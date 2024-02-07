package com.tmb.pages.flightreservation;

import com.tmb.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class FlightSearchPage extends AbstractPage {

    @FindBy(id = "twoway")
    private WebElement rdBtnRoundTrip;

    @FindBy(id = "passengers")
    private WebElement dropdownNoOfPassengers;

    @FindBy(id = "search-flights")
    private WebElement btnSearchFlights;

    public FlightSearchPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(btnSearchFlights));
        return this.btnSearchFlights.isDisplayed();
    }

    public void selectNoOfPassengers(String noOfPassengers){
        Select select = new Select(this.dropdownNoOfPassengers);
        select.selectByValue(noOfPassengers);
    }

    public void searchFlights(){
        this.btnSearchFlights.click();
    }
}
