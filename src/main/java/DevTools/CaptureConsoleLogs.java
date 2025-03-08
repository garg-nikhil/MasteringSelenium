package DevTools;

import Pages.com.java.nikhil.flightReservation.CustomerRegistrationPages;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.List;

public class CaptureConsoleLogs {
    private static final Logger log = LogManager.getLogger(CustomerRegistrationPages.class);

    public static void main(String[] args){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://dedicatedqavalidation.hcl-x.com/en/user/profile?tab=0");
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("nikhil.garg@hcl.com");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("India@2023");
        driver.findElement(By.xpath("//*[@id='kc-login']")).click();

        LogEntries entry= driver.manage().logs().get(LogType.BROWSER); //Get LogEntries object
        List<LogEntry> logs = entry.getAll();  //LogEntryobject- getAll method return all logs in list

        for(LogEntry e : logs)//iterating through list and printing each log message
        {
            log.info(""+e.getMessage());  //Log4j

        }
    }
}
