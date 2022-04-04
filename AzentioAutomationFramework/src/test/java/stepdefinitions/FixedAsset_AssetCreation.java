package stepdefinitions;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataProvider.JsonConfig;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.Then;
import pageobjects.FixedAsset_AssetCreationObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.FixedAsset_AssetCreationTestDataType;

public class FixedAsset_AssetCreation extends BaseClass {
	
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	JsonDataReaderWriter reader = new JsonDataReaderWriter();
	JavascriptHelper javascripthelper = new JavascriptHelper();
	WaitHelper waithelper = new WaitHelper(driver);
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	FixedAsset_AssetCreationObj fixedAsset_AssetCreationObj = new FixedAsset_AssetCreationObj(driver);
	FixedAsset_AssetCreationTestDataType fixedAsset_AssetCreationTestDataType = new FixedAsset_AssetCreationTestDataType();

	
	@Then("^Fill Form asset Creation$")
	public void fill_form_asset_Creation()  {
		fixedAsset_AssetCreationTestDataType = jsonReader.getAssetCreationByName("Maker");

		waithelper.waitForElement(driver, 2000, fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_BranchCode_Textbox());
		fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_BranchCode_Textbox().click();
		fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_BranchCode_Textbox().sendKeys(fixedAsset_AssetCreationTestDataType.BranchCode);
		fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_BranchCode_Textbox().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 2000, fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetCode_Textbox());
		fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetCode_Textbox().click();
		fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetCode_Textbox().sendKeys(fixedAsset_AssetCreationTestDataType.AssetCode);
		fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetCode_Textbox().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 2000, fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_BillReferenceNumber_Textbox());
		fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_BillReferenceNumber_Textbox().click();
		fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_BillReferenceNumber_Textbox().sendKeys(fixedAsset_AssetCreationTestDataType.BillReferenceNo);
		fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_BillReferenceNumber_Textbox().sendKeys(Keys.ENTER);
		
	}

	
		 
	    @Then("^fill the asset item details asset Creation$")
	    public void fill_the_asset_item_details_asset_Creation() throws Throwable  {
	    //item details
	    	
	    	fixedAsset_AssetCreationTestDataType = jsonReader.getAssetCreationByName("Maker");
	    	
	    	waithelper.waitForElement(driver, 2000,fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemNumber());
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemNumber().click();
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemNumber().sendKeys(fixedAsset_AssetCreationTestDataType.AssetItemNumber);
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemNumber().sendKeys(Keys.ENTER);
	    	
	    	waithelper.waitForElement(driver, 2000,fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemDescription());
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemDescription().click();
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemDescription().sendKeys(fixedAsset_AssetCreationTestDataType.AssetItemDescription);
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemDescription().sendKeys(Keys.ENTER);
	       
	    	waithelper.waitForElement(driver, 2000,fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetValue());
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetValue().click();
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetValue().sendKeys(fixedAsset_AssetCreationTestDataType.AssetValue);
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetValue().sendKeys(Keys.ENTER);
	       
	    	waithelper.waitForElement(driver, 2000,fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_SalvageValue());
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_SalvageValue().click();
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_SalvageValue().sendKeys(fixedAsset_AssetCreationTestDataType.SalvageValue);
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_SalvageValue().sendKeys(Keys.ENTER);
	       
	    	
	    	//Calendar
	    	javascripthelper.JavaScriptHelper(driver);
	    	fixedAsset_AssetCreationTestDataType= jsonReader.getAssetCreationByName("Maker");
	    	
	    	ClicksAndActionsHelper clickAndActionHelper=new ClicksAndActionsHelper(driver);
	    	waithelper.waitForElement(driver, 2000,fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemCalendar());
	    	fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AssetItemCalendar().click();
	    	//Thread.sleep(1000);
	    	while(true)
	        {
			try
			{
			
				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+fixedAsset_AssetCreationTestDataType.GlToMonth+" "+fixedAsset_AssetCreationTestDataType.GlYear+"')]")));
				WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+fixedAsset_AssetCreationTestDataType.GlToMonth+" "+fixedAsset_AssetCreationTestDataType.GlYear+"')]"));
				Thread.sleep(1000);
				break;
			}
			
			catch(NoSuchElementException nosuchElement)
			{
				fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_NextMonth().click();
			}
			}
	    	Thread.sleep(1000);
			WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+fixedAsset_AssetCreationTestDataType.GlFullToMonth+" "+fixedAsset_AssetCreationTestDataType.GlToDate+", "+fixedAsset_AssetCreationTestDataType.GlYear+"']/span"));
			clickAndActionHelper.doubleClick(FinalDay);
			
	    }
	    
	    @Then("^click on report icon$")
	    public void click_on_report_icon() {
	    	javascripthelper.JavaScriptHelper(driver);
	    	javascripthelper.scrollIntoViewAndClick(fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_ReportIcon());
	    }

	
	    
	    

}