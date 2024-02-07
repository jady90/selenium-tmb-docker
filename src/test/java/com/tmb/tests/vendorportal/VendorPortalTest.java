package com.tmb.tests.vendorportal;

import com.tmb.pages.vendorportal.DashboardPage;
import com.tmb.pages.vendorportal.LoginPage;
import com.tmb.tests.AbstractTest;
import com.tmb.tests.vendorportal.modal.VendorPortalTestData;
import com.tmb.utils.Config;
import com.tmb.utils.Constants;
import com.tmb.utils.JsonUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class VendorPortalTest extends AbstractTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private VendorPortalTestData testData;

    @BeforeTest
    @Parameters("path")
    public void setup(String path){
        this.loginPage = new LoginPage(this.driver);
        this.dashboardPage = new DashboardPage(this.driver);
        this.testData = JsonUtils.getTestData(path, VendorPortalTestData.class);
    }

    @Test
    public void loginTest(){
        loginPage.goTo(Config.get(Constants.VENDOR_PORTAL_URL));
        Assert.assertTrue(loginPage.isAt());
        loginPage.enterCredentials(testData.username(), testData.password());
        loginPage.login();
    }

    @Test(dependsOnMethods = "loginTest")
    public void dashboardTest(){
        Assert.assertTrue(dashboardPage.isAt());
        Assert.assertEquals(dashboardPage.getMonthlyEarnings(), testData.monthlyEarnings());
        Assert.assertEquals(dashboardPage.getAnnualEarningElement(), testData.annualEarnings());
        Assert.assertEquals(dashboardPage.getProfitMargin(), testData.profitMargin());
        Assert.assertEquals(dashboardPage.getAvailableInventory(), testData.availableInventory());
        dashboardPage.searchCriteria(testData.searchCriteria());
        Assert.assertEquals(dashboardPage.getSearchResult(), testData.searchResult());
    }

    @Test(dependsOnMethods = "dashboardTest")
    public void logoutTest(){
        dashboardPage.logout();
        Assert.assertTrue(loginPage.isAt());
    }
}
