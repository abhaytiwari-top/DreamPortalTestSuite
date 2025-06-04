package Tests;

import Utilities.ScreenshotUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import Pages.DreamsDiaryPage;

import java.time.Duration;

public class DreamsDiaryPageTest {
    private WebDriver driver;
    private DreamsDiaryPage diaryPage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://arjitnigam.github.io/myDreams/dreams-diary.html");
        diaryPage = new DreamsDiaryPage(driver);
    }

    @Test
    public void verifyTotalDreams() {
        Assert.assertEquals(diaryPage.getTotalDreamEntries(), 10);
    }

    @Test
    public void validateDreamTypes() {
        Assert.assertTrue(diaryPage.validateDreamTypes());
    }

    @Test
    public void verifyColumnsFilled() {
        Assert.assertTrue(diaryPage.areAllColumnsFilled());
    }

    @Test
    public void checkRecurringDreams() {
        Assert.assertTrue(diaryPage.isDreamRecurring("Flying over mountains"));
        Assert.assertTrue(diaryPage.isDreamRecurring("Lost in maze"));
    }

    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            ScreenshotUtils.captureScreenshot(driver, result.getName());
        }
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
