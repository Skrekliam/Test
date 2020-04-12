import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Flight {

    WebDriver driver;

    @BeforeTest
    public void beforeTest() {

        System.setProperty("webdriver.chrome.driver", "D:/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.phptravels.net/home");

    }

    @Test
    @Description("This testcase verify that flights result page open")
    public void testFlightSearch(){

        String from = "KRK";
        String to = "IEV";
        String expectedResult = "KRK to IEV";

        driver.findElement(By.xpath("//*[@href='#flights']")).click();

        driver.findElement(By.xpath("//*[@for='flightSearchRadio-2']")).click();
        driver.findElement(By.id("s2id_location_from")).click();
        driver.findElement(By.xpath("//*[@id='select2-drop']/div/input")).sendKeys(from);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@class='select2-result-label']")).click();

        driver.findElement(By.id("s2id_location_to")).click();
        driver.findElement(By.xpath("//*[@id='select2-drop']/div/input")).sendKeys(to);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//li[contains(@class,'select2-result-selectable')]")).click();
        driver.findElement(By.xpath("//*[@class='col-xs-12 col-md-12']/button")).click();

        String actual = driver.findElement(By.xpath("//*[@class='heading-title']")).getText();
        Assert.assertEquals(actual,expectedResult);

    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

}
