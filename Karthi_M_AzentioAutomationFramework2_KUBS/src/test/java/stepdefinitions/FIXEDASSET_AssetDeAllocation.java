package stepdefinitions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataProvider.JsonConfig;
import helper.ClicksAndActionsHelper;
import helper.WaitHelper;
import io.cucumber.java.en.Then;
import pageobjects.FIXED_ASSET_AssetDeAllocationObj;
import resources.BaseClass;
import testDataType.FIXEDASSET_AixedAssetDeAllocationTestData;

public class FIXEDASSET_AssetDeAllocation extends BaseClass {

		WebDriver driver = BaseClass.driver;
		JsonConfig jsonReader = new JsonConfig();
		WaitHelper waithelper = new WaitHelper(driver) ;
		
		
		FIXEDASSET_AixedAssetDeAllocationTestData fixedAsset_AssetDeallocationTestDataType = jsonReader.getAssetDeallocationByName("Maker");

		



}
