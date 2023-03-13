package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FIXEDASSET_AssetRevaluvationObj {
	WebDriver driver;

	public FIXEDASSET_AssetRevaluvationObj(WebDriver driver) {
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

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/137']")
	private WebElement fixed_AssetRevalueEye;

	public WebElement fixed_AssetRevalueEye() {

		return fixed_AssetRevalueEye;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid/136']")
	private WebElement fixed_AssetRevalueEdit;

	public WebElement fixed_AssetRevalueEdit() {

		return fixed_AssetRevalueEdit;
	}

	@FindBy(xpath = "//ion-fab/ion-fab-button[@id='addBtn']")
	private WebElement fixed_AssetRevalueAdd;

	public WebElement fixedAssetRevalueAdd() {

		return fixed_AssetRevalueAdd;
	}

	@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement fixed_AssetReferenceNumber;

	public WebElement fixed_AssetReferenceNumber() {

		return fixed_AssetReferenceNumber;
	}

	@FindBy(xpath = "//ion-col[5]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement fixed_AssetItemCode;

	public WebElement fixed_AssetItemCode() {

		return fixed_AssetItemCode;
	}

	@FindBy(xpath = "//ion-col[7]/ion-item[1]/input[@ng-reflect-name='bookValue']")
	private WebElement fixed_AssetBookValue;

	public WebElement fixed_AssetBookValue() {

		return fixed_AssetBookValue;
	}

	@FindBy(xpath = "//div[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1]")
	private WebElement fixed_Save;

	public WebElement AssetRevaluvation_Save() {

		return fixed_Save;
	}

	@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]")
	private WebElement fixed_AssetGetReferenceNumber;

	public WebElement fixed_AssetGetReferenceNumber() {

		return fixed_AssetGetReferenceNumber;
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

	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row[1]//datatable-body-cell[5]//span")
	private WebElement fixed_AssetTableRef;

	public WebElement fixed_AssetTableRef() {

		return fixed_AssetTableRef;
	}
	
	// ASSET DE-ALLOCATION
	
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/120']")
	private WebElement fixed_AssetDeallocationEye;

	public WebElement fixed_AssetDeallocationEye() {

		return fixed_AssetDeallocationEye;
	}
	
	// ASSET IMPAIRMENT
	
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/129']")
	private WebElement fixed_AssetImpairmentEye;

	public WebElement fixed_AssetImpairmentEye() {

		return fixed_AssetImpairmentEye;
	}
	
	// ASSET AMENDMENT
	
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/128']")
	private WebElement fixed_AssetAmendmentEye;

	public WebElement fixed_AssetAmendmentEye() {

		return fixed_AssetAmendmentEye;
	}
	
	// ASSET REPLACEMENT	
	
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/124']")
	private WebElement fixed_AssetReplaceEye;

	public WebElement fixed_AssetReplaceEye() {

		return fixed_AssetReplaceEye;
	}
	
	// ASSET UNDERTAKEN
	
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/118']")
	private WebElement fixed_AssetUndertakenEye;

	public WebElement fixed_AssetUndertakenEye() {

		return fixed_AssetUndertakenEye;
	}
	
	// ASSET SALE
	
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/115']")
	private WebElement fixed_AssetSaleEye;

	public WebElement fixed_AssetSaleEye() {

		return fixed_AssetSaleEye;
	}
	
	// ASSET RETURN
	
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/125']")
	private WebElement fixed_AssetReturnEye;

	public WebElement fixed_AssetReturnEye() {

		return fixed_AssetReturnEye;
	}
	@FindBy(xpath = "//datatable-row-wrapper[1]//span[text()='ASSET_REVALUATION']//ancestor::datatable-body-cell//preceding-sibling::datatable-body-cell[1]//span")
	private WebElement assetRevaluation_ReferenceNumber;

	public WebElement assetRevaluationReferenceNumber() {
		return assetRevaluation_ReferenceNumber;
	}

	@FindBy(xpath = "//datatable-row-wrapper[1]//span[text()='ASSET_REVALUATION']//ancestor::datatable-body-cell//preceding-sibling::datatable-body-cell[2]//ion-button")
	private WebElement assetRevaluation_NotificationFirstRecord;

	public WebElement assetRevaluationNotificationFirstRecord() {
		return assetRevaluation_NotificationFirstRecord;
	}
	@FindBy(xpath="//input[@placeholder='Search Asset Reference No']")
	private WebElement assetRevaluation_ListViewSearchAssetReferenceNumber;
	public WebElement assetRevaluationListViewSearchAssetReferenceNumber()
	{
		return assetRevaluation_ListViewSearchAssetReferenceNumber;
	}
	
	
	
	
	
}
