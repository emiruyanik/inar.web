import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WO_005_LP_02Test extends Hook {
    /*
1-) Open the URL.
2-) Click "WebOrder" button on top bar.
3-) Enter valid username "Inar" and password "Academy".
4-) Navigate to the order page.
5-) Select "ScreenSaver" from Product dropdown.
6-) Leave blank the quantity box.
7-) Enter "20" as discount percentage.
8-) Click on the "Calculate" button.
9-) Verify the invalid Quantity error message is displayed
     */
    @Test
    void verifyCalculateFunctionalityInOrderPageInvalidInput() {
        WebElement webOrderPage = driver.findElement(By.xpath("//a[@class='text-fifth fw-semibold px-3 fs-3 nav-link'][1]"));
        webOrderPage.click();

//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-username-input")));
        WebElement userNameText = driver.findElement(By.id("login-username-input"));
        userNameText.sendKeys("Inar");

//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-password-input")));
        WebElement passwordText = driver.findElement(By.id("login-password-input"));
        passwordText.sendKeys("Academy");

//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-button")));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement orderPage = driver.findElement(By.linkText("Order"));
        orderPage.click();

        WebElement productDropdown = driver.findElement(By.id("productSelect"));
        Select product = new Select(productDropdown);
        product.selectByIndex(2);

        WebElement discountText = driver.findElement(By.id("discountInput"));
        discountText.sendKeys("20");

        WebElement calculateButton = driver.findElement(By.xpath("//button[contains(text(),'Calculate')]"));
        calculateButton.click();


        WebElement quantityValidateError = driver.findElement(By.xpath("//em[contains(text(),\"Field 'Quantity' must be greater than zero.\")]"));
        String actual = quantityValidateError.getText();
        String expected = "Field 'Quantity' must be greater than zero.";

        Assertions.assertEquals(expected, actual);


    }
}
