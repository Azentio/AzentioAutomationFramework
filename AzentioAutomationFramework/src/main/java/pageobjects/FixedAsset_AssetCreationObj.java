package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FixedAsset_AssetCreationObj {
	WebDriver driver;

	public FixedAsset_AssetCreationObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Direction
	@FindBy(xpath = "//ion-segment/ion-segment-button[2]")
	private WebElement fixedAsset_AssetCreation_DirectionIcon;

	public WebElement fixedAsset_AssetCreation_DirectionIcon() {
		return fixedAsset_AssetCreation_DirectionIcon;
	}
	
	// Fixed assets
	@FindBy(xpath = "//ion-label[contains(text(),'Fixed assets')]")
	private WebElement fixedAsset_AssetCreation_FixedAssetsField;

	public WebElement fixedAsset_AssetCreation_FixedAssetsField() {
		return fixedAsset_AssetCreation_FixedAssetsField;
	}
	
	// Fixed asset creation eye button
	@FindBy(xpath = "//ion-list[1]/div[6]/ion-menu-toggle[1]/ion-item[1]/ion-buttons[1]/ion-button[2]")
	private WebElement fixedAsset_AssetCreation_EyeButton;

	public WebElement fixedAsset_AssetCreation_EyeButton() {
		return fixedAsset_AssetCreation_EyeButton;
	}
	
	// Add button
	@FindBy(xpath = "//ion-icon[@ng-reflect-name='add']|//div[1]/ion-router-outlet[1]/app-data-grid[1]/ion-content[1]/ion-fab[1]/ion-fab-button[1]/ion-icon[1]")
	private WebElement fixedAsset_AssetCreation_AddButton;

	public WebElement fixedAsset_AssetCreation_AddButton() {
		return fixedAsset_AssetCreation_AddButton;
	}
	
	// BranchCode
	@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement fixedAsset_AssetCreation_BranchCode_Textbox;

	public WebElement fixedAsset_AssetCreation_BranchCode_Textbox() {
		return fixedAsset_AssetCreation_BranchCode_Textbox;
	}
	
	// AssetCode
	@FindBy(xpath = "//ion-col[6]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement fixedAsset_AssetCreation_AssetCode_Textbox;

	public WebElement fixedAsset_AssetCreation_AssetCode_Textbox() {
		return fixedAsset_AssetCreation_AssetCode_Textbox;
	}
	
	// BillReference NUmber
	@FindBy(xpath = "//ion-col[10]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement fixedAsset_AssetCreation_BillReferenceNumber_Textbox;

	public WebElement fixedAsset_AssetCreation_BillReferenceNumber_Textbox() {
		return fixedAsset_AssetCreation_BillReferenceNumber_Textbox;
	}
	
	// SaveButton for FixedAsset Creation
	@FindBy(xpath = "(//ion-toolbar[1]/ion-buttons[2]/ion-button[1])[2]")
	private WebElement fixedAsset_AssetCreation_SaveButton;

	public WebElement fixedAsset_AssetCreation_SaveButton() {
		return fixedAsset_AssetCreation_SaveButton;
	}

	// reference id
	@FindBy(xpath = "//app-inbox//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[2]//span")
	private WebElement fixedAsset_AssetCreation_ReferenceId;

	public WebElement fixedAsset_AssetCreation_ReferenceId() {
		return fixedAsset_AssetCreation_ReferenceId;
	}

	// Pencil Icon
	@FindBy(xpath = "//app-inbox//datatable-row-wrapper[1]//datatable-body-row//div[2]//datatable-body-cell//div//ion-buttons//ion-button")
	private WebElement fixedAsset_AssetCreation_PencilIcon;

	public WebElement fixedAsset_AssetCreation_PencilIcon() {
		return fixedAsset_AssetCreation_PencilIcon;
	}

	// Notification NextButton
	@FindBy(xpath = "//datatable-pager[1]/ul[1]/li[8]/a[1]/i[1]")
	private WebElement fixedAsset_AssetCreation_NotificationNext_Button;

	public WebElement fixedAsset_AssetCreation_NotificationNext_Button() {
		return fixedAsset_AssetCreation_NotificationNext_Button;
	}

	// Validation Msg
	@FindBy(xpath = "//body/div/div/div/div[1]")
	private WebElement fixedAsset_AssetCreation_ValidationMsg;

	public WebElement fixedAsset_AssetCreation_ValidationMsg() {

		return fixedAsset_AssetCreation_ValidationMsg;
	}

	// Submit
	@FindBy(xpath = "//span[contains(text(),'Submit')]")
	private WebElement fixedAsset_AssetCreation_SubmitButton;

	public WebElement fixedAsset_AssetCreation_SubmitButton() {
		return fixedAsset_AssetCreation_SubmitButton;
	}

	// Remark field
	@FindBy(xpath = "//ion-textarea/div/textarea[@name='remarks']")
	private WebElement fixedAsset_AssetCreation_RemarkField;

	public WebElement fixedAsset_AssetCreation_RemarkField() {
		return fixedAsset_AssetCreation_RemarkField;
	}

	// Submit by maker
	@FindBy(xpath = "//ion-button[contains(text(),'Submit')]")
	private WebElement fixedAsset_AssetCreation_SubmitByMaker;

	public WebElement fixedAsset_AssetCreation_SubmitByMaker() {
		return fixedAsset_AssetCreation_SubmitByMaker;
	}

	// RecordStatus
	@FindBy(xpath = "//body/div/div/div/div[1]")
	private WebElement fixedAsset_AssetCreation_RecordStatus;

	public WebElement fixedAsset_AssetCreation_RecordStatus() {
		return fixedAsset_AssetCreation_RecordStatus;
	}

	// Fixed Asset Items
	@FindBy(xpath = "//span[2]/ion-tab-button/ion-label")
	private WebElement fixedAsset_AssetCreation_FixedAssetItems;

	public WebElement fixedAsset_AssetCreation_FixedAssetItems() {
		return fixedAsset_AssetCreation_FixedAssetItems;
	}	

	// Asset item Number
	@FindBy(xpath = "//ion-row[1]/ion-col[1]/ion-item[1]/ion-input[1]/input")
	private WebElement fixedAsset_AssetCreation_AssetItemNumber;

	public WebElement fixedAsset_AssetCreation_AssetItemNumber() {
		return fixedAsset_AssetCreation_AssetItemNumber;
	}

	// Asset item Description
	@FindBy(xpath = "//ion-row[1]/ion-col[2]/ion-item[1]/ion-input[1]/input")
	private WebElement fixedAsset_AssetCreation_AssetItemDescription;

	public WebElement fixedAsset_AssetCreation_AssetItemDescription() {
		return fixedAsset_AssetCreation_AssetItemDescription;
	}

	// Asset AssetValue
	@FindBy(xpath = "//ion-row[4]/ion-col[1]/ion-item[1]/ion-input[1]/input")
	private WebElement fixedAsset_AssetCreation_AssetValue;

	public WebElement fixedAsset_AssetCreation_AssetValue() {
		return fixedAsset_AssetCreation_AssetValue;
	}
	
	// Asset SalvageValue
	@FindBy(xpath = "//ion-row[4]/ion-col[3]/ion-item[1]/ion-input[1]/input")
	private WebElement fixedAsset_AssetCreation_SalvageValue;

	public WebElement fixedAsset_AssetCreation_SalvageValue() {
		return fixedAsset_AssetCreation_SalvageValue;
	}

	// Asset item calendar
	@FindBy(xpath = "(//span[@class='input-calendar'])[2]")
	private WebElement fixedAsset_AssetCreation_AssetItemCalendar;

	public WebElement fixedAsset_AssetCreation_AssetItemCalendar() {
		return fixedAsset_AssetCreation_AssetItemCalendar;
	}
	//---calendar--//
	@FindBy(xpath = "(//span[@class='input-calendar'])[1]")
	private WebElement fixedAsset_AssetCreation_FromDate;

	public WebElement fixedAsset_AssetCreation_FromDate() {
		return fixedAsset_AssetCreation_FromDate;

	}

	@FindBy(xpath = "(//span[@class='input-calendar'])[2]")
	private WebElement fixedAsset_AssetCreation_ToDate;

	public WebElement fixedAsset_AssetCreation_ToDate() {
		return fixedAsset_AssetCreation_ToDate;
	}

	@FindBy(xpath = "(//button[@type='button'])[3]")
	private WebElement fixedAsset_AssetCreation_NextMonth;

	public WebElement fixedAsset_AssetCreation_NextMonth() {
		return fixedAsset_AssetCreation_NextMonth;
	}
	
	
	
}
