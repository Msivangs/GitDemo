package stepdefs.support;

import org.openqa.selenium.WebDriver;

public class SuperStepDef {

	public WebDriver driver;
	public String AUT;
	public Hook hook;
	
	public SuperStepDef(Hook hook) {
		this.driver = hook.getDriver();
		this.AUT = hook.getEnvironment();
		this.hook = hook;
	}
}
