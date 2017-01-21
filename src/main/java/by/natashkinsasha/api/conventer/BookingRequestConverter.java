package by.natashkinsasha.api.conventer;

import by.natashkinsasha.util.TimeUtil;
import by.natashkinsasha.model.BookingRequest;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.time.temporal.ChronoUnit;

@JsonComponent
public class BookingRequestConverter {


    public static class Deserializer extends JsonDeserializer<BookingRequest> {
        private final Logger logger = LoggerFactory.getLogger(this.getClass());
        @Override
        public BookingRequest deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            ObjectCodec oc = jsonParser.getCodec();
            JsonNode node = oc.readTree(jsonParser);
            BookingRequest bookingRequest = new BookingRequest();
            bookingRequest.setBookingDateTime(TimeUtil.toLocalDateTime(node.get("bookingDateTime").asLong()));
            bookingRequest.setUserId(node.get("userId").asText());
            bookingRequest.setStartSubmissionTime(TimeUtil.toLocalDateTime(node.get("submissionTime").asLong()));
            bookingRequest.setFinishSubmissionTime(bookingRequest.getStartSubmissionTime().plus(node.get("duration").asLong(), ChronoUnit.SECONDS));
            logger.debug(bookingRequest.toString());
            return bookingRequest;
        }



    }
}
