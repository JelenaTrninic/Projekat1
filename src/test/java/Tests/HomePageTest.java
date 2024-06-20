package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class HomePageTest extends BaseTest {


    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        validLogin();

    }

@Test
    public void sortOptionsAreDisplayed(){

    homePage.clikOnSortOptionNameAToZ();
    homePage.clikOnSortOptionNameZToA();
    homePage.clikOnSortOptionPriceLowToHigh();
    homePage.clikOnSortOptionPriceHighToLow();


    Assert.assertEquals(homePage.sortOptionNamesAToZ.getText(), "Name (A to Z)");
    Assert.assertTrue(homePage.sortOptionNamesAToZ.isDisplayed());

    Assert.assertEquals(homePage.sortOptionNamestZToA.getText(), "Name (Z to A)");
    Assert.assertTrue(homePage.sortOptionNamestZToA.isDisplayed());

    Assert.assertEquals(homePage.sortOptionPriceLowToHigh.getText(), "Price (low to high)");
    Assert.assertTrue(homePage.sortOptionPriceLowToHigh.isDisplayed());

    Assert.assertEquals(homePage.sortOptionPriceHighToLow.getText(), "Price (high to low)");
    Assert.assertTrue(homePage.sortOptionPriceHighToLow.isDisplayed());

}

@Test
    public void sortOptitonNameAToZIsCorrect()  {

    homePage.clikOnSortOptionNameAToZ();
    Assert.assertEquals(homePage.listOfProductsNames(), homePage.sortListOfNamesAsc());

}

@Test
    public void sortOptitonNameZToAIsCorrect(){

    homePage.clikOnSortOptionNameZToA();
    Assert.assertEquals(homePage.listOfProductsNames(), homePage.sortListOfNamesDesc());

}

@Test
    public void sortOptitonPriceLowToHighIsCorrect(){

    homePage.clikOnSortOptionPriceLowToHigh();
    Assert.assertEquals(homePage.listOfProductsPrices(), homePage.sortListOfPricesAsc());

}

@Test
    public void sortOptitonPriceHighToLowIsCorrect(){

    homePage.clikOnSortOptionPriceHighToLow();
    Assert.assertEquals(homePage.listOfProductsPrices(), homePage.sortListOfPricesDsc());

}

@Test
    public void menuOptionsAreDisplayed() throws InterruptedException {

     Assert.assertTrue(homePage.menuButton.isDisplayed());

     homePage.clikOnMenuButton();

     waitForElementVisibility(homePage.menuOptionAllItems());

     Assert.assertTrue(homePage.menuOptionAllItems().isDisplayed());
     Assert.assertEquals(homePage.menuOptionAllItems().getText(), "All Items");

     waitForElementVisibility(homePage.menuOptionAbout());

     Assert.assertTrue(homePage.menuOptionAbout().isDisplayed());
     Assert.assertEquals(homePage.menuOptionAbout().getText(), "About");

     waitForElementVisibility(homePage.menuOptionLogout());

     Assert.assertTrue(homePage.menuOptionLogout().isDisplayed());
     Assert.assertEquals(homePage.menuOptionLogout().getText(), "Logout");

     waitForElementVisibility(homePage.menuOptionResetAppState());

     Assert.assertTrue(homePage.menuOptionResetAppState().isDisplayed());
     Assert.assertEquals(homePage.menuOptionResetAppState().getText(), "Reset App State");

}

@Test
    public void menuOptionAllItemsIsCorrect(){

    homePage.clikOnMenuButton();

    waitForElementVisibility(homePage.menuOptionAllItems());

    homePage.clickOnMenuOption("All Items");
    Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
}

@Test
    public void menuOptionAboutIsCorrect(){

    homePage.clikOnMenuButton();

    waitForElementVisibility(homePage.menuOptionAbout());

    homePage.clickOnMenuOption("About");
    Assert.assertEquals(driver.getCurrentUrl(), "https://saucelabs.com/");
}

@Test
    public void menuOptionLogoutIsCorrect(){

    homePage.clikOnMenuButton();

    waitForElementVisibility(homePage.menuOptionLogout());

    homePage.clickOnMenuOption("Logout");
    Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");

}

@Test
    public void otpionResetAppStateIscorrect() throws InterruptedException {

    homePage.clikOnAddButton("Sauce Labs Backpack");
    Assert.assertEquals(homePage.numberInshoppingbutton.getText(), "1");

    homePage.clikOnMenuButton();
    waitForElementClikability(homePage.menuOptionResetAppState());
    homePage.menuOptionResetAppState().click();

    Assert.assertTrue(isElementNotPresent, "Element koji označava broj proizvoda u korpi nije prisutan i nula je!");

    }

@Test
   public void userCanAddProductToCartFromHomePage()  {


    homePage.clikOnAddButton("Sauce Labs Backpack");

    Assert.assertEquals(homePage.removeHomePageButton("Sauce Labs Backpack").getText(), "Remove");
    Assert.assertEquals(homePage.numberInshoppingbutton.getText(), "1");
}

@Test
    public void userCanAddMoreProductsToCartFromHomePage(){

    homePage.clikOnAddButton("Sauce Labs Backpack");
    homePage.clikOnAddButton("Sauce Labs Bike Light");

    Assert.assertEquals(homePage.removeHomePageButton("Sauce Labs Backpack").getText(), "Remove");
    Assert.assertEquals(homePage.removeHomePageButton("Sauce Labs Bike Light").getText(), "Remove");
    Assert.assertEquals(homePage.numberInshoppingbutton.getText(), "2");
}

@Test
    public void removeButtonOnHomePageIsCorrect(){

    homePage.clikOnAddButton("Sauce Labs Backpack");
    homePage.clikOnAddButton("Sauce Labs Bike Light");
    homePage.clickOnRemoveHomePageButton("Sauce Labs Bike Light");

    Assert.assertEquals(homePage.numberInshoppingbutton.getText(), "1");
    Assert.assertTrue(homePage.addButton("Sauce Labs Bike Light").isDisplayed());
}

@Test
    public void userCanAccessShoppingCartFromHomePage(){

    homePage.clikOnAddButton("Sauce Labs Backpack");
    homePage.numberInshoppingbutton.click();

    Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");

}

@Test
    public void twitterIconIsCorrect() {

    homePage.clikOnTwitterIcon();

    Set<String> windowHandles = driver.getWindowHandles();
    for (String handle : windowHandles) {
        if (!handle.equals(mainWindowHandle)) {

            driver.switchTo().window(handle);


            Assert.assertEquals(driver.getCurrentUrl(), "https://x.com/saucelabs?mx=2");
        }
    }
}

@Test
    public void fbIconIsCorrect() {
    homePage.clikOnFbIcon();

    Set<String> windowHandles = driver.getWindowHandles();
    for (String handle : windowHandles) {
        if (!handle.equals(mainWindowHandle)) {

            driver.switchTo().window(handle);

            Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/saucelabs");

        }
    }
}

@Test
    public void linkendinIconIsCorrect(){

        homePage.clickOnLinkendinIcon();

    Set<String> windowHandles = driver.getWindowHandles();
    for (String handle : windowHandles) {
        if (!handle.equals(mainWindowHandle)) {

            driver.switchTo().window(handle);

            Assert.assertEquals(driver.getCurrentUrl(), "https://www.linkedin.com/company/sauce-labs/");

        }
    }
}
    @AfterMethod
    public void clearCookies(){
        driver.manage().deleteAllCookies();
    }
}


