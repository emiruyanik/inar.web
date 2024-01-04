package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OrderPage {
    private WebDriver driver;
    //Product Information
    private By productDropdownElement = By.id("productSelect");

    private By quantityInputField = By.id("quantityInput");

    private By discountInputField = By.id("discountInput");

    private By totalInputPrice = By.id("totalInput");

    private By calculateButton = By.xpath("//button[contains(text(),'Calculate')]");

    //Customer Information
    private By nameInputText = By.id("name");
    private By streetInputText = By.id("street");
    private By cityInputText = By.id("city");
    private By stateInputText = By.id("state");
    private By zipInputText = By.id("zip");


    //Payment Information
    //Card Type
    private By visaCardCheckBox = By.id("visa");
    private By masterCardCheckBox = By.id("mastercard");
    private By amaricanExpressCheckBox = By.id("amex");

    //Card nr
    private By cardNumberField = By.id("cardNumber");

    //expiryDate
    private By expiryDateField = By.id("expiryDate");
    private By processButton = By.xpath("//button[contains(text(),'Process')]");


    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectProduct(String productName) {
        WebElement dropDownElement = driver.findElement(productDropdownElement);
        Select element = new Select(dropDownElement);
        element.selectByVisibleText(productName);
    }

    public void enterQuantity(String quantity) {
        WebElement quantityElement = driver.findElement(quantityInputField);
        quantityElement.clear();
        quantityElement.sendKeys(quantity);
    }

    public void enterDiscount(String discount) {
        WebElement discountElement = driver.findElement(discountInputField);
        discountElement.clear();
        discountElement.sendKeys(discount);
    }

    public void clickCalculateButton() {
        driver.findElement(calculateButton).click();
    }

    public String calculatePrice(String productName, String quantity, String discount) {
        selectProduct(productName);
        enterQuantity(quantity);
        enterDiscount(discount);
        clickCalculateButton();

        WebElement totalPriceElement = driver.findElement(totalInputPrice);

        return totalPriceElement.getAttribute("value");

    }

    public void enterName(String name) {
        WebElement nameInput = driver.findElement(nameInputText);
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void enterStreet(String street) {
        WebElement streetInput = driver.findElement(streetInputText);
        streetInput.clear();
        streetInput.sendKeys(street);
    }

    public void enterCity(String city) {
        WebElement cityInput = driver.findElement(cityInputText);
        cityInput.clear();
        cityInput.sendKeys(city);
    }

    public void enterState(String state) {
        WebElement stateInput = driver.findElement(stateInputText);
        stateInput.clear();
        stateInput.sendKeys(state);
    }

    public void enterZip(String zip) {
        WebElement zipInput = driver.findElement(zipInputText);
        zipInput.clear();
        zipInput.sendKeys(zip);
    }

    public void customerInformation(String name, String street, String city, String state, String zip) {
        enterName(name);
        enterStreet(street);
        enterCity(city);
        enterState(state);
        enterZip(zip);
    }

    public void selectCardType(String cardType) {
        switch (cardType.toLowerCase()) {
            case "visa":
                driver.findElement(visaCardCheckBox).click();
                break;
            case "mastercard":
                driver.findElement(masterCardCheckBox).click();
                break;
            case "americanexpress":
                driver.findElement(amaricanExpressCheckBox).click();
                break;
            default:
                System.out.println("Card type doesn't exists");
        }
    }

    public void enterCardNumber(String cardNo) {
        WebElement cardNumberInput = driver.findElement(cardNumberField);
        cardNumberInput.clear();
        cardNumberInput.sendKeys(cardNo);
    }

    public void enterExpiryDate(String expiryDate) {
        WebElement expiryDateInput = driver.findElement(expiryDateField);
        expiryDateInput.clear();
        expiryDateInput.sendKeys(expiryDate);
    }

    public void paymentInformation(String cardType, String cardNo, String expiryDate) {
        selectCardType(cardType);
        enterCardNumber(cardNo);
        enterExpiryDate(expiryDate);

    }

    public void enterProductInformation(String productName, String quantity, String discount) {
        enterName(productName);
        enterQuantity(quantity);
        enterDiscount(discount);
        clickCalculateButton();

    }

    public void clickProcessButton() {
        driver.findElement(processButton).click();
    }
}
