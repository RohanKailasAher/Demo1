package com.FirstTestNG.Package;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTestNGFile {
    public String baseUrl = "https://www.google.com/";

    public WebDriver driver ;
    @Test
    public void verifyTitle() {

        System.out.println("launching chrome browser");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle);
        driver.close();
    }

}
