package Pages;

import Base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutOverviewPage extends BaseTest {

    public CheckoutOverviewPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "title")
    public WebElement titleCheckoutOverviewPage;

    @FindBy(className = "summary_info_label")
    public List<WebElement> listOfNecessaryBillingInformations;

    @FindBy(id = "finish")
    public WebElement finishButton;

    @FindBy(id = "cancel")
    public WebElement cancelButton;


    //--------------------------------------------------

    public void clikOnCancelButton(){
        cancelButton.click();
    }

    public void clikOnFinishButton(){
        finishButton.click();
    }

    public String titleCheckoutOverviewPage() {
        return titleCheckoutOverviewPage.getText();
    }

    public String information1(){
        return listOfNecessaryBillingInformations.get(0).getText();
    }
    public String information2(){
        return listOfNecessaryBillingInformations.get(1).getText();
    }
    public String information3(){
        return listOfNecessaryBillingInformations.get(2).getText();
    }
}
