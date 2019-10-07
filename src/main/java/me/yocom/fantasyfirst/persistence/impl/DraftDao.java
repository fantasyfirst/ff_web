package me.yocom.fantasyfirst.persistence.impl;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Query;
import me.yocom.fantasyfirst.domain.Draft;
import me.yocom.fantasyfirst.persistence.IDraftDao;

public class DraftDao extends AbstractDao<Draft> implements IDraftDao {

  @Override
  public List<Draft> findAllOngoing() {
    String hql = ""
        + " SELECT "
        + "   d "
        + " FROM "
        + "   Draft d "
        + " WHERE "
        + "   d.startTime < :now "
        + "   AND "
        + "     d.complete = false ";

    Query query = entityManager.createQuery(hql);
    query.setParameter("now", LocalDateTime.now());

    return query.getResultList();
  }
}
