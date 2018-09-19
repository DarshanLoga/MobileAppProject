package FlexbookAppTest.AbstractBaseTests.FlexbookApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.MessageFormat;

//import org.apache.tools.ant.taskdefs.Java;
//import org.openqa.selenium.interactions.internal.TouchAction;


/**
 * Created by Karthick on 02/06/17.
 */
public class OfflineLibrary extends BrowsePage {
    @Autowired
    BookDetails bookDetails;

    @Autowired
    BrowsePage browsePage;

    @Autowired
    OfflineLibrary offlineLibrary;
    /**
     * A base constructor that sets the page's driver
     * <p>
     * The page structure is being used within this test in order to separate the
     * page actions from the tests.
     * <p>
     * Please use the AppiumFieldDecorator class within the page factory. This way annotations
     * like @AndroidFindBy within the page objects.
     *
     * @param driver the appium driver created in the beforesuite method.
     *
     *
     */
    public OfflineLibrary(AppiumDriver driver) { super(driver);
    }

    public enum LibraryPageLocators {
        LIBRARY_PAGE(".view-LibraryZeroStateView"), //CSS
		OFFLINE_LIBRARY_ZERO_STATE_MSG("content-lib"), //class
        OFFLINE_PAGE_HDR("bookTitle"), //ID
        EDIT_LINK(".library-edit-button span"), //CSS $(".library-edit-button span").trigger("touchend")
        REMOVE_LINK(".library-remove-button span"),
        Books(".books"), //CSS
		START_BROWSING_BTN(".button.large.tangerine" ),// css
        //START_BROWSING_BTN("div.start-browsing-container > input"), //CSS
        DOWNLOAD_PERCENTAGE_IN_OFFLINE_LIBRARY(".loading-container div"), //CSS
        ACCESS_DOWNLOAED_BOOK_IN_OFFLINE_LIBRARY(".library-main-container > li"), //CSS $(".books:nth-child(1)").trigger("touchend")
		EDIT_BTN("editButton"), // id
		REMOVE_BTN("#removeButton"), //css
		BOOK_COVER_IMG("book-image"), //class
		ACCESS_BOOK_FROM_OFFLINE(".library-main-container > li"), //css
		LIBRARY_CONTAINER("div.library-main-container li"), //css
        ;

        private final String myLocator;

        LibraryPageLocators(String locator) {
            myLocator = locator;
        }

        public String get() {
            return myLocator;
        }

        public String getWithParams(Object... params) {
            return MessageFormat.format(myLocator, params);
        }
    }

    public void tapElement(AppiumDriver driver, WebElement element) {
        // Locate center of element
        Point location = element.getLocation();
        Dimension size = element.getSize();
        int tapX = location.getX() + (size.getWidth() / 2);
        int tapY = location.getY() + (size.getHeight() / 2);

        // Execute tap
        switchToWebViewContext("NATIVE_APP");
        TouchAction action = new TouchAction(driver);
        action.tap(tapX, tapY).perform();
        switchToWebViewContext("WEBVIEW");
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {}
    }


    public boolean verifyOfflineLibrary() {
		try {
			Thread.sleep ( 1000 );
		} catch (InterruptedException e) {
			e.printStackTrace ( );
		}
		if (webDriver.findElement ( By.cssSelector ( LibraryPageLocators.LIBRARY_PAGE.get ( ) ) ).isDisplayed ( ) &&
		  webDriver.findElement ( By.id ( LibraryPageLocators.OFFLINE_PAGE_HDR.get ( ) ) ).isDisplayed ( )) {
			if (webDriver.findElement ( By.id ( LibraryPageLocators.OFFLINE_PAGE_HDR.get ( ) ) ).getText ( ).equals ( "My Offline Library" )) {
				System.out.println ( "Offline library page appears" );
			}
		}
		return true;
	}

	public boolean verifyOfflineZeroState() {
		// Offline library zero state
		if (webDriver.findElement ( By.cssSelector ( LibraryPageLocators.START_BROWSING_BTN.get ( ) ) ).isDisplayed ( )) {
			System.out.println ( webDriver.findElement ( By.className ( LibraryPageLocators.OFFLINE_LIBRARY_ZERO_STATE_MSG.get ( ) ) ).getText ( ) );
			tap ( webDriver.findElement ( By.cssSelector ( LibraryPageLocators.START_BROWSING_BTN.get ( ) ) ) );
			try {
				Thread.sleep ( 2000 );
			} catch (InterruptedException e) {
				e.printStackTrace ( );
			}
			wait.until ( ExpectedConditions.visibilityOfElementLocated ( By.id ( BrowsePageLocators.SUBJECT_PAGE.get ( ) ) ) );
		}
		return true;
	}

	public boolean accessDownloadedBookInLibrary() {
		try {
			Thread.sleep( 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Access the downloaded book from library page
		if(webDriver.findElement(By.id (LibraryPageLocators.EDIT_BTN.get())).isDisplayed() &&
		  webDriver.findElement(By.className(LibraryPageLocators.BOOK_COVER_IMG.get())).isDisplayed() &&
		  webDriver.findElement(By.cssSelector(LibraryPageLocators.LIBRARY_CONTAINER.get())).isDisplayed()) {
        	System.out.println("Downloaded book appeas in library page");
        	WebElement accessDownloadedBookInLibrary=webDriver.findElement(By.cssSelector(LibraryPageLocators.ACCESS_BOOK_FROM_OFFLINE.get()));
        	if (accessDownloadedBookInLibrary.isDisplayed()) {
        		tap (accessDownloadedBookInLibrary);
				try {
					Thread.sleep( 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Downloaded book access successfully in library page");
			}
		}
		wait.until( ExpectedConditions.visibilityOfElementLocated( By.cssSelector(BookDetails.BookDetailsLocators.TOC_PAGE.get())));
        return true;
    }

    public boolean deleteDownloadedBookInLibrary() {
		try {
			Thread.sleep( 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (webDriver.findElement ( By.id ( LibraryPageLocators.EDIT_BTN.get ( ) ) ).isDisplayed ( )) {
			tap ( webDriver.findElement ( By.id ( LibraryPageLocators.EDIT_BTN.get ( ) ) ) );
			try {
				Thread.sleep ( 2000 );
			} catch (InterruptedException e) {
				e.printStackTrace ( );
			}
			if (webDriver.findElement ( By.cssSelector ( LibraryPageLocators.REMOVE_BTN.get ( ) ) ).isDisplayed ( ) &&
			  webDriver.findElement ( By.cssSelector ( LibraryPageLocators.Books.get ( ) ) ).isDisplayed ( )) {
				tap(webDriver.findElement ( By.cssSelector ( LibraryPageLocators.Books.get ( ) )));
				tap ( webDriver.findElement ( By.cssSelector ( LibraryPageLocators.REMOVE_BTN.get ( ) ) ) );
				try {
					Thread.sleep ( 1000 );
				} catch (InterruptedException e) {
					e.printStackTrace ( );
				}
				System.out.println ( "Downloaded book deleted successfully from library" );
				return true;
			}
		}
		return false;
	}
}



