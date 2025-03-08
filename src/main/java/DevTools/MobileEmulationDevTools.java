package DevTools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MobileEmulationDevTools {

    public static void main(String[] args){

    }

    public void devtools(){
        WebDriverManager.chromedriver().setup();

        // ✅ Define Mobile Emulation Settings
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPhone SE");  // Uses built-in iphone SE emulation

        // ✅ Apply to ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("mobileEmulation", mobileEmulation);

        // ✅ Launch Chrome in Mobile Mode
        ChromeDriver driver = new ChromeDriver(options);  // 🛠️ Apply ChromeOptions here
        driver.get("https://dev.console.hcl-x.com/");
    }

    private void emulationSecondMethod(){

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        DevTools devTools = driver.getDevTools();

        devTools.createSession();

        //send command to CDP Methods-> CDP Methods will invoke and get access to chrome dev tools
        devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true,       //device scale factor is zoom %, true is to enable mobile
                Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(),
                Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));

        driver.get("https://dedicatedqavalidation.hcl-x.com/en/user/profile?tab=0");
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("nikhil.garg@hcl.com");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("India@2023");
        driver.findElement(By.xpath("//*[@id='kc-login']")).click();

        devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true,
                Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(),
                Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
    }
}
