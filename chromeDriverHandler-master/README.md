
## Appium and chromedriver

This project will solve almost all issues of appium which normally occur when chromedriver can’t switch contexts from Native_App to webview and vice versa.

How to use:

1. Add chromedriverHandler.jar to your java project.

2. If you are using testNG or junit framework then in @beforeclass or @beforetest method or in any method where you are performing any setup prior to execute tests, write code like:

	ChromedriverHandler.chromeDriverHandlerThread().start();

3. In your @aftertest or @afterclass method or in any method where you are performing any setup after test completion, write code like: 

	ChromedriverHandler.chromeDriverHandlerThread().stop();

4. Also add dependencies: apache's httpcore-4.3.jar, httpclient-4.3.1.jar and json simple json-20080701.jar to your project, just in case to avoid any errors.

