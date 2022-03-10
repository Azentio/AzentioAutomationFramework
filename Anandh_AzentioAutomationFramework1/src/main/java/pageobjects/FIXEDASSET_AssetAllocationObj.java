package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FIXEDASSET_AssetAllocationObj {
	WebDriver driver;
	public FIXEDASSET_AssetAllocationObj(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath="//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/126']")
private WebElement fixedAsset_AssetAllocationView;
public WebElement fixedAssetAssetAllocationView()
{
	return fixedAsset_AssetAllocationView;
}
@FindBy(xpath="//page-fixed-asset-allocation-update//ion-col[2]//input")
private WebElement fixedAsset_AssetAllocationReferenceNumber;
public WebElement fixedAssetAssetAllocationReferenceNumber()
{
	return fixedAsset_AssetAllocationReferenceNumber;
}
@FindBy(xpath="//page-fixed-asset-allocation-update//ion-col[5]//input")
private WebElement fixedAsset_AssetAllocationItemNumber;
public WebElement fixedAssetAssetAllocationItemNumber()
{
	return fixedAsset_AssetAllocationItemNumber;
}
@FindBy(xpath="//page-fixed-asset-allocation-update//ion-col[9]//input")
private WebElement fixedAsset_AssetAllocationEmployeeNumber;
public WebElement fixedAsset_AssetAllocationEmployeeName()
{
	return fixedAsset_AssetAllocationEmployeeNumber;
}
@FindBy(xpath="//page-fixed-asset-allocation-update//ion-toolbar[1]//ion-buttons[2]//ion-button")
private WebElement fixedAsset_AssetAllocationSaveButton;
public WebElement fixedAssetAssetAllocationSaveButton()
{
	return fixedAsset_AssetAllocationSaveButton;
}
}
