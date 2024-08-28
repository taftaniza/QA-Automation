//Verify Product quantity in cart

package Sesi5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase13 {

        WebDriver driver;
        WebDriverWait wait;

        @BeforeClass
                public void setUp() {
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.get("https://automationexercise.com/");
            driver.manage().window().maximize();
        }

        @Test(priority = 1)
            public void clickProduct() {
            // Verify that home page is visible successfully
            System.out.println("Homepage is visible successfuly");
            driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();
        }

        @Test(priority = 2)
            public void addQuantity() {
            //Increase quantity to 4
            WebElement inc_qty = driver.findElement(By.xpath("//input[@type='number' and @name='quantity']"));
            inc_qty.clear(); //have to clear first bcs the field has a value that already set to '1'
            inc_qty.sendKeys("4");

            //Click 'Add to cart' button
            driver.findElement(By.xpath("//button[@type='button' and @class='btn btn-default cart']")).click();

            //Click 'View Cart' button
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("View Cart"))).click();
        }

        @Test(priority = 3)
            public void cart(){
            //Verify that product is displayed in cart page with exact quantity
            String prod_name = driver.findElement(By.xpath("//td[@class='cart_description']//h4")).getText();
            String qty_prod = driver.findElement(By.xpath("//td[@class='cart_quantity']//button")).getText();
            System.out.println("Product : " + prod_name);
            System.out.println("Quantity : " + qty_prod);
        }

        @AfterClass
            public void tearDown() {
            driver.quit();
        }

}
