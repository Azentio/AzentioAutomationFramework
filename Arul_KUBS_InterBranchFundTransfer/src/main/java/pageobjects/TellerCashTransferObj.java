package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TellerCashTransferObj {
	WebDriver driver;

	public TellerCashTransferObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath = "//ion-label[contains(text(),' Petty cash ')]")
	private WebElement PettyCashModule;
	public WebElement PettyCashModule() {
			return PettyCashModule;
	}
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/23']")
	private WebElement TellerCashTransferViewList;
	public WebElement TellerCashTransferViewList() {
			return TellerCashTransferViewList;
	}
	@FindBy(xpath = "//ion-fab-button[@id='addBtn']")
	private WebElement TellerCashtransfer_AddIcon;
	public WebElement TellerCashtransfer_AddIcon() {
			return TellerCashtransfer_AddIcon;
	}
	@FindBy(xpath = "//label[contains(text(),' Target Teller ID ')]//following-sibling::ng-select//input")
	private WebElement TellerCashtransfer_TargetTellerID;
	public WebElement TellerCashtransfer_TargetTellerID() {
			return TellerCashtransfer_TargetTellerID;
	}
	@FindBy(xpath = "(//th[contains(text(),'Denom Code')]//ancestor::thead//following-sibling::tbody//input)[1]")
	private WebElement TellerCashtransfer_DenomCode;
	public WebElement TellerCashtransfer_DenomCode() {
			return TellerCashtransfer_DenomCode;
	}
	@FindBy(xpath = "(//th[contains(text(),'Denom Code')]//ancestor::thead//following-sibling::tbody//input)[2]")
	private WebElement TellerCashtransfer_DenomName;
	public WebElement TellerCashtransfer_DenomName() {
			return TellerCashtransfer_DenomName;
	}
	@FindBy(xpath = "(//th[contains(text(),'Denom Code')]//ancestor::thead//following-sibling::tbody//input)[4]")
	private WebElement TellerCashtransfer_Quantity;
	public WebElement TellerCashtransfer_Quantity() {
			return TellerCashtransfer_Quantity;
	}
	@FindBy(xpath = "//ion-icon[@name='add']//parent::ion-button")
	private WebElement TellerCashTransfer_AddNewRowIcon;
	public WebElement TellerCashTransfer_AddNewRowIcon() {
			return TellerCashTransfer_AddNewRowIcon;
	}
	@FindBy(xpath = "//ion-icon[@name='save']//parent::ion-button")
	private WebElement TellerCashTransfer_SaveIcon;
	public WebElement TellerCashTransfer_SaveIcon() {
			return TellerCashTransfer_SaveIcon;
	}
	@FindBy(xpath = "(//ion-button[@ng-reflect-router-link='/tabs/list/datagrid/22'])[1]")
	private WebElement TellerCashTransferTempView;
	public WebElement TellerCashTransferTempView() {
			return TellerCashTransferTempView;
	}
	@FindBy(xpath = "//ion-buttons[@class='buttons-last-slot sc-ion-buttons-md-h sc-ion-buttons-md-s md hydrated']")
	private WebElement TellerCashTransferSearchIcon;
	public WebElement TellerCashTransferSearchIcon() {
	return TellerCashTransferSearchIcon;
	}
	@FindBy(xpath = "//ion-input[@ng-reflect-placeholder='Search Transfer Amount']//input")
	private WebElement TellerCashTransfer_TransferAmountSearchField;
	public WebElement TellerCashTransfer_TransferAmountSearchField() {
	return TellerCashTransfer_TransferAmountSearchField;
	}
	@FindBy(xpath = "//ion-input[@ng-reflect-placeholder='Search Transaction Ref No']//input")
	private WebElement TellerCashTransfer_TransactionRefNoSearchField;
	public WebElement TellerCashTransfer_TransactionRefNoSearchField() {
	return TellerCashTransfer_TransactionRefNoSearchField;
	}
	@FindBy(xpath = "//div[contains(text(),'No data to display')]")
	private WebElement TellerCashTransfer_NoDataText;
	public WebElement TellerCashTransfer_NoDataText() {
	return TellerCashTransfer_NoDataText;
	}
	@FindBy(xpath = "//ion-segment/ion-segment-button[3]")
	private WebElement ReportSegment;
	public WebElement ReportSegment() {
	return ReportSegment;
	}
	@FindBy(xpath = "//ion-label[contains(text(),' Financial reporting ')]")
	private WebElement FinancialReporting;
	public WebElement FinancialReporting() {
	return FinancialReporting;
	}
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='tabs/entities/financial-transa']")
	private WebElement FinancialTransactionReport;
	public WebElement FinancialTransactionReport() {
	return FinancialTransactionReport;
	}
	@FindBy(xpath = "//label[contains(text(),' Branch ')]//following-sibling::ng-select//input")
	private WebElement FinancialTransactionReport_BranchDropdown;
	public WebElement FinancialTransactionReport_BranchDropdown() {
	return FinancialTransactionReport_BranchDropdown;
	}
	@FindBy(xpath = "//label[contains(text(),' Report Type ')]//following-sibling::ng-select//input")
	private WebElement FinancialTransactionReport_ReportTypeDropdown;
	public WebElement FinancialTransactionReport_ReportTypeDropdown() {
	return FinancialTransactionReport_ReportTypeDropdown;
	}
	@FindBy(xpath = "//ion-button[@class='ion-color ion-color-primary md button button-clear in-toolbar ion-activatable ion-focusable hydrated']")
	private WebElement FinancialTransactionReport_ViewButton;
	public WebElement FinancialTransactionReport_ViewButton() {
	return FinancialTransactionReport_ViewButton;
	}
	@FindBy(xpath = "//input[@title='Next page']")
	private WebElement FinancialTransactionReport_NextButton;
	public WebElement FinancialTransactionReport_NextButton() {
	return FinancialTransactionReport_NextButton;
	}
	@FindBy(xpath = "(//div[contains(text(),'TL_')])[1]")
	private WebElement FinancialTransactionReport_TellerCashTransferText;
	public WebElement FinancialTransactionReport_TellerCashTransferText() {
	return FinancialTransactionReport_TellerCashTransferText;
	}
}
