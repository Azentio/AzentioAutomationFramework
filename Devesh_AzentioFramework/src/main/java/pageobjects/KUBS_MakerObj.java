package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KUBS_MakerObj {

	WebDriver driver;

	public KUBS_MakerObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//custom-side-menu/ion-select")
	private WebElement maker_finance_option;

	public WebElement kubsFinaceOption() {
		return maker_finance_option;
	}
    @FindBy(xpath="//ion-item[2]/ion-radio")
    private WebElement finance_option;
    public WebElement FinanceOption() {
		return finance_option;
    	
    }
	@FindBy(xpath = "//ion-segment/ion-segment-button[1]")
	private WebElement maker_tool_icon;

	public WebElement kubsToolIcon() {
		return maker_tool_icon;
	}

	@FindBy(xpath = "//ion-segment/ion-segment-button[2]")
	private WebElement maker_direction_icon;

	public WebElement kubsDirectionIcon() {
		return maker_direction_icon;
	}

	@FindBy(xpath = "//ion-label[contains(text(),'Business partner setup')]")
	private WebElement maker_business_partner_setup;

	public WebElement kubsBusinessPartnerSetup() {
		return maker_business_partner_setup;
	}

	@FindBy(xpath = "//ion-label[contains(text(),'Accounting setup')]")
	private WebElement maker_accounting_setup;

	public WebElement kubsAccountingSetup() {
		return maker_accounting_setup;

	}

	@FindBy(xpath = "//ion-label[contains(text(),'General ledger configuration')]")
	private WebElement maker_general_ledger_configuration;

	public WebElement kubsGeneralLedgerConfiguration() {
		return maker_general_ledger_configuration;
	}

	@FindBy(xpath = "//ion-label[contains(text(),'Expense/AR & AP configuration')]")
	private WebElement maker_expense_ar_ap__configuration;

	public WebElement kubsArApExpenseConfiguration() {
		return maker_expense_ar_ap__configuration;

	}

	@FindBy(xpath = "//ion-label[contains(text(),'Budget configuration')]")
	private WebElement maker_budget_configuration;

	public WebElement kubsBudgetConfiguration() {
		return maker_budget_configuration;

	}

	@FindBy(xpath = "//ion-label[contains(text(),'Fixed assets configuration')]")
	private WebElement maker_fixed_assets_configurations;

	public WebElement kubsFixedAssetsConfigurations() {
		return maker_fixed_assets_configurations;

	}

	@FindBy(xpath = "//ion-label[contains(text(),'Inventory maintenance')]")
	private WebElement maker_inventory_maintenance;

	public WebElement kubsInventoryMaintenance() {
		return maker_inventory_maintenance;

	}

	@FindBy(xpath = "//ion-label[contains(text(),'Bank recon')]")
	private WebElement maker_bank_recon;

	public WebElement kubsBankRecon() {
		return maker_bank_recon;

	}

	@FindBy(xpath = "//ion-label[contains(text(),'Petty cash configuration')]")
	private WebElement maker_petty_cash_configuration;

	public WebElement kubsPettyCashConfiguration() {
		return maker_petty_cash_configuration;

	}

	@FindBy(xpath = "//ion-label[contains(text(),'General ledger transaction')]")
	private WebElement maker__general_ledger_transaction;

	public WebElement kubsGeneralLedgerTransaction() {
		return maker__general_ledger_transaction;

	}

	@FindBy(xpath = "//ion-label[text()=' Budget ']")
	private WebElement maker_budget;

	public WebElement kubsBudget() {
		return maker_budget;

	}

	@FindBy(xpath = "//ion-label[contains(text(),' Accounts payable ')]")
	private WebElement maker_accounts_payable;

	public WebElement kubsAccountsPayable() {
		return maker_accounts_payable;

	}

	@FindBy(xpath = "//ion-label[contains(text(),' Adjustments ( AR and AP) ')]")
	private WebElement maker_adjustments_ar_ap;

	public WebElement kubsAdjustmentsArAp() {
		return maker_adjustments_ar_ap;

	}

	@FindBy(xpath = "//ion-label[text()=' Accounts receivable ']")
	private WebElement maker_accounts_receivable;

	public WebElement kubsAccountsReceivable() {
		return maker_accounts_receivable;

	}

	@FindBy(xpath = "//ion-label[contains(text(),'Fixed assets')]")
	private WebElement maker_fixed_assets;

	public WebElement kubsFixedAssets() {
		return maker_fixed_assets;

	}

	@FindBy(xpath = "//ion-label[contains(text(),'Inventory management')]")
	private WebElement maker_inventory_management;

	public WebElement kubsInventoryManagement() {
		return maker_inventory_management;

	}

	@FindBy(xpath = "//ion-label[contains(text(),'Petty cash')]")
	private WebElement maker_petty_cash;

	public WebElement kubsPettyCash() {
		return maker_petty_cash;
	}

	@FindBy(xpath = "//ion-label[text()=' Bank recon ']")
	private WebElement maker_dir_bank_recon;

	public WebElement kubsDirBankRecon() {
		return maker_dir_bank_recon;

	}
	
	// Click on Supplymentary budget eye icon
		@FindBy(xpath = "//ion-label[contains(text(),' Supplementary budget ')]/../ion-buttons/ion-button[2]/ion-icon[@name='eye']")
		private WebElement budget_SupplementaryBudget_SupplementaryBudgetEyeIcon;
		public WebElement budget_SupplementaryBudget_SupplementaryBudgetEyeIcon() {
			return budget_SupplementaryBudget_SupplementaryBudgetEyeIcon;
		}

		// Click on supplymentary budget add button
		@FindBy(xpath = "//ion-icon[@name='add']")
		//@FindBy(xpath = "//ion-title[contains(text(),' Budget Supplementary View ')]/../../../ion-content/ion-fab/ion-fab-button/ion-icon[@name='add']")
		private WebElement budget_SupplementaryBudget_SupplementaryBudgetAddButton;
		public WebElement budget_SupplementaryBudget_SupplementaryBudgetAddButton() {
			return budget_SupplementaryBudget_SupplementaryBudgetAddButton;
		}


}
