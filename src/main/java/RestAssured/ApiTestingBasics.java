package RestAssured;

import Pages.com.java.nikhil.flightReservation.CustomerRegistrationPages;
import io.restassured.*;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;


public class ApiTestingBasics {
    private static final Logger log = LogManager.getLogger(CustomerRegistrationPages.class);

    @Test
    public void getGoogle(){
        Response response = RestAssured.get("https://www.google.com");
        log.info(""+response.asPrettyString());

    }
}
