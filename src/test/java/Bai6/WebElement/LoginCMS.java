package Bai6.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginCMS {
    public static void main(String[] args) throws InterruptedException {

        //khởi tạo browser với chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //login CMS
        driver.get("https://cms.anhtester.com/login");

        //bắt cái WebElement Email (object)
        //tìm 1 Element => findElement; tìm 2 Element => findElements (lưu trong 1 list)
        WebElement inputEmail = driver.findElement(By.id("email"));

        //thực hiện thao tác điền giá trị
        inputEmail.sendKeys("admin@example.com");

       // Thread.sleep(2000);
        //xóa ô text
        //inputEmail.clear();

        //c2: dùng trực tiếp
        driver.findElement(By.id("password")).sendKeys("123456");

        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        //isDisplayed
//        WebElement btnCopy = driver.findElement(By.xpath("//button[normalize-space()='Copy']"));
//        System.out.println("Trạng thái nút Copy:" + btnCopy.isDisplayed());
//
//
//        //Lấy text
//        WebElement tieude = driver.findElement(By.xpath("//div[@class='card-body']//h1"));
//        System.out.println(tieude.getText());
//
//        //nếu nút button Copy hiện thì click vào nút Login button
//        if (btnCopy.isDisplayed() == true){
//            driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
//        }



        //driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        Thread.sleep(2000); // chạy trong 2 giây

        //tắt browser
        driver.quit();
    }
}
