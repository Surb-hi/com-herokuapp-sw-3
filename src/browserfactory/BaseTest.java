package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    public void openbrowser(String baseUrl) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        //Maximize window
        driver.manage().window().maximize();
        // We give implicit time to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    public void closebrowser(){
        driver.quit();
    }
}
