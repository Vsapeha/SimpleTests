package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CategoryPageTests extends TestBase{

    @Test
    public void defaultNumberOfProductsOnPageTest() {
        startPage.goToCategoryPage();
        Assert.assertTrue(categoryPage.getNumberOfProducts() <= 15);
    }
}
