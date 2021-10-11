package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

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
        System.out.println("Thread id is "+ Thread.currentThread().getId());}

    @AfterSuite
    public void closeDriverInstance() {
        closeDriver();
    }

}
