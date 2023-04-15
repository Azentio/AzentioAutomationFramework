package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankRecon_BankReconciliationObj {
	WebDriver driver;

	public BankRecon_BankReconciliationObj(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//	Bank Reconciliation SUBMODULE  //
	
	//Bank Recon Menu
	@FindBy(xpath = "//ion-label[text()=' Bank recon ']")
	private WebElement BankReconciliationMenu;

	public WebElement BankReconciliationMenu() {
		return BankReconciliationMenu;
	}
	
	//Bank Recon format eye button
	@FindBy(xpath = "//ion-label[text()=' Recon format ']/following-sibling::ion-buttons/ion-button[2]")
	private WebElement BankRecon_BankReconFormat_eyeButton;
	
	public WebElement BankRecon_BankReconFormat_eyeButton() {
		return BankRecon_BankReconFormat_eyeButton;
	}

	//temp view button
	@FindBy(xpath = "//ion-label[text()=' Bank reconciliation ']/following-sibling::ion-buttons/ion-button[1]")
	private WebElement BankRecon_BankReconciliation_TempView;

	public WebElement BankRecon_BankReconciliation_TempView() {
		return BankRecon_BankReconciliation_TempView;
	}
	
	//inbox button
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/inbox']")
	private WebElement BankRecon_BankReconciliation_InboxButton;
	
	public WebElement BankRecon_BankReconciliation_InboxButton() {
		return BankRecon_BankReconciliation_InboxButton;
	}
	
	//temp view search button
//	@FindBy(xpath = "//ion-icon[@aria-label='search']")
//	@FindBy(xpath = "//ion-icon[@title='Enable Search']")
	@FindBy(xpath = "//ion-buttons[2]/ion-item/ion-icon")
	private WebElement BankRecon_BankReconciliation_TempViewSearchButton;
	
	public WebElement BankRecon_BankReconciliation_TempViewSearchButton() {
		return BankRecon_BankReconciliation_TempViewSearchButton;
	}
	
	//temp view first record action button
	@FindBy(xpath = "//datatable-row-wrapper[1]/descendant::ion-button")
	private WebElement BankRecon_BankReconciliation_firstRecordActionButton;
	
	public WebElement BankRecon_BankReconciliation_firstRecordActionButton() {
		return BankRecon_BankReconciliation_firstRecordActionButton;
	}
	
	//temp record cancel
	@FindBy(xpath = "//span/ion-button[2]")
	private WebElement BankRecon_BankReconciliation_cancelButton;
	
	public WebElement BankRecon_BankReconciliation_cancelButton() {
		return BankRecon_BankReconciliation_cancelButton;
	}
	
	//bank name search record
	@FindBy(xpath = "//label[text()=' Bank Name ']/following-sibling::ion-input/input")
	private WebElement BankRecon_BankReconciliation_BankNameSearch;
	
	public WebElement BankRecon_BankReconciliation_BankNameSearch() {
		return BankRecon_BankReconciliation_BankNameSearch;
	}
	
	//view record
	@FindBy(xpath = "//datatable-row-wrapper[1]/descendant::ion-button[1]")
	private WebElement BankRecon_BankReconFormat_viewRecord;
	
	public WebElement BankRecon_BankReconFormat_viewRecord() {
		return BankRecon_BankReconFormat_viewRecord;
	}
	
	
	//Data Matching Rule tab
	@FindBy(xpath = "//ion-label[contains(text(),'Data Matching Rule')]")
	private WebElement BankRecon_BankReconFormat_DataMatchingRuleTab;
	
	public WebElement BankRecon_BankReconFormat_DataMatchingRuleTab() {
		return BankRecon_BankReconFormat_DataMatchingRuleTab;
	}
	
	//search field name
	@FindBy(xpath = "//input[@placeholder='Search Field Name']")
	private WebElement BankRecon_BankReconFormat_SearchFieldName;
	
	public WebElement BankRecon_BankReconFormat_SearchFieldName() {
		return BankRecon_BankReconFormat_SearchFieldName;
	}
	
	//Value date data matching rule
	@FindBy(xpath = "//span[text()='  Value Date ']/ancestor::datatable-row-wrapper/descendant::ion-button[1]")
	private WebElement BankRecon_BankReconFormat_ValueDateView;
	
	public WebElement BankRecon_BankReconFormat_ValueDateView() {
		return BankRecon_BankReconFormat_ValueDateView;
	}
	
	//Transaction date data matching rule
	@FindBy(xpath = "//span[text()=' Transaction Date ']/ancestor::datatable-row-wrapper/descendant::ion-button[1]")
	private WebElement BankRecon_BankReconFormat_TransactionDateView;
	
	public WebElement BankRecon_BankReconFormat_TransactionDateView() {
		return BankRecon_BankReconFormat_TransactionDateView;
	}
	
	//Instrument Number data matching rule
	@FindBy(xpath = "//span[text()=' Instrument Number ']/ancestor::datatable-row-wrapper/descendant::ion-button[1]")
	private WebElement BankRecon_BankReconFormat_InstrumentNumberView;
	
	public WebElement BankRecon_BankReconFormat_InstrumentNumberView() {
		return BankRecon_BankReconFormat_InstrumentNumberView;
	}
	
	//Deposits data matching rule
	@FindBy(xpath = "//span[text()=' Deposits ']/ancestor::datatable-row-wrapper/descendant::ion-button[1]")
	private WebElement BankRecon_BankReconFormat_DepositsView;
	
	public WebElement BankRecon_BankReconFormat_DepositsView() {
		return BankRecon_BankReconFormat_DepositsView;
	}
	
	//Particulars data matching rule
	@FindBy(xpath = "//span[text()=' Particulars ']/ancestor::datatable-row-wrapper/descendant::ion-button[1]")
	private WebElement BankRecon_BankReconFormat_ParticularsView;
	
	public WebElement BankRecon_BankReconFormat_ParticularsView() {
		return BankRecon_BankReconFormat_ParticularsView;
	}
	
	//Withdrawls data matching rule
	@FindBy(xpath = "//span[text()=' Withdrawals ']/ancestor::datatable-row-wrapper/descendant::ion-button[1]")
	private WebElement BankRecon_BankReconFormat_WithdrawlsView;
	
	public WebElement BankRecon_BankReconFormat_WithdrawlsView() {
		return BankRecon_BankReconFormat_WithdrawlsView;
	}
	
	//Match Condition input field
	@FindBy(xpath = "//label[text()=' Match Condition ']/following-sibling::ng-select/descendant::span[2]")
	private WebElement BankRecon_BankReconFormat_MatchConditionInput;
	
	public WebElement BankRecon_BankReconFormat_MatchConditionInput() {
		return BankRecon_BankReconFormat_MatchConditionInput;
	}
	
	//Suggested Condition input field
	@FindBy(xpath = "//label[text()=' Suggested Condition ']/following-sibling::ng-select/descendant::span[2]")
	private WebElement BankRecon_BankReconFormat_SuggestedConditionInput;
	
	public WebElement BankRecon_BankReconFormat_SuggestedConditionInput() {
		return BankRecon_BankReconFormat_SuggestedConditionInput;
	}
	
	//Transposition Condition input field
	@FindBy(xpath = "//label[text()=' Transposition Condition ']/following-sibling::ng-select/descendant::span[2]")
	private WebElement BankRecon_BankReconFormat_TranspositionConditionInput;
	
	public WebElement BankRecon_BankReconFormat_TranspositionConditionInput() {
		return BankRecon_BankReconFormat_TranspositionConditionInput;
	}
	
	//Back Button
	@FindBy(xpath = "//ion-back-button")
	private WebElement BankRecon_BankReconFormat_DataMatchingBackButton;
	
	public WebElement BankRecon_BankReconFormat_DataMatchingBackButton() {
		return BankRecon_BankReconFormat_DataMatchingBackButton;
	}
	
	//Eye button
	@FindBy(xpath = "//div[9]//ion-menu-toggle[1]//ion-item//ion-buttons//ion-button[2]")
	private WebElement BankRecon_BankReconciliation_EyeButton;
	
	public WebElement BankRecon_BankReconciliation_EyeButton() {
		return BankRecon_BankReconciliation_EyeButton;
	}
	
	//Add button
	@FindBy(xpath = "//ion-fab-button[@id='addBtn']")
	private WebElement BankRecon_BankReconciliation_AddButton;
	
	public WebElement BankRecon_BankReconciliation_AddButton() {
		return BankRecon_BankReconciliation_AddButton;
	}
	
	//Bank Name
	@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement BankRecon_BankReconciliation_BankName;
	
	public WebElement BankRecon_BankReconciliation_BankName() {
		return BankRecon_BankReconciliation_BankName;
	}
	
	//Account number
	@FindBy(xpath = "//ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement BankRecon_BankReconciliation_AccountNumber;
	
	public WebElement BankRecon_BankReconciliation_AccountNumber() {
		return BankRecon_BankReconciliation_AccountNumber;
	}
	
	//Recon Period From
//	@FindBy(xpath = "//ion-col[6]/app-kub-date-time/ion-item/div/span/ion-icon[1]")
	@FindBy(xpath = "(//span[@class='input-calendar'])[1]")
	private WebElement BankRecon_BankReconciliation_ReconPeriodFrom;
	
	public WebElement BankRecon_BankReconciliation_ReconPeriodFrom() {
		return BankRecon_BankReconciliation_ReconPeriodFrom;
	}
	
	//Recon Period To
//	@FindBy(xpath = "//ion-col[7]/app-kub-date-time/ion-item/div/span/ion-icon[1]")
	@FindBy(xpath = "(//span[@class='input-calendar'])[2]")
	private WebElement BankRecon_BankReconciliation_ReconPeriodTo;
	
	public WebElement BankRecon_BankReconciliation_ReconPeriodTo() {
		return BankRecon_BankReconciliation_ReconPeriodTo;
	}
	
	//Upload File
//	@FindBy(xpath = "//ion-col[8]/ion-item[1]/ion-input[1]")
	@FindBy(xpath = "//ion-col[8]/ion-item[1]/ion-input[1]/input[1]")
	private WebElement BankRecon_BankReconciliation_UploadFile;
	
	public WebElement BankRecon_BankReconciliation_UploadFile() {
		return BankRecon_BankReconciliation_UploadFile;
	}
	
//	//Toast message
//	@FindBy(xpath = "document.querySelector('ion-toast').shadowRoot.querySelector(\"div[class='toast-message']\").innerText")
//	private WebElement BankRecon_BankReconciliation_ToastMessage;
//	
//	public WebElement BankRecon_BankReconciliation_ToastMessage() {
//		return BankRecon_BankReconciliation_ToastMessage;
//	}
	
	
	//Save button
	@FindBy(xpath = "//page-bank-recon-details-update[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1]")
	private WebElement BankRecon_BankReconciliation_SaveButton;
	
	public WebElement BankRecon_BankReconciliation_SaveButton() {
		return BankRecon_BankReconciliation_SaveButton;
	}
	
	@FindBy(xpath="//*[@id=\"toast-container\"]/div/div[1]")
	private WebElement bankRecon_BankReconciliation_ValidationMessage;
	public WebElement bankRecon_BankReconciliation_ValidationMessage()
	{
		return bankRecon_BankReconciliation_ValidationMessage;
	}
	
	//Process button
	@FindBy(xpath = "//page-bank-recon-details-update[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[2]")
	private WebElement BankRecon_BankReconciliation_ProcessButton;
	
	public WebElement BankRecon_BankReconciliation_ProcessButton() {
		return BankRecon_BankReconciliation_ProcessButton;
	}
	
	// Process button For Reprocessing
	@FindBy(xpath = "//page-bank-recon-details-update/ion-header/ion-toolbar/ion-buttons[2]/ion-button")
	private WebElement BankRecon_BankReconciliation_ProcessButtonForReprocessing;
	
	public WebElement BankRecon_BankReconciliation_ProcessButtonForReprocessing() {
		return BankRecon_BankReconciliation_ProcessButtonForReprocessing;
	}
	
	// BankReconciliatioDetails tab
	@FindBy(xpath = "//span[1]/ion-tab-button")
	private WebElement BankRecon_BankReconciliation_BankReconciliatioDetails;
	
	public WebElement BankRecon_BankReconciliation_BankReconciliatioDetails() {
		return BankRecon_BankReconciliation_BankReconciliatioDetails;
	}
	
	//Bank Reconciliation Process tab
	@FindBy(xpath = "//span[2]/ion-tab-button")
	private WebElement BankRecon_BankReconciliation_BankReconciliationProcessTab;
	
	public WebElement BankRecon_BankReconciliation_BankReconciliationProcessTab() {
		return BankRecon_BankReconciliation_BankReconciliationProcessTab;
	}
	
	//Bank Reconciliation Statement tab
	@FindBy(xpath = "//span[4]/ion-tab-button/ion-label")
	private WebElement BankRecon_BankReconciliation_BankReconciliationStatementTab;
	
	public WebElement BankRecon_BankReconciliation_BankReconciliationStatementTab() {
		return BankRecon_BankReconciliation_BankReconciliationStatementTab;
	}
	
	//Records From Book Checkbox
	@FindBy(xpath = "//input[@id='saveCheckBox']")
	private WebElement BankRecon_BankReconciliation_RecordsFromBookCheckbox;
	
	public WebElement BankRecon_BankReconciliation_RecordsFromBookCheckbox() {
		return BankRecon_BankReconciliation_RecordsFromBookCheckbox;
	}
	
	//Records From Bank statement Title
	@FindBy(xpath = "//ion-item[contains(text(),'Records from Bank Statement')]")
	private WebElement BankRecon_BankReconciliation_RecordsFromBankStatementTitle;
	
	public WebElement BankRecon_BankReconciliation_RecordsFromBankStatementTitle() {
		return BankRecon_BankReconciliation_RecordsFromBankStatementTitle;
	}
	
	//Receipt Records From Bank statement
	@FindBy(xpath = "(//div[contains(text(),'RRN002')])[2]")
	private WebElement BankRecon_BankReconciliation_ReceiptNoFromBankStatement;
	
	public WebElement BankRecon_BankReconciliation_ReceiptNoFromBankStatement() {
		return BankRecon_BankReconciliation_ReceiptNoFromBankStatement;
	}
	
	//Search Records From Book
	@FindBy(xpath = "(//ion-col[2]/ion-item/ion-buttons/ion-button)[1]")
	private WebElement BankRecon_BankReconciliation_SearchButton1;
	
	public WebElement BankRecon_BankReconciliation_SearchButton1() {
		return BankRecon_BankReconciliation_SearchButton1;
	}
	
	//Search Records From Bank Statement
	@FindBy(xpath = "(//ion-col[2]/ion-item/ion-buttons/ion-button)[2]")
	private WebElement BankRecon_BankReconciliation_SearchButton2;
	
	public WebElement BankRecon_BankReconciliation_SearchButton2() {
		return BankRecon_BankReconciliation_SearchButton2;
	}
	
	//Receipt Search field Records From Book [Book to Bank]
	@FindBy(xpath = "//input[@placeholder='Search instrument No']")
	private WebElement BankRecon_BankReconciliation_SearchReceiptRecord;
	
	public WebElement BankRecon_BankReconciliation_SearchReceiptRecord() {
		return BankRecon_BankReconciliation_SearchReceiptRecord;
	}
	
	//Receipt Search field Records From Bank [Bank to Book]
	@FindBy(xpath = "//ion-grid[1]/descendant::input[@placeholder='Search instrument No']")
	private WebElement BankRecon_BankReconciliation_SearchBankToBookReceiptRecord1;
	
	public WebElement BankRecon_BankReconciliation_SearchBankToBookReceiptRecord1() {
		return BankRecon_BankReconciliation_SearchBankToBookReceiptRecord1;
	}
	
	//verify yes
	@FindBy(xpath = "//app-kub-lov/ion-select")
	private WebElement BankRecon_BankReconciliation_Verify;
	
	public WebElement BankRecon_BankReconciliation_Verify() {
		return BankRecon_BankReconciliation_Verify;
	}
	
	//verify yes
	@FindBy(xpath = "//button[2]/div/div[2]")
	private WebElement BankRecon_BankReconciliation_VerifyYes;
	
	public WebElement BankRecon_BankReconciliation_VerifyYes() {
		return BankRecon_BankReconciliation_VerifyYes;
	}
	
	//verify ok button
	@FindBy(xpath = "//span[contains(text(),'OK')]")
	private WebElement BankRecon_BankReconciliation_VerifyConfirm;
	
	public WebElement BankRecon_BankReconciliation_VerifyConfirm() {
		return BankRecon_BankReconciliation_VerifyConfirm;
	}
	
	//Receipt Search field Records From Book [Bank to Book]
	@FindBy(xpath = "//ion-grid[2]/descendant::input[@placeholder='Search instrument No']")
	private WebElement BankRecon_BankReconciliation_SearchBankToBookReceiptRecord2;
	
	public WebElement BankRecon_BankReconciliation_SearchBankToBookReceiptRecord2() {
		return BankRecon_BankReconciliation_SearchBankToBookReceiptRecord2;
	}
	
	
	
	//Unmatched data tab
	@FindBy(xpath = "//span[3]/ion-tab-button/ion-label")
	private WebElement BankRecon_BankReconciliation_UnmatchedDataTab;
	
	public WebElement BankRecon_BankReconciliation_UnmatchedDataTab() {
		return BankRecon_BankReconciliation_UnmatchedDataTab;
	}
	
	//Unmatched data Match button
//	@FindBy(xpath = "//page-book-recon-data-match-update[1]/div/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1]")
	@FindBy(xpath = "//ion-button[contains(text(),'Match')]")
	private WebElement BankRecon_BankReconciliation_UnmatchedDataMatchButton;
	
	public WebElement BankRecon_BankReconciliation_UnmatchedDataMatchButton() {
		return BankRecon_BankReconciliation_UnmatchedDataMatchButton;
	}
	
	//Unmatched data save button
	@FindBy(xpath = "//page-book-recon-data-match-update[1]/div/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[2]")
	private WebElement BankRecon_BankReconciliation_UnmatchedDataSaveButton;
	
	public WebElement BankRecon_BankReconciliation_UnmatchedDataSaveButton() {
		return BankRecon_BankReconciliation_UnmatchedDataSaveButton;
	}
	
	//Matched data tab
	@FindBy(xpath = "//span[2]/ion-tab-button/ion-label")
	private WebElement BankRecon_BankReconciliation_MatchedDataTab;
	
	public WebElement BankRecon_BankReconciliation_MatchedDataTab() {
		return BankRecon_BankReconciliation_MatchedDataTab;
	}
	
	//Matched Data Unmatch button
	@FindBy(xpath = "//page-bank-recon-data-match-update[1]/div/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1]")
	private WebElement BankRecon_BankReconciliation_MatchedDataUnmatchButton;
	
	public WebElement BankRecon_BankReconciliation_MatchedDataUnmatchButton() {
		return BankRecon_BankReconciliation_MatchedDataUnmatchButton;
	}
	
	//Matched Data Save button 
	@FindBy(xpath = "//page-bank-recon-data-match-update[1]/div/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[2]")
	private WebElement BankRecon_BankReconciliation_MatchedDataSaveButton;
	
	public WebElement BankRecon_BankReconciliation_MatchedDataSaveButton() {
		return BankRecon_BankReconciliation_MatchedDataSaveButton;
	}
	
	//Matched Data count 
	@FindBy(xpath = "//ion-grid[2]/ngx-datatable[1]/div[1]/datatable-footer[1]/div[1]/div[1]")
	private WebElement BankRecon_BankReconciliation_MatchedDataCount;
	
	public WebElement BankRecon_BankReconciliation_MatchedDataCount() {
		return BankRecon_BankReconciliation_MatchedDataCount;
	}
	
	//Multiple Matched Data count 
	@FindBy(xpath = "//ion-grid[3]/ngx-datatable[1]/div[1]/datatable-footer[1]/div[1]/div[1]")
	private WebElement BankRecon_BankReconciliation_multipleMatchedDataCount;
	
	public WebElement BankRecon_BankReconciliation_multipleMatchedDataCount() {
		return BankRecon_BankReconciliation_multipleMatchedDataCount;
	}
	
	//bank reconciliation basis-Book to bank text
	@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/span[2]")
	private WebElement BankRecon_BankReconciliation_BankReconBasis;
	
	public WebElement BankRecon_BankReconciliation_BankReconBasis() {
		return BankRecon_BankReconciliation_BankReconBasis;
	}
	
//	//bank reconciliation basis close span
////	@FindBy(xpath = "//span[@title='Clear all']")
//	@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/span[1]")
//	private WebElement BankRecon_BankReconciliation_BankReconBasisClose;
//	
//	public WebElement BankRecon_BankReconciliation_BankReconBasisClose() {
//		return BankRecon_BankReconciliation_BankReconBasisClose;
//	}
//	
//	//bank reconciliation basis dropdown span
////	@FindBy(xpath = "//span[@title='Clear all']")
//	@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/span[2]")
//	private WebElement BankRecon_BankReconciliation_BankReconBasisDropDown;
//	
//	public WebElement BankRecon_BankReconciliation_BankReconBasisDropDown() {
//		return BankRecon_BankReconciliation_BankReconBasisDropDown;
//	}
	
	//bank reconciliation basis input field
	@FindBy(xpath = "//ion-grid[1]//ion-col[2]//ng-select/div/div/div/input")
	private WebElement BankRecon_BankReconciliation_BankReconBasisField;
	
	public WebElement BankRecon_BankReconciliation_BankReconBasisField() {
		return BankRecon_BankReconciliation_BankReconBasisField;
	}
	
	//unmatched record in unmatched tab
//	@FindBy(xpath = "//ion-grid[1]/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[9]/div")
	@FindBy(xpath = "(//div[contains(text(),'UNMATCHED')])[1]")
	private WebElement BankRecon_BankReconciliation_UnmatchedRecord;
	
	public WebElement BankRecon_BankReconciliation_UnmatchedRecord() {
		return BankRecon_BankReconciliation_UnmatchedRecord;
	}
	
	//Suggested record in unmatched tab
	@FindBy(xpath = "//div[contains(text(),'SUGGESTED')]")
	private WebElement BankRecon_BankReconciliation_SuggestedRecord;
	
	public WebElement BankRecon_BankReconciliation_SuggestedRecord() {
		return BankRecon_BankReconciliation_SuggestedRecord;
	}
	
	//Transposition record in unmatched tab
	@FindBy(xpath = "//div[contains(text(),'TRANSPOSITION')]")
	private WebElement BankRecon_BankReconciliation_TranspositionRecord;
	
	public WebElement BankRecon_BankReconciliation_TranspositionRecord() {
		return BankRecon_BankReconciliation_TranspositionRecord;
	}
	
	
	//Search for records from book
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col/ion-item/ion-buttons/ion-button")
	private WebElement BankRecon_BankReconciliation_RecordsFromBookSearch;
	
	public WebElement BankRecon_BankReconciliation_RecordsFromBookSearch() {
		return BankRecon_BankReconciliation_RecordsFromBookSearch;
	}
	
	//Search status and respective records from book
	@FindBy(xpath = "//ion-grid[1]/ngx-datatable[1]/div[1]/datatable-header[1]/div[1]/div[2]/datatable-header-cell[9]/div[1]/ion-input[1]/input[1]")
	private WebElement BankRecon_BankReconciliation_StatusSearch;
	
	public WebElement BankRecon_BankReconciliation_StatusSearch() {
		return BankRecon_BankReconciliation_StatusSearch;
	}
	
//	//Search for records from bank
//	@FindBy(xpath = "//ion-grid[2]/ion-row/ion-col/ion-item/ion-buttons/ion-button")
//	private WebElement BankRecon_BankReconciliation_RecordsFromBankStatementSearch;
//	
//	public WebElement BankRecon_BankReconciliation_RecordsFromBankStatementSearch() {
//		return BankRecon_BankReconciliation_RecordsFromBankStatementSearch;
//	}


	//records from book count in unmatched tab
	@FindBy(xpath = "//ion-grid[1]/ngx-datatable[1]/div[1]/datatable-footer[1]/div[1]/div[1]")
	private WebElement BankRecon_BankReconciliation_RecordCountFromBook;
	
	public WebElement BankRecon_BankReconciliation_RecordCountFromBook() {
		return BankRecon_BankReconciliation_RecordCountFromBook;
	}
	
	
	//records from bank statement count in unmatched tab
	@FindBy(xpath = "//ion-grid[2]/ngx-datatable[1]/div[1]/datatable-footer[1]/div[1]/div[1]")
	private WebElement BankRecon_BankReconciliation_RecordCountFromBankStatement;
	
	public WebElement BankRecon_BankReconciliation_RecordCountFromBankStatement() {
		return BankRecon_BankReconciliation_RecordCountFromBankStatement;
	}
	
	//particulars from book
	@FindBy(xpath = "//ion-grid[2]/descendant::datatable-body-row/div[2]/datatable-body-cell[3]/div")
	private WebElement BankRecon_BankReconciliation_particularsFromBook;
	
	public WebElement BankRecon_BankReconciliation_particularsFromBook() {
		return BankRecon_BankReconciliation_particularsFromBook;
	}
	
	//particulars from Bank statement
	@FindBy(xpath = "//ion-grid[3]/descendant::datatable-body-row/div[2]/datatable-body-cell[3]/div")
	private WebElement BankRecon_BankReconciliation_particularsFromBank;
	
	public WebElement BankRecon_BankReconciliation_particularsFromBank() {
		return BankRecon_BankReconciliation_particularsFromBank;
	}
	
	//Instrument number from book
	@FindBy(xpath = "//ion-grid[2]/descendant::datatable-body-row/div[2]/datatable-body-cell[5]/div")
	private WebElement BankRecon_BankReconciliation_instrumentNumberFromBook;
	
	public WebElement BankRecon_BankReconciliation_instrumentNumberFromBook() {
		return BankRecon_BankReconciliation_instrumentNumberFromBook;
	}
	
	//Instrument number from Bank statement
	@FindBy(xpath = "//ion-grid[3]/descendant::datatable-body-row/div[2]/datatable-body-cell[5]/div")
	private WebElement BankRecon_BankReconciliation_instrumentNumberFromBank;
	
	public WebElement BankRecon_BankReconciliation_instrumentNumberFromBank() {
		return BankRecon_BankReconciliation_instrumentNumberFromBank;
	}
	
	//Withdrawl amount from book
	@FindBy(xpath = "//ion-grid[2]/descendant::datatable-body-row/div[2]/datatable-body-cell[6]/div")
	private WebElement BankRecon_BankReconciliation_WithDrawlAmountFromBook;
	
	public WebElement BankRecon_BankReconciliation_WithDrawlAmountFromBook() {
		return BankRecon_BankReconciliation_WithDrawlAmountFromBook;
	}
	
	//Deposit amount from Bank Statement
	@FindBy(xpath = "//ion-grid[3]/descendant::datatable-body-row/div[2]/datatable-body-cell[7]/div")
	private WebElement BankRecon_BankReconciliation_depositAmountFromBank;
	
	public WebElement BankRecon_BankReconciliation_depositAmountFromBank() {
		return BankRecon_BankReconciliation_depositAmountFromBank;
	}
	
	// Adjusted Balance as per Bank Statement
	@FindBy(xpath = "//b[text()='Adjusted Balance as per Bank Statement']/../../../descendant::ion-label[2]")
	private WebElement BankRecon_BankReconciliation_AdjustedBalanceAsPerBankStatement;
	
	public WebElement BankRecon_BankReconciliation_AdjustedBalanceAsPerBankStatement() {
		return BankRecon_BankReconciliation_AdjustedBalanceAsPerBankStatement;
	}
	
	// Adjusted Balance as per Book
	@FindBy(xpath = "//b[text()='Adjusted Balance as per Book']/../../../descendant::ion-label[2]")
	private WebElement BankRecon_BankReconciliation_AdjustedBalanceAsPerBook;
	
	public WebElement BankRecon_BankReconciliation_AdjustedBalanceAsPerBook() {
		return BankRecon_BankReconciliation_AdjustedBalanceAsPerBook;
	}
	
	// Add: Receipt recorded in Book but missing in Bank Statement
	@FindBy(xpath = "//ion-label[text()='Add: Receipt recorded in Book but missing in Bank Statement']/../../descendant::ion-label[2]")
	private WebElement BankRecon_BankReconciliation_ReceiptAmountRecordedInBook;
	
	public WebElement BankRecon_BankReconciliation_ReceiptAmountRecordedInBook() {
		return BankRecon_BankReconciliation_ReceiptAmountRecordedInBook;
	}
	
	// Add: Receipt recorded in Bank Statement but missing in Book
	@FindBy(xpath = "//ion-label[text()='Add: Receipts recorded in bank statement but missing in Book']/../../descendant::ion-label[2]")
	private WebElement BankRecon_BankReconciliation_ReceiptAmountRecordedInBankStatement;
	
	public WebElement BankRecon_BankReconciliation_ReceiptAmountRecordedInBankStatement() {
		return BankRecon_BankReconciliation_ReceiptAmountRecordedInBankStatement;
	}
	
	// Less: Payment recorded in Book but missing in Bank Statement
	@FindBy(xpath = "//ion-label[text()='Less: Payment recorded in Book but missing in Bank Statement ']/../../descendant::ion-label[2]")
	private WebElement BankRecon_BankReconciliation_PaymentAmountRecordedInBook;
	
	public WebElement BankRecon_BankReconciliation_PaymentAmountRecordedInBook() {
		return BankRecon_BankReconciliation_PaymentAmountRecordedInBook;
	}
	
	// Less: Payment recorded in Bank Statement but missing in Book
	@FindBy(xpath = "//ion-label[text()='Less: Payment recorded in Book but missing in Bank Statement ']/../../descendant::ion-label[2]")
	private WebElement BankRecon_BankReconciliation_PaymentAmountRecordedInBankStatement;
	
	public WebElement BankRecon_BankReconciliation_PaymentAmountRecordedInBankStatement() {
		return BankRecon_BankReconciliation_PaymentAmountRecordedInBankStatement;
	}
	
	// Balance as per Bank Statement
	@FindBy(xpath = "//b[text()='Balance as per Bank Statement']/../../../descendant::ion-label[2]")
	private WebElement BankRecon_BankReconciliation_BalanceAsPerBankStatement;
	
	public WebElement BankRecon_BankReconciliation_BalanceAsPerBankStatement() {
		return BankRecon_BankReconciliation_BalanceAsPerBankStatement;
	}
	
	// Balance as per Book
	@FindBy(xpath = "//b[text()='Balance as per Book']/../../../descendant::ion-label[2]")
	private WebElement BankRecon_BankReconciliation_BalanceAsPerBook;
	
	public WebElement BankRecon_BankReconciliation_BalanceAsPerBook() {
		return BankRecon_BankReconciliation_BalanceAsPerBook;
	}
}
