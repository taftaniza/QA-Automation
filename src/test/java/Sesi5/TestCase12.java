//Add Products in Cart
package Sesi5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase12 {
    public static void main(String[] args) {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tafta\\chromedriver-win64\\chromedriver.exe");

        // Declaration and instantiation of objects/variable ChromeDriver
        WebDriver driver = new ChromeDriver();
        String baseUrl= "https://automationexercise.com/";
        driver.get(baseUrl);


        WebElement productsLink = driver.findElement(By.cssSelector("a[href='/products']"));
        productsLink.click();


        WebElement add1 = driver.findElement(By.cssSelector("a[data-product-id='1'].btn.btn-default.add-to-cart"));
        add1.click();

        // Click 'Continue Shopping' button on the modal that appears
        WebElement btnContinueShopping = driver.findElement(By.cssSelector("button.btn.btn-success.close-modal"));
        btnContinueShopping.click();

        // Add second product to the cart
        WebElement add2 = driver.findElement(By.xpath("//a[@data-product-id='3']"));
        add2.click();

        // Click 'View Cart' link
        WebElement seeCart = driver.findElement(By.cssSelector("a[href='/view_cart']"));
        seeCart.click();

        // Print a success message
        System.out.println("Both products have been added to the cart");

        // Close the browser
        driver.quit();
    }
}


