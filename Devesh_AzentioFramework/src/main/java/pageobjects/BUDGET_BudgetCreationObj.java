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

	@FindBy(xpath = "//ion-label[contains(text(),'anant')]")
	private WebElement budget_creation_logout_button;

	public WebElement budgetCreation_LogoutButton() {
		return budget_creation_logout_button;

	}  
	@FindBy(xpath = "//ng-dropdown-panel//div[4]")
	private WebElement budget_creation_Yearly_budget;

	public WebElement budgetCreationYearlyBudget() {
		return budget_creation_Yearly_budget;

	}
	
}
