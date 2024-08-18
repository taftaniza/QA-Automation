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

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tafta\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adding WebDriverWait
        Actions actions = new Actions(driver); // Actions for hovering

        String baseUrl = "https://automationexercise.com/";
        driver.get(baseUrl);

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

        // Hover over the 2nd product to trigger the overlay
        WebElement hover2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.product-overlay ")));
        actions.moveToElement(hover2).perform(); // Hover over the product


        WebElement addToCartButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.overlay-content a[data-product-id='1']")));
        addToCartButton2.click();

        System.out.println("2nd product added to cart");

        WebElement viewCart = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("View Cart")));
        viewCart.click();

        //Get value from cart
        WebElement product = driver.findElement(By.xpath("//td[@class='cart_description']//h4//a"));
        WebElement price = driver.findElement(By.xpath("//td[@class='cart_price']//p"));



        // Retrieve the text and print it
        String productText = product.getText();
        String priceText = price.getText();

        System.out.println("Product name: " + productText);
        System.out.println("Product price: " + priceText);


        // Close the browser
        //driver.quit();
    }
}
