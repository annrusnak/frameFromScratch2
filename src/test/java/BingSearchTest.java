import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BingHomePage;
import utils.DriverManager;
import utils.TestListener;
import utils.WaitUtils;

@Listeners(TestListener.class)
public class BingSearchTest {
    private WebDriver driver;
    private BingHomePage bingHomePage;

    private static final Logger logger = LogManager.getLogger(BingSearchTest.class);

    @BeforeMethod
    public void setup() {
        logger.info("Setting up test environment");
        driver = DriverManager.getInstance().getDriver();
        bingHomePage = new BingHomePage(driver);
    }

    @Test
    @Description("Search test")
    public void testWeatherSearch() {
        logger.info("Navigating to Bing home page");
        bingHomePage.goToHomePage();

        logger.info("Performing search for 'weather in Lviv'");
        bingHomePage.setSearch("weather in Lviv");
        bingHomePage.clickSearch();

        logger.info("Waiting for page to load");
        WaitUtils.waitUntilTitleDisplayed("weather in Lviv");

        logger.info("Verifying that the search results contain information about the weather in Lviv");
        Assert.assertTrue(driver.getTitle().contains("weather in Lviv"), "The page title does not contain 'weather in Lviv'");
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        logger.info("Tearing down test environment");
        if (driver != null) {
            driver.quit();
        }
    }
}
