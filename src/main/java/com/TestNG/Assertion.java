package com.TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertion {
    public WebDriver driver;
    public SoftAssert softAssert;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        softAssert = new SoftAssert();
    }

    @Test
    public void testValidLogin() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");

        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        loginButton.click();

        // Hard assertion: Verify that login is successful
        WebElement welcomeMessage = driver.findElement(By.xpath("//div[text()='Swag Labs']"));
        Assert.assertEquals(welcomeMessage.getText(), "Swag Labs");
    }

    @Test
    public void testInvalidLogin() {
        driver.get("https://www.saucedemo.com/");

        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameField.sendKeys("standard_user1");
        passwordField.sendKeys("secret_sauce1");
        loginButton.click();

        // Hard assertion: Verify that an error message is displayed
        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
        Assert.assertEquals(errorMessage.getText(), "Epic sadface: Username and password do not match any user in this service");

        // Soft assertion: Verify that the login button is still visible after the failed login attempt
        softAssert.assertTrue(loginButton.isDisplayed(), "Login button is not displayed after failed login.");

        softAssert.assertAll();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
