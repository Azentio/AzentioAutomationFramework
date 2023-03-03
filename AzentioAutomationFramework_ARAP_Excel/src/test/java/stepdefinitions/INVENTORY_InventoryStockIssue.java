package stepdefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataProvider.ConfigFileReader;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
import pageobjects.INVENTORY_InventoryRequestObj;
import pageobjects.INVENTORY_InventoryStockIssueObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_MakerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.ExcelData;

public class INVENTORY_InventoryStockIssue extends BaseClass {
	WebDriver driver = BaseClass.driver;
	BrowserHelper browserHelper = new BrowserHelper(driver);
	ConfigFileReader configFileReader = new ConfigFileReader();
	KUBS_Login login = new KUBS_Login(driver);
	KUBS_MakerObj kubsMakerObj = new KUBS_MakerObj(driver);
	WaitHelper waitHelper=new WaitHelper(driver);
	INVENTORY_InventoryRequestObj inventoryStockRequestObj=new INVENTORY_InventoryRequestObj(driver);
	INVENTORY_InventoryStockIssueObj inventoryStockIssue = new INVENTORY_InventoryStockIssueObj(driver);
	JavascriptHelper javascriptHelper=new JavascriptHelper();
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(
			driver);
	ClicksAndActionsHelper clicksAndActionsHelper = new ClicksAndActionsHelper(driver);
	KUBS_CheckerObj kubsChecker=new KUBS_CheckerObj(driver);
	KUBS_ReviewerObj reviewerObj=new KUBS_ReviewerObj(driver);
	ExcelData excelData = new ExcelData(
			"C:\\Users\\ININDC00089\\git\\AzentioAutomationFramework\\ArAp\\AzentioAutomationFramework_ARAP_Excel\\Test-data\\KUBSTestData.xlsx",
			"InventoryRequest", "DataSet ID");
	Map<String, String> testData = new HashMap<>();

//	@Then("^click on second Segment button$")
//	public void click_on_second_segment_button() throws Throwable {
//		kubsMakerObj.kubsDirectionIcon().click();
//	}
	
	@And("^user update the data set ID for Inventory request$")
    public void user_update_the_data_set_id_for_inventory_request() throws Throwable {
		testData = excelData.getTestdata("KUBS_INV_MGMT_UAT_004_001_D1");
    }

	
	@And("^click on inventory management main menu$")
	public void click_on_inventory_management_main_menu() throws Throwable {

		waitHelper.waitForElement(driver, 3000, kubsMakerObj.kubsInventoryManagement());
		kubsMakerObj.kubsInventoryManagement().click();
	}

    
    @Then("^click on view button near by inventory request menu$")
    public void click_on_view_button_near_byy_inventory_request_menu() throws Throwable {
    	
    	for(int i=1; i<=10; i++) {
			try {
		
		clicksAndActionsHelper.moveToElement(inventoryStockRequestObj.inventoryRequestViewIcon());
		waitHelper.waitForElementToVisibleWithFluentWait(driver, inventoryStockRequestObj.inventoryRequestViewIcon(), 10, 2);
		inventoryStockRequestObj.inventoryRequestViewIcon().click();
		break;
			}
			catch(Exception e) {}
	}
//    	for (int i = 1; i <=199; i++) {
//			try {
//    	waitHelper.waitForElement(driver, 3000, inventoryStockRequestObj.inventoryRequestViewIcon());
//    	inventoryStockRequestObj.inventoryRequestViewIcon().click();    	
//    	break;
//			}
//			catch(Exception e) {
//				if (i==199) {
//					Assert.fail(e.getMessage());
//				}
//			}
//			}
    }
    @Then("^click on first eye button to get the request reference number$")
   	public void click_on_first_eye_button_to_get_the_request_reference_number() throws InterruptedException, IOException {
   		
   		javascriptHelper.JavaScriptHelper(driver);
   		waitHelper.waitForElement(driver, 2000, inventoryStockIssue.inventoryStockIssue_FirstEyeButton());
   		inventoryStockIssue.inventoryStockIssue_FirstEyeButton().click();
   		Thread.sleep(2000);
   		String reqRefnumber = javascriptHelper.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[3].value").toString();
   		System.out.println("Request Reference Number: " + reqRefnumber);
   		excelData.updateTestData("KUBS_INV_MGMT_UAT_004_001_D1", "RequestRefnumber", reqRefnumber); 
   		
   	}
    
    
    

    @Then("^select the perticular inventory record by the help of request reference number$")
    public void select_the_perticular_inventory_record_by_the_help_of_request_reference_number() throws Throwable {
//    	String before_xpath="//span[contains(text(),'";
//    	String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[2]//ion-button[1]";
////    	waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath(before_xpath+inventoryStockIssueTestData.inventoryRequestReferenceNumber+after_xpath)));
//    	while(true) {
//    		try {
//    			waitHelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(before_xpath+testData.get("RequestRefnumber")+after_xpath)));
//    			driver.findElement(By.xpath(before_xpath+testData.get("RequestRefnumber")+after_xpath)).click();
//				break;
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//    	}
    	
    	for (int i = 1; i <= 35; i++) {
			try {
		waitHelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Search());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Search().click();
		break;}
			catch(Exception e) {}}
    	
    	waitHelper.waitForElement(driver, 3000, inventoryStockIssue.inventoryStockIssue_RequestRefnumberSearch());
    	inventoryStockIssue.inventoryStockIssue_RequestRefnumberSearch().sendKeys(testData.get("RequestRefnumber"));
    	waitHelper.waitForElement(driver, 2000, inventoryStockIssue.inventoryStockIssue_FirstEyeButton());
   		inventoryStockIssue.inventoryStockIssue_FirstEyeButton().click();
    }

    @And("^check the inventory requested sucessfully and capture the inventory data$")
    public void check_the_inventory_requested_sucessfully_and_capture_the_inventory_data() throws Throwable {
    	String inventoryBranch=(String) javascriptHelper.executeScript("return document.getElementsByClassName('ng-value-label')[0].innerText");
    	excelData.updateTestData("KUBS_INV_MGMT_UAT_004_001_D1", "InventoryBranch", inventoryBranch); 
    	Thread.sleep(1000);
    	String inventoryItem=(String) javascriptHelper.executeScript("return document.getElementsByClassName('datagrid-lov ng-untouched ng-pristine md select-disabled hydrated ion-untouched ion-pristine')[0].textContent");
    	excelData.updateTestData("KUBS_INV_MGMT_UAT_004_001_D1", "InventoryItem", inventoryItem); 
    	
    	
    }
    @When("^user see the inventory request reference number , The inventory was successfully requested$")
    public void user_see_the_inventory_request_reference_number_the_inventory_was_successfully_requested() throws Throwable {
    	String inventoryReqReferenceNumber=(String) javascriptHelper.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[3].value");
//    	Assert.assertFalse(inventoryReqReferenceNumber.isBlank());
    }


///--------------------///
  //----------Inventory stock-----------//
    @And("^user update the data set ID for Inventory stock$")
	public void user_update_the_data_set_id_for_inventory_stock() throws Throwable {
		testData = excelData.getTestdata("KUBS_INV_MGMT_UAT_004_002_01_D1");
	}
    
    @Then("^click on first eye button to get the req reference number$")
    public void click_on_first_eye_button_to_get_the_req_reference_number() throws Throwable {
    	javascriptHelper.JavaScriptHelper(driver);
   		waitHelper.waitForElement(driver, 2000, inventoryStockIssue.inventoryStockIssue_FirstEyeButton());
   		inventoryStockIssue.inventoryStockIssue_FirstEyeButton().click();
   		Thread.sleep(2000);
   		String reqRefnumber = javascriptHelper.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[3].value").toString();
   		System.out.println("Request Reference Number: " + reqRefnumber);
   		excelData.updateTestData("KUBS_INV_MGMT_UAT_004_002_01_D1", "RequestRefnumber", reqRefnumber);
    }
	
	@Then("^click the eye icon near by inventory stock issue$")
    public void click_the_eye_icon_near_by_inventory_stock_issue() throws Throwable {
    
//		javascriptHelper.JavaScriptHelper(driver);
//		javascriptHelper.JSEClick(inventoryStockIssue.inventoryStockIssueEyeIcon());
//		
		for(int i=1; i<=10; i++) {
			try {
		
		clicksAndActionsHelper.moveToElement(inventoryStockIssue.inventoryStockIssueEyeIcon());
		waitHelper.waitForElementToVisibleWithFluentWait(driver, inventoryStockIssue.inventoryStockIssueEyeIcon(), 10, 2);
		inventoryStockIssue.inventoryStockIssueEyeIcon().click();
		break;
			}
			catch(Exception e) {}
	}
    	
    	}
	@And("^click on Add button$")
    public void click_on_add_button() throws Throwable {
		waitHelper.waitForElement(driver, 3000, inventoryStockIssue.inventoryStcokIssueAddButton());
		inventoryStockIssue.inventoryStcokIssueAddButton().click();
    }

	
	@And("^enter inventory item$")
	public void enter_inventory_item() throws Throwable {
		waitHelper.waitForElement(driver, 3000, inventoryStockIssue.inventoryInventoryItem());
		inventoryStockIssue.inventoryInventoryItem().click();
//		String[] inventoryItem= jsonData.readInventoryItem().split("-");
//		inventoryStockIssue.inventoryInventoryItem().sendKeys(inventoryItem[1].trim());
		inventoryStockIssue.inventoryInventoryItem().sendKeys(testData.get("InventoryItem"));
		inventoryStockIssue.inventoryInventoryItem().sendKeys(Keys.ENTER);
	}

	
	@Then("^enter inventory branch$")
	public void enter_inventory_branch() throws Throwable {
//		String requestRefNo=jsonData.readInventoryRequestedBranch();
//		String[] requestReferenceNo=requestRefNo.split("-");
//		inventoryStockIssue.inventoryBranchCode().sendKeys(requestReferenceNo[1]);
		inventoryStockIssue.inventoryBranchCode().sendKeys(testData.get("InventoryBranchCode"));
		inventoryStockIssue.inventoryBranchCode().sendKeys(Keys.ENTER);
		
	}

	@And("^enter inventory reference number$")
	public void enter_inventory_reference_number() throws Throwable {
//		waitHelper.waitForElement(driver, 3000, inventoryStockIssue.requestReferenceNumber());
		waitHelper.waitForElementwithFluentwait(driver, inventoryStockIssue.requestReferenceNumber());
		inventoryStockIssue.requestReferenceNumber().click();
		inventoryStockIssue.requestReferenceNumber().sendKeys(testData.get("RequestRefnumber"));
		Thread.sleep(1000);
		inventoryStockIssue.requestReferenceNumber().sendKeys(Keys.ENTER);
	}
	@Then("^Click on Save button$")
	public void click_on_save_button() throws Throwable {
//		waitHelper.waitForElement(driver, 3000, inventoryStockIssue.inventoryStockIssueSaveButton());
		waitHelper.waitForElementwithFluentwait(driver, inventoryStockIssue.inventoryStockIssueSaveButton());
		inventoryStockIssue.inventoryStockIssueSaveButton().click();
		
	}

//	@Then("^click on notification$")
//    public void click_on_notification() throws Throwable {
//    	waitHelper.waitForElementwithFluentwait(driver, inventoryStockIssue.inventoryStockIssueAlertClose());
//		inventoryStockIssue.inventoryStockIssueAlertClose().click();
//		waitHelper.waitForElementwithFluentwait(driver, inventoryStockIssue.inventoryStockIssueNotificationIcon());
//		inventoryStockIssue.inventoryStockIssueNotificationIcon().click();
//       
//    }
	
//	@And("^select the first record in notification$")
//    public void select_the_first_record_in_notification() throws Throwable {
//		waitHelper.waitForElement(driver, 3000, inventoryStockIssue.inventoryStockIssueFirstReferenceId());
//		String firstReferenceID=inventoryStockIssue.inventoryStockIssueFirstReferenceId().getText();
//		jsonData.addReferanceData(firstReferenceID);
//		waitHelper.waitForElement(driver, 3000, inventoryStockIssue.inventoryStockIssueFirstRecord());
//		inventoryStockIssue.inventoryStockIssueFirstRecord().click();
//		
//    }
    @Then("^submit the record$")
    public void submit_the_record() throws Throwable {
    	waitHelper.waitForElement(driver, 2000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId());
		String Reference_Id = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId()
				.getText();

		excelData.updateTestData("KUBS_INV_MGMT_UAT_004_002_02_D1", "ReferenceID", Reference_Id);

		System.out.println("ReferenceID:" + Reference_Id);

		for (int i = 1; i <= 199; i++) {
			try {
				waitHelper.waitForElement(driver, 2000,
						aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ActionButton());
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ActionButton().click();

				break;
			} catch (Exception e) {
				if (i == 199) {
					Assert.fail(e.getMessage());
				}
			}
		}

		waitHelper.waitForElement(driver, 4000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton().click();
//		    	Thread.sleep(1000);
//		    	waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());
		waitHelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());
		javascriptHelper.JSEClick(aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField()
				.sendKeys(testData.get("MakerAlertRemark"));

		waitHelper.waitForElement(driver, 4000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit().click();

//		    	Thread.sleep(1000);
//		    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
		waitHelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
		WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
		clicksAndActionsHelper.moveToElement(recordstatus);

		String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
		System.out.println(message);
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
		String emptystring = "";
		String ar[] = message.split(" ");
		emptystring = ar[ar.length - 1];
		String reviewerId = emptystring.replaceAll("[/.]", "");
		System.out.println(reviewerId);
		excelData.updateTestData("KUBS_INV_MGMT_UAT_004_002_02_D1", "ReviewerID", reviewerId);
        
    }
    
    @And("^user update the data set ID for Inventory stock Reviewer$")
    public void user_update_the_data_set_id_for_inventory_stock_reviewer() throws Throwable {
    	testData = excelData.getTestdata("KUBS_INV_MGMT_UAT_004_002_02_D1");
	}

    @And("^User login as a reviewer user for Inventory stock$")
    public void user_login_as_a_reviewer_user_for_inventory_stock() throws Throwable {
    	login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.logintoAzentioappReviewer("Reviewer", testData.get("ReviewerID"));
    }
  
    @And("^approve the record by reviewer user for Inventory stock$")
    public void approve_the_record_by_reviewer_user_for_inventory_stock() throws Throwable {
    	browserHelper = new BrowserHelper(driver);
		String after_xpath_for_action="]/datatable-body-row/div/datatable-body-cell[1]/div/ion-buttons/ion-button";
		Thread.sleep(1000);
		for (int i = 1; i < 35; i++) {
			
			try {
				waitHelper.waitForElement(driver, 3000, driver.findElement(
						By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]")));
				WebElement referanceID = driver.findElement(
						By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]"));
				referanceID.click();
				Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waitHelper.waitForElement(driver, 4000, kubsChecker.checker_notification_next_button());

				kubsChecker.checker_notification_next_button().click();
			}
		}
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

		waitHelper.waitForElement(driver, 5000,
				driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)));
		driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)).click();

		
		waitHelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Approve_Button());
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Approve_Button().click();
//				waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer());
				waitHelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer());
aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer().click();
		
waitHelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer());
	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer().sendKeys(testData.get("ReviewerAlertRemark"));
//				waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
	waitHelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit().click();
//				Thread.sleep(2000);
				waitHelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
		    	WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
		    	clicksAndActionsHelper.moveToElement(recordstatus);
		    	String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
		    	System.out.println(message);
		    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
	
    }

    @And("^capture claimed status for Inventory Stock$")
    public void capture_claimed_status_for_inventory_stock() throws Throwable {
    	//testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_001_TC_001_01_D1");
    	String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		//String after_xpath = ;
		//waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath_claim)));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(before_xpath+testData.get("ReferenceID")+after_xpath_claim)).click();
    
    }
    
    @Then("^checker should approved the Inventory Stock$")
    public void checker_should_approved_the_inventory_stock() throws Throwable {
    	Thread.sleep(2000);
    	//	testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_001_TC_001_01_D1");
    		for (int i = 1; i <= 35; i++) {
    			try {
//    			waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +reader.readReferancedata()+ "')]")));
    				waitHelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'" +testData.get("ReferenceID")+ "')]")));
    			WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" +  testData.get("ReferenceID") + "')]"));
    			referanceID.click();
    			Assert.assertTrue(referanceID.isDisplayed());
    			break;
    			} catch (NoSuchElementException e) {
    				waitHelper.waitForElement(driver,4000,kubsChecker.checker_notification_next_button());
    				kubsChecker.checker_notification_next_button().click();
    				}
    	    }
    			String before_xpath="//span[contains(text(),'";
    			String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
    			 
//    			waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath(before_xpath +reader.readReferancedata()+after_xpath)));
    			waitHelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(before_xpath +testData.get("ReferenceID") +after_xpath)));
    			driver.findElement(By.xpath(before_xpath +testData.get("ReferenceID") +after_xpath)).click();
    			
    		
//    		waithelper.waitForElement(driver, 2000, kubschecker.checkerApproveButton());
    			waitHelper.waitForElementwithFluentwait(driver, kubsChecker.checkerApproveButton());
    			kubsChecker.checkerApproveButton().click();
//    		waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
    		waitHelper.waitForElementwithFluentwait(driver, kubsChecker.checkerRemarks());
    		kubsChecker.checkerRemarks().sendKeys(testData.get("CheckerAlertRemark"));
//    		waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
    		waitHelper.waitForElementwithFluentwait(driver, kubsChecker.checkersubmitButton());
    		kubsChecker.checkersubmitButton().click();
//    		Thread.sleep(2000);
    		waitHelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
        	WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
        	clicksAndActionsHelper.moveToElement(recordstatus);
        	String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
        	System.out.println(message);
        	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
    	
    }
}
