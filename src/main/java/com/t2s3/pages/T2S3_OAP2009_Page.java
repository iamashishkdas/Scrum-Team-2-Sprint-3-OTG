package com.t2s3.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.t2s3.common.GenericFunctionsOAP;

public class T2S3_OAP2009_Page
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
	@FindBy(xpath = "//div[text()='Publish']")
	WebElement publishButton;
	@FindBy(xpath = "//div[text()='Archive']")
	WebElement archiveButton;
	String time=System.currentTimeMillis()+"";
	String nameQB=time+" QB";
	String nameQ=time+" Q";
	String question1=1+ nameQ;
	String question2=2+ nameQ;
	String question3=3+ nameQ;
	String revisionValue;
	String questionIDText;
	public T2S3_OAP2009_Page(WebDriver driver)
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
	public int archiveButton() throws InterruptedException
	{
		gf.highlightElement(saveAsDraftDDL);
		saveAsDraftDDL.click();

		 String colorCode = archiveButton.getCssValue("color");

	        // Print the color code
	        System.out.println("Color code of the element: " + colorCode);

	        // Validate the color code
	        if(colorCode.equals("rgba(0, 0, 0, 1)")) {
	        	System.out.println("Expected rgba(0, 0, 0, 1)");
	        	System.out.println("Actual "+colorCode);
	            gf.highlightElement(archiveButton);
				return 1;
	        } else {
	        	System.out.println("Expected rgba(0, 0, 0, 1)");
	            System.out.println("Actual "+colorCode);
	            gf.highlightElementBold(archiveButton);
				return 0;
	        }
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
		Thread.sleep(2000);	
		driver.navigate().refresh();
		Thread.sleep(2000);

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
	
}