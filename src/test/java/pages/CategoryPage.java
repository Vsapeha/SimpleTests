package pages;

import models.ProductData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
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

    @FindBy(id = "wishlist-total")
    WebElement wishlistPage;


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