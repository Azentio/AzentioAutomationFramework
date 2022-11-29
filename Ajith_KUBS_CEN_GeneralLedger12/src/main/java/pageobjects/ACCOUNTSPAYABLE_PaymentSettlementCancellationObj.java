package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ACCOUNTSPAYABLE_PaymentSettlementCancellationObj {
	WebDriver driver;

	public ACCOUNTSPAYABLE_PaymentSettlementCancellationObj(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//	Payment Settlement Cancellation SUBMODULE  //
	
	//eye button of PaymentSettlementCancellation
	@FindBy(xpath = "//div[3]//ion-menu-toggle[6]//ion-item//ion-buttons//ion-button[2]")
	private WebElement accountPayable_PaymentSettlementCancellation_EyeButton;

	public WebElement accountPayable_PaymentSettlementCancellation_EyeButton() {
		return accountPayable_PaymentSettlementCancellation_EyeButton;
	}
	
	// add button PaymentSettlementCancellation
	@FindBy(xpath = "//ion-fab-button[@id='addBtn']")
	private WebElement accountPayable_PaymentSettlementCancellation_AddButton;

	public WebElement accountPayable_PaymentSettlementCancellation_AddButton() {
		return accountPayable_PaymentSettlementCancellation_AddButton;
	}
	
	// Entity Branch
	@FindBy(xpath = "//ion-col[1]/app-kub-lov/span/ng-select/div/div/div[3]/input")
	private WebElement accountPayable_PaymentSettlementCancellation_EntityBranch;
	
	public WebElement accountPayable_PaymentSettlementCancellation_EntityBranch() {
		return accountPayable_PaymentSettlementCancellation_EntityBranch;
	}
	
	// Payment Txn Number
	@FindBy(xpath = "//ion-col[2]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement accountPayable_PaymentSettlementCancellation_PaymentTxnNumber;
	
	public WebElement accountPayable_PaymentSettlementCancellation_PaymentTxnNumber() {
		return accountPayable_PaymentSettlementCancellation_PaymentTxnNumber;
	}
	
	// Value Date Calendar
	@FindBy(xpath = "//ion-col[5]/app-kub-date-time/ion-item/div/span[1]")
	private WebElement accountPayable_PaymentSettlementCancellation_ValueDateCalendar;
	
	public WebElement accountPayable_PaymentSettlementCancellation_ValueDateCalendar() {
		return accountPayable_PaymentSettlementCancellation_ValueDateCalendar;
	}
	
	// Cancellation Reason Code
	@FindBy(xpath = "//ion-col[7]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement accountPayable_PaymentSettlementCancellation_CancellationReasonCode;

	public WebElement accountPayable_PaymentSettlementCancellation_CancellationReasonCode() {
		return accountPayable_PaymentSettlementCancellation_CancellationReasonCode;
	}
	
	// Cancellation Remark
	@FindBy(xpath = "//ion-col[8]//ion-item/ion-input/input")
	private WebElement accountPayable_PaymentSettlementCancellation_CancellationRemark;
	
	public WebElement accountPayable_PaymentSettlementCancellation_CancellationRemark() {
		return accountPayable_PaymentSettlementCancellation_CancellationRemark;
	}
	
	
	
	// footer
	@FindBy(xpath = "(//datatable-footer)[2]")
	private WebElement accountPayable_PaymentSettlementCancellation_Footer;
	
	public WebElement accountPayable_PaymentSettlementCancellation_Footer() {
		return accountPayable_PaymentSettlementCancellation_Footer;
	}
	
	// Remarks
	@FindBy(xpath = "//ion-textarea/div/textarea")
	private WebElement accountPayable_PaymentSettlementCancellation_Remark;
	
	public WebElement accountPayable_PaymentSettlementCancellation_Remark() {
		return accountPayable_PaymentSettlementCancellation_Remark;
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
	
	// payout aprroved payment txn number dropdown
	@FindBy(xpath = "//ng-dropdown-panel/div/div[2]/div")
	private WebElement accountPayable_ManualPayout_PaymentTxnNumberDropdown;
	
	public WebElement accountPayable_ManualPayout_PaymentTxnNumberDropdown() {
		return accountPayable_ManualPayout_PaymentTxnNumberDropdown;
	}
	
	

}
