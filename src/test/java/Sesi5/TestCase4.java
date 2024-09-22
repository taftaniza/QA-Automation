//Logout User

package Sesi5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase4 {
    WebDriver driver;

    @BeforeClass
            public void setUp() {
        driver = new ChromeDriver();
        String baseUrl= "https://automationexercise.com/";
        driver.get(baseUrl);

    }

    @Test(priority = 1)
    public void login() {

        // Get the Web Element corresponding to the Signup/Login page:
        driver.findElement(By.linkText("Signup / Login")).click();
    }

    @Test(priority = 2)
    public void fillForm() {
        //Fill the field at login page
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("melati@gmail.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12345");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test(priority = 3)
    public void logout() {
        // Logout Account:
        driver.findElement(By.linkText("Logout")).click();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
