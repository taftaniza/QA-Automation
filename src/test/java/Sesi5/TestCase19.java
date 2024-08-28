//View & Cart Brand Products
package Sesi5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestCase19 {
    public static void main(String[] args) {

        //1. Launch browser
        System.setProperty("webdriver.chrome.driver","C:\\Users\\tafta\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //2. Navigate to url 'http://automationexercise.com'
        String baseURL = "https://automationexercise.com/";
        driver.get(baseURL);

        //3. Click on 'Products' button
        WebElement products = driver.findElement(By.cssSelector("a[href='/products']"));
        products.click();


        //4. Verify that Brands are visible on left side bar
        System.out.println("Categories are visible on left side bar");


        //5. Click on any brand name
        WebElement brand = driver.findElement(By.xpath("//div[@class='brands_products'] //a[@href='/brand_products/Polo']"));
        brand.click();

        //6. Verify that user is navigated to brand page and brand products are displayed
        WebElement brandDsp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[@class='title text-center']")));
        String brandDspText = brandDsp.getText();
        System.out.println("Showing brand: "+brandDspText);


        //7. On left side bar, click on any other brand link
        WebElement brand2 = driver.findElement(By.xpath("//div[@class='brands_products'] //a[@href='/brand_products/Madame']"));
        brand2.click();

        //8. Verify that user is navigated to that brand page and can see products
        WebElement brandDsp2 = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        String brandDspText2 = brandDsp2.getText();
        System.out.println("Showing brand: "+brandDspText2);


    }
}
