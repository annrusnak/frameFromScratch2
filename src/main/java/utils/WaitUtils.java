package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    public static void waitUntilTitleDisplayed(String title) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().getDriver(), 10);
        wait.until(ExpectedConditions.titleContains(title));
    }

    public static WebElement waitForElementDisplayed(By element) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().getDriver(), 10); // wait for a maximum of 10 seconds
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
