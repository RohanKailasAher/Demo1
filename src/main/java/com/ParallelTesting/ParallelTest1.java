package com.ParallelTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class ParallelTest1 {
    WebDriver driver;
    @Test
    public void LogoTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(3000);
        WebElement logo = driver.findElement(By.xpath("//img[@alt='company-branding']"));
        Assert.assertTrue(logo.isDisplayed(),"logo not displayed on the page ");
    }
    @Test
    public void HomepageTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        System.out.println("PE1 Thread ID: "+Thread.currentThread().getId());
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(3000);
        String title = driver.getTitle();
        Assert.assertEquals(title,"OrangeHRM", "Title is not matched");
    }

     @AfterMethod
    public void tearDown()
     {
         driver.quit();
     }
    }

