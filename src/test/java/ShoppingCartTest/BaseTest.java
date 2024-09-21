package ShoppingCartTest;

import Pages.HomepagePage;
import Pages.ProductsPage;
import Utils.UtilMethods;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;

import org.openqa.selenium.io.FileHandler;

public class BaseTest {

    protected UtilMethods utils = new UtilMethods();
    protected static WebDriver webDriver;
    protected String webURL = "https://www.amazon.com";

    @BeforeSuite
    public void setUpandLoadApplication() throws InterruptedException {
        if (webDriver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            //options.addArguments("--headless=new");
            webDriver = new ChromeDriver(options);
            webDriver.manage().window().maximize();
            webDriver.navigate().to(webURL);
            utils.setDriver(webDriver);
            Thread.sleep(5000);
        }
    }
    @AfterSuite
    public void tearDown()
    {
        //webDriver.quit();
    }

    @AfterMethod
    public void takeScreenshotForFailure(ITestResult testResult) {
        if(ITestResult.FAILURE == testResult.getStatus()){
            TakesScreenshot screenshot = (TakesScreenshot) webDriver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir")+"/resources/screenshots/"+testResult.getName() + ".png");
            System.out.println(destination);
            try
            {
                FileUtils.copyFile(source,destination);
                System.out.println("Screenshot captured and saved to: " + destination.getAbsolutePath());

            }
            catch(IOException e)
            {
                System.out.println("Error capturing screenshot: " + e.getMessage());

            }
        }
    }
}
