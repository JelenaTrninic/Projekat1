package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BaseTest {

    public ProductPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".inventory_details_name.large_size")
    public WebElement titleProductPage;

    @FindBy(css = ".btn.btn_secondary.back.btn_large.inventory_details_back_button")
    public WebElement backToProductsButton;

    @FindBy(css = ".btn.btn_primary.btn_small.btn_inventory")
    public WebElement addToCartButtonProductPage;

    @FindBy(css = ".btn.btn_secondary.btn_small.btn_inventory")
    public WebElement removeButtonProductPage;





    //-------------------------------------------------------------------------

    public void clikOnBackToProductsButton(){
        backToProductsButton.click();
    }

    public void clikOnAddToCartButtonProductPage(){
        addToCartButtonProductPage.click();
    }

    public void clikOnRemoveButtonProductPage(){
        removeButtonProductPage.click();
    }


}
