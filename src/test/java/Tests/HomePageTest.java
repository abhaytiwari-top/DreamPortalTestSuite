package Tests;

import Utilities.ScreenshotUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import Pages.HomePage;

public class HomePageTest {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://arjitnigam.github.io/myDreams/");
        homePage = new HomePage(driver);
    }

    @Test(priority = 1)
    public void testLoaderDisappears() {
        Assert.assertTrue(homePage.waitForLoaderToDisappear(), "Loader did not disappear as expected");
    }

    @Test(priority = 2)
    public void testMainContentVisible() {
        Assert.assertTrue(homePage.isContentDisplayed(), "Main content not visible");
        Assert.assertTrue(homePage.isMyDreamsButtonDisplayed(), "My Dreams button not visible");
    }

    @Test(priority = 3)
    public void testMyDreamsButtonOpensTabs() {
        homePage.clickMyDreamsButton();
        Assert.assertEquals(driver.getWindowHandles().size(), 3, "Expected 2 new tabs/windows after clicking");
    }

    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            ScreenshotUtils.captureScreenshot(driver, result.getName());
        }
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
