package me.yocom.fantasyfirst.domain;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "pick")
public class Pick extends FFAbstractIdentifiedObject {

  @ManyToOne
  @JoinColumn(name="drafter_id")
  private Drafter drafter;

  @ManyToOne
  @JoinColumn(name="frc_team_id")
  private FRCTeam team;

  @Column(name="time_pick_entered")
  private LocalDateTime timePickEntered;

  @Column(name="time_zone")
  private ZoneId zoneId;

  public Drafter getDrafter() {
    return drafter;
  }

  public void setDrafter(Drafter drafter) {
    this.drafter = drafter;
  }

  public FRCTeam getTeam() {
    return team;
  }

  public void setTeam(FRCTeam team) {
    this.team = team;
  }

  public LocalDateTime getTimePickEntered() {
    return timePickEntered;
  }

  public void setTimePickEntered(LocalDateTime timePickEntered) {
    this.timePickEntered = timePickEntered;
  }

  public ZoneId getZoneId() {
    return zoneId;
  }

  public void setZoneId(ZoneId zoneId) {
    this.zoneId = zoneId;
  }
}
