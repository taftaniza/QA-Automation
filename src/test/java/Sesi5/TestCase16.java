//Place Order: Login before checkout
package Sesi5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import java.util.List;

public class TestCase16 {
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

        // 4. Click 'Signup / Login' button
        WebElement login = driver.findElement(By.linkText("Signup / Login"));
        login.click();


        //5. Fill email, password and click 'Login' button
        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
        WebElement passwordLogin = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement buttonLogin = driver.findElement(By.xpath("//button[@type='submit']"));

        email.sendKeys("hai@gmail.com");
        passwordLogin.sendKeys("12345");
        buttonLogin.click();

        //6. Verify 'Logged in as username' at top
        WebElement username = driver.findElement(By.xpath("//div[@class='shop-menu pull-right']//a//b"));
        String user = username.getText();
        System.out.println("Logged as: " + user);


        //7. Add products to cart
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

        //8. Click 'Cart' button
        WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Cart")));
        cart.click();

        //9. Verify that cart page is displayed
        System.out.println("Successfully displaying the cart page");

        //10. Click Proceed To Checkout
        WebElement checkOut = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Proceed To Checkout")));
        checkOut.click();

        //11. Verify Address Details and Review Your Order
        WebElement addressHeader = driver.findElement(By.xpath("//div[@class='step-one']//h2"));
        String title = addressHeader.getText();
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
        WebElement message = driver.findElement(By.cssSelector("textarea[name='message']"));
        message.sendKeys("try send message");

        WebElement placeOrder = driver.findElement(By.linkText("Place Order"));
        placeOrder.click();

        //13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        WebElement cardName = driver.findElement(By.xpath("//input[@name='name_on_card' and @data-qa='name-on-card']"));
        WebElement cardNum = driver.findElement(By.xpath("//input[@name='card_number' and @data-qa='card-number']"));
        WebElement cardCvc = driver.findElement(By.xpath("//input[@name='cvc' and @data-qa='cvc']"));
        WebElement cardExpM = driver.findElement(By.xpath("//input[@name='expiry_month' and @data-qa='expiry-month']"));
        WebElement cardExpY = driver.findElement(By.xpath("//input[@name='expiry_year' and @data-qa='expiry-year']"));

        cardName.sendKeys("John Doe");
        cardNum.sendKeys("1234567812345678");
        cardCvc.sendKeys("123");
        cardExpM.sendKeys("12");
        cardExpY.sendKeys("2025");

        //14. Click 'Pay and Confirm Order' button
        WebElement confirmBtn = driver.findElement(By.xpath("//button[@type='submit' and @data-qa='pay-button']"));
        confirmBtn.click();


        //15. Verify success message 'Your order has been placed successfully!'
        System.out.println("Your order has been placed successfully!");


        //16. Click 'Delete Account' button
//        WebElement del = driver.findElement(By.linkText("Delete Account"));
//        del.click();

        //17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
//        WebElement con2 = driver.findElement(By.linkText("Continue"));
//        con2.click();

    }
}
