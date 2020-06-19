package newRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features={"features"},
glue={"newStepDefinition"},
plugin={"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
)

/*@CucumberOptions(features=".",
glue={"newStepDefinition"},
plugin={"html:target/cucumber-html-report","json:target/cucumber.json",
"rerun:target/rerun.txt"}
)*/

public class TestRunner {
}




