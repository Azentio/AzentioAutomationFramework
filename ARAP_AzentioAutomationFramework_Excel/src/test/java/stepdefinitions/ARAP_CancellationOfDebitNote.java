package stepdefinitions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import dataProvider.ConfigFileReader;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.Selenium_Actions;
import helper.VerificationHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ACCOUNTSPAYABLE_PayementSettlementObj;
import pageobjects.ARAP_ARandAPObj;
import pageobjects.ARAP_ReportsObj;
import pageobjects.AccountsReceivable_DebitNoteObj;
import pageobjects.ArAp_BalanceSheetReportObj;
import pageobjects.ArAp_Cancellation_of_vendorObj;
import pageobjects.BUDGET_RequestAndAllocationObj;
import pageobjects.BUDGET_SupplementaryBudgetObj;
import pageobjects.InvoiceBookingObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_ReviewerObj;
import pageobjects.Payment_SettlementObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;

public class ARAP_CancellationOfDebitNote {
	WebDriver driver = BaseClass.driver;
	KUBS_Login kubsLogin;
	ConfigFileReader configFileReader = new ConfigFileReader();
	WaitHelper waitHelper = new WaitHelper(driver);
	JavascriptHelper javaScriptHelper = new JavascriptHelper();
	DropDownHelper dropDownHelper = new DropDownHelper(driver);
	Selenium_Actions seleniumactions = new Selenium_Actions(driver);
	VerificationHelper verificationHelper = new VerificationHelper();
	String referance_id;
	String reviwerId;
	String GRNNO;
	String Branchcode;
	String InvoiceNo;
	String PoNumber;
	String BPNumber;
	String DebitNo;
	String ADVNumber;
	String ADVAmount;
	String TxnNo;
	Map<String, String> Getdata = new LinkedHashMap<>();
	JsonDataReaderWriter readerData = new JsonDataReaderWriter();
	KUBS_ReviewerObj reviewerObj = new KUBS_ReviewerObj(driver);
	KUBS_CheckerObj checkerObj = new KUBS_CheckerObj(driver);
	ClicksAndActionsHelper clickAndActionHelper = new ClicksAndActionsHelper(driver);
	ARAP_ARandAPObj arapObj = new ARAP_ARandAPObj(driver);
	BUDGET_RequestAndAllocationObj requestAndAllocation = new BUDGET_RequestAndAllocationObj(driver);
	InvoiceBookingObj invoiceBookingObj = new InvoiceBookingObj(driver);
	ArAp_BalanceSheetReportObj arAp_BalanceSheetReportObj = new ArAp_BalanceSheetReportObj(driver);
	Payment_SettlementObj paymentSettlementObj = new Payment_SettlementObj(driver);
	BUDGET_SupplementaryBudgetObj bUDGET_SupplementaryBudgetObj=new BUDGET_SupplementaryBudgetObj(driver);
	ARAP_ReportsObj arapReportObj = new ARAP_ReportsObj(driver);
	BrowserHelper browseHelper = new BrowserHelper(driver);
	ArAp_Cancellation_of_vendorObj cancellationofcontract = new ArAp_Cancellation_of_vendorObj(driver);
	AccountsReceivable_DebitNoteObj accountsReceivable_DebitNoteObj = new AccountsReceivable_DebitNoteObj(driver);
	ACCOUNTSPAYABLE_PayementSettlementObj payementSettlementObj = new ACCOUNTSPAYABLE_PayementSettlementObj(driver);
	ExcelData excelData = new ExcelData("C:\\Users\\ININDC00091\\git\\AzentioAutomationFramework\\DeveshFW_Excel\\ARAP_AzentioAutomationFramework_Excel\\Test-data\\KUBS_TESTDATA_V1.xlsx",
			"CancelledDebitNoteTestData", "Data Set ID");
	Map<String, String> testData = new HashMap<>();
	String dataSetID;

////////////////////003_006_tc_01//////////////////////////////

	@Then("^Choose the second Tab Segment$")
	public void choose_the_second_tab_segment() throws Throwable {
// ---------TO VIEW THE SECOND SEGMENT ICON----------//
		Thread.sleep(1500);
		waitHelper.waitForElementwithFluentwait(driver, arapObj.ARAPTransfericon());
		arapObj.ARAPTransfericon().click();
	}

	@And("^Click On Main module Accounts Receivable$")
	public void click_on_main_module_accounts_receivable() throws Throwable {
// ----------ACCOUTS RECEIVABLE----------//
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoView(arapObj.ARAP_Accountsreceivable());
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_Accountsreceivable());
		arapObj.ARAP_Accountsreceivable().click();
	}

	@Then("^Click on Accounts Receivable Debit Note Eye Icon$")
	public void click_on_accounts_receivable_debit_note_eye_icon() throws Throwable {
// -----------DEBIT NOTE EYE---------------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountsReceivable_DebitNote_Eye());
		arapObj.accountsReceivable_DebitNote_Eye().click();
	}

	@Then("^Enter Cancelled Value In Debit Not Status$")
	public void enter_cancelled_value_in_debit_not_status() throws Throwable {
// ------------Cancelled STATUS------------//
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoView(arapObj.accountsReceivable_DebitNote_Status());

		waitHelper.waitForElement(driver, 2000, arapObj.accountsReceivable_DebitNote_Status());
		arapObj.accountsReceivable_DebitNote_Status().click();
		arapObj.accountsReceivable_DebitNote_Status().sendKeys(testData.get("GRN Status"));

	}

	@And("^Get The Bp Name and Debit Number Store It$")
	public void get_the_bp_name_and_debit_number_store_it() throws Throwable {
// ---------GET THE REQUIRED DETAILS--------------//
		Thread.sleep(1000);
		waitHelper.waitForElement(driver, 2000, arapObj.accountsReceivable_DebitNote_GetBpname());
		BPNumber = arapObj.accountsReceivable_DebitNote_GetBpname().getText();
		System.out.println(BPNumber);
		Thread.sleep(1000);
		javaScriptHelper.JavaScriptHelper(driver);
		DebitNo = (String) javaScriptHelper.executeScript("return document.getElementsByName('debitNoteNumber')[1].value");
		System.out.println(DebitNo);
		waitHelper.waitForElement(driver, 2000, arapObj.accountsReceivable_DebitNote_GetInvoiceNo());
		InvoiceNo = arapObj.accountsReceivable_DebitNote_GetInvoiceNo().getText();
		System.out.println(InvoiceNo);

	}

	@And("^Choose Enquiry Module for cancelled debit note$")
	public void choose_enquiry_module_for_cancelled_debit_note() throws Throwable {
// ------------CLICK ON ENQUIRY ICON--------------//
		waitHelper.waitForElement(driver, 3000, arapObj.ARAPEnquiryMenu());
		arapObj.ARAPEnquiryMenu().click();
		waitHelper.waitForElement(driver, 3000, arapObj.ARAPFinancialTransactionIcon());
		Assert.assertTrue(arapObj.ARAPFinancialTransactionIcon().isDisplayed());
	}

	@Then("^Click on financial transction edit button$")
	public void click_on_financial_transction_edit_button() throws Throwable {
// -----------CLICK ON FINANCIAL EDIT------------//
		arapObj.ARAPFinancialTransactionIcon().click();
	}

	@And("^choose branch codes for cancelled debit note$")
	public void choose_branch_codes_for_cancelled_debit_note() throws Throwable {
		// -----------CLICK ON BRANCH CODE------------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAPBranchCode());
		arapObj.ARAPBranchCode().click();
		arapObj.ARAPBranchCode().sendKeys(testData.get("BranchCode"));
		arapObj.ARAPBranchCode().sendKeys(Keys.ENTER);
	}

	@Then("^Select from date in calender for cancelled debit note$")
	public void select_from_date_in_calender_for_cancelled_debit_note() throws Throwable {
// ----------CLICK ON FROM DATE--------------//
		for(int i=0;i<30;i++) {
			try {
				waitHelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[text()='" + testData.get("FromMonth") + " " + testData.get("FromYear") + "']")));
				WebElement monthAndYear = driver.findElement(By.xpath("//span[text()='" + testData.get("FromMonth") + " " + testData.get("FromYear") + "']"));
//				Thread.sleep(2000);
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				arapObj.ARAPNextMonth().click();

			}

		}
		waitHelper.waitForElement(driver, 3000,
				driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FromFullMonth") + " " + testData.get("FromDate") + ", " + testData.get("FromYear") + "']/span")));
		WebElement Click = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FromFullMonth") + " " + testData.get("FromDate") + ", " + testData.get("FromYear") + "']/span"));

		clickAndActionHelper.doubleClick(Click);

	}

	@Then("^Select To date in calender for cancelled debit note$")
	public void select_to_date_in_calender_for_cancelled_debit_note() throws Throwable {
		for(int i=0;i<=30;i++) {
			try {

// span[contains(text(),'Oct 2022')]
//	Thread.sleep(1000);
//	waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//span[contains(text(),'"+arAp_BalanceSheetReportTestDataType.Month+" "+arAp_BalanceSheetReportTestDataType.Year+"')]")));
				waitHelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[text()='" + testData.get("ToMonth") + " " + testData.get("ToYear") + "']")));
				WebElement monthAndYear = driver.findElement(By.xpath("//span[text()='" + testData.get("ToMonth") + " " + testData.get("ToYear") + "']"));
//	Thread.sleep(2000);
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				arapObj.ARAPNextMonth().click();
			}
		}
		waitHelper.waitForElement(driver, 3000,
				driver.findElement(By.xpath("//td[@aria-label='" + testData.get("ToFullMonth") + " " + testData.get("ToDate") + ", " + testData.get("ToYear") + "']/span")));
		WebElement Click = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("ToFullMonth") + " " + testData.get("ToDate") + ", " + testData.get("ToYear") + "']/span"));

		clickAndActionHelper.doubleClick(Click);
//		Click.click();
	}

	@Then("^Verify Accounting entries post Debit Note is cancelled$")
	public void verify_accounting_entries_post_debit_note_is_cancelled() throws Throwable {
		javaScriptHelper.JavaScriptHelper(driver);
		Thread.sleep(1000);
		for (int i = 0; i <= 299; i++) {
			try {

				driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'" + DebitNo + "')])[1]")).isDisplayed();

				driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'" + DebitNo + "')])[1]"));
				String TransactionType = driver
						.findElement(
								By.xpath("(//datatable-body-cell[1]//span[contains(text(),' " + DebitNo + " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[5]//span)[1]"))
						.getText();
				System.out.println("TransactionType is " + TransactionType);
				String amount = driver
						.findElement(
								By.xpath("(//datatable-body-cell[1]//span[contains(text(),' " + DebitNo + " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[6]//span)[1]"))
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

				driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'" + DebitNo + "')])[2]")).isDisplayed();

				driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'" + DebitNo + "')])[1]"));
				String TransactionType = driver
						.findElement(
								By.xpath("(//datatable-body-cell[1]//span[contains(text(),' " + DebitNo + " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[5]//span)[2]"))
						.getText();
				System.out.println("TransactionType is " + TransactionType);
				String amount = driver
						.findElement(
								By.xpath("(//datatable-body-cell[1]//span[contains(text(),' " + DebitNo + " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[6]//span)[2]"))
						.getText();
				System.out.println("Amount is " + amount);
				break;

			} catch (NoSuchElementException e) {
				javaScriptHelper.scrollIntoView(arapObj.accountsPayablePayementSettlementNextRecord());
				arapObj.accountsPayablePayementSettlementNextRecord().click();
			}
			if (i == 299) {
				Assert.fail();
			}
		}
	}

	//////////////////////// 003_006_TC_02///////////////////////

	@And("^Get the Branch Name in wait$")
	public void get_the_branch_name_in_wait() throws Throwable {
// -------GET DEBIT NOTE BRANCH NAME--------//
		Branchcode = arapObj.ARAP_GetPoNumber().getText();
		System.out.println(Branchcode);

	}

	@Then("^Get the Transaction Date$")
	public void get_the_transaction_date() throws Throwable {
// ------GET TRANSACTION DATE-------//
		javaScriptHelper.JavaScriptHelper(driver);
		String Date = (String) javaScriptHelper.executeScript("return document.getElementsByName('kubDateTime')[0].value");
		Getdata.put("Date", Date);
		System.out.println(Date);
		String year = Date.substring(7, 11);
		Getdata.put("Year", year);
		String month = Date.substring(3, 6);
		Getdata.put("Month", month);
		String day = Date.substring(0, 2);
		Getdata.put("Day", day);
		if (Getdata.get("Day").substring(0, 1).equalsIgnoreCase("0")) {
			String Day = Getdata.get("Day").substring(1, 2);
			Getdata.put("Day", Day);
		}
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
	}

	@And("^Click on Financial Reporting module$")
	public void click_on_financial_reporting_module() throws Throwable {
// ---------FINANCIAL REPORT---------//
		waitHelper.waitForElementwithFluentwait(driver, arapReportObj.ARAP_Report_Financialreporting());
		arapReportObj.ARAP_Report_Financialreporting().click();
	}

	@Then("^Click on Balance sheet Sub module$")
	public void click_on_balance_sheet_sub_module() throws Throwable {
// --------balance sheet report-*----------//
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoView(arapReportObj.ARAP_Report_Balancesheet_Edit());
		waitHelper.waitForElementwithFluentwait(driver, arapReportObj.ARAP_Report_Balancesheet_Edit());
		arapReportObj.ARAP_Report_Balancesheet_Edit().click();
	}

	@Then("^Fill branch details for post debit note balance sheet report$")
	public void fill_branch_details_for_post_debit_note_balance_sheet_report() {

// Thread.sleep(6000);

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

	@Then("^Give Getted Transaction Date$")
	public void give_getted_transaction_date() throws Throwable {
// -----Transaction Date-------//
		waitHelper.waitForElement(driver, 2000, arapReportObj.ARAP_Report_Module_Date());
		arapReportObj.ARAP_Report_Module_Date().click();
		Thread.sleep(2000);
		arapObj.ARAP_Year().click();
		waitHelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//span[text()='" + Getdata.get("Year") + "']")));
		driver.findElement(By.xpath("//span[text()='" + Getdata.get("Year") + "']")).click();
		waitHelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//span[text()='" + Getdata.get("Month") + "']")));
		driver.findElement(By.xpath("//span[text()='" + Getdata.get("Month") + "']")).click();
		waitHelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//span[text()='" + Getdata.get("Day") + "'][1]")));
		driver.findElement(By.xpath("//span[text()='" + Getdata.get("Day") + "'][1]")).click();
	}

	@Then("^Click on Balance sheet View button$")
	public void click_on_balance_sheet_view_button() throws Throwable {
// ------CLICK ON VIEW BUTTON---------//
		arapReportObj.ARAP_Report_ViewButton().click();

	}

	@And("^verify Balance sheet post Bill is approved$")
	public void verify_balance_sheet_post_bill_is_approved() throws Throwable {
		browseHelper.SwitchToWindow(1);
		Thread.sleep(3000);
		System.out.println("The Balance sheet Report is Displayed");
		browseHelper.switchToParentWithChildClose();
	}

	//////////////////////// 003_006_TC_03///////////////////////

	@And("^Click main Reports module$")
	public void click_main_reports_module() throws Throwable {
		waitHelper.waitForElement(driver, 3000, arapObj.accountsReceivable_DebitNote_ReportModule());
		arapObj.accountsReceivable_DebitNote_ReportModule().click();
	}

	@Then("^Click on sub module Accounts Receivable Report$")
	public void click_on_sub_module_accounts_receivable_report() throws Throwable {
		// ----------ACCOUNTS RECEIVABLE EYE----------//
		arapReportObj.ARAP_Report_Acc_Rec_Module_Edit().click();
	}

	@And("^Give Getted Business Partner Name in field$")
	public void give_getted_business_partner_name_in_field() throws Throwable {
		// ---------GIVE GETTED DATA TO FIELD----------//
		// arapReportObj.ARAP_Report_Module_VendorName().click();
		arapReportObj.ARAP_Report_Module_VendorName().sendKeys(BPNumber);
		arapReportObj.ARAP_Report_Module_VendorName().sendKeys(Keys.ENTER);
	}

	@Then("^Give Current business Date in Account receivable report$")
	public void give_current_business_date_in_account_receivable_report() throws Throwable {
		// ----------CLICK ON DATE--------------//
		arapReportObj.ARAP_Report_Module_Date().click();
		javaScriptHelper.JavaScriptHelper(driver);
		for(int i=0;i<=30;i++) {
			try {

				waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("Month") + " " + testData.get("Year") + "')]")));
				driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("Month") + " " + testData.get("Year") + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				waitHelper.waitForElementwithFluentwait(driver, arapObj.ARAPNextMonth());
				arapObj.ARAPNextMonth().click();

			}
		}
		waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth") + " " + testData.get("Date") + ", " + testData.get("Year") + "']/span")));
		WebElement Click = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth") + " " + testData.get("Date") + ", " + testData.get("Year") + "']/span"));

		clickAndActionHelper.doubleClick(Click);
	}

	@And("^Verify Accounts Receivable Report post Debit Note is cancelled$")
	public void verify_accounts_receivable_report_post_debit_note_is_cancelled() throws Throwable {
		browseHelper.SwitchToWindow(1);
		javaScriptHelper.JavaScriptHelper(driver);
		while (true) {
			Thread.sleep(2000);
			try {
				javaScriptHelper.scrollIntoView(driver.findElement(By.xpath("//div[contains(text(),'" + DebitNo + "')]")));
				driver.findElement(By.xpath("//div[contains(text(),'" + DebitNo + "')]")).isDisplayed();
				break;
			} catch (NoSuchElementException e) {
				waitHelper.waitForElement(driver, 3000, arapReportObj.ARAP_Report_Nextbtn());
				arapReportObj.ARAP_Report_Nextbtn().click();
			}
		}
		browseHelper.switchToParentWithChildClose();
	}

	//////////////////////////// 003_006_TC_04//////////////////////////

	@And("^Store The Business partner and Invoice Number$")
	public void store_the_business_partner_and_invoice_number() throws Throwable {
		// ------------STORE THE DTAILS------------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountsReceivable_DebitNote_GetBpname());
		BPNumber = arapObj.accountsReceivable_DebitNote_GetBpname().getText();
		System.out.println(BPNumber);

		waitHelper.waitForElement(driver, 2000, arapObj.accountsReceivable_DebitNote_InvoiceNo());
		InvoiceNo = arapObj.accountsReceivable_DebitNote_InvoiceNo().getText();
		System.out.println(InvoiceNo);
	}

	@And("^Click On Main module Accounts payable$")
	public void click_on_main_module_accounts_payable() throws Throwable {
		// ---------CLICK ON ACCOUNTS PAYABLE MODULE------------//
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoView(arapObj.ARAP_SegmentButton_ReportIcon());
		waitHelper.waitForElementwithFluentwait(driver, arapObj.ARAP_Accountspayable());
		arapObj.ARAP_Accountspayable().click();
	}

	@Then("^Click sub module Payment settlement Eye Icon$")
	public void click_sub_module_payment_settlement_eye_icon() throws Throwable {
		// ------------PAYMENT SETTLEMENT EYE ICON---------------//
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoView(arapObj.accountsPayablePayementSettlementViewIcon());
//		waitHelper.waitForElement(driver, 2000, arapObj.accountsPayablePayementSettlementViewIcon());
		waitHelper.waitForElementwithFluentwait(driver, arapObj.accountsPayablePayementSettlementViewIcon());
		arapObj.accountsPayablePayementSettlementViewIcon().click();

	}

	@And("^Click Add icon button$")
	public void click_add_icon_button() throws Throwable {
		// -------CLICK ON ADD ICON--------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_InvoiceAdd());
		arapObj.ARAP_InvoiceAdd().click();
	}

	@Then("^Enter payment option$")
	public void enter_payment_option() throws Throwable {
		// -----------ENTER PAYMENT OPTION----------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountsPayablePayementSettlementPaymentOption());
		arapObj.accountsPayablePayementSettlementPaymentOption().sendKeys(testData.get("PaymentOption"));
		arapObj.accountsPayablePayementSettlementPaymentOption().sendKeys(Keys.ENTER);
	}

	@And("^Give Business partner Name$")
	public void give_business_partner_name() throws Throwable {
		// ----------ENTER BUSINESS PARTNER-------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountsPayablePayementSettlementBpName());
		arapObj.accountsPayablePayementSettlementBpName().sendKeys(BPNumber);
		arapObj.accountsPayablePayementSettlementBpName().sendKeys(Keys.ENTER);
	}

	@And("^Enter Business partner$")
	public void enter_business_partner() throws Throwable {
		// ----------ENTER BUSINESS PARTNER-------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountsPayablePayementSettlementBpName());
		arapObj.accountsPayablePayementSettlementBpName().sendKeys(testData.get("BusinessPartner"));
		arapObj.accountsPayablePayementSettlementBpName().sendKeys(Keys.ENTER);
	}

	@Then("^Choose value date as System current date$")
	public void choose_value_date_as_system_current_date() throws Throwable {
		// ------------VALUE DATE--SYSTEM DATE--------------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountsPayablePayementSettlementValueDate());
		arapObj.accountsPayablePayementSettlementValueDate().click();

		// -------------CHOOSE DATE---------------//
		javaScriptHelper.JavaScriptHelper(driver);
		while (true) {
			try {

				waitHelper.waitForElement(driver, 5000, driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("Month") + " " + testData.get("Year") + "')]")));
				driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("Month") + " " + testData.get("Year") + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				waitHelper.waitForElement(driver, 5000, arapObj.ARAPNextMonth());
				arapObj.ARAPNextMonth().click();
			}
		}
		waitHelper.waitForElement(driver, 5000, driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth") + " " + testData.get("Date") + ", " + testData.get("Year") + "']/span")));
		WebElement Click = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth") + " " + testData.get("Date") + ", " + testData.get("Year") + "']/span"));

		clickAndActionHelper.doubleClick(Click);
		// clickAndActionHelper.clickOnElement(Click);

	}

	@And("^find the invoice reference number for cancelled DebitNote is availabe at the billing queue$")
	public void find_the_invoice_reference_number_for_cancelled_debitnote_is_availabe_at_the_billing_queue() throws Throwable {
		// div[contains(text(),'ADV_10_21122021')]
		Thread.sleep(1000);
		javaScriptHelper.JavaScriptHelper(driver);
		// javascriptHelper.scrollDownByPixel();
		for (int i = 0; i <= 13; i++) {
			try {
				waitHelper.waitForElementVisible(driver.findElement(By.xpath("//div[contains(text(),'" + InvoiceNo + "')]")), 1000, 100);
				driver.findElement(By.xpath("//div[contains(text(),'" + InvoiceNo + "')]")).isDisplayed();
				// Assert.assertFalse(result);

			} catch (NoSuchElementException e) {
				// waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementNextRecord(),
				// 1000, 100);
				javaScriptHelper.scrollIntoView(arapObj.accountsPayablePayementSettlementNextRecord());

				arapObj.accountsPayablePayementSettlementNextRecord().click();

			}
			if (i == 13) {
				System.out.println("This is the end of the table invoice number is not availabe ");
				break;

			}
		}
	}

	//////////////////////////// 003_006_TC_05//////////////////////////

	@When("^click the account payable main module$")
	public void click_the_account_payable_main_module() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 3000, cancellationofcontract.getAccountspayable());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getAccountspayable());
	}

	@And("^click the eye icon of invoice bill booking$")
	public void click_the_eye_icon_of_invoice_bill_booking() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, invoiceBookingObj.accountPayable_InvoiceBooking_EyeButton());
		seleniumactions.getClickAndActionsHelper().clickOnElement(invoiceBookingObj.accountPayable_InvoiceBooking_EyeButton());

	}

	@And("^click the search icon in list view$")
	public void click_the_search_icon_in_list_view() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, cancellationofcontract.getApserachicon());
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getApserachicon());

	}

	@And("^search invoice type as Invoice Against Po$")
	public void search_invoice_type_as_invoice_against_po() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, invoiceBookingObj.searchInvoiceType());
		seleniumactions.getClickAndActionsHelper().clickOnElement(invoiceBookingObj.searchInvoiceType());
		invoiceBookingObj.searchInvoiceType().sendKeys(testData.get("ContracttypeAsInvoice"));
	}

	@And("^click the first eye icon in the list view of Active invoice bill$")
	public void click_the_first_eye_icon_in_the_list_view_of_active_invoice_bill() throws Throwable {
		String invoiceBillStatus = null;
		String beforexpath = "//datatable-row-wrapper[";
		String afterxpath = "]/datatable-body-row[1]/div[2]/datatable-body-cell[13]/div[1]/span[1]";
		for (int j = 1; j < 3; j++) {
			for (int i = 1; i < 9; i++) {
				// select active bill with expense as contract type
				seleniumactions.getWaitHelper().waitForElement(driver, 2000, driver.findElement(By.xpath(beforexpath + i + afterxpath)));
				invoiceBillStatus = driver.findElement(By.xpath(beforexpath + i + afterxpath)).getText();
				System.out.println(invoiceBillStatus);
				if (invoiceBillStatus.equalsIgnoreCase(testData.get("ContractStatus"))) {
					// seleniumactions.getWaitHelper().waitForElement(driver,2000,driver.findElement(By.xpath("(//datatable-body-cell[1]/div/ion-buttons/ion-button[1])["+i+"]")));
					driver.findElement(By.xpath("(//datatable-body-cell[1]/div/ion-buttons/ion-button[1])[" + i + "]")).click();
					break;
				}

			}
			if (invoiceBillStatus.equalsIgnoreCase(testData.get("ContractStatus"))) {
				break;
			}
			seleniumactions.getWaitHelper().waitForElement(driver, 2000, invoiceBookingObj.nextPageInListView());
			invoiceBookingObj.nextPageInListView().click();
		}
	}

	@And("^get the invoice number for DebitNote$")
	public void get_the_invoice_number_for_debitnote() throws Throwable {
		Thread.sleep(1000);
		javaScriptHelper.JavaScriptHelper(driver);
		InvoiceNo = (String) javaScriptHelper.executeScript("return document.getElementsByName('billNo')[0].value");
		System.out.println(InvoiceNo);
	}

	@Then("^click on add button$")
	public void click_on_add_button() throws InterruptedException {
		Thread.sleep(2000);
		// waithelper.waitForElement(driver, 3000,
		// bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_AddButton());
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_AddButton().click();
	}

	@And("^Fill the required fields in debit note$")
	public void fill_the_required_fields_in_debit_note() throws Throwable {
		waitHelper.waitForElement(driver, 3000, accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_ReceivableName());
		accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_ReceivableName().sendKeys("Purchase Return");
		accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_ReceivableName().sendKeys(Keys.ENTER);

		waitHelper.waitForElement(driver, 3000, accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_BPName());
		accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_BPName().sendKeys(testData.get("BPName"));
		accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_BPName().sendKeys(Keys.ENTER);

		accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_InvoiceNumber().click();
		waitHelper.waitForElement(driver, 3000, accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_InvoiceNumber());
		accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_InvoiceNumber().sendKeys(InvoiceNo);
		accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_InvoiceNumber().sendKeys(Keys.ENTER);

		waitHelper.waitForElement(driver, 3000, accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_DebitNoteAmount());
		clickAndActionHelper.doubleClick(accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_DebitNoteAmount());
		accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_DebitNoteAmount().sendKeys(testData.get("DebitNoteAmount"));

		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoView(accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_Description());
		accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_Description().click();
		accountsReceivable_DebitNoteObj.accountsReceivable_DebitNote_Description().sendKeys(testData.get("Description"));

//			waitHelper.waitForElement(driver, 3000, arapObj.ARAP_Debit_Cost());
//			arapObj.ARAP_Debit_Cost().click();
//			arapObj.ARAP_Debit_Cost().sendKeys("FINANCE");
//			arapObj.ARAP_Debit_Cost().sendKeys(Keys.ENTER);
	}

	@And("^Click save button$")
	public void click_save_button() throws Throwable {
		seleniumactions.getWaitHelper().waitForElement(driver, 2000, paymentSettlementObj.getSavebutton());
		seleniumactions.getClickAndActionsHelper().clickOnElement(paymentSettlementObj.getSavebutton());
	}

	@Then("^Goto The Notification Icon$")
	public void goto_the_notification_icon() throws Throwable {

		// ------------Maker Notification icon---------//
//		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_MakerNotification());
		waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_MakerNotification(), 20, 2);
		arapObj.ARAP_MakerNotification().click();
	}

	@And("^Store the Referance Id and Open the Record$")
	public void store_the_referance_id_and_open_the_record() throws Throwable {
		// -----------Action Icon-----------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_ReferanceId());
		String Referance_id = arapObj.ARAP_ReferanceId().getText();
		
		excelData.updateTestData(dataSetID, "ReferenceID", Referance_id);
		testData = excelData.getTestdata(dataSetID);
		
//		readerData.addReferanceData(Referance_id);
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_ActionButton());
		arapObj.ARAP_ActionButton().click();
	}

	@Then("^Click submit button and Enter Remark submit it$")
	public void click_submit_button_and_enter_remark_submit_it() throws Throwable {
		// -------------------------TO SUBMIT THE RECORD-----------------------------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_Submit());
		arapObj.ARAP_Submit().click();
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_Remark());
		arapObj.ARAP_Remark().sendKeys(testData.get("Remark"));
		waitHelper.waitForElement(driver, 5000, arapObj.ARAP_RemarkSubmit());
		arapObj.ARAP_RemarkSubmit().click();
		waitHelper.waitForElement(driver, 10000, arapObj.ARAP_ReviewerId());
		reviwerId = arapObj.ARAP_ReviewerId().getText();
		String trimmdReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmdReviewerID);
		StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
		String filanReviewerID = bufferedString.toString();
		// arapObj.arapObj_reviewer_id().getText());
//		json.addData(filanReviewerID);
		System.out.println(reviwerId);
		excelData.updateTestData(dataSetID, "ReviewerID", filanReviewerID);
		testData = excelData.getTestdata(dataSetID);
	}

	// REVIEWER
	@Given("^Navigate as a Reviewer$")
	public void navigate_as_a_reviewer() throws Throwable {
		// ---------LOGIN THE REVIEWER USER--------------//
		kubsLogin = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.logintoAzentioappReviewer("Reviewer", readerData.readdata());
	}

	@Then("^click on Notify icon$")
	public void click_on_notify_icon() throws Throwable {
		// -------------REVIEWER NOTIFICATION---------------//
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewerNotidicationIcon());
		reviewerObj.reviewerNotidicationIcon().click();
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewer_referanceid());
		javaScriptHelper.JavaScriptHelper(driver);
		referance_id = reviewerObj.reviewer_referanceid().getText();
		System.out.println("Referance_id:" + referance_id);
		Assert.assertTrue(reviewerObj.reviewer_referanceid().isDisplayed());
	}

	@And("^Click First record Action icon$")
	public void click_first_record_action_icon() throws Throwable {
		// -----------REVIEWER ACTION-------------//
		javaScriptHelper.JavaScriptHelper(driver);
		String befr_xpath = "//span[contains(text(),'";
		String aftr_xpath = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//div//ion-buttons//ion-button";
		waitHelper.waitForElement(driver, 2000, driver.findElement(By.xpath(befr_xpath + testData.get("ReferenceID") + aftr_xpath)));
		driver.findElement(By.xpath(befr_xpath + testData.get("ReferenceID") + aftr_xpath)).click();

		// reviewerObj.reviewer_action_button().click();
	}

	@Then("^Approve the record in Reviewer$")
	public void approve_the_record_in_reviewer() throws Throwable {
		// -----------------REVIEWER APPROVE---------------------//
//		readerData.addReferanceData(referance_id);
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewerApproveButton());
		reviewerObj.reviewerApproveButton().click();
	}

	@And("^Give Remark and Submit$")
	public void give_remark_and_submit() throws Throwable {
		// ---------------------SUBMIT THE REVIEWER RECORD-----------------------//
		waitHelper.waitForElement(driver, 5000, reviewerObj.reviewerAlertRemarks());
		reviewerObj.reviewerAlertRemarks().sendKeys(testData.get("Remark"));
		waitHelper.waitForElement(driver, 5000, reviewerObj.reviewerAlertSubmitButton());
		javaScriptHelper.JSEClick(reviewerObj.reviewerAlertSubmitButton());
		waitHelper.waitForElement(driver, 3000, reviewerObj.approvalStatus());
		String Notification = reviewerObj.approvalStatus().getText();
		System.out.println("Reviewer Notification: " + Notification);
		Assert.assertTrue(reviewerObj.approvalStatus().isDisplayed());
	}

	// CHECKER

	@Given("^Navigate as a Checker$")
	public void navigate_as_a_checker() throws Throwable {
		// ---------LOGIN THE CHECKER USER--------------//
		kubsLogin = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
	}

	@Then("^Click module security management$")
	public void click_module_security_management() throws Throwable {
		// --------------------CLICK ON SECURITY MANAGEMENTS-----------------------//
		waitHelper.waitForElement(driver, 3000, checkerObj.checkerSecurityManagement());
		checkerObj.checkerSecurityManagement().click();

		// ----------------------CLICK ON OPEN POOL-----------------------//
		waitHelper.waitForElement(driver, 3000, checkerObj.checkerActionIcon());
		checkerObj.checkerActionIcon().click();
	}

	@And("^Claim the Record in Checker$")
	public void claim_the_record_in_checker() throws Throwable {
		// -------------------------CLICK CLAIM OPTION-------------------------//
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		waitHelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath_claim)));
		driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath_claim)).click();
		waitHelper.waitForElement(driver, 2000, checkerObj.checker_alert_close());
		checkerObj.checker_alert_close().click();
	}

	@Then("^Goto the Checker notification Icon$")
	public void goto_the_checker_notification_icon() throws Throwable {
		// ----------------CHECKER NOTIFICATION-----------------------//
		javaScriptHelper = new JavascriptHelper();
		waitHelper.waitForElement(driver, 3000, checkerObj.checkerNotificationIcon());
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.JSEClick(checkerObj.checkerNotificationIcon());
	}

	@And("^Click the First Action Icon$")
	public void click_the_first_action_icon() throws Throwable {
		// ------------------CHECKER ACTION------------------//
		Thread.sleep(2000);
//			waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + readerData.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
//			waitHelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'" + readerData.readReferancedata()	+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(
				By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")).click();
	}

	@Then("^Approve the Record in checker stage$")
	public void approve_the_record_in_checker_stage() throws Throwable {
		// ------------------APPROVE THE RECORD----------------------//
		waitHelper.waitForElement(driver, 2000, checkerObj.checkerApproveButton());
		checkerObj.checkerApproveButton().click();
	}

	@And("^Give the Remark and Submit it$")
	public void give_the_remark_and_submit_it() throws Throwable {
		// -----------------------SUBMIT THE RECORD------------------------//
		waitHelper.waitForElement(driver, 2000, checkerObj.checkerRemarks());
		checkerObj.checkerRemarks().sendKeys(testData.get("Remark"));
		waitHelper.waitForElement(driver, 2000, checkerObj.checkersubmitButton());
		checkerObj.checkersubmitButton().click();
		waitHelper.waitForElement(driver, 3000, checkerObj.Popup_status());
		String Text = checkerObj.Popup_status().getText();
		System.out.println("Checker status: " + Text);
		Assert.assertTrue(checkerObj.Popup_status().isDisplayed());
	}

	@Then("^Enter Active Value In Debit Not Status$")
	public void enter_active_value_in_debit_not_status() throws Throwable {
		// ------------ACTIVE STATUS------------//
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoView(arapObj.accountsReceivable_DebitNote_Status());
		waitHelper.waitForElement(driver, 2000, arapObj.accountsReceivable_DebitNote_Status());
		arapObj.accountsReceivable_DebitNote_Status().click();
		arapObj.accountsReceivable_DebitNote_Status().sendKeys(testData.get("GRNStatus"));
	}
	
	@Then("^Click on Table Row First Eye Icon$")
	public void click_on_table_row_first_eye_icon() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.requestAndAllocation_Budget_TableEye());
		requestAndAllocation.requestAndAllocation_Budget_TableEye().click();
	}
	
	@And("^Give stored Business partner Name$")
	public void give_stored_business_partner_name() throws Throwable {
		waitHelper.waitForElement(driver, 2000, arapObj.accountsPayablePayementSettlementBpName());
		arapObj.accountsPayablePayementSettlementBpName().sendKeys(BPNumber);
		arapObj.accountsPayablePayementSettlementBpName().sendKeys(Keys.ENTER);

	}

	@And("^find the Debit reference number for Active Debit is availabe at the billing queue$")
	public void find_the_debit_reference_number_for_active_debit_is_availabe_at_the_billing_queue() throws Throwable {
		Thread.sleep(1000);
		javaScriptHelper.JavaScriptHelper(driver);
		// javascriptHelper.scrollDownByPixel();
		for (int i = 0; i <= 10; i++) {
			try {
				waitHelper.waitForElementVisible(driver.findElement(By.xpath("//div[contains(text(),'" + InvoiceNo + "')]")), 1000, 100);
				driver.findElement(By.xpath("//div[contains(text(),'" + InvoiceNo + "')]")).isDisplayed();
				// Assert.assertFalse(result);
				break;
			} catch (NoSuchElementException e) {
				// waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementNextRecord(),
				// 1000, 100);
				javaScriptHelper.scrollIntoView(arapObj.accountsPayablePayementSettlementNextRecord());

				arapObj.accountsPayablePayementSettlementNextRecord().click();

			}
			if (i == 10) {
				System.out.println("This is the end of the table invoice number is not availabe ");
				break;

			}
		}
	}

	@Then("^Click the Debit Note Checkbox As Tick$")
	public void click_the_debit_note_checkbox_as_tick() throws Throwable {
		// -------CHECKBOX CLICK----------------//
		String befr_xpath = "//div[contains(text(),'";
		String aftr_xpath = "')]//ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[3]//ion-checkbox";
		waitHelper.waitForElement(driver, 2000, driver.findElement(By.xpath(befr_xpath + InvoiceNo + aftr_xpath)));
		driver.findElement(By.xpath(befr_xpath + InvoiceNo + aftr_xpath)).click();
	}

	@When("^Enter the Description value$")
	public void enter_the_description_value() throws Throwable {
		// ---------ENTER THE DESCRIPTION----------//
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoView(arapObj.accountsPayableDescription());
		arapObj.accountsPayableDescription().click();
		arapObj.accountsPayableDescription().sendKeys(testData.get("Description"));
	}

	@And("^Save The Payment settlement Record$")
	public void save_the_payment_settlement_record() throws Throwable {
		// ---------SAVE THE RECORD---------//
		waitHelper.waitForElement(driver, 3000, arapObj.accountsPayableSaveButton());
		arapObj.accountsPayableSaveButton().click();

	}

	@Then("^Open the Adjustment ARAP module$")
	public void open_the_adjustment_arap_module() throws Throwable {
		// ----------adjustment ARAP---------//
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoView(arapObj.adjustment_ARAP());
//		waitHelper.waitForElement(driver, 2000, arapObj.adjustment_ARAP());
		waitHelper.waitForElementwithFluentwait(driver, arapObj.adjustment_ARAP());
		arapObj.adjustment_ARAP().click();
	}

	@And("^Click on Adjustment ARAP Eye Icon$")
	public void click_on_adjustment_arap_eye_icon() throws Throwable {
		// -----------ADJUSTMENT ARAP-------------//
		waitHelper.waitForElement(driver, 2000, arapObj.adjustmentViewButton());
		arapObj.adjustmentViewButton().click();
	}

	@Then("^Give The Business Partner$")
	public void give_the_business_partner() throws Throwable {
		// ----------BUSINESS PARTNER-----------//
		waitHelper.waitForElement(driver, 2000, arapObj.adjustmentBpName());
		arapObj.adjustmentBpName().click();
		arapObj.adjustmentBpName().sendKeys(BPNumber);
		arapObj.adjustmentBpName().sendKeys(Keys.ENTER);
	}

	@And("^Give The Adjustment Type$")
	public void give_the_adjustment_type() throws Throwable {
		// -----------ADJUSTMENTS TYPE-----------//
		waitHelper.waitForElement(driver, 2000, arapObj.adjustmentadjustmentType());
		arapObj.adjustmentadjustmentType().sendKeys(Keys.DOWN);
		arapObj.adjustmentadjustmentType().sendKeys(Keys.ENTER);
	}

	@Then("^Give the Adjustment Item Type$")
	public void give_the_adjustment_item_type() throws Throwable {
		// ----------ADJUSTMENTS ITEM TYPE------------//
		waitHelper.waitForElement(driver, 2000, arapObj.adjustmentItemType());
		arapObj.adjustmentItemType().click();
		arapObj.adjustmentItemType().sendKeys(testData.get("DebitType"));
		arapObj.adjustmentItemType().sendKeys(Keys.ENTER);
	}

	@And("^Give the Adjustment Ref No and Validate$")
	public void give_the_adjustment_ref_no_and_validate() throws Throwable {
		// -----------ADJUSTMENTS REF NO VALIDATE--------------//
		waitHelper.waitForElement(driver, 2000, arapObj.adjustmentAdjustmentReference());
		arapObj.adjustmentAdjustmentReference().sendKeys(DebitNo);

		try {
			waitHelper.waitForElement(driver, 2000, arapObj.adjustment_Save());
			arapObj.adjustment_Save().isDisplayed();
		} catch (ElementClickInterceptedException e) {
			System.out.println("The Approved Invoice Bill Record is Not Allowed for Cancellation");
		}
	}

	/////////////////////// ---DATA SET IDS---//////////////////////

	@Then("^select data set ID for accounting entries post debit note is cancelled$")
	public void select_data_set_id_for_accounting_entries_post_debit_note_is_cancelled() throws Throwable {
		dataSetID = "KUBS_AR_AP_UAT_003_006_TC_01_D1";
		testData = excelData.getTestdata(dataSetID);
	}

	@Then("^select data set ID for balance sheet post debit note is cancelled$")
	public void select_data_set_id_for_balance_sheet_post_debit_note_is_cancelled() throws Throwable {
		dataSetID = "KUBS_AR_AP_UAT_003_006_TC_02_D1";
		testData = excelData.getTestdata(dataSetID);
	}

	@Then("^select data set ID for accounts receivable report post debit note is cancelled$")
	public void select_data_set_id_for_accounts_receivable_report_post_debit_note_is_cancelled() throws Throwable {
		dataSetID = "KUBS_AR_AP_UAT_003_006_TC_03_D1";
		testData = excelData.getTestdata(dataSetID);
	}

	@Then("^select data set ID for Verify Cancelled Debit Note is not available for adjustment$")
	public void select_data_set_id_for_verify_cancelled_debit_note_is_not_available_for_adjustment() throws Throwable {
		dataSetID = "KUBS_AR_AP_UAT_003_006_TC_04_D1";
		testData = excelData.getTestdata(dataSetID);
	}
	
	@Then("^select data set ID to Verify Cancellation of Debit Note is not allowed if it has been adjusted$")
    public void select_data_set_id_to_verify_cancellation_of_debit_note_is_not_allowed_if_it_has_been_adjusted() throws Throwable {
		dataSetID = "KUBS_AR_AP_UAT_003_006_TC_05_D1";
		testData = excelData.getTestdata(dataSetID);
    }

}
