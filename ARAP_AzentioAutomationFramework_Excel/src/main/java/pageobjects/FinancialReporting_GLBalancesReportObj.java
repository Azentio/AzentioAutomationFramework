package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinancialReporting_GLBalancesReportObj {
	WebDriver driver;

	public FinancialReporting_GLBalancesReportObj(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// GLBalancesReport SUB-MODULE //

	@FindBy(xpath = "//ion-segment[1]/ion-segment-button[3]")
	private WebElement FinancialReporting_GLBalancesReport_ReportIcon;

	public WebElement FinancialReporting_GLBalancesReport_ReportIcon() {
		return FinancialReporting_GLBalancesReport_ReportIcon;
	}

	@FindBy(xpath="//ion-label[contains(text(),'Financial reporting')]")
	private WebElement FinancialReportingMenu;
	public WebElement FinancialReportingMenu()
	{
		return FinancialReportingMenu;
		
	}
	
	//GL balances report
	@FindBy(xpath="//div[2]/ion-menu-toggle[2]/ion-item/ion-buttons/ion-button")
	private WebElement FinancialReporting_GLBalancesReport_TempGridButton; 
	public WebElement FinancialReporting_GLBalancesReport_TempGridButton()
	{
		return FinancialReporting_GLBalancesReport_TempGridButton;
		
	}
	
	//GL Monthly balances report
	@FindBy(xpath="//div[2]/ion-menu-toggle[3]/ion-item/ion-buttons/ion-button")
	private WebElement FinancialReporting_GLMonthlyBalancesReport_TempGridButton; 
	public WebElement FinancialReporting_GLMonthlyBalancesReport_TempGridButton()
	{
		return FinancialReporting_GLMonthlyBalancesReport_TempGridButton;
		
	}
	
	@FindBy(xpath="//ion-col[1]//input")
	private WebElement FinancialReporting_GLBalancesReport_BranchCode;
	public WebElement FinancialReporting_GLBalancesReport_BranchCode()
	{
		return FinancialReporting_GLBalancesReport_BranchCode;
		
	}

	@FindBy(xpath="//ion-col[3]//input")
	private WebElement FinancialReporting_GLBalancesReport_GlCode;
	public WebElement FinancialReporting_GLBalancesReport_GlCode()
	{
		return FinancialReporting_GLBalancesReport_GlCode;
		
	}
	
	@FindBy(xpath="(//span[@class='input-calendar'])[1]")
	private WebElement FinancialReporting_GLBalancesReport_GLBalancesFromDate;
	public WebElement FinancialReporting_GLBalancesReport_GLBalancesFromDate()
	{
		return FinancialReporting_GLBalancesReport_GLBalancesFromDate;
		
	}
	
	@FindBy(xpath="(//span[@class='input-calendar'])[2]")
	private WebElement FinancialReporting_GLBalancesReport_GLBalancesToDate;
	public WebElement FinancialReporting_GLBalancesReport_GLBalancesToDate()
	{
		return FinancialReporting_GLBalancesReport_GLBalancesToDate;	
	}
	
	@FindBy(xpath="//owl-date-time-calendar/div/button[2]")
	private WebElement FinancialReporting_GLBalancesReport_NextMonth;
	public WebElement FinancialReporting_GLBalancesReport_NextMonth()
	{
		return FinancialReporting_GLBalancesReport_NextMonth;
	}
	
	@FindBy(xpath="//ion-col[5]//input")
	private WebElement FinancialReporting_GLBalancesReport_Currency;
	public WebElement FinancialReporting_GLBalancesReport_Currency()
	{
		return FinancialReporting_GLBalancesReport_Currency;
	}
	// Currency For Monthly
	@FindBy(xpath="//ion-col[5]//input")
	private WebElement FinancialReporting_GLBalancesReport_CurrencyForMonthly;
	public WebElement FinancialReporting_GLBalancesReport_CurrencyForMonthly()
	{
		return FinancialReporting_GLBalancesReport_CurrencyForMonthly;
	}
	
	@FindBy(xpath="//ion-toolbar/ion-buttons/ion-button/a")
	private WebElement FinancialReporting_GLBalancesReport_ViewButton;
	public WebElement FinancialReporting_GLBalancesReport_ViewButton()
	{
		return FinancialReporting_GLBalancesReport_ViewButton;
	}
	
//--------------------------	Balance Sheet Report
	
	// balance sheet report
	@FindBy(xpath="//div[2]/ion-menu-toggle[6]/ion-item/ion-buttons/ion-button")
	private WebElement FinancialReporting_BalanceSheetReport_TempGridButton; 
	public WebElement FinancialReporting_BalanceSheetReport_TempGridButton()
	{
		return FinancialReporting_BalanceSheetReport_TempGridButton;
		
	}
	
	//report type
	@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement FinancialReporting_BalanceSheetReport_ReportType;

	public WebElement FinancialReporting_BalanceSheetReport_ReportType() {
		return FinancialReporting_BalanceSheetReport_ReportType;

	}
	
	// Branch
	@FindBy(xpath="//ion-col[1]/app-kub-lov/span/ng-select/div/div/div[2]//input")
	private WebElement FinancialReporting_BalanceSheetReport_Branch; 
	public WebElement FinancialReporting_BalanceSheetReport_Branch()
	{
		return FinancialReporting_BalanceSheetReport_Branch;
		
	}
	
	// balance sheet date
	@FindBy(xpath="(//span[@class='input-calendar'])[1]")
	private WebElement FinancialReporting_BalanceSheetReport_BalanceSheetAsOnDate; 
	public WebElement FinancialReporting_BalanceSheetReport_BalanceSheetAsOnDate()
	{
		return FinancialReporting_BalanceSheetReport_BalanceSheetAsOnDate;
		
	}
	
	// balance sheet report view button
	@FindBy(xpath="//ion-toolbar/ion-buttons/ion-button/a")
	private WebElement FinancialReporting_BalanceSheetReport_BalanceSheetReportView; 
	public WebElement FinancialReporting_BalanceSheetReport_BalanceSheetReportView()
	{
		return FinancialReporting_BalanceSheetReport_BalanceSheetReportView;
		
	}
	
	// balance sheet report updated data(Post payout approval)
	@FindBy(xpath="//tr[17]/td[1]/div/../../td[2]")
	private WebElement FinancialReporting_BalanceSheetReport_UpdatedData; 
	public WebElement FinancialReporting_BalanceSheetReport_UpdatedData()
	{
		return FinancialReporting_BalanceSheetReport_UpdatedData;
		
	}
	
	// balance sheet report updated data(post approval through online mode)
	@FindBy(xpath="//div[contains(text(),'Cash Equivalents')]/../../td[3]")
//	@FindBy(xpath="//tr[23]/td[1]/div/../../td[2]")
	private WebElement FinancialReporting_BalanceSheetReport_UpdatedDataReceipt; 
	public WebElement FinancialReporting_BalanceSheetReport_UpdatedDataReceipt()
	{
		return FinancialReporting_BalanceSheetReport_UpdatedDataReceipt;
		
	}
	
}
