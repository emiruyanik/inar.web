import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WO_002_LP_02Test extends Hook {
    /*
     1-) Open the URL.
     2-) Click "WebOrder" button on top bar.
     3-) Enter invalid username "InvalidUserName" and/or password "InvalidPassword".
     4-) Click on the "Login" button
     5-) Verify that the appropriate error message is displayed.
     */


    @Test
    void verifyLoginFailure() {
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='text-fifth fw-semibold px-3 fs-3 nav-link'][1]")));
        WebElement webOrderPage = driver.findElement(By.xpath("//a[@class='text-fifth fw-semibold px-3 fs-3 nav-link'][1]"));
        webOrderPage.click();

//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-username-input")));
        WebElement userNameText = driver.findElement(By.id("login-username-input"));
        userNameText.sendKeys("Inar5");

//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-password-input")));
        WebElement passwordText = driver.findElement(By.id("login-password-input"));
        passwordText.sendKeys("Academy");

//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-button")));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();


//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("welcome-heading")));
        WebElement invalidUserNameText = driver.findElement(By.id("username-error-alert"));
        String result = invalidUserNameText.getText();

        Assertions.assertEquals("Invalid username", result, "We can reach the page with invalid values");


    }
}

