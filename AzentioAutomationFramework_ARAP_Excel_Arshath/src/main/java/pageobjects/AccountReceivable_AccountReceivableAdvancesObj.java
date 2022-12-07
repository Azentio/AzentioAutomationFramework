package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountReceivable_AccountReceivableAdvancesObj {

	WebDriver driver;

	public AccountReceivable_AccountReceivableAdvancesObj(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);

	}

	
	//Account Receivable Button
	@FindBy(xpath = "//ion-label[text()=' Accounts receivable ']")
	private WebElement accountReceivable_AccountReceivableAdvances_AccountReceivableButton;

	public WebElement accountReceivable_AccountReceivableAdvances_AccountReceivableButton() {
		return accountReceivable_AccountReceivableAdvances_AccountReceivableButton;
	}
	//Account Receivable (Advances) Eye Button
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/190']")
	private WebElement accountReceivable_AccountReceivableAdvances_EyeButton;

	public WebElement accountReceivable_AccountReceivableAdvances_EyeButton() {
		return accountReceivable_AccountReceivableAdvances_EyeButton;
	}

	//Account Receivable (Advances) Add Button
	@FindBy(xpath = "//app-data-grid[1]/ion-content[1]/ion-fab[1]/ion-fab-button[1]/ion-icon[1]")
	private WebElement accountReceivable_AccountReceivableAdvances_AddButton;

	public WebElement accountReceivable_AccountReceivableAdvances_AddButton() {
		return accountReceivable_AccountReceivableAdvances_AddButton;
	}
	//Entity Branch
	@FindBy(xpath = "//ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[3]/input")
	private WebElement accountReceivable_AccountReceivableAdvances_EntityBranch;

	public WebElement accountReceivable_AccountReceivableAdvances_EntityBranch() {
		return accountReceivable_AccountReceivableAdvances_EntityBranch;
	}
	//ReceivableName
	@FindBy(xpath = "//ion-row[1]/ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement accountReceivable_AccountReceivableAdvances_ReceivableName;

	public WebElement accountReceivable_AccountReceivableAdvances_ReceivableName() {
		return accountReceivable_AccountReceivableAdvances_ReceivableName;
	}
	

	//EmployeeName
	@FindBy(xpath = "//ion-grid[1]/ion-row[1]/ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement accountReceivable_AccountReceivableAdvances_EmployeeName;

	public WebElement accountReceivable_AccountReceivableAdvances_EmployeeName() {
		return accountReceivable_AccountReceivableAdvances_EmployeeName;
	}

	//PONumber Text Box
	@FindBy(xpath = "//ion-grid[1]/ion-row[2]/ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement accountReceviableAdvances_PONumber_TextBox;

	public WebElement accountReceviableAdvances_PONumber_TextBox() {
		return accountReceviableAdvances_PONumber_TextBox;
	}
				
	//PaymentMode 
	@FindBy(xpath = "//ion-grid[1]/ion-row[3]/ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement accountReceivable_AccountReceivableAdvances_PaymentMode;

	public WebElement accountReceivable_AccountReceivableAdvances_PaymentMode() {
		return accountReceivable_AccountReceivableAdvances_PaymentMode;
	}
	
	//Amount 
	@FindBy(xpath = "//input[@id='advanceAmt']")
	private WebElement accountReceivable_AccountReceivableAdvances_Amount;

	public WebElement accountReceivable_AccountReceivableAdvances_Amount() {
		return accountReceivable_AccountReceivableAdvances_Amount;
	}
	
	//Currency 
	@FindBy(xpath = "//ion-grid[1]/ion-row[3]/ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement accountReceivable_AccountReceivableAdvances_Currency;

	public WebElement accountReceivable_AccountReceivableAdvances_Currency() {
		return accountReceivable_AccountReceivableAdvances_Currency;
	}
	
	//CostCenter
	@FindBy(xpath = "//ion-row[3]/ion-col[4]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement accountReceivable_AccountReceivableAdvances_CostCenter;

	public WebElement accountReceivable_AccountReceivableAdvances_CostCenter() {
		return accountReceivable_AccountReceivableAdvances_CostCenter;
	}
	//Description 
	@FindBy(xpath = "//ion-col[5]/ion-item[1]/ion-input[1]/input")
	private WebElement accountReceivable_AccountReceivableAdvances_Description;

	public WebElement accountReceivable_AccountReceivableAdvances_Description() {
		return accountReceivable_AccountReceivableAdvances_Description;
	}	
	

	
	//Save Button
	@FindBy(xpath = "(//ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1])[2]")
	private WebElement accountReceivable_AccountReceivableAdvances_Save;

	public WebElement accountReceivable_AccountReceivableAdvances_Save() {
		return accountReceivable_AccountReceivableAdvances_Save;
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
	
	// FirstReferenceID
		@FindBy(xpath = "//app-inbox//datatable-row-wrapper[1]//datatable-body-row//div[2]//datatable-body-cell[2]//div//span")
		private WebElement FirstReferenceId;

		public WebElement FirstReferenceId() {
			return FirstReferenceId;
		}
		
		@FindBy(xpath="//app-inbox//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[1]//ion-button")
		
		
		private WebElement  ActionButton;
		public WebElement  ActionButton() {
			return ActionButton;
		}
		
		
		// Inbox Search icon
		@FindBy(xpath = "//div[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[2]")
		private WebElement InboxSearchIcon;

		public WebElement InboxSearchIcon() {
			return InboxSearchIcon;
		}

		// EventCodeSearch
		@FindBy(xpath = "//div[2]/datatable-header-cell[3]/div[1]/ion-input[1]/input[1]")
		private WebElement EventCodeSearch;

		public WebElement EventCodeSearch() {
			return EventCodeSearch;
		}
		
		// Submit
		@FindBy(xpath = "//span[contains(text(),'Submit')]")
		private WebElement SubmitButton;

		public WebElement SubmitButton() {
			return SubmitButton;
		}
		
		@FindBy(xpath = "//ion-row[1]/ion-col/ion-item/ion-textarea/div/textarea")
		private WebElement RemarkField;

		public WebElement RemarkField() {
			return RemarkField;
		}
		
		// Submit by maker
		@FindBy(xpath = "//ion-row[2]/ion-button")
		private WebElement Submit;

		public WebElement Submit() {
			return Submit;
		}
		
		// record status
		@FindBy(xpath = "//body/div/div/div/div[1]")
		private WebElement RecordStatus;

		public WebElement RecordStatus() {
			return RecordStatus;
		}
		
		@FindBy(xpath = "//textarea[@name='remarks']")
		private WebElement ApproveRemarkByReviewer;

		public WebElement ApproveRemarkByReviewer() {
			return ApproveRemarkByReviewer;
		}
		
		// approve button
		@FindBy(xpath = "//span/ion-button[1]")
		private WebElement Approve_Button;

		public WebElement Approve_Button() {
			return Approve_Button;

		}
		
		
		// Search icon
		@FindBy(xpath = "(//ion-buttons/ion-item/ion-icon)[2]")
		private WebElement Search_Icon;

		public WebElement Search_Icon() {
			return Search_Icon;
		}
		// Record Search using Business Partner
		@FindBy(xpath = "//datatable-header-cell[5]/div/ion-input/input")
		private WebElement BusinessPartnerSearch;

		public WebElement BusinessPartnerSearch() {
			return BusinessPartnerSearch;
		}

		// Advance to employee record Status
		@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[8]/div[1]/span")
		private WebElement AdvanceToEmployee_Record_Status;

		public WebElement AdvanceToEmployee_Record_Status() {
			return AdvanceToEmployee_Record_Status;
		}

		// txn Status
		@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[9]/div[1]/span")
		private WebElement TxnStatus;

		public WebElement TxnStatus() {
			return TxnStatus;
		}

}
