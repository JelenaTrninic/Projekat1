package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void successfulLogin(){

        validLogin();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void unsuccessfulLoginNonPredifineUsernamePassword()  {

        loginPage.inputUsername("mika");
        loginPage.inputPassword("laza");
        loginPage.clikOnLoginButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertTrue(loginPage.getErrorMessage().equalsIgnoreCase("Epic sadface: Username and password do not match any user in this service"));
    }

    @Test

    public void uncecessfulLoginNonPredifineUsernamePredifinePassword(){

        loginPage.inputUsername("mika");
        loginPage.inputPassword("secret_sauce");
        loginPage.clikOnLoginButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertTrue(loginPage.getErrorMessage().equalsIgnoreCase("Epic sadface: Username and password do not match any user in this service"));
    }
    @Test

    public void uncecessfulLoginPredifineUsernameNonPredifinePassword(){

        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("mikic");
        loginPage.clikOnLoginButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertTrue(loginPage.getErrorMessage().equalsIgnoreCase("Epic sadface: Username and password do not match any user in this service"));
    }

    @Test
    public void uncecessfulLoginWithUsernameOnly(){

        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("");
        loginPage.clikOnLoginButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertTrue(loginPage.getErrorMessage().equalsIgnoreCase("Epic sadface: Password is required"));
    }

    @Test
    public void uncecessfulLoginWithPasswordOnly(){

        loginPage.inputUsername("");
        loginPage.inputPassword("secret_sauce");
        loginPage.clikOnLoginButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertTrue(loginPage.getErrorMessage().equalsIgnoreCase("Epic sadface: Username is required"));
    }

    @Test
    public void uncecessfulLoginBlankUsrenameAndPassword(){

        loginPage.inputUsername("");
        loginPage.inputPassword("secret_sauce");
        loginPage.clikOnLoginButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertTrue(loginPage.getErrorMessage().equalsIgnoreCase("Epic sadface: Username is required"));
    }

    @AfterMethod
    public void clearCookies(){
        driver.manage().deleteAllCookies();
    }
}
