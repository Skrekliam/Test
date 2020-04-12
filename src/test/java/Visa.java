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

public class Visa {

    WebDriver driver;

    @BeforeTest
    public void beforeTest() {

        System.setProperty("webdriver.chrome.driver", "D:/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.phptravels.net/home");

    }

    @Test
    @Description("This test verify that visa booking result page open")
    public void testVisaBooking(){

        String fromCountry = "Pakistan";
        String toCountry = "Turkey";
        String firstName = "Volodya";
        String lastName = "Voronovsky";
        String mail = "danylo.voronovsky@gmail.com";
        String number = "380638480806";
        String expectedResult = "Visa Submitted";

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.add(Calendar.MONTH,1);
        Date currentDatePlusOneMonth = calendar.getTime();

        String visaDate = dateFormat.format(currentDatePlusOneMonth);

        driver.findElement(By.xpath("//*[@href='#visa']")).click();

        driver.findElement(By.xpath("//*[@class='chosen-single']/span[contains(text(),'Antigua and Barbuda')]")).click();
        driver.switchTo().activeElement().sendKeys(fromCountry);
        driver.findElement(By.xpath("//*[@class='active-result highlighted']")).click();

        driver.findElement(By.xpath("//*[@class='chosen-single']/span[contains(text(),'United Arab Emirates')]")).click();
        driver.switchTo().activeElement().sendKeys(toCountry);
        driver.findElement(By.xpath("//*[@class='active-result highlighted']")).click();

        driver.findElement(By.xpath("//*[@placeholder = 'Date']")).click();
        driver.switchTo().activeElement().sendKeys(visaDate);

        driver.findElement(By.xpath("//div[@class='hero-form-absolute']")).click();
        driver.findElement(By.xpath("//*[@class='col-md-2 col-xs-12']/button[contains(text(),'Submit')]")).click();

        driver.findElement(By.xpath("//*[@class='form-group']/label/span[contains(text(),'First Name')]")).click();
        driver.switchTo().activeElement().sendKeys(firstName);

        driver.findElement(By.xpath("//*[@class='col-md-6 col-12']/label/span[contains(text(),'Last Name')]")).click();
        driver.switchTo().activeElement().sendKeys(lastName);

        driver.findElement(By.xpath("//span[contains(text(),'Email ')]")).click();
        driver.switchTo().activeElement().sendKeys(mail);

        driver.findElement(By.xpath("//span[contains(text(),'Confirm Email')]")).click();
        driver.switchTo().activeElement().sendKeys(mail);

        driver.findElement(By.id("sub")).click();
        driver.switchTo().activeElement().sendKeys(number);

        driver.findElement(By.id("sub")).click();

        String actual = driver.findElement(By.xpath("//*[@class='wow fadeIn']/strong")).getText();
        Assert.assertEquals(actual,expectedResult);

    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
