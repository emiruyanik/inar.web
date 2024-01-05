package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {


    //Locators
    @FindBy(linkText = "Weborder")
    private WebElement weborderLink;

    @FindBy(linkText = "Webautomation")
    private WebElement webAutomationLink;

    @FindBy(linkText = "Target Market")
    private WebElement targetMarketLink;
    @FindBy(linkText = "Booking")
    private WebElement bookingLink;

    @FindBy(linkText = "Handling Certifications")
    private WebElement handlingCertificationsLink;

    @FindBy(linkText = "File Uploading")
    private WebElement fileUploadingLink;

    //<h1 class="display-1  text-fifth">Explore Inar's Testing World</h1>
    @FindBy(css = "h1.display-1.text-fifth")
    private WebElement exploreInarTestWorldTitleText;


    //constructor
    public HomePage() {
        super();
    }

    //page actions with Java Methods
    public void clickOnWebOrder() {
        weborderLink.click();

    }

    public void clickOnWebAutomation() {
        webAutomationLink.click();
    }

    public void clickOnTargetMarget() {
        targetMarketLink.click();
    }

    public void clickOnBooking() {
        bookingLink.click();
    }

    public void clickOnHandlingCertifications() {
        handlingCertificationsLink.click();
    }

    public void clickOnFileUploading() {
        fileUploadingLink.click();
    }

    public String getWelcomeText() {
        return exploreInarTestWorldTitleText.getText();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

}
