package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArApObj {
	WebDriver driver;

	public ArApObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/* InventoryManagament Button
		@FindBy(xpath = "//ion-label[contains(text(),'Inventory management')]")
		private WebElement inventoryManagament_button;

		public WebElement inventoryManagament_button() {
			return inventoryManagament_button;
	"*/
	//Report Button
	@FindBy(xpath = "//custom-side-menu[1]/ion-list[1]/ion-segment[1]/ion-segment-button[3]")
	private WebElement report_button;

	public WebElement report_button() {
		return report_button;
	}	
		
	//Financial reporting Button
		@FindBy(xpath = "//ion-label[contains(text(),'Financial reporting')]")
		private WebElement financial_Reporting;

		public WebElement financial_Reporting() {
			return financial_Reporting;
		}	
		//balanceSheetReport Button
		@FindBy(xpath = "//ion-list[1]/div[2]/ion-menu-toggle[6]/ion-item[1]/ion-buttons[1]/ion-button[1]")
		private WebElement balanceSheetReport_button;

		public WebElement balanceSheetReport_button() {
			return balanceSheetReport_button;
		}	
		
		//balanceSheetReport Button
				@FindBy(xpath = "//app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
				private WebElement balanceSheetReport_branch_textbox;

				public WebElement balanceSheetReport_branch_textbox() {
					return balanceSheetReport_branch_textbox;
				}		
		
				//Calendar Button
				@FindBy(xpath = "//span[@class='input-calendar']")
				private WebElement calendar_button;

				public WebElement calendar_button() {
					return calendar_button;
				}		
				
				//View Button
				@FindBy(xpath = "//div[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[1]/ion-button[1]")
				private WebElement view_button;

				public WebElement view_button() {
					return view_button;
				}	
		
		
					
		
		
				//Fixedasset asset creation eye Button
				@FindBy(xpath = "//div[6]/ion-menu-toggle[1]/ion-item[1]/ion-buttons[1]/ion-button[2]")
				private WebElement fixedAsset_AssetCreation_EyeButton;

				public WebElement fixedAsset_AssetCreation_EyeButton() {
					return fixedAsset_AssetCreation_EyeButton;
				}		
		
				
		
				//Fixedasset asset creation Add Button
				@FindBy(xpath = "//app-data-grid[1]/ion-content[1]/ion-fab[1]/ion-fab-button[1]/ion-icon[1]")
				private WebElement fixedAsset_AssetCreation_AddButton;

				public WebElement fixedAsset_AssetCreation_AddButton() {
					return fixedAsset_AssetCreation_AddButton;
				}		
		
					
		
				//Fixedasset asset creation GRN Reference number text Button
				@FindBy(xpath = "//ion-col[8]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
				private WebElement fixedAsset_AssetCreation_GRNtextButton;

				public WebElement fixedAsset_AssetCreation_GRNtextButton() {
					return fixedAsset_AssetCreation_GRNtextButton;
				}	
		
				
		
				//Account Receivable Button
				@FindBy(xpath = "//ion-menu[1]/ion-content[1]/custom-side-menu[1]/ion-list[1]/ion-item[5]/ion-label[1]")
				private WebElement accountReceivable_Button;

				public WebElement accountReceivable_Button() {
					return accountReceivable_Button;
				}		
		
				//Account Receivable (Advances) Eye Button
				@FindBy(xpath = "//div[5]/ion-menu-toggle[3]/ion-item[1]/ion-buttons[1]/ion-button[2]")
				private WebElement accountReceivableAdvances_EyeButton;

				public WebElement accountReceivableAdvances_EyeButton() {
					return accountReceivableAdvances_EyeButton;
				}
		
				//Account Receivable (Advances) Add Button
				@FindBy(xpath = "//app-data-grid[1]/ion-content[1]/ion-fab[1]/ion-fab-button[1]/ion-icon[1]")
				private WebElement accountReceivableAdvances_AddButton;

				public WebElement accountReceivableAdvances_AddButton() {
					return accountReceivableAdvances_AddButton;
				}
				//Receivable Name Text Box
				@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
				private WebElement accountReceviableAdvances_ReceivableName_TextBox;

				public WebElement accountReceviableAdvances_ReceivableName_TextBox() {
					return accountReceviableAdvances_ReceivableName_TextBox;
				}
		
				//Business Patner Name Text Box
				@FindBy(xpath = "//ion-grid[1]/ion-row[1]/ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
				private WebElement accountReceviableAdvances_BusinessPatner_TextBox;

				public WebElement accountReceviableAdvances_BusinessPatner_TextBox() {
					return accountReceviableAdvances_BusinessPatner_TextBox;
				}
				
				
				//PONumber Text Box
				@FindBy(xpath = "//ion-grid[1]/ion-row[2]/ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
				private WebElement accountReceviableAdvances_PONumber_TextBox;

				public WebElement accountReceviableAdvances_PONumber_TextBox() {
					return accountReceviableAdvances_PONumber_TextBox;
				}
							
				//Payment Mode Text Box
				@FindBy(xpath = "//form[1]/ion-grid[1]/ion-row[3]/ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
				private WebElement accountReceviableAdvances_paymentMode_TextBox;

				public WebElement accountReceviableAdvances_paymentMode_TextBox() {
					return accountReceviableAdvances_paymentMode_TextBox;
				}
				
				//Amount Text Box
				@FindBy(xpath = "//input[@id='advanceAmt']")
				private WebElement accountReceviableAdvances_amount_TextBox;

				public WebElement amount_TextBox() {
					return accountReceviableAdvances_amount_TextBox;
				}
				
				//Currency Text Box
				@FindBy(xpath = "//ion-row[3]/ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
				private WebElement accountReceviableAdvances_currency_TextBox;

				public WebElement accountReceviableAdvances_currency_TextBox() {
					return accountReceviableAdvances_currency_TextBox;
				}	
				//Description Text Box
				@FindBy(xpath = "//ion-content[1]/form[1]/ion-grid[1]/ion-row[3]/ion-col[5]/ion-item[1]/ion-input[1]/input[1]")
				private WebElement accountReceviableAdvances_description_TextBox;

				public WebElement accountReceviableAdvances_description_TextBox() {
					return accountReceviableAdvances_description_TextBox;
				}	
				
		
				
				//Save Button
				@FindBy(xpath = "//page-advances-update[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1]")
				private WebElement accountReceviableAdvances_Save_Button;

				public WebElement accountReceviableAdvances_Save_Button() {
					return accountReceviableAdvances_Save_Button;
				}			
				
				//Entity Branch
				@FindBy(xpath = "//ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[3]/input")
				private WebElement accountReceviableAdvances_Entity_Branch_Textbox;

				public WebElement accountReceviableAdvances_Entity_Branch_Textbox() {
					return accountReceviableAdvances_Entity_Branch_Textbox;
				}	
				
				
				//AutoPayoutEditButton
				@FindBy(xpath = "//ion-list[1]/div[3]/ion-menu-toggle[7]/ion-item[1]/ion-buttons[1]/ion-button[2]")
				private WebElement accountPayable_AutoPayoutEditButton;

				public WebElement accountPayable_AutoPayoutEditButton() {
					return accountPayable_AutoPayoutEditButton;
				}	
							
				//AutoPayout1st record action Button
				@FindBy(xpath = "//ion-router-outlet[1]/app-data-grid[1]/ion-content[1]/div[1]/ngx-datatable[1]/div[1]/datatable-body[1]/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[1]/div[1]/ion-buttons[1]/ion-button[1]")
				private WebElement accountPayable_AutoPayout_ActionButton;

				public WebElement accountPayable_AutoPayout_ActionButton() {
					return accountPayable_AutoPayout_ActionButton;
				}		
				
				//AutoPayout Beneficiary Name
				@FindBy(xpath = "//ion-row[1]/ion-col[5]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[3]/input[1]")
				private WebElement accountPayable_AutoPayout_BeneficiaryName;

				public WebElement accountPayable_AutoPayout_BeneficiaryName() {
					return accountPayable_AutoPayout_BeneficiaryName;
				}
				//AutoPayout PaymentMode
				@FindBy(xpath = "//ion-row[1]/ion-col[18]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[3]/input[1]")
				private WebElement accountPayable_AutoPayout_PaymentMode;

				public WebElement accountPayable_AutoPayout_PaymentMode() {
					return accountPayable_AutoPayout_PaymentMode;
				}
			
				//AutoPayout AccountNumber
				@FindBy(xpath = "//ion-row[1]/ion-col[18]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[3]/input[1]")
				private WebElement accountPayable_AutoPayout_AccountNumber;

				public WebElement accountPayable_AutoPayout_AccountNumber() {
					return accountPayable_AutoPayout_AccountNumber;
				}
				// Accounts receivable button
				@FindBy(xpath = "//ion-content[1]/custom-side-menu[1]/ion-list[1]/ion-item[5]/ion-label[1]")
				private WebElement accountsReceivable_button;

				public WebElement accountsReceivable_button() {
					return accountsReceivable_button;
				}		
				
				// Accounts receivable Receipts reversals eye button
				@FindBy(xpath = "//custom-side-menu[1]/ion-list[1]/div[5]/ion-menu-toggle[5]/ion-item[1]/ion-buttons[1]/ion-button[2]")
				private WebElement accountsReceivable_ReceiptsReversals_EyeButton;

				public WebElement accountsReceivable_ReceiptsReversals_EyeButton() {
					return accountsReceivable_ReceiptsReversals_EyeButton;
				}

				// Accounts receivable Receipts reversals Add button
				@FindBy(xpath = "//ion-router-outlet[1]/app-data-grid[1]/ion-content[1]/ion-fab[1]/ion-fab-button[1]/ion-icon[1]")
				private WebElement accountsReceivable_ReceiptsReversals_AddButton;

				public WebElement accountsReceivable_ReceiptsReversals_AddButton() {
					return accountsReceivable_ReceiptsReversals_AddButton;
				}
				
				// Accounts receivable Receipts reversals entity branch text box
				@FindBy(xpath = "//ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[3]/input[1]")
				private WebElement accountsReceivable_ReceiptsReversals_EntityBranchTextBox;

				public WebElement accountsReceivable_ReceiptsReversals_EntityBranchTextBox() {
					return accountsReceivable_ReceiptsReversals_EntityBranchTextBox;
				}
				
				
				// Accounts receivable Receipts reversals RecieptReferenceNumber text box
				@FindBy(xpath = "//app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
				private WebElement accountsReceivable_ReceiptsReversals_RecieptReferenceNumberTextBox;

				public WebElement accountsReceivable_ReceiptsReversals_RecieptReferenceNumberTextBox() {
					return accountsReceivable_ReceiptsReversals_RecieptReferenceNumberTextBox;
				}	
				
				
				
				
				// Accounts receivable Receipts reversals CancellationRemark text box
				@FindBy(xpath = "//ion-grid[1]/ion-row[1]/ion-col[6]/ion-item[1]/ion-input[1]/input[1]")
				private WebElement accountsReceivable_ReceiptsReversals_CancellationRemarktextBox;

				public WebElement accountsReceivable_ReceiptsReversals_CancellationRemarktextBox() {
					return accountsReceivable_ReceiptsReversals_CancellationRemarktextBox;
				}
				//page-receipts-reversals-update[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1]			
				
				
				
				
				// Accounts receivable Receipts reversals SaveButton
				@FindBy(xpath = "//page-receipts-reversals-update[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1]")
				private WebElement accountsReceivable_ReceiptsReversals_SaveButton;

				public WebElement accountsReceivable_ReceiptsReversals_SaveButton() {
					return accountsReceivable_ReceiptsReversals_SaveButton;
				}		
				
				// Accounts receivable Receipts reversals edit grid
				@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid/209']")
				private WebElement accountsReceivable_ReceiptsReversals_EditGrid;

				public WebElement accountsReceivable_ReceiptsReversals_EditGrid() {
					return accountsReceivable_ReceiptsReversals_EditGrid;
				}		
				
				// Accounts receivable Receipts reversals edit grid first record
				@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[1]/div[1]/ion-buttons[1]/ion-button[1]")
				private WebElement accountsReceivable_ReceiptsReversals_EditGrid_FirstRecord;

				public WebElement accountsReceivable_ReceiptsReversals_EditGrid_FirstRecord() {
					return accountsReceivable_ReceiptsReversals_EditGrid_FirstRecord;
				}	
				
				// Accounts receivable Receipts reversals edit grid first record initiate button
				@FindBy(xpath = "//span[contains(text(),'Submit')]|//ion-header/ion-toolbar[1]/ion-buttons[2]/app-kub-decision-button[1]/ion-button[1]")
				private WebElement accountsReceivable_ReceiptsReversals_EditGrid_FirstRecord_initiateButton;

				public WebElement accountsReceivable_ReceiptsReversals_EditGrid_FirstRecord_initiateButton() {
					return accountsReceivable_ReceiptsReversals_EditGrid_FirstRecord_initiateButton;
				}		
				
				// Toast Close
				@FindBy(xpath = "//body/div/div/div/button/span")
				private WebElement ToastMessageClosebutton;

				public WebElement ToastMessageClosebutton() {
					return ToastMessageClosebutton;
				}
				
				// Appropriation reversals 
				
				
				@FindBy(xpath = "//div[5]/ion-menu-toggle[9]/ion-item[1]/ion-buttons[1]/ion-button[2]")
				private WebElement appropriation_Reversals_EyeButton;

				public WebElement appropriation_Reversals_EyeButton() {
					return appropriation_Reversals_EyeButton;
				}	
				
				
				
				
				@FindBy(xpath = "//page-receipt-appropriation-reversal-update[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1]")
				private WebElement appropriation_Reversals_SaveButton;

				public WebElement appropriation_Reversals_SaveButton() {
					return appropriation_Reversals_SaveButton;
				}	
				
				
				
// Appropriation EyeButton
				@FindBy(xpath = "//custom-side-menu[1]/ion-list[1]/div[5]/ion-menu-toggle[8]/ion-item[1]/ion-buttons[1]/ion-button[2]")
				private WebElement appropriation_Eye_Button;

				public WebElement appropriation_Eye_Button() {
					return appropriation_Eye_Button;
				}	
					
				
				
// Appropriation Add Button
				@FindBy(xpath = "//ion-router-outlet[1]/app-data-grid[1]/ion-content[1]/ion-fab[1]/ion-fab-button[1]/ion-icon[1]")
				private WebElement appropriation_Add_Button;

				public WebElement appropriation_Add_Button() {
					return appropriation_Add_Button;
				}
				//next button //report-data-grid[1]/ion-content[1]/div[1]/ngx-datatable[1]/div[1]/datatable-footer[1]/div[1]/datatable-pager[1]/ul[1]/li[8]/a[1]
				//(//i[@class='datatable-icon-right'])[2]
				@FindBy(xpath="//report-data-grid[1]/ion-content[1]/div[1]/ngx-datatable[1]/div[1]/datatable-footer[1]/div[1]/datatable-pager[1]/ul[1]/li[8]/a[1]")
				  private WebElement apportion_NextRecord;
				  public WebElement apportion_NextRecord()
				  {
					  return apportion_NextRecord;
				  }	
				
				
					//Report_report button 
					@FindBy(xpath="//ion-label[contains(text(),'Reports')]")
					  private WebElement report_Report_Button;
					  public WebElement report_Report_Button()
					  {
						  return report_Report_Button;
					  }			
				
					//Report_report_GRN Report button 
						@FindBy(xpath="//div[1]/ion-menu-toggle[1]/ion-item[1]/ion-buttons[1]/ion-button[1]")
						  private WebElement report_Report_GRNReport_EditButton;
						  public WebElement report_Report_GRNReport_EditButton()
						  {
							  return report_Report_GRNReport_EditButton;
						  }			
				
				
						//Report_report VendorEmployee button 
							@FindBy(xpath="//ion-row[1]/ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
							  private WebElement report_Report_GRNReport_VendorEmployeeName;
							  public WebElement report_Report_GRNReport_VendorEmployeeName()
							  {
								  return report_Report_GRNReport_VendorEmployeeName;
							  }			
				
				
							//Report_report GRN Status button 
								@FindBy(xpath="//ion-row[1]/ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
								  private WebElement report_Report_GRNReport_GRNStatus;
								  public WebElement report_Report_GRNReport_GRNStatus()
								  {
									  return report_Report_GRNReport_GRNStatus;
								  }		
				
								  @FindBy(xpath = "//owl-date-time-container[1]/div[2]/owl-date-time-calendar[1]/div[1]/button[2]/span[1]")
									private WebElement ARAP_NextMonth;

									public WebElement ARAPNextMonth() {

										return ARAP_NextMonth;
									}
				
				
				
				
				
}

