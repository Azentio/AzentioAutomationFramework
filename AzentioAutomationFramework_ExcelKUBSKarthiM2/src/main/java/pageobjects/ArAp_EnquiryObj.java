package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArAp_EnquiryObj {
	WebDriver driver;

	public  ArAp_EnquiryObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//ion-segment[1]/ion-segment-button[3]")
	private WebElement arAp_Enquiry_ReportIcon;

	public WebElement arAp_Enquiry_ReportIcon() {
		return arAp_Enquiry_ReportIcon;
	}
	@FindBy(xpath="//ion-label[contains(text(),'Enquiry')]")
	private WebElement arAp_Enquiry_EnquiryMenu;
	public WebElement arAp_Enquiry_EnquiryMenu()
	{
		return arAp_Enquiry_EnquiryMenu;
		
	}
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/entities/financial-trans']")
	private WebElement arAp_Enquiry_FinancialTransactionField; 
	public WebElement arAp_Enquiry_FinancialTransactionField()
	{
		return arAp_Enquiry_FinancialTransactionField;
		
	}
	@FindBy(xpath="//ion-col[1]//input")
	private WebElement arAp_Enquiry_BranchCode;
	public WebElement arAp_Enquiry_BranchCode()
	{
		return arAp_Enquiry_BranchCode;
		
	}

	@FindBy(xpath="//ion-col[3]//input")
	private WebElement arAp_Enquiry_GlCode;
	public WebElement arAp_Enquiry_GlCode()
	{
		return arAp_Enquiry_GlCode;
		
	}
	@FindBy(xpath="(//span[@class='input-calendar'])[1]")
	private WebElement arAp_Enquiry_FromDate;
	public WebElement arAp_Enquiry_FromDate()
	{
		return arAp_Enquiry_FromDate;
		
	}
	@FindBy(xpath="(//span[@class='input-calendar'])[2]")
	private WebElement arAp_Enquiry_ToDate;
	public WebElement arAp_Enquiry_ToDate()
	{
		return arAp_Enquiry_ToDate;	
	}
	
	@FindBy(xpath="(//button[@type='button'])[3]")
	private WebElement arAp_Enquiry_NextMonth;
	public WebElement arAp_Enquiry_NextMonth()
	{
		return arAp_Enquiry_NextMonth;
	}
	@FindBy(xpath="//ion-button[contains(text(),'View')]")
	private WebElement arAp_Enquiry_ViewButton;
	public WebElement arAp_Enquiry_ViewButton()
	{
		return arAp_Enquiry_ViewButton;
	}
	//(//i[@class='datatable-icon-right'])[2]"
	
	@FindBy(xpath="//li[6]/a/i")
	private WebElement arAp_Enquiry_Next;
	public WebElement arAp_Enquiry_Next()
	{
		return arAp_Enquiry_Next;
	}
	
	@FindBy(xpath="//li[8]/a/i")
	private WebElement arAp_Enquiry_Nextbutton;
	public WebElement arAp_Enquiry_Nextbutton()
	{
		return arAp_Enquiry_Nextbutton;
	}
	
	
   //to scroll page at bottom  web element TOTAL
	@FindBy(xpath="//div[contains(text(),'total')]")
	private WebElement arAp_Enquiry_Total;
	public WebElement arAp_Enquiry_Total()
	{
		return arAp_Enquiry_Total;
	}
	

}
