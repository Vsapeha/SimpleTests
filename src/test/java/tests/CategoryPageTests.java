package tests;

import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.StartPage;

import static org.testng.Assert.*;

public class CategoryPageTests extends TestBase{

    CategoryPage categoryPage = new CategoryPage(driver);
    StartPage startPage = new StartPage(driver);

    @Test
    public void defaultNumberOfProductsOnPageTest() {
        startPage.goToDesktopsCategoryPage();
        assertTrue(categoryPage.getNumberOfProducts() <= 15, "There are more than 15 products on the page");
    }
}
