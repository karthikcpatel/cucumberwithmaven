package newRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features={"features"},
glue={"newStepDefinition"},
plugin={"html:target/cucumber-html-report"},
tags={"@Ignore"}
)

/*@CucumberOptions(features={"features"},
glue={"newStepDefinition"},
tags = {"@Regression"}
)*/
public class TestRunnerWithTags {
}
