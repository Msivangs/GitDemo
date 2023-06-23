package stepdefs.findavailableworkstations;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import junit.framework.Assert;
import pages.common.CommonPage;
import pages.common.CommonPageOR;
import utils.DateGenerators;

public class FindAvailableWorkStations extends CommonPage implements CommonPageOR {

	By availableWorkStation = By.xpath("//*[contains(text(),'Find Available Workstations')]");

	By searchButton = By.id("search-button");

	By enterStartDate = By.xpath("(//input[@type='date'])[1]");

	By enterEndDate = By.xpath("(//input[@type='date'])[2]");

	By selectAvaliablePod = By.xpath("//button[@id='dropdown-basic']");

	By podOption = By.xpath("//*[@id='display-pods']/div/div/a[1]");

	By workstationOption = By.xpath("//button[contains(text(),'Workstation Options')]");

	By selectWorkstation = By.xpath("//*[@id='display-workstations']/div/div/a[1]");

	By clearDateCriteria = By.id("clear-date-button");

	By clickFullDay = By.xpath("(//input[@type='checkbox'])");

	By slotElement = By.id("time-slot-btn");

	By clickReserve = By.xpath("(//*[@id=\'modal-footer\']/button[1])");

	By workStationAvailabilityPopUp = By.xpath("//div[@id='modal-header']");

	By reservationConfirmationClose = By.xpath("//*[@id=\"close-modal-footer\"]/button");

	By myReservations = By.xpath("//a[contains(text(),'My Reservations')]");

	By cancelReservation = By.xpath("//button[contains(text(),'Cancel')]");

	By verifyUpcomingReservationsDetails = By.xpath("//p[@id='close-modal-text']");

	By cancelledReservation = By.xpath("//p[@id='close-modal-text']");

	By reservationCancellationClose = By.xpath("//*[@id=\"close-modal-footer\"]/button");

	By signOut = By.id("sign-out-btn");

	By editReservation = By.xpath("//button[contains(text(),'Edit')]");

	By editOptions = By.xpath("//button[contains(text(),'Edit Option(s)')]");

	By changeReservationDate = By.xpath("//a[contains(text(),'Change Date')]");

	By enterNewReservationDate = By.xpath("(//input[@id='validationCustom01'])[3]");

	By clickOnSubmit = By.xpath("//button[@id='edit-submit-button']");

	By closeNewReservationConfirmationWindow = By.xpath("//*[@id=\"close-modal-footer\"]/button");

	By changeWorkstation = By.xpath("//a[contains(text(),'Change Workstation')]");

	By podOptions = By.xpath("(//*[@id='dropdown-basic'])[3]");

	By availablePod = By.xpath("(//*[@id='display-pods']/div/div/a[1])[2]");

	By workStationOptions = By.xpath("(//*[@id='dropdown-basic'])[4]");

	By availableWorkStationOption = By.xpath("//*[@id='display-workstations']/div/div/a[1]");

	By submit = By.id("edit-submit-button");

	By changeTimeSlot = By.xpath("//a[contains(text(),'Change Time Slot')]");

	By selectFullDay = By.xpath("(//input[@type='checkbox'])");

	By clickSpecificTime = By.id("time-slot-btn");

	By reservationComplete = By.xpath("//p[contains(text(),'Your reservation was editted successfully.')]");

	public FindAvailableWorkStations(WebDriver driver) {

		super(driver);
	}

	public void validateAvailableWorkStationsPage() {
		waitForElementPresent(availableWorkStation);
		WebElement availWorkStationWE = driver.findElement(availableWorkStation);
		Assert.assertEquals("Find Available WorkStation Page display Validation!!", "Find Available Workstations",
				availWorkStationWE.getText().trim());
	}

	public void enterStartDate() {
		waitForElementPresent(enterStartDate);
		driver.findElement(enterStartDate).sendKeys(DateGenerators.getCurrentSystemDate());
	}

	public void enterEndDate(int noOfDays) {
		waitForElementPresent(enterEndDate);
		WebElement endDateWe = driver.findElement(enterEndDate);
		String date = DateGenerators.getFutureSystemDate(noOfDays);
		String[] dateSplit = date.split("/");
		endDateWe.sendKeys(dateSplit[0]);
		endDateWe.sendKeys(dateSplit[1]);
	}

	public void clearDateCriteria() {
		waitForElementPresent(clearDateCriteria);
		driver.findElement(clearDateCriteria).click();
	}

	public void searchButton() {
		scrollToElement(searchButton);
		waitForElementPresent(searchButton);
		scrollToElement(searchButton);
		driver.findElement(searchButton).click();
	}

	public void selectAvaliablePod() {
		waitForElementPresent(selectAvaliablePod);
		driver.findElement(selectAvaliablePod).click();
	}

	public void podOption() {
		waitForElementPresent(podOption);
		driver.findElement(podOption).click();
	}

	public void workstationOption() {
		waitForElementPresent(workstationOption);
		driver.findElement(workstationOption).click();
	}

	public void selectWorkstation() {
		waitForElementPresent(selectWorkstation);
		driver.findElement(selectWorkstation).click();
		waitForElementPresent(workStationAvailabilityPopUp);
	}

	public void clickFullDayorSlot() {
		waitForElementPresent(clickFullDay);
		try {
			boolean elementDisplayed = driver.findElement(clickFullDay).isDisplayed();

			if (elementDisplayed) {
				driver.findElement(clickFullDay).click();
			}

		} catch (NoSuchElementException e) {
			driver.findElement(slotElement).click();
		} catch (Exception e) {
			System.out.println("FullDay or Slot information not displayed for Workstation");
			e.printStackTrace();
		}

	}

	public void clickReserve() {
		waitForElementPresent(clickReserve);
		driver.findElement(clickReserve).click();
	}

	public void verifyUpcomingReservationsDetails() {
		waitForElementPresent(verifyUpcomingReservationsDetails);
		String reservationConfirmationMsg = driver.findElement(verifyUpcomingReservationsDetails).getText();
		// System.out.println("Reservation Confirmation Text:
		// "+reservationConfirmationMsg);
		Assert.assertTrue("Reservation Confirmation",
				reservationConfirmationMsg.contains("Your reservation was saved successfully."));
	}

	public void reservationComplete() {
		waitForElementPresent(reservationComplete);
		String reservationCompleteConfirmationMsg = driver.findElement(reservationComplete).getText();
		Assert.assertTrue("Reservation complete!",
				reservationCompleteConfirmationMsg.contains("Your reservation was editted successfully."));
	}

	public void verifyReservationCancelled() {
		waitForElementPresent(cancelledReservation);
		String reservationCancelledConfirmationMsg = driver.findElement(cancelledReservation).getText();
		Assert.assertTrue("Reservation Deletion",
				reservationCancelledConfirmationMsg.contains("Your reservation was cancelled successfully."));
	}

	public void reservationConfirmationClose() {
		waitForElementPresent(reservationConfirmationClose);
		driver.findElement(reservationConfirmationClose).click();
	}

	public void myReservations() {
		waitForElementPresent(myReservations);
		driver.findElement(myReservations).click();
	}

	public void editReservation() {
		waitForElementPresent(editReservation);
		driver.findElement(editReservation).click();
	}

	public void editOptions() {
		waitForElementPresent(editOptions);
		driver.findElement(editOptions).click();
	}

	public void changeReservationDate() {
		waitForElementPresent(changeReservationDate);
		driver.findElement(changeReservationDate).click();
	}

	public void enterNewReservationDate(int noOfDays) {
		waitForElementPresent(enterNewReservationDate);
		WebElement newDate = driver.findElement(enterNewReservationDate);
		String date = DateGenerators.getFutureSystemDate(noOfDays);
		String[] dateSplit = date.split("/");
		newDate.sendKeys(dateSplit[0]);
		newDate.sendKeys(dateSplit[1]);
		newDate.sendKeys(dateSplit[2]);
	}

	public void clickOnSubmit() {
		waitForElementPresent(clickOnSubmit);
		driver.findElement(clickOnSubmit).click();
	}

	public void closeNewReservationConfirmationWindow() {
		waitForElementPresent(closeNewReservationConfirmationWindow);
		// scrollToElement(closeNewReservationConfirmationWindow);
		driver.findElement(closeNewReservationConfirmationWindow).click();

	}

	public void changeWorkstation() {
		waitForElementPresent(changeWorkstation);
		driver.findElement(changeWorkstation).click();
	}

	public void podOptions() {
		waitForElementPresent(podOptions);
		driver.findElement(podOptions).click();
	}

	public void availablePod() {
		waitForElementPresent(availablePod);
		driver.findElement(availablePod).click();
	}

	public void workStationOptions() {
		waitForElementPresent(workStationOptions);
		driver.findElement(workStationOptions).click();
	}

	public void availableWorkStationOption() {
		waitForElementPresent(availableWorkStationOption);
		driver.findElement(availableWorkStationOption).click();
	}

	public void submit() {
		waitForElementPresent(submit);
		driver.findElement(submit).click();
	}

	public void changeTimeSlot() {
		waitForElementPresent(changeTimeSlot);
		driver.findElement(changeTimeSlot).click();
	}

	public void fullDayorSpecificTime() {
		waitForElementPresent(selectFullDay);
		try {
			boolean elementDisplayed = driver.findElement(selectFullDay).isDisplayed();

			if (elementDisplayed) {

				driver.findElement(selectFullDay).click();
			}

		} catch (NoSuchElementException e) {
			driver.findElement(clickSpecificTime).click();
		} catch (Exception e) {
			System.out.println("FullDay or Slot information not displayed for Workstation");
			e.printStackTrace();
		}

	}

	public void cancelReservation() {
		waitForElementPresent(cancelReservation);
		driver.findElement(cancelReservation).click();
	}

	public void reservationCancellationClose() {
		waitForElementPresent(reservationCancellationClose);
		driver.findElement(reservationCancellationClose).click();
	}

	public void signOut() {
		waitForElementPresent(signOut);
		driver.findElement(signOut).click();
	}
}
