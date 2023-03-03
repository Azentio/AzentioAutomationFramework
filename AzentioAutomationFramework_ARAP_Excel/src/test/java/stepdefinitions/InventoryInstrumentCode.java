package stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
import pageobjects.INVENTORY_MAINTENANCE_DenominationMasterObj;
import pageobjects.InventoryManagamentObj;
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.ExcelData;

public class InventoryInstrumentCode {
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
//	AzentioLogin login;
	ConfigFileReader config = new ConfigFileReader();
	
	WaitHelper waithelper = new WaitHelper(driver);
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(driver);
//	ACCOUNTSPAYABLE_InvoiceBookingObj aCCOUNTSPAYABLE_InvoiceBookingObj = new ACCOUNTSPAYABLE_InvoiceBookingObj(driver);
	INVENTORY_MAINTENANCE_DenominationMasterObj iNVENTORY_MAINTENANCE_DenominationMasterObj = new INVENTORY_MAINTENANCE_DenominationMasterObj(driver);
//	INVENTORY_MAINTENANCE_DenominationMasterTestDataType iNVENTORY_MAINTENANCE_DenominationMasterTestDataType=jsonReader.getDenominationMasterdata("Maker");
	JavascriptHelper javascripthelper = new JavascriptHelper();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	InventoryManagamentObj inventoryManagamentObj = new InventoryManagamentObj(driver);
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	//JsonDataReaderWriter reader;
	BrowserHelper browserHelper;
	//KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	ExcelData excelData = new ExcelData("C:\\Users\\ININDC00089\\git\\AzentioAutomationFramework\\ArAp\\AzentioAutomationFramework_ARAP_Excel\\Test-data\\KUBSTestData.xlsx","InventoryInstrumentCode", "DataSet ID");
	Map<String, String> testData = new HashMap<>();

	 @And("^user update the data set ID for instrument code$")
	    public void user_update_the_data_set_id_for_instrument_code() throws Throwable {
		 testData = excelData.getTestdata("KUBS_INV_MGMT_UAT_002_001_01_D1");
	    }
	
	@Then("^Click on Instrument code master eye button$")
	public void click_on_instrument_code_master_eye_button() throws Throwable {
		for(int i=1; i<=10; i++) {
			try {
				clicksAndActionHelper.moveToElement(inventoryManagamentObj.inventoryMaintenance_InstrumentCodeMaster_EyeButton());
				
		waithelper.waitForElement(driver, 4000, inventoryManagamentObj.inventoryMaintenance_InstrumentCodeMaster_EyeButton());
		inventoryManagamentObj.inventoryMaintenance_InstrumentCodeMaster_EyeButton().click();
		
		break;
			}
			catch(Exception e) {}
	}
	}
	@Then("^Click on Add button of Instrument code$")
    public void click_on_add_button_of_instrument_code() throws Throwable {
     
//		waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryManagament_InventoryRequest_AddButton());
//		inventoryManagamentObj.inventoryManagament_InventoryRequest_AddButton().click();
		Thread.sleep(1000);
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryManagament_InventoryRequest_AddButton());
		inventoryManagamentObj.inventoryManagament_InventoryRequest_AddButton().click();
	}


	@Then("^Fill all the details$")
	public void fill_all_the_details() throws Throwable {
//We need to change instrument code every time. If not changed it will show error instrument code already exist
//We need to change instrument code & Description every time. If not changed it will show error instrument code already exist	
		
		
		waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryMaintenance_InstrumentCodeMaster_InstrumentCodeTextBox());
		inventoryManagamentObj.inventoryMaintenance_InstrumentCodeMaster_InstrumentCodeTextBox().click();
		waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryMaintenance_InstrumentCodeMaster_InstrumentCodeTextBox());
		inventoryManagamentObj.inventoryMaintenance_InstrumentCodeMaster_InstrumentCodeTextBox().sendKeys(testData.get("InstrumentCode"));
		inventoryManagamentObj.inventoryMaintenance_InstrumentCodeMaster_InstrumentCodeTextBox().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryMaintenance_InstrumentCodeMaster_InstrumentDescriptionTextBox());
		inventoryManagamentObj.inventoryMaintenance_InstrumentCodeMaster_InstrumentDescriptionTextBox().click();
		inventoryManagamentObj.inventoryMaintenance_InstrumentCodeMaster_InstrumentDescriptionTextBox().sendKeys(testData.get("InstrumentDescription"));
		inventoryManagamentObj.inventoryMaintenance_InstrumentCodeMaster_InstrumentDescriptionTextBox().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryMaintenance_InstrumentCodeMaster_StartingSerialNumber());
		inventoryManagamentObj.inventoryMaintenance_InstrumentCodeMaster_StartingSerialNumber().click();
		inventoryManagamentObj.inventoryMaintenance_InstrumentCodeMaster_StartingSerialNumber().sendKeys(testData.get("StartingSerialNumber"));
		inventoryManagamentObj.inventoryMaintenance_InstrumentCodeMaster_StartingSerialNumber().sendKeys(Keys.ENTER);
	}
	 @Then("^Click on save button on instrument code master$")
	    public void click_on_save_button_on_instrument_code_master() throws Throwable {
//		 Thread.sleep(1000);
//		 waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryMaintanance_InstrumentCodeMaster_SaveButton());
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryMaintanance_InstrumentCodeMaster_SaveButton());
		 inventoryManagamentObj.inventoryMaintanance_InstrumentCodeMaster_SaveButton().click();
		 waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryManagament_InventoryRequest_PopupCloseButton());
			inventoryManagamentObj.inventoryManagament_InventoryRequest_PopupCloseButton().click();
			
			 Thread.sleep(1000);
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
	 
	 @Then("^Save and submit the creation instrument code details$")
	    public void save_and_submit_the_creation_instrument_code_details() throws Throwable {
		 waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton());
			aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton().click();
			

			waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId());
			String Reference_Id=aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId().getText();
			
			excelData.updateTestData("KUBS_INV_MGMT_UAT_002_001_02_D1", "ReferenceID", Reference_Id);
			
			System.out.println("ReferenceID:" +Reference_Id);
			
			for (int i = 1; i <=199; i++) {
				try {
	    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ActionButton());
	    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ActionButton().click();
			 
	    	break;
				}
				catch(Exception e) {
					if (i==199) {
						Assert.fail(e.getMessage());
					}
				}
				}
	    	
	    	waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton());
	    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton().click(); 
//	    	Thread.sleep(1000);
//	    	waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());
	    	waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());
//	    	javascripthelper.JSEClick(aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());
	    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField().click();
	    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField().sendKeys(testData.get("MakerAlertRemark"));
			
	    	waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
	    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit().click();
	    	
//	    	Thread.sleep(1000);
//	    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
	    	waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
	    	WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
	    	clicksAndActionHelper.moveToElement(recordstatus);
	    	
	    	String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
	    	System.out.println(message);
	    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
	    	String emptystring = "";
			String ar[] = message.split(" ");
			emptystring=ar[ar.length-1];
			String reviewerId=emptystring.replaceAll("[/.]", "");
			System.out.println(reviewerId);
			excelData.updateTestData("KUBS_INV_MGMT_UAT_002_001_02_D1", "ReviewerID", reviewerId); 
			
	    }
	 
	 @And("^user update the data set ID for instrument code Reviewer$")
	    public void user_update_the_data_set_id_for_instrument_code_reviewer() throws Throwable {
		 testData = excelData.getTestdata("KUBS_INV_MGMT_UAT_002_001_02_D1");
	    }

	    @And("^User login as a reviewer for instrument code Reviewer$")
	    public void user_login_as_a_reviewer_for_instrument_code_reviewer() throws Throwable {
	    	login = new KUBS_Login(driver);
			driver.get(config.getApplicationUrl());
			login.logintoAzentioappReviewer("Reviewer", testData.get("ReviewerID"));  
	    }

	    @And("^approve the instrument code record by reviewer user$")
	    public void approve_the_instrument_code_record_by_reviewer_user() throws Throwable {
	    	browserHelper = new BrowserHelper(driver);
			String after_xpath_for_action="]/datatable-body-row/div/datatable-body-cell[1]/div/ion-buttons/ion-button";
			Thread.sleep(1000);
			for (int i = 1; i < 35; i++) {
				
				try {
					waithelper.waitForElement(driver, 3000, driver.findElement(
							By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]")));
					WebElement referanceID = driver.findElement(
							By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]"));
					referanceID.click();
					Assert.assertTrue(referanceID.isDisplayed());
					break;
				} catch (NoSuchElementException e) {
					waithelper.waitForElement(driver, 4000, kubschecker.checker_notification_next_button());

					kubschecker.checker_notification_next_button().click();
				}
			}
			String before_xpath = "//span[contains(text(),'";
			String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

			waithelper.waitForElement(driver, 5000,
					driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)));
			driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)).click();

			
					waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Approve_Button());
					aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Approve_Button().click();
//					waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer());
	waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer());
	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer().click();
			
	waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer().sendKeys(testData.get("ReviewerAlertRemark"));
//					waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
					waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
					aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit().click();
//					Thread.sleep(2000);
					waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
			    	WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
			    	clicksAndActionHelper.moveToElement(recordstatus);
			    	String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
			    	System.out.println(message);
			    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
		 
	  
	    }
	    
	   

	    @And("^Click on claim button for instrument code$")
	    public void click_on_claim_button_for_instrument_code() throws Throwable {
	    	String before_xpath = "//span[contains(text(),'";
			String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
			//String after_xpath = ;
			//waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath_claim)));
			Thread.sleep(1000);
			
			driver.findElement(By.xpath(before_xpath+testData.get("ReferenceID")+after_xpath_claim)).click();
	      
	    }
	    @Then("^checker should approved the instrument code details$")
	    public void checker_should_approved_the_instrument_code_details() throws Throwable {
	    	Thread.sleep(2000);
			//	testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_001_TC_001_01_D1");
				for (int i = 1; i <= 35; i++) {
					try {
//					waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +reader.readReferancedata()+ "')]")));
					waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'" +testData.get("ReferenceID")+ "')]")));
					WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" +  testData.get("ReferenceID") + "')]"));
					referanceID.click();
					Assert.assertTrue(referanceID.isDisplayed());
					break;
					} catch (NoSuchElementException e) {
						waithelper.waitForElement(driver,4000,kubschecker.checker_notification_next_button());
						kubschecker.checker_notification_next_button().click();
						}
			    }
					String before_xpath="//span[contains(text(),'";
					String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
					 
//					waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath(before_xpath +reader.readReferancedata()+after_xpath)));
					waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(before_xpath +testData.get("ReferenceID") +after_xpath)));
					driver.findElement(By.xpath(before_xpath +testData.get("ReferenceID") +after_xpath)).click();
					
				
//				waithelper.waitForElement(driver, 2000, kubschecker.checkerApproveButton());
				waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerApproveButton());
				kubschecker.checkerApproveButton().click();
//				waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
				waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerRemarks());
				kubschecker.checkerRemarks().sendKeys(testData.get("CheckerAlertRemark"));
//				waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
				waithelper.waitForElementwithFluentwait(driver, kubschecker.checkersubmitButton());
				kubschecker.checkersubmitButton().click();
//				Thread.sleep(2000);
				waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
		    	WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
		    	clicksAndActionHelper.moveToElement(recordstatus);
		    	String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
		    	System.out.println(message);
		    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
			

	    }
  
		
}
