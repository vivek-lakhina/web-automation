package com.automation.pages.flightReservation;

import com.automation.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class FlightSearchPage extends BasePage {

    @FindBy(id="oneway")
    private WebElement oneWayRadioButton;

    @FindBy(id="twoway")
    private WebElement roundTripRadioButton;

    @FindBy(id="passengers")
    private WebElement passengerDropdown;

    @FindBy(id="depart-from")
    private WebElement departFromDropdown;

    @FindBy(id="arrive-in")
    private WebElement arriveInDropdown;

    @FindBy(id="service-class1")
    private WebElement economyClassRadioButton;

    @FindBy(id="service-class2")
    private WebElement firstClassRadioButton;

    @FindBy(id="service-class2")
    private WebElement businessClassRadioButton;

    @FindBy(id="search-flights")
    private WebElement searchFlightButton;

    public FlightSearchPage(WebDriver driver){
        super(driver);
    }

    public void selectTripType(String tripType){
        switch (tripType.toLowerCase()){
            case "oneway":
                this.oneWayRadioButton.click();
                break;
            case "roundtrip":
                this.roundTripRadioButton.click();
                break;
            default:
                System.out.println("Invalid Trip Type Value");
        }
    }

    public void selectServiceClass(String serviceClass){
        switch (serviceClass.toLowerCase()){
            case "economy":
                this.economyClassRadioButton.click();
                break;
            case "first":
                this.firstClassRadioButton.click();
                break;
            case "business":
                this.businessClassRadioButton.click();
                break;
            default:
                System.out.println("Invalid Trip Type Value");
        }
    }

    public void selectPassengerCount(String passengerCount){
        Select passengers = new Select(passengerDropdown);
        passengers.selectByValue(passengerCount);
    }

    public void selectDepartingCity(String departingCity){
        Select departing = new Select(departFromDropdown);
        departing.selectByValue(departingCity);
    }

    public void selectArriveInCity(String arriveInCity){
        Select arriveIn = new Select(arriveInDropdown);
        arriveIn.selectByValue(arriveInCity);
    }

    public void clickSearchFlightButton() throws InterruptedException {
        this.scrollToBottom();
        this.wait(3);
        this.searchFlightButton.click();
    }

    public boolean isFlightSearchPageDisplayed(){
       return this.isPageLoaded(oneWayRadioButton);
    }
}
