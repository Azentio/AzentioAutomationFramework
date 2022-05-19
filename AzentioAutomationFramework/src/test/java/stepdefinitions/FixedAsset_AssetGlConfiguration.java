package stepdefinitions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import dataProvider.JsonConfig;
import helper.ClicksAndActionsHelper;
import helper.WaitHelper;
import io.cucumber.java.en.Then;
import pageobjects.FixedAsset_AssetGlConfigurationObj;
import resources.BaseClass;
import testDataType.FixedAsset_AssetCategoryTestDataType;

public class FixedAsset_AssetGlConfiguration extends BaseClass  {
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver) ;
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	FixedAsset_AssetGlConfigurationObj fixedAsset_AssetGlConfigurationObj = new FixedAsset_AssetGlConfigurationObj(driver);
	FixedAsset_AssetCategoryTestDataType fixedAsset_AssetCategoryTestDataType = jsonReader.getAssetCategoryByName("Maker");

	
	
	
	
	@Then("^Click on Asset GL configuration Eye button$")
    public void click_on_asset_gl_configuration_eye_button()  {
	//Eye Button
	waithelper.waitForElement(driver, 4000,  fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_EyeIcon());
	fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_EyeIcon().click();
		     
    }

    @Then("^Fill Asset GL configuration Mandatory fields$")
    public void fill_asset_gl_configuration_mandatory_fields() throws InterruptedException  {
     fixedAsset_AssetCategoryTestDataType = jsonReader.getAssetCategoryByName("Maker");
    	 
    	 
    //Asset Code	
    waithelper.waitForElement(driver, 4000, fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AssetCode());
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AssetCode().click();
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AssetCode().sendKeys(fixedAsset_AssetCategoryTestDataType.AssetCode);
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AssetCode().sendKeys(Keys.DOWN);
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AssetCode().sendKeys(Keys.ENTER);
    Thread.sleep(2000);
    //FixedAssetGL
    waithelper.waitForElement(driver, 4000, fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_FixedAssetGL());
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_FixedAssetGL().click();
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_FixedAssetGL().sendKeys(fixedAsset_AssetCategoryTestDataType.FixedAssetGL);
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_FixedAssetGL().sendKeys(Keys.ENTER);
    
    //AccumulatedDepreciationGL
    waithelper.waitForElement(driver, 4000, fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AccumulatedDepreciationGL());
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AccumulatedDepreciationGL().click();
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AccumulatedDepreciationGL().sendKeys(fixedAsset_AssetCategoryTestDataType.AccumulatedDepreciationGL);
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AccumulatedDepreciationGL().sendKeys(Keys.ENTER);
    
    //DepreciationGL
    waithelper.waitForElement(driver, 4000, fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_DepreciationGL());
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_DepreciationGL().click();
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_DepreciationGL().sendKeys(fixedAsset_AssetCategoryTestDataType.DepreciationGL);
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_DepreciationGL().sendKeys(Keys.ENTER);
    
    //ProfitOnSaleGL
    waithelper.waitForElement(driver, 4000, fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_ProfitOnSaleGL());
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_ProfitOnSaleGL().click();
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_ProfitOnSaleGL().sendKeys(fixedAsset_AssetCategoryTestDataType.ProfitOnSaleGL);
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_ProfitOnSaleGL().sendKeys(Keys.ENTER);
    
    //lossOnSaleGL
    waithelper.waitForElement(driver, 4000, fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_lossOnSaleGL());
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_lossOnSaleGL().click();
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_lossOnSaleGL().sendKeys(fixedAsset_AssetCategoryTestDataType.lossOnSaleGL);
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_lossOnSaleGL().sendKeys(Keys.ENTER);
    
    //WriteOffGL
    waithelper.waitForElement(driver, 4000, fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_WriteOffGL());
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_WriteOffGL().click();
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_WriteOffGL().sendKeys(fixedAsset_AssetCategoryTestDataType.WriteOffGL);
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_WriteOffGL().sendKeys(Keys.ENTER);
    
    //ImpairmentLossGL
    waithelper.waitForElement(driver, 4000, fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_ImpairmentLossGL());
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_ImpairmentLossGL().click();
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_ImpairmentLossGL().sendKeys(fixedAsset_AssetCategoryTestDataType.ImpairmentLossGL);
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_ImpairmentLossGL().sendKeys(Keys.ENTER);
    
    //AccumulatedImpairmentLossGL
    waithelper.waitForElement(driver, 4000, fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AccumulatedImpairmentLossGL());
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AccumulatedImpairmentLossGL().click();
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AccumulatedImpairmentLossGL().sendKeys(fixedAsset_AssetCategoryTestDataType.AccumulatedImpairmentLossGL);
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AccumulatedImpairmentLossGL().sendKeys(Keys.ENTER);
    
    //RevaluationSurplusGL
    waithelper.waitForElement(driver, 4000, fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_RevaluationSurplusGL());
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_RevaluationSurplusGL().click();
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_RevaluationSurplusGL().sendKeys(fixedAsset_AssetCategoryTestDataType.RevaluationSurplusGL);
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_RevaluationSurplusGL().sendKeys(Keys.ENTER);
    
        
    }

}
