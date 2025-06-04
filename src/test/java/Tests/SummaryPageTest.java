package Tests;

import Utilities.ScreenshotUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import Pages.SummaryPage;

import java.time.Duration;

public class SummaryPageTest {
    private WebDriver driver;
    private SummaryPage summaryPage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        driver.get("https://arjitnigam.github.io/myDreams/dreams-total.html");
        summaryPage = new SummaryPage(driver);
    }

    @Test(priority = 1)
    public void testGoodDreamsDisplayed() {
        int goodDreams = summaryPage.getGoodDreamsCount();
        Assert.assertTrue(goodDreams >= 0);
    }

    @Test(priority = 2)
    public void testBadDreamsDisplayed() {
        int badDreams = summaryPage.getBadDreamsCount();
        Assert.assertTrue(badDreams >= 0);
    }

    @Test(priority = 3)
    public void testTotalDreamsDisplayed() {
        int totalDreams = summaryPage.getTotalDreamsCount();
        Assert.assertTrue(totalDreams >= 0);
    }

    @Test(priority = 4)
    public void testRecurringDreamsDisplayed() {
        int recurringDreams = summaryPage.getRecurringDreamsCount();
        Assert.assertTrue(recurringDreams >= 0);
    }

    @Test(priority = 5)
    public void testTotalDreamsIsSumOfGoodAndBad() {
        int good = summaryPage.getGoodDreamsCount();
        int bad = summaryPage.getBadDreamsCount();
        int total = summaryPage.getTotalDreamsCount();
        Assert.assertEquals(good + bad, total);
    }

    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            ScreenshotUtils.captureScreenshot(driver, result.getName());
        }
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
