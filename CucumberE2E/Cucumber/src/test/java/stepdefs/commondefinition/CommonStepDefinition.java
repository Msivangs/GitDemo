package stepdefs.commondefinition;

import stepdefs.support.Hook;
import stepdefs.support.SuperStepDef;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.common.CommonPage;

public class CommonStepDefinition extends SuperStepDef {

	public Hook hook;

	public CommonSteps commonSteps;

	public CommonStepDefinition(Hook hook) {
		super(hook);
		this.hook = hook;
		commonSteps = new CommonSteps(driver);

	}

	@Given("^User Launch Chrome Browser and opens Workspace Reservation url$")
	public void user_launch_chrome_browser() {
		try {
			// AUT = getAUTURL();
			driver.get(CommonPage.getURL());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@And("^User click on sign in button$")
	public void user_click_on_sign_in_button() {
		commonSteps.clikonSignin();

	}

	@When("^User enter ([^\"]*) in user name field$")
	public void user_enter_in_user_name_field(String username) {
		commonSteps.userName(username);
	}

	@Then("^User click on next button$")
	public void user_click_on_next_button() {
		commonSteps.clikNext();

	}

	@And("^User entered ([^\"]*) in password field$")
	public void user_entered_in_password_field(String password) {
		commonSteps.userPassword(password);

	}

	@And("^User click on signin$")
	public void user_click_on_signin() {
		commonSteps.clickSubmit();
	}

	@And("^Click on Stay signed in alert$")
	public void Click_on_Stay_signed_in_alert() {
		commonSteps.signInAlert();
	}

	
}
