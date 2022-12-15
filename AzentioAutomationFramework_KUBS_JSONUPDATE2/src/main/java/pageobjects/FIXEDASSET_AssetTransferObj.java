package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FIXEDASSET_AssetTransferObj {
	WebDriver driver;
	public FIXEDASSET_AssetTransferObj(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/114']")
    private WebElement fixedAsset_TransferViewButton;
	public WebElement fixedAssetAssetTransferViewButton()
	{
		return fixedAsset_TransferViewButton;
	}
	@FindBy(xpath="//ion-grid[1]/ion-row/ion-col[2]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement fixedAsset_AssetTransferReferenceNumber;
	public WebElement fixedAssetAssetTransferReferenceNumber()
	{
		return fixedAsset_AssetTransferReferenceNumber;
	}
	@FindBy(xpath="//ion-grid[1]/ion-row/ion-col[3]/app-kub-lov/span/ng-select/div/div/div[2]/input")
	private WebElement fixedAsset_AssetTransferBranch;
	public WebElement fixedAssetAssetTransferBranch()
	{
		return fixedAsset_AssetTransferBranch;
	}
	@FindBy(xpath="//datatable-body-cell/div/app-kub-lov/ion-select")
	private WebElement fixedAsset_TransferButton;
	public WebElement fixedAssetTransferButton()
	{
		return fixedAsset_TransferButton;
	}
	@FindBy(xpath="//page-fixed-asset-transfer-update//ion-toolbar//ion-buttons[2]//ion-button")
	private WebElement fixedAsset_TransferSaveButton;
	public WebElement fixedAssetTransferSaveButton()
	{
		return fixedAsset_TransferSaveButton;
	}	
	@FindBy(xpath="//ion-item[2]/ion-radio")
	private WebElement fixedAsset_TransferYes;
	public WebElement fixedAssetTransferYes()
	{
		return fixedAsset_TransferYes;
	}
	@FindBy(xpath = "//div[@id='toast-container']/div/div[@role='alertdialog']")
	private WebElement transfer_reviewer_id;

	public WebElement TransferReviewerId() {
		return transfer_reviewer_id;
	}
	@FindBy(xpath="//div[@id='toast-container']//button")
	private WebElement transfer_alert_close;
	public WebElement transferAlertClose()
	{
		return transfer_alert_close;
	}
	@FindBy(xpath="//page-fixed-asset-undertaking-temp-update[1]/div[1]/ion-header[1]/ion-toolbar[1]/ion-buttons[2]/ion-button[1]")
	private WebElement transferSaveSecondReviewer;
	public WebElement transferSecondReviewer()
	{
		return transferSaveSecondReviewer;
	}
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/118']")
	private WebElement assetUndertaking_ViewButton;
	public WebElement assetUndertakingViewButton()
	{
		return assetUndertaking_ViewButton;
	}
	@FindBy(xpath="//input[@placeholder='Search Refernce No']")
	private WebElement searchunderTaking_AssetReferenceNumber;
	public WebElement searchUndertakingAssetReferenceNumber()
	{
		return searchunderTaking_AssetReferenceNumber;
	}
	@FindBy(xpath="//datatable-row-wrapper[1]//datatable-body-cell[1]//ion-button[1]")
	private WebElement approvedUndertaking_record;
	public WebElement undertakingApprovedRecord()
	{
		return approvedUndertaking_record;
	}
	@FindBy(xpath="//datatable-row-wrapper[1]//datatable-body-cell[4]//span")
	private WebElement undertaking_ApprovedAssetCode;
	public WebElement underTakingApprovedAssetCode()
	{
		return undertaking_ApprovedAssetCode;
	}
	@FindBy(xpath="//datatable-row-wrapper[1]//datatable-body-cell[6]//span")
	private WebElement undertaking_TransferedBranch;
	public WebElement underTakingTransferedBranch()
	{
		return undertaking_TransferedBranch;
	}
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/70']")
	private WebElement config_BranchEntityMaintenece;
	public WebElement configBranchEntityMaintenence()
	{
		return config_BranchEntityMaintenece;
	}
	@FindBy(xpath="//input[@placeholder='Search Description']")
	private WebElement config_entityMaintenece_Description;
	public WebElement configEntityMainteneceDescription()
	{
		return config_entityMaintenece_Description;
	}
	@FindBy(xpath="//datatable-row-wrapper[1]//datatable-body-cell[3]//span")
	private WebElement config_getBranchCode;
	public WebElement configgetBranchCode()
	{
		return config_getBranchCode;
	}
	@FindBy(xpath="//ion-label[contains(text(),'Entity maintenance')]")
	private WebElement ConfigEntity_MainteneceMain;
	public WebElement configEntityMainteneceMain()
	{
		return ConfigEntity_MainteneceMain;
	}
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/91']")
	private WebElement fixedAsset_serialNumber;
	public WebElement fixedAssetSerailNumber()
	{
		return fixedAsset_serialNumber;
	}
	@FindBy(xpath="//input[@placeholder='Search Asset Code']")
	private WebElement search_AssetCode;
	public WebElement serachAssetCode()
	{
		return search_AssetCode;
	}
	
	@FindBy(xpath="//datatable-row-wrapper[1]//datatable-body-cell[4]//span")
	private WebElement assetSerialNumber_getLastSerailNumber;
	public WebElement assetSerailNumberGetLastSerailNumber()
	{
		return assetSerialNumber_getLastSerailNumber;
	}
	
	
	
}
