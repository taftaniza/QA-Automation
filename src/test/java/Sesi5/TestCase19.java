//View & Cart Brand Products
package Sesi5;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase19 {
        WebDriver driver;
        WebDriverWait wait;

        @BeforeClass
                public void setUp() {
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            String baseURL = "https://automationexercise.com/";
            driver.get(baseURL);
            driver.manage().window().maximize();
        }

        @Test(priority = 1)
                public void goToProd() {

            //3. Click on 'Products' button
            driver.findElement(By.cssSelector("a[href='/products']")).click();
            //4. Verify that Brands are visible on left side bar
            System.out.println("Categories are visible on left side bar");
        }

        @Test(priority = 2)
                public void category() {
        //5. Click on any brand name
        driver.findElement(By.xpath("//div[@class='brands_products'] //a[@href='/brand_products/Polo']")).click();

        //6. Verify that user is navigated to brand page and brand products are displayed
        String brandDspText = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[@class='title text-center']"))).getText();
        System.out.println("Showing brand: "+brandDspText);


        //7. On left side bar, click on any other brand link
        driver.findElement(By.xpath("//div[@class='brands_products'] //a[@href='/brand_products/Madame']")).click();

        //8. Verify that user is navigated to that brand page and can see products
        String brandDspText2 =driver.findElement(By.xpath("//h2[@class='title text-center']")).getText();
        System.out.println("Showing brand: "+brandDspText2);
    }

    @AfterClass
    public void tearDown() {
            driver.quit();
    }
}
