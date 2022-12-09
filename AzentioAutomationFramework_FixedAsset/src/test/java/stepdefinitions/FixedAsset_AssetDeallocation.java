package stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import dataProvider.JsonConfig;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.FixedAsset_AssetDeallocationObj;
import resources.BaseClass;
import testDataType.FixedAsset_AssetCreationTestDataType;
import testDataType.FixedAsset_AssetDeallocationTestDataType;

public class FixedAsset_AssetDeallocation extends BaseClass {
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver) ;
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	FixedAsset_AssetDeallocationObj fixedAsset_AssetDeallocationObj = new FixedAsset_AssetDeallocationObj(driver);
	FixedAsset_AssetDeallocationTestDataType fixedAsset_AssetDeallocationTestDataType = jsonReader.getAssetDeallocationByName("Maker");	
	FixedAsset_AssetCreationTestDataType fixedAsset_AssetCreationTestDataType = jsonReader.getAssetCreationByName("Maker");
	String AssetReferenceNumber;
	JavascriptHelper javascripthelper = new JavascriptHelper();
	Map<String,String> mapData= new HashMap<>();
	

//    @Then("^Click on fixed asset deallocaion  Direction icon$")
//    public void click_on_fixed_asset_deallocaion_direction_icon()  {
//    //Direction	
//    waithelper.waitForElementToVisisbleWithFluentWait(driver,  fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_DirectionIcon());
//    fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_DirectionIcon().click();
//    	
//       
//    }

//    @Then("^Click on Fixed assets field$")
//    public void click_on_fixed_assets_field() {
//    //Fixed Assets
//    waithelper.waitForElementToVisisbleWithFluentWait(driver,  fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_FixedAssetsField());
//    fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_FixedAssetsField().click();
//        	
//         
//      
//    }
   
	@And("^get the allocated asset reference number in asset allocation module$")
    public void get_the_allocated_asset_reference_number_in_asset_allocation_module() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,fixedAsset_AssetDeallocationObj.fixedAssetAllocatedApprovedRecord(),60,5);
		mapData.put("allocatedAssetReferenceNumber", fixedAsset_AssetDeallocationObj.fixedAssetAllocatedApprovedRecord().getText());
		System.out.println("Allocate dasset reference number is "+mapData.get("allocatedAssetReferenceNumber"));
		
    }

    @Then("^Click on asset deallocaion Eye button$")
    public void click_on_asset_deallocaion_eye_button() throws InterruptedException{
    //Eye
Thread.sleep(1500);
   javascripthelper.JavaScriptHelper(driver);
   javascripthelper.scrollIntoView(fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_EyeIcon());
 //  waithelper.waitForElementToVisisbleWithFluentWait(driver, fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_EyeIcon());
   fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_EyeIcon().click();   
        
    }

    @Then("^Fill asset deallocaion Mandatory fields$")
    public void fill_asset_deallocaion_mandatory_fields() throws InterruptedException  {
    	fixedAsset_AssetDeallocationTestDataType = jsonReader.getAssetDeallocationByName("Maker");	
    	
    	//AssetReferenceNumber
        waithelper.waitForElementToVisibleWithFluentWait(driver,fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber(),60,5);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().click();
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(fixedAsset_AssetDeallocationTestDataType.AssetReferenceNumber);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(Keys.ENTER);
       
        
        //AssetItemNumber
        waithelper.waitForElementToVisibleWithFluentWait(driver,fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber(),60,5);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().click();
        //Thread.sleep(2000);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(Keys.DOWN);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(Keys.ENTER);
        //Thread.sleep(2000);
       
    }
    
    @Then("^Fill asset deallocaion Mandatory fields to deallocate the asset$")
    public void fill_asset_deallocaion_mandatory_fields_to_deallocate_the_asset() throws Throwable {
fixedAsset_AssetDeallocationTestDataType = jsonReader.getAssetDeallocationByName("Maker");	
    	
    	//AssetReferenceNumber
        waithelper.waitForElementToVisibleWithFluentWait(driver,fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber(),60,5);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().click();
         fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(mapData.get("allocatedAssetReferenceNumber"));
      //  fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(fixedAsset_AssetCreationTestDataType.AssetCode);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(Keys.ENTER);
       
        
        //AssetItemNumber
        waithelper.waitForElementToVisibleWithFluentWait(driver,fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber(),60,5);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().click();
        Thread.sleep(1000);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(Keys.DOWN);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(Keys.ENTER);
        //Thread.sleep(2000);
    }
    
    //----------asset transferred deallocaion --------------//
    @Then("^Fill asset transferred deallocaion Mandatory fields$")
    public void fill_asset_transferred_deallocaion_mandatory_fields() throws InterruptedException  {
    	fixedAsset_AssetDeallocationTestDataType = jsonReader.getAssetDeallocationByName("Maker");	
    	
    	//AssetReferenceNumber
        waithelper.waitForElementToVisibleWithFluentWait(driver,fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber(),60,5);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().click();
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(fixedAsset_AssetDeallocationTestDataType.AssetReferenceNumberTransfer);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(Keys.DOWN);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(Keys.ENTER);
       
        
        //AssetItemNumber
        waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber(),60,5);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().click();
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(Keys.DOWN);
        //Thread.sleep(2000);
        //fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(fixedAsset_AssetDeallocationTestDataType.ItemNumberTransfer);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        
    }
   
    
    //---------asset sold deallocaion-------------//
    @And("^User get sold asset for de allocation$")
    public void user_get_sold_asset_for_de_allocation() throws Throwable {
    	waithelper.waitForElementVisible(driver.findElement(By.xpath("(//span[text()=' Active ']/ancestor::datatable-body-cell)[1]/preceding::datatable-body-cell[4]")), 3000, 300);
	     //driver.findElement(By.xpath("//datatable-row-wrapper[1]//datatable-body-cell[2]//span")).getText();
    	mapData.put("AssetCode", driver.findElement(By.xpath("(//span[text()=' Active ']/ancestor::datatable-body-cell)[1]/preceding::datatable-body-cell[4]")).getText());
	     System.out.println( driver.findElement(By.xpath("(//span[text()=' Active ']/ancestor::datatable-body-cell)[1]/preceding::datatable-body-cell[4]")).getText());
    }

    @Then("^Fill Asset Allocation For asset sold$")
    public void fill_asset_allocation_for_asset_sold() throws Throwable {
fixedAsset_AssetDeallocationTestDataType = jsonReader.getAssetDeallocationByName("Maker");	
    	
		waithelper.waitForElementToVisibleWithFluentWait(driver,fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_AssetRefferenceNumber(),60,5);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().click();
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(mapData.get("AssetCode"));
    	Thread.sleep(1000);
    //	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(fixedAsset_AssetCreationTestDataType.AssetCode);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(Keys.ENTER);
        
        
    	waithelper.waitForElementToVisibleWithFluentWait(driver,fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_ItemNumber(),60,5);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_ItemNumber().click();
    	//fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(fixedAsset_AssetDeallocationTestDataType.AssetItemNumberRevalued);
    	Thread.sleep(2000); 
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(Keys.DOWN);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(Keys.ENTER);
    	
    	waithelper.waitForElementToVisibleWithFluentWait(driver,fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_EmployeeID(),60,5);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_EmployeeID().click();  	
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_EmployeeID().sendKeys(fixedAsset_AssetDeallocationTestDataType.EmployeeID);
    	Thread.sleep(1000);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_EmployeeID().sendKeys(Keys.ENTER);
    }
    @Then("^Fill asset sold deallocaion Mandatory fields$")
    public void fill_asset_sold_deallocaion_mandatory_fields() throws InterruptedException {
    	fixedAsset_AssetDeallocationTestDataType = jsonReader.getAssetDeallocationByName("Maker");	
    	
    	//AssetReferenceNumber
        waithelper.waitForElementToVisibleWithFluentWait(driver,fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber(),60,5);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().click();
        //fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(fixedAsset_AssetDeallocationTestDataType.AssetReferenceNumberSold);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(mapData.get("AssetCode"));
        Thread.sleep(1000);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(Keys.ENTER);
       
        
        //AssetItemNumber
        waithelper.waitForElementToVisibleWithFluentWait(driver,fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber(),60,5);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().click();
        Thread.sleep(1000);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(Keys.DOWN);
       // fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(fixedAsset_AssetDeallocationTestDataType.ItemNumberSold);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(Keys.ENTER);
        
        
    }
    //--------asset impaired deallocaion--------------//
    
    // Asset Reference Number
    @Then("^Select Asset Reference Number$")
    public void select_asset_reference_number() throws InterruptedException {
    Thread.sleep(2000);
   	waithelper.waitForElementToVisibleWithFluentWait(driver,fixedAsset_AssetDeallocationObj.fixedAsset_AssetReference(),60,5);
   	AssetReferenceNumber = fixedAsset_AssetDeallocationObj.fixedAsset_AssetReference().getText();
   	System.out.println(AssetReferenceNumber);
    Thread.sleep(1000);
    }
    @Then("^Click on Asset Impairment Eye button$")
    public void click_on_asset_impairment_eye_button() throws InterruptedException  {
    javascripthelper.JavaScriptHelper(driver);
    javascripthelper.scrollIntoView(fixedAsset_AssetDeallocationObj.fixedAsset_AssetImpairement_EyeIcon());
    waithelper.waitForElementToVisibleWithFluentWait(driver,fixedAsset_AssetDeallocationObj.fixedAsset_AssetImpairement_EyeIcon(),60,5);
    fixedAsset_AssetDeallocationObj.fixedAsset_AssetImpairement_EyeIcon().click();
    Thread.sleep(1000);
    }
    @Then("^fill the form for Asset Impairment$")
    public void fill_the_form_for_asset_impairment() throws Throwable {
    	//AssetReferenceNumber
        waithelper.waitForElementToVisibleWithFluentWait(driver,fixedAsset_AssetDeallocationObj.fixedAsset_AssetImpairement_AssetReferenceNumber(),60,5);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetImpairement_AssetReferenceNumber().click();
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetImpairement_AssetReferenceNumber().sendKeys(AssetReferenceNumber);
        Thread.sleep(1000);
        //fixedAsset_AssetDeallocationObj.fixedAsset_AssetImpairement_AssetReferenceNumber().sendKeys(fixedAsset_AssetCreationTestDataType.AssetCode);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetImpairement_AssetReferenceNumber().sendKeys(Keys.ENTER);
       
        //Transaction TYpe
        waithelper.waitForElementToVisibleWithFluentWait(driver,fixedAsset_AssetDeallocationObj.fixedAsset_AssetImpairement_TransactionType(),60,5);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetImpairement_TransactionType().click();
        Thread.sleep(1000);
      //impairement
        waithelper.waitForElementToVisibleWithFluentWait(driver,fixedAsset_AssetDeallocationObj.fixedAsset_AssetImpairement_Impairement(),60,5);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetImpairement_Impairement().click();
        
        //AssetItemNumber
        waithelper.waitForElementToVisibleWithFluentWait(driver,fixedAsset_AssetDeallocationObj.fixedAsset_AssetImpairement_ItemNumber(),60,5);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetImpairement_ItemNumber().click();
        //fixedAsset_AssetDeallocationObj.fixedAsset_AssetImpairement_ItemNumber().sendKeys(fixedAsset_AssetDeallocationTestDataType.AssetItemNumberimpaired);
        Thread.sleep(1000);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetImpairement_ItemNumber().sendKeys(Keys.DOWN);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetImpairement_ItemNumber().sendKeys(Keys.ENTER);
        
       
        
    }
    @Then("^Fill Asset Allocation Form impaired$")
    public void fill_asset_allocation_form_impaired() throws InterruptedException {
		
		
    	fixedAsset_AssetDeallocationTestDataType = jsonReader.getAssetDeallocationByName("Maker");	
    	
		waithelper.waitForElementToVisibleWithFluentWait(driver,fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_AssetRefferenceNumber(),60,5);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().click();
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(AssetReferenceNumber);
    //	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(fixedAsset_AssetCreationTestDataType.AssetCode);
    	Thread.sleep(1000);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(Keys.ENTER);
        
        
    	waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_ItemNumber(),60,5);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_ItemNumber().click();
    	 
    //	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(fixedAsset_AssetDeallocationTestDataType.AssetItemNumberimpaired);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(Keys.DOWN);
    	Thread.sleep(1000); 
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(Keys.ENTER);
    	
    	
    	waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_EmployeeID(),60,5);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_EmployeeID().click();
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_EmployeeID().sendKeys(fixedAsset_AssetDeallocationTestDataType.EmployeeID);
    	Thread.sleep(1000);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_EmployeeID().sendKeys(Keys.ENTER);
    	
	}
    @Then("^Fill Asset Allocation Form$")
    public void fill_asset_allocation_form() throws InterruptedException {
		
		
    	fixedAsset_AssetDeallocationTestDataType = jsonReader.getAssetDeallocationByName("Maker");	
    	
		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_AssetRefferenceNumber(),60,5);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().click();
    	//AssetReferenceNumber
    	//fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(AssetReferenceNumber);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(fixedAsset_AssetCreationTestDataType.AssetCode);
    	Thread.sleep(1000);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(Keys.ENTER);
        
        
    	waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_ItemNumber(),60,5);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_ItemNumber().click(); 
    	Thread.sleep(1000);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(Keys.DOWN);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(Keys.ENTER);
    	
    	
    	waithelper.waitForElementToVisibleWithFluentWait(driver,fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_EmployeeID(),60,5);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_EmployeeID().click();
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_EmployeeID().sendKeys(fixedAsset_AssetDeallocationTestDataType.EmployeeID);
    	Thread.sleep(1000);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_EmployeeID().sendKeys(Keys.ENTER);
  
	}

    @Then("^Fill Asset Allocation Form revalued$")
    public void fill_asset_allocation_form_revalued() throws InterruptedException {
		
		
    	fixedAsset_AssetDeallocationTestDataType = jsonReader.getAssetDeallocationByName("Maker");	
    	
		waithelper.waitForElementToVisibleWithFluentWait(driver,fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_AssetRefferenceNumber(),60,5);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().click();
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(AssetReferenceNumber);
    	Thread.sleep(1000);
    //	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(fixedAsset_AssetCreationTestDataType.AssetCode);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(Keys.ENTER);
        
        
    	waithelper.waitForElementToVisibleWithFluentWait(driver,fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_ItemNumber(),60,5);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_ItemNumber().click();
    	//fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(fixedAsset_AssetDeallocationTestDataType.AssetItemNumberRevalued);
    	Thread.sleep(2000);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(Keys.DOWN);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(Keys.ENTER);
    	
    	waithelper.waitForElementToVisibleWithFluentWait(driver,fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_EmployeeID(),60,5);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_EmployeeID().click();  	
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_EmployeeID().sendKeys(fixedAsset_AssetDeallocationTestDataType.EmployeeID);
    	Thread.sleep(1000);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_EmployeeID().sendKeys(Keys.ENTER);
    	
	}
    @Then("^Fill Asset Allocation Form amended$")
    public void fill_asset_allocation_form_amended() throws InterruptedException {
		
		
    	fixedAsset_AssetDeallocationTestDataType = jsonReader.getAssetDeallocationByName("Maker");	
    	
		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_AssetRefferenceNumber(),60,5);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().click();
    	//fixedAsset_AssetCreationTestDataType.AssetCode
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(AssetReferenceNumber);
    	
    	//fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(fixedAsset_AssetCreationTestDataType.AssetCode);
    	Thread.sleep(1000);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(Keys.ENTER);
        
        
    	waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_ItemNumber(),60,5);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_ItemNumber().click();
    	Thread.sleep(2000); 
    	//fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(fixedAsset_AssetDeallocationTestDataType.AssetItemNumberamended);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(Keys.DOWN);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(Keys.ENTER);
    	 
    	
    	waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_EmployeeID(),60,5);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_EmployeeID().click();
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_EmployeeID().sendKeys(fixedAsset_AssetDeallocationTestDataType.EmployeeID);
    	Thread.sleep(1000); 
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_EmployeeID().sendKeys(Keys.ENTER);
    	
	}
    
    @Then("^Fill Asset Allocation Form another employee$")
    public void fill_asset_allocation_form_another_employee() throws Throwable {
    	
		
    	
		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_AssetRefferenceNumber(),60,5);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().click();
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(AssetReferenceNumber);
    	Thread.sleep(1000);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(Keys.ENTER);
        
        
    	waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_ItemNumber(),60,5);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_ItemNumber().click();
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(fixedAsset_AssetDeallocationTestDataType.AssetItemNumber);
    	Thread.sleep(1000);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(Keys.ENTER);
     
    	
    	waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_EmployeeID(),60,5);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_EmployeeID().click();
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_EmployeeID().sendKeys(fixedAsset_AssetDeallocationTestDataType.EmployeeIDAnother);
    	Thread.sleep(1000);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_EmployeeID().sendKeys(Keys.ENTER);
    	   
    }
   

    @Then("^Fill asset impaired deallocaion Mandatory fields$")
    public void fill_asset_impaired_deallocaion_mandatory_fields() throws InterruptedException {
    	fixedAsset_AssetDeallocationTestDataType = jsonReader.getAssetDeallocationByName("Maker");	
    	
    	//AssetReferenceNumber
        waithelper.waitForElementToVisibleWithFluentWait(driver,  fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber(),60,5);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().click();
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(AssetReferenceNumber);
      //  fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(fixedAsset_AssetCreationTestDataType.AssetCode);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(Keys.ENTER);
       
        
        //AssetItemNumber
        waithelper.waitForElementToVisibleWithFluentWait(driver,  fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber(),60,5);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().click();
        Thread.sleep(2000);
    //    fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(fixedAsset_AssetDeallocationTestDataType.AssetItemNumberimpaired);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(Keys.DOWN);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(Keys.ENTER);
        Thread.sleep(2000);
      
    }
    @Then("^Fill asset replaced deallocaion Mandatory fields$")
    public void fill_asset_replaced_deallocaion_mandatory_fields() throws InterruptedException {
    	fixedAsset_AssetDeallocationTestDataType = jsonReader.getAssetDeallocationByName("Maker");	
    	
    	//AssetReferenceNumber
        waithelper.waitForElementToVisibleWithFluentWait(driver,  fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber(),60,5);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().click();
      //  fixedAsset_AssetCreationTestDataType.AssetCode
     //   fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(AssetReferenceNumber);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(fixedAsset_AssetCreationTestDataType.AssetCode);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(Keys.ENTER);
       
        
        //AssetItemNumber
        waithelper.waitForElementToVisibleWithFluentWait(driver,fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber(),60,5);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().click();
        Thread.sleep(2000);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(fixedAsset_AssetDeallocationTestDataType.AssetItemNumberReplaced);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(Keys.ENTER);
        Thread.sleep(2000);
      
    }

    @Then("^Fill asset amended deallocaion Mandatory fields$")
    public void fill_asset_amended_deallocaion_mandatory_fields() throws InterruptedException {
    	fixedAsset_AssetDeallocationTestDataType = jsonReader.getAssetDeallocationByName("Maker");	
    	
    	//AssetReferenceNumber
        waithelper.waitForElementToVisibleWithFluentWait(driver,fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber(),60,5);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().click();
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(AssetReferenceNumber);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(Keys.ENTER);
       
        
        //AssetItemNumber
        waithelper.waitForElementToVisibleWithFluentWait(driver,  fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber(),60,5);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().click();
        Thread.sleep(2000);
        //fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(fixedAsset_AssetDeallocationTestDataType.AssetItemNumberamended);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(Keys.DOWN);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(Keys.ENTER);
        
      
    }
    
    //--------asset revalued deallocaion--------------//
    
    @Then("^Click on revalued asset Eye button$")
    public void click_on_revalued_asset_eye_button() throws Throwable {
    	javascripthelper.JavaScriptHelper(driver);
        javascripthelper.scrollIntoView(fixedAsset_AssetDeallocationObj.fixedAsset_RevaluedAsset_EyeIcon());
        waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAsset_AssetDeallocationObj.fixedAsset_RevaluedAsset_EyeIcon(),60,5);
        fixedAsset_AssetDeallocationObj.fixedAsset_RevaluedAsset_EyeIcon().click();
        Thread.sleep(1000);
    }
    

    @Then("^fill the form for revalued asset$")
    public void fill_the_form_for_revalued_asset() throws Throwable {
    	fixedAsset_AssetDeallocationTestDataType = jsonReader.getAssetDeallocationByName("Maker");  
    	//AssetReferenceNumber
        waithelper.waitForElementToVisibleWithFluentWait(driver,  fixedAsset_AssetDeallocationObj.fixedAsset_RevaluedAsset_AssetReferenceNumber(),60,5);
        fixedAsset_AssetDeallocationObj.fixedAsset_RevaluedAsset_AssetReferenceNumber().click();
        fixedAsset_AssetDeallocationObj.fixedAsset_RevaluedAsset_AssetReferenceNumber().sendKeys(AssetReferenceNumber);
      //  fixedAsset_AssetDeallocationObj.fixedAsset_RevaluedAsset_AssetReferenceNumber().sendKeys(fixedAsset_AssetCreationTestDataType.AssetCode);
        fixedAsset_AssetDeallocationObj.fixedAsset_RevaluedAsset_AssetReferenceNumber().sendKeys(Keys.ENTER);
       
        
        //AssetItemNumber
        waithelper.waitForElementToVisibleWithFluentWait(driver,  fixedAsset_AssetDeallocationObj.fixedAsset_RevaluedAsset_ItemNumber(),60,5);
        fixedAsset_AssetDeallocationObj.fixedAsset_RevaluedAsset_ItemNumber().click();
        Thread.sleep(2000);
        //fixedAsset_AssetDeallocationObj.fixedAsset_RevaluedAsset_ItemNumber().sendKeys(fixedAsset_AssetDeallocationTestDataType.AssetItemNumberRevalued);
        fixedAsset_AssetDeallocationObj.fixedAsset_RevaluedAsset_ItemNumber().sendKeys(Keys.DOWN);
        fixedAsset_AssetDeallocationObj.fixedAsset_RevaluedAsset_ItemNumber().sendKeys(Keys.ENTER);

    }
    @Then("^Fill asset Revalued deallocaion Mandatory fields$")
    public void fill_asset_Revalued_deallocaion_mandatory_fields() throws InterruptedException {
    	fixedAsset_AssetDeallocationTestDataType = jsonReader.getAssetDeallocationByName("Maker");	
    	
    	//AssetReferenceNumber
        waithelper.waitForElementToVisibleWithFluentWait(driver,  fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber(),60,5);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().click();
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(AssetReferenceNumber);
    //    fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(fixedAsset_AssetCreationTestDataType.AssetCode);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(Keys.ENTER);
       
        
        //AssetItemNumber
        waithelper.waitForElementToVisibleWithFluentWait(driver,  fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber(),60,5);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().click();
        Thread.sleep(2000);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(fixedAsset_AssetDeallocationTestDataType.AssetItemNumberRevalued);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(Keys.ENTER);
        Thread.sleep(2000);
      
    }
   
    
    
    //----------asset amended deallocaion------------//
    @Then("^Click on amended asset Eye button$")
    public void click_on_amended_asset_eye_button() throws InterruptedException  {
    	javascripthelper.JavaScriptHelper(driver);
        javascripthelper.scrollIntoView(fixedAsset_AssetDeallocationObj.fixedAsset_AmendedAsset_EyeIcon());
        waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAsset_AssetDeallocationObj.fixedAsset_AmendedAsset_EyeIcon(),60,5);
        fixedAsset_AssetDeallocationObj.fixedAsset_AmendedAsset_EyeIcon().click();
        Thread.sleep(1000);  
    }

    @Then("^fill the form for amended asset$")
    public void fill_the_form_for_amended_asset() throws InterruptedException  {
    	fixedAsset_AssetDeallocationTestDataType = jsonReader.getAssetDeallocationByName("Maker");	
    	
    	//AssetReferenceNumber
        waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAsset_AssetDeallocationObj.fixedAsset_AmendedAsset_AssetReferenceNumber(),60,5);
        fixedAsset_AssetDeallocationObj.fixedAsset_AmendedAsset_AssetReferenceNumber().click();
        fixedAsset_AssetDeallocationObj.fixedAsset_AmendedAsset_AssetReferenceNumber().sendKeys(AssetReferenceNumber);
      //  fixedAsset_AssetDeallocationObj.fixedAsset_AmendedAsset_AssetReferenceNumber().sendKeys(fixedAsset_AssetCreationTestDataType.AssetCode);
        fixedAsset_AssetDeallocationObj.fixedAsset_AmendedAsset_AssetReferenceNumber().sendKeys(Keys.ENTER);
       
        
        //AssetItemNumber
        waithelper.waitForElementToVisibleWithFluentWait(driver,  fixedAsset_AssetDeallocationObj.fixedAsset_AmendedAsset_ItemNumber(),60,5);
        fixedAsset_AssetDeallocationObj.fixedAsset_AmendedAsset_ItemNumber().click();
        Thread.sleep(1000);
        //fixedAsset_AssetDeallocationObj.fixedAsset_AmendedAsset_ItemNumber().sendKeys(fixedAsset_AssetDeallocationTestDataType.AssetItemNumberamended);
        fixedAsset_AssetDeallocationObj.fixedAsset_AmendedAsset_ItemNumber().sendKeys(Keys.DOWN);
        fixedAsset_AssetDeallocationObj.fixedAsset_AmendedAsset_ItemNumber().sendKeys(Keys.ENTER);
        Thread.sleep(1000);  
        
       //ModificationType
        waithelper.waitForElementToVisibleWithFluentWait(driver,  fixedAsset_AssetDeallocationObj.fixedAsset_AmendedAsset_ModificationType(),60,5);
        fixedAsset_AssetDeallocationObj.fixedAsset_AmendedAsset_ModificationType().click();
        fixedAsset_AssetDeallocationObj.fixedAsset_AmendedAsset_ModificationType().sendKeys(fixedAsset_AssetDeallocationTestDataType.ModificationType);
        fixedAsset_AssetDeallocationObj.fixedAsset_AmendedAsset_ModificationType().sendKeys(Keys.ENTER);
       
    }
    
    //----------asset replacement deallocaion ------------//
    
    

    @Then("^Click on asset replacement  Eye button$")
    public void click_on_asset_replacement_eye_button() throws InterruptedException  {
    	javascripthelper.JavaScriptHelper(driver);
        javascripthelper.scrollIntoView(fixedAsset_AssetDeallocationObj.fixedAsset_AssetReplacement_EyeIcon());
        waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAsset_AssetDeallocationObj.fixedAsset_AssetReplacement_EyeIcon(),60,5);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetReplacement_EyeIcon().click();
        Thread.sleep(1000);    
    }
    
    @Then("^fill the form for asset replacement$")
    public void fill_the_form_for_asset_replacement() throws InterruptedException  {
   fixedAsset_AssetDeallocationTestDataType = jsonReader.getAssetDeallocationByName("Maker");	
    	
    	//AssetReferenceNumber
        waithelper.waitForElementToVisibleWithFluentWait(driver,fixedAsset_AssetDeallocationObj.fixedAsset_RevaluedAsset_AssetReferenceNumber(),60,5);
        fixedAsset_AssetDeallocationObj.fixedAsset_RevaluedAsset_AssetReferenceNumber().click();
        fixedAsset_AssetDeallocationObj.fixedAsset_RevaluedAsset_AssetReferenceNumber().sendKeys(AssetReferenceNumber);
       // fixedAsset_AssetDeallocationObj.fixedAsset_RevaluedAsset_AssetReferenceNumber().sendKeys(fixedAsset_AssetCreationTestDataType.AssetCode);
        fixedAsset_AssetDeallocationObj.fixedAsset_RevaluedAsset_AssetReferenceNumber().sendKeys(Keys.ENTER);
       
        
        //AssetItemNumber
        waithelper.waitForElementToVisibleWithFluentWait(driver,  fixedAsset_AssetDeallocationObj.fixedAsset_AssetReplacement_ItemNumber(),60,5);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetReplacement_ItemNumber().click();
        Thread.sleep(1000);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetReplacement_ItemNumber().sendKeys(Keys.DOWN);
  //    fixedAsset_AssetDeallocationObj.fixedAsset_AssetReplacement_ItemNumber().sendKeys(fixedAsset_AssetDeallocationTestDataType.AssetItemNumberReplaced);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetReplacement_ItemNumber().sendKeys(Keys.ENTER);
 //     Thread.sleep(1000);
        
        //NewItemNumber
        waithelper.waitForElementToVisibleWithFluentWait(driver,  fixedAsset_AssetDeallocationObj.fixedAsset_AssetReplacement_NewItemNumber(),60,5);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetReplacement_NewItemNumber().click();
        Thread.sleep(1000);
        //fixedAsset_AssetDeallocationObj.fixedAsset_AssetReplacement_NewItemNumber().sendKeys(fixedAsset_AssetDeallocationTestDataType.NewItemNumber);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetReplacement_NewItemNumber().sendKeys(Keys.DOWN);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetReplacement_NewItemNumber().sendKeys(Keys.ENTER);
        
        
        //NewItemDiscription
        waithelper.waitForElementToVisibleWithFluentWait(driver,  fixedAsset_AssetDeallocationObj.fixedAsset_AssetReplacement_NewItemDiscription(),60,5);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetReplacement_NewItemDiscription().click();
        Thread.sleep(1000);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetReplacement_NewItemDiscription().sendKeys(fixedAsset_AssetDeallocationTestDataType.NewItemDiscription);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetReplacement_NewItemDiscription().sendKeys(Keys.ENTER);
        
    
    }
    
    @Then("^Fill Asset Allocation for asset replacement$")
    public void fill_asset_allocation_for_asset_replacement() throws InterruptedException  {
    
		
    	
		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_AssetRefferenceNumber(),60,5);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().click();
    	//fixedAsset_AssetCreationTestDataType.AssetCode
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(AssetReferenceNumber);
    	Thread.sleep(2000);
    	//fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(fixedAsset_AssetCreationTestDataType.AssetCode);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_AssetRefferenceNumber().sendKeys(Keys.ENTER);
        
        
    	waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_ItemNumber(),60,5);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_ItemNumber().click();
    	Thread.sleep(2000);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(Keys.DOWN);
       //fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(fixedAsset_AssetDeallocationTestDataType.NewItemNumber);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_ItemNumber().sendKeys(Keys.ENTER);
    	
    	
    	waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_EmployeeID(),60,5);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_EmployeeID().click();
    	Thread.sleep(1000);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_EmployeeID().sendKeys(fixedAsset_AssetDeallocationTestDataType.EmployeeID);
    	fixedAsset_AssetDeallocationObj.fixedAsset_AssetAllocation_EmployeeID().sendKeys(Keys.ENTER);
    	
    }
    @Then("^Fill asset replacement deallocaion Mandatory fields$")
    public void fill_asset_replacement_deallocaion_mandatory_fields() throws InterruptedException  {
fixedAsset_AssetDeallocationTestDataType = jsonReader.getAssetDeallocationByName("Maker");	
    	
    	//AssetReferenceNumber
        waithelper.waitForElementToVisibleWithFluentWait(driver,fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber(),60,5);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().click();
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(AssetReferenceNumber);
        Thread.sleep(1000);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(Keys.ENTER);
       
        
        //AssetItemNumber
        waithelper.waitForElementToVisibleWithFluentWait(driver,fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber(),60,5);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().click();
        Thread.sleep(2000);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(Keys.DOWN);
       // fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(fixedAsset_AssetDeallocationTestDataType.NewItemNumber);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(Keys.ENTER);
        
    }
    
  
    

}
