package org.automation.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

/**
 * Utility class for common element interactions with built-in checks.
 * <p>
 * Demonstrates OOP principles: Encapsulation (static methods), Utility pattern.
 */
public class Utils {

    /**
     * Click an element after ensuring it's clickable.
     *
     * @param driver  The WebDriver instance.
     * @param locator The By locator for the element.
     */
    public static void click(WebDriver driver, By locator) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
        LoggerUtil.info("Clicked element with locator: " + locator.toString());
    }

    /**
     * Send keys to an element after ensuring it's visible.
     *
     * @param driver  The WebDriver instance.
     * @param locator The By locator for the element.
     * @param text    The text to send.
     */
    public static void sendKeys(WebDriver driver, By locator, String text) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
        LoggerUtil.info("Sent text '" + text + "' to element with locator: " + locator.toString());
    }

    /**
     * Get text from an element after ensuring it's visible.
     *
     * @param driver  The WebDriver instance.
     * @param locator The By locator for the element.
     * @return The text of the element.
     */
    public static String getText(WebDriver driver, By locator) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(locator));
        String text = element.getText();
        LoggerUtil.info("Retrieved text '" + text + "' from element with locator: " + locator.toString());
        return text;
    }

    /**
     * Check if an element is displayed.
     *
     * @param driver  The WebDriver instance.
     * @param locator The By locator for the element.
     * @return True if the element is displayed, false otherwise.
     */
    public static boolean isDisplayed(WebDriver driver, By locator) {
        try {
            boolean displayed = driver.findElement(locator).isDisplayed();
            LoggerUtil.info("Element with locator " + locator.toString() + " is displayed: " + displayed);
            return displayed;
        } catch (Exception e) {
            LoggerUtil.info("Element with locator " + locator.toString() + " is not displayed");
            return false;
        }
    }

    /**
     * Click an element using JavaScript for dynamic content.
     *
     * @param driver  The WebDriver instance.
     * @param locator The By locator for the element.
     */
    public static void jsClick(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
        LoggerUtil.info("Performed JavaScript click on element with locator: " + locator.toString());
    }

    /**
     * Select an option from a dropdown by value.
     *
     * @param driver  The WebDriver instance.
     * @param locator The By locator for the dropdown.
     * @param value   The value of the option to select.
     */
    public static void selectByValue(WebDriver driver, By locator, String value) {
        WebElement element = driver.findElement(locator);
        Select select = new Select(element);
        select.selectByValue(value);
        LoggerUtil.info("Selected option with value '" + value + "' from dropdown with locator: " + locator.toString());
    }

    /**
     * Select an option from a dropdown by visible text.
     *
     * @param driver  The WebDriver instance.
     * @param locator The By locator for the dropdown.
     * @param text    The visible text of the option to select.
     */
    public static void selectByVisibleText(WebDriver driver, By locator, String text) {
        WebElement element = driver.findElement(locator);
        Select select = new Select(element);
        select.selectByVisibleText(text);
        LoggerUtil.info("Selected option '" + text + "' from dropdown with locator: " + locator.toString());
    }

    /**
     * Capture a screenshot and save it to the target directory.
     *
     * @param driver   The WebDriver instance.
     * @param testName The name of the test.
     * @return The path to the saved screenshot.
     */

    public static String captureScreenshot(WebDriver driver, String testName) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotPath = "target/screenshots/" + testName + "_" + timestamp + ".png";
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(screenshotPath));
            LoggerUtil.info("Captured screenshot: " + screenshotPath);
        } catch (IOException e) {
            LoggerUtil.error("Failed to capture screenshot", e);
        }
        return screenshotPath;
    }

    /**
     * Switch to a new window.
     *
     * @param driver The WebDriver instance.
     * @return The handle of the new window.
     */
    public static String switchToNewWindow(WebDriver driver) {
        String parentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                LoggerUtil.info("Switched to new window: " + window);
                return window;
            }
        }
        LoggerUtil.info("No new window found");
        return null;
    }

    /**
     * Switch back to the parent window.
     *
     * @param driver       The WebDriver instance.
     * @param parentWindow The handle of the parent window.
     */
    public static void switchToParentWindow(WebDriver driver, String parentWindow) {
        driver.switchTo().window(parentWindow);
        LoggerUtil.info("Switched back to parent window: " + parentWindow);
    }
}
