package B22_ThucHanh.AddClientCRM;

import Common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.security.Key;

public class ClientCRM extends BaseTest {

    //vì hàm để static nên cần sử dụng static để gọi hàm, hoặc là khởi tạo đối tượng để sử dụng gọi hàm
    public static void SigninCRM(){
        driver.get("https://rise.fairsketch.com/signin");
        //clear ô mặc định r mới điền
        driver.findElement(By.xpath("//input[@id='email']")).clear();
        driver.findElement(By.xpath("//input[@id='password']")).clear();
        sleep(1);

        //login
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@demo.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("riseDemo");
        driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
    }

    //Open Client page
    public static void OpenClientPage(){
        sleep(2);
        driver.findElement(By.xpath("//span[normalize-space()='Clients']")).click();
        sleep(2);
        //driver.findElement(By.xpath("//a[contains(text(),'Clients')]")).click();
        driver.findElement(By.xpath("//div[@id='page-content']//a[normalize-space()='Clients']")).click();
        sleep(1);
    }

    //Enter Data on Add New Client dialog
    public static void enterDataAddClient(String clientName){
        driver.findElement(By.xpath("//a[normalize-space()='Add client']")).click();
        sleep(2);

        //enter information
        driver.findElement(By.xpath("//input[@id='company_name']")).sendKeys(clientName);
        driver.findElement(By.xpath("//div[@id='s2id_created_by']//a")).click(); //vì đây là DropdownDynamic
        sleep(1);
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("Sara Ann", Keys.ENTER);
        driver.findElement(By.id("address")).sendKeys("Hà Nội");
        driver.findElement(By.id("city")).sendKeys("Hà Nội");
        driver.findElement(By.id("state")).sendKeys("Phía Bắc");
        driver.findElement(By.id("zip")).sendKeys("81000");
        driver.findElement(By.id("country")).sendKeys("Việt Nam");
        driver.findElement(By.id("phone")).sendKeys("09506569666");
        driver.findElement(By.id("website")).sendKeys("https://anhtester.com");

        //cuộn chuột đến Element VAT Number (vì nó bị che)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView(false);",driver.findElement(By.id("vat_number"))); //cuộn và trỏ đên var number

        //cuộn và trỏ đến cuối để thấy được các Element bị che
        js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//label[normalize-space()='Disable online payment']")));

        driver.findElement(By.id("vat_number")).sendKeys("0");

        //input tag dropdown
        driver.findElement(By.xpath("//div[@id='s2id_group_ids']")).click();
        driver.findElement(By.xpath("//div[@id='s2id_group_ids']//input")).sendKeys("VIP", Keys.ENTER);

        //nhấn nút Save
        sleep(1);
        driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();


    }

    //search giá trị vừa thêm mới - Search Client after Added
    public static void checkClientAfterAdded(String clientName){
        sleep(2);
        driver.findElement(By.xpath("//div[@id='client-table_filter']//input")).sendKeys(clientName);
        sleep(2);
        //kiểm tra dữ liệu
        String clientNameInTable = driver.findElement(By.xpath("//table[@id='client-table']//tbody//tr[1]//td[2]")).getText();
        System.out.println(clientNameInTable);
    }

    //kiểm tra thông tin sau khi search
    public static void main(String[] args) {
        createDriver();
        SigninCRM();//gọi hàm bên trên
        OpenClientPage();
        enterDataAddClient("ThoeHee");
        checkClientAfterAdded("ThoeHee");


        closeDriver();
    }
}
