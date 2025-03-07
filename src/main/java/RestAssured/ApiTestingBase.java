package RestAssured;

import Pages.com.java.nikhil.flightReservation.CustomerRegistrationPages;
import io.restassured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.net.URI;
import static io.restassured.RestAssured.given;


public class ApiTestingBase {
    private static final Logger log = LogManager.getLogger(CustomerRegistrationPages.class);

    public void getGoogle(){
        Response response = RestAssured.get("https://www.google.com");
        log.info(""+response.asPrettyString());
    }

    public Response makeGetCall(URI uri){
        return RestAssured.get(uri);
    }

    public Response makePostCall(URI uri, String request, String statusCode){
        Response response =  given()
                            .contentType(ContentType.JSON)
                            .body(request)
                            .when()
                            .post()
                            .then()
                            .statusCode(Integer.parseInt(statusCode))
                            .extract().response();
        return response;
    }

    public Response makePutCall(URI uri, String request, String statusCode){
        Response response =  given()
                            .contentType(ContentType.JSON)
                            .body(request)
                            .when()
                            .put()
                            .then()
                            .statusCode(Integer.parseInt(statusCode))
                            .extract().response();
        return response;
    }

    public Response makeDeleteCall(URI uri, String request, String statusCode){
        Response response =  given()
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .delete()
                .then()
                .statusCode(Integer.parseInt(statusCode))
                .extract().response();
        return response;
    }

    public void testBasicAuth(){
        RestAssured.baseURI="https://httpbin.org/basic-auth/user/pass";

                             given()
                            .auth().basic("user","pass")
                            .when()
                            .get()
                            .then()
                            .statusCode(200);

        }
}
