package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static driverFactory.LocalDriverFactory.driver;
import static org.testng.AssertJUnit.assertTrue;


public class DeleteFromCartTests extends TestBase {

    @BeforeMethod
    public void ensureCartHasProduct() {
        if (commonElements.getCheckoutDropdownInfo().equals("Your shopping cart is empty!")) {
            startPage.goToCategoryPage();
            categoryPage.addToCart();
        }
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.textToBePresentInElementLocated(By.id("cart-total"), "1 item(s)")); // PageFactory locator?
        assertTrue(commonElements.getCheckoutButtonInfo().contains("1 item(s)"));
    }

        @Test
        public void deleteFromCartOnCategoryPage() {
            commonElements.clickOnCheckoutButton();
            categoryPage.deleteFromCartViaCheckout();
            assertTrue(commonElements.getCheckoutDropdownInfo().contains("Your shopping cart is empty!"));

        }
    }