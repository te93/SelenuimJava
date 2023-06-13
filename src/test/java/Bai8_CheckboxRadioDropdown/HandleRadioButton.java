package Bai8_CheckboxRadioDropdown;

import Common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HandleRadioButton extends BaseTest {

    public static void main(String[] args) {
        createDriver();

        driver.get("https://demo.seleniumeasy.com/basic-radiobutton-demo.html");

        sleep(1);
        WebElement radioButton = driver.findElement(By.xpath("//div[normalize-space()='Radio Button Demo']/following-sibling::div/label[normalize-space()='Male']/input"));
        System.out.println(radioButton.isSelected());

        sleep(1);
        if (radioButton.isSelected() == false){
            radioButton.click();
        }

        System.out.println("Đã chọn true " + radioButton.isSelected());

        sleep(1);
        WebElement radio5to15 = driver.findElement(By.xpath("//h4[normalize-space()='Age Group :']/following-sibling::label[normalize-space()='5 to 15']/input"));
        radio5to15.click();
        System.out.println("Đã chọn 2 " + radio5to15.isSelected());

        WebElement radio0to10 = driver.findElement(By.xpath("//h4[normalize-space()='Age Group :']/following-sibling::label[normalize-space()='0 to 5']"));
        WebElement radio15to50 = driver.findElement(By.xpath("//h4[normalize-space()='Age Group :']/following-sibling::label[normalize-space()='15 to 50']"));

        System.out.println("Trạng thái 1 " + radio0to10.isSelected());
        System.out.println("Trạng thái 2 "+ radio15to50.isSelected());


        closeDriver();
    }
}
