package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DreamsDiaryPage {
    private final WebDriver driver;
    private final By tableRows = By.xpath("//table//tbody/tr");

    public DreamsDiaryPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getTotalDreamEntries() {
        return driver.findElements(tableRows).size();
    }

    public boolean validateDreamTypes() {
        List<WebElement> rows = driver.findElements(tableRows);
        for (WebElement row : rows) {
            String type = row.findElements(By.tagName("td")).get(2).getText();
            if (!type.equals("Good") && !type.equals("Bad")) return false;
        }
        return true;
    }

    public boolean areAllColumnsFilled() {
        List<WebElement> rows = driver.findElements(tableRows);
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.size() != 3 || cells.get(0).getText().isEmpty()
                    || cells.get(1).getText().isEmpty()
                    || cells.get(2).getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public boolean isDreamRecurring(String dreamName) {
        int count = 0;
        List<WebElement> rows = driver.findElements(tableRows);
        for (WebElement row : rows) {
            String name = row.findElements(By.tagName("td")).get(0).getText();
            if (name.equalsIgnoreCase(dreamName)) count++;
        }
        return count >= 2;
    }
}
