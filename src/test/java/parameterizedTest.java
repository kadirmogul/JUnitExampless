import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class parameterizedTest {
    @ParameterizedTest
    @ValueSource(strings = {"Hamburger","Kola","Patates","Soğan Halkası"})

    public void testCase01(String mail){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://practicetestautomation.com/practice-test-exceptions/");
        driver.findElement(By.id("edit_btn")).click();
        WebElement textData =driver.findElement(By.className("input-field"));
        textData.clear();
        textData.sendKeys(mail);
        textData.sendKeys(Keys.ENTER);
        try {
            Thread.sleep(Duration.ofSeconds(2));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
