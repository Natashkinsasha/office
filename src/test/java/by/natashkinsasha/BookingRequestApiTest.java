package by.natashkinsasha;


import by.natashkinsasha.config.JerseyConfig;
import by.natashkinsasha.model.BookingRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.ws.rs.core.Application;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookingRequestApiTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    public void testPostBookingRequestCreateWithArrayTime() throws JsonProcessingException {
        HttpEntity<String> httpEntity = new HttpEntity<String>("[]");
        ResponseEntity<String> entity = this.restTemplate
                .postForEntity("/bookingRequest/createWithArray?startWorkTime=5677&finishWorkTime=57476", httpEntity,String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody()).isEqualTo("[]");

    }




}
