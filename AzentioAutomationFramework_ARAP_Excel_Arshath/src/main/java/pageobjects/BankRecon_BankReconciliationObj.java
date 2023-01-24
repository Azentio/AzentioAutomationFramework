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
	
	@FindBy(xpath = "//owl-date-time-container[1]/div[2]/owl-date-time-calendar[1]/div[1]/button[1]/span[1]")
	private WebElement ARAP_NextMonth;

	public WebElement NextMonth() {

		return ARAP_NextMonth;
	}
	
	//Save button
	@FindBy(xpath = "//page-bank-recon-details-update[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1]")
	private WebElement BankRecon_BankReconciliation_SaveButton;
	
	public WebElement BankRecon_BankReconciliation_SaveButton() {
		return BankRecon_BankReconciliation_SaveButton;
	}
	
	//Process button
	@FindBy(xpath = "//page-bank-recon-details-update[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[2]")
	private WebElement BankRecon_BankReconciliation_ProcessButton;
	
	public WebElement BankRecon_BankReconciliation_ProcessButton() {
		return BankRecon_BankReconciliation_ProcessButton;
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
	
	//Unmatched data tab
	@FindBy(xpath = "//span[3]/ion-tab-button/ion-label")
	private WebElement BankRecon_BankReconciliation_UnmatchedDataTab;
	
	public WebElement BankRecon_BankReconciliation_UnmatchedDataTab() {
		return BankRecon_BankReconciliation_UnmatchedDataTab;
	}
	
	//Unmatched data Match button
	@FindBy(xpath = "//page-book-recon-data-match-update[1]/div/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1]")
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
	@FindBy(xpath = "//page-bank-recon-data-match-update[1]/div/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1]")
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
	private WebElement BankRecon_BankReconciliation_StatusSearchFromBook;
	
	public WebElement BankRecon_BankReconciliation_StatusSearchFromBook() {
		return BankRecon_BankReconciliation_StatusSearchFromBook;
	}
	
	//Search for records from bank
	@FindBy(xpath = "//ion-grid[2]/ion-row/ion-col/ion-item/ion-buttons/ion-button")
	private WebElement BankRecon_BankReconciliation_RecordsFromBankSearch;
	
	public WebElement BankRecon_BankReconciliation_RecordsFromBankSearch() {
		return BankRecon_BankReconciliation_RecordsFromBankSearch;
	}


	//records from book count in unmatched tab
	@FindBy(xpath = "//ion-grid[1]/ngx-datatable[1]/div[1]/datatable-footer[1]/div[1]/div[1]")
	private WebElement BankRecon_BankReconciliation_RecordCountFromBook;
	
	public WebElement BankRecon_BankReconciliation_RecordCountFromBook() {
		return BankRecon_BankReconciliation_RecordCountFromBook;
	}
	
	
	//records from bank count in unmatched tab
	@FindBy(xpath = "//ion-grid[2]/ngx-datatable[1]/div[1]/datatable-footer[1]/div[1]/div[1]")
	private WebElement BankRecon_BankReconciliation_RecordCountFromBank;
	
	public WebElement BankRecon_BankReconciliation_RecordCountFromBank() {
		return BankRecon_BankReconciliation_RecordCountFromBank;
	}
}
