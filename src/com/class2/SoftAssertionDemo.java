package com.class2;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utils.CommonMethods;
import com.utils.Constants;

/* Open Application
 * Verify logo is displayed
 * Enter valid credentials
 * Verify user successfully logged in
 */
public class SoftAssertionDemo extends CommonMethods {

	@BeforeMethod(alwaysRun = true)
	public void open() {
		setUp("chrome", Constants.HRMS_URL);
	}

	@Test(groups = "smoke")
	public void logoAndLogin() {
		boolean logoDisplayed = driver.findElement(By.xpath("//div[@id='divLogo']/img")).isDisplayed();
		logoDisplayed = false;

		// Hard Assert will fail and execution will stop at that point
		// Assert.assertTrue(logoDisplayed, "Logo is NOT displayed");

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(logoDisplayed, "Logo is NOT displayed");

		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.name("Submit")).click();

		boolean welcomeDisplayed = driver.findElement(By.id("welcome")).isDisplayed();
		softAssert.assertTrue(welcomeDisplayed, "Welcome element is NOT displayed");
		softAssert.assertAll();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
}
