package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FinishPageTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        validLogin();
        addingTwoProductsForPurposeOfTesting();
        addCartPage.clikOnCheckoutButton();
        validInformationForCheckout();
        checkoutOverviewPage.clikOnFinishButton();
    }

    @Test
    public void itIsFinishPage(){

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-complete.html");
        Assert.assertEquals(finishPage.getTitleFinsihPage(), "Checkout: Complete!");
        Assert.assertTrue(finishPage.titleFinishPage.isDisplayed());
        Assert.assertTrue(finishPage.thankYouMessage.isDisplayed());
        Assert.assertEquals(finishPage.getThankYouMessage(), "Thank you for your order!");
        Assert.assertTrue(finishPage.backHomeButton.isDisplayed());
        Assert.assertTrue(isElementNotPresent, "Element koji označava broj proizvoda u korpi nije prisutan i nula je!");
        Assert.assertTrue(finishPage.messageShipping.isDisplayed());
        Assert.assertEquals(finishPage.getShippingMessage(), "Your order has been dispatched, and will arrive just as fast as the pony can get there!");
    }

    @Test
    public void backToProdutcsButtonIsCorrect(){
        finishPage.clikOnBackHomeButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @AfterMethod
    public void clearCookies(){
        driver.manage().deleteAllCookies();
    }
}
