package me.yocom.fantasyfirst.persistence.impl;

import java.util.List;
import javax.persistence.Query;
import me.yocom.fantasyfirst.domain.Draft;
import me.yocom.fantasyfirst.domain.FRCTeam;
import me.yocom.fantasyfirst.persistence.IFRCTeamDao;

public class FRCTeamDao extends AbstractDao<FRCTeam> implements IFRCTeamDao {

  @Override
  public List<FRCTeam> findAllByDraft(Draft draft) {
    final String hql = ""
        + " SELECT "
        + "   t "
        + " FROM "
        + "   Draft d "
        + " JOIN "
        + "   d.event e "
        + " JOIN "
        + "   e.teams et "
        + " JOIN "
        + "   et.frcTeam t "
        + " WHERE "
        + "   d.id = :draftId ";

    final Query query = entityManager.createQuery(hql);
    query.setParameter("draftId", draft.getId());

    return query.getResultList();
  }
}
