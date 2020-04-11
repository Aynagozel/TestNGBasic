package reviewclass1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PriorityDemo {

	@BeforeClass
	public void testBeforeM() {
		System.out.println("Open Browser");
	}

	@Test
	public void test1() {
		System.out.println("Logining in");
		System.out.println("PIM Test case");
	}

	@Test
	public void test2() {
		System.out.println("Leave Test Case");
	}

	@AfterClass
	public void testAfterM() {
		System.out.println("Close Browser");
	}

}
