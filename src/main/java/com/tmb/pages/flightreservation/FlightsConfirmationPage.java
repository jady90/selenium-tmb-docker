package com.tmb.pages.flightreservation;

import com.tmb.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlightsConfirmationPage extends AbstractPage {

    private static final Logger log = LoggerFactory.getLogger(FlightsConfirmationPage.class);

    @FindBy(xpath = "//div[@id='flights-confirmation-section']//div[@class='row'][1]//p")
    private WebElement flightConfirmationElement;

    @FindBy(xpath = "//div[@id='flights-confirmation-section']//div[@class='row'][3]//p")
    private WebElement totalPriceElement;

    public FlightsConfirmationPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(flightConfirmationElement));
        return flightConfirmationElement.isDisplayed();
    }

    public String getFlightConfirmationNumber(){
        String confirmation = flightConfirmationElement.getText().trim();
        log.info("Flight confirmation# : {}", confirmation);
        return confirmation;
    }

    public String getTotalPrice(){
        String price = totalPriceElement.getText().trim();
        log.info("Total price is : {}", price);
        return price;
    }
}
