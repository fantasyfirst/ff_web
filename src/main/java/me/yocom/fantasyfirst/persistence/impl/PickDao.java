package me.yocom.fantasyfirst.persistence.impl;

import java.util.List;
import javax.persistence.Query;
import me.yocom.fantasyfirst.domain.Draft;
import me.yocom.fantasyfirst.domain.Pick;
import me.yocom.fantasyfirst.persistence.IPickDao;

public class PickDao extends AbstractDao<Pick> implements IPickDao {

  @Override
  public List<Pick> findAllByDraft(Draft draft) {

    final String hql = ""
        + " SELECT "
        + "   p "
        + " FROM "
        + "   Pick p "
        + " WHERE "
        + "   p.drafter.draft.id = :draftId ";

    final Query query = entityManager.createQuery(hql);
    query.setParameter("draftId", draft.getId());

    return query.getResultList();
  }
}
