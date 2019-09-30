import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumTest {

    WebDriver driver;
    private String buttonAddToCart = "//a[@class='button ajax_add_to_cart_button btn btn-default']";
    private static final String BASE_URL = "http://automationpractice.com/index.php";
    private static final String PATH_TO_DRIVER = "C:\\Users\\roman\\IdeaProjects\\automationcourse\\src\\main\\resources\\Drivers\\chromedriver.exe";

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", PATH_TO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.navigate().to(BASE_URL);
    }

    @Test
    public void verifyTotalPrice() throws InterruptedException{

        final String expectedTotalPrice = "$29.00";
        driver.findElement(By.id("search_query_top")).sendKeys("Blouse");
        driver.findElement(By.xpath("//button[@name='submit_search']")).click();

        driver.findElement(By.xpath("//a[@title='List']")).click();
        driver.findElement(By.xpath(buttonAddToCart)).click();
        driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();

        driver.findElement(By.id("total_price")).getText();
        String actualTotalPrice = driver.findElement(By.id("total_price")).getText();
        Assert.assertEquals("The total price is different",expectedTotalPrice, actualTotalPrice);
    }

    @After
    public void close(){
        driver.close();
    }
}
