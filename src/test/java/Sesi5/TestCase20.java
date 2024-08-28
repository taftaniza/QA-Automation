// Search Products and Verify Cart After Login
package Sesi5;

import org.checkerframework.checker.units.qual.A;
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

public class TestCase20 {
        WebDriver driver;
        WebDriverWait wait;
        Actions actions;

        @BeforeClass
                public void setUp() {
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            actions = new Actions(driver);

            //2. Navigate to url 'http://automationexercise.com'
            String baseURL = "https://automationexercise.com/";
            driver.get(baseURL);
            driver.manage().window().maximize();
        }

        @Test(priority = 1)
                public void goToProd() {

            //3. Click on 'Products' button
            driver.findElement(By.cssSelector("a[href='/products']")).click();

            //4. Verify user is navigated to ALL PRODUCTS page successfully
            System.out.println("Navigated to ALL PRODUCTS page successfully");
        }

        @Test(priority = 2)
                public void prodSearch() {
            //5. Enter product name in search input and click search button
            driver.findElement(By.cssSelector("input[name='search']")).sendKeys("Dress");

            driver.findElement(By.id("submit_search")).click();

            //6. Verify 'SEARCHED PRODUCTS' is visible
            System.out.println("Searched product is visible");

            //7. Verify all the products related to search are visible
            String prod = driver.findElement(By.cssSelector("input[name='search']")).getText();
            System.out.println("All the product related to " + prod + " is displayed");
        }

        @Test(priority = 3)
                public void addProd() {

        //8. Add those products to cart
        WebElement overlay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.product-overlay")));
        actions.moveToElement(overlay).perform();

        driver.findElement(By.xpath("//div[@class='overlay-content'] //a[@data-product-id='3']")).click();
        System.out.println("1 Product added successfully");

        //9. Click 'Cart' button and verify that products are visible in cart
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("View Cart"))).click();

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
    }

    @Test(priority = 4)
    public void login() {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("dots@gmail.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12345");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test(priority = 5)
            public void cart() {
        //11. Again, go to Cart page
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Cart"))).click();

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

    @AfterClass
    public void close(){
            driver.close();
    }
}
