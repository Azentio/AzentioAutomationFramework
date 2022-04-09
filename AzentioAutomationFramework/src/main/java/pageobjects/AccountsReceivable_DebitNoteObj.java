package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsReceivable_DebitNoteObj {
	WebDriver driver;

	public AccountsReceivable_DebitNoteObj(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//	Receipts Reversals SUBMODULE  //
	//Account Receivable Menu
	@FindBy(xpath = "//ion-label[text()=' Accounts receivable ']")
	private WebElement accountsReceivableMenu;

	public WebElement accountsReceivableMenu() {
		return accountsReceivableMenu;
	}

	// eye button of accounts receivable debitenote
	@FindBy(xpath = "//div[5]//ion-menu-toggle[1]//ion-item//ion-buttons//ion-button[2]")
	private WebElement accountsReceivable_DebitNote_EyeButton;

	public WebElement accountsReceivable_DebitNote_EyeButton() {
		return accountsReceivable_DebitNote_EyeButton;
	}
	
	// add button
	@FindBy(xpath = "//ion-fab-button[@id='addBtn']")
	private WebElement accountsReceivable_DebitNote_AddButton;
	
	public WebElement accountsReceivable_DebitNote_AddButton() {
		return accountsReceivable_DebitNote_AddButton;
	}
	
	//Receivable name
	@FindBy(xpath = "//ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement accountsReceivable_DebitNote_ReceivableName;
	
	public WebElement accountsReceivable_DebitNote_ReceivableName() {
		return accountsReceivable_DebitNote_ReceivableName;
	}
	
	//BP NAme
	@FindBy(xpath = "//ion-col[4]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement accountsReceivable_DebitNote_BPName;
	
	public WebElement accountsReceivable_DebitNote_BPName() {
		return accountsReceivable_DebitNote_BPName;
	}
	
	//BP NAme for payment settlement
	@FindBy(xpath = "//ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement accountsReceivable_DebitNote_BPNamePaymentSettlement;
	
	public WebElement accountsReceivable_DebitNote_BPNamePaymentSettlement() {
		return accountsReceivable_DebitNote_BPNamePaymentSettlement;
	}
	
	//invoice number
	@FindBy(xpath = "//ion-col[8]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement accountsReceivable_DebitNote_InvoiceNumber;
	
	public WebElement accountsReceivable_DebitNote_InvoiceNumber() {
		return accountsReceivable_DebitNote_InvoiceNumber;
	}
	
	//debit note amount
	@FindBy(xpath = "//input[@id='debitNoteAmount']")
	private WebElement accountsReceivable_DebitNote_DebitNoteAmount;
	
	public WebElement accountsReceivable_DebitNote_DebitNoteAmount() {
		return accountsReceivable_DebitNote_DebitNoteAmount;
	}
	
	// description
	@FindBy(xpath = "//ion-col[9]/ion-item[1]/ion-input[1]/input[1]")
	private WebElement accountsReceivable_DebitNote_Description;
	
	public WebElement accountsReceivable_DebitNote_Description() {
		return accountsReceivable_DebitNote_Description;
	}
	
	// Save button
	@FindBy(xpath = "(//ion-buttons[2]/ion-button[1])[2]")
	private WebElement accountsReceivable_DebitNote_SaveButton;

	public WebElement accountsReceivable_DebitNote_SaveButton() {
		return accountsReceivable_DebitNote_SaveButton;
	}
	
	// Search icon
	@FindBy(xpath = "(//ion-buttons/ion-item/ion-icon)[2]")
	private WebElement accountsReceivable_DebitNote_Search;

	public WebElement accountsReceivable_DebitNote_Search() {
		return accountsReceivable_DebitNote_Search;
	}

	// Search & get txn number using recept type
	@FindBy(xpath = "//datatable-header-cell[5]/div/ion-input/input")
	private WebElement accountsReceivable_DebitNote_ReceiptType;

	public WebElement accountsReceivable_DebitNote_ReceiptType() {
		return accountsReceivable_DebitNote_ReceiptType;
	}
	
	// Search & get txn number using recept Number
	@FindBy(xpath = "//datatable-header-cell[4]/div/ion-input/input")
	private WebElement accountsReceivable_DebitNote_ReceiptNumber;
	
	public WebElement accountsReceivable_DebitNote_ReceiptNumber() {
		return accountsReceivable_DebitNote_ReceiptNumber;
	}
	
	//get the debit number
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[4]/div[1]/span[1]")
	private WebElement accountsReceivable_DebitNote_LatestDebitNumber;
	
	public WebElement accountsReceivable_DebitNote_LatestDebitNumber() {
		return accountsReceivable_DebitNote_LatestDebitNumber;
	}
	
//	// Get txn number using recept Type & Number
//	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[3]/div/span")
//	private WebElement accountsReceivable_DebitNote_TxnNumber;
//	
//	public WebElement accountsReceivable_DebitNote_TxnNumber() {
//		return accountsReceivable_DebitNote_TxnNumber;
//	}
//
//	
//	// ReceiptReferenceNumber
//	@FindBy(xpath = "//ion-col[3]/app-kub-lov/span/ng-select/div/div/div[2]/input")
//	private WebElement accountsReceivable_DebitNote_ReceiptReferenceNumber;
//	
//	public WebElement accountsReceivable_DebitNote_ReceiptReferenceNumber() {
//		return accountsReceivable_DebitNote_ReceiptReferenceNumber;
//	}
	
	// eye button of PaymentSettlement
	@FindBy(xpath = "//div[3]//ion-menu-toggle[5]//ion-item//ion-buttons//ion-button[2]")
	private WebElement accountPayable_PaymentSettlement_EyeButton;

	public WebElement accountPayable_PaymentSettlement_EyeButton() {
		return accountPayable_PaymentSettlement_EyeButton;
	}

	// add button PaymentSettlement
	@FindBy(xpath = "//ion-fab-button[@id='addBtn']")
	private WebElement accountPayable_PaymentSettlement_AddButton;

	public WebElement accountPayable_PaymentSettlement_AddButton() {
		return accountPayable_PaymentSettlement_AddButton;
	}
	
	// payment option field
	@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement accountPayable_PaymentSettlement_PaymentOption;
	
	public WebElement accountPayable_PaymentSettlement_PaymentOption() {
		return accountPayable_PaymentSettlement_PaymentOption;
	}
	
	// Value Date Calendar
	@FindBy(xpath = "//ion-col[5]/app-kub-date-time/ion-item/div/span[1]")
	private WebElement accountPayable_PaymentSettlement_ValueDateCalendar;

	public WebElement accountPayable_PaymentSettlement_ValueDateCalendar() {
		return accountPayable_PaymentSettlement_ValueDateCalendar;
	}

	// footer
	@FindBy(xpath = "(//datatable-footer)[2]")
	private WebElement accountPayable_PaymentSettlement_Footer;

	public WebElement accountPayable_PaymentSettlement_Footer() {
		return accountPayable_PaymentSettlement_Footer;
	}
	
	// footer
	@FindBy(xpath = "//ion-grid[1]/ngx-datatable[1]/div[1]/datatable-footer[1]/div[1]/datatable-pager[1]/ul[1]/li[8]/a[1]/i[1]")
	private WebElement accountPayable_PaymentSettlement_NextButton;
	
	public WebElement accountPayable_PaymentSettlement_NextButton() {
		return accountPayable_PaymentSettlement_NextButton;
	}
	
	// disabled next button
	@FindBy(xpath = "//li[8][@class='disabled']")
	private WebElement accountPayable_PaymentSettlement_DisabledNextButton;
	
	public WebElement accountPayable_PaymentSettlement_DisabledNextButton() {
		return accountPayable_PaymentSettlement_DisabledNextButton;
	}
	
	// confirm
	@FindBy(xpath = "//span[contains(text(),'Yes')]")
	private WebElement accountPayable_PaymentSettlement_ConfirmYes;
	
	public WebElement accountPayable_PaymentSettlement_ConfirmYes() {
		return accountPayable_PaymentSettlement_ConfirmYes;
	}
	
	// eye button of appropriation
	@FindBy(xpath = "//div[5]//ion-menu-toggle[8]//ion-item//ion-buttons//ion-button[2]")
	private WebElement accountsReceivable_Appropriation_EyeButton;

	public WebElement accountsReceivable_Appropriation_EyeButton() {
		return accountsReceivable_Appropriation_EyeButton;
	}
	
	
}