package Bai7_WebDriver;

import Common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.swing.table.TableRowSorter;
import java.util.List;

public class ListWebElement extends BaseTest {

    public static void main(String[] args) throws InterruptedException {
        createDriver();
        driver.get("https://app.hrsale.com/");

        //login
        driver.findElement(By.xpath("//button[normalize-space()='Super Admin']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        Thread.sleep(9000);

        List<WebElement> listMenu = driver.findElements(By.xpath("//ul[@class='pc-navbar']/li"));

        System.out.println(listMenu.get(3).getText());
        listMenu.get(3).click();

        //duyệt list
//        for (int i=0; i<listMenu.size(); i++){
//            //get(i): lấy ra vị trí 1 phần tử trong List
//            //getText(): laf hàm của WebElement
//            System.out.println(listMenu.get(i).getText());
//        }

        closeDriver();
    }



}
