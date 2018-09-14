/*
 * Copyright 2014-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

/*package Pages;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class LoginPage extends BasePage {
    private static final int KEYBOARD_ANIMATION_DELAY = 1000;


    @AndroidFindBy(id = "com.amazonaws.devicefarm.android.referenceapp:id/login_button")
    private MobileElement loginButton;


    @AndroidFindBy(id = "com.amazonaws.devicefarm.android.referenceapp:id/username_text_input")
    private MobileElement usernameField;


    @AndroidFindBy(id = "com.amazonaws.devicefarm.android.referenceapp:id/password_text_input")
    private MobileElement passwordField;

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }


    public boolean login(String username, String password) throws InterruptedException {
        boolean usernameStatus = sendKeysToElement(username, usernameField, false);

        passwordField.click();
        Thread.sleep(KEYBOARD_ANIMATION_DELAY);
        passwordField.sendKeys(password);

        loginButton.click();

        return usernameStatus;
    }


    public String getMessage() {
        return driver.findElementById("Alt Message").getText();
    }


    public boolean checkIfBackAtLogin() {
        return loginButton.isDisplayed() && usernameField.isDisplayed() && passwordField.isDisplayed();
    }


    public void pressAltButton() {
        driver.findElementById("Alt Button").click();
    }
}*/
