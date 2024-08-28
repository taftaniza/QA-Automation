// Search Products and Verify Cart After Login
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

public class TestCase20 {

    public static void main(String[] args) {

        //1. Launch browser
        System.setProperty("webdriver.chrome.driver","C:\\Users\\tafta\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        //2. Navigate to url 'http://automationexercise.com'
        String baseURL = "https://automationexercise.com/";
        driver.get(baseURL);

        //3. Click on 'Products' button
        WebElement products = driver.findElement(By.cssSelector("a[href='/products']"));
        products.click();

        //4. Verify user is navigated to ALL PRODUCTS page successfully
        System.out.println("Navigated to ALL PRODUCTS page successfully");


        //5. Enter product name in search input and click search button
        WebElement inputProd = driver.findElement(By.cssSelector("input[name='search']"));
        inputProd.sendKeys("Dress");

        WebElement searchBtn = driver.findElement(By.id("submit_search"));
        searchBtn.click();

        //6. Verify 'SEARCHED PRODUCTS' is visible
        System.out.println("Searched product is visible");

        //7. Verify all the products related to search are visible
        WebElement product = driver.findElement(By.cssSelector("input[name='search']"));
        String prod = product.getText();
        System.out.println("All the product related to "+prod+" is displayed");


        //8. Add those products to cart
        WebElement overlay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.product-overlay")));
        actions.moveToElement(overlay).perform();

        WebElement addProd = driver.findElement(By.xpath("//div[@class='overlay-content'] //a[@data-product-id='3']"));
        addProd.click();

        System.out.println("1 Product added successfully");

        //9. Click 'Cart' button and verify that products are visible in cart
        WebElement viewCart = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("View Cart")));
        viewCart.click();

        System.out.println("Current product:");

        WebElement cart = driver.findElement(By.id("cart_info_table"));

        List<WebElement> cartDetails = cart.findElements(By.tagName("tbody"));

        System.out.println("Cart:");
        // Loop through and print each detail
        for (WebElement detail : cartDetails) {
            System.out.println(detail.getText());
        }
        //10. Click 'Signup / Login' button and submit login details
        WebElement login = driver.findElement(By.linkText("Signup / Login"));
        login.click();

        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
        WebElement passwordLogin = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement buttonLogin = driver.findElement(By.xpath("//button[@type='submit']"));

        email.sendKeys("hai@gmail.com");
        passwordLogin.sendKeys("12345");
        buttonLogin.click();

        //11. Again, go to Cart page
        WebElement cartbtn = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Cart")));
        cartbtn.click();

        //12. Verify that those products are visible in cart after login as well
        System.out.println("Products are visible in cart after login");

        WebElement cart2 = driver.findElement(By.id("cart_info_table"));

        List<WebElement> cartDetails2 = cart2.findElements(By.tagName("tbody"));

        System.out.println("Cart:");
        // Loop through and print each detail
        for (WebElement detail : cartDetails2) {
            System.out.println(detail.getText());
        }
    }
}
