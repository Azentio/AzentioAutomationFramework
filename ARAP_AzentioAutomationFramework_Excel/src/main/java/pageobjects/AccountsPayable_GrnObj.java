package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsPayable_GrnObj {

	WebDriver driver;

	public AccountsPayable_GrnObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	// Account Payable

	@FindBy(xpath = "//ion-content[1]/custom-side-menu[1]/ion-list[1]/ion-item[3]")
	private WebElement accountPayableButton;

	public WebElement accountPayableButton() {
		return accountPayableButton;
	}

	// Goods Received note (GRN) Eye button
	@FindBy(xpath = "//custom-side-menu[1]/ion-list[1]/div[3]/ion-menu-toggle[3]/ion-item[1]/ion-buttons[1]/ion-button[2]")
	private WebElement accountPayable_GoodsReceivedNoteGRNEyeButton;

	public WebElement accountPayable_GoodsReceivedNoteGRNEyeButton() {
		return accountPayable_GoodsReceivedNoteGRNEyeButton;
	}

	// Goods Received note (GRN) Add button
	@FindBy(xpath = "//ion-fab-button[@id='addBtn']")
	private WebElement accountPayable_GoodsReceivedNoteGRN_AddButton;

	public WebElement accountPayable_GoodsReceivedNoteGRN_AddButton() {
		return accountPayable_GoodsReceivedNoteGRN_AddButton;
	}

	// Goods Received note (GRN) BP Name
//	@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")

	@FindBy(xpath = "//label[contains(text(),'  BP Name  ')]/../../..//div[2]//input[1]")

	private WebElement accountPayable_GrnBpName;

	public WebElement accountPayable_GrnBpName() {
		return accountPayable_GrnBpName;
	}
	// Goods Received note (GRN) Invoice number

	@FindBy(xpath = "//form[1]/ion-infinite-scroll[1]/ion-grid[1]/ion-row[1]/ion-col[5]/ion-item[1]/ion-input[1]/input[1]")
	private WebElement accountPayable_GrnInvoiceNumber;

	public WebElement accountPayable_GrnInvoiceNumber() {
		return accountPayable_GrnInvoiceNumber;
	}

	// Goods Received note (GRN) Delivery Location
	@FindBy(xpath = "//ion-grid[1]/ion-row[1]/ion-col[9]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement accountPayable_GrnDeliveryLocation;

	public WebElement accountPayable_GrnDeliveryLocation() {
		return accountPayable_GrnDeliveryLocation;
	}

	@FindBy(xpath = "(//ion-buttons[2]/ion-button[1])[2]")
	private WebElement accountPayable_Grn_SaveButton;

	public WebElement accountPayable_Grn_SaveButton() {
		return accountPayable_Grn_SaveButton;
	}

	@FindBy(xpath = "//body/div/div/div/button")
	private WebElement ConfirmationMessageCloseButton;

	public WebElement ConfirmationMessageCloseButton() {
		return ConfirmationMessageCloseButton;
	}

	@FindBy(xpath = "//div[@id='toast-container']/div[1]")
	private WebElement MessageContent;

	public WebElement MessageContent() {
		return MessageContent;
	}

	// Inbox Search icon
	@FindBy(xpath = "//div[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[2]")
	private WebElement accountPayable_Grn_InboxSearchIcon;

	public WebElement accountPayable_Grn_InboxSearchIcon() {
		return accountPayable_Grn_InboxSearchIcon;
	}

	// Inbox EventCodeSearch
	@FindBy(xpath = "//div[2]/datatable-header-cell[3]/div[1]/ion-input[1]/input[1]")
	private WebElement accountPayable_Grn_EventCodeSearch;

	public WebElement accountPayable_Grn_EventCodeSearch() {
		return accountPayable_Grn_EventCodeSearch;
	}

	// FirstReferenceID
	@FindBy(xpath = "//app-inbox//datatable-row-wrapper[1]//datatable-body-row//div[2]//datatable-body-cell[2]//div//span")
	private WebElement accountPayable_Grn_FirstReferenceId;

	public WebElement accountPayable_Grn_FirstReferenceId() {
		return accountPayable_Grn_FirstReferenceId;
	}

	// ActionButton
	@FindBy(xpath = "//app-inbox//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[1]//ion-button")

	private WebElement accountPayable_Grn_ActionButton;

	public WebElement accountPayable_Grn_ActionButton() {
		return accountPayable_Grn_ActionButton;
	}

	// ItemDetails tab
	@FindBy(xpath = "//ion-label[contains(text(),'Item Details')]")
	private WebElement accountsPayable_Grn_ItemDetails;

	public WebElement accountsPayable_Grn_ItemDetails() {
		return accountsPayable_Grn_ItemDetails;

	}

	// Goods Received note (GRN) PO Number textbox
	@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement accountPayable_GrnPONumber;

	public WebElement accountPayable_GrnPONumber() {
		return accountPayable_GrnPONumber;
	}

	// Goods Received note (GRN) Qty Received textbox
	@FindBy(xpath = "//input[@id='row.receivedQty']")
	private WebElement accountPayable_GrnQtyReceived;

	public WebElement accountPayable_GrnQtyReceived() {
		return accountPayable_GrnQtyReceived;
	}

	// Goods Received note (GRN) Qty Approved textbox
	@FindBy(xpath = "//input[@id='row.approvedQty']")
	private WebElement accountPayable_GrnQtyApproved;

	public WebElement accountPayable_GrnQtyApproved() {
		return accountPayable_GrnQtyApproved;
	}

	// Item details Save Button
	@FindBy(xpath = "(//ion-toolbar/ion-buttons[1]/ion-button)[2]")
	private WebElement accountPayable_GRN_ItemDetailsSaveButton;

	public WebElement accountPayable_GRN_ItemDetailsSaveButton() {
		return accountPayable_GRN_ItemDetailsSaveButton;
	}

	// Submit
	@FindBy(xpath = "//span[contains(text(),'Submit')]")
	private WebElement accountPayable_GRN_SubmitButton;

	public WebElement accountPayable_GRN_SubmitButton() {
		return accountPayable_GRN_SubmitButton;
	}

	@FindBy(xpath = "//ion-row[1]/ion-col/ion-item/ion-textarea/div/textarea")
	private WebElement accountPayable_GRN_RemarkField;

	public WebElement accountPayable_GRN_RemarkField() {
		return accountPayable_GRN_RemarkField;
	}

	// Submit by maker
	@FindBy(xpath = "//ion-row[2]/ion-button")
	private WebElement accountPayable_GRN_Submit;

	public WebElement accountPayable_GRN_Submit() {
		return accountPayable_GRN_Submit;
	}

	// record status
	@FindBy(xpath = "//body/div/div/div/div[1]")
	private WebElement accountPayable_GRN_RecordStatus;

	public WebElement accountPayable_GRN_RecordStatus() {
		return accountPayable_GRN_RecordStatus;
	}

	// Submit button
	// ion-button[contains(text(),'Submit')]
	// ion-header/ion-toolbar[1]/ion-buttons[2]/app-kub-decision-button[1]/div[1]/span[1]/ion-button[1]
	@FindBy(xpath = "//ion-header/ion-toolbar[1]/ion-buttons[2]/app-kub-decision-button[1]/div[1]/span[1]/ion-button[1]")
	private WebElement accountPayable_SubmitButton;

	public WebElement accountPayable_SubmitButton() {
		return accountPayable_SubmitButton;
	}

	// GRN Submit from maker notification Submit button
	@FindBy(xpath = "//ion-header/ion-toolbar[1]/ion-buttons[2]/app-kub-decision-button[1]/div[1]/span[1]/ion-button[1]")
	private WebElement accountPayable_GRNNotificationSubmitButton;

	public WebElement accountPayable_GRNNotificationSubmitButton() {
		return accountPayable_GRNNotificationSubmitButton;
	}

	// approve button
	@FindBy(xpath = "//span/ion-button[1]")
	private WebElement accountPayable_GRN_Approve_Button;

	public WebElement accountPayable_GRN_Approve_Button() {
		return accountPayable_GRN_Approve_Button;

	}
	// Search icon
		@FindBy(xpath = "(//ion-buttons/ion-item/ion-icon)[2]")
		private WebElement accountPayable_GRN_Search;

		public WebElement accountPayable_GRN_Search() {
			return accountPayable_GRN_Search;
		}
		// Record Search using Business Partner
		@FindBy(xpath = "//datatable-header-cell[4]/div/ion-input/input")
		private WebElement accountPayable_GRN_BusinessPartnerSearch;

		public WebElement accountPayable_GRN_BusinessPartnerSearch() {
			return accountPayable_GRN_BusinessPartnerSearch;
		}
		// GRN Status
		@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[6]/div[1]/span")
		private WebElement accountPayable_GRN_ContractStatus;

		public WebElement accountPayable_GRN_ContractStatus() {
			return accountPayable_GRN_ContractStatus;
		}

		// txn Status
		@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[12]/div[1]/span")
		private WebElement accountPayable_GRN_TxnStatus;

		public WebElement accountPayable_GRN_TxnStatus() {
			return accountPayable_GRN_TxnStatus;
		}
		// GrnNumber
				@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[3]/div[1]/span")
				private WebElement accountPayable_GRN_GrnNumber;

				public WebElement accountPayable_GRN_GrnNumber() {
					return accountPayable_GRN_GrnNumber;
				}

	// approve remarks
	// textarea[@name='remarks']
	@FindBy(xpath = "(//textarea[@name='remarks'])[2]")
	private WebElement accountPayable_GRN_ApproveRemarkByReviewer;

	public WebElement accountPayable_GRN_ApproveRemarkByReviewer() {
		return accountPayable_GRN_ApproveRemarkByReviewer;
	}
	@FindBy(xpath = "(//textarea[@name='remarks'])[2]")
	private WebElement accountPayable_GRN_checker_alert_remarks;

	public WebElement accountPayable_GRN_checker_alert_remarks() {
		return accountPayable_GRN_checker_alert_remarks;
	}

	// DirectionIcon
	@FindBy(xpath = "//ion-segment/ion-segment-button[2]")
	private WebElement DirectionIcon;

	public WebElement DirectionIcon() {
		return DirectionIcon;
	}

	// Fixed asset button

	@FindBy(xpath = "//ion-label[contains(text(),'Fixed assets')]")
	private WebElement fixedAsset_Button;

	public WebElement fixedAsset_Button() {
		return fixedAsset_Button;
	}

	// Fixedasset asset creation eye Button
	@FindBy(xpath = "//div[6]/ion-menu-toggle[1]/ion-item[1]/ion-buttons[1]/ion-button[2]")
	private WebElement fixedAsset_AssetCreation_EyeButton;

	public WebElement fixedAsset_AssetCreation_EyeButton() {
		return fixedAsset_AssetCreation_EyeButton;
	}

	// Fixedasset asset creation Add Button
	@FindBy(xpath = "//app-data-grid[1]/ion-content[1]/ion-fab[1]/ion-fab-button[1]/ion-icon[1]")
	private WebElement fixedAsset_AssetCreation_AddButton;

	public WebElement fixedAsset_AssetCreation_AddButton() {
		return fixedAsset_AssetCreation_AddButton;
	}

	// Fixedasset asset creation GRN Reference number text Button
	@FindBy(xpath = "//ion-col[8]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement fixedAsset_AssetCreation_GRNtextButton;

	public WebElement fixedAsset_AssetCreation_GRNtextButton() {
		return fixedAsset_AssetCreation_GRNtextButton;
	}

///-----------------------------------//
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/133']")
	private WebElement accountsPayable_Grn_EyeButton;

	public WebElement accountsPayable_Grn_EyeButton() {
		return accountsPayable_Grn_EyeButton;

	}

	@FindBy(xpath = "//input[@name='col1']")
	private WebElement accountsPayable_GrnNumber;

	public WebElement accountsPayable_GrnNumber() {
		return accountsPayable_GrnNumber;

	}

	@FindBy(xpath = "//datatable-body-cell/div[1]/ion-buttons[1]/ion-button[1]")
	private WebElement accountsPayable_Grn_SelectRecord;

	public WebElement accountsPayable_Grn_SelectRecord() {
		return accountsPayable_Grn_SelectRecord;

	}

	// BpName
	@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement accountsPayable_Grn_BpName;

	public WebElement accountsPayable_Grn_BpName() {
		return accountsPayable_Grn_BpName;

	}

	// BpBranch
	@FindBy(xpath = "//ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement accountsPayable_Grn_BpBranch;

	public WebElement accountsPayable_Grn_BpBranch() {
		return accountsPayable_Grn_BpBranch;

	}

	// InvoiceNumber
	@FindBy(xpath = "//ion-row[1]/ion-col[5]/ion-item[1]/ion-input[1]/input")
	private WebElement accountsPayable_Grn_InvoiceNumber;

	public WebElement accountsPayable_Grn_InvoiceNumber() {
		return accountsPayable_Grn_InvoiceNumber;

	}

	// DeliveryLocation
	@FindBy(xpath = "//ion-col[9]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement accountsPayable_Grn_DeliveryLocation;

	public WebElement accountsPayable_Grn_DeliveryLocation() {
		return accountsPayable_Grn_DeliveryLocation;

	}

	// PoNumber
	@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement accountsPayable_Grn_PoNumber;

	public WebElement accountsPayable_Grn_PoNumber() {
		return accountsPayable_Grn_PoNumber;

	}

	// QtyReceived
	@FindBy(xpath = "//input[@id='row.receivedQty']")
	private WebElement accountsPayable_Grn_QtyReceived;

	public WebElement accountsPayable_Grn_QtyReceived() {
		return accountsPayable_Grn_QtyReceived;

	}

	// QtyApproved
	@FindBy(xpath = "//input[@id='row.approvedQty']")
	private WebElement accountsPayable_Grn_QtyApproved;

	public WebElement accountsPayable_Grn_QtyApproved() {
		return accountsPayable_Grn_QtyApproved;

	}

	// ItemSave
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

	// reviewer remark
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
