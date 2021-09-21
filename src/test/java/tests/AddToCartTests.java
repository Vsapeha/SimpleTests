package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.CommonElements;
import pages.StartPage;
import static org.testng.AssertJUnit.assertTrue;

public class AddToCartTests extends TestBase {

    CommonElements commonElements = new CommonElements(driver);
    CategoryPage categoryPage = new CategoryPage(driver);
    StartPage startPage = new StartPage(driver);


    @BeforeMethod
    public void ensureCartIsEmpty() {
        assertTrue("Checkout button: Cart is not empty", commonElements.getCheckoutButtonText().contains("0 item(s)"));
        assertTrue("Checkout dropdown: Cart is not empty", commonElements.getCheckoutDropdownInfo().
                contains("Your shopping cart is empty!"));
    }

    @Test
    public void addToCartFromCategoryPage() {
        startPage.goToDesktopsCategoryPage();
        categoryPage.addToCart();
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.textToBePresentInElement(commonElements.getCheckoutButtonElement(), "1 item(s)"));
        assertTrue("Checkout button: Cart has No of products other than 1",commonElements.getCheckoutButtonText().
                contains("1 item(s)"));
        assertTrue("Success alert text doesn't include word 'Success'", categoryPage.getSuccessAlertText().
                contains("Success"));

    }

}

