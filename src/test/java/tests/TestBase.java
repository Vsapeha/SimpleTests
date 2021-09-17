package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.PageBase;

import static driverFactory.LocalDriverFactory.*;

public class TestBase {
    protected WebDriver driver;

    public TestBase()
    {
        driver = getDriver();
    }

    @BeforeTest
    public void openMainPage() {
        driver.get("https://demo.opencart.com");
    }

    @AfterTest
    public void closeDriverInstance() {
        closeDriver();
    }

}
