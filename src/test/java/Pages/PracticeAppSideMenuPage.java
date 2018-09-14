package Pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PracticeAppSideMenuPage extends PracticeAppLandingPage {
    
    @FindBy(css = "div.right-menu div.icon-more.right.icon-change:nth-of-type(1)")
    private WebElement rightMenuAndroid;
    
    @FindBy(css = "div.right-menu div.icon-more.right.icon-change:nth-of-type(2)")
    private WebElement rightMenuiOS;
    
    @FindBy(css = "a[title='Profile'] > img")
    private WebElement profileImage;
    
    @FindBy(css = "a[title='Profile'] > span")
    private WebElement profileUserName;
    
    @FindBy(css = "a[title='Summer Challenge'] > span.menu-item-title-app")
    private WebElement subjectLink;
    
    @FindBy(css = "a[title='My Assignments'] > span.menu-item-title-app")
    private WebElement assignmentLink;
    
    @FindBy(css = "a[title='Settings'] > span.menu-item-title-app")
    private WebElement settingsLink;
    
    @FindBy(css = "a[title='help'] > span.menu-item-title-app")
    private WebElement helpLink;
    
    @FindBy(css = "a[title='Sign out'] > span.menu-item-title-app")
    private WebElement signOutLink;
    
    
    public PracticeAppSideMenuPage (AppiumDriver driver) {
        super (driver);
    }
    
    public boolean verifyAndTapSideMenu() {
        try {
	    Thread.sleep (2000);
	} catch (InterruptedException e) {
	    e.printStackTrace ();
	}
	try {
            if (rightMenuAndroid.isDisplayed()) {
                System.out.println("Right menu for Android appears...");
                rightMenuAndroid.click();
		System.out.println("Right menu for Android tapped successfully...");
	    }
	    else if (rightMenuiOS.isDisplayed()) {
		System.out.println("Right menu for iOS appears...");
		rightMenuiOS.click();
		System.out.println("Right menu for iOS tapped successfully...");
	    }
	}catch (Exception e){
            e.printStackTrace ();
	}
	return true;
    }
    
    public boolean verifyRightMenuItems() {
	try {
	    Thread.sleep (1000);
	} catch (InterruptedException e) {
	    e.printStackTrace ();
	}
	if (profileImage.isDisplayed() && profileUserName.isDisplayed()
	    && subjectLink.isDisplayed() && assignmentLink.isDisplayed() &&
	    settingsLink.isDisplayed() && helpLink.isDisplayed() && signOutLink.isDisplayed()) {
	    System.out.println("Right menu items appears...");
	}
	return true;
    }
    
    public boolean tapSubjectMenu() {
        //verifyAndTapSideMenu();
        //verifyRightMenuItems();
        if (subjectLink.isDisplayed()) {
            subjectLink.click();
	    try {
		Thread.sleep (2000);
	    } catch (InterruptedException e) {
		e.printStackTrace ();
	    }
	    System.out.println("Subject menu tapped succesfully");
	    wait.until(ExpectedConditions.visibilityOfElementLocated
		(By.cssSelector("#subjects-container div.small-12.columns.assignments-subjects-container")));
	    System.out.println ("Browse page appears...");
	}
	return true;
    }
    
    public boolean signOutApp() {
        verifyAndTapSideMenu();
        verifyRightMenuItems();
        if (signOutLink.isDisplayed()) {
            signOutLink.click();
	    try {
		Thread.sleep (2000);
	    } catch (InterruptedException e) {
		e.printStackTrace ();
	    }
	    System.out.println("App Signout successfully...");
	    verifySignInJoinBtnsInLauncherPage();
	}
	return true;
    }
    
    public boolean tapSettingsMenu() {
	if (settingsLink.isDisplayed()) {
	    settingsLink.click();
	    try {
		Thread.sleep (2000);
	    } catch (InterruptedException e) {
		e.printStackTrace ();
	    }
	    System.out.println("Settings menu tapped succesfully");
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.page-title.show-small")));
	    System.out.println ("Account Settings page appears...");
	}
	return true;
    }
}
