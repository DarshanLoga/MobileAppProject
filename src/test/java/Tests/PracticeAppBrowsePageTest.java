package Tests;

import Pages.BrowsePage;
import Pages.SignInPage;
import Tests.AbstractBaseTests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PracticeAppBrowsePageTest extends TestBase {
    
    private BrowsePage browsePage;
    
    public String getName() {
	return "BrowsePage";
    }
    
    @BeforeTest
    @Override
    public void setUpPage() {
	browsePage = new BrowsePage(driver);
    }
    
    @Test (priority = 3)
    public void verifyPracticeAppBrowsePage() {
        Assert.assertTrue (browsePage.verifyBrowsePage ());
    }
    
    @Test (priority = 4)
    public void verifyAndBrowseSubject() {
        Assert.assertTrue(browsePage.verifyAndSelectSubjects());
    }
    
    @Test (priority = 5)
    public void verifyAndBrowseSubjectStream() {
	Assert.assertTrue(browsePage.verifyStreamPage());
	Assert.assertTrue(browsePage.selectSubjectStream());
    }
    
    @Test (priority = 6)
    public void verifyAndBrowseSubjectTrack() {
	Assert.assertTrue(browsePage.verifyAndSelectSubjectTrack());
    }
    
    @Test (priority = 7)
    public void verifyAndBrowseSubjectConcept() {
	Assert.assertTrue(browsePage.verifyAndSelectSubjectConcept());
    }
    
    @Test (priority = 17)
    public void verifyAndSearchConcept(){
	Assert.assertTrue(browsePage.searchConcept ("Homogeneous Mixture"));
    }
    
    /*@Test (priority = 20)
    public void searchConceptInSubjectPage(){
	Assert.assertTrue(browsePage.searchConcept("Homogeneous Mixture"));
    }*/
}
