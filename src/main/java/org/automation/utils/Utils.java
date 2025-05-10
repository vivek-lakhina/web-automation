package org.automation.utils;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.apache.commons.io.FileUtils;
import org.automation.base.BasePage;
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
     * Waits for the specified web element to be visible.
     *
     * @param driver  The WebDriver instance.
     * @param element The WebElement to wait for.
     */
    public static void waitForElementVisible(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, java.time.Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(element));
        LoggerUtil.info("Waited for visibility of element: " + element.toString());
    }

    /**
     * Waits for the specified web element to be clickable.
     *
     * @param driver  The WebDriver instance.
     * @param element The WebElement to wait for.
     */
    public static void waitForElementClickable(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, java.time.Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(element));
        LoggerUtil.info("Waited for clickability of element: " + element.toString());
    }

    /**
     * Clicks on the specified web element after ensuring it is clickable.
     *
     * @param driver  The WebDriver instance.
     * @param element The WebElement to click.
     */
    public static void click(WebDriver driver, WebElement element) {
        waitForElementClickable(driver, element);
        element.click();
        LoggerUtil.info("Clicked element: " + element.toString());
    }

    /**
     * Sends keys to the specified web element after ensuring it is visible.
     *
     * @param driver  The WebDriver instance.
     * @param element The WebElement to send keys to.
     * @param text    The text to send.
     */
    public static void sendKeys(WebDriver driver, WebElement element, String text) {
        waitForElementVisible(driver, element);
        element.clear();
        element.sendKeys(text);
        LoggerUtil.info("Sent text '" + text + "' to element: " + element.toString());
    }

    /**
     * Retrieves the text from the specified web element after ensuring it is visible.
     *
     * @param driver  The WebDriver instance.
     * @param element The WebElement to get text from.
     * @return The text of the element.
     */
    public static String getText(WebDriver driver, WebElement element) {
        waitForElementVisible(driver, element);
        String text = element.getText();
        LoggerUtil.info("Retrieved text '" + text + "' from element: " + element.toString());
        return text;
    }

    /**
     * Checks if the specified web element is displayed.
     *
     * @param driver  The WebDriver instance.
     * @param element The WebElement to check.
     * @return True if the element is displayed, false otherwise.
     */
    public static boolean isDisplayed(WebDriver driver, WebElement element) {
        try {
            boolean displayed = element.isDisplayed();
            LoggerUtil.info("Element is displayed: " + displayed);
            return displayed;
        } catch (Exception e) {
            LoggerUtil.info("Element is not displayed");
            return false;
        }
    }

    /**
     * Clicks on the specified web element using JavaScript.
     *
     * @param driver  The WebDriver instance.
     * @param element The WebElement to click.
     */
    public static void jsClick(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
        LoggerUtil.info("Performed JavaScript click on element: " + element.toString());
    }

    /**
     * Selects an option from a dropdown by visible text.
     *
     * @param driver   The WebDriver instance.
     * @param dropdown The WebElement representing the dropdown.
     * @param text     The visible text of the option to select.
     */
    public static void selectByVisibleText(WebDriver driver, WebElement dropdown, String text) {
        waitForElementVisible(driver, dropdown);
        Select select = new Select(dropdown);
        select.selectByVisibleText(text);
        LoggerUtil.info("Selected option '" + text + "' from dropdown: " + dropdown.toString());
    }

    /**
     * Selects an option from a dropdown by value.
     *
     * @param driver   The WebDriver instance.
     * @param dropdown The WebElement representing the dropdown.
     * @param value    The value of the option to select.
     */
    public static void selectByValue(WebDriver driver, WebElement dropdown, String value) {
        waitForElementVisible(driver, dropdown);
        Select select = new Select(dropdown);
        select.selectByValue(value);
        LoggerUtil.info("Selected option with value '" + value + "' from dropdown: " + dropdown.toString());
    }

    /**
     * Switches to a new window.
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
     * Switches back to the parent window.
     *
     * @param driver       The WebDriver instance.
     * @param parentWindow The handle of the parent window.
     */
    public static void switchToParentWindow(WebDriver driver, String parentWindow) {
        driver.switchTo().window(parentWindow);
        LoggerUtil.info("Switched back to parent window: " + parentWindow);
    }

    /**
     * Captures a screenshot and saves it to the target directory.
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
}

