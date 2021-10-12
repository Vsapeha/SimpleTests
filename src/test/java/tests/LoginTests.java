package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PageBase;
import pages.StartPage;

import static driverFactory.LocalDriverFactory.closeDriver;
import static org.testng.AssertJUnit.assertTrue;

public class LoginTests extends TestBase {
    LoginPage loginPage = new LoginPage(driver);
    StartPage startPage = new StartPage(driver);

    @Test
    public void positiveLoginTest() {
        startPage.goToLoginPage();
        loginPage.login("addressbook.test.user.21@gmail.com","151192");
        assertTrue("User is NOT logged in as page title is not 'My Account'",
                driver.getTitle().equals("My Account"));

    }
    @Test
    public void negativeLoginTest() {
        startPage.goToLoginPage();
        loginPage.login("addressbook.test.user.21@gmail.com","wrong password");
        assertTrue("User is NOT on loginPage as page title is not 'Account Login'",
                driver.getTitle().equals("Account Login"));

    }
}
