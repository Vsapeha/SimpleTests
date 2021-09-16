package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.CommonElements;
import pages.LoginPage;
import pages.StartPage;

import static driverFactory.LocalDriverFactory.*;
import static org.openqa.selenium.support.PageFactory.initElements;

public class TestBase {
        StartPage startPage;
        LoginPage loginPage;
        CommonElements commonElements;
        CategoryPage categoryPage;


    @BeforeTest
    public void openMainPage() {
        getDriver().get("https://demo.opencart.com");
        startPage = initElements(driver, StartPage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        commonElements = initElements(driver, CommonElements.class);
        categoryPage = initElements(driver, CategoryPage.class);

    }


    @AfterTest
    public void closeDriverInstance() {
        closeDriver();
    }

}
