package stepdefinitions;

import java.util.Random;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.FixedAsset_AssetCategoryObj;
import pageobjects.Azentio_CheckerObj;
import pageobjects.Azentio_ReviewerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.BUDGET_BudgetCreationTestDataType;
import testDataType.FixedAsset_AssetCategoryTestDataType;

public class FixedAsset_AssetCategory extends BaseClass{

	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	ConfigFileReader configFileReader = new ConfigFileReader();
	ConfigFileReader config=new ConfigFileReader();
	DropDownHelper dropDownHelper;
	WaitHelper waithelper = new WaitHelper(driver) ;
	
	JavascriptHelper javascripthelper = new JavascriptHelper();
	AzentioLogin login;
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	JsonDataReaderWriter reader = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	Azentio_ReviewerObj reviewer;
	BrowserHelper browserHelper;
	String referance_id;
	String user = "Maker";
	Azentio_CheckerObj kubschecker = new Azentio_CheckerObj(driver) ;
	BUDGET_BudgetCreationTestDataType budgetdata;
	
	FixedAsset_AssetCategoryObj fixedAsset_AssetCategoryObj = new FixedAsset_AssetCategoryObj(driver);

	FixedAsset_AssetCategoryTestDataType fixedAsset_AssetCategoryTestDataType = new FixedAsset_AssetCategoryTestDataType();

	
	
	
	
	
	
	 	@Then("^Click on Fixed Asset Direction icon$")
	    public void click_on_fixed_asset_direction_icon()  {
	 	waithelper = new WaitHelper(driver) ;
	 	waithelper.waitForElement(driver, 4000,  fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_DirectionIcon());
	 	fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_DirectionIcon().click();
	    
	        
	    }

	    @Then("^Click on Fixed assets configuration$")
	    public void click_on_fixed_assets_configuration()  {
	    waithelper.waitForElement(driver, 4000,  fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_FixedAssetsConfiguration());
		fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_FixedAssetsConfiguration().click();
		    
	       
	    }

	    @Then("^Click on Asset Category Eye button$")
	    public void click_on_asset_category_eye_button()  {
	    //Eye Button
	    waithelper.waitForElement(driver, 4000,  fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_EyeIcon());
	 	fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_EyeIcon().click();
	 		
	        
	    }

	    @Then("^Click on Fixed Asset Add button$")
	    public void click_on_fixed_asset_add_button()  {
	    //Add Button
	    waithelper.waitForElement(driver, 4000,  fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AddButton());
		fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AddButton().click();
		 		
	        
	    }
	    
	    @Then("^Fill Asset Category Mandatory fields$")
	    public void fill_asset_category_mandatory_fields() {
	    fixedAsset_AssetCategoryTestDataType = jsonReader.getAssetCategoryByName("Maker");
	    Random random = new Random();
	  //Asset Category 	
	  waithelper.waitForElement(driver, 4000,  fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetCategoryInputField());
	  fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetCategoryInputField().click();
	  fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetCategoryInputField().sendKeys(fixedAsset_AssetCategoryTestDataType.AssetCategory);
	  fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetCategoryInputField().sendKeys(Keys.ENTER);
	 
	  //AssetSubCategory
	  waithelper.waitForElement(driver, 4000,  fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetSubCategory());
	  fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetSubCategory().click();
	  fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetSubCategory().sendKeys(fixedAsset_AssetCategoryTestDataType.AssetSubCategory);
	  fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetSubCategory().sendKeys(Keys.ENTER);
	 
	  //AssetItemCategory
	  
	  int randomNum=random.nextInt(1000-1)+1;
	  waithelper.waitForElement(driver, 4000,  fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetItemCategory());
	  fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetItemCategory().click();
	  fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetItemCategory().sendKeys(fixedAsset_AssetCategoryTestDataType.AssetItemCategory+randomNum);
	  //fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetItemCategory().sendKeys(Keys.ENTER);
	 
	  //AssetDescription
	  waithelper.waitForElement(driver, 4000,  fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetDescription());
	  fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetDescription().click();
	  fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetDescription().sendKeys(fixedAsset_AssetCategoryTestDataType.AssetDescription);
	  fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetDescription().sendKeys(Keys.ENTER);
	 
	    	
			 
	       
	    }

	    @Then("^Click on Fixed Asset Save button$")
	    public void click_on_fixed_asset_save_button() throws InterruptedException {
	    //Save	
	    waithelper.waitForElement(driver, 4000,  fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_Save());
	   	fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_Save().click();
	   	Thread.sleep(2000); 
	    	
	    
	    }

	    @Then("^Click on Fixed Asset Notification$")
	    public void click_on_fixed_asset_notification() {
	    //Notification
	    waithelper.waitForElement(driver, 4000,  fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_Notification());
	 	fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_Notification().click();
	 	   	
	      
	    }

	  	

}
