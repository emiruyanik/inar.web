import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WO_012_VAO_03Test extends Hook {
    /*
1-) Open the URL
2-) Click "WebOrder" button on top bar.
3-) Enter valid username "Inar" and password "Academy".
4-) Navigate to the view all order page.
5-) Click "Add More Data" "8" times.
6-) Click 1st, 3rd and 5th orders checkbox's.
7-) Click "Delete All" button.
8-) Verify the orders are deleted
     */
    @Test
    void VerifyDeleteFunctionalityInViewAllOrderPage() {
        WebElement orderPage = driver.findElement(By.linkText("Weborder"));
        orderPage.click();

        WebElement loginText = driver.findElement(By.id("login-username-input"));
        loginText.sendKeys("Inar");

        WebElement passwordText = driver.findElement(By.id("login-password-input"));
        passwordText.sendKeys("Academy");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement viewAllOrdersPage = driver.findElement(By.xpath("//a[@href='/weborder/view-orders']"));
        viewAllOrdersPage.click();

        WebElement addMoreDataButton = driver.findElement(By.xpath("//button[contains(text(),'Add More Data')]"));
        addMoreDataButton.click();
        addMoreDataButton.click();
        addMoreDataButton.click();
        addMoreDataButton.click();
        addMoreDataButton.click();
        addMoreDataButton.click();
        addMoreDataButton.click();
        addMoreDataButton.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<WebElement> inputs = driver.findElements(By.xpath("//input[@class='form-check-input']"));
        for (int i = 0; i < 5; i += 2) {
            inputs.get(i).click();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scroll(0,250)");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Assertions.assertTrue(inputs.get(i).isSelected(), "The input should have been selected");

        }
        WebElement checkAllButton = driver.findElement(By.xpath("//button[contains(text(),'Check All')]"));
        checkAllButton.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,500)");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement deleteButton = driver.findElement(By.xpath("//button[contains(text(),'Delete')]"));
        deleteButton.click();

        WebElement noOrdersAvailableParagraph = driver.findElement(By.tagName("p"));
        String actual = noOrdersAvailableParagraph.getText();
        System.out.println(actual);
        assertEquals("No orders available.", actual, "There is still order in spite of delete button");

    }
}