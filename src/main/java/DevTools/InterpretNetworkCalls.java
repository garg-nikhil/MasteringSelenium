package DevTools;

import Pages.com.java.nikhil.flightReservation.CustomerRegistrationPages;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v131.network.Network;
import org.openqa.selenium.devtools.v131.network.model.Request;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.List;
import java.util.Optional;

public class InterpretNetworkCalls {
    private static final Logger log = LogManager.getLogger(CustomerRegistrationPages.class);

    public static void main(String[] args) {
        System.out.println("InterpretNetworkCalls");
    }

    public void interpretNetworkCalls() {
        System.out.println("InterpretNetworkCalls");
        {
            WebDriverManager.chromedriver().setup();
            ChromeDriver driver = new ChromeDriver();

            DevTools devTools = driver.getDevTools();
            devTools.createSession();
            devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));

            devTools.addListener(Network.requestWillBeSent(), Request ->
            {
                org.openqa.selenium.devtools.v131.network.model.Request request = Request.getRequest();
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
}
