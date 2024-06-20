package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddCartPage extends BaseTest {

    public AddCartPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "title")
    public WebElement titleAddCartPage;

    @FindBy(css = ".btn.btn_secondary.back.btn_medium")
    public WebElement continueShoppingButton;

    @FindBy(css = ".btn.btn_secondary.btn_small.cart_button")
    public WebElement removeButtonAddCartPage;

    @FindBy(css = ".btn.btn_action.btn_medium.checkout_button")
    public WebElement checkoutButton;

    @FindBy(className = "cart_quantity")
    public List<WebElement> listOfQuanityFieldsAddCartPage;

    @FindBy(className = "shopping_cart_badge")
    public WebElement numberInshoppingcart;



    //-----------------------------------------

    //needed for test userCanNotChangeQuantity

    public String getQuantity(int j){
        String number="";
        for(int i=0; i<listOfQuanityFieldsAddCartPage.size(); i++){
            number=listOfQuanityFieldsAddCartPage.get(j).getText();
        }
        return number;
    }

    ////needed for test userCanNotChangeQuantity
    public void changeQuantity(){
        for(int i=0; i<listOfQuanityFieldsAddCartPage.size(); i++){
            listOfQuanityFieldsAddCartPage.get(i).sendKeys("2");
        }
    }



    public String getTitleAddCartPage(){
        return titleAddCartPage.getText();
    }

    public void clikOnContinueShoppingButton(){
        continueShoppingButton.click();
    }

    public void clikOnRemoveButtonAddCartPage(){
        removeButtonAddCartPage.click();
    }

    public void clikOnCheckoutButton(){
        checkoutButton.click();
    }


}
