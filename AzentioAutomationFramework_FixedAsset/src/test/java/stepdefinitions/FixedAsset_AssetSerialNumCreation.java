package stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataProvider.JsonConfig;
import helper.ClicksAndActionsHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
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
	Map<String,String> codeConfigData= new HashMap<>();
	
	
	@Then("^Click on Asset Serial Num Creation Eye button$")
    public void click_on_asset_serial_num_creation_eye_button()  {
	//Eye Button
	WebElement eye = waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAsset_AssetSerialNumCreationObj.fixedAsset_AssetSerialNumCreation_EyeIcon(),60,5);
	clicksAndActionHelper.moveToElement(eye);
	fixedAsset_AssetSerialNumCreationObj.fixedAsset_AssetSerialNumCreation_EyeIcon().click();
		
        
    }

	@And("^get the active asset code in asset category moduless$")
    public void get_the_active_asset_code_in_asset_category_moduless() throws Throwable {
		waithelper.waitForElementVisible(driver.findElement(By.xpath("//datatable-row-wrapper[1]//datatable-body-cell[2]//span")), 3000, 300);
     driver.findElement(By.xpath("//datatable-row-wrapper[1]//datatable-body-cell[2]//span")).getText();
     codeConfigData.put("AssetCode", driver.findElement(By.xpath("//datatable-row-wrapper[1]//datatable-body-cell[2]//span")).getText());
     
    }
	
    @Then("^Click on Asset Serial Num Creation Search icon$")
    public void click_on_asset_serial_num_creation_search_icon()  {
    waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAsset_AssetSerialNumCreationObj.fixedAsset_AssetSerialNumCreation_SearchIcon(),60,5);
    fixedAsset_AssetSerialNumCreationObj.fixedAsset_AssetSerialNumCreation_SearchIcon().click();
    	
        
    }

    @Then("^Enter Asset code$")
    public void enter_asset_code()  {
    fixedAsset_AssetCategoryTestDataType = jsonReader.getAssetCategoryByName("Maker");	
    //Asset code
    	
    waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAsset_AssetSerialNumCreationObj.fixedAsset_AssetSerialNumCreation_AssetCode(),60,5);
    fixedAsset_AssetSerialNumCreationObj.fixedAsset_AssetSerialNumCreation_AssetCode().click();
   // fixedAsset_AssetSerialNumCreationObj.fixedAsset_AssetSerialNumCreation_AssetCode().sendKeys(fixedAsset_AssetCategoryTestDataType.AssetCode);
    fixedAsset_AssetSerialNumCreationObj.fixedAsset_AssetSerialNumCreation_AssetCode().sendKeys(codeConfigData.get("AssetCode"));
    fixedAsset_AssetSerialNumCreationObj.fixedAsset_AssetSerialNumCreation_AssetCode().sendKeys(Keys.ENTER);
    
    	    
        
    }

    @Then("^Click on the record$")
    public void click_on_the_record()  {
    //Pencil
    	
     waithelper.waitForElementToVisibleWithFluentWait(driver,fixedAsset_AssetSerialNumCreationObj.fixedAsset_AssetSerialNumCreation_PencilIcon(),60,5);
     fixedAsset_AssetSerialNumCreationObj.fixedAsset_AssetSerialNumCreation_PencilIcon().click();
       
        
    }

    @Then("^Fill Asset Serial Num Creation Mandatory fields$")
    public void fill_asset_serial_num_creation_mandatory_fields() throws InterruptedException  {
    fixedAsset_AssetCategoryTestDataType = jsonReader.getAssetCategoryByName("Maker");	
    //StartSerialNumber
 	
    waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAsset_AssetSerialNumCreationObj.fixedAsset_AssetSerialNumCreation_StartSerialNumber(),60,5);
    fixedAsset_AssetSerialNumCreationObj.fixedAsset_AssetSerialNumCreation_StartSerialNumber().click();
    fixedAsset_AssetSerialNumCreationObj.fixedAsset_AssetSerialNumCreation_StartSerialNumber().sendKeys(fixedAsset_AssetCategoryTestDataType.StartSerialNumber);
    fixedAsset_AssetSerialNumCreationObj.fixedAsset_AssetSerialNumCreation_StartSerialNumber().sendKeys(Keys.ENTER);
    Thread.sleep(2000);
      
    }

}
