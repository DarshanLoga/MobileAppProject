package Tests;

import Pages.PracticeAppSettingsPage;
import Tests.AbstractBaseTests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PracticeAppSettingsPageTest extends TestBase {
    
    private PracticeAppSettingsPage practiceAppSettingsPage;
    
    public String getName () {
	return "PracticeAppSettingsPageTest";
    }
    
    @BeforeTest
    @Override
    public void setUpPage () {
	practiceAppSettingsPage = new PracticeAppSettingsPage(driver);
    }
    
    /*@Test (priority = 21)
    public void tapSettingsMenu() {
	Assert.assertTrue(practiceAppSettingsPage.verifyAccountSettingsPage());
    }
    
    @Test (priority = 22)
    public void createUserName() {
	Assert.assertTrue(practiceAppSettingsPage.createUserNameWithPassword());
    }
    
    @Test (priority = 23)
    public void changeCurrentPassword() {
	Assert.assertTrue(practiceAppSettingsPage.changeCurrentPasswordWithExistingPassword());
    }
    
    @Test (priority = 24)
    public void exitAccountSettingsPage() {
	Assert.assertTrue(practiceAppSettingsPage.exitSettingsPage());
    }*/
}
