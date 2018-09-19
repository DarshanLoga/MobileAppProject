package FlexbookAppTest.Test_FlexbookApp;

import FlexbookAppTest.AbstractBaseTests.FlexbookApp.*;
import FlexbookAppTest.AbstractBaseTests.TestBase;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tests_SignUp extends TestBase {

	private SignUpPage signUpPage;


	@Override
	public String getName() {
		return "SignUpPage";
	}

	@BeforeTest
	@Override
	public void setUpPage() {
		System.out.println ( "Signup page" );
		//landingPage = new LandingPage ( driver );
		//signInPage = new SignInPage ( driver );
		signUpPage = new SignUpPage ( driver );
	}

	WebElement email = null;

	@Test(priority = 3)
	public void signUpAccount() {
		try {
			System.out.println("entering test 3");
			//signUpPage = new SignUpPage (driver);
			//Assert.assertTrue (landingPage.verifyLauncher ( ) );
			//Assert.assertTrue (signInPage.verifySignInPage());
			//Assert.assertTrue (signInPage.clickSignUp());
			Assert.assertTrue(signUpPage.signUPWithEmail ( "Flexbookuser" ) );
			Assert.assertTrue(signUpPage.verifysignUpCompletePage ( ) );
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
}

