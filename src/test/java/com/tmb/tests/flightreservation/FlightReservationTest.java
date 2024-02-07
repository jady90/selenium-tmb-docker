package com.tmb.tests.flightreservation;

import com.tmb.pages.flightreservation.*;
import com.tmb.tests.AbstractTest;
import com.tmb.tests.flightreservation.modal.FlightReservationTestData;
import com.tmb.utils.Config;
import com.tmb.utils.Constants;
import com.tmb.utils.JsonUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FlightReservationTest extends AbstractTest {

    private FlightReservationTestData testData;

    @BeforeTest
    @Parameters("path")
    public void setup(String path){
        this.testData = JsonUtils.getTestData(path, FlightReservationTestData.class);
    }

    @Test
    public void registrationTest(){
        RegistrationPage registrationPage = new RegistrationPage(this.driver);
        registrationPage.goTo(Config.get(Constants.FLIGHT_RESERVATION_URL));
        Assert.assertTrue(registrationPage.isAt());
        registrationPage.enterUserDetails(testData.firstName(), testData.lastName());
        registrationPage.enterUserCredentials(testData.email(), testData.email());
        registrationPage.enterAddress(testData.email(), testData.city(), testData.zip());
        registrationPage.register();
    }

    @Test(dependsOnMethods = "registrationTest")
    public void registrationConfirmationTest(){
        RegistrationConfirmationPage confirmationPage = new RegistrationConfirmationPage(this.driver);
        Assert.assertTrue(confirmationPage.isAt());
        Assert.assertEquals(confirmationPage.getFirstNameElement(), testData.firstName());
        confirmationPage.goToFlightsSearch();
    }

    @Test(dependsOnMethods = "registrationConfirmationTest")
    public void flightSearchTest(){
        FlightSearchPage searchPage = new FlightSearchPage(this.driver);
        Assert.assertTrue(searchPage.isAt());
        searchPage.selectNoOfPassengers(testData.passengersCount());
        searchPage.searchFlights();
    }

    @Test(dependsOnMethods = "flightSearchTest")
    public void selectFlightsTest(){
        SelectFlightsPage flightsPage = new SelectFlightsPage(this.driver);
        Assert.assertTrue(flightsPage.isAt());
        flightsPage.selectDepartureFlightOption();
        flightsPage.selectArrivalDepartureFlightOption();
        flightsPage.confirmFlights();
    }

    @Test(dependsOnMethods = "selectFlightsTest")
    public void flightConfirmationTest(){
        FlightsConfirmationPage confirmationPage = new FlightsConfirmationPage(this.driver);
        Assert.assertTrue(confirmationPage.isAt());
        confirmationPage.getFlightConfirmationNumber();
        Assert.assertEquals(confirmationPage.getTotalPrice(), testData.expectedPrice());
    }
}
