package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By loader = By.id("loader");
    private final By mainContent = By.id("main");
    private final By myDreamsBtn = By.xpath("//button[contains(text(),'My Dreams')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean waitForLoaderToDisappear() {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
    }

    public boolean isContentDisplayed() {
        return driver.findElement(mainContent).isDisplayed();
    }

    public boolean isMyDreamsButtonDisplayed() {
        return driver.findElement(myDreamsBtn).isDisplayed();
    }

    public void clickMyDreamsButton() {
        driver.findElement(myDreamsBtn).click();
    }
}
