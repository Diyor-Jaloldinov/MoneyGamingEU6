package com.moneygaming.tests;

import com.moneygaming.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1 {

    WebDriver driver;

    @BeforeTest
    public void setUP(){
        driver = WebDriverFactory.getDriver("edge");
        driver.manage().window().maximize();
    }

    @Test
    public void test1(){

    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
