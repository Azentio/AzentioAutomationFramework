package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinancialReporting_TrialBalanceReportObj {
	WebDriver driver;

	public FinancialReporting_TrialBalanceReportObj(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// TrialBalanceReport SUB-MODULE //

	//Trial balance report
	@FindBy(xpath="//div[2]/ion-menu-toggle[4]/ion-item/ion-buttons/ion-button")
	private WebElement FinancialReporting_TrialBalanceReport_TempGridButton; 
	public WebElement FinancialReporting_TrialBalanceReport_TempGridButton()
	{
		return FinancialReporting_TrialBalanceReport_TempGridButton;
		
	}
	
	//Trial balance report summary
	@FindBy(xpath="//div[2]/ion-menu-toggle[5]/ion-item/ion-buttons/ion-button")
	private WebElement FinancialReporting_TrialBalanceReportSummary_TempGridButton; 
	public WebElement FinancialReporting_TrialBalanceReportSummary_TempGridButton()
	{
		return FinancialReporting_TrialBalanceReportSummary_TempGridButton;
		
	}
	
	@FindBy(xpath="//ion-col[1]//input")
	private WebElement FinancialReporting_TrialBalanceReport_BranchCode;
	public WebElement FinancialReporting_TrialBalanceReport_BranchCode()
	{
		return FinancialReporting_TrialBalanceReport_BranchCode;
		
	}
	
	@FindBy(xpath="(//span[@class='input-calendar'])[1]")
	private WebElement FinancialReporting_TrialBalanceReport_TrialBalanceFromDate;
	public WebElement FinancialReporting_TrialBalanceReport_TrialBalanceFromDate()
	{
		return FinancialReporting_TrialBalanceReport_TrialBalanceFromDate;
		
	}
	
	@FindBy(xpath="(//span[@class='input-calendar'])[2]")
	private WebElement FinancialReporting_TrialBalanceReport_TrialBalanceToDate;
	public WebElement FinancialReporting_TrialBalanceReport_TrialBalanceToDate()
	{
		return FinancialReporting_TrialBalanceReport_TrialBalanceToDate;	
	}
	
	@FindBy(xpath="//owl-date-time-calendar/div/button[2]")
	private WebElement FinancialReporting_TrialBalanceReport_NextMonth;
	public WebElement FinancialReporting_TrialBalanceReport_NextMonth()
	{
		return FinancialReporting_TrialBalanceReport_NextMonth;
	}
	
	@FindBy(xpath="//ion-col[4]//input")
	private WebElement FinancialReporting_TrialBalanceReport_Currency;
	public WebElement FinancialReporting_TrialBalanceReport_Currency()
	{
		return FinancialReporting_TrialBalanceReport_Currency;
	}
	
	//currency for Trial balancesummary
	@FindBy(xpath="//ion-col[4]//input")
	private WebElement FinancialReporting_TrialBalanceReport_CurrencyForTrialBalanceSummary;
	public WebElement FinancialReporting_TrialBalanceReport_CurrencyForTrialBalanceSummary()
	{
		return FinancialReporting_TrialBalanceReport_CurrencyForTrialBalanceSummary;
	}
	
	@FindBy(xpath="//ion-toolbar/ion-buttons/ion-button/a")
//	@FindBy(xpath="//ion-toolbar/ion-buttons[1]/ion-button")
	private WebElement FinancialReporting_TrialBalanceReport_ViewButton;
	public WebElement FinancialReporting_TrialBalanceReport_ViewButton()
	{
		return FinancialReporting_TrialBalanceReport_ViewButton;
	}
	
	
//	Trial balance report
	@FindBy(xpath="//div[contains(text(),'TRIAL BALANCE')]")
	private WebElement FinancialReporting_TrialBalanceReport_Report;
	public WebElement FinancialReporting_TrialBalanceReport_Report()
	{
		return FinancialReporting_TrialBalanceReport_Report;
	}	
	
}
