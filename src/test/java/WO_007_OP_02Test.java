import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WO_007_OP_02Test extends Hook {
    /*
1-) Open the URL.
2-) Click "WebOrder" button on top bar.
3-) Enter valid username "Inar" and password "Academy".
4-) Navigate to the order page.
5-) Select "FamilyAlbum" from Product dropdown.
6-) Enter "3" as quantity number.
7-) Enter "17" as discount percentage.
8-) Enter "Inar Academy" as Name.
9-) Enter "1100 Congress Ave" as Street.
10-) Enter "Austin" as City.
11-) Enter "TX" State.
12-) Enter "78701" as Zip Code(number).
13-) Select "Mastercard" as Card Type.
14-) Enter "5162738261027163" as Card Number.
15-) Enter "11/28" Expire Date(mm/yy format).
16-) Click "Process"" button.
17-) Verify the invalid Product Information error message is displayed
     */
    @Test
    void verifyOrderPlacementWithoutCalculation() {
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

        WebElement productSelectDropdown = driver.findElement(By.id("productSelect"));
        Select product = new Select(productSelectDropdown);
        product.selectByIndex(1);

        WebElement quantityText = driver.findElement(By.id("quantityInput"));
        quantityText.sendKeys("8");

        WebElement discountText = driver.findElement(By.id("discountInput"));
        discountText.sendKeys("20");

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

        WebElement masterCardSelector=driver.findElement(By.xpath("//label[contains(text(),'MasterCard')]"));
        masterCardSelector.click();

        WebElement cardNUmberText=driver.findElement(By.id("cardNumber"));
        cardNUmberText.sendKeys("5162738261027163");

        WebElement expiryDateText=driver.findElement(By.id("expiryDate"));
        expiryDateText.sendKeys("11/28");

        WebElement processButton=driver.findElement(By.xpath("//button[contains(text(),'Process')]"));
        processButton.click();

        js.executeScript("window.scroll(0,-750)");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement errorsInProductInformationText=driver.findElement(By.xpath("//em[contains(text(),'Fix errors in Product Information ')]"));
        String actual=errorsInProductInformationText.getText();

        Assertions.assertEquals("Fix errors in Product Information",actual,"Without calculate button we took the order but we couldn't");

    }
}
