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
	
	//EyeIcon
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/92']")
	private WebElement fixedAsset_AssetCodeConfiguration_EyeIcon;
	public WebElement fixedAsset_AssetCodeConfiguration_EyeIcon() {
		return fixedAsset_AssetCodeConfiguration_EyeIcon;
	}
	
	
	//AssetCode
	@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]//input")
	private WebElement fixedAsset_AssetCodeConfiguration_AssetCode;
	public WebElement fixedAsset_AssetCodeConfiguration_AssetCode() {
		return fixedAsset_AssetCodeConfiguration_AssetCode;
	}
	
	//AccountingModel
	@FindBy(xpath = "//ion-col[4]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement fixedAsset_AssetCodeConfiguration_AccountingModel;
	public WebElement fixedAsset_AssetCodeConfiguration_AccountingModel() {
		return fixedAsset_AssetCodeConfiguration_AccountingModel;
	}
	
	//AssetLifeUnit
	@FindBy(xpath = "//ion-col[5]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement fixedAsset_AssetCodeConfiguration_AssetLifeUnit;
	public WebElement fixedAsset_AssetCodeConfiguration_AssetLifeUnit() {
		return fixedAsset_AssetCodeConfiguration_AssetLifeUnit;
	}
	//AssetLife
	@FindBy(xpath = "//ion-col[6]/ion-item[1]/ion-input[1]/input")
	private WebElement fixedAsset_AssetCodeConfiguration_AssetLife;
	public WebElement fixedAsset_AssetCodeConfiguration_AssetLife() {
		return fixedAsset_AssetCodeConfiguration_AssetLife;
	}
	
	//BasisForDeperciation
	@FindBy(xpath = "//ion-col[7]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement fixedAsset_AssetCodeConfiguration_BasisForDeperciation;
	public WebElement fixedAsset_AssetCodeConfiguration_BasisForDeperciation() {
		return fixedAsset_AssetCodeConfiguration_BasisForDeperciation;
	}
	//DeperciationMethod
	@FindBy(xpath = "//ion-col[8]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]//input")
	private WebElement fixedAsset_AssetCodeConfiguration_DeperciationMethod;
	public WebElement fixedAsset_AssetCodeConfiguration_DeperciationMethod() {
		return fixedAsset_AssetCodeConfiguration_DeperciationMethod;
	}
	//DeperciationRoundingMethod
	@FindBy(xpath = "//ion-col[9]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement fixedAsset_AssetCodeConfiguration_DeperciationRoundingMethod;
	public WebElement fixedAsset_AssetCodeConfiguration_DeperciationRoundingMethod() {
		return fixedAsset_AssetCodeConfiguration_DeperciationRoundingMethod;
	}
	
	

}
