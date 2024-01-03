import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WO_010_VAO_01Test extends Hook {
    /*
1-) Open the URL
2-) Click "WebOrder" button on top bar.
3-) Enter valid username "Inar" and password "Academy".
4-) Navigate to the view all order page.
5-) Click "Add More Data" "4" times.
6-) Click "Check All" button.
7-) Verify all orders selected
     */
    @Test
    void VerifyCheckAllFunctionalityInViewAllOrderPage() {
        WebElement webOrderButtonOntOpBar = driver.findElement(By.xpath("//a[@href='/weborder']"));
        webOrderButtonOntOpBar.click();

        WebElement loginText=driver.findElement(By.id("login-username-input"));
        loginText.sendKeys("Inar");

        WebElement passwordText=driver.findElement(By.id("login-password-input"));
        passwordText.sendKeys("Academy");

        WebElement loginButton=driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement viewAllOrdersPage = driver.findElement(By.xpath("//a[contains(text(),'View all orders')]"));
        viewAllOrdersPage.click();

        WebElement addMoreDataButton = driver.findElement(By.xpath("//button[contains(text(),'Add More Data')]"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        addMoreDataButton.click();
        addMoreDataButton.click();
        addMoreDataButton.click();
        addMoreDataButton.click();

        WebElement checkAllButton = driver.findElement(By.xpath("//button[contains(text(),'Check All')]"));
        checkAllButton.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<WebElement>inputs=driver.findElements(By.xpath("//div/input[@type='checkbox']"));
        for (int i = 0; i <inputs.size()-1 ; i++) {
            assertTrue(inputs.get(i).isSelected(),"The checkboxes is not selected");
        }


    }
}
