package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseDriver {

    public static WebDriver driver;

    @BeforeSuite
    public void setup() {

        // Disable notification
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--headless");
        option.addArguments("--window-size=1920, 1080");
        option.addArguments("--disable-notifications");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(option);

        driver.manage().window().maximize();
        driver.get("https://twitter.com/bbcbangla");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterSuite
    public void endSession() {
        driver.quit();
    }

}
