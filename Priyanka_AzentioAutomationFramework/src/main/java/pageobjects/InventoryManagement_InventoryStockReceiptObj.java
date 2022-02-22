package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryManagement_InventoryStockReceiptObj {
	WebDriver driver;

	public InventoryManagement_InventoryStockReceiptObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//ion-label[text()=' Inventory management ']")
	private WebElement inventoryManagement_InventoryStockReceipt_InventoryManagementField;
	public WebElement inventoryManagement_InventoryStockReceipt_InventoryManagementField() {
		return inventoryManagement_InventoryStockReceipt_InventoryManagementField;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/6']")
	private WebElement inventoryManagement_InventoryStockReceipt_EyeButton;

	public WebElement inventoryManagement_InventoryStockReceipt_EyeButton() {
		return inventoryManagement_InventoryStockReceipt_EyeButton;

	}

	@FindBy(xpath = "//ion-fab-button[@id='addBtn']")
	private WebElement inventoryManagement_InventoryStockReceipt_AddButton;
	public WebElement inventoryManagement_InventoryStockReceipt_AddButton() {
		return inventoryManagement_InventoryStockReceipt_AddButton;

	}
	//GRN Number
	@FindBy(xpath = "//ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement inventoryManagement_InventoryStockReceipt_GRNNumber;
	public WebElement inventoryManagement_InventoryStockReceipt_GRNNumber() {
		return inventoryManagement_InventoryStockReceipt_GRNNumber;

	}
	
	//Accepted Quantity
	@FindBy(xpath = "//datatable-body-row[1]/div[2]/datatable-body-cell[8]/div[1]/input")
	private WebElement inventoryManagement_InventoryStockReceipt_AcceptedQuantity;
	public WebElement inventoryManagement_InventoryStockReceipt_AcceptedQuantity() {
		return inventoryManagement_InventoryStockReceipt_AcceptedQuantity;

	}
	//Save
	@FindBy(xpath = "(//ion-toolbar[1]/ion-buttons[2]/ion-button[1])[2]")	
	private WebElement inventoryManagement_InventoryStockReceipt_Save;
	public WebElement inventoryManagement_InventoryStockReceipt_Save() {
		return inventoryManagement_InventoryStockReceipt_Save;
		
	}
			
	//Notification
	@FindBy(xpath = "//ion-header/ion-toolbar[1]/ion-buttons[2]/ion-button[2]")	
	private WebElement inventoryManagement_InventoryStockReceipt_MakerNotification;
	public WebElement inventoryManagement_InventoryStockReceipt_MakerNotification() {
		 return inventoryManagement_InventoryStockReceipt_MakerNotification;
	}
	
	
}
