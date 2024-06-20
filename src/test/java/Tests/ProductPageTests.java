package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductPageTests extends BaseTest {
    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        validLogin();
    }

    @Test

    public void clikOnProductNameIsCorrect() throws InterruptedException {

        homePage.clickOnProductName("Sauce Labs Backpack");
        Assert.assertEquals(productPage.titleProductPage.getText(), "Sauce Labs Backpack");

        back();

        homePage.clickOnProductName("Sauce Labs Bike Light");
        Assert.assertEquals(productPage.titleProductPage.getText(), "Sauce Labs Bike Light");

        back();

        homePage.clickOnProductName("Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(productPage.titleProductPage.getText(), "Sauce Labs Bolt T-Shirt");

        back();

        homePage.clickOnProductName("Sauce Labs Fleece Jacket");
        Assert.assertEquals(productPage.titleProductPage.getText(), "Sauce Labs Fleece Jacket");

        back();

        homePage.clickOnProductName("Sauce Labs Onesie");
        Assert.assertEquals(productPage.titleProductPage.getText(), "Sauce Labs Onesie");

        back();

        homePage.clickOnProductName("Test.allTheThings() T-Shirt (Red)");
        Assert.assertEquals(productPage.titleProductPage.getText(), "Test.allTheThings() T-Shirt (Red)");
    }

    @Test
    public void backToProductsButtonIsDisplayed(){

        homePage.clickOnProductName("Sauce Labs Backpack");

        Assert.assertTrue(productPage.backToProductsButton.isDisplayed());

        productPage.clikOnBackToProductsButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

    }

    @Test
    public void userCanAddProductFromProductPage(){

        homePage.clickOnProductName("Sauce Labs Backpack");
        productPage.clikOnAddToCartButtonProductPage();

        Assert.assertEquals(productPage.removeButtonProductPage.getText(), "Remove");
        Assert.assertEquals(homePage.numberInshoppingbutton.getText(), "1");
}

    @Test
    public void userCanAddMoreProductsFromProductsPages(){
        homePage.clickOnProductName("Sauce Labs Backpack");
        productPage.clikOnAddToCartButtonProductPage();
        Assert.assertEquals(productPage.removeButtonProductPage.getText(), "Remove");

        back();

        homePage.clickOnProductName("Sauce Labs Bike Light");
        productPage.clikOnAddToCartButtonProductPage();
        Assert.assertEquals(productPage.removeButtonProductPage.getText(), "Remove");

        Assert.assertEquals(homePage.numberInshoppingbutton.getText(), "2");

        back();

       Assert.assertEquals(homePage.removeHomePageButton("Sauce Labs Backpack").getText(), "Remove");
       Assert.assertEquals(homePage.removeHomePageButton("Sauce Labs Bike Light").getText(), "Remove");
}

    @Test
    public void removeButtonOnProductPageIsCorrect(){

        homePage.clickOnProductName("Sauce Labs Backpack");
        productPage.clikOnAddToCartButtonProductPage();

        back();

        homePage.clickOnProductName("Sauce Labs Bike Light");
        productPage.clikOnAddToCartButtonProductPage();

        back();

        homePage.clickOnProductName("Sauce Labs Backpack");
        productPage.clikOnRemoveButtonProductPage();

        Assert.assertEquals(homePage.numberInshoppingbutton.getText(), "1");
        Assert.assertTrue(productPage.addToCartButtonProductPage.isDisplayed());

}
    @AfterMethod
    public void clearCookies(){
        driver.manage().deleteAllCookies();
    }
}