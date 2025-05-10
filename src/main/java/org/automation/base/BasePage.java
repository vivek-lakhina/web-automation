package org.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Base class for all page objects, responsible for initializing PageFactory.
 * Demonstrates OOP principles: Abstraction (abstract class), Encapsulation (protected fields).
 */
public abstract class BasePage {
    protected WebDriver driver;

    /**
     * Constructor to initialize PageFactory.
     *
     * @param driver The WebDriver instance.
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
