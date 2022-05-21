package myStore.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import myStore.framework.Utils;

public class RegistrationPage extends Utils {

	By signin = By.cssSelector("a[title^=\"Log in\"]");
	By emailTextField = By.cssSelector("input[id=\"email_create\"]");
	By createAnAccountBtn = By.cssSelector("button[id=\"SubmitCreate\"]");
	By errorExistingEmail = By.cssSelector("div[class=\"alert alert-danger\"]>ol>li");
	By radioTitle = By.cssSelector("input[id=\"id_gender2\"]");
	By firstname = By.cssSelector("input[name=\"customer_firstname\"]");
	By lastname = By.cssSelector("input[id=\"customer_lastname\"]");
	By password = By.cssSelector("input[id=\"passwd\"]");
	By dropDownDays = By.cssSelector("select[id=\"days\"]");
	By dropDownMonth = By.cssSelector("select[id=\"months\"]");
	By dropDownYear = By.cssSelector("select[id=\"years\"]");
	By newsLetterCheckBox = By.cssSelector("div[id=\"uniform-newsletter\"]");
	By offersCheckbox = By.cssSelector("div[id=\"uniform-optin\"]");
	By addressFirst = By.cssSelector("input[id=\"firstname\"]");
	By addresslast = By.cssSelector("input[id=\"lastname\"]");
	By companyName = By.cssSelector("input[id=\"company\"]");
	By address = By.cssSelector("input[id=\"address1\"]");
	By cityName = By.cssSelector("input[id=\"city\"]");
	By StateName = By.cssSelector("select[id=\"id_state\"]");
	By zipName = By.cssSelector("input[id=\"postcode\"]");
	By countryName = By.cssSelector("select[id=\"id_country\"]");
	By additionalInformation = By.cssSelector("textarea[id=\"other\"]");
	By homePhone = By.cssSelector("input[id=\"phone\"]");
	By MobilePhone = By.cssSelector("input[id=\"phone_mobile\"]");
	By aliasAddress = By.cssSelector("input[id=\"alias\"]");
	By registrationButton = By.cssSelector("button[id=\"submitAccount\"]");
	By formValidationMessage = By.cssSelector("div[class=\"alert alert-danger\"]>p");
	
	private static final Logger logger = LogManager.getLogger();

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	public void clickOnSignIn() {

		try {
			clickOnElement(signin);
			logger.info("Clicked on signin");
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("**************** " + e + " ****************");
			logger.error("Not able to click on Sign in " + e.getMessage());
		}
	}

	public String getTitleOfSignInPage() {

		try {
			logger.info("Title of page is" + getDriver().getTitle());
			return getDriver().getTitle();
		} catch (Exception e) {
			logger.error("Unable to fetch Page Title");
		}
		return null;
	}

	public void enterEmailAddress(String email) {
		enterTextToField(emailTextField, email);
	}

	public void clearEmailField() {
		try {
			clearTextField(emailTextField);
			logger.info("Field clear");
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Field not clear");
			logger.error("**************** " + e + " ****************");
			logger.error("Not able to clear on element " + e.getMessage());
		}
	}

	public void clickOnCreateAccount() {
		try {
			clickOnElement(createAnAccountBtn);
			logger.info("Clicked on createAnAccountBtn");
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("**************** " + e + " ****************");
			logger.error("Not able to click on createAnAccountBtn " + e.getMessage());
		}
	}

	public String getError() {
		try {
			driverWait(10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(errorExistingEmail));
			String error = getDriver().findElement(errorExistingEmail).getText();
			logger.info(error);
			return error;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("error fetching errorMessage " + e.getMessage());
			e.printStackTrace();

		}
		return null;
	}
	
	public void clickRegisterButton() {
		try {
			clickOnElement(registrationButton);
			logger.info("Clicked on RegisterButton");
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}

	public void fillForm(String fname, String lname, String pwd,int days,int month,int year,String faddress,
			String laddress,String cName,String aName,String city,int state,String zip,int country,
			String addInfo,String hPhone,String mPhone, String aEmail) {
		try {
			//select radio button
			driverWait(20);
			clickOnElement(radioTitle);
			logger.info("clicked on radio");
			
			//Enter Firstname
			enterTextToField(firstname, fname);
			logger.info("Entering firstname as " + fname);
			
			//Enter lastname
			enterTextToField(lastname, lname);
			logger.info("Entering lastname as " + lname);
			
			//Enter password
			enterTextToField(password, pwd);
			logger.info("Entering password as " + pwd);
			
			//Select days from dropdown
			Select dropDays = new Select(driver.findElement(dropDownDays));
			dropDays.selectByIndex(days);
			logger.info("selecting " + days + " from dropDown");
			
			//Select month from dropdown
			Select dropMonth = new Select(driver.findElement(dropDownMonth));
			dropMonth.selectByIndex(month);
			logger.info("selecting " + month + " from dropDown");
			
			//Select year from dropdown
			Select dropYear = new Select(driver.findElement(dropDownYear));
			dropYear.selectByIndex(year);
			logger.info("selecting " + year + " from dropDown");
			
			//Click on newsletter checkbox
			clickOnElement(newsLetterCheckBox);
			logger.info("Clicked on newsLetterCheckBox");
			
			//Click on offers checkbox
			clickOnElement(offersCheckbox);
			logger.info("Clicked on offersCheckbox");
			
			//enter first address
			enterTextToField(addressFirst, faddress);
			logger.info("Entering first address " + faddress);
		
			//enter last address
			enterTextToField(addresslast, laddress);
			logger.info("Entering first address " + laddress);
			
			//enter company name
			enterTextToField(companyName, cName);
			logger.info("Entering companyName " + cName);
			
			//enter address
			enterTextToField(address, aName);
			logger.info("Entering companyName " + aName);
			
			//enter city
			enterTextToField(cityName, city);
			logger.info("Entering companyName " + city);
			
			//Select State
			Select stSelect = new Select(driver.findElement(StateName));
			stSelect.selectByIndex(state);
			logger.info("selecting " + state + " from dropDown");
			
			//enter zip
			enterTextToField(zipName, zip);
			logger.info("Entering companyName " + zip);
			
			//Select country
			Select countrySelect = new Select(driver.findElement(countryName));
			countrySelect.selectByIndex(country);
			logger.info("selecting " + country + " from dropDown");
			
			//enter additional Information
			enterTextToField(additionalInformation, addInfo);
			logger.info("Entering companyName " + addInfo);
			
			//enter Home Phone
			enterTextToField(homePhone, hPhone);
			logger.info("Entering companyName " + hPhone);
			
			//enter Mobile Phone
			enterTextToField(MobilePhone, mPhone);
			logger.info("Entering companyName " + mPhone);
			
			//enter alias Address
			enterTextToField(aliasAddress, aEmail);
			logger.info("Entering companyName " + aEmail);

		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}

}
