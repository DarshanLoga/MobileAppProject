package FlexbookAppTest.AbstractBaseTests.FlexbookApp;

import FlexbookAppTest.AbstractBaseTests.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.MessageFormat;
import java.util.UUID;

/**
 * Created by Karthick on 02/06/17.
 */
public class SignUpPage extends LandingPage {
	@Autowired
	LandingPage landingPage;
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
     */
    public SignUpPage(AppiumDriver driver) {
        super(driver);
    }

    public enum SignUpPageLocators {
        //SIGNUP
        SIGNUP_CLOSE_ICON(".close-signup"), //CSS
        HEADER_MSG(".header-msg"), //CSS
        FULLNAME_TXT("input.f-name.validated-input"), //CSS
        EMAIL_TXT(".email.validated-input.input-custom"), //CSS
        SIGNUP_PASSWORD_TXT("pswd-change"),//ID
        SIGNUP_BTN("createUser"), //ID
        SIGNIN_LINK(".signup-bottom"), //CSS
        SIGNUP_LINK(".signin-bottom"), //CSS
		DOB_TXT(".dob.po-relative"),

        PROFILE_BUILDER("profileBuilder"), //ID
        SIGNUP_COMPLETE_MSG(".firstTopTitle"), //CSS
        OK_GOT_IT_BTN("thankYou-okayButton"), //ID
        ;
        private final String myLocator;

        SignUpPageLocators(String locator) {
            myLocator = locator;
        }

        public String get() {
            return myLocator;
        }

        public String getWithParams(Object... params) {
            return MessageFormat.format( myLocator, params );
        }
    }

    // Verify the signup page after coming back from the signin page
    public boolean verifySignUpPage() {
		try {
			Thread.sleep ( 2000);
		} catch (InterruptedException e) {
			e.printStackTrace ( );
		}
		if (webDriver.findElement(By.cssSelector(SignUpPageLocators.SIGNUP_CLOSE_ICON.get())).isDisplayed() &&
			  webDriver.findElement(By.cssSelector(SignUpPageLocators.SIGNIN_LINK.get())).isDisplayed()) {
				System.out.println("Signup page appears successfully");
				return true;
		}
		return false;
	}

	// Verify the signup fields and signup the account
    public boolean signUPWithEmail(String fullname) {
		try {
			Thread.sleep ( 1000);
		} catch (InterruptedException e) {
			e.printStackTrace ( );
		}
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(SignUpPageLocators.FULLNAME_TXT.get())));
        webDriver.findElement(By.cssSelector(SignUpPageLocators.FULLNAME_TXT.get())).sendKeys(fullname);
		try {
			if (webDriver.findElement(By.cssSelector(SignUpPageLocators.DOB_TXT.get())).isDisplayed()) {
				driver.executeScript( "arguments[0].setAttribute('value',arguments[1])",
				  webDriver.findElement (By.cssSelector(SignUpPageLocators.DOB_TXT.get())), "1999-09-12");
			}
		}catch(Exception e){
			System.out.println("DOB field not available in the signup form");
		}
        final String randomEmail = randomEmail();
        WebElement email = webDriver.findElement(By.cssSelector(SignUpPageLocators.EMAIL_TXT.get()));
        email.sendKeys(randomEmail);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignUpPageLocators.SIGNUP_PASSWORD_TXT.get())));
        webDriver.findElement(By.id(SignUpPageLocators.SIGNUP_PASSWORD_TXT.get())).sendKeys("111111");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignUpPageLocators.SIGNUP_BTN.get()))).isDisplayed();
        webDriver.findElement(By.id(SignUpPageLocators.SIGNUP_BTN.get())).click();
        try {
            Thread.sleep( 5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }
    private static String randomEmail() {
		return "ck12user-" + UUID.randomUUID().toString() + "@ck12.org";
    }

	// Verify the signup complete page
    public Boolean verifysignUpCompletePage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignUpPageLocators.PROFILE_BUILDER.get())));
        if (webDriver.findElement(By.id(SignUpPageLocators.PROFILE_BUILDER.get())).isDisplayed()) {
			System.out.println ( "Signup complete page appears" );
			WebElement thanks_msg = webDriver.findElement (By.cssSelector (SignUpPageLocators.SIGNUP_COMPLETE_MSG.get()));
			System.out.println (thanks_msg.getText());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (webDriver.findElement(By.id(SignUpPageLocators.OK_GOT_IT_BTN.get())).isDisplayed()) {
				((JavascriptExecutor) webDriver).executeScript("arguments[0].click();",
				  webDriver.findElement(By.id(SignUpPageLocators.OK_GOT_IT_BTN.get())));
				//webDriver.findElement(By.id(SignUpPageLocators.OK_GOT_IT_BTN.get())).click();
				return true;
			}
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return false;
    }

}

