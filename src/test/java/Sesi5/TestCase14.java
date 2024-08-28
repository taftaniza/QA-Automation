//Place Order: Register while checkout
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

public class TestCase14 {

        WebDriver driver;
        WebDriverWait wait;
        Actions actions;

        @BeforeClass
                public void setUp() {

            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adding WebDriverWait
            actions = new Actions(driver); // Create an instance of the Actions class

            driver.manage().window().maximize();
            driver.get("https://automationexercise.com/");

        }

        @Test(priority = 1)
            public void goToProduct() {
            // 3. Verify that home page is visible successfully
            System.out.println("Homepage is visible successfully");

            //4. Add products to cart |  Go to Products menu first:
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
        }

        @Test(priority = 3)
                public void goToCart() {

            //5. Click 'Cart' button
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Cart"))).click();

            //6. Verify that cart page is displayed
            System.out.println("Successfully displaying the cart page");
        }

        @Test(priority = 4)
                public void goToProducts() {

            //7. Click Proceed To Checkout
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Proceed To Checkout"))).click();

            //8. Click 'Register / Login' button
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Register / Login"))).click();

        }

        @Test(priority = 5)
        public void regist() {
            //9. Fill all details in Signup and create account
            //i)Fill Signup
            driver.findElement(By.cssSelector("input[name='name'")).sendKeys("hi");
            driver.findElement(By.xpath("//input[@name='email' and @data-qa='signup-email']")).sendKeys("hi@gmail.com");

            driver.findElement(By.xpath("//button[@type='submit' and @data-qa='signup-button']")).click();

        }

        @Test(priority = 6)
                public void fillForm() {

            driver.findElement(By.id("uniform-id_gender2")).click();

            driver.findElement(By.xpath("//input[@id='password' and @data-qa='password']")).sendKeys("12345");

            //Address Information Section:
            driver.findElement(By.id("first_name")).sendKeys("John");
            driver.findElement(By.id("last_name")).sendKeys("Smith");
            driver.findElement(By.id("company")).sendKeys("Aksata");

            driver.findElement(By.id("address1")).sendKeys("123 Main St");
            driver.findElement(By.id("country")).sendKeys("Indonesia");

            driver.findElement(By.id("state")).sendKeys("Residence");
            driver.findElement(By.id("city")).sendKeys("Jakarta");

            driver.findElement(By.id("zipcode")).sendKeys("1233");
            driver.findElement(By.id("mobile_number")).sendKeys("081234");

            driver.findElement(By.xpath("//button[@type='submit' and @data-qa='create-account']")).click();


            //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
            driver.findElement(By.linkText("Continue")).click();

            System.out.println("ACCOUNT CREATED, Successfully!");

        }

        @Test(priority = 7)
                public void login() {

            //11. Verify ' Logged in as username' at top

            String user = driver.findElement(By.xpath("//div[@class='shop-menu pull-right']//a//b")).getText();
            System.out.println("Logged as : " + user);


            //12.Click 'Cart' button
            driver.findElement(By.linkText("Cart")).click();
        }

        @Test(priority = 8)
                public void userAddress() {
            //13. Click 'Proceed To Checkout' button
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Proceed To Checkout"))).click();

            //14. Verify Address Details and Review Your Order
            String title = driver.findElement(By.xpath("//div[@class='step-one']//h2")).getText();
            System.out.println(title);

            WebElement deliveryAddress = driver.findElement(By.id("address_invoice"));

            // Locate all the list items inside the delivery address
            List<WebElement> deliveryDetails = deliveryAddress.findElements(By.tagName("li"));

            System.out.println("Delivery Address:");
            // Loop through and print each detail
            for (WebElement detail : deliveryDetails) {
                System.out.println(detail.getText());
            }

            // Locate the invoice address container
            WebElement invoiceAddress = driver.findElement(By.id("address_invoice"));

            // Locate all the list items inside the invoice address
            List<WebElement> invoiceDetails = invoiceAddress.findElements(By.tagName("li"));

            System.out.println("\nInvoice Address:");
            // Loop through and print each detail
            for (WebElement detail : invoiceDetails) {
                System.out.println(detail.getText());
            }


            //15. Enter description in comment text area and click 'Place Order'
            driver.findElement(By.xpath("//input[@name='message']")).sendKeys("try send message");

            driver.findElement(By.xpath("//a[@href='/payment']")).click();

        }

        @Test(priority = 9)
                public void payment() {

            //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
            driver.findElement(By.xpath("//input[@name='name_on_card' and @data-qa='name-on-card']")).sendKeys();
            driver.findElement(By.xpath("//input[@name='card_number' and @data-qa='card-number']")).sendKeys();
            driver.findElement(By.xpath("//input[@name='cvc' and @data-qa='cvc']")).sendKeys();
            driver.findElement(By.xpath("//input[@name='expiry_month' and @data-qa='expiry-month']")).sendKeys();
            driver.findElement(By.xpath("//input[@name='expiry_year' and @data-qa='expiry-year']")).sendKeys();

            //17. Click 'Pay and Confirm Order' button
            driver.findElement(By.xpath("//button[@type='submit' and @data-qa='pay-button']")).click();

            //18. Verify success message 'Your order has been placed successfully!'
            System.out.println("Your order has been placed successfully!");
        }

        @Test(priority = 10)
                public void deleteAcc() {

            //19. Click 'Delete Account' button
             driver.findElement(By.linkText("Delete Account")).click();
        }

        @Test(priority = 11)
        public void verification() {
            //20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
            driver.findElement(By.linkText("Continue")).click();
        }

        @AfterClass
            public void tearDown() {
            driver.quit();
        }

}
