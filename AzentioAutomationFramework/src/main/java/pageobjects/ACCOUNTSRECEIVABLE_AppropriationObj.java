package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ACCOUNTSRECEIVABLE_AppropriationObj {
	WebDriver driver;
	
	public ACCOUNTSRECEIVABLE_AppropriationObj(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/200']")
	private WebElement accountsReceivable_viewButton;
	public WebElement accountsPayableViewButton()
	{
		return accountsReceivable_viewButton;
	}
	@FindBy(xpath="//page-receipt-appropriation-hdr-update//ion-toolbar//ion-buttons[2]")
	private WebElement accountsReceivableAppropriation_SaveButton;
	public WebElement appropriationSaveButton()
	{
		return accountsReceivableAppropriation_SaveButton;
	}
	@FindBy(xpath="//ul[1]/li[8]/a[1]")
	private WebElement accountsReceivable_nextButton;
	public WebElement accontsReceivableNextButton()
	{
		return accountsReceivable_nextButton;
	}
	@FindBy(xpath="//ion-col[3]//input")
	private WebElement accountsReceivable_AppropriationReceiptReferenceNumber;
	public WebElement  accountsReceivableAppropriationReceiptReferenceNumber()
	{
	return accountsReceivable_AppropriationReceiptReferenceNumber;
	}

//	Update Cheque Status SUBMODULE  //

	// eye button of update cheque status
	@FindBy(xpath = "//div[5]//ion-menu-toggle[8]//ion-item//ion-buttons//ion-button[2]")
	private WebElement accountsReceivable_Appropriation_EyeButton;

	public WebElement accountsReceivable_Appropriation_EyeButton() {
		return accountsReceivable_Appropriation_EyeButton;
	}
	
	// Search icon
	@FindBy(xpath = "(//ion-buttons/ion-item/ion-icon)[2]")
	private WebElement accountsReceivable_Appropriation_Search;

	public WebElement accountsReceivable_Appropriation_Search() {
		return accountsReceivable_Appropriation_Search;
	}

	// Search by cheque number
	@FindBy(xpath = "//datatable-header-cell[4]/div/ion-input/input")
	private WebElement accountsReceivable_Appropriation_ReceiptRef;

	public WebElement accountsReceivable_Appropriation_ReceiptRef() {
		return accountsReceivable_Appropriation_ReceiptRef;
	}
	
	// Get trx number
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[3]/div/span")
	private WebElement accountsReceivable_Appropriation_TrxNumber;
	
	public WebElement accountsReceivable_Appropriation_TrxNumber() {
		return accountsReceivable_Appropriation_TrxNumber;
	}
//	
//	// Get trx number of advance po
//	@FindBy(xpath = "//datatable-row-wrapper[2]/datatable-body-row/div[2]/datatable-body-cell[3]/div/span")
//	private WebElement accountsReceivable_Appropriation_AdvancePO;
//	
//	public WebElement accountsReceivable_Appropriation_AdvancePO() {
//		return accountsReceivable_Appropriation_AdvancePO;
//	}
//	
//	// Get trx number of advance debit note
//	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[3]/div/span")
//	private WebElement accountsReceivable_Appropriation_DebitNote;
//	
//	public WebElement accountsReceivable_Appropriation_DebitNote() {
//		return accountsReceivable_Appropriation_DebitNote;
//	}
	
	
//	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/200']")
//	private WebElement accountsReceivable_viewButton;
//	public WebElement accountsPayableViewButton()
//	{
//		return accountsReceivable_viewButton;
//	}
//	@FindBy(xpath="//ul[1]/li[8]/a[1]")
//	private WebElement accountsReceivable_nextButton;
//	public WebElement accontsReceivableNextButton()
//	{
//		return accountsReceivable_nextButton;
//	}

}
