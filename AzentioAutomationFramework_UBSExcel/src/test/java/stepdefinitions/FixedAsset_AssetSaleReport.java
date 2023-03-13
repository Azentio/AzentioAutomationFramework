package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.Then;
import pageobjects.FixedAsset_AssetGlConfigurationObj;
import resources.BaseClass;
import testDataType.FixedAsset_AssetCategoryTestDataType;

public class FixedAsset_AssetSaleReport extends BaseClass  {
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver) ;
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	FixedAsset_AssetGlConfigurationObj fixedAsset_AssetGlConfigurationObj = new FixedAsset_AssetGlConfigurationObj(driver);
	
	BrowserHelper browserHelper = new BrowserHelper(driver) ;
	JavascriptHelper javascripthelper = new JavascriptHelper();
	
	@Then("^click on Asset Sale Report$")
    public void click_on_asset_sale_report(){
	//Asset Code	
	 waithelper.waitForElement(driver, 4000, fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetSaleReport());
	 fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetSaleReport().click();
	  
    }
	

    @Then("^verify the Asset Sale report$")
    public void verify_the_asset_sale_report() throws InterruptedException{
    	javascripthelper.JavaScriptHelper(driver);
    	browserHelper.SwitchToWindow(1);
    	Thread.sleep(2000);
    	browserHelper.switchToParentWithChildClose();   
    }
}
