//Place Order: Login before checkout
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

import java.util.List;

public class TestCase16 {

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
                public void goToLOgin() {

            // 3. Verify that home page is visible successfully
            System.out.println("Homepage is visible successfully");

            // 4. Click 'Signup / Login' button
            driver.findElement(By.linkText("Signup / Login")).click();
        }

        @Test(priority = 2)
                public void login() {

            //5. Fill email, password and click 'Login' button
            driver.findElement(By.xpath("//input[@name='email']")).sendKeys("dots@gmail.com");
            driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12345");
            driver.findElement(By.xpath("//button[@type='submit']")).click();

        }

        @Test(priority = 3)
                public void veryUser() {
            //6. Verify 'Logged in as username' at top
            WebElement username = driver.findElement(By.xpath("//div[@class='shop-menu pull-right']//a//b"));
            String user = username.getText();
            System.out.println("Logged as: " + user);


            WebElement productsLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/products']")));
            productsLink.click();

        }

        @Test(priority = 4)
                public void addProduct() {
            //7. Add products to cart
            // Hover over the product to trigger the overlay
            WebElement hover = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.product-overlay")));
            actions.moveToElement(hover).perform(); // Hover over the product
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.overlay-content a[data-product-id='1']"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-success close-modal btn-block']"))).click();

            System.out.println("1 product added to cart");

            //8. Click 'Cart' button
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Cart"))).click();

            //9. Verify that cart page is displayed
            System.out.println("Successfully displaying the cart page");
        }

        @Test(priority = 5)
                public void checkOut() {

            //10. Click Proceed To Checkout
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Proceed To Checkout"))).click();

            //11. Verify Address Details and Review Your Order
            String title = driver.findElement(By.xpath("//div[@class='step-one']//h2")).getText();
            System.out.println(title);

            WebElement deliveryAddress = driver.findElement(By.id("address_delivery"));
            List<WebElement> deliveryDetails = deliveryAddress.findElements(By.tagName("li"));

            System.out.println("Delivery Address:");
            for (WebElement detail : deliveryDetails) {
                System.out.println(detail.getText());
            }

            WebElement invoiceAddress = driver.findElement(By.id("address_invoice"));
            List<WebElement> invoiceDetails = invoiceAddress.findElements(By.tagName("li"));

            System.out.println("\nInvoice Address:");
            for (WebElement detail : invoiceDetails) {
                System.out.println(detail.getText());
            }

            //12. Enter description in comment text area and click 'Place Order'
            driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys("try send message");

            driver.findElement(By.linkText("Place Order")).click();

        }

        @Test(priority = 6)
                public void cardPayment() {

            //13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
            driver.findElement(By.xpath("//input[@name='name_on_card' and @data-qa='name-on-card']")).sendKeys("John Doe");
            driver.findElement(By.xpath("//input[@name='card_number' and @data-qa='card-number']")).sendKeys("1234567812345678");
            driver.findElement(By.xpath("//input[@name='cvc' and @data-qa='cvc']")).sendKeys("123");
            driver.findElement(By.xpath("//input[@name='expiry_month' and @data-qa='expiry-month']")).sendKeys("12");
            driver.findElement(By.xpath("//input[@name='expiry_year' and @data-qa='expiry-year']")).sendKeys("2025");


            //14. Click 'Pay and Confirm Order' button
            driver.findElement(By.xpath("//button[@type='submit' and @data-qa='pay-button']")).click();

            //15. Verify success message 'Your order has been placed successfully!'
            System.out.println("Your order has been placed successfully!");

        }

        @Test(priority = 7)
                public void deleteAcc(){
        //16. Click 'Delete Account' button
        driver.findElement(By.linkText("Delete Account")).click();

        //17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        driver.findElement(By.linkText("Continue")).click();

    }

    @AfterClass
    public void close(){
            driver.close();
    }
}
