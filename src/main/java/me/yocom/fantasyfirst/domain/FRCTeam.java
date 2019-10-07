package me.yocom.fantasyfirst.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "frc_team")
public class FRCTeam extends FFAbstractIdentifiedObject {

  @Column(name = "number")
  private Integer number;

  @Column(name = "name")
  private String name;

  @ManyToOne
  @JoinColumn(name = "district_id")
  private District district;

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public District getDistrict() {
    return district;
  }

  public void setDistrict(District district) {
    this.district = district;
  }
}
