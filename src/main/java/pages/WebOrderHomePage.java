package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebOrderHomePage extends BasePage {
    @FindBy(linkText = "View all orders")
    private WebElement viewAllOrdersLink;
    @FindBy(linkText = "View all products")
    private WebElement viewAllProductsLink;
    @FindBy(linkText = "Order")
    private WebElement orderLink;


    public WebOrderHomePage() {
        super();
    }

    public void navigateToAllOrdersPage() {
        viewAllOrdersLink.click();

    }

    public void navigateToViewAllProducts() {
        viewAllProductsLink.click();

    }

    public void navigateToOrder() {
        orderLink.click();

    }
}
