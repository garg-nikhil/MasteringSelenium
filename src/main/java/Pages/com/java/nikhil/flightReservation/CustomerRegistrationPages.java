package Pages.com.java.nikhil.flightReservation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerRegistrationPages {
    WebDriver driver;

    public CustomerRegistrationPages(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id='firstName']")
    private WebElement firstName;

    @FindBy(xpath = "//*[@id='lastName']")
    private WebElement lastName;

    @FindBy(xpath = "//*[@id='email']")
    private WebElement email;

    @FindBy(xpath = "//*[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//*[@name='street']")
    private WebElement street;

    @FindBy(xpath = "//*[@name='city']")
    private WebElement city;

    @FindBy(xpath = "//*[contains(text(),'State')]")
    private WebElement state;

    @FindBy(xpath = "//*[@name='zip']")
    private WebElement zip;

    @FindBy(xpath = "//*[@id='register-btn']")
    private WebElement register;

    public void submitData(){
        firstName.sendKeys("Nikhil");
        lastName.sendKeys("Nikhil");
        email.sendKeys("abc@gmail.com");
        password.sendKeys("water");
        street.sendKeys("downtown");
        city.sendKeys("arizona");
        zip.sendKeys("411033");
        register.click();
    }

}
