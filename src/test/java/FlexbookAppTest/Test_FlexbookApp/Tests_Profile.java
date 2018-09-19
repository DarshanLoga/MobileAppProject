package FlexbookAppTest.Test_FlexbookApp;

import FlexbookAppTest.AbstractBaseTests.FlexbookApp.ProfilePage;
import FlexbookAppTest.AbstractBaseTests.FlexbookApp.SignInPage;
import FlexbookAppTest.AbstractBaseTests.FlexbookApp.SignUpPage;
import FlexbookAppTest.AbstractBaseTests.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tests_Profile extends TestBase {
	private ProfilePage profilePage;


	@Override
	public String getName() {
		return "ProfilePage";
	}

	@BeforeTest
	@Override
	public void setUpPage() {
		System.out.println("Profile page");
		profilePage = new ProfilePage(driver);
		System.out.println("Before test testng method");
	}


	@Test(priority = 4)
	public void verifyProfileBuilder() {
		System.out.println("entering test 4");
		Assert.assertTrue(profilePage.verifyProfilePage());
		}

	@Test(priority = 5)
	public void selectProfileRole() {
		System.out.println("entering test 5");
		Assert.assertTrue(profilePage.verifyUserName());
		Assert.assertTrue(profilePage.selectUserRole("teacher"));
		Assert.assertTrue(profilePage.clickNextBtn());
	}

	@Test(priority = 6)
	public void selectUserGrades() {
		System.out.println("entering test 6");
		Assert.assertTrue(profilePage.selectGrades());
		Assert.assertTrue(profilePage.clickNextBtn());
		Assert.assertTrue(profilePage.clickContinue());
	}

}