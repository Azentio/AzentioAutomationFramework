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
		@FindBy(xpath = "//ion-row[4]/ion-col[1]/ion-item[1]/ion-input[1]/input")
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
@FindBy(xpath = "//page-fixed-asset-creation-update[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1]")
private WebElement fixedAsset_AssetCreation_SaveButton;

	public WebElement fixedAsset_AssetCreation_SaveButton() {
return fixedAsset_AssetCreation_SaveButton;
						}
	//Fixed Asset Items
@FindBy(xpath = "//span[2]/ion-tab-button/ion-label")
private WebElement fixedAsset_AssetCreation_FixedAssetItems;

public WebElement fixedAsset_AssetCreation_FixedAssetItems() {
return fixedAsset_AssetCreation_FixedAssetItems;
				}	
	
	
	@FindBy(xpath = "//page-fixed-asset-creation-item-dtl-update[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[1]/ion-button[1]")
	private WebElement fixedAsset_AssetAllocation_SaveButton;

		public WebElement fixedAsset_AssetAllocation_SaveButton() {
	return fixedAsset_AssetAllocation_SaveButton;
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

}
