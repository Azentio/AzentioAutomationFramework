package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FIXEDASSET_AssetReturnObj {
	WebDriver driver;

	public FIXEDASSET_AssetReturnObj(WebDriver driver) {
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

	@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]")
	private WebElement fixed_AssetGetReferenceNumber;

	public WebElement fixed_AssetGetReferenceNumber() {

		return fixed_AssetGetReferenceNumber;
	}

	@FindBy(xpath = "(//ion-col[2]//input)[1]")
	private WebElement asset_return_assetReferenceNo;

	public WebElement assetReturnAssetReferenceNumber() {
		return asset_return_assetReferenceNo;
	}

	@FindBy(xpath = "//ion-row[2]//ion-col[1]//input")
	private WebElement asset_return_assetItemNo;

	public WebElement assetReturnAssetItemNo() {
		return asset_return_assetItemNo;
	}

	// Asset Reference number
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[6]/div/span")
	private WebElement fixedAsset_AssetReference;

	public WebElement fixedAsset_AssetReference() {
		return fixedAsset_AssetReference;

	}

	@FindBy(xpath = "(//ion-toolbar[1]/ion-buttons[2]/ion-button[1])[2]")
	private WebElement fixed_return_save_button;

	public WebElement fixetReturnSaveButton() {
		return fixed_return_save_button;

	}

	@FindBy(xpath = "//div[@id='toast-container']//div[@role='alert']")
	private WebElement fixedAsset_AssetReturn_WorkflowInitiated;

	public WebElement fixedAsset_AssetReturn_WorkflowInitiated() {
		return fixedAsset_AssetReturn_WorkflowInitiated;
	}

	@FindBy(xpath = "//button[@aria-label='Close']")
	private WebElement fixedAsset_AssetReturn_AlertClose;

	public WebElement fixedAsset_AssetReturn_AlertClose() {
		return fixedAsset_AssetReturn_AlertClose;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/125']")
	private WebElement fixedAsset_assetReturn;

	public WebElement fixedAssetAssetReturnEyeButton() {
		return fixedAsset_assetReturn;
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

	@FindBy(xpath = "//ion-fab/ion-fab-button[@id='addBtn']")
	private WebElement fixed_AssetReturnAdd;

	public WebElement fixedAssetReturnAdd() {

		return fixed_AssetReturnAdd;
	}

	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row[1]//datatable-body-cell[4]//span")
	private WebElement fixed_AssetTableRef;

	public WebElement fixed_AssetTableRef() {

		return fixed_AssetTableRef;
	}

	// ACCOUNTS PAYABLE

	@FindBy(xpath = "//ion-segment-button[@ng-reflect-value='rpt']")
	private WebElement fixesAsset_ReportIcon;

	public WebElement fixesAsset_ReportIcon() {

		return fixesAsset_ReportIcon;
	}

	@FindBy(xpath = "//ion-label[contains(text(),'Enquiry')]")
	private WebElement fixesAsset_EnquiryMenu;

	public WebElement fixesAsset_EnquiryMenu() {

		return fixesAsset_EnquiryMenu;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/entities/financial-trans']")
	private WebElement fixesAsset_FinancialTransactionIcon;

	public WebElement fixesAsset_FinancialTransactionIcon() {

		return fixesAsset_FinancialTransactionIcon;
	}

	@FindBy(xpath = "//ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement fixedAsset_BranchCode;

	public WebElement fixedAsset_BranchCode() {

		return fixedAsset_BranchCode;
	}

	@FindBy(xpath = "//ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement fixedAsset_GlCode;

	public WebElement fixedAsset_GlCode() {

		return fixedAsset_GlCode;
	}

	@FindBy(xpath = "(//span[@class='input-calendar'])[1]")
	private WebElement fixedAsset_FromDate;

	public WebElement fixedAsset_FromDate() {

		return fixedAsset_FromDate;
	}

	@FindBy(xpath = "(//span[@class='input-calendar'])[2]")
	private WebElement fixedAsset_ToDate;

	public WebElement fixedAsset_ToDate() {

		return fixedAsset_ToDate;
	}

	@FindBy(xpath = "//owl-date-time-container[1]/div[2]/owl-date-time-calendar[1]/div[1]/button[2]/span[1]")
	private WebElement fixedAsset_NextMonth;

	public WebElement fixedAsset_NextMonth() {

		return fixedAsset_NextMonth;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-shape='round']")
	private WebElement fixedAsset_ViewButton;

	public WebElement fixedAsset_ViewButton() {

		return fixedAsset_ViewButton;
	}

	// ASSET UNDERTAKEN

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/118']")
	private WebElement fixed_AssetUndertakenEye;

	public WebElement fixed_AssetUndertakenEye() {

		return fixed_AssetUndertakenEye;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/125']")
	private WebElement fixedAsset_assetReturnView;

	public WebElement fixedAssetAssetReturnViewButton() {
		return fixedAsset_assetReturnView;
	}

	@FindBy(xpath = "//datatable-row-wrapper[1]//datatable-body-row//datatable-body-cell[6]//span")
	private WebElement fixedAsset_NewAssetReferenceNumber;

	public WebElement fixedAssetNewAssetReferenceNumber() {
		return fixedAsset_NewAssetReferenceNumber;
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

	@FindBy(xpath = "//datatable-row-wrapper[1]//span[text()='ASSET_RETURN']//ancestor::datatable-body-cell//preceding-sibling::datatable-body-cell[1]//span")
	private WebElement assetReturn_ReferenceNumber;

	public WebElement assetReturnReferenceNumber() {
		return assetReturn_ReferenceNumber;
	}

	@FindBy(xpath = "//datatable-row-wrapper[1]//span[text()='ASSET_RETURN']//ancestor::datatable-body-cell//preceding-sibling::datatable-body-cell[2]//ion-button")
	private WebElement assetReturn_NotificationFirstRecord;

	public WebElement assetReturnNotificationFirstRecord() {
		return assetReturn_NotificationFirstRecord;
	}

	@FindBy(xpath = "//input[@placeholder='Search Asset Ref No']")
	private WebElement assetReturn_ListViewSearchAssetReferenceNumber;

	public WebElement assetReturnListViewSearchAssetReferenceNumber() {
		return assetReturn_ListViewSearchAssetReferenceNumber;
	}

	@FindBy(xpath = "//label[text()=' Item Number ']//following-sibling::ng-select//span[2]")
	private WebElement assetReturn_ApprovedItemNumber;

	public WebElement assetReturnApprovedItemNumber() {
		return assetReturn_ApprovedItemNumber;
	}
	@FindBy(xpath="//datatable-row-wrapper[1]//datatable-body-cell[1]//ion-button[1]")
	private WebElement assetReturn_ApprovedReturnRecord;

	public WebElement assetReturnApprovedReturnRecord() {
		return assetReturn_ApprovedReturnRecord;
	}
	@FindBy(xpath="//datatable-row-wrapper[1]//datatable-body-cell[4]//span")
	private WebElement assetReturn_ApprovedAssetReferenceNumber;

	public WebElement assetReturnApprovedAssetReferenceNumber() {
		return assetReturn_ApprovedAssetReferenceNumber;
	}
	@FindBy(xpath="//datatable-row-wrapper[1]//datatable-body-cell[5]//span")
	private WebElement assetReturn_ApprovedAssetReferenceCode;

	public WebElement assetReturnApprovedAssetReferenceCode() {
		return assetReturn_ApprovedAssetReferenceCode;
	}
	@FindBy(xpath="//datatable-row-wrapper[1]//datatable-body-cell[8]//span")
	private WebElement assetReturn_ApprovedAssetCreatedDate;

	public WebElement assetReturnApprovedAssetCreatedDate() {
		return assetReturn_ApprovedAssetCreatedDate;
	}
	@FindBy(xpath="//ion-label[contains(text(),' Asset return report ')]//ancestor::ion-item//ion-button")
	private WebElement assetReturn_AssetReturnTempView;

	public WebElement assetReturn_AssetReturnTempView() {
		return assetReturn_AssetReturnTempView;
	}
	@FindBy(xpath="//label[contains(text(),' Asset Code ')]//following-sibling::ng-select//input")
	private WebElement assetReturn_ReportAssetCode;
	public WebElement assetReturnAssetCode()
	{
		return assetReturn_ReportAssetCode;
	}
	@FindBy(xpath="//label[contains(text(),' Item Number ')]//following-sibling::ng-select//input")
	private WebElement assetReturn_ReportItemNumber;
	public WebElement assetReturnReportItemNumber()
	{
		return assetReturn_ReportItemNumber;
	}
	@FindBy(xpath="//span[@class='input-calendar']")
	private WebElement assetReturn_ReportReturnDate;
	public WebElement assetReturnReportReturnDate()
	{
		return assetReturn_ReportReturnDate;
	}
	
	
}
