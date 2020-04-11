package com.class4;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.CommonMethods;
import com.utils.Constants;

public class HW extends CommonMethods {

	@BeforeMethod(alwaysRun = true)
	public void open() {
		setUp("chrome", Constants.HRMS_URL);
	}

	@AfterMethod(alwaysRun = true)
	public void close() {
		driver.quit();
	}

	// @Test(dataProvider = "getData", groups="regression")
	public void test(String Name, String lastName, String userName, String password) throws InterruptedException {
		// login into hrms
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.name("Submit")).click();
		// navigating to add employee section
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//b[text()='PIM']")));
		driver.findElement(By.xpath("//b[text()='PIM']")).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("menu_pim_addEmployee")));
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		Thread.sleep(3000);
		// adding employee
		driver.findElement(By.id("firstName")).sendKeys(Name);
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		String empId = driver.findElement(By.id("employeeId")).getAttribute("value");
		driver.findElement(By.id("chkLogin")).click();
		// creating login credentials
		driver.findElement(By.id("user_name")).sendKeys(userName);
		driver.findElement(By.id("user_password")).sendKeys(password);
		driver.findElement(By.id("re_password")).sendKeys(password);
		driver.findElement(By.id("btnSave")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h1[text()='Personal Details']")));
		// verifying employee is added successfully
		String actualEmpId = driver.findElement(By.id("personal_txtEmployeeId")).getAttribute("value");
		Assert.assertEquals(actualEmpId, empId, "Employee ID did not match");
		// taking screenshot
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screen = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screen, new File("ScreenShot/screen/" + Name + lastName + ".png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = { { "James", "Smith", "james222", "Arlington@2@20" },
				{ "John", "Brown", "john222", "Arlington@2@19" }, { "Ramesh", "Yadav", "ram222", "NewYear@2@20" },
				{ "Mukesh", "Sharma", "mukesh222", "Syntax@2@20" }, { "Raj", "Maharjan", "raj222", "Fairfax@2@20" } };
		return data;
	}
}
