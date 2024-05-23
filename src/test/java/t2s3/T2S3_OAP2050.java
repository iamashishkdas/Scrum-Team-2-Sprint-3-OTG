package t2s3;

import java.awt.Desktop;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;
import java.util.UUID;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.t2s3.common.GenericFunctionsOAP;
import com.t2s3.common.Utility;
import com.t2s3.pages.T2S3_OAP2050_Page;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
@Epic("OAP-30")
@Story("OAP-2050")
@Severity(SeverityLevel.MINOR)
public class T2S3_OAP2050
{
	public WebDriver driver;
	ChromeOptions options;
	GenericFunctionsOAP gf;
	T2S3_OAP2050_Page obj;
	Utility util;
	Properties prop;
	String assessmentDevURL,assessmentQCURL;
	String path = ".\\Screenshots";
	String configpath = "./src/main/java/com/t2s3/config/config.properties";
	ExtentReports extent = new ExtentReports();
	ExtentTest test;
	WebDriverWait wait;
	String testMethodName;
	Boolean value;
	String descriptiveTestName;
	int i, j, k;
	String concat=".";
	String html;
	@BeforeSuite
	public void extentReportConfig() {
		String fullName = new Object(){}.getClass().getEnclosingClass().getName();
		System.out.println(fullName);
		//com.oap.assessment.T2_S1_OAP1929
		String[] names=fullName.split("\\.");
		String className=names[names.length-1];
		System.out.println(className);
		//T2_S1_OAP1929
		html=System.getProperty("user.dir") + "./Reports/"+className+".html";
		System.out.println(html);
		//C:\Ashish\Eclipse\T2_S1./Reports/T2_S1_OAP1929.html
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(html);
		//C:\Ashish\Eclipse\T2_S1./Reports/T2_S1_OAP1929.html
		String docName=className+" Automation Test Execution Report";
		System.out.println(docName);
		htmlReport.config().setDocumentTitle(docName);
		//T2_S1_OAP1929 Automation Test Execution Report
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName(docName);
		//T2_S1_OAP1929 Automation Test Execution Report
		extent.attachReporter(htmlReport);
		extent.setSystemInfo("Environment", "Dev");
		extent.setSystemInfo("Author", "Ashish");
		extent.attachReporter(htmlReport);
	}
	@BeforeTest
	public void configSetUp	() throws IOException {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(configpath);
		prop.load(ip);
		assessmentDevURL = prop.getProperty("assessmentDevURL");
		assessmentQCURL=prop.getProperty("assessmentQCURL");
	}
	@BeforeClass
	public void stageApplicationSetUp() {
		try {
			WebDriverManager.chromedriver().setup();
			ChromeOptions dc = new ChromeOptions();
			dc.addArguments("--remote-allow-origins=*");
			dc.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(dc);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			gf = new GenericFunctionsOAP(driver);
			obj = new T2S3_OAP2050_Page(driver);
			util = new Utility(driver);
			gf.getUrl(assessmentDevURL);

		} catch (Exception e) {
			System.out.print(e);
		}
	}
	@BeforeMethod
	public void setup(Method method) {
		test = extent.createTest(method.getName(), method.getAnnotation(Description.class).value());
	}
	@AfterMethod
	public void teardown(ITestResult result) throws IOException {
		// Capture screenshot and attach it to the report if the test failed
		if (result.getStatus() == ITestResult.FAILURE) {
			test.fail("Test failed Screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(util.captureScreenshot()).build());
		}
		else {
			test.pass("Test passed Screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(util.captureScreenshot()).build());
		}
	}
	public void takeScreenshot() throws IOException {
		test.addScreenCaptureFromPath(concat + util.getScreenShot(driver, testMethodName + "_"));
		Allure.addAttachment(UUID.randomUUID().toString(),
				new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
	}
	@Description("TC01_Launch Assessment Platform")
	@Step("Launch Assessment Platform")
	@Test(priority = 1, testName = "TC01_Launch Assessment Platform")
	public void TC01_LaunchAssessmentPlatform() throws IOException, InterruptedException {
		try {
			i=obj.assessmentPlatformHome();
			Assert.assertEquals(i, 1);
			test.pass("Launched Assessment Platform Successfully");
			takeScreenshot();
		} catch (WebDriverException | AssertionError e) {
			test.fail("Assessment Platform Launch unsuccessful");
			takeScreenshot();
			test.fail(e);
			throw new AssertionError("Test failed: " + e.getMessage());
		}
	}
	@Description("TC02_Navigate To Question Bank Page")
	@Step("Navigate to Question Bank Page")
	@Test(priority = 2, testName = "TC02_NavigateToQuestionBankPage")
	public void TC02_NavigateToQuestionBankPage() throws IOException, InterruptedException {
		try {
			test.info("Test to navigate to Question Bank Page");
			i=obj.navigateToQuestionBankPage();
			Assert.assertEquals(i, 1);
			test.pass("Navigated to Question Bank Page Successfully");
			takeScreenshot();
		} catch (WebDriverException | AssertionError e) {
			test.fail("Question Bank Page should not Contains different Fields");
			takeScreenshot();
			test.fail(e);
			throw new AssertionError("Test failed: " + e.getMessage());
		}
	}

	@Description("TC03_Navigate To New Question Bank Page")
	@Step("Navigate to New Question Bank Page")
	@Test(priority = 3, testName = "TC03_NavigateToNewQuestionBankPage")
	public void TC03_NavigateToNewQuestionBankPage() throws IOException, InterruptedException {
		try {
			test.info("Test to navigate to New Question Bank Page");
			i=obj.navigateToNewQuestionBankPage();
			 Assert.assertEquals(i, 1);
				test.pass("Navigated to New Question Bank Page and Save Changes Button is inactive Validated Successfully");
				takeScreenshot();
		} catch (WebDriverException | AssertionError e) {
			test.fail("Navigation to New Question Bank Page and Save Changes Button is inactive Validation unsuccessful");
			 takeScreenshot();
			    test.fail(e);
			    throw new AssertionError("Test failed: " + e.getMessage());
		}
	}
	
	@Description("TC04_Navigate To add MCQ Page")
	@Step("Navigate to add MCQ Page")
	@Test(priority = 4, testName = "TC04_NavigateToAddMCQPage")
	public void TC04_NavigateToAddMCQPage() throws IOException, InterruptedException {
		try {
			test.info("Test to navigate to Add MCQ Page");
			i=obj.navigateToMCQPage();
			Assert.assertEquals(i, 1);
			test.pass("Navigated to add MCQ page and Save Changes Button is inactive Validated Successfully");
			takeScreenshot();
		} catch (WebDriverException | AssertionError e) {
			test.fail("Navigation to add MCQ page and Save Changes Button is inactive Validation unsuccessful");
			takeScreenshot();
			test.fail(e);
			throw new AssertionError("Test failed: " + e.getMessage());
		}
	}

	@Description("TC05_Validate Publish Button MCQ Enabled")
	@Step("Validate Publish Button of MCQ")
	@Test(priority = 5, testName = "TC05_ValidatePublishButtonMCQEnabled")
	public void TC05_ValidatePublishButtonMCQEnabled() throws IOException, InterruptedException {
		try {
			test.info("Test to validate Buttons");
			i=obj.addQuestionAnswerMCQPage();
			Assert.assertEquals(i, 1);
			test.pass("Save as Draft Button and Publish button Enabled after adding required fields Validated Successfully");
			takeScreenshot();
		} catch (WebDriverException | AssertionError e) {
			test.fail("Save as Draft Button and Publish button Enabled after adding required fields Validation unuccessfully");
			takeScreenshot();
			test.fail(e);
			throw new AssertionError("Test failed: " + e.getMessage());
		}
	}
	@Description("TC06_Validate Publish MCQ")
	@Step("Validate Publish MCQ")
	@Test(priority = 6, testName = "TC06_VadlidatePublishMCQ")
	public void TC06_VadlidatePublishMCQ() throws IOException, InterruptedException {
		try {
			test.info("Test to validate Publish MCQ Button");
			i=obj.publishMCQ();
			Assert.assertEquals(i, 1);
			test.pass("Validated Publish button of QB Enabled & Publish MCQ Button and navigated back to Question Bank page Successfully");
			takeScreenshot();
		} catch (WebDriverException | AssertionError e) {
			test.fail("Validation of Publish button of QB Enabled & Publish MCQ Button and navigated back to Question Bank page unsuccessful");
			takeScreenshot();
			test.fail(e);
			throw new AssertionError("Test failed: " + e.getMessage());
		}
	}
	@Description("TC07_Navigate To Edit Question")
	@Step("Navigate To Edit Question")
	@Test(priority = 7, testName = "TC07_Navigate To Edit Question")
	public void TC07_NavigateToEditQuestion() throws IOException, InterruptedException {
		try {
			test.info("Test to validate edit Published Question Bank");
			i=obj.editPublishedQuestion();
			Assert.assertEquals(i, 1);
			test.pass("Navigated to edit Published Question Successfully");
			takeScreenshot();
		} catch (WebDriverException | AssertionError e) {
			test.fail("Navigated to edit Published Question & archive button present validation unsuccessful");
			takeScreenshot();
			test.fail(e);
			throw new AssertionError("Test failed: " + e.getMessage());
		}
	}
	@Description("TC08_Validate Edit Enables Save_Publish")
	@Step("Validate Edit enables Save_Publish")
	@Test(priority = 8, testName = "TC08_ValidateEditEnablesSave_Publish")
	public void TC08_ValidateEditEnablesSave_Publish() throws IOException, InterruptedException {
		try {
			test.info("Test to Validate Save button in Popup");
			i=obj.editSaveQuestion();
			Assert.assertEquals(i, 1);
			test.pass("Save as draft and Publish button is enabled after editing any value validated Successfully");
			takeScreenshot();
		} catch (WebDriverException | AssertionError e) {
			test.fail("Save as draft and Publish button is enabled after editing any value validated unsuccessful");
			takeScreenshot();
			test.fail(e);
			throw new AssertionError("Test failed: " + e.getMessage());
		}
	}
	
		@AfterClass
		public void closeDriver() {
			driver.quit();
		}
	@AfterSuite 
	public void tearDown() throws IOException { 
		extent.flush();
		Desktop.getDesktop().browse(new File(html).toURI()); }

}
