//Register User and Delete it

package Sesi5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestCase1 {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // Maximize browser window
        driver.get("https://automationexercise.com/");
    }

    @Test (priority = 1)
    public void loginInput() {
        // Get the Web Element corresponding to the Signup/Login page:
        driver.findElement(By.linkText("Signup / Login")).click();

    }

    @Test(priority = 2)
            public void signUp() {

        // Fill Signup
        driver.findElement(By.cssSelector("input[name='name']")).sendKeys("Melati");
        driver.findElement(By.xpath("//input[@name='email' and @data-qa='signup-email']")).sendKeys("melati@gmail.com");
        driver.findElement(By.xpath("//button[@type='submit' and @data-qa='signup-button']")).click();

    }


    @Test(priority = 3)
    public void fillForm() {

        driver.findElement(By.cssSelector("div#uniform-id_gender2")).click();
        driver.findElement(By.xpath("//input[@id='password' and @data-qa='password']")).sendKeys("12345");

        driver.findElement(By.id("days")).sendKeys("29");

        driver.findElement(By.id("months")).sendKeys("August");
        driver.findElement(By.id("years")).sendKeys("2003");

        // Check the checkbox
        WebElement newsletterCheckbox = driver.findElement(By.name("newsletter"));
        if (!newsletterCheckbox.isSelected()) {
            newsletterCheckbox.click();
        }

        WebElement offersCheckbox = driver.findElement(By.name("optin"));
        if (!offersCheckbox.isSelected()) {
            offersCheckbox.click();
        }

        //Address Information Section:
        driver.findElement(By.id("first_name")).sendKeys("John");
        driver.findElement(By.id("last_name")).sendKeys("Smith");
        driver.findElement(By.id("company")).sendKeys("Aksata");

        driver.findElement(By.id("address1")).sendKeys("123 Main St");
        driver.findElement(By.id("country")).sendKeys("Indonesia");

        driver.findElement(By.id("state")).sendKeys("Residance");
        driver.findElement(By.id("city")).sendKeys("Jakarta");
        driver.findElement(By.id("zipcode")).sendKeys("1233");
        driver.findElement(By.id("mobile_number")).sendKeys("081234");
        driver.findElement(By.xpath("//button[@type='submit' and @data-qa='create-account']")).click();

        //Account created, next page:
        WebElement con = driver.findElement(By.linkText("Continue"));
        con.click();

        System.out.println("Account is created");
    }

    @Test(priority = 4)
    public void deleteAcc() {
        // Delete Account:
        driver.findElement(By.linkText("Delete Account")).click();
        driver.findElement(By.linkText("Continue")).click();

        System.out.println("Account is deleted");
    }

    @AfterClass
    public void close() {
        driver.quit();
    }
    }





