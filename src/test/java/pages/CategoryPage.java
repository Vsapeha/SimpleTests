package pages;

import models.ProductData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;
import java.util.stream.Collectors;


public class CategoryPage extends PageBase {

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//p[contains(text(),'HTC Touch')]/following::i[contains(@class, 'fa fa-shopping-cart')]")
    WebElement htcCartIcon;

    @FindBy(xpath = "//div[contains(@class, 'alert alert-success alert-dismissible')]")
    WebElement successAlert;

    @FindBy(xpath = "//button[contains(@class, 'btn btn-danger btn-xs')]")
    WebElement deleteButton;

    @FindBy(xpath = "//div[contains(@class, 'product-thumb')]")
    List<WebElement> productsList;

    @FindBy(id = "wishlist-total")
    WebElement wishlistPage;

    String titleXPathLocator = ".//div[contains(@class, 'caption')]//a";
    String priceXPathLocator = ".//p[contains(@class, 'price')]";
    String priceNewXPathLocator = ".//p[contains(@class, 'price')]//span[contains(@class, 'price-new')]";
    String priceOldXPathLocator = ".//p[contains(@class, 'price')]//span[contains(@class, 'price-old')]";
    String priceTaxXPathLocator = ".//p[contains(@class, 'price')]//span[contains(@class, 'price-tax')]";
    String addToCartXPathLocator = ".//button[contains(@onclick, 'cart.add')]";
    String addToWishlistXPathLocator = ".//button[contains(@onclick, 'wishlist.add')]";
    String compareXPathLocator = ".//button[contains(@onclick, 'compare.add')]";

    // methods of old tests (without product model)
    public void addToCart() {
        htcCartIcon.click();
    }

    public String getSuccessAlertText() {
        return successAlert.getText();
    }

    public void deleteFromCartViaCheckout() {
        deleteButton.click();
    }

    public int getNumberOfProducts() {
        return productsList.size();
    }

    // methods of new tests (with product model)

    public List<ProductData> allProducts() {
        List<ProductData> products = new ArrayList<>();
        List<WebElement> elements = productsList;
        for (WebElement element : elements) {
            String title = element.findElement(By.xpath(titleXPathLocator)).getText();
            String priceInitial = element.findElement(By.xpath(priceXPathLocator)).getText();
            String priceTax = element.findElement(By.xpath(priceTaxXPathLocator)).getText();
            String priceInitialWithBlankSpaces = priceInitial.replace(priceTax,"");
            String price = priceInitialWithBlankSpaces.replaceAll("\\s","");
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

    public List<ProductData> addProductsWithTestTitlesToWishlist() {
        String testTitleFirst = "Apple";
        String testTitleSecond = "Samsung";
        List<ProductData> products = allProducts();
        List<ProductData> productsWithTestTitles = products
                .stream()
                .filter(c -> c.getTitle().contains(testTitleFirst) || c.getTitle().contains(testTitleSecond))
                .collect(Collectors.toList());
        for (ProductData p : productsWithTestTitles) {
            p.addToWishlistButton.click();

        }
        return productsWithTestTitles;
    }



        public void goToWishlistPage() {
        wishlistPage.click();
    }
}