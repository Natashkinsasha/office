package by.natashkinsasha.service;

import by.natashkinsasha.model.BookingRequest;
import by.natashkinsasha.model.DaySchedule;
import org.springframework.stereotype.Service;

import java.time.LocalTime;


public interface ScheduleService {
    DaySchedule[] create(LocalTime startWorktime, LocalTime finishWorkTime, BookingRequest[] bookingRequests);
}
