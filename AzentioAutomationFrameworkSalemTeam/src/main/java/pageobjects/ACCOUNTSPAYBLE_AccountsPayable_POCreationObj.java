package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ACCOUNTSPAYBLE_AccountsPayable_POCreationObj {
	WebDriver driver;

	public ACCOUNTSPAYBLE_AccountsPayable_POCreationObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ion-segment/ion-segment-button[2]")
	private WebElement accountsPayable_VendorPurchaseOrder_DirectionIcon;

	public WebElement accountsPayable_VendorPurchaseOrder_DirectionIcon() {
		return accountsPayable_VendorPurchaseOrder_DirectionIcon;
	}

	@FindBy(xpath = "//ion-label[text()=' Accounts payable ']")
	private WebElement accountsPayable_VendorPurchaseOrder_AccountsPayableField;

	public WebElement accountsPayable_VendorPurchaseOrder_AccountsPayableField() {
		return accountsPayable_VendorPurchaseOrder_AccountsPayableField;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/134']")
	private WebElement accountsPayable_VendorPurchaseOrder_EyeButton;

	public WebElement accountsPayable_VendorPurchaseOrder_EyeButton() {
		return accountsPayable_VendorPurchaseOrder_EyeButton;

	}

	@FindBy(xpath = "//ion-fab-button[@id='addBtn']")
	private WebElement accountsPayable_VendorPurchaseOrder_AddButton;

	public WebElement accountsPayable_VendorPurchaseOrder_AddButton() {
		return accountsPayable_VendorPurchaseOrder_AddButton;

	}

//Select Entity Branch
	@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[3]/input")
	private WebElement accountsPayable_VendorPurchaseOrder_EntityBranch;

	public WebElement accountsPayable_VendorPurchaseOrder_EntityBranch() {
		return accountsPayable_VendorPurchaseOrder_EntityBranch;
	}

//Select BP Name
	@FindBy(xpath = "//ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement accountsPayable_VendorPurchaseOrder_BPName;

	public WebElement accountsPayable_VendorPurchaseOrder_BPName() {
		return accountsPayable_VendorPurchaseOrder_BPName;
	}

//Select Reference Type
	@FindBy(xpath = "//ion-col[4]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement accountsPayable_VendorPurchaseOrder_ReferenceType;

	public WebElement accountsPayable_VendorPurchaseOrder_ReferenceType() {
		return accountsPayable_VendorPurchaseOrder_ReferenceType;
	}

//Select Contract
	@FindBy(xpath = "(//ion-col[5]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2])[1]/input")
	private WebElement accountsPayable_VendorPurchaseOrder_Contract;

	public WebElement accountsPayable_VendorPurchaseOrder_Contract() {
		return accountsPayable_VendorPurchaseOrder_Contract;
	}

//Select CheckBox PO ITEM
	@FindBy(xpath = "//ion-checkbox[@id='rowIndex']")
	private WebElement accountsPayable_VendorPurchaseOrder_CheckBoxPoItem;

	public WebElement accountsPayable_VendorPurchaseOrder_CheckBoxPoItem() {
		return accountsPayable_VendorPurchaseOrder_CheckBoxPoItem;
	}

//Enter  PO Quantity
	@FindBy(xpath = "//datatable-body-cell/div[1]/input")
	private WebElement accountsPayable_VendorPurchaseOrder_PoQuantity;

	public WebElement accountsPayable_VendorPurchaseOrder_PoQuantity() {
		return accountsPayable_VendorPurchaseOrder_PoQuantity;
	}

//  Po Item Save
	@FindBy(xpath = "//page-po-item-details-update//ion-toolbar[1]//ion-buttons[2]/ion-button")
	private WebElement accountsPayable_VendorPurchaseOrder_PoItemSave;

	public WebElement accountsPayable_VendorPurchaseOrder_PoItemSave() {
		return accountsPayable_VendorPurchaseOrder_PoItemSave;

	}

//Select Purchase Requisition
	@FindBy(xpath = "//ion-col[5]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement accountsPayable_VendorPurchaseOrder_PurchaseRequisition;

	public WebElement accountsPayable_VendorPurchaseOrder_PurchaseRequisition() {
		return accountsPayable_VendorPurchaseOrder_PurchaseRequisition;
	}

//Select PO Type
	@FindBy(xpath = "//ion-col[6]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]//input")
	private WebElement accountsPayable_VendorPurchaseOrder_POType;

	public WebElement accountsPayable_VendorPurchaseOrder_POType() {
		return accountsPayable_VendorPurchaseOrder_POType;
	}

//Select PO Sub Type
	@FindBy(xpath = "//ion-col[7]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement accountsPayable_VendorPurchaseOrder_POSubType;

	public WebElement accountsPayable_VendorPurchaseOrder_POSubType() {
		return accountsPayable_VendorPurchaseOrder_POSubType;
	}

//Select PO Number
	@FindBy(xpath = "//ion-col[9]/ion-item[1]/ion-input[1]/input")
	private WebElement accountsPayable_VendorPurchaseOrder_PONumber;

	public WebElement accountsPayable_VendorPurchaseOrder_PONumber() {
		return accountsPayable_VendorPurchaseOrder_PONumber;
	}

//PO Delivery Date
	@FindBy(xpath = "(//span[@class='input-calendar'])[3]")
	private WebElement accountsPayable_VendorPurchaseOrder_PODeliveryDate;

	public WebElement accountsPayable_VendorPurchaseOrder_PODeliveryDate() {
		return accountsPayable_VendorPurchaseOrder_PODeliveryDate;
	}

	@FindBy(xpath = "(//button[@type='button'])[3]")
	private WebElement accountsPayable_VendorPurchaseOrder_NextMonth;

	public WebElement accountsPayable_VendorPurchaseOrder_NextMonth() {
		return accountsPayable_VendorPurchaseOrder_NextMonth;
	}

//Cost Center
	@FindBy(xpath = "//ion-col[13]//input")
	private WebElement accountsPayable_VendorPurchaseOrder_CostCenter;

	public WebElement accountsPayable_VendorPurchaseOrder_CostCenter() {
		return accountsPayable_VendorPurchaseOrder_CostCenter;
	}

//Remark
	@FindBy(xpath = "//ion-col[19]/ion-item[1]/ion-input[1]/input")
	private WebElement accountsPayable_VendorPurchaseOrder_Remark;

	public WebElement accountsPayable_VendorPurchaseOrder_Remark() {
		return accountsPayable_VendorPurchaseOrder_Remark;
	}

//Save
	@FindBy(xpath = "(//ion-toolbar[1]/ion-buttons[2]/ion-button[1])[2]")
	private WebElement accountsPayable_VendorPurchaseOrder_Save;

	public WebElement accountsPayable_VendorPurchaseOrder_Save() {
		return accountsPayable_VendorPurchaseOrder_Save;
	}

//Notification
	@FindBy(xpath = "//ion-header/ion-toolbar[1]/ion-buttons[2]/ion-button[2]")
	private WebElement accountsPayable_VendorPurchaseOrder_Notification;

	public WebElement accountsPayable_VendorPurchaseOrder_Notification() {
		return accountsPayable_VendorPurchaseOrder_Notification;
	}

//reference id
	@FindBy(xpath = "//app-inbox//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[2]//span")
	private WebElement accountsPayable_VendorPurchaseOrder_ReferenceId;

	public WebElement accountsPayable_VendorPurchaseOrder_ReferenceId() {
		return accountsPayable_VendorPurchaseOrder_ReferenceId;
	}

//Pencil Icon
	@FindBy(xpath = "//app-inbox//datatable-row-wrapper[1]//datatable-body-row//div[2]//datatable-body-cell//div//ion-buttons//ion-button")
	private WebElement accountsPayable_VendorPurchaseOrder_PencilIcon;

	public WebElement accountsPayable_VendorPurchaseOrder_PencilIcon() {
		return accountsPayable_VendorPurchaseOrder_PencilIcon;
	}

//Notification NextButton
	@FindBy(xpath = "//datatable-pager[1]/ul[1]/li[8]/a[1]/i[1]")
	private WebElement accountsPayable_VendorPurchaseOrder_NotificationNext_Button;

	public WebElement accountsPayable_VendorPurchaseOrder_NotificationNext_Button() {
		return accountsPayable_VendorPurchaseOrder_NotificationNext_Button;
	}

//Vaildation Msg
	@FindBy(xpath = "//body/div/div/div/div[1]")
	private WebElement accountsPayable_VendorPurchaseOrder_VaildationMsg;

	public WebElement accountsPayable_VendorPurchaseOrder_VaildationMsg() {

		return accountsPayable_VendorPurchaseOrder_VaildationMsg;
	}

//Submit
	@FindBy(xpath = "//span[contains(text(),'Submit')]")
	private WebElement accountsPayable_VendorPurchaseOrder_SubmitButton;

	public WebElement accountsPayable_VendorPurchaseOrder_SubmitButton() {
		return accountsPayable_VendorPurchaseOrder_SubmitButton;
	}

//Remark field
	@FindBy(xpath = "//ion-textarea/div/textarea[@name='remarks']")
	private WebElement accountsPayable_VendorPurchaseOrder_RemarkField;

	public WebElement accountsPayable_VendorPurchaseOrder_RemarkField() {
		return accountsPayable_VendorPurchaseOrder_RemarkField;
	}

//Submit by maker
	@FindBy(xpath = "//ion-button[contains(text(),'Submit')]")
	private WebElement accountsPayable_VendorPurchaseOrder_SubmitByMaker;

	public WebElement accountsPayable_VendorPurchaseOrder_SubmitByMaker() {
		return accountsPayable_VendorPurchaseOrder_SubmitByMaker;
	}

//RecordStatus
	@FindBy(xpath = "//body/div/div/div/div[1]")
	private WebElement accountsPayable_VendorPurchaseOrder_RecordStatus;

	public WebElement accountsPayable_VendorPurchaseOrder_RecordStatus() {
		return accountsPayable_VendorPurchaseOrder_RecordStatus;
	}

//ItemDetails
	@FindBy(xpath = "//span[2]/ion-tab-button/ion-label")
	private WebElement accountsPayable_VendorPurchaseOrder_ItemDetails;

	public WebElement accountsPayable_VendorPurchaseOrder_ItemDetails() {
		return accountsPayable_VendorPurchaseOrder_ItemDetails;
	}

// ItemDetails Record select 
	@FindBy(xpath = "//datatable-body-cell/div[1]/ion-buttons[1]/ion-button[1]")
	private WebElement accountsPayable_VendorPurchaseOrder_ItemDetailsRecord;

	public WebElement accountsPayable_VendorPurchaseOrder_ItemDetailsRecord() {
		return accountsPayable_VendorPurchaseOrder_ItemDetailsRecord;
	}

//Shipped From Location
	@FindBy(xpath = "//ion-col[9]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement accountsPayable_VendorPurchaseOrder_ShippedFromLocation;

	public WebElement accountsPayable_VendorPurchaseOrder_ShippedFromLocation() {
		return accountsPayable_VendorPurchaseOrder_ShippedFromLocation;
	}

//Delivery Location
	@FindBy(xpath = "//ion-col[10]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement accountsPayable_VendorPurchaseOrder_DeliveryLocation;

	public WebElement accountsPayable_VendorPurchaseOrder_DeliveryLocation() {
		return accountsPayable_VendorPurchaseOrder_DeliveryLocation;
	}

	@FindBy(xpath = "//page-po-item-details//ion-toolbar//ion-buttons/ion-button[1]")
	private WebElement vendorContract_poItemSave;

	public WebElement vendorContractPoItemSave() {
		return vendorContract_poItemSave;
	}
	@FindBy(xpath="//span[contains(text(),'PO Qty')]")
	private WebElement poContract_poQuantity;
	public WebElement pocontractPoQuantity()
	{
		return poContract_poQuantity;
	}
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid/47']")
	private WebElement poCreation_tempView;
	public WebElement poCreationTempView()
	{
		return poCreation_tempView;
	}
	@FindBy(xpath="//datatable-row-wrapper[1]//datatable-body-cell[1]//ion-button")
	private WebElement poCreation_tempViewFirstRecord;
	public WebElement tempViewFirstRecord()
	{
		return poCreation_tempViewFirstRecord;
	}
	@FindBy(xpath="//div[@id='toast-container']//button")
	private WebElement alert_close;
	public WebElement checkerAlertClose()
	{
		return alert_close;
	}
	@FindBy(xpath="//app-data-grid[1]//datatable-row-wrapper[1]//datatable-body-cell[3]//span[1]")
	private WebElement poCreation_approvedPoNumber;
	public WebElement poCreationApprovedPoNumber()
	{
		return poCreation_approvedPoNumber;
	}
}