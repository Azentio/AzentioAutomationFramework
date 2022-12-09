package stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import dataProvider.JsonConfig;
import helper.ClicksAndActionsHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
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
	Map<String,String> codeConfigData= new HashMap<>();
	
	
	
	
	@Then("^Click on Asset GL configuration Eye button$")
    public void click_on_asset_gl_configuration_eye_button()  {
	//Eye Button
	waithelper.waitForElementToVisibleWithFluentWait(driver,   fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_EyeIcon(),30,2);
	fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_EyeIcon().click();
		     
    }
	@And("^get the active asset code in asset category modules$")
    public void get_the_active_asset_code_in_asset_category_modules() throws Throwable {
		waithelper.waitForElementVisible(driver.findElement(By.xpath("//datatable-row-wrapper[1]//datatable-body-cell[2]//span")), 3000, 300);
	     //driver.findElement(By.xpath("//datatable-row-wrapper[1]//datatable-body-cell[2]//span")).getText();
	     codeConfigData.put("AssetCode", driver.findElement(By.xpath("//datatable-row-wrapper[1]//datatable-body-cell[2]//span")).getText());
	     System.out.println( driver.findElement(By.xpath("//datatable-row-wrapper[1]//datatable-body-cell[2]//span")).getText());
     
    }
	
    @Then("^Fill Asset GL configuration Mandatory fields$")
    public void fill_asset_gl_configuration_mandatory_fields() throws InterruptedException  {
     fixedAsset_AssetCategoryTestDataType = jsonReader.getAssetCategoryByName("Maker");
    	 
    	 
    //Asset Code	
    waithelper.waitForElementToVisibleWithFluentWait(driver,  fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AssetCode(),60,5);
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AssetCode().click();
   // fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AssetCode().sendKeys(fixedAsset_AssetCategoryTestDataType.AssetCode);
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AssetCode().sendKeys(codeConfigData.get("AssetCode"));
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AssetCode().sendKeys(Keys.DOWN);
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AssetCode().sendKeys(Keys.ENTER);
    Thread.sleep(2000);
    //FixedAssetGL
    waithelper.waitForElementToVisibleWithFluentWait(driver,  fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_FixedAssetGL(),60,5);
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_FixedAssetGL().click();
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_FixedAssetGL().sendKeys(fixedAsset_AssetCategoryTestDataType.FixedAssetGL);
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_FixedAssetGL().sendKeys(Keys.DOWN);
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_FixedAssetGL().sendKeys(Keys.ENTER);
    
    //AccumulatedDepreciationGL
    waithelper.waitForElementToVisibleWithFluentWait(driver,  fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AccumulatedDepreciationGL(),60,5);
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AccumulatedDepreciationGL().click();
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AccumulatedDepreciationGL().sendKeys(fixedAsset_AssetCategoryTestDataType.AccumulatedDepreciationGL);
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AccumulatedDepreciationGL().sendKeys(Keys.DOWN);
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AccumulatedDepreciationGL().sendKeys(Keys.ENTER);
    
    //DepreciationGL
    waithelper.waitForElementToVisibleWithFluentWait(driver,  fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_DepreciationGL(),60,5);
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_DepreciationGL().click();
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_DepreciationGL().sendKeys(fixedAsset_AssetCategoryTestDataType.DepreciationGL);
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_DepreciationGL().sendKeys(Keys.DOWN);
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_DepreciationGL().sendKeys(Keys.ENTER);
    
    //ProfitOnSaleGL
    waithelper.waitForElementToVisibleWithFluentWait(driver,  fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_ProfitOnSaleGL(),60,5);
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_ProfitOnSaleGL().click();
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_ProfitOnSaleGL().sendKeys(fixedAsset_AssetCategoryTestDataType.ProfitOnSaleGL);
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_ProfitOnSaleGL().sendKeys(Keys.DOWN);
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_ProfitOnSaleGL().sendKeys(Keys.ENTER);
    
    //lossOnSaleGL
    waithelper.waitForElementToVisibleWithFluentWait(driver,  fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_lossOnSaleGL(),60,5);
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_lossOnSaleGL().click();
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_lossOnSaleGL().sendKeys(fixedAsset_AssetCategoryTestDataType.lossOnSaleGL);
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_lossOnSaleGL().sendKeys(Keys.DOWN);
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_lossOnSaleGL().sendKeys(Keys.ENTER);
    
    //WriteOffGL
    waithelper.waitForElementToVisibleWithFluentWait(driver,  fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_WriteOffGL(),60,5);
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_WriteOffGL().click();
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_WriteOffGL().sendKeys(fixedAsset_AssetCategoryTestDataType.WriteOffGL);
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_WriteOffGL().sendKeys(Keys.DOWN);
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_WriteOffGL().sendKeys(Keys.ENTER);
    
    //ImpairmentLossGL
    waithelper.waitForElementToVisibleWithFluentWait(driver,  fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_ImpairmentLossGL(),60,5);
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_ImpairmentLossGL().click();
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_ImpairmentLossGL().sendKeys(fixedAsset_AssetCategoryTestDataType.ImpairmentLossGL);
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_ImpairmentLossGL().sendKeys(Keys.DOWN);
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_ImpairmentLossGL().sendKeys(Keys.ENTER);
    
    //AccumulatedImpairmentLossGL
    waithelper.waitForElementToVisibleWithFluentWait(driver,  fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AccumulatedImpairmentLossGL(),60,5);
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AccumulatedImpairmentLossGL().click();
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AccumulatedImpairmentLossGL().sendKeys(fixedAsset_AssetCategoryTestDataType.AccumulatedImpairmentLossGL);
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AccumulatedImpairmentLossGL().sendKeys(Keys.DOWN);
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_AccumulatedImpairmentLossGL().sendKeys(Keys.ENTER);
    
    //RevaluationSurplusGL
    waithelper.waitForElementToVisibleWithFluentWait(driver,fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_RevaluationSurplusGL(),60,5);
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_RevaluationSurplusGL().click();
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_RevaluationSurplusGL().sendKeys(fixedAsset_AssetCategoryTestDataType.RevaluationSurplusGL);
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_RevaluationSurplusGL().sendKeys(Keys.DOWN);
    fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetGlConfiguration_RevaluationSurplusGL().sendKeys(Keys.ENTER);
    
        
    }

}
