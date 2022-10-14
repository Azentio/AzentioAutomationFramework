package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class REPORT_FinancialReportingObj {
	WebDriver driver;
	public REPORT_FinancialReportingObj(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ion-label[contains(text(),'Financial reporting')]")
	private WebElement financiaTransaction_MainMenu;
	public WebElement financialTransactionMainMenu()
	{
		return financiaTransaction_MainMenu;
	}
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='tabs/entities/balance-sheet-re']")
	private WebElement financialReporting_BalanceSheet;
	public WebElement financialReportingBalanceSheet()
	{
		return financialReporting_BalanceSheet;
	}
	@FindBy(xpath="//ion-col[1]//input")
	private WebElement financialreporting_BalanceSheet_BranchName;
	public WebElement financialReportingBalanceSheetBranchName()
	{
		return financialreporting_BalanceSheet_BranchName;
	}
	@FindBy(xpath="//span[@class='input-calendar']")
	private WebElement financialReporting_BalanecSheet_InputCalendar;
	public WebElement financialReportingBalanceSheetInputCalendar()
	{
		return financialReporting_BalanecSheet_InputCalendar;
	}
	@FindBy(xpath="//owl-date-time-calendar[1]/div[1]/div[1]/button[1]")
	private WebElement financialReporting_YearMonth;
	public WebElement financialReprtingYearMonth()
	{
		return financialReporting_YearMonth;
	}

}
