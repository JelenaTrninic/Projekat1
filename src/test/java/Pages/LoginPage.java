package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="user-name")
    public WebElement usernameField;

    @FindBy(id="password")
    public WebElement passwordField;

    @FindBy(id="login-button")
    public WebElement loginButton;


    //The locator is the same for all error messages that occur during login
    @FindBy(css = "h3[data-test='error']")
    public WebElement errorMessage;



    //------------------------------------------------------------------------------------------------------------

    public void inputUsername(String userName){
        usernameField.sendKeys(userName);
    }

    public void inputPassword(String password){
        passwordField.sendKeys(password);
    }

    public void clikOnLoginButton(){
        loginButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }


}
