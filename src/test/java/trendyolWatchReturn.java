import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.DriverManager;
import java.time.Duration;

public class trendyolWatchGet {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void trendyolSearch(){
        driver.get("https://www.trendyol.com/");
        WebElement searhBox=driver.findElement(By.className("V8wbcUhU"));
        searhBox.sendKeys("Saat");
        searhBox.sendKeys(Keys.ENTER);

        String actualData="araması için 100.000+ sonuç listeleniyor";
        String expectedData="";

        WebElement searchTextWE=driver.findElement(By.xpath("//*[@id=\"search-app\"]/div/div/div/div[2]/div[1]/div[1]/div/h2"));
        expectedData=searchTextWE.getText();
        expectedData.trim();
        actualData.trim();
        Assert.assertEquals(expectedData,actualData);
        //Assert.assertEquals(expectedData.equals(actualData));


    }
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
