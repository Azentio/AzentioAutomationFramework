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

	@Then("^Click on the Direction$")
	public void click_on_the_direction() throws Throwable {
		Thread.sleep(2000);
		waithelper.waitForElement(driver, 2000, fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_DirectionIcon());
		fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_DirectionIcon().click();
	

	}
	
	@Then("^Click on Fixed Asset$")
	public void click_on_fixed_asset()  {
		waithelper.waitForElement(driver, 2000, fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_FixedAssetsField());
		fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_FixedAssetsField().click();
		
	}
	
	@Then("^Click on Asset Creation Eye button$")
	public void click_on_asset_creation_eye_button()  {
		fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_EyeButton().click();
	}
	
	@Then("^Click on the add button to add new record$")
    public void click_on_the_add_button_to_add_new_record() throws Throwable {
		fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AddButton().click();
    }
	
	@Then("^Fill Form$")
	public void fill_form()  {
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

	@Then("^Save the filled form$")
	public void save_the_filled_form() throws Throwable {
		Thread.sleep(2000);
		waithelper.waitForElement(driver, 2000, fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_SaveButton());
		fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_SaveButton().click();
	}

	//notification reuse code
	
	@Then("^Select the record which we saved$")
	public void select_the_record_which_we_saved() throws Throwable {
		//Reference
    	waithelper.waitForElement(driver, 2000, fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_ReferenceId());
    	String id = fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_ReferenceId().getText();
        jsonWriter.addReferanceData(id);
        System.out.println("Reference ID:" +id);
        for (int i = 1; i <= 35; i++) {
        		try {
        	    	waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +jsonWriter.readReferancedata()+ "')]")));	
        			WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" +  jsonWriter.readReferancedata() + "')]"));	
        			referanceID.click();
        	    	System.out.println(referanceID);
        	    	//Assert.assertTrue(referanceID.isDisplayed());
        			break;
        		} catch (NoSuchElementException e) 
        		{
        			waithelper.waitForElement(driver,4000,fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_NotificationNext_Button());
        			
        			fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_NotificationNext_Button().click();
        		}
        	}
           fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_ReferenceId().click();	    	
        	
        	//pencil 
        	 String before_xpath="//span[contains(text(),'";
        	 String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
        	  
        	 waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath(before_xpath +reader.readReferancedata()+after_xpath)));
        	 driver.findElement(By.xpath(before_xpath +reader.readReferancedata() +after_xpath)).click();
       }
	
		@Then("^Click on Fixed Asset items$")
		public void click_on_fixed_asset_items() throws Throwable {
			// Asset Items
			Thread.sleep(1000);
			waithelper.waitForElement(driver, 2000, fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_FixedAssetItems());
			fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_FixedAssetItems().click();

		}
		
		@Then("^Click on the add button of asset items$")
	    public void click_on_the_add_button_of_asset_items() {
	    //Add button	
	    waithelper.waitForElement(driver, 2000,fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AddButton());
	    fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_AddButton().click();	
	 	    	
	    }
		
		
		 
	    @Then("^fill the asset item details$")
	    public void fill_the_asset_item_details() throws Throwable  {
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
	    	Thread.sleep(2000);
	    	while(true)
	        {
			try
			{
			
				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+fixedAsset_AssetCreationTestDataType.GlToMonth+" "+fixedAsset_AssetCreationTestDataType.GlYear+"')]")));
				WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+fixedAsset_AssetCreationTestDataType.GlToMonth+" "+fixedAsset_AssetCreationTestDataType.GlYear+"')]"));
				Thread.sleep(2000);
				break;
			}
			
			catch(NoSuchElementException nosuchElement)
			{
				fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_NextMonth().click();
			}
			}
	    	Thread.sleep(2000);
			WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+fixedAsset_AssetCreationTestDataType.GlFullToMonth+" "+fixedAsset_AssetCreationTestDataType.GlToDate+", "+fixedAsset_AssetCreationTestDataType.GlYear+"']/span"));
			clickAndActionHelper.doubleClick(FinalDay);
			
	    }

	/*    @Then("^Click on save button of item details$")
		public void click_on_save_button_of_item_details() throws Throwable {
	    	Thread.sleep(2000);
			WebElement save = waithelper.waitForElement(driver, 2000, fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_SaveButton());
			clicksAndActionHelper.moveToElement(save);
			fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_SaveButton().click();
			
		}*/
	    
	    

	    @Then("^Submit record$")
	    public void submit_record() throws Throwable {
	    	// Submit button
			waithelper.waitForElement(driver, 2000, fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_SubmitButton());
			fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_SubmitButton().click();
			javascripthelper.JavaScriptHelper(driver);
			
			// Remark Field
			waithelper.waitForElement(driver, 3000, fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_RemarkField());
			fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_RemarkField().click();
			Thread.sleep(2000);
			fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_RemarkField().sendKeys("ok");
			fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_RemarkField().sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			
			// Remark Submit
			waithelper.waitForElement(driver, 2000, fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_SubmitByMaker());
			fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_SubmitByMaker().click();
			Thread.sleep(2000);
			WebElement recordstatus = fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_RecordStatus();

			clicksAndActionHelper.moveToElement(recordstatus);
			String message = fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_RecordStatus().getText();
			System.out.println(message);
			fixedAsset_AssetCreationObj.fixedAsset_AssetCreation_RecordStatus().click();
			String t = "";
			String ar[] = message.split(" ");
			Thread.sleep(2000);
			for (int i = ar.length - 1; i >= 0; i--) {
				t = ar[ar.length - 1];
			}
			String reviewerId = "";
			for (int i = 0; i < t.length() - 1; i++) {
				if (t.charAt(i) == '.') {
				} else {
					reviewerId = reviewerId + t.charAt(i);
				}
			}
			System.out.println(reviewerId);
			jsonWriter = new JsonDataReaderWriter();
			jsonWriter.addData(reviewerId);

	    }







}
