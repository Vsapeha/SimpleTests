package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.CommonElements;
import pages.StartPage;

public class CategoryPageTests extends TestBase{

    CategoryPage categoryPage = new CategoryPage(driver);
    StartPage startPage = new StartPage(driver);

    @Test
    public void defaultNumberOfProductsOnPageTest() {
        startPage.goToCategoryPage();
        Assert.assertTrue(categoryPage.getNumberOfProducts() <= 15);
    }
}
