//View & Cart Brand Products
package Sesi5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase19 {
    public static void main(String[] args) {

        //1. Launch browser
        System.setProperty("webdriver.chrome.driver","C:\\Users\\tafta\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //2. Navigate to url 'http://automationexercise.com'
        String baseURL = "https://automationexercise.com/";
        driver.get(baseURL);

        //


    }
}
