package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static driverFactory.LocalDriverFactory.driver;
import static org.testng.AssertJUnit.assertTrue;

public class AddToCartTests extends TestBase {

    @BeforeMethod
    public void ensureCartIsEmpty() {
        assertTrue(commonElements.getCheckoutButtonText().contains("0 item(s)"));
        assertTrue(commonElements.getCheckoutDropdownInfo().contains("Your shopping cart is empty!"));
    }

    @Test
    public void addToCartFromCategoryPage() {
        startPage.goToCategoryPage();
        categoryPage.addToCart();
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.textToBePresentInElementLocated(By.id("cart-total"), "1 item(s)")); // PageFactory locator?
        assertTrue(commonElements.getCheckoutButtonText().contains("1 item(s)"));
        assertTrue(categoryPage.getSuccessAlertText().contains("Success"));

    }

}

