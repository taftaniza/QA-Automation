package Sesi5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestCase2 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        String baseUrl= "https://automationexercise.com/";
        driver.get(baseUrl);

        //Fill the field at login page
        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
        WebElement passwordLogin = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement buttonLogin = driver.findElement(By.xpath("//button[@type='submit']"));

        email.sendKeys("tata@gmail.com");
        passwordLogin.sendKeys("12345");
        buttonLogin.click();

    }
}
