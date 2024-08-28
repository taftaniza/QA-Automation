//Remove Products From Cart
package Sesi5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestCase17 {
    public static void main(String[] args) {
        // 1. Launch browser
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tafta\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // 2. Navigate to url 'http://automationexercise.com'
        String baseUrl = "https://automationexercise.com/";
        driver.get(baseUrl);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adding WebDriverWait
        Actions actions = new Actions(driver); // Create an instance of the Actions class

        // 3. Verify that home page is visible successfully
        System.out.println("Homepage is visible successfully");

        // 4. Add products to cart

        WebElement productsLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/products']")));
        productsLink.click();

        // Hover over the product to trigger the overlay
        WebElement hover = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.product-overlay")));
        actions.moveToElement(hover).perform(); // Hover over the product


        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.overlay-content a[data-product-id='1']")));
        addToCartButton.click();

        WebElement btnContinue = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-success close-modal btn-block']")));
        btnContinue.click();


        System.out.println("1 product added to cart");

        //5. Click 'Cart' button
        WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/view_cart']")));
        cart.click();


        //6. Verify that cart page is displayed
        System.out.println("cart page is displayed");

        //7. Click 'X' button corresponding to particular product
        WebElement deleteCart = driver.findElement(By.cssSelector("a[class='cart_quantity_delete']"));
        deleteCart.click();


        //8. Verify that product is removed from the cart
        System.out.println("Product is removed from cart");

    }
}
