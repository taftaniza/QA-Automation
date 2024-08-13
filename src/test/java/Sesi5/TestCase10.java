//Verify Subscription in home page

package Sesi5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase10 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        String baseUrl="https://automationexercise.com/";
        driver.get(baseUrl);

        WebElement subs = driver.findElement(By.id("susbscribe_email"));
        subs.sendKeys("tes@gmail.com");

        WebElement btn = driver.findElement(By.cssSelector("button.btn.btn-default"));
        btn.click();

        System.out.println("You have been successfully subscribed");

    }
}
