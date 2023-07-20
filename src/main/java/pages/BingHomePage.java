package pages;// pages.BingHomePage.java

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static utils.WaitUtils.waitForElementDisplayed;

public class BingHomePage {
    private WebDriver driver;

    public BingHomePage(WebDriver driver) {
        this.driver = driver;
    }

    private String homePageUrl = "https://www.bing.com/";

    private By searchBox = By.id("sb_form_q");
    private By searchButton = By.id("search_icon");
    private By chatLink = By.xpath("//*[text()='Chat']");
    private By hamburgerMenu = By.xpath("//*[@aria-label='Settings and quick links']");
    private By settingsOption = By.id("hbsettings");
    private By moreOption = By.xpath("//*[text()='More']");

    public void goToHomePage() {
        driver.get(homePageUrl);
    }

    public void setSearch(String searchTerm) {
        driver.findElement(searchBox).sendKeys(searchTerm);
    }

    public void clickSearch() {
        driver.findElement(searchButton).click();
    }

    public ChatWindow clickChatLink() {
        waitForElementDisplayed(chatLink).click();
        return new ChatWindow(driver);
    }

    public void clickHamburgerMenu() {
        waitForElementDisplayed(hamburgerMenu).click();
    }

    public void clickSettingsOption() {
        waitForElementDisplayed(settingsOption).click();
    }

    public SettingsPage clickMoreOption() {
        waitForElementDisplayed(moreOption).click();
        return new SettingsPage(driver);
    }
}
