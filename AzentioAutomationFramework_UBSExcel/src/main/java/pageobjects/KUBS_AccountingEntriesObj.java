package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KUBS_AccountingEntriesObj {
	WebDriver driver;
	public KUBS_AccountingEntriesObj(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//label[text()=' Branch Code ']//following-sibling::ng-select//input")
	private WebElement accountingEntries_BranchCode;
	public WebElement accountingEntriesBranchCode()
	{
		return accountingEntries_BranchCode;
	}
	@FindBy(xpath="//label[text()=' Gl Code ']//following-sibling::ng-select//input")
	private WebElement accountingEntries_GlCode;
	public WebElement accountingEntriesGlCode()
	{
		return accountingEntries_GlCode;
	}
	@FindBy(xpath="//span[text()='View']//parent::ion-button")
	private WebElement accountingEntries_ViewButton;
	public WebElement accountingEntriesViewButton()
	{
		return accountingEntries_ViewButton;
	}
	@FindBy(xpath="//ion-label[text()=' Enquiry ']//ancestor::ion-item//ion-icon")
	private WebElement accountingEntries_EnquiryMenu;
	public WebElement accountingEntriesEnquiryMenu()
	{
		return accountingEntries_EnquiryMenu;
	}
	@FindBy(xpath="//ion-label[text()=' Financial transaction ']//following-sibling::ion-buttons//ion-button")
	private WebElement enquiry_FinancilaTransaction_Temp;
	public WebElement enquiryFinancilaTransactionTemp()
	{
		return enquiry_FinancilaTransaction_Temp;
	}
	

}
