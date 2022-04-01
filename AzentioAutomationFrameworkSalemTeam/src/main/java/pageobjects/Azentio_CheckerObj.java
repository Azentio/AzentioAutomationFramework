package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Azentio_CheckerObj {

	WebDriver driver;

	public Azentio_CheckerObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ion-item[1]/ion-icon[@class='mr-2 md ion-color ion-color-dark hydrated']")
	private WebElement checker_security_management;

	public WebElement checkerSecurityManagement() {
		return checker_security_management;
	}

	@FindBy(xpath = "//ion-buttons[1]/ion-button[2]")
	private WebElement checker_eye_icon;

	public WebElement checkereyeIcon() {
		return checker_eye_icon;
	}

	@FindBy(xpath = "//ion-label[contains(text(),' Open pool ')]/parent::ion-item/ion-buttons/ion-button[1]")
	private WebElement checker_action_icon;

	public WebElement checkerActionIcon() {
		return checker_action_icon;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/inbox']")
	private WebElement checker_notification_icon;

	public WebElement checkerNotificationIcon() {
		return checker_notification_icon;
	}

	@FindBy(xpath = "//span/ion-button[3]")
	private WebElement checker_reject_button;

	public WebElement checkerRejectButton() {
		return checker_reject_button;
	}

	@FindBy(xpath = "//span/ion-button[1]")
	private WebElement checker_approve_button;

	public WebElement checkerApproveButton() {
		return checker_approve_button;

	}

	@FindBy(xpath = "//span/ion-button[2]")
	private WebElement checker_return_button;

	public WebElement checkerReturnButton() {
		return checker_return_button;
	}

	@FindBy(xpath = "//input[@name='budgetCode']")
	private WebElement checker_budget_code;

	public WebElement checkerGetBudgetCode() {
		return checker_budget_code;
	}

	@FindBy(xpath = "//ion-col[3]/app-kub-lov/span/ng-select/div/div/div[2]")
	private WebElement checker_budget_year;

	public WebElement checkerGetBudgetYear() {
		return checker_budget_year;
	}

	@FindBy(xpath = "//input[@name='warningPercentage']")
	private WebElement checker_warning_percentage;

	public WebElement checkerGetWarningPercentage() {
		return checker_warning_percentage;
	}

	@FindBy(xpath = "//input[@name='budgetName']")
	private WebElement checker_budget_name;

	public WebElement checkerGetBudgetName() {
		return checker_budget_name;
	}

	@FindBy(xpath = "//ion-col[8]/app-kub-lov/span/ng-select/div/div/div[2]")
	private WebElement checker_budget_status;

	public WebElement checkerGetBudgetStatus() {
		return checker_budget_status;
	}

	@FindBy(xpath = "//textarea[@name='remarks']")
	private WebElement checker_alert_remarks;

	public WebElement checkerRemarks() {
		return checker_alert_remarks;
	}

	@FindBy(xpath = "//ion-button[contains(text(),'Submit')]")
	private WebElement checker_alert_submit_button;

	public WebElement checkersubmitButton() {
		return checker_alert_submit_button;
	}
	@FindBy(xpath="//ion-col[3]//ng-select/div/div/div/span[2]")
	private WebElement budget_type;
	public WebElement budgetType()
	{
		return budget_type;
		
	}
	@FindBy(xpath="//div[@id='toast-container']//button")
	private WebElement alert_close;
	public WebElement checkerAlertClose()
	{
		return alert_close;
	}
        @FindBy(xpath = "//div[@id='toast-container']//button")
	private WebElement checker_alert_close;

	public WebElement checker_alert_close() {
		return checker_alert_close;
	}
	@FindBy(xpath="//div[@id='toast-container']/div/div[@role='alertdialog']")
	private WebElement checker_approval_status;
	public WebElement checkerApprovalStatus()
	{
		return checker_approval_status;
	}
        //TOTAST - CONTAINER
	@FindBy(xpath="//div[@id='toast-container']/div/div[@role='alertdialog']")
	private WebElement Popup_status;
	public WebElement Popup_status()
	{
		return Popup_status;
	}
@FindBy(xpath = "//div[@id='toast-container']//button")
	private WebElement checkerAlertClose;

	/*public WebElement checkerAlertClose() {
		return checkerAlertClose;
	}*/

	@FindBy(xpath = "//datatable-pager[1]/ul[1]/li[8]/a[1]/i[1]")
	private WebElement checker_notification_next_button;

	public WebElement checker_notification_next_button() {
		return checker_notification_next_button;
	}

	@FindBy(xpath = "//div[@id='toast-container']/div/div[@role='alertdialog']")
	private WebElement checker_right_corner_green_toast;

	public WebElement checker_right_corner_green_toast() {
		return checker_right_corner_green_toast;
	}

	@FindBy(xpath = "//div[@aria-label='Record REJECTED Successfully']")
	private WebElement checker_right_corner_reject_toast;

	public WebElement checker_right_corner_reject_toast() {
		return checker_right_corner_reject_toast;
	}

}