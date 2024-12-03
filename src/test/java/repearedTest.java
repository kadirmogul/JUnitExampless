import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.junit.jupiter.api.RepeatedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class repearedTest {
    static WebDriver driver;

    @RepeatedTest(3)
    public void testCaseRepeared() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.google.com.tr/");
        String actualData = driver.getTitle();
        String expectedData = "gOOgle";
        // Assert.assertTrue(actualData.contains(expectedData));
        Assert.assertEquals(actualData.toLowerCase(), expectedData.toLowerCase());
        driver.quit();
    }



}
