package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.CommonElements;
import pages.StartPage;

import static driverFactory.LocalDriverFactory.driver;
import static org.openqa.selenium.support.PageFactory.initElements;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;
import static org.testng.AssertJUnit.assertTrue;

public class CartTests extends TestBase {

    @BeforeMethod
    public void ensureCartIsEmpty() {
        CommonElements commonElements = initElements(driver, CommonElements.class);
        assertTrue(commonElements.getCheckoutButtonInfo().contains("0 item(s)"));
        assertTrue(commonElements.getCheckoutDropdownInfo().contains("Your shopping cart is empty!"));

    }

    @Test
    public void addToCartFromCategoryPage() throws InterruptedException {
        StartPage startPage = initElements(driver, StartPage.class);
        startPage.goToCategoryPage();
        CategoryPage categoryPage = initElements(driver, CategoryPage.class);
        categoryPage.addToCart();
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.textToBePresentInElementLocated(By.id("cart-total"), "1 item(s)")); // PageFactory locator?
        CommonElements commonElements1 = initElements(driver, CommonElements.class);
        assertTrue(commonElements1.getCheckoutButtonInfo().contains("1 item(s)"));
        assertTrue(categoryPage.getSuccessAlertText().contains("Success"));

    }

}

