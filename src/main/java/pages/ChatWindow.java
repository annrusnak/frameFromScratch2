package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static utils.WaitUtils.waitForElementDisplayed;

public class ChatWindow {
    private WebDriver driver;

    public ChatWindow(WebDriver driver) {
        this.driver = driver;
    }

    private By infoWindow = By.xpath("//*[text()='Chat mode is only available when you have access to the new Bing.']");

    public boolean isInfoWindowDisplayed() {
        return waitForElementDisplayed(infoWindow).isDisplayed();
    }
}
