package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BUDGET_BudgetTransferObj {
	WebDriver driver;

	public BUDGET_BudgetTransferObj(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ion-label[contains(text(),' Budget ')]")
	private WebElement budget_BudgetTransfer_BudgetField;

	public WebElement budget_BudgetTransfer_BudgetField() {
		return budget_BudgetTransfer_BudgetField;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/224']")
	private WebElement budget_BudgetTransfer_EyeButton;

	public WebElement budget_BudgetTransfer_EyeButton() {
		return budget_BudgetTransfer_EyeButton;

	}

	@FindBy(xpath = "//ion-icon[@ng-reflect-name='add']")
	private WebElement budget_BudgetTransfer_AddButton;

	public WebElement budget_BudgetTransfer_AddButton() {
		return budget_BudgetTransfer_AddButton;

	}

	//
	@FindBy(xpath = "//ion-col[2]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement budget_BudgetTransfer_BudgetCodeDropDown;

	public WebElement budget_BudgetTransfer_BudgetCodeDropDown() {
		return budget_BudgetTransfer_BudgetCodeDropDown;

	}

	@FindBy(xpath = "(//div[@role='combobox'])[3]/input")
	private WebElement budget_BudgetTransfer_BudgetYearDropdown;

	public WebElement budget_BudgetTransfer_BudgetYearDropdown() {
		return budget_BudgetTransfer_BudgetYearDropdown;

	}

	@FindBy(xpath = "(//div[@role='combobox'])[4]//input")
	private WebElement budget_BudgetTransfer_Branch;

	public WebElement budget_BudgetTransfer_Branch() {
		return budget_BudgetTransfer_Branch;

	}

	@FindBy(xpath = "(//div[@role='combobox'])[5]//input")
	private WebElement budget_BudgetTransfer_TransferToBudgetCode;

	public WebElement budget_BudgetTransfer_TransferToBudgetCode() {
		return budget_BudgetTransfer_TransferToBudgetCode;

	}

	@FindBy(xpath = "//input[@id='trxAmt']")
	private WebElement budget_BudgetTransfer_TransferAmount;

	public WebElement budget_BudgetTransfer_TransferAmount() {
		return budget_BudgetTransfer_TransferAmount;

	}

	@FindBy(xpath = "(//div[@role='combobox'])[6]//input")
	private WebElement budget_BudgetTransfer_CurrencyChange;

	public WebElement budget_BudgetTransfer_CurrencyChange() {
		return budget_BudgetTransfer_CurrencyChange;

	}

	@FindBy(xpath = "//ion-col[12]//ion-item//ion-input//input")
	private WebElement budget_BudgetTransfer_Comment;

	public WebElement budget_BudgetTransfer_Comment() {
		return budget_BudgetTransfer_Comment;

	}

	@FindBy(xpath = "(//datatable-body-cell[3]//div//app-kub-currency//input[1])[1]")
	private WebElement budget_BudgetTransfer_ApportionedAmountA;

	public WebElement budget_BudgetTransfer_ApportionedAmountA() {
		return budget_BudgetTransfer_ApportionedAmountA;

	}

	@FindBy(xpath = "(//datatable-body-cell[4]//div//app-kub-currency//input)[1]")
	private WebElement budget_BudgetTransfer_fromNewAmountA;

	public WebElement budget_BudgetTransfer_fromNewAmountA() {
		return budget_BudgetTransfer_fromNewAmountA;

	}

	@FindBy(xpath = "(//datatable-body-cell[3]//div//app-kub-currency//input[1])[2]")
	private WebElement budget_BudgetTransfer_ApportionedAmountB;

	public WebElement budget_BudgetTransfer_ApportionedAmountB() {
		return budget_BudgetTransfer_ApportionedAmountB;

	}

	@FindBy(xpath = "(//datatable-body-cell[4]//div//app-kub-currency//input)[2]")
	private WebElement budget_BudgetTransfer_NewAmountB;

	public WebElement budget_BudgetTransfer_NewAmountB() {
		return budget_BudgetTransfer_NewAmountB;

	}

	@FindBy(xpath = "//div[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1]")
	private WebElement budget_BudgetTransfer_SaveButton;

	public WebElement budget_BudgetTransfer_SaveButton() {
		return budget_BudgetTransfer_SaveButton;

	}

	@FindBy(xpath = "//ion-buttons[2]/ion-button[2]")
	private WebElement budget_BudgetTransfer_NotificationButton;

	public WebElement budget_BudgetTransfer_NotificationButton() {
		return budget_BudgetTransfer_NotificationButton;
	}

	@FindBy(xpath = "//app-inbox//datatable-row-wrapper[1]//datatable-body-row//div[2]//datatable-body-cell//div//ion-buttons//ion-button")
	private WebElement budget_BudgetTransfer_FirstPencilButton;

	public WebElement budget_BudgetTransfer_FirstPencilButton() {
		return budget_BudgetTransfer_FirstPencilButton;
	}

	@FindBy(xpath = "//app-inbox//datatable-row-wrapper[1]//datatable-body-row//div[2]//datatable-body-cell[2]//div//span")
	private WebElement budget_BudgetTransfer_FirstReferenceId;

	public WebElement budget_BudgetTransfer_FirstReferenceId() {
		return budget_BudgetTransfer_FirstReferenceId;
	}

	// Submit
	@FindBy(xpath = "//span[contains(text(),'Submit')]")
	private WebElement budget_BudgetTransfer_SubmitButton;

	public WebElement budget_BudgetTransfer_SubmitButton() {
		return budget_BudgetTransfer_SubmitButton;
	}

	// Remark field
	@FindBy(xpath = "//ion-textarea/div/textarea[@name='remarks']")

	private WebElement budget_BudgetTransfer_RemarkField;

	public WebElement budget_BudgetTransfer_RemarkField() {
		return budget_BudgetTransfer_RemarkField;
	}

	// Submit by maker
	@FindBy(xpath = "//ion-row/ion-col/ion-button")
	private WebElement budget_BudgetTransfer_Submit;

	public WebElement budget_BudgetTransfer_Submit() {
		return budget_BudgetTransfer_Submit;
	}

	@FindBy(xpath = "//body/div/div/div/div[1]")
	private WebElement budget_BudgetTransfer_RecordStatus;

	public WebElement budget_BudgetTransfer_RecordStatus() {
		return budget_BudgetTransfer_RecordStatus;
	}

	// ------TESTCASE BP_BT_05_03--------//

	@FindBy(xpath = "//datatable-pager[1]/ul[1]/li[8]/a[1]/i[1]")
	private WebElement maker_notification_next_button;

	public WebElement maker_notification_next_button() {
		return maker_notification_next_button;
	}

	@FindBy(xpath = "//ion-buttons[2]//ion-button[4]")
	private WebElement budget_profilename;

	public WebElement budget_ProfileName() {
		return budget_profilename;
	}

	@FindBy(xpath = "//ion-icon[@name='log-out']")
	private WebElement budget_Logout;

	public WebElement budget_Logout() {
		return budget_Logout;
	}

	@FindBy(xpath = "//datatable-header-cell[2]//label")
	private WebElement budget_BudgetTransfer_VerifyBudgetCodeField;

	public WebElement budget_BudgetTransfer_VerifyBudgetCodeField() {
		return budget_BudgetTransfer_VerifyBudgetCodeField;
	}

	@FindBy(xpath = "//datatable-header-cell[3]//label")
	private WebElement budget_BudgetTransfer_VerifyBudgetNameField;

	public WebElement budget_BudgetTransfer_VerifyBudgetNameField() {
		return budget_BudgetTransfer_VerifyBudgetNameField;
	}

	@FindBy(xpath = "//datatable-header-cell[4]//label")
	private WebElement budget_BudgetTransfer_VerifyBudgetYearField;

	public WebElement budget_BudgetTransfer_VerifyBudgetYearField() {
		return budget_BudgetTransfer_VerifyBudgetYearField;
	}

	@FindBy(xpath = "//datatable-header-cell[5]//label")
	private WebElement budget_BudgetTransfer_VerifyBudgetTransferFromField;

	public WebElement budget_BudgetTransfer_VerifyBudgetTransferFromField() {
		return budget_BudgetTransfer_VerifyBudgetTransferFromField;
	}

	@FindBy(xpath = "//datatable-header-cell[6]//label")
	private WebElement budget_BudgetTransfer_VerifyBudgetTransferToField;

	public WebElement budget_BudgetTransfer_VerifyBudgetTransferToField() {
		return budget_BudgetTransfer_VerifyBudgetTransferToField;
	}

	@FindBy(xpath = "//datatable-header-cell[7]//label")
	private WebElement budget_BudgetTransfer_VerifyBudgetTransferAmountField;

	public WebElement budget_BudgetTransfer_VerifyBudgetTransferAmountField() {
		return budget_BudgetTransfer_VerifyBudgetTransferAmountField;
	}

	@FindBy(xpath = "//datatable-header-cell[8]//label")
	private WebElement budget_BudgetTransfer_VerifyStatusField;

	public WebElement budget_BudgetTransfer_VerifyStatusField() {
		return budget_BudgetTransfer_VerifyStatusField;
	}

	@FindBy(xpath = "//ion-segment/ion-segment-button[2]")
	private WebElement budget_BudgetTransfer_DirectionIcon;

	public WebElement budget_BudgetTransfer_DirectionIcon() {
		return budget_BudgetTransfer_DirectionIcon;
	}

	@FindBy(xpath = "document.querySelector('ion-toast').shadowRoot.querySelector(\"div[class='toast-message']\")")
	private WebElement budget_BudgetTransfer_Excessive_Amount_Toast;

	public WebElement budget_BudgetTransfer_Excessive_Amount_Toast() {
		return budget_BudgetTransfer_Excessive_Amount_Toast;

	}

//Pencil
	@FindBy(xpath = "//app-inbox//datatable-row-wrapper[1]//datatable-body-row//div[2]//datatable-body-cell//div//ion-buttons//ion-button")
	private WebElement budget_BudgetTransfer_Pencil;

	public WebElement budget_BudgetTransfer_Pencil() {
		return budget_BudgetTransfer_Pencil;

	}

//Submit
//		@FindBy(xpath="//span[contains(text(),'Submit')]")
//		private WebElement budget_BudgetTransfer_Submit;
//		public WebElement budget_BudgetTransfer_Submit()
//		{
//			return budget_BudgetTransfer_Submit;
//			
//		}
//Submit by maker remark
	@FindBy(xpath = "//ion-button[contains(text(),'Submit')]")
	private WebElement budget_BudgetTransfer_SubmitByMaker;

	public WebElement budget_BudgetTransfer_SubmitByMaker() {
		return budget_BudgetTransfer_SubmitByMaker;

	}

//search 
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link=\"/tabs/list/datagrid/39\"]")
	private WebElement budget_BudgetTransfer_NoteIcon;

	public WebElement budget_BudgetTransfer_NoteIcon() {
		return budget_BudgetTransfer_NoteIcon;

	}

	@FindBy(xpath = "//ion-icon[@title='Enable Search']")
	private WebElement budget_BudgetTransfer_SearchIcon;

	public WebElement budget_BudgetTransfer_SearchIcon() {
		return budget_BudgetTransfer_SearchIcon;

	}

	@FindBy(xpath = "//ion-input[@id='col0']//input")
	private WebElement budget_BudgetTransfer_SearchBudgetCode;

	public WebElement budget_BudgetTransfer_SearchBudgetCode() {
		return budget_BudgetTransfer_SearchBudgetCode;

	}

	@FindBy(xpath = "//ion-input[@id='col1']//input")
	private WebElement budget_BudgetTransfer_SearchBudgetName;

	public WebElement budget_BudgetTransfer_SearchBudgetName() {
		return budget_BudgetTransfer_SearchBudgetName;

	}

	@FindBy(xpath = "//ion-input[@id='col2']//input")
	private WebElement budget_BudgetTransfer_SearchBudgetYear;

	public WebElement budget_BudgetTransfer_SearchBudgetYear() {
		return budget_BudgetTransfer_SearchBudgetYear;

	}

	@FindBy(xpath = "//ion-input[@id='col3']//input")
	private WebElement budget_BudgetTransfer_SearchTransferFrom;

	public WebElement budget_BudgetTransfer_SearchTransferFrom() {
		return budget_BudgetTransfer_SearchTransferFrom;

	}

	@FindBy(xpath = "//ion-input[@id='col4']//input")
	private WebElement budget_BudgetTransfer_SearchTransferTo;

	public WebElement budget_BudgetTransfer_SearchTransferTo() {
		return budget_BudgetTransfer_SearchTransferTo;

	}

	@FindBy(xpath = "//ion-input[@id='col5']//input")
	private WebElement budget_BudgetTransfer_SearchTransferAmount;

	public WebElement budget_BudgetTransfer_SearchTransferAmount() {
		return budget_BudgetTransfer_SearchTransferAmount;

	}

	@FindBy(xpath = "//ion-input[@id='col6']//input")
	private WebElement budget_BudgetTransfer_SearchStatus;

	public WebElement budget_BudgetTransfer_SearchStatus() {
		return budget_BudgetTransfer_SearchStatus;

	}

	@FindBy(xpath = "//datatable-body/datatable-selection[1]/datatable-scroller[1]/datatable-row-wrapper[1]")
	private WebElement budget_BudgetTransfer_SearchRecord;

	public WebElement budget_BudgetTransfer_SearchRecord() {
		return budget_BudgetTransfer_SearchRecord;

	}

	@FindBy(xpath = "//span/ion-button[1]")
	private WebElement maker_Approve_button;

	public WebElement maker_Approve_button() {

		return maker_Approve_button;
	}

	@FindBy(xpath = "//ion-header/ion-toolbar[1]/ion-buttons[2]/ion-button[2]")
	private WebElement budget_BudgetTransfer_NotificationIcon;

	public WebElement budget_BudgetTransfer_NotificationIcon() {
		return budget_BudgetTransfer_NotificationIcon;
}
}
