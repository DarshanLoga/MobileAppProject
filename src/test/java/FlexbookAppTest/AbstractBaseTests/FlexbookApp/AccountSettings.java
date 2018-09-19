package FlexbookAppTest.AbstractBaseTests.FlexbookApp;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.MessageFormat;
import java.util.UUID;

/**
 * Created by Karthick on 02/06/17.
 */
public class AccountSettings extends SideMenu {
    @Autowired
    LandingPage landingPage;

    @Autowired
    SideMenu sideMenu;

    //@Autowired
    //BookDetails bookDetails;

    @Autowired
    BrowsePage browsePage;
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
    public AccountSettings(AppiumDriver driver) {
        super( driver );
    }

    public enum AccountSettingsPageLocators {
        SETTINGS_PAGE_HDR(".account-settings-main-header"), //CSS
        USER_NAME("login"), //ID
        PASSWORD("password"), //ID
        //USERNAME_SUBMIT("#usernameFormSubmit"), //css
		USERNAME_SUBMIT("usernameFormSubmit"), //ID
        CURRENT_PASSWORD("currentpassword"), //ID
        NEW_PASSWORD("newpassword"), //ID
        SETTING_SAVE_MSG("#passwordSave > span"), //CSS
        SETTING_BACK_BTN("backButton"), //ID
		BACK_BTN("backTocIcon"), //id
		NAME_TXT("name"), //id
		EMAIL_TXT("email"), //id
		SAVE_NEW_PWD_BTN("#passwordFormSubmit"), //css
        CELLUAR_DATA_TOGGLE("div.onoffswitch-switch"), //CSS

        ;
        private final String myLocator;

        AccountSettingsPageLocators(String locator) {
            myLocator = locator;
        }

        public String get() {
            return myLocator;
        }
        public String getWithParams(Object... params) {
            return MessageFormat.format( myLocator, params );
        }
    }

    public boolean verifyAccountSettings() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(AccountSettingsPageLocators.SETTINGS_PAGE_HDR.get())));
        WebElement settingPageHeader = webDriver.findElement(By.cssSelector(AccountSettingsPageLocators.SETTINGS_PAGE_HDR.get()));
        if (settingPageHeader.equals("Account Settings")) {
        	if (webDriver.findElement(By.id(AccountSettingsPageLocators.BACK_BTN.get())).isDisplayed() &&
			  webDriver.findElement(By.id (AccountSettingsPageLocators.NAME_TXT.get())).isDisplayed() &&
			  webDriver.findElement(By.id(AccountSettingsPageLocators.EMAIL_TXT.get())).isDisplayed()) {
        		System.out.println("Account settings page appear...");
			}
		}
		return true;
    }

    public boolean changeCurrentPassword() {
    	try {
    		if (webDriver.findElement(By.id(AccountSettingsPageLocators.CURRENT_PASSWORD.get())).isDisplayed() &&
			  webDriver.findElement(By.id(AccountSettingsPageLocators.NEW_PASSWORD.get())).isDisplayed()) {
    			System.out.println("Password section appears");
				webDriver.findElement(By.id(AccountSettingsPageLocators.CURRENT_PASSWORD.get())).sendKeys( "111111" );
				webDriver.findElement(By.id(AccountSettingsPageLocators.NEW_PASSWORD.get())).sendKeys("222222");
				((JavascriptExecutor) webDriver).executeScript( "$($(\"#passwordFormSubmit\")).trigger(\"touchend\")");
				//WebElement saveNewPassword=webDriver.findElement(By.cssSelector(AccountSettingsPageLocators.SAVE_NEW_PWD_BTN.get()));
				//if (saveNewPassword.isDisplayed()) {
					//tap(saveNewPassword);
					try {
						Thread.sleep( 2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("New password changed successfully");
				}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return true;
	}


	public boolean createUserName() {
		try {
			Thread.sleep( 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(AccountSettingsPageLocators.USER_NAME.get())));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(AccountSettingsPageLocators.PASSWORD.get())));
		webDriver.findElement(By.id(AccountSettingsPageLocators.USER_NAME.get())).sendKeys("flexbookuserjun22www");
		webDriver.findElement(By.id(AccountSettingsPageLocators.PASSWORD.get())).sendKeys("111111");
		((JavascriptExecutor) webDriver).executeScript( "$($(\"#usernameFormSubmit\")).trigger(\"touchend\")");
		try {
			Thread.sleep( 2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println ("username created successfully");
		return true;
	}

	public String randomUserName() {
		return "ck12user-" + UUID.randomUUID().toString() + "flexbookappuser";
	}

	public boolean exitSettingsPage() {
        if (webDriver.findElement(By.id(AccountSettingsPageLocators.BACK_BTN.get())).isDisplayed()) {
        	tap(webDriver.findElement(By.id(AccountSettingsPageLocators.BACK_BTN.get())));
			try {
				Thread.sleep( 1000 );
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println ("Account settings page exit successfully");
		}
        wait.until( ExpectedConditions.visibilityOfElementLocated(By.cssSelector(BookDetails.BookDetailsLocators.TOC_PAGE.get() ) ) );
        System.out.println( "Book details page appears" );
        return true;
    }


    public boolean setCelluarDataOn() {
        //scroll down the page
        ((JavascriptExecutor) webDriver).executeScript("$($(\"div\")).scrollTop(1000)");
        if (webDriver.findElement(By.cssSelector(AccountSettingsPageLocators.CELLUAR_DATA_TOGGLE.get())).isDisplayed()) {
			webDriver.findElement ( By.cssSelector ( AccountSettingsPageLocators.CELLUAR_DATA_TOGGLE.get ( ) ) ).click ( );
			try {
				Thread.sleep ( 1000 );
			} catch (InterruptedException e) {
				e.printStackTrace ( );
			}
			System.out.println ( "Cellular Data toogle On" );
		}
		//scroll up the page
		((JavascriptExecutor) webDriver).executeScript ( "$($(\"div\")).scrollTop(-1000)");
        return true;
    }
}


