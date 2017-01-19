package by.natashkinsasha.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;





public class BookingRequest   {
  
  private Long bookingDate = null;
  private String userId = null;
  private Long meetingDate = null;
  private Long duration = null;


  public BookingRequest bookingDate(Long bookingDate) {
    this.bookingDate = bookingDate;
    return this;
  }


  @JsonProperty("bookingDate")
  public Long getBookingDate() {
    return bookingDate;
  }
  public void setBookingDate(Long bookingDate) {
    this.bookingDate = bookingDate;
  }


  public BookingRequest userId(String userId) {
    this.userId = userId;
    return this;
  }


  @JsonProperty("userId")
  public String getUserId() {
    return userId;
  }
  public void setUserId(String userId) {
    this.userId = userId;
  }


  public BookingRequest meetingDate(Long meetingDate) {
    this.meetingDate = meetingDate;
    return this;
  }


  @JsonProperty("meetingDate")
  public Long getMeetingDate() {
    return meetingDate;
  }
  public void setMeetingDate(Long meetingDate) {
    this.meetingDate = meetingDate;
  }


  public BookingRequest duration(Long duration) {
    this.duration = duration;
    return this;
  }


  @JsonProperty("duration")
  public Long getDuration() {
    return duration;
  }
  public void setDuration(Long duration) {
    this.duration = duration;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BookingRequest bookingRequest = (BookingRequest) o;
    return Objects.equals(bookingDate, bookingRequest.bookingDate) &&
        Objects.equals(userId, bookingRequest.userId) &&
        Objects.equals(meetingDate, bookingRequest.meetingDate) &&
        Objects.equals(duration, bookingRequest.duration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bookingDate, userId, meetingDate, duration);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BookingRequest {\n");
    
    sb.append("    bookingDate: ").append(toIndentedString(bookingDate)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    meetingDate: ").append(toIndentedString(meetingDate)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
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

