package FlexbookAppTest.Test_FlexbookApp;

import FlexbookAppTest.AbstractBaseTests.FlexbookApp.BookDetails;
import FlexbookAppTest.AbstractBaseTests.FlexbookApp.ChapterSections;
import FlexbookAppTest.AbstractBaseTests.FlexbookApp.SideMenu;
import FlexbookAppTest.AbstractBaseTests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tests_SectionsPage extends TestBase {

	private ChapterSections sections;
	
	private SideMenu sideMenu;

	@Override
	public String getName() {
		return "ChapterSection";
	}

	@BeforeTest
	@Override
	public void setUpPage() {
		System.out.println("Sections page");
		sections = new ChapterSections(driver);
		sideMenu = new SideMenu(driver);
		System.out.println("Before test testng method");
	}

	@Test(priority = 18)
	public void verifyChapterIndexPage() {
		System.out.println("entering test 18");
		Assert.assertTrue(sections.verifyChapterTOCPage());
	}

	@Test(priority = 19)
	public void tapSideMenuAndVerifyChapterInBook() {
		System.out.println("entering test 19");
		Assert.assertTrue(sections.accessChapterLinksThroughSideMenu());
	}

	@Test(priority = 20)
	public void tapSideMenuAndVerifyChapterSectionInBook() {
		System.out.println("entering test 20");
		Assert.assertTrue(sections.accessChapterSectionsThroughSideMenu());
	}

	@Test(priority = 21)
	public void increaseFontSizeInBookSectionContent() {
		System.out.println("entering test 21");
		Assert.assertTrue(sections.increaseFontSize());
	}

	@Test(priority = 22)
	public void changeBackgroundInSectionContent() {
		System.out.println("entering test 21");
		Assert.assertTrue(sections.changeBackground( "Black"));
	}

	@Test(priority = 23)
	public void changeFontStyleInSectionContent() {
		System.out.println("entering test 23");
		Assert.assertTrue(sections.changeFontStyle());
	}

	@Test(priority = 24)
	public void setLineSpaceToSectionContent() {
		System.out.println("entering test 24");
		Assert.assertTrue(sections.changeLineSpacing( "Small"));
	}

	@Test(priority = 25)
	public void decreaseFontSizeInSectionContent() {
		System.out.println("entering test 25");
		Assert.assertTrue(sections.decreaseFontSize());
	}

	@Test(priority = 26)
	public void tapCoverMenuAndVerifyBookTOCPage() {
		System.out.println("entering test 26");
		Assert.assertTrue(sideMenu.tapCoverBookMenuInChapterSideMenu ( ) );
	}
}
