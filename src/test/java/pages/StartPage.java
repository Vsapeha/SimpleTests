package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage {
    @FindBy(xpath=".//span[contains(text(),'My Account')]")
    WebElement myAccountIcon;

    @FindBy(xpath=".//a[contains(text(),'Login')]")
    WebElement loginOption;

    public void goToLoginPage() {
        myAccountIcon.click();
        loginOption.click();
    }
}
