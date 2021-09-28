package tests;

import models.ProductData;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.util.HashSet;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

    public class MoreTests extends TestBase {

        LoginPage loginPage = new LoginPage(driver);
        StartPage startPage = new StartPage(driver);
        CategoryPage categoryPage = new CategoryPage(driver);
        WishlistPage wishlistPage = new WishlistPage(driver);
        PageBase pageBase = new PageBase(driver);


        @Test
              //  (enabled = false)
        public void firstTest() {
            pageBase.myAccountIcon.click();
            List<WebElement> accountOptions = startPage.myAccountOption;
            int myAccountOptions = accountOptions.size();
            if (myAccountOptions == 2) {
                startPage.loginOption.click();
                loginPage.login("addressbook.test.user.21@gmail.com", "151192");
                assertTrue(driver.getTitle().equals("My Account"));
            }
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
            Assert.assertEquals(startPage.getCurrency(), "$");
            String testTitle = "iPhone";
            List<ProductData> productsWithPricesInDollars = startPage.chooseProductsWithTestTitle(testTitle);
            for (ProductData p : productsWithPricesInDollars) {
                Assert.assertEquals(p.getPrice(), startPage.getCurrency() + "123.20");
            }
            startPage.changeCurrencyToEuro();
            List<ProductData> productsWithPricesInEuro = startPage.chooseProductsWithTestTitle(testTitle);
            for (ProductData p : productsWithPricesInEuro) {
                Assert.assertEquals(p.getPrice(), "106.04" + startPage.getCurrency());
            }
            startPage.changeCurrencyToPound();
            List<ProductData> productsWithPricesInPounds = startPage.chooseProductsWithTestTitle(testTitle);
            for (ProductData p : productsWithPricesInPounds) {
                Assert.assertEquals(p.getPrice(), startPage.getCurrency() + "92.93");
            }
            startPage.changeCurrencyToDollar();
        }


        @Test
        public void thirdTest() {
            String currency = startPage.getCurrency();
            startPage.goToCamerasCategoryPage();
            int numberOfProducts = categoryPage.getNumberOfProducts();
            assertEquals(numberOfProducts, 2);
            String testTitleFirst = "Canon EOS 5D";
            String testTitleSecond = "Nikon D300";
            String priceNewFirst = currency + "98.00";
            String priceOldFirst = currency + "122.00";
            String priceTaxSecond = "Ex Tax: " + currency + "80.00";
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

