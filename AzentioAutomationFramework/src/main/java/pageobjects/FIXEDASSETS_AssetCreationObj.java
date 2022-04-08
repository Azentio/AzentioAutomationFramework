package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FIXEDASSETS_AssetCreationObj {
	WebDriver driver;

	public FIXEDASSETS_AssetCreationObj(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	ASSET CREATION SUBMODULE  //

//	--------------------------A-S-S-E-T--C-R-E-A-T-I-O-N-----------------------------------//
	// Direction button
	@FindBy(xpath = "//ion-segment/ion-segment-button[2]")
	private WebElement fixedAssets_AssetCreation_DirectionButton;

	public WebElement fixedAssets_AssetCreation_DirectionButton() {
		return fixedAssets_AssetCreation_DirectionButton;
	}

	// Fixed Asset menu
	@FindBy(xpath = "//ion-label[text()=' Fixed assets ']")
	private WebElement fixedAssets_AssetCreation_Menu;

	public WebElement fixedAssets_AssetCreation_Menu() {
		return fixedAssets_AssetCreation_Menu;
	}

	// eye button of Asset Creation
	@FindBy(xpath = "//div[6]//ion-menu-toggle[1]//ion-item//ion-buttons//ion-button[2]")
	private WebElement fixedAssets_AssetCreation_EyeButton;

	public WebElement fixedAssets_AssetCreation_EyeButton() {
		return fixedAssets_AssetCreation_EyeButton;
	}
	
//	// eye button of first record of Asset Transfer
//	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[1]/div/ion-buttons/ion-button[1]")
//	private WebElement fixedAssets_AssetTransfer_FirstViewButton;
//	
//	public WebElement fixedAssets_AssetTransfer_FirstViewButton() {
//		return fixedAssets_AssetTransfer_FirstViewButton;
//	}
//	
//	// eye button of Asset undertaking
//	@FindBy(xpath = "//div[6]//ion-menu-toggle[3]//ion-item//ion-buttons//ion-button[2]")
//	private WebElement fixedAssets_AssetUndertaking_EyeButton;
//	
//	public WebElement fixedAssets_AssetUndertaking_EyeButton() {
//		return fixedAssets_AssetUndertaking_EyeButton;
//	}
	
	// add button
	@FindBy(xpath = "//ion-fab-button[@id='addBtn']")
	private WebElement fixedAssets_AssetCreation_AddButton;

	public WebElement fixedAssets_AssetCreation_AddButton() {
		return fixedAssets_AssetCreation_AddButton;
	}
	
	// branch code
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[2]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement fixedAssets_AssetCreation_BranchCode;
	
	public WebElement fixedAssets_AssetCreation_BranchCode() {
		return fixedAssets_AssetCreation_BranchCode;
	}
	
	// Asset code
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[6]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement fixedAssets_AssetCreation_AssetCode;
	
	public WebElement fixedAssets_AssetCreation_AssetCode() {
		return fixedAssets_AssetCreation_AssetCode;
	}
	
	// GRN ref no
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[8]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement fixedAssets_AssetCreation_GRN_ReferenceNumber;
	
	public WebElement fixedAssets_AssetCreation_GRN_ReferenceNumber() {
		return fixedAssets_AssetCreation_GRN_ReferenceNumber;
	}
	
	// Bill ref no
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[10]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement fixedAssets_AssetCreation_BillReferenceNumber;
	
	public WebElement fixedAssets_AssetCreation_BillReferenceNumber() {
		return fixedAssets_AssetCreation_BillReferenceNumber;
	}
	
	// asset life unit
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[13]/app-kub-lov/span/ng-select/div/div/div[3]/input")
	private WebElement fixedAssets_AssetCreation_AssetLifeUnit;
	
	public WebElement fixedAssets_AssetCreation_AssetLifeUnit() {
		return fixedAssets_AssetCreation_AssetLifeUnit;
	}
	
	//  External ref no
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[11]/ion-item/ion-input/input")
	private WebElement fixedAssets_AssetCreation_ExternalReferenceNumber;
	
	public WebElement fixedAssets_AssetCreation_ExternalReferenceNumber() {
		return fixedAssets_AssetCreation_ExternalReferenceNumber;
	}
	
	//  fixed asset items
	@FindBy(xpath = "//span[2]/ion-tab-button/ion-label")
	private WebElement fixedAssets_AssetCreation_FixedAssetItems;
	
	public WebElement fixedAssets_AssetCreation_FixedAssetItems() {
		return fixedAssets_AssetCreation_FixedAssetItems;
	}
	
	// Asset item number
	@FindBy(xpath = "//ion-grid[1]/ion-row[1]/ion-col[1]/ion-item/ion-input/input")
	private WebElement fixedAssets_AssetCreation_AssetItemNumber;
	
	public WebElement fixedAssets_AssetCreation_AssetItemNumber() {
		return fixedAssets_AssetCreation_AssetItemNumber;
	}
	
	// asset items description
	@FindBy(xpath = "//ion-grid[1]/ion-row[1]/ion-col[2]/ion-item/ion-input/input")
	private WebElement fixedAssets_AssetCreation_AssetItemDescription;
	
	public WebElement fixedAssets_AssetCreation_AssetItemDescription() {
		return fixedAssets_AssetCreation_AssetItemDescription;
	}
	
	// asset capitalization date
	@FindBy(xpath = "//ion-row[3]/ion-col[1]/app-kub-date-time/ion-item/div/span")
	private WebElement fixedAssets_AssetCreation_AssetCapitalizationDate;
	
	public WebElement fixedAssets_AssetCreation_AssetCapitalizationDate() {
		return fixedAssets_AssetCreation_AssetCapitalizationDate;
	}
	

	//Click on next month 
	@FindBy(xpath = "//owl-date-time-calendar/div/button[2]")
	private WebElement  fixedAssets_AssetCreation_ClickOnNextMonth;
	
	public WebElement fixedAssets_AssetCreation_ClickOnNextMonth() {
		return fixedAssets_AssetCreation_ClickOnNextMonth;
	}
	
	// Salvage Value
	@FindBy(xpath = "//ion-grid[1]/ion-row[4]/ion-col[3]/ion-item/ion-input/input")
	private WebElement fixedAssets_AssetCreation_SalvageValue;
	
	public WebElement fixedAssets_AssetCreation_SalvageValue() {
		return fixedAssets_AssetCreation_SalvageValue;
	}
	
	// HSN Code
	@FindBy(xpath = "//ion-row[3]/ion-col[2]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement fixedAssets_AssetCreation_HSNcode;
	
	public WebElement fixedAssets_AssetCreation_HSNcode() {
		return fixedAssets_AssetCreation_HSNcode;
	}
	
	// Input tax credit value
//	@FindBy(xpath = "//ion-row[6]/ion-col[1]/ion-item/ion-input/input")
//	@FindBy(xpath = "//ion-row[6]/ion-col[1]")
	@FindBy(xpath = "//input[@name='inputTaxCreditVal']")
	private WebElement fixedAssets_AssetCreation_InputTaxCreditValue;
	
	public WebElement fixedAssets_AssetCreation_InputTaxCreditValue() {
		return fixedAssets_AssetCreation_InputTaxCreditValue;
	}
	
	//  asset Value
	@FindBy(xpath = "//ion-grid[1]/ion-row[4]/ion-col[1]/ion-item/ion-input/input")
	private WebElement fixedAssets_AssetCreation_AssetValue;
	
	public WebElement fixedAssets_AssetCreation_AssetValue() {
		return fixedAssets_AssetCreation_AssetValue;
	}
	
	//  Salvage percentage
//	@FindBy(xpath = "//ion-grid[1]/ion-row[4]/ion-col[2]/ion-item/ion-input/input")
	@FindBy(xpath = "//input[@name='salvagePct']")
	private WebElement fixedAssets_AssetCreation_SalvagePercentage;
	
	public WebElement fixedAssets_AssetCreation_SalvagePercentage() {
		return fixedAssets_AssetCreation_SalvagePercentage;
	}
	
	//  Asset Life
	@FindBy(xpath = "//ion-grid[1]/ion-row[5]/ion-col[2]/ion-item/ion-input/input")
	private WebElement fixedAssets_AssetCreation_AssetLife;
	
	public WebElement fixedAssets_AssetCreation_AssetLife() {
		return fixedAssets_AssetCreation_AssetLife;
	}
	
	//  Asset Contract Linkage
	@FindBy(xpath = "//span[3]/ion-tab-button/ion-label")
	private WebElement fixedAssets_AssetCreation_AssetContractLinkage;
	
	public WebElement fixedAssets_AssetCreation_AssetContractLinkage() {
		return fixedAssets_AssetCreation_AssetContractLinkage;
	}
	
	//  PO Reference Number
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[1]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement fixedAssets_AssetCreation_PO_ReferenceNumber;
	
	public WebElement fixedAssets_AssetCreation_PO_ReferenceNumber() {
		return fixedAssets_AssetCreation_PO_ReferenceNumber;
	}
	
	//  Contract Reference Number
	@FindBy(xpath = "//ion-grid[1]/ion-row/ion-col[2]/ion-item/ion-input/input")
	private WebElement fixedAssets_AssetCreation_ContractReferenceNumber;
	
	public WebElement fixedAssets_AssetCreation_ContractReferenceNumber() {
		return fixedAssets_AssetCreation_ContractReferenceNumber;
	}

	//Save Button
	@FindBy(xpath = "(//ion-buttons[2]/ion-button[1])[2]")
	private WebElement fixedAssets_AssetCreation_SaveButton;
	
	public WebElement fixedAssets_AssetCreation_SaveButton() {
		return fixedAssets_AssetCreation_SaveButton;
	}
	
	//Submit Button
	@FindBy(xpath = "//span[contains(text(),'Submit')]")
	private WebElement fixedAssets_AssetCreation_SubmitbuttonInContractLinkage;
	
	public WebElement fixedAssets_AssetCreation_SubmitbuttonInContractLinkage() {
		return fixedAssets_AssetCreation_SubmitbuttonInContractLinkage;
	}
	
	
	//Save fixed assed item Button
	@FindBy(xpath = "(//ion-toolbar[1]/ion-buttons[1]/ion-button[1])[2]")
	private WebElement fixedAssets_AssetCreation_FixedAssetItems_SaveButton;
	
	public WebElement fixedAssets_AssetCreation_FixedAssetItems_SaveButton() {
		return fixedAssets_AssetCreation_FixedAssetItems_SaveButton;
	}
	

	// First eye button [To get Asset Reference Number ]
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[1]/div/ion-buttons/ion-button[1]")
	private WebElement fixedAssets_AssetCreation_CreatedRecordEyeButton;
	
	public WebElement fixedAssets_AssetCreation_CreatedRecordEyeButton() {
		return fixedAssets_AssetCreation_CreatedRecordEyeButton;
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
	@FindBy(xpath="//datatable-row-wrapper[4]//datatable-body-cell[5]//span")
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

	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/124']")
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
	
	
}
