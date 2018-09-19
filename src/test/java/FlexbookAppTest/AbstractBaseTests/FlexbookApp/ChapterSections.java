package FlexbookAppTest.AbstractBaseTests.FlexbookApp;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.MessageFormat;

/**
 * Created by Karthick on 02/06/17.
 */
public class ChapterSections extends SideMenu {
    @Autowired
    LandingPage landingPage;

    @Autowired
    BookDetails bookDetails;
    private Dimension size;

    @Autowired
    SideMenu sideMenu;

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
    public ChapterSections(AppiumDriver driver) {
        super(driver);
    }


    public boolean verifyChapterTOCPage() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(SectionsPageLocators.CHAPTER_PAGE.get()))).isDisplayed();
		if (webDriver.findElement(By.cssSelector(SectionsPageLocators.CHAPTER_CONTAINER.get())).isDisplayed() &&
		  webDriver.findElement(By.cssSelector(SectionsPageLocators.CHAPTER_TITLE.get())).isDisplayed()) {
			System.out.println("Chapter TOC Page appears");
			return true;
		}
		return false;
	}

	public boolean selectChapterSections(int sectionIndex){
    	if (webDriver.findElement(By.cssSelector(SectionsPageLocators.CHAPTER_CONTAINER.get())).isDisplayed()) {
    		WebElement selectSection = webDriver.findElement(By.cssSelector(SectionsPageLocators.SELECT_SECTION.getWithParams(sectionIndex)));
    		if (selectSection.isDisplayed()) {
    			tap(selectSection);
    			System.out.println("Sections is selected successfully");
    			try {
    				Thread.sleep(1000);
    			} catch (InterruptedException e) {
    				e.printStackTrace();
    			}
    			return true;
    		}
		}
		return false;
	}

	public boolean accessChapterLinksThroughSideMenu() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//To refresh the page and disappear the customize popup
		tap(webDriver.findElement(By.cssSelector(SectionsPageLocators.SECTIONS_TITLE.getWithParams(1))));
		// Tap the side menu to view the chapter list
		selectRightMenu();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (webDriver.findElement(By.id(SectionsPageLocators.USER_INFO_MENU.get())).isDisplayed() &&
		  webDriver.findElement(By.cssSelector(SectionsPageLocators.LIBRARY_MENU_ICON_IN_CHAPTER_PAGE.get())).isDisplayed() &&
		  webDriver.findElement(By.cssSelector(SectionsPageLocators.COVER_MENU_ICON.get())).isDisplayed() &&
		  webDriver.findElement(By.cssSelector(SectionsPageLocators.ACCESS_CHAPTER_LINKS_FROM_HAMBURGER.get())).isDisplayed()) {
			System.out.println("Chapter links are visible in hamburger menu");
			double chapterIndex = Math.floor(Math.random() * 4);
			chapterIndex = chapterIndex + 6;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// Access the chapter links
			WebElement accessChapterLinkInSideMenu=webDriver.findElement(By.cssSelector(SectionsPageLocators.ACCESS_CHAPTER_LINKS_FROM_HAMBURGER.getWithParams(chapterIndex)));
			if (accessChapterLinkInSideMenu.isDisplayed()) {
				tap(accessChapterLinkInSideMenu);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Chapter list get expanded successfully");
				return true;
			}
		}
		return false;
	}

	public boolean accessChapterSectionsThroughSideMenu() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(SectionsPageLocators.ACCESS_CHAPTER_SECTIONS_FROM_HAMBURGER.get())));
		double sectionIndex = Math.floor(Math.random() * 4);
		sectionIndex = sectionIndex + 6;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement accessSectionLinkInSideMenu=webDriver.findElement(By.cssSelector(SectionsPageLocators.ACCESS_CHAPTER_SECTIONS_FROM_HAMBURGER.getWithParams(sectionIndex)));
		if (accessSectionLinkInSideMenu.isDisplayed()) {
			tap (accessSectionLinkInSideMenu);
			System.out.println("Chapter sections get expanded and clicked successfully");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(SectionsPageLocators.SECTIONS_PAGE.get())));
			System.out.println("Sections page appears....");
			return true;
		}
		return false;
	}

	public boolean verifyCustomizedPopupInSectionsPage() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement customizeIcon=webDriver.findElement(By.cssSelector(SectionsPageLocators.CUSTOMIZE_PAGE.get()));
		if (customizeIcon.isDisplayed()){
			tap(customizeIcon);
			System.out.println("Customized icon appear successfully");
			if (webDriver.findElement(By.cssSelector(SectionsPageLocators.CUSTOMIZE_ICON.get())).isDisplayed()){
				tap(webDriver.findElement(By.cssSelector(SectionsPageLocators.CUSTOMIZE_ICON.get())));
				System.out.println("Customized icon tapped successfully");
				if (webDriver.findElement(By.cssSelector(SectionsPageLocators.CUSTOMIZE_POPUP.get())).isDisplayed()){
					System.out.println("Customized popup appears");
					return true;
				}
			}
		}
		return false;
	}

	public boolean verifySectionsPage() {
		try {
			Thread.sleep (1000);
		} catch (InterruptedException e) {
			e.printStackTrace ();
		}
		if (webDriver.findElement(By.cssSelector (SectionsPageLocators.SECTIONS_PAGE.get())).isDisplayed()) {
			System.out.println("Sections page appears....");
			System.out.println(webDriver.findElement(By.cssSelector(SectionsPageLocators.SECTIONS_TITLE.getWithParams(2))).getText());
			return true;
		}
		return false;
	}


    public boolean accessNextChapterSectionLinks(){
    	try {
    		if (webDriver.findElement(By.cssSelector(SectionsPageLocators.NXT_SECTIONS.get())).isDisplayed()) {
    			tap(webDriver.findElement(By.cssSelector(SectionsPageLocators.NXT_SECTIONS.get())));
    			try {Thread.sleep(1000);
    			}catch (InterruptedException e) {
    				e.printStackTrace();
    			}
				verifySectionsPage();
    		}
    	}catch (Exception e) {
    		// click the prev section link
			accessPreviousChapterSectionLinks();
    	}
    	try {
    		Thread.sleep(1000);
    	} catch (InterruptedException e) {
    		e.printStackTrace();
    	}
        return true;
    }

    public boolean accessPreviousChapterSectionLinks() {
    	try {
    		if (webDriver.findElement(By.cssSelector(SectionsPageLocators.PREV_SECTIONS.get())).isDisplayed()) {
    			tap(webDriver.findElement(By.cssSelector(SectionsPageLocators.PREV_SECTIONS.get())));
    			try {
    				Thread.sleep(1000);
    			} catch (InterruptedException e) {
    				e.printStackTrace();
    			}
				verifySectionsPage();
    		}
    	}catch (Exception e) {
    		// click the next section link
			accessNextChapterSectionLinks();
    	}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        return true;
    }

    public boolean decreaseFontSize() {
		System.out.println ( "##############decreasefontsize###################" );
		//scroll down the page
		scrollDownPage ( );
		//call the customized method
		verifyCustomizedPopupInSectionsPage ( );
		wait.until ( ExpectedConditions.visibilityOfElementLocated(By.id (SectionsPageLocators.FONT_CHANAGE_DECREASE.get())));
		for (int i = 0; i < 9; i++) {
			System.out.println ( "The font decrease count" + i );
			//tap ( webDriver.findElement ( By.id ( SectionsPageLocators.FONT_CHANAGE_DECREASE.get ( ) ) ) );
			((JavascriptExecutor) webDriver).executeScript("$($(\"#sub\")).trigger(\"touchend\")");
		}
		System.out.println("font size decreases successfully");
		//To refresh the page and disappear the customize popup
		((JavascriptExecutor) webDriver).executeScript("$($(\".view-ChapterSectionView\")).trigger(\"mouseup\")");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//scroll up the page
		scrollUpPage();
		return true;
	}


    public boolean increaseFontSize() {
        System.out.println("##############increasefontsize###################");
        accessPreviousChapterSectionLinks();
        //scroll down the page
        scrollDownPage();
        //call the customized method
        verifyCustomizedPopupInSectionsPage ();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SectionsPageLocators.FONT_CHANGE_INCREASE.get())));
		for (int i = 0; i < 9; i++) {
			System.out.println ( "The font increase count" + i );
			//tap (webDriver.findElement(By.id(SectionsPageLocators.FONT_CHANGE_INCREASE.get())));
			((JavascriptExecutor) webDriver).executeScript("$($(\"#add\")).trigger(\"touchend\")");
		}
        System.out.println("font size increases successfully");
		//To refresh the page and disappear the customize popup
		((JavascriptExecutor) webDriver).executeScript("$($(\".view-ChapterSectionView\")).trigger(\"mouseup\")");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//Scroll up the page
		scrollUpPage();
        return true;
    }

    public boolean changeBackground(String backgroundColor) {
        System.out.println("##############change background###################");
        accessNextChapterSectionLinks();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Scroll down the page
         scrollDownPage();
        //call the customized method
        verifyCustomizedPopupInSectionsPage ();
        if (backgroundColor.equals("White")) {
        	if (webDriver.findElement(By.id(SectionsPageLocators.BACKGROUND_CHANGE_WHITE.get())).isDisplayed()) {
        		tap(webDriver.findElement(By.id(SectionsPageLocators.BACKGROUND_CHANGE_WHITE.get())));
			}
		}
		else if(backgroundColor.equals("Brown")) {
			if (webDriver.findElement(By.id(SectionsPageLocators.BACKGROUND_CHANGE_BROWN.get())).isDisplayed()) {
				tap(webDriver.findElement(By.id(SectionsPageLocators.BACKGROUND_CHANGE_BROWN.get())));
			}
		}
		else if(backgroundColor.equals("Black")) {
			if (webDriver.findElement(By.id(SectionsPageLocators.BACKGROUND_CHANGE_BLACK.get())).isDisplayed()) {
				tap(webDriver.findElement(By.id(SectionsPageLocators.BACKGROUND_CHANGE_BLACK.get())));
			}
		}
        //To refresh the page and disappear the customize popup
		((JavascriptExecutor) webDriver).executeScript("$($(\".view-ChapterSectionView\")).trigger(\"mouseup\")");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace ( );
        }
        //Scroll up the page
        scrollUpPage();
        return true;
    }


    public boolean changeFontStyle() {
        System.out.println("##############fontstyle###################");
        accessPreviousChapterSectionLinks();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //scroll down the page
        scrollDownPage();
        //call the customized method
        verifyCustomizedPopupInSectionsPage ();
        if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(SectionsPageLocators.FONT_WRAPPER.get()))).isDisplayed()) {
			tap ( webDriver.findElement ( By.cssSelector ( SectionsPageLocators.FONT_WRAPPER.get ( ) ) ) );
			if (webDriver.findElement ( By.cssSelector ( SectionsPageLocators.FONT_FAMILY_EDITOR.get ( ) ) ).isDisplayed ( )) {
				int fontType = (int) Math.floor ( Math.random ( ) * 3 );
				fontType = fontType + 1;
				tap ( webDriver.findElement ( By.cssSelector ( SectionsPageLocators.FONT_TYPE.getWithParams ( fontType ) ) ) );
				try {
					Thread.sleep ( 1000 );
				} catch (InterruptedException e) {
					e.printStackTrace ( );
				}
				if (webDriver.findElement ( By.cssSelector ( SectionsPageLocators.FONT_ICON_ARROW.get ( ) ) ).isDisplayed ( )) {
					tap (webDriver.findElement ( By.cssSelector ( SectionsPageLocators.FONT_ICON_ARROW.get ( ) ) ) );
					System.out.println ( "Chosen font style applied sucessfully" );
				}
			}
		}
        //To refresh the page and disappear the customize popup
		((JavascriptExecutor) webDriver).executeScript("$($(\".view-ChapterSectionView\")).trigger(\"mouseup\")");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        //scroll down the page
        scrollDownPage();
        return true;
    }

    public boolean changeLineSpacing(String lineSpace) {
        System.out.println("##############Linespace###################");
        accessNextChapterSectionLinks();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //scroll down the page
        scrollDownPage();
        //call the customized method
        verifyCustomizedPopupInSectionsPage ();
        if (lineSpace.equals ("Medium")) {
        	if (webDriver.findElement(By.cssSelector(SectionsPageLocators.LINE_SPACE_MEDIUM.get())).isDisplayed()){
        		tap(webDriver.findElement(By.cssSelector(SectionsPageLocators.LINE_SPACE_MEDIUM.get())));
			}
		}
		else if (lineSpace.equals ("Large")) {
			if (webDriver.findElement(By.cssSelector(SectionsPageLocators.LINE_SPACE_LARGE.get())).isDisplayed()){
				tap(webDriver.findElement(By.cssSelector(SectionsPageLocators.LINE_SPACE_LARGE.get())));
			}
		}
		else if (lineSpace.equals ("Small")) {
			if (webDriver.findElement(By.cssSelector(SectionsPageLocators.LINE_SPACE_SMALL.get())).isDisplayed()){
				tap(webDriver.findElement(By.cssSelector(SectionsPageLocators.LINE_SPACE_SMALL.get())));
			}
		}
        //To refresh the page and disappear the customize popup
		((JavascriptExecutor) webDriver).executeScript("$($(\".view-ChapterSectionView\")).trigger(\"mouseup\")");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		//Scroll up the page
		scrollUpPage();
        return true;
    }

    public enum SectionsPageLocators {
        CHAPTER_PAGE(".view-ChapterView"), //CSS
		CHAPTER_TITLE("div.chapter-container div.chapter-title"), //css
        CHAPTER_CONTAINER("div.chapter-container"), //CSS
		SECTION_TABLE("ul.section-table"), //css
		SELECT_SECTION("ul.section-table li:nth-child({0})"), //css
        CHAPTER_SECTIONS(".chapter-container li"), //CSS
        ACCESS_CHAPTER_SECTIONS(".chapter-container li:nth-child({0})"), //CSS $(".chapter-container li:nth-child(1)").trigger("touchend")
        PREV_SECTIONS(".arrow-icons.arrow-icon-prev"), //CSS $(".arrow-icons.arrow-icon-prev").trigger("touchend")
        NXT_SECTIONS(".arrow-icons.arrow-icon-next"), //CSS
        //CUSTOMIZE_ICON("#reader-app-customizer-placeholder > span"), //CSS  $(".reader-app-customizer-placeholder-text").trigger("touchend")
		CUSTOMIZE_PAGE("div.customizer-placeholder-parent"), //css
		CUSTOMIZE_ICON("#reader-app-customizer-placeholder > span"), //css
		CUSTOMIZE_POPUP("div.reader-customizer"), //css

        FONT_CHANAGE_DECREASE("sub"), // ID
        FONT_CHANGE_INCREASE("add"), //ID

        BACKGROUND_CONTAINER(".background-changer-parent"), //CSS
        BACKGROUND_CHANGE_WHITE("white"), //ID
        BACKGROUND_CHANGE_BROWN("brown"), //ID
        BACKGROUND_CHANGE_BLACK("black"), //ID

		//BACKGROUND_CHANGE_WHITE("css=span.background-changer-white"),
		//BACKGROUND_CHANGE_BROWN("css=span.background-changer-brown"),
		//BACKGROUND_CHANGE_BLACK("css=span.background-changer-black")

        //FONT_WRAPPER(".wrapper-dropdown"), //CSS $(".wrapper-dropdown").trigger("touchend")
		FONT_WRAPPER(".fontFamily-changer-parent .wrapper-dropdown" ), //css
		FONT_FAMILY_EDITOR(".font-family-editor" ), //css
		FONT_TYPE("ul#dropdown li:nth-child({0}) span" ), //css
		FONT_ICON_ARROW(".icon-arrow3_left.back-icon" ), //css
        //FONT_TYPE(".font-family-editor li:nth-child({0})"), //CSS $(".font-family-editor li:nth-child(1)").trigger("touchend") 1 - TYPE 2 - Droid-Sans 3- Droid-Serif 4 - PROXIMA NOVA
        SELECTED_FONT_TEXT("#dd > span"), //CSS
        LINE_SPACE_CONTAINER(".lineHeight-changer-parent"), //CSS
        LINE_SPACE_CONTAINER_LIST(".lineHeight-changer-parent span"), //CSS
        LINE_SPACE_SMALL(".lineHeight-changer-small"), //CSS
        LINE_SPACE_MEDIUM(".lineHeight-changer-medium"), //CSS
        LINE_SPACE_LARGE(".lineHeight-changer-large"), //CSS
        ACCESS_CHAPTER_LINKS_FROM_HAMBURGER(".icon-arrow3_right"), //CSS $(".icon-arrow3_right").trigger("mouseup")
		VIEW_CHAPTER_LINKS_FROM_HAMBURGER(".toc-item.ellipsis.chapter-links"),

        ACCESS_CHAPTER_SECTIONS_FROM_HAMBURGER(".toc-item.ellipsis.section-links"), //CSS $(".toc-item.ellipsis.section-links").trigger("mouseup")
		ACCESS_CHAPTER_SECTION_IN_SIDE_MENU("#userInfoMenu > li:nth-child({0}) a.section-links"), //css
		ACCESS_CHAPTER_IN_SIDE_MENU("#userInfoMenu > li:nth-child({0}) a.chapter-links"), //css
        //ACCESS_CHAPTER_LINK_FROM_MENU_ICON("li:nth-child({0}) > span > a.icon-arrow3_right"), //CSS  $("li:nth-child(7) > span > a.icon-arrow3_right").trigger("mouseup") STARTS FROM 5
        //ACCESS_SECTIONS_LINK_FROM_MENU_ICON("li:nth-child({0}) a"), //CSS  $("li:nth-child(7) > span > a.icon-arrow3_right").trigger("mouseup"
        //Hambuger menu
        COVER_MENU_ICON("#Cover-link"), //CSS $("#Cover-link").trigger("touchend")
		USER_INFO_MENU("userInfoMenu"), //ID
		LIBRARY_MENU_ICON_IN_CHAPTER_PAGE("#library-links > span"), //css
        SECTIONS_TITLE("div.chapter-title > span:nth-child({0})"), //CSS //2
        SECTIONS_PAGE(".view-ChapterSectionView"), //CSS

        ;
        private final String myLocator;

        SectionsPageLocators(String locator) {
            myLocator = locator;
        }

        public String get() {
            return myLocator;
        }

        public String getWithParams(Object... params) {
            return MessageFormat.format(myLocator, params);
        }
    }

}


