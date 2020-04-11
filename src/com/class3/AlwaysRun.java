package com.class3;

	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterSuite;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	public class AlwaysRun {

		@BeforeSuite(alwaysRun=true)
		public void beforeSuite() {
			System.out.println("I am before suite");
		}
		
		@BeforeTest(alwaysRun=true)
		public void beforeTest() {
			System.out.println("I am before test");
		}
		
		@BeforeClass(alwaysRun=true)
		public void beforeClass() {
			System.out.println("I am before class");
		}
		
		@BeforeMethod(alwaysRun=true)
		public void beforeMethod() {
			System.out.println("I am before method");
		}
		
		@AfterMethod(alwaysRun=true)
		public void afterMethod() {
			System.out.println("I am after method");
		}
		
		@AfterClass(alwaysRun=true)
		public void afterClass() {
			System.out.println("I am after class");
		}
		
		@AfterTest(alwaysRun=true)
		public void afterTest() {
			System.out.println("I am after test");
		}
		
		@AfterSuite(alwaysRun=true)
		public void afterSuite() {
			System.out.println("I am after suite");
		}
		
		@Test
		public void testMethod() {
			System.out.println("I am test");
		}
		
		@Test
		public void testMethod1() {
			System.out.println("I am test1");
		}
}
