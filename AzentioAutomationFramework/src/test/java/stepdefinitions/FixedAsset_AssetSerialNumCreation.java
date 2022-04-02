package stepdefinitions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataProvider.JsonConfig;
import helper.ClicksAndActionsHelper;
import helper.WaitHelper;
import io.cucumber.java.en.Then;
import pageobjects.FixedAsset_AssetSerialNumCreationObj;
import resources.BaseClass;
import testDataType.FixedAsset_AssetCategoryTestDataType;

public class FixedAsset_AssetSerialNumCreation extends BaseClass {
	
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver) ;
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	FixedAsset_AssetSerialNumCreationObj fixedAsset_AssetSerialNumCreationObj = new FixedAsset_AssetSerialNumCreationObj(driver);
	FixedAsset_AssetCategoryTestDataType fixedAsset_AssetCategoryTestDataType = new FixedAsset_AssetCategoryTestDataType();

	
	
	@Then("^Click on Asset Serial Num Creation Eye button$")
    public void click_on_asset_serial_num_creation_eye_button()  {
	//Eye Button
	WebElement eye = waithelper.waitForElement(driver, 4000,  fixedAsset_AssetSerialNumCreationObj.fixedAsset_AssetSerialNumCreation_EyeIcon());
	clicksAndActionHelper.moveToElement(eye);
	fixedAsset_AssetSerialNumCreationObj.fixedAsset_AssetSerialNumCreation_EyeIcon().click();
		
        
    }

    @Then("^Click on Asset Serial Num Creation Search icon$")
    public void click_on_asset_serial_num_creation_search_icon()  {
    waithelper.waitForElement(driver, 4000,  fixedAsset_AssetSerialNumCreationObj.fixedAsset_AssetSerialNumCreation_SearchIcon());
    fixedAsset_AssetSerialNumCreationObj.fixedAsset_AssetSerialNumCreation_SearchIcon().click();
    	
        
    }

    @Then("^Enter Asset code$")
    public void enter_asset_code()  {
    fixedAsset_AssetCategoryTestDataType = jsonReader.getAssetCategoryByName("Maker");	
    //Asset code
    	
    waithelper.waitForElement(driver, 4000,  fixedAsset_AssetSerialNumCreationObj.fixedAsset_AssetSerialNumCreation_AssetCode());
    fixedAsset_AssetSerialNumCreationObj.fixedAsset_AssetSerialNumCreation_AssetCode().click();
    fixedAsset_AssetSerialNumCreationObj.fixedAsset_AssetSerialNumCreation_AssetCode().sendKeys(fixedAsset_AssetCategoryTestDataType.AssetCode);
    fixedAsset_AssetSerialNumCreationObj.fixedAsset_AssetSerialNumCreation_AssetCode().sendKeys(Keys.ENTER);
    
    	    
        
    }

    @Then("^Click on the record$")
    public void click_on_the_record()  {
    //Pencil
    	
     waithelper.waitForElement(driver, 4000,  fixedAsset_AssetSerialNumCreationObj.fixedAsset_AssetSerialNumCreation_PencilIcon());
     fixedAsset_AssetSerialNumCreationObj.fixedAsset_AssetSerialNumCreation_PencilIcon().click();
       
        
    }

    @Then("^Fill Asset Serial Num Creation Mandatory fields$")
    public void fill_asset_serial_num_creation_mandatory_fields() throws InterruptedException  {
    fixedAsset_AssetCategoryTestDataType = jsonReader.getAssetCategoryByName("Maker");	
    //StartSerialNumber
 	
    waithelper.waitForElement(driver, 4000,  fixedAsset_AssetSerialNumCreationObj.fixedAsset_AssetSerialNumCreation_StartSerialNumber());
    fixedAsset_AssetSerialNumCreationObj.fixedAsset_AssetSerialNumCreation_StartSerialNumber().click();
    fixedAsset_AssetSerialNumCreationObj.fixedAsset_AssetSerialNumCreation_StartSerialNumber().sendKeys(fixedAsset_AssetCategoryTestDataType.StartSerialNumber);
    fixedAsset_AssetSerialNumCreationObj.fixedAsset_AssetSerialNumCreation_StartSerialNumber().sendKeys(Keys.ENTER);
    Thread.sleep(2000);
      
    }

}
