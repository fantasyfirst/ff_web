package me.yocom.fantasyfirst.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="district")
public class District extends FFAbstractIdentifiedObject {

  @Column(name = "code")
  private String code;

  @Column(name = "display_name")
  private String displayName;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }
}
