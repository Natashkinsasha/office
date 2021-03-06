package by.natashkinsasha.model;

import java.time.LocalTime;

import by.natashkinsasha.api.conventer.ReservationsConverter;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;



@Data
@JsonSerialize(using = ReservationsConverter.Serializer.class)
public class Reservations   {

  private LocalTime startDuration;
  private LocalTime finishDuration;
  private String userId;

  public Reservations() {
  }


  public LocalTime getStartDuration() {
    return startDuration;
  }

  public void setStartDuration(LocalTime startDuration) {
    this.startDuration = startDuration;
  }

  public LocalTime getFinishDuration() {
    return finishDuration;
  }

  public void setFinishDuration(LocalTime finishDuration) {
    this.finishDuration = finishDuration;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }
}

