package org.automation.utils;

import org.automation.config.ConfigurationManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Factory class to create thread-safe WebDriver instances based on configuration.
 * <p>
 * Demonstrates OOP principles: Encapsulation (private ThreadLocal), Factory pattern.
 */
public class DriverFactory {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    /**
     * Get WebDriver instance for the current thread.
     *
     * @return The WebDriver instance.
     */
    public static WebDriver getDriver() {
        if (driver.get() == null) {
            String browser = ConfigurationManager.getProperty("browser");
            switch (browser.toLowerCase()) {
                case "chrome":
                    driver.set(new ChromeDriver());
                    break;
                case "firefox":
                    driver.set(new FirefoxDriver());
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
            driver.get().manage().window().maximize();
            LoggerUtil.info("Initialized WebDriver for browser: " + browser);
        }
        return driver.get();
    }

    /**
     * Quit WebDriver and clean up for the current thread.
     */
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
            LoggerUtil.info("WebDriver quit successfully");
        }
    }
}
