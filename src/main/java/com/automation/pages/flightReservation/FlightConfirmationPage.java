package com.automation.pages.flightReservation;

import com.automation.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlightConfirmationPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(FlightConfirmationPage.class);
    @FindBy(xpath = "//div[contains(text(),'Total Price')]/following-sibling::div/p")
    private WebElement totalPrice;

    @FindBy(xpath = "//div[contains(text(),'Flight Confirmation')]/following-sibling::div/p")
    private WebElement flightConfirmationNumber;

    public FlightConfirmationPage(WebDriver driver){
        super(driver);
    }

    public boolean isFlightConfirmationPageLoaded(){
        return this.isPageLoaded(totalPrice);
    }

    public String getPrice(){
        String price = this.totalPrice.getText();
        String flightConfirmationNumber = this.flightConfirmationNumber.getText();
        log.info("Flight Confirmation # : {}", flightConfirmationNumber);
        log.info("Total Price : {}",price);
        return price;
    }
}
