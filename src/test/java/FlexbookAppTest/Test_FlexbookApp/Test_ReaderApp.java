/*package FlexbookAppTest.Test_FlexbookApp;

import FlexbookAppTest.AbstractBaseTests.FlexbookApp.*;
import FlexbookAppTest.AbstractBaseTests.TestBase;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;*/

//import org.springframework.util.Assert;

 //Created by Karthick on 02/06/17.
/*public class Test_ReaderApp extends TestBase {
	 @Autowired
	 LandingPage landingPage;

	 @Autowired
	 SignInPage signInPage;

	 @Autowired
	 SignUpPage signUpPage;

	 @Autowired
	 TutorialPage tutorialPage;

	 @Autowired
	 ProfilePage profilePage;

	 @Autowired
	 BrowsePage browsePage;

	 @Autowired
	 BookDetails bookDetails;

	 @Autowired
	 ChapterSections sections;

	 @Autowired
	 SideMenu sideMenu;

	 @Autowired
	 AccountSettings accountSettings;

	 @Autowired
	 OfflineLibrary offlineLibrary;


	 @Override
	 public String getName() {
		 return null;
	 }

	 @BeforeTest
	 @Override
	 public void setUpPage() {
		 landingPage = new LandingPage ( driver );
		 signInPage = new SignInPage ( driver );
		 signUpPage = new SignUpPage ( driver );
		 tutorialPage = new TutorialPage ( driver );
		 profilePage = new ProfilePage ( driver );
		 browsePage = new BrowsePage ( driver );
		 bookDetails = new BookDetails ( driver );
		 sections = new ChapterSections ( driver );
		 sideMenu = new SideMenu ( driver );
		 accountSettings = new AccountSettings ( driver );
		 offlineLibrary = new OfflineLibrary ( driver );
	 }

	 WebElement email = null;

	 //@Test(groups = {"FlexbookApp"}, priority = 1)
	 // @Test(priority = 1, alwaysRun = true)
    /*public void verifyAppLaunch() throws InterruptedException {
        Assert.assertTrue ( landingPage.verifyLauncher());
    }

    //@Test(groups = {"FlexbookApp"}, priority = 2)
	@Test(priority = 2, alwaysRun = true)
    public void verifySignInPage() throws InterruptedException {
        Assert.assertTrue (signInPage.verifySignInPage ( ) );
    }

    //@Test(groups = {"FlexbookApp"}, priority = 3)
	@Test(priority = 3, alwaysRun = true)
    public void verifyFooterLinks() throws InterruptedException {
        Assert.assertTrue (signInPage.clickSignUp ( ) );
    }

    //@Test(groups = {"FlexbookApp"}, priority = 4)
	@Test(priority = 4, alwaysRun = true)
    public void verifySignUpPage() throws InterruptedException {
        Assert.assertTrue (signUpPage.signUPWithEmail ("Flexbookuser"));
        Assert.assertTrue (signUpPage.verifysignUpCompletePage ());
    }
*/
    /*@Test(groups = {"FlexbookApp"}, priority = 5)
    public void verifyOfflineLibraryPage() throws InterruptedException {
        Assert.assertTrue (offlineLibrary.verifyOfflineLibrary());
    }

    @Test(groups = {"FlexbookApp"}, priority6
    public void goToSubjectFromLibraryPage() throws InterruptedException {
        Assert.assertTrue (offlineLibrary.gotoBrowsePagefromLibrary());
    }

    @Test(groups = {"FlexbookApp"}, priority = 7)
    public void verifyAndSelectScieneSubject() throws InterruptedException {
        Assert.assertTrue ( browsePage.selectScienceSubject ( "Science" ) );
    }

    @Test(groups = {"FlexbookApp"}, priority = 8)
    public void verifyBookDetailsPage() throws InterruptedException {
        Assert.assertTrue ( bookDetails.verifybookTOCPage ());
        Assert.assertTrue (bookDetails.accessDownloadedChapters());
    }

    @Test(groups = {"FlexbookApp"}, priority = 9)
    public void verifyAndAccessChapters() throws InterruptedException {
        Assert.assertTrue(sections.accessChapterLinksThroughSideMenu());
    }

    @Test(groups = {"FlexbookApp"}, priority = 10)
    public void verifyAndSectionFromSidemenu() throws InterruptedException {
        Assert.assertTrue(sections.accessChapterSectionsThroughSideMenu());
    }

    @Test(groups = {"FlexbookApp"}, priority = 11)
    public void verifyAndDecreaseFontSize() throws InterruptedException {
        Assert.assertTrue ( sections.decreaseFontSize ( ) );
    }

    @Test(groups = {"FlexbookApp"}, priority = 12)
    public void verifyAndChangeFontStyle() throws InterruptedException {
        Assert.assertTrue (sections.changeFontStyle ());
    }

    @Test(groups = {"FlexbookApp"}, priority = 13)
    public void verifyAndChangeLineSpacing() throws InterruptedException {
        Assert.assertTrue ( sections.changeLineSpacing ( false, true ) );
    }

    @Test(groups = {"FlexbookApp"}, priority = 14)
    public void verifyAndChangeBackground() throws InterruptedException {
        Assert.assertTrue ( sections.changeBackground ( false, true ) );
    }

    @Test(groups = {"FlexbookApp"}, priority = 15)
    public void verifyBookCoverPage() throws InterruptedException {
        Assert.assertTrue (sections.gotoBookCoverPage ( ) );
    }

    @Test(groups = {"FlexbookApp"}, priority = 16)
    public void goToBrowsePage() throws InterruptedException {
        Assert.assertTrue (sideMenu.selectRightMenu());
        Assert.assertTrue (sideMenu.gotoSubjectPage ());
    }

    @Test(groups = {"FlexbookApp"}, priority = 17)
    public void verifyAndSelectMoreSubject() throws InterruptedException {
        Assert.assertTrue (browsePage.selectMoreSubject ( "More" ) );
    }

    @Test(groups = {"FlexbookApp"}, priority = 18)
    public void verifyAndFullBookDownload() throws InterruptedException {
        Assert.assertTrue ( bookDetails.verifybookTOCPage ());
        Assert.assertTrue(bookDetails.fullBookDownload());
    }

    @Test(groups = {"FlexbookApp"}, priority = 19)
    public void goToOfflinePage() throws InterruptedException {
        Assert.assertTrue(bookDetails.verifyRecentRead());
    }

    @Test(groups = {"FlexbookApp"}, priority = 20)
    public void verifyAndTapSettingsMenu() throws InterruptedException {
        Assert.assertTrue (sideMenu.selectRightMenu());
        Assert.assertTrue ( accountSettings.clickSettingsfromHamburgerMenu ( ) );
    }

    @Test(groups = {"FlexbookApp"}, priority = 21)
    public void verifyAccountSettingsPage() throws InterruptedException {
        Assert.assertTrue ( accountSettings.verifyAccountSettings ( ) );
    }

    @Test(groups = {"FlexbookApp"}, priority = 22)
    public void verifyAndChangePassword() throws InterruptedException {
        Assert.assertTrue ( accountSettings.changeCurrentPassword ( ) );
    }

    @Test(groups = {"FlexbookApp"}, priority = 23)
    public void verifyAndExitSettingsPage() throws InterruptedException {
        Assert.assertTrue (accountSettings.exitSettingsPage ( ) );
    }

    @Test(groups = {"FlexbookApp"}, priority = 24)
    public void VerifyAppSignOut() throws InterruptedException {
        Assert.assertTrue (sideMenu.selectRightMenu());
        Assert.assertTrue (sideMenu.performSignOut());
    }*/

	 //https://medium.com/@kokodede/continuous-testing-using-jenkins-and-aws-device-farm-d9d706f268bb

	 /*@Test(groups = {"FlexbookApp"}, priority = 1)
	 public void verifyNewUserSignUp() throws InterruptedException {
		 Assert.assertTrue ( landingPage.verifyLauncher ( ) );
		 Assert.assertTrue ( signInPage.verifySignInPage ( ) );
		 Assert.assertTrue ( signInPage.clickSignUp ( ) );
		 Assert.assertTrue ( signUpPage.signUPWithEmail ( "Flexbookuser" ) );
		 Assert.assertTrue ( signUpPage.verifysignUpCompletePage ( ) );
		 Assert.assertTrue ( profilePage.verifyProfilePage ( ) );
		 Assert.assertTrue ( profilePage.verifyUserName ( ) );
		 Assert.assertTrue ( profilePage.selectUserRole ( "teacher" ) );
		 Assert.assertTrue ( profilePage.clickNextBtn ( ) );
		 Assert.assertTrue ( profilePage.selectGrades ( ) );
		 Assert.assertTrue ( profilePage.clickNextBtn ( ) );
		 Assert.assertTrue ( profilePage.clickContinue ( ) );
		 Assert.assertTrue ( tutorialPage.verifyTutorialPage ( ) );
		 Assert.assertTrue ( tutorialPage.startBrowsing ( ) );
		 Assert.assertTrue ( browsePage.verifyBrowsePage ( ) );
		 Assert.assertTrue ( browsePage.selectSubject ( "Math" ) );
		 Assert.assertTrue ( browsePage.selectConcept ( "MAT.ARI" ) );
		 Assert.assertTrue ( browsePage.verifyBookBrowsePage ( ) );
		 Assert.assertTrue ( browsePage.verifyLanguageFilter ( ) );
		 Assert.assertTrue ( browsePage.selectLanguage ( ) );
		 Assert.assertTrue ( browsePage.verifyLevelFilter ( ) );
		 Assert.assertTrue ( browsePage.selectLevel ( ) );
		 Assert.assertTrue ( browsePage.verifyandSelectBook ( ) );
		 Assert.assertTrue ( bookDetails.verifyBookTOCPage ( ) );
		 Assert.assertTrue ( bookDetails.verifyBookMetaData ( ) );
		 //Assert.assertTrue (bookDetails.downloadSingleChapter());
		 Assert.assertTrue ( bookDetails.accessChapterInBookTOC ( ) );
		 Assert.assertTrue ( sections.verifyChapterTOCPage ( ) );
		 //Assert.assertTrue (sections.selectChapterSections (1));
		 Assert.assertTrue ( sections.accessChapterLinksThroughSideMenu ( ) );
		 Assert.assertTrue ( sections.accessChapterSectionsThroughSideMenu ( ) );
		 Assert.assertTrue ( sections.increaseFontSize ( ) );
		 Assert.assertTrue ( sections.changeBackground ( "Brown" ) );
		 Assert.assertTrue ( sections.changeFontStyle ( ) );
		 Assert.assertTrue ( sections.changeLineSpacing ( "Large" ) );
		 Assert.assertTrue ( sections.decreaseFontSize ( ) );
		 Assert.assertTrue ( sideMenu.tapCoverBookMenuInChapterSideMenu ( ) );
		 Assert.assertTrue ( sideMenu.tapAndGoToSettingsPage ( ) );
		 Assert.assertTrue ( accountSettings.verifyAccountSettings ( ) );
		 Assert.assertTrue ( accountSettings.createUserName ( ) );
		 Assert.assertTrue ( accountSettings.exitSettingsPage ( ) );
		 Assert.assertTrue ( sideMenu.tapAndGoToSubjectPage ( ) );
		 Assert.assertTrue ( sideMenu.signOutApp ( ) );
	 }
 }

		 /*Assert.assertTrue ( landingPage.verifyLauncher ( ) );
		 Assert.assertTrue ( signInPage.verifySignInPage ( ) );
		 Assert.assertTrue ( signInPage.signInWithExistingUser ( ) );
		 Assert.assertTrue ( offlineLibrary.verifyOfflineLibrary ( ) );
		 Assert.assertTrue ( offlineLibrary.verifyOfflineZeroState ( ) );
		 Assert.assertTrue ( browsePage.verifyBrowsePage ( ) );
		 Assert.assertTrue ( browsePage.selectSubject ( "Science" ) );
		 Assert.assertTrue ( browsePage.selectConcept ( "SCI.LSC" ) );
		 Assert.assertTrue ( browsePage.verifyBookBrowsePage ( ) );
		 Assert.assertTrue ( browsePage.verifyandSelectBook ( ) );
		 Assert.assertTrue ( bookDetails.verifyBookTOCPage ( ) );
		 Assert.assertTrue ( bookDetails.verifyBookMetaData ( ) );
		 Assert.assertTrue ( bookDetails.accessChapterInBookTOC ( ) );
		 Assert.assertTrue ( sections.verifyChapterTOCPage ( ) );
		 Assert.assertTrue ( sections.changeBackground ( "Brown" ) );
		 Assert.assertTrue ( sections.changeFontStyle ( ) );
		 Assert.assertTrue ( sections.changeLineSpacing ( "Large" ) );
		 Assert.assertTrue ( sideMenu.tapCoverBookMenuInChapterSideMenu ( ) );
		 Assert.assertTrue ( sideMenu.tapAndGoToSettingsPage ( ) );
		 Assert.assertTrue ( accountSettings.verifyAccountSettings ( ) );
		 Assert.assertTrue ( accountSettings.changeCurrentPassword ( ) );
		 Assert.assertTrue ( accountSettings.exitSettingsPage ( ) );
		 Assert.assertTrue ( bookDetails.verifyRecentReadPage ( ) );
		 Assert.assertTrue ( sideMenu.tapAndGoToSubjectPage ( ) );
		 Assert.assertTrue ( sideMenu.signOutApp ( ) );
	 }*/

