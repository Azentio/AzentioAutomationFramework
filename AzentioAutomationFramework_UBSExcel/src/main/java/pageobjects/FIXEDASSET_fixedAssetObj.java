package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FIXEDASSET_fixedAssetObj {
	WebDriver driver;

	public FIXEDASSET_fixedAssetObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/126']")
	private WebElement fixed_asset_asset_allocation_view;

	public WebElement fixedAssetAssetAllocationViewButton() {
		return fixed_asset_asset_allocation_view;
	}
	@FindBy(xpath="//input[@placeholder='Search Status']")
	private WebElement fixedAsset_AssetReferenceNumStatus;
	public WebElement fixedAssetAssetReferenceNumStatus()
	{
		return fixedAsset_AssetReferenceNumStatus;
	}
	@FindBy(xpath="//datatable-row-wrapper[1]//datatable-body-cell[5]//span")
	private WebElement fixedAsset_AmmendmentApprovedRecord;
	public WebElement fixedAssetAmmendmentApprovedRecord()
	{
		return fixedAsset_AmmendmentApprovedRecord;
	}
	@FindBy(xpath="//datatable-row-wrapper[1]//datatable-body-cell[6]//span")
	private WebElement fixedAsset_ActiveRecord;
	public WebElement fixedAssetActiveRecord()
	{
		return fixedAsset_ActiveRecord;
	}
	@FindBy(xpath="//datatable-row-wrapper[1]//datatable-body-cell[4]//span")
	private WebElement fixedAssetRevaluation_AssetReferenceNumber;
	public WebElement fixedAssetReValuationReferenceNumber()
	{
		return fixedAssetRevaluation_AssetReferenceNumber;
	}
	@FindBy(xpath="//datatable-row-wrapper[1]//datatable-body-cell[5]//span")
	private WebElement assetAllocation_AssetReferenceNumActive;
	public WebElement fixedAssetAllocationActiveReferenceNumber()
	{
		return assetAllocation_AssetReferenceNumActive;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/115']")
	private WebElement fixed_asset_asset_sale_view;

	public WebElement fixedAssetAssetSaleViewButton() {
		return fixed_asset_asset_sale_view;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/118']")
	private WebElement fixed_asset_asset_underTaking;

	public WebElement fixedAssetAssetUnderTaking() {
		return fixed_asset_asset_underTaking;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/114']")
	private WebElement fixed_asset_asset_transfer;

	public WebElement fixedAssetAssetTransfer() {
		return fixed_asset_asset_transfer;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/120']")
	private WebElement fixed_asset_asset_deallocation;

	public WebElement fixedAssetAssetDeallocation() {
		return fixed_asset_asset_deallocation;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/125']")
	private WebElement fixedAsset_assetReturn;

	public WebElement fixedAssetAssetReturn() {
		return fixedAsset_assetReturn;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid/122']")
	private WebElement fixedAsset_assetReturn_action;

	public WebElement fixedAssetAssetReturnActionIcon() {
		return fixedAsset_assetReturn_action;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid/121']")
	private WebElement fixedAsset_assetReplacement;

	public WebElement fixedAssetAssetReplacement() {
		return fixedAsset_assetReplacement;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/128']")
	private WebElement fixedAsset_assetAmmendent;

	public WebElement fixedAssetAssetAmmendent() {
		return fixedAsset_assetAmmendent;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/137']")
	private WebElement fixedAsset_assetRevalueation;

	public WebElement fixedAssetRevaluation() {
		return fixedAsset_assetRevalueation;
	}

	@FindBy(xpath = "//ion-icon[@title='Enable Search']")
	private WebElement fixedAsset_searchIcon;

	public WebElement fixedAssetSearchIcon() {
		return fixedAsset_searchIcon;
	}

	@FindBy(xpath = "//input[@placeholder='Search Asset Reference No']")
	private WebElement fixedAsset_search_RefNo;

	public WebElement fixedAssetSearchRefNo() {
		return fixedAsset_search_RefNo;
	}

	@FindBy(xpath = "//input[@placeholder='Search Asset Ref No']")
	private WebElement fixedAsset_assetReplacementSearch;

	public WebElement AssetReplacementAssetRefNoSearch() {
		return fixedAsset_assetReplacementSearch;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/98']")
	private WebElement fixedAsset_AssetCreationView;

	public WebElement fixedAssetAssetCreationViewButton() {
		return fixedAsset_AssetCreationView;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/115']")
	private WebElement fixedAsset_assetSale;

	public WebElement fixedAssetAssetSale() {
		return fixedAsset_assetSale;
	}

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid/113']")
	private WebElement fixedAsset_assetTransfer;

	public WebElement fixedAssetAssetTransferEditIcon() {
		return fixedAsset_assetTransfer;
	}

	@FindBy(xpath = "(//ion-tab-button/ion-label)[2]")
	private WebElement fixedAsset_FixedAssetItem;
	public WebElement fixedAssetFixedAssetItem()
	{
		return fixedAsset_FixedAssetItem;
	}
	@FindBy(xpath="//datatable-row-wrapper[1]/datatable-body-row/div/datatable-body-cell[1]//ion-button[1]")
	private WebElement fixedAsset_AssetItem;
	public WebElement fixedAssetItemRecord()
	{
		return fixedAsset_AssetItem;
	}
	@FindBy(xpath="//ion-toolbar//ion-buttons[2]/span[1]")
	private WebElement fixedAsset_SystemDate;
	public WebElement fixedAssetSystemDate()
	{
		return fixedAsset_SystemDate;
	}
	@FindBy(xpath="//ion-col[13]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]")
	private WebElement fixedAssetLife;
	public WebElement fixedAssetLife()
	{
		return fixedAssetLife;
	}
	@FindBy(xpath="//datatable-row-wrapper[1]//datatable-body-cell[6]//span")
	private WebElement fixedAsset_ApprovedAssetReferenceNumber;
	public WebElement fixedAssetApprovedReferenceNumber()
	{
		return fixedAsset_ApprovedAssetReferenceNumber;
	}
	@FindBy(xpath="//label[text()=' Asset Reference Number ']//following-sibling::ng-select//input")
	private WebElement AssetAmmendment_AssetReferenceNumber;
	public WebElement assetAmmendmentAssetReferenceNumber()
	{
		return AssetAmmendment_AssetReferenceNumber;
	}
	@FindBy(xpath="//label[text()=' Item Number ']//following-sibling::ng-select//input")
	private WebElement AssetAmmendment_AssetItemNumber;
	public WebElement assetAmmendmentAssetItemNumber()
	{
		return AssetAmmendment_AssetItemNumber;
	}
	@FindBy(xpath="//label[text()=' Modification Type ']//following-sibling::ng-select//input")
	private WebElement AssetAmmendment_ModificationType;
	public WebElement AssetAmmendmentModificationType()
	{
		return AssetAmmendment_ModificationType;
	}
	@FindBy(xpath="//app-kub-date-time[@formcontrolname='newAssetCapitalizationDate']//span[1]")
	private WebElement assetAmmendment_AssetCapitalizationDate;
	public WebElement assetAmmendmentAssetCapitalizationDate()
	{
		return assetAmmendment_AssetCapitalizationDate;
	}
	@FindBy(xpath="//ion-label[text()='Asset Life']//following-sibling::ion-input//input")
	private WebElement assetAmmendment_AssetLife;
	public WebElement assetAmmendmentAssetLife()
	{
		return assetAmmendment_AssetLife;
	}
	@FindBy(xpath = "//datatable-row-wrapper[1]//span[text()='FIXED_ASSET_AMENDENT']//ancestor::datatable-body-cell//preceding-sibling::datatable-body-cell[1]//span")
	private WebElement assetAmmendment_ReferenceNumber;

	public WebElement assetAmmendmentReferenceNumber() {
		return assetAmmendment_ReferenceNumber;
	}

	@FindBy(xpath = "//datatable-row-wrapper[1]//span[text()='FIXED_ASSET_AMENDENT']//ancestor::datatable-body-cell//preceding-sibling::datatable-body-cell[2]//ion-button")
	private WebElement assetAmmendment_NotificationFirstRecord;

	public WebElement assetAmmendmentNotificationFirstRecord() {
		return assetAmmendment_NotificationFirstRecord;
	}
	@FindBy(xpath="//input[@placeholder='Search Asset Reference No']")
	private WebElement assetAmmendment_ListViewSearchAssetRefNo;
	public WebElement assetAmmendmentListViewSearchAssetRefNo()
	{
		return assetAmmendment_ListViewSearchAssetRefNo;
	}
	@FindBy(xpath="//label[text()=' Item Number ']//following-sibling::ng-select//span[2]")
	private WebElement assetAmmendment_ApprovedItemNumber;
	public WebElement assetAmmendmentApprovedItemNumber()
	{
		return assetAmmendment_ApprovedItemNumber;
	}
	@FindBy(xpath="//datatable-row-wrapper[1]//datatable-body-cell[3]//span")
	private WebElement fixedAsset_ApprovedGl;
	public WebElement fixedAssetApprovedGl()
	{
		return fixedAsset_ApprovedGl;
	}
	@FindBy(xpath="//input[@placeholder='Search Asset Code']")
	private WebElement fixedAsset_GlSearchAssetCode;
	public WebElement fixedAssetGlSearchAssetCode()
	{
		return fixedAsset_GlSearchAssetCode;
	}
	@FindBy(xpath="//label[contains(text(),' Branch Code ')]//following-sibling::ng-select//input")
	private WebElement fixedAsset_AccountingEntriesBranchCode;
	public WebElement fixedAssetAccountingEntriesBranchCode()
	{
		return fixedAsset_AccountingEntriesBranchCode;
	}
	@FindBy(xpath="//label[contains(text(),' Gl Code ')]//following-sibling::ng-select//input")
	private WebElement fixedAsset_AccountingEntriesGlCode;
	public WebElement fixedAssetAccountingEntriesGlCode()
	{
		return fixedAsset_AccountingEntriesGlCode;
	}
	@FindBy(xpath="//span[contains(text(),'View')]//ancestor::ion-button")
	private WebElement fixedAsset_AccountingEntriesViewButton;
	public WebElement fixedAssetAccountingEntriesViewButton()
	{
		return fixedAsset_AccountingEntriesViewButton;
	}
	@FindBy(xpath="//div[contains(text(),'No data to display')]")
	private WebElement fixedAsset_AccountingEntriesNoDataValidation;
	public WebElement fixedAsset_AccountingEntriesNoDataValidation()
	{
		return fixedAsset_AccountingEntriesNoDataValidation;
	}
}
