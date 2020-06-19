package newStepDefinition;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pageObjects.GoogleObjects;
import managers.WebDriverManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProviders.ConfigFileReader;

public class SearchGoogle {
WebDriver driver;	
ConfigFileReader filereader = new ConfigFileReader();	
WebDriverManager webDriverManager;
GoogleObjects googlePage;

@Before
public void testSetUp() throws Exception {
	webDriverManager = new WebDriverManager();
	driver = webDriverManager.getDriver();
}

@Given("^I navigate to google$")
public void i_navigate_to_google() throws Throwable {
	driver.manage().window().maximize();    
	driver.get(filereader.getApplicationUrl());
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}

@When("^I enter a keyword$")
public void i_enter_a_keyword() throws Throwable {
	GoogleObjects object = new GoogleObjects(driver);
	object.fill_Data();
}

@Then("^I click search$")
public void i_click_search() throws Throwable {
	GoogleObjects object = new GoogleObjects(driver);
	object.click_Search();	
}

@After
public void killBrowser(Scenario scenario){
    if (scenario.isFailed()) {
     scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png");
    }
    driver.quit();
}
}