package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutOverviewPageTests extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        validLogin();
        addingTwoProductsForPurposeOfTesting();
        addCartPage.clikOnCheckoutButton();
        validInformationForCheckout();
    }

    @Test
    public void itIsCheckoutOverviewPage(){

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html");
        Assert.assertEquals(checkoutOverviewPage.titleCheckoutOverviewPage(), "Checkout: Overview");
        Assert.assertEquals(checkoutOverviewPage.information1(), "Payment Information:");
        Assert.assertEquals(checkoutOverviewPage.information2(), "Shipping Information:");
        Assert.assertEquals(checkoutOverviewPage.information3(), "Price Total");
        Assert.assertTrue(checkoutOverviewPage.cancelButton.isDisplayed());
        Assert.assertTrue(checkoutOverviewPage.finishButton.isDisplayed());

    }

    @Test
    public void cancelButtonIsCorrect(){

        checkoutOverviewPage.clikOnCancelButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void finishButtonIsCorrect(){

        checkoutOverviewPage.clikOnFinishButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-complete.html");
    }

    @AfterMethod
    public void clearCookies(){
        driver.manage().deleteAllCookies();
    }
}
