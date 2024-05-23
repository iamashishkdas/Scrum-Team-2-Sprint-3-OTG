package com.t2s3.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.t2s3.common.GenericFunctionsOAP;

public class T2S3_OAP2031_Page
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
	@FindBy(xpath = "//button[text()='Cancel']")
	WebElement cancel;
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
	@FindBy(xpath = "//button[.='Question Bank']")
	WebElement addQBButtonAssessment;
	@FindBy(xpath = "//div[@aria-labelledby='questionBank-label']")
	WebElement addQBDDLAssessment;
	@FindBy(xpath="//li[@role='option']")
	List<WebElement> addQBAssessmentList;
	@FindBy(xpath = "//button[.='Add']")
	WebElement addButtonPopup;
	
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
	List<WebElement> statusList;
	@FindBy(xpath = "(//span[text()='Question Banks'])[1]")
	WebElement QBMenu;
	@FindBy(xpath = "//h5[text()='Question Banks']")
	WebElement QBHeader;
	@FindBy(xpath = "//button[text()='New Question Bank']")
	WebElement NewQBbutton;

	@FindBy(xpath = "//input[@type='search']")
	WebElement QBSearchField;
	@FindBy(xpath = "//table//tbody//td[2]")
	List<WebElement> QBNameListTable;
	@FindBy(xpath = "//ul[@role='listbox']//li")
	List<WebElement> namesQBList;

	@FindBy(xpath = "//h5[text()='New Question Bank']")
	WebElement NewQBheader;

	@FindBy(xpath = "//button[text()='Cancel']")
	WebElement cancelButton;

	@FindBy(xpath = "//button[text()='Save as draft']")
	WebElement saveAsDraft;

	@FindBy(xpath = "//button[text()='Save as draft']/..//*[local-name()='svg']")
	WebElement saveAsDraftDDL;

	@FindBy(xpath = "//div[text()='Publish']")
	WebElement publishButton;

	@FindBy(xpath = "//div[@role='dialog']")
	WebElement popup;

	@FindBy(xpath = "//button[.='Publish']")
	WebElement popupPublish;

	@FindBy(xpath = "//div[@role='dialog']//button[text()='Archive']")
	WebElement archiveButtonInPopup;

	@FindBy(xpath = "//div[@role='dialog']//button[text()='Delete']")
	WebElement deleteButtonInPopup;

	@FindBy(xpath = "//table")
	WebElement questionAreaTable;

	@FindBy(xpath = "//table//span[text()='Draft']/..")
	WebElement drftMCQInTable;

	@FindBy(xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-17b2gzg']")
	WebElement editIcon;

	@FindBy(xpath = "//span[text()='Ready']/..")
	WebElement whenMCQisReady;

	@FindBy(xpath = "//input[@type='search']/..")
	WebElement questionSearchField;
	@FindBy(xpath = "//input[@type='search']")
	WebElement inputSearchField;
	@FindBy(xpath ="//tbody[@class='MuiTableBody-root css-1xnox0e']//tr")
	List<WebElement> QBsuggestions;

	@FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-17b2gzg'])[2]")
	WebElement searchPublishedQuestion;

	@FindBy(xpath = "//h5[text()='New QS-2']/..")
	WebElement publishedQBheader;

	@FindBy(xpath = "//button[text()='Restore']")
	WebElement restoreButton;

	@FindBy(xpath = "//div[@role='dialog']//button[text()='Restore']")
	WebElement restoreButtonInPopup;
	
	String time=System.currentTimeMillis()+"";
	String nameQB=time+" QB";
	String nameQ=time+" Q";
	String question1=1+ nameQ;
	String question2=2+ nameQ;
	String question3=3+ nameQ;
	String nameAssessment=time+" Assessment";
	public T2S3_OAP2031_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		gf=new GenericFunctionsOAP(driver);
	}

	public int assessmentPlatformHome() throws InterruptedException  
	{
		gf.waitTillElementVisible(nameColumntable);
	    value=nameColumntable.isDisplayed();
	    Thread.sleep(3000);
	   
		if (value)
			 return 1;
		else
			 return 0;
	}
	public int toAssessments() throws InterruptedException  
	{
		gf.unhighlightElement(QBMenu);
		gf.highlightElement(assessmentsMenu);
		assessmentsMenu.click();
		gf.waitTillElementVisible(newAssessment);
	    value=newAssessment.isDisplayed();
	    Thread.sleep(1000);
		if (value)
			 return 1;
		else
			 return 0;
	}
	public int newAssessment()  
	{
		gf.highlightElement(newAssessment);
		newAssessment.click();
		gf.waitTillElementVisible(cancel);
	    value=cancel.isDisplayed()&!saveAsDraft.isEnabled();
		if (value)
			 return 1;
		else
			 return 0;
	}
	public int publishButtonBeforeFilling() throws InterruptedException  
	{
		assessmentNameTextField2.sendKeys("a");
		saveAsDraftDDL.click();
		value=publishButton.getAttribute("tabindex").equals("-1");// publish enable 0, disable -1
		if (value)
			{
			gf.highlightElement(publishButton);
			 return 1;
			}
		else {
			gf.highlightElementBold(publishButton);
			 return 0;
		}
		}
	
	public int addMandatoryFields() throws InterruptedException  
	{
		gf.highlightElement(assessmentTypeDDL);
		assessmentTypeDDL.click();
		Thread.sleep(2000);
		gf.highlightElement(DDLList.get(0));
		DDLList.get(0).click();
		Thread.sleep(2000);
		gf.highlightElement(functionalAreaDDL);
		functionalAreaDDL.click();
		Thread.sleep(2000);
		gf.highlightElement(DDLList.get(0));
		DDLList.get(0).click();
		Thread.sleep(2000);
		gf.highlightElement(detailedSubjectDDL);
		detailedSubjectDDL.click();
		Thread.sleep(2000);
		gf.highlightElement(DDLList.get(0));
		DDLList.get(0).click();
		Thread.sleep(2000);
		gf.highlightElement(addQBButtonAssessment);
		addQBButtonAssessment.click();
		gf.waitTillElementVisible(popup);
		gf.highlightElement(addQBDDLAssessment);
		addQBDDLAssessment.click();
		gf.highlightElement(namesQBList.get(0));
		namesQBList.get(0).click();
		value=addButtonPopup.isDisplayed();
		if (value)
			{
			gf.highlightElement(addButtonPopup);
			 return 1;
			}
		else {
			gf.highlightElementBold(addButtonPopup);
			 return 0;
		}
		}
	public void addQBButton() {
		addButtonPopup.click();
		//value=publishButton.getAttribute("tabindex").equals("0");// publish enable 0, disable -1
	}
	public int publishEnabled() {
		saveAsDraftDDL.click();
		gf.waitTillElementVisible(publishButton);
		value=publishButton.getAttribute("tabindex").equals("0");// publish enable 0, disable -1
		if (value)
		{
		gf.highlightElement(publishButton);
		 return 1;
		}
	else {
		gf.highlightElementBold(publishButton);
		 return 0;
	}
	}
}
