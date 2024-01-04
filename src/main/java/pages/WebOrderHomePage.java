package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebOrderHomePage {
    private WebDriver driver;
    private By viewAllOrdersLink = By.linkText("View all orders");
    private By viewAllProductsLink = By.linkText("View all products");
    private By orderLink = By.linkText("Order");

    public WebOrderHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public ViewAllOrdersPage navigateToAllOrdersPage() {
        driver.findElement(viewAllOrdersLink).click();
        return new ViewAllOrdersPage(driver);
    }

    public ViewAllProductsPage navigateToViewAllProducts() {
        driver.findElement(viewAllProductsLink).click();
        return new ViewAllProductsPage(driver);
    }

    public OrderPage navigateToOrder() {
        driver.findElement(orderLink).click();
        return new OrderPage(driver);
    }
}
