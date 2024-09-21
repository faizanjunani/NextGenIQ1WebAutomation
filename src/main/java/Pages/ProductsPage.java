package Pages;

import Locators.ProductLocators;
import Utils.UtilMethods;

public class ProductsPage {

    UtilMethods utils = new UtilMethods();
    ProductLocators productLocators = new ProductLocators();

    private String product1Price;
    private String product2Price;

    public void checkProductPriceonSearchPage()
    {
        utils.scrollWebPageToElement(270);
        product1Price = utils.getElementText(productLocators.getPriceProduct1);
        System.out.println("Price of Product 1 is "+product1Price);
        product2Price = utils.getElementText(productLocators.getPriceProduct2);
        System.out.println("Price of Product 2 is "+product2Price);
    }
    public void goToProduct1Details()
    {
        utils.click(productLocators.accessProductDetails1);
    }
    public void goToProduct2Details()
    {
        utils.click(productLocators.accessProductDetails2);
    }
    public void verifyProduct1PriceonProductDetails()
    {
        utils.verifyElement(productLocators.getPriceProduct1onProductDetails,product1Price);
    }
    public void verifyProduct2PriceonProductDetails()
    {
        utils.verifyElement(productLocators.getPriceProduct2onProductDetails,product2Price);
    }
    public void addProductToCart()
    {
        utils.scrollWebPageToElement(50);
        utils.click(productLocators.btnAddProduct);
    }
    public void goBackToSearch()
    {
        utils.goBackToPrevious();
        utils.goBackToPrevious();
    }
    public void goToCart()
    {
        utils.click(productLocators.btnGoToCart);
    }
    public void verifyProduct1PriceonCart()
    {
        utils.verifyElement(productLocators.getPriceInCartProduct1,product1Price);
    }
    public void verifyProduct2PriceonCart()
    {
        utils.verifyElement(productLocators.getPriceInCartProduct2,product2Price);
    }

}
