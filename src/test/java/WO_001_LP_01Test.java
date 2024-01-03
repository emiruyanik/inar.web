import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WO_001_LP_01Test extends Hook {
    /*
    1-) Open the URL.
    2-) Click "WebOrder" button on top bar.
    3-) Enter "Inar" as username and "Academy" password.
    4-) Click on the "Login" button.
    5-) Verify that the user is successfully logged in.
     */
    @Test
    void verifyLoginFunctionality() {
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='text-fifth fw-semibold px-3 fs-3 nav-link'][1]")));
        WebElement webOrderPage = driver.findElement(By.xpath("//a[@class='text-fifth fw-semibold px-3 fs-3 nav-link'][1]"));
        webOrderPage.click();

//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-username-input")));
        WebElement userNameText = driver.findElement(By.id("login-username-input"));
        userNameText.sendKeys("Inar");

//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-password-input")));
        WebElement passwordText = driver.findElement(By.id("login-password-input"));
        passwordText.sendKeys("Academy");

//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-button")));
        WebElement clickButton = driver.findElement(By.id("login-button"));
        clickButton.click();


//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("welcome-heading")));
        WebElement welcomeText = driver.findElement(By.id("welcome-heading"));
        String result = welcomeText.getText();

        Assertions.assertEquals("Welcome, Inar!", result, "The login message is wrong");


    }
}
