package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryManagamentObj {
	WebDriver driver;

	public InventoryManagamentObj(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// InventoryManagament Button
	@FindBy(xpath = "//ion-label[contains(text(),'Inventory management')]")
	private WebElement inventoryManagament_button;

	public WebElement inventoryManagament_button() {
		return inventoryManagament_button;

	}
	// GRN_BP_Branch
		@FindBy(xpath = "//ion-row[1]/ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement accountPayable_GRN_BPBranch;

		public WebElement accountPayable_GRN_BPBranch() {
			return accountPayable_GRN_BPBranch;

		}

	//GRNItemDetails
	@FindBy(xpath = "//ion-label[contains(text(),'Item Details')]")
	private WebElement inventoryManagament_GRNItemDetails;

	public WebElement inventoryManagament_GRNItemDetails() {
		return inventoryManagament_GRNItemDetails;

	}
	// InventoryManagament Eye Button
		@FindBy(xpath = "//div[7]/ion-menu-toggle[1]/ion-item[1]/ion-buttons[1]/ion-button[2]")
		private WebElement inventoryManagament_InventoryRequest_EyeButton;

		public WebElement inventoryManagament_InventoryRequest_EyeButton() {
			return inventoryManagament_InventoryRequest_EyeButton;

		}

	// InventoryManagament Add Button
	//div[1]/ion-router-outlet[1]/app-data-grid[1]/ion-content[1]/ion-fab[1]/ion-fab-button[1]/ion-icon[1]
	@FindBy(xpath = "//ion-icon[@ng-reflect-name='add']|//div[1]/ion-router-outlet[1]/app-data-grid[1]/ion-content[1]/ion-fab[1]/ion-fab-button[1]/ion-icon[1]")
	private WebElement inventoryManagament_InventoryRequest_AddButton;

	public WebElement inventoryManagament_InventoryRequest_AddButton() {
		return inventoryManagament_InventoryRequest_AddButton;
	}

	// InventoryManagament Branch code
	@FindBy(xpath = "//div[1]/div[1]/div[3]/input[1]")
	private WebElement inventoryManagament_InventoryRequest_BranchCode;

	public WebElement inventoryManagament_InventoryRequest_BranchCode() {
		return inventoryManagament_InventoryRequest_BranchCode;
	}

	// InventoryManagament InventoryRequest ItemCode Description Button
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[1]/div[1]/app-kub-lov[1]/ion-select[1]")
	private WebElement inventoryManagament_InventoryRequest_ItemCodeDescriptionButton;

	public WebElement inventoryManagament_InventoryRequest_ItemCodeDescriptionButton() {
		return inventoryManagament_InventoryRequest_ItemCodeDescriptionButton;
	}

	// Saving Account Cheque Radio Button
	@FindBy(xpath = "//ion-radio-group[1]/ion-item[2]/ion-radio[1]")
	private WebElement inventoryManagament_InventoryRequest_SavingAccountChequeRadioButton;

	public WebElement inventoryManagament_InventoryRequest_SavingAccountChequeRadioButton() {
		return inventoryManagament_InventoryRequest_SavingAccountChequeRadioButton;
	}

	// RequestType Button
	@FindBy(xpath = "//datatable-scroller[1]/datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]/app-kub-lov[1]/ion-select[1]")
	private WebElement inventoryManagament_InventoryRequest_RequestTypeButton;

	public WebElement inventoryManagament_InventoryRequest_RequestTypeButton() {
		return inventoryManagament_InventoryRequest_RequestTypeButton;
	}

	// RequestType Normal Radio Button
	@FindBy(xpath = "//div[2]/ion-select-popover[1]/ion-list[1]/ion-radio-group[1]/ion-item[2]/ion-radio[1]")
	private WebElement inventoryManagament_InventoryRequest_RequestTypeNormalRadioButton;

	public WebElement inventoryManagament_InventoryRequest_RequestTypeNormalRadioButton() {
		return inventoryManagament_InventoryRequest_RequestTypeNormalRadioButton;
	}

	// RequestType Adhoc Radio Button
	@FindBy(xpath = "//div[2]/div[2]/ion-select-popover[1]/ion-list[1]/ion-radio-group[1]/ion-item[1]/ion-radio[1]")
	private WebElement inventoryManagament_InventoryRequest_RequestTypeAdhocRadioButton;

	public WebElement inventoryManagament_InventoryRequest_RequestTypeAdhocRadioButton() {
		return inventoryManagament_InventoryRequest_RequestTypeAdhocRadioButton;
	}

	// RequestQt
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[4]/div[1]/input[1]")
	private WebElement inventoryManagament_InventoryRequest_RequestQty;

	public WebElement inventoryManagament_InventoryRequest_RequestQty() {
		return inventoryManagament_InventoryRequest_RequestQty;

	}

	// Action add button for adding item code and quantaty
	@FindBy(xpath = "//datatable-body-cell/div[1]/ion-button[1]")
	private WebElement inventoryManagament_InventoryRequest_ActionAddButton;

	public WebElement inventoryManagament_InventoryRequest_ActionAddButton() {
		return inventoryManagament_InventoryRequest_ActionAddButton;
	}

	// Save Button
	@FindBy(xpath = "//ion-router-outlet[1]/page-grn-update[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1]|//div[1]/ion-router-outlet[1]/page-inventory-request-hdr-update[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1]")
	private WebElement inventoryManagament_InventoryRequest_SaveButton;

	public WebElement inventoryManagament_InventoryRequest_SaveButton() {
		return inventoryManagament_InventoryRequest_SaveButton;
	}
	//Instrument code master save button
	@FindBy(xpath = "//page-inventory-access-master-update[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1]|//page-instrument-code-master-update[1]/div[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1]")
	private WebElement inventoryMaintanance_InstrumentCodeMaster_SaveButton;

	public WebElement inventoryMaintanance_InstrumentCodeMaster_SaveButton() {
		return inventoryMaintanance_InstrumentCodeMaster_SaveButton;
	}
	
	// Notification Button
		@FindBy(xpath = "//ion-header/ion-toolbar[1]/ion-buttons[2]/ion-button[2]")
		private WebElement inventoryManagament_InventoryRequest_Notification;

		public WebElement inventoryManagament_InventoryRequest_Notification() {
			return inventoryManagament_InventoryRequest_Notification;
		}
		
		
		// Popup close Button
				@FindBy(xpath = "//*[@id=\"toast-container\"]/div/button")
				private WebElement inventoryManagament_InventoryRequest_PopupCloseButton;

				public WebElement inventoryManagament_InventoryRequest_PopupCloseButton() {
					return inventoryManagament_InventoryRequest_PopupCloseButton;
				}
		
	// Inventory maintenance
	@FindBy(xpath = "//ion-app[1]/ion-split-pane[1]/ion-menu[1]/ion-content[1]/custom-side-menu[1]/ion-list[1]/ion-item[7]/ion-icon[1]")
	private WebElement inventoryMaintenance_Button;

	public WebElement inventoryMaintenance_Button() {
		return inventoryMaintenance_Button;
	}

	// Instrument code master eye button
	@FindBy(xpath = "//ion-content[1]/custom-side-menu[1]/ion-list[1]/div[7]/ion-menu-toggle[1]/ion-item[1]/ion-buttons[1]/ion-button[2]")
	private WebElement inventoryMaintenance_InstrumentCodeMaster_EyeButton;

	public WebElement inventoryMaintenance_InstrumentCodeMaster_EyeButton() {
		return inventoryMaintenance_InstrumentCodeMaster_EyeButton;
	}

	// Instrument Code text box
	@FindBy(xpath = "//ion-content[1]/form[1]/ion-infinite-scroll[1]/ion-grid[1]/ion-row[1]/ion-col[1]/ion-item[1]/ion-input[1]/input[1]")
	private WebElement inventoryMaintenance_InstrumentCodeMaster_InstrumentCodeTextBox;

	public WebElement inventoryMaintenance_InstrumentCodeMaster_InstrumentCodeTextBox() {
		return inventoryMaintenance_InstrumentCodeMaster_InstrumentCodeTextBox;
	}

	// Instrument Description text box
	@FindBy(xpath = "//*[@id=\"main-content\"]/app-tabs/ion-tabs/div/ion-router-outlet/page-instrument-code-master-update/ion-content/form/ion-infinite-scroll/ion-grid/ion-row[1]/ion-col[2]/ion-item/ion-input/input")
	private WebElement inventoryMaintenance_InstrumentCodeMaster_InstrumentDescriptionTextBox;

	public WebElement inventoryMaintenance_InstrumentCodeMaster_InstrumentDescriptionTextBox() {
		return inventoryMaintenance_InstrumentCodeMaster_InstrumentDescriptionTextBox;
	}

	// Routing Mask Text box

	@FindBy(xpath = "//page-instrument-code-master-update[1]/ion-content[1]/form[1]/ion-infinite-scroll[1]/ion-grid[1]/ion-row[2]/ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[3]/input[1]")
	private WebElement inventoryMaintenance_InstrumentCodeMaster_RoutingMask;

	public WebElement inventoryMaintenance_InstrumentCodeMaster_RoutingMask() {
		return inventoryMaintenance_InstrumentCodeMaster_RoutingMask;
	}

	// Track Reorder Level

	@FindBy(xpath = "//div/ion-router-outlet/page-instrument-code-master-update/ion-content/form/ion-infinite-scroll/ion-grid/ion-row[2]/ion-col[2]/app-kub-lov/span/ng-select/div/div/div[3]/input")
	private WebElement inventoryMaintenance_InstrumentCodeMaster_TrackReorderLevel;

	public WebElement inventoryMaintenance_InstrumentCodeMaster_TrackReorderLevel() {
		return inventoryMaintenance_InstrumentCodeMaster_TrackReorderLevel;
	}

	// Track Excess Level

	@FindBy(xpath = "//div/ion-router-outlet/page-instrument-code-master-update/ion-content/form/ion-infinite-scroll/ion-grid/ion-row[2]/ion-col[3]/app-kub-lov/span/ng-select/div/div/div[3]/input")
	private WebElement inventoryMaintenance_InstrumentCodeMaster_TrackExcessLevel;

	public WebElement inventoryMaintenance_InstrumentCodeMaster_TrackExcessLevel() {
		return inventoryMaintenance_InstrumentCodeMaster_TrackExcessLevel;
	}

	// Denomination Applied

	@FindBy(xpath = "//div/ion-router-outlet/page-instrument-code-master-update/ion-content/form/ion-infinite-scroll/ion-grid/ion-row[3]/ion-col[1]/app-kub-lov/span/ng-select/div/div/div[3]/input")
	private WebElement inventoryMaintenance_InstrumentCodeMaster_DenominationApplied;

	public WebElement inventoryMaintenance_InstrumentCodeMaster_DenominationApplied() {
		return inventoryMaintenance_InstrumentCodeMaster_DenominationApplied;
	}

	// Auto Serial Number

	@FindBy(xpath = "//div/ion-router-outlet/page-instrument-code-master-update/ion-content/form/ion-infinite-scroll/ion-grid/ion-row[3]/ion-col[2]/app-kub-lov/span/ng-select/div/div/div[3]/input")
	private WebElement inventoryMaintenance_InstrumentCodeMaster_AutoSerialNumber;

	public WebElement inventoryMaintenance_InstrumentCodeMaster_AutoSerialNumber() {
		return inventoryMaintenance_InstrumentCodeMaster_AutoSerialNumber;
	}

	//Starting Serial Number

	@FindBy(xpath = "//ion-content/form/ion-infinite-scroll/ion-grid/ion-row[4]/ion-col[1]/ion-item/ion-input/input")
	private WebElement inventoryMaintenance_InstrumentCodeMaster_StartingSerialNumber;

	public WebElement inventoryMaintenance_InstrumentCodeMaster_StartingSerialNumber() {
		return inventoryMaintenance_InstrumentCodeMaster_StartingSerialNumber;
	}
	// Last Serial Number

	@FindBy(xpath = "//ion-content/form/ion-infinite-scroll/ion-grid/ion-row[4]/ion-col[2]")
	private WebElement inventoryMaintenance_InstrumentCodeMaster_LastSerialNumber;

	public WebElement inventoryMaintenance_InstrumentCodeMaster_LastSerialNumber() {
		return inventoryMaintenance_InstrumentCodeMaster_LastSerialNumber;
	}
	//Save button
	@FindBy(xpath = "//span[contains(text(),'Submit')]")
	private WebElement inventoryMaintenance_InstrumentCodeMaster_SaveButton;

	public WebElement inventoryMaintenance_InstrumentCodeMaster_SaveButton() {
		return inventoryMaintenance_InstrumentCodeMaster_SaveButton;
	}
	//Inventory access master Eye Button

	@FindBy(xpath = "//div[7]/ion-menu-toggle[4]/ion-item[1]/ion-buttons[1]/ion-button[2]")
	private WebElement inventoryMaintenance_InventoryAccessMaster_EyeButton;

	public WebElement inventoryMaintenance_InventoryAccessMaster_EyeButton() {
		return inventoryMaintenance_InventoryAccessMaster_EyeButton;
	}
	//Inventory Access Master_Access Branch Code

	@FindBy(xpath = "//ion-grid[1]/ion-row[1]/ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement inventoryMaintenance_InventoryAccessMaster_Access_Branch_Code;

	public WebElement inventoryMaintenance_InventoryAccessMaster_Access_Branch_Code() {
		return inventoryMaintenance_InventoryAccessMaster_Access_Branch_Code;
	}
	//Inventory Access Master_InventoryBranchCode
		@FindBy(xpath = "//page-inventory-access-master-update[1]/ion-content[1]/form[1]/ion-grid[1]/ion-row[1]/ion-col[5]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement inventoryMaintenance_InventoryAccessMaster_InventoryBranchCode;

		public WebElement inventoryMaintenance_InventoryAccessMaster_InventoryBranchCode() {
			return inventoryMaintenance_InventoryAccessMaster_InventoryBranchCode;
		}
	//Inventory Access Master_PlaceOrderCheckBox
		@FindBy(xpath = "//ion-content[1]/form[1]/ion-grid[1]/ion-row[1]/ion-col[8]/ion-item[1]/ion-checkbox[1]")
		private WebElement inventoryMaintenance_InventoryAccessMaster_PlaceOrderCheckBox;
		public WebElement inventoryMaintenance_InventoryAccessMaster_PlaceOrderCheckBox() {
					return inventoryMaintenance_InventoryAccessMaster_PlaceOrderCheckBox;
				}	
		//Inventory Access Master_PlaceRequestCheckBox
		
		@FindBy(xpath = "//ion-content[1]/form[1]/ion-grid[1]/ion-row[1]/ion-col[7]/ion-item[1]/ion-checkbox[1]")
		private WebElement inventoryMaintenance_InventoryAccessMaster_PlaceRequestCheckBox;
		public WebElement inventoryMaintenance_InventoryAccessMaster_PlaceRequestCheckBox() {
					return inventoryMaintenance_InventoryAccessMaster_PlaceRequestCheckBox;
				}	
		//Inventory Access Master_IssueCheckBox
		
		@FindBy(xpath = "//ion-content[1]/form[1]/ion-grid[1]/ion-row[1]/ion-col[10]/ion-item[1]/ion-checkbox[1]")
		private WebElement inventoryMaintenance_InventoryAccessMaster_IssueCheckBox;
		public WebElement inventoryMaintenance_InventoryAccessMaster_IssueCheckBox() {
					return inventoryMaintenance_InventoryAccessMaster_IssueCheckBox;
				}
	
		//Inventory Access Master_ReceiveCheckBox
		
				@FindBy(xpath = "//ion-content[1]/form[1]/ion-grid[1]/ion-row[1]/ion-col[9]/ion-item[1]/ion-checkbox[1]")
				private WebElement inventoryMaintenance_InventoryAccessMaster_ReceieveCheckBox;
				public WebElement inventoryMaintenance_InventoryAccessMaster_ReceieveCheckBox() {
							return inventoryMaintenance_InventoryAccessMaster_ReceieveCheckBox;
						}
			
 //Inventory Access Master_InventoryBranchCheckBox
 
 @FindBy(xpath = "//ion-content[1]/form[1]/ion-grid[1]/ion-row[1]/ion-col[4]/ion-item[1]/ion-checkbox[1]")
	private WebElement inventoryMaintenance_InventoryAccessMaster_InventoryBranchCheckBox;
	public WebElement inventoryMaintenance_InventoryAccessMaster_InventoryBranchCheckBox() {
				return inventoryMaintenance_InventoryAccessMaster_InventoryBranchCheckBox;
			}
	//Account Payable
	 
	 @FindBy(xpath = "//ion-content[1]/custom-side-menu[1]/ion-list[1]/ion-item[3]")
		private WebElement accountPayableButton;
		public WebElement accountPayableButton() {
					return accountPayableButton;
				}
//Goods Received note (GRN) Eye button		
		 @FindBy(xpath = "//custom-side-menu[1]/ion-list[1]/div[3]/ion-menu-toggle[3]/ion-item[1]/ion-buttons[1]/ion-button[2]")
			private WebElement accountPayable_GoodsReceivedNoteGRNEyeButton;
			public WebElement accountPayable_GoodsReceivedNoteGRNEyeButton() {
						return accountPayable_GoodsReceivedNoteGRNEyeButton;
					}	

		
		//Goods Received note (GRN) BP Name	
	 @FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
			private WebElement accountPayable_GrnBpName;
		public WebElement accountPayable_GrnBpName() {
							return accountPayable_GrnBpName;
						}
		//Goods Received note (GRN) Invoice number
		
	@FindBy(xpath = "//form[1]/ion-infinite-scroll[1]/ion-grid[1]/ion-row[1]/ion-col[5]/ion-item[1]/ion-input[1]/input[1]")
			private WebElement accountPayable_GrnInvoiceNumber;
		public WebElement accountPayable_GrnInvoiceNumber() {
					return accountPayable_GrnInvoiceNumber;
							}
			//Goods Received note (GRN) Delivery Location
 @FindBy(xpath = "//ion-grid[1]/ion-row[1]/ion-col[9]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement accountPayable_GrnDeliveryLocation;
	public WebElement accountPayable_GrnDeliveryLocation() {
									return accountPayable_GrnDeliveryLocation;
								}	
				
	//Goods Received note (GRN) PO Number textbox
		 @FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
			private WebElement accountPayable_GrnPONumber;
		public WebElement accountPayable_GrnPONumber() {
					return accountPayable_GrnPONumber;
									}		
		//Goods Received note (GRN) Qty Received textbox
		 @FindBy(xpath = "//input[@id='row.receivedQty']")
			private WebElement accountPayable_GrnQtyReceived;
		public WebElement accountPayable_GrnQtyReceived() {
					return accountPayable_GrnQtyReceived;
									}		
		//Goods Received note (GRN) Qty Approved textbox
		 @FindBy(xpath = "//input[@id='row.approvedQty']")
			private WebElement accountPayable_GrnQtyApproved;
		public WebElement accountPayable_GrnQtyApproved() {
					return accountPayable_GrnQtyApproved;
									}	
		
		//Goods Received note (GRN) Save Button
		 @FindBy(xpath = "(//ion-toolbar/ion-buttons[1]/ion-button[1])[2]")
		           
			private WebElement accountPayable_GrnSaveButton;
		public WebElement accountPayable_GrnSaveButton() {
					return accountPayable_GrnSaveButton;
									}		
		
		//Submit button
		 @FindBy(xpath = "//ion-header/ion-toolbar[1]/ion-buttons[2]/app-kub-decision-button[1]/div[1]/span[1]/ion-button[1]")
			private WebElement accountPayable_SubmitButton;
		public WebElement accountPayable_SubmitButton() {
					return accountPayable_SubmitButton;
		}
		//GRN Submit from maker notification Submit button
		 @FindBy(xpath = "//ion-header/ion-toolbar[1]/ion-buttons[2]/app-kub-decision-button[1]/div[1]/span[1]/ion-button[1]")
			private WebElement accountPayable_GRNNotificationSubmitButton;
		public WebElement accountPayable_GRNNotificationSubmitButton() {
					return accountPayable_GRNNotificationSubmitButton;
		}
		//--------------priyanka------
		

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
		
		
		@FindBy(xpath="//app-inventory-items-details[1]/ion-content[1]/form[1]/ion-grid[1]/ion-row[1]/ion-col[2]/app-kub-date-time[1]/ion-item[1]/div[1]/span[1]")
		private WebElement inventoryItemCalandar_report;
		public WebElement inventoryItemCalandar_report()
				{
					return inventoryItemCalandar_report;
					
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
		
		
		@FindBy(xpath="//app-inventory-items-details[1]/div[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[1]/ion-button[1]")
		private WebElement report_viewButton;
		public WebElement report_viewButton()
		{
			return report_viewButton;
		}
		
		
		
		
		

		@FindBy(xpath="//ion-list[1]/div[1]/ion-menu-toggle[15]/ion-item[1]/ion-buttons[1]/ion-button[1]")
		private WebElement report_inventoryItemDetail_EditButton;
		public WebElement report_inventoryItemDetail_EditButton()
		{
			return report_inventoryItemDetail_EditButton;
		}
		
		
		
		
		@FindBy(xpath="//ion-row[1]/ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement report_inventoryItemDetail_ItemDescription;
		public WebElement report_inventoryItemDetail_ItemDescription()
		{
			return report_inventoryItemDetail_ItemDescription;
		}
		
		
		@FindBy(xpath="//ion-menu[1]/ion-content[1]/custom-side-menu[1]/ion-list[1]/div[1]/ion-menu-toggle[16]/ion-item[1]/ion-buttons[1]/ion-button[1]")
		private WebElement report_inventoryRequest_Editbutton;
		public WebElement report_inventoryRequest_Editbutton()
		{
			return report_inventoryRequest_Editbutton;
		}
			
		@FindBy(xpath="//ion-grid[1]/ion-row[1]/ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement report_inventoryRequest_RequestReferenceNo;
		public WebElement report_inventoryRequest_RequestReferenceNo()
		{
			return report_inventoryRequest_RequestReferenceNo;
		}
		
		@FindBy(xpath="//app-inventory-request-report[1]/ion-content[1]/form[1]/ion-grid[1]/ion-row[1]/ion-col[2]/app-kub-date-time[1]/ion-item[1]/div[1]/span[1]")
		private WebElement report_inventoryRequest_calanderbutton;
		public WebElement report_inventoryRequest_calanderbutton()
		{
			return report_inventoryRequest_calanderbutton;
		}
		//ReportNext
		@FindBy(xpath = "//tbody/tr[2]/td[7]/input[1]\"")
		private WebElement Report_report_NextButton;

		public WebElement Report_report_NextButton() {
		return Report_report_NextButton;
						}	
		
		
		@FindBy(xpath="//div[1]/ion-router-outlet[1]/app-inventory-request-report[1]/div[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[1]/ion-button[1]")
		private WebElement report_inventoryRequest_viewbutton;
		public WebElement report_inventoryRequest_viewbutton()
		{
			return report_inventoryRequest_viewbutton;
		}	
		
		
		@FindBy(xpath="//custom-side-menu[1]/ion-list[1]/div[1]/ion-menu-toggle[18]/ion-item[1]/ion-buttons[1]/ion-button[1]")
		private WebElement report_PurchaseRequsition_editbutton;
		public WebElement report_PurchaseRequsition_editbutton()
		{
			return report_PurchaseRequsition_editbutton;
		}	
			
		@FindBy(xpath="//ion-grid[1]/ion-row[1]/ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement report_PurchaseRequsition_IndentReferenceNo;
		public WebElement report_PurchaseRequsition_IndentReferenceNo()
		{
			return report_PurchaseRequsition_IndentReferenceNo;
		}	
		@FindBy(xpath="//app-purchase-requisition[1]/div[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[1]/ion-button[1]/a[1]")
		private WebElement report_PurchaseRequsition_viewbutton;
		public WebElement report_PurchaseRequsition_viewbutton()
		{
			return report_PurchaseRequsition_viewbutton;
		}	
				
		@FindBy(xpath="//ion-content[1]/form[1]/ion-grid[1]/ion-row[1]/ion-col[2]/app-kub-date-time[1]/ion-item[1]/div[1]/span[1]")
		private WebElement report_PurchaseRequsition_calanderbutton;
		public WebElement report_PurchaseRequsition_calanderbutton()
		{
			return report_PurchaseRequsition_calanderbutton;
		}	
			
			
		
		@FindBy(xpath="//custom-side-menu[1]/ion-list[1]/div[1]/ion-menu-toggle[20]/ion-item[1]/ion-buttons[1]/ion-button[1]")
		private WebElement report_StockIssuance_editbutton;
		public WebElement report_StockIssuance_editbutton()
		{
			return report_StockIssuance_editbutton;
		}	
		
		@FindBy(xpath="//form[1]/ion-grid[1]/ion-row[1]/ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement report_StockIssuance_IssuanceReffrenceNo;
		public WebElement report_StockIssuance_IssuanceReffrenceNo()
		{
			return report_StockIssuance_IssuanceReffrenceNo;
		}	
		
		@FindBy(xpath="//a[contains(text(),'View')]")
		private WebElement report_StockIssuance_ViewButton;
		public WebElement report_StockIssuance_ViewButton()
		{
			return report_StockIssuance_ViewButton;
		}	
		
		
		@FindBy(xpath="//ion-header/ion-toolbar[1]/ion-buttons[1]/ion-button[1]")
		private WebElement report_inventoryStockReceipt_ViewButton;
		public WebElement report_inventoryStockReceipt_ViewButton()
		{
			return report_inventoryStockReceipt_ViewButton;
		}			
		
		@FindBy(xpath="//ion-grid[1]/ion-row[1]/ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement report_inventoryStockReceipt_POReferenceTextbox;
		public WebElement report_inventoryStockReceipt_POReferenceTextbox()
		{
			return report_inventoryStockReceipt_POReferenceTextbox;
		}	
		
		

		@FindBy(xpath="//custom-side-menu[1]/ion-list[1]/div[1]/ion-menu-toggle[17]/ion-item[1]/ion-buttons[1]/ion-button[1]")
		private WebElement report_inventoryStockReceipt_EditButton;
		public WebElement report_inventoryStockReceipt_EditButton()
		{
			return report_inventoryStockReceipt_EditButton;
		}
		@FindBy(xpath="//custom-side-menu[1]/ion-list[1]/div[1]/ion-menu-toggle[21]/ion-item[1]/ion-buttons[1]/ion-button[1]")
		private WebElement report_StockReturn_EditButton;
		public WebElement report_StockReturn_EditButton()
		{
			return report_StockReturn_EditButton;
		}
		@FindBy(xpath="//ion-grid[1]/ion-row[1]/ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement report_StockReturn_returntype_Textbox;
		public WebElement report_StockReturn_returntype_Textbox()
		{
			return report_StockReturn_returntype_Textbox;
		}
		@FindBy(xpath="//custom-side-menu[1]/ion-list[1]/div[1]/ion-menu-toggle[22]/ion-item[1]/ion-buttons[1]/ion-button[1]")
		private WebElement report_FundRequsitionReport_EditButton;
		public WebElement report_FundRequsitionReport_EditButton()
		{
			return report_FundRequsitionReport_EditButton;
		}
		
			
		
		@FindBy(xpath="//form[1]/ion-grid[1]/ion-row[1]/ion-col[1]/app-kub-date-time[1]/ion-item[1]/div[1]/span[1]")
		private WebElement report_FundRequsitionReport_CalendarButton;
		public WebElement report_FundRequsitionReport_CalendarButton()
		{
			return report_FundRequsitionReport_CalendarButton;
		}
		
		
		
		@FindBy(xpath="//custom-side-menu[1]/ion-list[1]/div[1]/ion-menu-toggle[15]/ion-item[1]/ion-buttons[1]/ion-button[1]")
		private WebElement report_InventoryItemDetails_EditButton;
		public WebElement report_InventoryItemDetails_EditButton()
		{
			return report_InventoryItemDetails_EditButton;
		}
		
		@FindBy(xpath="//form[1]/ion-grid[1]/ion-row[1]/ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement report_InventoryItemDetails_ItemDescription_textbox;
		public WebElement report_InventoryItemDetails_ItemDescription_textbox()
		{
			return report_InventoryItemDetails_ItemDescription_textbox;
		}	
		
		@FindBy(xpath="//app-inventory-items-details[1]/div[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[1]/ion-button[1]")
		private WebElement report_InventoryItemDetails_ViewButton;
		public WebElement report_InventoryItemDetails_ViewButton()
		{
			return report_InventoryItemDetails_ViewButton;
		}	
		
			
		@FindBy(xpath="//li[8]/a/i")
		private WebElement inventory_Next;
		public WebElement inventory_Next()
		{
			return inventory_Next;
		}

	//---------------------arshat page obj----
		

		@FindBy(xpath = "//ion-select[@class='datagrid-lov ng-valid md hydrated ng-touched ng-dirty ion-valid ion-touched ion-dirty']")
		private WebElement inventory_FinanceOption;

		public WebElement inventoryFinanceOption() {

			return inventory_FinanceOption;
		}

		@FindBy(xpath = "//ion-segment/ion-segment-button[2]")
		private WebElement inventory_Transfericon;

		public WebElement inventoryTransfericon() {

			return inventory_Transfericon;
		}
		
		@FindBy(xpath = "//div[@id='toast-container']/div/div[@role='alertdialog']") 
		private WebElement inventory_Popup;

		public WebElement inventory_Popup() {

			return inventory_Popup;
		}
		
		@FindBy(xpath = "//ion-label[contains(text(),'Inventory management')]")
		private WebElement inventory_Management;

		public WebElement inventoryManagement() {

			return inventory_Management;
		}
		
		@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/11']")
		private WebElement inventory_StockissueEye;

		public WebElement inventory_StockissueEye() {

			return inventory_StockissueEye;
		}
		
		@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row[1]//ion-button[1]")
		private WebElement inventory_StockissueGridEye;

		public WebElement inventory_StockissueGridEye() {

			return inventory_StockissueGridEye;
		}
		
		@FindBy(xpath = "//ion-col[5]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]")
		private WebElement inventory_StockissueRefNo;

		public WebElement inventory_StockissueRefNo() {

			return inventory_StockissueRefNo;
		}
		
		@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/4']")
		private WebElement inventory_StockConfirmEye;

		public WebElement inventory_StockConfirmEye() {

			return inventory_StockConfirmEye;
		}
		
		@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid/3']")
		private WebElement inventory_StockConfirmEdit;

		public WebElement inventoryStockConfirmEdit() {

			return inventory_StockConfirmEdit;
		}
		
		@FindBy(xpath = "//ion-fab/ion-fab-button[@id='addBtn']")
		private WebElement inventory_StockConfirmAdd;

		public WebElement inventoryStockConfirmAdd() {

			return inventory_StockConfirmAdd;
		}

		 
		
	 
		
		@FindBy(xpath = "//input[@name='ifcIssuedQuantity']") 
		private WebElement inventory_IssueQuantity;

		public WebElement StockConfirm_IssueQuantity() {

			return inventory_IssueQuantity;
		}
		
	 
		
		@FindBy(xpath = "//ion-checkbox[@name='ifcAcceptStatus']") 
		private WebElement inventory_AcceptCheckBox;

		public WebElement StockConfirm_AcceptCheckBox() {

			return inventory_AcceptCheckBox;
		}
		
	 
		 
		
	 
		
	 
		
		@FindBy(xpath = "//button[@aria-label='Close']") 
		private WebElement inventory_Notification_Close;

		public WebElement StockConfirm_Notification_Close() {

			return inventory_Notification_Close;
		}	
		

	 
	 

		 
		@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/12']")
		private WebElement inventory_StockReturnBranchEye;

		public WebElement inventoryStockReturnBranchEye() {

			return inventory_StockReturnBranchEye;
		}

		@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid/9']")
		private WebElement inventory_StockReturnBranchEdit;

		public WebElement inventoryStockReturnBranchEdit() {

			return inventory_StockReturnBranchEdit;
		}

		@FindBy(xpath = "//ion-fab/ion-fab-button[@id='addBtn']")
		private WebElement inventory_StockReturnBranchAdd;

		public WebElement inventoryStockReturnBranchAdd() {

			return inventory_StockReturnBranchAdd;
		}

		@FindBy(xpath = "//ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement inventory_RequestReferanceNumber;

		public WebElement inventoryRequestReferanceNumber() {

			return inventory_RequestReferanceNumber;
		}

		@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement inventory_IssueReferanceNo;

		public WebElement inventoryIssueReferanceNo() {

			return inventory_IssueReferanceNo;
		}

		@FindBy(xpath = "//ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
		private WebElement inventory_ItemCode;

		public WebElement inventoryItemCode() {

			return inventory_ItemCode;
		}
		
		@FindBy(xpath = "//input[@name='ion-input-37']") 
		private WebElement inventory_ItemDescrption;

		public WebElement inventoryItemDescrption() {

			return inventory_ItemDescrption;
		}

		@FindBy(xpath = "//input[@name='ifrReturnQty']")
		private WebElement inventory_ReturnQuantity;

		public WebElement inventoryReturnQuantity() {

			return inventory_ReturnQuantity;
		}
		
		@FindBy(xpath = "//input[@name='ifrStartSerialNumber']") 
		private WebElement inventory_Start_Serial_No;

		public WebElement inventoryStart_Serial_No() {

			return inventory_Start_Serial_No;
		}
		
		@FindBy(xpath = "//input[@name='ifrEndSerialNumber']") 
		private WebElement inventory_End_Serial_No;

		public WebElement inventoryEnd_Serial_No() {

			return inventory_End_Serial_No;
		}
		
		@FindBy(xpath = "//input[@name='ifrInventoryBranchId']") 
		private WebElement inventory_InventoryBranchId;

		public WebElement inventory_InventoryBranchId() {

			return inventory_InventoryBranchId;
		}
		
		@FindBy(xpath = "//input[@name='ifrInventoryBranchName']") 
		private WebElement inventory_InventoryBranchName;

		public WebElement inventory_InventoryBranchName() {

			return inventory_InventoryBranchName;
		}
		
		@FindBy(xpath = "//ion-col[10]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input") 
		private WebElement inventory_ReturnType;

		public WebElement inventory_ReturnType() {

			return inventory_ReturnType;
		}
		
		@FindBy(xpath = "//ion-col[11]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input") 
		private WebElement inventory_ReturnReason;

		public WebElement inventory_ReturnReason() {

			return inventory_ReturnReason;
		}
		
		@FindBy(xpath = "//div[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1]") 
		private WebElement inventory_Save;

		public WebElement inventory_Save() {

			return inventory_Save;
		}
		
		@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/inbox']") 
		private WebElement inventory_MakerNotification;

		public WebElement inventory_MakerNotification() {

			return inventory_MakerNotification;
		}
		
		@FindBy(xpath = "//app-inbox//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[2]//span") 
		private WebElement inventory_ReferanceId;

		public WebElement inventory_ReferanceId() {

			return inventory_ReferanceId;
		}
		
		@FindBy(xpath = "//app-inbox//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[1]//ion-button") 
		private WebElement inventory_ActionButton;

		public WebElement inventory_ActionButton() {

			return inventory_ActionButton;
		}
		
		@FindBy(xpath = "//span[contains(text(),'Submit')]") 
		private WebElement inventory_Submit;

		public WebElement inventory_Submit() {

			return inventory_Submit;
		}
		
		@FindBy(xpath = "//textarea[@name='remarks']") 
		private WebElement inventory_Remark;

		public WebElement inventory_Remark() {

			return inventory_Remark;
		}
		
		@FindBy(xpath = "//ion-button[contains(text(),'Submit')]") 
		private WebElement inventory_RemarkSubmit;

		public WebElement inventory_RemarkSubmit() {

			return inventory_RemarkSubmit;
		}
		
		//Reviewer
		@FindBy(xpath = "//div[@id='toast-container']/div/div[@role='alertdialog']") 
		private WebElement inventory_Revieweralert;

		public WebElement inventory_Revieweralert() {

			return inventory_Revieweralert;
		}
		
		@FindBy(xpath = "//div[@id='toast-container']/div/div[@role='alertdialog']") 
		private WebElement inventory_ReviewerId;

		public WebElement inventory_ReviewerId() {

			return inventory_ReviewerId;
		}
		
		@FindBy(xpath = "//ion-button/ion-icon[@name='person-circle']") 
		private WebElement inventory_MakerLogo;

		public WebElement inventory_MakerLogo() {

			return inventory_MakerLogo;
		}
		
		@FindBy(xpath = "//ion-content[1]/div[1]/ion-list[1]/ion-item[3]/ion-icon[1]") 
		private WebElement inventory_MakerLogout;

		public WebElement inventory_MakerLogout() {

			return inventory_MakerLogout;
		}
		
		//Inventory Maintance
		@FindBy(xpath = "//ion-label[contains(text(),'Inventory maintenance')]") 
		private WebElement inventory_InventoryMaintenance;

		public WebElement inventory_InventoryMaintenance() {

			return inventory_InventoryMaintenance;
		}
		
		@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/187']") 
		private WebElement inventory_MasterItemEye;

		public WebElement inventory_MasterItemEye() {

			return inventory_MasterItemEye;
		}
		
		@FindBy(xpath = "//ion-icon[@ng-reflect-name='search']") 
		private WebElement inventory_SearchIcon;

		public WebElement inventory_SearchIcon() {

			return inventory_SearchIcon;
		}
		
		@FindBy(xpath = "//input[@name='col6']") 
		private WebElement inventory_Itemvalue;

		public WebElement inventory_Itemvalue() {

			return inventory_Itemvalue;
		}
		
		@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row[1]//ion-button[2]") 
		private WebElement inventory_PencilIcon;

		public WebElement inventory_PencilIcon() {

			return inventory_PencilIcon;
		}
		
		@FindBy(xpath = "//input[@name='currentBalanceQuantity']") 
		private WebElement inventory_CurrentQuantity;

		public WebElement inventory_CurrentQuantity() {

			return inventory_CurrentQuantity;
		}
		@FindBy(xpath = "//ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement StockConfirm_RequestReferanceNumber;

		public WebElement StockConfirm_RequestReferanceNumber() {

			return StockConfirm_RequestReferanceNumber;
		}
		
		@FindBy(xpath = "(//ion-textarea[@name='remarks'])[2]") 
		private WebElement StockConfirm_Remark;

		public WebElement StockConfirm_Remark() {

			return StockConfirm_Remark;
		}
		
		 

		@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement StockConfirm_ItemCode;

		public WebElement StockConfirm_ItemCode() {

			return StockConfirm_ItemCode;
		}
		
		@FindBy(xpath = "//ion-input/input[@name='ifcIssueRefNo']")
		private WebElement StockConfirm_IssueReferanceNo;

		public WebElement StockConfirm_IssueReferanceNo() {

			return StockConfirm_IssueReferanceNo;
		}
		
		@FindBy(xpath = "//input[@name='ion-input-1085']") 
		private WebElement StockConfirm_ItemDescrption;

		public WebElement StockConfirm_ItemDescrption() {

			return StockConfirm_ItemDescrption;
		}
		
		 
		
		@FindBy(xpath = "//input[@name='ifcStartSerialNumber']") 
		private WebElement StockConfirm_StartSerialNo;

		public WebElement StockConfirm_StartSerialNo() {

			return StockConfirm_StartSerialNo;
		}
		
		@FindBy(xpath = "//input[@name='ifcEndSerialNumber']") 
		private WebElement StockConfirm_EndSerialNo;

		public WebElement StockConfirm_EndSerialNo() {

			return StockConfirm_EndSerialNo;
		}
		
		 
		
		@FindBy(xpath = "//div[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1]") 
		private WebElement StockConfirm_Save;

		public WebElement StockConfirm_Save() {

			return StockConfirm_Save;
		}
		
		@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/inbox']") 
		private WebElement StockConfirm_MakerNotification;

		public WebElement StockConfirm_MakerNotification() {

			return StockConfirm_MakerNotification;
		}
		
		@FindBy(xpath = "//app-inbox//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[2]//span") 
		private WebElement StockConfirm_ReferanceId;

		public WebElement StockConfirm_ReferanceId() {

			return StockConfirm_ReferanceId;
		}
		
		@FindBy(xpath = "//app-inbox//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[1]//ion-button") 
		private WebElement StockConfirm_ActionButton;

		public WebElement StockConfirm_ActionButton() {

			return StockConfirm_ActionButton;
		}
		
		@FindBy(xpath = "//span[contains(text(),'Submit')]") 
		private WebElement StockConfirm_Submit;

		public WebElement StockConfirm_Submit() {

			return StockConfirm_Submit;
		}
		
	 
		
		@FindBy(xpath = "//ion-button[contains(text(),'Submit')]") 
		private WebElement StockConfirm_RemarkSubmit;

		public WebElement StockConfirm_RemarkSubmit() {

			return StockConfirm_RemarkSubmit;
		}
		
		@FindBy(xpath = "//div[@id='toast-container']/div/div[@role='alertdialog']") 
		private WebElement StockConfirm_ReviewerId;

		public WebElement StockConfirm_ReviewerId() {

			return StockConfirm_ReviewerId;
		}
		
	 
		@FindBy(xpath = "//ion-list[1]/div[1]/ion-menu-toggle[19]/ion-item[1]/ion-buttons[1]/ion-button[1]") 
		private WebElement Report_report_StockConfirmationReport;

		public WebElement Report_report_StockConfirmationReport() {

			return Report_report_StockConfirmationReport;
		}
			
		@FindBy(xpath = "//span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]") 
		private WebElement Report_report_StockConfirmationReport_acceptStatus;

		public WebElement Report_report_StockConfirmationReport_acceptStatus() {

			return Report_report_StockConfirmationReport_acceptStatus;
		}	
		
		 	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
