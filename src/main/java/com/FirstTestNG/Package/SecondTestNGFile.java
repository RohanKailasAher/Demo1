package com.FirstTestNG.Package;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SecondTestNGFile {
    public String baseUrl = "https://www.google.com/";

    public WebDriver driver ;

    @BeforeTest
    public void launchBrowser(){
        System.out.println("launching chrome browser");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }
    @Test
    public void verifyTitle(){
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @AfterTest
    public void ExitBrowser(){
        driver.close();
    }
}
