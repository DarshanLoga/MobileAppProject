package FlexbookAppTest.AbstractBaseTests.FlexbookApp;

import FlexbookAppTest.AbstractBaseTests.FlexbookApp.BrowsePage.BrowsePageLocators;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;
import FlexbookAppTest.AbstractBaseTests.FlexbookApp.LandingPage;

import java.text.MessageFormat;

/**
 * Created by Karthick on 02/06/17.
 */
public class BookDetails extends SideMenu {
    @Autowired
    LandingPage landingPage;

    @Autowired
    AccountSettings accountSettings;

    @Autowired
    TutorialPage tutorialPage;

    private Dimension size;

    /**
     * A base constructor that sets the page's driver
     * <p>
     * The page structure is being used within this test in order to separate the
     * page actions from the tests.
     * <p>
     * Please use the AppiumFieldDecorator class within the page
     * factory. This way annotations
     * like @AndroidFindBy within the page objects.
     *
     * @param driver the appium driver created in the beforesuite method.
     */
    public BookDetails(AppiumDriver driver) {
        super( driver );
    }

    public enum BookDetailsLocators {
        TOC_PAGE(".view-BookTocView"), //CSS
        DOWNLOAD_FULL_BOOK_BTN("downloadBook"), //ID $("#downloadBook").trigger("touchend")").trigger("touchend")
        DOWNLOAD_PROGRESS_PERCENTAGE(".loading-container div"), // CSS
        SHOW_FLIP_FLOP(".show-on-flip"), //CSS $(".show-on-flip").trigger("touchend")
        DOWNLOAD_MSG_LINE1(".download-message.line1"), //CSS
        DOWNLOAD_MSG_LINE2(".download-message.line2"), //CSS

        BOOK_TITLE("bookTitle"), // id
        BACK_TOC_ICON("backTocIcon"), //id
        FULL_BOOK_DOWNLOAD_BTN("downloadBook"), //id
        BOOK_DETAILS("css=div.book-details"),
        BOOK_IMAGE_CONTAINER("div.book-img-detail-cont"), //css
        CHAPTER_LIST_CONTAINER(".chapter-list-wrapper"), //css
        CHAPTER_CONTAINER("div.chapter-container"), //css
        SECTION_TABLE("ul.section-table"), //css
        SELECT_SECTION("ul.section-table li:nth-child({0})"), //css
        DOWNLOAD_ICONS(".chapter-list-item > span"), //css
        CLICK_DOWNLOAD("div.chapter-list-wrapper div.chapter-list-item:nth-child({0}) span.download-chapter"), //css
        BOOK_PROGRESS_CIRCLE("li.books:nth-child({0}) div.inner-circle-book"), //css
        OPEN_BTNS("div.chapter-list-wrapper div.chapter-list-item:nth-child({0}) div.open-button"), //css
        BOOK_TITLE_IN_SIDE_MENU("span.toc-item-title-app.ellipsis"), //css
        //CLICK_CHAPTER_ARROW("jquery=.icon-arrow3_right:eq({0})"),
        CLICK_CHAPTER_ARROW("#userInfoMenu > li:nth-child({0}) a.icon-arrow3_right.chapter-links-section"), //css
        LIBRARY_IN_SIDE_MENU("li.offline-library-menuToc"), //css
        COVER_IN_SIDE_MENU("li.concepts-link.cover-link"), //css
        USER_MENU("userInfoMenu"), //id

        //CHAPTER
        CHAPTER_LIST(".chapter-list-item"), //CSS  .chapter-list-item:nth-child(2) .chapter-title
        DOWNLOAD_ICON(".chapter-list-item > span"), //CSS
        DOWNLOAD_SINGLE_CHAPTER("div.chapter-list-wrapper div.chapter-list-item:nth-child({0}) span.download-chapter"), //CSS
        SINGLE_CHAPTER("div.chapter-list-wrapper div.chapter-list-item:nth-child({0}) div.chapter-title-cont"),
        CHAPTER_PROGRESS_CIRCLE("div.chapter-list-wrapper div.chapter-list-item:nth-child({0}) div.chapter-progress"),
		OFFLINE_DOWNLOAD_MESSAGE_POPUP("offlineMsgCont"), //id
		DISMISS_DOWNLOAD_MESSAGE_POPUP("#offline-msg-parent > div.cellular-download-button-parent > input"), //CSS

        OPEN_BTN(".open-button > span"), //CSS
        DOWNLOAD_CHAPTER(".chapter-list-item:nth-child({0}) > span"), //CSS $(".chapter-list-item:nth-child(1) > span").trigger("touchend")
        CHAPTER_DOWNLOAD_PROGRESS(".chapter-progress"), //CSS
        ACCESS_DOWNLOADED_CHAPTER(".chapter-list-item:nth-child({0}) span.open-text"), //CSS  $(".chapter-list-item:nth-child(1) span.open-text").trigger("touchend")

        //SECTIONS PAGE
        CHAPTER_TOC_PAGE(".view-ChapterView"), //CSS

        //RECENT READ
        RECENT_READ_PAGE(".view-RecentReadView"), //CSS
        RECENT_HEADER_TEXT("bookTitle"), //id
        SELECT_BOOK("div.recent-read-container li.books:nth-child({0}) div.book-meta div.book-title"), //css
        RECENT_READ_CONTAINER("div.recent-read-container"), //css
        BACK_BUTTON("#backTocIcon"), //CSS $("#backTocIcon").trigger("touchend")
        ;
        private final String myLocator;

        BookDetailsLocators(String locator) {
            myLocator = locator;
        }

        public String get() {
            return myLocator;
        }
        public String getWithParams(Object... params) {
            return MessageFormat.format( myLocator, params );
        }
    }

    public boolean scrollupdownpage() {
        setCoefficient ( "FlexbookApp" );
        try {
            Thread.sleep( 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Dimension dimensions = driver.manage().window().getSize();
        System.out.println("Dimension value = "+dimensions);

        Double screenHeightStart = dimensions.getHeight() * 0.5;
        System.out.println("Screen Height start Value="+screenHeightStart);

        int scrollStart = screenHeightStart.intValue();
        System.out.println("Scroll Start Value="+scrollStart);

        Double screenHeightEnd = dimensions.getHeight() * 0.2;
        System.out.println("Screen Height start End="+screenHeightEnd);

        int scrollEnd = screenHeightEnd.intValue();
        System.out.println("Scroll end Value="+scrollEnd);
        switchToWebViewContext("NATIVE_APP");
        driver.swipe(0,scrollStart,0,scrollEnd,2000);
        try {
            Thread.sleep( 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        switchToWebViewContext("WEBVIEW");
        return true;
    }

    public boolean verifyBookTOCPage() {
        try {
            Thread.sleep( 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (driver.findElement(By.id(BookDetailsLocators.BOOK_TITLE.get())).isDisplayed() &&
        driver.findElement(By.cssSelector(BookDetailsLocators.BOOK_IMAGE_CONTAINER.get())).isDisplayed() &&
          driver.findElement(By.cssSelector(BookDetailsLocators.CHAPTER_LIST_CONTAINER.get())).isDisplayed() &&
          driver.findElement(By.id(BookDetailsLocators.FULL_BOOK_DOWNLOAD_BTN.get())).isDisplayed()) {
            System.out.println("Book details page appears");
            //Scroll down the page
            scrollDownPage();
            return true;
        }
        return false;
    }

    public boolean verifyBookMetaData() {
        // Scroll up the page
        scrollUpPage();
        WebElement bookMetaData = webDriver.findElement ( By.cssSelector ( BookDetailsLocators.SHOW_FLIP_FLOP.get ( ) ) );
        if (bookMetaData.isDisplayed ( )) {
            tap ( bookMetaData );
            System.out.println ( webDriver.findElement ( By.cssSelector ( BookDetailsLocators.SHOW_FLIP_FLOP.get ( ) ) ).getText ( ) );
            try {
                Thread.sleep ( 1000 );
            } catch (InterruptedException e) {
                e.printStackTrace ( );
            }
        }
        return true;
    }

    public boolean accessChapterInBookTOC() {
		if (webDriver.findElement ( By.cssSelector ( BookDetailsLocators.CHAPTER_LIST_CONTAINER.get ( ) ) ).isDisplayed ( )) {
			System.out.println ( "Chapter list is visible" );
			WebElement accessChapterInBookTOC = webDriver.findElement ( By.cssSelector ( BookDetailsLocators.SINGLE_CHAPTER.getWithParams ( 1 ) ) );
			if (accessChapterInBookTOC.isDisplayed ( )) {
				tap (accessChapterInBookTOC);
				return true;
			}
		}try {
			Thread.sleep ( 1000);
		} catch (InterruptedException e) {
			e.printStackTrace ( );
		}
		return false;
	}


    public boolean downloadSingleChapter() {
		if (webDriver.findElement (By.cssSelector (BookDetailsLocators.CHAPTER_LIST_CONTAINER.get ( ) ) ).isDisplayed ( ) &&
		  webDriver.findElement ( By.cssSelector ( BookDetailsLocators.DOWNLOAD_ICON.get ( ) ) ).isDisplayed ( )) {
			System.out.println ( "Entered into download chapters" );
			System.out.println ( webDriver.findElement ( By.cssSelector ( BookDetailsLocators.SINGLE_CHAPTER.getWithParams ( 1 ) ) ).getText ( ) );
			//WebElement downloadIcon = webDriver.findElement ( By.cssSelector ( BookDetailsLocators.DOWNLOAD_SINGLE_CHAPTER.getWithParams ( 1 ) ) );
			((JavascriptExecutor) webDriver).executeScript ( "$($(\"div.chapter-list-wrapper div.chapter-list-item:nth-child(1) span.download-chapter\")).trigger(\"touchend\")" );
			return true;
		}
		return false;
	}


    public boolean accessDownloadedChapter() {
        if (webDriver.findElement(By.cssSelector(BookDetailsLocators.OPEN_BTNS.getWithParams(1))).isDisplayed()) {
            WebElement openBtn = webDriver.findElement (By.cssSelector (BookDetailsLocators.OPEN_BTNS.getWithParams ( 1 ) ) );
            tap ( openBtn );
            try {
                Thread.sleep ( 1000 );
            } catch (InterruptedException e) {
                e.printStackTrace ( );
            }
            return true;
        }
        if (webDriver.findElement(By.cssSelector(BookDetailsLocators.CHAPTER_CONTAINER.get())).isDisplayed()) {
            System.out.println("Chapter sections page appear");
        }
        return false;
    }

    public boolean fullBookDownload() {
        try {
            Thread.sleep ( 1000 );
        } catch (InterruptedException e) {
            e.printStackTrace ( );
        }
        try {
            WebElement FullBookDownloadBtn = webDriver.findElement(By.id (BookDetailsLocators.DOWNLOAD_FULL_BOOK_BTN.get ()));
            if (FullBookDownloadBtn.isDisplayed ()) {
                System.out.println ("Download full book btn appears");
                tap (FullBookDownloadBtn);
                try {
                    Thread.sleep ( 1000 );
                } catch (InterruptedException e) {
                    e.printStackTrace ( );
                }
                return true;
            }
        }catch(Exception e) {
            e.printStackTrace ();
        }
        return false;
    }


    public boolean verifyRecentReadPage() {
    	selectRightMenu();
    	tapRecentReadMenu ();
        try {
            Thread.sleep ( 1000 );
        } catch (InterruptedException e) {
            e.printStackTrace ( );
        }
        if (webDriver.findElement (By.cssSelector ( BookDetailsLocators.RECENT_READ_PAGE.get())).isDisplayed ( )) {
            if (webDriver.findElement ( By.id ( BookDetailsLocators.RECENT_HEADER_TEXT.get())).getText ().equals ("Recent Read")) {
                System.out.println ( "Recent Read page appear" );
                if (webDriver.findElement ( By.cssSelector ( BookDetailsLocators.SELECT_BOOK.getWithParams (1))).isDisplayed ( ) &&
                  webDriver.findElement ( By.cssSelector ( BookDetailsLocators.RECENT_READ_CONTAINER.get ( ) ) ).isDisplayed ( )) {
                    WebElement selectRecentReadBook = webDriver.findElement ( By.cssSelector ( BookDetailsLocators.SELECT_BOOK.getWithParams ( 1 ) ) );
                    tap ( selectRecentReadBook );
                    try {
                        Thread.sleep ( 1000 );
                    } catch (InterruptedException e) {
                        e.printStackTrace ( );
                    }
                    wait.until (ExpectedConditions.visibilityOfElementLocated (By.cssSelector(BookDetailsLocators.TOC_PAGE.get())));
                    System.out.println("Book details page appears");
                }
                return true;
            }
        }
        return false;
    }
}





