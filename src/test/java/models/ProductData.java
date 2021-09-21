package models;

import org.openqa.selenium.WebElement;

import java.util.Objects;

public class ProductData {

    String title;
    String model;
    String stock;
    String price;
    String priceOld;
    String priceNew;
    String priceTax;
    WebElement addToCartButtonIcon;
    public WebElement addToWishlistButton;
    WebElement compareButton;
    WebElement addToCartButton;
    WebElement removeFromWishlistButton;

    public ProductData(String title, String model, String stock, String price, String priceOld, String priceNew,
                       String priceTax, WebElement addToCartButtonIcon, WebElement addToWishlistButton,
                       WebElement compareButton, WebElement addToCartButton, WebElement removeFromWishlistButton) {
        this.title = title;
        this.price = price;
        this.model = model;
        this.stock = stock;
        this.priceOld = priceOld;
        this.priceNew = priceNew;
        this.priceTax = priceTax;
        this.addToCartButtonIcon = addToCartButtonIcon;
        this.addToWishlistButton = addToWishlistButton;
        this.compareButton = compareButton;
        this.addToCartButton = addToCartButton;
        this.removeFromWishlistButton = removeFromWishlistButton;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getPriceOld() {
        return priceOld;
    }

    public String getPriceNew() {
        return priceNew;
    }

    public String getPriceTax() {
        return priceTax;
    }

    public WebElement getAddToCartButtonIcon() {
        return addToCartButtonIcon;
    }

    public WebElement getAddToWishlistButton() {
        return addToWishlistButton;
    }

    public WebElement getCompareButton() {
        return compareButton;
    }

    public String getModel() {
        return model;
    }

    public String getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return "ProductData{" +
                "title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", priceOld='" + priceOld + '\'' +
                ", priceNew='" + priceNew + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductData that = (ProductData) o;
        return Objects.equals(title, that.title) && Objects.equals(price, that.price) && Objects.equals(priceOld, that.priceOld) && Objects.equals(priceNew, that.priceNew);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price, priceOld, priceNew);
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public WebElement getRemoveFromWishlistButton() {
        return removeFromWishlistButton;
    }

}



