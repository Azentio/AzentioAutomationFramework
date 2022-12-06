package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FIXED_ASSET_AssetDeAllocationObj {
	WebDriver driver;

	public FIXED_ASSET_AssetDeAllocationObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	//Direction
	@FindBy(xpath = "//ion-segment/ion-segment-button[2]")
	private WebElement fixedAsset_AssetDeallocation_DirectionIcon;
	public WebElement fixedAsset_AssetDeallocation_DirectionIcon() {
			return fixedAsset_AssetDeallocation_DirectionIcon;
	}
	
	//Fixed assets
	@FindBy(xpath = "//ion-label[contains(text(),'Fixed assets')]")
	private WebElement fixedAsset_AssetDeallocation_FixedAssetsField;
	public WebElement fixedAsset_AssetDeallocation_FixedAssetsField() {
			return fixedAsset_AssetDeallocation_FixedAssetsField;
		}

	
	//EyeIcon
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/120']")
	private WebElement fixedAsset_AssetDeallocation_EyeIcon;
	public WebElement fixedAsset_AssetDeallocation_EyeIcon() {
		return fixedAsset_AssetDeallocation_EyeIcon;
	}
	
	
	//AssetReferenceNumber
	@FindBy(xpath = "//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement fixedAsset_AssetDeallocation_AssetReferenceNumber;
	public WebElement fixedAsset_AssetDeallocation_AssetReferenceNumber() {
		return fixedAsset_AssetDeallocation_AssetReferenceNumber;
	}
	//ItemNumber
	@FindBy(xpath = "//ion-col[5]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input")
	private WebElement fixedAsset_AssetDeallocation_ItemNumber;
	public WebElement fixedAsset_AssetDeallocation_ItemNumber() {
		return fixedAsset_AssetDeallocation_ItemNumber;
	}
    @FindBy(xpath="(//ion-toolbar[1]/ion-buttons[2]/ion-button[1])[2]")
    private WebElement fixedAsset_AssetDeallocationSaveButton;
    public WebElement fixedAssetDeAllocationSaveButton()
    {
    	return fixedAsset_AssetDeallocationSaveButton;
    }
    @FindBy(xpath="//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]//span[2]")
    private WebElement fixedAsset_AssetDeallocationRefNo;
    public WebElement getReferenceNumberOfDeAllocation()
    {
    	return fixedAsset_AssetDeallocationRefNo;
    }

}
