package FlexbookAppTest.AbstractBaseTests.FlexbookApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;
import FlexbookAppTest.AbstractBaseTests.FlexbookApp.LandingPage;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import FlexbookAppTest.AbstractBaseTests.FlexbookApp.BookDetails;

/**
 * Created by Karthick on 02/06/17.
 */
public class BrowsePage extends LandingPage {
    @Autowired
    LandingPage landingPage;

    @Autowired
    BookDetails bookDetails;

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
    public BrowsePage(AppiumDriver driver) {
        super( driver );
    }

    public enum BrowsePageLocators {
        SUBJECT_PAGE("subjects-container"), //ID
        SUBJECT_HDR_TXT(".subject-header-title"), //CSS
        SELECT_SUBJECT("//div[@class=''subject-title'']/span[text()=''{0}'']"),
        //SELECT_SUBJECT("//div[@class=''subject-title'']/span[text()=''{0}'']"),
        RIGHT_MENU_ICON("div.pointer.side-reveal.menu-icon i"), //CSS  $("div.pointer.side-reveal.menu-icon i").trigger("mouseup")
        //SELECT_SUBJECT(".subject-title span({0})"), //CSS  $(".subject-title span")[0]
        SELECT_SUBJECT1("div[@class=''subject-title'']/span[text()=''{0}'']"),

        //Branch
        BRANCH_PAGE(".view-BranchView"), //CSS
        SUBJECT_TITLE("bookTitle"), //ID
        SELECT_BRANCH("div.small-9.large-9.columns.subject-title > a[data-encodedid=''{0}'']"),
        //SELECT_BRANCH("div[data-name={0}]") , //CSS
        //SELECT_BRANCH(".left.branch-wrapper span({0})"), // CSS $(".left.branch-wrapper span")[0] touchend

        //Book Browse Page
        BOOK_BROWSE_PAGE(".view-BranchBooksView"), //CSS
        //FILTER_CONTAINER(".filter-container"), //CSS
        LANG_FILTER("#language-filter-selector a.language-filter-label"),
        LEV_FILTER("#level-filter-selector a.level-filter-label"),
        //LANGUAGE_FILTER(".language-filter-container"), //CSS  $(".language-filter-container").trigger("touchend")
        SELECT_LANGUAGE_DROPDOWN("language-filter-dropdown"), //ID $("#language-filter-dropdown li:nth-child(2)").trigger("touchend")
        SELECT_LANGUAGE_FILTER("#language-filter-dropdown"), //css
        //LEVEL_FILTER(".level-filter-container"), //CSS  $(".level-filter-container").trigger("touchend")
        //LEVEL_FILTER_DROPDOWN("level-filter-dropdown"), //ID
        SELECT_LEVEL_FILTER("#level-filter-dropdown"), //CSS $("li.js-level-filter-level:nth-child(2)").trigger("touchend")
        //BOOK_CONTAINER(".book-container"), //CSS
        MIDDLE_SCHOOL_TXT(".ms-title"), //CSS
        HIGH_SCHOOL_TXT(".hs-title"), //CSS
        //SELECT_BOOK(".js-ms-eng-book-container ul > li:nth-child({0})") , //CSS $(".js-ms-eng-book-container ul > li:nth-child(1)").trigger("touchend")
        BOOK_UNAVAILABLE_MSG("div.row.collapse.all-books-container > div > div > span"), //CSS

        BOOK_CONTAINER("div.book-container"),
        SELECT_BOOK("div.book-container li:nth-child({0}) div.book-meta div.book-title"), //CSS
        BOOK_TITLE("bookTitle"),

        FILTER_CONTAINER("div.filter-container"),
        LANGUAGE_FILTER("#language-filter-selector > a"), // css
        LANGUAGE_FILTER_DROP_DOWN("language-filter-dropdown"), // id
        LANGUAGE_COUNT("#language-filter-dropdown li.js-language-filter-level"), // css
        SELECT_LANGUAGES("#language-filter-dropdown li.js-language-filter-level:nth-child({0})"), //css

        LEVEL_FILTER("level-filter-selector"), // id
        LEVEL_FILTER_DROP_DOWN("level-filter-dropdown"), //id
        LEVEL_COUNT("#level-filter-dropdown li.js-level-filter-level"), // css
        SELECT_LEVEL("#level-filter-dropdown li.js-level-filter-level:nth-child({0})"), // css
        ;

        private final String myLocator;

        BrowsePageLocators(String locator) {
            myLocator = locator;
        }

        public String get() {
            return myLocator;
        }
        public String getWithParams(Object... params) {
            return MessageFormat.format( myLocator, params );
        }
    }

    // Verify the app browse page
    public boolean verifyBrowsePage() {
        try {
            Thread.sleep( 4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BrowsePageLocators.SUBJECT_PAGE.get())));
        String[] subjects = {"Math", "Science", "More"};
        for (String subject: subjects) {
            if (!webDriver.findElement(By.xpath(BrowsePageLocators.SELECT_SUBJECT.getWithParams(subject))).isDisplayed()) {
                return false;
            }
        }
        System.out.println(webDriver.findElement(By.cssSelector(BrowsePageLocators.SUBJECT_HDR_TXT.get())).getText());
        return true;
    }

    // Select the subject from the browse page
    public boolean selectSubject(String subjectName) {
        WebElement subject = webDriver.findElement(By.xpath(BrowsePageLocators.SELECT_SUBJECT.getWithParams(subjectName)));
        if (subject.isDisplayed ()) {
            tap (subject);
            System.out.println("The selected subject name is" +subject);
            return true;
        }
        try {
            Thread.sleep( 2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Select the subject branch from the browse page
    public boolean selectConcept(String branchName) {
        String branchTitle = webDriver.findElement(By.id(BrowsePageLocators.SUBJECT_TITLE.get())).getText();
        System.out.println("The branch title is" +branchTitle);
        try {
        	WebElement selectBranch = webDriver.findElement (By.cssSelector (BrowsePageLocators.SELECT_BRANCH.getWithParams ( branchName ) ) );
			if (selectBranch.isDisplayed ( )) {
				System.out.println ("Subject branch found" );
				tap(selectBranch);
				System.out.println ("Subject branch selected successfully");
				try {
					Thread.sleep( 3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return true;
			}
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    // Verify the book browse page
    public boolean verifyBookBrowsePage() {
        wait.until( ExpectedConditions.visibilityOfElementLocated(By.cssSelector( BrowsePageLocators.BOOK_BROWSE_PAGE.get())));
        System.out.println(webDriver.findElement(By.id(BrowsePageLocators.SUBJECT_TITLE.get())).getText());
        try {
            Thread.sleep( 2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean verifyLanguageFilter() {
        try {
            WebElement languageFilter = webDriver.findElement ( By.cssSelector ( BrowsePageLocators.LANGUAGE_FILTER.get () ) );
            if (languageFilter.isDisplayed ( )) {
                System.out.println ( "Language filter available now" );
                tap ( languageFilter );
                System.out.println ( "language filter tapped successfully" );
                try {
                    Thread.sleep ( 2000 );
                } catch (InterruptedException e) {
                    e.printStackTrace ( );
                }
                return true;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean selectLanguage() {
        int i = 1;
        try {
            if (webDriver.findElement(By.id (BrowsePageLocators.LANGUAGE_FILTER_DROP_DOWN.get())).isDisplayed()) {
                WebElement languageFilterdropdown = driver.findElement ( By.id ( BrowsePageLocators.LANGUAGE_FILTER_DROP_DOWN.get ( ) ) );
                List<WebElement> languages = driver.findElements ( By.cssSelector ( BrowsePageLocators.LANGUAGE_COUNT.get ( ) ) );
                Random r = new Random ( );
                int randomlang = r.nextInt ( languages.size ( ) - 1 ) + 1;
                languages.get (randomlang );
                if (randomlang == i) {
                    tap ( languageFilterdropdown );
                } else {
                    tap (driver.findElement ( By.cssSelector ( BrowsePageLocators.SELECT_LANGUAGES.getWithParams ( randomlang ) ) ) );
                }
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace ( );
        }
        return false;
    }

    public boolean verifyLevelFilter() {
        try {
            Thread.sleep( 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (driver.findElement(By.cssSelector(BrowsePageLocators.FILTER_CONTAINER.get())).isDisplayed()
            && webDriver.findElement(By.id(BrowsePageLocators.LEVEL_FILTER.get())).isDisplayed()) {
            WebElement levelFilter = webDriver.findElement(By.id(BrowsePageLocators.LEVEL_FILTER.get()));
            System.out.println ( "Level fitler appears" );
            tap (levelFilter);
            try {
                Thread.sleep ( 1000 );
            } catch (InterruptedException e) {
                e.printStackTrace ( );
            }
            return true;
        }
        if (webDriver.findElement(By.id(BrowsePageLocators.LEVEL_FILTER_DROP_DOWN.get())).isDisplayed()) {
            System.out.println("Level filter dropdown appears");
        }
        return false;
    }

    public boolean selectLevel() {
        int i=1;
        if (webDriver.findElement(By.id(BrowsePageLocators.LEVEL_FILTER_DROP_DOWN.get())).isDisplayed()) {
            List<WebElement> levels = driver.findElements(By.cssSelector ( BrowsePageLocators.LEVEL_COUNT.get ( ) ) );
            Random l = new Random();
            int randomLevel = l.nextInt(levels.size () - 1) + 1;
            levels.get (randomLevel);
            if (randomLevel == i) {
                tap(webDriver.findElement(By.id(BrowsePageLocators.LEVEL_FILTER_DROP_DOWN.get())));
            }
            else {
                tap (webDriver.findElement(By.cssSelector(BrowsePageLocators.SELECT_LEVEL.getWithParams(randomLevel))));
            }
            return true;
        }
        return false;
    }

    public boolean verifyandSelectBook() {
        try {
            Thread.sleep ( 1000 );
        } catch (InterruptedException e) {
            e.printStackTrace ( );
        }
        if (webDriver.findElement(By.cssSelector(BrowsePageLocators.BOOK_CONTAINER.get())).isDisplayed()) {
            WebElement selectBook = webDriver.findElement(By.cssSelector(BrowsePageLocators.SELECT_BOOK.getWithParams(1)));
            if (selectBook.isDisplayed ()) {
                tap (selectBook);
                try {
                    Thread.sleep ( 1000 );
                } catch (InterruptedException e) {
                    e.printStackTrace ( );
                }
                return true;
            }
        }
        wait.until (ExpectedConditions.visibilityOfElementLocated(By.cssSelector(BookDetails.BookDetailsLocators.TOC_PAGE.get())));
        return false;
    }
}



