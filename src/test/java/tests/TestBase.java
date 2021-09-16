package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CommonElements;

import static driverFactory.LocalDriverFactory.*;

public class TestBase {
    @BeforeTest
    public void openMainPage() {
        getDriver().get("https://demo.opencart.com");
    }


    @AfterTest
    public void closeDriverInstance() {
        closeDriver();
    }
}
