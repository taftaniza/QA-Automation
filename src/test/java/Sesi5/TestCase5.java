//Register User with Existing account

package Sesi5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;

public class TestCase5 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        String baseUrl= "https://automationexercise.com/";
        driver.get(baseUrl);

        // Get the Web Element corresponding to the Signup/Login page:
        WebElement login = driver.findElement(By.linkText("Signup / Login"));
        login.click();

        // Fill Signup
        WebElement name = driver.findElement(By.cssSelector("input[name='name'"));
        name.sendKeys("lovely");
        WebElement emailSignup = driver.findElement(By.xpath("//input[@name='email' and @data-qa='signup-email']"));
        emailSignup.sendKeys("lovely@gmail.com");

        WebElement buttonSignup = driver.findElement(By.xpath("//button[@type='submit' and @data-qa='signup-button']"));
        buttonSignup.click();

        driver.quit();

    }
}
