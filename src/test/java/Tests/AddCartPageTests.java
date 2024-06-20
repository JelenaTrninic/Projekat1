package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddCartPageTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        validLogin();
    }

    @Test
    public void itIsAddCartPage() {
        addingTwoProductsForPurposeOfTesting();

        Assert.assertEquals(addCartPage.getTitleAddCartPage(), "Your Cart");
        Assert.assertTrue(addCartPage.continueShoppingButton.isDisplayed());
        Assert.assertTrue(addCartPage.removeButtonAddCartPage.isDisplayed());
        Assert.assertTrue(addCartPage.checkoutButton.isDisplayed());
    }

    @Test
    public void continueShoppingButtonIsCorrect() {

        addingTwoProductsForPurposeOfTesting();
        addCartPage.clikOnContinueShoppingButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

    }

    @Test
    public void removeButtonAddCartPageIsCorrect() {

        addingTwoProductsForPurposeOfTesting();
        addCartPage.clikOnRemoveButtonAddCartPage();

        Assert.assertEquals(homePage.numberInshoppingbutton.getText(), "1");

    }

    @Test
    public void checkoutButtonIsCorrect() {

        addingTwoProductsForPurposeOfTesting();
        addCartPage.clikOnCheckoutButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html");


    }

    @Test
    public void userCanNotChangeQuantity() {
        addingTwoProductsForPurposeOfTesting();


        Assert.assertTrue(addCartPage.listOfQuanityFieldsAddCartPage.getFirst().isDisplayed());
        Assert.assertTrue(addCartPage.listOfQuanityFieldsAddCartPage.get(1).isDisplayed());

        try {
            addCartPage.changeQuantity();
        } catch (Exception e) {

        }
        Assert.assertNotEquals(addCartPage.getQuantity(0),"2");
        Assert.assertNotEquals(addCartPage.getQuantity(1),"2");
    }

    @AfterMethod
    public void clearCookies(){
        driver.manage().deleteAllCookies();
    }
}
