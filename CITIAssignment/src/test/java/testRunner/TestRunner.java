package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src//main//java//OrangeHRMBDD//OrangeBDD.feature"},
        glue = "stepDefinition",
        dryRun = false,
        monochrome = true,
        plugin = { "pretty", "html:target/cucumber-html-report.html",
                "json:target/cucumber-reports/cucumber.json",
                "junit:target/cucumber-reports/cucumber.xml",
        }
)

        public class TestRunner{

}

