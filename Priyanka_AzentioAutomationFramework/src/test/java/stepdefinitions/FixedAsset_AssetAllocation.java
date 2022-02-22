package stepdefinitions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataProvider.JsonConfig;
import helper.ClicksAndActionsHelper;
import helper.WaitHelper;
import io.cucumber.java.en.Then;
import pageobjects.FixedAsset_AssetAllocationObj;
import resources.BaseClass;
import testDataType.FixedAsset_AssetAllocationTestDataType;

public class FixedAsset_AssetAllocation extends BaseClass {

	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver);
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	FixedAsset_AssetAllocationObj fixedAsset_AssetAllocationObj = new FixedAsset_AssetAllocationObj(driver);
	FixedAsset_AssetAllocationTestDataType fixedAsset_AssetAllocationTestDataType = new FixedAsset_AssetAllocationTestDataType();
	
	@Then("^Click on Asset Allocation Eye button$")
    public void click_on_asset_allocation_eye_button()  {
		
	WebElement eye = waithelper.waitForElement(driver, 2000, fixedAsset_AssetAllocationObj.fixedAsset_AssetAllocation_EyeIcon());
	clicksAndActionHelper.moveToElement(eye);
	fixedAsset_AssetAllocationObj.fixedAsset_AssetAllocation_EyeIcon().click();
       
    }

	
	@Then("^Fill Asset Allocation Form$")
    public void fill_asset_allocation_form() throws InterruptedException {
		
		fixedAsset_AssetAllocationTestDataType = jsonReader.getAssetAllocationByName("Maker");
		
    	waithelper.waitForElement(driver, 2000, fixedAsset_AssetAllocationObj.fixedAsset_AssetAllocation_AssetRefferenceNumber());
    	fixedAsset_AssetAllocationObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().click();
    	fixedAsset_AssetAllocationObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(fixedAsset_AssetAllocationTestDataType.AssetReferenceNumber);
    	fixedAsset_AssetAllocationObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        
    	waithelper.waitForElement(driver, 2000, fixedAsset_AssetAllocationObj.fixedAsset_AssetAllocation_ItemNumber());
    	fixedAsset_AssetAllocationObj.fixedAsset_AssetAllocation_ItemNumber().click();
    	fixedAsset_AssetAllocationObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(fixedAsset_AssetAllocationTestDataType.ItemNumber);
    	fixedAsset_AssetAllocationObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(Keys.ENTER);
    	Thread.sleep(2000); 
    	
    	waithelper.waitForElement(driver, 2000, fixedAsset_AssetAllocationObj.fixedAsset_AssetAllocation_EmployeeID());
    	fixedAsset_AssetAllocationObj.fixedAsset_AssetAllocation_EmployeeID().click();
    	fixedAsset_AssetAllocationObj.fixedAsset_AssetAllocation_EmployeeID().sendKeys(fixedAsset_AssetAllocationTestDataType.EmployeeID);
    	fixedAsset_AssetAllocationObj.fixedAsset_AssetAllocation_EmployeeID().sendKeys(Keys.ENTER);
    	Thread.sleep(2000);
	}


}
