import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
/*
1-) Open the URL.
2-) Click "WebOrder" button on top bar.
3-) Enter valid username "Inar" and password "Academy".
4-) Navigate to the order page.
5-) Select "FashionApparel" from Product dropdown.
6-) Enter "6" as quantity number.
7-) Enter "5" as discount percentage.
8-) Click on the "Calculate" button.
9-) Enter "Inar Academy" as Name.
10-) Enter "1100 Congress Ave" as Street.
11-) Enter "Austin" as City.
12-) Enter "TX" State.
13-) Enter "78701" as Zip Code(number).
14-) Select "Visa" as Card Type.
15-) Enter "4938281746192845" as Card Number.
16-) Enter "11/28" Expire Date(mm/yy format).
17-) Click "Reset"" button.
 */

public class WO_014_CF_02Test extends Hook {
    @Test
    void verifyResetButton() {
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
        product.selectByIndex(5);

        WebElement quantityText = driver.findElement(By.id("quantityInput"));
        quantityText.sendKeys("6");

        WebElement discountText = driver.findElement(By.id("discountInput"));
        discountText.sendKeys("5");

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

        WebElement visaCard = driver.findElement(By.id("visa"));
        visaCard.click();

        WebElement cardNumberText = driver.findElement(By.id("cardNumber"));
        cardNumberText.sendKeys("4938281746192845");

        WebElement expiryDateTest = driver.findElement(By.id("expiryDate"));
        expiryDateTest.sendKeys("11/28");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement resetButton = driver.findElement(By.xpath("//button[contains(text(),'Reset')]"));
        resetButton.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertFalse(visaCard.isSelected(), "Vİsa card should have not been selected");


    }
}
