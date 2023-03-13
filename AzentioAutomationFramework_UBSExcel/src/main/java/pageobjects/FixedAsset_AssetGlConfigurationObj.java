package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FixedAsset_AssetGlConfigurationObj {
	
	WebDriver driver;

	public FixedAsset_AssetGlConfigurationObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	//EyeIcon
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/93']")
	private WebElement fixedAsset_AssetGlConfiguration_EyeIcon;
	public WebElement fixedAsset_AssetGlConfiguration_EyeIcon() {
		return fixedAsset_AssetGlConfiguration_EyeIcon;
	}
	@FindBy(xpath="//input[@placeholder='Search Asset Code']")
	private WebElement AssetGlConfiguration_SearchAssetCode;
	public WebElement AssetGlConfigurationSearchAssetCode() {
		return AssetGlConfiguration_SearchAssetCode;
	}
	@FindBy(xpath="//datatable-row-wrapper[1]//datatable-body-cell[3]//span")
	private WebElement AssetGlConfiguration_ApprovedGlCode;
	public WebElement AssetGlConfigurationApprovedGlCode() {
		return AssetGlConfiguration_ApprovedGlCode;
	}
	
	
	//AssetCode
	@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement fixedAsset_AssetGlConfiguration_AssetCode;
	public WebElement fixedAsset_AssetGlConfiguration_AssetCode() {
		return fixedAsset_AssetGlConfiguration_AssetCode;
	}
	
	//FixedAssetGL
	@FindBy(xpath = "//ion-col[3]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]//input")
	private WebElement fixedAsset_AssetGlConfiguration_FixedAssetGL;
	public WebElement fixedAsset_AssetGlConfiguration_FixedAssetGL() {
		return fixedAsset_AssetGlConfiguration_FixedAssetGL;
	}
	
	//AccumulatedDepreciationGL
	@FindBy(xpath = "//ion-col[4]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]//input")
	private WebElement fixedAsset_AssetGlConfiguration_AccumulatedDepreciationGL;
	public WebElement fixedAsset_AssetGlConfiguration_AccumulatedDepreciationGL() {
		return fixedAsset_AssetGlConfiguration_AccumulatedDepreciationGL;
	}
	//DepreciationGL
	@FindBy(xpath = "//ion-col[5]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]//input")
	private WebElement fixedAsset_AssetGlConfiguration_DepreciationGL;
	public WebElement fixedAsset_AssetGlConfiguration_DepreciationGL() {
		return fixedAsset_AssetGlConfiguration_DepreciationGL;
	}
	//ProfitOnSaleGL
	@FindBy(xpath = "//ion-col[6]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]//input")
	private WebElement fixedAsset_AssetGlConfiguration_ProfitOnSaleGL;
	public WebElement fixedAsset_AssetGlConfiguration_ProfitOnSaleGL() {
		return fixedAsset_AssetGlConfiguration_ProfitOnSaleGL;
	}
	//lossOnSaleGL
	@FindBy(xpath = "//ion-col[7]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]//input")
	private WebElement fixedAsset_AssetGlConfiguration_lossOnSaleGL;
	public WebElement fixedAsset_AssetGlConfiguration_lossOnSaleGL() {
		return fixedAsset_AssetGlConfiguration_lossOnSaleGL;
	}
	//WriteOffGL
	@FindBy(xpath = "//ion-col[8]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]//input")
	private WebElement fixedAsset_AssetGlConfiguration_WriteOffGL;
	public WebElement fixedAsset_AssetGlConfiguration_WriteOffGL() {
		return fixedAsset_AssetGlConfiguration_WriteOffGL;
	}
	//ImpairmentLossGL
	@FindBy(xpath = "//ion-col[9]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]//input")
	private WebElement fixedAsset_AssetGlConfiguration_ImpairmentLossGL;
	public WebElement fixedAsset_AssetGlConfiguration_ImpairmentLossGL() {
		return fixedAsset_AssetGlConfiguration_ImpairmentLossGL;
	}
	//AccumulatedImpairmentLossGL
	@FindBy(xpath = "//ion-col[10]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]//input")
	private WebElement fixedAsset_AssetGlConfiguration_AccumulatedImpairmentLossGL;
	public WebElement fixedAsset_AssetGlConfiguration_AccumulatedImpairmentLossGL() {
		return fixedAsset_AssetGlConfiguration_AccumulatedImpairmentLossGL;
	}
	//RevaluationSurplusGL
	@FindBy(xpath = "//ion-col[11]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]//input")
	private WebElement fixedAsset_AssetGlConfiguration_RevaluationSurplusGL;
	public WebElement fixedAsset_AssetGlConfiguration_RevaluationSurplusGL() {
		return fixedAsset_AssetGlConfiguration_RevaluationSurplusGL;
	}
 //---------------Report---------------------------//
	
	//AssetSaleReport x-path
	@FindBy(xpath = "//ion-list[1]/div[1]/ion-menu-toggle[7]/ion-item[1]/ion-buttons[1]/ion-button[1]")
	private WebElement fixedAsset_AssetSaleReport;
	public WebElement fixedAsset_AssetSaleReport() {
		return fixedAsset_AssetSaleReport;
	}
	//AssetSaleCode
	@FindBy(xpath = "//ion-row[1]/ion-col[1]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement fixedAsset_AssetSaleCode;
	public WebElement fixedAsset_AssetSaleCode() {
		return fixedAsset_AssetSaleCode;
	}
	// CalendarFromDate
	@FindBy(xpath = "(//span[@class='input-calendar'])[1]")
	private WebElement fixedAsset_CalendarFromDate;

	public WebElement fixedAsset_CalendarFromDate() {
		return fixedAsset_CalendarFromDate;
	}

	// NextMonth
	@FindBy(xpath = "(//button[@type='button'])[3]")
	private WebElement fixedAsset_NextMonth;

	public WebElement fixedAsset_NextMonth() {
		return fixedAsset_NextMonth;
	}
	
	@FindBy(xpath = "//datatable-row-wrapper[1]//span[text()='ASSET_GL_CONFIG']//ancestor::datatable-body-cell//preceding-sibling::datatable-body-cell[1]//span")
	private WebElement assetCodeConfig_AssetGLConfigNotificationRecordReferenceNo;

	public WebElement assetCodeConfigAssetGLConfigNotificationRecordReferenceNo() {
		return assetCodeConfig_AssetGLConfigNotificationRecordReferenceNo;
	}

	@FindBy(xpath = "//datatable-row-wrapper[1]//span[text()='ASSET_GL_CONFIG']//ancestor::datatable-body-cell//preceding-sibling::datatable-body-cell[2]//ion-button")
	private WebElement assetCodeConfig_AssetGLConfigNotificationRecord;

	public WebElement assetCodeConfigAssetGLConfigNotificationRecord() {
		return assetCodeConfig_AssetGLConfigNotificationRecord;
	}
	@FindBy(xpath="//datatable-row-wrapper[1]//datatable-body-cell[2]//span")
	private WebElement assetCodeConfig_AssetGLApprovedAssetCode;

	public WebElement assetCodeConfigAssetGLApprovedAssetCode() {
		return assetCodeConfig_AssetGLApprovedAssetCode;
	}
	@FindBy(xpath="//label[contains(text(),' Asset Code ')]//following-sibling::ng-select//input")
	private WebElement assetCodeConfig_AssetGLReportAssetCode;

	public WebElement assetCodeConfigAssetGLReportAssetCode() {
		return assetCodeConfig_AssetGLReportAssetCode;
	}
	@FindBy(xpath="//span[@class='input-calendar']")
	private WebElement assetCodeConfig_AssetGLReportAssetCodeAsOnDate;

	public WebElement assetCodeConfigAssetGLReportAssetCodeAsOnDate() {
		return assetCodeConfig_AssetGLReportAssetCodeAsOnDate;
	}
	
}
