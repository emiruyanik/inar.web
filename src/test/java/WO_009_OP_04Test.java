import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WO_009_OP_04Test extends Hook{
    /*
1-) Open the URL.
2-) Click "WebOrder" button on top bar.
3-) Enter valid username "Inar" and password "Academy".
4-) Navigate to the order page.
5-) Select "SportsEquipment" from Product dropdown.
6-) Enter "1" as quantity number.
7-) Enter "10" as discount percentage.
8-) Click on the "Calculate" button.
9-) Enter "Inar Academy" as Name.
10-) Enter "1100 Congress Ave" as Street.
11-) Enter "Austin" as City.
12-) Enter "TX" State.
13-) Enter "78701" as Zip Code(number).
14-) Enter "4938220192845" as Card Number.
15-) Enter "09/26" Expire Date(mm/yy format).
16-) Click "Process"" button.
17-) Verify the Card Type error message is displayed
     */
    @Test
    void verifyOrderPlacementWithoutCardType(){
        WebElement orderPage=driver.findElement(By.xpath("//header/nav[1]/div[1]/div[1]/a[1]"));
        orderPage.click();

        WebElement userNameText=driver.findElement(By.id("login-username-input"));
        userNameText.sendKeys("Inar");

        WebElement passwordText=driver.findElement(By.id("login-password-input"));
        passwordText.sendKeys("Academy");

        WebElement loginButton=driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement orderButton=driver.findElement(By.xpath("//a[contains(text(),'Order')]"));
        orderButton.click();

        WebElement productDropdown=driver.findElement(By.id("productSelect"));
        Select product=new Select(productDropdown);
        product.selectByIndex(8);

       WebElement quantityText=driver.findElement(By.id("quantityInput"));
       quantityText.sendKeys("1");

       WebElement discountText=driver.findElement(By.id("discountInput"));
       discountText.sendKeys("10");

       WebElement calculatorButton=driver.findElement(By.xpath("//button[contains(text(),'Calculate')]"));
       calculatorButton.click();

       WebElement nameText=driver.findElement(By.id("name"));
       nameText.sendKeys("Inar Academy");

        WebElement streetText=driver.findElement(By.id("street"));
        streetText.sendKeys("1100 Congress Ave");

        WebElement cityText=driver.findElement(By.id("city"));
        cityText.sendKeys("Austin");

        WebElement stateText= driver.findElement(By.id("state"));
        streetText.sendKeys("TX");

        WebElement zipText=driver.findElement(By.id("zip"));
        zipText.sendKeys("78701");

        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,1000)");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement cardNumberText=driver.findElement(By.id("cardNumber"));
        cardNumberText.sendKeys("4938220192845");

        WebElement expiryDateText=driver.findElement(By.id("expiryDate"));
        expiryDateText.sendKeys("09/26");

        WebElement processButton=driver.findElement(By.xpath("//button[contains(text(),'Process')]"));
        processButton.click();

        WebElement cardTypeErrorMessage=driver.findElement(By.xpath("//em[contains(text(),'Card type cannot be empty')]"));
        String actual=cardTypeErrorMessage.getText();

        Assertions.assertEquals("Card type cannot be empty",actual,"User can order without selecting card type");


    }
}
