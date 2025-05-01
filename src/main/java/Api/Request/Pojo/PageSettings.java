package Api.Request.Pojo;

public class PageSettings {
    private String PageName;

    public PageSettings() {}

    // Getters and Setters
    public String getPageName() {
        return PageName;
    }

    public void setPageName(String pageName) {
        PageName = pageName;
    }

    @Override
    public String toString() {
        return "PageSettings{" +
                "PageName='" + PageName + '\'' +
                '}';
    }
}

