package apiTests;

import Api.Request.Pojo.CreatePageRequest;
import Api.Request.Pojo.Input;
import Api.Request.Pojo.PageSettings;
import Api.Request.Pojo.Variables;
import Api.Response.Pojo.CreatePageResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class CreatePageAPITest {
    public static void main(String[] args) {
        //Assume your API endpoint is something like "https://api.example.com/createPage"
        baseURI = "https://api.example.com";

        //Construct the nested objects
        PageSettings pageSettings = new PageSettings();
        pageSettings.setPageName("create");

        Input input = new Input();
        input.setPage("create");
        input.setSiteName("productionsite");
        input.setTitle("create");
        input.setParentPageURL("/");
        input.setCurrentPageURL("/create");
        input.setDevelopedBy("Nikhil Garg");
        input.setDevelopedDate("2025-04-10T12:03:18.451Z");
        input.setIsEdit(false);
        input.setSeoEnable(true);
        input.setAnalyticsEnable(true);
        input.setRobotTxt(false);
        input.setSiteMap(false);
        input.setChildren(null);
        input.setAnalytics("");
        input.setOthers("");
        input.setStructureData("");
        input.setPageSettings(pageSettings);
        input.setPage_LastModificationDate("2025-04-10T12:03:18.451Z");
        input.setPage_LastModifiedBy("Nikhil Garg");

        Variables variables = new Variables();
        variables.setInput(input);

        CreatePageRequest createPageRequest = new CreatePageRequest();
        createPageRequest.setOperationName("createPage");
        createPageRequest.setVariables(variables);
        createPageRequest.setQuery("mutation createPage($input: authoring_PageModelRequest) {\n  authoring_createPage(input: $input) {\n    id\n    message\n    path\n    __typename\n  }\n}");

        // Send the POST request with the serialized POJO
        Response response = given().log().all()
                .contentType(ContentType.JSON)
                .body(createPageRequest)
                .when()
                .post("/createPage")
                .then()
                .statusCode(200) // Or the expected status code
                .extract()
                .response();

        // Optionally, deserialize the response
        System.out.println("Response: " + response.asString());

        // You can also validate the response if needed
        CreatePageResponse createPageResponse = response.as(CreatePageResponse.class);

        createPageResponse.getData().getAuthoringCreatePage().getId();
        createPageResponse.getData().getAuthoringCreatePage().getMessage();

    }
}

