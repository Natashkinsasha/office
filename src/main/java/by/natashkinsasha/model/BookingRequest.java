package by.natashkinsasha.model;

import java.time.LocalDateTime;
import java.util.Comparator;

import by.natashkinsasha.api.conventer.BookingRequestConverter;
import by.natashkinsasha.util.TimeUtil;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;


@Data
@JsonDeserialize(using = BookingRequestConverter.Deserializer.class)
public class BookingRequest {
    private LocalDateTime bookingDateTime;
    private String userId;
    private LocalDateTime startSubmissionTime;
    private LocalDateTime finishSubmissionTime;


    public BookingRequest() {
    }

    public LocalDateTime getBookingDateTime() {
        return bookingDateTime;
    }

    public void setBookingDateTime(LocalDateTime bookingDateTime) {
        this.bookingDateTime = bookingDateTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getStartSubmissionTime() {
        return startSubmissionTime;
    }

    public void setStartSubmissionTime(LocalDateTime startSubmissionTime) {
        this.startSubmissionTime = startSubmissionTime;
    }

    public LocalDateTime getFinishSubmissionTime() {
        return finishSubmissionTime;
    }

    public void setFinishSubmissionTime(LocalDateTime finishSubmissionTime) {
        this.finishSubmissionTime = finishSubmissionTime;
    }


    public boolean isOverlapping(BookingRequest bookingRequest) {
        return this.getStartSubmissionTime().isBefore(bookingRequest.getFinishSubmissionTime()) && bookingRequest.getStartSubmissionTime().isBefore(this.getFinishSubmissionTime());
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("BookingRequest{");
        sb.append("bookingDateTime=").append(bookingDateTime);
        sb.append(", userId='").append(userId).append('\'');
        sb.append(", startSubmissionTime=").append(startSubmissionTime);
        sb.append(", finishSubmissionTime=").append(finishSubmissionTime);
        sb.append('}');
        return sb.toString();
    }

}

