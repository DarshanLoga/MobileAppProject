package FlexbookAppTest.AbstractBaseTests.FlexbookApp;

import FlexbookAppTest.AbstractBaseTests.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.MessageFormat;
import java.util.List;
import java.util.Set;

//import org.apache.tools.ant.taskdefs.Java;
//import org.openqa.selenium.interactions.internal.TouchAction;


/**
 * Created by Karthick on 02/06/17.
 */
public class LandingPage extends BasePage {
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
    public LandingPage(AppiumDriver driver) {
    	super(driver);
    }

    public enum LandingPageLocators {
        //Launcher Page
        TOU_POPUP("popup-msg-parent"), //ID
        POPUP_DISMISS("popup_modal_dismiss"), //ID
        //CK12_LOGO(".logo-img.large"), //CSS
        CK12_LOGO("className=logo-image"),
        ANIMATION_IMG(".background-app"), //CSS
        LANDINGPAGE_MSG(".firstPage-msg"), //CSS
        GET_STARTED(".sigin-btn-cnt input"), //CSS


        SIGN_IN_FORM(".signin-form-parent" ), //CSS
        SIGN_IN_HDR( ".signin-header span" ), //CSS
        SIGN_CLOSE_ICON(".close-signin"), //CSS
        SIGNIN_WITH_GOOGLE_BTN(".signin-googleplay.large"), //CSS
        USERNAME_TXT("usrname"), //id
        PASSWORD_TXT("#login-form > input:nth-child(3)"), //css
        FORGOT_PASSWORD_LNK("forgot-pswd"), //ID
        SIGNIN_SUBMIT_BTN(".signin-submit"), //CSS
        //SIGNIN_SUBMIT_BTN("input[value='Sign In']"), //CSS
        SIGNUP_LINK(".signin-bottom"), //CSS
        SIGN_UP_TERMS(".signin-terms-content"), //CSS
        APP_VERSION("app_version"), //ID

        //SIGNUP
        SIGNUP_CLOSE_ICON(".close-signup"), //CSS
        HEADER_MSG(".header-msg"), //CSS
        FULLNAME_TXT("input.f-name.validated-input"), //CSS
        EMAIL_TXT(".email.validated-input.input-custom"), //CSS
        SIGNUP_PASSWORD_TXT("pswd-change"),//ID
        //DOB_TXT(".dob.po-relative"),
        //DOB_TXT("input[name=\"dob\"]"), //CSS
        SIGNUP_BTN("createUser"), //ID
        SIGNIN_LINK(".signup-bottom"), //CSS
        ;

        private final String myLocator;

        LandingPageLocators(String locator) {
            myLocator = locator;
        }

        public String get() {
            return myLocator;
        }

        public String getWithParams(Object... params) {
            return MessageFormat.format(myLocator, params);
        }
    }
    Object[] contextHandles = driver.getContextHandles().toArray();
    String webViewContent = (String) contextHandles[contextHandles.length - 1];
    WebDriver webDriver = (AppiumDriver) driver.context(webViewContent);
    WebDriverWait wait = new WebDriverWait(webDriver, 10000);
    JavascriptExecutor js = (JavascriptExecutor) webDriver;


    // Verify and click "Get started" button in the launcher page
    public boolean verifyLauncher() {
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        try {
			if (driver.findElement ( By.id ( "popup-msg-parent" ) ).isDisplayed ( )) {
				driver.findElement ( By.cssSelector ( "#popup_modal_dismiss" ) ).click ( );
			}
		}catch (Exception e) {
			System.out.println ( "Message popup doesn't appears" );
		}
		try {
    		Thread.sleep(2000);
    	} catch (InterruptedException e) {
    		e.printStackTrace();
    	}
    	if (webDriver.findElement(By.cssSelector(LandingPageLocators.GET_STARTED.get())).isDisplayed()){
    		System.out.println("Get Started button in the launcher page");
    		webDriver.findElement(By.cssSelector(LandingPageLocators.GET_STARTED.get())).click();
    		return true;
    	}
    	try {
    		Thread.sleep( 1000);
    	} catch (InterruptedException e) {
    		e.printStackTrace();
    	}
    	return false;
    }

    protected boolean isWebView() {
        boolean bWebView = false;
        driver.context("NATIVE_APP");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        List<WebElement> mList = driver
                .findElementsByClassName("android.webkit.WebView");
        if (mList.size() > 0) {
            System.out.println("Webview available");
            driver.context("WEBVIEW");
            bWebView = true;
        } else {
            System.out.println("Webview NOT available");
            // android_driver.context("NATIVE_APP");
        }

        return bWebView;
    }

    public boolean switchToWebViewContext(String context) {
        try {
            Thread.sleep( 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String toSwitch = "";
        // Switch to last web view context
        System.out.println( driver.getContext() );
        Set<String> contextNames = driver.getContextHandles();
        System.out.println( contextNames );
        for (String contextName : contextNames) {
            System.out.println( contextNames );
            if (contextName.contains(context)) {
                System.out.println("Trying to change the context app..." );
                toSwitch = contextName;
            }
        }
        driver.context(toSwitch);
        System.out.println("Switched to new context...." );
        System.out.println( driver.getContext());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }


    public boolean isAlertPresent(){
        try {
            Thread.sleep( 10000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try{
            Alert a = new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
            if(a!=null){
                System.out.println("Alert is present");
                System.out.print(driver.switchTo().alert().getText() );
                driver.switchTo().alert().accept();
                return true;
            }else{
                throw new Throwable();
            }
        }
        catch (Throwable e) {
            System.err.println("Alert isn't present!!");
            return false;
        }
    }

    public boolean tap(WebElement element) throws NumberFormatException {
        try {
            setCoefficient ( "FlexbookApp" );
            Point location = element.getLocation ( );
            Dimension size = element.getSize ( );
            int x = (int) (location.getX() + size.getWidth()/2.0) * Integer.parseInt(System.getProperty("xcoefficient"));
            int y = (int) (location.getY() + size.getHeight()/2.0) * Integer.parseInt(System.getProperty("ycoefficient")) +
              Integer.parseInt(System.getProperty("topDeviceBarSize"));
            TouchAction touchAction = new TouchAction ( driver );
            switchToWebViewContext("NATIVE_APP");
            touchAction.tap(x, y).perform();
            switchToWebViewContext("WEBVIEW");
            return true;
        }catch (Exception e){
            e.printStackTrace ();
        }
        return false;
    }

    public void setCoefficient(String appName) {
        if (System.getProperty ("xcoefficient") == "" && System.getProperty ("ycoefficient") == "") {
            if (appName.equals("PracticeApp")) {
                switchToWebViewContext("NATIVE_APP");
                int topDeviceBarSize = 0;
                if (driver.findElement(By.xpath ("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]")).isDisplayed()) {
                    topDeviceBarSize = webDriver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]")).getLocation().getY();
                }
                int nativeX = driver.manage().window().getSize().getWidth();
                int nativeY = driver.manage().window().getSize().getHeight() - topDeviceBarSize;

                switchToWebViewContext("WEBVIEW");
                double webX = driver.findElement(By.xpath("//body")).getSize().getWidth();
                double webY = driver.findElement(By.xpath("//body")).getSize().getHeight();

                int coeffX = (int) (nativeX / webX);
                int coeffY = (int) (nativeY / webY);

                System.setProperty("xcoefficient", Integer.toString (coeffX));
                System.setProperty("ycoefficient", Integer.toString (coeffY));
                System.setProperty("topDeviceBarSize", Integer.toString (topDeviceBarSize));
            }
        }
        else if(appName.equals("FlexbookApp")) {
            switchToWebViewContext ("NATIVE_APP");
            int topDeviceBarSize = 0;
            if (driver.findElement(By.xpath ("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]")).isDisplayed()) {
                topDeviceBarSize = webDriver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]")).getLocation().getY();
            }

            int nativeX = driver.manage().window().getSize().getWidth();
            int nativeY = driver.manage().window().getSize().getHeight() - topDeviceBarSize;

            switchToWebViewContext("WEBVIEW");
            double webX = driver.findElement(By.xpath("//body")).getSize().getWidth();
            double webY = driver.findElement(By.xpath("//body")).getSize().getHeight();

            int coeffX = (int) (nativeX / webX);
            int coeffY = (int) (nativeY / webY);

            System.setProperty("xcoefficient", Integer.toString (coeffX));
            System.setProperty("ycoefficient", Integer.toString (coeffY));
            System.setProperty("topDeviceBarSize", Integer.toString (topDeviceBarSize));
        }

    }

    public String getContext() {
        Set<String> contextNames = driver.getContextHandles();
        System.out.println("Context Name: "+contextNames);
        for(final String contextName : contextNames) {
            if (contextName.contains("WEBVIEW")) {
                driver.context(contextName);
                System.out.println("Context Name: "+contextName);
                return contextName;
            }
        }
        return null;
    }

    public boolean scrollDownPage() {
        for (int j = 0; j < 10; j++) {
            System.out.println ( "Scroll down the page count" + j );
            ((JavascriptExecutor) webDriver).executeScript ( "$($(\"div\")).animate({scrollTop:2000}, 'slow')" );
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean scrollUpPage() {
        for(int k=0; k<10; k++) {
            System.out.println("Scroll up the page count" +k);
            ((JavascriptExecutor) webDriver).executeScript("$($(\"div\")).animate({scrollTop:-2000}, 'slow')");
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }
}




