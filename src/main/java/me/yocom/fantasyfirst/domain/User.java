package me.yocom.fantasyfirst.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "user")
public class User extends FFAbstractIdentifiedObject {

  @Column(name = "username")
  private String username;

}
