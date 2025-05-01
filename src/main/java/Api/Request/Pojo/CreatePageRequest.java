package Api.Request.Pojo;

public class CreatePageRequest {
    private String operationName;
    private Variables variables;

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public Variables getVariables() {
        return variables;
    }

    public void setVariables(Variables variables) {
        this.variables = variables;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    private String query;



    @Override
    public String toString() {
        return "CreatePageRequest{" +
                "operationName='" + operationName + '\'' +
                ", variables=" + variables +
                ", query='" + query + '\'' +
                '}';
    }
}

