//Search Product
package Sesi5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase9 {

        WebDriver driver;

        @BeforeClass
                public void setUp() {
            driver = new ChromeDriver();
            String baseUrl="https://automationexercise.com/";
            driver.get(baseUrl);
        }

        @Test(priority = 1)
    public void productPage() {
            driver.findElement(By.cssSelector("a[href='/products']")).click();
            driver.findElement(By.id("search_product")).sendKeys("Stylish Dress");
            driver.findElement(By.id("submit_search")).click();

            System.out.println("Searched product is visible");
        }

        @AfterClass
    public void tearDown() {
            driver.quit();
        }

}
