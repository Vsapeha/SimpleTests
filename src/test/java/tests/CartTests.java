package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.CommonElements;
import pages.StartPage;

import static driverFactory.LocalDriverFactory.driver;
import static org.openqa.selenium.support.PageFactory.initElements;
import static org.testng.AssertJUnit.assertTrue;

public class CartTests extends TestBase {

    @BeforeMethod
    public void ensureCartIsEmpty() {
        CommonElements commonElements = initElements(driver, CommonElements.class);
        assertTrue(commonElements.getCheckoutButtonInfo().contains("0 item(s)"));
        assertTrue(commonElements.getCheckoutDropdownInfo().contains("Your shopping cart is empty!"));

    }

    @Test
    public void addToCartFromCategoryPage() {
        StartPage startPage = initElements(driver, StartPage.class);
        startPage.goToCategoryPage();
        CategoryPage categoryPage = initElements(driver, CategoryPage.class);
        categoryPage.addToCart();
        assertTrue(categoryPage.getSuccessAlertText().contains("Success"));

    }

}

