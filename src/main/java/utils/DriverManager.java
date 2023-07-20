package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static DriverManager instance = null;
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    private DriverManager() {
    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public WebDriver getDriver() {
        if (webDriver.get() == null) {
            WebDriverManager.chromedriver().setup();
            webDriver.set(new ChromeDriver());
        }
        return webDriver.get();
    }

    public void quitDriver() {
        if (null != webDriver.get()) {
            try {
                webDriver.get().quit();
                webDriver.remove();
            } catch (Exception e) {
                throw new RuntimeException("Error quitting driver", e);
            }
        }
    }
}
