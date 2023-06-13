package Bai5.Locator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginECommerce {
    public static void main(String[] args) throws InterruptedException {

        //Khởi tạo browser với Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Mở trang eCommerce
        driver.get("https://demo.activeitzone.com/ecommerce/login");
        Thread.sleep(1000);

        //tìm Locator email theo ID
        //điền email, sendKeys: điền email vào
        driver.findElement(By.id("email")).sendKeys("admin@example.com");

        //điền Password - Tìm Locator theo ID với By.name()
        driver.findElement(By.name("password")).sendKeys("123456");

        //By.link Test - Click link Forgot Password
        driver.findElement(By.linkText("Forgot password ?")).click();

        Thread.sleep(2000);


        //Tắt browser
        driver.quit();
    }
}
