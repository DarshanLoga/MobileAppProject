package FlexbookAppTest.Test_FlexbookApp;

import FlexbookAppTest.AbstractBaseTests.FlexbookApp.BrowsePage;
import FlexbookAppTest.AbstractBaseTests.FlexbookApp.TutorialPage;
import FlexbookAppTest.AbstractBaseTests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tests_Browse extends TestBase {

	private BrowsePage browsePage;


	@Override
	public String getName() {
		return "BrowsePage";
	}

	@BeforeTest
	@Override
	public void setUpPage() {
		System.out.println ( "Browse page" );
		browsePage = new BrowsePage ( driver );
		System.out.println ( "Before test testng method" );
	}

	@Test(priority = 8)
	public void verifyBrowsePage() {
		System.out.println ( "entering test 8" );
		Assert.assertTrue ( browsePage.verifyBrowsePage ( ) );
	}

	@Test(priority = 9)
	public void browseSubject() {
		System.out.println ( "entering test 9" );
		Assert.assertTrue ( browsePage.selectSubject ( "Math" ) );
	}

	@Test(priority = 10)
	public void browseConcept() {
		System.out.println ( "entering test 10" );
		Assert.assertTrue ( browsePage.selectConcept ( "MAT.ARI" ) );
	}

	@Test(priority = 11)
	public void verifyBookBrowsePage() {
		System.out.println ( "entering test 11" );
		Assert.assertTrue ( browsePage.verifyBookBrowsePage ( ) );
	}

	@Test(priority = 12)
	public void selectLanguage() {
		System.out.println ( "entering test 12" );
		Assert.assertTrue ( browsePage.verifyLanguageFilter ( ) );
		Assert.assertTrue ( browsePage.selectLanguage ( ) );
	}

	@Test(priority = 13)
	public void selectLevel() {
		System.out.println ( "entering test 13" );
		Assert.assertTrue ( browsePage.verifyLevelFilter ( ) );
		Assert.assertTrue ( browsePage.selectLevel ( ) );
	}

	@Test(priority = 14)
	public void selectBook() {
		System.out.println("entering test 14");
		Assert.assertTrue(browsePage.verifyandSelectBook());
	}
}
