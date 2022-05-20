package myStore.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import myStore.framework.Utils;

public class HomePage extends Utils {

	private static final Logger logger = LogManager.getLogger();

	By listOfPopularEle = By.cssSelector("ul[id='homefeatured']>li[class*='ajax']");

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public int listOfPopular() {
		try {
			List<WebElement> ls = getDriver().findElements(listOfPopularEle);
			for (WebElement link : ls) {
				System.out.println(link.getText());
				logger.info(link.getText());
			}
			logger.info("List of Popular elements contain " + ls.size() + " elements");
			return ls.size();
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("No list found");
		}
		return 0;
	}

	public void closeBrowser() {
		getDriver().quit();
	}
}
