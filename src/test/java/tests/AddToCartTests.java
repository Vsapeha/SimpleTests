package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.StartPage;
import static org.testng.AssertJUnit.assertTrue;

public class AddToCartTests extends TestBase {

    CategoryPage categoryPage = new CategoryPage(driver);
    StartPage startPage = new StartPage(driver);


    @BeforeMethod
    public void ensureCartIsEmpty() {
        assertTrue("Checkout button: Cart is not empty", startPage.getCheckoutButtonText().contains("0 item(s)"));
        assertTrue("Checkout dropdown: Cart is not empty", startPage.getCheckoutDropdownInfo().
                contains("Your shopping cart is empty!"));
    }

    @Test
    public void addToCartFromCategoryPage() {
        startPage.goToDesktopsCategoryPage();
        categoryPage.addToCart();
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.textToBePresentInElement(categoryPage.getCheckoutButtonElement(), "1 item(s)"));
        assertTrue("Checkout button: Cart has No of products other than 1",categoryPage.getCheckoutButtonText().
                contains("1 item(s)"));
        assertTrue("Success alert text doesn't include word 'Success'", categoryPage.getSuccessAlertText().
                contains("Success"));

    }

}

