package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinishPage extends BaseTest {

    public FinishPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "title")
    public WebElement titleFinishPage;

    @FindBy(className = "complete-header")
    public WebElement thankYouMessage;

    @FindBy(id = "back-to-products")
    public WebElement backHomeButton;

    @FindBy(className = "complete-text")
    public WebElement messageShipping;




    //---------------------------------------------

    public String getTitleFinsihPage(){
        return titleFinishPage.getText();
    }
    public String getThankYouMessage(){
        return thankYouMessage.getText();
    }

    public void clikOnBackHomeButton(){
        backHomeButton.click();
    }

    public String getShippingMessage(){
        return messageShipping.getText();
    }






}
