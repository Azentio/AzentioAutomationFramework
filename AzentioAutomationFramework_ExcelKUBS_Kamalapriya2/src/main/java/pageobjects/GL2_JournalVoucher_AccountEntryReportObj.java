package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GL2_JournalVoucher_AccountEntryReportObj {
	WebDriver driver;

	public  GL2_JournalVoucher_AccountEntryReportObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ion-segment[1]/ion-segment-button[3]")
	private WebElement gL2_JournalVoucher_AccountEntryReport_ReportIcon;

	public WebElement gL2_JournalVoucher_AccountEntryReport_ReportIcon() {
		return gL2_JournalVoucher_AccountEntryReport_ReportIcon;
	}
	@FindBy(xpath="//ion-label[contains(text(),'Enquiry')]")
	private WebElement gL2_JournalVoucher_AccountEntryReport_EnquiryMenu;
	public WebElement gL2_JournalVoucher_AccountEntryReport_EnquiryMenu()
	{
		return gL2_JournalVoucher_AccountEntryReport_EnquiryMenu;
		
	}
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/entities/financial-trans']")
	private WebElement gL2_JournalVoucher_AccountEntryReport_FinancialTransactionField; 
	public WebElement gL2_JournalVoucher_AccountEntryReport_FinancialTransactionField()
	{
		return gL2_JournalVoucher_AccountEntryReport_FinancialTransactionField;
		
	}
	@FindBy(xpath="//ion-col[1]//input")
	private WebElement gL2_JournalVoucher_AccountEntryReport_BranchCode;
	public WebElement gL2_JournalVoucher_AccountEntryReport_BranchCode()
	{
		return gL2_JournalVoucher_AccountEntryReport_BranchCode;
		
	}

	@FindBy(xpath="//ion-col[3]//input")
	private WebElement gL2_JournalVoucher_AccountEntryReport_GlCode;
	public WebElement gL2_JournalVoucher_AccountEntryReport_GlCode()
	{
		return gL2_JournalVoucher_AccountEntryReport_GlCode;
		
	}
	@FindBy(xpath="(//span[@class='input-calendar'])[1]")
	private WebElement gL2_JournalVoucher_AccountEntryReport_FromDate;
	public WebElement gL2_JournalVoucher_AccountEntryReport_FromDate()
	{
		return gL2_JournalVoucher_AccountEntryReport_FromDate;
		
	}
	@FindBy(xpath="(//span[@class='input-calendar'])[2]")
	private WebElement gL2_JournalVoucher_AccountEntryReport_ToDate;
	public WebElement gL2_JournalVoucher_AccountEntryReport_ToDate()
	{
		return gL2_JournalVoucher_AccountEntryReport_ToDate;	
	}
	
	@FindBy(xpath="(//button[@type='button'])[3]")
	private WebElement gL2_JournalVoucher_AccountEntryReport_NextMonth;
	public WebElement gL2_JournalVoucher_AccountEntryReport_NextMonth()
	{
		return gL2_JournalVoucher_AccountEntryReport_NextMonth;
	}
	@FindBy(xpath="//ion-button[contains(text(),'View')]")
	private WebElement gL2_JournalVoucher_AccountEntryReport_ViewButton;
	public WebElement gL2_JournalVoucher_AccountEntryReport_ViewButton()
	{
		return gL2_JournalVoucher_AccountEntryReport_ViewButton;
	}
	//(//i[@class='datatable-icon-right'])[2]"
	
	@FindBy(xpath="//li[8]/a/i")
	private WebElement gL2_JournalVoucher_AccountEntryReport_Next;
	public WebElement gL2_JournalVoucher_AccountEntryReport_Next()
	{
		return gL2_JournalVoucher_AccountEntryReport_Next;
	}
	
   //to scroll page at bottom  web element TOTAL
	@FindBy(xpath="//div[contains(text(),'total')]")
	private WebElement gL2_JournalVoucher_AccountEntryReport_Total;
	public WebElement gL2_JournalVoucher_AccountEntryReport_Total()
	{
		return gL2_JournalVoucher_AccountEntryReport_Total;
	}
	

}
