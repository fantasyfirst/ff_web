package me.yocom.fantasyfirst.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="event_team")
public class EventTeam extends FFAbstractIdentifiedObject {

  @ManyToOne
  @JoinColumn(name = "frc_team_id")
  private FRCTeam frcTeam;

  @ManyToOne
  @JoinColumn(name = "event_id")
  private Event event;

  public FRCTeam getFrcTeam() {
    return frcTeam;
  }

  public void setFrcTeam(FRCTeam frcTeam) {
    this.frcTeam = frcTeam;
  }

  public Event getEvent() {
    return event;
  }

  public void setEvent(Event event) {
    this.event = event;
  }
}
