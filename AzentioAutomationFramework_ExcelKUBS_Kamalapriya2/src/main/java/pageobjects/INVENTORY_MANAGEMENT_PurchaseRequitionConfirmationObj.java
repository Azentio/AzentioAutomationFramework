package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class INVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj {
	WebDriver driver;

	public INVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Inventory Management Menu
	@FindBy(xpath = "//ion-label[text()=' Inventory management ']")
	private WebElement  inventoryManagementMenu;
	
	public WebElement inventoryManagementMenu() {
		return inventoryManagementMenu;
	}
	
	//eye button of Purchase requisition confirmation
	@FindBy(xpath = "//div[7]//ion-menu-toggle[2]//ion-item//ion-buttons//ion-button[2]")
	private WebElement  inventoryManagement_PurchaseRequisitionConfirmation_EyeButton;

	public WebElement inventoryManagement_PurchaseRequisitionConfirmation_EyeButton() {
		return inventoryManagement_PurchaseRequisitionConfirmation_EyeButton;
	}
	
	//add button of Purchase requisition confirmation
	@FindBy(xpath = "//ion-fab-button[@id='addBtn']")
	private WebElement  inventoryManagement_PurchaseRequisitionConfirmation_AddButton;
	
	public WebElement inventoryManagement_PurchaseRequisitionConfirmation_AddButton() {
		return inventoryManagement_PurchaseRequisitionConfirmation_AddButton;
	}
	
	//item code
	@FindBy(xpath = "//ion-col[2]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement  inventoryManagement_PurchaseRequisitionConfirmation_ItemCode;
	
	public WebElement inventoryManagement_PurchaseRequisitionConfirmation_ItemCode() {
		return inventoryManagement_PurchaseRequisitionConfirmation_ItemCode;
	}
	
	//Save Button
	@FindBy(xpath = "//page-purchase-requisition-confirmation-update/ion-header/ion-toolbar/ion-buttons[2]/ion-button")
	private WebElement  inventoryManagement_PurchaseRequisitionConfirmation_SaveButton;
	
	public WebElement inventoryManagement_PurchaseRequisitionConfirmation_SaveButton() {
		return inventoryManagement_PurchaseRequisitionConfirmation_SaveButton;
	}
	
	//Action Button
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[6]/div/ion-button")
	private WebElement  inventoryManagement_PurchaseRequisitionConfirmation_ActionButton;
	
	public WebElement inventoryManagement_PurchaseRequisitionConfirmation_ActionButton() {
		return inventoryManagement_PurchaseRequisitionConfirmation_ActionButton;
	}
	
	//Notification Button
	@FindBy(xpath = "//ion-buttons[2]/ion-button[2]")
	private WebElement  inventoryManagement_PurchaseRequisitionConfirmation_NotificationButton;
	
	public WebElement inventoryManagement_PurchaseRequisitionConfirmation_NotificationButton() {
		return inventoryManagement_PurchaseRequisitionConfirmation_NotificationButton;
	}

}
