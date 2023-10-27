package com.FirstTestNG.Package;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;

public class ThirdTestNGFile {
    public String baseUrl = "http://demo.guru99.com/test/newtours/";
    public WebDriver driver;
    public String expected = null;
    public String actual = null;

    @BeforeTest
    public void launchBrowser() {
        System.out.println("launching chrome browser");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @BeforeMethod
    public void verifyHomepageTitle() {
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @Test(priority = 0)
    public void register(){
        driver.findElement(By.linkText("REGISTER")).click() ;
        expected = "Register: Mercury Tours";
        actual = driver.getTitle();
        System.out.println(actual);
        Assert.assertEquals(actual, expected);
    }
    @Test(priority = 1)
    public void support() {
        driver.findElement(By.linkText("SUPPORT")).click() ;
        expected = "Under Construction: Mercury Tours";
        actual = driver.getTitle();
        System.out.println(actual);
        Assert.assertEquals(actual, expected);
    }
    @AfterMethod
    public void goBackToHomepage ( ) {
        driver.findElement(By.linkText("Home")).click() ;
    }

    @AfterTest
    public void EndBrowser(){
        driver.close();
    }
}

