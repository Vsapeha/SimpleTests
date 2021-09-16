package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonElements {


    @FindBy(xpath = ".//span[contains(text(),'item(s)')]")
    WebElement checkoutButton;

    @FindBy(xpath = ".//p[contains(@class, 'text-center')]")
    WebElement checkoutDropdown;

    public String getCheckoutButtonInfo() {
        return checkoutButton.getText();
    }


    public String getCheckoutDropdownInfo() {
        checkoutButton.click();
        return checkoutDropdown.getText();
    }

}
