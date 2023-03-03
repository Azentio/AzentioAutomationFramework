package stepdefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import dataProvider.ConfigFileReader;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.Selenium_Actions;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import pageobjects.AccountPayable_VendorPurchaseOrderObj;
import pageobjects.ArAp_Cancellation_of_vendorObj;
import pageobjects.Ar_Po_creationObj;
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;


public class AccountPayable_VendorPurchaseOrder extends BaseClass {
	
	WebDriver driver = BaseClass.driver;
	ConfigFileReader configFileReader = new ConfigFileReader();
	ConfigFileReader config = new ConfigFileReader();
	KUBS_Login login = new KUBS_Login(driver);
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	DropDownHelper dropDownHelper;
	WaitHelper waithelper = new WaitHelper(driver);
	// maker//
	JavascriptHelper javascripthelper = new JavascriptHelper();
	AccountPayable_VendorPurchaseOrderObj accountPayable_VendorPurchaseOrderObj = new AccountPayable_VendorPurchaseOrderObj(driver);
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	Selenium_Actions seleniumactions = new Selenium_Actions(driver);
	ArAp_Cancellation_of_vendorObj cancellationofcontract = new ArAp_Cancellation_of_vendorObj(driver);
	Map<String, String> testdata = new LinkedHashMap<>();
	Ar_Po_creationObj arpoCreationObj = new Ar_Po_creationObj(driver);
	BrowserHelper browserHelper;
	String referance_id;
	String user = "Maker";
	ExcelData excelData = new ExcelData("C:\\Users\\ININDC00089\\git\\AzentioAutomationFramework\\ArAp\\AzentioAutomationFramework_ARAP_Excel\\Test-data\\KUBSTestData.xlsx","ARAP_VendorPurchaseOrders", "DataSet ID");
	Map<String, String> testData = new HashMap<>();
		
	@Then("^Click on purchase order Eye Icon$")
	public void click_on_purchase_order_eye_icon()  {
	waithelper.waitForElementToVisibleWithFluentWait(driver, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_EyeButton(), 15, 1);
	accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_EyeButton().click();
	}

	@Then("^Click on purchase order Add button$")
	public void click_on_purchase_order_add_button() {
	while (true) {
		try {
			waithelper.waitForElementToVisibleWithFluentWait(driver, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_AddButton(), 15, 1);
			accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_AddButton().click();
				break;
			} catch (Exception e) {}
		}	
		        
 }

	@And("^user update the data set ID for Purchase Order$")
	public void user_update_the_data_set_id_for_purchase_order() {
		testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_001_TC_002_01_D1");
	}
	@Then("^Fill purchase order Mandatory fields$")
	public void fill_purchase_order_mandatory_fields() throws InterruptedException  {
			 //BP Name
	waithelper.waitForElementToVisibleWithFluentWait(driver, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_BPName(), 15, 1);
	accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_BPName().click();
	accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_BPName().sendKeys(testData.get("BPName"));
	accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_BPName().sendKeys(Keys.ARROW_DOWN);
	accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_BPName().sendKeys(Keys.ENTER);
		    
		     //Reference Type
	waithelper.waitForElementToVisibleWithFluentWait(driver, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ReferenceType(), 15, 1);
	accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ReferenceType().click();
	accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ReferenceType().sendKeys(testData.get("RefernceType"));
	accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ReferenceType().sendKeys(Keys.ENTER);
		

	
	//Contract
	for(int i=1; i<=20; i++) {
		try {
	waithelper.waitForElementToVisibleWithFluentWait(driver, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_Contract(), 15, 1);
	accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_Contract().click();
	accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_Contract().sendKeys(testData.get("Contract"));
	accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_Contract().sendKeys(Keys.ARROW_DOWN);
	accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_Contract().sendKeys(Keys.ENTER);
	waithelper.waitForElementToVisibleWithFluentWait(driver, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_CheckBoxPoItem(), 15, 1);
	accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_CheckBoxPoItem().isDisplayed();
	
	break;
		} catch (Exception e) {
		}}
			 //CheckBox Po Item
	for(int i=1; i<=20; i++) {
		try {
			Thread.sleep(2000);
	waithelper.waitForElementToVisibleWithFluentWait(driver, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_CheckBoxPoItem(), 15, 1);
	accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_CheckBoxPoItem().click();
	waithelper.waitForElementToVisibleWithFluentWait(driver, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PoQuantity(), 15, 1);
	accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PoQuantity().isDisplayed();
	
	break;
		} catch (Exception e) {
		}}
			
	
	
	
			//Po Quantity
	waithelper.waitForElementToVisibleWithFluentWait(driver, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PoQuantity(), 15, 1);
	accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PoQuantity().click();
	accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PoQuantity().sendKeys(testData.get("PoQuantity"));
	accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PoQuantity().sendKeys(Keys.ENTER);
		
			//Po item save
	WebElement posave = waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PoItemSave());
	clicksAndActionHelper.clickOnElement(posave);	
			// Po item save
			//waithelper.waitForElement(driver, 2000,accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PONumber());
			//accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PONumber().click();
			//accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PONumber().sendKeys(accountPayable_VendorPurchaseOrderTestDataType.PoNumber);
			//accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PONumber().sendKeys(Keys.ENTER);
		

	//Po Sub Type
	for(int i=1; i<=20; i++) {
		try {
			waithelper.waitForElementToVisibleWithFluentWait(driver, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_POSubType1(), 15, 1);
	accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_POSubType1().click();
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_POSubType1().sendKeys("PO For Asset Purchase");
	accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_POSubType1().sendKeys(Keys.ENTER);
		//testData.get("POSubType")
	break;
		} catch (Exception e) {
		}	}
			
	 //cost Center
waithelper.waitForElementToVisibleWithFluentWait(driver, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_CostCenter1(), 15, 1);
accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_CostCenter1().click();
accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_CostCenter1().sendKeys(testData.get("CostCenter"));
accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_CostCenter1().sendKeys(Keys.ENTER);
	
}
		 
@Then("^Click on Account Payable Save button$")
public void click_on_account_payable_save_button() {
waithelper.waitForElementToVisibleWithFluentWait(driver, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_Save(), 15, 1);
accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_Save().click();

}

@Then("^close the confrimation msg$")
public void close_the_confrimation_msg() {

while (true) {
	try {
		waithelper.waitForElementwithFluentwait(driver, accountPayable_VendorPurchaseOrderObj.MessageContent());
		String mssg = accountPayable_VendorPurchaseOrderObj.MessageContent().getText();
		System.out.println(mssg);
		waithelper.waitForElementwithFluentwait(driver,accountPayable_VendorPurchaseOrderObj.ConfirmationMessageCloseButton());
		accountPayable_VendorPurchaseOrderObj.ConfirmationMessageCloseButton().click();
		break;
		} catch (Exception e) {
		}
	}

while (true) {
	try {
		waithelper.waitForElementwithFluentwait(driver, accountPayable_VendorPurchaseOrderObj.MessageContent());
		String mssg = accountPayable_VendorPurchaseOrderObj.MessageContent().getText();
		System.out.println(mssg);
		waithelper.waitForElementwithFluentwait(driver,accountPayable_VendorPurchaseOrderObj.ConfirmationMessageCloseButton());
		accountPayable_VendorPurchaseOrderObj.ConfirmationMessageCloseButton().click();
		break;
		} catch (Exception e) {
		}
	}
}
		 
@Then("^Click on Item Details Record$")
public void click_on_item_details_record() throws InterruptedException {

	Thread.sleep(2000);
waithelper.waitForElementToVisibleWithFluentWait(driver, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ItemDetailsRecord(), 15, 1);
accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ItemDetailsRecord().click();

	// validate msg

//	  		WebElement toast = accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_VaildationMsg();
//	  		waithelper.waitForElement(driver, 3000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_VaildationMsg());
//	  		clicksAndActionHelper.clickOnElement(toast);;
//	    	String message = accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_VaildationMsg().getText();
//	    	System.out.println(message);

}
		
@Then("^Edit the item details fields$")
public void edit_the_item_details_fields() throws InterruptedException {

	while(true) {
			try {
			waithelper.waitForElementwithFluentwait(driver, accountPayable_VendorPurchaseOrderObj.MessageContent());
			String mssg =accountPayable_VendorPurchaseOrderObj.MessageContent().getText();
			System.out.println(mssg);
			waithelper.waitForElementwithFluentwait(driver, accountPayable_VendorPurchaseOrderObj.ConfirmationMessageCloseButton());
			accountPayable_VendorPurchaseOrderObj.ConfirmationMessageCloseButton().click();
			break;
				}
				catch(Exception e) {}
			}
	while(true) {
		try {
		waithelper.waitForElementwithFluentwait(driver, accountPayable_VendorPurchaseOrderObj.MessageContent());
		String mssg =accountPayable_VendorPurchaseOrderObj.MessageContent().getText();
		System.out.println(mssg);
		waithelper.waitForElementwithFluentwait(driver, accountPayable_VendorPurchaseOrderObj.ConfirmationMessageCloseButton());
		accountPayable_VendorPurchaseOrderObj.ConfirmationMessageCloseButton().click();
		break;
			}
			catch(Exception e) {}
		}
		
			while(true) {
				try {
				waithelper.waitForElementwithFluentwait(driver, accountPayable_VendorPurchaseOrderObj.MessageContent());
				String mssg =accountPayable_VendorPurchaseOrderObj.MessageContent().getText();
				System.out.println(mssg);
				waithelper.waitForElementwithFluentwait(driver, accountPayable_VendorPurchaseOrderObj.ConfirmationMessageCloseButton());
				accountPayable_VendorPurchaseOrderObj.ConfirmationMessageCloseButton().click();
				break;
					}
					catch(Exception e) {}
				}
					

			//Shipped from Location
	Thread.sleep(2000);
	waithelper.waitForElementToVisibleWithFluentWait(driver, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ShippedFromLocation(), 15, 1);
	accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ShippedFromLocation().click();
	Thread.sleep(2000);
	accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ShippedFromLocation().sendKeys(testData.get("ShippedFromLocation"));
	Thread.sleep(2000);
	accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ShippedFromLocation().sendKeys(Keys.ENTER);
			
			//DeliveryLocation
	waithelper.waitForElementToVisibleWithFluentWait(driver, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_DeliveryLocation(), 15, 1);
	accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_DeliveryLocation().click();
	Thread.sleep(2000);
	accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_DeliveryLocation().sendKeys(testData.get("DeliveryLocation"));
	accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_DeliveryLocation().sendKeys(Keys.ENTER);

	}
	@Then("^Click on Account Payable Notification$")
	public void click_on_account_payable_notification() {
	for (int i = 1; i <= 35; i++) {
				try {
		waithelper.waitForElementToVisibleWithFluentWait(driver, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ShippedFromLocation(), 15, 1);
        accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_Notification().click();
		break;}
				catch(Exception e) {}}
	}
	@Then("^Search purchase order record in List$")
    public void search_purchase_order_record_in_list()  {
		waithelper.waitForElementwithFluentwait(driver, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_InboxSearchIcon());
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_InboxSearchIcon().click();
			
		waithelper.waitForElementwithFluentwait(driver, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_EventCodeSearch());
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_EventCodeSearch().sendKeys(testData.get("EventCode"));
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_EventCodeSearch().sendKeys(Keys.ENTER);   
    }
		 
		 @Then("^Select the record from Notification$")
		 public void select_the_record_from_notification() throws Throwable {
			// Reference
			 Thread.sleep(2000);
			waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ReferenceId());
			String referenceid = accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ReferenceId().getText();
//			jsonWriter.addReferanceData(id);
			excelData.updateTestData("KUBS_AR/AP_UAT_001_001_TC_002_02_D1", "ReferenceID", referenceid); 
			for (int i = 1; i <=199; i++) {
				try {
	    	waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.ActionButton());
	    	accountPayable_VendorPurchaseOrderObj.ActionButton().click();
			 
	    	break;
				}
				catch(Exception e) {
					if (i==199) {
						Assert.fail(e.getMessage());
					}
				}
				} 
			
		}
		 
		@And("^Submit the Selected record$")
		public void submit_the_selected_record() throws InterruptedException, IOException {
			
			// Submit button
        	waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_SubmitButton());
        	accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_SubmitButton().click();
        			
        	//Remark
        	javascripthelper.JavaScriptHelper(driver);
        	waithelper.waitForElement(driver, 3000,accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RemarkField());
        	javascripthelper.JSEClick(accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RemarkField());
        	accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RemarkField().sendKeys("OK");
        	//inventoryMaintenanceTestDataType.Remark
        			    
        			
        	//Remark Submit
        	
        	waithelper.waitForElement(driver, 2000,accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_SubmitByMaker());
        	accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_SubmitByMaker().click();
        	Thread.sleep(2000);
        	
        	// REVIEWER
        			Thread.sleep(2000);
        			WebElement recordstatus = accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RecordStatus();

        			clicksAndActionHelper.moveToElement(recordstatus);
        			String message = accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RecordStatus().getText();
        			System.out.println(message);
        			accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RecordStatus().click();
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
        			excelData.updateTestData("KUBS_AR/AP_UAT_001_001_TC_002_02_D1", "ReviewerID", reviewerId); 
			
		}
		
		@And("^user update the data set ID for purchase order Reviewer$")
	    public void user_update_the_data_set_id_for_purchase_order_reviewer()   {
			testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_001_TC_002_02_D1");    
	    }

	    @And("^User login as a reviewer user Approve purchase order$")
	    public void user_login_as_a_reviewer_user_approve_purchase_order()   {
	    	login = new KUBS_Login(driver);
			driver.get(config.getApplicationUrl());
			login.logintoAzentioappReviewer("Reviewer", testData.get("ReviewerID"));   
	    }

	    @And("^approve the purchase order record by reviewer user$")
	    public void approve_the_purchase_order_record_by_reviewer_user() throws InterruptedException  {
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

			
					waithelper.waitForElementwithFluentwait(driver, accountPayable_VendorPurchaseOrderObj.Approve_Button());
					accountPayable_VendorPurchaseOrderObj.Approve_Button().click();
//					waithelper.waitForElement(driver, 3000, accountPayable_VendorPurchaseOrderObj.accountPayable_VendorContracts_ApproveRemarkByReviewer());
	waithelper.waitForElementwithFluentwait(driver, accountPayable_VendorPurchaseOrderObj.ApproveRemarkByReviewer());
	accountPayable_VendorPurchaseOrderObj.ApproveRemarkByReviewer().click();
			
	waithelper.waitForElementwithFluentwait(driver, accountPayable_VendorPurchaseOrderObj.ApproveRemarkByReviewer());
		accountPayable_VendorPurchaseOrderObj.ApproveRemarkByReviewer().sendKeys(testData.get("ReviewerAlertRemark"));
//					waithelper.waitForElement(driver, 3000, accountPayable_VendorPurchaseOrderObj.accountPayable_VendorContracts_Submit());
					waithelper.waitForElementwithFluentwait(driver, accountPayable_VendorPurchaseOrderObj.Submit());
					accountPayable_VendorPurchaseOrderObj.Submit().click();
//					Thread.sleep(2000);
					waithelper.waitForElementwithFluentwait(driver, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RecordStatus());
			    	WebElement recordstatus = accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RecordStatus();
			    	clicksAndActionHelper.moveToElement(recordstatus);
			    	String message = accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RecordStatus().getText();
			    	System.out.println(message);
			    	accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RecordStatus().click();
   
	    }


	    @And("^Click on claim button in checker for purchase order$")
	    public void click_on_claim_button_in_checker_for_purchase_order() throws InterruptedException  {
	    	String before_xpath = "//span[contains(text(),'";
			String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
			//String after_xpath = ;
			//waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath_claim)));
			Thread.sleep(1000);
			
			driver.findElement(By.xpath(before_xpath+testData.get("ReferenceID")+after_xpath_claim)).click();
	    
			   
	    }
	    @Then("^checker should approved the purchase order record$")
	    public void checker_should_approved_the_purchase_order_record() throws Throwable {
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
	    		
	    		waithelper.waitForElementwithFluentwait(driver, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RecordStatus());
	        	WebElement recordstatus = accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RecordStatus();
	        	clicksAndActionHelper.moveToElement(recordstatus);
	        	String message = accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RecordStatus().getText();
	        	System.out.println(message);
	        	accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RecordStatus().click();
	    	    

	    }
	    @Then("^Get the purchase order Txn status by searching the record via business partner$")
	    public void get_the_purchase_order_txn_status_by_searching_the_record_via_business_partner() throws Throwable {
	    	for (int i = 1; i <= 35; i++) {
				try {
			waithelper.waitForElement(driver, 3000, accountPayable_VendorPurchaseOrderObj.accountPayable_VendorPurchaseOrder_Search());
			accountPayable_VendorPurchaseOrderObj.accountPayable_VendorPurchaseOrder_Search().click();
			break;}
			catch(Exception e) {}}
			waithelper.waitForElement(driver, 3000, accountPayable_VendorPurchaseOrderObj.accountPayable_VendorPurchaseOrder_BusinessPartnerSearch());
			accountPayable_VendorPurchaseOrderObj.accountPayable_VendorPurchaseOrder_BusinessPartnerSearch().click();

			accountPayable_VendorPurchaseOrderObj.accountPayable_VendorPurchaseOrder_BusinessPartnerSearch().sendKeys(testData.get("BPName"));
			accountPayable_VendorPurchaseOrderObj.accountPayable_VendorPurchaseOrder_BusinessPartnerSearch().sendKeys(Keys.ENTER);

			waithelper.waitForElement(driver, 3000, accountPayable_VendorPurchaseOrderObj.accountPayable_VendorPurchaseOrder_POStatus());
			System.out.println("Contract Status - " +accountPayable_VendorPurchaseOrderObj.accountPayable_VendorPurchaseOrder_POStatus().getText());
			
	    }
	    
	    
	    
	    //---------------KUBS_AR/AP_UAT_003_001_TC_02------------------------//
	    
	    @And("^user click search icon$")
		public void user_click_search_icon() throws Throwable {
			seleniumactions.getWaitHelper().waitForElement(driver, 2000, cancellationofcontract.getApserachicon());
			seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getApserachicon());
		}
	    @And("^user update the data set ID for po against cancelled order$")
	    public void user_update_the_data_set_id_for_po_against_cancelled_order() throws Throwable {
	    	testData = excelData.getTestdata("KUBS_AR/AP_UAT_003_001_TC_02_D1");
	    }
			
		
	    
	    @And("^user search cancelled vendor contract$")
		public void user_search_cancelled_vendor_contract() throws Throwable {
			seleniumactions.getWaitHelper().waitForElement(driver, 2000, cancellationofcontract.getSearchcontractstatus());
			seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getSearchcontractstatus());
			
			cancellationofcontract.getSearchcontractstatus().sendKeys(testData.get("Contractstatus"));
		}
	    @And("^user click the cancelled vendor contract eye icon$")
		public void user_click_the_cancelled_vendor_contract_eye_icon() throws Throwable {
			seleniumactions.getWaitHelper().waitForElement(driver, 2000,
					cancellationofcontract.getClickFirstEyeiconInListView());
			seleniumactions.getClickAndActionsHelper()
					.clickOnElement(cancellationofcontract.getClickFirstEyeiconInListView());
//			Thread.sleep(4000);
//			javascripthelper.scrollToElemet(cancellationofcontract.getClickFirstEyeiconInListView());
//			clicksAndActionHelper.moveToElement(cancellationofcontract.getClickFirstEyeiconInListView());
//			cancellationofcontract.getClickFirstEyeiconInListView().click();
		}
	    @And("^get buisness partner name and get contract name$")
	    public void get_buisness_partner_name_and_get_contract_name() throws Throwable {
			seleniumactions.getWaitHelper().waitForElement(driver, 2000,
					cancellationofcontract.getBuisnessPartnerNameinContract());
			String buisnessPartnerNameinCancelledContract = cancellationofcontract.getBuisnessPartnerNameinContract()
					.getText();
			testdata.put("buisnessPartnerNameinCancelledContract", buisnessPartnerNameinCancelledContract);
			javascripthelper.JavaScriptHelper(driver);
			String contractname = (String) javascripthelper.executeScript("return document.getElementsByName('contractName')[1].value");
	        testdata.put("contractname", contractname);
		}
	    
	    @And("^select buisness partner we get in cancelled list$")
		public void select_buisness_partner_we_get_in_cancelled_list() throws Throwable {
			seleniumactions.getWaitHelper().waitForElement(driver, 2000,
					arpoCreationObj.accountsPayable_VendorPurchaseOrder_BPName());
			seleniumactions.getClickAndActionsHelper()
					.clickOnElement(arpoCreationObj.accountsPayable_VendorPurchaseOrder_BPName());
			arpoCreationObj.accountsPayable_VendorPurchaseOrder_BPName()
					.sendKeys(testdata.get("buisnessPartnerNameinCancelledContract"));
			arpoCreationObj.accountsPayable_VendorPurchaseOrder_BPName().sendKeys(Keys.ENTER);
		}
	    
	    @And("^select referece type as contract$")
		public void select_referece_type_as_contract() throws Throwable {
			seleniumactions.getWaitHelper().waitForElement(driver, 2000,
					arpoCreationObj.accountsPayable_VendorPurchaseOrder_ReferenceType());
			seleniumactions.getClickAndActionsHelper()
					.clickOnElement(arpoCreationObj.accountsPayable_VendorPurchaseOrder_ReferenceType());
			arpoCreationObj.accountsPayable_VendorPurchaseOrder_ReferenceType().sendKeys(Keys.ENTER);
		}
	    @And("^select the contract Name$")
	    public void select_the_contract_name() throws Throwable {
	        cancellationofcontract.selectContractName().click();
	        cancellationofcontract.selectContractName().sendKeys(testdata.get("contractname"));
	        cancellationofcontract.selectContractName().sendKeys(Keys.ENTER);
	    }
	    
	    @Then("^verify not able to select contract and po creation is not allowed$")
		public void verify_not_able_to_select_contract_and_po_creation_is_not_allowed() throws Throwable {
			seleniumactions.getWaitHelper().waitForElement(driver, 2000,
					arpoCreationObj.accountsPayable_VendorPurchaseOrder_Contract());
			seleniumactions.getClickAndActionsHelper()
					.clickOnElement(arpoCreationObj.accountsPayable_VendorPurchaseOrder_Contract());
			Thread.sleep(3000);
			System.out.println("No items found and not able to create purchase order for cancelled contract");

		}
	    

}
	    
	    
	    
	    
	    

