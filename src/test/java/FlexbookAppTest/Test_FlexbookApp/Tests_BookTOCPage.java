package FlexbookAppTest.Test_FlexbookApp;

import FlexbookAppTest.AbstractBaseTests.FlexbookApp.BookDetails;
import FlexbookAppTest.AbstractBaseTests.FlexbookApp.BrowsePage;
import FlexbookAppTest.AbstractBaseTests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tests_BookTOCPage extends TestBase {
	private BookDetails bookDetails;

	@Override
	public String getName() {
		return "BookDetails";
	}

	@BeforeTest
	@Override
	public void setUpPage() {
		System.out.println("Book details page");
		bookDetails = new BookDetails(driver);
		System.out.println("Before test testng method");
	}
	
	@Test(priority = 15)
	public void verifyBookTOCPage() {
		System.out.println("entering test 15");
		Assert.assertTrue(bookDetails.verifyBookTOCPage());
	}

	@Test(priority = 16)
	public void verifyBookMetaDataInBookCover() {
		System.out.println("entering test 16");
		Assert.assertTrue(bookDetails.verifyBookMetaData());
	}

	@Test(priority = 17)
	public void accessChapterInBookTOCPage() {
		System.out.println("entering test 16");
		Assert.assertTrue(bookDetails.accessChapterInBookTOC());
	}
}
