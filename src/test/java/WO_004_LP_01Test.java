import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WO_004_LP_01Test extends Hook {
    /*
1-) Open the URL.
2-) Click "WebOrder" button on top bar.
3-) Enter valid username "Inar" and password "Academy".
4-) Navigate to the order page.
5-) Select "HomeDecor" from Product dropdown.
6-) Enter "5" as quantity number.
7-) Enter "15" as discount percentage.
8-) Click on the "Calculate" button.
9-) Verify that the total amount is successfully displayed.
     */
    @Test
    void verifyCalculateFunctionalityInOrderPage() {
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
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();


//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("welcome-heading")));
        WebElement orderPage = driver.findElement(By.xpath("//a[contains(text(),'Order')]"));
        orderPage.click();

        WebElement productDropDown = driver.findElement(By.id("productSelect"));
        Select dropDown = new Select(productDropDown);
        dropDown.selectByIndex(4);

        WebElement quantityNumber = driver.findElement(By.id("quantityInput"));
        quantityNumber.sendKeys("5");

        WebElement discountPercentageText = driver.findElement(By.id("discountInput"));
        discountPercentageText.sendKeys("15");

        WebElement calculateButton = driver.findElement(By.xpath("//button[contains(text(),'Calculate')]"));
        calculateButton.click();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        WebElement totalText = driver.findElement(By.id("totalInput"));
        Assertions.assertEquals("638", totalText.getAttribute("value"), "Calculator is not working properly");

    }
}
