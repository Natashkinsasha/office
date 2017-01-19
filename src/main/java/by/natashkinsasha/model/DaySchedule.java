package by.natashkinsasha.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;





public class DaySchedule   {
  
  private Long date;
  private List<Reservations> reservations = new ArrayList<Reservations>();

  public DaySchedule date(Long date) {
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


  public DaySchedule reservations(List<Reservations> reservations) {
    this.reservations = reservations;
    return this;
  }


  @JsonProperty("reservations")
  public List<Reservations> getReservations() {
    return reservations;
  }
  public void setReservations(List<Reservations> reservations) {
    this.reservations = reservations;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DaySchedule daySchedule = (DaySchedule) o;
    return Objects.equals(date, daySchedule.date) &&
        Objects.equals(reservations, daySchedule.reservations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, reservations);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DaySchedule {\n");
    
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    reservations: ").append(toIndentedString(reservations)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

