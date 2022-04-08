package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Gl_Reports_Obj1 {
	WebDriver driver;
	public Gl_Reports_Obj1(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	// reviewer id
	@FindBy(xpath = "//div[@id='toast-container']/div/div[@role='alertdialog']")
	private WebElement Ar_Ap_reviewer_id;
	public WebElement Ar_Ap_reviewer_id() {
		return Ar_Ap_reviewer_id;
	}
	//account payable
	@FindBy(xpath="//ion-label[contains(text(),'Accounts payable')]")
	private WebElement accountspayable;
	public WebElement accountPayable() {
		return accountspayable;
	}
	@FindBy(xpath="//div[3]//ion-menu-toggle[8]//ion-item//ion-buttons//ion-button[2]")
	private WebElement manualPayoutEyeIcon;
	public WebElement manualPayoutEyeIcon() {
		return manualPayoutEyeIcon;
	}
	@FindBy(xpath="//ion-fab-button[@id='addBtn']")
	private WebElement manualPayoutAddIcon;
	public WebElement manualPayoutAddIcon(){
		return manualPayoutAddIcon;
	}
	@FindBy(xpath="//ion-col[3]/app-kub-lov/span/ng-select/div/div/div/input")
	private WebElement manualPayoutSelectEntityBranch;
	public WebElement manualPayoutSelectEntityBranch() {
		return manualPayoutSelectEntityBranch;
	}
	@FindBy(xpath="//ion-col[4]/app-kub-lov/span/ng-select/div/div/div/input")
	private WebElement manualPayoutSelectBp;
	public WebElement manualPayoutSelectBp() {
		return manualPayoutSelectBp;
	}
	@FindBy(xpath="//ion-col[5]/app-kub-lov/span/ng-select/div/div/div/input")
	public WebElement manualPayoutSelectBeneficiaryName;
	public WebElement manualPayoutSelectBeneficiaryName() {
		return manualPayoutSelectBeneficiaryName;
	}
	@FindBy(xpath="//ion-col[11]/app-kub-lov/span/ng-select/div/div/div/input")
	private WebElement manualPayoutSelectCurrency;
	public WebElement  manualPayoutSelectCurrency() {
		return manualPayoutSelectCurrency;
	}
	@FindBy(xpath="//ion-col[14]/app-kub-lov/span/ng-select/div/div/div/input")
	private WebElement manualPayoutSelectBank;
	public WebElement manualPayoutSelectBank() {
		return manualPayoutSelectBank;
	}
	@FindBy(xpath="//ion-col[15]/app-kub-lov/span/ng-select/div/div/div/input")
	private WebElement manualPayoutSelectBankAccountNumber;
	public WebElement manualPayoutSelectBankAccountNumber() {
		return manualPayoutSelectBankAccountNumber;
	}
	@FindBy(xpath="(//span[@class='input-calendar'])[1]")
	private WebElement manualPayoutCalender;
	public WebElement manualPayoutCalender() {
		return manualPayoutCalender;
	}
	// reoort
	@FindBy(xpath = "//ion-segment-button[@ng-reflect-value='rpt']")
	private WebElement ReportIcon;

	public WebElement ReportIcon() {

		return ReportIcon;
	}
	@FindBy(xpath="//ion-label[text()=' Financial reporting ']")
	private WebElement financialReporting;
	public WebElement financialReporting() {
		return financialReporting; 
	}
	@FindBy(xpath="//ion-label[text()=' Accounting setup ']")
	private WebElement accountingSetup;
	public WebElement accountingSetup() {
		return accountingSetup;
	}
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/135']")
	private WebElement accountingBookDefinitionEyeIcon;
	public WebElement accountingBookDefinitionEyeIcon() {
		return accountingBookDefinitionEyeIcon;
	}
	@FindBy(xpath="//ion-icon[@aria-label='search']")
	private WebElement searchIcon;
	public WebElement searchIcon() {
		return searchIcon;
	}
	@FindBy(xpath="//datatable-header-cell[14]/div[1]/ion-input[1]/input[1]")
	private WebElement searchStatus;
	public WebElement searchStatus() {
		return searchStatus;
	}
	@FindBy(xpath="//datatable-pager[1]/ul[1]/li[8]/a[1]/i[1]")
	private WebElement nextPageInListView;
	public WebElement nextPageInListView() {
		return nextPageInListView;
	}
	@FindBy(xpath="//ion-col[8]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[3]/input[1]")
	private WebElement selectStatus;
	public WebElement selectStatus() {
		return selectStatus;
	}
	
	@FindBy(xpath="(//ion-toolbar/ion-buttons)[6]")
	private WebElement saveButton;
	public WebElement saveButton() {
		return saveButton;
	}
	@FindBy(xpath="//ion-toolbar[1]/ion-buttons[2]/ion-button[2]")
	private WebElement makerNotificationIcon;
	public WebElement makerNotificationIcon() {
		return makerNotificationIcon;
	}
	@FindBy(xpath="//app-inbox//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[1]//ion-button")
	private WebElement first_record_Click;
	public WebElement FirstRecordEditIcon()
	{
		return first_record_Click;
		
	}
	@FindBy(xpath="//app-inbox//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[2]//span")
	private WebElement first_reference_id;
	public WebElement firstReferenceId()
	{
		return first_reference_id;
		
	}
	@FindBy(xpath="//span[contains(text(),'Submit')]")
	private WebElement submit;
	public WebElement submit() {
		return submit;
	}
	 @FindBy(xpath="//span[contains(text(),'Approve')]")
	   private WebElement approve_button;
	   public WebElement approveButton()
	   {
		   return approve_button;
	   }
	 
	 //ion-item[@class='item-interactive item-textarea item-input item ios ion-focusable hydrated item-label item-label-floating']
	   @FindBy(xpath="//textarea[@name='remarks' and @class='native-textarea sc-ion-textarea-ios']")
	   private WebElement enterRemarkInMaker;
	   public WebElement enterRemarkInMaker() {
		   return enterRemarkInMaker;
	   }
	 
	 @FindBy(xpath="//ion-button[contains(text(),'Submit')]")
	 private WebElement submitRemark;
	 public WebElement submitRemark() {
		 return submitRemark;
	 }
	 //accounting category
	 @FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/149']")
	 private WebElement accountingCategoryEyeicon;
	 public WebElement accountingCategoryEyeicon() {
		 return accountingCategoryEyeicon;
	 }
	 
	 @FindBy(xpath="//ion-row[1]/ion-col[1]/ion-item[1]/ion-input[1]/input[1]")
	 private WebElement enterCategoryCode;
	 public WebElement enterCategoryCode() {
		 return enterCategoryCode;
	 }
	 @FindBy(xpath="//ion-row[1]/ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	 private WebElement selectAccountingBook;
	 public WebElement selectAccountingBook() {
		 return selectAccountingBook;
	 }
	 @FindBy(xpath="//ion-row[2]/ion-col[1]/ion-item[1]/ion-input[1]/input[1]")
	 private WebElement enterAccountingCategory;
	 public WebElement enterAccountingCategory() {
		 return enterAccountingCategory;
	 }
	 @FindBy(xpath="//ion-row[2]/ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	 private WebElement selectGlCodeGeneration;
	 public WebElement selectGlCodeGeneration() {
		 return selectGlCodeGeneration;
	 }
	 @FindBy(xpath = "//div[@id='toast-container']//button")
	private WebElement checkerAlertClose;
	public WebElement checkerAlertClose() {
			return checkerAlertClose;
		}
	@FindBy(xpath="(//datatable-body-cell[1]/div/ion-buttons/ion-button[1])[1]")
	private WebElement clickFirstEyeiconInListView;
	public WebElement clickFirstEyeiconInListView() {
			return clickFirstEyeiconInListView;
		}
	@FindBy(xpath="//input[@class='native-input sc-ion-input-md' and @name='macCode']")
	private WebElement getCategoryCode;
	public WebElement getCategoryCode() {
		return getCategoryCode;
	}
	 // chart of accounts definition
	 @FindBy(xpath="//ion-button[@ng-reflect-router-link=\"/tabs/list/datagrid-view/143\"]")
	 private WebElement chartOfAccountsDefinitionEyeIcon;
	 public WebElement chartOfAccountsDefinitionEyeIcon() {
		 return chartOfAccountsDefinitionEyeIcon;
	 }
	 @FindBy(xpath="//ion-row[1]/ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	 private WebElement selectAccountingCategory;
	 public WebElement selectAccountingCategory() {
		 return selectAccountingCategory;
	 }
	 @FindBy(xpath="//ion-row[1]/ion-col[3]/ion-item[1]/ion-input[1]/input[1]")
	 private WebElement coaName;
	 public WebElement coaName() {
		 return coaName;
	 } 
	 @FindBy(xpath="//ion-row[2]/ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	 private WebElement selectParentGl;
	 public WebElement selectParentGl() {
		 return selectParentGl;
	 }
	 @FindBy(xpath="//ion-row[2]/ion-col[3]//app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	 private WebElement selectGlType;
	 public WebElement  selectGlType() {
		 return selectGlType;
	 }
	 
	 @FindBy(xpath="//input[@name='langDescValue']")
	 private WebElement descriptionForCOA;
	 public WebElement descriptionForCOA() {
		 return descriptionForCOA;
	 } 
	//input[@autocomplete="ac88e40a92f8"]
	 @FindBy(xpath="//ion-grid[1]/ion-row[4]/ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	 private WebElement selectBalanceType;
	 public WebElement selectBalanceType() {
		 return selectBalanceType;
	 }
	 @FindBy(xpath="//ion-fab-button[@id='addBtn']")
		private WebElement addIcon;
		public WebElement addIcon() {
			return addIcon;
		}
		// Accounting Scheme definition
		@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/147']")
		private WebElement accountingSchemeDefinitionEyeIcon;
		public WebElement accountingSchemeDefinitionEyeIcon() {
			return accountingSchemeDefinitionEyeIcon;
		}
		@FindBy(xpath="//datatable-header-cell[7]/div[1]/ion-input[1]/input[1]")
		private WebElement searchStatusInAccountingScheme;
		public WebElement searchStatusInAccountingScheme() {
			return searchStatusInAccountingScheme;
		}
		@FindBy(xpath="//ion-row[1]/ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement selectAccountBook;
		public WebElement selectAccountBook() {
			return selectAccountBook;
		}
		@FindBy(xpath="//input[@name='schemeCode']")
		private WebElement enterAccountingSchemeCode;
		public WebElement enterAccountingSchemeCode() {
			return enterAccountingSchemeCode;
		}
		@FindBy(xpath="//ion-row[1]/ion-col[4]/ion-item[1]/ion-input[1]/input[1]")
		private WebElement enterAccountingSchemeName;
		public WebElement enterAccountingSchemeName() {
			return enterAccountingSchemeName;
		}
		@FindBy(xpath="//ion-col[10]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement selectExpandIndicator;
		public WebElement selectExpandIndicator() {
			return selectExpandIndicator;
		}
		@FindBy(xpath="//ion-col[11]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement selectTransactionType;
		public WebElement selectTransactionType() {
			return selectTransactionType;
		}
		@FindBy(xpath="//page-accounting-scheme-update[1]/ion-content[1]/app-data-grid[1]/ion-content[1]/ion-fab[1]/ion-fab-button[1]/ion-icon[1]")
		private WebElement addAccountingSchemesDetail;
		public WebElement addAccountingSchemesDetail() {
			return addAccountingSchemesDetail;
		}
		@FindBy(xpath="//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement selectGlSource;
		public WebElement selectGlSource() {
			return selectGlSource;
		}
		@FindBy(xpath="//ion-row[1]/ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement selectCrDrFlag;;
		public WebElement selectCrDrFlag() {
			return selectCrDrFlag;
		}
		@FindBy(xpath="//ion-row[1]/ion-col[5]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement selectExpandIndicatorInSchemeDetail;
		public WebElement selectExpandIndicatorInSchemeDetail() {
			return selectExpandIndicatorInSchemeDetail;
		}
		@FindBy(xpath="//ion-row[1]/ion-col[4]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement selectParameterType;
		public WebElement selectParameterType() {
			return selectParameterType;
		}
		@FindBy(xpath="//form[1]/ion-grid[1]/ion-row[3]/ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement selectParameterInAccountingSchemeDetails;
		public WebElement selectParameterInAccountingSchemeDetails() {
			return selectParameterInAccountingSchemeDetails;
		}
		@FindBy(xpath="//form[1]/ion-grid[1]/ion-row[3]/ion-col[2]/ion-button[1]")
		private WebElement addIconinAccountingSchemeDetails;
		public WebElement addIconinAccountingSchemeDetails() {
			return addIconinAccountingSchemeDetails;
		}
		@FindBy(xpath="//page-accounting-scheme-details-update[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1]")
		private WebElement saveButtonInAccountingSchemeDetails;
		public WebElement saveButtonInAccountingSchemeDetails() {
			return saveButtonInAccountingSchemeDetails;
		}
		@FindBy(xpath="//ion-row[1]/ion-col[6]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[3]/input[1]")
		private WebElement selectStatusInAccountingSchemes;
		public WebElement selectStatusInAccountingSchemes() {
			return selectStatusInAccountingSchemes;
		}
		@FindBy(xpath="(//datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[1]/div[1]/ion-buttons[1]/ion-button[1])[2]")
		private WebElement editIconInAccountingSchemeDetails;
		public WebElement editIconInAccountingSchemeDetails() {
			return editIconInAccountingSchemeDetails;
		}
		// accounting Scheme Event Mapping
		@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/152']")
		private WebElement accountingSchemeEventMappingEyeIcon;
		public WebElement accountingSchemeEventMappingEyeIcon() {
			return accountingSchemeEventMappingEyeIcon;
		}
		@FindBy(xpath="//ion-row[1]/ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement selectEvent;
		public WebElement selectEvent() {
			return selectEvent;
		}
		@FindBy(xpath="//button[@icon='pi pi-angle-right']")
		private WebElement addSchemesButton;
		public WebElement addSchemesButton() {
			return addSchemesButton;
		}
		@FindBy(xpath="//page-accounting-scheme-event-mapping-update//ion-toolbar//ion-buttons[2]/ion-button")
		private WebElement saveButtonInEventMapping;
		public WebElement saveButtonInEventMapping() {
			return saveButtonInEventMapping;
		}
		@FindBy(xpath="//datatable-header-cell[2]/div[1]/ion-input[1]/input[1]")
		private WebElement searchEventName;
		public WebElement searchEventName() {
			return searchEventName;
		}
		@FindBy(xpath="//ion-col[4]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[3]/input[1]")
		private WebElement selectStatusInEventMapping;
		public WebElement selectStatusInEventMapping() {
			return selectStatusInEventMapping;
		}
		@FindBy(xpath="//datatable-row-wrapper[2]/datatable-body-row[1]/div[2]/datatable-body-cell[3]/div[1]/span[1]")
		private WebElement getAccountingNameInListView;
		public WebElement getAccountingNameInListView() {
			return getAccountingNameInListView;
		}
		@FindBy(xpath="(//datatable-body-cell[1]/div/ion-buttons/ion-button[2])[1]")
		private WebElement clickFirstEditIconInListView;
		public WebElement clickFirstEditIconInListView() {
			return clickFirstEditIconInListView;
		}
		@FindBy(xpath="(//ul)[3]/li[@role='option']/span")
		private WebElement getMappedSchemes;
		public WebElement getMappedSchemes() {
			return getMappedSchemes;
		}
	@FindBy(xpath ="//ion-button[@ng-reflect-router-link=\"tabs/entities/gl-balances-repo\"]")
	private WebElement FinancialTransactionIcon;
	public WebElement FinancialTransactionIcon() {

		return FinancialTransactionIcon;
	}
	
	@FindBy(xpath="//ion-col[1]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement glBalanceReportSelectBranch;
	public  WebElement glBalanceReportSelectBranch() {
		return glBalanceReportSelectBranch;
	}
	@FindBy(xpath="//ion-col[2]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	public WebElement glBalanceReportSelectGlcode;
	public WebElement glBalanceReportSelectGlcode() {
		return glBalanceReportSelectGlcode;
	}
	@FindBy(xpath="//ion-col[5]/app-kub-lov/span/ng-select/div/div/div/input")
	private WebElement glBalanceReportSelectCurrency;
	public WebElement glBalanceReportCurrency() {
		return glBalanceReportSelectCurrency;
	}
	@FindBy(xpath="//ion-segment/ion-segment-button[2]")
	private WebElement optionicon;
	public WebElement directionIcon() {
		return optionicon;
	}
	@FindBy(xpath = "//a[contains(text(),'View')]")
	private WebElement Gl_ViewButton;

	public WebElement glViewButton() {

		return Gl_ViewButton;
	}
	@FindBy(xpath="//input[@title='Next page']")
	private WebElement nextPageInGlbalanceReport;
	public WebElement nextPageInGlbalanceReport() {
		return nextPageInGlbalanceReport;
	}
	@FindBy(xpath = "//div[@id='toast-container']/div/div[@role='alertdialog']")
	private WebElement budget_creation_reviewer_id;

	public WebElement budgetCreation_ReviewerId() {
	return budget_creation_reviewer_id;
	}
	

}
