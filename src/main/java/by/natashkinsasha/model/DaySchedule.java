package by.natashkinsasha.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;





public class DaySchedule   {
  @JsonProperty("date")
  private Long date;
  @JsonProperty("reservations")
  private List<Reservations> reservations = new ArrayList<Reservations>();

  public DaySchedule() {
  }

  public Long getDate() {
    return date;
  }

  public void setDate(Long date) {
    this.date = date;
  }

  public List<Reservations> getReservations() {
    return reservations;
  }

  public void setReservations(List<Reservations> reservations) {
    this.reservations = reservations;
  }
}

