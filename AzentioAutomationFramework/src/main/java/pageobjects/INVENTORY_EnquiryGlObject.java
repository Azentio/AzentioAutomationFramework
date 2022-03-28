package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class INVENTORY_EnquiryGlObject {
	WebDriver driver;

	public INVENTORY_EnquiryGlObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ion-segment[1]/ion-segment-button[3]")
	private WebElement invenrory_report_icon;

	public WebElement inventoryReportIcon() {
		return invenrory_report_icon;
	}
	@FindBy(xpath="//ion-label[contains(text(),'Enquiry')]")
	private WebElement inventory_enquiry_menu;
	public WebElement inventoryEnquiryMenu()
	{
		return inventory_enquiry_menu;
		
	}
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/entities/financial-trans']")
	private WebElement inventory_financial_transaction_icon; 
	public WebElement inventoryFinancialTransactionIcon()
	{
		return inventory_financial_transaction_icon;
		
	}
	@FindBy(xpath="//ion-col[1]//input")
	private WebElement inventory_branch_code;
	public WebElement inventoryBranchCode()
	{
		return inventory_branch_code;
		
	}

	@FindBy(xpath="//ion-col[3]//input")
	private WebElement inventory_gl_code;
	public WebElement inventoryGlCode()
	{
		return inventory_gl_code;
		
	}
	@FindBy(xpath="(//span[@class='input-calendar'])[1]")
	private WebElement inventory_from_date;
	public WebElement inventoryFromDate()
	{
		return inventory_from_date;
		
	}
	@FindBy(xpath="(//span[@class='input-calendar'])[2]")
	private WebElement inventory_to_date;
	public WebElement inventoryToDate()
	{
		return inventory_to_date;	
	}
	@FindBy(xpath="(//button[@type='button'])[3]")
	private WebElement inventory_next_month;
	public WebElement inventoryNextMonth()
	{
		return inventory_next_month;
	}
	@FindBy(xpath="//ion-button[contains(text(),'View')]")
	private WebElement inventory_view;
	public WebElement inventoryViewButton()
	{
		return inventory_view;
	}
	@FindBy(xpath="(//i[@class='datatable-icon-right'])[2]")
	private WebElement gl_nextRecord;
	public WebElement nextRecord()
	{
		return gl_nextRecord;
	}
	
	
}
