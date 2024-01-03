import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WO_003_LP_03Test extends Hook {

    /*
    1-) Open the URL
    2-) Click "WebOrder" button on top bar.
    3-) Enter valid username "Inar" and password "Academy".
    4-) Click "Logout" button.
    5-) Verify logout successfully.
     */
    @Test
    void verifyLogoutFunctionality() {
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
        WebElement logOutButton = driver.findElement(By.id("logout-button"));
        logOutButton.click();

        WebElement loginPage = driver.findElement(By.xpath("//h2[contains(text(),'Login')]"));
        String login = loginPage.getText();
        Assertions.assertEquals("Login",login,"We can't back to the login page");


    }
}
