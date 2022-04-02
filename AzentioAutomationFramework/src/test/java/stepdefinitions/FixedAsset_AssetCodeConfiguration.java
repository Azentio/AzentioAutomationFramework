package stepdefinitions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import dataProvider.JsonConfig;
import helper.ClicksAndActionsHelper;
import helper.WaitHelper;
import io.cucumber.java.en.Then;
import pageobjects.FixedAsset_AssetCodeConfigurationObj;
import resources.BaseClass;
import testDataType.FixedAsset_AssetCategoryTestDataType;

public class FixedAsset_AssetCodeConfiguration extends BaseClass {
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver) ;
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	FixedAsset_AssetCodeConfigurationObj fixedAsset_AssetCodeConfigurationObj = new FixedAsset_AssetCodeConfigurationObj(driver);
	FixedAsset_AssetCategoryTestDataType fixedAsset_AssetCategoryTestDataType = jsonReader.getAssetCategoryByName("Maker");
	String AssetCode;
	
	/*@Then("^Select the Asset code from the list$")
    public void select_the_asset_code_from_the_list() throws InterruptedException  {
	Thread.sleep(2000);
   	 waithelper.waitForElement(driver, 2000,fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetCodeSelect());
   	  AssetCode = fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetCodeSelect().getText();
   	 System.out.println(AssetCode);
   	 
    }*/
	
	@Then("^Click on Asset code configuration Eye button$")
    public void click_on_asset_code_configuration_eye_button()  {
	//Eye Button
	 waithelper.waitForElement(driver, 4000,  fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_EyeIcon());
	 fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_EyeIcon().click();
	 	
       
    }
	
	
	 @Then("^Fill Asset code configuration Mandatory fields$")
	 public void fill_asset_code_configuration_mandatory_fields()  {
		 
	 fixedAsset_AssetCategoryTestDataType = jsonReader.getAssetCategoryByName("Maker");
	 
	 
	 //Asset Code	
	  waithelper.waitForElement(driver, 4000, fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetCode());
	  fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetCode().click();
	  fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetCode().sendKeys(fixedAsset_AssetCategoryTestDataType.AssetCode);
	 fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetCode().sendKeys(Keys.ENTER);
	 
		 
	  //AccountingModel	
	  waithelper.waitForElement(driver, 4000, fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AccountingModel());
	  fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AccountingModel().click();
	  fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AccountingModel().sendKeys(fixedAsset_AssetCategoryTestDataType.AccountingModel);
	  fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AccountingModel().sendKeys(Keys.ENTER);
	 
	  //AssetLifeUnit	
	  waithelper.waitForElement(driver, 4000, fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetLifeUnit());
	  fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetLifeUnit().click();
	  fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetLifeUnit().sendKeys(fixedAsset_AssetCategoryTestDataType.AssetLifeUnit);
	  fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetLifeUnit().sendKeys(Keys.ENTER);
	  
	  //AssetLife
	  waithelper.waitForElement(driver, 4000, fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetLife());
	  fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetLife().click();
	  fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetLife().sendKeys(fixedAsset_AssetCategoryTestDataType.AssetLife);
	  fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_AssetLife().sendKeys(Keys.ENTER);
	  
	 //BasisForDeperciation
	  waithelper.waitForElement(driver, 4000, fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_BasisForDeperciation());
	  fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_BasisForDeperciation().click();
	  fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_BasisForDeperciation().sendKeys(fixedAsset_AssetCategoryTestDataType.BasisForDeperciation);
	  fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_BasisForDeperciation().sendKeys(Keys.ENTER);
	  
	 //DeperciationMethod
	  waithelper.waitForElement(driver, 4000, fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_DeperciationMethod());
	  fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_DeperciationMethod().click();
	  fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_DeperciationMethod().sendKeys(fixedAsset_AssetCategoryTestDataType.DeperciationMethod);
	  fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_DeperciationMethod().sendKeys(Keys.ENTER);
	  
	 //DeperciationRoundingMethod
	  waithelper.waitForElement(driver, 4000, fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_DeperciationRoundingMethod());
	  fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_DeperciationRoundingMethod().click();
	  fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_DeperciationRoundingMethod().sendKeys(fixedAsset_AssetCategoryTestDataType.DeperciationRoundingMethod);
	  fixedAsset_AssetCodeConfigurationObj.fixedAsset_AssetCodeConfiguration_DeperciationRoundingMethod().sendKeys(Keys.ENTER);
	  
	 
		 
	        
	    }

}
