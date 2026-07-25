package pkg_runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src//test//resources//features",
        glue = {"pkg_hooks", "pkg_stepDefinition", "pkg_stepDefinitionFlightBook"},
        monochrome = true,
        dryRun = false,
        plugin = {
                "pretty",
                "html:target\\HtmlReport.html",
        }
        ,
        tags = "@simple"
//        tags = "@CucumberWithBut"
//        tags = "@CucumberWithBackground"
//        tags = "@MultipleScenario"
//        tags = "@StepWithDataTable"
)
public class TestDemoRunner extends AbstractTestNGCucumberTests {

}
