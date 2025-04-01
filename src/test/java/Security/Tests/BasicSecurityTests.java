package Security.Tests;

import Base.BaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BasicSecurityTests extends BaseClass {

    //Session hijacking verification
    @Test
    public void sessionHijacking() throws InterruptedException {

        driver.get("https://dev.console.hcl-x.com/qualitycontroldedicated/en/dashboard");
        Thread.sleep(7000);
        driver.findElement(By.id("username")).sendKeys("nikhil.garg@hcl.com");
        driver.findElement(By.id("password")).sendKeys("India@2023");
        driver.findElement(By.name("login")).click();

        String sessionBeforeLogout = driver.manage().getCookieNamed("SESSIONID").getValue();

        driver.findElement(By.id("logoutBtn")).click();

        driver.get("https://dev.console.hcl-x.com/qualitycontroldedicated/en/dashboard");

        driver.findElement(By.id("username")).sendKeys("nikhil.garg@hcl.com");
        driver.findElement(By.id("password")).sendKeys("India@2023");
        driver.findElement(By.name("login")).click();

        String sessionAfterLogin = driver.manage().getCookieNamed("SESSIONID").getValue();

        boolean sessionChanged = !sessionBeforeLogout.equals(sessionAfterLogin);
        System.out.println("Session Hijacking Test: " + (sessionChanged ? "Passed ✅" : "Failed ❌"));



    }

}
