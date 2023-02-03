package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankReconciliation_ModuleObj {
	public WebDriver driver;
	public BankReconciliation_ModuleObj(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Job execution
	@FindBy(xpath="//ion-label[text()='Configuration']")
	private WebElement configurationSelect;
	public WebElement configurationSelect() {
		return configurationSelect;
	}
	@FindBy(xpath = "//custom-side-menu/ion-select")
	private WebElement maker_Finance_Option;

	public WebElement maker_Finance_Option() {
		return maker_Finance_Option;
	}
	@FindBy(xpath="//ion-label[text()=' Job scheduler ']")
	private WebElement jobScheduler;
	public WebElement jobScheduler() {
		return jobScheduler;
	}
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/entities/job-start/']")
	private WebElement jobExecutionTempView;
	public WebElement jobExecutionTempView() {
		return jobExecutionTempView;
	}
	@FindBy(xpath="//ion-button[contains(text(),'Start Job')]")
	private WebElement startJob;
	public WebElement startJob() {
		return startJob;
	}
	@FindBy(xpath = "//form[1]/ion-grid[1]/ion-row[1]/div[1]/ion-col[1]/ion-button[2]")
	private WebElement jobExecutionRefreshButton;

		public WebElement jobExecutionRefreshButton() {
	return jobExecutionRefreshButton;}	
	
	@FindBy(xpath="//ion-segment/ion-segment-button[2]")
	private WebElement optionicon;
	public WebElement optionicon() {
		return optionicon;
	}
	// bank recon
	@FindBy(xpath="//ion-label[text()=' Bank recon ']")
	private WebElement bankReconModule;
	public WebElement bankReconModule() {
		return bankReconModule;
	}
	@FindBy(xpath="//ion-label[text()=' Bank reconcilliation ']//following-sibling::ion-buttons/ion-button[2]")//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/9']")
	private WebElement bankRecon_EyeIcon;
	public WebElement bankRecon_EyeIcon() {
		return bankRecon_EyeIcon;
	}
	@FindBy(xpath="//ion-fab-button[1]/ion-icon[1]")
	private WebElement addIconInBankRecon;
	public WebElement addIconInBankRecon() {
		return addIconInBankRecon;
	}
	@FindBy(xpath="//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div/div/input")
	private WebElement selectBankName;
	public WebElement selectBankName() {
		return selectBankName;
	}
	@FindBy(xpath="//ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement selectAccountNumber;
	public WebElement selectAccountNumber() {
		return selectAccountNumber;
	}
	@FindBy(xpath = "(//span[@class='input-calendar'])[1]")
	private WebElement bankRecon_FromDate;

	public WebElement bankRecon_FromDate() {

		return bankRecon_FromDate;
	}
	@FindBy(xpath = "(//span[@class='input-calendar'])[2]")
	private WebElement bankRecon_ToDate;

	public WebElement bankRecon_ToDate() {

		return bankRecon_ToDate;
	}
	@FindBy(xpath="//input[@type='file']")
	private WebElement chooseFile;
	public WebElement chooseFile() {
		return chooseFile;
	}
	
	@FindBy(xpath="//page-bank-recon-details-update[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1]")
	private WebElement saveButtonInBankRecon;
	public WebElement saveButtonInBankRecon() {
		return saveButtonInBankRecon;
	}
	
	@FindBy(xpath="//ion-button[contains(text(),'Process')]")
	private WebElement bankProcess;
	public WebElement bankProcess() {
		return bankProcess;
	}
	@FindBy(xpath="//ion-label[text()=' Unmatched Data ']")
	private WebElement unmatchedData;
	public WebElement unmatchedData() {
		return unmatchedData;
	}
	@FindBy(xpath="//ion-label[contains(text(),'Bank Reconciliation Statement')]")
	private WebElement bankStatement;
	public WebElement bankStatement() {
		return bankStatement;
	}
	@FindBy(xpath="//b[contains(text(),'Adjusted Balance as per Book')]")
	private WebElement AdjustedBalance;
	public WebElement AdjustedBalance() {
		return AdjustedBalance;
	}
	@FindBy(xpath="//ion-infinite-scroll[1]/ion-row[2]/ion-col[1]/ion-grid[1]/ion-row[1]/ion-col[3]/ion-label[1]")
	private WebElement adjustedBalanceAmountInBankStatement;
	public WebElement adjustedBalanceAmountInBankStatement() {
		return adjustedBalanceAmountInBankStatement;
	}
	@FindBy(xpath="//ion-infinite-scroll[1]/ion-row[2]/ion-col[2]/ion-grid[1]/ion-row[1]/ion-col[3]/ion-label[1]")
	private WebElement adjustedBalanceAsPerBook;
	public WebElement adjustedBalanceAsPerBook() {
		return adjustedBalanceAsPerBook;
	}
	@FindBy(xpath="(//input[@id='saveCheckBox'])[1]")
	private WebElement clickFirstCheckboxInBookRecord;
	public WebElement clickFirstCheckboxInBookRecord() {
		return clickFirstCheckboxInBookRecord;
	}
	@FindBy(xpath="(//input[@id='saveCheckBox'])[5]")
	private WebElement clickFirstCheckInBankStatement;
	public WebElement clickFirstCheckInBankStatement() {
		return clickFirstCheckInBankStatement;
	} 
	@FindBy(xpath="(//app-kub-lov/ion-select)[1]")
	private WebElement clickFirstVerifyInBookRecord;
	public WebElement clickFirstVerifyInBookRecord() {
		return clickFirstVerifyInBookRecord;
	}
	@FindBy(xpath="(//ion-radio)[2]")
	private WebElement clickYesInSelectButton;
	public WebElement clickYesInSelectButton() {
		return clickYesInSelectButton;
	} 
	@FindBy(xpath="//ion-button[contains(text(),'Match')]")
	private WebElement clickMatch;
	public WebElement clickMatch() {
		return clickMatch;
	}
	@FindBy(xpath="//ion-label[contains(text(),'Matched Data')]")
	private WebElement matchedData;
	public WebElement matchedData() {
		return matchedData;
	}
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid/8']")
	private WebElement bankReconModuleTempView;
	public WebElement bankReconModuleTempView() {
		return bankReconModuleTempView;
	}
	@FindBy(xpath="//datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[1]/div[1]/ion-buttons[1]/ion-button[1]")
	private WebElement clickFirstRecordInTempView;
	public WebElement clickFirstRecordInTempView() {
		return clickFirstRecordInTempView;
	}
	@FindBy(xpath="//ion-button[contains(text(),'UnMatch')]")
	private WebElement clickUnmatch;
	public WebElement clickUnmatch() {
		return clickUnmatch;
	}
	@FindBy(xpath="//ion-label[contains(text(),'Bank Reconciliation Process')]")
	private WebElement bankReconciliationProcess;
	public WebElement bankReconciliationProcess() {
		return bankReconciliationProcess;
	}
	@FindBy(xpath="//ion-grid[1]//ion-col[2]//ng-select/div/div/div/input")
	private WebElement bankReconciliationBasis;
	public WebElement bankReconciliationBasis() {
		return bankReconciliationBasis;
	}
	
}
