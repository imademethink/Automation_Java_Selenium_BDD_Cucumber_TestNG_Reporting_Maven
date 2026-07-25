package pkg_pageObjectEcom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pkg_global.GlobalObjects;

public class Page_FlightBookIternary extends GlobalObjects {

    private WebDriverWait localWait = null;
    private WebDriver localDriver = null;
    public boolean allBookingDone = false;

    // constructor
    // page object pattern
    public Page_FlightBookIternary(WebDriver localDriverParam) {
        localDriver = localDriverParam;
        PageFactory.initElements(localDriver, this);
        localWait = utilGeneral.ExplicitWaitNormal();
    }

}
