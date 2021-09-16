package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.StartPage;

import static driverFactory.LocalDriverFactory.driver;
import static org.testng.AssertJUnit.assertTrue;

public class LoginTests extends TestBase {

    @Test
    public void positiveLoginTest() {
        startPage.goToLoginPage();
        loginPage.login("addressbook.test.user.21@gmail.com","151192");
        assertTrue(driver.getTitle().contains("My Account"));
    }
    @Test
    public void negativeLoginTest() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        startPage.goToLoginPage();
        loginPage.login("addressbook.test.user.21@gmail.com","1111");
        assertTrue(driver.getTitle().contains("Account Login"));
    }
}
