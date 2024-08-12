//Login User with Correct User and Password

package Sesi5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;

import java.time.Duration;

public class TestCase2 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        String baseUrl= "https://automationexercise.com/";
        driver.get(baseUrl);

        // Get the Web Element corresponding to the Signup/Login page:
        WebElement login = driver.findElement(By.linkText("Signup / Login"));
        login.click();

        //Fill the field at login page
        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
        WebElement passwordLogin = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement buttonLogin = driver.findElement(By.xpath("//button[@type='submit']"));

        email.sendKeys("radot@gmail.com");
        passwordLogin.sendKeys("12345");
        buttonLogin.click();

        // Delete Account:
        WebElement del = driver.findElement(By.linkText("Delete Account"));
        del.click();
        WebElement con2 = driver.findElement(By.linkText("Continue"));
        con2.click();
    }
}
