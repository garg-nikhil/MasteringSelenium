package Api.Request.Pojo;

public class Input {
    private String Page;
    private String SiteName;
    private String Title;
    private String ParentPageURL;
    private String CurrentPageURL;
    private String DevelopedBy;
    private String DevelopedDate;
    private boolean IsEdit;
    private boolean SeoEnable;
    private boolean AnalyticsEnable;
    private boolean RobotTxt;
    private boolean SiteMap;
    private Object Children;    // Assuming this could be null or a complex object
    private String Analytics;
    private String Others;
    private String StructureData;
    private PageSettings PageSettings;
    private String Page_LastModificationDate;
    private String Page_LastModifiedBy;

    public Input() {}

    // Getters and Setters
    public String getPage() {
        return Page;
    }
    public void setPage(String page) {
        Page = page;
    }
    public String getSiteName() {
        return SiteName;
    }
    public void setSiteName(String siteName) {
        SiteName = siteName;
    }
    public String getTitle() {
        return Title;
    }
    public void setTitle(String title) {
        Title = title;
    }
    public String getParentPageURL() {
        return ParentPageURL;
    }
    public void setParentPageURL(String parentPageURL) {
        ParentPageURL = parentPageURL;
    }
    public String getCurrentPageURL() {
        return CurrentPageURL;
    }
    public void setCurrentPageURL(String currentPageURL) {
        CurrentPageURL = currentPageURL;
    }
    public String getDevelopedBy() {
        return DevelopedBy;
    }
    public void setDevelopedBy(String developedBy) {
        DevelopedBy = developedBy;
    }
    public String getDevelopedDate() {
        return DevelopedDate;
    }
    public void setDevelopedDate(String developedDate) {
        DevelopedDate = developedDate;
    }
    public boolean isIsEdit() {
        return IsEdit;
    }
    public void setIsEdit(boolean isEdit) {
        IsEdit = isEdit;
    }
    public boolean isSeoEnable() {
        return SeoEnable;
    }
    public void setSeoEnable(boolean seoEnable) {
        SeoEnable = seoEnable;
    }
    public boolean isAnalyticsEnable() {
        return AnalyticsEnable;
    }
    public void setAnalyticsEnable(boolean analyticsEnable) {
        AnalyticsEnable = analyticsEnable;
    }
    public boolean isRobotTxt() {
        return RobotTxt;
    }
    public void setRobotTxt(boolean robotTxt) {
        RobotTxt = robotTxt;
    }
    public boolean isSiteMap() {
        return SiteMap;
    }
    public void setSiteMap(boolean siteMap) {
        SiteMap = siteMap;
    }
    public Object getChildren() {
        return Children;
    }
    public void setChildren(Object children) {
        Children = children;
    }
    public String getAnalytics() {
        return Analytics;
    }
    public void setAnalytics(String analytics) {
        Analytics = analytics;
    }
    public String getOthers() {
        return Others;
    }
    public void setOthers(String others) {
        Others = others;
    }
    public String getStructureData() {
        return StructureData;
    }
    public void setStructureData(String structureData) {
        StructureData = structureData;
    }
    public PageSettings getPageSettings() {
        return PageSettings;
    }
    public void setPageSettings(PageSettings pageSettings) {
        PageSettings = pageSettings;
    }
    public String getPage_LastModificationDate() {
        return Page_LastModificationDate;
    }
    public void setPage_LastModificationDate(String page_LastModificationDate) {
        Page_LastModificationDate = page_LastModificationDate;
    }
    public String getPage_LastModifiedBy() {
        return Page_LastModifiedBy;
    }
    public void setPage_LastModifiedBy(String page_LastModifiedBy) {
        Page_LastModifiedBy = page_LastModifiedBy;
    }

    @Override
    public String toString() {
        return "Input{" +
                "Page='" + Page + '\'' +
                ", SiteName='" + SiteName + '\'' +
                ", Title='" + Title + '\'' +
                ", ParentPageURL='" + ParentPageURL + '\'' +
                ", CurrentPageURL='" + CurrentPageURL + '\'' +
                ", DevelopedBy='" + DevelopedBy + '\'' +
                ", DevelopedDate='" + DevelopedDate + '\'' +
                ", IsEdit=" + IsEdit +
                ", SeoEnable=" + SeoEnable +
                ", AnalyticsEnable=" + AnalyticsEnable +
                ", RobotTxt=" + RobotTxt +
                ", SiteMap=" + SiteMap +
                ", Children=" + Children +
                ", Analytics='" + Analytics + '\'' +
                ", Others='" + Others + '\'' +
                ", StructureData='" + StructureData + '\'' +
                ", PageSettings=" + PageSettings +
                ", Page_LastModificationDate='" + Page_LastModificationDate + '\'' +
                ", Page_LastModifiedBy='" + Page_LastModifiedBy + '\'' +
                '}';
    }
}

