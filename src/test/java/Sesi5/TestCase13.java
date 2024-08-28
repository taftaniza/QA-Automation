//Verify Product quantity in cart

package Sesi5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestCase13 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\tafta\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String baseUrl = "https://automationexercise.com/";
        driver.get(baseUrl);

        // Verify that home page is visible successfully
        System.out.println("Homepage is visible successfuly");

        WebElement viewProd = driver.findElement(By.xpath("//a[@href='/product_details/1']"));
        viewProd.click();

        //Increase quantity to 4
        WebElement inc_qty = driver.findElement(By.xpath("//input[@type='number' and @name='quantity']"));
        inc_qty.clear(); //have to clear first bcs the field has a value that already set to '1'
        inc_qty.sendKeys("4");

        //Click 'Add to cart' button
        WebElement cart_btn = driver.findElement(By.xpath("//button[@type='button' and @class='btn btn-default cart']"));
        cart_btn.click();

        //Click 'View Cart' button
        WebElement viewCart = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("View Cart")));
        viewCart.click();

        //Verify that product is displayed in cart page with exact quantity
        WebElement product= driver.findElement(By.xpath("//td[@class='cart_description']//h4"));
        WebElement qty= driver.findElement(By.xpath("//td[@class='cart_quantity']//button"));
        String prod_name = product.getText();
        String qty_prod = qty.getText();
        System.out.println("Product : " + prod_name);
        System.out.println("Quantity : " + qty_prod);








    }
}
