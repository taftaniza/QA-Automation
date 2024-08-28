//Place Order: Register while checkout
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

public class TestCase14 {

    public static void main(String[] args) {

        //1. Launch browser
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tafta\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // 2. Navigate to url 'http://automationexercise.com'
        String baseUrl = "https://automationexercise.com/";
        driver.get(baseUrl);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adding WebDriverWait
        Actions actions = new Actions(driver); // Create an instance of the Actions class

        // 3. Verify that home page is visible successfully
        System.out.println("Homepage is visible successfully");


        //4. Add products to cart
        //Go to Products menu first:
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
        WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Cart")));
        cart.click();

        //6. Verify that cart page is displayed
        System.out.println("Successfully displaying the cart page");

        //7. Click Proceed To Checkout
        WebElement checkOut = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Proceed To Checkout")));
        checkOut.click();

        //8. Click 'Register / Login' button
        WebElement regLog = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Register / Login")));
        regLog.click();

        //9. Fill all details in Signup and create account
        //i)Fill Signup
        WebElement name = driver.findElement(By.cssSelector("input[name='name'"));
        name.sendKeys("melati");
        WebElement emailSignup = driver.findElement(By.xpath("//input[@name='email' and @data-qa='signup-email']"));
        emailSignup.sendKeys("melati@gmail.com");

        WebElement buttonSignup = driver.findElement(By.xpath("//button[@type='submit' and @data-qa='signup-button']"));
        buttonSignup.click();

        WebElement mrsRadioButton = driver.findElement(By.id("uniform-id_gender2"));
        mrsRadioButton.click();

        WebElement passSignup = driver.findElement(By.xpath("//input[@id='password' and @data-qa='password']"));
        passSignup.sendKeys("12345");

        //Address Information Section:
        WebElement fName = driver.findElement(By.id("first_name"));
        fName.sendKeys("John");
        WebElement lName = driver.findElement(By.id("last_name"));
        lName.sendKeys("Smith");
        WebElement Company = driver.findElement(By.id("company"));
        Company.sendKeys("Aksata");

        WebElement address = driver.findElement(By.id("address1"));
        address.sendKeys("123 Main St");

        WebElement country = driver.findElement(By.id("country"));
        country.sendKeys("Indonesia");

        WebElement state = driver.findElement(By.id("state"));
        state.sendKeys("Residence");

        WebElement city = driver.findElement(By.id("city"));
        city.sendKeys("Jakarta");

        WebElement zipCode = driver.findElement(By.id("zipcode"));
        zipCode.sendKeys("1233");

        WebElement phone = driver.findElement(By.id("mobile_number"));
        phone.sendKeys("081234");

        WebElement buttonCreate = driver.findElement(By.xpath("//button[@type='submit' and @data-qa='create-account']"));
        buttonCreate.click();


        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        WebElement con = driver.findElement(By.linkText("Continue"));
        con.click();
        System.out.println("ACCOUNT CREATED, Successfully!");


        //11. Verify ' Logged in as username' at top
        WebElement username= driver.findElement(By.xpath("//div[@class='shop-menu pull-right']//a//b"));
        String user = username.getText();
        System.out.println("Logged as : " + user);


        //12.Click 'Cart' button
        WebElement cartCheck = driver.findElement(By.linkText("Cart"));
        cartCheck.click();

        //13. Click 'Proceed To Checkout' button
        WebElement checkOut2 = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Proceed To Checkout")));
        checkOut2.click();

        //14. Verify Address Details and Review Your Order
        WebElement addrress= driver.findElement(By.xpath("//div[@class='step-one']//h2"));
        String title = addrress.getText();
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
        WebElement message = driver.findElement(By.xpath("//input[@name='message']"));
        message.sendKeys("try send message");

        WebElement placeOrder = driver.findElement(By.xpath("//a[@href='/payment']"));
        placeOrder.click();

        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        WebElement cardName = driver.findElement(By.xpath("//input[@name='name_on_card' and @data-qa='name-on-card']"));
        WebElement cardNum = driver.findElement(By.xpath("//input[@name='card_number' and @data-qa='card-number']"));
        WebElement cardCvc = driver.findElement(By.xpath("//input[@name='cvc' and @data-qa='cvc']"));
        WebElement cardExpM = driver.findElement(By.xpath("//input[@name='expiry_month' and @data-qa='expiry-month']"));
        WebElement cardExpY = driver.findElement(By.xpath("//input[@name='expiry_year' and @data-qa='expiry-year']"));

        cardName.sendKeys();
        cardNum.sendKeys();
        cardCvc.sendKeys();
        cardExpM.sendKeys();
        cardExpY.sendKeys();

        //17. Click 'Pay and Confirm Order' button
        WebElement confirmBtn = driver.findElement(By.xpath("//button[@type='submit' and @data-qa='pay-button']"));
        confirmBtn.click();

        //18. Verify success message 'Your order has been placed successfully!'
        System.out.println("Your order has been placed successfully!");

//        //19. Click 'Delete Account' button
//        WebElement del = driver.findElement(By.linkText("Delete Account"));
//        del.click();
//
//        //20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
//        WebElement con2 = driver.findElement(By.linkText("Continue"));
//        con2.click();


    }
}
