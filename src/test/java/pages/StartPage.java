package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage {
    @FindBy(xpath = ".//span[contains(text(),'My Account')]")
    WebElement myAccountIcon;

    @FindBy(xpath = ".//a[contains(text(),'Login')]")
    WebElement loginOption;

    @FindBy(linkText = "Desktops")
    WebElement topDesktopsCategory;

    @FindBy(xpath = "//a[contains(@class, 'see-all')][1]")
    WebElement seeAllCategoryProducts;


    public void goToLoginPage() {
        myAccountIcon.click();
        loginOption.click();
    }

    public void goToCategoryPage() {
        topDesktopsCategory.click();
        seeAllCategoryProducts.click();
    }

}

