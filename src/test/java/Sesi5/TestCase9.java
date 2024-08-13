//Search Product
package Sesi5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase9 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        String baseUrl="https://automationexercise.com/";
        driver.get(baseUrl);

        WebElement products = driver.findElement(By.cssSelector("a[href='/products']"));
        products.click();

        WebElement search = driver.findElement(By.id("search_product"));
        search.sendKeys("Stylish Dress");

        WebElement button = driver.findElement(By.id("submit_search"));
        button.click();

        System.out.println("Searched product is visible");
    }
}
