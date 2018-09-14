package Tests;

import Pages.BrowsePage;
import Pages.PracticePage;
import Tests.AbstractBaseTests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PracticeAppPracticeTestPage extends TestBase {
    
    private PracticePage practicePage;
    
    public String getName () {
	return "PracticePage";
    }
    
    @BeforeTest
    @Override
    public void setUpPage () {
	practicePage = new PracticePage (driver);
    }
    
    @Test (priority = 8)
    public void verifyPracticeCoverSheetPage () {
	Assert.assertTrue (practicePage.verifyPracticeCoverSheet ());
    }
    
    @Test (priority = 9)
    public void attendPracticeAndReachGoal () {
	String title = practicePage.getTestTitle ();
	Assert.assertEquals ("Dividing by 9", title);
	Assert.assertTrue (practicePage.startPractice (true));
	Assert.assertTrue (practicePage.verifyPracticeTunnel ());
	Assert.assertTrue (practicePage.attemptPractice ("Get 10 Correct", 10, title));
    }
    
    @Test (priority = 10)
    public void verifyAndAccessScratchpad () {
	Assert.assertTrue (practicePage.verifyPracticeTunnel ());
	Assert.assertTrue(practicePage.verifyScratchpad());
    }
    
    @Test (priority = 11)
    public void verifyAndReportQuestionError () {
	Assert.assertTrue(practicePage.verifyImproveThisQuestionPopup ());
    }
    
    @Test (priority = 12)
    public void submitPractice() {
	Assert.assertTrue(practicePage.submitPractice());
    }
    
    @Test (priority = 13)
    public void verifyPracticeReportsPage() {
	Assert.assertTrue(practicePage.verifyPracticeReportsPage ());
	Assert.assertTrue(practicePage.verifyUserAttendedQuestionsAndDetails());
    }
    
    @Test (priority = 14)
    public void verifyAndAccessNextConceptFromReportsPage() {
	Assert.assertTrue(practicePage.goToNextConceptCoverSheet ());
    }
    
    @Test (priority = 18)
    public void attendDiagnoseTestPractice(){
	Assert.assertTrue (practicePage.verifyPracticeCoverSheet ());
	String titles = practicePage.getTestTitle ();
	Assert.assertEquals("Homogeneous Mixture", titles);
	Assert.assertTrue (practicePage.startPractice (true));
	Assert.assertTrue (practicePage.verifyPracticeTunnel ());
	Assert.assertTrue(practicePage.attemptPractice ("diagnose", 4, titles));
	Assert.assertTrue(practicePage.attenddiagnoseTest(2));
	Assert.assertTrue(practicePage.verifyRecommendationCompletePage());
	Assert.assertTrue(practicePage.verifyAndAccessRecommendedModality());
	Assert.assertTrue(practicePage.verifyEmbedModalityPopup());
	Assert.assertTrue(practicePage.returnToPractice());
	Assert.assertTrue(practicePage.verifyPracticeTunnel());
	Assert.assertTrue(practicePage.submitPractice());
	Assert.assertTrue(practicePage.verifyPracticeReportsPage ());
	Assert.assertTrue(practicePage.verifyUserAttendedQuestionsAndDetails());
    }
    
    /*@Test (priority = 21)
    public void attendSpacedPractice(){
	Assert.assertTrue (practicePage.verifyPracticeCoverSheet ());
	String tile = practicePage.getTestTitle ();
	Assert.assertEquals("Homogeneous Mixture", tile);
	Assert.assertTrue(practicePage.startPractice(true));
	Assert.assertTrue(practicePage.verifyPracticeTunnel());
	Assert.assertTrue(practicePage.attemptPractice ("memoryboost", 10, tile));
	Assert.assertTrue(practicePage.verifyMemoryBoostQuestionsPopup ());
	Assert.assertTrue(practicePage.attendMemoryBoostQuestions (3));
	Assert.assertTrue(practicePage.stopPracticingFromSpacedPracticePopup());
	Assert.assertTrue(practicePage.verifyPracticeReportsPage ());
	Assert.assertTrue(practicePage.verifyUserAttendedQuestionsAndDetails());
    }*/
}
