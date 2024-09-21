package Pages;

import Locators.HomepageLocators;
import Locators.ProductLocators;
import Utils.UtilMethods;

public class HomepagePage {

    UtilMethods utils = new UtilMethods();
    HomepageLocators homepageLocators = new HomepageLocators();

    public void userPresentonHomepage()
    {
        utils.verifyElement(homepageLocators.userPresentOnHomePage,"Hello, sign in" );
    }
    public void searchForProducts()
    {
        utils.sendKeys(homepageLocators.txtsearchBar, "toys");
    }
    public void clickSearchButton()
    {
        utils.click(homepageLocators.btnEnter);
    }

}
