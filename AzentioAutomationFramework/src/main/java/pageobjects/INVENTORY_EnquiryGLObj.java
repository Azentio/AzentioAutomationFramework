package pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class INVENTORY_EnquiryGLObj {
	
	WebDriver driver;

	public  INVENTORY_EnquiryGLObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ion-segment[1]/ion-segment-button[3]")
	private WebElement inventory_ReportIcon;

	public WebElement inventory_ReportIcon() {
		return inventory_ReportIcon;
	}
	@FindBy(xpath="//ion-label[contains(text(),'Enquiry')]")
	private WebElement inventory_EnquiryMenu;
	public WebElement inventory_EnquiryMenu()
	{
		return inventory_EnquiryMenu;
		
	}
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/entities/financial-trans']")
	private WebElement inventory_FinancialTransactionField; 
	public WebElement inventory_FinancialTransactionField()
	{
		return inventory_FinancialTransactionField;
		
	}
	@FindBy(xpath="//ion-col[1]//input")
	private WebElement inventory_BranchCode;
	public WebElement inventory_BranchCode()
	{
		return inventory_BranchCode;
		
	}

	@FindBy(xpath="//ion-col[3]//input")
	private WebElement inventory_GlCode;
	public WebElement inventory_GlCode()
	{
		return inventory_GlCode;
		
	}
	@FindBy(xpath="(//span[@class='input-calendar'])[1]")
	private WebElement inventory_FromDate;
	public WebElement inventory_FromDate()
	{
		return inventory_FromDate;
		
	}
	@FindBy(xpath="(//span[@class='input-calendar'])[2]")
	private WebElement inventory_ToDate;
	public WebElement inventory_ToDate()
	{
		return inventory_ToDate;	
	}
	
	@FindBy(xpath="(//button[@type='button'])[3]")
	private WebElement inventory_NextMonth;
	public WebElement inventory_NextMonth()
	{
		return inventory_NextMonth;
	}
	@FindBy(xpath="//ion-button[contains(text(),'View')]")
	private WebElement inventory_ViewButton;
	public WebElement inventory_ViewButton()
	{
		return inventory_ViewButton;
	}
	


}
