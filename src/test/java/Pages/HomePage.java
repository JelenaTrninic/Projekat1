package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HomePage extends BaseTest {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(className = "bm-item")
    public List<WebElement> menuOptions;

    @FindBy(css = "option[value='az']")
    public WebElement sortOptionNamesAToZ;

    @FindBy(css = "option[value='za']")
    public WebElement sortOptionNamestZToA;

    @FindBy(css = "option[value='lohi']")
    public WebElement sortOptionPriceLowToHigh;

    @FindBy(css = "option[value='hilo']")
    public WebElement sortOptionPriceHighToLow;

    @FindBy(className = "inventory_item_name")
    public List<WebElement> productsNames;

    @FindBy(className = "inventory_item_price")
    public List<WebElement> productsPrices;

    @FindBy(id = "react-burger-menu-btn")
    public WebElement menuButton;

    @FindBy(className = "inventory_item_description")
    public List<WebElement> productContainer;

    @FindBy(className = "shopping_cart_badge")
    public WebElement numberInshoppingbutton;

    @FindBy(className = "shopping_cart_link")
    public WebElement shoppingButton;

    @FindBy(className = "social_twitter")
    public WebElement twitterIcon;

    @FindBy(className = "social_facebook")
    public WebElement fbIcon;

    @FindBy(className = "social_linkedin")
    public WebElement linkendinIcon;


    //------------------------------------------------------

    public void clickOnLinkendinIcon(){
        linkendinIcon.click();
    }

    public void clikOnFbIcon(){
        fbIcon.click();
    }

    public void clikOnTwitterIcon(){
        twitterIcon.click();
    }



    public void clikOnShoppingButton(){
        shoppingButton.click();
    }

    //clink on product by its name passed in the method
    public void clickOnProductName(String productName) {

        for (int i = 0; i < productsNames.size(); i++) {
            if (productsNames.get(i).getText().contains(productName)) {
                productsNames.get(i).click();
                break;
            }
        }
    }

    //the element is extracted from the parent (product container)
    public WebElement removeHomePageButton(String productName) {

        WebElement button = null;

        for (int i = 0; i < productContainer.size(); i++) {
            if (productContainer.get(i).getText().contains(productName)) {
                button = productContainer.get(i).findElement(By.cssSelector(".btn.btn_secondary.btn_small.btn_inventory"));
                break;
            }
        }
        return button;
    }

    public void clickOnRemoveHomePageButton(String productName) {
        for (int i = 0; i < productContainer.size(); i++) {
            if (productContainer.get(i).getText().contains(productName)) {
                productContainer.get(i).findElement(By.cssSelector(".btn.btn_secondary.btn_small.btn_inventory")).click();
                break;
            }
        }
    }

    //the element is extracted from the parent (product container)
    public WebElement addButton(String nameOfProduct) {
        WebElement addButton = null;
        for (int i = 0; i < productContainer.size(); i++) {
            if (productContainer.get(i).getText().contains(nameOfProduct)) {
                addButton= productContainer.get(i).findElement(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory"));
                break;
            }
        }
        return addButton;
    }
    public void clikOnAddButton(String nameOfProduct) {
        for (int i = 0; i < productContainer.size(); i++) {
            if (productContainer.get(i).getText().contains(nameOfProduct)) {
               productContainer.get(i).findElement(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory")).click();
                break;
            }
        }
    }

    public void clikOnMenuButton(){
        menuButton.click();
    }

    public void clickOnMenuOption(String menuOption) {
        for (int i = 0; i < menuOptions.size(); i++) {
            if (menuOptions.get(i).getText().equals(menuOption)) {
                menuOptions.get(i).click();
                break;
            }
        }
    }

    public WebElement menuOptionAllItems(){
        return menuOptions.get(0);
    }

    public WebElement menuOptionAbout(){
        return menuOptions.get(1);
    }

    public WebElement menuOptionLogout(){
        return menuOptions.get(2);
    }

    public WebElement menuOptionResetAppState(){
        return menuOptions.get(3);
    }

    //First step in sorting products by price: getting prices as Strings
    public List<String> listOfProductsPricesAsString() {
        List<String> prices = new ArrayList<>();
        for (int i = 0; i < productsPrices.size(); i++) {
            prices.add(productsPrices.get(i).getText());
        }
        return prices;
    }

    //Second step in sorting products by price: removing currecny simbol form the prices as Strings
    public List<String> listOfProductsPricesAsWithoutSimbol() {
        List<String> pricesWtihoutSimbol= new ArrayList<>();
        for (int i = 0; i < listOfProductsPricesAsWithoutSimbol().size(); i++) {
            String price = listOfProductsPricesAsWithoutSimbol().get(i);
            pricesWtihoutSimbol.add(price.substring(1));
        }
        return pricesWtihoutSimbol;
    }

    //Third step in sorting products by price: converting prices from Strings to Doubles
    public List<Double> listOfProductsPrices(){
        List<Double> pricesAsDoubles = new ArrayList<>();
        for (String price : listOfProductsPricesAsWithoutSimbol()) {
            pricesAsDoubles.add(Double.parseDouble(price));
        }
        return pricesAsDoubles;
    }

    //Final step in sorting products by price: sorting prices by Asc order using Collection.sort class/method
    public List<Double> sortListOfPricesAsc() {
        List<Double> pricesAsc = listOfProductsPrices();
        Collections.sort(pricesAsc);
        return pricesAsc;
    }

    //Final step in sorting products by price: sorting prices by Dsc order using Collection.sort class/method
    public List<Double> sortListOfPricesDsc() {
        List<Double> pricesDsec = listOfProductsPrices();
        Collections.sort(pricesDsec, Comparator.reverseOrder());
        return pricesDsec;
    }

    //First step in sorting products by name: getting names as Strings
    public List<String> listOfProductsNames() {
        List<String> names = new ArrayList<>();
        for (int i = 0; i < productsNames.size(); i++) {
            names.add(productsNames.get(i).getText());
        }
        return names;
    }

    //Final step in sorting products by name: sorting names by Asc order using Collection.sort class/method
    public List<String> sortListOfNamesAsc() {
        Collections.sort(listOfProductsNames());
        List<String> sortListAsc = new ArrayList<>(listOfProductsNames());
        return sortListAsc;
    }

    //Final step in sorting products by name: sorting names by Dsc order using Collection.sort class/method
    public List<String> sortListOfNamesDesc() {
        Collections.sort(listOfProductsNames(), Collections.reverseOrder());
        List<String> sortListDesc = new ArrayList<>(listOfProductsNames());
        return sortListDesc;
    }


    public void clikOnSortOptionNameAToZ(){
        sortOptionNamesAToZ.click();
    }

    public void clikOnSortOptionNameZToA(){
        sortOptionNamestZToA.click();
    }

    public void clikOnSortOptionPriceLowToHigh(){
        sortOptionPriceLowToHigh.click();
    }

    public void clikOnSortOptionPriceHighToLow(){
        sortOptionPriceHighToLow.click();
    }

}
