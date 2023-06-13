package Bai8_DropdownList;

import Common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HandleDropdownListStatic extends BaseTest { //chạy DropdownList tĩnh
    public static void main(String[] args) {
        createDriver();

        driver.get("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");

        WebElement selectElement = driver.findElement(By.xpath("//select[@id='select-demo']"));
        //khởi tạo đối tượng select và giá trị là 1 WebElement của thẻ select trong HTML
        Select select = new Select(selectElement);
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("Kiểm tra kiểu của Select: " +select.isMultiple());
        System.out.println("Số lượng Option trong Select: " +select.getOptions().size());

        //get options với hàm hỗ trợ của class Select
        select.selectByVisibleText("Wednesday");
        sleep(1);
        System.out.println(select.getFirstSelectedOption().getText());

        select.selectByValue("Monday");
        sleep(1);
        System.out.println(select.getFirstSelectedOption().getText());

        select.selectByIndex(6);
        sleep(2);
        System.out.println(select.getFirstSelectedOption().getText());

        closeDriver();
    }
}
