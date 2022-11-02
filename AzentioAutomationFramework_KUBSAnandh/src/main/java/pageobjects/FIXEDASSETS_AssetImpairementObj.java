package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FIXEDASSETS_AssetImpairementObj {
	WebDriver driver;

	public FIXEDASSETS_AssetImpairementObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ion-label[text()=' Asset impairement ']//following-sibling::ion-buttons//ion-button[2]")
	private WebElement fixedasset_view_icon;

	public WebElement fixedAssetViewIcon() {
		return fixedasset_view_icon;
	}

	@FindBy(xpath = "//ion-fab-button[@id='addBtn']")
	private WebElement fixed_asset_add_button;

	public WebElement fixedAssetAddButton() {
		return fixed_asset_add_button;
	}

	@FindBy(xpath = "//ion-label[text()=' Asset sale ']//following-sibling::ion-buttons//ion-button[1]")
	private WebElement fixedAsset_AssetSaleTempView;

	public WebElement fixedAssetAssetSaleTempView() {
		return fixedAsset_AssetSaleTempView;
	}

	@FindBy(xpath = "//datatable-row-wrapper[1]//datatable-body-cell[5]//span")
	private WebElement fixedAsset_TempViewFirstAssetReferenceNumber;

	public WebElement fixedAssetTempViewFirstAssetReferenceNumber() {
		return fixedAsset_TempViewFirstAssetReferenceNumber;
	}

	@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement fixedasset_asset_reference_number;

	public WebElement fixedAssetReferenceNumber() {
		return fixedasset_asset_reference_number;
	}
	@FindBy(xpath="//datatable-row-wrapper[1]//datatable-body-cell[5]//span")
	private WebElement assetTransfer_TempViewAssetReferenceNumber;
	public WebElement assetTransferTempViewAssetReferenceNumber()
	{
		return assetTransfer_TempViewAssetReferenceNumber;
	}
	@FindBy(xpath = "//ion-col[6]//input")
	private WebElement fixedasset_asset_item_no;

	public WebElement fixedAssetAssetItemNo() {
		return fixedasset_asset_item_no;
	}

	@FindBy(xpath = "//ion-col[3]/ion-item[1]/ion-select[1]")
	private WebElement fixedasset_asset_transaction_type;

	public WebElement fixedAssetAssetTransactionType() {
		return fixedasset_asset_transaction_type;
	}

	@FindBy(xpath = "//ion-col[5]/app-kub-display-field[1]/ion-item[1]/ion-input[1]/input[1]")
	private WebElement fixed_asset_asset_description;

	public WebElement fixedAssetAssetDescription() {
		return fixed_asset_asset_description;
	}

	@FindBy(xpath = "//ion-item[1]/ion-radio")
	private WebElement fixed_asset_transType_impairement;

	public WebElement fixedAssetTransTypeImpairement() {
		return fixed_asset_transType_impairement;
	}

	@FindBy(xpath = "//ion-item[2]/ion-radio")
	private WebElement fixed_asset_transType_writeOff;

	public WebElement fixedAssetTransTypeWriteOff() {
		return fixed_asset_transType_writeOff;
	}

	@FindBy(xpath = "//page-fixed-asset-impairment-update[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button")
	private WebElement fixed_asset_save_button;

	public WebElement fixedAssetSaveButton() {
		return fixed_asset_save_button;

	}

	@FindBy(xpath = "//div[@id='toast-container']/div/div[@role='alert']")
	private WebElement kubs_ToastAlert;

	public WebElement kubsToastAlert() {
		return kubs_ToastAlert;
	}

	@FindBy(xpath = "//div[@id='toast-container']//button")
	private WebElement alert_close;

	public WebElement alertClose() {
		return alert_close;
	}

	@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/span[2]")
	private WebElement fixed_asset_get_asset_referece_no;

	public WebElement fixedAssetGetReferenceNo() {
		return fixed_asset_get_asset_referece_no;
	}

	@FindBy(xpath = "//i[@class='datatable-icon-right']")
	private WebElement fixed_asset_next_button;

	public WebElement fixedAssetNextButton() {
		return fixed_asset_next_button;
	}

	@FindBy(xpath = "//ion-input[@name='bookValue']/input")
	private WebElement fixedAsset_bookValue;

	public WebElement fixedAssetBookValue() {
		return fixedAsset_bookValue;
	}

	@FindBy(xpath = "//input[@id='assetAmt']")
	private WebElement fixedAsset_assetValue;

	public WebElement fixedAssetAssetValue() {
		return fixedAsset_assetValue;
	}

	@FindBy(xpath = "//div[contains(text(),'No items found')]")
	private WebElement fixedAsset_noList;

	public WebElement fixedAssetNoList() {
		return fixedAsset_noList;
	}
}
