package com.java.nikhil.flightReservation.tests;

import Base.BaseClass;
import Pages.com.java.nikhil.flightReservation.CustomerRegistrationPages;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.ConfigReader;

public class CustomerRegistrationTests extends BaseClass {

    public CustomerRegistrationTests(){
        super();
    }

    @Test
    public void launchCustomerPortal(){
        CustomerRegistrationPages customerRegistrationPages = new CustomerRegistrationPages(driver);
        driver.get(ConfigReader.getProperty("url"));
        customerRegistrationPages.submitData();
    }


    public void registerUser(){

    }

}
