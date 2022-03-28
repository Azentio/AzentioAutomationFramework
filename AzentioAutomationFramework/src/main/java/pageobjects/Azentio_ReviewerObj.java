package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Azentio_ReviewerObj {

	WebDriver driver;

	public Azentio_ReviewerObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/inbox']")
	private WebElement reviewer_notification_icon;

	public WebElement reviewerNotidicationIcon() {
		return reviewer_notification_icon;
	}

	@FindBy(xpath = "//span/ion-button[3]")
	private WebElement reviewer_reject_button;

	public WebElement reviewerRejectButton() {
		return reviewer_reject_button;
	}

	@FindBy(xpath = "//span/ion-button[1]")
	private WebElement reviewer_approve_button;

	public WebElement reviewerApproveButton() {
		return reviewer_approve_button;

	}

	@FindBy(xpath = "//span/ion-button[2]")
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

	@FindBy(xpath = "//textarea[@name='remarks']")
	private WebElement reviewer_alert_remarks;

	public WebElement reviewerAlertRemarks() {
		return reviewer_alert_remarks;
	}
       //@FindBy(xpath="//div[@id='toast-container']/div/div[@role='alertdialog']")
	
	
       // public WebElement approvalStatus()
	
        //{
	
           //    return approval_status;
	
        //}
	
        
	@FindBy(xpath = "//ion-button[contains(text(),'Submit')]")
	private WebElement reviewer_alert_submit_button;

	public WebElement reviewerAlertSubmitButton() {
		return reviewer_alert_submit_button;
	}
        @FindBy(xpath="//div[@id='toast-container']/div/div[@role='alertdialog']")
	
        private WebElement approval_status;
	
        public WebElement approvalStatus()
	
        {
	
                return approval_status;
	
        }
	
        
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[1]//ion-button")
	private WebElement reviewer_action_button;

	public WebElement reviewerActionButton() {
		return reviewer_action_button;

	}

	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[2]//span")
	private WebElement reviewer_reference_id;

	public WebElement reviewerReferenceID() {
		return reviewer_reference_id;

	}

	@FindBy(xpath="//div[@id='toast-container']/div/div[@role='alertdialog']")
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
       @FindBy(xpath = "//div[contains(text(),'Record REJECTED Successfully')]")
	private WebElement reviewer_reject_toast;

	public WebElement reviewer_reject_toast() {
		return reviewer_reject_toast;
	}
}