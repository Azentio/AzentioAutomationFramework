package stepdefinitions;

import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.Then;
import pageobjects.Azentio_CheckerObj;
import pageobjects.Azentio_ReviewerObj;
import pageobjects.FixedAsset_AssetCategoryObj;
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
	WaitHelper waithelper = new WaitHelper(driver);
	ClicksAndActionsHelper clickAndActions = new ClicksAndActionsHelper(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper();
	AzentioLogin login;
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	JsonDataReaderWriter reader = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	Azentio_ReviewerObj reviewer;
	BrowserHelper browserHelper;
	String referance_id;
	String user = "Maker";
	Azentio_CheckerObj kubschecker = new Azentio_CheckerObj(driver);
	BUDGET_BudgetCreationTestDataType budgetdata;
	FixedAsset_AssetCategoryObj fixedAsset_AssetCategoryObj = new FixedAsset_AssetCategoryObj(driver);

	FixedAsset_AssetCategoryTestDataType fixedAsset_AssetCategoryTestDataType = new FixedAsset_AssetCategoryTestDataType();

	
	
	
	
	
	
	 	@Then("^Click on Fixed Asset Direction icon$")
	    public void click_on_fixed_asset_direction_icon()  {
	 	waithelper = new WaitHelper(driver) ;
	 	waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_DirectionIcon(),60,5);
	 	fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_DirectionIcon().click();
	    
	        
	    }

	    @Then("^Click on Fixed assets configuration$")
	    public void click_on_fixed_assets_configuration()  {
	    waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_FixedAssetsConfiguration(),60,5);
		fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_FixedAssetsConfiguration().click();
		    
	       
	    }

	    @Then("^Click on Asset Category Eye button$")
	    public void click_on_asset_category_eye_button()  {
	    //Eye Button
	    waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_EyeIcon(),60,5);
	 	fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_EyeIcon().click();
	 		
	        
	    }

	    @Then("^Click on Fixed Asset Add button$")
	    public void click_on_fixed_asset_add_button()  {
	    //Add Button
	    //waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AddButton(),60,5);
	    	for (int i = 0; i <30; i++) {
				try {
					fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AddButton().click();
					break;
				} catch (Exception e) {
					if (i==29) {
						Assert.fail("add button not clicked");
					}
				}
			}
		
		 		
	        
	    }
	    
	    @Then("^Fill Asset Category Mandatory fields$")
	    public void fill_asset_category_mandatory_fields() throws InterruptedException {
	    fixedAsset_AssetCategoryTestDataType = jsonReader.getAssetCategoryByName("Maker");
	    Random random = new Random();
	  //Asset Category 	
	  waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetCategoryInputField(),60,5);
	  fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetCategoryInputField().click();
	  fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetCategoryInputField().sendKeys(fixedAsset_AssetCategoryTestDataType.AssetCategory);
	  fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetCategoryInputField().sendKeys(Keys.ENTER);
	 
	  //AssetSubCategory
	  waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetSubCategory(),60,5);
	  fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetSubCategory().click();
	  fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetSubCategory().sendKeys(fixedAsset_AssetCategoryTestDataType.AssetSubCategory);
	  fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetSubCategory().sendKeys(Keys.DOWN);
	  Thread.sleep(1000);
	  fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetSubCategory().sendKeys(Keys.ENTER);
	 
	  //AssetItemCategory
	  
	  int randomNum=random.nextInt(1000-1)+1;
	  waithelper.waitForElementToVisibleWithFluentWait(driver,fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetItemCategory(),60,5);
	  fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetItemCategory().click();
	  fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetItemCategory().sendKeys(fixedAsset_AssetCategoryTestDataType.AssetItemCategory+randomNum);
	  //fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetItemCategory().sendKeys(Keys.ENTER);
	 
	  //AssetDescription
	  waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetDescription(),60,5);
	  fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetDescription().click();
	  fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetDescription().sendKeys(fixedAsset_AssetCategoryTestDataType.AssetDescription);
	  fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AssetDescription().sendKeys(Keys.ENTER);
	 
	    	
			 
	       
	    }

	    @Then("^Click on Fixed Asset Save button$")
	    public void click_on_fixed_asset_save_button() throws InterruptedException {
	    //Save	
	    //waithelper.waitForElementToVisibleWithFluentWait(driver,fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_Save(),60,5);
	    	for (int i = 0; i < 20; i++) {
	    		try {
	    			fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_Save().click();
	    			break;
				} catch (Exception e) {
					
				}
				
			}
	   	
	  	Thread.sleep(2000); 
	    	
	    
	    }

	    @Then("^Click on Fixed Asset Notification$")
	    public void click_on_fixed_asset_notification() {
	    //Notification
		    waithelper.waitForElementToVisibleWithFluentWait(driver,fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_WorkflowInitiated(),30,2);
	    	fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_WorkflowInitiated().click();
	    	for (int i = 0; i <30; i++) {
				try {
					
					clickAndActions.moveToElement(fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AlertClose());
					fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AlertClose().click();
					break;
				} catch (Exception e) {
					
				}
			}
	    	
	   // waithelper.waitForElementToVisibleWithFluentWait(driver,fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_Notification(),60,5);
	 	for (int i = 0; i <30; i++) {
			try {
				fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_Notification().click();
				break;
			} catch (Exception e) {
				
			}
		}
		 	
	 	   	
	      
	    }

	  	

}
