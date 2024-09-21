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

    @Test(testName = "Verify price of product1 on product details page")
    public void verifyPriceOfProduct1onDetailsPage()
    {
        productsPage.goToProduct1Details();
        productsPage.verifyProduct1PriceonProductDetails();
        productsPage.addProductToCart();
        productsPage.goBackToSearch();

    }
}
