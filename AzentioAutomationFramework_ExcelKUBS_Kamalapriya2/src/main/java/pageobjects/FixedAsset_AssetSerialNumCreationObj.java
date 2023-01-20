package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FixedAsset_AssetSerialNumCreationObj {
	WebDriver driver;

	public FixedAsset_AssetSerialNumCreationObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// EyeIcon
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/91']")
	private WebElement fixedAsset_AssetSerialNumCreation_EyeIcon;

	public WebElement fixedAsset_AssetSerialNumCreation_EyeIcon() {
		return fixedAsset_AssetSerialNumCreation_EyeIcon;
	}

	// Search icon
	@FindBy(xpath = "//ion-icon[@title='Enable Search']")
	private WebElement fixedAsset_AssetSerialNumCreation_SearchIcon;

	public WebElement fixedAsset_AssetSerialNumCreation_SearchIcon() {
		return fixedAsset_AssetSerialNumCreation_SearchIcon;
	}

	// Asset Code
	@FindBy(xpath = "//datatable-header-cell[2]/div[1]/ion-input[1]/input")
	private WebElement fixedAsset_AssetSerialNumCreation_AssetCode;

	public WebElement fixedAsset_AssetSerialNumCreation_AssetCode() {
		return fixedAsset_AssetSerialNumCreation_AssetCode;
	}

	// Pencil icon
	@FindBy(xpath = "//datatable-body-cell/div[1]/ion-buttons[1]/ion-button[2]")
	private WebElement fixedAsset_AssetSerialNumCreation_PencilIcon;

	public WebElement fixedAsset_AssetSerialNumCreation_PencilIcon() {
		return fixedAsset_AssetSerialNumCreation_PencilIcon;
	}

	// StartSerialNumber
	@FindBy(xpath = "//ion-col[1]/ion-item[1]/ion-input[1]/input")
	private WebElement fixedAsset_AssetSerialNumCreation_StartSerialNumber;

	public WebElement fixedAsset_AssetSerialNumCreation_StartSerialNumber() {
		return fixedAsset_AssetSerialNumCreation_StartSerialNumber;
	}

	@FindBy(xpath = "//datatable-row-wrapper[1]//span[text()='ASSET_SR_NO']//ancestor::datatable-body-cell//preceding-sibling::datatable-body-cell[1]//span")
	private WebElement assetSerialNumber_ReferenceNumber;

	public WebElement assetSerialNumberReferenceNumber() {
		return assetSerialNumber_ReferenceNumber;
	}

	@FindBy(xpath = "//datatable-row-wrapper[1]//span[text()='ASSET_SR_NO']//ancestor::datatable-body-cell//preceding-sibling::datatable-body-cell[2]//ion-button")
	private WebElement assetSerialNumber_NotificationFirstRecord;

	public WebElement assetSerialNumberNotificationFirstRecord() {
		return assetSerialNumber_NotificationFirstRecord;
	}

}
