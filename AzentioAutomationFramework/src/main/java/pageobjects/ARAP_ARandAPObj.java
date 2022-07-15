package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ARAP_ARandAPObj {
	WebDriver driver;

	public ARAP_ARandAPObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ion-select[@class='datagrid-lov ng-valid md hydrated ng-touched ng-dirty ion-valid ion-touched ion-dirty']")
	private WebElement ARAP_FinanceOption;

	public WebElement ARAP_FinanceOption() {

		return ARAP_FinanceOption;
	}

	@FindBy(xpath = "//ion-segment/ion-segment-button[2]")
	private WebElement ARAP_Transfericon;

	public WebElement ARAPTransfericon() {

		return ARAP_Transfericon;
	}

	@FindBy(xpath = "//div[@id='toast-container']/div/div[@role='alertdialog']")
	private WebElement ARAP_Popup;

	public WebElement ARAP_Popup() {

		return ARAP_Popup;
	}

	@FindBy(xpath = "//ion-label[contains(text(),'Accounts payable')]")
	private WebElement ARAP_Accountspayable;

	public WebElement ARAP_Accountspayable() {

		return ARAP_Accountspayable;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/133']")
	private WebElement ARAP_GRN_Eye;

	public WebElement ARAP_GRN_Eye() {

		return ARAP_GRN_Eye;
	}

	@FindBy(xpath = "//ion-icon[@ng-reflect-name='search']")
	private WebElement ARAP_Search;

	public WebElement ARAP_Search() {

		return ARAP_Search;
	}

	@FindBy(xpath = "//datatable-header[1]/div[1]/div[2]/datatable-header-cell[3]/div[1]/ion-input[1]/input[1]")
	private WebElement ARAP_GrnNo;

	public WebElement ARAP_GrnNo() {

		return ARAP_GrnNo;
	}

	@FindBy(xpath = "//datatable-header[1]/div[1]/div[2]/datatable-header-cell[6]/div[1]/ion-input[1]/input[1]")
	private WebElement ARAP_GRNStatus;

	public WebElement ARAP_GRNStatus() {

		return ARAP_GRNStatus;
	}

	@FindBy(xpath = "//datatable-header[1]/div[1]/div[2]/datatable-header-cell[13]/div[1]/ion-input[1]/input[1]")
	private WebElement ARAP_InvoiceStatus;

	public WebElement ARAP_InvoiceStatus() {

		return ARAP_InvoiceStatus;
	}

	// datatable-header[1]/div[1]/div[2]/datatable-header-cell[4]/div[1]/ion-input[1]/input[1]
	@FindBy(xpath = "//datatable-header[1]/div[1]/div[2]/datatable-header-cell[3]/div[1]/ion-input[1]/input[1]")
	private WebElement ARAP_InvoiceTypeSearch;

	public WebElement ARAP_InvoiceTypeSearch() {

		return ARAP_InvoiceTypeSearch;
	}

	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[1]//ion-button[1]")
	private WebElement ARAP_TableEye;

	public WebElement ARAP_TableEye() {

		return ARAP_TableEye;
	}

	@FindBy(xpath = "//ion-label[contains(text(),'Item Details')]")
	private WebElement ARAP_ItemDetails;

	public WebElement ARAP_ItemDetails() {

		return ARAP_ItemDetails;
	}

	@FindBy(xpath = "//ion-col[1]/app-kub-lov[1]/span/ng-select[1]/div[1]/div[1]/div[2]")
	private WebElement ARAP_GetBranch;

	public WebElement ARAP_GetBranch() {

		return ARAP_GetBranch;
	}

	@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]")
	private WebElement ARAP_GetPoNumber;

	public WebElement ARAP_GetPoNumber() {

		return ARAP_GetPoNumber;
	}

	@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]")
	private WebElement ARAP_GetBpName;

	public WebElement ARAP_GetBpName() {

		return ARAP_GetBpName;
	}

	@FindBy(xpath = "//ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]")
	private WebElement ARAP_GetcancelBpName;

	public WebElement ARAP_GetcancelBpName() {

		return ARAP_GetcancelBpName;
	}

	@FindBy(xpath = "//ion-col[4]/ion-item[1]/ion-input[1]/input[1]")
	private WebElement ARAP_GetGrnNo;

	public WebElement ARAP_GetGrnNo() {

		return ARAP_GetGrnNo;
	}

	@FindBy(xpath = "//ion-col[5]/ion-item[1]/ion-input[1]/input")
	private WebElement ARAP_GetInvoiceNo;

	public WebElement ARAP_GetInvoiceNo() {

		return ARAP_GetInvoiceNo;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/151']")
	private WebElement ARAP_InvoiceEye;

	public WebElement ARAP_InvoiceEye() {

		return ARAP_InvoiceEye;
	}

	@FindBy(xpath = "//ion-fab/ion-fab-button[@id='addBtn']")
	private WebElement ARAP_InvoiceAdd;

	public WebElement ARAP_InvoiceAdd() {

		return ARAP_InvoiceAdd;
	}

	@FindBy(xpath = "//ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement ARAP_EntityBranch;

	public WebElement ARAP_EntityBranch() {

		return ARAP_EntityBranch;
	}

	@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement ARAP_InvoiceType;

	public WebElement ARAP_InvoiceType() {

		return ARAP_InvoiceType;
	}

	@FindBy(xpath = "//ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement ARAP_InvoiceSubType;

	public WebElement ARAP_InvoiceSubType() {

		return ARAP_InvoiceSubType;
	}

	@FindBy(xpath = "//ion-col[4]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement ARAP_GiveBPname;

	public WebElement ARAP_GiveBPname() {

		return ARAP_GiveBPname;
	}

	@FindBy(xpath = "//ion-col[6]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement ARAP_GiveCostCenter;

	public WebElement ARAP_GiveCostCenter() {

		return ARAP_GiveCostCenter;
	}

	@FindBy(xpath = "//input[@name='supplierRefno']")
	private WebElement ARAP_GivesupplierRefno;

	public WebElement ARAP_GivesupplierRefno() {

		return ARAP_GivesupplierRefno;
	}

	@FindBy(xpath = "//input[@id='flatDiscount']")
	private WebElement ARAP_GiveflatDiscount;

	public WebElement ARAP_GiveflatDiscount() {

		return ARAP_GiveflatDiscount;
	}

	@FindBy(xpath = "//ion-col[15]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement ARAP_GiveModeofPayment;

	public WebElement ARAP_GiveModeofPayment() {

		return ARAP_GiveModeofPayment;
	}

	@FindBy(xpath = "//ion-router-outlet[1]/page-ap-bill-booking-update[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[2]")
	private WebElement ARAP_InvoiceSave;

	public WebElement ARAP_InvoiceSave() {

		return ARAP_InvoiceSave;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/inbox']")
	private WebElement ARAP_MakerNotification;

	public WebElement ARAP_MakerNotification() {

		return ARAP_MakerNotification;
	}

	@FindBy(xpath = "//app-inbox//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[2]//span")
	private WebElement ARAP_ReferanceId;

	public WebElement ARAP_ReferanceId() {

		return ARAP_ReferanceId;
	}

	@FindBy(xpath = "//app-inbox//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[1]//ion-button")
	private WebElement ARAP_ActionButton;

	public WebElement ARAP_ActionButton() {

		return ARAP_ActionButton;
	}

	@FindBy(xpath = "//span[contains(text(),'Submit')]")
	private WebElement ARAP_Submit;

	public WebElement ARAP_Submit() {

		return ARAP_Submit;
	}

	@FindBy(xpath = "//textarea[@name='remarks']")
	private WebElement ARAP_Remark;

	public WebElement ARAP_Remark() {

		return ARAP_Remark;
	}

	@FindBy(xpath = "//ion-button[contains(text(),'Submit')]")
	private WebElement ARAP_RemarkSubmit;

	public WebElement ARAP_RemarkSubmit() {

		return ARAP_RemarkSubmit;
	}

	@FindBy(xpath = "//div[@id='toast-container']/div/div[@role='alert']")
	private WebElement ARAP_ReviewerId;

	public WebElement ARAP_ReviewerId() {

		return ARAP_ReviewerId;
	}

	@FindBy(xpath = "//button[@aria-label='Close']")
	private WebElement ARAP_Notification_Close;

	public WebElement ARAP_Notification_Close() {

		return ARAP_Notification_Close;
	}

	@FindBy(xpath = "//ion-label[contains(text(),'AP Invoice Against PO')]")
	private WebElement ARAP_APInvoiceAgainstPO;

	public WebElement ARAP_APInvoiceAgainstPO() {

		return ARAP_APInvoiceAgainstPO;
	}

	@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement ARAP_PoNumber;

	public WebElement ARAP_PoNumber() {

		return ARAP_PoNumber;
	}

	@FindBy(xpath = "//ion-icon[@ng-reflect-name='save']")
	private WebElement ARAP_APInvoiceAgainstPO_Save;

	public WebElement ARAP_APInvoiceAgainstPO_Save() {

		return ARAP_APInvoiceAgainstPO_Save;
	}

	@FindBy(xpath = "//ion-col[3]/ion-item/ion-select")
	private WebElement InvoiceBooking_GRN_Number;

	public WebElement InvoiceBooking_GRN_Number() {
		return InvoiceBooking_GRN_Number;
	}

	// Adjustments AR/AP

	@FindBy(xpath = "//ion-label[contains(text(),'Adjustments ( AR and AP)')]")
	private WebElement adjustment_ARAP;

	public WebElement adjustment_ARAP() {
		return adjustment_ARAP;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/196']")
	private WebElement adjustment_view_button;

	public WebElement adjustmentViewButton() {
		return adjustment_view_button;
	}

	@FindBy(xpath = "//ion-row[1]/ion-col[2]//input")
	private WebElement adjustment_BpName;

	public WebElement adjustmentBpName() {
		return adjustment_BpName;
	}

	@FindBy(xpath = "//ion-col[6]//input")
	private WebElement adjustment_adjustmentType;

	public WebElement adjustmentadjustmentType() {
		return adjustment_adjustmentType;
	}

	@FindBy(xpath = "//ion-col[7]//input")
	private WebElement adjustment_itemType;

	public WebElement adjustmentItemType() {
		return adjustment_itemType;
	}

	@FindBy(xpath = "//ion-col[8]//input")
	private WebElement adjustment_adjustmentReference;

	public WebElement adjustmentAdjustmentReference() {
		return adjustment_adjustmentReference;
	}

	@FindBy(xpath = "//ng-dropdown-panel[1]/div[1]/div[2]/div[6]/span[1]")
	private WebElement adjustment_dropdownGRN;

	public WebElement adjustment_dropdownGRN() {
		return adjustment_dropdownGRN;
	}

	@FindBy(xpath = "//ion-col//input[@id='cancelledAmt']")
	private WebElement adjustment_CancellationAmt;

	public WebElement adjustment_CancellationAmt() {
		return adjustment_CancellationAmt;
	}

	@FindBy(xpath = "//div[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1]")
	private WebElement adjustment_Save;

	public WebElement adjustment_Save() {
		return adjustment_Save;
	}

	// ENQUIRES

	@FindBy(xpath = "//ion-segment-button[@ng-reflect-value='rpt']")
	private WebElement ARAP_ReportIcon;

	public WebElement ARAPReportIcon() {

		return ARAP_ReportIcon;
	}

	@FindBy(xpath = "//ion-label[contains(text(),'Enquiry')]")
	private WebElement ARAP_EnquiryMenu;

	public WebElement ARAPEnquiryMenu() {

		return ARAP_EnquiryMenu;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/entities/financial-trans']")
	private WebElement ARAP_FinancialTransactionIcon;

	public WebElement ARAPFinancialTransactionIcon() {

		return ARAP_FinancialTransactionIcon;
	}

	@FindBy(xpath = "//ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement ARAP_BranchCode;

	public WebElement ARAPBranchCode() {

		return ARAP_BranchCode;
	}

	@FindBy(xpath = "//ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement ARAP_GlCode;

	public WebElement ARAPGlCode() {

		return ARAP_GlCode;
	}

	@FindBy(xpath = "(//span[@class='input-calendar'])[1]")
	private WebElement ARAP_FromDate;

	public WebElement ARAPFromDate() {

		return ARAP_FromDate;
	}

	@FindBy(xpath = "(//span[@class='input-calendar'])[2]")
	private WebElement ARAP_ToDate;

	public WebElement ARAPToDate() {

		return ARAP_ToDate;
	}

	@FindBy(xpath = "(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]")
	private WebElement ARAP_Year;

	public WebElement ARAP_Year() {

		return ARAP_Year;
	}

	@FindBy(xpath = "//owl-date-time-container[1]/div[2]/owl-date-time-calendar[1]/div[1]/button[2]/span[1]")
	private WebElement ARAP_NextMonth;

	public WebElement ARAPNextMonth() {

		return ARAP_NextMonth;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-shape='round']")
	private WebElement ARAP_ViewButton;

	public WebElement ARAPViewButton() {

		return ARAP_ViewButton;
	}

	// ACCOUNTS PAYABLE
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/195']")
	private WebElement accountsPayable_paymentSettlementViewIcon;

	public WebElement accountsPayablePayementSettlementViewIcon() {
		return accountsPayable_paymentSettlementViewIcon;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/204']")
	private WebElement accountsPayable_paymentSettlementcancellionViewIcon;

	public WebElement accountsPayable_paymentSettlementcancellionViewIcon() {
		return accountsPayable_paymentSettlementcancellionViewIcon;
	}

	@FindBy(xpath = "//ion-col[2]//input")
	private WebElement accountsPayable_paymentSettlementPaymentOption;

	public WebElement accountsPayablePayementSettlementPaymentOption() {
		return accountsPayable_paymentSettlementPaymentOption;
	}

	@FindBy(xpath = "(//i[@class='datatable-icon-right'])[2]")
	private WebElement accountsPayable_paymentSettlementNextRecord;

	public WebElement accountsPayablePayementSettlementNextRecord() {
		return accountsPayable_paymentSettlementNextRecord;
	}

	@FindBy(xpath = "(//li[@class='disabled']/a/i)[1]")
	private WebElement accountsPayable_paymentSettlementDisabledNext;

	public WebElement accountsPayablePayementSettlementdisabledNext() {
		return accountsPayable_paymentSettlementDisabledNext;
	}
	
//	@FindBy(xpath = "(//datatable-footer[1]/div[1]/datatable-pager[1])[2]")
	@FindBy(xpath = "(//div[contains(text(),'total')])[2]")
	private WebElement accountsPayable_paymentSettlementFooter;
	
	public WebElement accountsPayable_paymentSettlementFooter() {
		return accountsPayable_paymentSettlementFooter;
	}

	@FindBy(xpath = "//ion-col[3]//input")
	private WebElement accountsPayable_paymentSettlementBpName;

	public WebElement accountsPayablePayementSettlementBpName() {
		return accountsPayable_paymentSettlementBpName;
	}

	@FindBy(xpath = "(//span[@class='input-calendar'])[2]")
	private WebElement accountsPayable_paymentSettlementValueDate;

	public WebElement accountsPayablePayementSettlementValueDate() {
		return accountsPayable_paymentSettlementValueDate;
	}
	// owl-date-time-container[1]/div[2]/owl-date-time-calendar[1]/div[1]/button[2]/span[1]

	@FindBy(xpath = "//datatable-row-wrapper[2]/datatable-body-row[1]/div[2]/datatable-body-cell[1]/div[1]/ion-checkbox[1]")
	private WebElement first_record;

	public WebElement firstRecord() {
		return first_record;
	}

	@FindBy(xpath = "//page-ap-payment-settlement-update[1]//datatable-body-cell[4]//div")
	private WebElement paymentSettlement_RecentlyApprovedInvoiceNumber;

	public WebElement paymentSettlementRecentlyApprovedInvoiceNUmber() {
		return paymentSettlement_RecentlyApprovedInvoiceNumber;
	}

	@FindBy(xpath = "//ion-col[9]//input")
	private WebElement accountsPayable_Description;

	public WebElement accountsPayableDescription() {
		return accountsPayable_Description;
	}

	@FindBy(xpath = "//span[contains(text(),'Yes')]")
	private WebElement accountsPayable_alertYes;

	public WebElement accountsPayableAlertYes() {
		return accountsPayable_alertYes;
	}

	@FindBy(xpath = "(//ion-toolbar[1]//ion-buttons[2])[3]")
	private WebElement accountsPayable_saveButton;

	public WebElement accountsPayableSaveButton() {
		return accountsPayable_saveButton;
	}

	@FindBy(xpath = "(//datatable-header-cell[12]/div[1])")
	private WebElement accountsPayable_Payment_NetAdjustedvalue;

	public WebElement accountsPayable_Payment_NetAdjustedvalue() {
		return accountsPayable_Payment_NetAdjustedvalue;
	}

	@FindBy(xpath = "(//ion-col[8]//input)[1]")
	private WebElement accountsPayable_Payment_Netpayable;

	public WebElement accountsPayable_Payment_Netpayable() {
		return accountsPayable_Payment_Netpayable;
	}

	// ACCOUNTS RECEIVABLE

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link=\"/tabs/list/datagrid-view/163\"]")
	private WebElement accountsReceivable_DebitNote_Eye;

	public WebElement accountsReceivable_DebitNote_Eye() {
		return accountsReceivable_DebitNote_Eye;
	}

	@FindBy(xpath = "//datatable-header[1]/div[1]/div[2]/datatable-header-cell[9]/div[1]/ion-input[1]/input[1]")
	private WebElement accountsReceivable_DebitNote_Status;

	public WebElement accountsReceivable_DebitNote_Status() {

		return accountsReceivable_DebitNote_Status;
	}

	@FindBy(xpath = "//label[contains(text(),'Debit Note Status')]")
	private WebElement accountsReceivable_DebitNote_StatusHead;

	public WebElement accountsReceivable_DebitNote_StatusHead() {

		return accountsReceivable_DebitNote_StatusHead;
	}

	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[1]//ion-button[2]")
	private WebElement ARAP_TableEdit;

	public WebElement ARAP_TableEdit() {

		return ARAP_TableEdit;
	}

	@FindBy(xpath = "//ion-col[8]/app-kub-lov[1]//ng-select[1]//div[2]")
	private WebElement accountsReceivable_DebitNote_InvoiceNo;

	public WebElement accountsReceivable_DebitNote_InvoiceNo() {

		return accountsReceivable_DebitNote_InvoiceNo;
	}

	@FindBy(xpath = "//ion-item[5]/ion-label[contains(text(), ' Accounts receivable ')]")
	private WebElement ARAP_Accountsreceivable;

	public WebElement ARAP_Accountsreceivable() {

		return ARAP_Accountsreceivable;
	}

	@FindBy(xpath = "//ion-col[4]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]")
	private WebElement accountsReceivable_DebitNote_GetBpname;

	public WebElement accountsReceivable_DebitNote_GetBpname() {

		return accountsReceivable_DebitNote_GetBpname;
	}

	@FindBy(xpath = "//ion-col[8]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]")
	private WebElement accountsReceivable_DebitNote_GetInvoiceNo;

	public WebElement accountsReceivable_DebitNote_GetInvoiceNo() {

		return accountsReceivable_DebitNote_GetInvoiceNo;
	}

	// ACCOUNTS ADVANCES

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/190']")
	private WebElement accountsReceivable_Advance_Eye;

	public WebElement accountsReceivable_Advance_Eye() {

		return accountsReceivable_Advance_Eye;
	}

	@FindBy(xpath = "//datatable-header[1]/div[1]/div[2]/datatable-header-cell[3]/div[1]/ion-input[1]/input[1]")
	private WebElement accountsReceivable_Advance_ReceivableName;

	public WebElement accountsReceivable_Advance_ReceivableName() {

		return accountsReceivable_Advance_ReceivableName;
	}

	@FindBy(xpath = "//datatable-header[1]/div[1]/div[2]/datatable-header-cell[8]/div[1]/ion-input[1]/input[1]")
	private WebElement accountsReceivable_Advance_ADVstatus;

	public WebElement accountsReceivable_Advance_ADVstatus() {

		return accountsReceivable_Advance_ADVstatus;
	}

	@FindBy(xpath = "//datatable-header[1]/div[1]/div[2]/datatable-header-cell[4]/div[1]/ion-input[1]/input[1]")
	private WebElement accountsReceivable_Advance_ADVNostatus;

	public WebElement accountsReceivable_Advance_ADVNostatus() {

		return accountsReceivable_Advance_ADVNostatus;
	}

	@FindBy(xpath = "(//ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2])[1]")
	private WebElement accountsReceivable_Advance_GetBp;

	public WebElement accountsReceivable_Advance_GetBp() {

		return accountsReceivable_Advance_GetBp;
	}

	// Account Receivable (Advances) Add Button
	@FindBy(xpath = "//app-data-grid[1]/ion-content[1]/ion-fab[1]/ion-fab-button[1]/ion-icon[1]")
	private WebElement accountReceivableAdvances_AddButton;

	public WebElement accountReceivableAdvances_AddButton() {
		return accountReceivableAdvances_AddButton;
	}

	// Receivable Name Text Box
	@FindBy(xpath = "(//ion-col[2]//input[1])[1]")
	private WebElement accountReceviableAdvances_ReceivableName_TextBox;

	public WebElement accountReceviableAdvances_ReceivableName_TextBox() {
		return accountReceviableAdvances_ReceivableName_TextBox;
	}

	// Business Patner Name Text Box
	@FindBy(xpath = "(//ion-col[3]//input[1])[1]")
	private WebElement accountReceviableAdvances_BusinessPatner_TextBox;

	public WebElement accountReceviableAdvances_BusinessPatner_TextBox() {
		return accountReceviableAdvances_BusinessPatner_TextBox;
	}

	// PONumber Text Box
	@FindBy(xpath = "(//ion-grid[1]//input[1])[7]")
	private WebElement accountReceviableAdvances_PONumber_TextBox;

	public WebElement accountReceviableAdvances_PONumber_TextBox() {
		return accountReceviableAdvances_PONumber_TextBox;
	}

	// Payment Mode Text Box
	@FindBy(xpath = "(//ion-grid[1]//input[1])[8]")
	private WebElement accountReceviableAdvances_paymentMode_TextBox;

	public WebElement accountReceviableAdvances_paymentMode_TextBox() {
		return accountReceviableAdvances_paymentMode_TextBox;
	}

	// Amount Text Box
	@FindBy(xpath = "//input[@id='advanceAmt']")
	private WebElement accountReceviableAdvances_amount_TextBox;

	public WebElement amount_TextBox() {
		return accountReceviableAdvances_amount_TextBox;
	}

	// Currency Text Box
	@FindBy(xpath = "(//ion-row[3]//input[1])[4]")
	private WebElement accountReceviableAdvances_currency_TextBox;

	public WebElement accountReceviableAdvances_currency_TextBox() {
		return accountReceviableAdvances_currency_TextBox;
	}

	@FindBy(xpath = "//span[contains(text(),'INR')]")
	private WebElement accountReceviableAdvances_INRcurrency_TextBox;

	public WebElement accountReceviableAdvances_INRcurrency_TextBox() {
		return accountReceviableAdvances_INRcurrency_TextBox;
	}

	// Description Text Box
	@FindBy(xpath = "(//ion-content[1]//input[1])[15]")
	private WebElement accountReceviableAdvances_description_TextBox;

	public WebElement accountReceviableAdvances_description_TextBox() {
		return accountReceviableAdvances_description_TextBox;
	}
	// Cost Center

	@FindBy(xpath = "(//ion-row[3]//input[1])[5]")
	private WebElement accountReceviableAdvances_costCenter_TextBox;

	public WebElement accountReceviableAdvances_costCenter_TextBox() {
		return accountReceviableAdvances_costCenter_TextBox;
	}

	// Save Button
	@FindBy(xpath = "(//ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1])[2]")
	private WebElement accountReceviableAdvances_Save_Button;

	public WebElement accountReceviableAdvances_Save_Button() {
		return accountReceviableAdvances_Save_Button;
	}

	// *****RECEIPT OBJECTS*****//

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/193']")
	private WebElement accountReceviableReceipt_Eye;

	public WebElement accountReceviableReceipt_Eye() {
		return accountReceviableReceipt_Eye;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/210']")
	private WebElement accountReceviableReceiptReversals_Eye;

	public WebElement accountReceviableReceiptReversals_Eye() {
		return accountReceviableReceiptReversals_Eye;
	}

	@FindBy(xpath = "(//ion-col[3]//input[1])[1]")
	private WebElement accountReceviableReceipt_Receipt_Type;

	public WebElement accountReceviableReceipt_Receipt_Type() {
		return accountReceviableReceipt_Receipt_Type;
	}

	@FindBy(xpath = "(//ion-col[4]//input[1])[1]")
	private WebElement accountReceviableReceipt_Receipt_RefNo;

	public WebElement accountReceviableReceipt_Receipt_RefNo() {
		return accountReceviableReceipt_Receipt_RefNo;
	}

	@FindBy(xpath = "(//ion-col[7]//input[1])[1]")
	private WebElement accountReceviableReceipt_Receipt_Currency;

	public WebElement accountReceviableReceipt_Receipt_Currency() {
		return accountReceviableReceipt_Receipt_Currency;
	}

	@FindBy(xpath = "(//ion-col[8]//input[1])[1]")
	private WebElement accountReceviableReceipt_Receipt_BankNo;

	public WebElement accountReceviableReceipt_Receipt_BankNo() {
		return accountReceviableReceipt_Receipt_BankNo;
	}

	@FindBy(xpath = "(//ion-col[9]//input[1])[1]")
	private WebElement accountReceviableReceipt_Receipt_Payer;

	public WebElement accountReceviableReceipt_Receipt_Payer() {
		return accountReceviableReceipt_Receipt_Payer;
	}

	@FindBy(xpath = "(//ion-col[11]//input[1])[1]")
	private WebElement accountReceviableReceipt_Receipt_Remark;

	public WebElement accountReceviableReceipt_Receipt_Remark() {
		return accountReceviableReceipt_Receipt_Remark;
	}

	@FindBy(xpath = "//ion-col[6]/ion-item[1]/input[@ng-reflect-name='receiptAmt']")
	private WebElement accountReceviableReceipt_Receipt_Amount;

	public WebElement accountReceviableReceipt_Receipt_Amount() {
		return accountReceviableReceipt_Receipt_Amount;
	}

	@FindBy(xpath = "(//ion-toolbar[1]//ion-buttons[2])[3]")
	private WebElement accountReceviableReceipt_Receipt_Save;

	public WebElement accountReceviableReceipt_Receipt_Save() {

		return accountReceviableReceipt_Receipt_Save;
	}

	@FindBy(xpath = "//datatable-header[1]/div[1]/div[2]/datatable-header-cell[4]/div[1]/ion-input[1]/input[1]")
	private WebElement accountReceviableReceipt_Receipt_SearchRefNo;

	public WebElement accountReceviableReceipt_Receipt_SearchRefNo() {

		return accountReceviableReceipt_Receipt_SearchRefNo;
	}

	@FindBy(xpath = "//datatable-header[1]/div[1]/div[2]/datatable-header-cell[5]/div[1]/ion-input[1]/input[1]")
	private WebElement accountReceviableReceipt_ReceiptType;

	public WebElement accountReceviableReceipt_ReceiptType() {

		return accountReceviableReceipt_ReceiptType;
	}

	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[5]/div[1]")
	private WebElement accountReceviableReceipt_ReceiptNumber;

	public WebElement accountReceviableReceipt_ReceiptNumber() {

		return accountReceviableReceipt_ReceiptNumber;
	}

	// GL OBJECTS

	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[2]/div[1]")
	private WebElement accountReceviable_GetBranchcode;

	public WebElement accountReceviable_GetBranchcode() {

		return accountReceviable_GetBranchcode;
	}

	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[3]/div[1]")
	private WebElement accountReceviable_GetGrn;

	public WebElement accountReceviable_GetGrn() {

		return accountReceviable_GetGrn;
	}
	// Manual Payout

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/222']")
	private WebElement ARAP_Manual_payout;

	public WebElement ARAP_Manual_payout() {

		return ARAP_Manual_payout;
	}

	@FindBy(xpath = "(//datatable-body-cell[4]/div[1]/span[1])[9]")
	private WebElement ARAP_Manual_payout_RefNo;

	public WebElement ARAP_Manual_payout_RefNo() {

		return ARAP_Manual_payout_RefNo;
	}
	
	
	@FindBy(xpath = "//ion-col[3]/app-kub-lov[1]/span/ng-select[1]/div[1]/div[1]/div[2]")
	private WebElement ARAP_Manual_payout_GetBranch;

	public WebElement ARAP_Manual_payout_GetBranch() {

		return ARAP_Manual_payout_GetBranch;
	}
}
