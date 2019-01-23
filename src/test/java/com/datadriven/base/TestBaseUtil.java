package com.datadriven.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class TestBaseUtil {

	// To get the web driver
	public static WebDriver driver;

	// To read the information from properties files
	public static Properties config = new Properties();
	public static Properties OR = new Properties();

	// To create File inpust stream object
	public static FileInputStream fis;

	@BeforeSuite
	public void testSetup() throws IOException {

		if (driver == null) {
			// Load the properties file
			fis = new FileInputStream(System.getProperty("user.dir") 
					+ "/src/test/resources/properties/Config.properties");
			config.load(fis);

			fis = new FileInputStream(System.getProperty("user.dir") 
					+ "/src/test/resources/properties/OR.properties");
			OR.load(fis);
		}

		if (config.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", 
					"/Users/milanpatel/Documents/core/software/geckodriver 2");

			driver = new FirefoxDriver();
		} else if (config.getProperty("browser").equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", 
					"/Users/milanpatel/Documents/core/software/chromedriver-3");

			driver = new ChromeDriver();
		}

		driver.navigate().to(config.getProperty("testsiteurl"));

		driver.manage().timeouts().implicitlyWait
		(Integer.parseInt(config.getProperty("implicit.wait")),
				TimeUnit.SECONDS);

	}

	@AfterSuite(alwaysRun = true)
	public void testCleanUp() throws InterruptedException {

		if (driver != null) {
			Thread.sleep(5000);
			driver.quit();
		}

	}

}
