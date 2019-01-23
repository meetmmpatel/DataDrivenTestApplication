package com.datadriven.schatch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.datadriven.base.TestBaseUtil;

public class DemoTest extends TestBaseUtil {

	By userName = By.id(OR.getProperty("loginPageUserName"));
	By passWord = By.id(OR.getProperty("loginpagePassword"));
	By submit = By.id(OR.getProperty("loginpageSubmit"));
	
	@Test (groups = "A")
	public void testLogin() {
		driver.findElement(userName).sendKeys("Admin");
		driver.findElement(passWord).sendKeys("admin123");
		driver.findElement(submit).click();
	}

	public DemoTest(WebDriver driver) {
		super();
	}
	
	

}
