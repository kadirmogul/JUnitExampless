import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.DriverManager;
import java.time.Duration;

public class MyFirstTest {

  static  WebDriver driver;

@BeforeClass
  public static void testPreparation(){
      WebDriverManager.chromedriver().setup();
      driver=new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }
    @Test
    public void testCase1() {
    driver.get("https://www.google.com.tr/");
    String actualData=driver.getTitle();
    String expectedData="gOOgle";
   // Assert.assertTrue(actualData.contains(expectedData));
    Assert.assertEquals(actualData.toLowerCase(),expectedData.toLowerCase());


  }

@AfterClass
    public static void endTest(){
    driver.quit();
}


}



