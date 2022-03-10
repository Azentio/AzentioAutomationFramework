package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FIXEDASSET_AssetReplacementObj {
	WebDriver driver;
	public FIXEDASSET_AssetReplacementObj(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/124']")
	private WebElement fixedAsset_AssetReplacementViewButton;
	public WebElement fixedAssetAAssetReplacementViewButton()
	{
		return fixedAsset_AssetReplacementViewButton;
	}
	@FindBy(xpath="//ion-col[2]//input")
	private WebElement fixedAssetAssetReplacementRaferenceNumber;
	public WebElement fixedAssetReplacementReferenceNumber()
	{
		return fixedAssetAssetReplacementRaferenceNumber;
	}
	@FindBy(xpath="//ion-col[5]//input")
	private WebElement fixedAssetAssetReplacementItemNumber;
	public WebElement fixedAssetReplacementItemNumber()
	{
		return fixedAssetAssetReplacementItemNumber;
	}
	@FindBy(xpath="//ion-col[8]//input")
	private WebElement fixedAssetAssetReplacementNewItemNumber;
	public WebElement fixedAssetReplacementNewItemNumber()
	{
		return fixedAssetAssetReplacementNewItemNumber;
	}
	@FindBy(xpath="//ion-col[9]//input")
	private WebElement fixedAssetAssetReplacementNewDescription;
	public WebElement fixedAssetReplacementNewDescription()
	{
		return fixedAssetAssetReplacementNewDescription;
	}
	
	//@FindBy(xpath="//page-asset-replacement-update//ion-toolbar[1]//ion-buttons[2]//ion-button[1]")
@FindBy(xpath="//page-asset-replacement-update//ion-buttons[2]//ion-button")
private WebElement fixedAssetAssetReplacementSaveButton;
public WebElement fixedAssetReplacementSaveButton()
{
	return fixedAssetAssetReplacementSaveButton;
}
}
