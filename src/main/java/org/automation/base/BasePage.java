package org.automation.base;

import org.automation.utils.LoggerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Base class for all page objects, implementing Page Object Model (POM) with common utilities.
 * <p>
 * Demonstrates OOP principles: Abstraction (abstract class), Encapsulation (protected fields).
 */
public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    /**
     * Constructor to initialize WebDriver and WebDriverWait.
     *
     * @param driver The WebDriver instance.
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        LoggerUtil.info("Initialized BasePage for: " + this.getClass().getSimpleName());
    }

    /**
     * Wait for an element to be visible.
     *
     * @param driver  The WebDriver instance.
     * @param locator The By locator for the element.
     */
    public static void waitForElementVisible(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(locator));
        LoggerUtil.info("Waited for visibility of element with locator: " + locator.toString());
    }

    /**
     * Wait for an element to be clickable.
     *
     * @param driver  The WebDriver instance.
     * @param locator The By locator for the element.
     */
    public static void waitForElementClickable(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(locator));
        LoggerUtil.info("Waited for clickability of element with locator: " + locator.toString());
    }

}