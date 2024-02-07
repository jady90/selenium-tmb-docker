package com.tmb.pages.flightreservation;

import com.tmb.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SelectFlightsPage extends AbstractPage {

    @FindBy(name = "departure-flight")
    private List<WebElement> departureFlightOptions;

    @FindBy(name = "arrival-flight")
    private List<WebElement> arrivalFlightOptions;

    @FindBy(id = "confirm-flights")
    private WebElement btnConfirmFlights;

    public SelectFlightsPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(btnConfirmFlights));
        return btnConfirmFlights.isDisplayed();
    }

    public void selectDepartureFlightOption(){
        int random = ThreadLocalRandom.current().nextInt(0, departureFlightOptions.size());
        departureFlightOptions.get(random).click();
    }

    public void selectArrivalDepartureFlightOption(){
        int random = ThreadLocalRandom.current().nextInt(0, arrivalFlightOptions.size());
        arrivalFlightOptions.get(random).click();
    }

    public void confirmFlights(){
        btnConfirmFlights.click();
    }
}
