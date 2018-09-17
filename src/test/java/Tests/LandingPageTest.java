package Tests;

import Pages.*;
import Tests.AbstractBaseTests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LandingPageTest extends TestBase {
    
    private PracticeAppLandingPage practiceAppLandingPage;
    
    private SignInPage signInPage;
    
    private BrowsePage browsePage;
    
    private PracticePage practicePage;
    
    private PracticeAppSideMenuPage practiceAppSideMenuPage;
    
    private PracticeAppSettingsPage practiceAppSettingsPage;
    
    public String getName () {
        return "PracticeAppLandingPage";
    }
    
    @BeforeTest
    @Override
    public void setUpPage () {
        System.out.println ("Enter into the landing page");
        practiceAppLandingPage = new PracticeAppLandingPage (driver);
        /*signInPage = new SignInPage (driver);
        browsePage = new BrowsePage (driver);
        practicePage = new PracticePage (driver);
        practiceAppSettingsPage = new PracticeAppSettingsPage (driver);
        practiceAppSideMenuPage = new PracticeAppSideMenuPage (driver);*/
    }
    
    
    @Test (priority = 1)
    public void ApplauncherPage() {
        Assert.assertTrue (practiceAppLandingPage.dismissPermissionPopup ());
        Assert.assertTrue (practiceAppLandingPage.verifySignInJoinBtnsInLauncherPage ());
        Assert.assertTrue (practiceAppLandingPage.clickJoinBtn ());
    }
}
    

    
    
