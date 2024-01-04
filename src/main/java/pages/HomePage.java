package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    //Locators

    private By weborderLink = By.linkText("Weborder");
    private By webAutomation = By.linkText("Webautomation");

    private By targetMarketLink = By.linkText("Target Market");

    private By bookingLink = By.linkText("Booking");

    private By handlingCertificationsLink = By.linkText("Handling Certifications");

    private By fileUploading = By.linkText("File Uploading");

    //<h1 class="display-1  text-fifth">Explore Inar's Testing World</h1>
    private By exploreInarTestWorldTitleText = By.cssSelector("h1.display-1.text-fifth");

    //constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //page actions with Java Methods
    public WebOrderLoginPage clickOnWebOrder() {
        driver.findElement(weborderLink).click();
        return new WebOrderLoginPage(driver);
    }

    public void clickOnWebAutomation() {
        driver.findElement(webAutomation).click();
    }

    public void clickOnTargetMarget() {
        driver.findElement(targetMarketLink).click();
    }

    public void clickOnBooking() {
        driver.findElement(bookingLink).click();
    }

    public void clickOnHandlingCertifications() {
        driver.findElement(handlingCertificationsLink).click();
    }

    public void clickOnFileUploading() {
        driver.findElement(fileUploading).click();
    }

    public String getWelcomeText() {
        return driver.findElement(exploreInarTestWorldTitleText).getText();
    }
    public void refreshPage(){
        driver.navigate().refresh();
    }

}
