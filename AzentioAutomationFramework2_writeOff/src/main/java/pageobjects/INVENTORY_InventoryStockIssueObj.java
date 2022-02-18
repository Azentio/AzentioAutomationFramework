package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class INVENTORY_InventoryStockIssueObj {
	WebDriver driver;

	public INVENTORY_InventoryStockIssueObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ion-fab-button[@id='addBtn']")
	private WebElement inventory_inventroy_stock_add;

	public WebElement inventoryStcokIssueAddButton() {
		return inventory_inventroy_stock_add;

	}

	@FindBy(xpath = "//ion-col[1]//input")
	private WebElement inventory_inventory_item;

	public WebElement inventoryInventoryItem() {
		return inventory_inventory_item;

	}

	@FindBy(xpath = "//ion-col[3]//input")
	private WebElement inventory_inventory_branch_code;

	public WebElement inventoryBranchCode() {
		return inventory_inventory_branch_code;
	}

	@FindBy(xpath = "//ion-col[5]//input")
	private WebElement request_reference_number;

	public WebElement requestReferenceNumber() {
		return request_reference_number;
	}
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/11']")
	private WebElement inventory_stock_issue_eye_icon;
	public WebElement inventoryStockIssueEyeIcon()
	{
		return inventory_stock_issue_eye_icon;
	}
	@FindBy(xpath="//app-inbox//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[2]//span")
	private WebElement inventory_stock_issue_first_reference_id;
	public WebElement inventoryStockIssueFirstReferenceId()
	{
		return inventory_stock_issue_first_reference_id;
		
	}
	@FindBy(xpath="//app-inbox//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[1]//ion-button")
	private WebElement inventory_stock_issue_first_record;
	public WebElement inventoryStockIssueFirstRecord()
	{
		return inventory_stock_issue_first_record;
		
	}
	@FindBy(xpath="(//ion-toolbar[1]/ion-buttons[2]/ion-button[1])[2]")
	private WebElement inventory_stock_issue_save_button;
	public WebElement inventoryStockIssueSaveButton()
	{
		return inventory_stock_issue_save_button;
	}
	@FindBy(xpath="//ion-textarea/div/textarea[@name='remarks']")
	private WebElement inventory_stock_issue_alert_remarks;
	public WebElement inventoryStockIssueAlertRemarks()
	{
		return inventory_stock_issue_alert_remarks;
	}
	@FindBy(xpath="//span[contains(text(),'Submit')]")
	private WebElement inventory_stock_issue_submit_button;
	public WebElement inventoryStockIssueSubmitButton()
	{
		return inventory_stock_issue_submit_button;
	}
	@FindBy(xpath="//ion-header/ion-toolbar[1]/ion-buttons[2]/ion-button[4]")
    private WebElement inventory_stock_issue_user_name;
    public WebElement inventoryStockIssueUserName()
    {
    	return inventory_stock_issue_user_name;
    }
    @FindBy(xpath="//ion-label[contains(text(),'Logout')]")
    private WebElement inventorystock_issue_logout_button;
    public WebElement inventoryStockIssueLogoutButton()
    {
		return inventorystock_issue_logout_button;
    	
    }
    @FindBy(xpath="//div[@id='toast-container']//button")
	private WebElement inventory_stock_issue_alert_close;
	public WebElement inventoryStockIssueAlertClose()
	{
		return inventory_stock_issue_alert_close;
	}
	@FindBy(xpath="//ion-toolbar[1]/ion-buttons[2]/ion-button[2]")
	private WebElement inventory_stock_issue_notification_icon;
	public WebElement inventoryStockIssueNotificationIcon()
	{
		return inventory_stock_issue_notification_icon;
	}
	@FindBy(xpath="//ion-button[contains(text(),'Submit')]")
	private WebElement inventory_stock_issue_alert_submit_button;
	public WebElement inventoryStockIssueAlertSubmitButton()
	{
		return inventory_stock_issue_alert_submit_button;
	}
	@FindBy(xpath="//div[@id='toast-container']/div/div[@role='alertdialog']")
	private WebElement inventory_stock_issue_reviewer_id;
	public WebElement inventoryStockIssueReviewerID()
	{
		return inventory_stock_issue_reviewer_id;
	}

}
