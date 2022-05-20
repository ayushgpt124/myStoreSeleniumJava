package myStore.stepDefinations;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.junit.Assert.*;
import myStore.page.HomePage;


public class HomePageSteps {
	
	WebDriver driver;
	
	HomePage homePage;
	
	@Before
	public void initGooglePage() throws Throwable {
		homePage = new HomePage(driver);
	}
	
	@Given("^a web browser is on the AutomationPractice HomePage$")
	public void a_web_browser_is_on_the_AutomationPractice_HomePage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("At homepage");
	    homePage.navigateToHomePage();
	}

	
	@Then("^I verify List under popular tab$")
	public void i_verify_List_under_popular_tab() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		int t=homePage.listOfPopular();
		assertEquals(7, t);
	}

//	@Then("^Browser is closed$")
//	public void browser_is_closed() throws Exception{
//		driver.quit();
//	}
	@Then("^Browser is closed$")
	public void browser_is_closed() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	   homePage.closeBrowser();
	}
}
