package Api.Response.Pojo;

public class CreatePageResponse {
    private Data data;

    // Default constructor
    public CreatePageResponse() {}

    // Getters and setters
    public Data getData() {
        return data;
    }
    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CreatePageResponse{" +
                "data=" + data +
                '}';
    }
}

