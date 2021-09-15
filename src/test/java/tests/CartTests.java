package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.CommonElements;
import pages.StartPage;

import static driverFactory.LocalDriverFactory.driver;
import static org.testng.AssertJUnit.assertTrue;

public class CartTests extends TestBase {

    @BeforeMethod
    public void ensureCartIsEmpty() {
        CommonElements commonElements = PageFactory.initElements(driver, CommonElements.class);
        assertTrue(commonElements.getCheckoutButtonInfo().contains("0 item(s)"));
    }

    @Test
    public void addToCartFromCategoryPage() {
        StartPage startPage = PageFactory.initElements(driver, StartPage.class);
        startPage.goToCategoryPage();
        CategoryPage categoryPage = PageFactory.initElements(driver, CategoryPage.class);
        categoryPage.addToCart();
    }
    @AfterMethod
    public void ensureCartHasProduct() {
        CommonElements commonElements1 = PageFactory.initElements(driver, CommonElements.class);
        assertTrue(commonElements1.getCheckoutButtonInfo().contains("1 item(s)"));
    }
    
    }

