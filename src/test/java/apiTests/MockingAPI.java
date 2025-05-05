package apiTests;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.restassured.response.Response;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;

public class MockingAPI {

    public static void main(String[] args) {
        mockAPI();
    }


    private static void mockAPI(){
        WireMockServer wireMockServer= new WireMockServer(8080);
        wireMockServer.start();
        configureFor("localhost", 8080);
        stubFor(get(urlEqualTo("/api/user/123"))
                            .willReturn(aResponse()
                            .withStatus(200)
                            .withHeader("Content-Type", "application/json")
                            .withBody("{ \"id\": 1234, \"name\": \"Nikhil\" }")));
        restAPICall();
        wireMockServer.stop();
    }

    private static void restAPICall(){
        Response response = given().log().all().baseUri("http://localhost:8080")
        .when().get("/api/user/123");

        System.out.print(response.getBody().prettyPrint());

    }
    }

