package reviewclass1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PrametarizationDemo {

	@Test(dataProvider = "getData")
	public void testOne(String userName, String pass) {

		System.out.println(userName);
		System.out.println(pass);
		System.out.println("click button");
		System.out.println("***************");
	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = { { "test1@yahoo.com", "test1@123" }, { "test2@gmail.com", "test2.123" },
				{ "test3@live.com", "test3@567" } };

		return data;
	}

}
