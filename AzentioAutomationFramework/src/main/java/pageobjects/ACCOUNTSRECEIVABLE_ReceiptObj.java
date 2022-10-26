package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ACCOUNTSRECEIVABLE_ReceiptObj {
	WebDriver driver;
	public ACCOUNTSRECEIVABLE_ReceiptObj(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/193']")
	private WebElement accoutsReceivable_receiptViewButton;
	public WebElement accoutsReceivableReceiptViewButton()
	{
		return accoutsReceivable_receiptViewButton;
	}
	@FindBy(xpath="//ion-col[3]//input")
	private WebElement accoutsReceivable_receiptReceiptType;
	public WebElement accoutsReceivableReceiptReceiptType()
	{
		return accoutsReceivable_receiptReceiptType;
	}
	@FindBy(xpath="//ion-col[4]//input")
	private WebElement accoutsReceivable_receiptReceiptReferenceNumber;
	public WebElement accoutsReceivableReceiptReceiptReferenceNumber()
	{
		return accoutsReceivable_receiptReceiptReferenceNumber;
	}
	@FindBy(xpath="//ion-col[6]//input")
	private WebElement accoutsReceivable_receiptReceiptAmount;
	public WebElement accoutsReceivableReceiptReceiptAmount()
	{
		return accoutsReceivable_receiptReceiptAmount;
	}
	@FindBy(xpath="//ion-col[8]//input")
	private WebElement accoutsReceivable_receiptBankAcoount;
	public WebElement accoutsReceivableReceiptBankAccount()
	{
		return accoutsReceivable_receiptBankAcoount;
	}
	@FindBy(xpath="//ion-col[9]//input")
	private WebElement accoutsReceivable_receiptPayerName;
	public WebElement accoutsReceivableReceiptPayerName()
	{
		return accoutsReceivable_receiptPayerName;
	}
	@FindBy(xpath="//ion-col[11]//input")
	private WebElement accoutsReceivable_receiptRemark;
	public WebElement accoutsReceivableReceiptRemark()
	{
		return accoutsReceivable_receiptRemark;
	}
	
    @FindBy(xpath="(//ion-toolbar//ion-buttons[2]/ion-button)[5]")
    private WebElement accoutsReceivable_receiptSaveButton;
	public WebElement accoutsReceivableReceiptSaveButton()
	{
		return accoutsReceivable_receiptSaveButton;
	}
	@FindBy(xpath = "//div[@id='toast-container']//div[@role='alert']")
    private WebElement WorkflowInitiated;
    public WebElement WorkflowInitiated() {
         return WorkflowInitiated;
    }
    @FindBy(xpath = "//button[@aria-label='Close']")
    private WebElement AlertClose;
    public WebElement AlertClose() {
         return AlertClose;
    } 
	
	@FindBy(xpath="//ion-col[8]//div/div/div/span[2]")
	private WebElement accoutsReceivable_getBankAccountNumber;
	public WebElement accoutsReceivableGetBankAccoutNumber()
	{
		return accoutsReceivable_getBankAccountNumber;
	}
}
