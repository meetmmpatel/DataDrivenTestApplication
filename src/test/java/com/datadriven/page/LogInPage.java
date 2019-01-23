package com.datadriven.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LogInPage {

	WebDriver driver;

	@FindBy(id = "txtUsername")
	@CacheLookup
	WebElement userName;

	@FindBy(how = How.ID, using = "txtPassword")
	@CacheLookup
	WebElement password;

	@FindBy(how = How.ID, using = "btnLogin")
	@CacheLookup
	WebElement loginSubmit;

	public LogInPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void userLogin(String InputUserName, String InputPassword) {
		userName.sendKeys(InputUserName);
		password.sendKeys(InputPassword);

	}

	public void clickSubmit() {
		loginSubmit.click();
	}

}
