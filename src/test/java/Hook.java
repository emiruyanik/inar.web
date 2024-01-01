import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Hook {
    protected static WebDriver driver;
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    @BeforeAll
    public static void setUpBeforeTest() {
        String browser = System.getProperty("browser", "chrome");

        switch (browser.toLowerCase()) {
            case "firefox":
                driver = new FirefoxDriver();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                break;
            case "edge":
                driver = new EdgeDriver();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                break;
            case "chrome":
            default:
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                break;
        }
        driver.manage().window().maximize();
        driver.get("https://InarAcademy:Fk160621.@test.inar-academy.com");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (browser.equalsIgnoreCase("firefox")) {
            driver.navigate().refresh();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }

    @AfterAll
    public static void tearDownAfterTest() {
        if (driver != null) {
            driver.quit();
        }
    }
}
