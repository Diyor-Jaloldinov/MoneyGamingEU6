package com.moneygaming.tests;

import com.moneygaming.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1 {

    WebDriver driver;

    @BeforeTest
    public void setUP(){
        driver = WebDriverFactory.getDriver("firefox");
        driver.manage().window().maximize();
        driver.get("https://moneygaming.qa.gameaccount.com/sign-up.shtml");

    }

    @Test
    public void test1(){
        driver.findElement(By.id("forename")).sendKeys("John");
        driver.findElement(By.name("map(lastName)")).sendKeys("Deos");


        String checkBoxText = "I accept the Terms and Conditions and certify that I am over the age of 18.";

        Assert.assertEquals(checkBoxText,
                driver.findElement(By.cssSelector("div.validation")).getText(),"Comparing validation text");

        WebElement validationCheckBox = driver.findElement(By.name("map(terms)"));
        validationCheckBox.click();
        Assert.assertTrue(validationCheckBox.isSelected(),"validating checkbox is checked");

        driver.findElement(By.cssSelector(".promoReg")).click();

        String validationMessage = "This field is required";

        Assert.assertEquals(validationMessage,
                driver.findElement(By.xpath("//label[@for='dob']")).getText(),
                "verify Date of Birth error message");


    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
