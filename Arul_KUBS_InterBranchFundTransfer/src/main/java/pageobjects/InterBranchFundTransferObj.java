package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InterBranchFundTransferObj {
	WebDriver driver;

	public InterBranchFundTransferObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath = "(//ion-button[@ng-reflect-router-link=\"/tabs/list/datagrid-view/11\"])[1]")
	private WebElement InterBranchFundTrnsferEyeIcon;
	public WebElement InterBranchFundTrnsferEyeIcon() {
			return InterBranchFundTrnsferEyeIcon;
	}
	@FindBy(xpath = "(//ion-button[@ng-reflect-router-link='/tabs/list/datagrid/10'])[1]")
	private WebElement InterBranchFundTrnsferTempView;
	public WebElement InterBranchFundTrnsferTempView() {
			return InterBranchFundTrnsferTempView;
	}
	@FindBy(xpath = "//ion-fab-button[@id='addBtn']")
	private WebElement InterBranchFundTrnsfer_AddIcon;
	public WebElement InterBranchFundTrnsfer_AddIcon() {
			return InterBranchFundTrnsfer_AddIcon;
	}
	@FindBy(xpath = "//label[contains(text(),'  Mode Of Payment  ')]//following-sibling::ng-select//input")
	private WebElement InterBranchFundTrnsfer_ModeOfPayment;
	public WebElement InterBranchFundTrnsfer_ModeOfPayment() {
			return InterBranchFundTrnsfer_ModeOfPayment;
	}
	@FindBy(xpath = "//ion-label[contains(text(),'Instrument No ')]//following-sibling::ion-input//input")
	private WebElement InterBranchFundTrnsfer_InstrumentNo;
	public WebElement InterBranchFundTrnsfer_InstrumentNo() {
			return InterBranchFundTrnsfer_InstrumentNo;
	}
	@FindBy(xpath = "(//span[contains(text(),'Amount')]//ancestor::thead//following-sibling::tbody//input[1])[1]")
	private WebElement InterBranchFundTrnsfer_DRAndCR1Field;
	public WebElement InterBranchFundTrnsfer_DRAndCR1Field() {
			return InterBranchFundTrnsfer_DRAndCR1Field;
	}
	@FindBy(xpath = "(//span[contains(text(),'Amount')]//ancestor::thead//following-sibling::tbody//input[1])[2]")
	private WebElement InterBranchFundTrnsfer_BranchCode1Field;
	public WebElement InterBranchFundTrnsfer_BranchCode1Field() {
			return InterBranchFundTrnsfer_BranchCode1Field;
	}
	@FindBy(xpath = "(//span[contains(text(),'Amount')]//ancestor::thead//following-sibling::tbody//input[1])[3]")
	private WebElement InterBranchFundTrnsfer_GLCode1Field;
	public WebElement InterBranchFundTrnsfer_GLCode1Field() {
			return InterBranchFundTrnsfer_GLCode1Field;
	}
	@FindBy(xpath = "(//span[contains(text(),'Amount')]//ancestor::thead//following-sibling::tbody//input[1])[4]")
	private WebElement InterBranchFundTrnsfer_AmountField;
	public WebElement InterBranchFundTrnsfer_AmountField() {
			return InterBranchFundTrnsfer_AmountField;
	}
	@FindBy(xpath = "(//span[contains(text(),'Remarks')]//ancestor::thead//following-sibling::tbody//textarea)[1]")
	private WebElement InterBranchFundTrnsfer_RemarksField;
	public WebElement InterBranchFundTrnsfer_RemarksField() {
			return InterBranchFundTrnsfer_RemarksField;
	}
	@FindBy(xpath = "//ion-icon[@name='add']//parent::ion-button")
	private WebElement InterBranchFundTrnsfer_AddNewRowIcon;
	public WebElement InterBranchFundTrnsfer_AddNewRowIcon() {
			return InterBranchFundTrnsfer_AddNewRowIcon;
	}
	@FindBy(xpath = "(//span[contains(text(),'Amount')]//ancestor::thead//following-sibling::tbody//input[1])[5]")
	private WebElement InterBranchFundTrnsfer_DRAndCR2Field;
	public WebElement InterBranchFundTrnsfer_DRAndCR2Field() {
			return InterBranchFundTrnsfer_DRAndCR2Field;
	}
	@FindBy(xpath = "(//span[contains(text(),'Amount')]//ancestor::thead//following-sibling::tbody//input[1])[6]")
	private WebElement InterBranchFundTrnsfer_BranchCode2Field;
	public WebElement InterBranchFundTrnsfer_BranchCode2Field() {
			return InterBranchFundTrnsfer_BranchCode2Field;
	}
	@FindBy(xpath = "(//span[contains(text(),'Amount')]//ancestor::thead//following-sibling::tbody//input[1])[7]")
	private WebElement InterBranchFundTrnsfer_GLCode2Field;
	public WebElement InterBranchFundTrnsfer_GLCode2Field() {
			return InterBranchFundTrnsfer_GLCode2Field;
	}
	@FindBy(xpath = "(//span[contains(text(),'Amount')]//ancestor::thead//following-sibling::tbody//input[1])[8]")
	private WebElement InterBranchFundTrnsfer_Amount2Field;
	public WebElement InterBranchFundTrnsfer_Amount2Field() {
			return InterBranchFundTrnsfer_Amount2Field;
	}
	@FindBy(xpath = "(//span[contains(text(),'Remarks')]//ancestor::thead//following-sibling::tbody//textarea)[2]")
	private WebElement InterBranchFundTrnsfer_Remarks2Field;
	public WebElement InterBranchFundTrnsfer_Remarks2Field() {
			return InterBranchFundTrnsfer_Remarks2Field;
	}
	@FindBy(xpath = "//ion-icon[@name='save']//parent::ion-button")
	private WebElement InterBranchFundTrnsfer_SaveIcon;
	public WebElement InterBranchFundTrnsfer_SaveIcon() {
			return InterBranchFundTrnsfer_SaveIcon;
	}
	@FindBy(xpath = "//ion-label[contains(text(),' General ledger transaction ')]")
	private WebElement GeneralLedgerTransaction;
	public WebElement GeneralLedgerTransaction() {
			return GeneralLedgerTransaction;
	}
	@FindBy(xpath = "//datatable-body//datatable-row-wrapper[1]//datatable-body-cell[1]//ion-buttons//ion-button[1]")
	private WebElement InterBranchFundTransferViewList_EyeIconofFirstRecord;
	public WebElement InterBranchFundTransferViewList_EyeIconofFirstRecord() {
	return InterBranchFundTransferViewList_EyeIconofFirstRecord;
	}
	
	@FindBy(xpath = "//input[@name='instrumentNo']")
	private WebElement retrieveInstrumentNoInApprovedListView;
	public WebElement retrieveInstrumentNoInApprovedListView() {
	return retrieveInstrumentNoInApprovedListView;
	}
	@FindBy(xpath = "//span[contains(text(),'Return')]")
	private WebElement ReturnButtonInChecker;
	public WebElement ReturnButtonInChecker() {
	return ReturnButtonInChecker;
	}
	@FindBy(xpath = "//span[contains(text(),'Reject')]")
	private WebElement RejectButtonInChecker;
	public WebElement RejectButtonInChecker() {
	return RejectButtonInChecker;
	}
	@FindBy(xpath = "//span[contains(text(),'ViewSummary')]")
	private WebElement ViewSummaryLink;
	public WebElement ViewSummaryLink() {
	return ViewSummaryLink;
	}
	@FindBy(xpath = "//ionic-title[contains(text(),' Transaction Summary ')]")
	private WebElement TransactionSummaryTextinViewSummary;
	public WebElement TransactionSummaryTextinViewSummary() {
	return TransactionSummaryTextinViewSummary;
	}
	@FindBy(xpath = "(//ion-button[@class='md button button-clear in-toolbar ion-activatable ion-focusable hydrated'])[2]")
	private WebElement BackButton;
	public WebElement BackButton() {
	return BackButton;
	}
	@FindBy(xpath = "//ion-buttons[@class='buttons-last-slot sc-ion-buttons-md-h sc-ion-buttons-md-s md hydrated']")
	private WebElement InterBranchFundTransferSearchIcon;
	public WebElement InterBranchFundTransferSearchIcon() {
	return InterBranchFundTransferSearchIcon;
	}
	@FindBy(xpath = "//ion-input[@ng-reflect-placeholder='Search Dr Amount']//input")
	private WebElement InterBranchFundTransfer_DrAmountSearchField;
	public WebElement InterBranchFundTransfer_DrAmountSearchField() {
	return InterBranchFundTransfer_DrAmountSearchField;
	}
	@FindBy(xpath = "//div[contains(text(),'No data to display')]")
	private WebElement InterBranchFundTransfer_NoDataText;
	public WebElement InterBranchFundTransfer_NoDataText() {
	return InterBranchFundTransfer_NoDataText;
	}

}
