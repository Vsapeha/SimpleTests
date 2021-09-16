package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage {
    @FindBy(xpath = ".//span[contains(text(),'My Account')]")
    WebElement myAccountIcon;

    @FindBy(xpath = ".//a[contains(text(),'Login')]")
    WebElement loginOption;

    @FindBy(linkText = "Desktops")
    WebElement topMenuCategory;

    @FindBy(xpath = "//a[contains(@class, 'see-all')][1]")
    WebElement seeAllCategoryProducts;

    @FindBy(xpath = ".//span[contains(text(),'item(s)')]")
    WebElement checkoutButton;


    public void goToLoginPage() {
        myAccountIcon.click();
        loginOption.click();
    }

    public void goToCategoryPage() {
        topMenuCategory.click();
        seeAllCategoryProducts.click();
    }

    public String getCheckoutButtonInfo() {
        return checkoutButton.getText();
    }
}

