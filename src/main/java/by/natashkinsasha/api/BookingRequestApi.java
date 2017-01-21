package by.natashkinsasha.api;

import by.natashkinsasha.model.BookingRequest;
import by.natashkinsasha.model.DaySchedule;
import by.natashkinsasha.service.ScheduleService;
import by.natashkinsasha.util.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/bookingRequest")
@Component
public class BookingRequestApi  {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ScheduleService scheduleService;
    @POST
    @Path("/createWithArray")
    @Consumes({MediaType.APPLICATION_JSON+ ";charset=utf-8"})
    @Produces({MediaType.APPLICATION_JSON+ ";charset=utf-8"})
    public DaySchedule[] postBookingRequestCreateWithArray(@QueryParam("startWorkTime") Long startWorkTime, @QueryParam("finishWorkTime") Long finishWorkTime, BookingRequest[] bookingRequests) throws by.natashkinsasha.api.exception.NotFoundException {
        logger.debug(startWorkTime.toString());
        logger.debug(finishWorkTime.toString());
        logger.debug(bookingRequests.toString());
        return scheduleService.create(TimeUtil.toLocalTime(startWorkTime), TimeUtil.toLocalTime(finishWorkTime), bookingRequests);
    }
}
