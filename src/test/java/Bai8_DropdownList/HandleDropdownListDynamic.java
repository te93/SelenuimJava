package Bai8_DropdownList;

import Common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HandleDropdownListDynamic extends BaseTest {
    public static void main(String[] args) {
        createDriver();

        driver.get("https://techydevs.com/demos/themes/html/listhub-demo/listhub/index.html");
        sleep(2);

        //click vào dropdown Category
        sleep(1);
        driver.findElement(By.xpath("//span[normalize-space()='Select a Category']")).click();
        //search giá trị cần chọn
        sleep(1);
        driver.findElement(By.xpath("//span[normalize-space()='Select a Category']/parent::a/following-sibling::div/div/input")).sendKeys("Travel");
        //click chọn Text đã search (cần chọn)
        sleep(1);
        //driver.findElement(By.xpath("//li[@class='active-result highlighted']")).click();


        //sử dụng hàm Enter
        Actions actions = new Actions(driver); //khởi tạo đối tượng Actions
        actions.sendKeys(Keys.ENTER).perform(); //sendKeys: điền vào lệnh Enter, ham perform: xác nhận
        //Cách ENTER dùng cho TH chỉ hiển thị 1 giá trị lựa chọn



        sleep(2);
        closeDriver();
    }
}
