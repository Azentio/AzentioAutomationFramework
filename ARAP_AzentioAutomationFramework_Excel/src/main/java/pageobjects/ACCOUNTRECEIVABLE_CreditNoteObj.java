package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ACCOUNTRECEIVABLE_CreditNoteObj {
	WebDriver driver;
	public ACCOUNTRECEIVABLE_CreditNoteObj(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/158']")
	private WebElement accountsReceivable_ViewButton;
	public WebElement accountsReceivableViewButton()
	{
		return accountsReceivable_ViewButton;
	}
	@FindBy(xpath="//ion-col[2]//input")
	private WebElement accountsReceivable_ReceivableName;
	public WebElement accountsReceivableReceivableName()
	{
		return accountsReceivable_ReceivableName;
	}
	@FindBy(xpath="//ion-col[3]//input")
	private WebElement accountsReceivable_BpName;
	public WebElement accountsReceivableBpName()
	{
		return accountsReceivable_BpName;
	}
	@FindBy(xpath="//ion-col[7]//input")
	private WebElement accountsReceivable_InvoiceNumber;
	public WebElement accountsReceivableInvoiceNumber()
	{
		return accountsReceivable_InvoiceNumber;
	}
	@FindBy(xpath="//ion-col[8]//input")
	private WebElement accountsReceivable_CreditAmmount;
	public WebElement accountsReceivableCreditAmmount()
	{
		return accountsReceivable_CreditAmmount;
	}
	@FindBy(xpath="//ion-col[13]//input")
	private WebElement accountsReceivable_Description;
	public WebElement accountsReceivableDescription()
	{
		return accountsReceivable_Description;
	}
	@FindBy(xpath="(//ion-toolbar[1]/ion-buttons[2]/ion-button[1])[2]")
	private WebElement accountsReceivable_SaveButton;
	public WebElement accountsReceivablleSaveButton()
	{
		return accountsReceivable_SaveButton;
	}
	@FindBy(xpath="//app-data-grid[1]//datatable-row-wrapper[1]//datatable-body-cell[4]//span[1]")
	private WebElement approvedCredit_noteRecord;
	public WebElement approvedCreditNoteRecord()
	{
		return approvedCredit_noteRecord;
	}
	@FindBy(xpath="//app-data-grid[1]//datatable-row-wrapper[1]//datatable-body-cell[5]//span[1]")
	private WebElement creditNote_ApprovedBusinessPartnerName;
	public WebElement creditNoteApprovedBusinessPartnerName()
	{
		return creditNote_ApprovedBusinessPartnerName;
	}
	@FindBy(xpath="//app-data-grid[1]//datatable-row-wrapper[1]//datatable-body-cell[6]//span[1]")
	private WebElement crditNote_ApprovedCreditAmount;
	public WebElement creditNoteApprovedCreditAmount()
	{
		return crditNote_ApprovedCreditAmount;
	}

	// record status
	@FindBy(xpath = "//body/div/div/div/button")
	private WebElement crditNote_ConfirmationMessageCloseButton;

	public WebElement crditNote_ConfirmationMessageCloseButton() {
		return crditNote_ConfirmationMessageCloseButton;
	}
	
}
