package by.natashkinsasha;


import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.filter.log.RequestLoggingFilter;
import com.jayway.restassured.filter.log.ResponseLoggingFilter;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.jayway.restassured.RestAssured.given;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = OfficeApplication.class)
@WebAppConfiguration
@IntegrationTest
public class BookingRequestApiTest {
    private static RequestSpecification spec;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @BeforeClass
    public static void initSpec() {
        spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .build();
    }

    @Test
    public void testPostBookingRequest() {
        given().spec(spec).body("[\n" +
                "{\n" +
                "\"bookingDateTime\":\"1300357026\",\n" +
                "\"userId\":\"EMP001\",\n" +
                "\"submissionTime\":\"1300698000\",\n" +
                "\"duration\":\"7200\"\n" +
                "},\n" +
                "{\n" +
                "\"bookingDateTime\":\"1300278896\",\n" +
                "\"userId\":\"EMP002\",\n" +
                "\"submissionTime\":\"1300698000\",\n" +
                "\"duration\":\"7200\"\n" +
                "},\n" +
                "{\n" +
                "\"bookingDateTime\":\"1300267703\",\n" +
                "\"userId\":\"EMP003\",\n" +
                "\"submissionTime\":\"1300802400\",\n" +
                "\"duration\":\"7200\"\n" +
                "},\n" +
                "{\n" +
                "\"bookingDateTime\":\"1300361025\",\n" +
                "\"userId\":\"EMP004\",\n" +
                "\"submissionTime\":\"1300809600\",\n" +
                "\"duration\":\"3600\"\n" +
                "},\n" +
                "{\n" +
                "\"bookingDateTime\":\"1300210152\",\n" +
                "\"userId\":\"EMP005\",\n" +
                "\"submissionTime\":\"1300723200\",\n" +
                "\"duration\":\"10800\"\n" +
                "}\n" +
                "]").when().
                post("/bookingRequest/createWithArray?startWorkTime=32400&finishWorkTime=61200").
                then().
                statusCode(HttpStatus.SC_OK);
    }


    @Test
    public void testPostBookingRequestWithEmptyArray() {
        given().spec(spec).body("[]").when().
                post("/bookingRequest/createWithArray?startWorkTime=32400&finishWorkTime=61200").
                then().
                statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    public void testPostBookingRequestWithEmptyBody() {
        given().spec(spec).when().
                post("/bookingRequest/createWithArray?startWorkTime=32400&finishWorkTime=61200").
                then().
                statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    public void testPostBookingRequestWithoutWorkTime() {
        given().spec(spec).body("[\n" +
                "{\n" +
                "\"bookingDateTime\":\"1300357026\",\n" +
                "\"userId\":\"EMP001\",\n" +
                "\"submissionTime\":\"1300698000\",\n" +
                "\"duration\":\"7200\"\n" +
                "},\n" +
                "]").when().
                post("/bookingRequest/createWithArray?finishWorkTime=61200").
                then().
                statusCode(HttpStatus.SC_BAD_REQUEST);
        given().spec(spec).body("[\n" +
                "{\n" +
                "\"bookingDateTime\":\"1300357026\",\n" +
                "\"userId\":\"EMP001\",\n" +
                "\"submissionTime\":\"1300698000\",\n" +
                "\"duration\":\"7200\"\n" +
                "},\n" +
                "]").when().
                post("/bookingRequest/createWithArray?finishWorkTime=61200").
                then().
                statusCode(HttpStatus.SC_BAD_REQUEST);
        given().spec(spec).body("[\n" +
                "{\n" +
                "\"bookingDateTime\":\"1300357026\",\n" +
                "\"userId\":\"EMP001\",\n" +
                "\"submissionTime\":\"1300698000\",\n" +
                "\"duration\":\"7200\"\n" +
                "},\n" +
                "]").when().
                post("/bookingRequest/createWithArray").
                then().
                statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    public void testPostBookingRequestWithoutField() {
        given().spec(spec).body("[\n" +
                "{\n" +
                "\"userId\":\"EMP001\",\n" +
                "\"submissionTime\":\"1300698000\",\n" +
                "\"duration\":\"7200\"\n" +
                "}\n" +
                "]").when().
                post("/bookingRequest/createWithArray?finishWorkTime=61200").
                then().
                statusCode(HttpStatus.SC_BAD_REQUEST);
        given().spec(spec).body("[\n" +
                "{\n" +
                "\"bookingDateTime\":\"1300357026\",\n" +
                "\"submissionTime\":\"1300698000\",\n" +
                "\"duration\":\"7200\"\n" +
                "}\n" +
                "]").when().
                post("/bookingRequest/createWithArray?finishWorkTime=61200").
                then().
                statusCode(HttpStatus.SC_BAD_REQUEST);
        given().spec(spec).body("[\n" +
                "{\n" +
                "\"bookingDateTime\":\"1300357026\",\n" +
                "\"userId\":\"EMP001\",\n" +
                "\"duration\":\"7200\"\n" +
                "}\n" +
                "]").when().
                post("/bookingRequest/createWithArray").
                then().
                statusCode(HttpStatus.SC_BAD_REQUEST);
        given().spec(spec).body("[\n" +
                "{\n" +
                "\"bookingDateTime\":\"1300357026\",\n" +
                "\"userId\":\"EMP001\",\n" +
                "\"submissionTime\":\"1300698000\",\n" +
                "}\n" +
                "]").when().
                post("/bookingRequest/createWithArray").
                then().
                statusCode(HttpStatus.SC_BAD_REQUEST);

    }


}
