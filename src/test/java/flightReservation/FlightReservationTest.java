//package flightReservation;
//
//import com.automation.pages.flightReservation.*;
////import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.*;
//
//public class FlightReservationTest {
//
//    private WebDriver driver;
//    private String noOfPassengers;
//    private String expectedPrice;
//    @BeforeTest
//    @Parameters({"noOfPassengers","expectedPrice"})
//    public void setDriver(String noOfPassengers,String expectedPrice){
//        this.noOfPassengers = noOfPassengers;
//        this.expectedPrice = expectedPrice;
//        // Driver Setup
//        WebDriverManager.chromedriver().setup();
//        this.driver = new ChromeDriver();
//        this.driver.manage().window().maximize();
//    }
//
//    @Test
//    public void userRegistration(){
//        RegistrationPage registrationPage = new RegistrationPage(driver);
//        registrationPage.open("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/reservation-app/index.html");
//        Assert.assertTrue(registrationPage.isRegistrationPageLoaded());
//
//        registrationPage.inputUserDetails("selenium","docker");
//        registrationPage.inputUserCredentials("selenium@docker.com","docker");
//        registrationPage.inputAddress("123","Delhi","110096","California");
//        registrationPage.clickRegisterButton();
//    }
//
//    @Test(dependsOnMethods = "userRegistration")
//    public void registrationConfirmationTest(){
//        RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
//        Assert.assertTrue(registrationConfirmationPage.isRegistrationConfirmationPageLoaded());
//        registrationConfirmationPage.clickFlightSearchButton();
//    }
//
//    @Test(dependsOnMethods = "registrationConfirmationTest")
//    public void flightSearchTest() throws InterruptedException {
//        FlightSearchPage flightSearchPage =new FlightSearchPage(driver);
//        Assert.assertTrue(flightSearchPage.isFlightSearchPageDisplayed());
//        flightSearchPage.selectPassengerCount(noOfPassengers);
//        flightSearchPage.clickSearchFlightButton();
//    }
//
//    @Test(dependsOnMethods = "flightSearchTest")
//    public void flightSelectionTest(){
//        FlightSelectionPage flightSelectionPage = new FlightSelectionPage(driver);
//        Assert.assertTrue(flightSelectionPage.isFlightSlectionPageLoaded());
//        flightSelectionPage.selectFlights();
//        flightSelectionPage.clickConfirmFlight();
//    }
//
//    @Test(dependsOnMethods = "flightSelectionTest")
//    public void reservationConfirmationTest(){
//        FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
//        Assert.assertTrue(flightConfirmationPage.isFlightConfirmationPageLoaded());
//        Assert.assertEquals(flightConfirmationPage.getPrice(),expectedPrice);
//    }
//
//    @AfterTest
//    public void quitBrowser(){
//        this.driver.quit();
//    }
//}
//
