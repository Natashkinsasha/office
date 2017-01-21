package by.natashkinsasha.service;


import by.natashkinsasha.model.BookingRequest;
import by.natashkinsasha.model.DaySchedule;
import by.natashkinsasha.model.Reservations;
import by.natashkinsasha.model.comparator.ComparatorBookingRequestByBookingDate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ScheduleServiceImpl implements ScheduleService {


    @Override
    public DaySchedule[] create(LocalTime startWorktime, LocalTime finishWorkTime, BookingRequest[] bookingRequests) {
        List<BookingRequest> bookingRequestList = Arrays.stream(bookingRequests).parallel().filter(bookingRequest ->
                ((bookingRequest.getStartSubmissionTime().toLocalTime().isAfter(startWorktime)) && (bookingRequest.getFinishSubmissionTime().toLocalTime().isBefore(finishWorkTime))))
                .sorted(new ComparatorBookingRequestByBookingDate()).collect(Collectors.toList());
        for (int i = 1; i < bookingRequestList.size(); i++) {
            if (bookingRequestList.get(i - 1).getFinishSubmissionTime().isAfter(bookingRequestList.get(i).getStartSubmissionTime())) {
                bookingRequestList.remove(i);
                i--;
            }
        }
        Map<LocalDate, List<BookingRequest>> groupByLocalDateStartSubmissionTime = bookingRequestList.parallelStream().collect(Collectors.groupingBy((bookingRequest) -> bookingRequest.getStartSubmissionTime().toLocalDate()));
        List<DaySchedule> dayScheduleList = groupByLocalDateStartSubmissionTime.entrySet().parallelStream().map(entry -> {
            DaySchedule daySchedule = new DaySchedule();
            daySchedule.setDate(entry.getKey());
            List<Reservations> reservationsList = entry.getValue().parallelStream().map(bookingRequest -> {
                Reservations reservations = new Reservations();
                reservations.setUserId(bookingRequest.getUserId());
                reservations.setStartDuration(bookingRequest.getStartSubmissionTime().toLocalTime());
                reservations.setFinishDuration(bookingRequest.getFinishSubmissionTime().toLocalTime());
                return reservations;
            }).collect(Collectors.toList());
            daySchedule.setReservations(reservationsList);
            return daySchedule;
        }).collect(Collectors.toList());
        return dayScheduleList.toArray(new DaySchedule[dayScheduleList.size()]);
    }
}
