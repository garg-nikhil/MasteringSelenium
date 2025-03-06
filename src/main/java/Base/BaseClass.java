package Base;

import Pages.com.java.nikhil.flightReservation.CustomerRegistrationPages;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ConfigReader;

import java.io.FileInputStream;
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
        WebDriverManager.chromedriver().setup();

        log.info("***********************************");
        log.info("**** Test Execution is started ****");
        log.info("***********************************");

        if (ConfigReader.getProperty("browser").equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (ConfigReader.getProperty("browser").equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (ConfigReader.getProperty("browser").equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Browser not supported: " + ConfigReader.getProperty("browser"));
        }

        log.info("Launching "+ConfigReader.getProperty("browser"));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        if (driver != null){
        driver.quit();
        }
    }

}
