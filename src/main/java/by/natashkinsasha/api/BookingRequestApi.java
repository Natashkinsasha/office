package by.natashkinsasha.api;

import by.natashkinsasha.model.BookingRequest;
import by.natashkinsasha.model.DaySchedule;
import by.natashkinsasha.service.ScheduleService;
import by.natashkinsasha.util.TimeUtil;
import io.swagger.annotations.ApiParam;
import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/bookingRequest")
@Component
public class BookingRequestApi {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ScheduleService scheduleService;

    @POST
    @Path("/createWithArray")
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    public List<DaySchedule> postBookingRequestCreateWithArray(@ApiParam(value = "Start time of the company working day in second.") @QueryParam("startWorkTime") @NotNull Long startWorkTime, @ApiParam(value = "End time of the company working day in second.") @QueryParam("finishWorkTime") @NotNull Long finishWorkTime, @ApiParam(value = "Booking requests") @NotEmpty @Valid List<BookingRequest> bookingRequests) {
        logger.debug("StartWorktine-{};FinishWorkTime-{};BokkingRequests", startWorkTime.toString(), finishWorkTime.toString(), bookingRequests.toString());
        return scheduleService.create(TimeUtil.toLocalTime(startWorkTime), TimeUtil.toLocalTime(finishWorkTime), bookingRequests);
    }
}
