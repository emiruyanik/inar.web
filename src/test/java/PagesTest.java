import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.OrderPage;
import pages.WebOrderHomePage;
import pages.WebOrderLoginPage;

import java.time.Duration;

public class PagesTest {
    @Test
    void pageTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://InarAcademy:Fk160621.@test.inar-academy.com");

        HomePage homePage = new HomePage(driver);
        WebOrderLoginPage webOrderLoginPage = homePage.clickOnWebOrder();

        WebOrderHomePage webOrderHomePage = webOrderLoginPage.login("Inar", "Academy");


//        OrderPage orderPage = webOrderHomePage.navigateToOrder();
//        String totalPrice = orderPage.calculatePrice("Books", "10", "10");
//
//        Assertions.assertEquals("810",totalPrice);

        OrderPage orderPage = webOrderHomePage.navigateToOrder();
        orderPage.enterProductInformation("Books", "10", "10");
        orderPage.customerInformation("emo", "main", "angara", "IA", "06");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,1000)");
        Thread.sleep(1000);
        orderPage.paymentInformation("visa", "4938281746192845", "07/26");
        orderPage.clickProcessButton();
        Thread.sleep(5000);


    }
}
