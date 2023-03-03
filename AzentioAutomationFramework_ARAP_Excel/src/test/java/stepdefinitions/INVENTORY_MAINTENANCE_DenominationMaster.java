package stepdefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.parser.ParseException;
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
import io.cucumber.java.en.When;
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
//import pageobjects.ACCOUNTSPAYABLE_InvoiceBookingObj;
//import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
import pageobjects.INVENTORY_MAINTENANCE_DenominationMasterObj;
import pageobjects.KUBS_CheckerObj;
//import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.ExcelData;


public class INVENTORY_MAINTENANCE_DenominationMaster {
	
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
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	//JsonDataReaderWriter reader;
	BrowserHelper browserHelper;
	//KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	ExcelData excelData = new ExcelData("C:\\Users\\ININDC00089\\git\\AzentioAutomationFramework\\ArAp\\AzentioAutomationFramework_ARAP_Excel\\Test-data\\KUBSTestData.xlsx","DenominationMaster", "DataSet ID");
	Map<String, String> testData = new HashMap<>();

	
	@And("^user should navigate to denomination master menu$")
	public void user_should_navigate_to_denomination_master_menu() {
		
		waithelper.waitForElement(driver, 2000, iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintenanceMenu());
		iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintenanceMenu().click();
	}

	@When("^click on eye button of denomination master$")
	public void click_on_eye_button_of_denomination_master() {
//		waithelper.waitForElement(driver, 2000, iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_EyeButton());
		for(int i=1; i<=10; i++) {
			try {
		
		clicksAndActionHelper.moveToElement(iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_EyeButton());
		waithelper.waitForElementToVisibleWithFluentWait(driver, iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_EyeButton(), 10, 2);
		iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_EyeButton().click();
		break;
			}
			catch(Exception e) {}
	}
	}
	
	@And("^click on add button to create denomination details$")
	public void click_on_add_button_to_create_denomination_details(){
		waithelper.waitForElement(driver, 2000, iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_AddButton());
		iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_AddButton().click();
	}
	
	 @And("^user update the data set ID for denomination$")
	    public void user_update_the_data_set_id_for_denomination() throws Throwable {
		 testData = excelData.getTestdata("KUBS_INV_MGMT_UAT_002_002_01_D1"); 
	    }
	
	@And("^Fill the required fields to create denomination details$")
	public void fill_the_required_fields_to_create_denomination_details()  {
		waithelper.waitForElement(driver, 2000, iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_InstrumentCode());
		iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_InstrumentCode().sendKeys(testData.get("InstrumentCode"));
		iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_InstrumentCode().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 2000, iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_Currency());
		iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_Currency().sendKeys(testData.get("Currency"));
		iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_Currency().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 2000, iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_DenominationType());
		iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_DenominationType().sendKeys(testData.get("DenominationType"));
		iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_DenominationType().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 2000, iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_DenominationSubType());
		iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_DenominationSubType();
		
//		iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_DenominationSubTypeCoin().click();
		waithelper.waitForElement(driver, 2000, iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_DenominationSequence());
		iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_DenominationSequence().sendKeys(testData.get("DenominationSequence"));
		
		waithelper.waitForElement(driver, 2000, iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_DenominationValue());
		iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_DenominationValue().sendKeys(testData.get("DenominationValue"));
		
		waithelper.waitForElement(driver, 2000, iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_DenominationDescription());
		iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_DenominationDescription().sendKeys(testData.get("DenominationDescription"));
		
//		waithelper.waitForElement(driver, 2000, iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_ActionButton());
//		iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_ActionButton().click();
	}

	@Then("^Save and submit the creation denomination details$")
	public void save_and_submit_the_creation_denomination_details() throws IOException, ParseException, InterruptedException  {
		iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintnenance_DenominationMaster_SaveButton().click();
		
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
		Thread.sleep(2000);
		javascripthelper.JavaScriptHelper(driver);
//		String str = javascripthelper.executeScript(
//				"return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText")
//				.toString();
//		System.out.println("Message:" + str);
		
//		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton());
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton().click();
		

		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId());
		String Reference_Id=aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId().getText();
		
		excelData.updateTestData("KUBS_INV_MGMT_UAT_002_002_02_D1", "ReferenceID", Reference_Id);
		
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
//    	Thread.sleep(1000);
//    	waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());
    	waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());
    	javascripthelper.JSEClick(aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField().sendKeys(testData.get("MakerAlertRemark"));
		
    	waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit().click();
    	
//    	Thread.sleep(1000);
//    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
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
		excelData.updateTestData("KUBS_INV_MGMT_UAT_002_002_02_D1", "ReviewerID", reviewerId); 
		
	}
	@And("^user update the data set ID for denomination Reviewer$")
    public void user_update_the_data_set_id_for_denomination_reviewer() throws Throwable {
		 testData = excelData.getTestdata("KUBS_INV_MGMT_UAT_002_002_02_D1");  
    }
	 @And("^User login as a reviewer for denomination Reviewer$")
	    public void user_login_as_a_reviewer_for_denomination_reviewer() throws Throwable {
		 login = new KUBS_Login(driver);
			driver.get(config.getApplicationUrl());
			login.logintoAzentioappReviewer("Reviewer", testData.get("ReviewerID"));
	    }
	
	@And("^approve the denomination record by reviewer user$")
    public void approve_the_denomination_record_by_reviewer_user() throws Throwable {
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
//				waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer());
waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer());
aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer().click();
		
waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer());
	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer().sendKeys(testData.get("ReviewerAlertRemark"));
//				waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
				waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit().click();
//				Thread.sleep(2000);
				waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
		    	WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
		    	clicksAndActionHelper.moveToElement(recordstatus);
		    	String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
		    	System.out.println(message);
		    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
	 
    }
	 @And("^capture claimed status for denomination Reviewer$")
	    public void capture_claimed_status_for_denomination_reviewer() throws Throwable {
		//testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_001_TC_001_01_D1");
	    	String before_xpath = "//span[contains(text(),'";
			String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
			//String after_xpath = ;
			//waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath_claim)));
			Thread.sleep(1000);
			
			driver.findElement(By.xpath(before_xpath+testData.get("ReferenceID")+after_xpath_claim)).click();
	    
			
	    }

	@Then("^checker should approved the denomination details$")
	public void checker_should_approved_the_denomination_details()
			throws IOException, InterruptedException, ParseException {
		Thread.sleep(2000);
		//	testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_001_TC_001_01_D1");
			for (int i = 1; i <= 35; i++) {
				try {
//				waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +reader.readReferancedata()+ "')]")));
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
				 
//				waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath(before_xpath +reader.readReferancedata()+after_xpath)));
				waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(before_xpath +testData.get("ReferenceID") +after_xpath)));
				driver.findElement(By.xpath(before_xpath +testData.get("ReferenceID") +after_xpath)).click();
				
			
//			waithelper.waitForElement(driver, 2000, kubschecker.checkerApproveButton());
			waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerApproveButton());
			kubschecker.checkerApproveButton().click();
//			waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
			waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerRemarks());
			kubschecker.checkerRemarks().sendKeys(testData.get("CheckerAlertRemark"));
//			waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
			waithelper.waitForElementwithFluentwait(driver, kubschecker.checkersubmitButton());
			kubschecker.checkersubmitButton().click();
//			Thread.sleep(2000);
			waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
	    	WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
	    	clicksAndActionHelper.moveToElement(recordstatus);
	    	String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
	    	System.out.println(message);
	    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
		

	}
	@And("^checker should logout$")
    public void checker_should_logout()  {
		waithelper.waitForElement(driver, 2000, iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintenance_profilename());
		iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintenance_profilename().click();
		waithelper.waitForElement(driver, 2000, iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintenance_Logout());
		iNVENTORY_MAINTENANCE_DenominationMasterObj.inventoryMaintenance_Logout();
    }

}
