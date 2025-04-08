package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    // This class is used to manage the ExtentReports instance
    // You can add methods to initialize, flush, and close the report
    // For example:

    private static ExtentReports extent;

    public synchronized static ExtentReports getExtentReports(){
    if(extent == null){

        String reportPath = System.getProperty("user.dir") + "/src/test/reports/TestResults.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
        reporter.config().setDocumentTitle("Automation Test Results");
        extent = new ExtentReports();
        extent.attachReporter(reporter);

        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java version", System.getProperty("java.version"));
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Host Name", System.getProperty("os.hostname"));
        extent.setSystemInfo("Browser", System.getProperty("browser.name"));
        extent.setSystemInfo("Browser Version", System.getProperty("browser.version"));
        extent.setSystemInfo("Environment", System.getProperty("env"));
        extent.setSystemInfo("Test Suite", System.getProperty("testSuite"));

    }
    return extent;
}}
