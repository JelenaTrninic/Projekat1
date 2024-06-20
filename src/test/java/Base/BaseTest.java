package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    public WebDriverWait wait;
    public LoginPage loginPage;
    public String message1;
    public HomePage homePage;
    public ProductPage productPage;
    public AddCartPage addCartPage;
    public CheckoutYourInformationPage checkoutYourInformationPage;
    public CheckoutOverviewPage checkoutOverviewPage;
    public FinishPage finishPage;

    /*Needed to test an element that disappears after a certain action (HomePageTest otpionResetAppStateIscorrect,
    FinishPageTest itIsFinishPage)
     */
    public boolean isElementNotPresent;

    //needed for geting URL in another window in broweser
    public String mainWindowHandle;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage=new LoginPage();
        homePage=new HomePage();
        productPage=new ProductPage();
        addCartPage=new AddCartPage();
        checkoutYourInformationPage=new CheckoutYourInformationPage();
        checkoutOverviewPage=new CheckoutOverviewPage();
        finishPage=new FinishPage();
        isElementNotPresent =driver.findElements(By.className("shopping_cart_badge")).isEmpty();
        mainWindowHandle = driver.getWindowHandle();
    }

    //-------------------------------------------------------------------------------------

    //Methods that are often called in classes

    public void validInformationForCheckout(){
        checkoutYourInformationPage.filloutFirstNameField("pera");
        checkoutYourInformationPage.filloutLastNameField("peric");
        checkoutYourInformationPage.filloutPostalCodeField("18000");
        checkoutYourInformationPage.clickOnContinueButton();
    }

    public void addingTwoProductsForPurposeOfTesting(){

        homePage.clikOnAddButton("Sauce Labs Backpack");
        homePage.clikOnAddButton("Sauce Labs Bike Light");
        homePage.clikOnShoppingButton();
    }

    public void validLogin() {

        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clikOnLoginButton();
    }

    public void waitForElementVisibility(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementClikability(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void back(){
        driver.navigate().back();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
