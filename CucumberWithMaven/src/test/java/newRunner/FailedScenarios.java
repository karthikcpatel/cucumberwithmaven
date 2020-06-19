package newRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="@target/rerun.txt",
		glue={"newStepDefinition"},
		plugin={"html:target/cucumber-html-report","json:target/cucumber.json"}
		)
		
public class FailedScenarios {

}