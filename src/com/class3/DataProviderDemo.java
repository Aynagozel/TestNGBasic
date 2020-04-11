package com.class3;

/*
 * Verify user is able to login into hrms with different uid and pwd
 * 
 */

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.Constants;

public class DataProviderDemo extends CommonMethods {

	@BeforeMethod
	public void openBrowser() {
		setUp("chrome", Constants.HRMS_URL);
	}

	@Test(dataProvider = "getData")
	public void login(String username, String password) throws InterruptedException {
		driver.findElement(By.name("txtUsername")).sendKeys(username);
		driver.findElement(By.name("txtPassword")).sendKeys(password);
		Thread.sleep(5000);
		driver.findElement(By.name("Submit")).click();
		boolean welcomeDisplayed = driver.findElement(By.id("welcome")).isDisplayed();
		Assert.assertTrue(welcomeDisplayed, "Welcome element is NOT displayed");
	}

	// to create a data provider we need to create a method that will be returning
	// Object 2D array
	@DataProvider
	public Object[][] getData() {
		Object[][] data = { { "Admin", "Hum@nhrm123" }, { "Syntax", "Syntax123!" }, { "SyntaxUser", "Syntax123!" } };
		return data;
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
