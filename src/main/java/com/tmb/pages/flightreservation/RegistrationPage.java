package com.tmb.pages.flightreservation;

import com.tmb.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegistrationPage extends AbstractPage {

    private static final Logger log = LoggerFactory.getLogger(RegistrationPage.class);
    @FindBy(id = "firstName")
    private WebElement txtFirstName;

    @FindBy(id = "lastName")
    private WebElement txtLastName;

    @FindBy(id = "email")
    private WebElement txtEmail;

    @FindBy(id = "password")
    private WebElement txtPassword;

    @FindBy(name = "street")
    private WebElement txtStreet;

    @FindBy(name = "city")
    private WebElement txtCity;

    @FindBy(id = "inputState")
    private WebElement dropdownState;

    @FindBy(name = "zip")
    private WebElement txtZip;

    @FindBy(id = "register-btn")
    private WebElement btnRegister;

    public RegistrationPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(txtFirstName));
        return this.txtFirstName.isDisplayed();
    }

    public void goTo(String url){
        this.driver.get(url);
        log.info("Url launched : {}", url);
    }

    public void enterUserDetails(String firstName, String lastName){
        txtFirstName.sendKeys(firstName);
        txtLastName.sendKeys(lastName);
    }

    public void enterUserCredentials(String email, String password){
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
    }

    public void enterAddress(String street, String city, String zip){
        txtStreet.sendKeys(street);
        txtCity.sendKeys(city);
        txtZip.sendKeys(zip);
    }

    public void register(){
        btnRegister.click();
    }
}
