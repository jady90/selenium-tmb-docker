package com.tmb.tests;

import com.tmb.utils.Config;
import com.tmb.utils.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class AbstractTest {

    protected WebDriver driver;

    @BeforeSuite
    public void setup(){
        Config.initialize();
    }

    @BeforeTest
    public void setDriver(ITestContext ctx) throws MalformedURLException {
        this.driver = Boolean.parseBoolean(Config.get(Constants.GRID_ENABLED))
                ? remoteDriver() : localDriver();
        this.driver.manage().window().maximize();
        ctx.setAttribute(Constants.DRIVER, this.driver);
    }

    private WebDriver localDriver(){
        String browser = Config.get(Constants.BROWSER);
        if(browser.equalsIgnoreCase(Constants.CHROME)){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }else {
            WebDriverManager.safaridriver().setup();
            return new SafariDriver();
        }
    }

    private WebDriver remoteDriver() throws MalformedURLException {
        String browser = Config.get(Constants.BROWSER);
        String url = String.format(Config.get(Constants.GRID_URL_FORMAT)
                , Config.get(Constants.GRID_HUB_HOST));
        if(browser.equalsIgnoreCase(Constants.CHROME))
        return new RemoteWebDriver(new URL(url), new ChromeOptions());
        else if (browser.equalsIgnoreCase(Constants.EDGE)) {
            return new RemoteWebDriver(new URL(url), new EdgeOptions());
        }
        return null;
    }

    @AfterTest
    public void teardown(){
        this.driver.quit();
    }
}
