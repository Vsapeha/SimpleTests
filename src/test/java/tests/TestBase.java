package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import static driverFactory.LocalDriverFactory.closeDriver;
import static driverFactory.LocalDriverFactory.getDriver;

public class TestBase {
    protected WebDriver driver;

    public TestBase()
    {
        driver = getDriver();
    }

    @BeforeSuite
    public void openMainPage() {
        driver.get("https://demo.opencart.com");
    }

    @AfterSuite
    public void closeDriverInstance() {
        closeDriver();
    }

}
