package stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataProvider.JsonConfig;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.FIXEDASSETS_AssetImpairementObj;
import pageobjects.FIXEDASSET_AssetAmmendentObj;
import pageobjects.FIXEDASSET_AssetReturnObj;
import pageobjects.FIXEDASSET_AssetRevalueationObj;
import pageobjects.FIXEDASSET_fixedAssetObj;
import pageobjects.FIXED_ASSET_AssetDeAllocationObj;
import resources.BaseClass;
import testDataType.FIXEDASSET_AssetReturnTestData;

public class FIXEDASSET_AssetReturn extends BaseClass{
	WebDriver driver=BaseClass.driver;
	WaitHelper waitHelper=new WaitHelper(driver);
	JavascriptHelper javascriptHelper=new JavascriptHelper();
	FIXEDASSET_AssetReturnObj assetReturnObj=new FIXEDASSET_AssetReturnObj(driver);
	Map<String,String> assetReferenceNo=new HashMap<String,String>();
	JsonConfig jsonConfig=new JsonConfig();
	FIXEDASSET_AssetReturnTestData assetReturnTestData=jsonConfig.getFixedAssetReturnTestDataByUserName("Maker");
	FIXEDASSET_fixedAssetObj fixedAssetObj=new FIXEDASSET_fixedAssetObj(driver);
	FIXEDASSET_AssetRevalueationObj assetRevaluvationObj=new FIXEDASSET_AssetRevalueationObj(driver);
	FIXEDASSET_AssetAmmendentObj assetAmmendmentObj=new FIXEDASSET_AssetAmmendentObj(driver);
	FIXEDASSETS_AssetImpairementObj assetImpairementObj=new FIXEDASSETS_AssetImpairementObj(driver);
	FIXED_ASSET_AssetDeAllocationObj fixedAsset_AssetDeallocationObj = new FIXED_ASSET_AssetDeAllocationObj(driver);
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	public String revaluedAssetReferenceNo; 
	@And("^click on view button nearby asset return module$")
    public void click_on_view_button_nearby_asset_return_module() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		//waitHelper.waitForElementVisible(AssetReturnObj.fixedAssetAssetReturnViewButton(), 2000, 100);
		javascriptHelper.scrollIntoView(assetReturnObj.fixedAssetAssetReturnViewButton());
		assetReturnObj.fixedAssetAssetReturnViewButton().click();
    }
	@Then("^goto ammendent asset module$")
    public void goto_ammendent_asset_module() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		//waitHelper.waitForElementVisible(fixedAssetObj.fixedAssetAssetAmmendent(),1000, 100);
		javascriptHelper.scrollIntoView(fixedAssetObj.fixedAssetAssetAmmendent());
		fixedAssetObj.fixedAssetAssetAmmendent().click();
		
    }
	@Then("^Enter Asset Referance Number in ammendent asset$")
    public void enter_asset_referance_number_in_ammendent_asset() throws Throwable {
		// ---------ENTER THE REQUEST REFERANCE NUMBER---------//
		waitHelper.waitForElement(driver, 2000, assetAmmendmentObj.fixed_AssetReferenceNumber());
		assetAmmendmentObj.fixed_AssetReferenceNumber().sendKeys(assetReturnTestData.assetReferenceNumberOFAmmendentAsset);
		assetAmmendmentObj.fixed_AssetReferenceNumber().sendKeys(Keys.ENTER);
    }
	
	

	@And("^Enter Asset Item Number$")
	public void enter_asset_item_number() throws Throwable {

		// ----------ENTER ASSET ITEM NUMBER-----------//
		waitHelper.waitForElement(driver, 2000, assetAmmendmentObj.fixed_AssetItemCode());
		assetAmmendmentObj.fixed_AssetItemCode().click();
		assetAmmendmentObj.fixed_AssetItemCode().sendKeys(Keys.DOWN);
		assetAmmendmentObj.fixed_AssetItemCode().sendKeys(Keys.ENTER);
	}

    @Then("^Choose Modification Type Which need$")
    public void choose_modification_type_which_need() throws Throwable {
    	
		// -----------CHOOSE THE MODIFICATION TYPE-----------//
		waitHelper.waitForElement(driver, 2000, assetAmmendmentObj.fixed_ModificationType());
		assetAmmendmentObj.fixed_ModificationType().click();
		assetAmmendmentObj.fixed_ModificationType().sendKeys(assetReturnTestData.assetLife);
		assetAmmendmentObj.fixed_ModificationType().sendKeys(Keys.ENTER);
    }

	@And("^Enter Asset Life Value$")
	public void enter_asset_life_value() throws Throwable {

		// ----------------ENTER ASSET VALUE----------------//
		waitHelper.waitForElement(driver, 2000, assetAmmendmentObj.fixed_AssetLife());
		assetAmmendmentObj.fixed_AssetLife().click();
		assetAmmendmentObj.fixed_AssetLife().clear();
		assetAmmendmentObj.fixed_AssetLife().sendKeys(assetReturnTestData.assetLifeValue);
		String ammendentAssetReferenceNo = assetRevaluvationObj.fixed_AssetGetReferenceNumber().getText();
		 System.out.println(ammendentAssetReferenceNo);
		 assetReferenceNo.put("AssetReferenceNumber", ammendentAssetReferenceNo);
		 System.out.println(assetReferenceNo.get("AssetReferenceNumber"));
	}
	@Then("^Save the Asset Record$")
	public void save_the_asset_record() throws Throwable {
		waitHelper.waitForElement(driver, 2000, assetAmmendmentObj.AssetAmendment_Save());
		assetAmmendmentObj.AssetAmendment_Save().isDisplayed();
		waitHelper.waitForElement(driver, 2000, assetAmmendmentObj.AssetAmendment_Save());
		assetAmmendmentObj.AssetAmendment_Save().click();
	}
	

	
	@And("^choose asset reference number$")
    public void choose_asset_reference_number() throws Throwable {
		assetReturnObj.assetReturnAssetReferenceNumber().click();
		assetReturnObj.assetReturnAssetReferenceNumber().sendKeys(assetReturnTestData.assetReferenceNumber);
		assetReturnObj.assetReturnAssetReferenceNumber().sendKeys(Keys.DOWN);
		assetReturnObj.assetReturnAssetReferenceNumber().sendKeys(Keys.ENTER);
		String assetReferenceNumber=assetReturnObj.fixedAssetGetReferenceNo().getText();
		assetReferenceNo.put("AssetReferenceNumber",assetReferenceNumber );
    }
	
	 @Then("^Give Asset Referance Number$")
	 public void give_asset_referance_number() throws Throwable {

	 // -----------ENTER ASSET REF NO---------------//
	 waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_AssetReferenceNumber());
	 assetRevaluvationObj.fixed_AssetReferenceNumber().sendKeys(assetReturnTestData.assetReferenceNumberOFRevaluedAsset);
	 assetRevaluvationObj.fixed_AssetReferenceNumber().sendKeys(Keys.ENTER);
	 waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_AssetGetReferenceNumber());
	 revaluedAssetReferenceNo = assetRevaluvationObj.fixed_AssetGetReferenceNumber().getText();
	 System.out.println(revaluedAssetReferenceNo);
	 assetReferenceNo.put("AssetReferenceNumber", revaluedAssetReferenceNo);
	 }

	 @And("^Select Asset Item Number$")
	 public void select_asset_item_number() throws Throwable {

	 // --------------ASSET ITEM NUMBER---------------//
	 waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_AssetItemCode());
	 assetRevaluvationObj.fixed_AssetItemCode().click();
	 assetRevaluvationObj.fixed_AssetItemCode().sendKeys(Keys.DOWN);
	 assetRevaluvationObj.fixed_AssetItemCode().sendKeys(Keys.ENTER);
	 }

	 @Then("^Alter the Book Value$")
	 public void alter_the_book_value() throws Throwable {

	 // --------------ALTER THE BOOK VALUE---------------//
	 waitHelper.waitForElement(driver, 2000, assetRevaluvationObj.fixed_AssetBookValue());
	 assetRevaluvationObj.fixed_AssetBookValue().clear();
	 assetRevaluvationObj.fixed_AssetBookValue().sendKeys(assetReturnTestData.bookValue);

	 }

	 @Then("^save the Revaluation record$")
	 public void save_the_revaluation_record() throws Throwable {

	 // -----------------SAVE THE RECORD---------------//
	 waitHelper.waitForElement(driver, 3000, assetRevaluvationObj.AssetRevaluvation_Save());
	 assetRevaluvationObj.AssetRevaluvation_Save().click();
	 }

	
	
   /* @And("^check if the reference number is availabe in list$")
    public void check_if_the_reference_number_is_availabe_in_list() throws Throwable {
    	fixedAssetObj.fixedAssetSearchIcon().click();
    	waitHelper.waitForElementVisible(fixedAssetObj.fixedAssetSearchRefNo(), 1000, 100);
    	fixedAssetObj.fixedAssetSearchRefNo().click();
    	fixedAssetObj.fixedAssetSearchRefNo().sendKeys(assetReturnTestData.ReferenceNoOFRevaluedAsset);
    	for(int i=0;i<3;i++)
    	{
    		try
    		{
    	boolean result=driver.findElement(By
						.xpath("//span[contains(text(),'" + assetReturnTestData.ReferenceNoOFRevaluedAsset + "')]")).isDisplayed();
    		}
    		catch(NoSuchElementException e)
    		{
    			System.out.println(e.getMessage());
    			if(i>1)
    			{
    				Assert.fail("Asset Reference number not available");
    			
    			}
    			
    		}
    		}
    }
*/
	 @And("^choose asset reference number of revalued asset$")
	    public void choose_asset_reference_number_of_revalued_asset() throws Throwable {
		 assetReturnObj.assetReturnAssetReferenceNumber().click();
			assetReturnObj.assetReturnAssetReferenceNumber().sendKeys(assetReturnTestData.assetReferenceNumberOFRevaluedAsset);
			assetReturnObj.assetReturnAssetReferenceNumber().sendKeys(Keys.DOWN);
			assetReturnObj.assetReturnAssetReferenceNumber().sendKeys(Keys.ENTER);
			String assetReferenceNumber=assetReturnObj.fixedAssetGetReferenceNo().getText();
			assetReferenceNo.put("AssetReferenceNumber",assetReferenceNumber );
	    }
	    @And("^choose asset reference number of ammendent asset$")
	    public void choose_asset_reference_number_of_ammendent_asset() throws Throwable {
	    	 assetReturnObj.assetReturnAssetReferenceNumber().click();
				assetReturnObj.assetReturnAssetReferenceNumber().sendKeys(assetReturnTestData.assetReferenceNumberOFAmmendentAsset);
				assetReturnObj.assetReturnAssetReferenceNumber().sendKeys(Keys.DOWN);
				assetReturnObj.assetReturnAssetReferenceNumber().sendKeys(Keys.ENTER);
				String assetReferenceNumber=assetReturnObj.fixedAssetGetReferenceNo().getText();
				assetReferenceNo.put("AssetReferenceNumber",assetReferenceNumber );
	    }
	    @And("^choose asset reference number in asset impaired module$")
	    public void choose_asset_reference_number_in_asset_impaired_module() throws Throwable {
	    	assetImpairementObj.fixedAssetReferenceNumber().click();
	    	assetImpairementObj.fixedAssetReferenceNumber().sendKeys(assetReturnTestData.assetReferenceNumberOFImpairedAsset);
			assetImpairementObj.fixedAssetReferenceNumber().sendKeys(Keys.ENTER);
	    }
	    @And("^choose asset reference number of impaired asset$")
	    public void choose_asset_reference_number_of_impaired_asset() throws Throwable {
	    	 assetReturnObj.assetReturnAssetReferenceNumber().click();
				assetReturnObj.assetReturnAssetReferenceNumber().sendKeys(assetReturnTestData.assetReferenceNumberOFImpairedAsset);
				assetReturnObj.assetReturnAssetReferenceNumber().sendKeys(Keys.DOWN);
				assetReturnObj.assetReturnAssetReferenceNumber().sendKeys(Keys.ENTER);
				String assetReferenceNumber=assetReturnObj.fixedAssetGetReferenceNo().getText();
				assetReferenceNo.put("AssetReferenceNumber",assetReferenceNumber );
	    }
	    @And("^choose asset reference number of de allocated asset$")
	    public void choose_asset_reference_number_of_de_allocated_asset() throws Throwable {
	    	assetReturnObj.assetReturnAssetReferenceNumber().click();
			assetReturnObj.assetReturnAssetReferenceNumber().sendKeys(assetReturnTestData.assetReferenceNumberOFDeallocationAsset);
			assetReturnObj.assetReturnAssetReferenceNumber().sendKeys(Keys.DOWN);
			assetReturnObj.assetReturnAssetReferenceNumber().sendKeys(Keys.ENTER);
			String assetReferenceNumber=assetReturnObj.fixedAssetGetReferenceNo().getText();
			assetReferenceNo.put("AssetReferenceNumber",assetReferenceNumber );
	    }
	@And("^choose item number for the asset$")
    public void choose_item_number_for_the_asset() throws Throwable {
		assetReturnObj.assetReturnAssetItemNo().click();
		assetReturnObj.assetReturnAssetItemNo().sendKeys(Keys.DOWN);
		assetReturnObj.assetReturnAssetItemNo().sendKeys(Keys.ENTER);
    }

    @Then("^Click on fixed asset deallocaion  Direction icon$")
    public void click_on_fixed_asset_deallocaion_direction_icon()  {
    //Direction	
    waitHelper.waitForElement(driver, 4000,  fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_DirectionIcon());
    fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_DirectionIcon().click();
    	
       
    }

    @Then("^Click on Fixed assets field$")
    public void click_on_fixed_assets_field() {
    //Fixed Assets
    waitHelper.waitForElement(driver, 4000,  fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_FixedAssetsField());
    fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_FixedAssetsField().click();
        	
         
      
    }

    @Then("^Click on asset deallocaion Eye button$")
    public void click_on_asset_deallocaion_eye_button(){
    //Eye
   WebElement eye = waitHelper.waitForElement(driver, 4000,  fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_EyeIcon());
   clicksAndActionHelper.moveToElement(eye);
   fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_EyeIcon().click();
       
        
    }

    @Then("^Fill asset deallocaion Mandatory fields$")
    public void fill_asset_deallocaion_mandatory_fields() throws InterruptedException  {
     	
    	
    	//AssetReferenceNumber
        waitHelper.waitForElement(driver, 4000,  fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber());
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().click();
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(assetReturnTestData.assetReferenceNumberOFDeallocationAsset);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_AssetReferenceNumber().sendKeys(Keys.ENTER);
       
        
        //ItemNumber
        waitHelper.waitForElement(driver, 4000,  fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber());
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().click();
        
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(Keys.DOWN);
        fixedAsset_AssetDeallocationObj.fixedAsset_AssetDeallocation_ItemNumber().sendKeys(Keys.ENTER);
        String getDeallocationRefNo=fixedAsset_AssetDeallocationObj.getReferenceNumberOfDeAllocation().getText();
        assetReferenceNo.put("AssetReferenceNumber",getDeallocationRefNo );
        System.out.println(assetReferenceNo.get("AssetReferenceNumber"));
        Thread.sleep(2000);
       
    }
    @Then("^Click on Fixed Asset Save button$")
    public void click_on_fixed_asset_save_button() throws Throwable {
    	waitHelper.waitForElementVisible(fixedAsset_AssetDeallocationObj.fixedAssetDeAllocationSaveButton(), 1000, 100);
    	fixedAsset_AssetDeallocationObj.fixedAssetDeAllocationSaveButton().click();
    }
	@Then("^click on Save after fill all the asset$")
    public void click_on_save_after_fill_all_the_asset() throws Throwable {
		
		System.out.println("The asset reference number is"+assetReferenceNo.get("AssetReferenceNumber"));
		waitHelper.waitForElementVisible(assetReturnObj.fixetReturnSaveButton(), 1000, 100);
		assetReturnObj.fixetReturnSaveButton().click();
		
    }
	@Then("^check the approved record is displayed in de allocation list view$")
    public void check_the_approved_record_is_displayed_in_de_allocation_list_view() throws Throwable {
		 System.out.println(assetReferenceNo.get("AssetReferenceNumber"));

			String beforeXpath = "//span[contains(text(),'";
			String afterXpath = "')]";
			while (true) {
				try {
					driver.findElement(By.xpath(beforeXpath + assetReferenceNo.get("AssetReferenceNumber") + afterXpath))
							.isDisplayed();
					break;
				} catch (NoSuchElementException e) {
					System.out.println(e.getMessage());
					assetReturnObj.fixedAssetNextButton().click();
				}
			}
    }
	 @Then("^check the approved record is displayed in list view of returned asset$")
	    public void check_the_approved_record_is_displayed_in_list_view_od_returned_asset() throws Throwable {
		 System.out.println(assetReferenceNo.get("AssetReferenceNumber"));

			String beforeXpath = "//span[contains(text(),'";
			String afterXpath = "')]";
			while (true) {
				try {
					driver.findElement(By.xpath(beforeXpath + assetReferenceNo.get("AssetReferenceNumber") + afterXpath))
							.isDisplayed();
					break;
				} catch (NoSuchElementException e) {
					System.out.println(e.getMessage());
					assetReturnObj.fixedAssetNextButton().click();
				}
			}

	    }
	    @Then("^check the approved record is displayed in revalued asset$")
	    public void check_the_approved_record_is_displayed_in_revalued_asset() throws Throwable {
	    	System.out.println(assetReferenceNo.get("AssetReferenceNumber"));

			String beforeXpath = "//span[contains(text(),'";
			String afterXpath = "')]";
			while (true) {
				try {
					driver.findElement(By.xpath(beforeXpath + assetReferenceNo.get("AssetReferenceNumber") + afterXpath))
							.isDisplayed();
					break;
				} catch (NoSuchElementException e) {
					System.out.println(e.getMessage());
					assetReturnObj.fixedAssetNextButton().click();
				}
			}
	    }
	    @Then("^check the approved record is displayed in ammendent asset$")
	    public void check_the_approved_record_is_displayed_in_ammendent_asset() throws Throwable {
	    	System.out.println(assetReferenceNo.get("AssetReferenceNumber"));

			String beforeXpath = "//span[contains(text(),'";
			String afterXpath = "')]";
			while (true) {
				try {
					driver.findElement(By.xpath(beforeXpath + assetReferenceNo.get("AssetReferenceNumber") + afterXpath))
							.isDisplayed();
					break;
				} catch (NoSuchElementException e) {
					System.out.println(e.getMessage());
					assetReturnObj.fixedAssetNextButton().click();
				}
			}
	    }
}
