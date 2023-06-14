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
	FixedAsset_AssetCategoryTestDataType fixedAsset_AssetCategoryTestDataType = jsonReader.getAssetCategoryByName("Maker");
	BrowserHelper browserHelper = new BrowserHelper(driver) ;
	JavascriptHelper javascripthelper = new JavascriptHelper();
	
	@Then("^click on Asset Sale Report$")
    public void click_on_asset_sale_report(){
	//Asset Code	
	 waithelper.waitForElement(driver, 4000, fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetSaleReport());
	 fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetSaleReport().click();
	  
    }
	@Then("^Select the Asset Sale Code$")
    public void select_the_asset_sale_code()  {
    //Asset sale Code	
     waithelper.waitForElement(driver, 4000, fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetSaleCode());
     fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetSaleCode().click();
     fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetSaleCode().sendKeys(fixedAsset_AssetCategoryTestDataType.AssetSaleCode);
     fixedAsset_AssetGlConfigurationObj.fixedAsset_AssetSaleCode().sendKeys(Keys.ENTER);
         
    }

    @Then("^Select the date Asset Sale$")
    public void select_the_date_asset_sale(){
    	//select Transaction from date
 		waithelper.waitForElement(driver, 3000, fixedAsset_AssetGlConfigurationObj.fixedAsset_CalendarFromDate());
 		fixedAsset_AssetGlConfigurationObj.fixedAsset_CalendarFromDate().click();
 	
 		javascripthelper.JavaScriptHelper(driver);
 		while(true)
         {
 		try
 		{
 		
 			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+fixedAsset_AssetCategoryTestDataType.FromMonth+" "+fixedAsset_AssetCategoryTestDataType.Year+"')]")));
 			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+fixedAsset_AssetCategoryTestDataType.FromMonth+" "+fixedAsset_AssetCategoryTestDataType.Year+"')]"));
 		    break;
 		}
 		
 		catch(NoSuchElementException nosuchElement)
 		{
 			fixedAsset_AssetGlConfigurationObj.fixedAsset_NextMonth().click();
 		}
 		}
 		WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+fixedAsset_AssetCategoryTestDataType.FromFullMonth+" "+fixedAsset_AssetCategoryTestDataType.FromDay+", "+fixedAsset_AssetCategoryTestDataType.Year+"']/span"));
 		clicksAndActionHelper.doubleClick(FinalDay);	
    }
    @Then("^verify the Asset Sale report$")
    public void verify_the_asset_sale_report() throws InterruptedException{
    	javascripthelper.JavaScriptHelper(driver);
    	browserHelper.SwitchToWindow(1);
    	Thread.sleep(2000);
    	browserHelper.switchToParentWithChildClose();   
    }
}
