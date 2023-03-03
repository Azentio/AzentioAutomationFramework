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
import pageobjects.INVENTORY_InventoryRequestObj;
import pageobjects.INVENTORY_InventoryStockIssueObj;
import pageobjects.InventoryManagamentObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_MakerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.ExcelData;

public class INVENTORY_InventoryStockIssueConfirmation extends BaseClass{
	WebDriver driver = BaseClass.driver;
	ConfigFileReader configFileReader = new ConfigFileReader();
	KUBS_Login login = new KUBS_Login(driver);
	KUBS_MakerObj kubsMakerObj = new KUBS_MakerObj(driver);
	WaitHelper waithelper=new WaitHelper(driver);
	InventoryManagamentObj inventoryManagamentObj = new InventoryManagamentObj(driver);
	String RefNo;
	BrowserHelper browserHelper = new BrowserHelper(driver);
	INVENTORY_InventoryRequestObj inventoryStockRequestObj=new INVENTORY_InventoryRequestObj(driver);
	INVENTORY_InventoryStockIssueObj inventoryStockIssue = new INVENTORY_InventoryStockIssueObj(driver);
	JavascriptHelper javascripthelper=new JavascriptHelper();
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(
			driver);
	ClicksAndActionsHelper clicksAndActionsHelper = new ClicksAndActionsHelper(driver);
	KUBS_CheckerObj kubschecker=new KUBS_CheckerObj(driver);
	KUBS_ReviewerObj reviewerObj=new KUBS_ReviewerObj(driver);
	ExcelData excelData = new ExcelData(
			"C:\\Users\\inindc00089\\eclipse-workspace\\AzentioAutomationFramework_ARAP\\Test-data\\KUBSTestData.xlsx",
			"InventoryStockConfirmation", "DataSet ID");
	Map<String, String> testData = new HashMap<>();
	
	
	//---------------KUBS_INV_MGMT_UAT_004_StockConfirm
	 @And("^user update the data set ID for Inventory stock confirmation$")
	    public void user_update_the_data_set_id_for_inventory_stock_confirmation() throws Throwable {
		 testData = excelData.getTestdata("KUBS_INV_MGMT_UAT_004_003_01_D1");
	    }
    
    @Then("^Inventory Second direction icon$")
	public void inventory_second_direction_icon() throws Throwable {

		// ---------TO VIEW THE TRANFER AMOUNT BUDGET----------//
//    	waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventoryTransfericon());
    	Thread.sleep(1500);
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryTransfericon());
		inventoryManagamentObj.inventoryTransfericon().click();
	}

	@And("^Inventory Management Module$")
	public void inventory_management_module() throws Throwable {

		// ---------TO VIEW THE Inventory Management----------//
		javascripthelper.JavaScriptHelper(driver);
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventoryManagement());
		inventoryManagamentObj.inventoryManagement().click();
		javascripthelper.scrollIntoView(inventoryManagamentObj.inventoryStockReturnBranchEye());
	}
	
    @Then("^Click on Stock issue eye icon$")
    public void click_on_stock_issue_eye_icon() throws Throwable {
    	waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventory_StockissueEye());
    	inventoryManagamentObj.inventory_StockissueEye().click();
 
    }

    @And("^Click on First record eye icon$")
    public void click_on_first_record_eye_icon() throws Throwable {
       	waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventory_StockissueGridEye());
    	inventoryManagamentObj.inventory_StockissueGridEye().click();
    }
    
    @Then("^Get the New Request Referance No$")
    public void get_the_new_request_referance_no() throws Throwable {
    	waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventory_StockissueRefNo());
         RefNo = inventoryManagamentObj.inventory_StockissueRefNo().getText();
        System.out.println("Request Referance No =" +RefNo);
    }
    
	@Then("^Click on Inventory stock confirmation eye icon$")
	public void click_on_inventory_stock_confirmation_eye_icon() throws Throwable {

		// ---------TO VIEW THE stock return from branch Eye icon----------//
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventory_StockConfirmEye());
		inventoryManagamentObj.inventory_StockConfirmEye().click();
	}

	@And("^Sub module Inventory stock confirmation click Add icon$")
	public void sub_module_inventory_stock_confirmation_click_add_icon() throws Throwable {

		// ---------TO VIEW THE stock return from branch Add icon----------//
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventoryStockConfirmAdd());
		inventoryManagamentObj.inventoryStockConfirmAdd().click();
	}

	@Then("^Enter the Request Referance Number$")
	public void enter_the_request_referance_number() throws Throwable {
		
		// -----------ENTER THE REQUEST REFERANCE NUMBER---------//
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.StockConfirm_RequestReferanceNumber());
		inventoryManagamentObj.StockConfirm_RequestReferanceNumber().click();
		inventoryManagamentObj.StockConfirm_RequestReferanceNumber().sendKeys(RefNo);
		inventoryManagamentObj.StockConfirm_RequestReferanceNumber().sendKeys(Keys.ENTER);
	}

	@And("^Enter Item code Number$")
	public void enter_item_Code_Number() throws Throwable {
		
		// ---------ENTER THE ITEM CODE--------//
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.StockConfirm_ItemCode());
		inventoryManagamentObj.StockConfirm_ItemCode().click();
		Thread.sleep(1000);
		inventoryManagamentObj.StockConfirm_ItemCode().sendKeys(Keys.DOWN);
		inventoryManagamentObj.StockConfirm_ItemCode().sendKeys(Keys.ENTER);
	
	}

	@Then("^Accept the status in checkbox$")
	public void accept_the_status_in_checkbox() throws Throwable {

		// ----------ACCEPT THE STATUS----------//
//		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.StockConfirm_AcceptCheckBox());
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.StockConfirm_AcceptCheckBox());
		inventoryManagamentObj.StockConfirm_AcceptCheckBox().click();
	}

	@And("^click the save icon for StockConfirm$")
	public void click_the_save_icon_for_stockconfirm() throws Throwable {

		// ----------SAVE THE RECORD----------//
//		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.StockConfirm_Save());
		waithelper.waitForElementToVisibleWithFluentWait(driver, inventoryManagamentObj.StockConfirm_Save(), 2, 1);
//		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.StockConfirm_Save());
		inventoryManagamentObj.StockConfirm_Save().click();
		
//		waithelper.waitForElement(driver, 3000, inventoryManagamentObj.StockConfirm_Notification_Close());
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.StockConfirm_Notification_Close());
		inventoryManagamentObj.StockConfirm_Notification_Close().click();
	}

	@And("^goto maker Notification Icon$")
	public void goto_maker_notification_Icon() throws Throwable {
		// ------------Maker Notification icon---------//
//		Thread.sleep(2000);
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.StockConfirm_MakerNotification());
		inventoryManagamentObj.StockConfirm_MakerNotification().click();
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId());
		String Reference_Id=aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId().getText();
		
		excelData.updateTestData("KUBS_INV_MGMT_UAT_004_003_02_D1", "ReferenceID", Reference_Id);
		
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
		
	}

	@Then("^Click Submit button to Inventory Record$")
	public void click_submit_button_to_inventory_record() throws Throwable {
		// -----------Submit Icon Inventory-----------//
//		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.StockConfirm_Submit());
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.StockConfirm_Submit());
		inventoryManagamentObj.StockConfirm_Submit().click();
	}

	@And("^Give Remark and submit to Reviewer$")
	public void give_remark_and_submit_to_Reviewer() throws Throwable {
		// ----------ENTER THE REMARK AND SUBMIT THE RECORD-------------//
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());
    	waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());
    	javascripthelper.JSEClick(aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField().sendKeys(testData.get("MakerAlertRemark"));
		
//    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
    	waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit().click();
    	
//    	Thread.sleep(1000);
//    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
    	waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
    	WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
    	clicksAndActionsHelper.moveToElement(recordstatus);
    	
    	String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
    	System.out.println(message);
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
    	String emptystring = "";
		String ar[] = message.split(" ");
		emptystring=ar[ar.length-1];
		String reviewerId=emptystring.replaceAll("[/.]", "");
		System.out.println(reviewerId);
//		jsonWriter=new JsonDataReaderWriter();
//		jsonWriter.addData(reviewerId);
		excelData.updateTestData("KUBS_INV_MGMT_UAT_004_003_02_D1", "ReviewerID", reviewerId);   
		
	}
	
	  @And("^user update the data set ID for Inventory stock confirmation Reviewer$")
	    public void user_update_the_data_set_id_for_inventory_stock_confirmation_reviewer() throws Throwable {
		  testData = excelData.getTestdata("KUBS_INV_MGMT_UAT_004_003_02_D1");
	    }

	    @And("^User login as a reviewer user for Inventory stock confirmation Reviewer$")
	    public void user_login_as_a_reviewer_user_for_inventory_stock_confirmation_reviewer() throws Throwable {
	    	login = new KUBS_Login(driver);
			driver.get(configFileReader.getApplicationUrl());
			login.logintoAzentioappReviewer("Reviewer", testData.get("ReviewerID"));
	    }
	    
	    @And("^approve the record by reviewer user for Inventory stock confirmation Reviewer$")
	    public void approve_the_record_by_reviewer_user_for_inventory_stock_confirmation_reviewer() throws Throwable {
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
			    	clicksAndActionsHelper.moveToElement(recordstatus);
			    	String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
			    	System.out.println(message);
			    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
		
	    }
	    
	    //....checker login...//
	    @And("^Click on claim button in checker for Inventory stock confirmation$")
	    public void click_on_claim_button_in_checker_for_inventory_stock_confirmation() throws Throwable {
	    	String before_xpath = "//span[contains(text(),'";
			String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
			//String after_xpath = ;
			//waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath_claim)));
			Thread.sleep(1000);
			
			driver.findElement(By.xpath(before_xpath+testData.get("ReferenceID")+after_xpath_claim)).click();
	    
	    }
	    
	    @Then("^Checker approve Inventory Stock Issue confirmation$")
	    public void checker_approve_inventory_stock_issue_confirmation() throws Throwable {
	    	Thread.sleep(2000);
	    	//	testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_001_TC_001_01_D1");
	    		for (int i = 1; i <= 35; i++) {
	    			try {
//	    			waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +reader.readReferancedata()+ "')]")));
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
	    			 
//	    			waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath(before_xpath +reader.readReferancedata()+after_xpath)));
	    			waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(before_xpath +testData.get("ReferenceID") +after_xpath)));
	    			driver.findElement(By.xpath(before_xpath +testData.get("ReferenceID") +after_xpath)).click();
	    			
	    		
//	    		waithelper.waitForElement(driver, 2000, kubschecker.checkerApproveButton());
	    		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerApproveButton());
	    		kubschecker.checkerApproveButton().click();
//	    		waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
	    		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerRemarks());
	    		kubschecker.checkerRemarks().sendKeys(testData.get("CheckerAlertRemark"));
//	    		waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
	    		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkersubmitButton());
	    		kubschecker.checkersubmitButton().click();
//	    		Thread.sleep(2000);
	    		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
	        	WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
	        	clicksAndActionsHelper.moveToElement(recordstatus);
	        	String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
	        	System.out.println(message);
	        	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
	    	  
	    }

    

}
