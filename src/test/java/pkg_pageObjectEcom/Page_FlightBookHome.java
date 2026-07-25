package pkg_pageObjectEcom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import pkg_global.GlobalObjects;

public class Page_FlightBookHome extends GlobalObjects {

    private WebDriverWait localWait = null;
    private WebDriver localDriver = null;

    @FindBy(how = How.XPATH, using = "//select[@name='fromPort']")
    private WebElement DrpDwn_FromPort;
    @FindBy(how = How.XPATH, using = "//select[@name='toPort']")
    private WebElement DrpDwn_ToPort;
    @FindBy(how = How.CSS, using = "input[value='Find Flights']")
    private WebElement Btn_FindFlight;
    @FindBy(how = How.XPATH, using = "//*[contains(text(), 'Flights from')]")
    private WebElement Labl_SearchResults;
    @FindBy(how = How.XPATH, using = "//input[@value='Choose This Flight']")
    private List<WebElement> Btn_AllFlights;
    @FindBy(how = How.XPATH, using = "//*[contains(text(), 'Your flight from')]")
    private WebElement Labl_FlightDetails;
    @FindBy(how = How.XPATH, using = "//input[@value='Purchase Flight']")
    private WebElement Btn_PurchaseFlight;
    @FindBy(how = How.XPATH, using = "//*[contains(text(), 'Thank you for your purchase today!')]")
    private WebElement Labl_PurchaseSuccessText;
    @FindBy(how = How.XPATH, using = "//*[text()='Welcome to the Simple Travel Agency!']")
    private WebElement Labl_Title;

    // constructor
    // page object pattern
    public Page_FlightBookHome(WebDriver localDriverParam) {
        localDriver = localDriverParam;
        PageFactory.initElements(localDriver, this);
        localWait = utilGeneral.ExplicitWaitNormal();
    }

    public Page_FlightBookIternary NavigateHomeFlightBooking() {
        realDriver.get(hmGlobalData.get("sUrlHomeBooking"));
//        utilGeneral.MyThreadSleep(utilGeneral.sleepMilliSec);
        localWait.until(ExpectedConditions.visibilityOf(Labl_Title));
        return new Page_FlightBookIternary(localDriver);
    }

    public Page_FlightBookHome PurchaseThisFlight() {
        Btn_PurchaseFlight.click();
        localWait.until(ExpectedConditions.visibilityOf(Labl_PurchaseSuccessText));
        return new Page_FlightBookHome(localDriver);
    }

    public Page_FlightBookHome ChooseThisFlight(String flightOption) {
        int nthFlight = Integer.parseInt(flightOption);
        Btn_AllFlights.get(nthFlight-1).click();
        localWait.until(ExpectedConditions.visibilityOf(Labl_FlightDetails));
        return new Page_FlightBookHome(localDriver);
    }

    public Page_FlightBookHome SearchFlightsFor(String fromLocation, String toLocation) {
        Select drpDwn_ToPort = new Select(DrpDwn_ToPort);
        drpDwn_ToPort.selectByVisibleText(toLocation);
        Select drpDwn_FromPort = new Select(DrpDwn_FromPort);
        drpDwn_FromPort.selectByVisibleText(fromLocation);
        Btn_FindFlight.click();
        localWait.until(ExpectedConditions.visibilityOf(Labl_SearchResults));
        return new Page_FlightBookHome(localDriver);
    }

    public Page_FlightBookIternary NavigateHomeBack() {
        localDriver.navigate().back();
        localWait.until(ExpectedConditions.visibilityOf(Btn_PurchaseFlight));
        localDriver.navigate().back();
        localWait.until(ExpectedConditions.visibilityOf(Labl_SearchResults));
        localDriver.navigate().back();
        localWait.until(ExpectedConditions.visibilityOf(Labl_Title));
        return new Page_FlightBookIternary(localDriver);
    }
}
