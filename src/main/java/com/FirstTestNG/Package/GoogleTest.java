package com.FirstTestNG.Package;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class GoogleTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @Test
    public void GoogleTitleTest() {
        String title = driver.getTitle();
        System.out.println(title);

    }

    @Test
    public void GoogleLogoTest() {
        boolean b = driver.findElement(By.xpath("//img[@class='lnXdpd']")).isDisplayed();

    }

    @Test
    public void GmailLinkTest() {
        boolean b = driver.findElement(By.xpath("//a[text()='Gmail']")).isDisplayed();

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
