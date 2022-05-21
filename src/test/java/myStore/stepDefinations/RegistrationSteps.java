package myStore.stepDefinations;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import myStore.page.RegistrationPage;

public class RegistrationSteps {

	WebDriver driver;
	RegistrationPage registrationPage=new RegistrationPage(driver);
	String actualTitle = "Login - My Store";
	
	@Given("^a web browser is on the HomePage$")
	public void a_web_browser_is_on_the_HomePage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		registrationPage.navigateToHomePage();
	}

	@When("^user clicks in sign in button$")
	public void user_clicks_in_sign_in_button() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		//System.out.println("############################## "+ driver.getTitle()+ " #################################");
		registrationPage.clickOnSignIn();
	}

	@Then("^user navigates to login page$")
	public void user_navigates_to_login_page() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		System.out.println(registrationPage.getTitleOfSignInPage());
		assertEquals(registrationPage.getTitleOfSignInPage(), actualTitle);
	}

	@When("^user enters Email Address and clicks on Create account$")
	public void user_enters_Email_Address_and_clicks_on_Create_account(DataTable dataTable) throws Exception {
		// Write code here that turns the phrase above into concrete actions
		List<Map<String, String>> form = dataTable.asMaps(String.class, String.class);
		String email = form.get(0).get("Email");
		String email2 = form.get(1).get("Email");
		registrationPage.enterEmailAddress(email);
		registrationPage.clickOnCreateAccount();
		System.out.println("***** "+registrationPage.getError() + " *****");
		registrationPage.clearEmailField();
		registrationPage.enterEmailAddress(email2);
		registrationPage.clickOnCreateAccount();
	}

	@Then("^user navigates to registration form$")
	public void user_navigates_to_registration_form() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Step4");
	}

	@Then("^user fills form$")
	public void user_fills_form(DataTable table) throws Exception {
		// Write code here that turns the phrase above into concrete actions
		List<Map<String, String>> form = table.asMaps(String.class, String.class);
		String fname = form.get(0).get("FirstName");
		String lname = form.get(0).get("LastName");
		String pwd = form.get(0).get("Pass");
		int days = Integer.parseInt(form.get(0).get("Days"));
		int month = Integer.parseInt(form.get(0).get("Month"));
		int year = Integer.parseInt(form.get(0).get("Year"));
		String FirstAddressName = form.get(0).get("FirstAddressName");
		String LastAddressName = form.get(0).get("LastAddressName");
		String CompanyName = form.get(0).get("CompanyName");
		String Address = form.get(0).get("Address");
		String City = form.get(0).get("City");
		int State = Integer.parseInt(form.get(0).get("State"));
		String ZIP = form.get(0).get("ZIP");
		int Country = Integer.parseInt(form.get(0).get("Country"));
		String Additional = form.get(0).get("Additional");
		String HomePhone = form.get(0).get("HomePhone");
		String MobilePhone = form.get(0).get("MobilePhone");
		String AliasEmail  = form.get(0).get("AliasEmail");
		//registrationPage.fillForm(fname, lname, pwd, days,month,year);
		registrationPage.fillForm(fname, lname, pwd, days, month, year, FirstAddressName, Address, LastAddressName, CompanyName, City, State, ZIP, Country, Additional, HomePhone, MobilePhone, AliasEmail);
	}

}
