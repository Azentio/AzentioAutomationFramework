package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class INVENTORY_MAINTENANCE_DenominationMasterObj {
	WebDriver driver;

	public INVENTORY_MAINTENANCE_DenominationMasterObj(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Inventory Maintenance Menu
	@FindBy(xpath = "//ion-label[text()=' Inventory maintenance ']")
	private WebElement  inventoryMaintenanceMenu;
	
	public WebElement inventoryMaintenanceMenu() {
		return inventoryMaintenanceMenu;
	}

	//eye button of Denomination Master
	@FindBy(xpath = "//div[7]//ion-menu-toggle[2]//ion-item//ion-buttons//ion-button[2]")
	private WebElement inventoryMaintnenance_DenominationMaster_EyeButton;

	public WebElement inventoryMaintnenance_DenominationMaster_EyeButton() {
		return inventoryMaintnenance_DenominationMaster_EyeButton;
	}

	// add button Denomination Master
	@FindBy(xpath = "//ion-fab-button[@id='addBtn']")
	private WebElement inventoryMaintnenance_DenominationMaster_AddButton;

	public WebElement inventoryMaintnenance_DenominationMaster_AddButton() {
		return inventoryMaintnenance_DenominationMaster_AddButton;
	}
	
	// Instrument code
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[1]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement inventoryMaintnenance_DenominationMaster_InstrumentCode;
	
	public WebElement inventoryMaintnenance_DenominationMaster_InstrumentCode() {
		return inventoryMaintnenance_DenominationMaster_InstrumentCode;
	}
	
	// Currency
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[2]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement inventoryMaintnenance_DenominationMaster_Currency;
	
	public WebElement inventoryMaintnenance_DenominationMaster_Currency() {
		return inventoryMaintnenance_DenominationMaster_Currency;
	}
	
	// Denomination Type
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[3]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement inventoryMaintnenance_DenominationMaster_DenominationType;
	
	public WebElement inventoryMaintnenance_DenominationMaster_DenominationType() {
		return inventoryMaintnenance_DenominationMaster_DenominationType;
	}
	
	// Denomination Sub Type
	@FindBy(xpath = "//app-kub-lov/ion-select")
	private WebElement inventoryMaintnenance_DenominationMaster_DenominationSubType;
	
	public WebElement inventoryMaintnenance_DenominationMaster_DenominationSubType() {
		return inventoryMaintnenance_DenominationMaster_DenominationSubType;
	}
	
	// Denomination Sub Type switch to coin
	@FindBy(xpath = "//ion-item[2]/ion-radio")
	private WebElement inventoryMaintnenance_DenominationMaster_DenominationSubTypeCoin;
	
	public WebElement inventoryMaintnenance_DenominationMaster_DenominationSubTypeCoin() {
		return inventoryMaintnenance_DenominationMaster_DenominationSubTypeCoin;
	}
	
	// Denomination Sequence
	@FindBy(xpath = "//datatable-body-cell[2]/div/input")
	private WebElement inventoryMaintnenance_DenominationMaster_DenominationSequence;
	
	public WebElement inventoryMaintnenance_DenominationMaster_DenominationSequence() {
		return inventoryMaintnenance_DenominationMaster_DenominationSequence;
	}
	
	// Denomination Value
	@FindBy(xpath = "//datatable-body-cell[3]/div/input")
	private WebElement inventoryMaintnenance_DenominationMaster_DenominationValue;
	
	public WebElement inventoryMaintnenance_DenominationMaster_DenominationValue() {
		return inventoryMaintnenance_DenominationMaster_DenominationValue;
	}
	
	// Denomination Description
	@FindBy(xpath = "//datatable-body-cell[4]/div/input")
	private WebElement inventoryMaintnenance_DenominationMaster_DenominationDescription;
	
	public WebElement inventoryMaintnenance_DenominationMaster_DenominationDescription() {
		return inventoryMaintnenance_DenominationMaster_DenominationDescription;
	}
	
	// Action Button
	@FindBy(xpath = "//datatable-body-cell/div/ion-button")
	private WebElement inventoryMaintnenance_DenominationMaster_ActionButton;
	
	public WebElement inventoryMaintnenance_DenominationMaster_ActionButton() {
		return inventoryMaintnenance_DenominationMaster_ActionButton;
	}
	
	// Save Button
	@FindBy(xpath = "//page-mst-denomination-hdr-update/ion-header/ion-toolbar/ion-buttons[2]/ion-button")
	private WebElement inventoryMaintnenance_DenominationMaster_SaveButton;
	
	public WebElement inventoryMaintnenance_DenominationMaster_SaveButton() {
		return inventoryMaintnenance_DenominationMaster_SaveButton;
	}

	@FindBy(xpath = "//ion-buttons[2]//ion-button[4]")
	private WebElement inventoryMaintenance_profilename;

	public WebElement inventoryMaintenance_profilename() {
		return inventoryMaintenance_profilename;
	}

	@FindBy(xpath = "//ion-icon[@name='log-out']")
	private WebElement inventoryMaintenance_Logout;

	public WebElement inventoryMaintenance_Logout() {
		return inventoryMaintenance_Logout;
	}
	
	
	
	
	
	
}
