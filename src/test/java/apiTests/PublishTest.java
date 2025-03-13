package apiTests;

import Api.Request.Input;
import Api.Request.Publish;
import Api.Request.Variables;
import Base.BaseAPI;
import Pages.com.java.nikhil.flightReservation.CustomerRegistrationPages;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.devtools.v131.network.model.Request;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PublishTest extends BaseAPI {
    private static final Logger log = LogManager.getLogger(CustomerRegistrationPages.class);

    @Test
    public void testPublish(){

        Publish abc = new Publish();
        abc.setOperationName("authoring_publishContent");

        Variables var = new Variables();
        var.setContentType("Article");

        Input input = new Input();
        input.setPage("automated-1741603830682");

        var.setInput(input);

        abc.setVariables(var);

        abc.setQuery("mutation authoring_publishContent($contentType: authoring_ContentTypes!, $input: authoring_PublishInfo) {\n" +
                "  authoring_publishContent(contentType: $contentType, input: $input) {\n" +
                "    parent_page_url\n" +
                "    message\n" +
                "    current_page_url\n" +
                "    __typename\n" +
                "  }\n" +
                "}");

        Request request = (Request) given()
                .headers("Content-Type", "application/json")
                .header("sitename","qualitycontroldedicated")
                .headers("cookie","platform-x-session=s%3A76PzuIKMaD3xuup1nvVGkR2jzQvTBe6x.YvoU%2Fwf3W95%2FkxKipDiQLNPUV16NiavTOPCi%2FS1thQU")
                .when().log().all()
                .body(abc)
                .post("https://dev.api.hcl-x.com/platform-x/v1/authoring/gateway");

        Publish response = given()
                .headers("Content-Type", "application/json")
                .header("sitename","qualitycontroldedicated")
                .headers("cookie","platform-x-session=s%3A76PzuIKMaD3xuup1nvVGkR2jzQvTBe6x.YvoU%2Fwf3W95%2FkxKipDiQLNPUV16NiavTOPCi%2FS1thQU")
                            .when().log().all()
                            .post("https://dev.api.hcl-x.com/platform-x/v1/authoring/gateway").as(Publish.class);

        String pageName = response.getVariables().getInput().getPage();
        log.info("Page Name is: " + pageName);

        RequestSpecification requestSpecification = new RequestSpecBuilder().
                                                    setBaseUri("https://www.google.com").
                                                    setContentType(ContentType.JSON).build();

        ResponseSpecification responseSpecification = new ResponseSpecBuilder().
                                                    expectStatusCode(200).
                                                    expectContentType(ContentType.JSON).build();

        ValidatableResponse response1 = given().spec(requestSpecification)
                            .when()
                            .post()
                                .then().
                                spec(responseSpecification);

    }
}
