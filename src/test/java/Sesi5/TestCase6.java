//Contact Us From
package Sesi5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase6 {

    WebDriver driver;

    @BeforeClass
            public void setUp() {
        driver = new ChromeDriver();
        String baseUrl="https://automationexercise.com/";
        driver.get(baseUrl);

    }

    @Test(priority = 1)
    public void contactPage() {
        driver.findElement(By.linkText("Contact us")).click();
    }

    @Test(priority = 2)
    public void fillFrom() {
        //Fill Get In Touch Form:
        driver.findElement(By.xpath("//input[@name='name' and @data-qa='name']")).sendKeys("Rilakuma");
        driver.findElement(By.xpath("//input[@name='email' and @data-qa='email']")).sendKeys("rilakuma@gmail.com");
        driver.findElement(By.xpath("//input[@name='subject' and @data-qa='subject']")).sendKeys("Reach me ASAP");
        driver. findElement(By.id("message")).sendKeys("I hope you're doing well");

        WebElement uploadFile = driver. findElement(By.xpath("//input[@type='file']"));
        String file_path= "C:\\Users\\tafta\\Downloads\\Aphrodite Logo.png";
        uploadFile.sendKeys(file_path);

        driver.findElement(By.name("submit")).click();
    }

    @Test(priority = 3)
    public void alert() {
        driver.switchTo().alert().accept();
    }

    @AfterClass
    public void quit(){
        driver.findElement(By.linkText("Home")).click();
        driver.quit();
    }

}
