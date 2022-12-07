package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KUBS_FixedAsssetTransferObj {
	WebDriver driver;
	public KUBS_FixedAsssetTransferObj(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//ion-label[text()=' Asset transfer ']//following-sibling::ion-buttons//ion-button[1]")
	private WebElement fixedAsset_AssetTransferTempView;
	public WebElement fixedAssetTransferTempView()
	{
		return fixedAsset_AssetTransferTempView;
	}
	@FindBy(xpath="//ion-label[text()=' Asset transfer ']//following-sibling::ion-buttons//ion-button[2]")
	private WebElement fixedAsset_AssetTransferViewIcon;
	public WebElement fixedAssetAssetTransferViewIcon()
	{
		return fixedAsset_AssetTransferViewIcon;
	}
	@FindBy(xpath="//ion-icon[@ng-reflect-name='add']")
	private WebElement fixedAssetTransfer_AddButton;
	public WebElement fixedAssetTransferAddButton()
	{
		return fixedAssetTransfer_AddButton;
	}
	@FindBy(xpath="//label[text()=' Asset Reference Number ']//following-sibling::ng-select//input")
	private WebElement fixedAsset_AssetTransferAssetReferenceNumber;
	public WebElement  fixedAssetAssetTransferAssetReferenceNumber()
	{
		return fixedAsset_AssetTransferAssetReferenceNumber;
	}
	@FindBy(xpath="//label[text()=' New Branch ']//following-sibling::ng-select//input")
	private WebElement fixedAsset_AssetTransferNewBranch;
	public WebElement fixedAssetAssetTransferNewBranch()
	{
		return fixedAsset_AssetTransferNewBranch;
	}
	@FindBy(xpath="//datatable-row-wrapper[1]//datatable-body-cell[6]//ion-select")
	private WebElement fixedAsset_AssetTransferDropdown;
	public WebElement fixedAssetAssetTransferTransDropdown()
	{
		return fixedAsset_AssetTransferDropdown;
	}
	@FindBy(xpath="//ion-label[text()=' YES ']//following-sibling::ion-radio")
	private WebElement fixedAsset_TrasferYesOption;
	public WebElement fixedAssetTransferYesOption()
	{
		return fixedAsset_TrasferYesOption;
	}
	@FindBy(xpath="//app-kub-decision-button[@eventcode='FIXED_ASSET_TRANSFER']//parent::ion-buttons//ion-button")
	private WebElement assetTransfer_SaveButton;
	public WebElement assetTransferSaveButton()
	{
		return assetTransfer_SaveButton;
	}
	
	@FindBy(xpath="//datatable-row-wrapper[1]//datatable-body-cell[6]//span")
	private WebElement assetCreation_NewAssetReferenceNumber;
	public WebElement assetCreationNewAssetReferenceNumber()
	{
		return assetCreation_NewAssetReferenceNumber;
	}

}
