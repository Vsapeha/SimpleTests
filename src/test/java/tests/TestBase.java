package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static driverFactory.LocalDriverFactory.closeDriver;
import static driverFactory.LocalDriverFactory.getDriver;

public class TestBase {
    protected WebDriver driver;

    public TestBase()
    { driver = getDriver();
    }

    @BeforeTest
    public void openMainPage() {
        getDriver().get("https://demo.opencart.com");

    }
    @AfterTest
    public void closeDriverInstance() {
        closeDriver();
    }

}
