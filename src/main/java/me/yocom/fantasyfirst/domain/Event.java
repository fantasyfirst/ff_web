package me.yocom.fantasyfirst.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity(name="event")
public class Event extends FFAbstractIdentifiedObject {

  @Column(name = "year")
  private Integer year;

  @Column(name = "year")
  private String code;

  @Column(name = "year")
  private String displayName;

  @Column(name = "year")
  private Integer week;

  @OneToMany(mappedBy = "event")
  private List<EventTeam> teams;

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

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

  public Integer getWeek() {
    return week;
  }

  public void setWeek(Integer week) {
    this.week = week;
  }

  public List<EventTeam> getTeams() {
    return teams;
  }

  public void setTeams(List<EventTeam> teams) {
    this.teams = teams;
  }
}
