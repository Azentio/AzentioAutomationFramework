package pageobjects;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Petty_Cash_Obj {

	WebDriver driver;

	public Petty_Cash_Obj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Petty_Cash_Expense Code Limit
	@FindBy(xpath = "//ion-label[contains(text(),'Petty cash configuration')]")
	private WebElement Petty_Cash_Configuration;

	public WebElement Petty_Cash_Configuration() {
		return Petty_Cash_Configuration;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/238']")
	private WebElement Petty_Cash_Expense_code_limit;

	public WebElement Petty_Cash_Expense_code_limit() {
		return Petty_Cash_Expense_code_limit;
	}

	@FindBy(xpath = "(//ion-icon[@ng-reflect-name='add'])[1]")
	private WebElement Petty_Cash_Add;

	public WebElement Petty_Cash_Add() {
		return Petty_Cash_Add;
	}

	@FindBy(xpath = "//ion-col[1]/ion-item[1]/ion-input[1]/input[1]")
	private WebElement Petty_Cash_ExpenseCode;

	public WebElement Petty_Cash_ExpenseCode() {
		return Petty_Cash_ExpenseCode;
	}

	@FindBy(xpath = "//ion-col[2]/ion-item[1]/ion-input[1]/input[1]")
	private WebElement Petty_Cash_ExpenseName;

	public WebElement Petty_Cash_ExpenseName() {
		return Petty_Cash_ExpenseName;
	}

	@FindBy(xpath = "//ion-col[5]/ion-item[1]/input[@id='maxLimit']")
	private WebElement Petty_Cash_Max_Limit;

	public WebElement Petty_Cash_Max_Limit() {
		return Petty_Cash_Max_Limit;
	}

	@FindBy(xpath = "//ion-col[3]/app-kub-lov[1]/span[1]//ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement Petty_Cash_Expense_Gl;

	public WebElement Petty_Cash_Expense_Gl() {
		return Petty_Cash_Expense_Gl;
	}

	@FindBy(xpath = "//ion-col[6]/app-kub-lov[1]/span[1]//ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement Petty_Cash_Expense_Currency;

	public WebElement Petty_Cash_Expense_Currency() {
		return Petty_Cash_Expense_Currency;
	}

	@FindBy(xpath = "(//ion-header[1]/ion-toolbar[1]/ion-buttons[2])[3]")
	private WebElement Petty_Cash_Expense_Save;

	public WebElement Petty_Cash_Expense_Save() {
		return Petty_Cash_Expense_Save;
	}

	// Employee Limit

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/40']")
	private WebElement Petty_Cash_Employee_limit;

	public WebElement Petty_Cash_Employee_limit() {
		return Petty_Cash_Employee_limit;
	}

	@FindBy(xpath = "//ion-col[1]/app-kub-lov[1]/span[1]//ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement Petty_Cash_Employee;

	public WebElement Petty_Cash_Employee() {
		return Petty_Cash_Employee;
	}

	@FindBy(xpath = "//ion-col[3]/app-kub-lov[1]/span[1]//ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement Petty_Cash_Employee_Currancy;

	public WebElement Petty_Cash_Employee_Currancy() {
		return Petty_Cash_Employee_Currancy;
	}

	@FindBy(xpath = "//ion-col[2]/ion-item[1]/input[@id='maxAdvanceLimit']")
	private WebElement Petty_Cash_Max_AdvanceLimit;

	public WebElement Petty_Cash_Max_AdvanceLimit() {
		return Petty_Cash_Max_AdvanceLimit;
	}

	// FUND LIMIT

	@FindBy(xpath = "//ion-label[contains(text(),'Petty cash')]")
	private WebElement pettyCashModule;

	public WebElement pettyCashModule() {
		return pettyCashModule;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/15']")
	private WebElement fundRequestEyeIcon;

	public WebElement fundRequestEyeIcon() {
		return fundRequestEyeIcon;
	}

	@FindBy(xpath = "//ion-col[5]//input")
	private WebElement enterRequestAmout;

	public WebElement enterRequestAmout() {
		return enterRequestAmout;
	}

	@FindBy(xpath = "//ion-col[7]//input")
	private WebElement enterRemark;

	public WebElement enterRemark() {
		return enterRemark;
	}

	@FindBy(xpath = "//span[contains(text(),'Approve')]")
	private WebElement fundRequest_Approve;

	public WebElement fundRequest_Approve() {
		return fundRequest_Approve;
	}

	// CUSTODIAN LIMIT

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/38']")
	private WebElement PettyCashConfig_CostodianLimitviewButton;

	public WebElement pettyCashConfigCostodianLimitViewButton() {
		return PettyCashConfig_CostodianLimitviewButton;
	}

	@FindBy(xpath = "//ion-col[1]//input")
	private WebElement costodianLimit_UserName;

	public WebElement costodianLimitUserName() {
		return costodianLimit_UserName;
	}

	@FindBy(xpath = "//input[@id='maxLimit']")
	private WebElement costodianLimit_MaxLimit;

	public WebElement costodianLimitMaxLimit() {
		return costodianLimit_MaxLimit;
	}

	@FindBy(xpath = "//input[@id='floatLimit']")
	private WebElement costodianLimit_ReplenishLimit;

	public WebElement costodianLimitReplenishLimit() {
		return costodianLimit_ReplenishLimit;
	}

	@FindBy(xpath = "//ion-col[4]//input")
	private WebElement constodianLimit_CurrencyType;

	public WebElement costodianLimitCurrencyLimit() {
		return constodianLimit_CurrencyType;
	}

	// REIMBURSEMENT
	
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/17']")
	private WebElement Reimbursement_Eye_Icon;

	public WebElement Reimbursement_Eye_Icon() {
		return Reimbursement_Eye_Icon;
	}

	@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]//ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement Reimbursement_cashMemo;

	public WebElement Reimbursement_cashMemo() {
		return Reimbursement_cashMemo;
	}

	@FindBy(xpath = "//ion-col[3]//input[1]")
	private WebElement Reimbursement_AdvanceAmount;

	public WebElement Reimbursement_AdvanceAmount() {
		return Reimbursement_AdvanceAmount;
	}

	@FindBy(xpath = "//ion-select[@formcontrolname='expenseCode']")
	private WebElement Reimbursement_expenseCode;

	public WebElement Reimbursement_expenseCode() {
		return Reimbursement_expenseCode;
	}

	@FindBy(xpath = "(//ion-select[@formcontrolname='expenseCode'])[2]")
	private WebElement Reimbursement_expenseCode1;

	public WebElement Reimbursement_expenseCode1() {
		return Reimbursement_expenseCode1;
	}
	
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[2]/div[1]/input[1]")
	private WebElement Reimbursement_Reimbursement_Amount;

	public WebElement Reimbursement_Reimbursement_Amount() {
		return Reimbursement_Reimbursement_Amount;
	}

	@FindBy(xpath = "//datatable-row-wrapper[2]/datatable-body-row[1]/div[2]/datatable-body-cell[2]/div[1]/input[1]")
	private WebElement Reimbursement_Reimbursement_Amount1;

	public WebElement Reimbursement_Reimbursement_Amount1() {
		return Reimbursement_Reimbursement_Amount1;
	}
	
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]/input[1]")
	private WebElement Reimbursement_Remark;

	public WebElement Reimbursement_Remark() {
		return Reimbursement_Remark;
	}

	@FindBy(xpath = "//datatable-row-wrapper[2]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]/input[1]")
	private WebElement Reimbursement_Remark1;

	public WebElement Reimbursement_Remark1() {
		return Reimbursement_Remark1;
	}
	
	@FindBy(xpath = "(//ion-radio[1])[1]")
	private WebElement Reimbursement_Expense1;

	public WebElement Reimbursement_Expense1() {
		return Reimbursement_Expense1;
	}

	@FindBy(xpath = "(//ion-radio[1])[2]")
	private WebElement Reimbursement_Expense2;

	public WebElement Reimbursement_Expense2() {
		return Reimbursement_Expense2;
	}
	
	@FindBy(xpath="//datatable-body-cell[4]/div[1]/ion-button[1]")
	private WebElement Reimbursement_ExtraAdd;
	public WebElement Reimbursement_ExtraAdd() {
		return Reimbursement_ExtraAdd;
	}
	
	@FindBy(xpath = "//button[@aria-label='Close']")
	private WebElement ARAP_MakerNotification_Close1;

	public WebElement ARAP_MakerNotification_Close() {

		return ARAP_MakerNotification_Close1;
	}
	//system Date
	@FindBy(xpath = "//span[@class='legal-entity'][1]")
	private WebElement systemDate;

	public WebElement systemDate() {
		return systemDate;
	}
	
	
	
	
}
