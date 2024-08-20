//View Category Products

package Sesi5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase18 {
    public static void main(String[] args) {

        //1. Launch browser
        System.setProperty("webdriver.chrome.driver","C:\\Users\\tafta\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //2. Navigate to url 'http://automationexercise.com'
        String baseURL = "https://automationexercise.com/";
        driver.get(baseURL);

        //3. Verify that categories are visible on left side bar
        System.out.println("Categories are visible on left side bar");


        //4. Click on 'Women' category
        WebElement women = driver.findElement(By.linkText("WOMEN"));
        women.click();


        //5. Click on any category link under 'Women' category, for example: Dress
        WebElement dress = driver.findElement(By.xpath("//a[@href='/category_products/2']"));
        dress.click();

        //6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
        WebElement displaying = driver.findElement(By.xpath("//div[@class='features_items']//h2"));
        String dsp = displaying.getText();
        System.out.println("Selected Category: "+ dsp);

        //7. On left side bar, click on any sub-category link of 'Men' category
        WebElement men = driver.findElement(By.linkText("MEN"));
        men.click();
        WebElement menSub = driver.findElement(By.xpath("//a[@href='/category_products/3']"));
        menSub.click();


        //8. Verify that user is navigated to that category page
        WebElement displaying2 = driver.findElement(By.xpath("//div[@class='features_items']//h2"));
        String dsp2 = displaying2.getText();
        System.out.println("Selected Category: "+ dsp2);

    }
}
