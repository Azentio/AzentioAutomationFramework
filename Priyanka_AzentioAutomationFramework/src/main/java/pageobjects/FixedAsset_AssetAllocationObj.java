package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FixedAsset_AssetAllocationObj {
	WebDriver driver;

	public FixedAsset_AssetAllocationObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	
	// EyeIcon
	@FindBy(xpath = "//ion-button[@ng-reflect-router-link='/tabs/list/datagrid-view/126']")
	private WebElement fixedAsset_AssetAllocation_EyeIcon;

	public WebElement fixedAsset_AssetAllocation_EyeIcon() {
		return fixedAsset_AssetAllocation_EyeIcon;
	}
	
	//Allocation AssetRefferenceNumber
	
	@FindBy(xpath = "//ion-row[1]/ion-col[2]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement fixedAsset_AssetAllocation_AssetRefferenceNumber;

	public WebElement fixedAsset_AssetAllocation_AssetRefferenceNumber() {
		return fixedAsset_AssetAllocation_AssetRefferenceNumber;
	}
	
	//Allocation Item Number
	
	@FindBy(xpath = "//ion-col[5]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement fixedAsset_AssetAllocation_ItemNumber;

	public WebElement fixedAsset_AssetAllocation_ItemNumber() {
		return fixedAsset_AssetAllocation_ItemNumber;
	}
	
	//EmployeeID
	
	@FindBy(xpath = "//ion-grid[1]/ion-row[1]/ion-col[9]/app-kub-lov[1]/span[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
	private WebElement fixedAsset_AssetAllocation_EmployeeID;

	public WebElement fixedAsset_AssetAllocation_EmployeeID() {
		return fixedAsset_AssetAllocation_EmployeeID;
	}	


}
