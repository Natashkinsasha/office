package by.natashkinsasha.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;






public class Reservations   {
  @JsonProperty("date")
  private Long date = null;
  @JsonProperty("startDuration")
  private Long startDuration = null;
  @JsonProperty("finishDuration")
  private Long finishDuration = null;

  public Reservations() {
  }

  public Long getDate() {
    return date;
  }

  public void setDate(Long date) {
    this.date = date;
  }

  public Long getStartDuration() {
    return startDuration;
  }

  public void setStartDuration(Long startDuration) {
    this.startDuration = startDuration;
  }

  public Long getFinishDuration() {
    return finishDuration;
  }

  public void setFinishDuration(Long finishDuration) {
    this.finishDuration = finishDuration;
  }
}

