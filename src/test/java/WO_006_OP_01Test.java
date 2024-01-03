import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WO_006_OP_01Test extends Hook {
    List<String> orderList = new ArrayList<>();
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
13-) Enter "78701" as Zip Code(number).
14-) Select "Visa" as Card Type.
15-) Enter "4938281746192845" as Card Number.
16-) Enter "11/28" Expire Date(mm/yy format).
17-) Click "Process"" button.
18-) Verify the confirmation message is displayed.
19-) Navigate to view all orders page.
20-) Verify the order is successfully placed.

     */

    @Test
    void verifyOrderPlacement() {
        orderList.add("Inar Academy");
        orderList.add("MyMoney");
        orderList.add("8");

        Date currentDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String dateString = simpleDateFormat.format(currentDate);

        orderList.add(dateString);
        orderList.add("1100 Congress Ave");
        orderList.add("Austin");
        orderList.add("TX");
        orderList.add("78701");
        orderList.add("Visa");
        orderList.add("4938281746192845");
        orderList.add("11/28");

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
        zipText.sendKeys("78701");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,1000)");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement cardSelector = driver.findElement(By.xpath("//label[contains(text(),'Visa')]"));
        cardSelector.click();

        WebElement carIdText = driver.findElement(By.id("cardNumber"));
        carIdText.sendKeys("4938281746192845");

        WebElement expiryDateText = driver.findElement(By.id("expiryDate"));
        expiryDateText.sendKeys("11/28");


        WebElement processButton = driver.findElement(By.xpath("//button[contains(text(),'Process')]"));
        processButton.click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        js.executeScript("window.scroll(0,-1000)");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement viewAllOrders = driver.findElement(By.xpath("//a[contains(text(),'View all orders')]"));
        viewAllOrders.click();

        List<WebElement> tableRows = driver.findElements(By.cssSelector("tbody>tr"));
        List<WebElement> lastDataOfTableRows = tableRows.get(tableRows.size() - 1).findElements(By.xpath("td"));
        for (int i = 0; i < orderList.size(); i++) {
            Assertions.assertEquals(orderList.get(i), lastDataOfTableRows.get(i+1).getText(), "The orderlist was not created properly");


        }


    }
}
