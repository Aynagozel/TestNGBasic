package com.class4;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.Constants;

public class LoginAndTitle extends CommonMethods {
	@BeforeMethod(alwaysRun = true)
	public void openAndNavigate() {
		setUp("chrome", Constants.HRMS_URL);
	}

	@Test(groups = "regression")
	public void titleValidation() {
		System.out.println("Executing title validation test case-------------");
		String expectedTitle = "Human Management Systems";
		String actualTitle = driver.getTitle();// Human Management System
		Assert.assertEquals(actualTitle, expectedTitle, "Titles are NOT matched");
		System.out.println("I am a text after the assertion");
	}

	@Test(groups = "regression")
	public void logoValidation() {
		boolean isDisplayed = driver.findElement(By.xpath("//div[@id='divLogo']/img")).isDisplayed();
		Assert.assertTrue(isDisplayed, "Syntax Logo is NOT displayed");
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}
}
