package com.class1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TaskTwo {
	@BeforeClass
	public void beforeClass() {
		System.out.println("This is a b4 Class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("This is an after Class");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This is b4 Method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("This is after Method");
	}

	@Test
	public void testA1() {
		System.out.println("Test me first ");
	}

	@Test
	public void testZ9() {
		System.out.println("Test me last");
	}
}
