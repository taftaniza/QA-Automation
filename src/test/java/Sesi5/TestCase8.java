//Verify All Products and product detail page

package Sesi5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase8 {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        String baseUrl = "https://automationexercise.com/";
        driver.get(baseUrl);

        WebElement testCase = driver.findElement(By.cssSelector("a[href='/product_details/1']"));
        testCase.click();

        System.out.println("Navigated to detail product");
    }
}
