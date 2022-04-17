package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GeneralLedger2_JournalVoucherObj {
	WebDriver driver;

	public GeneralLedger2_JournalVoucherObj(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//	Journal Voucher Submodule
	
	// General Ledger Transaction Menu
	@FindBy(xpath = "//ion-label[contains(text(),'General ledger transaction')]")
	private WebElement GeneralLedger2_JournalVoucher_GeneralLedgerTransactionMenu;

	public WebElement GeneralLedger2_JournalVoucher_GeneralLedgerTransactionMenu() {
		return GeneralLedger2_JournalVoucher_GeneralLedgerTransactionMenu;
	}
	
	// Journal Voucher eye button
	@FindBy(xpath = "//div[1]//ion-menu-toggle[1]//ion-item//ion-buttons//ion-button[2]")
	private WebElement GeneralLedger2_JournalVoucher_JournalVoucherEyeButton;
	
	public WebElement GeneralLedger2_JournalVoucher_JournalVoucherEyeButton() {
		return GeneralLedger2_JournalVoucher_JournalVoucherEyeButton;
	}
	
	// Record eyebutton to get the voucher number
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[1]/div/ion-buttons/ion-button[1]")
	private WebElement GeneralLedger2_JournalVoucher_RecordVoucherNumberEyeButton;
	
	public WebElement GeneralLedger2_JournalVoucher_RecordVoucherNumberEyeButton() {
		return GeneralLedger2_JournalVoucher_RecordVoucherNumberEyeButton;
	}
	
	// Record eyebutton to get the voucher number
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row//div[2]/datatable-body-cell[2]/div/app-kub-lov/ion-select/input")
	private WebElement GeneralLedger2_JournalVoucher_GLCode;
	
	public WebElement GeneralLedger2_JournalVoucher_GLCode() {
		return GeneralLedger2_JournalVoucher_GLCode;
	}

}
