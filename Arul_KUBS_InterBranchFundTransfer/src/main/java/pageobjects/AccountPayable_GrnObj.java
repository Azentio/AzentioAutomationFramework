package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPayable_GrnObj {

	WebDriver driver;

	public AccountPayable_GrnObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/133']")
	private WebElement accountsPayable_Grn_EyeButton;

	public WebElement accountsPayable_Grn_EyeButton() {
		return accountsPayable_Grn_EyeButton;

	}
	
	//BpName
	@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement accountsPayable_Grn_BpName;

	public WebElement accountsPayable_Grn_BpName() 
	{
		return accountsPayable_Grn_BpName;

	}
	
	//BpBranch
	@FindBy(xpath = "//ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement accountsPayable_Grn_BpBranch;

	public WebElement accountsPayable_Grn_BpBranch() {
		return accountsPayable_Grn_BpBranch;

	}
	
	//InvoiceNumber
	@FindBy(xpath = "//ion-row[1]/ion-col[5]/ion-item[1]/ion-input[1]/input")
	private WebElement accountsPayable_Grn_InvoiceNumber;

	public WebElement accountsPayable_Grn_InvoiceNumber() {
		return accountsPayable_Grn_InvoiceNumber;

	}
	
	//DeliveryLocation
	@FindBy(xpath = "//ion-col[9]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement accountsPayable_Grn_DeliveryLocation;

	public WebElement accountsPayable_Grn_DeliveryLocation() {
		return accountsPayable_Grn_DeliveryLocation;

	}
	
	//ItemDetails tab
	@FindBy(xpath = "//ion-label[contains(text(),'Item Details')]")
	private WebElement accountsPayable_Grn_ItemDetails;

	public WebElement accountsPayable_Grn_ItemDetails() {
	return accountsPayable_Grn_ItemDetails;

	}
	
	// PoNumber
	@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement accountsPayable_Grn_PoNumber;

	public WebElement accountsPayable_Grn_PoNumber() {
	return accountsPayable_Grn_PoNumber;

	}
	
	//QtyReceived
	@FindBy(xpath = "//input[@id='row.receivedQty']")
	private WebElement accountsPayable_Grn_QtyReceived;

	public WebElement accountsPayable_Grn_QtyReceived() {
		return accountsPayable_Grn_QtyReceived;

	}
	
	//QtyApproved
	@FindBy(xpath = "//input[@id='row.approvedQty']")
	private WebElement accountsPayable_Grn_QtyApproved;

	public WebElement accountsPayable_Grn_QtyApproved() {
	return accountsPayable_Grn_QtyApproved;

	}
	

			
	//ItemSave
	@FindBy(xpath = "(//ion-toolbar/ion-buttons[1]/ion-button[1])[2]")
	private WebElement accountsPayable_Grn_ItemSave;

	public WebElement accountsPayable_Grn_ItemSave() {
	return accountsPayable_Grn_ItemSave;

	}
	
	// Submit
	@FindBy(xpath = "//span[contains(text(),'Submit')]")
	private WebElement accountsPayable_Grn_SubmitButton;

	public WebElement accountsPayable_Grn_SubmitButton() {
		return accountsPayable_Grn_SubmitButton;
	}

	// Remark field
	@FindBy(xpath = "(//ion-textarea/div/textarea[@name='remarks'])[2]")
	private WebElement accountsPayable_Grn_RemarkField;

	public WebElement accountsPayable_Grn_RemarkField() {
		return accountsPayable_Grn_RemarkField;
	}

	// Submit by maker
	@FindBy(xpath = "//ion-button[contains(text(),'Submit')]")
	private WebElement accountsPayable_Grn_SubmitByMaker;

	public WebElement accountsPayable_Grn_SubmitByMaker() {
		return accountsPayable_Grn_SubmitByMaker;
	}

	// RecordStatus
	@FindBy(xpath = "//body/div/div/div/div[1]")
	private WebElement accountsPayable_Grn_RecordStatus;

	public WebElement accountsPayable_Grn_RecordStatus() {
		return accountsPayable_Grn_RecordStatus;
	}
	
	//reviewer remark
	@FindBy(xpath = "(//textarea[@name='remarks'])[2]")
	private WebElement reviewer_Grn_remarks;

	public WebElement reviewer_Grn_remarks() {
		return reviewer_Grn_remarks;
	}
	
	// FirstRecord
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[1]/div[1]/ion-buttons[1]/ion-button[1]")
	private WebElement accountsPayable_Grn_FirstRecord;

	public WebElement accountsPayable_Grn_FirstRecord() {
		return accountsPayable_Grn_FirstRecord;
	}

	// Grn Reference number
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[3]/div/span")
	private WebElement accountsPayable_Grn_GrnReference;

	public WebElement accountsPayable_Grn_GrnReference() {
		return accountsPayable_Grn_GrnReference;
	}
		
}
