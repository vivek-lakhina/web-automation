package com.automation.pages.flightReservation;

import com.automation.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationConfirmationPage extends BasePage {

    @FindBy(id="go-to-flights-search")
    private WebElement flightSearchButton;

    public RegistrationConfirmationPage(WebDriver driver){
        super(driver);
    }

    public void clickFlightSearchButton(){
        this.flightSearchButton.click();
    }

    public boolean isRegistrationConfirmationPageLoaded(){
        return this.isPageLoaded(flightSearchButton);
    }
}
