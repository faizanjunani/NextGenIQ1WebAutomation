package ShoppingCartTest;

import Pages.HomepagePage;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{

    HomepagePage homepagePage = new HomepagePage();

    @Test(testName = "verify user is present on Amazon home page")
    public void verifyUserIsPresentOnAmazonHomePage()
    {
        homepagePage.userPresentonHomepage();
    }
    @Test(testName = "successfully search the details", dependsOnMethods = "verifyUserIsPresentOnAmazonHomePage")
    public void searchForDetails()
    {
        homepagePage.searchForProducts();
        homepagePage.clickSearchButton();
    }

}
