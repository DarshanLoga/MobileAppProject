package FlexbookAppTest.AbstractBaseTests.FlexbookApp;

import io.appium.java_client.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.MessageFormat;

/**
 * Created by Karthick on 02/06/17.
 */
public class TutorialPage extends LandingPage {
    @Autowired
    LandingPage landingPage;

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
    public TutorialPage(AppiumDriver driver) {
        super( driver );
    }

    public enum TutorialPageLocators {
        TUTORIAL_PAGE("div.view-TutorialHomeView"), //css

        TUTORIAL_HDR_MSG("#tut_subject > div.row.collapse.tutorial-header-container > span"), //CSS
        //START_BROWSING_BTN(".thanks-container > input"), //CSS
        SUBJECT_MENU_ICON("#subjects-link"),  // CSS $("#subjects-link").trigger("touchend")


        TUTORIAL_BRANCH_CONTAINER("div.tutorial-branch-container"), //css
        START_BROWSING_BTN("div.thanks-container input"), //css

        ;
        private final String myLocator;

        TutorialPageLocators(String locator) {
            myLocator = locator;
        }

        public String get() {
            return myLocator;
        }
        public String getWithParams(Object... params) {
            return MessageFormat.format( myLocator, params );
        }
    }

    public boolean swipe(String direction, int offset, int time)  {
        switchToWebViewContext ("NATIVE_APP");
        int y = driver.manage().window().getSize().getHeight();
        int x = driver.manage().window().getSize().getWidth();
        TouchAction touchAction = new TouchAction(driver);
        System.out.println(x + " " + y);
        System.out.println("Entering swipe");
        if ("right".equalsIgnoreCase(direction)) {
            System.out.println("Swipe Right");
            touchAction.press(x - offset, y / 2).moveTo(-(x - (2 * offset)), 0).release().perform();
        } else if ("left".equalsIgnoreCase(direction)) {
            System.out.println("Swipe Left");
            touchAction.press(offset, y / 2).moveTo((x - (2 * offset)), 0).release().perform();
        } else if ("up".equalsIgnoreCase(direction)) {
            System.out.println("Swipe Up");
            touchAction.press(x / 2, offset).moveTo(0, y - (2 * offset)).release().perform();
        } else if ("down".equalsIgnoreCase(direction)) {
            System.out.println("Swipe Down");
            touchAction.press(x / 2, y - offset).moveTo(0, -(y - (2 * offset))).release().perform();
        } else {
            System.out.println("invalid direction");
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        switchToWebViewContext("WEBVIEW");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    // Verify the tutorial page
    public Boolean verifyTutorialPage() {
        try {
            Thread.sleep ( 3000);
        } catch (InterruptedException e) {
            e.printStackTrace ( );
        }
        if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(TutorialPageLocators.TUTORIAL_PAGE.get()))).isDisplayed() &&
          webDriver.findElement(By.cssSelector(TutorialPageLocators.TUTORIAL_HDR_MSG.get())).isDisplayed() &&
          webDriver.findElement(By.cssSelector(TutorialPageLocators.TUTORIAL_BRANCH_CONTAINER.get())).isDisplayed() &&
          webDriver.findElement(By.cssSelector(TutorialPageLocators.START_BROWSING_BTN.get())).isDisplayed()) {
            System.out.println("Verify the tutorial page");
              return true;
        }
        return false;
    }


    // Start browsing from the tutorial page
    public boolean startBrowsing() {
        try {
            Thread.sleep (2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement startBrowsing = driver.findElement(By.cssSelector(TutorialPageLocators.START_BROWSING_BTN.get()));
        if (startBrowsing.isDisplayed ()) {
            System.out.println("Element found");
            tap (startBrowsing);
            return true;
        }
        /*if (wait.until (ExpectedConditions.visibilityOfElementLocated (By.cssSelector (TutorialPageLocators.START_BROWSING_BTN.get()))).isDisplayed()) {
            System.out.println ("Element found");
            ((JavascriptExecutor) webDriver).executeScript ("$($(\"div.thanks-container input\")).trigger(\"touchend\")");
            return true;
        }*/
        try {
            Thread.sleep ( 2000);
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        return false;
    }

}


