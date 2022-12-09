package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvoiceBookingObj {
	WebDriver driver;

	public InvoiceBookingObj(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// eye button of Invoice Booking
	@FindBy(xpath = "//div[3]//ion-menu-toggle[4]//ion-item//ion-buttons//ion-button[2]")
	private WebElement accountPayable_InvoiceBooking_EyeButton;

	public WebElement accountPayable_InvoiceBooking_EyeButton() {
		return accountPayable_InvoiceBooking_EyeButton;
	}

	// serach buisness partner in invoice list view
	@FindBy(xpath = "//datatable-header[1]/div[1]/div[2]/datatable-header-cell[5]/div[1]/ion-input[1]/input[1]")
	private WebElement searchBpInList;

	public WebElement searchBpInList() {
		return searchBpInList;
	}
	@FindBy(xpath="//datatable-header-cell[13]/div/ion-input/input")
	private WebElement searchInvoiceStatus;
	public WebElement searchInvoiceStatus() {
		return searchInvoiceStatus;
	}
	@FindBy(xpath="//datatable-header-cell[4]/div/ion-input/input")
	private WebElement searchInvoiceType;
	public WebElement searchInvoiceType() {
		return searchInvoiceType;
	}
	@FindBy(xpath="//ion-row[1]/ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]")
	private WebElement getBuisnessPartnerFromBillInvoiceAgainstPo;
	public WebElement getBuisnessPartnerFromBillInvoiceAgainstPo() {
		return getBuisnessPartnerFromBillInvoiceAgainstPo;
	}
	@FindBy(xpath="//ion-col[4]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]")
	private WebElement getBuisnessPartnerFromInvoiceBill;
	public WebElement getBuisnessPartnerFromInvoiceBill() {
		return getBuisnessPartnerFromInvoiceBill;
	}
	@FindBy(xpath="//ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]")
	private WebElement getBuisnessPartnerFromInvoiceBillAgainstPo;
	public WebElement getBuisnessPartnerFromInvoiceBillAgainstPo(){
		return getBuisnessPartnerFromBillInvoiceAgainstPo;
	}
	@FindBy(xpath="//ion-col[5]/ion-item/ion-input/input[@class=\"native-input sc-ion-input-md\"]")
	private WebElement getInvoiceNumber;
	public WebElement getInvoiceNumber() {
		return getInvoiceNumber;
	}
	//select eye icon invoice view
	@FindBy(xpath="//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[1]//ion-button[1]")
	public WebElement selectFirstEyeicon;
	public WebElement selectFirstEyeicon() {
		return selectFirstEyeicon;
	}
	//next in page view
	@FindBy(xpath="//datatable-pager[1]/ul[1]/li[8]/a[1]/i[1]")
	private WebElement nextPageInListView;
	public WebElement nextPageInListView() {
		return nextPageInListView;
	}
	////datatable-header-cell[13]/div/ion-input/input
	//get the status of the invoice bill booking
	@FindBy(xpath="//datatable-row-wrapper/datatable-body-row[1]//datatable-body-cell[13]")
	public WebElement statusOfInvoice;
	public WebElement statusOfInvoice(){
		return statusOfInvoice;
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
	// @FindBy(xpath =
	// "//page-ap-bill-booking-update/ion-content/form/ion-grid/ion-row[1]/ion-col[2]/app-kub-lov/span/ng-select/div/div/div[3]/input")
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

	@FindBy(xpath="//datatable-row-wrapper[1]//datatable-body-cell[8]//span")
	public WebElement invoiceBillBooking_TransactionDate;
	public WebElement invoiceBillBookingTransactionDate()
	{
		return invoiceBillBooking_TransactionDate;
	}
	
	@FindBy(xpath = "//input[@placeholder='Search Invoice Status']")
	private WebElement accountPayable_search_invoiceStatus;

	public WebElement accountPayableSearchInvoiceStatus() {
		return accountPayable_search_invoiceStatus;
	}
	
}
