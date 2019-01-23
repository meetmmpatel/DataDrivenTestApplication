package com.datadriven.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.datadriven.base.TestBaseUtil;
import com.datadriven.page.LogInPage;

public class TestLoginPage extends TestBaseUtil {

	
	@BeforeTest
	public void testLoginPage() {

		LogInPage login = PageFactory.initElements(driver, LogInPage.class);
		login.userLogin("Admin", "admin123");
		login.clickSubmit();

	}

	@Test(groups = "A")
	public void clickOnAdminPage() {
		By adminPage = By.id(OR.getProperty("adminPageClick"));
		driver.findElement(adminPage).click();
		driver.quit();
	}

	

}
