package by.natashkinsasha.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;






public class Reservations   {
  
  private Long date = null;
  private Long startDuration = null;
  private Long finishDuration = null;


  public Reservations date(Long date) {
    this.date = date;
    return this;
  }

  @JsonProperty("date")
  public Long getDate() {
    return date;
  }
  public void setDate(Long date) {
    this.date = date;
  }

  /**
   **/
  public Reservations startDuration(Long startDuration) {
    this.startDuration = startDuration;
    return this;
  }


  @JsonProperty("startDuration")
  public Long getStartDuration() {
    return startDuration;
  }
  public void setStartDuration(Long startDuration) {
    this.startDuration = startDuration;
  }

  /**
   **/
  public Reservations finishDuration(Long finishDuration) {
    this.finishDuration = finishDuration;
    return this;
  }


  @JsonProperty("finishDuration")
  public Long getFinishDuration() {
    return finishDuration;
  }
  public void setFinishDuration(Long finishDuration) {
    this.finishDuration = finishDuration;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Reservations reservations = (Reservations) o;
    return Objects.equals(date, reservations.date) &&
        Objects.equals(startDuration, reservations.startDuration) &&
        Objects.equals(finishDuration, reservations.finishDuration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, startDuration, finishDuration);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Reservations {\n");
    
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    startDuration: ").append(toIndentedString(startDuration)).append("\n");
    sb.append("    finishDuration: ").append(toIndentedString(finishDuration)).append("\n");
    sb.append("}");
    return sb.toString();
  }


  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

