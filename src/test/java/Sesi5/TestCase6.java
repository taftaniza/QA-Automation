//Contact Us From
package Sesi5;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase6 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        String baseUrl="https://automationexercise.com/";
        driver.get(baseUrl);

        WebElement contact = driver.findElement(By.linkText("Contact us"));
        contact.click();

        //Fill Get In Touch Form:
        WebElement name = driver. findElement(By.xpath("//input[@name='name' and @data-qa='name']"));
        name.sendKeys("Rilakuma");

        WebElement email = driver. findElement(By.xpath("//input[@name='email' and @data-qa='email']"));
        email.sendKeys("rilakuma@gmail.com");

        WebElement subject = driver.findElement(By.xpath("//input[@name='subject' and @data-qa='subject']"));
        subject.sendKeys("Reach me ASAP");

        WebElement texts = driver. findElement(By.id("message"));
        texts.sendKeys("I hope you're doing well");

        WebElement uploadFile = driver. findElement(By.xpath("//input[@type='file']"));
        String file_path= "C:\\Users\\tafta\\Downloads\\Aphrodite Logo.png";
        uploadFile.sendKeys(file_path);

        WebElement buttonSub = driver.findElement(By.name("submit"));
        buttonSub.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement btn_home = driver.findElement(By.linkText("Home"));
        btn_home.click();





    }
}
