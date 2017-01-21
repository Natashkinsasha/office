package by.natashkinsasha.api.conventer;


import by.natashkinsasha.util.TimeUtil;
import by.natashkinsasha.model.Reservations;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class ReservationsConverter {

    public static  class Serializer extends JsonSerializer<Reservations> {


        @Override
        public void serialize(Reservations reservations, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("userId", reservations.getUserId());
            jsonGenerator.writeNumberField("startDuration", TimeUtil.toSecond(reservations.getStartDuration()));
            jsonGenerator.writeNumberField("finishDuration", TimeUtil.toSecond(reservations.getFinishDuration()));
            jsonGenerator.writeEndObject();
        }
    }
}
