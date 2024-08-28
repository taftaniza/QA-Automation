//Verify All Products and product detail page

package Sesi5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase8 {
    WebDriver driver;

        @BeforeClass
                public void setUp()  {
            driver = new ChromeDriver();
            String baseUrl = "https://automationexercise.com/";
            driver.get(baseUrl);
        }

        @Test(priority = 1)
                public void test2() {
            driver.findElement(By.cssSelector("a[href='/products']")).click();
            driver.findElement(By.cssSelector("a[href='/product_details/1']")).click();

            System.out.println("Navigated to detail product");
        }

        @AfterClass
    public void tearDown() {
            driver.quit();
        }

}
