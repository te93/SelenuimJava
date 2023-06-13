package Common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    //khởi tạo Browser
    public static void createDriver(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    //đóng browser
    public static void closeDriver() {
        sleep(2);
        driver.quit();
    }

    public static void sleep(double seconds) {
        try {
            Thread.sleep((long) (1000 * seconds)); //cụm Sleep phải là số nguyên
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }

    }
}
