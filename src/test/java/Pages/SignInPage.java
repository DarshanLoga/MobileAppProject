package Pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.UUID;

public class SignInPage extends PracticeAppLandingPage {

    @FindBy(id="com.android.packageinstaller:id/permission_message")
    private WebElement permissionMessage;

    @FindBy(id="usrname")
    private WebElement username;

    @FindBy(css ="#login-form > input:nth-child(3)")
    private WebElement password;

    @FindBy(css ="input[value='Sign In']")
    private WebElement submitSignInBtn;
    
    @FindBy(css = "input.f-name.validated-input")
    private WebElement fullName;
    
    @FindBy(css = ".forminput.email")
    private WebElement emailText;
    
    @FindBy(id = "pswd-change")
    private WebElement signuppassword;
    
    @FindBy(css = ".dob.po-relative")
    private WebElement dobField;
    
    @FindBy(id = "createUser")
    private WebElement signupAccount;

    public SignInPage(AppiumDriver driver) {
        super( driver );
    }

    public boolean loginAsExistingUsers() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (username.isDisplayed() && password.isDisplayed()) {
            System.out.println("Username & Password fields are appears...");
            username.sendKeys("karti28");
            driver.hideKeyboard();
            password.sendKeys("test1234");
            driver.hideKeyboard();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (submitSignInBtn.isEnabled()) {
                submitSignInBtn.click();
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Login successfully...");
            return true;
        }
        return false;
    }
    
    
    public boolean signUPWithEmail(String fullname) {
        wait.until(ExpectedConditions.visibilityOf(fullName));
        try {
            if (fullName.isDisplayed() && signuppassword.isDisplayed () && dobField.isDisplayed() && emailText.isDisplayed()) {
                System.out.println("Signup page appears...");
                fullName.sendKeys(fullname);
                driver.executeScript("arguments[0].setAttribute('value',arguments[1])", dobField, "2000-09-12");
                final String randomEmail = randomEmail();
                emailText.sendKeys (randomEmail);
                signuppassword.sendKeys("111111");
                signupAccount.click();
                try {
                    Thread.sleep( 4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Account created successfully...");
            }
        }catch (Exception e) {
            e.printStackTrace ();
        }
        return true;
    }
    
    private static String randomEmail() {
        return "ck12automator-" + UUID.randomUUID().toString() + "@ck12.org";
    }
}
