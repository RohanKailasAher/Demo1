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

public class AssertionExample4 {
    WebDriver driver;
    @BeforeClass
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(2000);

    }
    @Test(priority = 1)
    public void LogoTest(){
        WebElement logo = driver.findElement(By.xpath("//img[@alt='company-branding']"));
        //Assert.assertTrue(logo.isDisplayed(),"logo not displayed on the page ");
        Assert.assertFalse(logo.isDisplayed(),"logo displayed on the page ");

    }
    @Test(priority = 2)
    public void homepageTitle(){
        String title = driver.getTitle();
        Assert.assertEquals(title,"OrangeHRM", "Title is not matched");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
