//Login User with Correct User and Password

package Sesi5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestCase2 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tafta\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // Maximize browser window
        driver.get("https://automationexercise.com/");
    }

    @Test(priority = 1)
    public void login() {
        // Navigate to the Signup/Login page
        driver.findElement(By.linkText("Signup / Login")).click();

        // Fill in the login credentials
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("hai@gmail.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12345");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test(priority = 2, dependsOnMethods = "login")
    public void delAcc() {
        // Navigate to Delete Account:
        driver.findElement(By.linkText("Delete Account")).click();

        // Click on "Continue" after deleting the account
        driver.findElement(By.linkText("Continue")).click();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Close the browser and end the session
        }
    }

}
