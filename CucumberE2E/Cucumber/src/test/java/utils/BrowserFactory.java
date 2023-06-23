package utils;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactory {

	public WebDriver getBrowser(String browserName) {
		WebDriver driver = null;
		switch (browserName) {
		case "chrome":
			String chromeDriverPath = "Drivers" + File.separator + "chromedriver.exe";
			System.out.println("Chrome Driver Path..[" + chromeDriverPath + "]");
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			// driver = new ChromeDriver();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("disable-popup-blocking");
			// options.addArguments("--headless");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			options.merge(capabilities);
			driver = new ChromeDriver(options);
			// driver.manage().window().maximize();
			// driver.manage().window().setSize(new Dimension(640,360));
			break;
		}
	
		return driver;
	}

}