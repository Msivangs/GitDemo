package stepdefs.commondefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import pages.common.CommonPage;
import pages.common.CommonPageOR;

public class CommonSteps extends CommonPage implements CommonPageOR {

	By signIn = By.xpath("//button[contains(text(),'Sign in')]");

	By userName = By.xpath("//input[@name='loginfmt']");

	By clickOnNext = By.xpath("//input[@id='idSIButton9']");

	By userPassword = By.xpath("//input[@name='passwd']");

	By clickSubmit = By.xpath("//input[@id='idSIButton9']");

	By signInAlert = By.xpath("//input[@id='idBtn_Back']");

	public CommonSteps(WebDriver driver) {

		super(driver);
	}

	public void clikonSignin() {
		driver.findElement(signIn).click();

	}

	public void userName(String usrname) {
		waitForElementPresent(userName);
		driver.findElement(userName).sendKeys(usrname);
	}

	public void clikNext() {

		driver.findElement(clickOnNext).click();

	}

	public void userPassword(String password) {
		try {
			waitForElementPresent(userPassword);
			driver.findElement(userPassword).sendKeys(password);

		} catch (StaleElementReferenceException se) {
			// WebElement passwordField = driver.findElement(userPassword);
			driver.findElement(userPassword).sendKeys(password);
		} catch (Exception e) {
			System.out.println("password text field not displayed");
		}

	}

	public void clickSubmit() {
		try {
			waitForElementPresent(clickSubmit);
			driver.findElement(clickSubmit).click();

		} catch (StaleElementReferenceException se) {
			boolean signInDisplayed = driver.findElement(clickSubmit).isDisplayed();
			if (signInDisplayed) {
				driver.findElement(clickSubmit).click();
			}
		} catch (Exception e) {
			System.out.println("sign in element is not displayed");
		}

	}

	public void signInAlert() {
		waitForElementPresent(signInAlert);
		driver.findElement(signInAlert).click();
	}

}
