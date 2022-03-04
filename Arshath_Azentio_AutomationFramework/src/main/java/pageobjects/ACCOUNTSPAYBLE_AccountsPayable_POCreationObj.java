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

}
