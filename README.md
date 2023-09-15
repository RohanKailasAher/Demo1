# Demo1
Authour Rohan Aher
package Test1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;

public class TakingScreenShot {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.neosofttech.com/");

        // Create a File object to store the screenshot
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String fileName = "screenshot";

        String filePath = "C:\\Users\\user\\IdeaProjects\\Selenium-Practicles\\Pics" + fileName + ".png";

       // Copy the screenshot to the specified file path
        FileUtils.copyFile(file, new File(filePath));
        System.out.println("Screenshot saved to: " + filePath);

        driver.quit();
    }
}
