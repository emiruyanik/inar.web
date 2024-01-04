package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebOrderLoginPage {
    private WebDriver driver;
    private By userNameInputField = By.id("login-username-input");
    private By passwordInputField = By.id("login-password-input");
    private By loginButton = By.id("login-button");

    public WebOrderLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserName(String userName) {
        driver.findElement(userNameInputField).sendKeys(userName);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInputField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public WebOrderHomePage login(String userName, String password) {
        driver.findElement(userNameInputField).sendKeys(userName);
        driver.findElement(passwordInputField).sendKeys(password);
        driver.findElement(loginButton).click();

        return new WebOrderHomePage(driver);
    }
}
