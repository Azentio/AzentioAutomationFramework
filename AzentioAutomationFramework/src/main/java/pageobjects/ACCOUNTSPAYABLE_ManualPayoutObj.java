package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ACCOUNTSPAYABLE_ManualPayoutObj {
	WebDriver driver;

	public ACCOUNTSPAYABLE_ManualPayoutObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/222']")
	private WebElement accountsPayable_ManualPayoutViewButton;

	public WebElement accountsPayable_ManualPayoutViewButton() {
		return accountsPayable_ManualPayoutViewButton;
	}

	@FindBy(xpath = "//input[@placeholder='Search Payout Status']")
	private WebElement accountsPayable_PayoutStatus;

	public WebElement accountsPayablePayoutStatus() {
		return accountsPayable_PayoutStatus;
	}

	@FindBy(xpath = "//app-data-grid[1]//datatable-row-wrapper[1]//datatable-body-cell[8]//span")
	private WebElement approved_PayoutReferenceNumber;

	public WebElement approvedManualPayoutReferenceNumber() {
		return approved_PayoutReferenceNumber;
	}

	@FindBy(xpath = "//input[@placeholder='Search Payout Number']")
	private WebElement accountsPayable_SearchApprovedPayoutNumber;

	public WebElement accountsPayableSearchApprovvedPayoutNumber() {
		return accountsPayable_SearchApprovedPayoutNumber;
	}

	@FindBy(xpath = "//app-data-grid[1]//datatable-row-wrapper[1]//datatable-body-cell[3]//span")
	private WebElement accountsPayable_ApprovedBpName;

	public WebElement accountsPayableApprovedBpName() {
		return accountsPayable_ApprovedBpName;
	}

	@FindBy(xpath = "//app-data-grid[1]//datatable-row-wrapper[1]//datatable-body-cell[1]//ion-button[1]")
	private WebElement accountsPayable_PayoutRecord;

	public WebElement accountsPayablePayoutRecord() {
		return accountsPayable_PayoutRecord;
	}

	@FindBy(xpath = "//page-manual-payout-processing-update//datatable-row-wrapper[1]//datatable-body-cell[4]//span")
	private WebElement accountsPayable_GetAdvanceReferenceNumber;

	public WebElement accountsPayableGetAdvanceReferenceNumber() {
		return accountsPayable_GetAdvanceReferenceNumber;
	}

	@FindBy(xpath = "//input[@placeholder='Search Payment Mode']")
	private WebElement accountsPayable_ManualPayoutSearchPaymentMode;

	public WebElement accountsPayableManualPayoutSearchPaymentMode() {
		return accountsPayable_ManualPayoutSearchPaymentMode;
	}

	@FindBy(xpath = "//app-data-grid[1]//datatable-row-wrapper[1]//datatable-body-cell[7]//span")
	private WebElement accountsPayable_ManualPayoutPayoutDate;

	public WebElement accountsPayableManualPayoutPayoutDate() {
		return accountsPayable_ManualPayoutPayoutDate;
	}

	@FindBy(xpath = "//app-data-grid[1]//datatable-row-wrapper[1]//datatable-body-cell[2]//span[1]")
	private WebElement accountsPayable_ManualPayotBranchName;

	public WebElement accountsPayableManualPayoutBranchName() {
		return accountsPayable_ManualPayotBranchName;
	}
	
//	Manual Payout SUBMODULE  //
	
	//eye button of Manual payout
	@FindBy(xpath = "//div[3]//ion-menu-toggle[8]//ion-item//ion-buttons//ion-button[2]")
	private WebElement accountPayable_ManualPayout_EyeButton;

	public WebElement accountPayable_ManualPayout_EyeButton() {
		return accountPayable_ManualPayout_EyeButton;
	}
	
	// add button Manual payout
	@FindBy(xpath = "//ion-fab-button[@id='addBtn']")
	private WebElement accountPayable_ManualPayout_AddButton;

	public WebElement accountPayable_ManualPayout_AddButton() {
		return accountPayable_ManualPayout_AddButton;
	}
	
	// Entity Branch
	@FindBy(xpath = "//ion-col[3]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement accountPayable_ManualPayout_EntityBranch;
	
	public WebElement accountPayable_ManualPayout_EntityBranch() {
		return accountPayable_ManualPayout_EntityBranch;
	}
	
	// BP_Name
	@FindBy(xpath = "//ion-col[4]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement accountPayable_ManualPayout_BP_Name;
	
	public WebElement accountPayable_ManualPayout_BP_Name() {
		return accountPayable_ManualPayout_BP_Name;
	}
	
	// Beneficiary Name
	@FindBy(xpath = "//ion-col[5]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement accountPayable_ManualPayout_BeneficiaryName;
	
	public WebElement accountPayable_ManualPayout_BeneficiaryName() {
		return accountPayable_ManualPayout_BeneficiaryName;
	}
	
	// Currency
	@FindBy(xpath = "//ion-col[11]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement accountPayable_ManualPayout_Currency;

	public WebElement accountPayable_ManualPayout_Currency() {
		return accountPayable_ManualPayout_Currency;
	}
	
	// Payment Bank
	@FindBy(xpath = "//ion-col[14]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement accountPayable_ManualPayout_PaymentBank;
	
	public WebElement accountPayable_ManualPayout_PaymentBank() {
		return accountPayable_ManualPayout_PaymentBank;
	}
	
	// Bank Account Number
	@FindBy(xpath = "//ion-col[15]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement accountPayable_ManualPayout_BankAccountNumber;
	
	public WebElement accountPayable_ManualPayout_BankAccountNumber() {
		return accountPayable_ManualPayout_BankAccountNumber;
	}
	
	// Payment Mode
	@FindBy(xpath = "//ion-col[18]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement accountPayable_ManualPayout_PaymentMode;
	
	public WebElement accountPayable_ManualPayout_PaymentMode() {
		return accountPayable_ManualPayout_PaymentMode;
	}
	
	// Select 3rd payment approval txn number
//	@FindBy(xpath = "//datatable-row-wrapper[3]/datatable-body-row/div[2]/datatable-body-cell/div/ion-checkbox")
	@FindBy(xpath = "//div[contains(text(),'PAN-25')]/../../datatable-body-cell/div/ion-checkbox")
	private WebElement accountPayable_ManualPayout_SelectPaymentTxnNumber;
	
	public WebElement accountPayable_ManualPayout_SelectPaymentTxnNumber() {
		return accountPayable_ManualPayout_SelectPaymentTxnNumber;
	}
	
	// Reference number
	@FindBy(xpath = "//ion-col[17]/ion-item/ion-input/input")
	private WebElement accountPayable_ManualPayout_ReferenceNumber;
	
	public WebElement accountPayable_ManualPayout_ReferenceNumber() {
		return accountPayable_ManualPayout_ReferenceNumber;
	}
	
	// Cheque number
	@FindBy(xpath = "//ion-col[20]/ion-item/ion-input/input")
	private WebElement accountPayable_ManualPayout_ChequeNumber;
	
	public WebElement accountPayable_ManualPayout_ChequeNumber() {
		return accountPayable_ManualPayout_ChequeNumber;
	}
	
	// footer
	@FindBy(xpath = "(//datatable-footer)[2]")
	private WebElement accountPayable_ManualPayout_Footer;
	
	public WebElement accountPayable_ManualPayout_Footer() {
		return accountPayable_ManualPayout_Footer;
	}
	
	// Remarks
	@FindBy(xpath = "//ion-textarea/div/textarea")
	private WebElement accountPayable_ManualPayout_Remark;
	
	public WebElement accountPayable_ManualPayout_Remark() {
		return accountPayable_ManualPayout_Remark;
	}
	
	// Save button
	@FindBy(xpath = "(//ion-buttons[2]/ion-button[1])[2]")
	private WebElement accountPayable_ManualPayout_SaveButton;
	
	public WebElement accountPayable_ManualPayout_SaveButton() {
		return accountPayable_ManualPayout_SaveButton;
	}
	
	
	// Submit by maker remarks
	@FindBy(xpath = "//ion-row[1]/ion-col/ion-item/ion-textarea/div/textarea")
	private WebElement accountPayable_ManualPayout_RemarksByMaker;
	
	public WebElement accountPayable_ManualPayout_RemarksByMaker() {
		return accountPayable_ManualPayout_RemarksByMaker;
	}
	
//	----------------------------------------------------------------------------------------------
//	//reviewer remark
//	@FindBy(xpath = "//ion-row[1]/ion-col/ion-item/ion-textarea/div/textarea")
//	private WebElement accountPayable_InvoiceBooking_ApprovedByReviewerRemark;
//	
//	public WebElement accountPayable_InvoiceBooking_ApprovedByReviewerRemark() {
//		return accountPayable_InvoiceBooking_ApprovedByReviewerRemark;
//	}
	
	// Search icon
	@FindBy(xpath = "(//ion-buttons/ion-item/ion-icon)[2]")
	private WebElement accountPayable_ManualPayout_Search;

	public WebElement accountPayable_ManualPayout_Search() {
		return accountPayable_ManualPayout_Search;
	}

	// Record Search using Business Partner
	@FindBy(xpath = "//datatable-header-cell[3]/div/ion-input/input")
	private WebElement accountPayable_ManualPayout_BusinessPartnerSearch;

	public WebElement accountPayable_ManualPayout_BusinessPartnerSearch() {
		return accountPayable_ManualPayout_BusinessPartnerSearch;
	}

	// payout Status
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[9]/div[1]/span")
	private WebElement accountPayable_ManualPayout_PayoutStatus;

	public WebElement accountPayable_ManualPayout_PayoutStatus() {
		return accountPayable_ManualPayout_PayoutStatus;
	}
	
	// click on next button
	@FindBy(xpath = "(//li[@class='']/a/i)[1]")
	private WebElement accountPayable_ManualPayout_ClickOnNextButton;

	public WebElement accountPayable_ManualPayout_ClickOnNextButton() {
		return accountPayable_ManualPayout_ClickOnNextButton;
	}
}
