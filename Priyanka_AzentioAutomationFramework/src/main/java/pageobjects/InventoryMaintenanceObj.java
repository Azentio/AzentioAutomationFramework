package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryMaintenanceObj {
	WebDriver driver;

	public InventoryMaintenanceObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath = "//ion-segment/ion-segment-button[1]")
	private WebElement inventoryMaintenance_InventoryMaintenanceDirectionLeft;
	public WebElement inventoryMaintenance_InventoryMaintenanceDirectionLeft() {
		return inventoryMaintenance_InventoryMaintenanceDirectionLeft;
	}
	
	
	@FindBy(xpath = "//ion-label[text()=' Inventory maintenance ']")
	private WebElement inventoryMaintenance_InventoryMaintenanceField;
	public WebElement inventoryMaintenance_InventoryMaintenanceField() {
		return inventoryMaintenance_InventoryMaintenanceField;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/187']")
	private WebElement inventoryMaintenance_InventoryItem_EyeButton;

	public WebElement inventoryMaintenance_InventoryItem_EyeButton() {
		return inventoryMaintenance_InventoryItem_EyeButton;

	}

	@FindBy(xpath = "//ion-fab-button[@id='addBtn']")
	private WebElement inventoryMaintenance_AddButton;
	public WebElement inventoryMaintenance_AddButton() {
		return inventoryMaintenance_AddButton;

	}
	
	//Select Branch code
	@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement  inventoryMaintenance_InventoryItem_BranchCode;
	public WebElement inventoryMaintenance_InventoryItem_BranchCode() {
		return inventoryMaintenance_InventoryItem_BranchCode;
	}
	
	//Select Item code
	@FindBy(xpath = "//ion-col[3]/ion-item[1]/ion-input[1]/input")
	private WebElement  inventoryMaintenance_InventoryItem_ItemCode;
	public WebElement inventoryMaintenance_InventoryItem_ItemCode() {
		return inventoryMaintenance_InventoryItem_ItemCode;
	}
	
	//Select Item Description
	@FindBy(xpath = "//ion-col[4]/ion-item[1]/ion-input[1]/input")
	private WebElement  inventoryMaintenance_InventoryItem_ItemDescription;
	public WebElement inventoryMaintenance_InventoryItem_ItemDescription() {
		return inventoryMaintenance_InventoryItem_ItemDescription;
	}
	
	//Select Item Short Description
	@FindBy(xpath = "//ion-col[6]/ion-item[1]/ion-input[1]/input")
	private WebElement  inventoryMaintenance_InventoryItem_ItemShortDescription;
	public WebElement inventoryMaintenance_InventoryItem_ItemShortDescription() {
		return inventoryMaintenance_InventoryItem_ItemShortDescription;
	}
	//Select Instrument code
	@FindBy(xpath = "//ion-col[8]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement  inventoryMaintenance_InventoryItem_InstrumentCode;
	public WebElement inventoryMaintenance_InventoryItem_InstrumentCode() {
			return inventoryMaintenance_InventoryItem_InstrumentCode;
	}
	
	//Select Instrument  Description
	@FindBy(xpath = "//ion-col[9]/app-kub-display-field[1]/ion-item[1]/ion-input[1]/input")
	private WebElement  inventoryMaintenance_InventoryItem_InstrumentDescription;
	public WebElement inventoryMaintenance_InventoryItem_InstrumentDescription() {
			return inventoryMaintenance_InventoryItem_InstrumentDescription;
	}
	
	//Select Currency Code
	@FindBy(xpath = "//ion-col[10]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement  inventoryMaintenance_InventoryItem_CurrencyCode;
	public WebElement inventoryMaintenance_InventoryItem_CurrencyCode() {
			return inventoryMaintenance_InventoryItem_CurrencyCode;
	}
	
	//Select Reorder Level
	@FindBy(xpath = "//ion-col[11]/ion-item[1]/ion-input[1]/input")
	private WebElement  inventoryMaintenance_InventoryItem_ReorderLevel;
	public WebElement inventoryMaintenance_InventoryItem_ReorderLevel() {
			return inventoryMaintenance_InventoryItem_ReorderLevel;
	}
	
	//Select Excess Level
	@FindBy(xpath = "//ion-col[12]/ion-item[1]/ion-input[1]/input")
	private WebElement  inventoryMaintenance_InventoryItem_ExcessLevel;
	public WebElement inventoryMaintenance_InventoryItem_ExcessLevel() {
			return inventoryMaintenance_InventoryItem_ExcessLevel;
	}
	
	//Select Reorder Qty
	@FindBy(xpath = "//ion-col[13]/ion-item[1]/ion-input[1]/input")
	private WebElement  inventoryMaintenance_InventoryItem_ReorderQty;
	public WebElement inventoryMaintenance_InventoryItem_ReorderQty() {
			return inventoryMaintenance_InventoryItem_ReorderQty;
	}
	//Select Current Balance Quantity
	@FindBy(xpath = "//ion-col[14]/ion-item[1]/ion-input[1]/input")
	private WebElement  inventoryMaintenance_InventoryItem_CurrentBalanceQuantity;
	public WebElement inventoryMaintenance_InventoryItem_CurrentBalanceQuantity() {
			return inventoryMaintenance_InventoryItem_CurrentBalanceQuantity;
	}
	
	//Select Qc Required
	@FindBy(xpath = "//ion-col[15]/ion-item[1]/ion-checkbox[1]")
	private WebElement  inventoryMaintenance_InventoryItem_QcRequired;
	public WebElement inventoryMaintenance_InventoryItem_QcRequired() {
			return inventoryMaintenance_InventoryItem_QcRequired;
	}
	
	//Select Fill Indicator
	@FindBy(xpath = "//ion-col[16]/ion-item[1]/ion-checkbox[1]")
	private WebElement  inventoryMaintenance_InventoryItem_FillIndicator;
	public WebElement inventoryMaintenance_InventoryItem_FillIndicator() {
			return inventoryMaintenance_InventoryItem_FillIndicator;
	}
	//Save
		@FindBy(xpath = "(//ion-toolbar[1]/ion-buttons[2]/ion-button[1])[2]")	
		private WebElement inventoryMaintenance_InventoryItem_Save;
		public WebElement inventoryMaintenance_InventoryItem_Save() {
				return inventoryMaintenance_InventoryItem_Save;
		}
		
		//Notification
		@FindBy(xpath = "//ion-header/ion-toolbar[1]/ion-buttons[2]/ion-button[2]")	
		private WebElement inventoryMaintenance_InventoryItem_MakerNotification;
		public WebElement inventoryMaintenance_InventoryItem_MakerNotification() {
				return inventoryMaintenance_InventoryItem_MakerNotification;
		}
		
		//reference id
		@FindBy(xpath = "//app-inbox//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[2]//span")	
		private WebElement inventoryMaintenance_InventoryItem_ReferenceId;
		public WebElement inventoryMaintenance_InventoryItem_ReferenceId() {
		    return inventoryMaintenance_InventoryItem_ReferenceId;
		}
		
		//Pencil Icon
		@FindBy(xpath = "//app-inbox//datatable-row-wrapper[1]//datatable-body-row//div[2]//datatable-body-cell//div//ion-buttons//ion-button")	
		private WebElement inventoryMaintenance_InventoryItem_PencilIcon;
		public WebElement inventoryMaintenance_InventoryItem_PencilIcon() {
			return inventoryMaintenance_InventoryItem_PencilIcon;
		}
		//Notification NextButton
		@FindBy(xpath = "//datatable-pager[1]/ul[1]/li[8]/a[1]/i[1]")
		private WebElement inventoryMaintenance_InventoryItem_NotificationNext_Button;
		public WebElement inventoryMaintenance_InventoryItem_NotificationNext_Button() {
			return inventoryMaintenance_InventoryItem_NotificationNext_Button;
		}
		
		//Validation Msg
		@FindBy(xpath = "//body/div/div/div/div[1]")
		private WebElement inventoryMaintenance_InventoryItem_ValidationMsg;
		public WebElement inventoryMaintenance_InventoryItem_ValidationMsg() {
			
			return inventoryMaintenance_InventoryItem_ValidationMsg;
		}
		
		//Submit
		@FindBy(xpath = "//span[contains(text(),'Submit')]")
		private WebElement inventoryMaintenance_InventoryItem_SubmitButton;
		public WebElement inventoryMaintenance_InventoryItem_SubmitButton() {
			return inventoryMaintenance_InventoryItem_SubmitButton;
		}

		//Remark field//ion-textarea/div/textarea[@name='remarks']
		@FindBy(xpath = "//ion-textarea/div/textarea[@name='remarks']")
		private WebElement inventoryMaintenance_InventoryItem_RemarkField;
		public WebElement inventoryMaintenance_InventoryItem_RemarkField() {
			return inventoryMaintenance_InventoryItem_RemarkField;
		}
		//Submit by maker
		@FindBy(xpath = "//ion-button[contains(text(),'Submit')]")
		private WebElement inventoryMaintenance_InventoryItem_SubmitByMaker;
		public WebElement inventoryMaintenance_InventoryItem_SubmitByMaker() {
			return inventoryMaintenance_InventoryItem_SubmitByMaker;
		}
		
		//RecordStatus
		@FindBy(xpath="//body/div/div/div/div[1]")
		private WebElement inventoryMaintenance_InventoryItem_RecordStatus;
		public WebElement inventoryMaintenance_InventoryItem_RecordStatus()
		{
			return inventoryMaintenance_InventoryItem_RecordStatus;
		}
		
		//--------GL----------//
		
	

		@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/258']")
		private WebElement inventoryMaintenance_InventoryGlConfiguration_EyeButton;

		public WebElement inventoryMaintenance_InventoryGlConfiguration_EyeButton() {
			return inventoryMaintenance_InventoryGlConfiguration_EyeButton;

		}
		
		@FindBy(xpath = "//ion-fab-button[@id='addBtn']")
		private WebElement inventoryMaintenance_InventoryGlConfiguration_AddButton;
		public WebElement inventoryMaintenance_InventoryGlConfiguration_AddButton() {
			return inventoryMaintenance_InventoryGlConfiguration_AddButton;

		}
		

		//Item code
		@FindBy(xpath="//ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
		private WebElement inventoryMaintenance_InventoryGlConfiguration_Itemcode;
		public WebElement inventoryMaintenance_InventoryGlConfiguration_Itemcode()
		{
			return inventoryMaintenance_InventoryGlConfiguration_Itemcode;
		}
		
		//Inventory Gl
	    @FindBy(xpath="//ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	    private WebElement inventoryMaintenance_InventoryGlConfiguration_InventoryGl;
	    public WebElement inventoryMaintenance_InventoryGlConfiguration_InventoryGl()
		{
				return inventoryMaintenance_InventoryGlConfiguration_InventoryGl;
		}
	
	    //Accrued Purchase Gl
	    @FindBy(xpath="//ion-col[5]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	    private WebElement inventoryMaintenance_InventoryGlConfiguration_AccruedPurchaseGl;
	    public WebElement inventoryMaintenance_InventoryGlConfiguration_AccruedPurchaseGl()
		{
				return inventoryMaintenance_InventoryGlConfiguration_AccruedPurchaseGl;
		}
	    
	    //Accrued Landed Cost Gl
	    @FindBy(xpath="//ion-col[7]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	    private WebElement inventoryMaintenance_InventoryGlConfiguration_AccruedLandedCostGl;
	    public WebElement inventoryMaintenance_InventoryGlConfiguration_AccruedLandedCostGl()
		{
				return inventoryMaintenance_InventoryGlConfiguration_AccruedLandedCostGl;
		}
	    
	    //Inventory Inter Branch Gl
	    @FindBy(xpath="//ion-col[9]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	    private WebElement inventoryMaintenance_InventoryGlConfiguration_InventoryInterBranchGl;
	    public WebElement inventoryMaintenance_InventoryGlConfiguration_InventoryInterBranchGl()
		{
				return inventoryMaintenance_InventoryGlConfiguration_InventoryInterBranchGl;
		}
	    
	    //Inventory Damage Adjustment Gl
	    @FindBy(xpath="//ion-col[11]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	    private WebElement inventoryMaintenance_InventoryGlConfiguration_InventoryDamageAdjustmentGl;
	    public WebElement inventoryMaintenance_InventoryGlConfiguration_InventoryDamageAdjustmentGl()
		{
				return inventoryMaintenance_InventoryGlConfiguration_InventoryDamageAdjustmentGl;
		}

	    //Inventory Loss Adjustment Gl
	    @FindBy(xpath="//ion-col[13]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	    private WebElement inventoryMaintenance_InventoryGlConfiguration_InventoryLossAdjustmentGl;
	    public WebElement inventoryMaintenance_InventoryGlConfiguration_InventoryLossAdjustmentGl()
		{
				return inventoryMaintenance_InventoryGlConfiguration_InventoryLossAdjustmentGl;
		}
	    
	    //Inventory Consumption Gl
	    @FindBy(xpath="//ion-col[15]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	    private WebElement inventoryMaintenance_InventoryGlConfiguration_InventoryConsumptionGl;
	    public WebElement inventoryMaintenance_InventoryGlConfiguration_InventoryConsumptionGl()
		{
				return inventoryMaintenance_InventoryGlConfiguration_InventoryConsumptionGl;
		}

}
