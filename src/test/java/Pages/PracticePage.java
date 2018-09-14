package Pages;

import com.gargoylesoftware.htmlunit.WebWindow;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Scanner;

public class PracticePage extends PracticeAppLandingPage {
    @FindBy (css = "#backButton")
    private WebElement backButton;
    
    @FindBy (css = "#headerText > span")
    private WebElement testTitle;
    
    @FindBy (id = "practiceScore")
    private WebElement practiceScoreContainer;
    
    @FindBy (id = "testDetail")
    private WebElement practiceCoverSheetContainer;
    
    @FindBy (css = ".prc-msg")
    private WebElement practiceGoalMessage;
    
    @FindBy (css = "#testDetail div.button.large.tangerine.start.takePractice.practice-mobile")
    private WebElement startPracticing;
    
    @FindBy (id = "walkthrough")
    private WebElement walkThroughPage;
    
    @FindBy (id = "imgNavigation")
    private WebElement walkThroughImage;
    
    @FindBy (id = "startPractice")
    private WebElement walkThroughStartPractice;
    
    @FindBy (id = "practiceScoreReport")
    private WebElement scoreReportBlock;
    
    @FindBy (id = "adaptiveTestDetailContainer")
    private WebElement adaptiveTestContainer;
    
    @FindBy (css = "#testDetailContainer > li[data-detail-type='correct']")
    private WebElement correctAnswerSection;
    
    @FindBy (css = "#testDetailContainer > li[data-detail-type='streak']")
    private WebElement bestStreakSection;
    
    @FindBy (css = "#testDetailContainer > li[data-detail-type='time']")
    private WebElement timeSpentSection;
    
    @FindBy (css = "#testDetailContainer > li[data-detail-type='skill_level']")
    private WebElement skillLevelSection;
    
    @FindBy (css = "#attemptButtonContainerDesktop > div > div.text-center.next-concept-title-container > div")
    private WebElement goToNextConceptBtn;
    
    @FindBy (css = "#adaptiveFilters > div.recomended-title > div.set-title")
    private WebElement reviewYourAnswerHdrTxt;
    
    @FindBy (css = "#adaptiveFilters > div.level-report")
    private WebElement difficultyLevelReportContainer;
    
    @FindBy (css = "#adaptiveFilters > div.level-report > div.all-questions")
    private WebElement allQuestionFilterCircle;
    
    @FindBy (css = "#adaptiveFilters > div.level-report > div.easy-circle")
    private WebElement easyQuestionFilterCircle;
    
    @FindBy (css = "#adaptiveFilters > div.level-report > div.medium-circle")
    private WebElement mediumQuestionFilterCircle;
    
    @FindBy (css = "#adaptiveFilters > div.level-report > div.hard-circle")
    private WebElement hardQuestionFilterCircle;
    
    @FindBy (css = "div.all-questions > div[data-filter-type='all']")
    private WebElement allQuestionDifficultyFilter;
    
    @FindBy (css = "div.easy-circle > div[data-filter-type='easy']")
    private WebElement easyQuestionDifficultyFilter;
    
    @FindBy (css = "div.medium-circle > div[data-filter-type='medium']")
    private WebElement mediumQuestionDifficultyFilter;
    
    @FindBy (css = "div.hard-circle > div[data-filter-type='hard']")
    private WebElement hardQuestionDifficultyFilter;
    
    @FindBy (id = "attemptCarousal")
    private WebElement attemptQuestionsContainer;
    
    @FindBy (css = "#practiceScoreReport div.pie-container span.progress-text")
    private WebElement practiceScore;
    
    @FindBy (id = "testDetailContainer")
    private WebElement testDetailsInReportsPage;
    
    @FindBy (css = "#attemptButtonContainerDesktop > div > div.text-center.next-concept-title-container > div.button.next-concept-title.tangerine")
    private WebElement nextConceptBtn;
    
    @FindBy (id = "tryAgain")
    private WebElement keepPracticing;
    
    @FindBy (css = "#header div.columns.test-title-container h1.test-title")
    private WebElement tunnelTestTitle;
    
    @FindBy (css = "#submitTest > span")
    private WebElement submitPractice;
    
    @FindBy (id = "progressContainer")
    private WebElement progressBlock;
    
    @FindBy (id = "questionContainer")
    private WebElement questionContainer;
    
    @FindBy (css = "div.question-text")
    private WebElement questionText;
    
    @FindBy (id = "nextQuestion")
    private WebElement nextQuestionBtn;
    
    @FindBy (css = "#dataStemContainer > div > p:nth-child(2) > input")
    private WebElement inputAnswerBox1;
    
    @FindBy (css = "#dataStemContainer > div > p:nth-child(3) > input")
    private WebElement inputAnswerBox2;
    
    @FindBy (css = "#dataStemContainer > div > p > input:nth-child(1)")
    private WebElement fillInBlankBox1;
    
    @FindBy (css = "#dataStemContainer > div > p > input:nth-child(2)")
    private WebElement fillInBlankBox2;
    
    @FindBy (css = "#dataStemContainer > div > p > input")
    private WebElement BlankBox;
    
    @FindBy(css = "#dataResponseContainer li > input")
    private WebElement diagnoseShortAnswerBox;
    
    @FindBy (css = "div.dt-cards div#dataResponseContainer li:nth-child(1)")
    private WebElement diagnoseTrueFalseOption;
    
    @FindBy (id = "speechInfoText")
    private WebElement speechInfoMessagePopup;
    
    @FindBy (css = "#dtAttemptModal div.close-cont")
    private WebElement closeSpeechInfoPopup;
    
    @FindBy (css = "#dtAttemptModal div.heading-text.left.small-12.columns.large-12.text-center > div.text-content.heading-font")
    private WebElement diagnoseTestModalHeading;
    
    @FindBy (css = ".deny-attempt")
    private WebElement denydiagnoseTest;
    
    @FindBy (css = "li.dt-check-mark")
    private WebElement iconCheckMark;
    
    @FindBy (id = "dtSubmitResponse")
    private WebElement diagnoseCheckItBtn;
    
    @FindBy (id = "dtNextQuestion")
    private WebElement diagnoseNextBtn;
    
    @FindBy (css = "#dtAttemptModal div.dt-check-mark-container")
    private WebElement checkMarkContainer;
    
    @FindBy (id = "dtViewRecommendation")
    private WebElement viewRecommendationBtn;
    
    @FindBy (css = ".rec-msg")
    private WebElement recommendationCompleteMessage;
    
    @FindBy (id = "diagnosticRecommendation")
    private WebElement diagnoseRecommendationPopup;
    
    @FindBy (css = "#diagnosticRecommendation > div.recommendation-header")
    private WebElement recommendationHDRTxt;
    
    @FindBy (css = "#pauseModalityContainer  div.recommend-title-section > span.recommend-title")
    private WebElement conceptTitleInRecommendationPopup;
    
    
    /*@FindAll ({
        //@FindBy(how = How.CSS, using ="li.response-row div.display-text")
        @FindBy(css = "li.response-row:nth-child(1) div.display-text"),
        @FindBy(css = "li.response-row:nth-child(2) div.display-text"),
        @FindBy(css = "li.response-row:nth-child(3) div.display-text"),
        @FindBy(css = "li.response-row:nth-child(4) div.display-text"),
    })
    private List<WebElement> multipleChoiceField;*/
    
    @FindBy (css = "li.response-row div.display-text")
    private WebElement multipleChoiceField;
    
    @FindBy (css = "#dataResponseContainer  ul  li  input")
    private WebElement shortAnswerBox;
    
    @FindBy (id = "submitResponse")
    private WebElement checkitBtn;
    
    @FindBy (id = "completePracticeModal")
    private WebElement completePracticeModalPopup;
    
    @FindBy (css = "#completePracticeModal div.cp-button-container > a.stop-practice")
    private WebElement stopForNowBtn;
    
    @FindBy (css = "#completePracticeModal div.cp-button-container > a.continue-pactice span")
    private WebElement keepPracticingBtn;
    
    @FindBy (id = "dtAttemptModal")
    private WebElement diagnoseTestModalPopup;
    
    @FindBy (css = "#dtAttemptModal div.dt-cards div.question-render-container div#dataStemContainer div.question-text.default")
    private WebElement diagnoseQuestionText;
    
    @FindBy (css = "div.recommendation-list div.row.modality-list-row:nth-child(1) div.pause-recommendation-modality:nth-child(1) div.pause-modality-content")
    private WebElement recommendedModality;
    
    @FindBy (css = "div.unlock-message")
    private WebElement unLockMessage;
    
    @FindBy (css = "div.recommendation-list div.row.modality-list-row:nth-child(1) div.pause-recommendation-modality:nth-child(1) div.pause-modality-content div.diagnostic-check")
    private WebElement recommendedModalityCheckMark;
    
    @FindBy (css = "div#embed_container div.modality_title h2")
    private WebElement embedModalityTitle;
    
    @FindBy (css = "div#embed_container div.modality_title a i")
    private WebElement closeEmbedModalityPage;
    
    @FindBy (id = "spInitModal")
    private WebElement memoryBoostInitModalPopup;
    
    @FindBy (css = "#spInitModal div.header-content")
    private WebElement memoryBoostInitModalPopupHeaderTxt;
    
    @FindBy (id = "spAttemptModal")
    private WebElement memoryBoostAttemptModalPopup;
    
    @FindBy (css = "#spAttemptModal div.heading-text > div.text-content.large-font.inline-div")
    private WebElement headerTextInMemoryBoostPopup;
    
    @FindBy (css = "#spAttemptModal a.close-reveal-modal.close")
    private WebElement closeIconInMemoryBoostPopup;
    
    @FindBy (css = "#spAttemptModal div.boost-help.block-inline > div.icon-help")
    private WebElement boostToolTipIcon;
    
    @FindBy (css = "div.cards.active div#dataStemContainer div.question-text")
    private WebElement memoryBoostQuestionText;
    
    @FindBy (css = "div.cards.first-card.active div.question-render-container")
    private WebElement memoryBoostQuestionContainer;
    
    @FindBy (css = "div.check-mark-container.large-4")
    private WebElement memoryBoostCheckMarkContainer;
    
    @FindBy (id = "spSubmitResponse")
    private WebElement memoryBoostCheckItBtn;
    
    @FindBy (id = "spNextQuestion")
    private WebElement memoryBoostNextBtn;
    
    @FindBy (id = "spFeedbackModal")
    private WebElement memoryBoostFeedbackModalPopup;
    
    @FindBy (css = "#spFeedbackModal > div.body-content.text-center.for-animated.body-image > div")
    private WebElement smileyImageInFeedbackModalPopup;
    
    @FindBy (css = "#spFeedbackModal div.for-feedback > div.medium-font")
    private WebElement headerMsgInFeedbackModalPopup;
    
    @FindBy (css = "li.face.face-easy")
    private WebElement smileyIcon;
    
    @FindBy (css = "div.sp-button-container a.button.stop-practice")
    private WebElement stopPracticingBtnInMemoryBoostPopup;
    
    @FindBy (css = "div.sp-button-container a.button.continue-practice")
    private WebElement keepPracticingBtnInMemoryBoostPopup;
    
    @FindBy (css = "div.report-error-link.for-mobile.text-center > span")
    private WebElement improveThisQuestionLnk;
    
    @FindBy (css = "section#reportErrorModal div.small-10.padding-top-down")
    private WebElement improveThisQuestionMessage;
    
    @FindBy (id = "errorTypes")
    private WebElement improveErrorTypeDropDown;
    
    @FindBy (id = "errorReason")
    private WebElement improveErrorDetails;
    
    @FindBy (id = "reportError")
    private WebElement improveSubmitErrorReport;
    
    @FindBy (css = ".row.margin-top")
    private WebElement improveReportErrorMessage;
    
    @FindBy (css = "#reportErrorModal div.close-button-container > div.close-mobile-view-modal")
    private WebElement closeImproveThisQuestionPopup;
    
    @FindBy (css = ".showScratchPad")
    private WebElement scratchpad;
    
    @FindBy (css = ".tools.transition-all")
    private WebElement scratchpadTools;
    
    @FindBy (css = ".icon-close.js-close.tool")
    private WebElement closeScratchpadContainer;
    
    @FindBy (css = ".showSolution")
    private WebElement solution;
    
    @FindBy (id = "stickyHeaderTitle")
    private WebElement solutionHeader;
    
    @FindBy (css = ".icon-validated")
    private WebElement solutionGotItBtn;
    
    @FindBy(id = "dataResponseContainer")
    private WebElement dataResponseContainer;
    
    
    String qIDs[] = {"55f2afa35aa41330cbda3f14", "55f2ae76da2cfe5cf9570463", "55f2af9cda2cfe03b035daff", "55f2af935aa41330cbda3f12"
	, "55f2ae8a8e0e081130e9b75a"};
    
    // 57c742238e0e08156db399d2, 5741f3fc8e0e08198e86484a 5741f3fc8e0e08198e86484a
    //       .question-text input:nth-child(2)
    
    // Elementary Math Concepts
    String questionIDs[] = {"55f2af67da2cfe673a22685a", "5592b8155aa41331bd178ede", "55f2afa35aa41330cbda3f14", "5592b80c5aa41331832faad4",
	"55f2af8ada2cfe17ab4a772f", "55f2ae76da2cfe5cf9570463", "5592b8135aa41331c4fbe394", "5592b81dda2cfe6a3b086398", "55f2afa85aa4132c8120a192",
	"55f2afb18e0e081b58b2ab6b", "55f2ae59da2cfe72f72bb8d0", "5592b8205aa41331bd178edf", "55f2af9cda2cfe03b035daff", "5592b8108e0e0854df48ddce",
	"5592b80e5aa41331c4fbe392", "5592b81bda2cfe6b07bfe9a9", "55f2ae8a8e0e081130e9b75a", "5592b824da2cfe6b1ae7cd30", "5592b8215aa41331bc7e8b52",
	"55f2af935aa41330cbda3f12", "5592b81bda2cfe6b07bfe9a9"};
    
    
    String answers[] = {"3", "6", "8", "10", "5", "2", "7", "4", "9", "10", "1", "3", "7", "8", "9", "5", "4", "1", "2", "6", "5"};
    
    String m_qIDs[] = {"556de19dda2cfe70f6d41697", "5602e93a9616aa74e49384dc", "5602e5349616aa706a4ccf2f", "5602e1399616aa752f9b1d7f", "5602e1a28e0e0845db792423",
	"5602dd708e0e084c5d658377",
	//Spaced
	"531e031c5aa413333fe8d744", "53ce903c5aa4135297ee656c", "57a2a8728e0e0812ab714bc5"
    };
    
    String m_ans[] = {"Make observations", "Selecting a hypothesis", "A new law", "The carbon dioxide in volcanic gases has increased over time",
	"It must be able to pass all its tests", "The hypothesis must be abandoned entirely",
	
	// Spaced
	"solution.", "A mixture of oxygen atoms only", "Colloid",
    };
    
    String t_qIDs[] = {"5602ea659616aa013dc6a961", "5aa78614f42c50069521233a", "5aa78614f42c50069521233b", "5602eb76da2cfe6e62ee0d58",
	"54fde5b1da2cfe284c7b86ca"};
    
    String t_ans[] = {"FALSE", "FALSE", "FALSE", "FALSE", "FALSE"};
    
    String f_qIDs[] = {"5aa78614f42c500695212339", "5ac3d05c5aa4130bc340a1d7"};
    
    String f_ans[] = {"a", "a"};
    
       // Diagnose
    String d_qIDs[] = {"57fea9559616aa0ea0683ada", "59c743b29616aa67eb769892", "55cffd428e0e0865419612ba",
	   // Truefalse questions
	"5464ef148e0e080f9e0f9b9a", "5ac72763f42c500e17d5ed85", "5acf842a38aaa372f4210626", "5602df45da2cfe1dfb8024f2",
	   "5601e8c88e0e084877abea55", "55bead4f8e0e08404f7f0769", "56795ab79616aa2767e3c8c2", "567959c8da2cfe54f91bf249",
	   "56795c07da2cfe55fa3c8a2c", "5602e9dada2cfe6e9b0e58d6", "5601eba89616aa7985e3aad3", "55d4eb8dda2cfe21f8b1678c",
    
            // Mixture Diagnose practice questions
	   "53ebd6af8e0e082195fb6082", "594ca1738e0e082a273ff345", "59dd4e208e0e08611023703b", "53ebd5a2da2cfe5d68892804",
	   "588255539616aa5ed23510f8", "588257e6da2cfe1ccddd0a01", "54c029488e0e0801cb9d8319", "5882576d8e0e0803f4c8eb79",
	   "588259c1da2cfe17df351feb", "5882598b9616aa7e63310452", "55ea2d29da2cfe4c949fb79d", "5882584eda2cfe6ccfd33f3a",
	   "594ca322da2cfe2da074c082", "53ebd3f78e0e082014590d68", "594c7f548e0e085da12f7f41", "588256cf9616aa7e633103e3",
	   "594c809f8e0e085cd5f6bc58", "594ca2698e0e085f84afe543", "594ca36c5aa41324cf325155", "5882589f8e0e082cc5d0f84a",
	   "53ebd4edda2cfe5df9c0dcee", "53ebd5f58e0e082013ecdd3f"
	   
    };
    
    String d_ans[] = {"homogeneous", "homogeneous", "FALSE",
	//Truefalse
	"TRUE", "TRUE", "a", "Is it testable?", "TRUE", "TRUE", "What is the age of our planet?", "None of the above",
	"TRUE", "Make a hypothesis", "TRUE", "Hypothetical",
	
	// Mixture Diagnose question answer
	"all of the above", "Solution", "suspension", "suspensions.", "mixture", "A mixture O2 and N2", "solution.", "sugar crystals dissolving in water",
	"air", "a balloon filled with helium", "FALSE", "Mixture", "Suspension", "FALSE", "mixture", "mixture", "FALSE",
	"Colloid", "FALSE", "False", "FALSE", "homogenized milk."
	
	};
    
    String h_qIDs[] = {"55316f2fda2cfe144fd3a737", "53c057e65aa41318f7a9a78d", "59c743b29616aa67eb769892", "54c13931da2cfe501888557a",
	"55db509cda2cfe0bcbf0d493", "5776f8acda2cfe3878a6b54f", "53c04f178e0e081af6572fde", "55316ff28e0e0806c9ca029a", "59c7418e8e0e086d659eac12",
	"5b168ebd9616aa0621b4bd18", "553178d75aa413575fefe63c", "55db51268e0e081c14d8a631", "55db5ed2da2cfe0e7e61853e", "59c7400ada2cfe5782f1d922",
	"5a7e22af5aa4131961dbe108", "553171918e0e087d49c8579b", "5531768e5aa4133c2051c348", "574f6f0ada2cfe3bbf471634", "553179308e0e08315728b2a2",
	"53c0500e5aa41318f7a9a6ad", "553171db8e0e087f87d9ccb3", "553172235aa4135105d2997e", "553178875aa4134205176a9b",
	"553170d38e0e0809230b1b11", "574f6fa2da2cfe3ba3508a2a", "5ac72768f42c500e1595b51f", "553176e95aa4134eef64dd3d",
	"5ac72763f42c500e17d5ed85", "5aa3b97b38aaa36bef04a12b", "5af479d938aaa3067d67ca91"
 
	/*"53ebd6af8e0e082195fb6082", "594ca1738e0e082a273ff345", "59dd4e208e0e08611023703b", "53ebd5a2da2cfe5d68892804", "588255539616aa5ed23510f8",
	"588257e6da2cfe1ccddd0a01", "54c029488e0e0801cb9d8319", "5882576d8e0e0803f4c8eb79", "588259c1da2cfe17df351feb", "5882598b9616aa7e63310452",
	"55ea2d29da2cfe4c949fb79d", "5882584eda2cfe6ccfd33f3a", "594ca322da2cfe2da074c082", "53ebd3f78e0e082014590d68", "594c7f548e0e085da12f7f41",
	"588256cf9616aa7e633103e3", "594c809f8e0e085cd5f6bc58", "594ca2698e0e085f84afe543", "594ca36c5aa41324cf325155", "5882589f8e0e082cc5d0f84a",
	"53ebd4edda2cfe5df9c0dcee", "53ebd5f58e0e082013ecdd3f"*/
    };
    
    
    String h_ans[]= {"Smog", "It is uniform in composition", "a", "zinc", "Gas", "Surface tension", "TRUE", "TRUE", "No",
	"TRUE", "TRUE", "FALSE", "Blood", "FALSE", "No", "FALSE", "FALSE", "False", "FALSE", "FALSE", "FALSE", "FALSE", "FALSE",
	"FALSE", "False", "No", "TRUE", "No", "a", "FALSE"
	
    };

    String mem_qIDs[] = {/*"588256cf9616aa7e633103e3", "59dd4e208e0e08611023703b", "53ebd4edda2cfe5df9c0dcee"*/
	"55d66af6da2cfe7da7d5093d", "59ea6b3a8e0e0837e0bc8a24", "552c30bbda2cfe5d4eb7ccdb"};
    
    String spacd_ans[] = {/*"mixture", "a", "TRUE"*/
	"TRUE", "mixture", "TRUE"};
    
    String mem_ans[] = {"6", "5", "2"};
    
    String diag_title = "Homogeneous Mixture";
    
    String mem_title = "Testing hypotheses";
    
    //String mem_title = "Mixture";
    
    String adaptive_title = "Dividing by 9";
    
    String diagnose_header = "Need more help";
    
    
    String ans[] = {"8", "2", "7", "6", "4"};
    //String ans[] = {"8", "2", "7", "6", "4", "5", "3", "1", "9", "10" };
    String diag_QID[] = {"1", "2", "3", "4", "5"};
    String diag_ans[] = {"1", "2"};
    
    
    public PracticePage (AppiumDriver driver) {
	super (driver);
    }
    
    public boolean verifyPracticeCoverSheet () {
	wait.until (ExpectedConditions.visibilityOf (testTitle));
	try {
	    if (backButton.isDisplayed () && testTitle.isDisplayed () && practiceScoreContainer.isDisplayed ()
		&& practiceCoverSheetContainer.isDisplayed () && practiceGoalMessage.isDisplayed () && startPracticing.isDisplayed ()) {
		//break;
	    }
	    //retry--;
	    System.out.println ("Practice cover sheet page appears....");
	} catch (Exception e) {
	    e.printStackTrace ();
	}
	System.out.println ("Practice Goal message is" + practiceGoalMessage.getText ());
	return true;
    }
    
    public String getTestTitle () {
	String title = testTitle.getText ();
	return title;
    }
    
    public boolean startPractice (boolean walkthrough) {
	try {
	    if (startPracticing.isDisplayed ()) {
		startPracticing.click ();
		try {
		    Thread.sleep (5000);
		} catch (InterruptedException e) {
		    e.printStackTrace ();
		}
		if (walkthrough) {
		    skipWalkThrough ();
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace ();
	}
	return true;
    }
    
    public boolean skipWalkThrough () {
	if (walkThroughPage.isDisplayed ()) {
	    if (walkThroughImage.isDisplayed () && walkThroughStartPractice.isDisplayed ()) {
		System.out.println ("Practice walkthrough page appears...");
		walkThroughStartPractice.click ();
		try {
		    Thread.sleep (5000);
		} catch (InterruptedException e) {
		    e.printStackTrace ();
		}
	    }
	}
	return true;
    }
    
    public String getPracticeTunnelTestTitle () {
	String tunnelTitle = tunnelTestTitle.getText ();
	return tunnelTitle;
    }
    
    public boolean verifyPracticeTunnel () {
	try {
	    if (progressBlock.isDisplayed () && submitPractice.isDisplayed () && questionContainer.isDisplayed ()
		&& questionText.isDisplayed ()) {
		System.out.println ("Practice tunnel appears...");
		return true;
	    }
	} catch (Exception e) {
	    e.printStackTrace ();
	}
	return false;
    }
    
    public boolean submitPractice () {
	if (submitPractice.isDisplayed ()) {
	    submitPractice.click ();
	    try {
		Thread.sleep (4000);
	    } catch (InterruptedException e) {
		e.printStackTrace ();
	    }
	    System.out.println ("Practice submitted successfully");
	}
	return true;
    }
    
    public Boolean attemptPractice (String type, int numberOfQuestions, String assessmentTitle) {
	String testTitle = tunnelTestTitle.getText ();
	if (testTitle.equals (assessmentTitle)) {
	    System.out.println ("Testtitles are same");
	    for (int i = 1; i <=numberOfQuestions; i++) {
		System.out.println("Count is " + i);
		wait.until(ExpectedConditions.visibilityOf(questionContainer));
		wait.until(ExpectedConditions.visibilityOf(questionText));
		String questionType = questionText.getAttribute ("data-qtype");
		String questionID = questionText.getAttribute ("data-qid");
		System.out.println ("Member QuestionId:");
		System.out.println (questionID);
		System.out.println ("questiontype is" + questionType);
		if (questionType.equals ("fill-in-the-blanks")) {
		    this.validateFillInBlanksQuestion (questionID, "");
		} else if (questionType.equals ("short-answer")) {
		    validateShortAnswerQuestions(questionID, "");
		} else if (questionType.equals ("multiple-choice")) {
		    validateMultipleChoiceQuestion (questionID, "");
		} else if (questionType.equals ("true-false")) {
		    validateTrueFalseQuestiion (questionID, "");
		}
	    }
	}
	if (type.equals ("Get 10 Correct") && numberOfQuestions == 10) {
	    System.out.println ("Enter into the adaptive practice");
	    if (completePracticeModalPopup.isDisplayed ()) {
		if (stopForNowBtn.isDisplayed () && keepPracticingBtn.isDisplayed ()) {
		    System.out.println ("Get 10 correct popup appears");
		    // Keep practicing from the "You got 10 questions right" popup
		    keepPracticingBtn.click();
		    try {
			Thread.sleep (2000);
		    } catch (InterruptedException e) {
			e.printStackTrace ();
		    }
		}
	    }
	}
	if (type.equals ("diagnose") && numberOfQuestions == 4) {
	    System.out.println ("Diagnose pause");
	    try {
		Thread.sleep (5000);
	    } catch (InterruptedException e) {
		e.printStackTrace ();
	    }
	    if (diagnoseTestModalPopup.isDisplayed ()) {
		System.out.println ("Enter into the diagnose test flow");
		verifyDiagnoseTestModalPopup ();
	    }
	}
	if (type.equals ("memoryboost") && numberOfQuestions==10) {
	    System.out.println ("Spaced practice appears...");
	    try {
		Thread.sleep (3000);
	    } catch (InterruptedException e) {
		e.printStackTrace ();
	    }
	    if (memoryBoostInitModalPopup.isDisplayed ()) {
		if (memoryBoostInitModalPopupHeaderTxt.getText ().contains ("Getting")) {
		    System.out.println ("Memory boost popup appears");
		}
	    }
	}
	return true;
    }
    
    public void validateFillInBlanksQuestion (String questionID, String type) {
	System.out.println ("Validate Fill in the blanks");
        // Testing hypotheses
	if (type.equals ("diagnostic")) {
	    System.out.println ("Enter into the diagnose test loop fill..");
	    for (int i = 0; i < d_qIDs.length; i++) {
		System.out.println ("The questionID is" + questionID);
		if (questionID.equals (d_qIDs[i])) {
		    System.out.println ("Derived ID: " + d_qIDs[i] + "Actual ID: " + questionID);
		    try {
			if (fillInBlankBox1.isDisplayed () && fillInBlankBox2.isDisplayed ()) {
			    fillInBlankBox1.sendKeys (d_ans[i]);
			    fillInBlankBox2.sendKeys (d_ans[i]);
			} else {
			    BlankBox.isDisplayed ();
			    BlankBox.sendKeys (d_ans[i]);
			}
		    } catch (Exception e) {
			e.printStackTrace ();
		    }
		    try {
			Thread.sleep (1000);
		    } catch (InterruptedException e) {
			e.printStackTrace ();
		    }
		}
		if (diagnoseCheckItBtn.isDisplayed ()) {
		    System.out.println ("Diagnose Check it button is available");
		    diagnoseCheckItBtn.click ();
		    try {
			Thread.sleep (1000);
		    } catch (InterruptedException e) {
			e.printStackTrace ();
		    }
		}
	    }
	}
	// Dividing by 9
	if (tunnelTestTitle.getText ().equals (adaptive_title)) {
	    for (int i = 0; i < questionIDs.length; i++) {
		System.out.println ("The questionID is" + questionID);
		if (questionID.equals (questionIDs[i])) {
		    System.out.println ("Derived ID: " + questionIDs[i] + "Actual ID: " + questionID);
		    if (inputAnswerBox1.isDisplayed () && inputAnswerBox2.isDisplayed ()) {
			inputAnswerBox1.sendKeys (answers[i]);
			inputAnswerBox2.sendKeys (answers[i]);
			try {
			    Thread.sleep (1000);
			} catch (InterruptedException e) {
			    e.printStackTrace ();
			}
			if (checkitBtn.isDisplayed ()) {
			    System.out.println ("Check it button is available");
			    checkitBtn.click ();
			    try {
				Thread.sleep (1000);
			    } catch (InterruptedException e) {
				e.printStackTrace ();
			    }
			}
		    }
		}
	    }
	}
	//Diagnose test
	if (tunnelTestTitle.getText ().equals (diag_title)) {
	    System.out.println ("Enter into the loop...");
	    for (int i = 0; i < h_qIDs.length; i++) {
		System.out.println ("The questionID is" + questionID);
		if (questionID.equals (h_qIDs[i])) {
		    System.out.println ("Derived ID: " + h_qIDs[i] + "Actual ID: " + questionID);
		    try {
			if (BlankBox.isDisplayed()) {
			    BlankBox.sendKeys(h_ans[i]);
			} else if (fillInBlankBox1.isDisplayed () && fillInBlankBox2.isDisplayed ()) {
			    fillInBlankBox1.sendKeys(h_ans[i]);
			    fillInBlankBox2.sendKeys(h_ans[i]);
			}
		    } catch (Exception e) {
			e.printStackTrace ();
		    }
		}
	    }
	    if (checkitBtn.isDisplayed ()) {
		System.out.println ("Check it button is available");
		checkitBtn.click ();
		try {
		    Thread.sleep (1000);
		} catch (InterruptedException e) {
		    e.printStackTrace ();
		}
	    }
	}
	// Spaced practice
	if (type.equals ("spacedPractice")) {
	    System.out.println ("Enter into the memory loop...");
	    for (int i = 0; i < mem_qIDs.length; i++) {
		System.out.println ("The questionID is" + questionID);
		if (questionID.equals (mem_qIDs[i])) {
		    System.out.println ("Derived ID: " + mem_qIDs[i] + "Actual ID: " + questionID);
		    if (fillInBlankBox1.isDisplayed ()) {
			fillInBlankBox1.sendKeys (spacd_ans[i]);
			try {
			    Thread.sleep (500);
			} catch (InterruptedException e) {
			    e.printStackTrace ();
			}
			if (memoryBoostCheckItBtn.isDisplayed ()) {
			    System.out.println ("Check it button is available");
			    memoryBoostCheckItBtn.click ();
			    try {
				Thread.sleep (1000);
			    } catch (InterruptedException e) {
				e.printStackTrace ();
			    }
			}
		    }
		}
	    }
	    if (memoryBoostNextBtn.isDisplayed ()) {
		System.out.println ("Memory boost Next button is available");
		memoryBoostNextBtn.click ();
		try {
		    Thread.sleep (1000);
		} catch (InterruptedException e) {
		    e.printStackTrace ();
		}
	    } else {
		System.out.println ("Memory boost Next button not available");
		try {
		    Thread.sleep (1000);
		} catch (InterruptedException e) {
		    e.printStackTrace ();
		}
	    }
	}
	//Homogeneous mixture
	if (tunnelTestTitle.getText ().equals (mem_title)) {
	    for (int i = 0; i < h_qIDs.length; i++) {
		System.out.println ("The questionID is" + questionID);
		if (questionID.equals (h_qIDs[i])) {
		    System.out.println ("Derived ID: " + h_qIDs[i] + "Actual ID: " + questionID);
		    if (BlankBox.isDisplayed ()) {
			BlankBox.sendKeys (h_ans[i]);
			try {
			    Thread.sleep (500);
			} catch (InterruptedException e) {
			    e.printStackTrace ();
			}
			if (checkitBtn.isDisplayed ()) {
			    System.out.println ("Check it button is available");
			    checkitBtn.click ();
			    try {
				Thread.sleep (1000);
			    } catch (InterruptedException e) {
				e.printStackTrace ();
			    }
			}
		    }
		}
	    }
	}
	if (nextQuestionBtn.isDisplayed ()) {
	    System.out.println ("Next button is available");
	    nextQuestionBtn.click ();
	    try {
		Thread.sleep (500);
	    } catch (InterruptedException e) {
		e.printStackTrace ();
	    }
	} else {
	    System.out.println ("Next button not available");
	    try {
		Thread.sleep (1000);
	    } catch (InterruptedException e) {
		e.printStackTrace ();
	    }
	}
	if (diagnoseNextBtn.isDisplayed ()) {
	    System.out.println ("Diagnose Next button is available");
	    diagnoseNextBtn.click ();
	    try {
		Thread.sleep (500);
	    } catch (InterruptedException e) {
		e.printStackTrace ();
	    }
	} else {
	    System.out.println ("Diagnose Next button not available");
	    try {
		Thread.sleep (1000);
	    } catch (InterruptedException e) {
		e.printStackTrace ();
	    }
	}
    }
    
    //for (int i = 0; i < m_qIDs.length; i++) {
    
    public void validateMultipleChoiceQuestion (String questionID, String type) {
	// Testing hypotheses
	System.out.println ("Validate multiple choice");
	if (type.equals ("spacedPractice")) {
	    System.out.println ("Memory boost question container");
	    for (int i = 0; i < mem_qIDs.length; i++) {
	        System.out.println ("Derived ID: " + mem_qIDs[i] + "Actual ID: " + questionID);
	        if (questionID.equals (mem_qIDs[i])) {
	            List<WebElement> elements = driver.findElements (By.cssSelector ("div.cards.active div#dataResponseContainer li"));
	            System.out.println ("Elements size are" + elements.size ());
	            for (int k = 0; k <= elements.size () - 1; k++) {
	                String answer = elements.get (k).getText ();
	                System.out.println ("answer text is" + answer);
	                if (answer.equals (spacd_ans[i])) {
	                    try {
				Thread.sleep (1000);
			    }catch (InterruptedException e) {
	                        e.printStackTrace ();
	                    }
	                    elements.get (k).click ();
	                    try {
	                        Thread.sleep (1000);
	                    } catch (InterruptedException e) {
	                        e.printStackTrace ();
	                    }
	                }
	            }
	        }
	    }
	    if (memoryBoostNextBtn.isDisplayed ()) {
	        System.out.println ("Memory boost Next button is available");
	        memoryBoostNextBtn.click ();
	        try {
	            Thread.sleep (1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace ();
	        }
	    }else {
	        System.out.println ("Memory boost Next button not available");
	        try {
	            Thread.sleep (1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace ();
	        }
	    }
	}
	if (tunnelTestTitle.getText ().equals (diag_title)) {
	    for (int i = 0; i < h_ans.length; i++) {
		System.out.println ("Derived ID: " + h_qIDs[i] + "Actual ID: " + questionID);
		if (questionID.equals (h_qIDs[i])) {
		    List<WebElement> elements = driver.findElements (By.cssSelector ("li.response-row div.display-text"));
		    System.out.println ("Elements size are" + elements.size ());
		    for (int k = 0; k <= elements.size () - 1; k++) {
			String answer = elements.get (k).getText ();
			System.out.println ("answer text is" + answer);
			if (answer.equals (h_ans[i])) {
			    try {
				Thread.sleep (1000);
			    } catch (InterruptedException e) {
				e.printStackTrace ();
			    }
			    elements.get (k).click ();
			    System.out.println ("answer choose successfully");
			    try {
				Thread.sleep (500);
			    } catch (InterruptedException e) {
				e.printStackTrace ();
			    }
			}
		    }
		}
	    }
	}
	// Homogeneous mixutre
	if (tunnelTestTitle.getText ().equals (mem_title)) {
	    System.out.println ("Homogeneous");
	    for (int i = 0; i < h_qIDs.length; i++) {
		System.out.println ("Derived ID: " + h_qIDs[i] + "Actual ID: " + questionID);
		if (questionID.equals (h_qIDs[i])) {
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dataResponseContainer);
		    List<WebElement> elements = driver.findElements (By.cssSelector ("li.response-row div.display-text"));
		    System.out.println ("Elements size are" + elements.size ());
		    for (int k = 0; k <= elements.size () - 1; k++) {
			String answer = elements.get (k).getText ();
			System.out.println ("answer text is" + answer);
			if (answer.equals (h_ans[i])) {
			    try {
				Thread.sleep (1000);
			    } catch (InterruptedException e) {
				e.printStackTrace ();
			    }
			    elements.get (k).click ();
			    System.out.println ("answer choose successfully");
			    try {
				Thread.sleep (500);
			    } catch (InterruptedException e) {
				e.printStackTrace ();
			    }
			}
		    }
		}
	    }
	}
	if (type.equals ("diagnostic")) {
	    System.out.println ("Diagnose test flow mc");
	    for (int i = 0; i < d_qIDs.length; i++) {
		System.out.println ("Derived ID: " + d_qIDs[i] + "Actual ID: " + questionID);
		if (questionID.equals (d_qIDs[i])) {
		    List<WebElement> elements = driver.findElements (By.cssSelector ("#dtAttemptModal div.dt-cards div#dataResponseContainer ul > li"));
		    System.out.println ("Elements size are" + elements.size ());
		    for (int k = 0; k <= elements.size () - 1; k++) {
			String answer = elements.get (k).getText ();
			System.out.println ("answer text is" + answer);
			if (answer.contains (d_ans[i])) {
			    try {
				Thread.sleep (1000);
			    } catch (InterruptedException e) {
				e.printStackTrace ();
			    }
			    elements.get (k).click ();
			    try {
				Thread.sleep (500);
			    } catch (InterruptedException e) {
				e.printStackTrace ();
			    }
			}
		    }
		}
	    }
	}
	if (nextQuestionBtn.isDisplayed ()) {
	    System.out.println ("Next button is available");
	    nextQuestionBtn.click ();
	    try {
		Thread.sleep (1000);
	    } catch (InterruptedException e) {
		e.printStackTrace ();
	    }
	} else {
	    System.out.println ("Next button not available");
	    try {
		Thread.sleep (1000);
	    } catch (InterruptedException e) {
		e.printStackTrace ();
	    }
	}
	if (diagnoseNextBtn.isDisplayed ()) {
	    System.out.println ("Diagnose Next button is available");
	    diagnoseNextBtn.click ();
	    try {
		Thread.sleep (500);
	    } catch (InterruptedException e) {
		e.printStackTrace ();
	    }
	} else {
	    System.out.println ("Diagnose Next button not available");
	    try {
		Thread.sleep (500);
	    } catch (InterruptedException e) {
		e.printStackTrace ();
	    }
	}
    }
    
    public void validateTrueFalseQuestiion (String questionID, String type) {
	System.out.println ("Validate true false question");
	// Diagnose test
	if (type.equals ("diagnostic")) {
	    System.out.println ("Diagnose test flow true/false");
	    for (int i = 0; i < d_qIDs.length; i++) {
		System.out.println ("Derived ID: " + d_qIDs[i] + "Actual ID: " + questionID);
		if (questionID.equals (d_qIDs[i])) {
		    List<WebElement> elements = driver.findElements (By.cssSelector ("#dtAttemptModal div.dt-cards div#dataResponseContainer ul > li"));
		    System.out.println ("Elements size are" + elements.size ());
		    for (int k = 0; k <= elements.size () - 1; k++) {
			String answer = elements.get (k).getText ();
			System.out.println ("answer text is" + answer);
			if (answer.equals (d_ans[i])) {
			    try {
				Thread.sleep (1000);
			    } catch (InterruptedException e) {
				e.printStackTrace ();
			    }
			    elements.get (k).click ();
			    try {
				Thread.sleep (500);
			    } catch (InterruptedException e) {
				e.printStackTrace ();
			    }
			}
		    }
		}
	    }
	    
	}
	// Spaced practice
	if (type.equals ("spacedPractice")) {
	    System.out.println ("Memory boost question container");
	    for (int i = 0; i < mem_qIDs.length; i++) {
		System.out.println ("Derived ID: " + mem_qIDs[i] + "Actual ID: " + questionID);
		if (questionID.equals (mem_qIDs[i])) {
		    List<WebElement> elements = driver.findElements (By.cssSelector ("div.cards.active div#dataResponseContainer li"));
		    System.out.println ("Elements size are" + elements.size ());
		    for (int k = 0; k <= elements.size () - 1; k++) {
			String answer = elements.get (k).getText ();
			System.out.println ("answer text is" + answer);
			if (answer.equals (spacd_ans[i])) {
			    try {
				Thread.sleep (1000);
			    } catch (InterruptedException e) {
				e.printStackTrace ();
			    }
			    elements.get (k).click ();
			    try {
				Thread.sleep (1000);
			    } catch (InterruptedException e) {
				e.printStackTrace ();
			    }
			}
		    }
		}
	    }
	    if (memoryBoostNextBtn.isDisplayed ()) {
		System.out.println ("Memory boost Next button is available");
		memoryBoostNextBtn.click ();
		try {
		    Thread.sleep (1000);
		} catch (InterruptedException e) {
		    e.printStackTrace ();
		}
	    } else {
		System.out.println ("Memory boost Next button not available");
		try {
		    Thread.sleep (1000);
		} catch (InterruptedException e) {
		    e.printStackTrace ();
		}
	    }
	}
	// Testing hypotheses
	if (tunnelTestTitle.getText ().equals (diag_title)) {
	    for (int i = 0; i < h_qIDs.length; i++) {
		System.out.println ("Derived ID: " + h_qIDs[i] + "Actual ID: " + questionID);
		if (questionID.equals (h_qIDs[i])) {
		    List<WebElement> elements = driver.findElements (By.cssSelector ("li.response-row div.display-text"));
		    System.out.println ("Elements size are" + elements.size ());
		    for (int k = 0; k <= elements.size () - 1; k++) {
			String answer = elements.get (k).getText ();
			System.out.println ("answer text is" + answer);
			if (answer.equals (h_ans[i])) {
			    try {
				Thread.sleep (1000);
			    } catch (InterruptedException e) {
				e.printStackTrace ();
			    }
			    elements.get (k).click ();
			    try {
				Thread.sleep (500);
			    } catch (InterruptedException e) {
				e.printStackTrace ();
			    }
			}
		    }
		}
	    }
	}
	// Homogeneous mixture
	if (tunnelTestTitle.getText ().equals (mem_title)) {
	    System.out.println ("H");
	    for (int i = 0; i < h_qIDs.length; i++) {
		System.out.println ("Derived ID: " + h_qIDs[i] + "Actual ID: " + questionID);
		if (questionID.equals (h_qIDs[i])) {
		    List<WebElement> elements = driver.findElements (By.cssSelector ("li.response-row div.display-text"));
		    System.out.println ("Elements size are" + elements.size ());
		    for (int k = 0; k <= elements.size () - 1; k++) {
			String answer = elements.get (k).getText ();
			System.out.println ("answer text is" + answer);
			if (answer.equals (h_ans[i])) {
			    try {
				Thread.sleep (1000);
			    } catch (InterruptedException e) {
				e.printStackTrace ();
			    }
			    elements.get (k).click ();
			    try {
				Thread.sleep (500);
			    } catch (InterruptedException e) {
				e.printStackTrace ();
			    }
			}
		    }
		}
	    }
	}
	if (nextQuestionBtn.isDisplayed ()) {
	    System.out.println ("Next button is available");
	    nextQuestionBtn.click ();
	    try {
		Thread.sleep (1000);
	    } catch (InterruptedException e) {
		e.printStackTrace ();
	    }
	} else {
	    System.out.println ("Next button not available");
	}
	if (diagnoseNextBtn.isDisplayed ()) {
	    System.out.println ("Diagnose Next button is available");
	    diagnoseNextBtn.click ();
	    try {
		Thread.sleep (500);
	    } catch (InterruptedException e) {
		e.printStackTrace ();
	    }
	} else {
	    System.out.println ("Diagnose Next button not available");
	    try {
		Thread.sleep (500);
	    } catch (InterruptedException e) {
		e.printStackTrace ();
	    }
	}
    }
    
    public void validateShortAnswerQuestions (String questionID, String type) {
	// Spaced practice
	if (type.equals ("spacedPractice")) {
	    System.out.println ("Memory boost question container");
	    for (int i = 0; i < mem_qIDs.length; i++) {
		System.out.println ("The questionID is" + questionID);
		if (questionID.equals (mem_qIDs[i])) {
		    System.out.println ("Derived ID: " + mem_qIDs[i] + "Actual ID: " + questionID);
		    if (shortAnswerBox.isDisplayed ()) {
			shortAnswerBox.sendKeys (spacd_ans[i]);
			try {
			    Thread.sleep (500);
			} catch (InterruptedException e) {
			    e.printStackTrace ();
			}
			if (memoryBoostCheckItBtn.isDisplayed ()) {
			    System.out.println ("Check it button is available");
			    memoryBoostCheckItBtn.click ();
			    try {
				Thread.sleep (1000);
			    } catch (InterruptedException e) {
				e.printStackTrace ();
			    }
			}
		    }
		}
	    }
	}
	if (tunnelTestTitle.getText ().equals (diag_title)) {
	    for (int i = 0; i < h_qIDs.length; i++) {
		System.out.println ("The questionID is" + questionID);
		if (questionID.equals (h_qIDs[i])) {
		    System.out.println ("Derived ID: " + h_qIDs[i] + "Actual ID: " + questionID);
		    if (shortAnswerBox.isDisplayed ()) {
			shortAnswerBox.sendKeys (h_ans[i]);
			try {
			    Thread.sleep (500);
			} catch (InterruptedException e) {
			    e.printStackTrace ();
			}
			if (checkitBtn.isDisplayed ()) {
			    System.out.println ("Check it button is available");
			    checkitBtn.click ();
			    try {
				Thread.sleep (1000);
			    } catch (InterruptedException e) {
				e.printStackTrace ();
			    }
			}
		    }
		}
	    }
	}
	if (type.equals("diagnostic")) {
	    for (int i = 0; i < d_qIDs.length; i++) {
		System.out.println ("The questionID is" + questionID);
		if (questionID.equals (d_qIDs[i])) {
		    System.out.println ("Derived ID: " + d_qIDs[i] + "Actual ID: " + questionID);
		    if (diagnoseShortAnswerBox.isDisplayed ()) {
			diagnoseShortAnswerBox.sendKeys (d_ans[i]);
			try {
			    Thread.sleep (500);
			} catch (InterruptedException e) {
			    e.printStackTrace ();
			}
			if (diagnoseCheckItBtn.isDisplayed ()) {
			    System.out.println ("Check it button is available");
			    diagnoseCheckItBtn.click ();
			    try {
				Thread.sleep (1000);
			    } catch (InterruptedException e) {
				e.printStackTrace ();
			    }
			}
		    }
		}
	    }
	}
	if (nextQuestionBtn.isDisplayed ()) {
	    System.out.println ("Next button is available");
	    nextQuestionBtn.click ();
	    try {
		Thread.sleep (1000);
	    } catch (InterruptedException e) {
		e.printStackTrace ();
	    }
	} else {
	    System.out.println ("Next button not available");
	}
	if (memoryBoostNextBtn.isDisplayed ()) {
	    System.out.println ("Memory boost Next button is available");
	    memoryBoostNextBtn.click ();
	    try {
		Thread.sleep (500);
	    } catch (InterruptedException e) {
		e.printStackTrace ();
	    }
	} else {
	    System.out.println ("Memory boost Next button not available");
	    try {
		Thread.sleep (1000);
	    } catch (InterruptedException e) {
		e.printStackTrace ();
	    }
	}
	if (diagnoseNextBtn.isDisplayed ()) {
	    System.out.println ("Diagnose Next button is available");
	    diagnoseNextBtn.click ();
	    try {
		Thread.sleep (500);
	    } catch (InterruptedException e) {
		e.printStackTrace ();
	    }
	} else {
	    System.out.println ("Diagnose Next button not available");
	    try {
		Thread.sleep (500);
	    } catch (InterruptedException e) {
		e.printStackTrace ();
	    }
	}
    }
    
    public boolean verifyDiagnoseTestModalPopup () {
	if (speechInfoMessagePopup.isDisplayed () && diagnoseTestModalHeading.isDisplayed ()
	    && denydiagnoseTest.isDisplayed () && iconCheckMark.isDisplayed ()) {
	    System.out.println ("Diagnose test modal popup appears...");
	}
	closeSpeechInfoPopup.click ();
	return true;
    }
    
    public boolean attenddiagnoseTest (int numberOfQuestions) {
	for (int i = 1; i <= numberOfQuestions; i++) {
	    String questionType = diagnoseQuestionText.getAttribute ("data-qtype");
	    String questionID = diagnoseQuestionText.getAttribute ("data-qid");
	    System.out.println ("Member QuestionId:");
	    System.out.println (questionID);
	    System.out.println ("questiontype is" + questionType);
	    if (questionType.equals ("fill-in-the-blanks")) {
		this.validateFillInBlanksQuestion(questionID, "diagnostic");
	    } else if (questionType.equals ("short-answer")) {
	        this.validateShortAnswerQuestions (questionID, "diagnostic");
	    } else if (questionType.equals ("multiple-choice")) {
		validateMultipleChoiceQuestion (questionID, "diagnostic");
	    } else if (questionType.equals ("true-false")) {
		validateTrueFalseQuestiion (questionID, "diagnostic");
	    }
	}
	return true;
    }
    
    public boolean verifyRecommendationCompletePage () {
	wait.until (ExpectedConditions.visibilityOf (viewRecommendationBtn));
	if (checkMarkContainer.isDisplayed () && recommendationCompleteMessage.isDisplayed ()) {
	    System.out.println ("Recommendation complete message is" + recommendationCompleteMessage.getText ());
	}
	viewRecommendationBtn.click ();
	try {
	    Thread.sleep (2000);
	} catch (InterruptedException e) {
	    e.printStackTrace ();
	}
	return true;
    }
    
    public boolean verifyAndAccessRecommendedModality () {
        wait.until(ExpectedConditions.visibilityOf(diagnoseRecommendationPopup));
	if (diagnoseRecommendationPopup.isDisplayed ()) {
	    if (recommendationHDRTxt.isDisplayed () && conceptTitleInRecommendationPopup.isDisplayed ()
		&& recommendedModality.isDisplayed () && unLockMessage.isDisplayed ()) {
		System.out.println ("Recommendation popup appears...");
	    }
	}
	recommendedModality.click ();
	try {
	    Thread.sleep (5000);
	} catch (InterruptedException e) {
	    e.printStackTrace ();
	}
	return true;
    }
    
    //IOS
    public boolean verifyEmbedRecommendedModality () {
	switchToWebViewContext ("NATIVE_APP");
	System.out.println ("Embed page appear");
	switchToWebViewContext ("WEBVIEW");
	if (embedModalityTitle.isDisplayed () && closeEmbedModalityPage.isDisplayed ()) {
	    //((JavascriptExecutor) webDriver).executeScript("$($(\".icon-arrow\")).trigger(\"click\")");
	    closeEmbedModalityPage.click ();
	}
	driver.navigate ().back ();
	System.out.println ("back button clicked successfully");
	switchToWebViewContext ("WEBVIEW");
	try {
	    Thread.sleep (10000);
	} catch (InterruptedException e) {
	    e.printStackTrace ();
	}
	return true;
    }
    
    
    public boolean verifyEmbedModalityPopup () {
	//if (System.getProperty ("profileDriver").contains ("android")) {
	try {
	    Thread.sleep (5000);
	} catch (InterruptedException e) {
	    e.printStackTrace ();
	}
	System.out.println ("Embed page appear");
	System.out.println (driver.getWindowHandles ());
	String oldHandle = driver.getWindowHandle ();
	System.out.println (oldHandle);
	for (String winHandle : driver.getWindowHandles ()) {
	    driver.switchTo ().window (winHandle);
	    System.out.println ("Changed to " + winHandle);
	    System.out.println (driver.getTitle ());
	    System.out.println (driver.getCurrentUrl ());
	    if (driver.getCurrentUrl ().contains ("embed")) {
		System.out.println ("Switched to new window");
		if (embedModalityTitle.isDisplayed () && closeEmbedModalityPage.isDisplayed ()) {
		    closeEmbedModalityPage.click ();
		}
	    }
	}
	try {
	    Thread.sleep (10000);
	} catch (InterruptedException e) {
	    e.printStackTrace ();
	}
	driver.switchTo ().window (oldHandle);
	System.out.println ("##############");
	System.out.println (driver.getCurrentUrl ());
	return true;
    }
    
    public boolean returnToPractice () {
	switchToWebViewContext ("WEBVIEW");
	System.out.println ("Recommendation page");
	//System.out.println (driver.getPageSource ());
	try {
	    Thread.sleep (2000);
	} catch (InterruptedException e) {
	    e.printStackTrace ();
	}
	if (recommendedModalityCheckMark.isDisplayed ()) {
	    System.out.println ("Recommendation popup appers again after come back from embed page");
	}
	unLockMessage.click ();
	try {
	    Thread.sleep (1000);
	} catch (InterruptedException e) {
	    e.printStackTrace ();
	}
	return true;
    }
    
    public boolean verifyMemoryBoostQuestionsPopup () {
	try {
	    Thread.sleep (1000);
	} catch (InterruptedException e) {
	    e.printStackTrace ();
	}
	if (memoryBoostAttemptModalPopup.isDisplayed ()) {
	    if (memoryBoostQuestionContainer.isDisplayed () && memoryBoostQuestionText.isDisplayed () &&
		headerTextInMemoryBoostPopup.isDisplayed () && closeIconInMemoryBoostPopup.isDisplayed () &&
		boostToolTipIcon.isDisplayed () && memoryBoostCheckMarkContainer.isDisplayed ()) {
		if (headerTextInMemoryBoostPopup.getText ().contains ("Memory boost")) {
		    System.out.println ("Memory boost question modal popup appear");
		}
	    }
	}
	return true;
    }
    
    
    public boolean attendMemoryBoostQuestions (int numberOfQuestions) {
	for (int i = 0; i < numberOfQuestions; i++) {
	    System.out.println("count is" +i);
	    String questionType = memoryBoostQuestionText.getAttribute ("data-qtype");
	    String questionID = memoryBoostQuestionText.getAttribute ("data-qid");
	    System.out.println ("Member QuestionId:");
	    System.out.println (questionID);
	    System.out.println ("questiontype is" + questionType);
	    if (questionType.equals ("fill-in-the-blanks")) {
		this.validateFillInBlanksQuestion (questionID, "spacedPractice");
	    } else if (questionType.equals ("short-answer")) {
		this.validateShortAnswerQuestions (questionID, "spacedPractice");
	    } else if (questionType.equals ("multiple-choice")) {
		validateMultipleChoiceQuestion (questionID, "spacedPractice");
	    } else if (questionType.equals ("true-false")) {
		validateTrueFalseQuestiion (questionID, "spacedPractice");
	    }
	}
	try {
	    Thread.sleep (2000);
	} catch (InterruptedException e) {
	    e.printStackTrace ();
	}
	// Memory boost feedback modal popup
	if (memoryBoostFeedbackModalPopup.isDisplayed ()) {
	    if (headerMsgInFeedbackModalPopup.getText ().contains ("bonus questions")) {
		System.out.println ("Memory boost feedback modal popup appear");
		if (smileyIcon.isDisplayed ()) {
		    smileyIcon.click ();
		}
		try {
		    Thread.sleep (2000);
		} catch (InterruptedException e) {
		    e.printStackTrace ();
		}
		if (stopPracticingBtnInMemoryBoostPopup.isDisplayed () && keepPracticingBtnInMemoryBoostPopup.isDisplayed ()) {
		    System.out.println ("Stop for now and keep practicing button appears");
		}
	    }
	}
	return true;
    }
    
    public boolean keepPracticingFromSpacedPracticePopup () {
	if (keepPracticingBtnInMemoryBoostPopup.isDisplayed ()) {
	    keepPracticingBtnInMemoryBoostPopup.click ();
	    try {
		Thread.sleep (2000);
	    } catch (InterruptedException e) {
		e.printStackTrace ();
	    }
	    System.out.println ("Return to the practice tunnel");
	}
	return true;
    }
    
    public boolean stopPracticingFromSpacedPracticePopup() {
	if (stopPracticingBtnInMemoryBoostPopup.isDisplayed ()) {
	    stopPracticingBtnInMemoryBoostPopup.click ();
	    try {
		Thread.sleep (2000);
	    } catch (InterruptedException e) {
		e.printStackTrace ();
	    }
	    System.out.println ("Return to the practice reports page");
	}
	return true;
    }
    public boolean verifyImproveThisQuestionPopup () {
	try {
	    Thread.sleep (1000);
	} catch (InterruptedException e) {
	    e.printStackTrace ();
	}
	if (improveThisQuestionLnk.isDisplayed ()) {
	    improveThisQuestionLnk.click ();
	    try {
		Thread.sleep (1000);
	    } catch (InterruptedException e) {
		e.printStackTrace ();
	    }
	    if (improveThisQuestionMessage.isDisplayed () && improveErrorTypeDropDown.isDisplayed () &&
		improveErrorDetails.isDisplayed () && closeImproveThisQuestionPopup.isDisplayed ()) {
		System.out.println (improveThisQuestionMessage.getText ());
		System.out.println ("Improve this question popup appears...");
		Select se = new Select (improveErrorTypeDropDown);
		se.selectByIndex (2);
		System.out.println ("Selected error type is" + se);
		improveErrorDetails.sendKeys ("Testing");
		if (improveSubmitErrorReport.isDisplayed ()) {
		    improveSubmitErrorReport.click ();
		    try {
			Thread.sleep (2000);
		    } catch (InterruptedException e) {
			e.printStackTrace ();
		    }
		}
		closeImproveThisQuestionPopup.click ();
		try {
		    Thread.sleep (1000);
		} catch (InterruptedException e) {
		    e.printStackTrace ();
		}
		System.out.println ("Report container closed and returns to practice tunnel");
	    }
	}
	return true;
    }
    
    public boolean verifyScratchpad () {
	try {
	    Thread.sleep (1000);
	} catch (InterruptedException e) {
	    e.printStackTrace ();
	}
	if (scratchpad.isDisplayed ()) {
	    scratchpad.click ();
	    if (scratchpadTools.isDisplayed () && closeScratchpadContainer.isDisplayed ()) {
		System.out.println ("scratchpad container appears...");
	    }
	    closeScratchpadContainer.click ();
	    System.out.println ("Scratchpad closed and returns to practice tunnel");
	    try {
		Thread.sleep (1000);
	    } catch (InterruptedException e) {
		e.printStackTrace ();
	    }
	}
	return true;
    }
    
    public boolean verifyAndMarkSolution () {
	try {
	    Thread.sleep (2000);
	} catch (InterruptedException e) {
	    e.printStackTrace ();
	}
	if (inputAnswerBox1.isDisplayed () && inputAnswerBox2.isDisplayed ()) {
	    inputAnswerBox1.sendKeys ("a");
	    inputAnswerBox2.sendKeys ("b");
	    checkitBtn.click ();
	    try {
		Thread.sleep (1000);
	    } catch (InterruptedException e) {
		e.printStackTrace ();
	    }
	    if (solution.isDisplayed ()) {
		solution.click ();
		if (solutionHeader.isDisplayed () && solutionGotItBtn.isDisplayed ()) {
		    System.out.println ("Solution container appears...");
		}
		solutionGotItBtn.click ();
		System.out.println ("Solution container closed and returns to practice tunnel");
		try {
		    Thread.sleep (1000);
		} catch (InterruptedException e) {
		    e.printStackTrace ();
		}
	    }
	}
	return true;
    }
    
    public boolean verifyPracticeReportsPage () {
	try {
	    Thread.sleep (3000);
	} catch (InterruptedException e) {
	    e.printStackTrace ();
	}
	wait.until(ExpectedConditions.visibilityOf(adaptiveTestContainer));
	if (scoreReportBlock.isDisplayed () && practiceScore.isDisplayed() && testDetailsInReportsPage.isDisplayed()) {
	    System.out.println ("Practice reports page appears...");
	    if (correctAnswerSection.isDisplayed () && bestStreakSection.isDisplayed ()
		&& timeSpentSection.isDisplayed () && skillLevelSection.isDisplayed ()){
		System.out.println ("Test Details container appears...");
	    }
	}
	return true;
    }
    
    public boolean verifyUserAttendedQuestionsAndDetails () {
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", reviewYourAnswerHdrTxt);
	if (reviewYourAnswerHdrTxt.getText().contains("Review")) {
	    System.out.println(reviewYourAnswerHdrTxt.getText());
	    if (difficultyLevelReportContainer.isDisplayed ()) {
		if (allQuestionFilterCircle.isDisplayed () && easyQuestionFilterCircle.isDisplayed ()
		    && mediumQuestionFilterCircle.isDisplayed () && hardQuestionFilterCircle.isDisplayed ()) {
		    System.out.println ("Review your answer section appears in the reports page...");
		    if (allQuestionDifficultyFilter.isDisplayed ()) {
			allQuestionDifficultyFilter.click ();
			try {
			    Thread.sleep (1000);
			} catch (InterruptedException e) {
			    e.printStackTrace ();
			}
			if (attemptQuestionsContainer.isDisplayed ()) {
			    System.out.println ("Verified the user attended questions and its answers in the reports page");
			    try {
				Thread.sleep (1000);
			    } catch (InterruptedException e) {
				e.printStackTrace ();
			    }
			}
		    }
		}
	    }
	}
	return true;
    }
    
    public boolean goToNextConceptCoverSheet() {
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextConceptBtn);
        if (nextConceptBtn.isDisplayed()) {
            nextConceptBtn.click();
	    try {
		Thread.sleep (2000);
	    } catch (InterruptedException e) {
		e.printStackTrace ();
	    }
	    verifyPracticeCoverSheet();
	}
	return true;
    }
    
    public boolean keepPracticingFromReportsPage() {
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", keepPracticing);
        if (keepPracticing.isDisplayed()) {
	    keepPracticing.click();
	    try {
		Thread.sleep (2000);
	    } catch (InterruptedException e) {
		e.printStackTrace ();
	    }
	    verifyPracticeTunnel();
	    submitPractice();
	    verifyPracticeReportsPage();
	}
	return true;
    }
}





    
    
    
