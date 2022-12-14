package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FIXEDASSET_AssetReplacementObj {
	WebDriver driver;

	public FIXEDASSET_AssetReplacementObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ion-select[@class='datagrid-lov ng-valid md hydrated ng-touched ng-dirty ion-valid ion-touched ion-dirty']")
	private WebElement fixed_FinanceOption;

	public WebElement fixedFinanceOption() {

		return fixed_FinanceOption;
	}

	@FindBy(xpath = "//ion-segment/ion-segment-button[2]")
	private WebElement fixed_Transfericon;

	public WebElement fixedTransfericon() {

		return fixed_Transfericon;
	}

	@FindBy(xpath = "//div[@id='toast-container']/div/div[@role='alert']")
	private WebElement fixed_Popup;

	public WebElement fixed_Popup() {

		return fixed_Popup;
	}

	@FindBy(xpath = "//ion-label[contains(text(),'Fixed assets')]")
	private WebElement fixed_Fixedassets;

	public WebElement fixed_FixedAssets() {

		return fixed_Fixedassets;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/124']")
	private WebElement fixed_AssetReplacementEye;

	public WebElement fixed_AssetReplacementEye() {

		return fixed_AssetReplacementEye;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid/127']")
	private WebElement fixed_AssetReplacementEdit;

	public WebElement fixed_AssetReplacementEdit() {

		return fixed_AssetReplacementEdit;
	}

	@FindBy(xpath = "//ion-fab/ion-fab-button[@id='addBtn']")
	private WebElement fixed_AssetReplacementAdd;

	public WebElement fixedAssetReplacementAdd() {

		return fixed_AssetReplacementAdd;
	}

	@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement fixed_AssetReferenceNumber;

	public WebElement fixed_AssetReferenceNumber() {

		return fixed_AssetReferenceNumber;
	}

	@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]")
	private WebElement fixed_AssetGetReferenceNumber;

	public WebElement fixed_AssetGetReferenceNumber() {

		return fixed_AssetGetReferenceNumber;
	}

	@FindBy(xpath = "//ion-col[5]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement fixed_AssetItemNO;

	public WebElement fixed_AssetItemNO() {

		return fixed_AssetItemNO;
	}

	@FindBy(xpath = "//ion-input/input[@name='newItemNo']")
	private WebElement fixed_AssetNewItemNO;

	public WebElement fixed_AssetNewItemNO() {

		return fixed_AssetNewItemNO;
	}

	@FindBy(xpath = "//input[@name='newItemDesc']")
	private WebElement fixed_AssetNewDesc;

	public WebElement fixed_AssetNewDesc() {

		return fixed_AssetNewDesc;
	}

	@FindBy(xpath = "//ion-toolbar[1]/ion-buttons[2]//ion-button/ion-icon[@name='save']")
	private WebElement fixed_Save;

	public WebElement AssetReplace_Save() {

		return fixed_Save;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/inbox']")
	private WebElement fixed_MakerNotification;

	public WebElement fixed_MakerNotification() {

		return fixed_MakerNotification;
	}

	@FindBy(xpath = "//app-inbox//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[2]//span")
	private WebElement fixed_ReferanceId;

	public WebElement fixed_ReferanceId() {

		return fixed_ReferanceId;
	}

	@FindBy(xpath = "//app-inbox//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[1]//ion-button")
	private WebElement fixed_ActionButton;

	public WebElement fixed_ActionButton() {

		return fixed_ActionButton;
	}

	@FindBy(xpath = "//span[contains(text(),'Submit')]")
	private WebElement fixed_Submit;

	public WebElement fixed_Submit() {

		return fixed_Submit;
	}

	@FindBy(xpath = "//textarea[@name='remarks']")
	private WebElement fixed_Remark;

	public WebElement fixed_Remark() {

		return fixed_Remark;
	}

	@FindBy(xpath = "//ion-button[contains(text(),'Submit')]")
	private WebElement fixed_RemarkSubmit;

	public WebElement fixed_RemarkSubmit() {

		return fixed_RemarkSubmit;
	}

	@FindBy(xpath = "//div[@id='toast-container']/div/div[@role='alert']")
	private WebElement fixed_ReviewerId;

	public WebElement fixed_ReviewerId() {

		return fixed_ReviewerId;
	}

	@FindBy(xpath = "//button[@aria-label='Close']")
	private WebElement fixed_Notification_Close;

	public WebElement fixed_Notification_Close() {

		return fixed_Notification_Close;
	}

	@FindBy(xpath = "//ion-icon[@ng-reflect-name='search']")
	private WebElement fixed_AssetSearch;

	public WebElement fixed_AssetSearch() {

		return fixed_AssetSearch;
	}

	@FindBy(xpath = "//ion-input/input[@name='col2']")
	private WebElement fixed_AssetSearchCode;

	public WebElement fixed_AssetSearchCode() {

		return fixed_AssetSearchCode;
	}

	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[1]//ion-button[1]")
	private WebElement fixed_AssetTableEye;

	public WebElement fixed_AssetTableEye() {

		return fixed_AssetTableEye;
	}

	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row[1]//datatable-body-cell[6]//span")
	private WebElement fixed_AssetTableRef;

	public WebElement fixed_AssetTableRef() {

		return fixed_AssetTableRef;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/124']")
	private WebElement fixedAsset_AssetReplacementViewButton;

	public WebElement fixedAssetAAssetReplacementViewButton() {
		return fixedAsset_AssetReplacementViewButton;
	}

	@FindBy(xpath = "//ion-col[2]//input")
	private WebElement fixedAssetAssetReplacementRaferenceNumber;

	public WebElement fixedAssetReplacementReferenceNumber() {
		return fixedAssetAssetReplacementRaferenceNumber;
	}

	@FindBy(xpath = "//ion-col[5]//input")
	private WebElement fixedAssetAssetReplacementItemNumber;

	public WebElement fixedAssetReplacementItemNumber() {
		return fixedAssetAssetReplacementItemNumber;
	}

	@FindBy(xpath = "//ion-col[8]//input")
	private WebElement fixedAssetAssetReplacementNewItemNumber;

	public WebElement fixedAssetReplacementNewItemNumber() {
		return fixedAssetAssetReplacementNewItemNumber;
	}

	@FindBy(xpath = "//ion-col[9]//input")
	private WebElement fixedAssetAssetReplacementNewDescription;

	public WebElement fixedAssetReplacementNewDescription() {
		return fixedAssetAssetReplacementNewDescription;
	}

	// @FindBy(xpath="//page-asset-replacement-update//ion-toolbar[1]//ion-buttons[2]//ion-button[1]")
	@FindBy(xpath = "//page-asset-replacement-update//ion-buttons[2]//ion-button")
	private WebElement fixedAssetAssetReplacementSaveButton;

	public WebElement fixedAssetReplacementSaveButton() {
		return fixedAssetAssetReplacementSaveButton;
	}
	@FindBy(xpath = "//datatable-row-wrapper[1]//span[text()='ASSET_REPLACEMENT']//ancestor::datatable-body-cell//preceding-sibling::datatable-body-cell[1]//span")
	private WebElement assetReplacement_ReferenceNumber;

	public WebElement assetReplacementReferenceNumber() {
		return assetReplacement_ReferenceNumber;
	}

	@FindBy(xpath = "//datatable-row-wrapper[1]//span[text()='ASSET_REPLACEMENT']//ancestor::datatable-body-cell//preceding-sibling::datatable-body-cell[2]//ion-button")
	private WebElement assetReplacement_NotificationFirstRecord;

	public WebElement assetReplacementNotificationFirstRecord() {
		return assetReplacement_NotificationFirstRecord;
	}
	@FindBy(xpath="//input[@placeholder='Search Asset Ref No']")
	private WebElement assetReplacement_ListViewSearchAssetReferenceNumber;
	public WebElement assetReplacementListViewSearchAssetReferenceNumber()
	{
		return assetReplacement_ListViewSearchAssetReferenceNumber;
	}
}
