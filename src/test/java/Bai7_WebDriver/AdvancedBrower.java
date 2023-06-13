package Bai7_WebDriver;

import Common.BaseTest;
import org.openqa.selenium.WindowType;

public class AdvancedBrower extends BaseTest {
    public static void main(String[] args) {
        createDriver();
        driver.get("https://anhtester.com");

        //mở thêm 1 tab mới
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://google.com");


        closeDriver();
    }
}
