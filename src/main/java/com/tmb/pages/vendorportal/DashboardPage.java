package com.tmb.pages.vendorportal;

import com.tmb.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends AbstractPage {

    @FindBy(id = "monthly-earning")
    private WebElement monthlyEarningsElement;

    @FindBy(id = "annual-earning")
    private WebElement annualEarningsElement;

    @FindBy(id = "profit-margin")
    private WebElement profitMarginElement;

    @FindBy(id = "available-inventory")
    private WebElement availableInventoryElement;

    @FindBy(xpath = "//div[@id='dataTable_filter']//input")
    private WebElement txtSearch;

    @FindBy(id = "dataTable_info")
    private WebElement tableInfoElement;

    @FindBy(id = "userDropdown")
    private WebElement linkProfileOptions;

    @FindBy(xpath = "//a[@data-toggle='modal']")
    private WebElement linkLogout;

    @FindBy(xpath = "//div[@class='modal-footer']/a")
    private WebElement linkModalLogout;


    public DashboardPage(WebDriver driver){
        super(driver);
    }

    public String getMonthlyEarnings(){
        return monthlyEarningsElement.getText();
    }

    public String getAnnualEarningElement(){
        return annualEarningsElement.getText();
    }

    public String getProfitMargin(){
        return profitMarginElement.getText();
    }

    public String getAvailableInventory(){
        return availableInventoryElement.getText();
    }

    public void searchCriteria(String num){
        txtSearch.sendKeys(num);
    }

    public String getSearchResult(){
        String str = tableInfoElement.getText();
        String[] arr = str.split(" ");
        return arr[5];
    }

    public void logout(){
        linkProfileOptions.click();
        this.wait.until(ExpectedConditions.visibilityOf(linkLogout));
        if(this.linkLogout.isDisplayed())
            linkLogout.click();
        this.wait.until(ExpectedConditions.visibilityOf(linkModalLogout));
        if(this.linkModalLogout.isDisplayed())
            linkModalLogout.click();
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(txtSearch));
        return txtSearch.isDisplayed();
    }
}
