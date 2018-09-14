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
import io.appium.java_client.pagefactory.AndroidFindBy;*/

/**
 * A page for alerts
 */
/*public class AlertPage extends BasePage {

    @AndroidFindBy(id = "com.amazonaws.devicefarm.android.referenceapp:id/notifications_alert_button")
    private MobileElement alertButton;


    @AndroidFindBy(id = "com.amazonaws.devicefarm.android.referenceapp:id/notifications_toast_button")
    private MobileElement toastButton;

    public AlertPage(AppiumDriver driver) {
        super(driver);
    }


    public void clickToastButton() {
        toastButton.click();
    }

    public void clickAlertsButton() {
        alertButton.click();
    }


    public String getAlertText() {
        MobileElement alertMessage = (MobileElement) driver.findElementsByClassName("android.widget.TextView").get(1);
        return alertMessage.getText();
    }


    public void acceptAlertMessage() {
        MobileElement alertOkButton = (MobileElement) driver.findElementsByClassName("android.widget.Button").get(0);
        alertOkButton.click();
    }
}*/