package Pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.UUID;

public class PracticeAppSettingsPage extends PracticeAppLandingPage {
    
    @FindBy(id = "backButton")
    private WebElement exitBtn;
    
    @FindBy(css= "header > span.page-title")
    private WebElement settingsHdr;
    
    @FindBy(id = "name")
    private WebElement nameTxt;
    
    @FindBy(id = "email")
    private WebElement emailTxt;
    
    @FindBy(id = "login")
    private WebElement userName;
    
    @FindBy(id = "password")
    private WebElement password;
    
    @FindBy(id = "usernameFormSubmit")
    private WebElement saveChangesBtn;
    
    @FindBy(id = "currentpassword")
    private WebElement currentPassword;
    
    @FindBy(id = "newpassword")
    private WebElement newPassword;
    
    @FindBy(id = "passwordFormSubmit")
    private WebElement saveNewPasswordBtn;
    
    @FindBy(css = "#password-save span")
    private WebElement settingsSaveMesage;
    
    @FindBy(xpath = "//*[@id='change-password']/div/div/span[2]")
    private WebElement passwordSectionTxt;
    
    
    public PracticeAppSettingsPage (AppiumDriver driver) {
	super (driver);
    }
    
    public boolean verifyAccountSettingsPage() {
        wait.until(ExpectedConditions.visibilityOf(settingsHdr));
        if (settingsHdr.getText().equals ("Account Settings")) {
            if (exitBtn.isDisplayed() && nameTxt.isDisplayed() && emailTxt.isDisplayed()
		&& userName.isDisplayed() && password.isDisplayed()) {
                System.out.println ("Account settings page appear");
    
            }
        }
	return true;
    }
    
    public boolean createUserNameWithPassword() {
        if (userName.isDisplayed() && password.isDisplayed ()) {
            final String randomUser = randomUser ();
            userName.sendKeys (randomUser);
            password.sendKeys ("111111");
            if (saveChangesBtn.isEnabled ()) {
                saveChangesBtn.click ();
                try {
                    Thread.sleep (2000);
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
                System.out.println ("Username created successfully...");
            }
        }
        return true;
    }
    
    public boolean changeCurrentPasswordWithExistingPassword() {
        if (passwordSectionTxt.getText().equals("Password")) {
            if (currentPassword.isDisplayed() && newPassword.isDisplayed ()) {
                currentPassword.sendKeys("111111");
                newPassword.sendKeys("222222");
                if (saveNewPasswordBtn.isEnabled()) {
                    saveNewPasswordBtn.click();
                    try {
                        Thread.sleep (1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace ();
                    }
                    wait.until(ExpectedConditions.visibilityOf(settingsSaveMesage));
                }
            }
        }
        return true;
    }
    
    public boolean exitSettingsPage() {
        if (exitBtn.isDisplayed()) {
            exitBtn.click();
            try {
                Thread.sleep (2000);
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }
        return true;
    }
    
    private static String randomUser() {
        return "ck12automatorUser-" + UUID.randomUUID().toString();
    }
}
