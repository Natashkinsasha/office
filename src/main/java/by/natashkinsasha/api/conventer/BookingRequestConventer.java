package by.natashkinsasha.api.conventer;

import by.natashkinsasha.model.BookingRequest;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.*;
import org.springframework.boot.jackson.JsonComponent;
import sun.jvm.hotspot.utilities.Interval;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@JsonComponent
public class BookingRequestConventer {

    public static class Serializer extends JsonSerializer<BookingRequest> {
        @Override
        public void serialize(BookingRequest bookingRequest, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
            //jsonGenerator.writeStartObject();
            //jsonGenerator.writeNumberField("bookingDate", bookingRequest.getBookingDate().);
        }

    }

    public static class Deserializer extends JsonDeserializer<BookingRequest> {
        @Override
        public BookingRequest deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            ObjectCodec oc = jsonParser.getCodec();
            JsonNode node = oc.readTree(jsonParser);
            BookingRequest bookingRequest = new BookingRequest();
            //bookingRequest.setBookingDate(Instant.ofEpochMilli(node.get("bookingDate").asLong()).atZone(ZoneId.systemDefault()).toLocalDate());
            //bookingRequest.setUserId(node.get("userId").asText());
            //bookingRequest.setDuration();
            //new Interval(4646,34563);
            return bookingRequest;
        }

    }
}
