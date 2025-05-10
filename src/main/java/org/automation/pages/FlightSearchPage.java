package org.automation.pages;

import org.automation.base.BasePage;
import org.automation.utils.Utils;
import org.automation.utils.LoggerUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Page Object for the MakeMyTrip flight search page, including calendar and table handling.
 * <p>
 * Demonstrates OOP principles: Inheritance (extends BasePage), Encapsulation (private fields).
 */
public class FlightSearchPage extends BasePage {
    @FindBy(xpath = "//div[@class='listingCard']")
    private List<WebElement> flightResults;

    /**
     * Constructor to initialize page elements.
     *
     * @param driver The WebDriver instance.
     */
    public FlightSearchPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Selects a flight from the results table by index.
     *
     * @param index The index of the flight to select.
     */
    public void selectFlight(int index) {
        if (index < flightResults.size()) {
            Utils.click(driver, flightResults.get(index));
            LoggerUtil.info("Selected flight at index: " + index);
        } else {
            LoggerUtil.error("Flight index " + index + " is out of bounds", null);
            throw new IllegalArgumentException("Flight index out of bounds");
        }
    }
}

