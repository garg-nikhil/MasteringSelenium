package uiTests;

import Base.BaseClass;
import Pages.com.java.nikhil.flightReservation.CustomerRegistrationPages;
import config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class CustomerRegistrationTests extends BaseClass {

    public CustomerRegistrationTests(){
        super();
    }

    @Test
    public void launchCustomerPortal(){
        CustomerRegistrationPages customerRegistrationPages = new CustomerRegistrationPages(driver);
        driver.get(ConfigReader.getProperty("url"));
        customerRegistrationPages.submitData();
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("java.version"));
    }


    public void registerUser(){

    }

    @Test
    public void ele() throws InterruptedException {
        driver.get("https://demoqa.com");
        Thread.sleep(4000);
//        JavascriptExecutor js = new JavascriptExecutor() {
//            @Override
//            public @Nullable Object executeScript(String script, @Nullable Object... args) {
//                return null;
//            }
//
//            @Override
//            public @Nullable Object executeAsyncScript(String script, @Nullable Object... args) {
//                return null;
//            }
//        }


       WebElement element = driver.findElement(By.xpath("//h5[contains(text(),'Elements')]"));
       element.click();

        List<WebElement> list = driver.findElements(By.xpath("//*[@class='btn btn-light ']/parent::ul"));
        for(WebElement a:list){
            System.out.println(a);
        }

        WebElement textBox = driver.findElement(By.xpath("//span[contains(text(),'Text Box')]"));
        textBox.click();

        WebElement userName = driver.findElement(By.xpath("//*[@id='userName']"));
        String names = "abcd";
        userName.sendKeys(names);


        WebElement userEmail = driver.findElement(By.xpath("//*[@id='userEmail']"));
        String originalEMail = "abcd@tools.com";
        userEmail.sendKeys(originalEMail);

        WebElement address = driver.findElement(By.xpath("//*[@id='currentAddress']"));
        String originalAddress="abcd villa Pune";
        address.sendKeys(originalAddress);

        //permanentAddress
        WebElement permanentAddress = driver.findElement(By.xpath("//*[@id='permanentAddress']"));
        String permanentAddress1="abcd villa Pune";
        permanentAddress.sendKeys(permanentAddress1);

        //*[@id='submit']
        WebElement submitBtn = driver.findElement(By.xpath("//*[@id='submit']"));
        submitBtn.click();

        WebElement verifyName = driver.findElement(By.xpath("//*[@id='name']"));
        String name = verifyName.getText();

        if(name.equalsIgnoreCase(names)){
            System.out.println("Name is matching");
        }

        //email
        WebElement email = driver.findElement(By.xpath("//*[@id='email']"));
        String emails = email.getText();

        if(emails.equalsIgnoreCase(originalEMail)){
            System.out.println("Email is matching");
        }

        //p[@id='currentAddress']
        WebElement addresses = driver.findElement(By.xpath("//p[@id='currentAddress']"));
        String address1 = addresses.getText();

        if(address1.equalsIgnoreCase(originalAddress)){
            System.out.println("Address is matching");
        }

        //p[@id='permanentAddress']
        WebElement permaddresses = driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        String paddress = permaddresses.getText();

        if(paddress.equalsIgnoreCase(permanentAddress1)){
            System.out.println("Permanent Address is matching");
        }

        WebElement alertsFramesWindows = driver.findElement(By.xpath("//*[contains(text(),'Alerts, Frame & Windows')]"));
        alertsFramesWindows.click();

        //span[contains(text(),'Frames') and @class='text']
        WebElement frames = driver.findElement(By.xpath("//span[contains(text(),'Frames') and @class='text']"));
        frames.click();

        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='frame1']")));

        //*[@id='sampleHeading']
        WebElement headingText = driver.findElement(By.xpath("//*[@id='sampleHeading']"));
        headingText.getText();

        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='framesWrapper']")));

        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='frame2']")));
        WebElement headingText2 = driver.findElement(By.xpath("//*[@id='sampleHeading']"));
        headingText2.getText();

        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='framesWrapper']")));

        WebElement alertElement = driver.findElement(By.xpath("//span[contains(text(),'Alerts')]"));
        alertElement.click();

        WebElement alert = driver.findElement(By.xpath("//*[@id='alertButton']"));
        alert.click();

        System.out.println("Alert text is: "+driver.switchTo().alert().getText());

        driver.switchTo().alert().accept();

        WebElement browseWindows = driver.findElement(By.xpath("//span[contains(text(),'Browser Windows')]"));
        browseWindows.click();

        WebElement tab = driver.findElement(By.xpath("//*[@id='tabButton']"));
        tab.click();
        String handle = driver.getWindowHandle();
       Set<String> handles = driver.getWindowHandles();

       for(String h: handles){
           driver.switchTo().window(h);
       }

        WebElement text = driver.findElement(By.xpath("//*[@id='sampleHeading']"));
        text.getText();
    }

    public void verifySUbmittedDEtails(){



    }
    //Input - I am an Automation Engineer
    //Output - I ma na noitamotuA reenignE
    public void reverseString(){
        String input = "I am an Automation Engineer";
        HashMap<Character,Integer> abcd = new HashMap<>();

        for(char a:input.toCharArray()){
            System.out.println(abcd.put(a,abcd.getOrDefault(a,0)+1));
        }

    }

}
