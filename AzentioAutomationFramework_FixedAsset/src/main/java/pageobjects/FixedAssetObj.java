package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FixedAssetObj {
	WebDriver driver;

	public FixedAssetObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Fixed asset button
	
	@FindBy(xpath = "//ion-label[contains(text(),'Fixed assets')]")
	private WebElement fixedAsset_Button;

	public WebElement fixedAsset_Button() {
		return fixedAsset_Button;
	}
	
	//Fixed asset Fixed asset creation eye button
	
		@FindBy(xpath = "//ion-list[1]/div[6]/ion-menu-toggle[1]/ion-item[1]/ion-buttons[1]/ion-button[2]")
		private WebElement fixedAsset_AssetCreation_EyeButton;

		public WebElement fixedAsset_AssetCreation_EyeButton() {
			return fixedAsset_AssetCreation_EyeButton;
		}
		//Fixed asset Fixed asset Allocation eye button
		
			@FindBy(xpath = "//body/app-root[1]/ion-app[1]/ion-split-pane[1]/ion-menu[1]/ion-content[1]/custom-side-menu[1]/ion-list[1]/div[6]/ion-menu-toggle[5]/ion-item[1]/ion-buttons[1]/ion-button[2]")
			private WebElement fixedAsset_AssetAllocation_EyeButton;

			public WebElement fixedAsset_AssetAllocation_EyeButton() {
				return fixedAsset_AssetAllocation_EyeButton;
			}	
			
			
						
			//Fixed asset Fixed asset Allocation AssetRefferenceNumber
			
			@FindBy(xpath = "//ion-row[1]/ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
			private WebElement fixedAsset_AssetAllocation_AssetRefferenceNumber;

			public WebElement fixedAsset_AssetAllocation_AssetRefferenceNumber() {
				return fixedAsset_AssetAllocation_AssetRefferenceNumber;
			}
//Fixed asset Fixed asset Allocation Item Number
			
			@FindBy(xpath = "//ion-col[5]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
			private WebElement fixedAsset_AssetAllocation_ItemNumber;

			public WebElement fixedAsset_AssetAllocation_ItemNumber() {
				return fixedAsset_AssetAllocation_ItemNumber;
			}
//Fixed asset Fixed asset EmployeeID
			
			@FindBy(xpath = "//ion-grid[1]/ion-row[1]/ion-col[9]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
			private WebElement fixedAsset_AssetAllocation_EmployeeID;

			public WebElement fixedAsset_AssetAllocation_EmployeeID() {
				return fixedAsset_AssetAllocation_EmployeeID;
			}			
			
// search record 
			//ion-icon[@title='Enable Search']
			@FindBy(xpath = "//ion-icon[@title='Enable Search']")
			private WebElement searchIconInApprovedListView;

			public WebElement searchIconInApprovedListView() {
				return searchIconInApprovedListView;
			}
	// transaction type		
			@FindBy(xpath = "//ion-input[@ng-reflect-placeholder='Search Transaction Type']/input")
			private WebElement searchTransactionType;

			public WebElement searchTransactionType() {
				return searchTransactionType;
			}
	//Add button
		@FindBy(xpath = "//ion-icon[@ng-reflect-name='add']|//div[1]/ion-router-outlet[1]/app-data-grid[1]/ion-content[1]/ion-fab[1]/ion-fab-button[1]/ion-icon[1]")
		private WebElement fixedAsset_AssetCreation_AddButton;

		public WebElement fixedAsset_AssetCreation_AddButton() {
			return fixedAsset_AssetCreation_AddButton;
		}
	//Asset item Number
		@FindBy(xpath = "//ion-row[1]/ion-col[1]/ion-item[1]/ion-input[1]/input")
		private WebElement fixedAsset_AssetCreation_AssetItemNumber;

		public WebElement fixedAsset_AssetCreation_AssetItemNumber() {
			return fixedAsset_AssetCreation_AssetItemNumber;
		}
		
	//Asset item Description
		@FindBy(xpath = "//ion-row[1]/ion-col[2]/ion-item[1]/ion-input[1]/input")
		private WebElement fixedAsset_AssetCreation_AssetItemDescription;

		public WebElement fixedAsset_AssetCreation_AssetItemDescription() {
			return fixedAsset_AssetCreation_AssetItemDescription;
		}
		
	//Asset AssetValue
		@FindBy(xpath = "//ion-label[text()='Asset Value ']/following-sibling::ion-input/input")
		private WebElement fixedAsset_AssetCreation_AssetValue;

		public WebElement fixedAsset_AssetCreation_AssetValue() {
		return fixedAsset_AssetCreation_AssetValue;
		}
		
	//Asset item calendar
		@FindBy(xpath = "(//span[@class='input-calendar'])[2]")
		private WebElement fixedAsset_AssetCreation_AssetItemCalendar;

		public WebElement fixedAsset_AssetCreation_AssetItemCalendar() {
		return fixedAsset_AssetCreation_AssetItemCalendar;
		}
		//HSN code textbox
		@FindBy(xpath = "//app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement fixedAsset_AssetCreation_HSNCode;

		public WebElement fixedAsset_AssetCreation_HSNCode() {
		return fixedAsset_AssetCreation_HSNCode;
		}
	
		//BranchCode
				@FindBy(xpath = "//ion-grid[1]/ion-row[1]/ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
				private WebElement fixedAsset_AssetCreation_BranchCode_Textbox;

				public WebElement fixedAsset_AssetCreation_BranchCode_Textbox() {
					return fixedAsset_AssetCreation_BranchCode_Textbox;
				}
				
	

				//BranchCode
						@FindBy(xpath = "//ion-grid[1]/ion-row[1]/ion-col[6]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
						private WebElement fixedAsset_AssetCreation_AssetCode_Textbox;

						public WebElement fixedAsset_AssetCreation_AssetCode_Textbox() {
							return fixedAsset_AssetCreation_AssetCode_Textbox;
						}
	

						//BillReference NUmber
	@FindBy(xpath = "//ion-grid[1]/ion-row[1]/ion-col[10]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement fixedAsset_AssetCreation_BillReferenceNumber_Textbox;

			public WebElement fixedAsset_AssetCreation_BillReferenceNumber_Textbox() {
		return fixedAsset_AssetCreation_BillReferenceNumber_Textbox;
								}	
			// SaveButton for FixedAsset Creation
@FindBy(xpath = "(//ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1])[2]")
private WebElement fixedAsset_AssetCreation_SaveButton;

	public WebElement fixedAsset_AssetCreation_SaveButton() {
return fixedAsset_AssetCreation_SaveButton;
						}
	//success message close
	@FindBy(xpath = "//button[@aria-label='Close']")
	private WebElement fixedAsset_AssetCreation_SuccessMessageClose;

		public WebElement fixedAsset_AssetCreation_SuccessMessageClose() {
	return fixedAsset_AssetCreation_SuccessMessageClose;
							}
		 @FindBy(xpath = "//div[@id='toast-container']//div[@role='alert']")
			private WebElement fixedAsset_AssetCategory_WorkflowInitiated;
		    public WebElement fixedAsset_AssetCategory_WorkflowInitiated() {
				 return fixedAsset_AssetCategory_WorkflowInitiated;
			}
		    @FindBy(xpath = "//button[@aria-label='Close']")
			private WebElement fixedAsset_AssetCategory_AlertClose;
		    public WebElement fixedAsset_AssetCategory_AlertClose() {
				 return fixedAsset_AssetCategory_AlertClose;
			}	    
	//Fixed Asset Items
@FindBy(xpath = "//span[2]/ion-tab-button/ion-label")
private WebElement fixedAsset_AssetCreation_FixedAssetItems;

public WebElement fixedAsset_AssetCreation_FixedAssetItems() {
return fixedAsset_AssetCreation_FixedAssetItems;
				}
//Report_report_AssetCreationCommon
@FindBy(xpath = "//ion-list[1]/div[1]/ion-menu-toggle[9]/ion-item[1]/ion-buttons[1]/ion-button[1]")
private WebElement Report_report_AssetCreationCommon_editButton;

public WebElement Report_report_AssetCreationCommon_editButton() {
return Report_report_AssetCreationCommon_editButton;
				}
@FindBy(xpath = "//ion-row[1]/ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
private WebElement Report_report_AssetCreationCommon_AssetLifeUnit;

public WebElement Report_report_AssetCreationCommon_AssetLifeUnit() {
return Report_report_AssetCreationCommon_AssetLifeUnit;
				}
@FindBy(xpath = "//ion-content[1]/form[1]/ion-grid[1]/ion-row[1]/ion-col[2]/app-kub-date-time[1]/ion-item[1]/div[1]/span[1]")
private WebElement Report_report_AssetCreationCommon_Calendar;

public WebElement Report_report_AssetCreationCommon_Calendar() {
return Report_report_AssetCreationCommon_Calendar;
				}	
@FindBy(xpath = "//ion-header/ion-toolbar[1]/ion-buttons[1]/ion-button[1]")
private WebElement Report_report_AssetCreationCommon_ViewButton;

public WebElement Report_report_AssetCreationCommon_ViewButton() {
return Report_report_AssetCreationCommon_ViewButton;
				}
//ReportNext
@FindBy(xpath = "//tbody/tr[2]/td[7]/input[1]\"")
private WebElement Report_report_NextButton;

public WebElement Report_report_NextButton() {
return Report_report_NextButton;
				}	
//page-fixed-asset-allocation-update[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1]
// (//ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1])[2]
//page-fixed-asset-creation-item-dtl-update//ion-toolbar//ion-button
	@FindBy(xpath = "//page-fixed-asset-creation-item-dtl-update//ion-toolbar//ion-button")
	private WebElement fixedAsset_AssetAllocation_SaveButton;

		public WebElement fixedAsset_AssetAllocation_SaveButton() {
	return fixedAsset_AssetAllocation_SaveButton;
							}
		
		@FindBy(xpath="//page-fixed-asset-allocation-update//ion-toolbar//ion-buttons[2]//ion-button")
		private WebElement fixedAsset_allocationSaveButton;
		public WebElement fixedAsserAllocationSaveButton()
		{
			return fixedAsset_allocationSaveButton;
		}
		
		//Job Scheduler Button
		@FindBy(xpath = "//ion-label[contains(text(),'Job scheduler')]")
		private WebElement JobScheduler_Button;

			public WebElement JobScheduler_Button() {
		return JobScheduler_Button;}
			//Job Execution Button
			@FindBy(xpath = "//div[4]/ion-menu-toggle[2]/ion-item[1]/ion-buttons[1]/ion-button[1]")
			private WebElement JobExecution_EditButton;

				public WebElement JobExecution_EditButton() {
			return JobExecution_EditButton;}	
	
				//Job Execution To date calander Button
				@FindBy(xpath = "(//span[@class='input-calendar'])[2]")
				private WebElement JobExecution_ToDateCalanderButton;

					public WebElement JobExecution_ToDateCalanderButton() {
				return JobExecution_ToDateCalanderButton;}
					
					//Job Execution StartJob Button
					@FindBy(xpath = "//ion-button[contains(text(),'Start Job')]")
					private WebElement JobExecution_StartJobButton;

						public WebElement JobExecution_StartJobButton() {
					return JobExecution_StartJobButton;}	
					
						//Job Execution Refresh Button
						@FindBy(xpath = "//form[1]/ion-grid[1]/ion-row[1]/div[1]/ion-col[1]/ion-button[2]")
						private WebElement JobExecution_RefreshButton;

							public WebElement JobExecution_RefreshButton() {
						return JobExecution_RefreshButton;}	
							//-------- calendar code---
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
//-------------anand page obj--------
							@FindBy(xpath="//ion-button[@ng-reflect-router-link=\"/tabs/list/datagrid-view/129\"]")
							private WebElement fixedasset_view_icon;
							public WebElement fixedAssetViewIcon()
							{
								return fixedasset_view_icon;
							}
							@FindBy(xpath="//ion-fab-button[@id='addBtn']")
							private WebElement fixed_asset_add_button;
							public WebElement fixedAssetAddButton()
							{
								return fixed_asset_add_button;
							}
							@FindBy(xpath="//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
							private WebElement fixedasset_asset_reference_number;
							public WebElement fixedAssetReferenceNumber()
							{
								return fixedasset_asset_reference_number;
							}
							@FindBy(xpath="//ion-col[6]//input")
							private WebElement fixedasset_asset_item_no;
							public WebElement fixedAssetAssetItemNo()
							{
								return fixedasset_asset_item_no;
							}
						    @FindBy(xpath="//ion-col[3]/ion-item[1]/ion-select[1]")
						    private WebElement fixedasset_asset_transaction_type;
						    public WebElement fixedAssetAssetTransactionType()
						    {
						    	return fixedasset_asset_transaction_type;
						    }
							@FindBy(xpath="//ion-col[5]/app-kub-display-field[1]/ion-item[1]/ion-input[1]/input[1]")
							private WebElement fixed_asset_asset_description;
							public WebElement fixedAssetAssetDescription()
							{
								return fixed_asset_asset_description;
							}
							@FindBy(xpath="//ion-item[1]/ion-radio")
							private WebElement fixed_asset_transType_impairement;
							public WebElement fixedAssetTransTypeImpairement()
							{
								return fixed_asset_transType_impairement;
							}
							
							@FindBy(xpath="//ion-item[2]/ion-radio")
							private WebElement fixed_asset_transType_writeOff;
							public WebElement fixedAssetTransTypeWriteOff()
							{
								return fixed_asset_transType_writeOff;
							}
							
							@FindBy(xpath = "//page-fixed-asset-impairment-update[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button")
							private WebElement fixed_asset_save_button;

							public WebElement fixedAssetSaveButton() {
								return fixed_asset_save_button;

							}
							@FindBy(xpath="//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/span[2]")
							private WebElement fixed_asset_get_asset_referece_no;
							public WebElement fixedAssetGetReferenceNo()
							{
								return fixed_asset_get_asset_referece_no;
							}
						    @FindBy(xpath="//i[@class='datatable-icon-right']")
						    private WebElement fixed_asset_next_button;
						    public WebElement fixedAssetNextButton()
						    {
						    	return fixed_asset_next_button;
						    }
						    @FindBy(xpath="//ion-input[@name='bookValue']/input")
						    private WebElement fixedAsset_bookValue;
						    public WebElement fixedAssetBookValue()
						    {
						    	return fixedAsset_bookValue;
						    }
						    @FindBy(xpath="//input[@id='assetAmt']")
						    private WebElement fixedAsset_assetValue;
						    public WebElement fixedAssetAssetValue()
						    {
						    	return fixedAsset_assetValue;
						    }
						    @FindBy(xpath="//div[contains(text(),'No items found')]")
						    private WebElement fixedAsset_noList;
						    public WebElement fixedAssetNoList()
						    {
						    	return fixedAsset_noList;
						    }
	
}
