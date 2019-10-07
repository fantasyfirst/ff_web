package me.yocom.fantasyfirst.domain;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name="draft")
public class Draft extends FFAbstractIdentifiedObject {

  @Column(name = "name")
  private String name;

  @JoinColumn(name = "event_id")
  private Event event;

  @OneToMany(mappedBy = "draft")
  private List<Drafter> drafters;

  @Column(name="start_time")
  private LocalDateTime startTime;

  @Column(name="time_zone")
  private ZoneId zoneId;

  @Column(name="first_round_interval")
  private Integer firstRoundInterval;

  @Column(name="second_round_interval")
  private Integer secondRoundInterval;

  @Column(name="third_round_interval")
  private Integer thirdRoundInterval;

  @Column(name="is_complete")
  private Boolean complete;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Event getEvent() {
    return event;
  }

  public void setEvent(Event event) {
    this.event = event;
  }

  public List<Drafter> getDrafters() {
    return drafters;
  }

  public void setDrafters(List<Drafter> drafters) {
    this.drafters = drafters;
  }

  public LocalDateTime getStartTime() {
    return startTime;
  }

  public void setStartTime(LocalDateTime startTime) {
    this.startTime = startTime;
  }

  public Integer getFirstRoundInterval() {
    return firstRoundInterval;
  }

  public void setFirstRoundInterval(Integer firstRoundInterval) {
    this.firstRoundInterval = firstRoundInterval;
  }

  public Integer getSecondRoundInterval() {
    return secondRoundInterval;
  }

  public void setSecondRoundInterval(Integer secondRoundInterval) {
    this.secondRoundInterval = secondRoundInterval;
  }

  public Integer getThirdRoundInterval() {
    return thirdRoundInterval;
  }

  public void setThirdRoundInterval(Integer thirdRoundInterval) {
    this.thirdRoundInterval = thirdRoundInterval;
  }

  public Boolean getComplete() {
    return complete;
  }

  public void setComplete(Boolean complete) {
    this.complete = complete;
  }

  public ZoneId getZoneId() {
    return zoneId;
  }

  public void setZoneId(ZoneId zoneId) {
    this.zoneId = zoneId;
  }
}
