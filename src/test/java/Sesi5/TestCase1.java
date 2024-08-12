package Sesi5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestCase1 {

    public static void main(String[] args) {

        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tafta\\chromedriver-win64\\chromedriver.exe");

        // Declaration and instantiation of objects/variable ChromeDriver
        WebDriver driver = new ChromeDriver();
        String baseUrl= "https://automationexercise.com/";
        driver.get(baseUrl);

        // Get the Web Element corresponding to the Signup/Login page:
        WebElement login = driver.findElement(By.linkText("Signup / Login"));
        login.click();


        // Fill Signup
        WebElement name = driver.findElement(By.cssSelector("input[name='name'"));
        name.sendKeys("Hai");
        WebElement emailSignup = driver.findElement(By.xpath("//input[@name='email' and @data-qa='signup-email']"));
        emailSignup.sendKeys("hai@gmail.com");

        WebElement buttonSignup = driver.findElement(By.xpath("//button[@type='submit' and @data-qa='signup-button']"));
        buttonSignup.click();


        //Account Information:
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement mrsRadioButton = driver.findElement(By.id("uniform-id_gender2"));
        mrsRadioButton.click();

        WebElement passSignup = driver.findElement(By.xpath("//input[@id='password' and @data-qa='password']"));
        passSignup.sendKeys("12345");

        WebElement day = driver.findElement(By.id("days"));
        day.sendKeys("29");

        WebElement month = driver.findElement(By.id("months"));
        month.sendKeys("August");

        WebElement year = driver.findElement(By.id("years"));
        year.sendKeys("2003");

        //Address Information Section:
        WebElement fName = driver.findElement(By.id("first_name"));
        fName.sendKeys("John");
        WebElement lName = driver.findElement(By.id("last_name"));
        lName.sendKeys("Smith");
        WebElement Company = driver.findElement(By.id("company"));
        Company.sendKeys("Aksta");

        WebElement address = driver.findElement(By.id("address1"));
        address.sendKeys("123 Main St");

        WebElement country = driver.findElement(By.id("country"));
        country.sendKeys("Indonesia");

        WebElement state = driver.findElement(By.id("state"));
        state.sendKeys("Residance");

        WebElement city = driver.findElement(By.id("city"));
        city.sendKeys("Jakarta");

        WebElement zipCode = driver.findElement(By.id("zipcode"));
        zipCode.sendKeys("1233");

        WebElement phone = driver.findElement(By.id("mobile_number"));
        phone.sendKeys("081234");

        WebElement buttonCreate = driver.findElement(By.xpath("//button[@type='submit' and @data-qa='create-account']"));
        buttonCreate.click();

        //Account created, next page:
        WebElement con = driver.findElement(By.linkText("Continue"));
        con.click();

        // Delete Account:
        WebElement del = driver.findElement(By.linkText("Delete Account"));
        del.click();
        WebElement con2 = driver.findElement(By.linkText("Continue"));
        con2.click();


        System.out.println("Test login page");


        driver.quit();


    }

}
