package Base;

import Pages.com.java.nikhil.flightReservation.CustomerRegistrationPages;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ConfigReader;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class BaseClass {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private static final Logger log = LogManager.getLogger(CustomerRegistrationPages.class);


    private void loadConfig(){
        Properties Config = new Properties();
        try{
            String path = System.getProperty("user.dir") + "/src/main/resources/config/Configuration.properties";
            FileInputStream file = new FileInputStream(path);
            Config.load(file);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void devtools(){
        DevTools tools = ((ChromeDriver) driver).getDevTools();
        tools.createSession();
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

}
