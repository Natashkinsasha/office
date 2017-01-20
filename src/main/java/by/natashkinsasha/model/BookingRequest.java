package by.natashkinsasha.model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;





public class BookingRequest   {
  private LocalDateTime bookingDateTime;
  private String userId;
  private Duration duration;


  public BookingRequest() {
  }


}

