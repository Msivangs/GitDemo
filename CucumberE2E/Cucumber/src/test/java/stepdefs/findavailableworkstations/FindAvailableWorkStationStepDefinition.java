package stepdefs.findavailableworkstations;

import io.cucumber.java.en.And;
import stepdefs.support.Hook;
import stepdefs.support.SuperStepDef;

public class FindAvailableWorkStationStepDefinition extends SuperStepDef {
	public Hook hook;

	public FindAvailableWorkStations findavailableworkstations;

	public FindAvailableWorkStationStepDefinition(Hook hook) {
		super(hook);
		this.hook = hook;
		findavailableworkstations = new FindAvailableWorkStations(driver);
	}

	@And("^User ([^\"]*) is navigated to the home page of Create Reservation$")
	public void user_is_navigated_to_the_home_page_of_create_reservation(String username) {
		findavailableworkstations.validateAvailableWorkStationsPage();
	}

	@And("^Select start date and end date for reservations$")
	public void select_start_date_and_end_date_for_reservations() {
		findavailableworkstations.enterStartDate();
		findavailableworkstations.enterEndDate(6);
	}

	@And("^User click on clear button$")
	public void User_click_on_clear_button() {
		findavailableworkstations.clearDateCriteria();
	}

	@And("^User select start date and end date for reservations$")
	public void User_select_start_date_and_end_date_for_reservations() {
		findavailableworkstations.enterStartDate();
		findavailableworkstations.enterEndDate(6);
	}

	@And("^User Click on Search button$")
	public void user_click_on_search_button() {
		findavailableworkstations.searchButton();
	}

	@And("^User clicked on pod options dropdown and selected available pod$")
	public void User_clicked_on_pod_options_dropdown_and_selected_available_pod() {
		findavailableworkstations.selectAvaliablePod();
		findavailableworkstations.podOption();
	}

	@And("^User clciked on workstation options dropdown and selected available work station$")
	public void User_clciked_on_workstation_options_dropdown_and_selected_available_work_station()
			throws InterruptedException {
		findavailableworkstations.workstationOption();
		findavailableworkstations.selectWorkstation();
	}

	@And("^User selected preferrable date and time$")
	public void User_selected_preferrable_date_and_time() {
		findavailableworkstations.clickFullDayorSlot();
	}

	@And("^click on reserve button$")
	public void click_on_reserve_button() {
		findavailableworkstations.clickReserve();
	}

	@And("^User close the reservation confirmation window$")
	public void User_close_the_reservation_confirmation_window() {
		findavailableworkstations.reservationConfirmationClose();
	}

	@And("^User click on My Reservations tab$")
	public void User_click_on_My_Reservations_tab() {
		findavailableworkstations.myReservations();
	}

	@And("^User verify the upcoming Reservation details$")
	public void User_verify_the_upcoming_Reservation_details() {
		findavailableworkstations.verifyUpcomingReservationsDetails();
	}

	@And("^User click on Edit Reservation button$")
	public void User_click_on_Edit_Reservation_button() {
		findavailableworkstations.editReservation();
	}

	@And("^User click on Edit Options dropdown and selected change reservation date$")
	public void User_click_on_Edit_Options_dropdown_and_selected_change_reservation_date() {
		findavailableworkstations.editOptions();
		findavailableworkstations.changeReservationDate();
	}

	@And("^entered new reservation date and click on submit button$")
	public void entered_new_reservation_date_and_click_on_submit_button() {
		findavailableworkstations.enterNewReservationDate(4);
		findavailableworkstations.clickOnSubmit();
	}

	@And("^User verified reservation complete details$")
	public void User_verified_reservation_complete_details() {
		findavailableworkstations.reservationComplete();
	}

	@And("^User close the new reservation confirmation window$")
	public void user_close_the_new_reservation_confirmation_window() {
		findavailableworkstations.closeNewReservationConfirmationWindow();
	}

	@And("^User click on Edit Options dropdown and selected change workstation$")
	public void User_click_on_Edit_Options_dropdown_and_selected_change_workstation() {
		findavailableworkstations.editOptions();
		findavailableworkstations.changeWorkstation();

	}

	@And("^User click on the pod options and selected the available Pod$")
	public void User_click_on_the_pod_options_and_selected_the_available_Pod() {
		findavailableworkstations.podOptions();
		findavailableworkstations.availablePod();
	}

	@And("^User click on Workstation options and selected available workstation$")
	public void User_click_on_Workstation_options_and_selected_available_workstation() {
		findavailableworkstations.workStationOptions();
		findavailableworkstations.availableWorkStationOption();
	}

	@And("^User click on Submit button$")
	public void User_click_on_Submit_button() {
		findavailableworkstations.submit();
	}

	@And("^User click on Edit Options dropdown and selected change Time Slot$")
	public void User_click_on_Edit_Options_dropdown_and_selected_change_Time_Slot() {
		findavailableworkstations.editOptions();
		findavailableworkstations.changeTimeSlot();
	}

	@And("^User selected new time slot$")
	public void User_selected_new_time_slot() {
		findavailableworkstations.fullDayorSpecificTime();
	}

	@And("^User cancel the upcoming reservation$")
	public void User_cancel_the_upcoming_reservation() {
		findavailableworkstations.cancelReservation();
	}

	@And("^User verify the reservation cancelled details$")
	public void User_verify_the_Reservation_cancelled_details() {
		findavailableworkstations.verifyReservationCancelled();
	}

	@And("^User close the reservation cancellation window$")
	public void User_close_the_reservation_cancellation_window() {
		findavailableworkstations.reservationCancellationClose();
	}

	@And("^User click on signout button to logout from workspace reservations page$")
	public void User_click_on_signout_button_to_logout_from_workspace_reservations_page() {
		findavailableworkstations.signOut();
	}

}
