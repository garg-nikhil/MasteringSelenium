package uiTests;

import Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class googly extends BaseClass {

    public googly(){
        super();
    }

    @Test
    public void tryGoogl(){
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//*[@title='Search']")).sendKeys("Hello");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role='listbox']//li")));
        List<WebElement> list = driver.findElements(By.xpath("//*[@role='listbox']//li"));

        for(WebElement a:list){
            System.out.println(a.getText());
            if(a.getText().contains("Hello")){
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Hello']")));
                driver.findElement(By.xpath("//*[text()='Hello']")).click();
                System.out.print("clicked");
            }
        }

    }
}
