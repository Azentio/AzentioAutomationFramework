package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ar_Po_creationObj {
	WebDriver driver;

	public Ar_Po_creationObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//ion-segment/ion-segment-button[2]")
	private WebElement accountsPayable_VendorPurchaseOrder_DirectionIcon;
	public WebElement accountsPayable_VendorPurchaseOrder_DirectionIcon() {
		return accountsPayable_VendorPurchaseOrder_DirectionIcon;
	}
	@FindBy(xpath = "//ion-label[text()=' Accounts payable ']")
	private WebElement accountsPayable_VendorPurchaseOrder_AccountsPayableField;
	public WebElement accountsPayable_VendorPurchaseOrder_AccountsPayableField() {
		return accountsPayable_VendorPurchaseOrder_AccountsPayableField;
	}
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/134']")
	private WebElement accountsPayable_VendorPurchaseOrder_EyeButton;

	public WebElement accountsPayable_VendorPurchaseOrder_EyeButton() {
		return accountsPayable_VendorPurchaseOrder_EyeButton;

	}
	@FindBy(xpath = "//ion-fab-button[@id='addBtn']")
	private WebElement accountsPayable_VendorPurchaseOrder_AddButton;
	public WebElement accountsPayable_VendorPurchaseOrder_AddButton() {
		return accountsPayable_VendorPurchaseOrder_AddButton;

	}
	//Select Entity Branch
		@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[3]/input")
		private WebElement accountsPayable_VendorPurchaseOrder_EntityBranch;
		public WebElement accountsPayable_VendorPurchaseOrder_EntityBranch() {
			return accountsPayable_VendorPurchaseOrder_EntityBranch;
		}
		//Select BP Name
		@FindBy(xpath = "//ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
		private WebElement accountsPayable_VendorPurchaseOrder_BPName;
		public WebElement accountsPayable_VendorPurchaseOrder_BPName() {
			return accountsPayable_VendorPurchaseOrder_BPName;
		}
		//Select Reference Type
		@FindBy(xpath = "//ion-col[4]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
		private WebElement accountsPayable_VendorPurchaseOrder_ReferenceType;
		public WebElement accountsPayable_VendorPurchaseOrder_ReferenceType() {
			return accountsPayable_VendorPurchaseOrder_ReferenceType;
		}
		//Select Contract
		@FindBy(xpath = "(//ion-col[5]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2])[1]/input")
		private WebElement accountsPayable_VendorPurchaseOrder_Contract;
		public WebElement accountsPayable_VendorPurchaseOrder_Contract() {
			return accountsPayable_VendorPurchaseOrder_Contract;
		}
		//Select CheckBox PO ITEM
		@FindBy(xpath = "//ion-checkbox[@id='rowIndex']")
		private WebElement accountsPayable_VendorPurchaseOrder_CheckBoxPoItem;
		public WebElement accountsPayable_VendorPurchaseOrder_CheckBoxPoItem() {
			return accountsPayable_VendorPurchaseOrder_CheckBoxPoItem;
		}
		//Enter  PO Quantity
		@FindBy(xpath = "//datatable-body-cell/div[1]/input")
		private WebElement accountsPayable_VendorPurchaseOrder_PoQuantity;
		public WebElement accountsPayable_VendorPurchaseOrder_PoQuantity() {
			return accountsPayable_VendorPurchaseOrder_PoQuantity;
		}
	

}
