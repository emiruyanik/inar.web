package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    private static final ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();

    private Driver() {
        throw new UnsupportedOperationException("can not instantiate utility class");

    }

    public synchronized static WebDriver getDriver() {
        if (DRIVER_THREAD_LOCAL.get() == null) {
            WebDriver driver;
            String browser = System.getProperty("browser", "chrome");
            switch (browser.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                default:
                    driver = new ChromeDriver();


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
            DRIVER_THREAD_LOCAL.set(driver);
        }
        return DRIVER_THREAD_LOCAL.get();
    }

    public static synchronized void closeDriver() {
        WebDriver currentDriver = DRIVER_THREAD_LOCAL.get();
        if (currentDriver != null) {
            currentDriver.quit();
            DRIVER_THREAD_LOCAL.remove();
        }
    }
}
