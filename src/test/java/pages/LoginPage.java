package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(xpath=".//*[@id='input-email']")
    WebElement emailField;

    @FindBy(css="#input-password")
    WebElement passwordField;

    @FindBy(xpath=".//input[@value='Login']")
    WebElement loginButton;


    public void login (String userEmail, String userPassword) {
        emailField.sendKeys(userEmail);
        passwordField.sendKeys(userPassword);
        loginButton.click();

    }
}
