package stepdefs.support;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.Before;
import utils.BrowserFactory;

public class Hook {

	public final String globalDataPath = "src" + File.separator + "test" + File.separator + "resources" + File.separator
			+ "GlobalData.properties";
	public WebDriver driver;
	public String environment;
	public String browserToUse;

	@Before
	public void before() throws Exception {
		System.out.println("Loading Global Data from property file..[" + globalDataPath + "]");
		Properties prop = new Properties();
		FileInputStream input = new FileInputStream(new File(globalDataPath));
		prop.load(input);

		environment = prop.getProperty("environment");
		browserToUse = prop.getProperty("browser");
		System.out.println("Environment to be used: [" + environment + "]");
		System.out.println("Browser to be used: [" + browserToUse + "]");

		driver = new BrowserFactory().getBrowser(browserToUse);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public String getEnvironment() {
		return environment;
	}

}
