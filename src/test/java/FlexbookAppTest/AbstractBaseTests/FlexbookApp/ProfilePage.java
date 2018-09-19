package FlexbookAppTest.AbstractBaseTests.FlexbookApp;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.MessageFormat;

/**
 * Created by Karthick on 02/06/17.
 */
public class ProfilePage extends OfflineLibrary {
    @Autowired
    LandingPage landingPage;

    @Autowired
    SignUpPage signUpPage;

    /**
     * A base constructor that sets the page's driver
     * <p>
     * The page structure is being used within this test in order to separate the
     * page actions from the tests.
     * <p>
     * Please use the AppiumFieldDecorator class within the page
     * factory. This way annotations
     * like @AndroidFindBy within the page objects.
     *
     * @param driver the appium driver created in the beforesuite method.
     */
    public ProfilePage(AppiumDriver driver) {
        super( driver );
    }

    public enum ProfilePageLocators {
        //Profile Page
        USERNAME("userName"), //ID
        SELECT_ROLE(".role_container span"), //CSS
        ROLE_OPTIONS("roleOptions"), //ID
        SELECT_USER_ROLE("#roleOptions > div:nth-child({0})"), // CSS #roleOptions div:nth-child(2)
        SELECT_TEACHER_ROLE("roleOption-1"), //ID  TEACHER
        SELECT_STUDENT_ROLE("roleOption-2"), //ID STUDENT
		NEXT_BTN("button-continue"), //ID
        STATE_LOCATION(".js_location_select_link"), //CSS
        ZIP_CODE_INPUT_BOX("#usLocation"), //CSS .trigger(\"focus\")")

        LOCATION_CONTAINER("locationSelectionFormContainer"), //ID .js_location_select_link
        I_LIVE_OUTSIDE_US(".international-location-link"), //CSS
        I_LIVE_IN_THE_US(".us-location-link"), //CSS
        COUNTRY_TEXT_BOX("internationalLocation"), //ID
        COUNTRY_SUGGESTION_BOX("body > div:nth-child(10)"), //CSS
        //SELECT_COUNTRY(".pac-item:first"), // CSS
        GRADE_BOX(".grade_container"), //CSS
		GRADE_CONTAINER("gradeSelectionFormContainer"), //id
        //GRADE_CONTAINER("gradeSelectionFormContainer"), //ID
        SELECT_KINDERGARTEN_GRADE("#gradeSelectionForm > div.grades-row-2.row > div"), // CSS
        SELECT_NUMBER_GRADES1("#gradeSelectionForm > div.grades-row-3.row > div"), //CSS
        SELECT_NUMBER_GRADES2("#gradeSelectionForm > div.grades-row-4.row > div"), //CSS
        DONE_BTN(".next.tangerine.button"), //css //ID  continue_btn
        CONTINUE_BTN(".continue-btn"), //CSS

        ;
        private final String myLocator;

        ProfilePageLocators(String locator) {
            myLocator = locator;
        }

        public String get() {
            return myLocator;
        }
        public String getWithParams(Object... params) {
            return MessageFormat.format( myLocator, params );
        }
    }


    // Verify the profile builder page
    public Boolean verifyProfilePage() {
        try {
            Thread.sleep( 5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SignUpPage.SignUpPageLocators.PROFILE_BUILDER.get())));
        System.out.println("Profile page appear");
        return true;
    }

    // Verify the given username in the profile page
    public boolean verifyUserName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ProfilePageLocators.USERNAME.get())));
        System.out.println(webDriver.findElement(By.id(ProfilePageLocators.USERNAME.get())).getText());
        return true;
    }

    // Verify and click "Next" button to update the all profile details
	public boolean clickNextBtn() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ProfilePageLocators.NEXT_BTN.get())));
		webDriver.findElement(By.id(ProfilePageLocators.NEXT_BTN.get())).click();
		try {
			Thread.sleep( 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean clickContinue(){
		try {
			Thread.sleep( 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (webDriver.findElement(By.cssSelector(ProfilePageLocators.CONTINUE_BTN.get())).isDisplayed()) {
			webDriver.findElement(By.cssSelector(ProfilePageLocators.CONTINUE_BTN.get())).click();
			return true;
		}
		return false;
	}

    // Verify and select the grades
	public boolean selectGrades() {
		clickNextBtn();
		System.out.println("Enter into the method");
		try {
			Thread.sleep( 2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(webDriver.findElement(By.id(ProfilePageLocators.GRADE_CONTAINER.get())).isDisplayed()) {
			System.out.println("Grade box appears");
			if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ProfilePageLocators.SELECT_KINDERGARTEN_GRADE.get()))).isDisplayed()){
				webDriver.findElement(By.cssSelector(ProfilePageLocators.SELECT_KINDERGARTEN_GRADE.get())).click();
				System.out.println ( "Selected KinderGarden");
				try {
					Thread.sleep (1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (webDriver.findElement(By.cssSelector(ProfilePageLocators.SELECT_NUMBER_GRADES1.get())).isDisplayed()){
					webDriver.findElement(By.cssSelector(ProfilePageLocators.SELECT_NUMBER_GRADES1.get())).click();
					System.out.println("Selected NumberGrades1 row");
					try {
						Thread.sleep (1000 );
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (webDriver.findElement(By.cssSelector(ProfilePageLocators.SELECT_NUMBER_GRADES2.get())).isDisplayed()) {
						webDriver.findElement(By.cssSelector(ProfilePageLocators.SELECT_NUMBER_GRADES2.get())).click();
						System.out.println("Selected NumberGrades2 row");
						try {
							Thread.sleep (1000 );
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					return true;
				}
			}
		}
		return false;
	}

	// Verify and set the user role
	public boolean selectUserRole(String role) {
		if (webDriver.findElement(By.cssSelector(ProfilePageLocators.SELECT_ROLE.get())).isDisplayed()) {
			webDriver.findElement(By.cssSelector(ProfilePageLocators.SELECT_ROLE.get())).click();
			// Select the student or teacher role
			if (role.equals("teacher")) {
				if (webDriver.findElement(By.id(ProfilePageLocators.ROLE_OPTIONS.get())).isDisplayed()) {
					webDriver.findElement(By.id(ProfilePageLocators.SELECT_TEACHER_ROLE.get())).click();
					System.out.println("Teacher role selected");
					return true;
				}
			}
			else if(role.equals("student")) {
				if (webDriver.findElement(By.id(ProfilePageLocators.ROLE_OPTIONS.get())).isDisplayed()) {
					webDriver.findElement(By.id(ProfilePageLocators.SELECT_STUDENT_ROLE.get())).click();
					System.out.println("Student role selected");
					return true;
				}
			}
		}
		return false;
	}
}

