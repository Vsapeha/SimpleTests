package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.PageBase;
import pages.StartPage;

import static org.testng.AssertJUnit.assertTrue;


public class DeleteFromCartTests extends TestBase {

    CategoryPage categoryPage = new CategoryPage(driver);
    StartPage startPage = new StartPage(driver);

    @BeforeMethod
    public void ensureCartHasProduct() {
        if (startPage.getCheckoutButtonText().contains("0 item(s)")) {
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
            new WebDriverWait(driver, 10).
                    until(ExpectedConditions.textToBePresentInElement(categoryPage.getCheckoutButtonElement(),
                            "0 item(s)"));
            assertTrue(categoryPage.getCheckoutButtonText().contains("0 item(s)"));

        }
    }