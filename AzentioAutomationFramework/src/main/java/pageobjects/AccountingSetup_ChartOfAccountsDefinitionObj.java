package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountingSetup_ChartOfAccountsDefinitionObj {

	WebDriver driver;

	public AccountingSetup_ChartOfAccountsDefinitionObj(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// AccountingSetup Menu
	@FindBy(xpath = "//ion-label[text()=' Accounting setup ']")
	private WebElement AccountingSetupMenu;

	public WebElement AccountingSetupMenu() {
		return AccountingSetupMenu;
	}
	
	//eye button of ChartOfAccountsDefinition
	@FindBy(xpath = "//div[3]//ion-menu-toggle[3]//ion-item//ion-buttons//ion-button[2]")
	private WebElement accountingSetup_ChartOfAccountsDefinition_EyeButton;

	public WebElement accountingSetup_ChartOfAccountsDefinition_EyeButton() {
		return accountingSetup_ChartOfAccountsDefinition_EyeButton;
	}
	
	// Search icon
	@FindBy(xpath = "(//ion-buttons/ion-item/ion-icon)[2]")
	private WebElement accountingSetup_ChartOfAccountsDefinition_Search;

	public WebElement accountingSetup_ChartOfAccountsDefinition_Search() {
		return accountingSetup_ChartOfAccountsDefinition_Search;
	}
	
	// Record Search using COA Name
	@FindBy(xpath = "//datatable-header-cell[3]/div/ion-input/input")
	private WebElement accountingSetup_ChartOfAccountsDefinition_COA_NameSearch;

	public WebElement accountingSetup_ChartOfAccountsDefinition_COA_NameSearch() {
		return accountingSetup_ChartOfAccountsDefinition_COA_NameSearch;
	}
	
	// Record Search using COA Code
	@FindBy(xpath = "//datatable-header-cell[2]/div/ion-input/input")
	private WebElement accountingSetup_ChartOfAccountsDefinition_COA_CodeSearch;
	
	public WebElement accountingSetup_ChartOfAccountsDefinition_COA_CodeSearch() {
		return accountingSetup_ChartOfAccountsDefinition_COA_CodeSearch;
	}
	
	// First eye button 
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[1]/div/ion-buttons/ion-button[1]")
	private WebElement accountingSetup_ChartOfAccountsDefinition_FirstEyeButton;

	public WebElement accountingSetup_ChartOfAccountsDefinition_FirstEyeButton() {
		return accountingSetup_ChartOfAccountsDefinition_FirstEyeButton;
	}
	
	// First pencil button 
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell/div/ion-buttons/ion-button[2]")
	private WebElement accountingSetup_ChartOfAccountsDefinition_FirstPencilButton;
	
	public WebElement accountingSetup_ChartOfAccountsDefinition_FirstPencilButton() {
		return accountingSetup_ChartOfAccountsDefinition_FirstPencilButton;
	}
	
	// COA Code
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[2]/div[1]/span[1]")
	private WebElement accountingSetup_ChartOfAccountsDefinition_COA_Code;
	
	public WebElement accountingSetup_ChartOfAccountsDefinition_COA_Code() {
		return accountingSetup_ChartOfAccountsDefinition_COA_Code;
	}
	
	// COA Name field
	@FindBy(xpath = "//ion-col[3]/ion-item[1]/ion-input[1]/input[1]")
	private WebElement accountingSetup_ChartOfAccountsDefinition_COA_NameField;
	
	public WebElement accountingSetup_ChartOfAccountsDefinition_COA_NameField() {
		return accountingSetup_ChartOfAccountsDefinition_COA_NameField;
	}
	
	// Balance Type
	@FindBy(xpath = "//ion-row[4]/ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[3]/input[1]")
	private WebElement accountingSetup_ChartOfAccountsDefinition_BalanceType;
	
	public WebElement accountingSetup_ChartOfAccountsDefinition_BalanceType() {
		return accountingSetup_ChartOfAccountsDefinition_BalanceType;
	}
	
	// Description
	@FindBy(xpath = "//ion-row[3]/ion-col[1]/ion-item[1]/ion-input[1]/input[1]")
	private WebElement accountingSetup_ChartOfAccountsDefinition_Description;
	
	public WebElement accountingSetup_ChartOfAccountsDefinition_Description() {
		return accountingSetup_ChartOfAccountsDefinition_Description;
	}
	
	// Accounting Category
	@FindBy(xpath = "//ion-row[1]/ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[3]/input[1]")
	private WebElement accountingSetup_ChartOfAccountsDefinition_AccountingCategory;
	
	public WebElement accountingSetup_ChartOfAccountsDefinition_AccountingCategory() {
		return accountingSetup_ChartOfAccountsDefinition_AccountingCategory;
	}
	
	// External Mapping Code
	@FindBy(xpath = "//ion-row[2]/ion-col[1]/ion-item[1]/ion-input[1]/input[1]")
	private WebElement accountingSetup_ChartOfAccountsDefinition_ExternalMappingCode;
	
	public WebElement accountingSetup_ChartOfAccountsDefinition_ExternalMappingCode() {
		return accountingSetup_ChartOfAccountsDefinition_ExternalMappingCode;
	}
	
	// Entity SEgment
	@FindBy(xpath = "//ion-row[5]/ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]")
	private WebElement accountingSetup_ChartOfAccountsDefinition_EntitySegment;
	
	public WebElement accountingSetup_ChartOfAccountsDefinition_EntitySegment() {
		return accountingSetup_ChartOfAccountsDefinition_EntitySegment;
	}
	
	// Parent GL
	////ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]
	@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement accountingSetup_ChartOfAccountsDefinition_ParentGL;
	
	public WebElement accountingSetup_ChartOfAccountsDefinition_ParentGL() {
		return accountingSetup_ChartOfAccountsDefinition_ParentGL;
	}
	
	// GL Type
	@FindBy(xpath = "//ion-row[2]/ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[3]/input[1]")
	private WebElement accountingSetup_ChartOfAccountsDefinition_GLtype;
	
	public WebElement accountingSetup_ChartOfAccountsDefinition_GLtype() {
		return accountingSetup_ChartOfAccountsDefinition_GLtype;
	}
	
	// Branch Specific
	@FindBy(xpath = "//ion-row[5]/ion-col[1]/ion-item/ion-select")
	private WebElement accountingSetup_ChartOfAccountsDefinition_BranchSpecific;
	
	public WebElement accountingSetup_ChartOfAccountsDefinition_BranchSpecific() {
		return accountingSetup_ChartOfAccountsDefinition_BranchSpecific;
	}
	
	// Control account
	@FindBy(xpath = "//ion-row[5]/ion-col[2]/ion-item/ion-select")
	private WebElement accountingSetup_ChartOfAccountsDefinition_ControlAccount;
	
	public WebElement accountingSetup_ChartOfAccountsDefinition_ControlAccount() {
		return accountingSetup_ChartOfAccountsDefinition_ControlAccount;
	}
	
	//Radio Button (YES)
	@FindBy(xpath = "//ion-item[1]/ion-radio")
	private WebElement accountingSetup_ChartOfAccountsDefinition_RadioYes;
	
	public WebElement accountingSetup_ChartOfAccountsDefinition_RadioYes() {
		return accountingSetup_ChartOfAccountsDefinition_RadioYes;
	}
	
	//Radio Button (NO)
	@FindBy(xpath = "//ion-item[2]/ion-radio")
	private WebElement accountingSetup_ChartOfAccountsDefinition_RadioNo;
	
	public WebElement accountingSetup_ChartOfAccountsDefinition_RadioNo() {
		return accountingSetup_ChartOfAccountsDefinition_RadioNo;
	}
	
	// Status
	@FindBy(xpath = "//ion-row[6]/ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[3]/input[1]")
	private WebElement accountingSetup_ChartOfAccountsDefinition_StatusField;
	
	public WebElement accountingSetup_ChartOfAccountsDefinition_StatusField() {
		return accountingSetup_ChartOfAccountsDefinition_StatusField;
	}
	
	// Remarks
//	@FindBy(xpath = "//ion-row[7]/ion-col[1]/ion-item[1]/ion-textarea[1]/div[1]")
	@FindBy(xpath = "//ion-textarea/div/textarea")
	private WebElement accountingSetup_ChartOfAccountsDefinition_Remarks;
	
	public WebElement accountingSetup_ChartOfAccountsDefinition_Remarks() {
		return accountingSetup_ChartOfAccountsDefinition_Remarks;
	}
	
	// Save Button
	@FindBy(xpath = "(//ion-buttons[2]/ion-button[1])[2]")
	private WebElement accountingSetup_ChartOfAccountsDefinition_SaveButton;
	
	public WebElement accountingSetup_ChartOfAccountsDefinition_SaveButton() {
		return accountingSetup_ChartOfAccountsDefinition_SaveButton;
	}
	

	//record status for modification not allowed
	@FindBy(xpath = "//body/div/div/div/div[2]")
	private WebElement accountingSetup_ChartOfAccountsDefinition_RecordStatus;

	public WebElement accountingSetup_ChartOfAccountsDefinition_RecordStatus() {
		return accountingSetup_ChartOfAccountsDefinition_RecordStatus;
	}
	
	//submit
	
	@FindBy(xpath = "//ion-button[contains(text(),'Submit')]")
	private WebElement accountingSetup_ChartOfAccountsDefinition_RemarkSubmit;

	public WebElement accountingSetup_ChartOfAccountsDefinition_RemarkSubmit() {
		return accountingSetup_ChartOfAccountsDefinition_RemarkSubmit;
	}
}



