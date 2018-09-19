package FlexbookAppTest.Test_FlexbookApp;

import FlexbookAppTest.AbstractBaseTests.FlexbookApp.*;
import FlexbookAppTest.AbstractBaseTests.TestBase;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Tests_SignIn extends TestBase {
	private SignInPage signInPage;


	@Override
	public String getName() {
		return "SignInPage";
	}

	@BeforeTest
	@Override
	public void setUpPage() {
		System.out.println("Signin page");
		signInPage = new SignInPage(driver);
		System.out.println("Before test testng method");
	}


	@Test(priority = 2)
	public void verifySignIn() {
		try {
			System.out.println("entering test 2");
			Assert.assertTrue(signInPage.verifySignInPage());
			Assert.assertTrue(signInPage.clickSignUp());
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
}
