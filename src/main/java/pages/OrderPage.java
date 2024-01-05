package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class OrderPage extends BasePage {
    //Product Information
    @FindBy(id = "productSelect")
    private WebElement productDropdownElement;

    @FindBy(id = "quantityInput")
    private WebElement quantityInputField;

    @FindBy(id = "discountInput")
    private WebElement discountInputField;

    @FindBy(id = "totalInput")
    private WebElement totalInputPrice;

    @FindBy(xpath = "//button[contains(text(),'Calculate')]")
    private WebElement calculateButton;


    //Customer Information
    @FindBy(id = "name")
    private WebElement nameInputText;
    @FindBy(id = "street")
    private WebElement streetInputText;
    @FindBy(id = "city")
    private WebElement cityInputText;
    @FindBy(id = "state")
    private WebElement stateInputText;
    @FindBy(id = "zip")
    private WebElement zipInputText;

    //Payment Information


    //Card Type
    @FindBy(id = "visa")
    private WebElement visaCardCheckBox;
    @FindBy(id = "mastercard")
    private WebElement masterCardCheckBox;
    @FindBy(id = "amex")
    private WebElement amaricanExpressCheckBox;


    //Card nr
    @FindBy(id = "cardNumber")
    private WebElement cardNumberField;


    //expiryDate
    @FindBy(id = "expiryDate")
    private WebElement expiryDateField;
    @FindBy(xpath = "//button[contains(text(),'Process')]")
    private WebElement processButton;


    public OrderPage() {
        super();
    }

    public void selectProduct(String productName) {
        Select element = new Select(productDropdownElement);
        element.selectByVisibleText(productName);
    }

    public void enterQuantity(String quantity) {
        quantityInputField.clear();
        quantityInputField.sendKeys(quantity);
    }

    public void enterDiscount(String discount) {

        discountInputField.clear();
        discountInputField.sendKeys(discount);
    }

    public void clickCalculateButton() {
        calculateButton.click();
    }

    public String calculatePrice(String productName, String quantity, String discount) {
        selectProduct(productName);
        enterQuantity(quantity);
        enterDiscount(discount);
        clickCalculateButton();


        return totalInputPrice.getAttribute("value");

    }

    public void enterName(String name) {
        nameInputText.clear();
        nameInputText.sendKeys(name);
    }

    public void enterStreet(String street) {
        streetInputText.clear();
        streetInputText.sendKeys(street);
    }

    public void enterCity(String city) {
        cityInputText.clear();
        cityInputText.sendKeys(city);
    }

    public void enterState(String state) {
        stateInputText.clear();
        stateInputText.sendKeys(state);
    }

    public void enterZip(String zip) {
        zipInputText.clear();
        zipInputText.sendKeys(zip);
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
                visaCardCheckBox.click();
                break;
            case "mastercard":
                masterCardCheckBox.click();
                break;
            case "americanexpress":
                amaricanExpressCheckBox.click();
                break;
            default:
                System.out.println("Card type doesn't exists");
        }
    }

    public void enterCardNumber(String cardNo) {
        cardNumberField.clear();
        cardNumberField.sendKeys(cardNo);
    }

    public void enterExpiryDate(String expiryDate) {
        expiryDateField.clear();
        expiryDateField.sendKeys(expiryDate);
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
        processButton.click();
    }
}
