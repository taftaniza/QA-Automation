package Sesi4;//Sesi4

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SeleniumTest {
    public static void main(String[] args) {
        // Set the path to the chromedriver executable
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\tafta\\chromedriver-win64\\chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // 1. Open the website
            driver.get("https://demoblaze.com/");

            // 2. Navigate to the "Laptops" category
            driver.findElement(By.linkText("Laptops")).click();

            // 3. Select the first laptop listed in the category
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement firstLaptop = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".card-title a")));
            String laptopName = firstLaptop.getText();
            firstLaptop.click();

            // 4. Click on the "Add to cart" button using its class and onclick attributes
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.btn.btn-success[onclick^='addToCart']"))).click();

            // 5. Handle the alert by accepting it
            wait.until(ExpectedConditions.alertIsPresent()).accept();

            // 6. Navigate to the "Cart" page
            driver.findElement(By.id("cartur")).click();

            // 7. Validate that the added laptop appears in the cart
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(), '" + laptopName + "')]")));

            // 8. Ensure the test checks for the presence of the product name in the cart items
            WebElement cartItem = driver.findElement(By.xpath("//td[contains(text(), '" + laptopName + "')]"));
            if (cartItem.isDisplayed()) {
                System.out.println("Test Passed: Laptop is in the cart");
            } else {
                System.out.println("Test Failed: Laptop is not in the cart");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 9. Close the browser window
            driver.quit();
        }
    }
}

