//Verify Subscription in home page

package Sesi5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase10 {
        WebDriver driver;

        @BeforeClass
                public void setUp() {
            driver = new ChromeDriver();
            String baseUrl="https://automationexercise.com/";
            driver.get(baseUrl);
        }

        @Test(priority = 1)
    public void subs() {
            driver.findElement(By.id("susbscribe_email")).sendKeys("tes@gmail.com");
            driver.findElement(By.cssSelector("button.btn.btn-default")).click();

            System.out.println("You have been successfully subscribed");
        }

        @AfterClass
    public void tearDown() {
            driver.quit();
        }

}
