package pages;

import models.ProductData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class StartPage extends PageBase {

    public StartPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//a[contains(text(),'Login')]")
    WebElement loginOption;

    @FindBy(linkText = "Desktops")
    WebElement topDesktopsCategory;

    @FindBy(linkText = "Components")
    WebElement topComponentsCategory;

    @FindBy(linkText = "Cameras")
    WebElement topCamerasCategory;

    @FindBy(partialLinkText = "Monitors")
    WebElement topMonitorsSubcategory;

    @FindBy(xpath = "//a[contains(@class, 'see-all')][1]")
    WebElement seeAllCategoryProducts;

    @FindBy(xpath = "//form[@id='form-currency']//strong")
    WebElement currencyIcon;

    @FindBy(name = "GBP")
    WebElement currencyPound;

    @FindBy(name = "EUR")
    WebElement currencyEuro;

    @FindBy(name = "USD")
    WebElement currencyDollar;


    public List<ProductData> allProducts() {
        List<ProductData> products = new ArrayList<>();
        List<WebElement> elements = productsList;
        for (WebElement element : elements) {
            String title = element.findElement(By.xpath(titleXPathLocator)).getText();
            String priceInitial = element.findElement(By.xpath(priceXPathLocator)).getText();
            String priceTax = element.findElement(By.xpath(priceTaxXPathLocator)).getText();
            String priceInitialWithBlankSpaces = priceInitial.replace(priceTax, "");
            String price = priceInitialWithBlankSpaces.replaceAll("\\s", "");
            String priceNew;
            String priceOld;
            try {
                WebElement priceNewElement = element.findElement(By.xpath(priceNewXPathLocator));
                priceNew = priceNewElement.getText();
            } catch (Exception e) {
                priceNew = null;
            }
            try {
                WebElement priceOldElements = element.findElement(By.xpath(priceOldXPathLocator));
                priceOld = priceOldElements.getText();
            } catch (Exception e) {
                priceOld = null;
            }
            if (priceOld != null) {
                price = null;
            }
            WebElement addToCart = element.findElement(By.xpath(addToCartXPathLocator));
            WebElement addToWishlist = element.findElement(By.xpath(addToWishlistXPathLocator));
            WebElement compare = element.findElement(By.xpath(compareXPathLocator));
            ProductData product = new ProductData(title, null, null, price, priceNew, priceOld, priceTax, addToCart,
                    addToWishlist, compare, null, null);
            products.add(product);
        }
        return products;
    }

    public void goToLoginPage() {
        myAccountIcon.click();
        loginOption.click();
    }

    public void goToDesktopsCategoryPage() {
        topDesktopsCategory.click();
        seeAllCategoryProducts.click();
    }

    public void goToCamerasCategoryPage() {
        topCamerasCategory.click();
    }

    public void goToMonitorsSubcategoryPage() {
        topComponentsCategory.click();
        topMonitorsSubcategory.click();
    }
    public String getCurrency() {
        return currencyIcon.getText();
    }

    public void changeCurrencyToPound() {
        currencyIcon.click();
        currencyPound.click();
    }

    public void changeCurrencyToEuro() {
        currencyIcon.click();
        currencyEuro.click();
    }

    public void changeCurrencyToDollar() {
        currencyIcon.click();
        currencyDollar.click();



    }
}













