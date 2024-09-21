package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class UtilMethods {

    protected int Timeout = 5;

    protected static WebDriver webDriver;
    JavascriptExecutor js;

    public void setDriver(WebDriver driver)
    {
        this.webDriver = driver;
    }
    protected void implicitWait()
    {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Timeout));
    }
    protected WebElement findElement(String path)
    {
            new WebDriverWait(webDriver, Duration.ofSeconds(Timeout)).until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath(path)));
            return webDriver.findElement(By.xpath(path));
    }
    protected  String getTextFromElement(String path)
    {
        String text = findElement(path).getText();
        System.out.println(text);
        return text;
    }
    protected void elementSendKeys(String path, String text)
    {
        findElement(path).clear();
        findElement(path).sendKeys(text);
    }
    protected void clickElement(String path)
    {
        findElement(path).click();
    }
    protected void goBack()
    {
        webDriver.navigate().back();
    }
    protected void ScrollWebPage(int i)
    {
        js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,"+i+")");
       /* long start = System.currentTimeMillis();
        System.out.println("Inside Scroll Method");
       // findElement(scrollElementPath);
        implicitWait();
        System.out.println("Sleep time in ms = " + (System.currentTimeMillis() - start));
        js.executeScript("arguments[0].scrollIntoView();", findElement(scrollElementPath));
        implicitWait();
        System.out.println("Sleep time in ms = " + (System.currentTimeMillis() - start));
        System.out.println("Scrolled Down. Moving Out");*/
    }
    public void scrollWebPageToElement(int i)
    {
        ScrollWebPage(i);
    }
    public void sendKeys(String path, String value)
    {
        elementSendKeys(path, value);
    }
    public String getElementText(String path)
    {
        return getTextFromElement(path);
    }
    public void click(String path)
    {
        clickElement(path);
    }
    public void verifyElement(String path, String expectedValue) {
        int attempts = 0;
        boolean elementFound = false;
        while (!elementFound && attempts <= 5) {
            try {
                implicitWait();
                String actualText = getTextFromElement(path);
                Assert.assertEquals(actualText, expectedValue);
                elementFound = true;
            }
            catch (Exception e) {
                System.out.println("Exception Message: " + e.getMessage());
                attempts++;
                System.out.println("Exception caught. Retrying attempt " + attempts);
            }
        }
    }
    public void goBackToPrevious()
    {
        goBack();
    }

}
