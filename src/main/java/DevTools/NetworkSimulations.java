package DevTools;

import Pages.com.java.nikhil.flightReservation.CustomerRegistrationPages;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v131.network.Network;
import org.openqa.selenium.devtools.v131.network.model.Request;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class NetworkSimulations {
    private static final Logger log = LogManager.getLogger(CustomerRegistrationPages.class);

    public static void main(String[] args) {


    }

    //Use the following method to set geolocation override to perform automated localization testing
    public void setGeolocationOverride(){
            WebDriverManager.chromedriver().setup();
            ChromeDriver driver = new ChromeDriver();

            DevTools tools = driver.getDevTools();
            tools.createSession();
            Map<String, Object> coordinates = new HashMap<String, Object>();
            coordinates.put("latitude", 46);
            coordinates.put("longitude", 2);
            coordinates.put("accuracy", 1);

            driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
            driver.get("https://www.google.com");
            driver.findElement(By.xpath("//*[@title='Search']")).sendKeys("netflix" + Keys.RETURN);
    }

    private void interpretNetworkCalls(){
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

        driver.get("https://dev.console.hcl-x.com/");
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("nikhil.garg@hcl.com");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("India@2023");
        driver.findElement(By.xpath("//*[@id='kc-login']")).click();

    }
}
