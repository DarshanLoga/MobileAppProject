package Tests;

import Pages.PracticeAppSideMenuPage;
import Pages.PracticePage;
import Tests.AbstractBaseTests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PracticeAppSideMenuTest extends TestBase {
    
    private PracticeAppSideMenuPage practiceAppSideMenuPage;
    
    public String getName () {
	return "PracticeAppSideMenuPage";
    }
    
    @BeforeTest
    @Override
    public void setUpPage () {
	practiceAppSideMenuPage = new PracticeAppSideMenuPage(driver);
    }
    
    @Test (priority = 15)
    public void verifyAndTapSideMenu() {
	Assert.assertTrue(practiceAppSideMenuPage.verifyAndTapSideMenu());
	Assert.assertTrue(practiceAppSideMenuPage.verifyRightMenuItems());
    }
    
    @Test (priority = 16)
    public void tapSubjectMenu() {
	Assert.assertTrue(practiceAppSideMenuPage.tapSubjectMenu());
    }
    
    /*@Test (priority = 19)
    public void tapSideMenuInPracticeReportsPage() {
	Assert.assertTrue(practiceAppSideMenuPage.verifyAndTapSideMenu());
	Assert.assertTrue(practiceAppSideMenuPage.verifyRightMenuItems());
    }*/
    
    /*@Test (priority = 20)
    public void tapSettingsMenu() {
	Assert.assertTrue(practiceAppSideMenuPage.tapSettingsMenu());
    }*/
    
    @Test (priority = 19)
    public void tapSubjectMenuInPracticeReportPage() {
	Assert.assertTrue(practiceAppSideMenuPage.verifyAndTapSideMenu());
	Assert.assertTrue(practiceAppSideMenuPage.verifyRightMenuItems());
	Assert.assertTrue(practiceAppSideMenuPage.tapSubjectMenu());
    }
    
    @Test (priority = 20)
    public void signoutApp(){
	Assert.assertTrue(practiceAppSideMenuPage.signOutApp());
    }
}
