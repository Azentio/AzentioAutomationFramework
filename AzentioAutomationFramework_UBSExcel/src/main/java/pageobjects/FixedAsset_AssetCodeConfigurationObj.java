package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FixedAsset_AssetCodeConfigurationObj {

	WebDriver driver;

	public FixedAsset_AssetCodeConfigurationObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// EyeIcon
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/92']")
	private WebElement fixedAsset_AssetCodeConfiguration_EyeIcon;

	public WebElement fixedAsset_AssetCodeConfiguration_EyeIcon() {
		return fixedAsset_AssetCodeConfiguration_EyeIcon;
	}

	// AssetCodeSelected from asset category view list
	@FindBy(xpath = "//datatable-row-wrapper[1]/datatable-body-row/div[2]/datatable-body-cell[2]/div/span")
	private WebElement fixedAsset_AssetCodeConfiguration_AssetCodeSelect;

	public WebElement fixedAsset_AssetCodeConfiguration_AssetCodeSelect() {
		return fixedAsset_AssetCodeConfiguration_AssetCodeSelect;
	}

	// AssetCode
	@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]//input")
	private WebElement fixedAsset_AssetCodeConfiguration_AssetCode;

	public WebElement fixedAsset_AssetCodeConfiguration_AssetCode() {
		return fixedAsset_AssetCodeConfiguration_AssetCode;
	}

	// AccountingModel
	@FindBy(xpath = "//ion-col[4]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement fixedAsset_AssetCodeConfiguration_AccountingModel;

	public WebElement fixedAsset_AssetCodeConfiguration_AccountingModel() {
		return fixedAsset_AssetCodeConfiguration_AccountingModel;
	}

	// AssetLifeUnit
	@FindBy(xpath = "//ion-col[5]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement fixedAsset_AssetCodeConfiguration_AssetLifeUnit;

	public WebElement fixedAsset_AssetCodeConfiguration_AssetLifeUnit() {
		return fixedAsset_AssetCodeConfiguration_AssetLifeUnit;
	}

	// AssetLife
	@FindBy(xpath = "//ion-col[6]/ion-item[1]/ion-input[1]/input")
	private WebElement fixedAsset_AssetCodeConfiguration_AssetLife;

	public WebElement fixedAsset_AssetCodeConfiguration_AssetLife() {
		return fixedAsset_AssetCodeConfiguration_AssetLife;
	}

	// BasisForDeperciation
	@FindBy(xpath = "//ion-col[7]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement fixedAsset_AssetCodeConfiguration_BasisForDeperciation;

	public WebElement fixedAsset_AssetCodeConfiguration_BasisForDeperciation() {
		return fixedAsset_AssetCodeConfiguration_BasisForDeperciation;
	}

	// DeperciationMethod
	@FindBy(xpath = "//ion-col[8]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]//input")
	private WebElement fixedAsset_AssetCodeConfiguration_DeperciationMethod;

	public WebElement fixedAsset_AssetCodeConfiguration_DeperciationMethod() {
		return fixedAsset_AssetCodeConfiguration_DeperciationMethod;
	}

	// DeperciationRoundingMethod
	@FindBy(xpath = "//ion-col[9]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement fixedAsset_AssetCodeConfiguration_DeperciationRoundingMethod;

	public WebElement fixedAsset_AssetCodeConfiguration_DeperciationRoundingMethod() {
		return fixedAsset_AssetCodeConfiguration_DeperciationRoundingMethod;
	}

	@FindBy(xpath = "//datatable-row-wrapper[1]//span[text()='ASSET_CODE_CONFIG']//ancestor::datatable-body-cell//preceding-sibling::datatable-body-cell[1]//span")
	private WebElement assetCodeConfig_AssetCodeConfigNotificationRecordReferenceNo;

	public WebElement assetCodeConfigNotificationRecordReferenceNo() {
		return assetCodeConfig_AssetCodeConfigNotificationRecordReferenceNo;
	}

	@FindBy(xpath = "//datatable-row-wrapper[1]//span[text()='ASSET_CODE_CONFIG']//ancestor::datatable-body-cell//preceding-sibling::datatable-body-cell[2]//ion-button")
	private WebElement assetCodeConfig_AssetCodeConfigNotificationRecord;

	public WebElement assetCodeConfigNotificationRecord() {
		return assetCodeConfig_AssetCodeConfigNotificationRecord;
	}
	@FindBy(xpath="//datatable-row-wrapper[1]//datatable-body-cell[2]//span")
	private WebElement assetCodeConfig_ListViewApprovedAssetRecord;

	public WebElement assetCodeConfigListViewApprovedAssetRecord() {
		return assetCodeConfig_ListViewApprovedAssetRecord;
	}
	@FindBy(xpath="//datatable-row-wrapper[1]//datatable-body-cell[4]//span")
	private WebElement assetCodeConfig_ListViewApprovedAssetDepriciationType;

	public WebElement assetCodeConfigListViewApprovedAssetDepriciationType() {
		return assetCodeConfig_ListViewApprovedAssetDepriciationType;
	}
	@FindBy(xpath="//label[contains(text(),' Depreciation Method ')]//following-sibling::ng-select//input")
	private WebElement assetCodeReport_DepriciationMethod;

	public WebElement assetCodeReportDepriciationMethod() {
		return assetCodeReport_DepriciationMethod;
	}
	@FindBy(xpath="//span[@class='input-calendar']")
	private WebElement assetCodeReport_AssetCodeAsOndate;

	public WebElement assetCodeReportAssetCodeAsOndate() {
		return assetCodeReport_AssetCodeAsOndate;
	}
	
	

}
