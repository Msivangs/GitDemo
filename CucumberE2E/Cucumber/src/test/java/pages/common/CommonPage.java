package pages.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import stepdefs.support.Hook;

public class CommonPage {

	public WebDriver driver;
	public String featureFileName;
	public Object scenarioId;

	public CommonPage(WebDriver driver, String featureFileName, String scenarioId) {
		this.driver = driver;
		this.featureFileName = featureFileName;
		this.scenarioId = scenarioId;

	}
	

	public CommonPage(WebDriver driver) {
		this.driver = driver;
	}

	public CommonPage(Hook hook) {

	}

	public static String getURL() {
		String environmentURL = null;
		try {
			String globalDataPath = "src" + File.separator + "test" + File.separator + "resources" + File.separator
					+ "GlobalData.properties";
			Properties prop = new Properties();
			FileInputStream input = new FileInputStream(new File(globalDataPath));
			prop.load(input);
			environmentURL = prop.getProperty("environment");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return environmentURL;
	}

	public void launchApplication() {
		driver.get(featureFileName);
	}
	
	public void scrollToElement(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(locator);
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void waitForElementPresent(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	

}
