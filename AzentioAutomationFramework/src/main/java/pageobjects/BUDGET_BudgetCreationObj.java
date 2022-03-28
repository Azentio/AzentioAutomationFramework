package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BUDGET_BudgetCreationObj {

	WebDriver driver;

	public BUDGET_BudgetCreationObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/219']")
	private WebElement budget_creation_eyeIcon;

	public WebElement budgetCreation_EyeIcon() {
		return budget_creation_eyeIcon;

	}
    @FindBy(xpath="//ion-icon[@title='Enable Search']")
    private WebElement budget_creation_search_icon;
    public WebElement budgetCreationSearchIcon()
    {
		return budget_creation_search_icon;
    	
    }
    @FindBy(xpath="//input[@placeholder='Search Budget Code']")
    private WebElement budget_creation_search_budget_code;
    public WebElement budgetCreationSearchBudgetCode()
    {
		return budget_creation_search_budget_code;
    	
    }
	@FindBy(xpath = "//ion-fab-button[@id='addBtn']")
	private WebElement budget_creation_addbutton;

	public WebElement budgetCreation_AddButton() {
		return budget_creation_addbutton;
	}

	@FindBy(xpath = "//input[@name='budgetCode']")
	private WebElement budget_creation_budgetcode;

	public WebElement budgetCreation_BudgetCode() {
		return budget_creation_budgetcode;

	}

	@FindBy(xpath = "//ion-col[3]//ng-select/div/div/div/input")
	private WebElement budget_creation_budget_type;

	public WebElement budgetCreation_BudgetType() {
		return budget_creation_budget_type;
	}

	@FindBy(xpath = "//input[@name='warningPercentage']")
	private WebElement budget_creation_warning_percentage;

	public WebElement budgetCreation_WarningPercentage() {
		return budget_creation_warning_percentage;

	}

	@FindBy(xpath = "//input[@name='budgetName']")
	private WebElement budget_creation_budget_name;

	public WebElement budgetCreation_BudgetName() {
		return budget_creation_budget_name;

	}

	@FindBy(xpath = "//input[@name='remarks']")
	private WebElement budget_creation_remarks;

	public WebElement budgetCreation_Remarks() {
		return budget_creation_remarks;

	}

	@FindBy(xpath = "//div[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1]")
	private WebElement budget_creation_save_button;

	public WebElement budgetCreation_saveButton() {
		return budget_creation_save_button;

	}

	@FindBy(xpath = "//ion-textarea/div/textarea[@name='remarks']")
	private WebElement budget_creation_alert_remarks;

	public WebElement budgetCreation_AlertRemarks() {
		return budget_creation_alert_remarks;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid/36']")
	private WebElement budget_creation_action_button;

	public WebElement budgetCreation_ActionButton() {
		return budget_creation_action_button;

	}

	@FindBy(xpath = "//ion-button[contains(text(),'Submit')]")
	private WebElement budget_creation_alert_submit_button;

	public WebElement budgetCreation_AlertsubmitButton() {
		return budget_creation_alert_submit_button;
	}

	@FindBy(xpath = "//span[contains(text(),'Submit')]")
	private WebElement budget_creation_submit_button;

	public WebElement budgetCreation_SubmitButton() {
		return budget_creation_submit_button;

	}

	@FindBy(xpath = "//span[contains(text(),'Cancel')]")
	private WebElement budget_creation_cancel_button;

	public WebElement budgetCreation_CancelButton() {
		return budget_creation_cancel_button;

	}

	@FindBy(xpath = "//div[@id='toast-container']/div/div[@role='alertdialog']")
	private WebElement budget_creation_reviewer_id;

	public WebElement budgetCreation_ReviewerId() {
		return budget_creation_reviewer_id;
	}

//	@FindBy(xpath = "//ion-label[contains(text(),'anant')]")
//	private WebElement budget_creation_logout_button;
//
//	public WebElement budgetCreation_LogoutButton() {
//		return budget_creation_logout_button;
//
//	}

	@FindBy(xpath = "//div[contains(text(),'success')]")
	private WebElement budget_save_status;

	public WebElement budgetSaveStatus() {
		return budget_save_status;

	}

	@FindBy(xpath = "//ng-dropdown-panel//div[4]")
	private WebElement budget_creation_Yearly_budget;

	public WebElement budgetCreationYearlyBudget() {
		return budget_creation_Yearly_budget;

	}

	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[1]//ion-button[2]")
	private WebElement budget_creation_pencil_icon;

	public WebElement budgetCreationPencilIcon() {
		return budget_creation_pencil_icon;
	}
	@FindBy(xpath="//ion-toolbar[1]/ion-buttons[2]/ion-button[2]")
	private WebElement budget_creation_notification_icon;
	public WebElement budgetCreationNotificationIcon()
	{
		return budget_creation_notification_icon;
	}
	@FindBy(xpath="//app-inbox//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[2]//span")
	private WebElement budget_creation_first_reference_id;
	public WebElement budgetCreationFirstReferenceId()
	{
		return budget_creation_first_reference_id;
		
	}
	@FindBy(xpath="//app-inbox//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[1]//ion-button")
	private WebElement budget_creation_first_record;
	public WebElement budgetCreationFirstRecord()
	{
		return budget_creation_first_record;
		
	}
   @FindBy(xpath="//datatable-pager[1]/ul[1]/li[8]/a[1]/i[1]")
   private WebElement budget_creation_next_button;
   public WebElement budgetCreationNextButton()
   {
	   return budget_creation_next_button;
   }
   @FindBy(xpath="//span[contains(text(),'Approve')]")
   private WebElement budget_creation_approve_button;
   public WebElement budgetCreationApproveButton()
   {
	   return budget_creation_approve_button;
   }
   @FindBy(xpath = "//div[@id='toast-container']/div/div[@role='alertdialog']")
	private WebElement budget_creation_approval_status;

	public WebElement budgetCreationApprovalStatus() {
		return budget_creation_approval_status;
	}
	@FindBy(xpath="//div[@id='toast-container']//button")
	private WebElement alert_close;
	public WebElement checkerAlertClose()
	{
		return alert_close;
	}
    @FindBy(xpath="//ion-col[3]//ng-select[1]/div[1]/div[1]/div[2]/span[2]")
    private WebElement get_budget_type;
    public WebElement getBudgetType()
    {
    	return get_budget_type;
    }
    
    @FindBy(xpath="//ion-header/ion-toolbar[1]/ion-buttons[2]/ion-button[4]")
    private WebElement budget_creation_user_name;
    public WebElement budgetCreationUserName()
    {
    	return budget_creation_user_name;
    }
    @FindBy(xpath="//ion-label[contains(text(),'Logout')]")
    private WebElement budget_creation_logout_button;
    public WebElement budgetCreationLogoutButton()
    {
		return budget_creation_logout_button;
    	
    }
    @FindBy(xpath="//div[@id='toast-container']//button")
	private WebElement budget_creation_alert_close;
	public WebElement budgetCreationAlertClose()
	{
		return budget_creation_alert_close;
	}
}