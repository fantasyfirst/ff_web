package me.yocom.fantasyfirst.persistence;

import java.util.List;
import me.yocom.fantasyfirst.domain.Draft;
import me.yocom.fantasyfirst.domain.FRCTeam;

public interface IFRCTeamDao extends IAbstractDao<FRCTeam> {

  List<FRCTeam> findAllByDraft(Draft draft);
}
