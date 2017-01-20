package by.natashkinsasha.api;

import by.natashkinsasha.model.BookingRequest;
import org.springframework.stereotype.Component;


import java.util.List;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/bookingRequest")
@Component
public class BookingRequestApi  {

    @POST
    @Path("/createWithArray/{time}")
    @Consumes({MediaType.APPLICATION_JSON+ ";charset=utf-8"})
    @Produces({MediaType.APPLICATION_JSON+ ";charset=utf-8"})
    public BookingRequest[] postBookingRequestCreateWithArrayTime(@PathParam("time") Long time, BookingRequest[] bookingRequests) throws by.natashkinsasha.api.exception.NotFoundException {
        return bookingRequests;
    }
}
