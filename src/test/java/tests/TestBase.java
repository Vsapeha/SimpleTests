package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static driverFactory.LocalDriverFactory.closeDriver;
import static driverFactory.LocalDriverFactory.getDriver;

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
