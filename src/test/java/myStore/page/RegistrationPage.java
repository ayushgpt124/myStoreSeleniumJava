package myStore.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import myStore.framework.Utils;

public class RegistrationPage extends Utils {

	By signin = By.cssSelector("a[title^=\"Log in\"]");
	By emailTextField = By.cssSelector("input[id=\"email_create\"]");
	By createAnAccountBtn = By.cssSelector("button[id=\"SubmitCreate\"]");
	By errorExistingEmail = By.cssSelector("div[class=\"alert alert-danger\"]>ol>li");
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
			// TODO: handle exception
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

}
















