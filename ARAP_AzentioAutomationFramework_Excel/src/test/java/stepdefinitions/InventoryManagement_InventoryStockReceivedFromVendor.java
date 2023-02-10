package stepdefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
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
import pageobjects.ACCOUNTSPAYABLE_InvoiceBookingObj;
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
import pageobjects.AccountPayable_VendorPurchaseOrderObj;
import pageobjects.Azentio_CheckerObj;
import pageobjects.Azentio_ReviewerObj;
import pageobjects.BUDGET_BudgetTransferObj;
import pageobjects.INVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj;
import pageobjects.InventoryMaintenanceObj;
import pageobjects.InventoryManagamentObj;
import pageobjects.InventoryManagement_InventoryStockReceiptObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;
import utilities.ExtentTestManager;

public class InventoryManagement_InventoryStockReceivedFromVendor {
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	Azentio_ReviewerObj reviewer = new Azentio_ReviewerObj(driver);;
	ConfigFileReader config = new ConfigFileReader();
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(driver);
	WaitHelper waithelper = new WaitHelper(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	BrowserHelper browserHelper;
	InventoryMaintenanceObj inventoryMaintenanceObj = new InventoryMaintenanceObj(driver);
	InventoryManagement_InventoryStockReceiptObj inventoryManagement_InventoryStockReceiptObj = new InventoryManagement_InventoryStockReceiptObj(driver);
//	INVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj iNVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj = new INVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj(driver);
	AccountPayable_VendorPurchaseOrderObj accountPayable_VendorPurchaseOrderObj = new AccountPayable_VendorPurchaseOrderObj(driver);
	ACCOUNTSPAYABLE_InvoiceBookingObj aCCOUNTSPAYABLE_InvoiceBookingObj = new ACCOUNTSPAYABLE_InvoiceBookingObj(driver);

	InventoryManagamentObj inventoryManagamentObj = new InventoryManagamentObj(driver);
	BUDGET_BudgetTransferObj budgetTransferObj = new BUDGET_BudgetTransferObj(driver);

	ExcelData excelData = new ExcelData("C:\\Users\\ININDC00091\\git\\AzentioAutomationFramework\\DeveshFW_Excel\\ARAP_AzentioAutomationFramework_Excel\\Test-data\\KUBS_InventoryMgmt_TestData.xlsx",
			"InventoryStockReceivedTestData", "Data Set ID");
	Map<String, String> testData = new HashMap<>();
	String dataSetID;

	@Then("^Click on Accounts Payable$")
	public void click_on_accounts_payable() throws Throwable {
//    	waithelper.waitForElement(driver, 2000,inventoryManagamentObj.accountPayableButton());
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.accountPayableButton());
		inventoryManagamentObj.accountPayableButton().click();
	}

	@Then("^click on first eye button to get the grn number$")
	public void click_on_first_eye_button_to_get_the_grn_number() throws InterruptedException, IOException {

		javascripthelper.JavaScriptHelper(driver);
		waithelper.waitForElement(driver, 2000, inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_FirstEyeButton());
		inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_FirstEyeButton().click();
		Thread.sleep(2000);
		String grnnumber = javascripthelper.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[2].value").toString();
		System.out.println("GRN Number: " + grnnumber);
//		jsonWriter.addInventoryManagementGRNnumber(grnnumber);
		excelData.updateTestData(dataSetID, "grnNumber", grnnumber);
		testData = excelData.getTestdata(dataSetID);

	}

	@Then("^Click on inventory stock receipt Eye Icon$")
	public void click_on_inventory_stock_receipt_eye_icon() throws InterruptedException {
//    Thread.sleep(2000);
		waithelper.waitForElementwithFluentwait(driver, inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_EyeButton());
		WebElement EyeIcon = inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_EyeButton();
		waithelper.waitForElement(driver, 3000, inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_EyeButton());
		Assert.assertTrue(inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_EyeButton().isDisplayed());
		clicksAndActionHelper.moveToElement(EyeIcon);
		inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_EyeButton().click();

	}

	@Then("^Click on inventory stock Add button$")
	public void click_on_inventory_stock_add_button() throws InterruptedException {
//    Thread.sleep(2000);
//    waithelper.waitForElement(driver, 3000, inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_AddButton());
		waithelper.waitForElementwithFluentwait(driver, inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_AddButton());
		inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_AddButton().click();

	}

	@Then("^Fill inventory stock Mandatory fields$")
	public void fill_inventory_stock_mandatory_fields() throws IOException, ParseException {
//		inventoryManagement_InventoryStockReceiptTestDataType = jsonReader.getInventoryStockReceiptByName("Maker");
		// GRN Number
//		waithelper.waitForElement(driver, 3000, inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_GRNNumber());
		waithelper.waitForElementwithFluentwait(driver, inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_GRNNumber());
		inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_GRNNumber().click();
		inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_GRNNumber().sendKeys(testData.get("grnNumber"));
		inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_GRNNumber().sendKeys(Keys.ENTER);

		// Accepted Quantity
//    waithelper.waitForElement(driver, 3000, inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_AcceptedQuantity());
// 	inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_AcceptedQuantity().click();
// 	inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_AcceptedQuantity().sendKeys(inventoryManagement_InventoryStockReceiptTestDataType.AcceptedQuantity);
// 	inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_AcceptedQuantity().sendKeys(Keys.ENTER);

	}

	@Then("^Click on inventory stock Save button$")
	public void click_on_inventory_stock_save_button() {
//  	waithelper.waitForElement(driver, 3000, inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_Save());
		waithelper.waitForElementwithFluentwait(driver, inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_Save());
		inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_Save().click();

  	waithelper.waitForElementwithFluentwait(driver, inventoryManagement_InventoryStockReceiptObj.inventoryStockReceipt_PopUpCloseButton());
  	inventoryManagement_InventoryStockReceiptObj.inventoryStockReceipt_PopUpCloseButton().click();
  	
	}

	@Then("^Click on inventory stock Notification$")
	public void click_on_inventory_stock_notification() {
		waithelper.waitForElement(driver, 3000, inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_MakerNotification());
		inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_MakerNotification().click();

	}

	@And("^Select and Submit the record$")
	public void select_and_submit_the_record() throws InterruptedException, IOException, ParseException {

		// Reference
		waithelper.waitForElement(driver, 2000, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReferenceId());
		String id = inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReferenceId().getText();
//		jsonWriter.addReferanceData(id);
		
		excelData.updateTestData(dataSetID, "ReferenceID", id);
		testData = excelData.getTestdata(dataSetID);
		
		System.out.println("Reference ID:" + id);
		Thread.sleep(1000);
		for (int i = 1; i <= 35; i++) {
			try {
				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[text()='" + testData.get("ReferenceID") + "']")));
				WebElement referanceID = driver.findElement(By.xpath("//span[text()='" + testData.get("ReferenceID") + "']"));
				referanceID.click();
				System.out.println(referanceID);
				// Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElement(driver, 4000, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_NotificationNext_Button());

				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_NotificationNext_Button().click();
			}

		}
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReferenceId().click();

		// pencil
		String before_xpath = "//span[text()='";
		String after_xpath = "']/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

		waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)));
		driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)).click();

		// Submit button
		waithelper.waitForElement(driver, 2000, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitButton());
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitButton().click();

		// Remark
		javascripthelper.JavaScriptHelper(driver);
		waithelper.waitForElement(driver, 3000, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RemarkField());
		javascripthelper.JSEClick(inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RemarkField());
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RemarkField().sendKeys("OK");
		// inventoryMaintenanceTestDataType.Remark

		// Remark Submit
		waithelper.waitForElement(driver, 2000, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitByMaker());
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitByMaker().click();
//        	Thread.sleep(3000);

		// REVIEWER
//        			waithelper.waitForElement(driver, 5000, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RecordStatus());
		waithelper.waitForElementwithFluentwait(driver, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RecordStatus());
		WebElement recordstatus = inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RecordStatus();

		clicksAndActionHelper.moveToElement(recordstatus);
		String message = inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RecordStatus().getText();
		System.out.println(message);
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RecordStatus().click();
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
//		jsonWriter = new JsonDataReaderWriter();
//		jsonWriter.addData(reviewerId);
		
		excelData.updateTestData(dataSetID, "ReviewerID", reviewerId);
		testData = excelData.getTestdata(dataSetID);

	}
	
	@Then("^log in to the reviewer account to approve stock receipt record$")
	public void log_in_to_the_reviewer_account_to_approve_stock_receipt_record() throws IOException, ParseException {
//		reader = new JsonDataReaderWriter();
		login = new KUBS_Login(driver);
		driver.get(config.getApplicationUrl());
		login.logintoAzentioappReviewer("Reviewer", testData.get("ReviewerID"));

	}
	
	@Then("^click on the Notification select the stock receipt record and Approve$")
	public void click_on_the_notification_select_the_stock_receipt_record_and_approve() throws InterruptedException, IOException, ParseException {
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
		Thread.sleep(2000);

	}
	
	@And("^then checker claim the stock receipt record$")
	public void then_checker_claim_the_stock_receipt_record() throws InterruptedException, IOException, ParseException {

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
	
	@And("^select the stock receipt record and Approve by checker$")
	public void select_the_stock_receipt_record_and_approve_by_checker() throws InterruptedException, IOException, ParseException {
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerNotificationIcon());
		kubschecker.checkerNotificationIcon().click();
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

		waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)));
		driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)).click();

//			waithelper.waitForElement(driver, 4000, kubschecker.checkerApproveButton());
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerApproveButton());
		kubschecker.checkerApproveButton().click();
//			waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertRemarks());
		waithelper.waitForElementwithFluentwait(driver, reviewer.reviewerAlertRemarks());
		reviewer.reviewerAlertRemarks().sendKeys("ok");
//			Thread.sleep(1000);
//			waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertSubmitButton());
		waithelper.waitForElementwithFluentwait(driver, reviewer.reviewerAlertSubmitButton());
		reviewer.reviewerAlertSubmitButton().click();
		Thread.sleep(3000);
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////

	@Then("^select data set ID for inventory stock received from vendor$")
	public void select_data_set_id_for_inventory_stock_received_from_vendor() throws Throwable {
		dataSetID = "KUBS_INV_MGMT_UAT_001_006_TC_01_D1";
		testData = excelData.getTestdata(dataSetID);
	}
	
	@Then("^update data set ID for inventory stock received from vendor for reviewer$")
    public void update_data_set_id_for_inventory_stock_received_from_vendor_for_reviewer() throws Throwable {
		dataSetID = "KUBS_INV_MGMT_UAT_001_006_TC_01_D1";
		testData = excelData.getTestdata(dataSetID);
    }

    @Then("^update data set ID for inventory stock received from vendor for checker$")
    public void update_data_set_id_for_inventory_stock_received_from_vendor_for_checker() throws Throwable {
    	dataSetID = "KUBS_INV_MGMT_UAT_001_006_TC_01_D1";
		testData = excelData.getTestdata(dataSetID);
    }

}
