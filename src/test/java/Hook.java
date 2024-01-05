import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;

public class Hook {
    protected static WebDriver driver;
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    @BeforeAll
    public static void setUpBeforeTest() {
        Driver.getDriver();


    }

    @AfterAll
    public static void tearDownAfterTest() {
       Driver.closeDriver();
    }
}
