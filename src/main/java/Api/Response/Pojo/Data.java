package Api.Response.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {
    @JsonProperty("authoring_createPage")
    private AuthoringCreatePage authoringCreatePage;

    // Default constructor
    public Data() {}

    // Getters and setters
    public AuthoringCreatePage getAuthoringCreatePage() {
        return authoringCreatePage;
    }
    public void setAuthoringCreatePage(AuthoringCreatePage authoringCreatePage) {
        this.authoringCreatePage = authoringCreatePage;
    }

    @Override
    public String toString() {
        return "Data{" +
                "authoringCreatePage=" + authoringCreatePage +
                '}';
    }
}

