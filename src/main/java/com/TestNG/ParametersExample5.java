package com.TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersExample5 {
    WebDriver driver;

    @BeforeClass
    @Parameters({"browser", "url"})
    public void setup(String browser, String app) throws InterruptedException {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.get(app);
        Thread.sleep(2000);
    }
    @Test(priority = 1)
    public void LogoTest() {
        WebElement logo = driver.findElement(By.xpath("//img[@alt='company-branding']"));
        Assert.assertTrue(logo.isDisplayed(), "logo not displayed on the page ");
    }
    @Test(priority = 2)
    public void homepageTitle() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "OrangeHRM", "Title is not matched");
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}


