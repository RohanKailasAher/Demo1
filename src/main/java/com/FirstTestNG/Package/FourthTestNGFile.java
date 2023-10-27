package com.FirstTestNG.Package;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.testng.Assert;

public class FourthTestNGFile {
    public String baseUrl = "http://demo.guru99.com/test/newtours/";
    public WebDriver driver;
    public String expected = null;
    public String actual = null;

    // This method runs once before the entire test suite.
    @BeforeSuite
    public void setUpSuite() {
        System.out.println("Setting up the test suite");
    }

    // This method runs once after the entire test suite.
    @AfterSuite
    public void EndSuite() {
        System.out.println("End the test suite");
    }

    // This method runs before any test method in the <test> tag.
    @BeforeTest
    public void setUpTest() {
        System.out.println("Setting up the test");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    // This method runs before any test method in the current test class.
    @BeforeClass
    public void setUpClass() {
        System.out.println("Setting up the test class");
    }

    // This method runs before each test method.
    @BeforeMethod
    public void setUpMethod() {
        System.out.println("Setting up the test method");
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    // This is a test method.
    @Test(priority = 0)
    public void testRegister() {
        System.out.println("Running Register Test");
        driver.findElement(By.linkText("REGISTER")).click();
        expected = "Register: Mercury Tours";
        actual = driver.getTitle();
        System.out.println(actual);
        Assert.assertEquals(actual, expected);
    }

    // This is another test method.
    @Test(priority = 1)
    public void testSupport() {
        System.out.println("Running Support Test");
        driver.findElement(By.linkText("SUPPORT")).click();
        expected = "Under Construction: Mercury Tours";
        actual = driver.getTitle();
        System.out.println(actual);
        Assert.assertEquals(actual, expected);
    }

    // This method runs after each test method.
    @AfterMethod
    public void tearDownMethod() {
        System.out.println("Tearing down the test method");
        driver.findElement(By.linkText("Home")).click();
    }

    // This method runs after all test methods in the current class.
    @AfterClass
    public void EndClass() {
        System.out.println("End  the test class");
    }

    // This method runs after all test methods in the <test> tag.
    @AfterTest
    public void tearDownTest() {
        System.out.println("Tearing down the test");
        driver.close();
    }

    // This method runs after a specific group of test methods.
    @AfterGroups(groups = "group1")
    public void afterGroup() {
        System.out.println("This runs after group1");
    }

    // This method runs before a specific group of test methods.
    @BeforeGroups(groups = "group1")
    public void beforeGroup() {
        System.out.println("This runs before group1");
    }
}