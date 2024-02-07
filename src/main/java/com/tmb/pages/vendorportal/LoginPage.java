package com.tmb.pages.vendorportal;

import com.tmb.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends AbstractPage {

    @FindBy(id = "username")
    private WebElement txtUsername;

    @FindBy(id = "password")
    private WebElement txtPassword;

    @FindBy(id = "login")
    private WebElement btnLogin;


    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void goTo(String url){
        this.driver.get(url);
    }

    public void enterCredentials(String username, String password){
        txtUsername.sendKeys(username);
        txtPassword.sendKeys(password);
    }

    public void login(){
        btnLogin.click();
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(txtUsername));
        return txtUsername.isDisplayed();
    }
}
