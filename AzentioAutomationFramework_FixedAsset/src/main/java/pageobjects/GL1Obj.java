package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GL1Obj {
 
		WebDriver driver;

		public GL1Obj(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		//accountingSetup button
		
		@FindBy(xpath = "//ion-label[contains(text(),'Accounting setup')]")
		private WebElement accountingSetup_Button;

		public WebElement accountingSetup_Button() {
			return accountingSetup_Button;
		}
		

		@FindBy(xpath = "//custom-side-menu[1]/ion-list[1]/div[3]/ion-menu-toggle[3]/ion-item[1]/ion-buttons[1]/ion-button[2]")
		private WebElement chartOfAccountsDefination_Button;

		public WebElement chartOfAccountsDefination_Button() {
			return chartOfAccountsDefination_Button;
		}	
		
		@FindBy(xpath = "//ion-router-outlet[1]/app-data-grid[1]/ion-content[1]/ion-fab[1]/ion-fab-button[1]/ion-icon[1]")
		private WebElement chartOfAccountsDefination_AddButton;

		public WebElement chartOfAccountsDefination_AddButton() {
			return chartOfAccountsDefination_AddButton;
		}	
		
		@FindBy(xpath = "//ion-row[1]/ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement accountingCategory_textBox;

		public WebElement accountingCategory_textBox() {
			return accountingCategory_textBox;
		}	
		
		@FindBy(xpath = "//ion-infinite-scroll[1]/ion-grid[1]/ion-row[1]/ion-col[3]/ion-item[1]/ion-input[1]/input[1]")
		private WebElement cOAname_textBox;

		public WebElement cOAname_textBox() {
			return cOAname_textBox;
		}	
		
		@FindBy(xpath = "//ion-row[2]/ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement parentGL_textBox;

		public WebElement parentGL_textBox() {
			return parentGL_textBox;
		}
		
		@FindBy(xpath = "//form[1]/ion-infinite-scroll[1]/ion-grid[1]/ion-row[2]/ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement gLType_textBox;

		public WebElement gLType_textBox() {
			return gLType_textBox;
		}
		
		@FindBy(xpath = "//form[1]/ion-infinite-scroll[1]/ion-grid[1]/ion-row[3]/ion-col[1]/ion-item[1]/ion-input[1]/input[1]")
		private WebElement decriptionOfGL_textBox;

		public WebElement decriptionOfGL_textBox() {
			return decriptionOfGL_textBox;
		}
		
		@FindBy(xpath = "//ion-select[@id='field_mglBranchSpecificInd']")
		private WebElement branchSpecific_Box;

		public WebElement branchSpecific_Box() {
			return branchSpecific_Box;
		}
		
		@FindBy(xpath = "//ion-select-popover[1]/ion-list[1]/ion-radio-group[1]/ion-item[2]/ion-radio[1]")
		private WebElement branchSpecific_NoRadioBox;

		public WebElement branchSpecific_NoRadioBox() {
			return branchSpecific_NoRadioBox;
		}
		
		@FindBy(xpath = "//ion-select-popover[1]/ion-list[1]/ion-radio-group[1]/ion-item[1]/ion-radio[1]")
		private WebElement branchSpecific_YesRadioBox;

		public WebElement branchSpecific_YesRadioBox() {
			return branchSpecific_YesRadioBox;
		}
		
		@FindBy(xpath = "//ion-select[@id='field_mglControlAcctInd']")
		private WebElement controlAccount_Box;

		public WebElement controlAccount_Box() {
			return controlAccount_Box;
		}
		
		@FindBy(xpath = "//ion-select-popover[1]/ion-list[1]/ion-radio-group[1]/ion-item[2]/ion-radio[1]")
		private WebElement controlAccount_NoRadioBox;

		public WebElement controlAccount_NoRadioBox() {
			return controlAccount_NoRadioBox;
		}
		
		@FindBy(xpath = "//ion-grid[1]/ion-row[5]/ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement entitySegement_Box;

		public WebElement entitySegement_Box() {
			return entitySegement_Box;
		}
		
		@FindBy(xpath = "//ion-grid[1]/ion-row[7]/ion-col[1]/ion-item[1]/ion-textarea[1]/div[1]/textarea[1]")
		private WebElement remarkForGeneralLedger_Box;

		public WebElement remarkForGeneralLedger_Box() {
			return remarkForGeneralLedger_Box;
		}
		
		
		
		@FindBy(xpath = "//page-general-ledger-update[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1]")
		private WebElement saveButtonForGeneralLedger;

		public WebElement saveButtonForGeneralLedger() {
			return saveButtonForGeneralLedger;
		}
		
		
		@FindBy(xpath = "//ion-content[1]/app-data-grid[1]/ion-content[1]/ion-fab[1]/ion-fab-button[1]/ion-icon[1]")
		private WebElement branch_AddButton;

		public WebElement branch_AddButton() {
			return branch_AddButton;
		}
		
		@FindBy(xpath = "//ion-grid[1]/ion-row[1]/ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement branch_TextBox;

		public WebElement branch_TextBox() {
			return branch_TextBox;
		}
		
		
		@FindBy(xpath = "//ion-row[1]/ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement department_TextBox;

		public WebElement department_TextBox() {
			return department_TextBox;
		}
		
		
		
		@FindBy(xpath = "//ion-grid[1]/ion-row[1]/ion-col[4]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement costCentre_TextBox;

		public WebElement costCentre_TextBox() {
			return costCentre_TextBox;
		}
		
		
		@FindBy(xpath = "//page-gl-branch-update[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1]")
		private WebElement branch_SaveButton;

		public WebElement branch_SaveButton() {
			return branch_SaveButton;
		}
		//after branch is saved we again save record
		@FindBy(xpath = "//page-general-ledger-update[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1]")
		private WebElement gLbranch_SaveButton;

		public WebElement gLbranch_SaveButton() {
			return gLbranch_SaveButton;
		}
		
		@FindBy(xpath = "//ion-row[4]/ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
		private WebElement balanceType_Textbox;

		public WebElement balanceType_Textbox() {
			return balanceType_Textbox;
		}
		
			
		
		@FindBy(xpath = "//ion-header/ion-toolbar[1]/ion-buttons[2]/ion-item[1]/ion-icon[1]")
		private WebElement search_Button;

		public WebElement search_Button() {
			return search_Button;
		}
			
		
		
		
		@FindBy(xpath = "//datatable-header[1]/div[1]/div[2]/datatable-header-cell[3]/div[1]/ion-input[1]/input[1]")
		private WebElement cOANameSearch_Textbox;

		public WebElement cOANameSearch_Textbox() {
			return cOANameSearch_Textbox;
		}
		
		
		@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[1]/div[1]/ion-buttons[1]/ion-button[2]")
		private WebElement editAction_Button;

		public WebElement editAction_Button() {
			return editAction_Button;
		}
		
		
		@FindBy(xpath = "//ion-row[6]/ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[3]/input[1]")
		private WebElement statusOfCOA_Textbox;

		public WebElement statusOfCOA_Textbox() {
			return statusOfCOA_Textbox;
		}
		
		
		@FindBy(xpath = "//page-general-ledger-update[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1]")
		private WebElement saveCOA_Button;

		public WebElement saveCOA_Button() {
			return saveCOA_Button;
		}
		
		
		
		@FindBy(xpath = "//div[@class='ng-tns-c135-15 toast-message ng-star-inserted']")
		private WebElement activeTransactionCOA_Toast;

		public WebElement activeTransactionCOA_Toast() {
			return activeTransactionCOA_Toast;
		}
		
		@FindBy(xpath = "//div[@id='toast-container']//div[@role='alert']")
		private WebElement budget_creation_Getalert;

		public WebElement budget_creation_Getalert() {
		return budget_creation_Getalert;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
