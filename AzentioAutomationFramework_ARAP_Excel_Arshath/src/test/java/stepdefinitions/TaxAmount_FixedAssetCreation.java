package stepdefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ACCOUNTSPAYABLE_InvoiceBookingObj;
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
import pageobjects.FixedAsset_AssetCreationObj;
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;

public class TaxAmount_FixedAssetCreation {

	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	ConfigFileReader config = new ConfigFileReader();
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(driver);
	
	WaitHelper waithelper = new WaitHelper(driver);
	ACCOUNTSPAYABLE_InvoiceBookingObj aCCOUNTSPAYABLE_InvoiceBookingObj = new ACCOUNTSPAYABLE_InvoiceBookingObj(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter reader;
	BrowserHelper browserHelper;
	FixedAsset_AssetCreationObj fixedAsset_AssetCreationObj = new FixedAsset_AssetCreationObj(driver);
	
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	ExcelData excelData = new ExcelData("C:\\Users\\inindc00089\\eclipse-workspace\\AzentioAutomationFramework_ARAP\\Test-data\\KUBSTestData.xlsx","TaxAmount_FixedAssetCreation", "DataSet ID");
	Map<String, String> testData = new HashMap<>();
	
	
	
	

	//---------------------------------------//
	@And("^user should navigate to fixed asset menu$")
	public void user_should_navigate_to_fixed_asset_menu() {
		waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_DirectionIcon(),60,5);
		fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_DirectionIcon().click();	
	waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAsset_AssetCreationObj.fixedAssets_Menu(),60,5);
	fixedAsset_AssetCreationObj.fixedAssets_Menu().click();
	}
	
	
	@When("^click on eye button of asset creation$")
    public void click_on_eye_button_of_asset_creation() {
		waithelper.waitForElement(driver, 3000, fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_EyeButton());
		fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_EyeButton().click();
    }
	@And("^click on add button to create asset record$")
	public void click_on_add_button_to_create_asset_record() {
		for(int i=1; i<=20; i++) {
			try{
				waithelper.waitForElement(driver, 3000, fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_AddButton());
				fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_AddButton().click();
				break;
				}
		catch(Exception e) {}}
		
	}
	@And("^update  data set id for Tax Amount is auto populated on Fixed Asset$")
    public void update_data_set_id_for_tax_amount_is_auto_populated_on_fixed_asset()   {
		testData = excelData.getTestdata("KUBS_AR_AP_UAT_001_001_TC_11_D1"); 
    }
	

	 @And("^Fill the required fields to create asset against GRN Ref number$")
		public void fill_the_required_fields_to_create_asset_against_GRN_Ref_number() {
		 for(int i=1; i<=20; i++) {
				try{
			
		 waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_BranchCode(), 20, 1);
		 fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_BranchCode().click();
			fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_BranchCode().sendKeys(testData.get("BranchCode") );
			fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_BranchCode().sendKeys(Keys.ENTER);
			break;
				}
		catch(Exception e) {}}
		 
		 for(int i=1; i<=20; i++) {
				try{
			waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_AssetCode(), 20, 1);
			fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_AssetCode().click();
			fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_AssetCode().sendKeys(testData.get("AssetCode") );
			fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_AssetCode().sendKeys(Keys.ENTER);
			break;
				}
		catch(Exception e) {}}
		 for(int i=1; i<=20; i++) {
				try{
			waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_GRN_ReferenceNumber(), 20, 1);
			fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_GRN_ReferenceNumber().click();
		    fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_GRN_ReferenceNumber().sendKeys(testData.get("GRNReferenceNumber"));
			fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_GRN_ReferenceNumber().sendKeys(Keys.ENTER);
			break;
		}
catch(Exception e) {}}
//			waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_BillReferenceNumber());
//			fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_BillReferenceNumber().sendKeys(fIXEDASSETS_AssetCreationTestDataType.BillReferenceNumber);
//			fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_BillReferenceNumber().sendKeys(Keys.ENTER);
		 for(int i=1; i<=20; i++) {
				try{
			waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_ExternalReferenceNumber(), 20, 1);
			fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_ExternalReferenceNumber().click();
			fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_ExternalReferenceNumber().sendKeys(testData.get("ExternalReferenceNumber"));
			fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_ExternalReferenceNumber().sendKeys(Keys.ENTER);
			break;
		}
catch(Exception e) {}}
//			waithelper.waitForElement(driver, 3000, fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_AssetLifeUnit());
//			fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_AssetLifeUnit().sendKeys(testData.get("AssetLifeUnit"));
//			fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_AssetLifeUnit().sendKeys(Keys.ENTER);
		}
	 
	 @Then("^Save the asset creation record against GRN Ref number$")
	  public void save_the_asset_creation_record_against_GRN_Ref_number() throws InterruptedException, IOException, ParseException{
	    	
	    	waithelper.waitForElement(driver, 3000, fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_SaveButton());
	    	fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_SaveButton().click();
	    	

	    	Thread.sleep(2000);
	    	javascripthelper.JavaScriptHelper(driver);
			String str = javascripthelper.executeScript(
					"return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText")
					.toString();
			System.out.println("Message:" + str);
	    	
			while(true) {
				try {
			waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.MessageContent());
			String mssg =aCCOUNTSPAYABLE_VendorContractsObj.MessageContent().getText();
			System.out.println(mssg);
			waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.ConfirmationMessageCloseButton());
			aCCOUNTSPAYABLE_VendorContractsObj.ConfirmationMessageCloseButton().click();
			break;
				}
				catch(Exception e) {}
			}
	    	
	    }
	 @Then("^Search Asset Creation record$")
	    public void search_asset_creation_record() throws InterruptedException  {
	    
		waithelper.waitForElementwithFluentwait(driver, fixedAsset_AssetCreationObj.InboxSearchIcon());
		fixedAsset_AssetCreationObj.InboxSearchIcon().click();
			
		waithelper.waitForElementwithFluentwait(driver, fixedAsset_AssetCreationObj.EventCodeSearch());
		fixedAsset_AssetCreationObj.EventCodeSearch().sendKeys(testData.get("EventCode"));
		fixedAsset_AssetCreationObj.EventCodeSearch().sendKeys(Keys.ENTER);
			

	    }
	 
	 @And("^navigate to fixed asset items tab to add item details$")
	    public void navigate_to_fixed_asset_items_tab_to_add_item_details() throws InterruptedException, IOException, ParseException{
	    	
	    	
	    	waithelper.waitForElement(driver, 2000, fixedAsset_AssetCreationObj.FirstReferenceId());
	    	String Reference_Id=fixedAsset_AssetCreationObj.FirstReferenceId().getText();
	    	excelData.updateTestData("KUBS_AR_AP_UAT_001_001_TC_11_D1", "ReferenceID", Reference_Id);
			
	    	System.out.println("ReferenceID:" +Reference_Id);
	    		
	    	for (int i = 1; i <=199; i++) {
	    		try {
	        waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAsset_AssetCreationObj.ActionButton(), 15, 1);
	        fixedAsset_AssetCreationObj.ActionButton().click();
	        break;
	    		}
	    	catch(Exception e) {
	    		if (i==199) {
	    		Assert.fail(e.getMessage());
	    			}
	    		}
	    		}
	    	
	    	Thread.sleep(1000);
	    	waithelper.waitForElement(driver, 3000, fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_FixedAssetItems());
	    	fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_FixedAssetItems().click();
	    	
	    }
	 @Then("^Fill the hsn code and verify the total tax amount is auto populated$")
	    public void Fill_the_hsn_code_and_verify_the_total_tax_amount_is_auto_populated() throws InterruptedException, IOException, ParseException{
	    	
	    	Thread.sleep(1000);
//	    	waithelper.waitForElement(driver, 3000, fIXEDASSETS_AssetCreationObj.fixedAssets_AssetCreation_InputTaxCreditValue());
	    	boolean enabled=fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_InputTaxCreditValue().isEnabled();
	    	System.out.println("The input tax credit value field is enabled - " +enabled);
	    	Thread.sleep(1000);
	    	waithelper.waitForElement(driver, 3000, fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_HSNcode());
	    	fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_HSNcode().click();
	    	fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_HSNcode().sendKeys(testData.get("HSNcode"));
	    	fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_HSNcode().sendKeys(Keys.ENTER);
	    	Thread.sleep(1000);
	    	String inputTaxCreditValue = javascripthelper.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[10].value").toString();
	    	System.out.println("Auto populated input tax credit value is - " +inputTaxCreditValue);
	    }
	 


}
