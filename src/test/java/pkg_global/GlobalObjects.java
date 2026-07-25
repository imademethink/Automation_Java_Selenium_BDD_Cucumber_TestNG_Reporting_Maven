package pkg_global;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pkg_pageObjectEcom.Page_FlightBookHome;
import pkg_pageObjectEcom.Page_FlightBookIternary;
import pkg_utility.Utility_General;
import pkg_pageObject.Page_Home;
import pkg_pageObject.Page_Register;
import pkg_pageObject.Page_OpenAccount;
import pkg_pageObject.Page_Search;
import pkg_pageObject.Page_Checkout;
import java.util.HashMap;
import java.util.Map;


public class GlobalObjects {

    // Browser instance
    public static WebDriver realDriver = null;
    public static boolean bBrowserInvoked = false;
    public static String chromeDriverPath = "\\src\\test\\resources\\chrome_driver\\chromedriver_new.exe";

    // Urls
    public static String sUrlHome = "https://parabank.parasoft.com/parabank/index.htm";

    // A hash-map of all data items
    public static HashMap<String, String> hmGlobalData = new HashMap<>();

    // Properties file
    public static final String sPropertiesFilePath = System.getProperty("user.dir") +
            "\\src\\test\\resources\\externalData\\Config.properties";

    // Csv file
    public static final String sCsvFilePath = System.getProperty("user.dir") +
            "\\src\\test\\resources\\externalData\\Searchterm.csv";

    // Utility handler objects
    public static Utility_General utilGeneral             = null;

    // Page object instances
    public static Page_Home pgHome                       = null;
    public static Page_Register pgRegister                = null;
    public static Page_OpenAccount pgOpenNewAccount  = null;
    public static Page_Search pgSearch                    = null;
    public static Page_Checkout pgCheckout              = null;

    // Page object instances - Flight Booking
    public static Page_FlightBookHome pgHomeFlightBook        = null;
    public static Page_FlightBookIternary pgIternaryFlightBook        = null;

    // General constant
    public final int sleepMilliSecShort = 8000;
    public final int sleepMilliSec = 10000;
    public final int sleepMilliSecLong = 10000;

    // Launch browser instance -- Currently only Chrome is supported
    // Note by default image loading is disabled to speed up the operation
    public void LaunchBrowser() {
        // Singleton Design Pattern
        if (null != realDriver) {
            realDriver = null;
        }

        if (!bBrowserInvoked) {
            String sChromeBinary = System.getProperty("user.dir") + chromeDriverPath;
            System.setProperty("webdriver.chrome.driver", sChromeBinary);
            System.setProperty("webdriver.chrome.silentOutput", "true");

            ChromeOptions options = new ChromeOptions();
//            options.addArguments("window-size=1400,800");
            options.addArguments("--start-maximized");
            options.addArguments("disable-infobars"); // disabling infobars
            options.addArguments("--disable-extensions"); // disabling extensions
            options.addArguments("--no-sandbox"); // Bypass OS security model
            //            options.addArguments("--remote-allow-origins=*");
            options.setExperimentalOption("useAutomationExtension", false);

            // Disable image loading - to speedup test execution
            Map<String, Object> prefs = new HashMap<String, Object>();
            //            prefs.put("profile.managed_default_content_settings.images", 2);
            options.setExperimentalOption("prefs", prefs);

            realDriver = null;
            realDriver = new ChromeDriver(options);
            System.out.println("Log: Chrome browser is launched");
            realDriver.manage().deleteAllCookies();
            bBrowserInvoked = true;
        }
    }
}
