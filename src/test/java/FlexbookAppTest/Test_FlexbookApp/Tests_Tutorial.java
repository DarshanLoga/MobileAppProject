package FlexbookAppTest.Test_FlexbookApp;

import FlexbookAppTest.AbstractBaseTests.FlexbookApp.ProfilePage;
import FlexbookAppTest.AbstractBaseTests.FlexbookApp.TutorialPage;
import FlexbookAppTest.AbstractBaseTests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tests_Tutorial extends TestBase {

	private TutorialPage tutorialPage;

	@Override
	public String getName() {
		return "TutorialPage";
	}

	@BeforeTest
	@Override
	public void setUpPage() {
		System.out.println ( "Tutorial page" );
		tutorialPage = new TutorialPage ( driver );
		System.out.println ( "Before test testng method" );
	}


	@Test(priority = 7)
	public void verifyTutorialPage() {
		System.out.println( "entering test 7" );
		Assert.assertTrue(tutorialPage.verifyTutorialPage());
		Assert.assertTrue(tutorialPage.startBrowsing());
	}
}