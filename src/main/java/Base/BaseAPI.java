package Base;

import Pages.com.java.nikhil.flightReservation.CustomerRegistrationPages;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URI;

import static io.restassured.RestAssured.given;

public class BaseAPI {
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

    public RequestSpecBuilder requestSpecBuilder(){
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder
                .setBaseUri("")
                .setContentType(ContentType.JSON).build();
        return requestSpecBuilder;

    }

    public void responseSpecBuilder(){
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.
                expectContentType(ContentType.JSON).
                expectStatusCode(200).build();

        ResponseSpecification responseSpecification = new ResponseSpecBuilder().
                                                expectContentType(ContentType.JSON).
                expectStatusCode(200).build();
    }
}
