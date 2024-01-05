import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import pages.HomePage;
import pages.OrderPage;
import pages.WebOrderHomePage;
import pages.WebOrderLoginPage;
import utils.BrowserUtils;
import utils.Driver;

import java.time.Duration;

public class PagesTest extends Hook{
    @Test
    void pageTest() throws InterruptedException {

        HomePage homePage = new HomePage();
        homePage.clickOnWebOrder();

        WebOrderLoginPage webOrderLoginPage = new WebOrderLoginPage();
        webOrderLoginPage.login("Inar", "Academy");


//        OrderPage orderPage = webOrderHomePage.navigateToOrder();
//        String totalPrice = orderPage.calculatePrice("Books", "10", "10");
//
//        Assertions.assertEquals("810",totalPrice);
        WebOrderHomePage webOrderHomePage = new WebOrderHomePage();
        webOrderHomePage.navigateToOrder();
        OrderPage orderPage = new OrderPage();
        orderPage.enterProductInformation("Books", "10", "10");
        orderPage.customerInformation("emo", "main", "angara", "IA", "06");
        BrowserUtils.scrollDown();
        Thread.sleep(1000);
        orderPage.paymentInformation("visa", "4938281746192845", "07/26");
        orderPage.clickProcessButton();
        Thread.sleep(5000);


    }
}
