package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class INVENTORY_StockConfirmationObj {
	WebDriver driver;
	public INVENTORY_StockConfirmationObj(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//ion-select[@class='datagrid-lov ng-valid md hydrated ng-touched ng-dirty ion-valid ion-touched ion-dirty']")
	private WebElement inventory_FinanceOption;

	public WebElement inventoryFinanceOption() {

		return inventory_FinanceOption;
	}

	@FindBy(xpath = "//ion-segment/ion-segment-button[2]")
	private WebElement inventory_Transfericon;

	public WebElement inventoryTransfericon() {

		return inventory_Transfericon;
	}
	
	@FindBy(xpath = "//div[@id='toast-container']/div/div[@role='alertdialog']") 
	private WebElement inventory_Popup;

	public WebElement inventory_Popup() {

		return inventory_Popup;
	}
	
	@FindBy(xpath = "//ion-label[contains(text(),'Inventory management')]")
	private WebElement inventory_Management;

	public WebElement inventoryManagement() {

		return inventory_Management;
	}
	
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/11']")
	private WebElement inventory_StockissueEye;

	public WebElement inventory_StockissueEye() {

		return inventory_StockissueEye;
	}
	
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row[1]//ion-button[1]")
	private WebElement inventory_StockissueGridEye;

	public WebElement inventory_StockissueGridEye() {

		return inventory_StockissueGridEye;
	}
	
	@FindBy(xpath = "//ion-col[5]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]")
	private WebElement inventory_StockissueRefNo;

	public WebElement inventory_StockissueRefNo() {

		return inventory_StockissueRefNo;
	}
	
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/4']")
	private WebElement inventory_StockConfirmEye;

	public WebElement inventory_StockConfirmEye() {

		return inventory_StockConfirmEye;
	}
	
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid/3']")
	private WebElement inventory_StockConfirmEdit;

	public WebElement inventoryStockConfirmEdit() {

		return inventory_StockConfirmEdit;
	}
	
	@FindBy(xpath = "//ion-fab/ion-fab-button[@id='addBtn']")
	private WebElement inventory_StockConfirmAdd;

	public WebElement inventoryStockConfirmAdd() {

		return inventory_StockConfirmAdd;
	}

	@FindBy(xpath = "//ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement inventory_RequestReferanceNumber;

	public WebElement StockConfirm_RequestReferanceNumber() {

		return inventory_RequestReferanceNumber;
	}

	@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement inventory_ItemCode;

	public WebElement StockConfirm_ItemCode() {

		return inventory_ItemCode;
	}
	
	@FindBy(xpath = "//ion-input/input[@name='ifcIssueRefNo']")
	private WebElement inventory_IssueReferanceNo;

	public WebElement StockConfirm_IssueReferanceNo() {

		return inventory_IssueReferanceNo;
	}
	
	@FindBy(xpath = "//input[@name='ion-input-1085']") 
	private WebElement inventory_ItemDescrption;

	public WebElement StockConfirm_ItemDescrption() {

		return inventory_ItemDescrption;
	}
	
	@FindBy(xpath = "//input[@name='ifcIssuedQuantity']") 
	private WebElement inventory_IssueQuantity;

	public WebElement StockConfirm_IssueQuantity() {

		return inventory_IssueQuantity;
	}
	
	@FindBy(xpath = "//input[@name='ifcStartSerialNumber']") 
	private WebElement inventory_Start_Serial_No;

	public WebElement StockConfirm_StartSerialNo() {

		return inventory_Start_Serial_No;
	}
	
	@FindBy(xpath = "//input[@name='ifcEndSerialNumber']") 
	private WebElement inventory_End_Serial_No;

	public WebElement StockConfirm_EndSerialNo() {

		return inventory_End_Serial_No;
	}
	
	@FindBy(xpath = "//ion-checkbox[@name='ifcAcceptStatus']") 
	private WebElement inventory_AcceptCheckBox;

	public WebElement StockConfirm_AcceptCheckBox() {

		return inventory_AcceptCheckBox;
	}
	
	@FindBy(xpath = "//div[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1]") 
	private WebElement inventory_Save;

	public WebElement StockConfirm_Save() {

		return inventory_Save;
	}
	
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/inbox']") 
	private WebElement inventory_MakerNotification;

	public WebElement StockConfirm_MakerNotification() {

		return inventory_MakerNotification;
	}
	
	@FindBy(xpath = "//app-inbox//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[2]//span") 
	private WebElement inventory_ReferanceId;

	public WebElement StockConfirm_ReferanceId() {

		return inventory_ReferanceId;
	}
	
	@FindBy(xpath = "//app-inbox//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[1]//ion-button") 
	private WebElement inventory_ActionButton;

	public WebElement StockConfirm_ActionButton() {

		return inventory_ActionButton;
	}
	
	@FindBy(xpath = "//span[contains(text(),'Submit')]") 
	private WebElement inventory_Submit;

	public WebElement StockConfirm_Submit() {

		return inventory_Submit;
	}
	
	@FindBy(xpath = "(//ion-textarea[@name='remarks'])[2]") 
	private WebElement inventory_Remark;

	public WebElement StockConfirm_Remark() {

		return inventory_Remark;
	}
	
	@FindBy(xpath = "//ion-button[contains(text(),'Submit')]") 
	private WebElement inventory_RemarkSubmit;

	public WebElement StockConfirm_RemarkSubmit() {

		return inventory_RemarkSubmit;
	}
	
	@FindBy(xpath = "//div[@id='toast-container']/div/div[@role='alertdialog']") 
	private WebElement inventory_ReviewerId;

	public WebElement StockConfirm_ReviewerId() {

		return inventory_ReviewerId;
	}
	
	@FindBy(xpath = "//button[@aria-label='Close']") 
	private WebElement inventory_Notification_Close;

	public WebElement StockConfirm_Notification_Close() {

		return inventory_Notification_Close;
	}
	
	
	
	
	
	
	
	
	
	
}
