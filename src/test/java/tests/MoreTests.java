package tests;

import models.ProductData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.LoginPage;
import pages.StartPage;
import pages.WishlistPage;
import java.util.HashSet;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

    public class MoreTests extends TestBase {

        LoginPage loginPage = new LoginPage(driver);
        StartPage startPage = new StartPage(driver);
        CategoryPage categoryPage = new CategoryPage(driver);
        WishlistPage wishlistPage = new WishlistPage(driver);

        @Test
              //  (enabled = false)
        public void firstTest() {
            startPage.goToLoginPage();
            loginPage.login("addressbook.test.user.21@gmail.com", "151192");
            assertTrue(driver.getTitle().equals("My Account"));
            startPage.goToMonitorsSubcategoryPage();
            List<ProductData> addedProducts = categoryPage.addProductsWithTestTitlesToWishlist();
            categoryPage.goToWishlistPage();
            List<ProductData> productsOnWishlist = wishlistPage.allProducts();
            Assert.assertEquals(new HashSet<Object>(productsOnWishlist), new HashSet<Object>(addedProducts));
            categoryPage.logout();
        }

        @Test
             //   (enabled = false)
        public void secondTest() {
            String currency = startPage.getCurrency();
            Assert.assertEquals(currency, "$");
            String testTitle = "iPhone";
            List<ProductData> productsWithPricesInDollars = startPage.chooseProductsWithTestTitle(testTitle);
            for (ProductData p : productsWithPricesInDollars) {
                Assert.assertEquals(p.getPrice(), "$123.20");
            }
            startPage.changeCurrencyToEuro();
            List<ProductData> productsWithPricesInEuro = startPage.chooseProductsWithTestTitle(testTitle);
            for (ProductData p : productsWithPricesInEuro) {
                Assert.assertEquals(p.getPrice(), "106.04€");
            }
            startPage.changeCurrencyToPound();
            List<ProductData> productsWithPricesInPounds = startPage.chooseProductsWithTestTitle(testTitle);
            for (ProductData p : productsWithPricesInPounds) {
                Assert.assertEquals(p.getPrice(), "£92.93");
            }
            startPage.changeCurrencyToDollar();
        }


        @Test
        public void thirdTest() {
            startPage.goToCamerasCategoryPage();
            int numberOfProducts = categoryPage.getNumberOfProducts();
            assertEquals(numberOfProducts, 2);
            String testTitleFirst = "Canon EOS 5D";
            String testTitleSecond = "Nikon D300";
            String priceNewFirst = "$98.00";
            String priceOldFirst = "$122.00";
            String priceTaxSecond = "Ex Tax: $80.00";
            List<ProductData> products1 = categoryPage.chooseProductsWithTestTitle(testTitleFirst);
            for (ProductData p : products1) {
                Assert.assertEquals(p.getPriceNew(), priceNewFirst);
                Assert.assertEquals(p.getPriceOld(), priceOldFirst);
            }
            List<ProductData> products2 = categoryPage.chooseProductsWithTestTitle(testTitleSecond);
            for (ProductData p : products2) {
                Assert.assertEquals(p.getPriceTax(), priceTaxSecond);

            }

        }
    }

