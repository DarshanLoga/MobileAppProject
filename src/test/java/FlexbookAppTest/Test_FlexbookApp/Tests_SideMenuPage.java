package FlexbookAppTest.Test_FlexbookApp;

import FlexbookAppTest.AbstractBaseTests.FlexbookApp.BookDetails;
import FlexbookAppTest.AbstractBaseTests.FlexbookApp.ChapterSections;
import FlexbookAppTest.AbstractBaseTests.FlexbookApp.SideMenu;
import FlexbookAppTest.AbstractBaseTests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tests_SideMenuPage extends TestBase {

	private SideMenu sideMenu;

	private BookDetails bookDetails;

	@Override
	public String getName() {
		return "ChapterSection";
	}

	@BeforeTest
	@Override
	public void setUpPage() {
		System.out.println("SideMenu page");
		sideMenu = new SideMenu(driver);
		bookDetails = new BookDetails(driver);
		System.out.println("Before test testng method");
	}

	@Test(priority = 27)
	public void tapSettingMenuAndVerifyAccountSettingPage() {
		System.out.println("entering test 27");
		Assert.assertTrue(sideMenu.tapAndGoToSettingsPage());
	}

	/*@Test(priority = 31)
	public void tapRecentMenuAndVerifyRecentReadPage() {
		System.out.println("entering test 31");
		Assert.assertTrue(bookDetails.verifyRecentReadPage());
	}*/

	@Test(priority = 30)
	public void tapSubjectMenuAndVerifyBrowsePage() {
		System.out.println("entering test 31");
		Assert.assertTrue(sideMenu.tapAndGoToSubjectPage ());
	}

	@Test(priority = 31)
	public void performSignoutApp() {
		System.out.println("entering test 32");
		Assert.assertTrue(sideMenu.signOutApp());
	}
}
