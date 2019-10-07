package me.yocom.fantasyfirst.persistence;

import java.util.List;
import me.yocom.fantasyfirst.domain.Draft;
import me.yocom.fantasyfirst.domain.Drafter;

public interface IDrafterDao extends IAbstractDao<Drafter> {

  List<Drafter> findAllByDraft(Draft ongoingDraft);
}
