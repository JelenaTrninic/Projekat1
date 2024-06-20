package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutYourInfomractionPageTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        validLogin();
        addingTwoProductsForPurposeOfTesting();
        addCartPage.clikOnCheckoutButton();
    }

    @Test
    public void itIsChekoutYourInformationPage(){

        Assert.assertEquals(checkoutYourInformationPage.titleChecoutYourInformationPage(), "Checkout: Your Information");
        Assert.assertTrue(checkoutYourInformationPage.cancelButton.isDisplayed());
        Assert.assertTrue(checkoutYourInformationPage.continueButton.isDisplayed());
    }

    @Test
    public void successfulContinuingByFillingOfAllInformationsFields(){

        checkoutYourInformationPage.filloutFirstNameField("pera");
        checkoutYourInformationPage.filloutLastNameField("peric");
        checkoutYourInformationPage.filloutPostalCodeField("18000");
        checkoutYourInformationPage.clickOnContinueButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html");
    }

    @Test
    public void unsuccessfulContinuingByFiilingOnlyFirstNameField(){

        checkoutYourInformationPage.filloutFirstNameField("pera");
        checkoutYourInformationPage.clickOnContinueButton();

        Assert.assertEquals(checkoutYourInformationPage.getErrorMessage(), "Error: Last Name is required");

    }

    @Test
    public void unsuccessfulContinuingByFillingOnlyLastNameField(){

        checkoutYourInformationPage.filloutLastNameField("peric");
        checkoutYourInformationPage.clickOnContinueButton();

        Assert.assertEquals(checkoutYourInformationPage.getErrorMessage(), "Error: First Name is required");

    }

    @Test
    public void unsuccessfulContinuingByFillingOnlyPostalCodeField(){

        checkoutYourInformationPage.filloutPostalCodeField("18000");
        checkoutYourInformationPage.clickOnContinueButton();

        Assert.assertEquals(checkoutYourInformationPage.getErrorMessage(), "Error: First Name is required");

    }

    @Test
    public void uncussefulContinuingByFillingOnlyFirstAndLastNameFields(){

        checkoutYourInformationPage.filloutFirstNameField("pera");
        checkoutYourInformationPage.filloutLastNameField("peric");
        checkoutYourInformationPage.clickOnContinueButton();

        Assert.assertEquals(checkoutYourInformationPage.getErrorMessage(), "Error: Postal Code is required");

    }

    @Test
    public void unsuccessfulContinuingByFillingOnlyFirstNameAndPostalCodeFields(){

        checkoutYourInformationPage.filloutFirstNameField("pera");
        checkoutYourInformationPage.filloutPostalCodeField("18000");
        checkoutYourInformationPage.clickOnContinueButton();

        Assert.assertEquals(checkoutYourInformationPage.getErrorMessage(), "Error: Last Name is required");

    }

    @Test
    public void unsuccessfulContinuingByFillingOnlyLastNameAndPOstalCodeFields(){

        checkoutYourInformationPage.filloutLastNameField("peric");
        checkoutYourInformationPage.filloutPostalCodeField("18000");
        checkoutYourInformationPage.clickOnContinueButton();

        Assert.assertEquals(checkoutYourInformationPage.getErrorMessage(), "Error: First Name is required");


    }
    @AfterMethod
    public void clearCookies(){
        driver.manage().deleteAllCookies();
    }
}
