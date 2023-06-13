package Bai7_WebDriver;

import Common.BaseTest;
import org.openqa.selenium.By;

public class BasicBrower extends BaseTest {

    public static void main(String[] args) {
        createDriver();

        driver.navigate().to("http://anhtester.com");
        sleep(2);

        driver.findElement(By.id("btn-login")).click();
        //điều hướng về lịch sử trang trước đó
        driver.navigate().back();
        sleep(1);

        //làm mới trang hiện tại
        driver.navigate().refresh();
        sleep(1);

        //điều hướng đến trang tiếp sau
        driver.navigate().forward();
        sleep(1);

        closeDriver();
    }
}
