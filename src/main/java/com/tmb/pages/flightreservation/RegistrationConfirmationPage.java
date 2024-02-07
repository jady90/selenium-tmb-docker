package com.tmb.pages.flightreservation;

import com.tmb.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationConfirmationPage extends AbstractPage {

    @FindBy(xpath = "//div[@id='registration-confirmation-section']//b")
    private WebElement firstNameElement;

    @FindBy(id = "go-to-flights-search")
    private WebElement btnFlightsSearch;

    public RegistrationConfirmationPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(btnFlightsSearch));
        return this.btnFlightsSearch.isDisplayed();
    }

    public String getFirstNameElement(){
        return firstNameElement.getText().trim();
    }

    public void goToFlightsSearch(){
        btnFlightsSearch.click();
    }
}
