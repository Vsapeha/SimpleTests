package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.StartPage;

import static org.testng.AssertJUnit.assertTrue;


public class DeleteFromCartTests extends TestBase {

    CategoryPage categoryPage = new CategoryPage(driver);
    StartPage startPage = new StartPage(driver);

    @BeforeMethod
    public void ensureCartHasProduct() {
        if (startPage.getCheckoutDropdownInfo().equals("Your shopping cart is empty!")) {
            startPage.goToDesktopsCategoryPage();
            categoryPage.addToCart();
        }
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.textToBePresentInElement(startPage.getCheckoutButtonElement(), "1 item(s)"));
        assertTrue(startPage.getCheckoutButtonText().contains("1 item(s)"));
    }

        @Test
        public void deleteFromCartOnCategoryPage() {
            categoryPage.clickOnCheckoutButton();
            categoryPage.deleteFromCartViaCheckout();
            assertTrue(categoryPage.getCheckoutDropdownInfo().contains("Your shopping cart is empty!"));

        }
    }