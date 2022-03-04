package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPayable_InvoiceBookingObj {
	WebDriver driver;

	public AccountPayable_InvoiceBookingObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}


	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/151']")
	private WebElement accountsPayable_InvoiceBooking_EyeButton;

	public WebElement accountsPayable_InvoiceBooking_EyeButton() {
		return accountsPayable_InvoiceBooking_EyeButton;

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

		// AP invoice against expence
		@FindBy(xpath = "//span[2]/ion-tab-button/ion-label")
		private WebElement accountPayable_InvoiceBooking_APInvoiceAgainstExpense;
		
		public WebElement accountPayable_InvoiceBooking_APInvoiceAgainstExpense() {
			return accountPayable_InvoiceBooking_APInvoiceAgainstExpense;
		}
		// Tax Details button
		@FindBy(xpath = "//datatable-body-cell[12]/div/ion-buttons/ion-button")
		private WebElement accountPayable_InvoiceBooking_TaxDetails;
		
		public WebElement accountPayable_InvoiceBooking_TaxDetails() {
			return accountPayable_InvoiceBooking_TaxDetails;
		}
		// Tax Details CloseButton
		@FindBy(xpath = "//page-tax-details-po-update/ion-header/ion-toolbar/ion-buttons/ion-button[2]")
//		@FindBy(xpath = "(//ion-toolbar/ion-buttons/ion-button[2])[2]")
		private WebElement accountPayable_InvoiceBooking_TaxDetailsCloseButton;
		
		public WebElement accountPayable_InvoiceBooking_TaxDetailsCloseButton() {
			return accountPayable_InvoiceBooking_TaxDetailsCloseButton;
		}
		
		

	}





