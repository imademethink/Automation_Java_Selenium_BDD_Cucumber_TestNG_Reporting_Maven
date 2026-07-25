package pkg_hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pkg_global.GlobalObjects;
import pkg_utility.Utility_Filehandler;
import pkg_utility.Utility_General;

public class Hooks extends GlobalObjects {
    private Scenario currentScenario;

    @Before
    public void setupHookBefore(Scenario scenario) {
        this.currentScenario = scenario;

        System.out.println("*** Setup Hook Before ***");

        new GlobalObjects().LaunchBrowser();

        new Utility_General().InitAllPageObject();

        new Utility_General().FetchCommandLineParam();

        new Utility_Filehandler().PropertiesDataReaderInit();

        new Utility_Filehandler().CsvDataReaderInit();
    }

    @After
    public void tearDownHookAfter() {
        System.out.println("*** Tear Down Hook After ***");
        if (this.currentScenario != null && this.currentScenario.isFailed()) {
            TakesScreenshot screen = (TakesScreenshot) realDriver;
            byte[] imgBytes = screen.getScreenshotAs(OutputType.BYTES);
            currentScenario.attach(imgBytes, "image/png", "Fail Screenshot Attached");
        }
        realDriver.quit();
        realDriver = null;
        bBrowserInvoked = false;
        this.currentScenario = null;
    }
}
