package me.yocom.fantasyfirst.persistence.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import me.yocom.fantasyfirst.domain.FFAbstractIdentifiedObject;
import me.yocom.fantasyfirst.persistence.IAbstractDao;

public class AbstractDao<T extends FFAbstractIdentifiedObject> implements IAbstractDao<T> {

  @PersistenceContext
  protected EntityManager entityManager;

  @Override
  public void save(T objectToSave) {
    entityManager.persist(objectToSave);
  }
}
