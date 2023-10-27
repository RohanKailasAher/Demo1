package Demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class Test {
    WebDriver driver;
    @BeforeMethod
    public void Setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        driver.findElement(By.xpath("//span[@role='button']")).click();
        Thread.sleep(5000);
    }
    @org.testng.annotations.Test
    public void Test(){
        WebElement SearchBar = driver.findElement(By.name("q"));
        SearchBar.sendKeys("Mobile");
    }


}
