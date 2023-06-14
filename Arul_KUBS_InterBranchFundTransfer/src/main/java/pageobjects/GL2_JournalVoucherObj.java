package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GL2_JournalVoucherObj {
	WebDriver driver;

	public GL2_JournalVoucherObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	//GeneralLedgerTransaction FIELD
	@FindBy(xpath = "//ion-label[text()=' General ledger transaction '] ")
	private WebElement gL2_JournalVoucher_GeneralLedgerTransaction;

	public WebElement gL2_JournalVoucher_GeneralLedgerTransaction() {
		return gL2_JournalVoucher_GeneralLedgerTransaction;

	}
	//EyeButton
	@FindBy(xpath = "(//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/2'])[1]")
	private WebElement gL2_JournalVoucher_EyeButton;

	public WebElement gL2_JournalVoucher_EyeButton() {
		return gL2_JournalVoucher_EyeButton;

	}
	
	//ADD BUTTON
	@FindBy(xpath = "//ion-fab-button[@id='addBtn']")
	private WebElement gL2_JournalVoucher_AddButton;

	public WebElement gL2_JournalVoucher_AddButton() {
		return gL2_JournalVoucher_AddButton;

	}
	
	//BranchCode
	@FindBy(xpath = "//ion-row[1]/ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement gL2_JournalVoucher_BranchCode;
	public WebElement gL2_JournalVoucher_BranchCode() {
		return gL2_JournalVoucher_BranchCode;

	}

	// Currency
	@FindBy(xpath = "//ion-row[1]/ion-col[6]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement gL2_JournalVoucher_Currency;
	public WebElement gL2_JournalVoucher_Currency() {
		return gL2_JournalVoucher_Currency;

	}
	
	// JournalType
	@FindBy(xpath = "//ion-row[1]/ion-col[7]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement gL2_JournalVoucher_JournalType;
	public WebElement gL2_JournalVoucher_JournalType() {
		return gL2_JournalVoucher_JournalType;
	}
    // Profit Center
		@FindBy(xpath = "//app-kub-lov[@ng-reflect-lov-label='Profit Center']//div/input")
		private WebElement gL2_JournalVoucher_ProfitCenter;
		public WebElement gL2_JournalVoucher_ProfitCenter() {
			return gL2_JournalVoucher_ProfitCenter;
		}
	// Cost Center 
		@FindBy(xpath = "//app-kub-lov[@ng-reflect-lov-label=' Cost Center ']//div/input")
		private WebElement gL2_JournalVoucher_CostCenter;
		public WebElement gL2_JournalVoucher_CostCenter() {
			return gL2_JournalVoucher_CostCenter;
		}
	// department 
		@FindBy(xpath = "//app-kub-lov[@ng-reflect-name='department']//div/input")
		private WebElement gL2_JournalVoucher_Department;
		public WebElement gL2_JournalVoucher_Department() {
			return gL2_JournalVoucher_Department;
		}
	// Remark
	@FindBy(xpath = "//ion-input[@ng-reflect-name='remarks']//input")
	private WebElement gL2_JournalVoucher_Remark;
	public WebElement gL2_JournalVoucher_Remark() {
		return gL2_JournalVoucher_Remark;
	}
	// Journal voucher ref
	@FindBy(xpath = "//ion-input[@name='voucherNo']//input")
	private WebElement gL2_GetJournalVoucherRef;
	public WebElement gL2_GetJournalVoucherRef() {
		return gL2_GetJournalVoucherRef;
	}
	//-------------First record for credit-------//
	// DrCr
	@FindBy(xpath = "//datatable-body-cell[1]/div[1]/app-kub-lov[1]/ion-select[1]")
	private WebElement gL2_JournalVoucher_DrCr;

	public WebElement gL2_JournalVoucher_DrCr() {
		return gL2_JournalVoucher_DrCr;
	}

	// Debit
	@FindBy(xpath = "//div[text()=' Debit ']/preceding-sibling::div")
	private WebElement gL2_JournalVoucher_Debit;

	public WebElement gL2_JournalVoucher_Debit() {
		return gL2_JournalVoucher_Debit;
	}
	
	@FindBy(xpath = "//span[text()='OK']/parent::button")
	private WebElement gL2_JournalVoucher_CreditDebitOk;

	public WebElement gL2_JournalVoucher_CreditDebitOk() {
		return gL2_JournalVoucher_CreditDebitOk;
	}
	// GlCode
	@FindBy(xpath = "//datatable-body-cell[2]/div[1]/app-kub-lov[1]/ion-select[1]")
	private WebElement gL2_JournalVoucher_GlCode;

	public WebElement gL2_JournalVoucher_GlCode() {
		return gL2_JournalVoucher_GlCode;
	}

	// GlCodeDebit Hdfc
	@FindBy(xpath = "//ion-list[1]/ion-radio-group[1]/ion-item[7]/ion-radio[1]")
	private WebElement gL2_JournalVoucher_GlCodeDebit;

	public WebElement gL2_JournalVoucher_GlCodeDebit() {
		return gL2_JournalVoucher_GlCodeDebit;
	}

	// DebitAmount
	@FindBy(xpath = "//input[@id='jvAmount0']")
	private WebElement gL2_JournalVoucher_DebitAmount;

	public WebElement gL2_JournalVoucher_DebitAmount() {
		return gL2_JournalVoucher_DebitAmount;
	}
	
	// Action
	@FindBy(xpath = "//datatable-body-cell/div[1]/ion-button[1]")
	private WebElement gL2_JournalVoucher_ActionButton;

	public WebElement gL2_JournalVoucher_ActionButton() {
		return gL2_JournalVoucher_ActionButton;
	}
	
	//-------------Second record for credit-------//
	// DrCrSecond
	@FindBy(xpath = "(//datatable-body-cell[1]/div[1]/app-kub-lov[1]/ion-select[1])[2]")
	private WebElement gL2_JournalVoucher_DrCrSecond;

	public WebElement gL2_JournalVoucher_DrCrSecond() {
		return gL2_JournalVoucher_DrCrSecond;
	}

	// Credit
	@FindBy(xpath = "//div[text()=' Credit ']/preceding-sibling::div")
	private WebElement gL2_JournalVoucher_Credit;

	public WebElement gL2_JournalVoucher_Credit() {
		return gL2_JournalVoucher_Credit;
	}

	// GlCodeSecond
	@FindBy(xpath = "(//datatable-body-cell[2]/div[1]/app-kub-lov[1]/ion-select[1])[2]")
	private WebElement gL2_JournalVoucher_GlCodeSecond;

	public WebElement gL2_JournalVoucher_GlCodeSecond() {
		return gL2_JournalVoucher_GlCodeSecond;
	}

	// GlCodeCredit EquityCapital
	@FindBy(xpath = "//ion-list[1]/ion-radio-group[1]/ion-item[1]/ion-radio[1]")
	private WebElement gL2_JournalVoucher_GlCodeCredit;

	public WebElement gL2_JournalVoucher_GlCodeCredit() {
		return gL2_JournalVoucher_GlCodeCredit;
	}

	// CreditAmount
	@FindBy(xpath = "//input[@id='jvAmount1']")
	private WebElement gL2_JournalVoucher_CreditAmount;

	public WebElement gL2_JournalVoucher_CreditAmount() {
		return gL2_JournalVoucher_CreditAmount;
	}

	// ActionSecond
	@FindBy(xpath = "(//datatable-body-cell/div[1]/ion-button[1])[2]")
	private WebElement gL2_JournalVoucher_ActionButtonSecond;

	public WebElement gL2_JournalVoucher_ActionButtonSecond() {
		return gL2_JournalVoucher_ActionButtonSecond;
	}
	

	//-------------Third record for credit-------//
	
	// DrCrThird
	@FindBy(xpath = "(//datatable-body-cell[1]/div[1]/app-kub-lov[1]/ion-select[1])[3]")
	private WebElement gL2_JournalVoucher_DrCrThird;

	public WebElement gL2_JournalVoucher_DrCrThird() {
		return gL2_JournalVoucher_DrCrThird;
	}
	///Credit//
	
	// GlCodeThird
	@FindBy(xpath = "(//datatable-body-cell[2]/div[1]/app-kub-lov[1]/ion-select[1])[3]")
	private WebElement gL2_JournalVoucher_GlCodeThird;

	public WebElement gL2_JournalVoucher_GlCodeThird() {
		return gL2_JournalVoucher_GlCodeThird;
	}
	
	//GlCodeCreditSecond Asset
	@FindBy(xpath = "//ion-list[1]/ion-radio-group[1]/ion-item[3]/ion-radio[1]")
	private WebElement gL2_JournalVoucher_GlCodeCreditSecond;

	public WebElement gL2_JournalVoucher_GlCodeCreditSecond() {
		return gL2_JournalVoucher_GlCodeCreditSecond;
	}

	// CreditAmountSecond
	@FindBy(xpath = "//input[@id='jvAmount2']")
	private WebElement gL2_JournalVoucher_CreditAmountSecond;

	public WebElement gL2_JournalVoucher_CreditAmountSecond() {
		return gL2_JournalVoucher_CreditAmountSecond;
	}
	
	
	
	// Save
	@FindBy(xpath = "(//ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1])[2]")
	private WebElement gL2_JournalVoucher_Save;

	public WebElement gL2_JournalVoucher_Save() {
		return gL2_JournalVoucher_Save;
	}
	@FindBy(xpath = "//button[@aria-label='Close']")
	private WebElement costOrDeparmentRequiredClose;

	public WebElement costOrDeparmentRequiredClose() {
		return costOrDeparmentRequiredClose;
	}
	
	
	
}
