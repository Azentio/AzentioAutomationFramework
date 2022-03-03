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
	
	

}
