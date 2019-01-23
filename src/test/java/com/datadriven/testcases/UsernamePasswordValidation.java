package com.datadriven.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.datadriven.base.TestBaseUtil;
import com.datadriven.page.LogInPage;

public class UsernamePasswordValidation extends TestBaseUtil {

	@Test(dataProvider = "UsernamePassword")
	public void testUserNamePassword(String userName, String password) throws InterruptedException {

		LogInPage login = PageFactory.initElements(driver, LogInPage.class);
		login.userLogin(userName, password);
		login.clickSubmit();
		driver.navigate().back();
		driver.findElement(By.id(OR.getProperty("loginPageUserName"))).clear();
		driver.findElement(By.id(OR.getProperty("loginpagePassword"))).clear();
		Thread.sleep(2000);
		driver.quit();
		

	}

	@DataProvider(name = "UsernamePassword")
	public Object[][] dataProviderForLogin() {

		Object[][] obj = { { "Admin", "admin123" }, 
				{ "Main", "Test" }, 
				{ "Admin", "Main" } };

		return obj;

	}

}
