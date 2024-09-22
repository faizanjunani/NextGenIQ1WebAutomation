package ShoppingCartTest;

import Locators.ProductLocators;
import Pages.ProductsPage;
import org.testng.annotations.Test;

public class ProductsPageTest extends BaseTest{

    ProductsPage productsPage = new ProductsPage();

    @Test(testName = "verify price of product1 on search page")
    public void verifyPriceOfProduct1onSearchPage()
    {
        productsPage.checkProductPriceonSearchPage();
    }

    @Test(testName = "Verify price of product1 on product details page",dependsOnMethods = "verifyPriceOfProduct1onSearchPage")
    public void verifyPriceOfProduct1onDetailsPage()
    {
        productsPage.goToProduct1Details();
        productsPage.verifyProduct1PriceonProductDetails();
        productsPage.addProductToCart();
        productsPage.goBackToSearch();
    }
    @Test(testName = "verify price of product2 on search page")
    public void verifyPriceOfProduct2onSearchPage()
    {
        productsPage.checkProductPriceonSearchPage();
    }
    @Test(testName = "Verify price of product2 on product details page", dependsOnMethods = "verifyPriceOfProduct2onSearchPage")
    public void verifyPriceOfProduct2onDetailsPage()
    {
        productsPage.goToProduct2Details();
        productsPage.verifyProduct2PriceonProductDetails();
        productsPage.addProductToCart();
    }
    @Test(testName = "Go to cart and verify the prices of both products",dependsOnMethods = "verifyPriceOfProduct2onDetailsPage")
    public void goToCartandVerifyPricesofBothProducts()
    {
        productsPage.goToCart();
        productsPage.verifyProduct1PriceonCart();
        productsPage.verifyProduct2PriceonCart();
    }
}
