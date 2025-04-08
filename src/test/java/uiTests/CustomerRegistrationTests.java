package uiTests;

import Base.BaseClass;
import Pages.com.java.nikhil.flightReservation.CustomerRegistrationPages;
import org.testng.annotations.Test;
import config.ConfigReader;

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

}
