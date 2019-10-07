package me.yocom.fantasyfirst.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="drafter")
public class Drafter extends FFAbstractIdentifiedObject {

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "draft_id")
  private Draft draft;

  @Column(name = "order")
  private Integer order;

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Draft getDraft() {
    return draft;
  }

  public void setDraft(Draft draft) {
    this.draft = draft;
  }

  public Integer getOrder() {
    return order;
  }

  public void setOrder(Integer order) {
    this.order = order;
  }
}
