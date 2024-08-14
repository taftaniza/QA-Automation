package Sesi5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestCase12 {
    public static void main(String[] args) {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tafta\\chromedriver-win64\\chromedriver.exe");

        // Declaration and instantiation of objects/variable ChromeDriver
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adding WebDriverWait
        Actions actions = new Actions(driver);

        String baseUrl = "https://automationexercise.com/";
        driver.get(baseUrl);

        // Navigate to the 'Products' page
        WebElement productsLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/products']")));
        productsLink.click();

        // Hover over the product to trigger the overlay
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.product-overlay")));
        actions.moveToElement(product).perform(); // Hover over the product

        // Click the 'Add to Cart' button within the overlay
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.overlay-content a[data-product-id='1']")));
        addToCartButton.click();

        //Click 'Continue Shopping' button on the modal that appears
        WebElement btnContinueShopping = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-success.close-modal.btn-block")));
        btnContinueShopping.click();

        // Hover over the product to trigger the overlay
        WebElement product2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.product-overlay")));
        actions.moveToElement(product2).perform(); // Hover over the product

        // Add second product to the cart
        WebElement add2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.overlay-content a[data-product-id='3']")));
        add2.click();

        // Click 'View Cart' link
        WebElement seeCart = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/view_cart']")));
        seeCart.click();

        // Print a success message
        System.out.println("Both products have been added to the cart");

//        // Close the browser
//        driver.quit();
    }
}
