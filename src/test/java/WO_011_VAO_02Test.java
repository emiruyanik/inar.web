import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WO_011_VAO_02Test extends Hook {
    /*
1-) Open the URL
2-) Click "WebOrder" button on top bar.
3-) Enter valid username "Inar" and password "Academy".
4-) Navigate to the view all order page.
5-) Click "Add More Data" "6" times.
6-) Click "Check All" button.
7-) Verify all orders selected.
8-) Click "Uncheck All" button.
9-) Verify all orders are unselected.
     */
    @Test
    void VerifyUncheckAllFunctionalityInViewAllOrderPage() {
        WebElement orderPage = driver.findElement(By.linkText("Weborder"));
        orderPage.click();

        WebElement loginText = driver.findElement(By.id("login-username-input"));
        loginText.sendKeys("Inar");

        WebElement passwordText = driver.findElement(By.id("login-password-input"));
        passwordText.sendKeys("Academy");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement viewAllOrderPage = driver.findElement(By.xpath("//a[@href='/weborder/view-orders']"));
        viewAllOrderPage.click();

        WebElement addMoreData = driver.findElement(By.xpath("//button[contains(text(),'Add More Data')]"));
        addMoreData.click();
        addMoreData.click();
        addMoreData.click();
        addMoreData.click();
        addMoreData.click();
        addMoreData.click();

        WebElement checkAllButton = driver.findElement(By.xpath("//button[contains(text(),'Check All')]"));
        checkAllButton.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement uncheckAllButton = driver.findElement(By.xpath("//button[contains(text(),'Uncheck All')]"));
        uncheckAllButton.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        List<WebElement> inputs = driver.findElements(By.xpath("//input[@class='form-check-input']"));
        for (WebElement input : inputs) {
            Assertions.assertFalse(input.isSelected(), "The checkbox is selected but it should be vice versa");
        }

    }
}
