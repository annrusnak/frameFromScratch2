import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BingHomePage;
import pages.ChatWindow;
import utils.DriverManager;
import utils.TestListener;

@Listeners(TestListener.class)
public class ChatTest {
    private WebDriver driver;
    private BingHomePage bingHomePage;

    private static final Logger logger = LogManager.getLogger(BingSearchTest.class);

    @BeforeClass
    public void setup() {
        logger.info("Setting up test environment");
        driver = DriverManager.getInstance().getDriver();
        bingHomePage = new BingHomePage(driver);
    }


    @Test
    @Description("Chat test")
    public void testChatLink() {
        logger.info("Navigating to Bing home page");
        bingHomePage.goToHomePage();

        logger.info("Clicking on the chat link");
        ChatWindow chatWindow = bingHomePage.clickChatLink();

        logger.info("Verifying that the pop-up information window is displayed");
        Assert.assertTrue(chatWindow.isInfoWindowDisplayed(), "The pop-up information window is not displayed");
    }


    @AfterClass(alwaysRun = true)
    public void tearDown() {
        logger.info("Tearing down test environment");
        if (driver != null) {
            driver.quit();
        }
    }
}


