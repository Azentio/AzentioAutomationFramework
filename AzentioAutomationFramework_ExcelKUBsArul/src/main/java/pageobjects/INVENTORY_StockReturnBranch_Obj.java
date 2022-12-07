package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class INVENTORY_StockReturnBranch_Obj {

	WebDriver driver;

	public INVENTORY_StockReturnBranch_Obj(WebDriver driver) {
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

	@FindBy(xpath = "//ion-label[contains(text(),'Inventory management')]")
	private WebElement inventory_Management;

	public WebElement inventoryManagement() {

		return inventory_Management;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/12']")
	private WebElement inventory_StockReturnBranchEye;

	public WebElement inventoryStockReturnBranchEye() {

		return inventory_StockReturnBranchEye;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid/9']")
	private WebElement inventory_StockReturnBranchEdit;

	public WebElement inventoryStockReturnBranchEdit() {

		return inventory_StockReturnBranchEdit;
	}

	@FindBy(xpath = "//ion-fab/ion-fab-button[@id='addBtn']")
	private WebElement inventory_StockReturnBranchAdd;

	public WebElement inventoryStockReturnBranchAdd() {

		return inventory_StockReturnBranchAdd;
	}

	@FindBy(xpath = "//ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement inventory_RequestReferanceNumber;

	public WebElement inventoryRequestReferanceNumber() {

		return inventory_RequestReferanceNumber;
	}

	@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement inventory_IssueReferanceNo;

	public WebElement inventoryIssueReferanceNo() {

		return inventory_IssueReferanceNo;
	}

	@FindBy(xpath = "//ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement inventory_ItemCode;

	public WebElement inventoryItemCode() {

		return inventory_ItemCode;
	}
	
	@FindBy(xpath = "//input[@name='ion-input-37']") 
	private WebElement inventory_ItemDescrption;

	public WebElement inventoryItemDescrption() {

		return inventory_ItemDescrption;
	}

	@FindBy(xpath = "//input[@name='ifrReturnQty']")
	private WebElement inventory_ReturnQuantity;

	public WebElement inventoryReturnQuantity() {

		return inventory_ReturnQuantity;
	}
	
	@FindBy(xpath = "//input[@name='ifrStartSerialNumber']") 
	private WebElement inventory_Start_Serial_No;

	public WebElement inventoryStart_Serial_No() {

		return inventory_Start_Serial_No;
	}
	
	@FindBy(xpath = "//input[@name='ifrEndSerialNumber']") 
	private WebElement inventory_End_Serial_No;

	public WebElement inventoryEnd_Serial_No() {

		return inventory_End_Serial_No;
	}
	
	@FindBy(xpath = "//input[@name='ifrInventoryBranchId']") 
	private WebElement inventory_InventoryBranchId;

	public WebElement inventory_InventoryBranchId() {

		return inventory_InventoryBranchId;
	}
	
	@FindBy(xpath = "//input[@name='ifrInventoryBranchName']") 
	private WebElement inventory_InventoryBranchName;

	public WebElement inventory_InventoryBranchName() {

		return inventory_InventoryBranchName;
	}
	
	@FindBy(xpath = "//ion-col[10]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input") 
	private WebElement inventory_ReturnType;

	public WebElement inventory_ReturnType() {

		return inventory_ReturnType;
	}
	
	@FindBy(xpath = "//ion-col[11]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input") 
	private WebElement inventory_ReturnReason;

	public WebElement inventory_ReturnReason() {

		return inventory_ReturnReason;
	}
	
	@FindBy(xpath = "//div[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1]") 
	private WebElement inventory_Save;

	public WebElement inventory_Save() {

		return inventory_Save;
	}
	
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/inbox']") 
	private WebElement inventory_MakerNotification;

	public WebElement inventory_MakerNotification() {

		return inventory_MakerNotification;
	}
	
	@FindBy(xpath = "//app-inbox//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[2]//span") 
	private WebElement inventory_ReferanceId;

	public WebElement inventory_ReferanceId() {

		return inventory_ReferanceId;
	}
	
	@FindBy(xpath = "//app-inbox//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[1]//ion-button") 
	private WebElement inventory_ActionButton;

	public WebElement inventory_ActionButton() {

		return inventory_ActionButton;
	}
	
	@FindBy(xpath = "//span[contains(text(),'Submit')]") 
	private WebElement inventory_Submit;

	public WebElement inventory_Submit() {

		return inventory_Submit;
	}
	
	@FindBy(xpath = "//textarea[@name='remarks']") 
	private WebElement inventory_Remark;

	public WebElement inventory_Remark() {

		return inventory_Remark;
	}
	
	@FindBy(xpath = "//ion-button[contains(text(),'Submit')]") 
	private WebElement inventory_RemarkSubmit;

	public WebElement inventory_RemarkSubmit() {

		return inventory_RemarkSubmit;
	}
	
	//Reviewer
	@FindBy(xpath = "//div[@id='toast-container']/div/div[@role='alertdialog']") 
	private WebElement inventory_Revieweralert;

	public WebElement inventory_Revieweralert() {

		return inventory_Revieweralert;
	}
	
	@FindBy(xpath = "//div[@id='toast-container']/div/div[@role='alertdialog']") 
	private WebElement inventory_ReviewerId;

	public WebElement inventory_ReviewerId() {

		return inventory_ReviewerId;
	}
	
	@FindBy(xpath = "//ion-button/ion-icon[@name='person-circle']") 
	private WebElement inventory_MakerLogo;

	public WebElement inventory_MakerLogo() {

		return inventory_MakerLogo;
	}
	
	@FindBy(xpath = "//ion-content[1]/div[1]/ion-list[1]/ion-item[3]/ion-icon[1]") 
	private WebElement inventory_MakerLogout;

	public WebElement inventory_MakerLogout() {

		return inventory_MakerLogout;
	}
	
	//Inventory Maintance
	@FindBy(xpath = "//ion-label[contains(text(),'Inventory maintenance')]") 
	private WebElement inventory_InventoryMaintenance;

	public WebElement inventory_InventoryMaintenance() {

		return inventory_InventoryMaintenance;
	}
	
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/187']") 
	private WebElement inventory_MasterItemEye;

	public WebElement inventory_MasterItemEye() {

		return inventory_MasterItemEye;
	}
	
	@FindBy(xpath = "//ion-icon[@ng-reflect-name='search']") 
	private WebElement inventory_SearchIcon;

	public WebElement inventory_SearchIcon() {

		return inventory_SearchIcon;
	}
	
	@FindBy(xpath = "//input[@name='col6']") 
	private WebElement inventory_Itemvalue;

	public WebElement inventory_Itemvalue() {

		return inventory_Itemvalue;
	}
	
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row[1]//ion-button[2]") 
	private WebElement inventory_PencilIcon;

	public WebElement inventory_PencilIcon() {

		return inventory_PencilIcon;
	}
	
	@FindBy(xpath = "//input[@name='currentBalanceQuantity']") 
	private WebElement inventory_CurrentQuantity;

	public WebElement inventory_CurrentQuantity() {

		return inventory_CurrentQuantity;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
