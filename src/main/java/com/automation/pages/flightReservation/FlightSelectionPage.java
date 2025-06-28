package com.automation.pages.flightReservation;

import com.automation.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class FlightSelectionPage extends BasePage {

    @FindBy(name="departure-flight")
    private List<WebElement> departureFlightRadioButton;

    @FindBy(name="arrival-flight")
    private List<WebElement> arrivalFlightRadioButton;

    @FindBy(id="confirm-flights")
    private WebElement confirmFlightButton;

    public FlightSelectionPage(WebDriver driver){
        super(driver);
    }

    public boolean isFlightSlectionPageLoaded(){
        this.wait(3);
        this.scrollToBottom();
        return this.isPageLoaded(this.confirmFlightButton);
    }

    public void selectFlights(){
        int random = ThreadLocalRandom.current().nextInt(0,departureFlightRadioButton.size());
        departureFlightRadioButton.get(random).click();
        this.wait(3);
        arrivalFlightRadioButton.get(random).click();
    }

    public void clickConfirmFlight(){
        this.scrollToBottom();
        this.wait(3);
        this.confirmFlightButton.click();
    }
}
