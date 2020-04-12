import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Hotel {

    WebDriver driver;


    @BeforeTest
    public void beforeTest() {

        System.setProperty("webdriver.chrome.driver", "D:/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.phptravels.net/home");

    }

    @Test
    @Description("This testcase verify that hotels result page open")
    public void testHotelSearch(){

        String destination = "Lviv";
        String expectedResult = "Hotels Lviv";

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.add(Calendar.MONTH,1);
        Date currentDatePlusOneMonth = calendar.getTime();

        calendar.add(Calendar.MONTH,1);
        Date currentDatePlusTwoMonth = calendar.getTime();

        String checkInDate = dateFormat.format(currentDatePlusOneMonth);
        String checkOutDate = dateFormat.format(currentDatePlusTwoMonth);

        driver.findElement(By.xpath("//a[@href='#hotels']")).click();
        driver.findElement(By.id("s2id_autogen1")).click();
        driver.findElement(By.xpath("//div[@id='select2-drop']/div/input")).sendKeys(destination);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//ul[@class='select2-result-sub']/li/div")).click();

        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("checkout")).clear();
        driver.findElement(By.id("checkout")).sendKeys(checkInDate);

        driver.findElement(By.id("checkin")).click();
        driver.findElement(By.id("checkin")).clear();
        driver.findElement(By.id("checkin")).sendKeys(checkOutDate);

        driver.findElement(By.xpath("//div[@class='hero-form-absolute']")).click();
        driver.findElement(By.xpath("//div[@class='col-md-2 col-xs-12']/button")).click();

        String actual = driver.findElement(By.xpath("//*[@class='heading-title']")).getText();
        Assert.assertEquals(actual,expectedResult);

    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

}
