package org.automation.pages;

import org.automation.base.BasePage;
import org.automation.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object for the MakeMyTrip home page.
 * <p>
 * Demonstrates OOP principles: Inheritance (extends BasePage), Encapsulation (private fields).
 */
public class HomePage extends BasePage {
    @FindBy(id = "fromCity")
    private WebElement fromCity;

    @FindBy(id = "toCity")
    private WebElement toCity;

    @FindBy(id = "departure")
    private WebElement departureDate;

    @FindBy(xpath = "//a[contains(text(),'Search')]")
    private WebElement searchButton;

    /**
     * Constructor to initialize page elements.
     *
     * @param driver The WebDriver instance.
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Enters the departure city.
     *
     * @param city The city name.
     */
    public void enterFromCity(String city){Utils.sendKeys(driver, fromCity, city);
    }

    /**
     * Enters the destination city.
     *
     * @param city The city name.
     */
    public void enterToCity(String city) {
        Utils.sendKeys(driver, toCity, city);
    }

    /**
     * Selects the departure date from the calendar.
     *
     * @param date The date in format "dd MMM yyyy" (e.g., "15 Jun 2025").
     */
    public void selectDepartureDate(String date) {
        Utils.click(driver, departureDate);
        // Additional logic for calendar selection can be added here
    }

    /**
     * Clicks the Search button to submit the flight search.
     */
    public void clickSearchButton() {
        Utils.click(driver, searchButton);
    }
}
