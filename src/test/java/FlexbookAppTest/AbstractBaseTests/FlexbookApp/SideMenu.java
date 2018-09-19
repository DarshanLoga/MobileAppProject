package FlexbookAppTest.AbstractBaseTests.FlexbookApp;

import FlexbookAppTest.AbstractBaseTests.FlexbookApp.BookDetails.BookDetailsLocators;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;
import FlexbookAppTest.AbstractBaseTests.FlexbookApp.ChapterSections.SectionsPageLocators;
import FlexbookAppTest.AbstractBaseTests.FlexbookApp.LandingPage;
import sun.swing.SwingUtilities2;

import java.text.MessageFormat;

/**
 * Created by Karthick on 02/06/17.
 */
public class SideMenu extends TutorialPage {
    @Autowired
    LandingPage landingPage;

    @Autowired
    BrowsePage browsePage;

    @Autowired
    BookDetails bookDetails;

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
    public SideMenu(AppiumDriver driver) {
        super( driver );
    }

    public enum SideMenuPageLocators {
        RIGHT_MENU_ICON("div.pointer.side-reveal.menu-icon i"),
        LIBRARY_MENU_ICON("#library-link"), //CSS $("#library-link").trigger("touchend")
        LIBRARY_MENU_ICON_IN_BOOK_SECTION("#library-links"), //CSS
        RECENT_READ_ICON("#recent-read-link"), //CSS
		RECENTLY_READ_LNK("a[title=\"Recent Read\"] span.menu-item-title-app"), //css
        SETTINGS_MENU_ICON("#settings-link"), //CSS
        TUTORIAL_MENU_ICON("#tutorials-link"), //CSS
        SIGN_OUT_MENU_ICON("#sign-out-link"), //CSS
        SUBJECT_MENU_ICON("#subjects-link"), //CSS
        COVER_MENU_ICON("#Cover-link"), //CSS
        APP_VERSION("#app_version"), //ID
        ;
        private final String myLocator;

        SideMenuPageLocators(String locator) {
            myLocator = locator;
        }

        public String get() {
            return myLocator;
        }
        public String getWithParams(Object... params) {
            return MessageFormat.format( myLocator, params );
        }
    }

    public boolean signOutApp() {
		// Tap right menu
		selectRightMenu();
		try {
			Thread.sleep ( 2000 );
		} catch (InterruptedException e) {
			e.printStackTrace ( );
		}
		try {
			WebElement signOutApp = webDriver.findElement(By.cssSelector(SideMenuPageLocators.SIGN_OUT_MENU_ICON.get ( ) ) );
			if (signOutApp.isDisplayed ()) {
				System.out.println ("Signout menu appears");
				tap(signOutApp);
				System.out.println("Signout menu tapped successfully");
				try {
					Thread.sleep (1000);
				} catch (InterruptedException e) {
					e.printStackTrace ();
				}
				System.out.println("App signout successfully");
				return true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	public boolean selectRightMenu() {
		try {
			Thread.sleep ( 1000 );
		} catch (InterruptedException e) {
			e.printStackTrace ( );
		}
		try {
			WebElement rightMenuIcon = webDriver.findElement ( By.cssSelector ( SideMenuPageLocators.RIGHT_MENU_ICON.get ( ) ) );
			if (rightMenuIcon.isDisplayed ()) {
				System.out.println ("Right menu appears");
				tap(rightMenuIcon);
				System.out.println("Side menu tapped successfully");
				try {
					Thread.sleep (1000);
				} catch (InterruptedException e) {
					e.printStackTrace ();
				}
				return true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean tapAndGoToSettingsPage() {
    	// Tap right menu
		selectRightMenu();
		try {
			WebElement goToSettingsPage=webDriver.findElement(By.cssSelector(SideMenuPageLocators.SETTINGS_MENU_ICON.get()));
			if (goToSettingsPage.isDisplayed()) {
				System.out.println ("Settings menu appears");
				tap(goToSettingsPage);
				try {
					Thread.sleep ( 1000);
				} catch (InterruptedException e) {
					e.printStackTrace ( );
				}
				System.out.println("Settings menu tapped successfully");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector( AccountSettings.AccountSettingsPageLocators.SETTINGS_PAGE_HDR.get())));
		System.out.println("Settings page appears");
		return true;
	}

	public boolean tapRecentReadMenu() {
    	try {
    		WebElement recentReadMenu=webDriver.findElement(By.cssSelector(SideMenuPageLocators.RECENTLY_READ_LNK.get()));
    		if (recentReadMenu.isDisplayed()) {
    			System.out.println ("Recent Read menu appears");
    			tap(recentReadMenu);
				System.out.println("Recent read menu tapped successfully");
				try {
					Thread.sleep ( 1000);
				} catch (InterruptedException e) {
					e.printStackTrace ( );
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean tapCoverBookMenuInChapterSideMenu() {
		// Tap right menu
		selectRightMenu();
    	try {
    		WebElement coverBookMenu=webDriver.findElement(By.cssSelector( SectionsPageLocators.COVER_MENU_ICON.get()));
    		if (coverBookMenu.isDisplayed()) {
				System.out.println ("CoverBook menu appears");
				tap(coverBookMenu);
				System.out.println("Cover book menu tapped successfully");
				try {
					Thread.sleep ( 2000);
				} catch (InterruptedException e) {
					e.printStackTrace ( );
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		wait.until (ExpectedConditions.visibilityOfElementLocated(By.cssSelector(BookDetails.BookDetailsLocators.TOC_PAGE.get())));
		return true;
	}

	public boolean tapAndGoToSubjectPage() {
		// Tap right menu
		selectRightMenu();
    	try {
    		WebElement goToSubjectPage=webDriver.findElement(By.cssSelector(SideMenuPageLocators.SUBJECT_MENU_ICON.get()));
    		if(goToSubjectPage.isDisplayed()) {
				System.out.println ("Subject menu appears");
				tap(goToSubjectPage);
				System.out.println("Subject menu tapped successfully");
				try {
					Thread.sleep ( 1000);
				} catch (InterruptedException e) {
					e.printStackTrace ( );
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		wait.until( ExpectedConditions.visibilityOfElementLocated( By.id( BrowsePage.BrowsePageLocators.SUBJECT_PAGE.get())));
		System.out.println("Browse page appears");
		return true;
	}

	public boolean tapAndGoToTutorialPage() {
		try {
			WebElement goToTutorialPage=webDriver.findElement(By.cssSelector(SideMenuPageLocators.TUTORIAL_MENU_ICON.get()));
			if(goToTutorialPage.isDisplayed()) {
				System.out.println ("Tutorial menu appears");
				tap(goToTutorialPage);
				System.out.println("Tutorial menu tapped successfully");
				try {
					Thread.sleep ( 1000);
				} catch (InterruptedException e) {
					e.printStackTrace ( );
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(TutorialPageLocators.TUTORIAL_PAGE.get())));
		System.out.println("Tutorial page appears");
		return true;
	}

	public boolean tapAndGotoOfflineLibraryPage() {
		// Tap right menu
		selectRightMenu();
		try {
			WebElement goToLibraryPage=webDriver.findElement(By.cssSelector(SideMenuPageLocators.LIBRARY_MENU_ICON.get()));
			if(goToLibraryPage.isDisplayed()) {
				System.out.println ("Library menu appears");
				tap(goToLibraryPage);
				System.out.println("Library menu tapped successfully");
				try {
					Thread.sleep ( 1000);
				} catch (InterruptedException e) {
					e.printStackTrace ( );
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(OfflineLibrary.LibraryPageLocators.LIBRARY_PAGE.get())));
		System.out.println("Library page appears");
		return true;
	}
}


