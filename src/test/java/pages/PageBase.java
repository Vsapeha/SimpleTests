package pages;
import models.ProductData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PageBase{
    protected WebDriver driver;

    public PageBase(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[contains(@class, 'product-thumb')]")
    List<WebElement> productsList;

    String titleXPathLocator = ".//div[contains(@class, 'caption')]//a";
    String priceXPathLocator = ".//p[contains(@class, 'price')]";
    String priceNewXPathLocator = ".//p[contains(@class, 'price')]//span[contains(@class, 'price-new')]";
    String priceOldXPathLocator = ".//p[contains(@class, 'price')]//span[contains(@class, 'price-old')]";
    String priceTaxXPathLocator = ".//p[contains(@class, 'price')]//span[contains(@class, 'price-tax')]";
    String addToCartXPathLocator = ".//button[contains(@onclick, 'cart.add')]";
    String addToWishlistXPathLocator = ".//button[contains(@onclick, 'wishlist.add')]";
    String compareXPathLocator = ".//button[contains(@onclick, 'compare.add')]";

    public List<ProductData> allProducts() {
        List<ProductData> products = new ArrayList<>();
        List<WebElement> elements = productsList;
        for (WebElement element : elements) {
            String title = element.findElement(By.xpath(titleXPathLocator)).getText();
            String priceInitial = element.findElement(By.xpath(priceXPathLocator)).getText();
            String priceTax = element.findElement(By.xpath(priceTaxXPathLocator)).getText();
            String priceInitialWithBlankSpaces = priceInitial.replace(priceTax,"");
            String price = priceInitialWithBlankSpaces.replaceAll("\\s","");
            String priceNew;
            String priceOld;
            try {
                WebElement priceNewElement = element.findElement(By.xpath(priceNewXPathLocator));
                priceNew = priceNewElement.getText();
            } catch (Exception e) {
                priceNew = null;
            }
            try {
                WebElement priceOldElements = element.findElement(By.xpath(priceOldXPathLocator));
                priceOld = priceOldElements.getText();
            } catch (Exception e) {
                priceOld = null;
            }
            if (priceOld != null) {
                price = null;
            }
            WebElement addToCart = element.findElement(By.xpath(addToCartXPathLocator));
            WebElement addToWishlist = element.findElement(By.xpath(addToWishlistXPathLocator));
            WebElement compare = element.findElement(By.xpath(compareXPathLocator));
            ProductData product = new ProductData(title, null, null, price, priceOld, priceNew, priceTax, addToCart,
                    addToWishlist, compare, null, null);
            products.add(product);
        }
        return products;
    }

    public List<ProductData> chooseProductsWithTestTitle(String testTitle) {
        List<ProductData> products = allProducts();
        List<ProductData> productsWithTestTitles = products
                .stream()
                .filter(c -> c.getTitle().contains(testTitle)).collect(Collectors.toList());
        return productsWithTestTitles;
    }







}
