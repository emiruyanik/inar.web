import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WO_013_CF_04Test extends Hook {
    /*
1-) Open the URL.
2-) Click "WebOrder" button on top bar.
3-) Enter valid username "Inar" and password "Academy".
4-) Navigate to the order page.
5-) Select "TechGadget" from Product dropdown.
6-) Enter "2" as quantity number.
7-) Enter "10" as discount percentage.
8-) Click on the "Calculate" button.
9-) Enter "Inar Academy" as Name.
10-) Enter "1100 Congress Ave" as Street.
11-) Enter "Austin" as City.
12-) Enter "TX" State.
13-) Enter "78701" as Zip Code(number).
14-)Select "Visa" as Card Type.
15-)Enter "342738261027163" as Card Number.
16-) Enter "09/26" Expire Date(mm/yy format).
17-) Click "Process"" button.
18-) Verify the Card Type error message is displayed.

     */
    @Test
    void VerifyOrderPlacementWithWrongCardType() {
        WebElement webOrderButton = driver.findElement(By.xpath("//a[@href='/weborder']"));
        webOrderButton.click();

        WebElement userNameText = driver.findElement(By.id("login-username-input"));
        userNameText.sendKeys("Inar");

        WebElement passwordText = driver.findElement(By.id("login-password-input"));
        passwordText.sendKeys("Academy");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement orderButton = driver.findElement(By.xpath("//a[contains(text(),'Order')]"));
        orderButton.click();

        WebElement productSelectDropdown = driver.findElement(By.id("productSelect"));
        Select product = new Select(productSelectDropdown);
        product.selectByIndex(3);

        WebElement quantityText = driver.findElement(By.id("quantityInput"));
        quantityText.sendKeys("2");

        WebElement discountText = driver.findElement(By.id("discountInput"));
        discountText.sendKeys("10");

        WebElement calculateButton = driver.findElement(By.xpath("//button[contains(text(),'Calculate')]"));
        calculateButton.click();

        WebElement nameText = driver.findElement(By.id("name"));
        nameText.sendKeys("Inar Academy");

        WebElement streetText = driver.findElement(By.id("street"));
        streetText.sendKeys("1100 Congress Ave");

        WebElement cityText = driver.findElement(By.id("city"));
        cityText.sendKeys("Austin");

        WebElement stateText = driver.findElement(By.id("state"));
        stateText.sendKeys("TX");

        WebElement zipText = driver.findElement(By.id("zip"));
        zipText.sendKeys("78701");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,1000)");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement visaCheckout = driver.findElement(By.id("visa"));
        visaCheckout.click();

        WebElement cardNumberText = driver.findElement(By.id("cardNumber"));
        cardNumberText.sendKeys("342738261027163");

        WebElement expiryDateText = driver.findElement(By.id("expiryDate"));
        expiryDateText.sendKeys("09/26");

        WebElement processButton = driver.findElement(By.xpath("//button[contains(text(),'Process')]"));
        processButton.click();

        WebElement cardNumberIsNotValidText=driver.findElement(By.xpath("//em[contains(text(),'Card number is not valid')]"));
        String actual=cardNumberIsNotValidText.getText();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals("Card number is not valid",actual,"Wrong card type should haven't been accepted");



    }
}
