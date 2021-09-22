package pages;

import models.ProductData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;



public class WishlistPage extends PageBase{


    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class, 'table-responsive')]//tbody/tr")
    List<WebElement> productsWishlist;

    String titleXPathLocator = ".//td[contains(@class, 'text-left')][1]";
    String modelXPathLocator = ".//td[contains(@class, 'text-left')][2]";
    String stockXPathLocator = ".//td[contains(@class, 'text-right')][1]";
    String priceXPathLocator = ".//td[contains(@class, 'text-right')][2]";
    String priceNewXPathLocator = ".//td[contains(@class, 'text-right')][2]//b";
    String priceOldXPathLocator = ".//td[contains(@class, 'text-right')][2]//s";
    String addToCartButtonXPathLocator = ".//td[contains(@class, 'text-right')][3]/button";
    String removeFromWishlistButtonXPathLocator = ".//td[contains(@class, 'text-right')][3]/a";

    public List<ProductData> allProducts() {
        List<ProductData> products = new ArrayList<>();
        List<WebElement> elements = productsWishlist;
        for (WebElement element : elements) {
            String title = element.findElement(By.xpath(titleXPathLocator)).getText();
            String model = element.findElement(By.xpath(modelXPathLocator)).getText();
            String stock = element.findElement(By.xpath(stockXPathLocator)).getText();
            String price = element.findElement(By.xpath(priceXPathLocator)).getText();
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
            WebElement addToCartButton = element.findElement(By.xpath(addToCartButtonXPathLocator));
            WebElement removeFromWishlistButton = element.
                    findElement(By.xpath(removeFromWishlistButtonXPathLocator));
            ProductData product = new ProductData(title, model,  stock, price, priceOld, priceNew,null,
                    null, null, null,
                    addToCartButton, removeFromWishlistButton);
            products.add(product);
        }
        return products;
    }
}
