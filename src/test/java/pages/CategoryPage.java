package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CategoryPage {

    @FindBy(xpath = "//p[contains(text(),'HTC Touch')]/following::i[contains(@class, 'fa fa-shopping-cart')]")
    WebElement cartIcon;

    @FindBy(xpath = "//div[contains(@class, 'alert alert-success alert-dismissible')]")
    WebElement successAlert;

    @FindBy(xpath = "//button[contains(@class, 'btn btn-danger btn-xs')]") // DELETE button from checkout dropdown
    WebElement deleteButton;

    @FindBy(xpath = "//div[contains(@class, 'product-thumb')]")
    List<WebElement> productsList;

    public void addToCart() {
        cartIcon.click();
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


}
