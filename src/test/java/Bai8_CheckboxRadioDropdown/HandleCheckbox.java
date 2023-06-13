package Bai8_CheckboxRadioDropdown;

import Common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HandleCheckbox extends BaseTest {
    public static void main(String[] args) {
        createDriver();
        driver.get("https://demo.seleniumeasy.com/basic-checkbox-demo.html");

        WebElement checkboxDone = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
        boolean checkBoxBefore = checkboxDone.isSelected();

        System.out.println(checkBoxBefore);

        //nếu checkbox chưa chọn (false) thì click chọn
        if (checkBoxBefore == false){
            checkboxDone.click();
        }

        //kiểm tra lại kq sau khi click chọn
        sleep(1);
        boolean checkBoxAfter = checkboxDone.isSelected();
        System.out.println(checkBoxAfter);

        //check trên UI: kiểm tra check box mặc định, thông báo liên quan với kq khi đã chọn
        sleep(1);
        WebElement message = driver.findElement(By.xpath("//div[@id='txtAge']"));
        System.out.println(message.isDisplayed());
        System.out.println(message.getText()); //lấy Text khi thẻ HTML chứa Text

        closeDriver();
    }
}
