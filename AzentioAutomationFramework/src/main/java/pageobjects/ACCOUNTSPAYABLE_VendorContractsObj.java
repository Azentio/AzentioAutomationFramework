package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ACCOUNTSPAYABLE_VendorContractsObj {
	WebDriver driver;

	public ACCOUNTSPAYABLE_VendorContractsObj(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	VENDOR CONTRACTS SUBMODULE  //
	//Direction button
	@FindBy(xpath = "//ion-segment/ion-segment-button[2]")
	private WebElement  accountPayable_VendorContracts_DirectionButton;
	
	public WebElement accountPayable_VendorContracts_DirectionButton() {
		return accountPayable_VendorContracts_DirectionButton;
	}
	
	//Account Payable Menu
	@FindBy(xpath = "//ion-label[text()=' Accounts payable ']")
	private WebElement  accountPayableMenu;
	
	public WebElement accountPayableMenu() {
		return accountPayableMenu;
	}
		
	//eye button of vendor contracts
	@FindBy(xpath = "//div[3]//ion-menu-toggle[1]//ion-item//ion-buttons//ion-button[2]")
	private WebElement  accountPayable_VendorContracts_EyeButton;

	public WebElement accountPayable_VendorContracts_EyeButton() {
		return accountPayable_VendorContracts_EyeButton;
	}
	
	//add button
	@FindBy(xpath = "//ion-fab-button[@id='addBtn']")
	private WebElement  accountPayable_VendorContracts_AddButton;
	
	public WebElement accountPayable_VendorContracts_AddButton() {
		return accountPayable_VendorContracts_AddButton;
	}
	
	//Expense Type
	@FindBy(xpath = "//ion-grid[1]/fieldset/ion-row/ion-col[3]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement  accountPayable_VendorContracts_ExpenseType;
	
	public WebElement accountPayable_VendorContracts_ExpenseType() {
		return accountPayable_VendorContracts_ExpenseType;
	}
	
	//BP name
	@FindBy(xpath = "//ion-grid[1]/fieldset/ion-row/ion-col[4]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement  accountPayable_VendorContracts_BP_Name;
	
	public WebElement accountPayable_VendorContracts_BP_Name() {
		return accountPayable_VendorContracts_BP_Name;
	}
	
	//BP Branch
	@FindBy(xpath = "//ion-grid[1]/fieldset/ion-row/ion-col[5]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement  accountPayable_VendorContracts_BP_Branch;
	
	public WebElement accountPayable_VendorContracts_BP_Branch() {
		return accountPayable_VendorContracts_BP_Branch;
	}
	
	
	//Contract Name
	@FindBy(xpath = "//ion-grid[1]/fieldset/ion-row/ion-col[7]/ion-item/ion-input/input")
	private WebElement  accountPayable_VendorContracts_ContractName;
	
	public WebElement accountPayable_VendorContracts_ContractName() {
		return accountPayable_VendorContracts_ContractName;
	}
	
	//Agreement Calendar
	@FindBy(xpath = "//ion-col[10]/app-kub-date-time/ion-item/div/span[1]")
	//@FindBy(xpath = "(//span[@class='input-calendar'])[2]")
	private WebElement  accountPayable_VendorContracts_AgreementCalendar;
	
	public WebElement accountPayable_VendorContracts_AgreementCalendar() {
		return accountPayable_VendorContracts_AgreementCalendar;
	}
	
	//Calendar Date
	@FindBy(xpath = "//div/div/button")
	private WebElement  accountPayable_VendorContracts_SelectDate;
	
	public WebElement accountPayable_VendorContracts_SelectDate() {
		return accountPayable_VendorContracts_SelectDate;
	}
	
	//Click on next year 
	@FindBy(xpath = "//owl-date-time-multi-year-view/button[2]")
	private WebElement  accountPayable_VendorContracts_ClickOnNextYear;
	
	public WebElement accountPayable_VendorContracts_ClickOnNextYear() {
		return accountPayable_VendorContracts_ClickOnNextYear;
	}
	
	//Click on next month 
	@FindBy(xpath = "//owl-date-time-calendar/div/button[2]")
	private WebElement  accountPayable_VendorContracts_ClickOnNextMonth;
	
	public WebElement accountPayable_VendorContracts_ClickOnNextMonth() {
		return accountPayable_VendorContracts_ClickOnNextMonth;
	}
	
	//Click on Agreement year 
	@FindBy(xpath = "//td/span[contains(text(),'2022')]")
	private WebElement  accountPayable_VendorContracts_AgreementYear;
	
	public WebElement accountPayable_VendorContracts_AgreementYear() {
		return accountPayable_VendorContracts_AgreementYear;
	}
	
	//Contract End Date
	@FindBy(xpath = "//ion-col[11]/app-kub-date-time/ion-item/div/span[1]")
	private WebElement  accountPayable_VendorContracts_ContractEndDate;
	
	public WebElement accountPayable_VendorContracts_ContractEndDate() {
		return accountPayable_VendorContracts_ContractEndDate;
	}
	
	//Contract Signed On Date
	@FindBy(xpath = "//ion-col[12]/app-kub-date-time/ion-item/div/span[1]")
	private WebElement  accountPayable_VendorContracts_ContractSignedOnDate;
	
	public WebElement accountPayable_VendorContracts_ContractSignedOnDate() {
		return accountPayable_VendorContracts_ContractSignedOnDate;
	}
	
	//Currency
	@FindBy(xpath = "(//div[@role='combobox'])[5]//input")
	private WebElement  accountPayable_VendorContracts_Currency;
	
	public WebElement accountPayable_VendorContracts_Currency() {
		return accountPayable_VendorContracts_Currency;
	}
	
	//Remarks
	@FindBy(xpath = "//ion-grid[1]/fieldset/ion-row/ion-col[17]/ion-item/ion-input/input")
	private WebElement  accountPayable_VendorContracts_Remark;
	
	public WebElement accountPayable_VendorContracts_Remark() {
		return accountPayable_VendorContracts_Remark;
	}
	
	//Other Details Button
	@FindBy(xpath = "//ion-grid[2]/fieldset/legend/ion-button")
	private WebElement  accountPayable_VendorContracts_OtherDetailsButton;
	
	public WebElement accountPayable_VendorContracts_OtherDetailsButton() {
		return accountPayable_VendorContracts_OtherDetailsButton;
	}
	
	//Auto Generate Invoice
	@FindBy(xpath = "//ion-grid[2]/fieldset/ion-row/ion-col[3]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement  accountPayable_VendorContracts_AutoGenerateInvoice;
	
	public WebElement accountPayable_VendorContracts_AutoGenerateInvoice() {
		return accountPayable_VendorContracts_AutoGenerateInvoice;
	}
	
	//Credit Period
	@FindBy(xpath = "//ion-grid[2]/fieldset/ion-row/ion-col[4]/ion-item/ion-input/input")
	private WebElement  accountPayable_VendorContracts_CreditPeriod;
	
	public WebElement accountPayable_VendorContracts_CreditPeriod() {
		return accountPayable_VendorContracts_CreditPeriod;
	}
	
	//LatePaymentFee
	@FindBy(xpath = "//ion-grid[2]/fieldset/ion-row/ion-col[5]/ion-item/input")
	private WebElement  accountPayable_VendorContracts_LatePaymentFee;
	
	public WebElement accountPayable_VendorContracts_LatePaymentFee() {
		return accountPayable_VendorContracts_LatePaymentFee;
	}
	
	//CurrencyInOtherDetails
	@FindBy(xpath = "//ion-grid[2]/fieldset/ion-row/ion-col[6]/app-kub-lov/span/ng-select/div/div/div[3]/input")
	private WebElement  accountPayable_VendorContracts_Currency2;
	
	public WebElement accountPayable_VendorContracts_Currency2() {
		return accountPayable_VendorContracts_Currency2;
	}
	
	//Upload File
	@FindBy(xpath = "//ion-grid[2]/fieldset/ion-row/ion-col[7]/ion-item/ion-input/input")
	private WebElement  accountPayable_VendorContracts_UploadFile;
	
	public WebElement accountPayable_VendorContracts_UploadFile() {
		return accountPayable_VendorContracts_UploadFile;
	}
	
	//Download File
	@FindBy(xpath = "//ion-grid[2]/fieldset/ion-row/ion-col[8]/ion-item/ion-button")
	private WebElement  accountPayable_VendorContracts_Download;
	
	public WebElement accountPayable_VendorContracts_Download() {
		return accountPayable_VendorContracts_Download;
	}
	
	//Additional Details Button
	@FindBy(xpath = "//ion-grid[3]/fieldset/legend/ion-button")
	private WebElement  accountPayable_VendorContracts_AdditionalDetailsButton;
	
	public WebElement accountPayable_VendorContracts_AdditionalDetailsButton() {
		return accountPayable_VendorContracts_AdditionalDetailsButton;
	}
	
	//PO_Delivery Date
	@FindBy(xpath = "//ion-grid[3]/fieldset/ion-row/ion-col[1]/app-kub-date-time/ion-item/div/span/ion-icon")
	private WebElement  accountPayable_VendorContracts_PO_DeliveryDate;
	
	public WebElement accountPayable_VendorContracts_PO_DeliveryDate() {
		return accountPayable_VendorContracts_PO_DeliveryDate;
	}
	
	//Taxes
	@FindBy(xpath = "//ion-grid[3]/fieldset/ion-row/ion-col[2]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement  accountPayable_VendorContracts_Taxes;
	
	public WebElement accountPayable_VendorContracts_Taxes() {
		return accountPayable_VendorContracts_Taxes;
	}
	
	//Warranty
	@FindBy(xpath = "//ion-grid[3]/fieldset/ion-row/ion-col[3]/ion-item/ion-input/input")
	private WebElement  accountPayable_VendorContracts_Warranty;
	
	public WebElement accountPayable_VendorContracts_Warranty() {
		return accountPayable_VendorContracts_Warranty;
	}
	
	//Payment Term
	@FindBy(xpath = "//ion-grid[3]/ion-row/ion-col[4]/ion-item/ion-input/input")
	private WebElement  accountPayable_VendorContracts_PaymentTerm;
	
	public WebElement accountPayable_VendorContracts_PaymentTerm() {
		return accountPayable_VendorContracts_PaymentTerm;
	}
	
	//Dispatch
	@FindBy(xpath = "//ion-grid[3]/fieldset/ion-row/ion-col[5]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement  accountPayable_VendorContracts_Dispatch;
	
	public WebElement accountPayable_VendorContracts_Dispatch() {
		return accountPayable_VendorContracts_Dispatch;
	}
	
	//Insurance
	@FindBy(xpath = "//ion-grid[3]/fieldset/ion-row/ion-col[6]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement  accountPayable_VendorContracts_Insurance;
	
	public WebElement accountPayable_VendorContracts_Insurance() {
		return accountPayable_VendorContracts_Insurance;
	}
	
	//Special Note
	@FindBy(xpath = "//ion-grid[3]/fieldset/ion-row/ion-col[7]/ion-item/ion-input/input")
	private WebElement  accountPayable_VendorContracts_SpecialNote;
	
	public WebElement accountPayable_VendorContracts_SpecialNote() {
		return accountPayable_VendorContracts_SpecialNote;
	}
	
	//Terms And Conditions
	@FindBy(xpath = "//ion-grid[3]/fieldset/ion-row/ion-col[8]/ion-item/ion-input/input")
	private WebElement  accountPayable_VendorContracts_TermsAndContitions;
	
	public WebElement accountPayable_VendorContracts_TermsAndContitions() {
		return accountPayable_VendorContracts_TermsAndContitions;
	}
	
	//Remarks in Additional Details
	@FindBy(xpath = "//ion-grid[3]/fieldset/ion-row/ion-col[9]/ion-item/ion-input/input")
	private WebElement  accountPayable_VendorContracts_Remark2;
	
	public WebElement accountPayable_VendorContracts_Remark2() {
		return accountPayable_VendorContracts_Remark2;
	}
	
	//Save Button
//	@FindBy(xpath = "//page-contract-creation-update/ion-header/ion-toolbar/ion-buttons[2]/ion-button")
	@FindBy(xpath = "(//ion-buttons[2]/ion-button[1])[2]")
	private WebElement  accountPayable_VendorContracts_SaveButton;
	
	public WebElement accountPayable_VendorContracts_SaveButton() {
		return accountPayable_VendorContracts_SaveButton;
	}
	
	//item details Save Button
	@FindBy(xpath = "//ion-toolbar/ion-buttons[1]/ion-button")
	private WebElement  accountPayable_VendorContracts_ItemDetailsSaveButton;
	
	public WebElement accountPayable_VendorContracts_ItemDetailsSaveButton() {
		return accountPayable_VendorContracts_ItemDetailsSaveButton;
	}
	
	//Benificiary details Save Button
	@FindBy(xpath = "(//ion-toolbar/ion-buttons[1]/ion-button)[2]")
	private WebElement  accountPayable_VendorContracts_BenificiaryDetailsSaveButton;
	
	public WebElement accountPayable_VendorContracts_BenificiaryDetailsSaveButton() {
		return accountPayable_VendorContracts_BenificiaryDetailsSaveButton;
	}
	
	//HSN code
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[3]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement  accountPayable_VendorContracts_HSN_Code;
	
	public WebElement accountPayable_VendorContracts_HSN_Code() {
		return accountPayable_VendorContracts_HSN_Code;
	}
	
	//Expense code
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[4]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement  accountPayable_VendorContracts_ExpenseCode;
	
	public WebElement accountPayable_VendorContracts_ExpenseCode() {
		return accountPayable_VendorContracts_ExpenseCode;
	}
	
	//Cost Center
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[5]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement  accountPayable_VendorContracts_CostCenter;
	
	public WebElement accountPayable_VendorContracts_CostCenter() {
		return accountPayable_VendorContracts_CostCenter;
	}
	
	//Unit
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[7]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement  accountPayable_VendorContracts_Unit;
	
	public WebElement accountPayable_VendorContracts_Unit() {
		return accountPayable_VendorContracts_Unit;
	}
	
	//Quantity
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[6]/ion-item/ion-input/input")
	private WebElement  accountPayable_VendorContracts_Quantity;
	
	public WebElement accountPayable_VendorContracts_Quantity() {
		return accountPayable_VendorContracts_Quantity;
	}
	
	//Rate per Unit
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[8]/ion-item/ion-input/input")
	private WebElement  accountPayable_VendorContracts_RatePerUnit;
	
	public WebElement accountPayable_VendorContracts_RatePerUnit() {
		return accountPayable_VendorContracts_RatePerUnit;
	}
	
	//Currency
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[10]/app-kub-lov/span/ng-select/div/div/div[3]/input")
	private WebElement  accountPayable_VendorContracts_CurrencyInItemDetail;
	
	public WebElement accountPayable_VendorContracts_CurrencyInItemDetail() {
		return accountPayable_VendorContracts_CurrencyInItemDetail;
	}
	
	//Payment Terms details
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[2]/ion-item/ion-input/input")
	private WebElement  accountPayable_VendorContracts_PaymentTermDetails;
	
	public WebElement accountPayable_VendorContracts_PaymentTermDetails() {
		return accountPayable_VendorContracts_PaymentTermDetails;
	}
	
	//Payment Term percentage
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[3]/ion-item/ion-input/input")
	private WebElement  accountPayable_VendorContracts_PaymentTermPercent;
	
	public WebElement accountPayable_VendorContracts_PaymentTermPercent() {
		return accountPayable_VendorContracts_PaymentTermPercent;
	}
	
	//Payment term Type
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[4]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement  accountPayable_VendorContracts_PaymentTermType;
	
	public WebElement accountPayable_VendorContracts_PaymentTermType() {
		return accountPayable_VendorContracts_PaymentTermType;
	}
	
	//Benificiary Details mode of payment
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[2]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement  accountPayable_VendorContracts_ModeOfPayment;
	
	public WebElement accountPayable_VendorContracts_ModeOfPayment() {
		return accountPayable_VendorContracts_ModeOfPayment;
	}
	
	//Auto Payout
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[6]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement  accountPayable_VendorContracts_AutoPayout;
	
	public WebElement accountPayable_VendorContracts_AutoPayout() {
		return accountPayable_VendorContracts_AutoPayout;
	}
	
	//Notification Button
	@FindBy(xpath = "//ion-buttons[2]/ion-button[2]")
	private WebElement  accountPayable_VendorContracts_NotificationButton;
	
	public WebElement accountPayable_VendorContracts_NotificationButton() {
		return accountPayable_VendorContracts_NotificationButton;
	}
	
	//Contract creation tab
	@FindBy(xpath = "//ion-label[contains(text(),' Contract Creation ')]")
	private WebElement  accountPayable_VendorContracts_ContractCreationTab;
	
	public WebElement accountPayable_VendorContracts_ContractCreationTab() {
		return accountPayable_VendorContracts_ContractCreationTab;
	}
	
	//FirstReferenceID
	@FindBy(xpath = "//app-inbox//datatable-row-wrapper[1]//datatable-body-row//div[2]//datatable-body-cell[2]//div//span")
	private WebElement accountPayable_VendorContracts_FirstReferenceId;

	public WebElement accountPayable_VendorContracts_FirstReferenceId() {
		return accountPayable_VendorContracts_FirstReferenceId;
	}
	
	//Maker Notification NextButton
	@FindBy(xpath = "//datatable-pager[1]/ul[1]/li[8]/a[1]/i[1]")
	private WebElement accountPayable_VendorContracts_NotificationNextButton;

	public WebElement accountPayable_VendorContracts_NotificationNextButton() {
		return accountPayable_VendorContracts_NotificationNextButton;
	}

	// Submit
	@FindBy(xpath = "//span[contains(text(),'Submit')]")
	private WebElement accountPayable_VendorContracts_SubmitButton;

	public WebElement accountPayable_VendorContracts_SubmitButton() {
		return accountPayable_VendorContracts_SubmitButton;
	}

	// Remark field
	@FindBy(xpath = "//ion-textarea/div/textarea[@name='remarks']")
	private WebElement accountPayable_VendorContracts_RemarkField;

	public WebElement accountPayable_VendorContracts_RemarkField() {
		return accountPayable_VendorContracts_RemarkField;
	}

	// Submit by maker
	@FindBy(xpath = "//ion-row/ion-col/ion-button")
	private WebElement accountPayable_VendorContracts_Submit;

	public WebElement accountPayable_VendorContracts_Submit() {
		return accountPayable_VendorContracts_Submit;
	}
	
	//record status
	@FindBy(xpath = "//body/div/div/div/div[1]")
	private WebElement accountPayable_VendorContracts_RecordStatus;

	public WebElement accountPayable_VendorContracts_RecordStatus() {
		return accountPayable_VendorContracts_RecordStatus;
	}
	
	//reject button
	@FindBy(xpath = "//span/ion-button[3]")
	private WebElement accountPayable_VendorContracts_Reject_Button;

	public WebElement accountPayable_VendorContracts_Reject_Button() {
		return accountPayable_VendorContracts_Reject_Button;
	}

	// approve button
	@FindBy(xpath = "//span/ion-button[1]")
	private WebElement accountPayable_VendorContracts_Approve_Button;

	public WebElement accountPayable_VendorContracts_Approve_Button() {
		return accountPayable_VendorContracts_Approve_Button;

	}
	
	//approve remarks
	@FindBy(xpath = "//textarea[@name='remarks']")
	private WebElement accountPayable_VendorContracts_ApproveRemarkByReviewer;

	public WebElement accountPayable_VendorContracts_ApproveRemarkByReviewer() {
		return accountPayable_VendorContracts_ApproveRemarkByReviewer;
	}

	// return button
	@FindBy(xpath = "//span/ion-button[2]")
	private WebElement accountPayable_VendorContracts_Return_Button;

	public WebElement accountPayable_VendorContracts_Return_Button() {
		return accountPayable_VendorContracts_Return_Button;
	}
	
	// First eye button [contract Account code]
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[1]/div/ion-buttons/ion-button[1]")
	private WebElement accountPayable_VendorContracts_ContractCodeEyeButton;
	
	public WebElement accountPayable_VendorContracts_ContractCodeEyeButton() {
		return accountPayable_VendorContracts_ContractCodeEyeButton;
	}
	
	// Search icon
	@FindBy(xpath = "(//ion-buttons/ion-item/ion-icon)[2]")
	private WebElement accountPayable_VendorContracts_Search;
	
	public WebElement accountPayable_VendorContracts_Search() {
		return accountPayable_VendorContracts_Search;
	}
	
	// Record Search using Business Partner
	@FindBy(xpath = "//datatable-header-cell[6]/div/ion-input/input")
	private WebElement accountPayable_VendorContracts_BusinessPartnerSearch;
	
	public WebElement accountPayable_VendorContracts_BusinessPartnerSearch() {
		return accountPayable_VendorContracts_BusinessPartnerSearch;
	}
	
	// Contract Status
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[8]/div[1]/span")
	private WebElement accountPayable_VendorContracts_ContractStatus;
	
	public WebElement accountPayable_VendorContracts_ContractStatus() {
		return accountPayable_VendorContracts_ContractStatus;
	}
	
	// txn Status
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[9]/div[1]/span")
	private WebElement accountPayable_VendorContracts_TxnStatus;
	
	public WebElement accountPayable_VendorContracts_TxnStatus() {
		return accountPayable_VendorContracts_TxnStatus;
	}
	
	// maker profile name for logout
	@FindBy(xpath = "//ion-buttons[2]//ion-button[4]")
	private WebElement accountPayable_VendorContracts_ProfileName;

	public WebElement accountPayable_VendorContracts_ProfileName() {
		return accountPayable_VendorContracts_ProfileName;
	}

	// logout
	@FindBy(xpath = "//ion-icon[@name='log-out']")
	private WebElement  accountPayable_VendorContracts_Logout;

	public WebElement accountPayable_VendorContracts_Logout() {
		return accountPayable_VendorContracts_Logout;
	}
	
	
	
	
	
	
	
	
	
	
}
