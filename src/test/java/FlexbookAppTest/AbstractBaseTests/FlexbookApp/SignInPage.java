package FlexbookAppTest.AbstractBaseTests.FlexbookApp;

import com.sun.java.swing.plaf.windows.resources.windows;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.MessageFormat;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Karthick on 02/06/17.
 */
public class SignInPage extends LandingPage {
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
    public SignInPage(AppiumDriver driver) {
        super( driver );
    }

    public enum SignInPageLocators {
        //Sign In
        SIGN_IN_FORM(".signin-form-parent" ), //CSS
        SIGN_IN_HDR(".signin-header span" ), //CSS
        SIGN_CLOSE_ICON(".close-signin"), //CSS
        SIGNIN_WITH_GOOGLE_BTN(".signin-googleplay.large"), //CSS
        USERNAME_TXT(".email.validate-input"), //CSS
        PASSWORD_TXT("#login-form > input:nth-child(3)"), //css
        FORGOT_PASSWORD_LNK("forgot-pswd"), //ID
        SIGNIN_SUBMIT_BTN(".signin-submit"), //CSS
        //SIGNIN_SUBMIT_BTN("input[value='Sign In']"), //CSS
        SIGNUP_LINK(".signin-bottom"),
        SIGN_UP_TERMS(".signin-terms-content"), //CSS
        APP_VERSION("app_version"), //ID
        GOOGLE_SIGNIN(".signin-googleplay.large"), //CSS
        //EMAIL_INPUT_BOX("#identifierLink > div.vdE7Oc.f3GIQ > p"), //CSS
        GOOGLE_WINDOW("view_container"), //ID
        GOOGLE_EMAIL_INPUT("identifierId"), //id
        EMAIL_NXT_BTN("identifierIdNext"), //id
        PASSWORD_NXT_BTN("passwordNext"), //ID
        GOOGLE_PASSWORD("password"), //name
        ;
        private final String myLocator;

        SignInPageLocators(String locator) {
            myLocator = locator;
        }

        public String get() {
            return myLocator;
        }

        public String getWithParams(Object... params) {
            return MessageFormat.format( myLocator, params );
        }
    }

    // Verify the sign in page
    // Verify the footer, header part and google login button in the sign in page
    public boolean verifySignInPage() {
        wait.until( ExpectedConditions.visibilityOfElementLocated(By.cssSelector(SignInPageLocators.SIGN_IN_FORM.get())));
        if (webDriver.findElement(By.cssSelector(SignInPageLocators.SIGN_IN_FORM.get())).isDisplayed()){
            System.out.println("Sign in page appear");
            if (webDriver.findElement(By.cssSelector(SignInPageLocators.SIGN_IN_HDR.get())).getText().contains("Welcome")) {
                if (webDriver.findElement(By.cssSelector(SignInPageLocators.SIGN_UP_TERMS.get())).isDisplayed() &&
                        webDriver.findElement(By.cssSelector(SignInPageLocators.GOOGLE_SIGNIN.get())).isDisplayed()) {
                    System.out.println("Verified the footer and Google Button in the sign in page");
                    return true;
                }
            }
        }
        return false;
    }

    // Login with existing user.
    public boolean signInWithExistingUser() {
        try {
            Thread.sleep ( 1000);
        } catch (InterruptedException e) {
            e.printStackTrace ( );
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated (By.cssSelector (SignInPageLocators.USERNAME_TXT.get())));
        if (webDriver.findElement (By.cssSelector ( SignInPageLocators.USERNAME_TXT.get())).isDisplayed() &&
          webDriver.findElement(By.cssSelector ( SignInPageLocators.PASSWORD_TXT.get())).isDisplayed()) {
            System.out.println ("Username and password fields are verified");
            webDriver.findElement(By.cssSelector(SignInPageLocators.USERNAME_TXT.get())).sendKeys("flexbookuserjun14www");
            webDriver.findElement(By.cssSelector(SignInPageLocators.PASSWORD_TXT.get())).sendKeys("111111");
            webDriver.findElement(By.cssSelector(SignInPageLocators.SIGNIN_SUBMIT_BTN.get())).click();
            System.out.println("Login successfully");
            return true;
        }
        return false;
    }

    // Verify and click "signup" link, redirects to the signup page
    public boolean clickSignUp() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(SignInPageLocators.SIGNUP_LINK.get())));
        webDriver.findElement(By.cssSelector(SignInPageLocators.SIGNUP_LINK.get())).click();
        try {
            Thread.sleep ( 2000);
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        return true;
    }

    public boolean clickGoogleSignInButton() {
        //System.out.println(driver.getWindowHandles());
        setWindows ( driver );
        webDriver.findElement(By.cssSelector(SignInPageLocators.GOOGLE_SIGNIN.get())).click();
        return true;
    }

    private boolean setWindows(WebDriver driver) {
        HashSet<String> window = new HashSet<String>();
        driver.getWindowHandles().stream().forEach(n -> window.add(n));
        return true;
    }

    private String getWindow(WebDriver driver) {
        //List<String> newWindow = driver.getWindowHandles().stream().filter(n -> windows.contains(n) == false).collect( Collectors.toList());
        List<String> newWindow = (List<String>) driver.getWindowHandles();
        System.out.println(newWindow.get(0));
        return newWindow.get ( 0 );
    }
 }

