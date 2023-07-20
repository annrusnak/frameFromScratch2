package pages;// pages.SettingsPage.java

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SettingsPage {
    private WebDriver driver;

    public SettingsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By settingsHeader = By.xpath("//h2[text()='Settings']");

    public boolean isSettingsPageOpened() {
        return driver.findElement(settingsHeader).isDisplayed();
    }
}
