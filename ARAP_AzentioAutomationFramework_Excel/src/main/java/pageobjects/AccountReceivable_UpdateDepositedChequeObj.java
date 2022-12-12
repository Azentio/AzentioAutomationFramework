package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountReceivable_UpdateDepositedChequeObj {
	
	WebDriver driver;

	public AccountReceivable_UpdateDepositedChequeObj(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);

	}
	
	//Account Receivable Button
		@FindBy(xpath = "//ion-label[text()=' Accounts receivable ']")
		private WebElement accountReceivable_UpdateDepositedCheque__AccountReceivableButton;

		public WebElement accountReceivable_UpdateDepositedCheque__AccountReceivableButton() {
			return accountReceivable_UpdateDepositedCheque__AccountReceivableButton;
		}
		
	//NoteIcon of UpdateDepositedCheque
		@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid/202']")
		private WebElement accountReceivable_UpdateDepositedCheque_NoteIcon;

		public WebElement accountReceivable_UpdateDepositedCheque_NoteIcon() {
			return accountReceivable_UpdateDepositedCheque_NoteIcon;
		}
	//select 1st record
		@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[1]/div[1]/ion-buttons[1]/ion-button[1]")
		private WebElement accountReceivable_UpdateDepositedCheque_FirstRecord;

		public WebElement accountReceivable_UpdateDepositedCheque_FirstRecord() {
			return accountReceivable_UpdateDepositedCheque_FirstRecord;
		}
		
	// ChequeStatus
		@FindBy(xpath = "//ion-row[1]/ion-col[8]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
		private WebElement accountReceivable_UpdateDepositedCheque_ChequeStatus;

		public WebElement accountReceivable_UpdateDepositedCheque_ChequeStatus() {
			return accountReceivable_UpdateDepositedCheque_ChequeStatus;
		}

		// BankCharges
		@FindBy(xpath = "//ion-row[1]/ion-col[9]/ion-item[1]/ion-input[1]/input")
		private WebElement accountReceivable_UpdateDepositedCheque_BankCharges;

		public WebElement accountReceivable_UpdateDepositedCheque_BankCharges() {
			return accountReceivable_UpdateDepositedCheque_BankCharges;
		}
		
		// BouncedReason
		@FindBy(xpath = "//ion-row[1]/ion-col[10]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
		private WebElement accountReceivable_UpdateDepositedCheque_BouncedReason;

		public WebElement accountReceivable_UpdateDepositedCheque_BouncedReason() {
			return accountReceivable_UpdateDepositedCheque_BouncedReason;
		}
		
		//Notification
		@FindBy(xpath = "//ion-header/ion-toolbar[1]/ion-buttons[2]/ion-button[2]")	
		private WebElement accountReceivable_UpdateDepositedCheque_Notification;
		public WebElement accountReceivable_UpdateDepositedCheque_Notification() {
			 return accountReceivable_UpdateDepositedCheque_Notification;
		}

		// Remark field
		@FindBy(xpath = "//ion-row[1]/ion-col[1]/ion-item[1]/ion-textarea[1]/div[1]/textarea[1]")
		private WebElement accountReceivable_UpdateDepositedCheque_RemarkField;

		public WebElement accountReceivable_UpdateDepositedCheque_RemarkField() {
			return accountReceivable_UpdateDepositedCheque_RemarkField;
		}
		
		
	}
