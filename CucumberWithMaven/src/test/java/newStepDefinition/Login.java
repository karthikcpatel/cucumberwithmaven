package newStepDefinition;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {
WebDriver driver;	

//***** NewLogin.feature *****

@Given("^Open login screen$")
public void open_login_screen() throws Throwable {
	System.setProperty("webdriver.chrome.driver", "C:\\eclipse\\drivers\\chromedriver_2.34.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();    
	driver.get("http://live.guru99.com/index.php/");
}

@And("^wait for page to load$")
public void wait_for_page_to_load() throws Throwable {
	WebDriverWait wait = new WebDriverWait(driver, 60);
    wait.until(ExpectedConditions.titleContains("Home page"));
}

@When("^I enter valid \"(.*?)\" and \"(.*?)\"$")
public void i_enter_valid_username_and_password(String username, String password) throws Throwable {
	driver.findElement(By.cssSelector("div.footer > div.links > ul > li.first > a[title=\"My Account\"]")).click();
    driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(username);
    driver.findElement(By.xpath(".//*[@id='pass']")).sendKeys(password);
}

@And("^I click on submit button$")
public void i_click_on_submit_button() throws Throwable {
	driver.findElement(By.xpath(".//*[@id='send2']")).click();
}

@Then("^I should login successfully$")
public void i_should_login_successfully() throws Throwable {
	WebDriverWait wait = new WebDriverWait(driver, 60);
	wait.until(ExpectedConditions.titleContains("My Account"));
}

@Then("^I click logout link$")
public void i_click_logout_link() throws Throwable {
	driver.findElement(By.xpath(".//*[@id='header']/div/div[2]/div/a/span[2]")).click();
    driver.findElement(By.xpath(".//*[@id='header-account']/div/ul/li[5]/a")).click();
}

@Then("^I should logout successfully$")
public void i_should_logout_successfully() throws Throwable {
	driver.quit();
}

//***** NewLogin1.feature *****

@Given("^Open application and wait for page to load$")
public void open_application_and_wait_for_page_to_load() throws Throwable {
	System.setProperty("webdriver.chrome.driver", "C:\\eclipse\\drivers\\chromedriver_2.34.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();    
	driver.get("http://live.guru99.com/index.php/");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.titleContains("Home page"));
}

@When("^I click on mobile link$")
public void i_click_on_mobile_link() throws Throwable {
	driver.findElement(By.xpath(".//*[@id='nav']/ol/li[1]/a")).click();
	WebDriverWait wait = new WebDriverWait(driver, 60);
	wait.until(ExpectedConditions.titleContains("Mobile"));
}

@And("^I sort with name$")
public void i_sort_with_name() throws Throwable {
new Select(driver.findElement(By.cssSelector("select[title=\"Sort By\"]"))).selectByVisibleText("Name");
}

@Then("^I compare price$")
public void i_compare_price() throws Throwable {
	String price1 = driver.findElement(By.xpath(".//*[@id='product-price-1']/span")).getText();
	  System.out.println("Price of Sony Xperia is: " +price1);
	  driver.findElement(By.xpath("//a[@title='Sony Xperia']")).click();
	  WebDriverWait wait = new WebDriverWait(driver, 60);
	  wait.until(ExpectedConditions.titleContains("Sony Xperia - Mobile"));
	  String price2 = driver.findElement(By.xpath("//span[@class='price']")).getText();
	  System.out.println("Price of Sony Xperia on detail page is: " +price2);
	  assertTrue(price1.equals(price2));
	  driver.quit();
}

//***** Admin Login.feature *****

@Given("^I navigate to admin login screen$")
public void i_navigate_to_admin_login_screen() throws Throwable {
System.setProperty("webdriver.chrome.driver", "C:\\eclipse\\drivers\\chromedriver_2.34.exe");
driver = new ChromeDriver();
driver.manage().window().maximize();    
driver.get("http://live.guru99.com/index.php/backendlogin");
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}

@When("^I enter valid username and password$")
public void i_enter_valid_username_and_password() throws Throwable {
driver.findElement(By.id("username")).clear();	    
driver.findElement(By.id("username")).sendKeys("user01");   
driver.findElement(By.id("login")).clear();
driver.findElement(By.id("login")).sendKeys("guru99com");
}

@When("^I click on sign in button$")
public void i_click_on_sign_in_button() throws Throwable {
driver.findElement(By.cssSelector("input.form-button")).click();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}

@Then("^I should get logged in successfully$")
public void i_should_get_logged_in_successfully() throws Throwable {
driver.findElement(By.cssSelector("a[title=\"close\"] > span")).click();
}

@Then("^I click on logout button$")
public void i_click_on_logout_button() throws Throwable {
driver.findElement(By.linkText("Log Out")).click();
driver.quit();
}
}