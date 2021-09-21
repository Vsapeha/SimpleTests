package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.CommonElements;
import pages.StartPage;

import static org.testng.AssertJUnit.assertTrue;


public class DeleteFromCartTests extends TestBase {

    CommonElements commonElements = new CommonElements(driver);
    CategoryPage categoryPage = new CategoryPage(driver);
    StartPage startPage = new StartPage(driver);

    @BeforeMethod
    public void ensureCartHasProduct() {
        if (commonElements.getCheckoutDropdownInfo().equals("Your shopping cart is empty!")) {
            startPage.goToDesktopsCategoryPage();
            categoryPage.addToCart();
        }
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.textToBePresentInElement(commonElements.getCheckoutButtonElement(), "1 item(s)"));
        assertTrue(commonElements.getCheckoutButtonText().contains("1 item(s)"));
    }

        @Test
        public void deleteFromCartOnCategoryPage() {
            commonElements.clickOnCheckoutButton();
            categoryPage.deleteFromCartViaCheckout();
            assertTrue(commonElements.getCheckoutDropdownInfo().contains("Your shopping cart is empty!"));

        }
    }