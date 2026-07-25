package pkg_utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pkg_global.GlobalObjects;
import pkg_pageObject.*;
import pkg_pageObjectEcom.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Utility_General extends GlobalObjects {

    public WebDriverWait ExplicitWaitNormal() {
        return new WebDriverWait(realDriver, Duration.ofMillis(10000));
    }

    public WebDriverWait ExplicitWaitLow() {
        return new WebDriverWait(realDriver, Duration.ofMillis(5000));
    }

    public WebDriverWait ExplicitWaitHigh() {
        return new WebDriverWait(realDriver, Duration.ofMillis(1500));
    }

    public void ImplicitWait(int nMilliSec) {
        realDriver.manage().timeouts().implicitlyWait(nMilliSec, TimeUnit.MILLISECONDS);
        //try{TimeUnit.MILLISECONDS.sleep(nMilliSec);}catch (Exception t){}
    }

    public static void Sleep(int nMillisec) {
        try {
            Thread.sleep(nMillisec);
        } catch (Exception time) {
            System.out.println();
        }
    }

    public void ScrollUsingJavaScript(String sHeightInPixel) {
        ((JavascriptExecutor) realDriver).executeScript("window.scrollBy(0," + sHeightInPixel + ")");
    }

    public void ScrollUsingJavaScriptBottom() {
        ((JavascriptExecutor) realDriver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void ClickUsingJavaScriptBottom(WebElement clickMe) {
        ((JavascriptExecutor) realDriver).executeScript("arguments[0].click();", clickMe);
    }

    public void DropDownChoose(String sElementId, String sOptionValue) {
        new Select(realDriver.findElement(By.id(sElementId))).selectByValue(sOptionValue);
    }

    public void MouseHoverTopMenu() {
        Actions objActions = new Actions(realDriver);
        try {
            objActions
                    .moveToElement(realDriver.findElement(By.cssSelector("a[href='Index.html']")))
                    .pause(1500)
                    .moveToElement(realDriver.findElement(By.cssSelector("a[href='WebTable.html']")))
                    .pause(1500)
                    .moveToElement(realDriver.findElement(By.cssSelector("a[href='SwitchTo.html']")))
                    .pause(1500)
                    .moveToElement(realDriver.findElement(By.cssSelector("a[href='Widgets.html']")))
                    .pause(1500)
                    .moveToElement(realDriver.findElement(By.cssSelector("a[href*='practice']")))
                    .pause(1500)
                    .build().perform();
        } catch (Exception act) {
            System.out.println();
        }
    }

    public void FetchCommandLineParam() {
        hmGlobalData.put("sUrlHome", sUrlHome);
    }

    public void InitAllPageObject() {
        // Factory Design Pattern
        utilGeneral = new Utility_General();
        pgHome = new Page_Home(realDriver);
        pgRegister = new Page_Register(realDriver);
        pgOpenNewAccount = new Page_OpenAccount(realDriver);
        pgSearch = new Page_Search(realDriver);
        pgCheckout = new Page_Checkout(realDriver);

        pgHomeFlightBook = new Page_FlightBookHome(realDriver);
        pgIternaryFlightBook = new Page_FlightBookIternary(realDriver);
    }

    public void MyThreadSleep(int customSleepValueMilliSec){
        try{Thread.sleep(customSleepValueMilliSec);}
        catch (Exception ex) {System.out.println();}
    }

    public static final String sBootText = "\n  ____       _                 _                    _____       _                 \n" + " |  _ \\     | |               (_)                  |  __ \\     (_)                \n" + " | |_) | ___| |__   __ ___   ___  ___  _   _ _ __  | |  | |_ __ ___   _____ _ __  \n" + " |  _ < / _ \\ '_ \\ / _` \\ \\ / / |/ _ \\| | | | '__| | |  | | '__| \\ \\ / / _ \\ '_ \\ \n" + " | |_) |  __/ | | | (_| |\\ V /| | (_) | |_| | |    | |__| | |  | |\\ V /  __/ | | |\n" + " |____/ \\___|_| |_|\\__,_| \\_/ |_|\\___/ \\__,_|_|    |_____/|_|  |_| \\_/ \\___|_| |_|\n";


}
