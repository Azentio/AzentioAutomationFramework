package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Account_Receivable {
	WebDriver driver;

	public Account_Receivable(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ion-label[text()=' Accounts receivable ']")
	private WebElement accountreceivable;

	public WebElement accountReceivable() {
		return accountreceivable;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link=\"/tabs/list/datagrid-view/158\"]")
	private WebElement accountsReceivable_Creditnote_Eye;

	public WebElement accountsReceivable_CreditNote_Eye() {
		return accountsReceivable_Creditnote_Eye;
	}
	@FindBy(xpath="//ion-fab-button[@id='addBtn']")
	private WebElement acccontReceivable_CreditnoteAddicon;
	public WebElement acccontReceivable_CreditnoteAddicon() {
		return acccontReceivable_CreditnoteAddicon;
	}
	@FindBy(xpath="//ion-col[2]/app-kub-lov/span/ng-select/div/div/div/input")
	private WebElement accountReceivable_CreditNoteReceivable_Name;
	public WebElement  accountReceivable_CreditNoteReceivable_Name() {
		return accountReceivable_CreditNoteReceivable_Name;
	}
	@FindBy(xpath="//ion-col[3]/app-kub-lov/span/ng-select/div/div/div/input")
	private WebElement accoutReceivableCreditNoteBpName;
	public WebElement accoutReceivableCreditNoteBpName() {
		return accoutReceivableCreditNoteBpName;
	}
	@FindBy(xpath="//ion-col[7]/app-kub-lov/span/ng-select/div/div/div/input")
	private WebElement accountReceivableCreditInvoiceNumberSelect;
	public WebElement accountReceivableCreditInvoiceNumberSelect() {
		return accountReceivableCreditInvoiceNumberSelect ;
	}
	@FindBy(xpath="//ion-col[8]/ion-item")
	private WebElement accontReceivableCreditNoteAmount;
	public WebElement accontReceivableCreditNoteAmount() {
		return accontReceivableCreditNoteAmount;
	}
	@FindBy(xpath="//ion-col[13]/ion-item")
	private WebElement accountReceivableCreditDescription;
	public WebElement accountReceivableDescription() {
		return accountReceivableCreditDescription;
	}
    @FindBy(xpath="//ion-button[@ng-reflect-router-link=\"/tabs/list/datagrid-view/163\"]")
    private WebElement accountsReceivable_Debit_Eye;
    public WebElement accountsReceivable_Debit_Eye(){
    	return accountsReceivable_Debit_Eye;
    }
	@FindBy(xpath = "//datatable-header[1]/div[1]/div[2]/datatable-header-cell[8]/div[1]/ion-input[1]/input[1]")
	private WebElement accountsReceivable_CreditNote_Status;

	public WebElement accountsReceivable_CreditNote_Status() {

		return accountsReceivable_CreditNote_Status;
	}
    @FindBy(xpath="//datatable-header[1]/div[1]/div[2]/datatable-header-cell[9]/div/ion-input/input")
    private WebElement accountsReceivable_DebitNote_Status;
    public WebElement accountsReceivable_DebitNote_Status() {
    	return accountsReceivable_DebitNote_Status;
    }
    @FindBy(xpath="//datatable-header-cell[3]/div[1]/ion-input[1]/input[1]")
    private WebElement searchReceivableName;
    public WebElement searchReceivableName() {
    	return searchReceivableName;
    }
    // same x path for debit
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[1]//ion-button[1]")
	private WebElement accountsReceivable_CreditNote_StatusHead;

	public WebElement accountsReceivable_CreditNote_StatusHead() {

		return accountsReceivable_CreditNote_StatusHead;
	}
	@FindBy(xpath="//ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]")
	private WebElement creditNote_Buisness_Partner;
	public WebElement creditNote_Buisness_Partner() {
		return creditNote_Buisness_Partner;
	}
	@FindBy(xpath="//ion-col[4]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]")
	private WebElement debitNoteBuisnessPartner;
	public WebElement debitNoteBuisnessPartner() {
		return debitNoteBuisnessPartner;
	}
	////ion-col[7]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2] credit invc from creditnotes
	@FindBy(xpath="//ion-col[7]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]")
	private WebElement creditNote_Invoice_NumberInCreditNotePage;
	public WebElement creditNote_Invoice_NumberInCreditNotePage() {
		return creditNote_Invoice_NumberInCreditNotePage;
	} 
	@FindBy(xpath="//ion-col[8]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]")
	private WebElement debitNoteInvoiceNumber;
	public WebElement debitNoteInvoiceNumber() {
		return debitNoteInvoiceNumber;
	}
	@FindBy(xpath = "(//i[@class='datatable-icon-right'])[2]")
	private WebElement accountsPayable_paymentSettlementNextRecord;

	public WebElement accountsPayablePayementSettlementNextRecord() {
		return accountsPayable_paymentSettlementNextRecord;
	}

	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[1]//ion-button[2]")
	private WebElement ARAP_TableEdit;

	public WebElement ARAP_TableEdit() {

		return ARAP_TableEdit;
	}

	@FindBy(xpath = "//ion-item[5]/ion-label[contains(text(), ' Accounts receivable ')]")
	private WebElement ARAP_Accountsreceivable;

	public WebElement ARAP_Accountsreceivable() {

		return ARAP_Accountsreceivable;
	}
	//appropriation
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/200']")
	private WebElement appropriationEyeIcon;
	public WebElement appropriationEyeIcon() {
		return appropriationEyeIcon;
	}
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/213']")
	private WebElement appropriationReversalsEyeIcon;
	public WebElement appropriationReversalsEyeIcon() {
		return appropriationReversalsEyeIcon;
		
	}
	@FindBy(xpath="//ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement selectRefernceNumber;
	public WebElement selectRefernceNumber() {
		return selectRefernceNumber;
	}
	@FindBy(xpath="//ion-input[@ng-reflect-placeholder='Search Trx No']/input")
	private WebElement searchTxtNumber;
	public WebElement searchTxtNumber(){
		return searchTxtNumber;
	}
	@FindBy(xpath="//datatable-body-cell[4]/div/span")
	private WebElement getReferenceNumberFromAppropriationReversal;
	public WebElement getReferenceNumberFromAppropriationReversal() {
		return getReferenceNumberFromAppropriationReversal;
	}
	@FindBy(xpath="//datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[6]/div[1]/input[1]")
	private WebElement enterAppropriationAmount;
	public WebElement enterAppropriationAmount() {
		return enterAppropriationAmount;
	}
	

}
