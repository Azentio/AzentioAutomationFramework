package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ENQUIRY_FinancialTransactionObj {
	WebDriver driver;

	public ENQUIRY_FinancialTransactionObj(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

// Financial Transaction SUBMODULE  //
	
	@FindBy(xpath = "//ion-segment[1]/ion-segment-button[3]")
	private WebElement ENQUIRY_FinancialTransaction_ReportIcon;

	public WebElement ENQUIRY_FinancialTransaction_ReportIcon() {
		return ENQUIRY_FinancialTransaction_ReportIcon;
	}
	
	@FindBy(xpath="//ion-label[contains(text(),'Enquiry')]")
	private WebElement ENQUIRY_FinancialTransaction_EnquiryMenu;
	public WebElement ENQUIRY_FinancialTransaction_EnquiryMenu()
	{
		return ENQUIRY_FinancialTransaction_EnquiryMenu;
		
	}
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/entities/financial-trans']")
	private WebElement ENQUIRY_FinancialTransaction_FinancialTransactionField; 
	public WebElement ENQUIRY_FinancialTransaction_FinancialTransactionField()
	{
		return ENQUIRY_FinancialTransaction_FinancialTransactionField;
		
	}
	@FindBy(xpath="//ion-col[1]//input")
	private WebElement ENQUIRY_FinancialTransaction_BranchCode;
	public WebElement ENQUIRY_FinancialTransaction_BranchCode()
	{
		return ENQUIRY_FinancialTransaction_BranchCode;
		
	}

	@FindBy(xpath="//ion-col[3]//input")
	private WebElement ENQUIRY_FinancialTransaction_GlCode;
	public WebElement ENQUIRY_FinancialTransaction_GlCode()
	{
		return ENQUIRY_FinancialTransaction_GlCode;
		
	}
	
	@FindBy(xpath="//ion-col[6]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement ENQUIRY_FinancialTransaction_TransactionRefNumber;
	public WebElement ENQUIRY_FinancialTransaction_TransactionRefNumber()
	{
		return ENQUIRY_FinancialTransaction_TransactionRefNumber;
		
	}
	
	@FindBy(xpath="(//span[@class='input-calendar'])[1]")
	private WebElement ENQUIRY_FinancialTransaction_FromDate;
	public WebElement ENQUIRY_FinancialTransaction_FromDate()
	{
		return ENQUIRY_FinancialTransaction_FromDate;
		
	}
	
	@FindBy(xpath="(//span[@class='input-calendar'])[2]")
	private WebElement ENQUIRY_FinancialTransaction_ToDate;
	public WebElement ENQUIRY_FinancialTransaction_ToDate()
	{
		return ENQUIRY_FinancialTransaction_ToDate;	
	}
	
//	@FindBy(xpath="(//button[@type='button'])[3]")
	@FindBy(xpath="//owl-date-time-calendar/div/button[2]")
	private WebElement ENQUIRY_FinancialTransaction_NextMonth;
	public WebElement ENQUIRY_FinancialTransaction_NextMonth()
	{
		return ENQUIRY_FinancialTransaction_NextMonth;
	}
	
	@FindBy(xpath="//span[contains(text(),'View')]/parent::ion-button")
	private WebElement ENQUIRY_FinancialTransaction_ViewButton;
	public WebElement ENQUIRY_FinancialTransaction_ViewButton()
	{
		return ENQUIRY_FinancialTransaction_ViewButton;
	}
	
	@FindBy(xpath="(//button[@type='button'])[3]")
	private WebElement ENQUIRY_FinancialTransaction_Next;
	public WebElement ENQUIRY_FinancialTransaction_Next()
	{
		return ENQUIRY_FinancialTransaction_Next;
	}	
	
	@FindBy(xpath="//li[8][@class='']/a/i")
	private WebElement ENQUIRY_FinancialTransaction_NextPage;
	public WebElement ENQUIRY_FinancialTransaction_NextPage()
	{
		return ENQUIRY_FinancialTransaction_NextPage;
	}
	@FindBy(xpath="//ion-col[5]//input")
	private WebElement trialBalance_currencyType;
	public WebElement trialBalanceCurrencyType()
	{
		return 	trialBalance_currencyType;

	}
}
