package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryPage {

    @FindBy(xpath = "//p[contains(text(),'HTC Touch')]/following::i[contains(@class, 'fa fa-shopping-cart')]")
    WebElement cartIcon;

    @FindBy(xpath = "//div[contains(@class, 'alert alert-success alert-dismissible')]")
    WebElement successAlert;

    public void addToCart() {
        cartIcon.click();
    }

    public String getSuccessAlertText() {
        return successAlert.getText();
    }

}
