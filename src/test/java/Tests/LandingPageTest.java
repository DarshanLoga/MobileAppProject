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
    
    
    /*@Test (priority = 1)
    public void launcherPage () {
        Assert.assertTrue (practiceAppLandingPage.dismissPermissionPopup ());
        Assert.assertTrue (practiceAppLandingPage.verifySignInJoinBtnsInLauncherPage ());
        Assert.assertTrue (practiceAppLandingPage.clickJoinBtn ());
        //Assert.assertTrue(practiceAppLandingPage.clickSignInBtn());
        //Assert.assertTrue(signInPage.loginAsExistingUsers());
        Assert.assertTrue (signInPage.signUPWithEmail ("PracticeAppUser"));
        Assert.assertTrue (browsePage.verifyBrowsePage ());
        //Assert.assertTrue(browsePage.searchConcept ("Testing Hypotheses"));
        /*Assert.assertTrue(browsePage.searchConcept ("Homogeneous Mixture"));
        Assert.assertTrue (browsePage.verifyAndSelectSubjects ());
        Assert.assertTrue (browsePage.verifyStreamPage ());
        Assert.assertTrue (browsePage.selectSubjectStream ());
        Assert.assertTrue (browsePage.verifyAndSelectSubjectTrack ());
        Assert.assertTrue (browsePage.verifyAndSelectSubjectConcept ());
        Assert.assertTrue (practicePage.verifyPracticeCoverSheet ());
        String title = practicePage.getTestTitle ();
        //Assert.assertEquals ("Dividing by 9", title);
         Assert.assertEquals("Testing Hypotheses", title);
        //Assert.assertEquals("Homogeneous Mixture", title);
        Assert.assertTrue (practicePage.startPractice (true));
        Assert.assertTrue (practicePage.verifyPracticeTunnel ());
        Assert.assertTrue (practicePage.attemptPractice ("Get 10 Correct", 10, title));
        Assert.assertTrue (practicePage.verifyPracticeTunnel ());
        Assert.assertTrue (practicePage.verifyScratchpad ());
        Assert.assertTrue (practicePage.verifyImproveThisQuestionPopup ());
        Assert.assertTrue (practicePage.submitPractice ());
        Assert.assertTrue (practicePage.verifyPracticeReportsPage ());
        Assert.assertTrue (practicePage.verifyUserAttendedQuestionsAndDetails ());*/
    
        //Assert.assertTrue(practicePage.goToNextConceptCoverSheet ());
        //Assert.assertTrue(practiceAppSideMenuPage.verifyAndTapSideMenu ());
        //Assert.assertTrue(practiceAppSideMenuPage.verifyRightMenuItems ());
        //Assert.assertTrue(practiceAppSideMenuPage.tapSettingsMenu());
        //Assert.assertTrue(practiceAppSettingsPage.verifyAccountSettingsPage ());
        //Assert.assertTrue(practiceAppSettingsPage.createUserNameWithPassword ());
        //Assert.assertTrue (practiceAppSettingsPage.changeCurrentPasswordWithExistingPassword ());
        //Assert.assertTrue (practiceAppSettingsPage.exitSettingsPage ());
        //Assert.assertTrue (practiceAppSideMenuPage.tapSubjectMenu ());*/
        /*Assert.assertTrue (browsePage.searchConcept ("Homogeneous Mixture"));
        Assert.assertTrue (practicePage.verifyPracticeCoverSheet ());
        String titles = practicePage.getTestTitle ();
        Assert.assertEquals ("Homogeneous Mixture", titles);
        Assert.assertTrue (practicePage.startPractice (true));
        Assert.assertTrue (practicePage.verifyPracticeTunnel ());
        Assert.assertTrue (practicePage.attemptPractice ("diagnose", 4, titles));
        Assert.assertTrue (practicePage.attenddiagnoseTest (2));
        Assert.assertTrue (practicePage.verifyRecommendationCompletePage ());
        Assert.assertTrue (practicePage.verifyAndAccessRecommendedModality ());
        Assert.assertTrue (practicePage.verifyEmbedModalityPopup ());
        Assert.assertTrue (practicePage.returnToPractice ());
        Assert.assertTrue (practicePage.verifyPracticeTunnel ());
        Assert.assertTrue (practicePage.submitPractice ());
        Assert.assertTrue (practicePage.verifyPracticeReportsPage ());
        Assert.assertTrue (practicePage.verifyUserAttendedQuestionsAndDetails ());
        //Assert.assertTrue(practicePage.keepPracticingFromReportsPage ());
        Assert.assertTrue (practiceAppSideMenuPage.signOutApp ());
        //Assert.assertTrue (practiceAppSideMenuPage.tapSubjectMenu ());
        /*Assert.assertTrue (browsePage.searchConcept ("Homogeneous Mixture"));
        //Assert.assertTrue(browsePage.searchConcept ("Testing Hypotheses"));
        Assert.assertTrue (practicePage.verifyPracticeCoverSheet ());
        String tile = practicePage.getTestTitle ();
        Assert.assertEquals ("Homogeneous Mixture", tile);
        Assert.assertTrue (practicePage.startPractice (true));
        Assert.assertTrue (practicePage.verifyPracticeTunnel ());
        Assert.assertTrue (practicePage.attemptPractice ("memoryboost", 10, tile));
        Assert.assertTrue (practicePage.verifyMemoryBoostQuestionsPopup ());
        Assert.assertTrue (practicePage.attendMemoryBoostQuestions (3));
        Assert.assertTrue (practicePage.stopPracticingFromSpacedPracticePopup ());
        Assert.assertTrue (practicePage.verifyPracticeReportsPage ());
        Assert.assertTrue (practicePage.verifyUserAttendedQuestionsAndDetails ());
        Assert.assertTrue (practiceAppSideMenuPage.signOutApp ());*/
    
    
