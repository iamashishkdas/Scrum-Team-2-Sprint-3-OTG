package com.t2s3.common;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;



public class GenericFunctionsOAP{

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;

	public static String TESTDATA_SHEET_PATH = "xlsx";

	private FileInputStream fis;
	private FileOutputStream fileOut;
	private WorkbookFactory workbookfactory;
	private Workbook workbook;
	private Sheet sheet;
	private Row row;
	private Cell cell;
	static JavascriptExecutor js;
	static Actions act;
	Utility util;

	public String path;
	@FindBy(xpath = "//input[@name='userId']")
	WebElement uNameVessel;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passVessel;
	@FindBy(xpath = "//div[@data-test='SectionCollapse']/div/div[text()='Search']")
	WebElement searchSectionNew;
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchTextField;
	@FindBy(xpath = "(//div[.='Search'])[1]")
	WebElement searchButtonNew;
	@FindAll({
		@FindBy(xpath = "//div[@class='sc-PJClH kWnocW']"),@FindBy(id="pers_grid")})
	WebElement resultTable;
	@FindBy(xpath = "//button[.='Search']")
	WebElement searchButton;

	@FindBy(xpath = "//div[@data-test='PersonnelList']//div[@data-test='TableRow']")
	List<WebElement> tableRows;
	@FindBy(xpath = "//div[@data-test='PersonnelList']//div[@data-test='TableRowCol'][1]")
	List<WebElement> tableIDRows;
	@FindBy(xpath = "//div[@data-test='ProfileHeaderSectionCollapse']")
	WebElement personalCard;
	@FindBy(xpath = "//p[@data-test='ProfilePersonalUserId']")
	WebElement personalCardID;
	@FindBy(xpath = "//input[@name='customer']")
	WebElement companyMainOffice;

	@FindBy(xpath = "//input[@name='userId']")
	WebElement userNameMainOffice;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordMainOffice;

	@FindBy(xpath = "//h5")
	List<WebElement> headingsHomepage;
	@FindBy(name= "btnSubmit")
	WebElement Submitbtn;
	@FindBy(xpath = "//html")
	WebElement page;
	@FindBy(xpath = "//button[.='Close']//div")
	WebElement closePopup;
	@FindBy(xpath = "//div[.='Profile']")
	WebElement profile;
	@FindBy(xpath = "//p[.='Rank']")
	WebElement rank;
	@FindBy(xpath="//h2[@data-test='SectionTitleTitle']")
	WebElement heading;
	@FindBy(xpath = "//div[@data-test='Sidebar']")
	WebElement menuBar;
	

	
	Boolean value;
	static Properties prop=new Properties();
	public WebDriver driver;
	//public SP93_CMP14151_PageClass pg;


	public GenericFunctionsOAP(WebDriver driver) {
		this.driver = driver;	
		PageFactory.initElements(driver, this);	

	}
	
	public void getUrl(String url) throws InterruptedException  {
		Thread.sleep(2000);
		driver.get(url);
		Thread.sleep(2000);

	}
	public  void LoginToVessel(String uname,String password) throws InterruptedException {
		//		Thread.sleep(7000);
		waitTillElementVisible(uNameVessel);

		uNameVessel.sendKeys(uname);
		passVessel.sendKeys(password);
		passVessel.submit();
		//waitTillElementVisible(searchSectionNew);
	}
	public  void LoginToVesselOther(String uname,String password) throws InterruptedException {
		//		Thread.sleep(7000);
		waitTillElementVisible(uNameVessel);

		uNameVessel.sendKeys(uname);
		passVessel.sendKeys(password);
		passVessel.submit();
		waitTillElementVisible(othersWelcome);
		MouseHover(progressHeading);
		Thread.sleep(3000);
	}
	public int navigateToOwnPersonalCard(String id) throws InterruptedException
	{
		Thread.sleep(5000);
		if (page.getText().contains("Close")) {
			highlightElement(closePopup);
	         closePopup.click();
			}
			waitTillElementVisible(menuBar);
			
			MouseHover(menuBar);
			waitTillElementVisible(profile);
			highlightElement(profile);
			clickByJS(profile, driver);
			MouseHover(rank);
	        waitTillElementVisible(heading);
			value=heading.isDisplayed();
			highlightElement(heading);
			Wait(3000);
			if (value) return 1;
			else return 0;
	}
	public int searchForPersonnelFromOthers() throws IOException, InterruptedException {
		Thread.sleep(5000);
		if (page.getText().contains("Close")) {
			highlightElement(closePopup);
	         closePopup.click();
			}
			waitTillElementVisible(menuBar);
			MouseHover(menuBar);
			waitTillElementVisible(personnel);
			highlightElement(personnel);
			personnel.click();
			waitTillElementVisible(searchForPersonnel);
			highlightElement(personnel);
			searchForPersonnel.click();
			highlightElement(searchSectionNew);
			value=searchSectionNew.isDisplayed();			
		if (value) {
			return 1;
		} else {
			return 0;
		}
	}
	public int personalCard(String id)  {
		waitTillElementVisible(searchSectionNew);
		searchSectionNew.click();
		searchTextField.sendKeys(id);
		clickByJS(searchButton, driver);
		for (int i = 0; i < tableRows.size(); i++) {
			WindowScrollToTheElement(tableIDRows.get(i));
			if (tableIDRows.get(i).getText().trim().equals(id)) {
				clickByJS(tableIDRows.get(i), driver);
				break;
			} else {
			}
		}
		waitTillElementVisible(personalCard);
		highlightElement(personalCard);
		MouseHover(personalCard);
		waitTillElementVisible(personalCardID);
		highlightElement(personalCardID);
		value=personalCardID.getText().equals(id);
		if (value) return 1;
		else return 0;
	}
	public void oldVesselLogout() {
		MouseHover(menuBarOldVessel);
		waitTillElementVisible(logoutNew);
		logoutNew.click();
		waitTillElementVisible(uNameVessel);
	}
	public void vesselLogout() throws InterruptedException {
		MouseHover(menuBarNew);
		waitTillElementVisible(logoutNew);
		clickByJS(logoutNew, driver);
		waitTillElementVisible(uNameVessel);
		Thread.sleep(2000);
	}
	public  void LoginToOldVessel(String uname,String password) throws InterruptedException {
		Thread.sleep(1000);
		waitTillElementVisible(uNameVessel);

		uNameVessel.sendKeys(uname);
		passVessel.sendKeys(password);
		passVessel.submit();
		waitTillElementVisible(settings);
	}
	public  void LoginToMainOffice(String company,String uname,String password) throws InterruptedException {
		GenericFunctionsOAP gf=new GenericFunctionsOAP(driver);
		gf.waitTillElementVisible(companyMainOffice);
		companyMainOffice.sendKeys(company);
		userNameMainOffice.sendKeys(uname);
		passwordMainOffice.sendKeys(password);
		passwordMainOffice.submit();
		gf.waitTillElementVisible(settings);
//		Thread.sleep(5000);
	}

	@FindBy(xpath = "//div[@data-test='Sidebar']")
	WebElement menuBarMO;
	@FindBy(xpath = "//div[@class='simplebar-content']")
	WebElement menuBarOldVessel;

	@FindBy(xpath = "//div[@data-test='Sidebar']")
	WebElement menuBarNew;
	
	@FindBy(xpath = "//h2[@data-test='HomeWelcomeTitle']")
	WebElement othersWelcome;
	
	@FindBy(xpath = "//h3[@data-test='HomeWelcomeOverallProgress']")
	WebElement progressHeading;
	@FindBy(xpath="//p[text()='Personnel']")
	WebElement personnel;
	@FindBy(xpath="//p[normalize-space()='Search for personnel']")
	WebElement searchForPersonnel;

	public void navigateToHomePage() throws InterruptedException {
		waitTillElementVisible(menuBarMO);
		MouseHover(menuBarMO);
		waitTillElementVisible(personnel);
		highlightElement(personnel);
		Thread.sleep(2000);
		clickByJS(personnel, driver);
		Thread.sleep(2000);
		highlightElement(searchForPersonnel);
		clickByJS(searchForPersonnel, driver);
		Thread.sleep(2000);
	}

	@FindBy(id="appbar-dropdown-trigger-configuration")
	WebElement settings;
	@FindBy(xpath = "//a[text()='Data exchange']")
	WebElement dataExchange;

	@FindBy(id="p1_rExport_div")
	WebElement exportBullet;

	@FindBy(xpath = "//a[text()='Next']")
	WebElement next;


	@FindBy(id="p1_ucUploader_ucUploadedItems_rItems_ctl00_lFileName")
	WebElement uploadedFile;
	@FindBy(id="p1_tlbWizard_FINISH")
	WebElement finish;
	@FindBy(xpath = "//input[@id='p1_cbMakePackageB_Input']")
	WebElement packageDDL;


	@FindBy(xpath = "//td[contains(.,'nft')]/..//a")
	WebElement downloadNFT;

	@FindBy(id="p1_dRequestedDateProcessedDateOperationStatus")
	WebElement status;
	@FindBy(xpath = "//div[contains(@class,'rcbScroll')]//li")
	List<WebElement> packageDDLs;

	@FindBy(xpath = "//span[.='Results']/../..//li[1]")
	WebElement resultsCheckBox;
	@FindBy(xpath = "(//div[normalize-space()='Exporting search results']//p)[1]")
	WebElement ExportingSearchResultsCheckbox;

	@FindBy(xpath = "//span[.='Browse']")
	WebElement browse;

	@FindBy(id = "p1_ucUploader_ucUploadedItems_rItems_ctl00_aDelete")
	WebElement remove;
	@FindBy (xpath = "//input[@value='Completed']")
	WebElement completedStatus;

//	@FindAll({ 
//		@FindBy(xpath="//div[@class='side-nav-content']"),
//		@FindBy(xpath="//div[@class='simplebar-content']"),
//		@FindBy(xpath="//div[@class='sc-kxCoLp bKRDRO']")})
//	WebElement menuBar;

	@FindBy(xpath="//div[normalize-space()='Logout']")
	WebElement logout;
	@FindBy(xpath="//h3[normalize-space()='Logout']")
	WebElement logoutNew;
	public int export() throws InterruptedException {
		waitForPageLoad(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		highlightElement(settings);
		settings.click();

		highlightElement(dataExchange);
		dataExchange.click();
		Thread.sleep(5000);
		switchToDefault();
		switchToName("w0");
		switchToId("selectActionContent");
		exportBullet.click();
		Thread.sleep(3000);
		switchToDefault();
		switchToName("w0");
		highlightElement(next);
		next.click();
		Thread.sleep(3000);
		switchToDefault();
		switchToName("w0");
		switchToId("exportOptionsContent");
		highlightElement(packageDDL);
		packageDDL.sendKeys("QC-STAGE Vessel");

		Thread.sleep(3000);

		packageDDLs.get(0).click();

		switchToDefault();
		//		switchToName("w0");
		switchToIndex(0);

		highlightElement(next);
		Thread.sleep(1000);
		next.click();
		Thread.sleep(3000);
		waitTillElementVisible(finish);
		highlightElement(finish);

		clickByJS(finish, driver);
		Thread.sleep(15000);
		switchToDefault();
		switchToName("w0");
		Thread.sleep(5000);
		waitTillElementVisible(completedStatus);
		downloadNFT.click();
		Thread.sleep(5000);
		nameOfLastDownloadedFIle();
		//export done

		value=isFileDownloaded(nameOfLastDownloadedFIle());
		if (value) return 1;
		else return 0;
	}

	public String importNFT() throws InterruptedException, AWTException {

		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
		Thread.sleep(3000);
		switchToDefault();
		waitTillElementVisible(settings);
		highlightElement(settings);
		settings.click();
		highlightElement(dataExchange);
		dataExchange.click();
		Thread.sleep(10000);
		switchToDefault();
		Thread.sleep(5000);
		switchToName("w0");
		//		gf.switchToIndex(0);
		highlightElement(next);
		next.click();
		Thread.sleep(3000);
		switchToDefault();
		//		gf.switchToName("w0");
		switchToIndex(0);
		Thread.sleep(3000);
		//		gf.switchToId("selectActionContent");
		switchToIndex(1);
		//		gf.switchToId("selectFileContent");
		//		selectFileContent
		Thread.sleep(2000);
		highlightElement(browse);
		Thread.sleep(2000);
		//		gf.clickByJS(browse, driver);
		Actions a =new Actions(driver);
		Robot r=new Robot();
		a.moveToElement(browse).click().build().perform();
		StringSelection textToCopy=new StringSelection("Downloads");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(textToCopy, null);
		Thread.sleep(2000);

		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		Thread.sleep(500);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		Thread.sleep(500);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(500);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		for (int i = 0; i < 11; i++) {

			r.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(500);
			r.keyRelease(KeyEvent.VK_TAB);				
		}

		r.keyPress(KeyEvent.VK_SPACE);
		Thread.sleep(500);
		r.keyRelease(KeyEvent.VK_SPACE);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(500);
		r.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(10000);

		//		switchToDefault();
		//		switchToIndex(0);
		//		switchToIndex(1);
		//		switchToId("selectFileContent");
		highlightElement(uploadedFile);
		String uploadedFileName=uploadedFile.getText();
		System.out.println(uploadedFile.getText());
		switchToDefault();
		switchToIndex(0);
		waitTillElementVisible(finish);
		highlightElement(finish);
		finish.click();
		Thread.sleep(5000);
		//import done
		switchToDefault();
		waitTillElementVisible(menuBar);
		highlightElement(menuBar);
		MouseHover(menuBar);
		waitTillElementVisible(logout);
		highlightElement(logout);
		Click(logout);
		Thread.sleep(5000);

		return uploadedFileName;

	}
	public String importNFTAgain() throws InterruptedException, AWTException {

		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
		Thread.sleep(3000);
		switchToDefault();
		waitTillElementVisible(settings);
		highlightElement(settings);
		settings.click();
		highlightElement(dataExchange);
		dataExchange.click();
		Thread.sleep(10000);
		switchToDefault();
		Thread.sleep(5000);
		switchToName("w0");
		//		gf.switchToIndex(0);
		highlightElement(next);
		next.click();
		Thread.sleep(3000);
		switchToDefault();
		//		gf.switchToName("w0");
		switchToIndex(0);
		Thread.sleep(3000);
		//		gf.switchToId("selectActionContent");
		switchToIndex(1);
		//		gf.switchToId("selectFileContent");
		//		selectFileContent
		Thread.sleep(2000);
		highlightElement(browse);
		Thread.sleep(2000);
		//		gf.clickByJS(browse, driver);
		Actions a =new Actions(driver);
		Robot r=new Robot();
		a.moveToElement(browse).click().build().perform();
		/*
		StringSelection textToCopy=new StringSelection("Downloads");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(textToCopy, null);
		Thread.sleep(2000);

		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		Thread.sleep(500);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		Thread.sleep(500);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(500);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		 */
		for (int i = 0; i < 10; i++) {

			r.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(500);
			r.keyRelease(KeyEvent.VK_TAB);				
		}

		r.keyPress(KeyEvent.VK_SPACE);
		Thread.sleep(500);
		r.keyRelease(KeyEvent.VK_SPACE);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(500);
		r.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(10000);

		//		switchToDefault();
		//		switchToIndex(0);
		//		switchToIndex(1);
		//		switchToId("selectFileContent");
		highlightElement(uploadedFile);
		String uploadedFileName=uploadedFile.getText().toLowerCase();
		System.out.println(uploadedFile.getText());
		switchToDefault();
		switchToIndex(0);
		waitTillElementVisible(finish);

		highlightElement(finish);
		finish.click();
		Thread.sleep(5000);
		//import done
		switchToDefault();
		waitTillElementVisible(menuBarOldVessel);
		highlightElement(menuBarOldVessel);
		MouseHover(menuBarOldVessel);
		waitTillElementVisible(logout);
		highlightElement(logout);
		clickByJS(logout, driver);
		Thread.sleep(2000);
		return uploadedFileName;

	}

	public String importNFT2() throws InterruptedException, AWTException {

		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));
		Thread.sleep(3000);
		switchToDefault();
		waitTillElementVisible(settings);
		highlightElement(settings);
		settings.click();
		highlightElement(dataExchange);
		dataExchange.click();
		Thread.sleep(10000);
		switchToDefault();
		Thread.sleep(5000);
		switchToName("w0");
		//		gf.switchToIndex(0);
		highlightElement(next);
		next.click();
		Thread.sleep(3000);
		switchToDefault();
		//		gf.switchToName("w0");
		switchToIndex(0);
		Thread.sleep(3000);
		//		gf.switchToId("selectActionContent");
		switchToIndex(1);
		//		gf.switchToId("selectFileContent");
		//		selectFileContent
		Thread.sleep(2000);
		highlightElement(browse);
		Thread.sleep(2000);
		//		gf.clickByJS(browse, driver);
		Actions a =new Actions(driver);
		Robot r=new Robot();
		a.moveToElement(browse).click().build().perform();
		Thread.sleep(2000);
		for (int i = 0; i < 9; i++) {

			r.keyPress(KeyEvent.VK_TAB);
			Thread.sleep(500);
			r.keyRelease(KeyEvent.VK_TAB);				
		}

		r.keyPress(KeyEvent.VK_SPACE);
		Thread.sleep(500);
		r.keyRelease(KeyEvent.VK_SPACE);
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(500);
		r.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(10000);

		//		switchToDefault();
		//		switchToIndex(0);
		//		switchToIndex(1);
		//		switchToId("selectFileContent");
		highlightElement(uploadedFile);
		String uploadedFileName=uploadedFile.getText();
		System.out.println(uploadedFile.getText());
		switchToDefault();
		switchToIndex(0);
		waitTillElementVisible(finish);
		highlightElement(finish);
		finish.click();
		Thread.sleep(5000);
		//import done
		switchToDefault();
		waitTillElementVisible(menuBar);
		highlightElement(menuBar);
		MouseHover(menuBar);
		waitTillElementVisible(logout);
		highlightElement(logout);
		Click(logout);
		Thread.sleep(2000);

		return uploadedFileName;

	}

	@FindBy(xpath="//a[@href='./GCCDashboard']")
	WebElement gccDashboard;

	@FindBy(id="Login")
	WebElement gccDashboardUsername;
	@FindBy(id="Password")
	WebElement gccDashboardPassword;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement gccLogin;
	@FindBy(xpath = "//a[.='CUSTOMERS']")
	WebElement gccCustomers;
//	public  void loginToGCCDashboard(String uname,String password) throws InterruptedException {
//		waitTillElementVisible(gccDashboard);
//		clickByJS(gccDashboard, driver);
//		Thread.sleep(1000);
//		driver.close();
//		switchToOpenWindow(0);
//		gccDashboardUsername.sendKeys(uname);
//		gccDashboardPassword.sendKeys(password);
//		//		gccLogin.click();
//		gccDashboardPassword.submit();
//		waitTillElementVisible(gccCustomers);
//	}
	public  void loginToGCCDashboard(String uname,String password) throws InterruptedException {
//		waitTillElementVisible(gccDashboard);
//		clickByJS(gccDashboard, driver);
//		Thread.sleep(1000);
//		driver.close();
//		switchToOpenWindow(0);
		gccDashboardUsername.sendKeys(uname);
		gccDashboardPassword.sendKeys(password);
		//		gccLogin.click();
		gccDashboardPassword.submit();
		waitTillElementVisible(gccCustomers);
	}
	// *********************************HANDLE_IFRAME**********************************************
	public  void switchToElement(WebElement element) {
		driver.switchTo().frame(element);

	}

	public void switchToName(String Name) {
		driver.switchTo().frame(Name);

	}
	public  void switchToId(String Id) {
		driver.switchTo().frame(Id);

	}

	public  void switchToIndex(int Index) {
		driver.switchTo().frame(Index);

	}

	public  void switchToDefault() {
		driver.switchTo().defaultContent();

	}
	public String getCurrentDate(String format) {
		// Create object of SimpleDateFormat class and decide the format
		DateFormat dateFormat = new SimpleDateFormat(format);

		//get current date time with Date()
		Date date = new Date();

		// Now format the date
		String date1= dateFormat.format(date);

		return date1;

	}
	public String addDateToCurrentDate(String format,int days) throws java.text.ParseException {
		// Create object of SimpleDateFormat class and decide the format
		DateFormat dateFormat = new SimpleDateFormat(format);

		//get current date time with Date()
		Date date = new Date();

		String date1= dateFormat.format(date);

		Calendar cal = Calendar.getInstance();  
		cal.setTime(dateFormat.parse(date1));  

		// use add() method to add the days to the given date  
		cal.add(Calendar.DAY_OF_MONTH, days);  
		String dateAfter = dateFormat.format(cal.getTime());  
		return dateAfter;
	}

	// *********************************fetch today's date **********************************************Ashish

	public String todayDate() {
		Date currentDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = formatter.format(currentDate);
		return formattedDate;
	}
	//*********************************fetch today's date with format **********************************************Ashish

	public String todayDate(String format) {
		Date currentDate = new Date();//"dd/MM/yyyy"
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String formattedDate = formatter.format(currentDate);
		return formattedDate;
	}
	// ****************************fetch today's date ddMMMMyyyy **********************************************Ashish

		public String todayDateddMMMMyyyy() {
			// Get today's date
	        Date currentDate = new Date();
	        // Define the desired date format
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
	        // Format today's date
	        String formattedDate = dateFormat.format(currentDate);
			return formattedDate;
		}
	// *********************************HIGHLIGHT_ELEMENT**********************************************
	public  void highlightElement(WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
		jsExecutor.executeScript("arguments[0].style.border='2px dotted red'", element);  

	}
	// *********************************BOLD_HIGHLIGHT_ELEMENT**********************************************
		public  void highlightElementBold(WebElement element) {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
			jsExecutor.executeScript("arguments[0].style.border='5px solid red'", element);  

		}

	// *********************************LOWLIGHT_ELEMENT**********************************************
	public void unhighlightElement(WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('style','')", element);
	}

	// *********************************DRAG_AND_DROP**********************************************
	public  void dragAndDrop(WebElement source, WebElement target) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).perform();

	}
	// *********************************DRAG_AND_DROP**********************************************
	public  void scrollUpPage() {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_UP).build().perform();

	}

	// *********************************GET_ELEMENT_BY_LOCATOR**********************************************
	public WebElement getElement(By locater) {
		WebElement element = driver.findElement(locater);
		return element;
	}

	// ***************************************CLICK********************************************************

	public  void Click(WebElement element) {
		element.click();
	}
	// ********************************SENDKEYS*******************************************

	public  void Sendkeys(WebElement element, String input) {
		element.sendKeys(input);
	}


	//***************************************RIGHT_CLICK************************************************************
	public  void RightClick(WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	// ***************************************DOUBLE_CLICK************************************************************
	public  void DoubleClick(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}
	// ********************************CLEAR***********************************************

	public  void Clear(WebElement element) {
		element.clear();
	}
	// ***************************************SENDKEYS_WITH_ACTION************************************************************
	public void doSendKeysWithAction(WebElement element, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(element, value).perform();
	}
	// ***************************************CLICKANDHOLD_WITH_ACTION************************************************************
	public void clickAndHoldWithAction() {
		Actions act = new Actions(driver);
		act.clickAndHold();
	}

	// ***************************************CLICK_LOCATOR_WITH_ACTION************************************************************
	public void doClickWithAction(WebElement element) {
		Actions act = new Actions(driver);
		act.click(element).perform();
	}

	// ***************************************GET_TEXT************************************************************
	public String getText(WebElement element) {
		String text = element.getText();
		return text;
	}

	// ***************************************ELEMENT_IS_DISPLAYED************************************************************
	public boolean isDisplayed(WebElement element) {
		boolean value=element.isDisplayed();
		return value;

	}

	// ***************************************ELEMENT_IS_SELECTED*****************************************************
	public boolean isSelect(WebElement element) {
		boolean value=element.isSelected();
		return value;
	}

	//// ***************************************ELEMENT_IS_ENABLED*****************************************************
	public boolean isEnable(WebElement element) {
		return element.isEnabled();
	}
	// ***********************************SELECT_FROM_DROPDOWN***********************************************
	// select by visible text
	public  void SelectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);

	}

	// select by index
	public  void SelectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	// select by value
	public  void SelectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	// ***********************************DESELECT_FROM_DROPDOWN***********************************************
	// deselect by index
	public void deselectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);

	}
	// deselect by value
	public void deselectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByValue(value);
	}
	// deselectAll drop down
	public void deSelectAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}

	// deselectByVisibleText
	public void deselectByVisibleText(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByVisibleText(value);
	}
	// ***********************************CHECK_IF_SUPPORT_MULTISELECT_DROPDOWN***********************************************
	public boolean isSelectMultiple(WebElement element) {
		Select select = new Select(element);
		return select.isMultiple();

	}
	// ***********************************CHECK_DEFAULT_VALUE_DROPDOWN***********************************************
	public String getDefaultSelectedValue(WebElement element) {
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();

	}

	public ArrayList<String> getOptions(WebElement element) {
		Select select = new Select(element);
		ArrayList<String> options = new ArrayList<String>();
		for(int i = 0; i<select.getOptions().size();i++) {
			options.add(select.getOptions().get(i).getText());
		}
		return options;
	}

	// ***********************************SWITCH_WINDOW***********************************************
	public void WindowHandle(WebDriver driver) {
		String parent = driver.getWindowHandle();
		Set<String> list_of_windows = driver.getWindowHandles();

		Iterator<String> iterator = list_of_windows.iterator();

		while (iterator.hasNext()) {

			String child_window = iterator.next();

			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				System.out.println(driver.switchTo().window(child_window).getTitle());

				driver.close();
			}
		}
		// again switching parent window
		driver.switchTo().window(parent);
	}
	// *********************************SWITCH_TO_ACTIVE_WINDOW_TAB**********************************************
	public  void switchToActiveWindow() {
		ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles());
		//switch to active tab
		driver.switchTo().window(wid.get(1));
	}
	// *********************************SWITCH_TO_OEN_WINDOW_TAB**********************************************
	public  void switchToOpenWindow(int id) {
		ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles());
		//switch to active tab
		driver.switchTo().window(wid.get(id));
	}
	// *********************************MOUSE_HOVER**********************************************
	public  void MouseHover(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();

	}

	// get Title
	public String getTitle() {
		return driver.getTitle();
	}

	public String doGetText(WebElement element) {
		return element.getText();
	}

	// *************************************ALERT************************************************
	// To click on the ‘Cancel’ button of the alert.
	public  void DismissAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	// To click on the ‘OK’ button of the alert.
	public  void AcceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	// To capture the alert message.
	public  void getAlertMessage() {
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
	}

	// To send some data to alert box.
	public  void SendDataToAlertBox(String Text) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(Text);
	}

	// **********************************CHECKBOX*************************************************
	// single checkbox
	public static void SelectCheckbox(WebElement element) {
		element.click();
	}

	// multiple checkboxes
	public  void SelectMultipleCheckboxes(List<WebElement> listOfItems, int noOfCheckboxesToBeSelected) {
		for (int i = 0; i <= noOfCheckboxesToBeSelected - 1; i++) {
			listOfItems.get(i).click();
			System.out.println("Checkbox_" + i + " selected");
		}
	}
	// ****************************************UPLOAD_FILE**********************************

	public  void UploadFile(WebElement element, String filePath) {
		Sendkeys(element, filePath);
	}
	// **********************************TAB***********************************************

	public  void TAB(WebElement element) {
		element.sendKeys(Keys.TAB);
	}
	// ************************************VERTICAL_SCROLL************************************
	public  void WindowVerticalScroll(int pixel) {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0," + pixel + ")");
	}
	// ************************************Horizontal_SCROLL************************************
	public  void WindowHorizontalScroll() {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(2000,0)");
	}

	// scroll it at the top and then by a 1/4th of the height of the view
	public  void WindowVerticalScroll(WebElement element) {
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true); window.scrollBy(0, -window.innerHeight / 4);", element);

	}
	// scroll it at the bottom
	public  void WindowScrollToBottom(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);

	}
	public void actionButton() {
		Actions a =new Actions(driver);
		a.moveToElement(browse).click().build().perform();

	}
	// scroll to the element
	public  void WindowScrollToTheElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// scroll just below an element , eg fixed header
	public  void WindowScrollToBelowTheElement(WebElement element, WebElement header) {
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true); window.scrollBy(0, -arguments[1].offsetHeight);", element, header);

	}

	// *********************WAIT_TILL_ELEMENT_VISIBLE*************************************

	public  void waitTillElementVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public  boolean isElementClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		boolean isClickable = wait.until(ExpectedConditions.elementToBeClickable(element)) != null;
		return isClickable;
	}

	public  boolean isElementVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		boolean isVisible = wait.until(ExpectedConditions.visibilityOf(element)) != null;
		return isVisible;
	}

	// ******************************WAIT_SOME_TIME*******************************************

	public  void waitForPageLoad(long mil) throws InterruptedException{
		Thread.sleep(mil);
	}

	// *************************************ASSERT***********************************************

	public boolean Assert(String actualtitle, String Expectedtitle) {

		if (actualtitle.equalsIgnoreCase(Expectedtitle))
			return true;
		else
			return false;

	}

	// ******************************JAVASCRIPT_FUNCTIONS*******************************************
	public String getTitleByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		return js.executeScript("return document.title").toString();
	}

	// to refresh webPage 
	public Object refreshWebPageByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		return js.executeScript("history.go(0");

	}
	// to send the value By JS
	public void sendKeysByJS(WebElement element, String value, WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript
		("arguments[0].value = arguments[1]", element, value);
	}


	// to click On element By Js
	public void clickByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click()", element);
	}
	// to scroll the bottom of the page
	public void scrollDownPage(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	// this method  is to perform  scrollUp page
	public void scrollUpPage(String high) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,'"+high+"')");
	}

	public void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgColor = element.getCssValue("backgroundcolor");
		for (int i = 0; i <= 10; i++) {
			changeColor("rgb(0,200,0)", element, driver);
			changeColor(bgColor, element, driver);
		}

	}

	private void changeColor(String color, WebElement element, WebDriver driver2) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("argumnts[0].style.backgroundcolor='" + color + "'", element);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	// to draw broder using js
	public void drawbroder(WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver; 
		js.executeScript("arguments[0].style.broder='3px solid green'", element);

	}

	// alert message
	public void generateAlertMessage(WebDriver driver, String message) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('" + message + "')");

	}

	//	Js click
	public Object clickOnElementByJS(WebDriver driver, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		return js.executeScript("argument[0].click();", element);
	}

	//	to refresh the page using Js
	public void refreshBrowserByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");

	}
	//  to getTitle BY Js
	public String toGetTitleByJs(WebDriver driver, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String title = js.executeScript("return document.title;").toString();
		return title;

	}

	//this will return the page text
	public String getPageInnerText(WebDriver driver) {
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		String pageText=js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;

	}
	//if data is get successfully then return row and column

	public String getCellStringValue(String rowName, int colNum, String sheetName) {
		try {
			if (colNum <= 0)
				return "";

			int index = workbook.getSheetIndex(sheetName);
			int col_Num = -1;
			if (index == -1)
				return "";

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				// System.out.println(row.getCell(i).getStringCellValue().trim());
				if (row.getCell(i).getStringCellValue().trim().equals(rowName.trim()))
					col_Num = i;
			}
			if (col_Num == -1)
				return "";

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(colNum - 1);
			if (row == null)
				return "";

			cell = row.getCell(col_Num);
			if (cell == null)
				return "";

			// System.out.println(cell.getCellType());
			if (cell.getCellType() == CellType.STRING)
				return cell.getStringCellValue();
			else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {

				String cellText = String.valueOf(cell.getNumericCellValue());
				if (DateUtil.isCellDateFormatted(cell)) {

					// format in form of M/D/YY
					double d = cell.getNumericCellValue();

					Calendar cal = Calendar.getInstance();
					cal.setTime(DateUtil.getJavaDate(d));
					cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + 1 + "/" + cellText;

					// System.out.println(cellText);

				}

				return cellText;
			} else if (cell.getCellType() == CellType.BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());

		} catch (Exception e) {

			e.printStackTrace();
			return "row " + rowName + " or column " + colNum + " does not exist in xls";
		}
	}

	// it returns the row count in a sheet
	public int getRowCount(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1)
			return 0;
		else {
			sheet = workbook.getSheetAt(index);
			int number = sheet.getLastRowNum() + 1;
			return number;
		}
	}

	// if data is set successful it returns true or else false
	public boolean setCellValue(int rowNum, int colName, String sheetName, String data) {
		try {
			fis = new FileInputStream(path);
			workbook = workbookfactory.create(fis);

			if (rowNum <= 0)
				return false;

			int index = workbook.getSheetIndex(sheetName);
			int colNum = -1;
			if (index == -1)
				return false;

			sheet = workbook.getSheetAt(index);

			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				// System.out.println(row.getCell(i).getStringCellValue().trim());
				if (row.getCell(i).getStringCellValue().trim().equals(colName))
					colNum = i;
			}
			if (colNum == -1)
				return false;
			sheet.autoSizeColumn(colNum);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				row = sheet.createRow(rowNum - 1);
			cell = row.getCell(colNum);
			if (cell == null)
				cell = row.createCell(colNum);
			cell.setCellValue(data);
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public Object[][] getTestData(String Testdata) throws InvalidFormatException {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = workbook.getSheet(Testdata);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}

	// presenceOfAllElementsLocated
	public List<WebElement> waitForListOfElementPresent(By locater, Duration time) {

		WebDriverWait wait = new WebDriverWait(driver, time);

		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locater));

	}

	public Wait<WebDriver> fluentWait(WebElement element, int time,int pollingTime) {

		Wait<WebDriver>wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(time))
				.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(StaleElementReferenceException.class);
		return wait;
	}
	public void returnToParentWindow() {
		// hold all window handles in array list
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		//close opened tab
		driver.close();
		//switch to new tab
		driver.switchTo().window(newTb.get(0));
	}
	// *********************WAIT_TILL_ELEMENT_INVISIBLE*************************************

	public  void waitTillElementInVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	// 
	public void clearFolder(String folderPath) {
	}

	public boolean isFileDownloaded(String fileName) {
		String home = System.getProperty("user.home");
		File dir = new File(home+"/Downloads/");
		File[] dirContents = dir.listFiles();
		for (int i = 0; i < dirContents.length; i++) {
			if (dirContents[i].getName().equals(fileName)) {
				return true;
			}
		}
		return false;

	}

	public boolean isFileDownloadedWithPath(String fileName,String path) {
		File dir = new File(path);
		File[] dirContents = dir.listFiles();
		for (int i = 0; i < dirContents.length; i++) {
			if (dirContents[i].getName().equals(fileName)) {
				return true;
			}
		}
		return false;

	}


	public void Wait(int time) throws InterruptedException {
		Thread.sleep(time);
	}

	public boolean verifyExcelSheet(File excelFile, String sheetName, String valueToFind) throws IOException {
		FileInputStream fis = new FileInputStream(excelFile);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		if (sheet == null) {
			// Sheet not found
			workbook.close();
			return false;
		}
		for (Row row : sheet) {
			for (Cell cell : row) {
				CellType cellType = cell.getCellType();
				if (cellType == CellType.STRING ) {
					String cellValue = cell.getStringCellValue();
					if (cellValue.equals(valueToFind)) {
						workbook.close();
						return true;
					}
				}
			}
		}
		workbook.close();
		return false;
	}

	//****************current window size, Covers all the elements of the page*************Ashish
	public void currentwindowSize() {
		Dimension screenSize = driver.manage().window().getSize();
		Dimension newSize = new Dimension(screenSize.getWidth()+50, screenSize.getHeight()+50);
		driver.manage().window().setSize(newSize);
	}

	//**********************Open a file*****************//Ashish
	public void openAFile(String filePath) throws IOException {
		File file = new File(filePath);   

		if(!Desktop.isDesktopSupported())//check if Desktop is supported by Platform or not  
		{  
			System.out.println("not supported");  
			return;  
		}  
		Desktop desktop = Desktop.getDesktop();  

		if(file.exists())         //checks file exists or not  
			desktop.open(file);              //opens the specified file
		else {
			System.out.println("file deosn't exist");
		}
	}


	//	/*********************name of the last downloaded File************/ Ashish
	public String nameOfLastDownloadedFIle() throws InterruptedException {
		Thread.sleep(10000);
		String directoryPath=System.getProperty("user.home")+"/Downloads/";

		File directory = new File(directoryPath);
		File latestFile = null;
		long lastModifiedTime = Long.MIN_VALUE;

		// Iterate through all files in the directory
		for (File file : directory.listFiles()) {
			if (file.isFile()) {
				long fileLastModifiedTime = file.lastModified();
				if (fileLastModifiedTime > lastModifiedTime) {
					lastModifiedTime = fileLastModifiedTime;
					latestFile = file;
				}
			}
		}

		if (latestFile != null) {
			String latestFileName = latestFile.getName();
			System.out.println("Latest downloaded file: " + latestFileName);
			return latestFileName;
		} else {
			System.out.println("No files found in the directory.");
		}
		return latestFile.getName();
	}
//	/*********************Validate value(column) present in a specific row************/ Ashish
	public boolean validateColumnsExcel(String[] expectedColumns, int rowNum) throws InterruptedException, EncryptedDocumentException, IOException {
		int c=0;
		FileInputStream fileInputStream = 
				new FileInputStream(System.getProperty("user.home")+"/Downloads/"+nameOfLastDownloadedFIle());
		Workbook workbook = WorkbookFactory.create(fileInputStream);

		Sheet sheet = workbook.getSheetAt(0); // Assuming you want to check the first sheet

		Row headerRow = sheet.getRow(rowNum); // Assuming the header is in the first row

		for (String column : expectedColumns) {
			boolean columnFound = false;

			for (Cell cell : headerRow) {
				if (cell.getStringCellValue().equalsIgnoreCase(column)) {
					columnFound = true;
					c++;
					break;
				}
			}

			if (columnFound) {
				System.out.println("Column '" + column + "' is present in the Excel sheet.");
			} else {
				System.out.println("Column '" + column + "' is not present in the Excel sheet.");
			}
		}

		if (c==expectedColumns.length)	return true;
		else return false;
	}
	/*****************proper numeric value present in a column of excel*/  //Ashish
	public boolean validateAColumnValues(int columnIndex, int from, int to) throws InterruptedException, EncryptedDocumentException, IOException {

		FileInputStream fileInputStream = 
				new FileInputStream(System.getProperty("user.home")+"/Downloads/"+nameOfLastDownloadedFIle());
		Workbook workbook = WorkbookFactory.create(fileInputStream);

		Sheet sheet = workbook.getSheetAt(0); // Assuming you want to check the first sheet

		//            int columnIndex = 0; // Assuming the column index is 0 (A column)

		for (int rowIndex = 1; rowIndex <= 100; rowIndex++) {
			Row row = sheet.getRow(rowIndex);

			if (row != null) {
				Cell cell = row.getCell(columnIndex);
				if (cell != null && cell.getCellType() == CellType.NUMERIC) {
					double cellValue = cell.getNumericCellValue();

					if (cellValue < from || cellValue > to) {
						System.out.println("Invalid value found at Row " + rowIndex + ", Column " + columnIndex);
						return false;
					}
				} else {
					System.out.println("Invalid or empty cell found at Row " + rowIndex + ", Column " + columnIndex);
					return false;				
				}
			} else {
				System.out.println("Row not found at index " + rowIndex);
			}
		}
		return true;
	}


	// it returns the row count in a sheet				//Ashish
	public int getRowsCountInExcel() throws EncryptedDocumentException, IOException, InterruptedException {
		FileInputStream file = new FileInputStream(System.getProperty("user.home")+"/Downloads/"+nameOfLastDownloadedFIle());

		Workbook workbook = WorkbookFactory.create(file);

		Sheet sheet = workbook.getSheetAt(0); // Assuming you want to validate the first sheet

		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum() + 1;
		System.out.println(sheet.getLastRowNum());
		System.out.println(sheet.getFirstRowNum());
		System.out.println(rowCount);
		return rowCount;
		/*
		if (rowCount == 1) {
			System.out.println("Only the first row is present in the Excel sheet.");
			return true;
		} else {
			System.out.println("Multiple rows are present in the Excel sheet.");
			return false;
		}
		 */

	}

	//************difference between dates***************Ashish
	//format 23/08/2023
	public int dateDifference(String startDateStr,String endDateStr) {   

		//		String startDateStr = "23/08/2023";
		//        String endDateStr = "23/08/2025";

		// Parse input strings to LocalDate objects
		LocalDate startDate = 
		LocalDate.parse(startDateStr, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDate endDate = 
		LocalDate.parse(endDateStr, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));

		// Calculate the duration between the dates
		Period duration = Period.between(startDate, endDate);

		// Extract years, months, and days from the duration
		int years = duration.getYears();
		int months = duration.getMonths();
		int days = duration.getDays();

		// Print the duration
		System.out.println("Duration: " + years + " years, " + months + " months, " + days + " days");
		if (years==0) {
			if (months==0) {
				return days;
				
			} 
			return months;
		} 
		return years;
	}
	//************add days***************Ashish
	public String addDay(String inputDateStr,int add) {
//		String inputDateStr = "26/08/2023";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate inputDate = LocalDate.parse(inputDateStr, formatter);

        LocalDate previousDate = inputDate.plusDays(add);

        String previousDateStr = previousDate.format(formatter);
        System.out.println("Previous date: " + previousDateStr);
        return previousDateStr;
	}
	
	//******************Fetch value to excel********** Ashish Release 2 OLP
public void fetchToExcel(String excelFilePath,String sheetName,int rowNum, int col, WebElement element) throws IOException {
	FileInputStream fis = new FileInputStream(excelFilePath);
    Workbook workbook = new XSSFWorkbook(fis);
    Sheet sheet = workbook.getSheet(sheetName); // Replace with the actual sheet name
    Row row = sheet.getRow(rowNum); // Replace with the row where you want to write the text
    Cell cell = row.createCell(col); // Replace with the column where you want to write the text
    cell.setCellValue(element.getAttribute("value"));

    // Save the changes to the Excel file
    FileOutputStream fos = new FileOutputStream(excelFilePath);
    workbook.write(fos);
    fos.close();
    workbook.close();
    fis.close();
}
//******************generate Alpha numeric Special character password********** Ashish Release 2 OLP
public String randomStringGenerator (int length) {
	String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
	    String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	 String DIGITS = "0123456789";
	    String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/";

	 SecureRandom random = new SecureRandom();
     StringBuilder password = new StringBuilder();

     // Initialize character sets
     String allCharacters = LOWERCASE + UPPERCASE + DIGITS + SPECIAL_CHARACTERS;

     for (int i = 0; i < length; i++) {
         int randomIndex = random.nextInt(allCharacters.length());
         char randomChar = allCharacters.charAt(randomIndex);
         password.append(randomChar);
     }
     return password.toString();
}
//*********The Matcher finds if any such digit is present in the input string.
//If it finds a match, it returns true, indicating that the string contains digits; 
//otherwise, it returns false.*****				//Ashish Release 2 OLP
public boolean containsDigits(String input) {
    Pattern pattern = Pattern.compile("[0-9]");
    Matcher matcher = pattern.matcher(input);
    return matcher.find();
}

//******************Nearest Past Date********** Ashish Release 2 OLP
public String nearestPastDate(List<String> dateStrings) throws ParseException {
//	  List<String> dateStrings = new ArrayList<>();
//    dateStrings.add("01/11/2023");
//    dateStrings.add("01/01/2020");
//    dateStrings.add("01/01/2019");
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Date currentDate = new Date(); // Get the current date
    Date nearestBackDate = null;
    long nearestBackDateDifference = Long.MAX_VALUE;
    for (String dateString : dateStrings) {
        Date date = dateFormat.parse(dateString);
        long difference = currentDate.getTime() - date.getTime();
        if (difference >= 0 && difference < nearestBackDateDifference) {
            nearestBackDate = date;
            nearestBackDateDifference = difference;
        }
    }
    if (nearestBackDate != null) {
        String formattedDate = dateFormat.format(nearestBackDate);
        System.out.println("The nearest back date to today is: " + formattedDate);
        return formattedDate;
    } else {
        System.out.println("No valid back date found in the list.");
        return "00/00/0000";
    }
    }
}






