package FlexbookAppTest.Test_FlexbookApp;

import FlexbookAppTest.AbstractBaseTests.FlexbookApp.*;
import FlexbookAppTest.AbstractBaseTests.TestBase;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
//import org.springframework.util.Assert;

/**
 * Created by Karthick on 02/06/17.
 */

public class Test_LaunchApp extends TestBase {

	private LandingPage landingPage;


	@Override
	public String getName() {
		return null;
	}

	@BeforeTest
	@Override
	public void setUpPage() {
		System.out.println("Landing page");
		landingPage = new LandingPage(driver);

	}

	//@Test(groups = {"landing"}) Work good in local
	@Test(priority = 1)
	public void signUpNewUser() {
		System.out.println("entering test 1");
		try {
			//landingPage = new LandingPage (driver);
			Assert.assertTrue(landingPage.verifyLauncher());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}



