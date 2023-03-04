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
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
import pageobjects.ACCOUNTSPAYBLE_AccountsPayable_POCreationObj;
import pageobjects.ACCOUNTSRECEIVABLE_ReceiptObj;
import pageobjects.ACCOUTSRECEIVABLE_ChequeDepositeObj;
import pageobjects.ARAP_ARandAPObj;
import pageobjects.ARAP_GRNCreationPageObject;
import pageobjects.ARAP_PoCreationObj;
import pageobjects.AccountReceivable_UpdateDepositedChequeObj;
import pageobjects.Account_Receivable;
import pageobjects.AccountsReceivable_ReceiptsReversalsObj;
import pageobjects.AccountsReceivable_UpdateChequeStatusObj;
import pageobjects.ArAp_BalanceSheetReportObj;
import pageobjects.ArAp_Cancellation_of_vendorObj;
import pageobjects.Ar_Ap_AdjustmentObj;
import pageobjects.Ar_Po_creationObj;
import pageobjects.Azentio_CheckerObj;
import pageobjects.Azentio_ReviewerObj;
import pageobjects.BUSINESS_PARTNER_SETUP_BusinessPartnerObj;
import pageobjects.ENQUIRY_FinancialTransactionObj;
import pageobjects.Enquiry_Obj;
import pageobjects.FinancialReporting_GLBalancesReportObj;
import pageobjects.FixedAsset_AssetCreationObj;
import pageobjects.INVENTORY_EnquiryGlObject;
import pageobjects.InventoryMaintenanceObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_MakerObj;
import pageobjects.KUBS_ReviewerObj;
import pageobjects.Payment_SettlementObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;

public class ARAP_ClearingReceiptViaChequeMode extends BaseClass {
	WebDriver driver = BaseClass.driver;
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	Selenium_Actions seleniumactions = new Selenium_Actions(driver);
	ConfigFileReader configreader = new ConfigFileReader();
	Map<String,String> receiptTestData=new HashMap<>();
	JavascriptHelper javaScriptHelper = new JavascriptHelper();
	BrowserHelper browserHelper = new BrowserHelper(driver);
	KUBS_ReviewerObj reviewerObj = new KUBS_ReviewerObj(driver);
	KUBS_CheckerObj checkerObj = new KUBS_CheckerObj(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	KUBS_Login login;
	Map<String, String> autoPayout = new HashMap<>();
	Azentio_ReviewerObj reviewer;
	ARAP_ARandAPObj arapObj = new ARAP_ARandAPObj(driver);
	KUBS_MakerObj makerObj = new KUBS_MakerObj(driver);
	ArAp_BalanceSheetReportObj arAp_BalanceSheetReportObj = new ArAp_BalanceSheetReportObj(driver);
	InventoryMaintenanceObj inventoryMaintenanceObj = new InventoryMaintenanceObj(driver);
	AccountsReceivable_ReceiptsReversalsObj accountsReceivable_ReceiptsReversalsObj = new AccountsReceivable_ReceiptsReversalsObj(driver);
	AccountsReceivable_UpdateChequeStatusObj accountsReceivable_UpdateChequeStatusObj = new AccountsReceivable_UpdateChequeStatusObj(driver);
	ENQUIRY_FinancialTransactionObj eNQUIRY_FinancialTransactionObj = new ENQUIRY_FinancialTransactionObj(driver);
	FinancialReporting_GLBalancesReportObj financialReporting_GLBalancesReportObj = new FinancialReporting_GLBalancesReportObj(driver);
	ACCOUTSRECEIVABLE_ChequeDepositeObj chequeDepositeObj=new ACCOUTSRECEIVABLE_ChequeDepositeObj(driver);
	ACCOUNTSRECEIVABLE_ReceiptObj receiptObj = new ACCOUNTSRECEIVABLE_ReceiptObj(driver);
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(driver);
	AccountReceivable_UpdateDepositedChequeObj accountReceivable_UpdateDepositedChequeObj = new AccountReceivable_UpdateDepositedChequeObj(
			driver);
	Azentio_CheckerObj kubschecker = new Azentio_CheckerObj(driver);

	ExcelData excelData = new ExcelData("C:\\Users\\ININDC00091\\git\\AzentioAutomationFramework\\DeveshFW_Excel\\ARAP_AzentioAutomationFramework_Excel\\Test-data\\KUBS_TESTDATA_V1.xlsx",
			"ClearingReceiptViaChequeData", "Data Set ID");
	Map<String, String> testData = new HashMap<>();
	String dataSetID;

	//////////////////////// KUBS_AR_AP_UAT_010_002_TC_02//////////////////////////
	@And("^goto accouts Receivable module$")
	public void goto_accouts_receivable_module() throws Throwable {
		Thread.sleep(1500);
		makerObj.kubsDirectionIcon().click();
		waitHelper.waitForElementVisible(makerObj.kubsAccountsReceivable(), 2000, 100);
		makerObj.kubsAccountsReceivable().click();

	}

	@And("^goto accouts receipt module$")
	public void goto_accouts_receipt_module() throws Throwable {
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoView(receiptObj.accoutsReceivableReceiptViewButton());
//		waitHelper.waitForElementVisible(receiptObj.accoutsReceivableReceiptViewButton(), 2000, 100);
		waitHelper.waitForElementToVisibleWithFluentWait(driver, receiptObj.accoutsReceivableReceiptViewButton(), 20,2);
		receiptObj.accoutsReceivableReceiptViewButton().click();
	}

	@And("^fill the all receipt mendatory details$")
	public void fill_the_all_receipt_mendatory_details() throws Throwable {
		waitHelper.waitForElementVisible(receiptObj.accoutsReceivableReceiptReceiptType(), 2000, 100);
		receiptObj.accoutsReceivableReceiptReceiptType().click();
		receiptObj.accoutsReceivableReceiptReceiptType().sendKeys(Keys.ENTER);
		
		receiptObj.accoutsReceivableReceiptReceiptReferenceNumber().click();			   
		receiptObj.accoutsReceivableReceiptReceiptReferenceNumber().sendKeys(testData.get("ReceiptReferenceNumber"));

		receiptObj.accoutsReceivableReceiptReceiptAmount().click();
		receiptObj.accoutsReceivableReceiptReceiptAmount().sendKeys(testData.get("ReceiptAmount"));

		receiptObj.accoutsReceivableReceiptBankAccount().click();
		receiptObj.accoutsReceivableReceiptBankAccount().sendKeys(testData.get("BankAccountNumber"));
		Thread.sleep(2000);
		receiptObj.accoutsReceivableReceiptBankAccount().sendKeys(Keys.ENTER);

		receiptObj.accoutsReceivableReceiptPayerName().click();
		receiptObj.accoutsReceivableReceiptPayerName().sendKeys(testData.get("ReceiptPayer"));

		receiptObj.accoutsReceivableReceiptRemark().click();
		receiptObj.accoutsReceivableReceiptRemark().sendKeys(testData.get("Remark"));

	}

	@And("^save the receipt record$")
	public void save_the_receipt_record() throws Throwable {
		for (int i = 0; i < 100; i++) {
			try {

				String bankAccountNumber = receiptObj.accoutsReceivableGetBankAccoutNumber().getText();
				receiptTestData.put("bankAccountNumber", bankAccountNumber);
				
				excelData.updateTestData(dataSetID, "BankAccountNumber", bankAccountNumber);
				testData = excelData.getTestdata(dataSetID);
				
				break;
			} catch (Exception e) {
			}
		}
		System.out.println("Bank account number is " + receiptTestData.get("bankAccountNumber"));
		receiptObj.accoutsReceivableReceiptSaveButton().click();
		Thread.sleep(1500);
		for (int i = 0; i < 30; i++) {
			try {
				clicksAndActionHelper.moveToElement(receiptObj.WorkflowInitiated());
				receiptObj.WorkflowInitiated().click();
				break;
			} catch (Exception e) {
			}
		}
		for (int i = 0; i < 30; i++) {
			try {

				receiptObj.AlertClose().click();
				break;
			} catch (Exception e) {
			}
		}
	}
	
	@And("^Select and Submit the Update Deposit Cheque record$")
	public void select_and_submit_the_update_deposit_cheque_record() throws InterruptedException, IOException, ParseException {

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
//		Thread.sleep(3000);

		// REVIEWER
//		Thread.sleep(2000);
		waitHelper.waitForElementwithFluentwait(driver, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RecordStatus());
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
	
	@Then("^click on the Notification and select the receipt record and Approve$")
	public void click_on_the_notification_and_select_the_receipt_record_and_approve() throws InterruptedException, IOException, ParseException {
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
//		Thread.sleep(3000);

	}
	
	@And("^select the receipt record and Approve by checker$")
	public void select_the_receipt_record_and_approve_by_checker() throws InterruptedException, IOException, ParseException {
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
	
	@And("^Claim the Record in Checker for cheque mode receipt record$")
	public void claim_the_record_in_checker_for_cheque_mode_receipt_record() throws Throwable {
		// -------------------------CLICK CLAIM OPTION-------------------------//
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
//		waitHelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath_claim)));
		waitHelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath_claim)));
		driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath_claim)).click();
		waitHelper.waitForElement(driver, 2000, checkerObj.checker_alert_close());
		checkerObj.checker_alert_close().click();
	}


	//////////////////////// KUBS_AR_AP_UAT_010_002_TC_03/////////////////////////
	@And("^goto cheque deposite module$")
	public void goto_cheque_deposite_module() throws Throwable {
		// waitHelper.waitForElementVisible(chequeDepositeObj.AccountsReceivableChecqueDeposite(),
		// 2000, 100);
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoView(chequeDepositeObj.AccountsReceivableChecqueDeposite());
		chequeDepositeObj.AccountsReceivableChecqueDeposite().click();

	}

	@And("^enter the bank account number$")
	public void enter_the_bank_account_number() throws Throwable {
		waitHelper.waitForElementVisible(chequeDepositeObj.AccountsReceivableBankAccount(), 2000, 100);
		chequeDepositeObj.AccountsReceivableBankAccount().click();
		chequeDepositeObj.AccountsReceivableBankAccount().sendKeys(testData.get("BankAccountNumber"));
		chequeDepositeObj.AccountsReceivableBankAccount().sendKeys(Keys.ENTER);

	}

	@And("^give date of bill deposited date$")
	public void give_date_of_bill_deposited_date() throws Throwable {
		waitHelper.waitForElementVisible(chequeDepositeObj.accountsPayableDepositeDate(), 2000, 100);
		chequeDepositeObj.accountsPayableDepositeDate().click();
		while (true) {
			try {
				waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("monthYear") + "')]")));
				WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("monthYear") + "')]"));
				break;
			} catch (NoSuchElementException e) {
				chequeDepositeObj.accountsPayableDepositeNextMonth().click();
			}

		}

		waitHelper.waitForElementVisible(driver.findElement(By.xpath("//td[@aria-label='" + testData.get("Month") + " " + testData.get("Date") + ", " + testData.get("Year") + "']/span")), 2000, 100);
		WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("Month") + " " + testData.get("Date") + ", " + testData.get("Year") + "']/span"));

		clicksAndActionHelper.doubleClick(FinalDay);

	}

	@And("^click on deposite bill generation$")
	public void click_on_deposite_bill_generation() throws Throwable {

		chequeDepositeObj.AccountsReceivableGenerateDepositeBill().click();
	}

	@And("^select our bill$")
	public void select_our_bill() throws Throwable {
		Thread.sleep(1000);
		javaScriptHelper.JavaScriptHelper(driver);
		while (true) {
			try {
				driver.findElement(By.xpath("//div[text()=' " + testData.get("ReceiptReferenceNumber") + " ']/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[2]//ion-checkbox"))
						.click();

				String status = driver
						.findElement(By.xpath("//div[text()=' " + testData.get("ReceiptReferenceNumber") + " ']/ancestor::datatable-body-cell/following-sibling::datatable-body-cell[8]/div"))
						.getText();
				Assert.assertEquals(status, "Deposit");

				break;
			} catch (NoSuchElementException e) {
				javaScriptHelper.scrollIntoView(chequeDepositeObj.accountsPayableDepositeNextPage());
				javaScriptHelper.JSEClick(chequeDepositeObj.accountsPayableDepositeNextPage());
				// chequeDepositeObj.accountsPayableDepositeNextPage().click();
			}
		}
		waitHelper.waitForElementVisible(
				driver.findElement(By.xpath("//div[text()=' " + testData.get("ReceiptReferenceNumber") + " ']/ancestor::datatable-body-cell/following-sibling::datatable-body-cell[9]/div")), 2000,
				100);
		driver.findElement(By.xpath("//div[text()=' " + testData.get("ReceiptReferenceNumber") + " ']/ancestor::datatable-body-cell/following-sibling::datatable-body-cell[9]/div")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()=' " + testData.get("ReceiptReferenceNumber") + " ']/ancestor::datatable-body-cell/following-sibling::datatable-body-cell[9]/div/input"))
				.sendKeys("Deposited");
	}

	@And("^save the bill record$")
	public void save_the_bill_record() throws Throwable {
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoView(receiptObj.accoutsReceivableReceiptSaveButton());
		receiptObj.accoutsReceivableReceiptSaveButton().click();

	}
	
	@And("^User should login as a reviewer user to verify status of receipt$")
	public void user_should_login_as_a_reviewer_user_to_verify_status_of_receipt() throws IOException, ParseException {
		login = new KUBS_Login(driver);
		driver.get(configreader.getApplicationUrl());
		System.out.println(testData.get("ReviewerID"));
		login.logintoAzentioappReviewer("Reviewer", testData.get("ReviewerID"));
	}
	
//	@Then("^update data set ID for verify status of the receipt is auto changed to deposit$")
//    public void update_data_set_id_for_verify_status_of_the_receipt_is_auto_changed_to_deposit() throws Throwable {
//		dataSetID = "KUBS_AR_AP_UAT_010_002_TC_02_02_D1";
//		testData = excelData.getTestdata(dataSetID);
//    }

	////////////////// KUBS_AR/AP_UAT_010_002_TC_03//////////////////////

	@Then("^Click on Update cheque status Note icon$")
	public void click_on_update_cheque_status_note_icon() {
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoView(accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_NoteIcon());
		waitHelper.waitForElement(driver, 2000, accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_NoteIcon());
		accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_NoteIcon().click();

	}

	@Then("^Select the Record$")
	public void select_the_record() {
		waitHelper.waitForElement(driver, 2000, accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_FirstRecord());
		accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_FirstRecord().click();

	}

	// ChequeStatus Cleared
	@Then("^Select Cheque Status Cleared$")
	public void select_cheque_status_cleared() {

		waitHelper.waitForElement(driver, 2000, accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_ChequeStatus());
		accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_ChequeStatus().click();
		accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_ChequeStatus().sendKeys(testData.get("ChequeStatus"));
		accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_ChequeStatus().sendKeys(Keys.ENTER);

	}
	
	@And("^Select and Submit the Update Deposited Cheque record as cleared$")
	public void select_and_submit_the_update_deposited_cheque_record_as_cleared() throws InterruptedException, IOException, ParseException {

		// Reference
//		waitHelper.waitForElement(driver, 2000, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReferenceId());
		waitHelper.waitForElementwithFluentwait(driver, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReferenceId());
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
//		Thread.sleep(3000);

		// REVIEWER
//		Thread.sleep(2000);
		waitHelper.waitForElementwithFluentwait(driver, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RecordStatus());
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
	
	@Given("^User login as a reviewer user for Update cheque status to Cleared$")
	public void user_login_as_a_reviewer_user_for_Update_cheque_status_to_Cleared() throws IOException, ParseException {
		login = new KUBS_Login(driver);
		driver.get(configreader.getApplicationUrl());
		login.logintoAzentioappReviewer("Reviewer", testData.get("ReviewerID"));
	}
	
	@Then("^click on the Notification select the Cheque record to cleared and Approve$")
	public void click_on_the_notification_select_the_cheque_record_to_cleared_and_approve() throws InterruptedException, IOException, ParseException {
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
	
	@And("^then checker claim the update cheque status as cleared record$")
	public void then_checker_claim_the_update_cheque_status_as_cleared_record() throws InterruptedException, IOException, ParseException {

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
	
	@And("^select the update Cheque record as cleared and Approve by checker$")
	public void select_the_update_cheque_record_as_cleared_and_approve_by_checker() throws InterruptedException, IOException, ParseException {
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

	

	//////////////////// KUBS_AR/AP_UAT_010_002_TC_04//////////////////////

	@And("^user should navigate to accounts receivable menu$")
	public void user_should_navigate_to_accounts_receivable_menu() throws InterruptedException {
		waitHelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_DirectionButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_DirectionButton().click();
		waitHelper.waitForElement(driver, 3000, accountsReceivable_ReceiptsReversalsObj.accountsReceivableMenu());
		accountsReceivable_ReceiptsReversalsObj.accountsReceivableMenu().click();
	}

	@When("^click on eye button of update cheque status$")
	public void click_on_eye_button_of_update_cheque_status() {
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoView(accountsReceivable_UpdateChequeStatusObj.accountsReceivable_UpdateChequeStatus_EyeButton());
		waitHelper.waitForElement(driver, 3000, accountsReceivable_UpdateChequeStatusObj.accountsReceivable_UpdateChequeStatus_EyeButton());
		accountsReceivable_UpdateChequeStatusObj.accountsReceivable_UpdateChequeStatus_EyeButton().click();
	}

	@Then("^get slip number by using cheque number$")
	public void get_slip_number_by_using_cheque_number() throws IOException {
		waitHelper.waitForElement(driver, 3000, accountsReceivable_UpdateChequeStatusObj.accountsReceivable_UpdateChequeStatus_Search());
		accountsReceivable_UpdateChequeStatusObj.accountsReceivable_UpdateChequeStatus_Search().click();

		waitHelper.waitForElement(driver, 3000, accountsReceivable_UpdateChequeStatusObj.accountsReceivable_UpdateChequeStatus_ChequeNumber());
		accountsReceivable_UpdateChequeStatusObj.accountsReceivable_UpdateChequeStatus_ChequeNumber().sendKeys(testData.get("ChequeNumber"));

		waitHelper.waitForElement(driver, 3000, accountsReceivable_UpdateChequeStatusObj.accountsReceivable_UpdateChequeStatus_SlipNumber());
		String slipnumber = accountsReceivable_UpdateChequeStatusObj.accountsReceivable_UpdateChequeStatus_SlipNumber().getText();
		
		excelData.updateTestData(dataSetID, "SlipNumber", slipnumber);
		testData = excelData.getTestdata(dataSetID);
		
//		jsonWriter = new JsonDataReaderWriter();
//		jsonWriter.addData(slipnumber);
	}

	@Then("^click on report icon1$")
	public void click_on_report_icon1() {
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoViewAndClick(eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ReportIcon());
	}

	@Then("^click on enquiry menu$")
	public void click_on_enquiry_menu() {

		waitHelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_EnquiryMenu());
		eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_EnquiryMenu().click();
	}

	@Then("^click on temp grid button of financial transaction$")
	public void click_on_temp_grid_button_of_financial_transaction() {
		waitHelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_FinancialTransactionField());
		eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_FinancialTransactionField().click();
	}

	@And("^fill the required fields of financial transaction$")
	public void fill_the_required_fields_of_financial_transaction() {
		waitHelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_BranchCode());
		eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_BranchCode().sendKeys(testData.get("BranchCode"));
		eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_BranchCode().sendKeys(Keys.ENTER);

//	    	waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_GlCode());
//	    	eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_GlCode().sendKeys(UpdateChequeStatusTestDataType.GLCode);
//	    	eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_GlCode().sendKeys(Keys.ENTER);

		waitHelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_FromDate());
		eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_FromDate().click();

		while (true) {
			try {

				waitHelper.waitForElement(driver, 3000,
						driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("Gl Month") + " " + testData.get("Gl Year") + "')]")));
				WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("Gl Month") + " " + testData.get("Gl Year") + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextMonth().click();
			}
		}
		WebElement FinalDay = driver.findElement(
				By.xpath("//td[@aria-label='" + testData.get("Gl FullMonth") + " " + testData.get("Gl Date") + ", " + testData.get("Gl Year") + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);

		waitHelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ToDate());
		eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ToDate().click();

		while (true) {
			try {

				waitHelper.waitForElement(driver, 3000,
						driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("Gl To Month") + " " + testData.get("Gl To Year") + "')]")));
				WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("Gl To Month") + " " + testData.get("Gl To Year") + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextMonth().click();
			}
		}
		WebElement FinalDay2 = driver.findElement(By
				.xpath("//td[@aria-label='" + testData.get("Gl To FullMonth") + " " + testData.get("Gl To Date") + ", " + testData.get("Gl To Year") + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay2);

	}

	@Then("^click on view button to view the reports and verify$")
	public void click_on_view_button_to_view_the_reports_and_verify() throws InterruptedException, IOException, ParseException {
		javaScriptHelper.JavaScriptHelper(driver);
//		waitHelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ViewButton());
		waitHelper.waitForElementToVisibleWithFluentWait(driver, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ViewButton(), 20, 2);
		eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ViewButton().click();
		Thread.sleep(2000);
		javaScriptHelper.scrollIntoView(eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextPage());
		String beforexpath = "//span[contains(text(),' Debit ')]/../../../datatable-body-cell[1]/div/span[contains(text(),'";
		String afterxpath = "')]";

		// span[contains(text(),' Debit
		// ')]/../../../datatable-body-cell[1]/div/span[contains(text(),' ')]
//	    	while(!driver.findElement(By.xpath(beforexpath+UpdateChequeStatusTestDataType.SlipNumber+afterxpath)).getText().equals(jsonWriter.readdata()))
		for(int i=0;i<=70;i++)  {
			try {
//				driver.findElement(By.xpath(beforexpath + jsonWriter.readdata() + afterxpath));
				driver.findElement(By.xpath(beforexpath + testData.get("SlipNumber") + afterxpath));
				System.out.println("Cleared cheque record is available in list");
				break;
			} catch (NoSuchElementException nosuchElement) {
				try {
					eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextPage().click();
				} catch (NoSuchElementException nosuchElement1) {
					System.out.println("Cleared cheque record is not available in list");
					break;
				}
			}
		}

	}
	
	/////////////////////////KUBS_AR_AP_UAT_010_002_TC_05////////////////////////////////////
	
	@Then("^Fill branch details for Balance sheet report post cheque is cleared$")
	public void fill_branch_details_for_Balance_sheet_report_post_cheque_is_cleared() {

		waitHelper.waitForElement(driver, 2000, arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_BranchTextbox());
		arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_BranchTextbox().click();
		arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_BranchTextbox().sendKeys(testData.get("BranchCode"));
		arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_BranchTextbox().sendKeys(Keys.ENTER);
// arAp_BalanceSheetReportTestDataType=
// jsonReader.getBalanceSheetReportByName("maker");
		waitHelper.waitForElement(driver, 2000, arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_ReportType());
		arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_ReportType().click();
		arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_ReportType().sendKeys(testData.get("ReportType"));
		arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_ReportType().sendKeys(Keys.ENTER);

	}
	
	@Then("^Select balance sheet as on date$")
	public void select_balance_sheet_as_on_date() throws InterruptedException {
		waitHelper.waitForElement(driver, 2000, arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_CalendarButton());
		arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_CalendarButton().click();
		javaScriptHelper.JavaScriptHelper(driver);
		for(int i=0;i<=30;i++) {
			try {
				// span[contains(text(),'Oct 2022')]
			Thread.sleep(1000);
//			waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//span[contains(text(),'"+arAp_BalanceSheetReportTestDataType.Month+" "+arAp_BalanceSheetReportTestDataType.Year+"')]")));
				waitHelper.waitForElementwithFluentwait(driver,
						driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("Gl Month") + " " + testData.get("Gl Year") + "')]")));
				WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("Gl Month") + " " + testData.get("Gl Year") + "')]"));
//			Thread.sleep(2000);
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_NextMonth().click();

			}
		}
		// td[@aria-label='November 1, 2022']/span
		WebElement FinalDay = driver.findElement(By.xpath(
				"//td[@aria-label='" + testData.get("Gl FullMonth") + " " + testData.get("Gl Date") + ", " + testData.get("Gl Year") + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
	}
	
	@Then("^Verify balance sheet should updated correctly post cheque is cleared$")
    public void Verify_balance_sheet_should_updated_correctly_post_cheque_is_cleared() throws InterruptedException  {
    	Thread.sleep(1000);
    	javaScriptHelper.JavaScriptHelper(driver);
    	browserHelper.SwitchToWindow(1);
    	waitHelper.waitForElement(driver, 3000, financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_UpdatedDataReceipt());
    	javaScriptHelper.scrollIntoView(financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_UpdatedDataReceipt()); 
    	String chequeAmount = financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_UpdatedDataReceipt().getText();
    	System.out.println("Receivables Cash Equivalents - "+ chequeAmount);
    	browserHelper.switchToParentWithChildClose();
    }
	
//////////////////////////////////////////////////////////////////////////////////
	
	@Then("^select data set ID for verify status of the receipt is auto changed to deposit$")
	public void select_data_set_id_for_verify_status_of_the_receipt_is_auto_changed_to_deposit() throws Throwable {
		dataSetID = "KUBS_AR_AP_UAT_010_002_TC_02_01_D1";
		testData = excelData.getTestdata(dataSetID);
	}
	
	@Then("^update data set ID for verify status of receipt is auto changed to deposit for reviewer$")
    public void update_data_set_id_for_verify_status_of_receipt_is_auto_changed_to_deposit_for_reviewer() throws Throwable {
		dataSetID = "KUBS_AR_AP_UAT_010_002_TC_02_01_D1";
		testData = excelData.getTestdata(dataSetID);
    }
	
	@Then("^update data set ID for verify status of receipt is auto changed to deposit for checker$")
	public void update_data_set_id_for_verify_status_of_receipt_is_auto_changed_to_deposit_for_checker() throws Throwable {
		dataSetID = "KUBS_AR_AP_UAT_010_002_TC_02_01_D1";
		testData = excelData.getTestdata(dataSetID);
	}
	
	@Then("^select data set ID for Update cheque status to Cleared$")
	public void select_data_set_id_for_update_cheque_status_to_cleared() throws Throwable {
		dataSetID = "KUBS_AR_AP_UAT_010_002_TC_03_01_D1";
		testData = excelData.getTestdata(dataSetID);
	}
	
	@Then("^update data set ID for Update cheque status to Cleared for reviewer$")
	public void update_data_set_id_for_update_cheque_status_to_cleared_for_reviewer() throws Throwable {
		dataSetID = "KUBS_AR_AP_UAT_010_002_TC_03_01_D1";
		testData = excelData.getTestdata(dataSetID);
	}
	
	@Then("^update data set ID for Update cheque status to Cleared for checker approval$")
    public void update_data_set_id_for_update_cheque_status_to_cleared_for_checker_approval() throws Throwable {
		dataSetID = "KUBS_AR_AP_UAT_010_002_TC_03_01_D1";
		testData = excelData.getTestdata(dataSetID);
    }
	
	@Then("^select data set ID for accounting entries for cleared cheques$")
	public void select_data_set_id_for_accounting_entries_for_cleared_cheques() throws Throwable {
		dataSetID = "KUBS_AR_AP_UAT_010_002_TC_04_D1";
		testData = excelData.getTestdata(dataSetID);
	}
	
	@Then("^select data set ID for Verify Balance sheet post cheque is cleared$")
    public void select_data_set_id_for_verify_balance_sheet_post_cheque_is_cleared() throws Throwable {
		dataSetID = "KUBS_AR_AP_UAT_010_002_TC_05_D1";
		testData = excelData.getTestdata(dataSetID);
    }

}