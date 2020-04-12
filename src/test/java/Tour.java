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

public class Tour {

    WebDriver driver;

    @BeforeTest
    public void beforeTest() {

        System.setProperty("webdriver.chrome.driver", "D:/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.phptravels.net/home");

    }

    @Test
    @Description("This testcase verify that tours result page open")
    public void testToursSearch(){

        String destination = "Kiev";
        String expectedResult = "Kiev";

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.add(Calendar.MONTH,1);
        Date currentDatePlusOneMonth = calendar.getTime();

        calendar.add(Calendar.MONTH,1);
        Date currentDatePlusTwoMonth = calendar.getTime();

        String fromDate = dateFormat.format(currentDatePlusOneMonth);
        String toDate = dateFormat.format(currentDatePlusTwoMonth);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@href='#tours']")).click();
        driver.findElement(By.id("s2id_textsearch")).click();
        driver.switchTo().activeElement().sendKeys(destination);
        driver.findElement(By.xpath("//*[@class='select2-match']")).click();

        driver.findElement(By.id("EndDateTours")).click();
        driver.switchTo().activeElement().sendKeys(toDate);

        driver.findElement(By.id("DateTours")).click();
        driver.switchTo().activeElement().sendKeys(fromDate);

        driver.findElement(By.xpath("//div[@class='hero-form-absolute']")).click();
        driver.findElement(By.xpath("//div[@class='col-md-3 col-xs-12']/button")).click();

        String actual = driver.findElement(By.xpath("//*[@class='text-primary']")).getText();
        Assert.assertEquals(actual,expectedResult);

    }


    @AfterTest
    public void afterTest() {
        driver.quit();
    }

}
