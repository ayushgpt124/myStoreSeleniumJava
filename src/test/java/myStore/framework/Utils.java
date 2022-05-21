package myStore.framework;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class Utils {

	protected WebDriver driver;
	private static final String HOME_URL = "http://automationpractice.com/index.php";
	private static final Logger logger = LogManager.getLogger();

	public Utils(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	protected WebDriverWait driverWait(long timeoutSeconds) {
		return new WebDriverWait(getDriver(), Duration.ofSeconds(10));
	}

	public void initWebDriver() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ayush\\OneDrive\\Desktop\\elearning\\driver\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	public void navigateToHomePage() throws Throwable {
		try {
			initWebDriver();
			getDriver().navigate().to(HOME_URL);
			logger.info("navigating to>> " + HOME_URL);
		} catch (Exception e) {
			logger.error("Failed to navigate " + HOME_URL);
		}
	}

	public void clickOnElement(By locator) {

		try {
			driverWait(10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
			driverWait(10).until(ExpectedConditions.elementToBeClickable(locator));
			getDriver().findElement(locator).click();
		} catch (Exception e) { //
			// TODO: handle exception
			logger.error("**************** " + e + " ****************");
			logger.error("Not able to click on element " + e.getMessage());
		}
	}

	public void enterTextToField(By locator,String text)  {
		try {
			driverWait(10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
			driverWait(10).until(ExpectedConditions.elementToBeClickable(locator));
			getDriver().findElement(locator).sendKeys(text);
		} catch (Exception e) { //
			// TODO: handle exception
			logger.error("**************** " + e + " ****************");
			logger.error("Not able to click on element " + e.getMessage());
		}
	}

	public void clearTextField(By locator) {
		try {
			driverWait(10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
			driverWait(10).until(ExpectedConditions.elementToBeClickable(locator));
			//getDriver().findElement(locator).click();
			getDriver().findElement(locator).clear();
		} catch (Exception e) { //
			// TODO: handle exception
			logger.error("**************** " + e + " ****************");
			logger.error("Not able to clear on element " + e.getMessage());
		}
	}
}
