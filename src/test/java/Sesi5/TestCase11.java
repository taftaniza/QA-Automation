//Verify Subscription in Cart page
package Sesi5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase11 {

        WebDriver driver;

        @BeforeClass
                public void setUp() {
            driver = new ChromeDriver();
            String baseUrl="https://automationexercise.com/";
            driver.get(baseUrl);
        }

        @Test(priority = 1)
    public void cartPage() {
            driver.findElement(By.linkText("Cart")).click();

        }

        @Test(priority = 2)
    public void subscribe() {
            driver.findElement(By.id("susbscribe_email")).sendKeys("tes@gmail.com");

            driver.findElement(By.cssSelector("button.btn.btn-default")).click();

            System.out.println("You have been successfully subscribed");
        }

        @AfterClass
    public void tearDown() {
            driver.quit();
        }
}
