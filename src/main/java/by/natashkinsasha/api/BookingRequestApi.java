package by.natashkinsasha.api;

import by.natashkinsasha.model.BookingRequest;
import by.natashkinsasha.model.DaySchedule;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;


import javax.ws.rs.core.Response;
import javax.ws.rs.*;

@Path("/bookingRequest")
@Component
public class BookingRequestApi  {


    @POST
    @Path("/createWithArray/{time}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public List<DaySchedule> postBookingRequestCreateWithArrayTime(@PathParam("time") Long time, List<BookingRequest> body) throws by.natashkinsasha.api.Exception.NotFoundException {
        List<DaySchedule> dayScheduleList = new ArrayList<>();
        dayScheduleList.add(new DaySchedule());
        return dayScheduleList;
    }
}
