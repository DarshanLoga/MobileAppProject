package FlexbookAppTest.Test_FlexbookApp;

import FlexbookAppTest.AbstractBaseTests.FlexbookApp.AccountSettings;
import FlexbookAppTest.AbstractBaseTests.FlexbookApp.SideMenu;
import FlexbookAppTest.AbstractBaseTests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tests_SettingsPage extends TestBase {

	private AccountSettings accountSettings;

	@Override
	public String getName() {
		return "ChapterSection";
	}

	@BeforeTest
	@Override
	public void setUpPage() {
		System.out.println("Settings page");
		accountSettings = new AccountSettings(driver);
		System.out.println("Before test testng method");
	}

	@Test(priority = 28)
	public void verifyAccountSettingsPage() {
		System.out.println("entering test 28");
		Assert.assertTrue(accountSettings.verifyAccountSettings());
	}

	/*@Test(priority = 29)
	public void createUserName() {
		System.out.println("entering test 29");
		Assert.assertTrue(accountSettings.createUserName());
	}*/

    /*@Test(priority = 29)
	public void changeCurrentPassword() {
		System.out.println("entering test 29");
		Assert.assertTrue(accountSettings.changeCurrentPassword());
	}*/

	@Test(priority = 29)
	public void exitAccountSettingsPage() {
		System.out.println("entering test 30");
		Assert.assertTrue(accountSettings.exitSettingsPage());
	}
}
