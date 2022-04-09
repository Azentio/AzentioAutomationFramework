package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GL2_FinancialTransactionReportObj {
	WebDriver driver;

	public GL2_FinancialTransactionReportObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	

	// Financial reporting Button
	@FindBy(xpath = "//ion-label[contains(text(),'Financial reporting')]")
	private WebElement gL2_FinancialTransactionReport_FinancialReport;

	public WebElement gL2_FinancialTransactionReport_FinancialReport() {
		return gL2_FinancialTransactionReport_FinancialReport;
	}
//-----------------FinancialTransactionReport-------------------------------//	

	// FinancialTransactionReport Button
	@FindBy(xpath = "//ion-list[1]/div[2]/ion-menu-toggle[1]/ion-item[1]/ion-buttons[1]/ion-button[1]")
	private WebElement gL2_FinancialTransactionReport;

	public WebElement gL2_FinancialTransactionReport() {
		return gL2_FinancialTransactionReport;
	}

	// Branch
	@FindBy(xpath = "//ion-row[1]/ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement gL2_FinancialTransactionReport_Branch;

	public WebElement gL2_FinancialTransactionReport_Branch() {
		return gL2_FinancialTransactionReport_Branch;
	}

	// GlCode
	@FindBy(xpath = "//ion-row[1]/ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement gL2_FinancialTransactionReport_GlCode;

	public WebElement gL2_FinancialTransactionReport_GlCode() {
		return gL2_FinancialTransactionReport_GlCode;
	}

	// CalendarFromDate
	@FindBy(xpath = "(//span[@class='input-calendar'])[1]")
	private WebElement gL2_FinancialTransactionReport_CalendarFromDate;

	public WebElement gL2_FinancialTransactionReport_CalendarFromDate() {
		return gL2_FinancialTransactionReport_CalendarFromDate;
	}

	// NextMonth
	@FindBy(xpath = "(//button[@type='button'])[3]")
	private WebElement gL2_FinancialTransactionReport_NextMonth;

	public WebElement gL2_FinancialTransactionReport_NextMonth() {
		return gL2_FinancialTransactionReport_NextMonth;
	}

	// CalendarToDate
	@FindBy(xpath = "(//span[@class='input-calendar'])[2]")
	private WebElement gL2_FinancialTransactionReport_CalendarToDate;

	public WebElement gL2_FinancialTransactionReport_CalendarToDate() {
		return gL2_FinancialTransactionReport_CalendarToDate;
	}
	
	//View
	@FindBy(xpath = "//a[contains(text(),'View')]")
	private WebElement gL2_FinancialTransactionReport_View;

	public WebElement gL2_FinancialTransactionReport_View() {
		return gL2_FinancialTransactionReport_View;
	}
//-----------------BalanceSheetReport-------------------------------//	

	// balanceSheetReport Button
	@FindBy(xpath = "//ion-list[1]/div[2]/ion-menu-toggle[6]/ion-item[1]/ion-buttons[1]/ion-button[1]")
	private WebElement gL2_BalanceSheetReport;

	public WebElement gL2_BalanceSheetReport() {
		return gL2_BalanceSheetReport;
	}

	// BranchTextbox
	@FindBy(xpath = "//app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement gL2_BalanceSheetReport_BranchTextbox;

	public WebElement gL2_BalanceSheetReport_BranchTextbox() {
		return gL2_BalanceSheetReport_BranchTextbox;
	}

	// Calendar Button
	@FindBy(xpath = "//span[@class='input-calendar']")
	private WebElement gL2_BalanceSheetReport_CalendarButton;

	public WebElement gL2_BalanceSheetReport_CalendarButton() {
		return gL2_BalanceSheetReport_CalendarButton;
	}

	// NextMonth
	@FindBy(xpath = "(//button[@type='button'])[3]")
	private WebElement gL2_BalanceSheetReport_NextMonth;

	public WebElement gL2_BalanceSheetReport_NextMonth() {
		return gL2_BalanceSheetReport_NextMonth;
	}

	// View Button
	@FindBy(xpath = "//div[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[1]/ion-button[1]")
	private WebElement gL2_BalanceSheetReport_ViewButton;

	public WebElement gL2_BalanceSheetReport_ViewButton() {
		return gL2_BalanceSheetReport_ViewButton;
	}

//-----------------GlMonthlyBalanceReport-------------------------------//	

	// GlMonthlyBalanceReport Button
	@FindBy(xpath = "//ion-list[1]/div[2]/ion-menu-toggle[3]/ion-item[1]/ion-buttons[1]/ion-button[1]")
	private WebElement gL2_GlMonthlyBalanceReport;

	public WebElement gL2_GlMonthlyBalanceReport() {
		return gL2_GlMonthlyBalanceReport;
	}

	// Branch
	@FindBy(xpath = "//ion-row[1]/ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement gL2_GlMonthlyBalanceReport_Branch;

	public WebElement gL2_GlMonthlyBalanceReport_Branch() {
		return gL2_GlMonthlyBalanceReport_Branch;
	}

	// GlCode
	@FindBy(xpath = "//ion-row[1]/ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement gL2_GlMonthlyBalanceReport_GlCode;

	public WebElement gL2_GlMonthlyBalanceReport_GlCode() {
		return gL2_GlMonthlyBalanceReport_GlCode;
	}

	// Calendar
	@FindBy(xpath = "(//span[@class='input-calendar'])[1]")
	private WebElement gL2_GlMonthlyBalanceReport_Calendar;

	public WebElement gL2_GlMonthlyBalanceReport_Calendar() {
		return gL2_GlMonthlyBalanceReport_Calendar;
	}

	// NextMonth
	@FindBy(xpath = "(//button[@type='button'])[3]")
	private WebElement gL2_GlMonthlyBalanceReport_NextMonth;

	public WebElement gL2_GlMonthlyBalanceReport_NextMonth() {
		return gL2_GlMonthlyBalanceReport_NextMonth;
	}

	// Currency
	@FindBy(xpath = "//ion-row[1]/ion-col[4]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement gL2_GlMonthlyBalanceReport_Currency;

	public WebElement gL2_GlMonthlyBalanceReport_Currency() {
		return gL2_GlMonthlyBalanceReport_Currency;
	}
	
	// View
	@FindBy(xpath = "//div[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[1]/ion-button[1]")
	private WebElement gL2_GlMonthlyBalanceReport_View;

	public WebElement gL2_GlMonthlyBalanceReport_View() {
		return gL2_GlMonthlyBalanceReport_View;
	}
		
	// -----------------CashFlowStatementReport--------------------------//

	// CashFlowStatementReport Button
	@FindBy(xpath = "//ion-list[1]/div[2]/ion-menu-toggle[7]/ion-item[1]/ion-buttons[1]/ion-button[1]")
	private WebElement gL2_CashFlowStatementReport;

	public WebElement gL2_CashFlowStatementReport() {
		return gL2_CashFlowStatementReport;
	}

	// Branch
	@FindBy(xpath = "//ion-row[1]/ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement gL2_CashFlowStatementReport_Branch;

	public WebElement gL2_CashFlowStatementReport_Branch() {
		return gL2_CashFlowStatementReport_Branch;
	}

	// Calendar
	@FindBy(xpath = "(//span[@class='input-calendar'])[1]")
	private WebElement gL2_CashFlowStatementReport_Calendar;

	public WebElement gL2_CashFlowStatementReport_Calendar() {
		return gL2_CashFlowStatementReport_Calendar;
	}

	// NextMonth
	@FindBy(xpath = "(//button[@type='button'])[3]")
	private WebElement gL2_CashFlowStatementReport_NextMonth;

	public WebElement gL2_CashFlowStatementReport_NextMonth() {
		return gL2_CashFlowStatementReport_NextMonth;
	}

	// View
	@FindBy(xpath = "//div[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[1]/ion-button[1]")
	private WebElement gL2_CashFlowStatementReport_View;

	public WebElement gL2_CashFlowStatementReport_View() {
		return gL2_CashFlowStatementReport_View;
	}

	// -----------------IncomeStatementReport-------------------------//

	// IncomeStatementReport Button
	@FindBy(xpath = "//ion-list[1]/div[2]/ion-menu-toggle[8]/ion-item[1]/ion-buttons[1]/ion-button[1]")
	private WebElement gL2_IncomeStatementReport;

	public WebElement gL2_IncomeStatementReport() {
		return gL2_IncomeStatementReport;
	}

	// Branch
	@FindBy(xpath = "//ion-row[1]/ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement gL2_IncomeStatementReport_Branch;

	public WebElement gL2_IncomeStatementReport_Branch() {
		return gL2_IncomeStatementReport_Branch;
	}

	// Calendar
	@FindBy(xpath = "(//span[@class='input-calendar'])[1]")
	private WebElement gL2_IncomeStatementReport_Calendar;

	public WebElement gL2_IncomeStatementReport_Calendar() {
		return gL2_IncomeStatementReport_Calendar;
	}

	// NextMonth
	@FindBy(xpath = "(//button[@type='button'])[3]")
	private WebElement gL2_IncomeStatementReport_NextMonth;

	public WebElement gL2_IncomeStatementReport_NextMonth() {
		return gL2_IncomeStatementReport_NextMonth;
	}

	// View
	@FindBy(xpath = "//div[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[1]/ion-button[1]")
	private WebElement gL2_IncomeStatementReport_View;

	public WebElement gL2_IncomeStatementReport_View() {
		return gL2_IncomeStatementReport_View;
	}
//------------------------report------//
	// ReportNext
	@FindBy(xpath = "//tbody/tr[2]/td[7]/input[1]")
	private WebElement gL2_IncomeStatementReport_ReportNext;

	public WebElement gL2_IncomeStatementReport_ReportNext() {

		return gL2_IncomeStatementReport_ReportNext;
	}
		
}
