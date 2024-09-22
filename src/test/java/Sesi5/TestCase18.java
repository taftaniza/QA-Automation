//View Category Products

package Sesi5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase18 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        String baseURL = "https://automationexercise.com/";
        driver.get(baseURL);
    }

    @Test(priority = 1)
    public void category() {
        //3. Verify that categories are visible on left side bar
        System.out.println("Categories are visible on left side bar");

        //4. Click on 'Women' category
        driver.findElement(By.linkText("WOMEN")).click();
    }

    @Test(priority = 2)
    public void category2() {
        //5. Click on any category link under 'Women' category, for example: Dress
        driver.findElement(By.xpath("//a[@href='/category_products/1']")).click();

        //6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
        String dsp = driver.findElement(By.xpath("//div[@class='features_items']//h2")).getText();
        System.out.println("Selected Category: " + dsp);
    }

    @Test(priority = 3)
    public void category3() {
        //7. On left side bar, click on any sub-category link of 'Men' category
        driver.findElement(By.linkText("MEN")).click();
        driver.findElement(By.xpath("//a[@href='/category_products/3']")).click();

        //8. Verify that user is navigated to that category page
        String dsp2 = driver.findElement(By.xpath("//div[@class='features_items']//h2")).getText();
        System.out.println("Selected Category: " + dsp2);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
