package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class PracticeAppLandingPage extends BasePage {

    /**
     * The headline of the homepage
     */
    @AndroidFindBy(accessibility = "Homepage Headline")
    private WebElement headline;

    @FindBy(id="com.android.packageinstaller:id/permission_message")
    private WebElement permissionMessage;

    @FindBy(id="com.android.packageinstaller:id/permission_allow_button")
    private WebElement allowPermissionMessage;

    @FindBy(id ="messagePopupModal")
    private WebElement messageModalPopup;

    @FindBy(id ="popup_modal_dismiss")
    private WebElement dismissModalPopup;

    @FindBy(css = "a.sign-btn")
            private WebElement signinbtn;

    @FindBy(css = "span.join-btn-cont")
    private WebElement joinbtn;

    /**
     * the subheader of the homepage
     */
    @AndroidFindBy(id = "Homepage Subheader")
    private WebElement subheader;

    public PracticeAppLandingPage(AppiumDriver driver) {
        super(driver);
    }
    
    Object[] contextHandles = driver.getContextHandles().toArray();
    String webViewContent = (String) contextHandles[contextHandles.length - 1];
    WebDriver webDriver = (AppiumDriver) driver.context(webViewContent);
    WebDriverWait wait = new WebDriverWait(webDriver, 1000);

    /**
     *
     * @return the header text content
     */
    public String getHeadlineValue() {

        return headline.getText();
    }

    public boolean dismissPermissionPopup() {
        switchToWebViewContext("NATIVE_APP");
        if (permissionMessage.isDisplayed()) {
            allowPermissionMessage.click();
            switchToWebViewContext("WEBVIEW");
            try {
                Thread.sleep( 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                if (messageModalPopup.isDisplayed()) {
                    dismissModalPopup.click();
                }
            }catch(Exception e) {
                System.out.println( "Message modal popup doesn't appears..." );
            }
            return true;
        }
        return false;
    }

    public boolean verifySignInJoinBtnsInLauncherPage() {
        try {
            Thread.sleep( 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int retry =4;
        while (retry>0) {
            if (joinbtn.isDisplayed() && signinbtn.isDisplayed()) {
                System.out.println("Sign in & join buttons are appears");
                break;
            }
            retry--;
            try {
                Thread.sleep( 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public boolean clickJoinBtn() {
        joinbtn.click();
        try {
            Thread.sleep( 2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean clickSignInBtn() {
        signinbtn.click();
        return true;
    }

    /**
     *
     * @return the subheader text content
     */
    public String getSubheaderValue() {

        return subheader.getText();
    }

    public boolean switchToWebViewContext(String context) {
        try {
            Thread.sleep( 1000 );
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
    
    public boolean tap(WebElement element) throws NumberFormatException {
        try {
            setCoefficient ("PracticeApp" );
            Point location = element.getLocation ( );
            Dimension size = element.getSize ( );
            int x = (int) (location.getX() + size.getWidth()/2.0) * Integer.parseInt(System.getProperty("xcoefficient"));
            int y = (int) (location.getY() + size.getHeight()/2.0) * Integer.parseInt(System.getProperty("ycoefficient")) +
                Integer.parseInt(System.getProperty("topDeviceBarSize"));
            TouchAction touchAction = new TouchAction(driver);
            switchToWebViewContext("NATIVE_APP");
            touchAction.tap(x, y).perform();
            switchToWebViewContext("WEBVIEW_org.ck12.app.practice");
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
                    topDeviceBarSize = driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]")).getLocation().getY();
                }
                int nativeX = driver.manage().window().getSize().getWidth();
                int nativeY = driver.manage().window().getSize().getHeight() - topDeviceBarSize;
                
                switchToWebViewContext("WEBVIEW_org.ck12.app.practice");
                double webX = driver.findElement(By.xpath("//body")).getSize().getWidth();
                double webY = driver.findElement(By.xpath("//body")).getSize().getHeight();
                
                int coeffX = (int) (nativeX / webX);
                int coeffY = (int) (nativeY / webY);
                
                System.setProperty("xcoefficient", Integer.toString (coeffX));
                System.setProperty("ycoefficient", Integer.toString (coeffY));
                System.setProperty("topDeviceBarSize", Integer.toString (topDeviceBarSize));
            }
        }
    }
    
    public boolean accessElement(AndroidElement element) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Point center = element.getCenter();
        Dimension size = element.getSize();
        int height = size.getHeight();
        Point target = new Point(center.getX(), center.getY() + (int) (height));
        System.out.println("target is" +target);
        TouchAction touchAction = new TouchAction ( driver );
        switchToWebViewContext("NATIVE_APP");
        touchAction.tap(target.getX (), target.getY ()).perform();
        switchToWebViewContext("WEBVIEW");
        return true;
    }
}
