package me.yocom.fantasyfirst.persistence;

import java.util.List;
import me.yocom.fantasyfirst.domain.Draft;

public interface IDraftDao extends IAbstractDao<Draft> {

  List<Draft> findAllOngoing();
}
