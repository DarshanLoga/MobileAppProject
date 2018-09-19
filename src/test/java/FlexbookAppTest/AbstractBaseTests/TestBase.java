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

package FlexbookAppTest.AbstractBaseTests;

import FlexbookAppTest.AbstractBaseTests.FlexbookApp.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import javafx.scene.web.WebView;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.io.File;


/**
 * An abstract base for all of the Android tests within this package
 *
 * Responsible for setting up the Appium test Driver
 */
public abstract class TestBase {
    /**
     * Make the driver static. This allows it to be created only once
     * and used across all of the test classes.
     */
     public static AndroidDriver driver;
    /**
     * This allows the navigation to work within the app.
     * The category name is returned so we can navigate to it from the navigation
     * drawer.
     *
     * @return The name of the Android category
     */
    public abstract String getName();

    /**
     * Method to initialize the test's page
     */
    @BeforeTest
    public abstract void setUpPage();


    /**
     * This method runs before any other method.
     * <p>
     * Appium follows a client - server model:
     * We are setting up our appium client in order to connect to Device Farm's appium server.
     * <p>
     * We do not need to and SHOULD NOT set our own DesiredCapabilities
     * Device Farm creates custom settings at the server level. Setting your own DesiredCapabilities
     * will result in unexpected results and failures.
     *
     * @throws MalformedURLException An exception that occurs when the URL is wrong
     */
    @BeforeSuite
    public DesiredCapabilities setUpAppium() throws MalformedURLException {
		//Capabilities for AWS
		final String URL_STRING = "http://127.0.0.1:4723/wd/hub";
		URL url = new URL ( URL_STRING );
		//Use a empty DesiredCapabilities object
		DesiredCapabilities capabilities = new DesiredCapabilities ( );
		driver = new AndroidDriver<MobileElement> ( url, capabilities );
		//capabilities.setCapability( "autoWebview", "true" );
		//Use a higher value if your mobile elements take time to show up
		//capabilities.setCapability ( "recreateChromeDriverSessions", true );
		driver.manage ( ).timeouts ( ).implicitlyWait ( 80, TimeUnit.SECONDS );
		try {
			Thread.sleep ( 15000 );
		} catch (InterruptedException e) {
			e.printStackTrace ( );
		}
		return capabilities;
	}

    /**
     * Always remember to quit
     */
    @AfterSuite
    public void tearDownAppium () {
		driver.quit();
    }

    /**
     * Restart the app after every test class to go back to the main
     * screen and to reset the behavior
     */
    /*@AfterClass
    public void restartApp () {
    	driver.resetApp();
    }*/

}

