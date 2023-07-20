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
import pages.SettingsPage;
import utils.DriverManager;
import utils.TestListener;

@Listeners(TestListener.class)
public class SettingsTest {
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
    @Description("Settings test")
    public void testSettingsPage() {
        logger.info("Navigating to Bing home page");
        bingHomePage.goToHomePage();

        logger.info("Clicking on the hamburger menu");
        bingHomePage.clickHamburgerMenu();

        logger.info("Selecting 'Settings' and then clicking on 'More'");
        bingHomePage.clickSettingsOption();
        SettingsPage settingsPage = bingHomePage.clickMoreOption();

        logger.info("Verifying that the settings page is opened");
        Assert.assertTrue(settingsPage.isSettingsPageOpened(), "The settings page is not opened");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        logger.info("Tearing down test environment");
        if (driver != null) {
            driver.quit();
        }
    }
}


