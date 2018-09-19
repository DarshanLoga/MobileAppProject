package FlexbookAppTest.Test_FlexbookApp;

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
          Test_LaunchApp.class,
		  Tests_SignIn.class,
		  Tests_SignUp.class,
		  Tests_Profile.class,
		  Tests_Tutorial.class,
		  Tests_Browse.class,
		  Tests_BookTOCPage.class,
		  Tests_SectionsPage.class,
		  Tests_SideMenuPage.class,
		  Tests_SettingsPage.class,
		  Tests_SideMenuPage.class
		});
        //execute the tests
        runner.run();
    }
}
