package org.automation.tests;

import org.automation.base.BaseTest;
import org.automation.config.ConfigurationManager;
import org.automation.pages.HomePage;
import org.automation.pages.FlightSearchPage;
import org.automation.utils.LoggerUtil;
import org.automation.utils.TestDataReader;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Sample test class demonstrating flight booking automation on MakeMyTrip.
 * Demonstrates OOP principles: Inheritance (extends BaseTest), Encapsulation (private methods).
 */
public class FlightBookingTest extends BaseTest {
    @Test
    public void testFlightBooking() {
        // Load test data
        Map<String, Object> testData = TestDataReader.getTestData("flightBooking");
        String fromCity = (String) testData.get("fromCity");
        String toCity = (String) testData.get("toCity");
        String departureDate = (String) testData.get("departureDate");

        LoggerUtil.info("Starting flight booking test with fromCity: " + fromCity + ", toCity: " + toCity);

        // Navigate to home page and perform search
        driver.get(ConfigurationManager.getProperty("baseUrl"));
        HomePage homePage = new HomePage(driver);
        homePage.enterFromCity(fromCity);
        homePage.enterToCity(toCity);
        homePage.selectDepartureDate(departureDate);
        homePage.clickSearchButton();

        // Proceed to flight selection
        FlightSearchPage flightSearchPage = new FlightSearchPage(driver);
        flightSearchPage.selectFlight(0); // Select the first flight
    }
}
