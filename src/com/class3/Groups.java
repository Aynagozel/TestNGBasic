package com.class3;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.Constants;

public class Groups extends CommonMethods {

	@BeforeMethod(alwaysRun = true)
	public void openAndNavigate() {
		setUp("chrome", Constants.HRMS_URL);
	}

	@Test(groups = { "smoke", "login" })
	public void validLogin() {
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
	}

	@Test(groups = { "regression", "sprint1" })
	public void titleValidation() {
		String expectedTitle = "Human Management System";
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("test pass");
		} else {
			System.out.println("test fails");
		}
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}
}
