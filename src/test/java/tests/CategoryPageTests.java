package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.CommonElements;
import pages.StartPage;

import static org.testng.Assert.*;

public class CategoryPageTests extends TestBase{

    CategoryPage categoryPage = new CategoryPage(driver);
    StartPage startPage = new StartPage(driver);

    @Test
    public void defaultNumberOfProductsOnPageTest() {
        startPage.goToCategoryPage();
        assertTrue(categoryPage.getNumberOfProducts() <= 15, "There are more than 15 products on the page");
    }
}
