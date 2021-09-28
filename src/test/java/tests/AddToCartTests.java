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
        while (! startPage.getCheckoutDropdownInfo().equals("Your shopping cart is empty!")) {
            categoryPage.deleteFromCartViaCheckout();
        }
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

