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
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
import pageobjects.AccountPayable_VendorPurchaseOrderObj;
import pageobjects.Azentio_CheckerObj;
import pageobjects.Azentio_ReviewerObj;
import pageobjects.INVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj;
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;

public class InventoryManagement_PurchaseOrderCreation {
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	Azentio_ReviewerObj reviewer;
	ConfigFileReader config = new ConfigFileReader();
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(driver);
	WaitHelper waithelper = new WaitHelper(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	BrowserHelper browserHelper;
	INVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj iNVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj = new INVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj(driver);
	AccountPayable_VendorPurchaseOrderObj accountPayable_VendorPurchaseOrderObj = new AccountPayable_VendorPurchaseOrderObj(driver);


	ExcelData excelData = new ExcelData("C:\\Users\\ININDC00091\\git\\AzentioAutomationFramework\\DeveshFW_Excel\\ARAP_AzentioAutomationFramework_Excel\\Test-data\\KUBS_InventoryMgmt_TestData.xlsx",
			"PurchaseOrderTestData", "Data Set ID");
	Map<String, String> testData = new HashMap<>();
	String dataSetID;

//	@And("^user should navigate to inventory management$")
//	public void user_should_navigate_to_inventory_management() throws InterruptedException {
//		Thread.sleep(2000);
////		waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_DirectionButton());
//		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_DirectionButton());
//		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_DirectionButton().click();
//		waithelper.waitForElement(driver, 4000, iNVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj.inventoryManagementMenu());
//		iNVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj.inventoryManagementMenu().click();
//	}
	
	@Then("^click on first eye button to get the indent reference number for po$")
	public void click_on_first_eye_button_to_get_the_indent_reference_number_for_po() throws InterruptedException, IOException {
		javascripthelper.JavaScriptHelper(driver);

//		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractCodeEyeButton());
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractCodeEyeButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractCodeEyeButton().click();
		Thread.sleep(2000);
		String indentrefnumber = javascripthelper.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[6].value").toString();
		System.out.println(" Unique Indent Reference Number is -: " + indentrefnumber);
//		jsonWriter.addInventoryManagementPRnumber(indentrefnumber);
		excelData.updateTestData(dataSetID, "IndentRefNumber", indentrefnumber);
		testData = excelData.getTestdata(dataSetID);
	}

	@Then("^Click on Account Payable$")
	public void click_on_account_payable() {
//		waithelper.waitForElement(driver, 4000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_AccountsPayableField());
		javascripthelper.JavaScriptHelper(driver);
		javascripthelper.scrollIntoView(accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_DirectionIcon());
		waithelper.waitForElementwithFluentwait(driver, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_AccountsPayableField());
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_AccountsPayableField().click();

	}

	@Then("^Fill purchase order for inventory Mandatory fields$")
	public void Fill_purchase_order_for_inventory_Mandatory_fields() throws InterruptedException, IOException, ParseException {
//		accountPayable_VendorPurchaseOrderTestDataType = jsonReader.getVendorPurchaseOrderyByName("Maker");
		// Entity Branch
		waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_EntityBranch());
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_EntityBranch().click();
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_EntityBranch().sendKeys(testData.get("EntityBranch"));
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_EntityBranch().sendKeys(Keys.ENTER);

		// BP Name
		waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_BPName());
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_BPName().click();
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_BPName().sendKeys(testData.get("BpName"));
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_BPName().sendKeys(Keys.ENTER);

		// Reference Type
		waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ReferenceType());
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ReferenceType().click();
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ReferenceType().sendKeys(testData.get("ReferenceTypePurchaseReq"));
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ReferenceType().sendKeys(Keys.ENTER);

		// Contract
		waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_Contract());
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_Contract().click();
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_Contract().sendKeys(testData.get("IndentRefNumber"));
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_Contract().sendKeys(Keys.ENTER);

		// CheckBox Po Item
		waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_CheckBoxPoItem());
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_CheckBoxPoItem().click();

		// Po Quantity
		waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PoQuantity());
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PoQuantity().click();
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PoQuantity().sendKeys(testData.get("PoQuantity"));
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PoQuantity().sendKeys(Keys.ENTER);

		// Po item save
		WebElement posave = waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PoItemSave());
		clicksAndActionHelper.clickOnElement(posave);

		// PO type
//			 waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_POType());
//			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_POType().click();
//			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_POType().sendKeys(accountPayable_VendorPurchaseOrderTestDataType.ReferenceTypePurchaseReq);
//			 accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_POType().sendKeys(Keys.ENTER);

		// PO Sub type
		waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_POSubType1());
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_POSubType1().click();
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_POSubType1().sendKeys(testData.get("PoSubTypeForInventory"));
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_POSubType1().sendKeys(Keys.ENTER);

		// CostCenterService
		waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_CostCenter1());
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_CostCenter1().click();
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_CostCenter1().sendKeys(testData.get("CostCenterService"));
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_CostCenter1().sendKeys(Keys.ENTER);

		// Po Delivery Date
//			 Thread.sleep(2000);
//			 waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PODeliveryDate());
		waithelper.waitForElementwithFluentwait(driver, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PODeliveryDate());
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PODeliveryDate().click();

		javascripthelper.JavaScriptHelper(driver);
		Thread.sleep(1000);
		while (true) {
			try {
				// span[contains(text(),'Nov 2022')]
				waithelper.waitForElementToVisibleWithFluentWait(driver, driver.findElement(
						By.xpath("//span[contains(text(),'" + testData.get("Month") + " " + testData.get("Year") + "')]")), 2, 1);
				WebElement monthAndYear = driver
						.findElement(By.xpath("//span[contains(text(),'" + testData.get("Month") + " " + testData.get("Year") + "')]"));
				break;
			} catch (Exception e) {
				accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_NextMonth().click();
			}
		}
		// td[@aria-label='November 1, 2022']/span
		while (true) {
			try {
				waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth") + " "
						+ testData.get("Date") + ", " + testData.get("Year") + "']/span")));
				WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth") + " "
						+ testData.get("Date") + ", " + testData.get("Year") + "']/span"));
				clicksAndActionHelper.doubleClick(FinalDay);
				break;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	@Then("^Edit the item details fields po$")
	public void edit_the_item_details_fields_po() {
		waithelper.waitForElementwithFluentwait(driver, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RecordStatus());
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RecordStatus();
//		accountPayable_VendorPurchaseOrderTestDataType = jsonReader.getVendorPurchaseOrderyByName("Maker");

		// Shipped from Location
//		waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ShippedFromLocation());
		waithelper.waitForElementwithFluentwait(driver, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ShippedFromLocation());
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ShippedFromLocation().click();
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ShippedFromLocation().sendKeys(testData.get("ShippedFromLocation"));
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ShippedFromLocation().sendKeys(Keys.ENTER);

		waithelper.waitForElementwithFluentwait(driver, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RatePerUnitService());
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RatePerUnitService().sendKeys(testData.get("RatePerUnit"));
		// DeliveryLocation
//			waithelper.waitForElement(driver, 2000,accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_DeliveryLocation());
//			accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_DeliveryLocation().click();
//			accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_DeliveryLocation().sendKeys(accountPayable_VendorPurchaseOrderTestDataType.DeliveryLocation);
//			accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_DeliveryLocation().sendKeys(Keys.ENTER);

	}

	@Then("^Click on the item details save button po$")
	public void Click_on_the_item_details_save_button_po() throws InterruptedException {
//			Thread.sleep(3000);
		waithelper.waitForElementwithFluentwait(driver, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PopUpCloseButton());
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PopUpCloseButton().click();
//			waithelper.waitForElementwithFluentwait(driver, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PopUp2CloseButton());
//			accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PopUp2CloseButton().click();
		waithelper.waitForElementwithFluentwait(driver, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ItemDetailsSave());
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ItemDetailsSave().click();
//			waithelper.waitForElementwithFluentwait(driver, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_Save());
//			accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_Save().click();
	}

	@Then("^Click on Beneficiary details tab$")
	public void Click_on_Beneficiary_details_tab() throws InterruptedException {
//	    waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_BeneficiarySave());
//	    accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_BeneficiarySave().click();
		Thread.sleep(2000);
		waithelper.waitForElementwithFluentwait(driver, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_BeneficiaryTab());
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_BeneficiaryTab().click();
	}

	@Then("^fill Beneficiary Details$")
	public void fill_beneficiary_details() {

//		accountPayable_VendorPurchaseOrderTestDataType = jsonReader.getVendorPurchaseOrderyByName("Maker");
		// ModeOfPayement
//			 waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ModeOfPayement());
		waithelper.waitForElementwithFluentwait(driver, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ModeOfPayement());
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ModeOfPayement().click();
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ModeOfPayement().sendKeys(testData.get("ModeOfPayement"));
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ModeOfPayement().sendKeys(Keys.ENTER);

		// AutoPayout
		waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_AutoPayout());
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_AutoPayout().click();
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_AutoPayout().sendKeys(testData.get("AutoPayout"));
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_AutoPayout().sendKeys(Keys.ENTER);

		// CreditPeriod
		waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_CreditPeriod());
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_CreditPeriod().click();
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_CreditPeriod().sendKeys(testData.get("CreditPeriod"));
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_CreditPeriod().sendKeys(Keys.ENTER);

	}

	@Then("^Click on Beneficiary Save button$")
	public void click_on_beneficiary_save_button() {
//	    waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_BeneficiarySave());
		waithelper.waitForElementwithFluentwait(driver, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_BeneficiarySave());
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_BeneficiarySave().click();
//	    waithelper.waitForElementwithFluentwait(driver, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RecordStatus());
//	    accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RecordStatus().click();   
	}
	
	@Then("^Select the po creation record from Notification$")
	 public void select_the_po_creation_record_from_notification() throws Throwable {
		// Reference
		 Thread.sleep(2000);
//		waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ReferenceId());
		waithelper.waitForElementwithFluentwait(driver, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ReferenceId());
		String referenceid = accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ReferenceId().getText();
//		jsonWriter.addReferanceData(id);
//		excelData.updateTestData("KUBS_AR/AP_UAT_001_001_TC_002_02_D1", "ReferenceID", referenceid); 
		
		excelData.updateTestData(dataSetID, "ReferenceID", referenceid);
		testData = excelData.getTestdata(dataSetID);
		
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
	
	@And("^Submit the Selected po creation record$")
	public void submit_the_selected_po_creation_record() throws InterruptedException, IOException {
		
		// Submit button
//    	waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_SubmitButton());
    	waithelper.waitForElementwithFluentwait(driver, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_SubmitButton());
    	accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_SubmitButton().click();
    			
    	//Remark
    	javascripthelper.JavaScriptHelper(driver);
//    	waithelper.waitForElement(driver, 3000,accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RemarkField());
    	waithelper.waitForElementwithFluentwait(driver, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RemarkField());
    	javascripthelper.JSEClick(accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RemarkField());
    	accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RemarkField().sendKeys("OK");
    	//inventoryMaintenanceTestDataType.Remark
    			    
    			
    	//Remark Submit
    	
//    	waithelper.waitForElement(driver, 2000,accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_SubmitByMaker());
    	waithelper.waitForElementwithFluentwait(driver, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_SubmitByMaker());
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
//    			excelData.updateTestData("KUBS_AR/AP_UAT_001_001_TC_002_02_D1", "ReviewerID", reviewerId); 
    			excelData.updateTestData(dataSetID, "ReviewerID", reviewerId);
    			testData = excelData.getTestdata(dataSetID);
		
	}

	@Then("^log in to the reviewer account$")
	public void log_in_to_the_reviewer_account() throws IOException, ParseException {
//		reader = new JsonDataReaderWriter();
		login = new KUBS_Login(driver);
		driver.get(config.getApplicationUrl());
		login.logintoAzentioappReviewer("Reviewer", testData.get("ReviewerID"));

	}

	@Then("^click on the Notification select the record and Approve$")
	public void click_on_the_notification_select_the_record_and_approve() throws InterruptedException, IOException, ParseException {
		// notification
		waithelper = new WaitHelper(driver);
		reviewer = new Azentio_ReviewerObj(driver);
		waithelper.waitForElement(driver, 2000, reviewer.reviewerNotidicationIcon());
		reviewer.reviewerNotidicationIcon().click();

		// select the record
		browserHelper = new BrowserHelper(driver);
//		budgetdata = jsonReader.getBudgetdataByName("Maker");
		javascripthelper = new JavascriptHelper();
		Thread.sleep(1000);
		for (int i = 1; i <= 35; i++) {
			try {
				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[text()='" + testData.get("ReferenceID") + "']")));
				WebElement referanceID = driver.findElement(By.xpath("//span[text()='" + testData.get("ReferenceID") + "']"));
				referanceID.click();
				Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElement(driver, 4000, kubschecker.checker_notification_next_button());

				kubschecker.checker_notification_next_button().click();
			}
		}
		String before_xpath = "//span[text()='";
		String after_xpath = "']/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

		waithelper.waitForElement(driver, 5000, driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)));
		driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)).click();

		// Approve
//			waithelper.waitForElement(driver, 4000, reviewer.reviewerApproveButton());
		waithelper.waitForElementwithFluentwait(driver, reviewer.reviewerApproveButton());
		reviewer.reviewerApproveButton().click();

//			waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertRemarks());
		waithelper.waitForElementwithFluentwait(driver, reviewer.reviewerAlertRemarks());
		clicksAndActionHelper.JSEClick(reviewer.reviewerAlertRemarks());
		reviewer.reviewerAlertRemarks().sendKeys("ok");

//			waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertSubmitButton());
		waithelper.waitForElementwithFluentwait(driver, reviewer.reviewerAlertSubmitButton());
		reviewer.reviewerAlertSubmitButton().click();
		Thread.sleep(3000);

	}
	
	@And("^then checker claim the po creation record$")
	public void then_checker_claim_the_po_creation_record() throws InterruptedException, IOException, ParseException {

		// open pool
		waithelper = new WaitHelper(driver);
		kubschecker = new KUBS_CheckerObj(driver);
//		waitHelper.waitForElement(driver, 3000, kubschecker.checkerSecurityManagement());
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubschecker.checkerSecurityManagement(), 20, 2);
		kubschecker.checkerSecurityManagement().click();

		// claim
		waithelper.waitForElement(driver, 3000, kubschecker.checkerActionIcon());
		kubschecker.checkerActionIcon().click();
		Thread.sleep(2000);
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		waithelper.waitForElement(driver, 5000, driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath_claim)));
		driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath_claim)).click();
		waithelper.waitForElement(driver, 3000, kubschecker.checkerAlertClose());
		kubschecker.checkerAlertClose().click();
		
	}
	
	@And("^select the po creation record and Approve by checker$")
	public void select_the_po_creation_record_and_approve_by_checker() throws InterruptedException, IOException, ParseException {
		Thread.sleep(2000);
		for (int i = 1; i <= 35; i++) {
			try {
//			waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +reader.readReferancedata()+ "')]")));
				waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]")));
				WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]"));
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

//			waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath(before_xpath +reader.readReferancedata()+after_xpath)));
		waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)));
		driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)).click();

//		waithelper.waitForElement(driver, 2000, kubschecker.checkerApproveButton());
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerApproveButton());
		kubschecker.checkerApproveButton().click();
//		waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerRemarks());
		kubschecker.checkerRemarks().sendKeys("ok");
//		waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();
//		Thread.sleep(2000);
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
		WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
		clicksAndActionHelper.moveToElement(recordstatus);
		String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
		System.out.println(message);
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
	}
	
	@Then("^click on first eye button to get an unique po number$")
	public void click_on_first_eye_button_to_get_an_unique_po_number() throws InterruptedException {
//		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractCodeEyeButton());
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractCodeEyeButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractCodeEyeButton().click();
		Thread.sleep(2000);
		javascripthelper.JavaScriptHelper(driver);
		String uniqueNo = javascripthelper.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[2].value").toString();
		System.out.println("Unique PO Number: " + uniqueNo);

	}

//	@Then("^log in to the Checker Account$")
//	public void log_in_to_the_checker_account() throws InterruptedException {
//		login = new KUBS_Login(driver);
//		driver.get(config.getApplicationUrl());
//		login.loginToAzentioAppAsChecker("Checker");
//
//	}
	
	@Then("^select data set ID for PO creation$")
    public void select_data_set_id_for_po_creation() throws Throwable {
		dataSetID = "KUBS_INV_MGMT_UAT_001_004_D1";
		testData = excelData.getTestdata(dataSetID);
    }
	@Then("^update data set ID for PO creation for reviewer$")
	public void update_data_set_id_for_po_creation_for_reviewer() throws Throwable {
		dataSetID = "KUBS_INV_MGMT_UAT_001_004_D1";
		testData = excelData.getTestdata(dataSetID);
	}
	@Then("^update data set ID for PO creation for checker$")
	public void update_data_set_id_for_po_creation_for_checker() throws Throwable {
		dataSetID = "KUBS_INV_MGMT_UAT_001_004_D1";
		testData = excelData.getTestdata(dataSetID);
	}

}
