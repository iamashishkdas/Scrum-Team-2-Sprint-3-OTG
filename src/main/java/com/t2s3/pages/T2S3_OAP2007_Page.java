package com.t2s3.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.t2s3.common.GenericFunctionsOAP;

public class T2S3_OAP2007_Page
{
	public WebDriver driver;
	Boolean value;
	public GenericFunctionsOAP gf;
	String text;
	int c;
	@FindBy(xpath = "//html")
	WebElement page;
	@FindBy(xpath = "(//img[@alt='React logo'])[1]")
	WebElement OAPLogo;
	@FindBy(xpath = "//h5[text()='Assessments']")
	WebElement ASHeader;
	@FindBy(xpath = "//table")
	WebElement table;
	@FindBy(xpath = "//span[text()='Name']")
	WebElement nameColumntable;
	@FindBy(xpath = "(//span[text()='Assessments'])[1]")
	WebElement assessmentsMenu;
	@FindBy(xpath = "//button[text()='New Assessment']")
	WebElement newAssessment;
	@FindBy(xpath = "//label[text()='Assessment Name']")
	WebElement assessmentNameTextFieldClick1;
	@FindBy(xpath = "//textarea[@name='name']")
	WebElement assessmentNameTextField2;
	@FindBy(xpath = "//div[@id='mui-component-select-type']")
	WebElement assessmentTypeDDL;
	@FindBy(xpath="//li[@role='option']")
	List<WebElement> DDLList;
	@FindBy(xpath = "//div[@id='mui-component-select-functionAreaId']")
	WebElement functionalAreaDDL;
	@FindBy(xpath = "//div[@id='mui-component-select-subjectDetailedId']")
	WebElement detailedSubjectDDL;
	@FindBy(xpath = "//div[@role='dialog']")
	WebElement dialogPopup;
	@FindBy(xpath = "//button[.='Question Bank']")
	WebElement addQBAssessment;
	@FindBy(xpath="//li[@role='option']")
	List<WebElement> addQBAssessmentList;
	@FindBy(xpath = "(//div[text()='All'])[2]")
	WebElement allButtonOfStatus;
	@FindBy(xpath = "//div[text()='1 selected']/../..//*[local-name()='svg']")
	WebElement selectedStatus;
	@FindBy(xpath = "//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']")
	WebElement tableOfStatus;
	@FindBy(xpath = "//input[@class='PrivateSwitchBase-input css-1m9pwf3']")
	List<WebElement> listOfStatusCombo;
	@FindBy(xpath = "//tr//span[@class='MuiChip-label MuiChip-labelSmall css-1pjtbja']")
	List<WebElement> filteredStatus;
	@FindBy(xpath = "//div[contains(@class,'MuiTablePagination-toolbar')]")
	WebElement paginationGrid;
	@FindBy(xpath = "//div[@class='MuiInputBase-root MuiInputBase-colorPrimary MuiInputBase-sizeSmall MuiTablePagination-input css-ryhwr8']//*[local-name()='svg']")
	WebElement rowsPerPageDDL;
	@FindBy(xpath = "//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']//li")
	List<WebElement> rowsValue;
	@FindBy(xpath = "//ul[@class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']")
	WebElement rowsTable;
	@FindBy(xpath = "//p[@class='MuiTablePagination-displayedRows css-1w1ge7b']")
	WebElement pageInfo;
	@FindBy(xpath = "//button[@title='Go to next page']")
	WebElement nextPage;
	@FindBy(xpath = "//button[@title='Go to previous page']")
	WebElement previousPage;
	@FindBy(xpath = "//span[contains(@class,'1pjtbja')]")
	List<WebElement> statusListQBList;
	@FindBy(xpath = "(//span[text()='Question Banks'])[1]")
	WebElement QBMenu;
	@FindBy(xpath = "//h5[text()='Question Banks']")
	WebElement QBHeader;
	@FindBy(xpath = "//button[text()='New Question Bank']")
	WebElement NewQBbutton;
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchTextField;
	@FindBy(xpath = "//table//tbody//td[2]")
	List<WebElement> QBNameListTable;
	@FindBy(xpath = "//table//button[1]")
	List<WebElement> editIcons;
	@FindBy(xpath = "//button[text()='Multiple Choice']/../../..//span[contains(@class,'1pjtbja')]")
	List<WebElement> statusListQ;
	@FindBy(xpath = "//h6[contains(.,'Total Question')]")
	WebElement totalQuestions;
	@FindBy(xpath = "//h5[text()='New Question Bank']")
	WebElement NewQBheader;
	@FindBy(xpath = "//button[text()='Cancel']")
	WebElement cancelButton;
	@FindBy(xpath = "//button[text()='Save as draft']")
	WebElement saveAsDraft;
	@FindBy(xpath = "//button[text()='Save as draft']/..//*[local-name()='svg']")
	WebElement saveAsDraftDDL;
	@FindBy(xpath = "//h5")
	WebElement header;
	@FindBy(xpath = "//h5/..//span[contains(@class,'1pjtbja')]")
	WebElement statusHeader;
	@FindBy(xpath = "//textarea[@name='name']")
	WebElement QBnameTextField;
	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> languages;
	@FindBy(xpath = "//button[text()='Multiple Choice']")
	WebElement MCQbutton;
	@FindBy(xpath = "//table//tbody//td[2]")
	List<WebElement> questionNameMCQTable;
	@FindBy(xpath = "//h5[text()='Add Multiple Choice Question']")
	WebElement MCQHeader;
	@FindBy(xpath = "//textarea[contains(@name,'Answers')]")
	List<WebElement> answerTextFields;
	@FindBy(xpath = "//textarea[@name='multipleChoiceTextAnswers.answers.0.multiLanguageTextAnswers.0.answerText']")
	WebElement answer1;
	@FindBy(xpath = "//textarea[@name='multipleChoiceTextAnswers.answers.1.multiLanguageTextAnswers.0.answerText']")
	WebElement answer2;
	@FindBy(xpath = "//textarea[@name='multipleChoiceTextAnswers.answers.2.multiLanguageTextAnswers.0.answerText']")
	WebElement answer3;
	@FindBy(xpath = "//textarea[@name='multipleChoiceTextAnswers.answers.3.multiLanguageTextAnswers.0.answerText']")
	WebElement answer4;
	@FindBy(xpath = "//button[text()='Add Answer']//*[local-name()='svg']")
	WebElement addAnswerButton;
	@FindBy(xpath = "//input[@name='multipleChoiceTextAnswers.answers.0.isCorrect']/..")
	WebElement answer1CheckBox;
	@FindBy(xpath = "//input[@name='multipleChoiceTextAnswers.answers.1.isCorrect']/..")
	WebElement answer2CheckBox;
	@FindBy(xpath = "//input[@name='multipleChoiceTextAnswers.answers.2.isCorrect']/..")
	WebElement answer3CheckBox;
	@FindBy(xpath = "//textarea[@name='questionDetails.0.questionText']")
	WebElement questionField;
	@FindBy(xpath = "//div[text()='Publish']")
	WebElement publishButton;
	@FindBy(xpath = "//button[.='Publish']")
	WebElement popupPublish;
	@FindBy(xpath = "//span[text()='Revisions']")
	WebElement revisionsHeading;
	@FindBy(xpath = "//button[text()='Archive']")
	WebElement popupArchive;
	@FindBy(xpath = "//div[@role='dialog']")
	WebElement popup;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement savePopup;
	@FindBy(xpath = "//label[.='Revision Note']/..//input")
	WebElement revisionNoteTextField;
	
	@FindBy(xpath = "//button[text()='Revisions']")
	WebElement revisionsButtonMenu;
	@FindBy(xpath = "//span[.='Date']/../p")
	WebElement revisionDate;
	@FindBy(xpath = "//span[.='Revision Note']/..//p")
	WebElement revisionNote;
	@FindBy(xpath = "//button[.='preview']")
	WebElement preview;
	@FindBy(xpath = "//button[.='Close Preview']")
	WebElement closePreview;
	@FindBy(xpath = "//p[contains(.,'ID')]")
	WebElement headingID;
	
	String time=System.currentTimeMillis()+"";
	String nameQB=time+" QB";
	String nameQ=time+" Q";
	String question1=1+ nameQ;
	String question2=2+ nameQ;
	String question3=3+ nameQ;
	String revisionValue;
	String questionIDText;
	public T2S3_OAP2007_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		gf=new GenericFunctionsOAP(driver);
	}

	public int assessmentPlatformHome() throws InterruptedException  
	{
		gf.waitTillElementVisible(nameColumntable);
		value=nameColumntable.isDisplayed();
		Thread.sleep(5000);

		if (value)
			return 1;
		else
			return 0;
	}
	public int navigateToQuestionBankPage() throws InterruptedException  
	{
		gf.highlightElement(QBMenu);
		gf.clickByJS(QBMenu, driver);
		Thread.sleep(3000);	
		driver.navigate().refresh();
		Thread.sleep(3000);	
		value=QBHeader.isDisplayed();
		if (value)
		{
			gf.highlightElement(QBHeader);
			return 1;
		}
		else
		{
			gf.highlightElementBold(QBHeader);
			return 0;
		}
	}
	public int navigateToNewQuestionBankPage() throws InterruptedException   
	{
		gf.highlightElement(NewQBbutton);
		gf.clickByJS(NewQBbutton, driver);
		Thread.sleep(3000);	
		driver.navigate().refresh();
		Thread.sleep(3000);
		gf.waitTillElementVisible(NewQBheader);
		value=NewQBheader.isDisplayed()&!saveAsDraft.isEnabled();
		if (value)
		{
			gf.highlightElement(NewQBheader);
			gf.highlightElement(saveAsDraft);
			return 1;
		}
		else
		{
			gf.highlightElementBold(NewQBheader);
			gf.highlightElementBold(saveAsDraft);
			return 0;
		}
	}

	public int enableSaveAsDraftQB() throws InterruptedException   
	{
		gf.unhighlightElement(NewQBheader);
		gf.unhighlightElement(saveAsDraft);
		gf.waitTillElementVisible(QBnameTextField);
		gf.highlightElement(QBnameTextField);
		QBnameTextField.sendKeys(this.nameQB);//fetch current time
		gf.Wait(2000);
		value=saveAsDraft.isEnabled();
		if (value)
		{
			gf.highlightElement(saveAsDraft);
			return 1;
		}
		else
		{
			gf.highlightElement(saveAsDraft);
			return 0;
		}
	}
	public int navigateToMCQPage() throws InterruptedException
	{
		gf.highlightElement(MCQbutton);
		Actions act=new Actions(driver);
		act.moveToElement(MCQbutton).click().build().perform();
		Thread.sleep(2000);	
		driver.navigate().refresh();
		Thread.sleep(2000);
		value=page.getText().contains("Add Multiple Choice Question")
				&page.getText().contains("Content")
				&page.getText().contains("Settings")
				&page.getText().contains("References")
				&!saveAsDraft.isEnabled();

		if (value)
		{
			gf.highlightElement(MCQHeader);
			gf.highlightElement(saveAsDraft);
			return 1;
		}
		else
			return 0;	
	}
	public int searchQB() throws InterruptedException {
		nameQB="1000 May QB";
		gf.waitTillElementVisible(searchTextField);
		Thread.sleep(1000);
		searchTextField.sendKeys(nameQB);
		Thread.sleep(2000);
		//p[.='Test Adaptive learning']/../../*[5]
		WebElement status=driver.findElement
				(By.xpath("//p[.='"+nameQB+"']/../../*[5]"));
		for (int i = 0; i < QBNameListTable.size(); i++) {
			if (QBNameListTable.get(i).getText().equals(nameQB)&
					status.getText().equals("Published")) {
				value=true;
				gf.highlightElement(QBNameListTable.get(i));
				gf.highlightElement(status);
				break;
			} else {
				value=false;
			}
		}
		if (value) {
			return 1;
		} else {
			return 0;
		}
	}
	public int editPublishedQB() throws InterruptedException {
		for (int i = 0; i < QBNameListTable.size(); i++) {
			if (QBNameListTable.get(i).getText().equals(nameQB)){
				gf.highlightElement(QBNameListTable.get(i));
				break;
			} else {
				value=false;
			}
		}
		//p[.='Test Adaptive learning']/../..//button[1]
		WebElement edit=driver.findElement
				(By.xpath("//p[.='"+nameQB+"']/../..//button[1]"));
		Thread.sleep(2000);
		gf.highlightElement(edit);
		Thread.sleep(2000);
		edit.click();
		Thread.sleep(3000);	
		driver.navigate().refresh();
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(1000);
		gf.waitTillElementVisible(cancelButton);
		value=cancelButton.isDisplayed()&header.getText().equals(nameQB)
				&QBnameTextField.getAttribute("value").equals(nameQB);
		if (value&statusHeader.getText().equals("Published")) {
			gf.highlightElement(header);
			gf.highlightElement(QBnameTextField);
			gf.highlightElement(statusHeader);
			return 1;
		} else {
			return 0;
		}
	}
	//	public int navigateToMCQPage() throws InterruptedException
	//	{
	//		gf.highlightElement(MCQbutton);
	//		Actions act=new Actions(driver);
	//		act.moveToElement(MCQbutton).click().build().perform();
	//		Thread.sleep(2000);	
	//		driver.navigate().refresh();
	//		Thread.sleep(2000);
	//		value=page.getText().contains("Add Multiple Choice Question")
	//				&page.getText().contains("Content")
	//				&page.getText().contains("Settings")
	//				&page.getText().contains("References")
	//				&!saveAsDraft.isEnabled();
	//
	//		if (value)
	//		{
	//			gf.highlightElement(MCQHeader);
	//			gf.highlightElement(saveAsDraft);
	//			return 1;
	//		}
	//		else
	//			return 0;	
	//	}

	public int addQuestionAnswerMCQPage() throws InterruptedException 
	{
		gf.Wait(1000);
		questionField.sendKeys(nameQ);// question name 1
		value=saveAsDraft.isEnabled();
		saveAsDraftDDL.click();
		gf.Wait(1000);
		gf.waitTillElementVisible(publishButton);
		value=value&publishButton.getAttribute("tabindex").equals("-1");// publish enable 0, disable -1
		saveAsDraftDDL.click();
		answerTextFields.get(0).sendKeys("correct");
		answerTextFields.get(1).sendKeys("wrong 1");
		answerTextFields.get(2).sendKeys("wrong 2");
		answerTextFields.get(3).sendKeys("wrong 3");
		saveAsDraftDDL.click();
		Thread.sleep(1000);
		gf.waitTillElementVisible(publishButton);
		value=value&publishButton.isEnabled();
		System.out.println(publishButton.isEnabled()+"publishButton.isEnabled()");
		if (value)
		{
			gf.highlightElement(saveAsDraft);
			gf.highlightElement(publishButton);
			return 1;
		}
		else
			return 0;
	}
	public int publishMCQ() throws InterruptedException {

		publishButton.click();
		gf.waitTillElementVisible(popupPublish);
		popupPublish.click();
		Thread.sleep(2000);	

		//		gf.waitTillElementVisible(MCQHeader);
		gf.waitTillElementVisible(paginationGrid);
		Thread.sleep(2000);
		for (int i = 0; i < questionNameMCQTable.size(); i++) {
			if (questionNameMCQTable.get(i).getText().equals(nameQ)) {
				value=true;
				gf.highlightElement(questionNameMCQTable.get(i));
				break;
			} else {
				value=false;
			}
		}
		if (value) {
			saveAsDraftDDL.click();
			value=value&publishButton.isEnabled();
			System.out.println(publishButton.isEnabled()+" publishButton.isEnabled();");
			if (value) {

				return 1;
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}
	public int editPublishedQuestion() throws InterruptedException {
		//nameQ="11";
		Thread.sleep(2000);
		System.out.println(nameQ+"  " +1);
		//p[.='1']/../../*[5]
		WebElement status=driver.findElement
				(By.xpath("//p[.='"+nameQ+"']/../../*[5]"));
		System.out.println(nameQ+"  " +2);
		//p[.='1']/../../*[6]//button[1]
		WebElement edit=driver.findElement
				(By.xpath("//p[.='"+nameQ+"']/../../*[6]//button[1]"));
		for (int i = 1; i < QBNameListTable.size(); i++) {
			if (QBNameListTable.get(i).getText().equals(nameQ)&
					status.getText().equals("Published")) {
				gf.highlightElement(edit);
				gf.highlightElement(status);
				edit.click();
				break;
			} 
		}
		//		Thread.sleep(2000);	
		//		driver.navigate().refresh();
		//		Thread.sleep(2000);

		gf.waitTillElementVisible(header);
		value=cancelButton.isDisplayed()
				&questionField.getAttribute("value").equals(nameQ);
		if (value&statusHeader.getText().equals("Published")) {
			gf.highlightElement(questionField);
			gf.highlightElement(statusHeader);
			return 1;
		} else {
			return 0;
		}
	}

	public int editSaveQuestion() throws InterruptedException {
		questionField.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		saveAsDraft.click();
		gf.waitTillElementVisible(popup);
		value=popup.isDisplayed()&!savePopup.isEnabled();
		if (value) {
			gf.highlightElement(popup);
			gf.highlightElement(savePopup);
			return 1;
		} else {
			gf.highlightElementBold(savePopup);
			return 0;
		}
	}
	public int enterRevisionValue(String revisionValue) throws InterruptedException {
		this.revisionValue=revisionValue;
		revisionNoteTextField.sendKeys(revisionValue);
		value=savePopup.isEnabled();
		if(value) {
			gf.highlightElement(savePopup);
			return 1;
		} else {
			gf.highlightElementBold(savePopup);
			return 0;
		}
	}
	//	String editedNameQ;
	public int validatePopupSaveButton() throws InterruptedException {
		savePopup.click();
		gf.waitTillElementVisible(header);
		Thread.sleep(2000);
		//p[.='1']/../../*[5]
		this.nameQ=nameQ.substring(0, nameQ.length()-1);
		System.out.println(nameQ);
		WebElement status=driver.findElement
				(By.xpath("//p[.='"+nameQ+"']/../../*[5]"));
		//p[.='1']/../../*[6]//button[1]
		WebElement edit=driver.findElement
				(By.xpath("//p[.='"+nameQ+"']/../../*[6]//button[1]"));
		for (int i = 1; i < QBNameListTable.size(); i++) {
			if (QBNameListTable.get(i).getText().equals(nameQ)&
					status.getText().equals("Modified")) {
				gf.highlightElement(status);
				return 1;
			} 
		}
		return 0;
	}
	public int editModifiedQuestion() throws InterruptedException {
		//nameQ="11";
		Thread.sleep(2000);
		WebElement questionID=driver.findElement(By.xpath("//p[.='"+nameQ+"']/../../*[1]"));
		this.questionIDText=questionID.getText();
		//p[.='1']/../../*[5]
		WebElement status=driver.findElement(By.xpath("//p[.='"+nameQ+"']/../../*[5]"));
		System.out.println(nameQ+"  " +2);
		//p[.='1']/../../*[6]//button[1]
		WebElement edit=driver.findElement
				(By.xpath("//p[.='"+nameQ+"']/../../*[6]//button[1]"));
		for (int i = 1; i < QBNameListTable.size(); i++) {
			if (QBNameListTable.get(i).getText().equals(nameQ)&
					status.getText().equals("Modified")) {
				gf.highlightElement(edit);
				gf.highlightElement(status);
				edit.click();
				break;
			} 
		}
		//				Thread.sleep(2000);	
		//				driver.navigate().refresh();
		//				Thread.sleep(2000);

		gf.waitTillElementVisible(header);
		value=cancelButton.isDisplayed()
				&questionField.getAttribute("value").equals(nameQ);
		if (value&statusHeader.getText().equals("Modified")) {
			gf.highlightElement(questionID);
			gf.highlightElement(questionField);
			gf.highlightElement(statusHeader);
			return 1;
		} else {
			return 0;
		}
	}

	public int revisons() {
		revisionsButtonMenu.click();
		gf.waitTillElementVisible(revisionDate);
		value=revisionDate.getText().equals(gf.todayDateddMMMMyyyy())&
				revisionNote.getText().equals(revisionValue);
        System.out.println(gf.todayDateddMMMMyyyy());
        if (value) {
			gf.highlightElement(revisionDate);
			gf.highlightElement(revisionsHeading);
			gf.highlightElement(revisionNote);
			return 1;
		} else {
			return 0;
		}
	}
	public int previewRevision() {
		preview.click();
		gf.waitTillElementVisible(closePreview);
		System.out.println(headingID.getText().substring(5));
		System.out.println(questionIDText);
		value=headingID.getText().substring(5).equals(questionIDText);
        if (value) {
        	gf.highlightElement(headingID);
			return 1;
		} else {
			gf.highlightElementBold(headingID);
			return 0;
		}
	}
}