package stepdefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import dataProvider.ConfigFileReader;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.Selenium_Actions;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ACCOUNTSPAYABLE_AutoPayoutObj;
import pageobjects.ACCOUNTSPAYABLE_InvoiceBookingObj;
import pageobjects.ACCOUNTSPAYABLE_PayementSettlementObj;
import pageobjects.ACCOUNTSPAYABLE_VendorContractCreationObj;
import pageobjects.ACCOUNTSPAYBLE_AccountsPayable_POCreationObj;
import pageobjects.ARAP_ARandAPObj;
import pageobjects.ARAP_GRNCreationPageObject;
import pageobjects.ARAP_PoCreationObj;
import pageobjects.AccountReceivable_UpdateDepositedChequeObj;
import pageobjects.Account_Receivable;
import pageobjects.ArAp_BalanceSheetReportObj;
import pageobjects.ArAp_Cancellation_of_vendorObj;
import pageobjects.Ar_Ap_AdjustmentObj;
import pageobjects.Ar_Po_creationObj;
import pageobjects.Azentio_CheckerObj;
import pageobjects.Azentio_ReviewerObj;
import pageobjects.Enquiry_Obj;
import pageobjects.INVENTORY_EnquiryGlObject;
import pageobjects.InventoryMaintenanceObj;
import pageobjects.Payment_SettlementObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;

public class ARAP_AutoPayoutPaymentSettlement extends BaseClass {
	WebDriver driver = BaseClass.driver;
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	Selenium_Actions seleniumactions = new Selenium_Actions(driver);
	ConfigFileReader configreader = new ConfigFileReader();
	Map<String, String> testdata = new LinkedHashMap<>();
	JavascriptHelper javaScriptHelper = new JavascriptHelper();
	BrowserHelper browserHelper = new BrowserHelper(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	Map<String, String> autoPayout = new HashMap<>();
	Azentio_ReviewerObj reviewer;
	String poNumber;
	String poBusinessPartner;
	Map<String, String> settlementTestData = new HashMap<>();
	Map<String, String> settlementData = new HashMap<>();
	ARAP_PoCreationObj ArAp_poCreationObj = new ARAP_PoCreationObj(driver);
	ARAP_GRNCreationPageObject grnObject = new ARAP_GRNCreationPageObject(driver);
	INVENTORY_EnquiryGlObject inventoryEnquiryGlObj = new INVENTORY_EnquiryGlObject(driver);
	ACCOUNTSPAYABLE_InvoiceBookingObj invoiceBookingObj = new ACCOUNTSPAYABLE_InvoiceBookingObj(driver);
	ACCOUNTSPAYABLE_PayementSettlementObj paymentSettlementObj = new ACCOUNTSPAYABLE_PayementSettlementObj(driver);
	ACCOUNTSPAYABLE_AutoPayoutObj accoutsPayableAutoPayoutObj = new ACCOUNTSPAYABLE_AutoPayoutObj(driver);
	AccountReceivable_UpdateDepositedChequeObj accountReceivable_UpdateDepositedChequeObj = new AccountReceivable_UpdateDepositedChequeObj(driver);
	InventoryMaintenanceObj inventoryMaintenanceObj = new InventoryMaintenanceObj(driver);
	ACCOUNTSPAYABLE_VendorContractCreationObj vendorContractObj = new ACCOUNTSPAYABLE_VendorContractCreationObj(driver);
	ACCOUNTSPAYBLE_AccountsPayable_POCreationObj poCreationObj = new ACCOUNTSPAYBLE_AccountsPayable_POCreationObj(driver);
	Azentio_CheckerObj kubschecker = new Azentio_CheckerObj(driver);

	ExcelData excelData = new ExcelData("C:\\Users\\ININDC00091\\git\\AzentioAutomationFramework\\DeveshFW_Excel\\ARAP_AzentioAutomationFramework_Excel\\Test-data\\KUBS_TESTDATA_V1.xlsx",
			"AutoPayoutTestData", "Data Set ID");
	Map<String, String> testData = new HashMap<>();
	String dataSetID;

	@And("^goto vendor contract module$")
	public void goto_vendor_contract_module() throws Throwable {
		waitHelper.waitForElementVisible(vendorContractObj.vendorContractEyeIcon(), 2000, 100);
		vendorContractObj.vendorContractEyeIcon().click();
	}

	@Then("^fill all the mendatory fields for creating vendor$")
	public void fill_all_the_mendatory_fields_for_creating_vendor() throws Throwable {
		waitHelper.waitForElementVisible(vendorContractObj.vendorContractExpenceType(), 2000, 100);
		vendorContractObj.vendorContractExpenceType().click();
		vendorContractObj.vendorContractExpenceType().sendKeys(testData.get("ContractType"));
		vendorContractObj.vendorContractExpenceType().sendKeys(Keys.ENTER);

		vendorContractObj.vendorContractBpName().click();
		vendorContractObj.vendorContractBpName().sendKeys(testData.get("BusinessPartnerName"));
		vendorContractObj.vendorContractBpName().sendKeys(Keys.ENTER);

		vendorContractObj.vendorContractContractName().click();
		vendorContractObj.vendorContractContractName().sendKeys(testData.get("ContractName"));

		vendorContractObj.vendorContractOtherDetails().click();
		waitHelper.waitForElementVisible(vendorContractObj.vendorContractAutoGenerateInvoice(), 2000, 100);
		vendorContractObj.vendorContractAutoGenerateInvoice().click();
		vendorContractObj.vendorContractAutoGenerateInvoice().sendKeys(Keys.ENTER);

		vendorContractObj.vendorContractCreditPeriod().click();
		vendorContractObj.vendorContractCreditPeriod().sendKeys(testData.get("CreditPeriod"));

		vendorContractObj.vendorContractLatePaymentAmount().click();
		vendorContractObj.vendorContractLatePaymentAmount().sendKeys(testData.get("PaymentAmmount"));
		waitHelper.waitForElementVisible(vendorContractObj.vendorContractSaveButton(), 2000, 100);
		vendorContractObj.vendorContractSaveButton().click();

	}

	@And("^add item details for the contract$")
	public void add_item_details_for_the_contract() throws Throwable {
		waitHelper.waitForElementVisible(vendorContractObj.vendorContractTempView(), 2000, 100);
		vendorContractObj.vendorContractTempView().click();
		waitHelper.waitForElementVisible(vendorContractObj.firstTempRecord(), 2000, 100);
		vendorContractObj.firstTempRecord().click();

		waitHelper.waitForElementVisible(vendorContractObj.vendorContractItemDetails(), 2000, 100);
		vendorContractObj.vendorContractItemDetails().click();

		waitHelper.waitForElementVisible(vendorContractObj.vendorContractAddButton(), 2000, 100);
		vendorContractObj.vendorContractAddButton().click();

		waitHelper.waitForElementVisible(vendorContractObj.vendorContractHSNCode(), 2000, 100);
		vendorContractObj.vendorContractHSNCode().click();
		vendorContractObj.vendorContractHSNCode().sendKeys(testData.get("HSNCode"));
		vendorContractObj.vendorContractHSNCode().sendKeys(Keys.ENTER);

		vendorContractObj.vendorContractExpenceCode().click();
		vendorContractObj.vendorContractExpenceCode().sendKeys(Keys.DOWN);
		vendorContractObj.vendorContractExpenceCode().sendKeys(Keys.ENTER);

		vendorContractObj.vendorContractCostCenter().click();
		vendorContractObj.vendorContractCostCenter().sendKeys(Keys.ENTER);

		vendorContractObj.vendorContractQuantity().click();
		vendorContractObj.vendorContractQuantity().sendKeys(testData.get("VendorContractQuantity"));

		vendorContractObj.vendorContractUnit().click();
		vendorContractObj.vendorContractUnit().sendKeys(Keys.ENTER);
		vendorContractObj.vendorContractRatePerUnit().click();
		vendorContractObj.vendorContractRatePerUnit().sendKeys(testData.get("RatePerUnit"));

		vendorContractObj.itemDetailsSaveButton().click();
	}

	@And("^add the payment term for the contract$")
	public void add_the_payment_term_for_the_contract() throws Throwable {
		while (true) {
			try {
				vendorContractObj.vendorContractPaymentTerm().click();
				waitHelper.waitForElementVisible(vendorContractObj.vendorContractAddButton(), 2000, 100);
				vendorContractObj.vendorContractAddButton().click();
				waitHelper.waitForElementVisible(vendorContractObj.paymentTermPaymentTerm(), 2000, 100);
				vendorContractObj.paymentTermPaymentTerm().click();
				vendorContractObj.paymentTermPaymentTerm().sendKeys(testData.get("PaymentTerm"));
				vendorContractObj.paymentTermPaymentTermPercentage().click();
				vendorContractObj.paymentTermPaymentTermPercentage().sendKeys(testData.get("PaymentTermPercentage"));
				vendorContractObj.paymentTermPaymentTermType().click();
				vendorContractObj.paymentTermPaymentTermType().sendKeys(Keys.ENTER);
				vendorContractObj.paymentTermPaymentTermSaveButton().click();
				break;
			} catch (StaleElementReferenceException e) {

			}
		}
	}

	@And("^add the benificiory details and select auto payout as yes$")
	public void add_the_benificiory_details_and_select_auto_payout_as_yes() throws Throwable {
		while (true) {
			try {
				waitHelper.waitForElementVisible(vendorContractObj.vendorContractBenificioryDetails(), 2000, 100);
				vendorContractObj.vendorContractBenificioryDetails().click();
				break;
			} catch (StaleElementReferenceException e) {

			}
		} // waitHelper.waitForElementVisible(vendorContractObj.vendorContractAddButton(),
			// 2000, 100);
			// vendorContractObj.vendorContractAddButton().click();
		waitHelper.waitForElementVisible(vendorContractObj.vendorContractBenificioryDetailsPaymentMode(), 2000, 100);
		vendorContractObj.vendorContractBenificioryDetailsPaymentMode().sendKeys(testData.get("PaymentMode"));
		vendorContractObj.vendorContractBenificioryDetailsPaymentMode().sendKeys(Keys.ENTER);

		vendorContractObj.vendorContractBenificioryDetailsAutoPayout().click();
		vendorContractObj.vendorContractBenificioryDetailsAutoPayout().sendKeys(Keys.DOWN);
		vendorContractObj.vendorContractBenificioryDetailsAutoPayout().sendKeys(Keys.ENTER);
		vendorContractObj.vendorContractBenificioryDetailsSaveButton().click();
	}

	@Then("^Click on Update Deposited Cheque Notification$")
	public void click_on_update_deposited_cheque_notification() {
		waitHelper.waitForElement(driver, 3000, accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_Notification());
		accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_Notification().click();

	}

	@And("^Select and Submit the Update Deposited Cheque record$")
	public void select_and_submit_the_update_deposited_cheque_record() throws InterruptedException, IOException, ParseException {

		// Reference
		waitHelper.waitForElement(driver, 2000, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReferenceId());
		String id = inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReferenceId().getText();
//		jsonWriter.addReferanceData(id);
		
		excelData.updateTestData(dataSetID, "ReferenceID", id);
		testData = excelData.getTestdata(dataSetID);
		
		System.out.println("Reference ID:" + id);
		for (int i = 1; i <= 35; i++) {
			try {
				waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]")));
				WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]"));
				referanceID.click();
				System.out.println(referanceID);
				// Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waitHelper.waitForElement(driver, 4000, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_NotificationNext_Button());

				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_NotificationNext_Button().click();
			}

		}
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReferenceId().click();

		// pencil
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

		waitHelper.waitForElement(driver, 2000, driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)));
		driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)).click();

		// Submit button
		waitHelper.waitForElement(driver, 2000, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitButton());
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitButton().click();

		// Remark
		javaScriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElement(driver, 3000, accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_RemarkField());
		javaScriptHelper.JSEClick(accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_RemarkField());
		accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_RemarkField().sendKeys("OK");
		// inventoryMaintenanceTestDataType.Remark

		// Remark Submit
		waitHelper.waitForElement(driver, 2000, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitByMaker());
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitByMaker().click();
		Thread.sleep(3000);

		// REVIEWER
		Thread.sleep(2000);
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
		
		excelData.updateTestData(dataSetID, "ReviewerID", reviewerId);
		testData = excelData.getTestdata(dataSetID);
//		jsonWriter = new JsonDataReaderWriter();
//		jsonWriter.addData(reviewerId);

	}

	@And("^validate the saved record$")
	public void validate_the_saved_record() throws Throwable {
		waitHelper = new WaitHelper(driver);
		reviewer = new Azentio_ReviewerObj(driver);
		waitHelper.waitForElementToVisibleWithFluentWait(driver, reviewer.alertMessage(), 10, 1);

		System.out.println(reviewer.alertMessage().getText());
		waitHelper.waitForElementToVisibleWithFluentWait(driver, reviewer.alertClose(), 10, 1);
		reviewer.alertClose().click();
	}

	@Then("^click on the Notification select the Cheque record and Approve$")
	public void click_on_the_notification_select_the_cheque_record_and_approve() throws InterruptedException, IOException, ParseException {
		// notification
		waitHelper = new WaitHelper(driver);
		reviewer = new Azentio_ReviewerObj(driver);
		waitHelper.waitForElement(driver, 2000, reviewer.reviewerNotidicationIcon());
		reviewer.reviewerNotidicationIcon().click();

		// select the record
		browserHelper = new BrowserHelper(driver);
		// budgetdata = jsonReader.getBudgetdataByName("Maker");
		javaScriptHelper = new JavascriptHelper();
		Thread.sleep(1000);
		/*
		 * for (int i = 1; i <= 35; i++) { try { waithelper.waitForElement(driver, 3000,
		 * driver.findElement(By.xpath("//span[contains(text(),'" +
		 * reader.readReferancedata() + "')]"))); WebElement referanceID = driver
		 * .findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata()
		 * + "')]")); referanceID.click(); Assert.assertTrue(referanceID.isDisplayed());
		 * break; } catch (NoSuchElementException e) { waithelper.waitForElement(driver,
		 * 4000, kubschecker.checker_notification_next_button());
		 * 
		 * kubschecker.checker_notification_next_button().click(); } }
		 */
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
		System.out.println(testData.get("ReferenceID"));
		waitHelper.waitForElement(driver, 5000, driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)));
		driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)).click();

		// Approve
		waitHelper.waitForElement(driver, 4000, reviewer.reviewerApproveButton());
		reviewer.reviewerApproveButton().click();
		waitHelper.waitForElement(driver, 2000, reviewer.reviewerAlertRemarkSecond());
		reviewer.reviewerAlertRemarkSecond().sendKeys("ok");
		waitHelper.waitForElement(driver, 2000, reviewer.reviewerAlertSubmitButton());
		reviewer.reviewerAlertSubmitButton().click();
		Thread.sleep(3000);

	}

	@And("^select the Cheque record and Approve by checker$")
	public void select_the_cheque_record_and_approve_by_checker() throws InterruptedException, IOException, ParseException {
		Thread.sleep(1000);
		for (int i = 1; i <= 35; i++) {
			try {
				waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]")));
				WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]"));
				referanceID.click();
				Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waitHelper.waitForElement(driver, 4000, kubschecker.checker_notification_next_button());
				kubschecker.checker_notification_next_button().click();
			} catch (StaleElementReferenceException e) {
				if (i == 35) {
					Assert.fail("Data not found");
				}
			}
		}
		while (true) {
			try {
				String before_xpath = "//span[contains(text(),'";
				String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

				waitHelper.waitForElement(driver, 2000, driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)));
				driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)).click();
				break;
			} catch (StaleElementReferenceException e) {

			}
		}

		// Approve
		waitHelper.waitForElement(driver, 2000, kubschecker.checkerApproveButton());
		kubschecker.checkerApproveButton().click();
		Thread.sleep(2000);
		waitHelper.waitForElement(driver, 2000, kubschecker.checkerRemarkSecond());
		kubschecker.checkerRemarkSecond().sendKeys("OK");
		Thread.sleep(2000);
		waitHelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();
		Thread.sleep(2000);
	}

	@And("^get the contract number$")
	public void get_the_contract_number() throws Throwable {
		waitHelper.waitForElementVisible(vendorContractObj.vendorContractApprovedContractNumber(), 2000, 100);
		String approvedContractNumber = vendorContractObj.vendorContractApprovedContractNumber().getText();
		autoPayout.put("approvedContractNumber", approvedContractNumber);
	}

	@And("^then checker claim the record$")
	public void then_checker_claim_the_record() throws InterruptedException, IOException, ParseException {

		// open pool
		waitHelper = new WaitHelper(driver);
		kubschecker = new Azentio_CheckerObj(driver);
		waitHelper.waitForElement(driver, 3000, kubschecker.checkerSecurityManagement());
		kubschecker.checkerSecurityManagement().click();

		// claim
		waitHelper.waitForElement(driver, 3000, kubschecker.checkerActionIcon());
		kubschecker.checkerActionIcon().click();
		Thread.sleep(2000);
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		waitHelper.waitForElement(driver, 5000, driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath_claim)));
		driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath_claim)).click();
		waitHelper.waitForElement(driver, 3000, kubschecker.checkerAlertClose());
		kubschecker.checkerAlertClose().click();

	}

	@Then("^click on the checker Notification$")
	public void click_on_the_checker_notification() throws InterruptedException {
//	    	Thread.sleep(1000);
//			waithelper.waitForElement(driver,3000,kubschecker.checkerNotificationIcon());
		waitHelper.waitForElementwithFluentwait(driver, kubschecker.checkerNotificationIcon());
		kubschecker.checkerNotificationIcon().click();
	}

	@And("^select the record and Approve by checker$")
	public void select_the_record_and_approve_by_checker() throws InterruptedException, IOException, ParseException {
		Thread.sleep(2000);
		for (int i = 1; i <= 35; i++) {
			try {
//			waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +reader.readReferancedata()+ "')]")));
				waitHelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]")));
				WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]"));
				referanceID.click();
				Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waitHelper.waitForElement(driver, 4000, kubschecker.checker_notification_next_button());
				kubschecker.checker_notification_next_button().click();
			}
		}
	}

	/////////////////////////////////////
	@And("^goto po creation module$")
	public void goto_po_creation_module() throws Throwable {
		waitHelper.waitForElementVisible(poCreationObj.accountsPayable_VendorPurchaseOrder_EyeButton(), 2000, 100);
		poCreationObj.accountsPayable_VendorPurchaseOrder_EyeButton().click();
	}

	@And("^fill the mendatory fields for po creation$")
	public void fill_the_mendatory_fields_for_po_creation() throws Throwable {
		waitHelper.waitForElementVisible(poCreationObj.accountsPayable_VendorPurchaseOrder_BPName(), 2000, 100);
		poCreationObj.accountsPayable_VendorPurchaseOrder_BPName().click();
		poCreationObj.accountsPayable_VendorPurchaseOrder_BPName().sendKeys(testData.get("BusinessPartnerName"));
		poCreationObj.accountsPayable_VendorPurchaseOrder_BPName().sendKeys(Keys.DOWN);
		poCreationObj.accountsPayable_VendorPurchaseOrder_BPName().sendKeys(Keys.ENTER);

		poCreationObj.accountsPayable_VendorPurchaseOrder_ReferenceType().click();
		poCreationObj.accountsPayable_VendorPurchaseOrder_ReferenceType().sendKeys(Keys.ENTER);

		poCreationObj.accountsPayable_VendorPurchaseOrder_Contract().click();
		poCreationObj.accountsPayable_VendorPurchaseOrder_Contract().sendKeys(testData.get("ContractName"));
		poCreationObj.accountsPayable_VendorPurchaseOrder_Contract().sendKeys(Keys.ENTER);

		/*
		 * poCreationObj.accountsPayable_VendorPurchaseOrder_POType().click()3
		 * poCreationObj.accountsPayable_VendorPurchaseOrder_POType().
		 * sendKeys("Purchace Contract3"); Thread.sleep(1000);
		 * poCreationObj.accountsPayable_VendorPurchaseOrder_POType().sendKeys(Keys.
		 * ENTER);
		 */
		// div[contains(text(),'Agency-8-41-28022022')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//ion-checkbox
		Thread.sleep(1000);
		waitHelper.waitForElementVisible(
				driver.findElement(
						By.xpath("//div[contains(text(),'" + autoPayout.get("approvedContractNumber") + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//ion-checkbox")),
				2000, 100);
		driver.findElement(By.xpath("//div[contains(text(),'" + autoPayout.get("approvedContractNumber") + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//ion-checkbox"))
				.click();
		driver.findElement(By.xpath("//div[contains(text(),'" + autoPayout.get("approvedContractNumber") + "')]/parent::datatable-body-cell/following-sibling::datatable-body-cell[5]//input")).click();
		driver.findElement(By.xpath("//div[contains(text(),'" + autoPayout.get("approvedContractNumber") + "')]/parent::datatable-body-cell/following-sibling::datatable-body-cell[5]//input"))
				.sendKeys("1");
		while (true) {
			try {
				// Thread.sleep(1000);
				waitHelper.waitForElementVisible(poCreationObj.vendorContractPoItemSave(), 2000, 100);
				poCreationObj.pocontractPoQuantity().click();
				poCreationObj.vendorContractPoItemSave().click();
				break;
			} catch (ElementClickInterceptedException e) {

			}
		}

		waitHelper.waitForElementVisible(poCreationObj.accountsPayable_VendorPurchaseOrder_POSubType(), 2000, 100);
		poCreationObj.accountsPayable_VendorPurchaseOrder_POSubType().click();
		// poCreationObj.accountsPayable_VendorPurchaseOrder_POSubType().sendKeys(Keys.DOWN);
		poCreationObj.accountsPayable_VendorPurchaseOrder_POSubType().sendKeys(Keys.ENTER);
		// waitHelper.waitForElementVisible(poCreationObj.accountsPayable_VendorPurchaseOrder_CostCenter(),
		// 2000, 100);
		while (true) {
			try {
				poCreationObj.accountsPayable_VendorPurchaseOrder_CostCenter().click();
				poCreationObj.accountsPayable_VendorPurchaseOrder_CostCenter().sendKeys(Keys.ENTER);
				break;
			} catch (NoSuchElementException e) {

			}
		}

		poCreationObj.accountsPayable_VendorPurchaseOrder_Save().click();
	}

	@And("^save the po creation record$")
	public void save_the_po_creation_record() throws Throwable {
		poCreationObj.poCreationTempView().click();
		waitHelper.waitForElementVisible(poCreationObj.tempViewFirstRecord(), 2000, 100);
		poCreationObj.tempViewFirstRecord().click();
	}

	@And("^save the item details for pocreation$")
	public void save_the_item_details_for_pocreation() throws Throwable {
		poCreationObj.accountsPayable_VendorPurchaseOrder_ItemDetails().click();
		waitHelper.waitForElementVisible(poCreationObj.accountsPayable_VendorPurchaseOrder_ItemDetailsRecord(), 2000, 100);
		poCreationObj.accountsPayable_VendorPurchaseOrder_ItemDetailsRecord().click();
		waitHelper.waitForElementVisible(poCreationObj.accountsPayable_VendorPurchaseOrder_ShippedFromLocation(), 2000, 100);
		poCreationObj.accountsPayable_VendorPurchaseOrder_ShippedFromLocation().click();
		poCreationObj.accountsPayable_VendorPurchaseOrder_ShippedFromLocation().sendKeys(Keys.ENTER);
		poCreationObj.accountsPayable_VendorPurchaseOrder_DeliveryLocation().click();
		poCreationObj.accountsPayable_VendorPurchaseOrder_DeliveryLocation().sendKeys(Keys.ENTER);
		while (true) {
			try {
				poCreationObj.accountsPayable_VendorPurchaseOrder_PoItemSave().click();
				break;
			} catch (NoSuchElementException e) {

			}
		}
		waitHelper.waitForElementVisible(poCreationObj.checkerAlertClose(), 2000, 100);
		poCreationObj.checkerAlertClose().click();
	}

	@And("^save the benificiery details for po creation$")
	public void save_the_benificiery_details_for_po_creation() throws Throwable {

	}

	@Then("^click on po creation module$")
	public void click_on_po_creation_module() throws Throwable {
		// grnObject.accountPayable_GoodsReceivedNoteGRNEyeButton().click();
		ArAp_poCreationObj.poCreationViewButton().click();

	}

	@Then("^go to GRN module$")
	public void go_to_grn_module() throws Throwable {
		waitHelper.waitForElementVisible(grnObject.accountPayable_GoodsReceivedNoteGRNEyeButton(), 1000, 100);
		grnObject.accountPayable_GoodsReceivedNoteGRNEyeButton().click();

	}

	@And("^search for approved po record$")
	public void search_for_approved_po_record() throws Throwable {
		javaScriptHelper.JavaScriptHelper(driver);
		ArAp_poCreationObj.poCreationSearchIcon().click();
		Thread.sleep(1000);
		// waitHelper.waitForElementVisible(poCreationObj.poStatus(), 1000, 100);
		javaScriptHelper.scrollIntoView(ArAp_poCreationObj.poStatus());
		ArAp_poCreationObj.poStatus().sendKeys(testData.get("ApprovedPo"));
		poNumber = ArAp_poCreationObj.poPoNumber().getText();
		poBusinessPartner = ArAp_poCreationObj.poBusinessPartner().getText();
		System.out.println(poNumber + " " + poBusinessPartner + " ");
		settlementTestData.put("poNumber", poNumber);
		settlementTestData.put("poBusinessPartner", poBusinessPartner);
		System.out.println("Po Number" + settlementTestData.get("poNumber"));
		System.out.println("Po Number" + settlementTestData.get("poBusinessPartner"));
	}

	@And("^check GRN can be created for that perticular po$")
	public void check_grn_can_be_created_for_that_perticular_po() throws Throwable {
		waitHelper.waitForElementVisible(grnObject.accountPayable_GrnBpName(), 1000, 100);
		System.out.println("Business Partner is" + poBusinessPartner);
		grnObject.accountPayable_GrnBpName().click();
		grnObject.accountPayable_GrnBpName().sendKeys(poBusinessPartner);
		// grnObject.accountPayable_GRN_BPBranch().click();
		grnObject.accountPayable_GrnBpName().sendKeys(Keys.ENTER);
		waitHelper.waitForElementVisible(grnObject.accountPayable_GRN_BPBranch(), 2000, 100);
		grnObject.accountPayable_GRN_BPBranch().click();
		grnObject.accountPayable_GRN_BPBranch().sendKeys(Keys.ENTER);
		grnObject.accountPayable_GrnInvoiceNumber().sendKeys(testData.get("InvoiceNo"));
		grnObject.accountPayable_GrnDeliveryLocation().click();
		// grnObject.accountPayable_GrnDeliveryLocation().sendKeys(Keys.DOWN);
		grnObject.accountPayable_GrnDeliveryLocation().sendKeys(Keys.ENTER);
		// waitHelper.waitForElementVisible(grnObject.accountPayable_GrnSaveButton(),
		// 1000, 100);
		Thread.sleep(2000);
		// grnObject.accountPayable_GrnSaveButton().click();
		clicksAndActionHelper.doubleClick(grnObject.accountPayable_GrnSaveButton());
		grnObject.grnTempView().click();
		waitHelper.waitForElementVisible(grnObject.grnTempViewFirstRecord(), 1000, 100);
		grnObject.grnTempViewFirstRecord().click();

	}

	@Then("^go to Item details and enter po number$")
	public void go_to_item_details_and_enter_po_number() throws Throwable {
		Thread.sleep(1000);
		waitHelper.waitForElement(driver, 2000, grnObject.inventoryManagament_GRNItemDetails());
		grnObject.inventoryManagament_GRNItemDetails().click();
		waitHelper.waitForElementVisible(grnObject.accountPayable_GrnPONumber(), 1000, 100);
		grnObject.accountPayable_GrnPONumber().click();
		grnObject.accountPayable_GrnPONumber().sendKeys(poNumber);
		boolean result = grnObject.poNoSuctDataFromDropdown().isDisplayed();
		Assert.assertTrue(result);
	}

	@Then("^go to Item details and enter po number for approval$")
	public void go_to_item_details_and_enter_po_number_for_approval() throws Throwable {
		waitHelper.waitForElement(driver, 2000, grnObject.inventoryManagament_GRNItemDetails());
		grnObject.inventoryManagament_GRNItemDetails().click();
		waitHelper.waitForElementVisible(grnObject.accountPayable_GrnPONumber(), 1000, 100);
		grnObject.accountPayable_GrnPONumber().click();
		grnObject.accountPayable_GrnPONumber().sendKeys(poNumber);
		grnObject.accountPayable_GrnPONumber().sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		for (int row = 1; row < 5; row++) {
			// datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[7]/div[1]/input[1]

			for (int col = 7; col <= 8; col++) {
				try {
					// waitHelper.waitForElementVisible(driver.findElement(By.xpath("//datatable-row-wrapper["+row+"]/datatable-body-row[1]/div[2]/datatable-body-cell["+col+"]/div[1]/input[1]")),
					// 5000, 100);
					boolean status = driver.findElement(By.xpath("//datatable-row-wrapper[" + row + "]/datatable-body-row[1]/div[2]/datatable-body-cell[" + col + "]/div[1]/input[1]")).isDisplayed();
					driver.findElement(By.xpath("//datatable-row-wrapper[" + row + "]/datatable-body-row[1]/div[2]/datatable-body-cell[" + col + "]/div[1]/input[1]")).click();
					driver.findElement(By.xpath("//datatable-row-wrapper[" + row + "]/datatable-body-row[1]/div[2]/datatable-body-cell[" + col + "]/div[1]/input[1]"))
							.sendKeys(testData.get("ItemQuantity"));
					if (status == false) {
						break;
					}
				} catch (NoSuchElementException e) {
					e.getMessage();
					break;
				}

			}
		}
		// javascriptHelper.JavaScriptHelper(driver);
		// Thread.sleep(1000);
		// grnObject.ItemDetailsSaveButton().click();
		// clickAndActions.doubleClick(grnObject.ItemDetailsSaveButton());
		clicksAndActionHelper.clickOnElement(grnObject.ItemDetailsSaveButton());
		// Thread.sleep(2000);
	}

	@And("^get the approved po number from approved record$")
	public void get_the_approved_po_number_from_approved_record() throws Throwable {
		waitHelper.waitForElementVisible(poCreationObj.poCreationApprovedPoNumber(), 2000, 100);
		String poNumber = poCreationObj.poCreationApprovedPoNumber().getText();
		autoPayout.put("poNumber", poNumber);
	}

	@And("^fill The invoice againse po record$")
	public void fill_the_invoice_againse_po_record() throws Throwable {
		waitHelper.waitForElementVisible(invoiceBookingObj.accountPayable_InvoiceBooking_APInvoiceAgainstExpense(), 2000, 100);
		invoiceBookingObj.accountPayable_InvoiceBooking_APInvoiceAgainstExpense().click();
		while (true) {
			try {
				invoiceBookingObj.accountPayable_InvoiceBooking_PONumber().click();
				invoiceBookingObj.accountPayable_InvoiceBooking_PONumber().sendKeys(autoPayout.get("poNumber"));
				invoiceBookingObj.accountPayable_InvoiceBooking_PONumber().sendKeys(Keys.ENTER);
				{
					waitHelper.waitForElementVisible(invoiceBookingObj.accountPayable_InvoiceBooking_GRN_Number(), 2000, 100);
					invoiceBookingObj.accountPayable_InvoiceBooking_GRN_Number().click();
					waitHelper.waitForElementVisible(invoiceBookingObj.invoiceBookingSelectGRNRecord(), 2000, 100);
					invoiceBookingObj.invoiceBookingSelectGRNRecord().click();
					waitHelper.waitForElementVisible(invoiceBookingObj.invoiceBooingOkButton(), 2000, 100);
					invoiceBookingObj.invoiceBooingOkButton().click();
					break;
				}
			} catch (StaleElementReferenceException e) {

			}
		}
		invoiceBookingObj.accountPayable_InvoiceBooking_SaveExpense().click();
		waitHelper.waitForElementVisible(poCreationObj.checkerAlertClose(), 2000, 100);
		poCreationObj.checkerAlertClose().click();
	}

	@And("^get the approved invoice from table$")
	public void get_the_approved_invoice_from_table() throws Throwable {
		waitHelper.waitForElementVisible(invoiceBookingObj.billBookingApprovedInvoiceNumber(), 2000, 100);
		String approvedInvoiceNumber = invoiceBookingObj.billBookingApprovedInvoiceNumber().getText();
		autoPayout.put("approvedInvoiceNumber", approvedInvoiceNumber);
	}

	@And("^go to invoice bill booking module$")
	public void go_to_invoice_bill_booking_module() throws Throwable {
		waitHelper.waitForElementVisible(invoiceBookingObj.accountPayable_InvoiceBooking_EyeButton(), 2000, 100);
		invoiceBookingObj.accountPayable_InvoiceBooking_EyeButton().click();
	}

	@And("^fill the invoice booking record$")
	public void fill_the_invoice_booking_record() throws Throwable {
		Random ran = new Random();
		int random = ran.nextInt(1000 - 500) + 500;
		waitHelper.waitForElementVisible(invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType(), 2000, 100);
		invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType().click();
		invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType().sendKeys(Keys.DOWN);
		invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceType().sendKeys(Keys.ENTER);

		/*
		 * invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType().click();
		 * invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType().sendKeys(
		 * Keys.DOWN);
		 * invoiceBookingObj.accountPayable_InvoiceBooking_InvoiceSubType().sendKeys(
		 * Keys.ENTER);
		 */
		invoiceBookingObj.billBookingPoBpName().click();
		invoiceBookingObj.billBookingPoBpName().sendKeys(testData.get("BusinessPartnerName"));
		invoiceBookingObj.billBookingPoBpName().sendKeys(Keys.ENTER);

		invoiceBookingObj.invoiceBollSuplierNAme().click();
		invoiceBookingObj.invoiceBollSuplierNAme().sendKeys(testData.get("SuplierReferenceNumber") + random);

		invoiceBookingObj.billBookingPoFlatDiscount().click();
		invoiceBookingObj.billBookingPoFlatDiscount().sendKeys(testData.get("FlatDiscount"));
		/*
		 * invoiceBookingObj.billBookingExpenceDiscountType().click();
		 * invoiceBookingObj.billBookingExpenceDiscountType().sendKeys(Keys.ENTER);
		 * 
		 * invoiceBookingObj.billBookingExpenceDiscountPercent().click();
		 * invoiceBookingObj.billBookingExpenceDiscountPercent().sendKeys("2");
		 * 
		 */
		invoiceBookingObj.billBookingPoPaymentMode().click();
		invoiceBookingObj.billBookingPoPaymentMode().sendKeys(testData.get("PaymentMode"));
		invoiceBookingObj.billBookingPoPaymentMode().sendKeys(Keys.ENTER);

		invoiceBookingObj.accountPayable_InvoiceBooking_SaveButton().click();
	}

	@And("^goto invoice bill booking temp view and select the record$")
	public void goto_invoice_bill_booking_temp_view_and_select_the_record() throws Throwable {
		waitHelper.waitForElementVisible(invoiceBookingObj.accountPayableIvoiceBookingTempView(), 2000, 100);
		invoiceBookingObj.accountPayableIvoiceBookingTempView().click();
		Thread.sleep(2000);
		waitHelper.waitForElementVisible(invoiceBookingObj.accountPayableIvoiceBookingRecord(), 2000, 100);
		invoiceBookingObj.accountPayableIvoiceBookingRecord().click();
	}

	@And("^goto invoice booking module$")
	public void goto_invoice_booking_module() throws Throwable {
		waitHelper.waitForElementVisible(invoiceBookingObj.accountPayable_InvoiceBooking_EyeButton(), 3000, 100);
		invoiceBookingObj.accountPayable_InvoiceBooking_EyeButton().click();

	}

	@And("^fill the mendatory field for settle the payment$")
	public void fill_the_mendatory_field_for_settle_the_payment() throws Throwable {
		javaScriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementPaymentOption(), 2000, 100);
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().click();
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().sendKeys(testData.get("PaymentOption"));
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().sendKeys(Keys.ENTER);
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().click();
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().sendKeys(testData.get("BusinessPartnerName"));
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		// div[contains(text(),'ADV_36_2422022')]
		for (int i = 1; i <= 20; i++) {
			Thread.sleep(1000);
			if (i == 20) {
				System.out.println("Data not available");
				System.out.println("Approved record we search " + autoPayout.get("approvedInvoiceNumber"));
				Assert.fail("Data not available");
			}
			try {

				waitHelper.waitForElementVisible(driver.findElement(By.xpath("//div[contains(text(),'" + autoPayout.get("approvedInvoiceNumber") + "')]")), 2000, 100);
				javaScriptHelper.scrollToElemet(driver.findElement(By.xpath("//div[contains(text(),'" + autoPayout.get("approvedInvoiceNumber") + "')]")));
				boolean finalStatus = driver.findElement(By.xpath("//div[contains(text(),'" + autoPayout.get("approvedInvoiceNumber") + "')]")).isDisplayed();
				Assert.assertTrue(finalStatus);
				waitHelper.waitForElementVisible(
						driver.findElement(By.xpath(
								"//div[contains(text(),'" + autoPayout.get("approvedInvoiceNumber") + "')]//ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[3]//ion-checkbox")),
						5000, 100);
				driver.findElement(
						By.xpath("//div[contains(text(),'" + autoPayout.get("approvedInvoiceNumber") + "')]//ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[3]//ion-checkbox"))
						.click();
				break;
			} catch (NoSuchElementException e) {
				javaScriptHelper.scrollIntoView(paymentSettlementObj.accountsPayablePayementSettlementNextRecord());
				paymentSettlementObj.accountsPayablePayementSettlementNextRecord().click();
			}
		}
	}

	@And("^fill the calender details and description$")
	public void fill_the_calender_details_and_save_the_record() throws Throwable {
		javaScriptHelper.JavaScriptHelper(driver);
		// javascriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoView(paymentSettlementObj.accountsPayablePayementSettlementValueDate());
		paymentSettlementObj.accountsPayablePayementSettlementValueDate().click();
		while (true) {
			try {

				waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("MonthYear") + "')]")));
				driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("MonthYear") + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				inventoryEnquiryGlObj.inventoryNextMonth().click();
			}
		}
		WebElement FinalDay = driver
				.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth") + " " + testData.get("Date") + ", " + testData.get("Year") + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
		clicksAndActionHelper.doubleClick(paymentSettlementObj.accountsPayableDescription());
		paymentSettlementObj.accountsPayableDescription().sendKeys(testData.get("Remark"));

	}

	/******************** AUTO PAYOUT ****************************/

	@And("^go to auto payout module$")
	public void go_to_auto_payout_module() throws Throwable {
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoViewAndClick(accoutsPayableAutoPayoutObj.accounPayablePayoutTempView());
		accoutsPayableAutoPayoutObj.accounPayablePayoutTempView().click();

	}

	@And("^select the record from temp view$")
	public void select_the_record_from_temp_view() throws Throwable {
		waitHelper.waitForElementVisible(accoutsPayableAutoPayoutObj.accoutspYablePaymenTempViewFirstRecord(), 2000, 100);
		accoutsPayableAutoPayoutObj.accoutspYablePaymenTempViewFirstRecord().click();

	}

	@And("^fill the valued date$")
	public void fill_the_valued_date() throws Throwable {
		waitHelper.waitForElementVisible(accoutsPayableAutoPayoutObj.accounPayablePayoutPayoutDate(), 2000, 100);
		accoutsPayableAutoPayoutObj.accounPayablePayoutPayoutDate().click();
		while (true) {
			try {

				waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("MonthYear") + "')]")));
				driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("MonthYear") + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				try {
					inventoryEnquiryGlObj.inventoryNextMonth().click();
				} catch (ElementClickInterceptedException e) {

				}
			}
		}
		WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth") + " " + testData.get("Date") + ", " + testData.get("Year") + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);

	}

	@Then("^save the auto payout record$")
	public void save_the_auto_payout_record() throws Throwable {
		String invoiceNumber = autoPayout.get("approvedInvoiceNumber");
		javaScriptHelper.scrollIntoView(driver.findElement(By.xpath("//span[contains(text(),'" + invoiceNumber + "')]")));
		// waitHelper.waitForElementVisible(driver.findElement(By.xpath("//span[contains(text(),'"+autoPayout.get("approvedInvoiceNumber")+"')]")),
		// 2000, 100);
		boolean result = driver.findElement(By.xpath("//span[contains(text(),'" + invoiceNumber + "')]")).isDisplayed();
		Assert.assertTrue(result);
		// driver.findElement(By.xpath("//span[contains(text(),'"+autoPayout.get("approvedInvoiceNumber")+"')]"));
		waitHelper.waitForElementVisible(accoutsPayableAutoPayoutObj.accoutspYablePaymentSaveButton(), 2000, 100);
		accoutsPayableAutoPayoutObj.accoutspYablePaymentSaveButton().click();
		Thread.sleep(1000);

	}

	@And("^fill the mendatory fields for auto payout record$")
	public void fill_the_mendatory_fields_for_auto_payout_record() throws Throwable {
		javaScriptHelper.JavaScriptHelper(driver);
		accoutsPayableAutoPayoutObj.accoutspYablePaymentBank().click();
		accoutsPayableAutoPayoutObj.accoutspYablePaymentBank().sendKeys(Keys.DOWN);
		accoutsPayableAutoPayoutObj.accoutspYablePaymentBank().sendKeys(Keys.ENTER);
		accoutsPayableAutoPayoutObj.accoutspYablePaymentBankAccount().click();
		accoutsPayableAutoPayoutObj.accoutspYablePaymentBankAccount().sendKeys(Keys.DOWN);
		accoutsPayableAutoPayoutObj.accoutspYablePaymentBankAccount().sendKeys(Keys.ENTER);
		javaScriptHelper.scrollIntoViewAndClick(accoutsPayableAutoPayoutObj.accoutspYablePaymentRemarks());
		accoutsPayableAutoPayoutObj.accoutspYablePaymentRemarks().click();
		accoutsPayableAutoPayoutObj.accoutspYablePaymentRemarks().sendKeys(testData.get("Remark"));
	}

	@And("^select the record from temp view and initiate$")
	public void select_the_record_from_temp_view_and_initiate() throws Throwable {
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoViewAndClick(accoutsPayableAutoPayoutObj.accounPayablePayoutTempView());
		accoutsPayableAutoPayoutObj.accounPayablePayoutTempView().click();
		waitHelper.waitForElementVisible(accoutsPayableAutoPayoutObj.accoutspYablePaymenTempViewFirstRecord(), 2000, 100);
		accoutsPayableAutoPayoutObj.accoutspYablePaymenTempViewFirstRecord().click();

		waitHelper.waitForElementVisible(accoutsPayableAutoPayoutObj.accoutspYablePaymentInitiateButtonButton(), 2000, 100);
		accoutsPayableAutoPayoutObj.accoutspYablePaymentInitiateButtonButton().click();
		waitHelper.waitForElementVisible(poCreationObj.checkerAlertClose(), 2000, 100);
		poCreationObj.checkerAlertClose().click();
	}
	
	////////////////////////004_008_TC_02/////////////////////////
	
	@And("^get the approved record from list view$")
	public void get_the_approved_record_from_list_view() throws Throwable {
		waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayableApprovedSettlementRefNo(), 2000, 100);
		String approvedReferenceNumber = paymentSettlementObj.accountsPayableApprovedSettlementRefNo().getText();
		settlementData.put("approvedReferenceNumber", approvedReferenceNumber);
		System.out.println("Settlement Reference Number" + settlementData.get("approvedReferenceNumber"));
	}
	
	@And("^choose branch code for auto payout accounting entries$")
	public void choose_branch_code_for_auto_payout_accounting_entries() throws Throwable {
		inventoryEnquiryGlObj.inventoryBranchCode().sendKeys(testData.get("BranchCode"));
		inventoryEnquiryGlObj.inventoryBranchCode().sendKeys(Keys.ENTER);
	}
	
	@Then("^choose the from date for auto payout accounting entries$")
	public void choose_the_from_date_for_auto_payout_accounting_entries() throws Throwable {

		javaScriptHelper.JavaScriptHelper(driver);
		for(int i=0;i<20;i++) {
			try {
//				waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("Gl Month") + " " + testData.get("Gl Year") + "')]")));
				waitHelper.waitForElementToVisibleWithFluentWait(driver, driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("GL Month") + " " + testData.get("GL Year") + "')]")), 10, 2);
				WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("GL Month") + " " + testData.get("GL Year") + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				inventoryEnquiryGlObj.inventoryNextMonth().click();
			}
		}
		WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("GL FullMonth") + " " + testData.get("GL Date") + ", " + testData.get("GL Year") + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
	}
	
	@Then("^choose the to date for auto payout accounting entries$")
	public void choose_the_to_date_for_auto_payout_accounting_entries() throws Throwable {
		for(int i=0;i<20;i++) {
			try {

//				waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("GL To Month") + " " + testData.get("GL To Year") + "')]")));
				waitHelper.waitForElementToVisibleWithFluentWait(driver, driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("GL To Month") + " " + testData.get("GL To Year") + "')]")), 0, 0);
				WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("GL To Month") + " " + testData.get("GL To Year") + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				inventoryEnquiryGlObj.inventoryNextMonth().click();
			}
		}
		WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("GL To FullMonth") + " " + testData.get("GL To Date") + ", " + testData.get("GL To Year") + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
	}
	
	@Then("^verify approved settlement reference number is available in the Gl report$")
	public void verify_approved_settlement_reference_number_is_available_in_the_gl_report() throws Throwable {
		javaScriptHelper.JavaScriptHelper(driver);
		Thread.sleep(1000);
//				driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'"
//						+ settlementData.get("approvedReferenceNumber") + "')])[1]")).isDisplayed();

//				driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'"
//						+ settlementData.get("approvedReferenceNumber") + "')])[1]"));
//				String TransactionType = driver
//						.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),' "
//								+ settlementData.get("approvedReferenceNumber")
//								+ " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[5]//span)[1]"))
//						.getText();
//				System.out.println("TransactionType is " + TransactionType);
//				String amount = driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),' "
//						+ settlementData.get("approvedReferenceNumber")
//						+ " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[6]//span)[1]"))
//						.getText();
		// System.out.println("Amount is " + amount);
	}

	@Then("^select data set ID for verify settlement for the bill is auto approved$")
	public void select_data_set_id_for_verify_settlement_for_the_bill_is_auto_approved() throws Throwable {
		dataSetID = "KUBS_AR_AP_UAT_004_008_TC_01_D1";
		testData = excelData.getTestdata(dataSetID);
	}

	@Then("^select data set ID for Verify accounting entries post payment settlement$")
	public void select_data_set_id_for_verify_accounting_entries_post_payment_settlement() throws Throwable {
		dataSetID = "KUBS_AR_AP_UAT_004_008_TC_02_D1";
		testData = excelData.getTestdata(dataSetID);
	}

}