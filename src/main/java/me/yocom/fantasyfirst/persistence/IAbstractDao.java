package me.yocom.fantasyfirst.persistence;

import me.yocom.fantasyfirst.domain.FFAbstractIdentifiedObject;

public interface IAbstractDao<T extends FFAbstractIdentifiedObject> {

  void save(T objectToSave);

}
