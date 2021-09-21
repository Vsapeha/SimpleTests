package tests;

import models.ProductData;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.LoginPage;
import pages.StartPage;
import pages.WishlistPage;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.AssertJUnit.*;
import static org.testng.AssertJUnit.assertTrue;

    public class MoreTests extends TestBase {

        LoginPage loginPage = new LoginPage(driver);
        StartPage startPage = new StartPage(driver);
        CategoryPage categoryPage = new CategoryPage(driver);
        WishlistPage wishlistPage = new WishlistPage(driver);

        @Test
        // (enabled = false)
        public void FirstTest() {
            startPage.goToLoginPage();
            loginPage.login("addressbook.test.user.21@gmail.com", "151192");
            assertTrue(driver.getTitle().contains("My Account"));
            startPage.goToMonitorsSubcategoryPage();
            List<ProductData> addedProducts = categoryPage.addProductsWithTestTitlesToWishlist();
            categoryPage.goToWishlistPage();
            List<ProductData> productsOnWishlist = wishlistPage.allProducts();
            Assert.assertEquals(new HashSet<Object>(productsOnWishlist), new HashSet<Object>(addedProducts));
            /*Comparator<? super ProductData> byTitle = (p1, p2) -> CharSequence.compare(p1.getTitle(), p2.getTitle());
            addedProducts.sort(byTitle);
            productsOnWishlist.sort(byTitle);
            Assert.assertEquals(addedProducts, productsOnWishlist);*/ //comparison of sorted lists
        }

        @Test
        public void SecondTest() {
            String currency = startPage.getCurrency();
            Assert.assertEquals(currency, "$");
            List<ProductData> productsWithPricesInDollars = startPage.chooseProductsWithTestTitle();
            for (ProductData p : productsWithPricesInDollars) {
                Assert.assertEquals(p.getPrice(), "$123.20");
            }
            startPage.changeCurrencyToEuro();
            List<ProductData> productsWithPricesInEuro = startPage.chooseProductsWithTestTitle();
            for (ProductData p : productsWithPricesInEuro) {
                Assert.assertEquals(p.getPrice(), "106.04€");
            }
            startPage.changeCurrencyToPound();
            List<ProductData> productsWithPricesInPounds = startPage.chooseProductsWithTestTitle();
            for (ProductData p : productsWithPricesInPounds) {
                Assert.assertEquals(p.getPrice(), "£92.93");
            }
        }
    }


