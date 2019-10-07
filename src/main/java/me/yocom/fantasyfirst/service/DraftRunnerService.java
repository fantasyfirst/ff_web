package me.yocom.fantasyfirst.service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import me.yocom.fantasyfirst.domain.Draft;
import me.yocom.fantasyfirst.domain.Drafter;
import me.yocom.fantasyfirst.domain.FRCTeam;
import me.yocom.fantasyfirst.domain.Pick;
import me.yocom.fantasyfirst.persistence.IDraftDao;
import me.yocom.fantasyfirst.persistence.IDrafterDao;
import me.yocom.fantasyfirst.persistence.IFRCTeamDao;
import me.yocom.fantasyfirst.persistence.IPickDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DraftRunnerService {

  private static final Random SECURE_RANDOM = new SecureRandom();

  @Autowired
  private IDraftDao draftDao;

  @Autowired
  private IDrafterDao drafterDao;

  @Autowired
  private IPickDao pickDao;

  @Autowired
  private IFRCTeamDao frcTeamDao;

  @Scheduled(fixedRate =  1 * 1_000)
  @Transactional(readOnly = false)
  public void tick(){
    List<Draft> ongoingDrafts = draftDao.findAllOngoing();
    ongoingDrafts.forEach(this::tickDraft);
  }

  private void tickDraft(Draft ongoingDraft){
    List<Drafter> drafters = drafterDao.findAllByDraft(ongoingDraft);
    // 1 -> 8
    List<Drafter> firstAndThirdRound = new ArrayList<>(drafters);
    // 8 -> 1
    drafters.sort(Comparator.comparingInt(Drafter::getOrder).reversed());
    List<Drafter> secondRound = new ArrayList<>(drafters);

    List<Pick> picks = pickDao.findAllByDraft(ongoingDraft);
    // get last pick
    if(picks.isEmpty()){
      setDraftOrder(drafters);
      pickRandomIfNeeded(firstAndThirdRound.get(0), ongoingDraft, ongoingDraft.getStartTime(), ongoingDraft.getZoneId(), ongoingDraft.getFirstRoundInterval());
      return;
    }

    Pick lastPick = picks.get(picks.size() - 1);
    Integer whichRound = picks.size() / drafters.size();
    Integer whichPickInRound = picks.size() % drafters.size();

    switch (whichRound){
      case 1:
        pickRandomIfNeeded(firstAndThirdRound.get(whichPickInRound), ongoingDraft, lastPick.getTimePickEntered(), lastPick.getZoneId(), ongoingDraft.getFirstRoundInterval());
        return;
      case 2:
        pickRandomIfNeeded(secondRound.get(whichPickInRound), ongoingDraft, lastPick.getTimePickEntered(), lastPick.getZoneId(), ongoingDraft.getSecondRoundInterval());
        return;
      case 3:
        pickRandomIfNeeded(firstAndThirdRound.get(whichPickInRound), ongoingDraft, lastPick.getTimePickEntered(), lastPick.getZoneId(), ongoingDraft.getThirdRoundInterval());
        return;
      case 4:
        endDraft(ongoingDraft);
    }
  }

  private void endDraft(Draft draft){
    draft.setComplete(true);
    draftDao.save(draft);
  }

  private void pickRandomIfNeeded(Drafter drafter, Draft draft,
      LocalDateTime lastPickEntered, ZoneId zone, Integer roundInterval){
    ZonedDateTime now = ZonedDateTime.now(zone);
    ZonedDateTime lastPickedEnteredTime = lastPickEntered.atZone(zone);

    if(lastPickedEnteredTime.plus(roundInterval, ChronoUnit.SECONDS).isBefore(now)){
      // TIMES UP MOTHERFUCKER!
      pickRandom(drafter, draft, now);
    }
  }

  private void pickRandom(Drafter drafter, Draft draft,
      ZonedDateTime now) {
    List<FRCTeam> frcTeams = frcTeamDao.findAllByDraft(draft);

    FRCTeam team = frcTeams.get(SECURE_RANDOM.nextInt(frcTeams.size()));
    Pick pick = new Pick();
    pick.setDrafter(drafter);
    pick.setTeam(team);
    pick.setTimePickEntered(now.toLocalDateTime());
    pickDao.save(pick);
  }


  public void setDraftOrder(List<Drafter> drafters){
    final List<Integer> range = IntStream.range(1, drafters.size()).boxed()
        .collect(Collectors.toCollection(ArrayList::new));
    Collections.shuffle(range);
    final Queue<Integer> randomQueue = new LinkedList<>(range);

    drafters.forEach(drafter -> {
      drafter.setOrder(randomQueue.poll());
      drafterDao.save(drafter);
    });
  }
}
