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
import pageobjects.BUSINESS_PARTNER_SETUP_BusinessPartnerObj;
import pageobjects.Enquiry_Obj;
import pageobjects.FinancialReporting_GLBalancesReportObj;
import pageobjects.FixedAsset_AssetCreationObj;
import pageobjects.INVENTORY_EnquiryGlObject;
import pageobjects.InventoryMaintenanceObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_ReviewerObj;
import pageobjects.Payment_SettlementObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;

public class ARAP_RecordingReceipt extends BaseClass {
	WebDriver driver = BaseClass.driver;
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	Selenium_Actions seleniumactions = new Selenium_Actions(driver);
	ConfigFileReader configreader = new ConfigFileReader();
	Map<String, String> testdata = new LinkedHashMap<>();
	JavascriptHelper javaScriptHelper = new JavascriptHelper();
	BrowserHelper browserHelper = new BrowserHelper(driver);
	KUBS_ReviewerObj reviewerObj = new KUBS_ReviewerObj(driver);
	KUBS_CheckerObj checkerObj = new KUBS_CheckerObj(driver);
	WaitHelper waithelper = new WaitHelper(driver);
	Map<String, String> autoPayout = new HashMap<>();
	Azentio_ReviewerObj reviewer;
	String poNumber;
	String poBusinessPartner;
	String GRNNO;
	String Branchcode;
	String InvoiceNo;
	String PoNumber;
	String BPNumber;
	String DebitNo;
	String ADVNumber;
	String ADVAmount;
	String TxnNo;
	Map<String, String> settlementTestData = new HashMap<>();
	Map<String, String> settlementData = new HashMap<>();
	ARAP_ARandAPObj arapObj = new ARAP_ARandAPObj(driver);
	FixedAsset_AssetCreationObj fixedAsset_AssetCreationObj = new FixedAsset_AssetCreationObj(driver);
	BUSINESS_PARTNER_SETUP_BusinessPartnerObj bUSINESS_PARTNER_SETUP_BusinessPartnerObj = new BUSINESS_PARTNER_SETUP_BusinessPartnerObj(driver);
	FinancialReporting_GLBalancesReportObj financialReporting_GLBalancesReportObj = new FinancialReporting_GLBalancesReportObj(driver);
//	ARAP_PoCreationObj ArAp_poCreationObj = new ARAP_PoCreationObj(driver);
//	ARAP_GRNCreationPageObject grnObject = new ARAP_GRNCreationPageObject(driver);
//	INVENTORY_EnquiryGlObject inventoryEnquiryGlObj = new INVENTORY_EnquiryGlObject(driver);
//	ACCOUNTSPAYABLE_InvoiceBookingObj invoiceBookingObj = new ACCOUNTSPAYABLE_InvoiceBookingObj(driver);
//	ACCOUNTSPAYABLE_PayementSettlementObj paymentSettlementObj = new ACCOUNTSPAYABLE_PayementSettlementObj(driver);
//	ACCOUNTSPAYABLE_AutoPayoutObj accoutsPayableAutoPayoutObj = new ACCOUNTSPAYABLE_AutoPayoutObj(driver);
//	AccountReceivable_UpdateDepositedChequeObj accountReceivable_UpdateDepositedChequeObj = new AccountReceivable_UpdateDepositedChequeObj(driver);
//	InventoryMaintenanceObj inventoryMaintenanceObj = new InventoryMaintenanceObj(driver);
//	ACCOUNTSPAYABLE_VendorContractCreationObj vendorContractObj = new ACCOUNTSPAYABLE_VendorContractCreationObj(driver);
//	ACCOUNTSPAYBLE_AccountsPayable_POCreationObj poCreationObj = new ACCOUNTSPAYBLE_AccountsPayable_POCreationObj(driver);
	Azentio_CheckerObj kubschecker = new Azentio_CheckerObj(driver);

	ExcelData excelData = new ExcelData("C:\\Users\\ININDC00091\\git\\AzentioAutomationFramework\\DeveshFW_Excel\\ARAP_AzentioAutomationFramework_Excel\\Test-data\\KUBS_TESTDATA_V1.xlsx",
			"AutoPayoutTestData", "Data Set ID");
	Map<String, String> testData = new HashMap<>();
	String dataSetID;

	// *************KUBS_AR/AP_UAT_010_001_TC_01***************//

	@Then("^Click on the Receipt Eye Icon$")
	public void click_on_the_receipt_eye_icon() throws Throwable {
		// --------RECEIPT EYE ICON--------//
		arapObj.accountReceviableReceipt_Eye().click();
	}

	@Then("^Enter Receipt type as cheque$")
	public void enter_receipt_type_as_cheque() throws Throwable {
		// -------RECEIPT TYPR--------//
		arapObj.accountReceviableReceipt_Receipt_Type().click();
		arapObj.accountReceviableReceipt_Receipt_Type().sendKeys(testData.get("ReceiptType"));
		arapObj.accountReceviableReceipt_Receipt_Type().sendKeys(Keys.ENTER);
	}

	@And("^Enter Receipt Ref Number$")
	public void enter_receipt_ref_number() throws Throwable {
		// -------RECEIPT REF NO---------//
		Random random = new Random();
		int RanDom = random.nextInt(1000 - 500) + 500;
		arapObj.accountReceviableReceipt_Receipt_RefNo().click();
		arapObj.accountReceviableReceipt_Receipt_RefNo().sendKeys(testData.get("ReceiptRefNo") + RanDom);
		arapObj.accountReceviableReceipt_Receipt_RefNo().sendKeys(Keys.ENTER);
	}

	@Then("^Enter Receipt Amount$")
	public void enter_receipt_amount() throws Throwable {
		// -------RECEIPT AMOUNT-------//
		arapObj.accountReceviableReceipt_Receipt_Amount().click();
		arapObj.accountReceviableReceipt_Receipt_Amount().sendKeys(testData.get("Amount"));
		arapObj.accountReceviableReceipt_Receipt_Amount().sendKeys(Keys.ENTER);
	}

	@And("^Enter Bank Account Number$")
	public void enter_bank_account_number() throws Throwable {
		// -------BANK ACC NUMBER-------//
		arapObj.accountReceviableReceipt_Receipt_BankNo().click();
		arapObj.accountReceviableReceipt_Receipt_BankNo().sendKeys(testData.get("BankAcc"));
		arapObj.accountReceviableReceipt_Receipt_BankNo().sendKeys(Keys.ENTER);
	}

	@Then("^Enter Receipt payer$")
	public void enter_receipt_payer() throws Throwable {
		// -------RECEIPT PAYER--------//
		arapObj.accountReceviableReceipt_Receipt_Payer().click();
		arapObj.accountReceviableReceipt_Receipt_Payer().sendKeys(testData.get("Receiptpayer"));

	}

	@And("^Enter Remarks for Receipt$")
	public void enter_remarks_for_receipt() throws Throwable {
		// --------RECEIPT REMARK-------//
		arapObj.accountReceviableReceipt_Receipt_Remark().click();
		arapObj.accountReceviableReceipt_Receipt_Remark().sendKeys(testData.get("Remark"));
		Thread.sleep(2000);
	}

	@Then("^Save Receipt Record$")
	public void save_receipt_record() throws Throwable {
		// -------SAVE RECEIPT RECORD-----//
		arapObj.accountReceviableReceipt_Receipt_Save().click();
		Thread.sleep(4000);
	}

	@Then("^Enter Get Referance Number$")
	public void enter_get_referance_number() throws Throwable {
		// -------REFERANCE NUMBER--------//
		arapObj.accountReceviableReceipt_Receipt_SearchRefNo().click();
		arapObj.accountReceviableReceipt_Receipt_SearchRefNo().sendKeys(testData.get("ReceiptRefNo"));
	}
	
	@And("^Store the Referance Id and Open the cheque mode receipt Record$")
	public void store_the_referance_id_and_open_the_cheque_mode_receipt_record() throws Throwable {
		
		// -----------Action Icon-----------//
		waithelper.waitForElement(driver, 2000, arapObj.ARAP_ReferanceId());
		String Referance_id = arapObj.ARAP_ReferanceId().getText();
		
		excelData.updateTestData(dataSetID, "ReferenceID", Referance_id);
		testData = excelData.getTestdata(dataSetID);
		
//		readerData.addReferanceData(Referance_id);
		waithelper.waitForElement(driver, 2000, arapObj.ARAP_ActionButton());
		arapObj.ARAP_ActionButton().click();
	}
	
	@And("^Store the Referance Id and Open the wire mode receipt Record$")
	public void store_the_referance_id_and_open_the_wire_mode_receipt_record() throws Throwable {
		
		// -----------Action Icon-----------//
		waithelper.waitForElement(driver, 2000, arapObj.ARAP_ReferanceId());
		String Referance_id = arapObj.ARAP_ReferanceId().getText();
		
		excelData.updateTestData(dataSetID, "ReferenceID", Referance_id);
		testData = excelData.getTestdata(dataSetID);
		
//		readerData.addReferanceData(Referance_id);
		waithelper.waitForElement(driver, 2000, arapObj.ARAP_ActionButton());
		arapObj.ARAP_ActionButton().click();
	}
	
	@And("^Give Remark and Submit the cheque mode receipt Record$")
	public void give_remark_and_submit_the_cheque_mode_receipt_record() throws Throwable {
		// ---------------------SUBMIT THE REVIEWER RECORD-----------------------//
		waithelper.waitForElement(driver, 5000, reviewerObj.reviewerAlertRemarks());
		reviewerObj.reviewerAlertRemarks().sendKeys(testData.get("Remark"));
		waithelper.waitForElement(driver, 5000, reviewerObj.reviewerAlertSubmitButton());
		javaScriptHelper.JSEClick(reviewerObj.reviewerAlertSubmitButton());
		waithelper.waitForElement(driver, 3000, reviewerObj.approvalStatus());
		String Notification = reviewerObj.approvalStatus().getText();
		System.out.println("Reviewer Notification: " + Notification);
		Assert.assertTrue(reviewerObj.approvalStatus().isDisplayed());
	}
	
	@And("^Give Remark and Submit the wire mode receipt Record$")
	public void give_remark_and_submit_the_wire_mode_receipt_record() throws Throwable {
		// ---------------------SUBMIT THE REVIEWER RECORD-----------------------//
		waithelper.waitForElement(driver, 5000, reviewerObj.reviewerAlertRemarks());
		reviewerObj.reviewerAlertRemarks().sendKeys(testData.get("Remark"));
		waithelper.waitForElement(driver, 5000, reviewerObj.reviewerAlertSubmitButton());
		javaScriptHelper.JSEClick(reviewerObj.reviewerAlertSubmitButton());
		waithelper.waitForElement(driver, 3000, reviewerObj.approvalStatus());
		String Notification = reviewerObj.approvalStatus().getText();
		System.out.println("Reviewer Notification: " + Notification);
		Assert.assertTrue(reviewerObj.approvalStatus().isDisplayed());
	}
	
	@And("^Give the Remark and Submit it from checker$")
	public void give_the_remark_and_submit_it_from_checker() throws Throwable {
		// -----------------------SUBMIT THE RECORD------------------------//
		waithelper.waitForElement(driver, 2000, checkerObj.checkerRemarks());
		checkerObj.checkerRemarks().sendKeys(testData.get("Remark"));
		waithelper.waitForElement(driver, 2000, checkerObj.checkersubmitButton());
		checkerObj.checkersubmitButton().click();
		waithelper.waitForElement(driver, 3000, checkerObj.Popup_status());
		String Text = checkerObj.Popup_status().getText();
		System.out.println("Checker status: " + Text);
		Assert.assertTrue(checkerObj.Popup_status().isDisplayed());
	}

	// *******************@KUBS_AR_AP_UAT_010_001_TC_02*******************//

	@Then("^Enter Receipt type as Online$")
	public void enter_receipt_type_as_online() throws Throwable {
		// -------RECEIPT TYPR--------//
		arapObj.accountReceviableReceipt_Receipt_Type().click();
		arapObj.accountReceviableReceipt_Receipt_Type().sendKeys(testData.get("ReceiptType"));
		arapObj.accountReceviableReceipt_Receipt_Type().sendKeys(Keys.ENTER);
	}

	// *******************@KUBS_AR_AP_UAT_010_001_TC_03*******************//

	@Then("^Enter Receipt type as Wire$")
	public void enter_receipt_type_as_wire() throws Throwable {
		// ---------ENTER RECEIPT TYPE----------//
		waithelper.waitForElement(driver, 2000, arapObj.accountReceviableReceipt_ReceiptType());
		arapObj.accountReceviableReceipt_ReceiptType().click();
		arapObj.accountReceviableReceipt_ReceiptType().sendKeys(testData.get("ReceiptType"));
	}

	@And("^Get The Txn Receipt Number$")
	public void get_the_txn_receipt_number() throws Throwable {
		// -------get the txn number--------//
		javaScriptHelper.JavaScriptHelper(driver);
		TxnNo = (String) javaScriptHelper.executeScript("return document.getElementsByName('receiptNo')[1].value");
		System.out.println(TxnNo);
	}
	
	@And("^choose branch codes to verify accounting entries post receipt recording$")
	public void choose_branch_codes_to_verify_accounting_entries_post_receipt_recording() throws Throwable {
		// -----------CLICK ON BRANCH CODE------------//
		waithelper.waitForElement(driver, 2000, arapObj.ARAPBranchCode());
		arapObj.ARAPBranchCode().click();
		arapObj.ARAPBranchCode().sendKeys(testData.get("BranchCode"));
		arapObj.ARAPBranchCode().sendKeys(Keys.ENTER);
	}
	
	@Then("^Select from date in calender to verify accounting entries post receipt recording$")
	public void select_from_date_in_calender_to_verify_accounting_entries_post_receipt_recording() throws Throwable {
		// ----------CLICK ON FROM DATE--------------//
		while (true) {
			try {

				waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("Month") + " " + testData.get("Year") + "')]")));
				WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("Month") + " " + testData.get("Year") + "')]"));
				Thread.sleep(2000);
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				arapObj.ARAPNextMonth().click();

			}

		}
		waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth") + " " + testData.get("Date") + ", " + testData.get("Year") + "']/span")));
		WebElement Click = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth") + " " + testData.get("Date") + ", " + testData.get("Year") + "']/span"));

		clicksAndActionHelper.doubleClick(Click);

	}

	@Then("^Select To date in calender to verify accounting entries post receipt recording$")
	public void select_to_date_in_calender_to_verify_accounting_entries_post_receipt_recording() throws Throwable {
		while (true) {
			try {

				// span[contains(text(),'Oct 2022')]
//				Thread.sleep(1000);
//				waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//span[contains(text(),'"+arAp_BalanceSheetReportTestDataType.Month+" "+arAp_BalanceSheetReportTestDataType.Year+"')]")));
				waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("Month1") + " " + testData.get("Year1") + "')]")));
				WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("Month1") + " " + testData.get("Year1") + "')]"));
//				Thread.sleep(2000);
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				arapObj.ARAPNextMonth().click();
			}
		}
		waithelper.waitForElement(driver, 3000,
				driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth1") + " " + testData.get("Date1") + ", " + testData.get("Year1") + "']/span")));
		WebElement Click = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth1") + " " + testData.get("Date1") + ", " + testData.get("Year1") + "']/span"));

		clicksAndActionHelper.doubleClick(Click);

	}


	@Then("^Verify Accounting entries post receipt recording$")
	public void verify_accounting_entries_post_receipt_recording() throws Throwable {
		javaScriptHelper.JavaScriptHelper(driver);
		Thread.sleep(1000);
		for (int i = 0; i <= 299; i++) {
			try {

				driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'" + TxnNo + "')])[1]")).isDisplayed();

				driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'" + TxnNo + "')])[1]"));
				String TransactionType = driver
						.findElement(
								By.xpath("(//datatable-body-cell[1]//span[contains(text(),' " + TxnNo + " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[5]//span)[1]"))
						.getText();
				System.out.println("TransactionType is " + TransactionType);
				String amount = driver
						.findElement(
								By.xpath("(//datatable-body-cell[1]//span[contains(text(),' " + TxnNo + " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[6]//span)[1]"))
						.getText();
				System.out.println("Amount is " + amount);
				break;

			} catch (NoSuchElementException e) {
				javaScriptHelper.scrollIntoView(arapObj.accountsPayablePayementSettlementNextRecord());
				arapObj.accountsPayablePayementSettlementNextRecord().click();
			}
		}
		for (int i = 0; i <= 299; i++) {
			try {

				driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'" + TxnNo + "')])[2]")).isDisplayed();

				driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'" + TxnNo + "')])[1]"));
				String TransactionType = driver
						.findElement(
								By.xpath("(//datatable-body-cell[1]//span[contains(text(),' " + TxnNo + " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[5]//span)[2]"))
						.getText();
				System.out.println("TransactionType is " + TransactionType);
				String amount = driver
						.findElement(
								By.xpath("(//datatable-body-cell[1]//span[contains(text(),' " + TxnNo + " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[6]//span)[2]"))
						.getText();
				System.out.println("Amount is " + amount);
				break;

			} catch (NoSuchElementException e) {
				javaScriptHelper.scrollIntoView(arapObj.accountsPayablePayementSettlementNextRecord());
				arapObj.accountsPayablePayementSettlementNextRecord().click();
			}
		}
	}

	////////////////////// @KUBS_AR_AP_UAT_010_001_TC_04//////////////////////////

	@Then("^click on report icon$")
	public void click_on_report_icon() throws InterruptedException {
		Thread.sleep(2000);
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoViewAndClick(fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_ReportIcon());
	}

	@And("^user should navigate to financial reporting menu$")
	public void user_should_navigate_to_financial_reporting_menu() {
		waithelper.waitForElementToVisibleWithFluentWait(driver, financialReporting_GLBalancesReportObj.FinancialReportingMenu(), 5, 500);
		financialReporting_GLBalancesReportObj.FinancialReportingMenu().click();
	}

	@Then("^click on temp grid button of Balance sheet report$")
	public void click_on_temp_grid_button_of_balance_sheet_report() {
		waithelper.waitForElement(driver, 3000, financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_TempGridButton());
		financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_TempGridButton().click();
	}

	@And("^fill the required field of Balance sheet report$")
	public void fill_the_required_field_of_balance_sheet_report() {

		waithelper.waitForElement(driver, 3000, financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_Branch());
		financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_Branch().sendKeys(testData.get("Branch"));
		financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_Branch().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000, financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_ReportType());
		financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_ReportType().sendKeys(testData.get("ReportType"));
		financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_ReportType().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000, financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_BalanceSheetAsOnDate());
		financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_BalanceSheetAsOnDate().click();

		while (true) {
			try {
				waithelper.waitForElement(driver, 3000,
						driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("Month") + " " + testData.get("Year") + "')]")));
				WebElement birthmonthandyear = driver
						.findElement(By.xpath("//span[contains(text(),'" + testData.get("Month") + " " + testData.get("Year") + "')]"));
//						driver.findElement(By.xpath("//div/div/button")).getText().contains(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthMonth+" "+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear);
				break;
			} catch (NoSuchElementException nosuchElement) {
				waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SelectDate());
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SelectDate().click();
				String tablehead = bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_HeadYear().getText();
//						String tablehead="2016 ~ 2036";
				String headyear = tablehead.replaceAll(" ~", "");
//						System.out.println(headyear);
				String ar[] = headyear.split(" ");
				int y1 = Integer.parseInt(ar[0]);
				int y2 = Integer.parseInt(ar[1]);
				int year = Integer.parseInt(testData.get("Year"));
				if (year < y1 && year < y2) {
					while (true) {
						try {
							waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("Year") + "')]")));
							WebElement Year = driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("Year") + "')]"));
							break;
						} catch (NoSuchElementException nosuchElement1) {
							waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear());
							bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear().click();
						}
					}
					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("Year") + "')]")));
					WebElement Year = driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("Year") + "')]"));
					Year.click();

					waithelper.waitForElement(driver, 2000,
							driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth") + " " + testData.get("Year") + "']")));
					driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth") + " " + testData.get("Year") + "']")).click();

				} else if (year > y1 && year > y2) {
					while (true) {
						try {
							waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("Year") + "')]")));
							WebElement Year = driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("Year") + "')]"));
							break;
						} catch (NoSuchElementException nosuchElement2) {
							waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear());
							bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear().click();
						}
					}
					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("Year") + "')]")));
					WebElement Year = driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("Year") + "')]"));
					clicksAndActionHelper.doubleClick(Year);

					waithelper.waitForElement(driver, 2000,
							driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth") + " " + testData.get("Year") + "']")));
					driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth") + " " + testData.get("Year") + "']")).click();

				} else {
					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='" + testData.get("Year") + "']")));
					WebElement Year = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("Year") + "']"));
					Year.click();

					waithelper.waitForElement(driver, 2000,
							driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth") + " " + testData.get("Year") + "']")));
					driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth") + " " + testData.get("Year") + "']")).click();

				}
			}
		}
		waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth") + " "
				+ testData.get("Date") + ", " + testData.get("Year") + "']/span")));
		WebElement BirthDate = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth") + " " + testData.get("Date") + ", "
				+ testData.get("Year") + "']/span"));
		clicksAndActionHelper.doubleClick(BirthDate);

	}

	@Then("^Verify balance sheet should updated correctly$")
	public void Verify_balance_sheet_should_updated_correctly() throws InterruptedException {
		Thread.sleep(1000);
		javaScriptHelper.JavaScriptHelper(driver);
		browserHelper.SwitchToWindow(1);
		waithelper.waitForElement(driver, 3000, financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_UpdatedData());
		javaScriptHelper.scrollIntoView(financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_UpdatedData());
		String receivableAmount = financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_UpdatedData().getText();
		System.out.println("Trade Receivables Advances to Employee - " + receivableAmount);
		browserHelper.switchToParentWithChildClose();
	}
	
	@Then("^click on view button to view the balance sheet report$")
    public void click_on_view_button_to_view_the_balance_sheet_report()  {
    	waithelper.waitForElement(driver, 3000, financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_BalanceSheetReportView());
    	financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_BalanceSheetReportView().click();
    	
    }

	@Then("^Verify balance sheet should updated correctly post approval through online mode$")
	public void Verify_balance_sheet_should_updated_correctly_post_approval_through_online_mode() throws InterruptedException {
		Thread.sleep(1000);
		javaScriptHelper.JavaScriptHelper(driver);
		browserHelper.SwitchToWindow(1);
		waithelper.waitForElement(driver, 3000, financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_UpdatedDataReceipt());
		javaScriptHelper.scrollIntoView(financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_UpdatedDataReceipt());
		String receiptAmount = financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_UpdatedDataReceipt().getText();
		System.out.println("Receivables Cash Equivalents - " + receiptAmount);
		browserHelper.switchToParentWithChildClose();
	}
	
	@Then("^select data set ID for Record a receipt through cheque mode$")
    public void select_data_set_id_for_record_a_receipt_through_cheque_mode() throws Throwable {
		dataSetID = "KUBS_AR_AP_UAT_010_001_TC_01";
		testData = excelData.getTestdata(dataSetID);
    }
	
	@Then("^select data set ID for Record a receipt through Online mode$")
    public void select_data_set_id_for_record_a_receipt_through_online_mode() throws Throwable {
		dataSetID = "KUBS_AR_AP_UAT_010_001_TC_02";
		testData = excelData.getTestdata(dataSetID);
    }
	
	@Then("^select data set ID for Verify accounting entries post receipt recording$")
	public void select_data_set_id_for_verify_accounting_entries_post_receipt_recording() throws Throwable {
		dataSetID = "KUBS_AR_AP_UAT_010_001_TC_03";
		testData = excelData.getTestdata(dataSetID);
	}
	
	@Then("^select data set ID for Verify Balance sheet post approval through online mode$")
    public void select_data_set_id_for_verify_balance_sheet_post_approval_through_online_mode() throws Throwable {
		dataSetID = "KUBS_AR_AP_UAT_010_001_TC_04";
		testData = excelData.getTestdata(dataSetID);
    }

}