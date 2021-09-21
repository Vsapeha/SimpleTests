package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends PageBase {

    public StartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//span[contains(text(),'My Account')]")
    WebElement myAccountIcon;

    @FindBy(xpath = ".//a[contains(text(),'Login')]")
    WebElement loginOption;

    @FindBy(linkText = "Desktops")
    WebElement topDesktopsCategory;

    @FindBy(linkText = "Components")
    WebElement topComponentsCategory;

    @FindBy(partialLinkText = "Monitors")
    WebElement topMonitorsSubcategory;

    @FindBy(xpath = "//a[contains(@class, 'see-all')][1]")
    WebElement seeAllCategoryProducts;


    public void goToLoginPage() {
        myAccountIcon.click();
        loginOption.click();
    }

    public void goToDesktopsCategoryPage() {
        topDesktopsCategory.click();
        seeAllCategoryProducts.click();
    }

    public void goToMonitorsSubcategoryPage() {
        topComponentsCategory.click();
        topMonitorsSubcategory.click();

    }

}

