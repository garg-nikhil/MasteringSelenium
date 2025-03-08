package DevTools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class MobileEmulationDevTools {

    public static void main(String[] args){

    }

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
}
