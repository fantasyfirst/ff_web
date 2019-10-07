package me.yocom.fantasyfirst.persistence.impl;

import java.util.List;
import javax.persistence.Query;
import me.yocom.fantasyfirst.domain.Draft;
import me.yocom.fantasyfirst.domain.Drafter;
import me.yocom.fantasyfirst.persistence.IDrafterDao;

public class DrafterDao extends AbstractDao<Drafter> implements IDrafterDao {

  @Override
  public List<Drafter> findAllByDraft(Draft draft) {
    final String hql = ""
        + " SELECT "
        + "   dr "
        + " FROM "
        + "   Drafter dr "
        + " WHERE "
        + "   dr.draft.id = :draftId ";

    final Query query = entityManager.createQuery(hql);
    query.setParameter("draftId", draft.getId());

    return query.getResultList();
  }
}
