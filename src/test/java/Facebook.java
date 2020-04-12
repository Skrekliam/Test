import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Facebook {

    WebDriver driver;


    @BeforeTest
    public void beforeTest() {

        System.setProperty("webdriver.chrome.driver", "D:/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.phptravels.net/home");

    }

    @Test
    @Description("This test verify redirection to phptravel Facebook page")
    public void testRedirectionToFacebook(){

        String expectedResult = "PHPTRAVELS.COM";

        driver.findElement(By.xpath("//*[@class='fab fa-facebook']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String actual = driver.findElement(By.xpath("//*[@id='seo_h1_tag']/span")).getText();

        Assert.assertEquals(actual,expectedResult);

    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

}
