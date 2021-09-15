package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommonElements {

    @FindBy(xpath = ".//span[contains(text(),'item(s)')]")
    WebElement checkoutButton;

    public String getCheckoutButtonInfo() {
        return checkoutButton.getText();
    }

}
