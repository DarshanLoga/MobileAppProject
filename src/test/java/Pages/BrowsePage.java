package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import net.sourceforge.htmlunit.corejs.javascript.EcmaError;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BrowsePage extends PracticeAppLandingPage {
    
    @FindBy (css = "#subjects-container div.small-12.columns.assignments-subjects-container")
    private WebElement subjectContainer;
    
    @FindBy (css = "#subjects-container div.assignments-subjects-wrapper div.subject-title span")
    private List<WebElement> subjects;
    
    @FindBy (css = "div#subjects-container div.assignments-subjects-wrapper:nth-child(1) div.subject-title span")
    private WebElement selectSubject;
    
    @FindBy (css = "#headerText > span.header-title")
    private WebElement streamHeaderTxt;
    
    @FindBy (css = "#groups-assignments-subject-ele")
    private WebElement streamWrapper;
    
    @FindBy (id = "tracks-wrapper")
    private WebElement trackPage;
    
    @FindBy (css = "#tracks-wrapper div.select-track-collection-wrapper:nth-child(1) div.track-name.js-node-name")
    private WebElement trackSelect;
    
    @FindBy (id = "concepts-wrapper")
    private WebElement conceptPage;
    
    @FindBy (xpath = "//*[contains(@class, 'concept-name')]/a[text()='Dividing by 9']")
    //Dividing 2-digit Numbers by 2-digit Numbers
    private WebElement selectConcept;
    
    @FindBy (css = ".assignment-search div.row.collapse.text-center")
    private WebElement searchBox;
    
    @FindBy (id = "assignment-search-input")
    private WebElement searchInputBox;
    
    @FindBy (css = ".hint-loader")
    private WebElement searchIcon;
    
    @FindBy (css = "ul.ui-autocomplete > li.autocomplete-list")
    private WebElement autoSuggestSearchResults;
    
    @FindBy (css = "ul.ui-autocomplete > li.autocomplete-list a.autocomplete-link")
    private WebElement accessConceptInAutoSearchResults;
    
    @FindBy (css = ".js-concept-select:nth-child(1)")
    private WebElement accessSearchConcept;
    
    public BrowsePage (AppiumDriver driver) {
	super (driver);
    }
    
    public boolean verifyBrowsePage () {
	try {
	    Thread.sleep (2000);
	} catch (InterruptedException e) {
	    e.printStackTrace ();
	}
	try {
	    if (subjectContainer.isDisplayed ()) {
		System.out.println ("Browse page appears...");
	    }
	} catch (Exception e) {
	    e.printStackTrace ();
	}
	return true;
    }
    
    public boolean verifyAndSelectSubjects () {
	try {
	    Thread.sleep (2000);
	} catch (InterruptedException e) {
	    e.printStackTrace ();
	}
	System.out.println ("Subjects size are" + subjects.size ());
	try {
	    if (subjects.get (0).isDisplayed () && subjects.get (1).isDisplayed () && subjects.get (2).isDisplayed () && subjects.get (3).isDisplayed ()) {
		System.out.println ("All subjects are appears in the browse page...");
		System.out.println ("The subject is" + subjects.get (0).getText ());
		if (selectSubject.isDisplayed ()) {
		    System.out.println ("Elementary math subject is displayed");
		    ((JavascriptExecutor) driver).executeScript ("$($(\".subject-title span\")[0]).trigger(\"touchend\")");  //Select Elementary Math
		    try {
			Thread.sleep (1000);
		    } catch (InterruptedException e) {
			e.printStackTrace ();
		    }
		    return true;
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace ();
	}
	return false;
    }
    
    public boolean verifyStreamPage () {
	try {
	    Thread.sleep (1000);
	} catch (InterruptedException e) {
	    e.printStackTrace ();
	}
	if (streamHeaderTxt.isDisplayed ()) {
	    System.out.println ("Stream page header txt is" + streamHeaderTxt.getText ());
	    if (streamWrapper.isDisplayed ()) {
		System.out.println ("Stream page appears...");
		return true;
	    }
	}
	return false;
    }
    
    public boolean selectSubjectStream () {
	try {
	    Thread.sleep (1000);
	} catch (InterruptedException e) {
	    e.printStackTrace ();
	}
	((JavascriptExecutor) driver).executeScript ("$($(\".subject-icon span\")[5]).trigger(\"touchend\")"); // Grade 5
	System.out.println ("Subject stream is selected");
	try {
	    Thread.sleep (1000);
	} catch (InterruptedException e) {
	    e.printStackTrace ();
	}
	return true;
    }
    
    public boolean verifyAndSelectSubjectTrack () {
	int retry = 4;
	while (retry > 0) {
	    try {
		if (trackPage.isDisplayed ()) {
		    if (trackSelect.isDisplayed ()) {
			System.out.println ("Subject track page appears...");
			break;
		    }
		}
		retry--;
	    } catch (Exception e) {
		e.printStackTrace ();
	    }
	}
	trackSelect.click ();
	System.out.println ("Subject track is selected");
	try {
	    Thread.sleep (2000);
	} catch (InterruptedException e) {
	    e.printStackTrace ();
	}
	return true;
    }
    
    public boolean verifyAndSelectSubjectConcept () {
	int retry = 4;
	while (retry > 0) {
	    try {
		if (conceptPage.isDisplayed ()) {
		    System.out.println ("Subject concept page appears...");
		    break;
		}
		retry--;
	    } catch (Exception e) {
		e.printStackTrace ();
	    }
	}
	((JavascriptExecutor) driver).executeScript ("arguments[0].click();", selectConcept);
	try {
	    Thread.sleep (1000);
	} catch (InterruptedException e) {
	    e.printStackTrace ();
	}
	return true;
    }
    
    public boolean searchConcept (String searchConcept) {
	try {
	    wait.until (ExpectedConditions.visibilityOf(searchBox));
	    if (searchBox.isDisplayed ()) {
		//((JavascriptExecutor) driver).executeScript ("arguments[0].click();", searchBox);
		((JavascriptExecutor) webDriver).executeScript("$($(\".assignment-search div\")).trigger(\"touchend\")");
		//tap(searchBox);
		System.out.println ("Search box is clicked");
		wait.until (ExpectedConditions.visibilityOf (searchInputBox));
		if (searchInputBox.isDisplayed ()) {
		    searchInputBox.sendKeys (searchConcept);
		    wait.until (ExpectedConditions.visibilityOf (autoSuggestSearchResults));
		    if (accessConceptInAutoSearchResults.isDisplayed ()) {
		        System.out.println("Auto suggest box");
			accessConceptInAutoSearchResults.click();
			try {
			    Thread.sleep (1000);
			} catch (InterruptedException e) {
			    e.printStackTrace ();
			}
			wait.until (ExpectedConditions.visibilityOf (accessSearchConcept));
			try {
			    Thread.sleep (500);
			} catch (InterruptedException e) {
			    e.printStackTrace ();
			}
			if (accessSearchConcept.isDisplayed ()) {
			   // ((JavascriptExecutor) driver).executeScript ("arguments[0].click();", accessSearchConcept);
			    ((JavascriptExecutor) webDriver).executeScript("$($(\".js-concept-select:nth-child(1) a\")).trigger(\"touchend\")");
			    try {
				Thread.sleep (2000);
			    } catch (InterruptedException e) {
				e.printStackTrace ();
			    }
			}
		    }
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace ();
	}
	return true;
    }
    
}
