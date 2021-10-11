package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageBase {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="input-email")
    WebElement emailField;

    @FindBy(id="input-password")
    WebElement passwordField;

    @FindBy(xpath=".//input[@value='Login']")
    WebElement loginButton;


    public void login (String userEmail, String userPassword) {
        emailField.sendKeys(userEmail);
        passwordField.sendKeys(userPassword);
        loginButton.click();

    }
}
