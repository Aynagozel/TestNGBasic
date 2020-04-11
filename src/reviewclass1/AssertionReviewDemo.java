package reviewclass1;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionReviewDemo {

	@Test
	public void testOne() {
		String actualTitle = "HRM";
		String expectedTitle = "HRM";

		boolean test = actualTitle.equals(expectedTitle);

//			if(actualTitle.equals(expectedTitle)) {
//				
//				System.out.println("Test Pass");
//			}else {
//				System.err.println("Test Failed");
//			}
		Assert.assertEquals(actualTitle, expectedTitle, "Actual Title did not match");

		Assert.assertTrue(test);

		System.out.println("Another Testcase");

	}

	@Test
	public void testTwo() {
		ArrayList<String> ui = new ArrayList<>();
		ui.add("a");
		ui.add("b");
		ui.add("c");

		ArrayList<String> db = new ArrayList<>();
		db.add("a");
		db.add("b");
		db.add("cb");

		// Assert.assertEquals(ui, db);

		SoftAssert sAssert = new SoftAssert();
		sAssert.assertEquals(ui, db);

		System.out.println("After assertion demo");
		sAssert.assertAll();
	}
}
