package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SummaryPage {
    private final WebDriver driver;

    private final By goodDreams = By.id("good-dreams");
    private final By badDreams = By.id("bad-dreams");
    private final By totalDreams = By.id("total-dreams");
    private final By recurringDreams = By.id("recurring-dreams");

    public SummaryPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getGoodDreamsCount() {
        return Integer.parseInt(driver.findElement(goodDreams).getText().trim());
    }

    public int getBadDreamsCount() {
        return Integer.parseInt(driver.findElement(badDreams).getText().trim());
    }

    public int getTotalDreamsCount() {
        return Integer.parseInt(driver.findElement(totalDreams).getText().trim());
    }

    public int getRecurringDreamsCount() {
        return Integer.parseInt(driver.findElement(recurringDreams).getText().trim());
    }
}
