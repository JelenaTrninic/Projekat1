package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutYourInformationPage extends BaseTest {

    public CheckoutYourInformationPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "title")
    public WebElement titleCheckoutYourInformationPage;

    @FindBy(css = ".btn.btn_secondary.back.btn_medium.cart_cancel_link")
    public WebElement cancelButton;

    @FindBy(id = "continue")
    public WebElement continueButton;

    @FindBy(id = "first-name")
    public WebElement firstNameField;

    @FindBy(id = "last-name")
    public WebElement lastNameField;

    @FindBy(id = "postal-code")
    public WebElement postalCodeField;

    @FindBy(css = "h3[data-test='error']")
    public WebElement errorMessage;


    //----------------------------------------

    public String titleChecoutYourInformationPage(){
        return titleCheckoutYourInformationPage.getText();
    }

    public void clikOnCancelButton(){
        cancelButton.click();
    }

    public void clickOnContinueButton(){
        continueButton.click();
    }

    public void filloutFirstNameField(String name){
        firstNameField.clear();
        firstNameField.sendKeys(name);
    }

    public void filloutLastNameField(String lastname){
        lastNameField.clear();
        lastNameField.sendKeys(lastname);
    }

    public void filloutPostalCodeField(String code){
        postalCodeField.clear();
        postalCodeField.sendKeys(code);
    }

    public String getErrorMessage(){

        return errorMessage.getText();

    }
}
