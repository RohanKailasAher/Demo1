package com.ParallelTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ParallelTest2 {
    WebDriver driver;
    @Test
    public void LoginTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println("PE2 Thread ID: "+Thread.currentThread().getId());
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(3000);
        driver.findElement(By.name("username")).sendKeys("Admin");
        Thread.sleep(3000);
        driver.findElement(By.name("password")).sendKeys("admin123");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertEquals(driver.getTitle(),"OrangeHRM");
        Thread.sleep(3000);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
