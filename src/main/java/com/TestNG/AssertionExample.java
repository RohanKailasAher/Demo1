package com.TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AssertionExample {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testGoogle() {
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("HYR Tutorials", Keys.ENTER);
        String expectedTitle = "HYR Tutorials - Google Search";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Title is mismatched");
    }

    @Test
    public void facebookTest() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.findElement(By.name("email")).sendKeys("HYR Tutorials", Keys.ENTER);
        Thread.sleep(5000);
        System.out.println(driver.getTitle());

        // Title assertion
        String actualTitle = driver.getTitle();
        String expectedTitle = "Log in to Facebook";
        Assert.assertEquals(actualTitle, expectedTitle, "Title is mismatched");

        // URL Assertion
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.facebook.com/";
        Assert.assertEquals(actualUrl, expectedUrl, "URL is mismatched");

        // Text Assertion
        String actualText = driver.findElement(By.name("email")).getAttribute("value");
        String expectedText = "HYR Tutorials";
        Assert.assertEquals(actualText, expectedText, "Username text is mismatched");

        // Border Assertion
        String actualBorder = driver.findElement(By.name("email")).getCssValue("border");
        String expectedBorder = "1px solid rgb(240, 40, 73)";
        Assert.assertEquals(actualBorder, expectedBorder, "Username border is mismatched");

        // Error Message Assertion
        String actualErrorMessage = driver.findElement(By.xpath("(//div[@id='email_container']/div)[last()]")).getText();
        String expectedErrorMessage = "The email address or mobile number you entered isn't connected to an account.";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message is mismatched");
        System.out.println(driver.getTitle());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
