package stepdefinitions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataProvider.JsonConfig;
import helper.ClicksAndActionsHelper;
import helper.WaitHelper;
import io.cucumber.java.en.Then;
import pageobjects.FixedAsset_AssetDeallocationObj;
import resources.BaseClass;
import testDataType.FixedAsset_AssetDeallocationTestDataType;

public class FixedAsset_AssetDeallocation extends BaseClass {
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver) ;
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	FixedAsset_AssetDeallocationObj fixedAsset_AssetDeallocationObj = new FixedAsset_AssetDeallocationObj(driver);
	FixedAsset_AssetDeallocationTestDataType fixedAsset_AssetDeallocationTestDataType = new FixedAsset_AssetDeallocationTestDataType();

	

    @Then("^Click on fixed asset deallocaion  Direction icon$")
    public void click_on_fixed_asset_deallocaion_direction_icon()  {
    //Direction	
    waithelper.waitForElement(driver, 4000,  fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_DirectionIcon());
    fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_DirectionIcon().click();
    	
       
    }

    @Then("^Click on Fixed assets field$")
    public void click_on_fixed_assets_field() {
    //Fixed Assets
    waithelper.waitForElement(driver, 4000,  fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_FixedAssetsField());
    fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_FixedAssetsField().click();
        	
         
      
    }

    @Then("^Click on asset deallocaion Eye button$")
    public void click_on_asset_deallocaion_eye_button(){
    //Eye
   WebElement eye = waithelper.waitForElement(driver, 4000,  fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_EyeIcon());
   clicksAndActionHelper.moveToElement(eye);
   fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_EyeIcon().click();
       
        
    }

    @Then("^Fill asset deallocaion Mandatory fields$")
    public void fill_asset_deallocaion_mandatory_fields() throws InterruptedException  {
    	fixedAsset_AssetDeallocationTestDataType = jsonReader.getAssetDeallocationByName("Maker");	
    	
    	//AssetReferenceNumber
        waithelper.waitForElement(driver, 4000,  fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber());
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().click();
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(fixedAsset_AssetDeallocationTestDataType.AssetReferenceNumber);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(Keys.ENTER);
       
        
        //ItemNumber
        waithelper.waitForElement(driver, 4000,  fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber());
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().click();
        Thread.sleep(2000);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(fixedAsset_AssetDeallocationTestDataType.ItemNumber);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(Keys.ENTER);
        Thread.sleep(2000);
       
    }
    
    //----------asset transferred deallocaion --------------//
    @Then("^Fill asset transferred deallocaion Mandatory fields$")
    public void fill_asset_transferred_deallocaion_mandatory_fields() throws InterruptedException  {
    	fixedAsset_AssetDeallocationTestDataType = jsonReader.getAssetDeallocationByName("Maker");	
    	
    	//AssetReferenceNumber
        waithelper.waitForElement(driver, 4000,  fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber());
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().click();
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(fixedAsset_AssetDeallocationTestDataType.AssetReferenceNumberTransfer);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(Keys.ENTER);
       
        
        //ItemNumber
        waithelper.waitForElement(driver, 4000,  fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber());
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().click();
        Thread.sleep(2000);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(fixedAsset_AssetDeallocationTestDataType.ItemNumberTransfer);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        
    }
    //---------asset sold deallocaion-------------//
    @Then("^Fill asset sold deallocaion Mandatory fields$")
    public void fill_asset_sold_deallocaion_mandatory_fields() throws InterruptedException {
    	fixedAsset_AssetDeallocationTestDataType = jsonReader.getAssetDeallocationByName("Maker");	
    	
    	//AssetReferenceNumber
        waithelper.waitForElement(driver, 4000,  fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber());
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().click();
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(fixedAsset_AssetDeallocationTestDataType.AssetReferenceNumberSold);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(Keys.ENTER);
       
        
        //ItemNumber
        waithelper.waitForElement(driver, 4000,  fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber());
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().click();
        Thread.sleep(2000);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(fixedAsset_AssetDeallocationTestDataType.ItemNumberSold);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        
    }
    //--------asset impaired deallocaion--------------//
    @Then("^Fill asset impaired deallocaion Mandatory fields$")
    public void fill_asset_impaired_deallocaion_mandatory_fields() throws InterruptedException {
    	fixedAsset_AssetDeallocationTestDataType = jsonReader.getAssetDeallocationByName("Maker");	
    	
    	//AssetReferenceNumber
        waithelper.waitForElement(driver, 4000,  fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber());
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().click();
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(fixedAsset_AssetDeallocationTestDataType.AssetReferenceNumberImpaired);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(Keys.ENTER);
       
        
        //ItemNumber
        waithelper.waitForElement(driver, 4000,  fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber());
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().click();
        Thread.sleep(2000);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(fixedAsset_AssetDeallocationTestDataType.ItemNumberImpaired);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(Keys.ENTER);
        Thread.sleep(2000);
      
    }
    
    //--------asset revalued deallocaion--------------//
    @Then("^Fill asset revalued deallocaion Mandatory fields$")
    public void fill_asset_revalued_deallocaion_mandatory_fields() throws InterruptedException{
fixedAsset_AssetDeallocationTestDataType = jsonReader.getAssetDeallocationByName("Maker");	
    	
    	//AssetReferenceNumber
        waithelper.waitForElement(driver, 4000,  fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber());
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().click();
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(fixedAsset_AssetDeallocationTestDataType.AssetReferenceNumberRevalued);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(Keys.ENTER);
       
        
        //ItemNumber
        waithelper.waitForElement(driver, 4000,  fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber());
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().click();
        Thread.sleep(2000);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(fixedAsset_AssetDeallocationTestDataType.ItemNumberRevalued);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(Keys.ENTER);
        Thread.sleep(2000);
       
    }
    //----------asset amended deallocaion------------//
    @Then("^Fill asset amended deallocaion Mandatory fields$")
    public void fill_asset_amended_deallocaion_mandatory_fields() throws InterruptedException  {
    	fixedAsset_AssetDeallocationTestDataType = jsonReader.getAssetDeallocationByName("Maker");	
    	
    	//AssetReferenceNumber
        waithelper.waitForElement(driver, 4000,  fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber());
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().click();
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(fixedAsset_AssetDeallocationTestDataType.AssetReferenceNumberAmended);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(Keys.ENTER);
       
        
        //ItemNumber
        waithelper.waitForElement(driver, 4000,  fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber());
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().click();
        Thread.sleep(2000);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(fixedAsset_AssetDeallocationTestDataType.ItemNumberAmended);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        
    }
    //----------asset replacement deallocaion ------------//
    @Then("^Fill asset replacement deallocaion Mandatory fields$")
    public void fill_asset_replacement_deallocaion_mandatory_fields() throws InterruptedException {
    	fixedAsset_AssetDeallocationTestDataType = jsonReader.getAssetDeallocationByName("Maker");	
    	
    	//AssetReferenceNumber
        waithelper.waitForElement(driver, 4000,  fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber());
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().click();
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(fixedAsset_AssetDeallocationTestDataType.AssetReferenceNumberReplaced);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(Keys.ENTER);
       
        
        //ItemNumber
        waithelper.waitForElement(driver, 4000,  fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber());
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().click();
        Thread.sleep(2000);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(fixedAsset_AssetDeallocationTestDataType.ItemNumberReplaced);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    
       
    }
    

}
