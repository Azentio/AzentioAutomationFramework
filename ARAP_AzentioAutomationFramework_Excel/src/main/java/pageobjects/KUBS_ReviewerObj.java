package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KUBS_ReviewerObj {

	WebDriver driver;

	public KUBS_ReviewerObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/inbox']")
	@FindBy(xpath = "//ion-toolbar[1]/ion-buttons[2]/ion-button[2]")
	private WebElement reviewer_notification_icon;

	public WebElement reviewerNotidicationIcon() {
		return reviewer_notification_icon;
	}
	@FindBy(xpath = "//label[contains(text(),'Reference Id')]")
	private WebElement reviewer_notification_referenceIdLabel;
	
	public WebElement reviewer_notification_referenceIdLabel() {
		return reviewer_notification_referenceIdLabel;
	}
	
    @FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[1]//ion-button")
	private WebElement reviewer_action_button1;

	public WebElement reviewer_action_button1() {
		return reviewer_action_button1;
	}
	
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[1]//ion-button")
	private WebElement reviewer_action_button;

	public WebElement reviewer_action_button() {
		return reviewer_action_button;
	} 
	
	@FindBy(xpath = "//span[text()='Reject']")
	private WebElement reviewer_reject_button;

	public WebElement reviewerRejectButton() {
		return reviewer_reject_button;
	}

	@FindBy(xpath = "//span[text()='Approve']/..")
	private WebElement reviewer_approve_button;

	public WebElement reviewerApproveButton() {
		return reviewer_approve_button;

	}

	@FindBy(xpath = "//span[text()='Return']")
	private WebElement reviewer_return_button;

	public WebElement reviewerReturnButton() {
		return reviewer_return_button;
	}

	@FindBy(xpath = "//ion-input/input[@name='budgetCode']")
	private WebElement reviewer_budget_code;

	public WebElement reviewerGetBudgetCode() {
		return reviewer_budget_code;
	}

	@FindBy(xpath = "//ion-col[3]/app-kub-lov/span/ng-select/div/div/div[2]")
	private WebElement reviewer_budget_year;

	public WebElement reviewerGetBudgetYear() {
		return reviewer_budget_year;
	}

	@FindBy(xpath = "//input[@name='warningPercentage']")
	private WebElement reviewer_warning_percentage;

	public WebElement reviewerGetWarningPercentage() {
		return reviewer_warning_percentage;
	}

	@FindBy(xpath = "//input[@name='budgetName']")
	private WebElement reviewer_budget_name;

	public WebElement reviewerGetBudgetName() {
		return reviewer_budget_name;
	}

	@FindBy(xpath = "//ion-col[8]/app-kub-lov/span/ng-select/div/div/div[2]")
	private WebElement reviewer_budget_status;

	public WebElement reviewerGetBudgetStatus() {
		return reviewer_budget_status;
	}

	@FindBy(xpath = "//ion-row[1]/ion-col[1]/ion-item[1]/ion-textarea[1]/div[1]/textarea[1]")
	private WebElement reviewer_alert_remarks;

	public WebElement reviewerAlertRemarks() {
		return reviewer_alert_remarks;
	}

	@FindBy(xpath = "//ion-button[contains(text(),'Submit')]")
	private WebElement reviewer_alert_submit_button;

	public WebElement reviewerAlertSubmitButton() {
		return reviewer_alert_submit_button;
	}

	@FindBy(xpath = "//div[contains(text(),'Record REJECTED Successfully')]")
	private WebElement reviewer_reject_toast;

	public WebElement reviewer_reject_toast() {
		return reviewer_reject_toast;
	}
@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[1]//ion-button")
	private WebElement reviewerActionButton;

	public WebElement reviewerActionButton() {
		return reviewerActionButton;

	}

	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[2]//span")
	private WebElement reviewer_reference_id;

	public WebElement reviewerReferenceID() {
		return reviewer_reference_id;

	}

	@FindBy(xpath="//div[@id='toast-container']/div/div[@role='alert']")
	private WebElement reviewer_approval_status;
	public WebElement reviewerApprovalStatus()
	{
		return reviewer_approval_status;
	}
	@FindBy(xpath="//ion-col[3]//ng-select/div/div/div/span[2]")
	private WebElement budget_type;
	public WebElement budgetType()
	{
		return budget_type;
		
	}
	 @FindBy(xpath="//ion-header/ion-toolbar[1]/ion-buttons[2]/ion-button[4]")
	    private WebElement reviewer_user_name;
	    public WebElement reviewerUserName()
	    {
	    	return reviewer_user_name;
	    }
	    @FindBy(xpath="//ion-label[contains(text(),'Logout')]")
	    private WebElement reviewer_logout_button;
	    public WebElement reviewerLogoutButton()
	    {
			return reviewer_logout_button;
	    	
	    }
	    @FindBy(xpath="//div[@id='toast-container']//button")
		private WebElement reviewer_alert_close;
		public WebElement reviewerAlertClose()
		{
			return reviewer_alert_close;
		}
		//---------
		 
		@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[2]//span")
		private WebElement reviewer_referanceid;

		public WebElement reviewer_referanceid() {
			return reviewer_referanceid;
		}
	 
		
		@FindBy(xpath="//div[@id='toast-container']/div/div[@role='alert']")
		private WebElement approval_status;
		public WebElement approvalStatus()
		{
			return approval_status;
		}
		
}
