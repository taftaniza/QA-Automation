//Remove Products From Cart
package Sesi5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase17 {

        WebDriver driver;
        WebDriverWait wait;
        Actions actions;

        @BeforeClass
                public void setUp() {
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adding WebDriverWait
            actions = new Actions(driver); // Create an instance of the Actions class

            String baseUrl = "https://automationexercise.com/";
            driver.get(baseUrl);
            driver.manage().window().maximize();
        }

        @Test(priority = 1)
                public void goToProduct() {
            // 3. Verify that home page is visible successfully
            System.out.println("Homepage is visible successfully");

            // 4. Add products to cart
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/products']"))).click();
        }

        @Test(priority = 2)
                public void addProduct() {

            // Hover over the product to trigger the overlay
            WebElement hover = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.product-overlay")));
            actions.moveToElement(hover).perform(); // Hover over the product

            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.overlay-content a[data-product-id='1']"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-success close-modal btn-block']"))).click();

            System.out.println("1 product added to cart");

            //5. Click 'Cart' button
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/view_cart']"))).click();

            //6. Verify that cart page is displayed
            System.out.println("cart page is displayed");
        }

        @Test(priority = 3)
                public void dellProductInCart() {

        //7. Click 'X' button corresponding to particular product
        driver.findElement(By.cssSelector("a[class='cart_quantity_delete']")).click();

        //8. Verify that product is removed from the cart
        System.out.println("Product is removed from cart");

    }
}
