package by.natashkinsasha.model;

import by.natashkinsasha.api.conventer.BookingRequestConverter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDateTime;


@Data
@JsonDeserialize(using = BookingRequestConverter.Deserializer.class)
public class BookingRequest {
    @NotNull
    private LocalDateTime bookingDateTime;
    @NotNull
    private String userId;
    @NotNull
    private LocalDateTime startSubmissionTime;
    @NotNull
    private LocalDateTime finishSubmissionTime;

    public BookingRequest() {
    }

    @AssertTrue(message = "Start submission time should be before finish submission time")
    private boolean isValid() {
        return startSubmissionTime.isBefore(finishSubmissionTime)&&bookingDateTime.isBefore(startSubmissionTime);
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

