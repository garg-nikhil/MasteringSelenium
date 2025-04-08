package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentTestNGListeners implements ITestListener {
    // This class is used to implement TestNG listeners for reporting
    // You can add methods to handle test events like onTestStart, onTestSuccess, etc.
    // For example:

    private static ExtentReports extent = ExtentManager.getExtentReports();
    private static ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();

     @Override
     public void onTestStart(ITestResult result) {
         ExtentTest test = extent.createTest(result.getMethod().getMethodName());
         testThread.set(test);
     }

    @Override
    public void onTestSuccess(ITestResult result) {
        testThread.get().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
         testThread.get().log(Status.FAIL, "Test failed" + result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        testThread.get().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context){
        extent.flush();
    }

}
