//Verify Test Cases Page

package Sesi5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase7 {

    WebDriver driver;

    @BeforeClass
            public void beforeClass(){
        driver = new ChromeDriver();
        String baseUrl = "https://automationexercise.com/";
        driver.get(baseUrl);
    }

    @Test(priority = 1)
    public void testCase(){
        driver.findElement(By.linkText("Test Cases")).click();

        System.out.println("Navigated to test cases page successfully");
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
