package Base;

import Pages.com.java.nikhil.flightReservation.CustomerRegistrationPages;
import config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v131.network.Network;
import org.openqa.selenium.devtools.v131.network.model.Request;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class BaseClass {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private static final Logger log = LogManager.getLogger(CustomerRegistrationPages.class);
    private static PropertiesConfiguration config;


    private void loadConfig(){
        try{
            String path = System.getProperty("user.dir") + "/src/main/resources/config/Configuration.properties";
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file);
            config = new PropertiesConfiguration();
            config.load(fis);
            fis.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    // Use following method to open chrome in mobile view
    public void devtools(){
        WebDriverManager.chromedriver().setup();

        // ✅ Define Mobile Emulation Settings
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPhone SE");  // Uses built-in Pixel 5 emulation

        // ✅ Apply to ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("mobileEmulation", mobileEmulation);

        // ✅ Launch Chrome in Mobile Mode
        ChromeDriver driver = new ChromeDriver(options);  // 🛠️ Apply ChromeOptions here
        driver.get("https://dev.console.hcl-x.com/");
    }

    @BeforeMethod
    public void setupBrowser(){
        loadConfig();
        log.info("**********************************************************************");
        log.info("********************* Test Execution is started **********************");
        log.info("**********************************************************************");

        if(Boolean.getBoolean("selenium.grid.enabled")){
            this.driver = getRemoteDriver();
        }else{
            this.driver = getLocalDriver();
        }

        driver.manage().window().maximize();
    }

    private WebDriver getRemoteDriver(){
        Capabilities capabilities;
        if(System.getProperty("browser").equalsIgnoreCase("chrome")){
            capabilities = new ChromeOptions();
            log.info("Launching remote chrome browser");
        }
        else{
            capabilities = new FirefoxOptions();
            log.info("Launching remote firefox browser");
        }
        try {
            return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private WebDriver getLocalDriver(){
        if (ConfigReader.getProperty("browser").equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (ConfigReader.getProperty("browser").equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (ConfigReader.getProperty("browser").equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Browser not supported: " + ConfigReader.getProperty("browser"));
        }

        log.info("Launching local "+ConfigReader.getProperty("browser"));
        return driver;
    }

    @AfterMethod
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }

    private void chromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

    }

    private void getScreenshot() throws IOException {
        File input = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File output = new File("");
        FileUtils.copyFile(input,output);
    }

    private void sampleActionsUsages(){
        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.xpath(""));
        WebElement target = driver.findElement(By.xpath(""));
        actions.dragAndDrop(source,target).perform();

        actions.dragAndDropBy(source, 150, 230).perform();
        actions.moveToLocation(100,200).perform();
        actions.moveToElement(source).click().build().perform();
    }

    //Use the following method to set geolocation override to perform automated localization testing
    private void setGeolocationOverride(){
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        DevTools tools = driver.getDevTools();
        tools.createSession();
        Map<String,Object> coordinates = new HashMap<String,Object>();
        coordinates.put("latitude",46);
        coordinates.put("longitude",2);
        coordinates.put("accuracy",1);

        driver.executeCdpCommand("Emulation.setGeolocationOverride",coordinates);
        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//*[@title='Search']")).sendKeys("netflix"+ Keys.RETURN);
    }

    //use this method if you want to parameterize browser from testng suite
    //using this you can control execution of browser in the grid as well
    //Few test cases you can execute using chrome and few using firefox etc as needed
    //browser values can be modified in testng.xml suite file

/*    @BeforeMethod
    @Parameters({"browser"})
    public void setupBrowser(String browser){
        loadConfig();
        log.info("**********************************************************************");
        log.info("********************* Test Execution is started **********************");
        log.info("**********************************************************************");

        if(Boolean.getBoolean("selenium.grid.enabled")){
            this.driver = getRemoteDriver(browser);
        }else{
            this.driver = getLocalDriver();
        }

        driver.manage().window().maximize();
    }*/

/*    private WebDriver getRemoteDriver(String browser){
        Capabilities capabilities;
        //if(System.getProperty("browser").equalsIgnoreCase("chrome")){
        if(browser.equalsIgnoreCase("chrome")){
             capabilities = new ChromeOptions();
             log.info("Launching remote chrome browser");
        }
        else{
             capabilities = new FirefoxOptions();
            log.info("Launching remote firefox browser");
        }
        try {
            return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }*/

    private void interpretNetworkCalls(){
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));

        devTools.addListener(Network.requestWillBeSent(), Request ->
        {
            Request request = Request.getRequest();
            log.info("Request URL: "+request.getUrl());
            log.info("Request headers: "+request.getHeaders().toString());

        });

        devTools.addListener(Network.responseReceived(), Response ->
        {
            org.openqa.selenium.devtools.v131.network.model.Response response = Response.getResponse();
            log.info("Response status: "+response.getStatus());
            log.info("Response status text: "+response.getStatusText());
        });

        driver.get("https://dedicatedqavalidation.hcl-x.com/en/user/profile?tab=0");
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("nikhil.garg@hcl.com");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("India@2023");
        driver.findElement(By.xpath("//*[@id='kc-login']")).click();

        LogEntries entry= driver.manage().logs().get(LogType.BROWSER); //Get LogEntries object
        List<LogEntry> logs = entry.getAll();  //LogEntryobject- getAll method return all logs in list

        for(LogEntry e : logs)//iterating through list and printing each log message
        {
            System.out.println(e.getMessage());  //Log4j

        }

    }


}
