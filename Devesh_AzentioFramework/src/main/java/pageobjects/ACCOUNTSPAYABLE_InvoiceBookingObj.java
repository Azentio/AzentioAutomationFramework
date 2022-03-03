package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ACCOUNTSPAYABLE_InvoiceBookingObj {
	WebDriver driver;

	public ACCOUNTSPAYABLE_InvoiceBookingObj(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//	INVOICE BOOKING SUBMODULE  //
	
	//eye button of Invoice Booking
	@FindBy(xpath = "//div[3]//ion-menu-toggle[4]//ion-item//ion-buttons//ion-button[2]")
	private WebElement accountPayable_InvoiceBooking_EyeButton;

	public WebElement accountPayable_InvoiceBooking_EyeButton() {
		return accountPayable_InvoiceBooking_EyeButton;
	}
	
	// add button invoice booking
	@FindBy(xpath = "//ion-fab-button[@id='addBtn']")
	private WebElement accountPayable_InvoiceBooking_AddButton;

	public WebElement accountPayable_InvoiceBooking_AddButton() {
		return accountPayable_InvoiceBooking_AddButton;
	}
	
	// Entity Branch
	@FindBy(xpath = "//ion-col[1]/app-kub-lov/span/ng-select/div/div/div[3]/input")
	private WebElement accountPayable_InvoiceBooking_EntityBranch;
	
	public WebElement accountPayable_InvoiceBooking_EntityBranch() {
		return accountPayable_InvoiceBooking_EntityBranch;
	}
	
	// Invoice type
	//@FindBy(xpath = "//page-ap-bill-booking-update/ion-content/form/ion-grid/ion-row[1]/ion-col[2]/app-kub-lov/span/ng-select/div/div/div[3]/input")
	@FindBy(xpath = "//ion-col[2]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement accountPayable_InvoiceBooking_InvoiceType;
	
	public WebElement accountPayable_InvoiceBooking_InvoiceType() {
		return accountPayable_InvoiceBooking_InvoiceType;
	}
	
	// Invoice sub type
	@FindBy(xpath = "//ion-col[3]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement accountPayable_InvoiceBooking_InvoiceSubType;
	
	public WebElement accountPayable_InvoiceBooking_InvoiceSubType() {
		return accountPayable_InvoiceBooking_InvoiceSubType;
	}
	
	// BP_Name
	@FindBy(xpath = "//ion-col[4]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement accountPayable_InvoiceBooking_BP_Name;
	
	public WebElement accountPayable_InvoiceBooking_BP_Name() {
		return accountPayable_InvoiceBooking_BP_Name;
	}
	
	// BP_Name[against po]
	@FindBy(xpath = "//ion-col[3]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement accountPayable_InvoiceBooking_BP_Name_AgainstPO;
	
	public WebElement accountPayable_InvoiceBooking_BP_Name_AgainstPO() {
		return accountPayable_InvoiceBooking_BP_Name_AgainstPO;
	}
	
	// CostCenter
	@FindBy(xpath = "//ion-col[7]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement accountPayable_InvoiceBooking_CostCenter;
	
	public WebElement accountPayable_InvoiceBooking_CostCenter() {
		return accountPayable_InvoiceBooking_CostCenter;
	}
	
	// CostCenter[against PO]
	@FindBy(xpath = "//ion-col[6]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement accountPayable_InvoiceBooking_CostCenterAgainstPO;
	
	public WebElement accountPayable_InvoiceBooking_CostCenterAgainstPO() {
		return accountPayable_InvoiceBooking_CostCenterAgainstPO;
	}
	
	// Supplier Reference Number
	@FindBy(xpath = "//ion-grid/ion-row/ion-col[8]/ion-item/ion-input/input")
	private WebElement accountPayable_InvoiceBooking_SupplierReferenceNumber;
	
	public WebElement accountPayable_InvoiceBooking_SupplierReferenceNumber() {
		return accountPayable_InvoiceBooking_SupplierReferenceNumber;
	}
	
	// Supplier Reference Number[againstPO]
	@FindBy(xpath = "//ion-grid/ion-row/ion-col[7]/ion-item/ion-input/input")
	private WebElement accountPayable_InvoiceBooking_SupplierReferenceNumberAgainstPO;
	
	public WebElement accountPayable_InvoiceBooking_SupplierReferenceNumberAgainstPO() {
		return accountPayable_InvoiceBooking_SupplierReferenceNumberAgainstPO;
	}
	
	// Invoice Date
	@FindBy(xpath = "//ion-col[9]/app-kub-date-time/ion-item/div/span[1]")
	private WebElement accountPayable_InvoiceBooking_InvoiceDate;
	
	public WebElement accountPayable_InvoiceBooking_InvoiceDate() {
		return accountPayable_InvoiceBooking_InvoiceDate;
	}
	
	// Invoice Date[AginstPO]
	@FindBy(xpath = "//ion-col[8]/app-kub-date-time/ion-item/div/span[1]")
	private WebElement accountPayable_InvoiceBooking_InvoiceDateAgainstPO;
	
	public WebElement accountPayable_InvoiceBooking_InvoiceDateAgainstPO() {
		return accountPayable_InvoiceBooking_InvoiceDateAgainstPO;
	}
	
	// Total Invoice Amount
	@FindBy(xpath = "//ion-grid/ion-row/ion-col[10]/ion-item/input")
	private WebElement accountPayable_InvoiceBooking_TotalInvoiceAmount;
	
	public WebElement accountPayable_InvoiceBooking_TotalInvoiceAmount() {
		return accountPayable_InvoiceBooking_TotalInvoiceAmount;
	}
	
	// Total Invoice Amount[againstPO]
	@FindBy(xpath = "//ion-grid/ion-row/ion-col[9]/ion-item/input")
	private WebElement accountPayable_InvoiceBooking_TotalInvoiceAmountAgainstPO;
	
	public WebElement accountPayable_InvoiceBooking_TotalInvoiceAmountAgainstPO() {
		return accountPayable_InvoiceBooking_TotalInvoiceAmountAgainstPO;
	}
	
	// Tax/Vat/GST Amount
	@FindBy(xpath = "//ion-grid/ion-row/ion-col[11]/ion-item/input")
	private WebElement accountPayable_InvoiceBooking_TaxAndGstAmount;
	
	public WebElement accountPayable_InvoiceBooking_TaxAndGstAmount() {
		return accountPayable_InvoiceBooking_TaxAndGstAmount;
	}
	
	// Flat Discount on Invoice
	@FindBy(xpath = "//ion-grid/ion-row/ion-col[12]/ion-item/input")
	private WebElement accountPayable_InvoiceBooking_FlatDiscount;
	
	public WebElement accountPayable_InvoiceBooking_FlatDiscount() {
		return accountPayable_InvoiceBooking_FlatDiscount;
	}
	
	// Flat Discount on Invoice[AgainstPO]
	@FindBy(xpath = "//ion-grid/ion-row/ion-col[11]/ion-item/input")
	private WebElement accountPayable_InvoiceBooking_FlatDiscountAgainstPO;
	
	public WebElement accountPayable_InvoiceBooking_FlatDiscountAgainstPO() {
		return accountPayable_InvoiceBooking_FlatDiscountAgainstPO;
	}
	
	// Early Payment Discount Type
	@FindBy(xpath = "//ion-col[13]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement accountPayable_InvoiceBooking_EarlyPaymentDiscountType;
	
	public WebElement accountPayable_InvoiceBooking_EarlyPaymentDiscountType() {
		return accountPayable_InvoiceBooking_EarlyPaymentDiscountType;
	}
	
	// Early Payment Discount Type[AgainstPO]
	@FindBy(xpath = "//ion-col[12]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement accountPayable_InvoiceBooking_EarlyPaymentDiscountTypeAgainstPO;
	
	public WebElement accountPayable_InvoiceBooking_EarlyPaymentDiscountTypeAgainstPO() {
		return accountPayable_InvoiceBooking_EarlyPaymentDiscountTypeAgainstPO;
	}
	
	// Early Payment Discount %
	@FindBy(xpath = "//ion-grid/ion-row/ion-col[14]/ion-item/ion-input/input")
	private WebElement accountPayable_InvoiceBooking_EarlyPaymentDiscountPercentBasis;
	
	public WebElement accountPayable_InvoiceBooking_EarlyPaymentDiscountPercentBasis() {
		return accountPayable_InvoiceBooking_EarlyPaymentDiscountPercentBasis;
	}
	
	// Early Payment Discount % [againstPO]
	@FindBy(xpath = "//ion-grid/ion-row/ion-col[13]/ion-item/ion-input/input")
	private WebElement accountPayable_InvoiceBooking_EarlyPaymentDiscountPercentBasisAgainstPO;
	
	public WebElement accountPayable_InvoiceBooking_EarlyPaymentDiscountPercentBasisAgainstPO() {
		return accountPayable_InvoiceBooking_EarlyPaymentDiscountPercentBasisAgainstPO;
	}
	
	// Early Payment Discount Amount
	@FindBy(xpath = "//ion-grid/ion-row/ion-col[15]/ion-item/input")
	private WebElement accountPayable_InvoiceBooking_EarlyPaymentDiscountAmount;
	
	public WebElement accountPayable_InvoiceBooking_EarlyPaymentDiscountAmount() {
		return accountPayable_InvoiceBooking_EarlyPaymentDiscountAmount;
	}
	
	// Early Payment Discount Amount[flat]
	@FindBy(xpath = "//ion-grid/ion-row/ion-col[14]/ion-item/input")
	private WebElement accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountAmount;
	
	public WebElement accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountAmount() {
		return accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountAmount;
	}
	
	// Early Payment Discount Amount[flat][againstPO]
	@FindBy(xpath = "//ion-grid/ion-row/ion-col[13]/ion-item/input")
	private WebElement accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountAmountAgainstPO;
	
	public WebElement accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountAmountAgainstPO() {
		return accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountAmountAgainstPO;
	}
	
	// Early Payment Discount Days
	@FindBy(xpath = "//ion-grid/ion-row/ion-col[16]/ion-item/ion-input/input")
	private WebElement accountPayable_InvoiceBooking_EarlyPaymentDiscountDays;
	
	public WebElement accountPayable_InvoiceBooking_EarlyPaymentDiscountDays() {
		return accountPayable_InvoiceBooking_EarlyPaymentDiscountDays;
	}
	
	// Early Payment Discount Days[flat]
	@FindBy(xpath = "//ion-grid/ion-row/ion-col[15]/ion-item/ion-input/input")
	private WebElement accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountDays;
	
	public WebElement accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountDays() {
		return accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountDays;
	}
	
	// Early Payment Discount Days[flat][AgainstPO]
	@FindBy(xpath = "//ion-grid/ion-row/ion-col[14]/ion-item/ion-input/input")
	private WebElement accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountDaysAgainstPO;
	
	public WebElement accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountDaysAgainstPO() {
		return accountPayable_InvoiceBooking_EarlyPaymentFlatDiscountDaysAgainstPO;
	}
	
	// Mode Of Payment
	@FindBy(xpath = "//ion-col[17]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement accountPayable_InvoiceBooking_ModeOfPayment;
	
	public WebElement accountPayable_InvoiceBooking_ModeOfPayment() {
		return accountPayable_InvoiceBooking_ModeOfPayment;
	}
	
	// Mode Of Payment[flat]
	@FindBy(xpath = "//ion-col[16]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement accountPayable_InvoiceBooking_ModeOfPaymentForFlat;
	
	public WebElement accountPayable_InvoiceBooking_ModeOfPaymentForFlat() {
		return accountPayable_InvoiceBooking_ModeOfPaymentForFlat;
	}
	
	// Mode Of Payment[flat][against PO]
	@FindBy(xpath = "//ion-col[15]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement accountPayable_InvoiceBooking_ModeOfPaymentForFlatAgainstPO;
	
	public WebElement accountPayable_InvoiceBooking_ModeOfPaymentForFlatAgainstPO() {
		return accountPayable_InvoiceBooking_ModeOfPaymentForFlatAgainstPO;
	}
	
	// Invoice Currency
	@FindBy(xpath = "//ion-col[18]/app-kub-lov/span/ng-select/div/div/div[3]/input")
	private WebElement accountPayable_InvoiceBooking_InvoiceCurrency;
	
	public WebElement accountPayable_InvoiceBooking_InvoiceCurrency() {
		return accountPayable_InvoiceBooking_InvoiceCurrency;
	}
	
	// Invoice Currency[flat]
	@FindBy(xpath = "//ion-col[17]/app-kub-lov/span/ng-select/div/div/div[3]/input")
	private WebElement accountPayable_InvoiceBooking_InvoiceCurrencyFlat;
	
	public WebElement accountPayable_InvoiceBooking_InvoiceCurrencyFlat() {
		return accountPayable_InvoiceBooking_InvoiceCurrencyFlat;
	}
	
	// Invoice Currency[flat][AgainstPO]
	@FindBy(xpath = "//ion-col[16]/app-kub-lov/span/ng-select/div/div/div[3]/input")
	private WebElement accountPayable_InvoiceBooking_InvoiceCurrencyFlatAgainstPO;
	
	public WebElement accountPayable_InvoiceBooking_InvoiceCurrencyFlatAgainstPO() {
		return accountPayable_InvoiceBooking_InvoiceCurrencyFlatAgainstPO;
	}
	
	// Invoice Payment Currency
	@FindBy(xpath = "//ion-col[19]/app-kub-lov/span/ng-select/div/div/div[3]/input")
	private WebElement accountPayable_InvoiceBooking_InvoicePaymentCurrency;
	
	public WebElement accountPayable_InvoiceBooking_InvoicePaymentCurrency() {
		return accountPayable_InvoiceBooking_InvoicePaymentCurrency;
	}
	
	// Invoice Payment Currency[flat]
	@FindBy(xpath = "//ion-col[18]/app-kub-lov/span/ng-select/div/div/div[3]/input")
	private WebElement accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlat;
	
	public WebElement accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlat() {
		return accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlat;
	}
	
	// Invoice Payment Currency[flat][againstPO]
	@FindBy(xpath = "//ion-col[17]/app-kub-lov/span/ng-select/div/div/div[3]/input")
	private WebElement accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlatAgainstPO;
	
	public WebElement accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlatAgainstPO() {
		return accountPayable_InvoiceBooking_InvoicePaymentCurrencyFlatAgainstPO;
	}
	
	// Payment Date
	@FindBy(xpath = "//ion-col[20]/app-kub-date-time/ion-item/div/span[1]")
	private WebElement accountPayable_InvoiceBooking_PaymentDate;
	
	public WebElement accountPayable_InvoiceBooking_PaymentDate() {
		return accountPayable_InvoiceBooking_PaymentDate;
	}
	
	// Payment Date[flat]
	@FindBy(xpath = "//ion-col[19]/app-kub-date-time/ion-item/div/span[1]")
	private WebElement accountPayable_InvoiceBooking_PaymentDateFlat;
	
	public WebElement accountPayable_InvoiceBooking_PaymentDateFlat() {
		return accountPayable_InvoiceBooking_PaymentDateFlat;
	}
	
	// Payment Date[flat][againstPO]
	@FindBy(xpath = "//ion-col[18]/app-kub-date-time/ion-item/div/span[1]")
	private WebElement accountPayable_InvoiceBooking_PaymentDateFlatAgainstPO;
	
	public WebElement accountPayable_InvoiceBooking_PaymentDateFlatAgainstPO() {
		return accountPayable_InvoiceBooking_PaymentDateFlatAgainstPO;
	}
	
	// Rounding Adjustment
	@FindBy(xpath = "//ion-grid/ion-row/ion-col[21]/ion-item/input")
	private WebElement accountPayable_InvoiceBooking_RoundingAdjustment;
	
	public WebElement accountPayable_InvoiceBooking_RoundingAdjustment() {
		return accountPayable_InvoiceBooking_RoundingAdjustment;
	}
	
	// Rounding Adjustment[flat]
	@FindBy(xpath = "//ion-grid/ion-row/ion-col[20]/ion-item/input")
	private WebElement accountPayable_InvoiceBooking_RoundingAdjustmentFlat;
	
	public WebElement accountPayable_InvoiceBooking_RoundingAdjustmentFlat() {
		return accountPayable_InvoiceBooking_RoundingAdjustmentFlat;
	}
	
	// Rounding Adjustment[flat][AgainstPO]
	@FindBy(xpath = "//ion-grid/ion-row/ion-col[19]/ion-item/input")
	private WebElement accountPayable_InvoiceBooking_RoundingAdjustmentFlatAgainstPO;
	
	public WebElement accountPayable_InvoiceBooking_RoundingAdjustmentFlatAgainstPO() {
		return accountPayable_InvoiceBooking_RoundingAdjustmentFlatAgainstPO;
	}
	
	// Remarks
	@FindBy(xpath = "//textarea[@name='remarks']")
	private WebElement accountPayable_InvoiceBooking_Remarks;
	
	public WebElement accountPayable_InvoiceBooking_Remarks() {
		return accountPayable_InvoiceBooking_Remarks;
	}
	
	// Submit by maker remarks
	@FindBy(xpath = "//ion-row[1]/ion-col/ion-item/ion-textarea/div/textarea")
	private WebElement accountPayable_InvoiceBooking_RemarksByMaker;
	
	public WebElement accountPayable_InvoiceBooking_RemarksByMaker() {
		return accountPayable_InvoiceBooking_RemarksByMaker;
	}
	
	// Save button
	@FindBy(xpath = "//page-ap-bill-booking-update/ion-header/ion-toolbar/ion-buttons[2]/ion-button")
	private WebElement accountPayable_InvoiceBooking_SaveButton;
	
	public WebElement accountPayable_InvoiceBooking_SaveButton() {
		return accountPayable_InvoiceBooking_SaveButton;
	}
	
	// AP invoice against expence
	@FindBy(xpath = "//span[2]/ion-tab-button/ion-label")
	private WebElement accountPayable_InvoiceBooking_APInvoiceAgainstExpense;
	
	public WebElement accountPayable_InvoiceBooking_APInvoiceAgainstExpense() {
		return accountPayable_InvoiceBooking_APInvoiceAgainstExpense;
	}
	
	// Advance/AR number
	@FindBy(xpath = "//div[2]/input[1]")
	private WebElement accountPayable_InvoiceBooking_AdvanceNumber;
	
	public WebElement accountPayable_InvoiceBooking_AdvanceNumber() {
		return accountPayable_InvoiceBooking_AdvanceNumber;
	}
	
	// PO Number
	@FindBy(xpath = "//div[2]/input[1]")
	private WebElement accountPayable_InvoiceBooking_PONumber;
	
	public WebElement accountPayable_InvoiceBooking_PONumber() {
		return accountPayable_InvoiceBooking_PONumber;
	}
	
	// GRN No.
	@FindBy(xpath = "//ion-col[3]/ion-item/ion-select")
	private WebElement accountPayable_InvoiceBooking_GRN_Number;
	
	public WebElement accountPayable_InvoiceBooking_GRN_Number() {
		return accountPayable_InvoiceBooking_GRN_Number;
	}
	
	// GRN No. check box
	@FindBy(xpath = "//button/div/div[1]")
	private WebElement accountPayable_InvoiceBooking_GRN_CheckBox;
	
	public WebElement accountPayable_InvoiceBooking_GRN_CheckBox() {
		return accountPayable_InvoiceBooking_GRN_CheckBox;
	}
	
	// GRN No. check box ok button
	@FindBy(xpath = "//button[2]")
	private WebElement accountPayable_InvoiceBooking_GRN_CheckBoxOKButton;
	
	public WebElement accountPayable_InvoiceBooking_GRN_CheckBoxOKButton() {
		return accountPayable_InvoiceBooking_GRN_CheckBoxOKButton;
	}
	
	// Action button
	@FindBy(xpath = "//datatable-body-cell/div/ion-button")
	private WebElement accountPayable_InvoiceBooking_ActionButton;
	
	public WebElement accountPayable_InvoiceBooking_ActionButton() {
		return accountPayable_InvoiceBooking_ActionButton;
	}
	
	// Expense Code
	@FindBy(xpath = "//datatable-body-cell[3]/div/app-kub-lov/ion-select")
	private WebElement accountPayable_InvoiceBooking_ExpenseCode;
	
	public WebElement accountPayable_InvoiceBooking_ExpenseCode() {
		return accountPayable_InvoiceBooking_ExpenseCode;
	}
	
	// Expense Code for laptop radio button
	@FindBy(xpath = "//ion-item[5]/ion-radio")
	private WebElement accountPayable_InvoiceBooking_ExpenseCodeForLaptop;
	
	public WebElement accountPayable_InvoiceBooking_ExpenseCodeForLaptop() {
		return accountPayable_InvoiceBooking_ExpenseCodeForLaptop;
	}
	
	// Invoice Qty
	@FindBy(xpath = "//datatable-body-cell[5]/div/input")
	private WebElement accountPayable_InvoiceBooking_InvoiceQuantity;
	
	public WebElement accountPayable_InvoiceBooking_InvoiceQuantity() {
		return accountPayable_InvoiceBooking_InvoiceQuantity;
	}
	
	// Unit
	@FindBy(xpath = "//datatable-body-cell[6]/div/app-kub-lov/ion-select")
	private WebElement accountPayable_InvoiceBooking_Unit;
	
	public WebElement accountPayable_InvoiceBooking_Unit() {
		return accountPayable_InvoiceBooking_Unit;
	}
	
	// Unit(Boxes) radio button
	@FindBy(xpath = "//ion-item[1]/ion-radio")
	private WebElement accountPayable_InvoiceBooking_UnitBoxes;
	
	public WebElement accountPayable_InvoiceBooking_UnitBoxes() {
		return accountPayable_InvoiceBooking_UnitBoxes;
	}
	
	// Rate per Unit
	@FindBy(xpath = "//datatable-body-cell[7]/div/input")
	private WebElement accountPayable_InvoiceBooking_RatePerUnit;
	
	public WebElement accountPayable_InvoiceBooking_RatePerUnit() {
		return accountPayable_InvoiceBooking_RatePerUnit;
	}
	
	// Currency AP invoice Against Expense
	@FindBy(xpath = "//datatable-body-cell[8]/div/app-kub-lov/ion-select")
	private WebElement accountPayable_InvoiceBooking_Currency;
	
	public WebElement accountPayable_InvoiceBooking_Currency() {
		return accountPayable_InvoiceBooking_Currency;
	}
	
	// Shipped From Location
	@FindBy(xpath = "//datatable-body-cell[10]/div/app-kub-lov/ion-select")
	private WebElement accountPayable_InvoiceBooking_ShippedFromLocation;
	
	public WebElement accountPayable_InvoiceBooking_ShippedFromLocation() {
		return accountPayable_InvoiceBooking_ShippedFromLocation;
	}
	
	// Shipped From Location(India-MH)
	@FindBy(xpath = "//ion-item[8]/ion-radio")
	private WebElement accountPayable_InvoiceBooking_ShippedFromMaharastra;
	
	public WebElement accountPayable_InvoiceBooking_ShippedFromMaharastra() {
		return accountPayable_InvoiceBooking_ShippedFromMaharastra;
	}
	
	// Delivery Location
	@FindBy(xpath = "//datatable-body-cell[11]/div/app-kub-lov/ion-select")
	private WebElement accountPayable_InvoiceBooking_DeliveryLocation;
	
	public WebElement accountPayable_InvoiceBooking_DeliveryLocation() {
		return accountPayable_InvoiceBooking_DeliveryLocation;
	}
	
	// Delivery Location Mulund Branch
	@FindBy(xpath = "//ion-item[4]/ion-radio")
	private WebElement accountPayable_InvoiceBooking_DeliveryLocationMulund;
	
	public WebElement accountPayable_InvoiceBooking_DeliveryLocationMulund() {
		return accountPayable_InvoiceBooking_DeliveryLocationMulund;
	}
	
	// page billing expense update save button
//	@FindBy(xpath = "//page-billing-expense-update/ion-header/ion-toolbar/ion-buttons[1]/ion-button")
	@FindBy(xpath = "(//ion-toolbar/ion-buttons[1]/ion-button[1])[2]")
	private WebElement accountPayable_InvoiceBooking_SaveExpense;
	
	public WebElement accountPayable_InvoiceBooking_SaveExpense() {
		return accountPayable_InvoiceBooking_SaveExpense;
	}
	
	// Tax Details button
	@FindBy(xpath = "//datatable-body-cell[12]/div/ion-buttons/ion-button")
	private WebElement accountPayable_InvoiceBooking_TaxDetails;
	
	public WebElement accountPayable_InvoiceBooking_TaxDetails() {
		return accountPayable_InvoiceBooking_TaxDetails;
	}
	
	// Tax Amount
	@FindBy(xpath = "//datatable-body-cell[6]/div/input")
	private WebElement accountPayable_InvoiceBooking_TaxAmount;
	
	public WebElement accountPayable_InvoiceBooking_TaxAmount() {
		return accountPayable_InvoiceBooking_TaxAmount;
	}
	
	// Tax Amount for SGST
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[6]/div/input")
	private WebElement accountPayable_InvoiceBooking_TaxAmountSGST;
	
	public WebElement accountPayable_InvoiceBooking_TaxAmountSGST() {
		return accountPayable_InvoiceBooking_TaxAmountSGST;
	}
	
	// Tax Amount for CGST
	@FindBy(xpath = "//datatable-row-wrapper[2]/datatable-body-row/div[2]/datatable-body-cell[6]/div/input")
	private WebElement accountPayable_InvoiceBooking_TaxAmountCGST;
	
	public WebElement accountPayable_InvoiceBooking_TaxAmountCGST() {
		return accountPayable_InvoiceBooking_TaxAmountCGST;
	}
	
//	// Tax percent for taxtype SGST
//	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[4]/div/input")
//	private WebElement accountPayable_InvoiceBooking_TaxPercentSGST;
//	
//	public WebElement accountPayable_InvoiceBooking_TaxPercentSGST() {
//		return accountPayable_InvoiceBooking_TaxPercentSGST;
//	}
//	
//	// Tax percent for taxtype CGST
//	@FindBy(xpath = "//datatable-row-wrapper[2]/datatable-body-row/div[2]/datatable-body-cell[4]/div/input")
//	private WebElement accountPayable_InvoiceBooking_TaxPercentCGST;
//	
//	public WebElement accountPayable_InvoiceBooking_TaxPercentCGST() {
//		return accountPayable_InvoiceBooking_TaxPercentCGST;
//	}
//	
//	// Invoice Amount for SGST
//	@FindBy(xpath = "(//datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[5]/div/input)[2]")
//	private WebElement accountPayable_InvoiceBooking_InvoiceAmountSGST;
//	
//	public WebElement accountPayable_InvoiceBooking_InvoiceAmountSGST() {
//		return accountPayable_InvoiceBooking_InvoiceAmountSGST;
//	}
//	
//	// Invoice Amount for CGST
//	@FindBy(xpath = "//datatable-row-wrapper[2]/datatable-body-row/div[2]/datatable-body-cell[5]/div/input")
//	private WebElement accountPayable_InvoiceBooking_InvoiceAmountCGST;
//	
//	public WebElement accountPayable_InvoiceBooking_InvoiceAmountCGST() {
//		return accountPayable_InvoiceBooking_InvoiceAmountCGST;
//	}
	
	
	// Tax Details SaveButton
	@FindBy(xpath = "//page-tax-details-po-update/ion-header/ion-toolbar/ion-buttons/ion-button[1]")
	private WebElement accountPayable_InvoiceBooking_TaxDetailsSaveButton;
	
	public WebElement accountPayable_InvoiceBooking_TaxDetailsSaveButton() {
		return accountPayable_InvoiceBooking_TaxDetailsSaveButton;
	}
	
	// Tax Details CloseButton
	@FindBy(xpath = "//page-tax-details-po-update/ion-header/ion-toolbar/ion-buttons/ion-button[2]")
//	@FindBy(xpath = "(//ion-toolbar/ion-buttons/ion-button[2])[2]")
	private WebElement accountPayable_InvoiceBooking_TaxDetailsCloseButton;
	
	public WebElement accountPayable_InvoiceBooking_TaxDetailsCloseButton() {
		return accountPayable_InvoiceBooking_TaxDetailsCloseButton;
	}
	
	// Cost Center button
	@FindBy(xpath = "//datatable-body-cell[13]/div/ion-buttons/ion-button")
	private WebElement accountPayable_InvoiceBooking_CostCenterButton;
	
	public WebElement accountPayable_InvoiceBooking_CostCenterButton() {
		return accountPayable_InvoiceBooking_CostCenterButton;
	}
	
	// Cost Center type details
	@FindBy(xpath = "//datatable-body-cell[2]/div/app-kub-lov/ion-select")
	private WebElement accountPayable_InvoiceBooking_CostCenterTypeDetail;
	
	public WebElement accountPayable_InvoiceBooking_CostCenterTypeDetail() {
		return accountPayable_InvoiceBooking_CostCenterTypeDetail;
	}
	
	// Cost Center type Finance
	@FindBy(xpath = "//ion-item[1]/ion-radio")
	private WebElement accountPayable_InvoiceBooking_CostCenterTypeFinance;
	
	public WebElement accountPayable_InvoiceBooking_CostCenterTypeFinance() {
		return accountPayable_InvoiceBooking_CostCenterTypeFinance;
	}
	
	// Cost Center Details(Amount to be allocated
	@FindBy(xpath = "//datatable-body-cell[3]/div/input")
	private WebElement accountPayable_InvoiceBooking_AmountToBeAllocated;
	
	public WebElement accountPayable_InvoiceBooking_AmountToBeAllocated() {
		return accountPayable_InvoiceBooking_AmountToBeAllocated;
	}
	
	// Add Cost Center
	@FindBy(xpath = "//ion-col[2]/ion-button")
	private WebElement accountPayable_InvoiceBooking_AddCostCenter;
	
	public WebElement accountPayable_InvoiceBooking_AddCostCenter() {
		return accountPayable_InvoiceBooking_AddCostCenter;
	}
	
	//Cost Center details save button
	@FindBy(xpath = "//page-cost-centre-expense-update/ion-header/ion-toolbar/ion-buttons/ion-button[1]")
	private WebElement accountPayable_InvoiceBooking_CostCenterDetailsSaveButton;
	
	public WebElement accountPayable_InvoiceBooking_CostCenterDetailsSaveButton() {
		return accountPayable_InvoiceBooking_CostCenterDetailsSaveButton;
	}
	
	//reviewer remark
	@FindBy(xpath = "//ion-row[1]/ion-col/ion-item/ion-textarea/div/textarea")
	private WebElement accountPayable_InvoiceBooking_ApprovedByReviewerRemark;
	
	public WebElement accountPayable_InvoiceBooking_ApprovedByReviewerRemark() {
		return accountPayable_InvoiceBooking_ApprovedByReviewerRemark;
	}
	
	// Search icon
	@FindBy(xpath = "(//ion-buttons/ion-item/ion-icon)[2]")
	private WebElement accountPayable_InvoiceBooking_Search;

	public WebElement accountPayable_InvoiceBooking_Search() {
		return accountPayable_InvoiceBooking_Search;
	}

	// Record Search using Business Partner
	@FindBy(xpath = "//datatable-header-cell[5]/div/ion-input/input")
	private WebElement accountPayable_InvoiceBooking_BusinessPartnerSearch;

	public WebElement accountPayable_InvoiceBooking_BusinessPartnerSearch() {
		return accountPayable_InvoiceBooking_BusinessPartnerSearch;
	}
	
	// Tax details Search via InvoiceNumber
	@FindBy(xpath = "//datatable-header-cell[3]/div/ion-input/input")
	private WebElement accountPayable_InvoiceBooking_InvoiceNumberSearch;
	
	public WebElement accountPayable_InvoiceBooking_InvoiceNumberSearch() {
		return accountPayable_InvoiceBooking_InvoiceNumberSearch;
	}
	

	// First eye button [Invoice Booking]
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[1]/div/ion-buttons/ion-button[1]")
	private WebElement accountPayable_InvoiceBooking_FirstEyeButton;
	
	public WebElement accountPayable_InvoiceBooking_FirstEyeButton() {
		return accountPayable_InvoiceBooking_FirstEyeButton;
	}

	// Contract Status
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[13]/div[1]/span")
	private WebElement accountPayable_InvoiceBooking_ContractStatus;

	public WebElement accountPayable_InvoiceBooking_ContractStatus() {
		return accountPayable_InvoiceBooking_ContractStatus;
	}
	
	

}
