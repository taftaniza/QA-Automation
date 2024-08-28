//Verify Test Cases Page

package Sesi5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase7 {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        String baseUrl = "https://automationexercise.com/";
        driver.get(baseUrl);

        WebElement testCase = driver.findElement(By.linkText("Test Cases"));
        testCase.click();

        System.out.println("Navigated to test cases page successfully");


    }
}
