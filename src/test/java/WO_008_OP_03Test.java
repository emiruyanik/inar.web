import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WO_008_OP_03Test extends Hook{
    /*
1-) Open the URL.
2-) Click "WebOrder" button on top bar.
3-) Enter valid username "Inar" and password "Academy".
4-) Navigate to the order page.
5-) Select "MyMoney" from Product dropdown.
6-) Enter "8" as quantity number.
7-) Enter "20" as discount percentage.
8-) Click on the "Calculate" button.
9-) Enter "Inar Academy" as Name.
10-) Enter "1100 Congress Ave" as Street.
11-) Enter "Austin" as City.
12-) Enter "TX" State.
13-) Enter "92@#83" as Zip Code.
14-) Select "American Express" as Card Type.
15-) Enter "342738261027163" as Card Number.
16-) Enter "01/28" Expire Date(mm/yy format).
17-) Click "Process"" button.
18-) Verify the invalid Zip Code error message is displayed.
     */
    @Test
    void VerifyOrderPlacementWithInvalidZipCode(){
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
        product.selectByIndex(0);


        WebElement quantityText = driver.findElement(By.id("quantityInput"));
        quantityText.sendKeys("8");

        WebElement discountText = driver.findElement(By.id("discountInput"));
        discountText.sendKeys("20");

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
        zipText.sendKeys("92@#83");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,1000)");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement cardSelector = driver.findElement(By.xpath("//label[contains(text(),'American Express')]"));
        cardSelector.click();

        WebElement carIdText = driver.findElement(By.id("cardNumber"));
        carIdText.sendKeys("342738261027163");

        WebElement expiryDateText = driver.findElement(By.id("expiryDate"));
        expiryDateText.sendKeys("01/28");


        WebElement processButton = driver.findElement(By.xpath("//button[contains(text(),'Process')]"));
        processButton.click();



        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement zipErrorText=driver.findElement(By.xpath("//em[contains(text(),'Zip cannot be empty')]"));
        String actual=zipErrorText.getText();

        Assertions.assertEquals("Zip Code is invalid.",actual,"The wrong Zip code is accepted!");

    }
}
