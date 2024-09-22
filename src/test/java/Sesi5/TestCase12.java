package Sesi5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase12 {

        WebDriver driver;
        WebDriverWait wait;
        Actions actions;

        @BeforeClass
            public void setUp() {
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adding WebDriverWait
            actions = new Actions(driver); // Actions for hovering

            String baseUrl = "https://automationexercise.com/";
            driver.get(baseUrl);
            driver.manage().window().maximize();
        }

        @Test(priority = 1)
            public void goToProduct() {
            WebElement productsLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/products']")));
            productsLink.click();
        }

        @Test(priority = 2)
            public void addProduct() {
            // Hover over the product to trigger the overlay
            WebElement hover = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.product-overlay")));
            actions.moveToElement(hover).perform(); // Hover over the product

            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.overlay-content a[data-product-id='1']"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-success close-modal btn-block']"))).click();

            System.out.println("1 product added to cart");
        }

        @Test(priority = 3)
            public void test3() {
            // Hover over the 2nd product to trigger the overlay
            WebElement hover2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.product-overlay ")));
            actions.moveToElement(hover2).perform(); // Hover over the product

            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.overlay-content a[data-product-id='1']"))).click();

            System.out.println("2nd product added to cart");

            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("View Cart"))).click();
        }

        @Test(priority = 4)
            public void test4() {
            //Get value from cart
            String productText = driver.findElement(By.xpath("//td[@class='cart_description']//h4//a")).getText();
            String priceText =  driver.findElement(By.xpath("//td[@class='cart_price']//p")).getText();

            System.out.println("Product name: " + productText);
            System.out.println("Product price: " + priceText);
        }

        @AfterClass
            public void close(){
            driver.quit();
        }

}
