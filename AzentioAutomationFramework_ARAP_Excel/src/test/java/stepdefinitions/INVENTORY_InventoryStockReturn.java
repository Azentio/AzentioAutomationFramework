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

public class INVENTORY_InventoryStockReturn extends BaseClass{
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
			"C:\\Users\\ININDC00089\\git\\AzentioAutomationFramework\\ArAp\\AzentioAutomationFramework_ARAP_Excel\\Test-data\\KUBSTestData.xlsx",
			"InventoryStockReturn", "DataSet ID");
	Map<String, String> testData = new HashMap<>();
	


	
	
	
	//-------arshat KUBS_INV_MGMT_UAT_005_001----
	
    
//	@Then("^Click on Second icon page$")
//	public void click_on_second_icon_page() throws Throwable {
//
//		// ---------TO VIEW THE TRANFER AMOUNT BUDGET----------//
//		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventoryTransfericon());
//		inventoryManagamentObj.inventoryTransfericon().click();
//	}


    @And("^user update the data set ID for Inventory stock return$")
    public void user_update_the_data_set_id_for_inventory_stock_return() throws Throwable {
   	 testData = excelData.getTestdata("KUBS_INV_MGMT_UAT_005_001_01_D1");
   	 
    }
	@And("^Click Inventory Management module$")
	public void click_inventory_management_module() throws Throwable {

		// ---------TO VIEW THE Inventory Management----------//
		javascripthelper.JavaScriptHelper(driver);
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventoryManagement());
		inventoryManagamentObj.inventoryManagement().click();
		javascripthelper.scrollIntoView(inventoryManagamentObj.inventoryStockReturnBranchEye());
	}

	@And("^Click on stock return from branch SubModule Eye icon$")
	public void click_on_stock_return_from_branch_submodule_eye_icon() throws Throwable {

		// ---------TO VIEW THE stock return from branch Eye icon----------//
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventoryStockReturnBranchEye());
		inventoryManagamentObj.inventoryStockReturnBranchEye().click();
	}

	@Then("^Click on stock return from branch Add icon$")
	public void click_on_stock_return_from_branch_add_icon() throws Throwable {

		// ---------TO VIEW THE stock return from branch Add icon----------//
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventoryStockReturnBranchAdd());
		inventoryManagamentObj.inventoryStockReturnBranchAdd().click();
	}

	@And("^Click on Request Referance No code$")
	public void click_on_request_referance_no_code() throws Throwable {

		// ---------TO Enter Request Referance No code----------//
		
//		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventoryRequestReferanceNumber());
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryRequestReferanceNumber());
		inventoryManagamentObj.inventoryRequestReferanceNumber().click();
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryRequestReferanceNumber());
		inventoryManagamentObj.inventoryRequestReferanceNumber().sendKeys(testData.get("requestReferanceNo"));
		Thread.sleep(500);
		inventoryManagamentObj.inventoryRequestReferanceNumber().sendKeys(Keys.ENTER);
	}

	@Then("^Click on Issue Referance No code$")
	public void click_on_issue_referance_no_code() throws Throwable {

		// ---------TO VIEW THE Issue Referance No code----------//
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventoryIssueReferanceNo());
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryIssueReferanceNo());
		inventoryManagamentObj.inventoryIssueReferanceNo().click();
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryIssueReferanceNo());
		inventoryManagamentObj.inventoryIssueReferanceNo().sendKeys(Keys.DOWN);
		Thread.sleep(500);
		inventoryManagamentObj.inventoryIssueReferanceNo().sendKeys(Keys.ENTER);
	}

	@And("^Click on item code$")
	public void click_on_item_code() throws Throwable {
		// ---------TO VIEW THE item code----------//
//		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventoryItemCode());
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryItemCode());
		inventoryManagamentObj.inventoryItemCode().click();
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryItemCode());
		inventoryManagamentObj.inventoryItemCode().sendKeys(Keys.DOWN);
		Thread.sleep(500);
		inventoryManagamentObj.inventoryItemCode().sendKeys(Keys.ENTER);
		
	}

	@And("^Enter Return Quantity Stock value$")
	public void enter_return_quantity_stock_value() throws Throwable {
		
		// ---------TO VIEW THE Return Quantity----------//
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventoryReturnQuantity());
		inventoryManagamentObj.inventoryReturnQuantity().click();
		inventoryManagamentObj.inventoryReturnQuantity().sendKeys(testData.get("returnQuantity"));
	}


    
	@Then("^Click on Return Type and Choose Type$")
	public void click_on_return_type_and_choose_type() throws Throwable {
		
		// ---------TO VIEW THE Return Type----------//
		waithelper.waitForElement(driver, 5000, inventoryManagamentObj.inventory_ReturnType());
		inventoryManagamentObj.inventory_ReturnType().click();
		inventoryManagamentObj.inventory_ReturnType().sendKeys(testData.get("returnType"));
		Thread.sleep(500);
		inventoryManagamentObj.inventory_ReturnType().sendKeys(Keys.ENTER);
	}

	@And("^Click on Return Reason and Choose Type$")
	public void click_on_return_reason_and_choose_type() throws Throwable {
		
		// ---------TO VIEW THE Return Reason----------//
//		waithelper.waitForElement(driver, 5000, inventoryManagamentObj.inventory_ReturnReason());
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventory_ReturnReason());
		inventoryManagamentObj.inventory_ReturnReason().click();
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventory_ReturnReason());
		inventoryManagamentObj.inventory_ReturnReason().sendKeys(testData.get("returnReason"));
		Thread.sleep(500);
		inventoryManagamentObj.inventory_ReturnReason().sendKeys(Keys.ENTER);
	}

	@Then("^Save the Inventory Stock Record$")
	public void save_the_inventory_stock_record() throws Throwable {

		// -----------SAVE THE RECORD----------------//
//		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventory_Save());
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventory_Save());
		inventoryManagamentObj.inventory_Save().click();
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryManagament_InventoryRequest_PopupCloseButton());
		inventoryManagamentObj.inventoryManagament_InventoryRequest_PopupCloseButton().click();
		Thread.sleep(1000);
	}

	@And("^goto the maker Notification icon$")
	public void goto_the_maker_notification_icon() throws Throwable {

		// ------------Maker Notification icon---------//
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventory_MakerNotification());
		inventoryManagamentObj.inventory_MakerNotification().click();
		
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId());
		String Reference_Id=aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId().getText();
		
		excelData.updateTestData("KUBS_INV_MGMT_UAT_005_001_02_D1", "ReferenceID", Reference_Id);
		
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

	@Then("^Click Submit icon to Inventory Record$")
	public void click_submit_icon_to_inventory_record() throws Throwable {

		// -----------Submit Icon Inventory-----------//
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventory_Submit());
		inventoryManagamentObj.inventory_Submit().click();
	}

	@And("^Give Remark and submit Inventory field$")
	public void give_remark_and_submit_inventory_field() throws Throwable {

		// ----------ENTER THE REMARK AND SUBMIT THE RECORD-------------//
//    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());
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
		excelData.updateTestData("KUBS_INV_MGMT_UAT_005_001_02_D1", "ReviewerID", reviewerId);   
		

	}

	  @And("^user update the data set ID for Inventory stock return Reviewer$")
	    public void user_update_the_data_set_id_for_inventory_stock_return_reviewer() throws Throwable {
		  testData = excelData.getTestdata("KUBS_INV_MGMT_UAT_005_001_02_D1");
	    }

	    @And("^User login as a reviewer user for Inventory stock return$")
	    public void user_login_as_a_reviewer_user_for_inventory_stock_return() throws Throwable {
	    	login = new KUBS_Login(driver);
			driver.get(configFileReader.getApplicationUrl());
			login.logintoAzentioappReviewer("Reviewer", testData.get("ReviewerID"));
	    }
	    
	    @And("^approve the record by reviewer user for Inventory stock return$")
	    public void approve_the_record_by_reviewer_user_for_inventory_stock_return() throws Throwable {
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
	    @And("^Click on claim button in checker for Inventory stock return$")
	    public void click_on_claim_button_in_checker_for_inventory_stock_return() throws Throwable {
	    	//testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_001_TC_001_01_D1");
	    	String before_xpath = "//span[contains(text(),'";
			String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
			//String after_xpath = ;
			//waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath_claim)));
			Thread.sleep(1000);
			
			driver.findElement(By.xpath(before_xpath+testData.get("ReferenceID")+after_xpath_claim)).click();
	    
			
	    }
	    
		@Then("^Checker approve Inventory stock return$")
		public void checker_approve_inventory_stock_return() throws Throwable {
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
		    	clicksAndActionsHelper.moveToElement(recordstatus);
		    	String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
		    	System.out.println(message);
		    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
			
		}
    
	@Then("^Click on Inventory Maintance module$")
    public void click_on_inventory_maintance_module() throws Throwable {
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventory_InventoryMaintenance());
		inventoryManagamentObj.inventory_InventoryMaintenance().click();
    }

    @And("^click on Master Item eye icon$")
    public void click_on_master_item_eye_icon() throws Throwable {
    	waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventory_MasterItemEye());
    	inventoryManagamentObj.inventory_MasterItemEye().click();
    }
    
    @Then("^click on the search icon$")
    public void click_on_the_search_icon() throws Throwable {
    	waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventory_SearchIcon());
    	inventoryManagamentObj.inventory_SearchIcon().click();
    }

//    @And("^Give Item description value and Click Edit icon$")
//    public void give_item_description_value_and_click_edit_icon() throws Throwable {
//    	waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventory_Itemvalue());
//    	inventoryManagamentObj.inventory_Itemvalue().click();
//    	inventoryManagamentObj.inventory_Itemvalue().sendKeys("STAPLERS");
//    }
    
//    @When("^validate the quantity of the Item$")
//    public void validate_the_quantity_of_the_item() throws Throwable {
//    	waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventory_CurrentQuantity());
//    	String Quantity = inventoryManagamentObj.inventory_CurrentQuantity().getText();
//    	System.out.println("The Branch Available Quantity is: "+Quantity);
//    }  
}
