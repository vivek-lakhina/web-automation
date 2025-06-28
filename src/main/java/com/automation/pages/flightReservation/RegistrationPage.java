package com.automation.pages.flightReservation;

import com.automation.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BasePage {

    private WebDriver driver;
    @FindBy(id="firstName")
    private WebElement firstNameTextField;

    @FindBy(id="lastName")
    private WebElement lastNameTextField;

    @FindBy(id="email")
    private WebElement emailTextField;

    @FindBy(id="password")
    private WebElement passwordTextField;

    @FindBy(name="street")
    private WebElement streetTextField;

    @FindBy(name="city")
    private WebElement cityTextField;

    @FindBy(id="inputState")
    private WebElement stateDropdown;

    @FindBy(name="zip")
    private WebElement zipCodeTextField;

    @FindBy(id="register-btn")
    private WebElement registerButton;

    public RegistrationPage(WebDriver driver){
        super(driver);
    }

    public void inputUserDetails(String firstName,String lastName){
        this.firstNameTextField.sendKeys(firstName);
        this.lastNameTextField.sendKeys(lastName);
    }
    public void inputUserCredentials(String email,String password){
        this.emailTextField.sendKeys(email);
        this.passwordTextField.sendKeys(password);
    }

    public void inputAddress(String street,String city, String zip,String state){
        this.streetTextField.sendKeys(street);
        this.cityTextField.sendKeys(city);
        this.zipCodeTextField.sendKeys(zip);
        selectstate(state);
    }

    private void selectstate(String state) {
        Select stateDropdown = new Select(this.stateDropdown);
        stateDropdown.selectByValue(state);
    }

    public void clickRegisterButton(){
        this.registerButton.click();
    }

    public boolean isRegistrationPageLoaded(){
        return this.isPageLoaded(firstNameTextField);
    }
}
