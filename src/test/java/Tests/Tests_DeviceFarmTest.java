package Tests;

import org.testng.TestNG;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Tests_DeviceFarmTest {
    @Test
    public void testMultipleTests(){
        TestNG runner = new TestNG();
        runner.setOutputDirectory(System.getenv("WORKING_DIRECTORY")); //uses the custom artifacts to get the results
        runner.setPreserveOrder(true);
        List<String> suitefiles = new ArrayList<String> ();
        //add the classes that need testing
        runner.setTestClasses(new Class[] {
            LandingPageTest.class,
	    SignInPageTest.class,
	    PracticeAppBrowsePageTest.class,
	    PracticeAppPracticeTestPage.class,
	    PracticeAppSideMenuTest.class,
	    PracticeAppBrowsePageTest.class,
	    PracticeAppPracticeTestPage.class,
	    PracticeAppSideMenuTest.class
	    //PracticeAppSettingsPageTest.class,
	    //PracticeAppBrowsePageTest.class,
	    //PracticeAppPracticeTestPage.class,
	    //PracticeAppSideMenuTest.class
        });
        //execute the tests
        runner.run();
    }
}
