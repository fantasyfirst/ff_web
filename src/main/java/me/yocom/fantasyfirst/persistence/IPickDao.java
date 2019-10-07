package me.yocom.fantasyfirst.persistence;

import java.util.List;
import me.yocom.fantasyfirst.domain.Draft;
import me.yocom.fantasyfirst.domain.Pick;

public interface IPickDao extends IAbstractDao<Pick> {

  List<Pick> findAllByDraft(Draft ongoingDraft);
}
