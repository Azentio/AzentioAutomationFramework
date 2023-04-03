package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankRecon_ReconcilliationObj {
	
	WebDriver driver;

	public BankRecon_ReconcilliationObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//ion-label[text()=' Bank recon ']")
	private WebElement bankRecon_Reconcilliation_Field;
	public WebElement bankRecon_Reconcilliation_Field() {
		return bankRecon_Reconcilliation_Field;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/9']")
	private WebElement bankRecon_Reconcilliation_EyeButton;

	public WebElement bankRecon_Reconcilliation_EyeButton() {
		return bankRecon_Reconcilliation_EyeButton;

	}
	@FindBy(xpath = "//ion-row[1]/ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement bankRecon_Reconcilliation_BankName;

	public WebElement bankRecon_Reconcilliation_BankName() {
		return bankRecon_Reconcilliation_BankName;

	}
	@FindBy(xpath = "//ion-row[1]/ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement bankRecon_Reconcilliation_AccountNumber;

	public WebElement bankRecon_Reconcilliation_AccountNumber() {
		return bankRecon_Reconcilliation_AccountNumber;

	}

	// CalendarFromDate
	@FindBy(xpath = "(//span[@class='input-calendar'])[1]")
	private WebElement bankRecon_Reconcilliation_CalendarDate;

	public WebElement bankRecon_Reconcilliation_CalendarDate() {
		return bankRecon_Reconcilliation_CalendarDate;
	}

	// NextMonth
	@FindBy(xpath = "(//button[@type='button'])[3]")
	private WebElement bankRecon_Reconcilliation_NextMonth;

	public WebElement bankRecon_Reconcilliation_NextMonth() {
		return bankRecon_Reconcilliation_NextMonth;
	}

	// CalendarToDate
	@FindBy(xpath = "(//span[@class='input-calendar'])[2]")
	private WebElement bankRecon_Reconcilliation_CalendarAsOnDate;

	public WebElement bankRecon_Reconcilliation_CalendarAsOnDate() {
		return bankRecon_Reconcilliation_CalendarAsOnDate;
	}
	@FindBy(xpath="//ion-col[8]/ion-item[1]/ion-input[1]/input[1]")
	private WebElement bankRecon_Reconcilliation_ChooseFile;
	public WebElement bankRecon_Reconcilliation_ChooseFile()
	{
		return bankRecon_Reconcilliation_ChooseFile;
	}
	
	@FindBy(xpath="//*[@id=\"toast-container\"]/div/div[1]")
	private WebElement bankRecon_Reconcilliation_ValidationMessage;
	public WebElement bankRecon_Reconcilliation_ValidationMessage()
	{
		return bankRecon_Reconcilliation_ValidationMessage;
	}
	
	@FindBy(xpath="//ion-button[contains(text(),'Upload')]")
	private WebElement bankRecon_Reconcilliation_UploadButton;
	public WebElement bankRecon_Reconcilliation_UploadButton()
	{
		return bankRecon_Reconcilliation_UploadButton;
	}
	@FindBy(xpath="//page-upload-payment-hdr-update//ion-toolbar//ion-buttons[2]//ion-button")
	private WebElement bankRecon_Reconcilliation_UploadSaveButton;
	public WebElement bankRecon_Reconcilliation_UploadSaveButton()
	{
		return bankRecon_Reconcilliation_UploadSaveButton;
	}
	// Process button

	@FindBy(xpath = "//page-bank-recon-details-update[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[2]")

	private WebElement bankRecon_BankReconciliation_ProcessButton;

	public WebElement bankRecon_BankReconciliation_ProcessButton() {

		return bankRecon_BankReconciliation_ProcessButton;

	}
	// Unmatched data tab

	@FindBy(xpath = "//span[3]/ion-tab-button/ion-label")

	private WebElement bankRecon_BankReconciliation_UnmatchedDataTab;

	public WebElement bankRecon_BankReconciliation_UnmatchedDataTab() {

		return bankRecon_BankReconciliation_UnmatchedDataTab;

	}
			// UnmatchedSuggestedRec

	@FindBy(xpath = "(//input[@id='saveCheckBox'][@name='selectFlag'])[2]")

	private WebElement bankRecon_BankReconciliation_UnmatchedSuggestedRec;

	public WebElement bankRecon_BankReconciliation_UnmatchedSuggestedRec() {

		return bankRecon_BankReconciliation_UnmatchedSuggestedRec;

	}
	// Suggested record in unmatched tab

	@FindBy(xpath = "//div[contains(text(),'SUGGESTED')]")

	private WebElement bankRecon_BankReconciliation_SuggestedRecord;

	public WebElement bankRecon_BankReconciliation_SuggestedRecord() {

		return bankRecon_BankReconciliation_SuggestedRecord;

	}
	//TotalBankRec 
	@FindBy(xpath = "//div[contains(text(),'1 total')]")

	private WebElement bankRecon_BankReconciliation_TotalBankRec;

	public WebElement bankRecon_BankReconciliation_TotalBankRec() {

		return bankRecon_BankReconciliation_TotalBankRec;

	}
	// UnmatchedTranspositionRec

	@FindBy(xpath = "(//input[@id='saveCheckBox'][@name='selectFlag'])[3]")

	private WebElement bankRecon_BankReconciliation_UnmatchedTranspositionRec;

	public WebElement bankRecon_BankReconciliation_UnmatchedTranspositionRec() {

		return bankRecon_BankReconciliation_UnmatchedTranspositionRec;

	}
	// Transposition record in unmatched tab

	@FindBy(xpath = "//div[contains(text(),'TRANSPOSITION')]")

	private WebElement bankRecon_BankReconciliation_TranspositionRecord;

	public WebElement bankRecon_BankReconciliation_TranspositionRecord() {

		return bankRecon_BankReconciliation_TranspositionRecord;

	}
	// UnmatchedRec

	@FindBy(xpath = "(//input[@id='saveCheckBox'][@name='selectFlag'])[1]")

	private WebElement bankRecon_BankReconciliation_UnmatchedRec;

	public WebElement bankRecon_BankReconciliation_UnmatchedRec() {

		return bankRecon_BankReconciliation_UnmatchedRec;

	}
	//unmatched record in unmatched tab 

	@FindBy(xpath = "//div[contains(text(),'UNMATCHED')]") 

	private WebElement bankRecon_BankReconciliation_UnmatchedRecord; 

	 

	public WebElement bankRecon_BankReconciliation_UnmatchedRecord() { 

		return bankRecon_BankReconciliation_UnmatchedRecord; 

	} 

}
