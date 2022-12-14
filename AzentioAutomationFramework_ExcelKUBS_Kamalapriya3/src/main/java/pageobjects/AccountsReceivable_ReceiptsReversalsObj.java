package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsReceivable_ReceiptsReversalsObj {
	WebDriver driver;

	public AccountsReceivable_ReceiptsReversalsObj(WebDriver driver) {

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

	// eye button of receipts
	@FindBy(xpath = "//div[5]//ion-menu-toggle[4]//ion-item//ion-buttons//ion-button[2]")
	private WebElement accountsReceivable_Receipts_EyeButton;

	public WebElement accountsReceivable_Receipts_EyeButton() {
		return accountsReceivable_Receipts_EyeButton;
	}
	
	// Search icon
	@FindBy(xpath = "(//ion-buttons/ion-item/ion-icon)[2]")
	private WebElement accountsReceivable_Receipts_Search;

	public WebElement accountsReceivable_Receipts_Search() {
		return accountsReceivable_Receipts_Search;
	}

	// Search & get txn number using recept type
	@FindBy(xpath = "//datatable-header-cell[5]/div/ion-input/input")
	private WebElement accountsReceivable_Receipts_ReceiptType;

	public WebElement accountsReceivable_Receipts_ReceiptType() {
		return accountsReceivable_Receipts_ReceiptType;
	}
	
	// Search & get txn number using recept Number
	@FindBy(xpath = "//datatable-header-cell[4]/div/ion-input/input")
	private WebElement accountsReceivable_Receipts_ReceiptNumber;
	
	public WebElement accountsReceivable_Receipts_ReceiptNumber() {
		return accountsReceivable_Receipts_ReceiptNumber;
	}
	
	// Get txn number using recept Type & Number
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[3]/div/span")
	private WebElement accountsReceivable_Receipts_TxnNumber;
	
	public WebElement accountsReceivable_Receipts_TxnNumber() {
		return accountsReceivable_Receipts_TxnNumber;
	}
	
	// eye button of receipts reversals
	@FindBy(xpath = "//div[5]//ion-menu-toggle[5]//ion-item//ion-buttons//ion-button[2]")
	private WebElement accountsReceivable_ReceiptsReversals_EyeButton;
	
	public WebElement accountsReceivable_ReceiptsReversals_EyeButton() {
		return accountsReceivable_ReceiptsReversals_EyeButton;
	}

	// add button
	@FindBy(xpath = "//ion-fab-button[@id='addBtn']")
	private WebElement accountsReceivable_ReceiptsReversals_AddButton;

	public WebElement accountsReceivable_ReceiptsReversals_AddButton() {
		return accountsReceivable_ReceiptsReversals_AddButton;
	}
	
	// ReceiptReferenceNumber
	@FindBy(xpath = "//ion-col[3]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement accountsReceivable_ReceiptsReversals_ReceiptReferenceNumber;
	
	public WebElement accountsReceivable_ReceiptsReversals_ReceiptReferenceNumber() {
		return accountsReceivable_ReceiptsReversals_ReceiptReferenceNumber;
	}
	
	// CancellationRemarks
	@FindBy(xpath = "//ion-col[6]/ion-item/ion-input/input")
	private WebElement accountsReceivable_ReceiptsReversals_CancellationRemarks;
	
	public WebElement accountsReceivable_ReceiptsReversals_CancellationRemarks() {
		return accountsReceivable_ReceiptsReversals_CancellationRemarks;
	}
	
	// Actions button
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell/div/ion-buttons/ion-button")
	private WebElement accountsReceivable_ReceiptsReversals_ActionButton;
	
	public WebElement accountsReceivable_ReceiptsReversals_ActionButton() {
		return accountsReceivable_ReceiptsReversals_ActionButton;
	}
	
	// Initiate button
	@FindBy(xpath = "//ion-buttons/app-kub-decision-button/ion-button")
	private WebElement accountsReceivable_ReceiptsReversals_InitiateButton;
	
	public WebElement accountsReceivable_ReceiptsReversals_InitiateButton() {
		return accountsReceivable_ReceiptsReversals_InitiateButton;
	}

}
