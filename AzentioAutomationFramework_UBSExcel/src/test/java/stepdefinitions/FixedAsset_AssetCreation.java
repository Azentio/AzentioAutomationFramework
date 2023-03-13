package stepdefinitions;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Random;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataProvider.JsonConfig;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.FIXEDASSETS_AssetSaleObj;
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
	FIXEDASSETS_AssetSaleObj fIXEDASSETS_AssetSaleObj = new FIXEDASSETS_AssetSaleObj(driver);
//	FixedAsset_AssetCreationTestDataType fixedAsset_AssetCreationTestDataType = new FixedAsset_AssetCreationTestDataType();
	

	
	

	
		 
	  

	    
	    @Then("^click on report icon$")
	    public void click_on_report_icon() throws InterruptedException {
	    	Thread.sleep(2000);
	    	javascripthelper.JavaScriptHelper(driver);
	    	javascripthelper.scrollIntoViewAndClick(fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_ReportIcon());
	    }

	    @When("^click on eye button of asset creation$")
	    public void click_on_eye_button_of_asset_creation() {
			waithelper.waitForElement(driver, 3000, fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_EyeButton());
			fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_EyeButton().click();
	    }
		
		@And("^click on add button to create asset record$")
		public void click_on_add_button_to_create_asset_record() {
			waithelper.waitForElement(driver, 3000, fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_AddButton());
			fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_AddButton().click();
		}
	
		 
		 @Then("^Save the asset creation record against GRN Ref number$")
		    public void save_the_asset_creation_record_against_GRN_Ref_number() throws InterruptedException, IOException, ParseException{
		    	
		    	waithelper.waitForElement(driver, 3000, fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_SaveButton());
		    	fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_SaveButton().click();
		    	
		    }
		 
		 @And("^navigate to fixed asset items tab to add item details$")
		    public void navigate_to_fixed_asset_items_tab_to_add_item_details() throws InterruptedException, IOException, ParseException{
		    	
		    	Thread.sleep(2000);
		    	javascripthelper.JavaScriptHelper(driver);
				String str = javascripthelper.executeScript(
						"return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText")
						.toString();
				System.out.println("Message:" + str);
		    	
		    	waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_NotificationButton());
		    	fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_NotificationButton().click();
		    	
		    	waithelper.waitForElement(driver, 2000, fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_FirstReferenceId());
		    	String id=fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_FirstReferenceId().getText();
		    	jsonWriter.addReferanceData(id);
				System.out.println("Reference ID:" +id);
		    	for (int i = 1; i <= 35; i++) {
					try {
				    	waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +jsonWriter.readReferancedata()+ "')]")));	
						WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" +  jsonWriter.readReferancedata() + "')]"));	
						waithelper.waitForElement(driver, i, referanceID);
						referanceID.click();
				    	System.out.println(referanceID);
//						Assert.assertTrue(referanceID.isDisplayed());
						break;
					} catch (NoSuchElementException e) {
						waithelper.waitForElement(driver,4000,fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_NotificationNextButton());
						fIXEDASSETS_AssetSaleObj.fixedAssets_AssetSale_NotificationNextButton().click();
					}
				}
		    	String before_xpath="//span[contains(text(),'";
		    	String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button"; 
		    	waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath +jsonWriter.readReferancedata()+after_xpath)));
		    	driver.findElement(By.xpath(before_xpath +jsonWriter.readReferancedata() +after_xpath)).click();
		    	
		    	Thread.sleep(1000);
		    	waithelper.waitForElement(driver, 3000, fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_FixedAssetItems());
		    	fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_FixedAssetItems().click();
		    	
		    }
		 
		
	    
	    

}