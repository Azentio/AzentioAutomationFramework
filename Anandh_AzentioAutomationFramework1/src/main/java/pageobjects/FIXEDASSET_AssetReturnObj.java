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

	@FindBy(xpath = "(//ion-toolbar[1]/ion-buttons[2]/ion-button[1])[2]")
	private WebElement fixed_return_save_button;

	public WebElement fixetReturnSaveButton() {
		return fixed_return_save_button;

	}
	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/125']")
	private WebElement fixedAsset_assetReturn;
	public WebElement fixedAssetAssetReturnViewButton()
	{
		return fixedAsset_assetReturn;
	}
	@FindBy(xpath="//ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/span[2]")
	private WebElement fixed_asset_get_asset_referece_no;
	public WebElement fixedAssetGetReferenceNo()
	{
		return fixed_asset_get_asset_referece_no;
	}
	 @FindBy(xpath="//i[@class='datatable-icon-right']")
	    private WebElement fixed_asset_next_button;
	    public WebElement fixedAssetNextButton()
	    {
	    	return fixed_asset_next_button;
	    }
}
