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

package Tests.AbstractBaseTests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

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
    public static AndroidDriver<MobileElement> driver;
    /**
     * This allows the navigation to work within the app.
     * The category name is returned so we can navigate to it from the navigation
     * drawer.
     *
     * @return The name of the Android category
     */
    public abstract String getName();

    /**
     * A page containing the navigation drawer
     */
    //private NavigationPage navigationPage;

    /**
     * Method to initialize the test's page
     */
    @BeforeTest
    public abstract void setUpPage();

    /**
     * This method runs before any other method.
     *
     * Appium follows a client - server model:
     * We are setting up our appium client in order to connect to Device Farm's appium server.
     *
     * We do not need to and SHOULD NOT set our own DesiredCapabilities
     * Device Farm creates custom settings at the server level. Setting your own DesiredCapabilities
     * will result in unexpected results and failures.
     *
     * @throws MalformedURLException An exception that occurs when the URL is wrong
     */
    @BeforeSuite
    public void setUpAppium() throws MalformedURLException {
        final String URL_STRING = "http://127.0.0.1:4723/wd/hub";
        URL url = new URL( URL_STRING );
        //Use a empty DesiredCapabilities object
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability( "autoWebview", "true" );
        capabilities.setCapability( "newCommandTimeout", "120");
        driver = new AndroidDriver<MobileElement>( url, capabilities );
        //capabilities.setCapability("autoAcceptAlerts", true);
        driver.manage().timeouts().implicitlyWait( 60, TimeUnit.SECONDS );
        try {
            Thread.sleep( 15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
        /*final String URL_STRING = "http://127.0.0.1:4723/wd/hub";
        URL url = new URL (URL_STRING);
        //Use a empty DesiredCapabilities object
        DesiredCapabilities capabilities = new DesiredCapabilities ();
        File appdir = new File ("/Users/apple/Downloads/PracticeAppBuilds");
        File app = new File (appdir, "CK12-debug-www-3.8.0.251918.apk");
        capabilities.setCapability (CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability ("noReset", true);
        capabilities.setCapability ("autoWebview", "true");
        capabilities.setCapability (MobileCapabilityType.NEW_COMMAND_TIMEOUT, 1000);
        capabilities.setCapability (MobileCapabilityType.APP, app.getAbsolutePath ());
        capabilities.setCapability ("autoLaunch", Boolean.parseBoolean ("autolaunch"));
        capabilities.setCapability ("autoLaunch", Boolean.parseBoolean (String.valueOf (true)));
        capabilities.setCapability (MobileCapabilityType.APP_ACTIVITY, "org.ck12.app.practice.MainActivity");
        capabilities.setCapability (MobileCapabilityType.APP_PACKAGE, "org.ck12.app.practice");
        capabilities.setCapability (MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability ("recreateChromeDriverSessions", true);
        capabilities.setCapability ("setWebContentsDebuggingEnabled", true);
        capabilities.setCapability (MobileCapabilityType.DEVICE_NAME, "0a9d425a0bfc6fac"); // Moto E TA38500ME6 // 0a9d425a0bfc6fac
        capabilities.setCapability ("chromedriverExecutable", "/Users/apple/Desktop/ChromeDriver/41/chromedriver");
        driver = new AndroidDriver<MobileElement> (new URL ("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage ().timeouts ().implicitlyWait (80, TimeUnit.SECONDS);
        try {
            Thread.sleep (15000);
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }*/

    /**
     * Always remember to quit
     */
    @AfterSuite
    public void tearDownAppium() {
        driver.quit();
    }

    /**
     *
     *  Creates a navigation page and navigates to the Class' category
     *  within the navigation drawer
     *
     */
    /*@BeforeClass
    public void navigateTo() throws InterruptedException {
        navigationPage = new NavigationPage(driver);
        navigationPage.gotoCategory(getName());
    }*/

    /**
     * Restart the app after every test class to go back to the main
     * screen and to reset the behavior
     */
    /*@AfterClass
    public void restartApp() {
        driver.resetApp();
    }*/
}