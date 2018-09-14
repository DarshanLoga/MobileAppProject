package Tests;

import Pages.BrowsePage;
import Pages.PracticeAppLandingPage;
import Pages.PracticePage;
import Pages.SignInPage;
import Tests.AbstractBaseTests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignInPageTest extends TestBase {
    
    private SignInPage signInPage;
    
    public String getName () {
	return "SignInPage";
    }
    
    @BeforeTest
    @Override
    public void setUpPage () {
	signInPage = new SignInPage (driver);
    }
    
    @Test (priority = 2)
    public void verifyAndSignUpAppAccount () {
	Assert.assertTrue (signInPage.signUPWithEmail ("PracticeAppUser"));
    }
}
