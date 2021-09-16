package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommonElements {

    @FindBy(id = "cart-total")
    WebElement checkoutButton;

    @FindBy(xpath = "//p[contains(@class, 'text-center')]")
    WebElement checkoutDropdown;

    public String getCheckoutButtonInfo() {
        return checkoutButton.getText();
    }

    public void clickOnCheckoutButton() {
        checkoutButton.click();
    }

    public String getCheckoutDropdownInfo() {
        clickOnCheckoutButton();
        return checkoutDropdown.getText();
    }

}
