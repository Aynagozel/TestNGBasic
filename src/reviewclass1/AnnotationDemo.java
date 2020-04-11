package reviewclass1;

import org.testng.annotations.Test;

public class AnnotationDemo {

	@Test(priority = 1)
	public void D() {
		System.out.println("Open Browser");
	}

	@Test(priority = 3)
	public void A() {
		System.out.println("PIM Test case");
	}

	@Test(priority = 2)
	public void B() {
		System.out.println("Leave Test Case");
	}

	@Test(priority = 4)
	public void C() {
		System.out.println("close browser");
	}

}
