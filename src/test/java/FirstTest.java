import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirstTest {

    WebDriver driver;


    @BeforeTest
    public void beforeMet() {
        System.setProperty("webdriver.chrome.driver", "D:/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.phptravels.net/home");
    }


    @Test
    public void firstTest(){

        driver.findElement(By.xpath("//a[@href='#hotels']")).click();
        driver.findElement(By.xpath("//div[@id='s2id_autogen1']")).click();
        driver.findElement(By.xpath("//div[@id='select2-drop']/div/input")).sendKeys("Lviv");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//ul[@class='select2-result-sub']/li/div")).click();

        driver.findElement(By.xpath("//input[@id='checkout']")).click();
        driver.findElement(By.xpath("//input[@id='checkout']")).clear();
        driver.findElement(By.xpath("//input[@id='checkout']")).sendKeys("27/07/2020");

        driver.findElement(By.xpath("//input[@id='checkin']")).click();
        driver.findElement(By.xpath("//input[@id='checkin']")).clear();
        driver.findElement(By.xpath("//input[@id='checkin']")).sendKeys("25/07/2020");


        driver.findElement(By.xpath("//div[@class='hero-form-absolute']")).click();
        driver.findElement(By.xpath("//div[@class='col-md-2 col-xs-12']/button")).click();

        String actual = driver.findElement(By.xpath("//*[@class='heading-title']")).getText();
        Assert.assertEquals(actual,"Hotels Lviv");


    }

    @Test
    public void secondTest(){

        driver.findElement(By.xpath("//*[@href='#flights']")).click();
        driver.findElement(By.xpath("//*[@for='flightSearchRadio-2']")).click();
        driver.findElement(By.xpath("//div[@id='s2id_location_from']")).click();
        driver.findElement(By.xpath("//*[@id='select2-drop']/div/input")).sendKeys("KRK");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@class='select2-results-dept-0 select2-result select2-result-selectable select2-highlighted']")).click();
        driver.findElement(By.xpath("//div[@id='s2id_location_to']")).click();
        driver.findElement(By.xpath("//*[@id='select2-drop']/div/input")).sendKeys("IEV");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@class='select2-results-dept-0 select2-result select2-result-selectable select2-highlighted']")).click();
        driver.findElement(By.xpath("//*[@class='col-xs-12 col-md-12']/button")).click();

        String actual = driver.findElement(By.xpath("//*[@class='heading-title']")).getText();
        Assert.assertEquals(actual,"KRK to IEV");

    }

    @Test
    public void thirdTest(){

        driver.findElement(By.xpath("//*[@href='#visa']")).click();
        driver.findElement(By.xpath("//*[@class='chosen-single']/span[contains(text(),'Antigua and Barbuda')]")).click();
        driver.switchTo().activeElement().sendKeys("Pakistan");
        driver.findElement(By.xpath("//*[@class='active-result highlighted']")).click();

        driver.findElement(By.xpath("//*[@class='chosen-single']/span[contains(text(),'United Arab Emirates')]")).click();
        driver.switchTo().activeElement().sendKeys("Turkey");
        driver.findElement(By.xpath("//*[@class='active-result highlighted']")).click();

        driver.findElement(By.xpath("//*[@placeholder = 'Date']")).click();
        driver.switchTo().activeElement().sendKeys("05/05/2020");

        driver.findElement(By.xpath("//div[@class='hero-form-absolute']")).click();
        driver.findElement(By.xpath("//*[@class='col-md-2 col-xs-12']/button[contains(text(),'Submit')]")).click();

        driver.findElement(By.xpath("//*[@class='form-group']/label/span[contains(text(),'First Name')]")).click();
        driver.switchTo().activeElement().sendKeys("Volodya");

        driver.findElement(By.xpath("//*[@class='col-md-6 col-12']/label/span[contains(text(),'Last Name')]")).click();
        driver.switchTo().activeElement().sendKeys("Voronovsky");

        driver.findElement(By.xpath("//span[contains(text(),'Email ')]")).click();
        driver.switchTo().activeElement().sendKeys("danik.voronovsky@gmail.com");

        driver.findElement(By.xpath("//span[contains(text(),'Confirm Email')]")).click();
        driver.switchTo().activeElement().sendKeys("danik.voronovsky@gmail.com");

        driver.findElement(By.xpath("//*[@id='sub']")).click();
        driver.switchTo().activeElement().sendKeys("380638480806");

        driver.findElement(By.xpath("//*[@id='sub']")).click();

        String actual = driver.findElement(By.xpath("//*[@class='wow fadeIn']/strong")).getText();
        Assert.assertEquals(actual,"Visa Submitted");

    }

    @Test
    public void fourthTest(){
        driver.findElement(By.xpath("//*[@href='#tours']")).click();
    }


    @Test
    public void fifthTest(){

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@href='https://www.facebook.com/travelbusiness']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void sixthTest(){

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@href='https://twitter.com/phptravels']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @AfterClass
    public void close() {
        driver.quit();
    }

}
