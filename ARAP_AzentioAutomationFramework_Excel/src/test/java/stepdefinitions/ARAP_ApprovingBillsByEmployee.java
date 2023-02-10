package stepdefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import dataProvider.ConfigFileReader;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
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
import pageobjects.BUDGET_RequestAndAllocationObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;

public class ARAP_ApprovingBillsByEmployee extends BaseClass {

	WebDriver driver = BaseClass.driver;
	KUBS_Login kubsLogin;
	ConfigFileReader configFileReader = new ConfigFileReader();
	WaitHelper waitHelper = new WaitHelper(driver);
	KUBS_Login login = new KUBS_Login(driver);
	JavascriptHelper javaScriptHelper = new JavascriptHelper();
	DropDownHelper dropDownHelper = new DropDownHelper(driver);
//	JsonConfig jsonConfig = new JsonConfig();
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
	ARAP_ReportsObj arapReportObj = new ARAP_ReportsObj(driver);
	JsonDataReaderWriter json = new JsonDataReaderWriter();
	BrowserHelper browseHelper = new BrowserHelper(driver);
	BUDGET_RequestAndAllocationObj requestAndAllocation = new BUDGET_RequestAndAllocationObj(driver);
	ArAp_BalanceSheetReportObj arAp_BalanceSheetReportObj = new ArAp_BalanceSheetReportObj(driver);
	AccountsReceivable_DebitNoteObj accountsReceivable_DebitNoteObj = new AccountsReceivable_DebitNoteObj(driver);
	ACCOUNTSPAYABLE_PayementSettlementObj payementSettlementObj = new ACCOUNTSPAYABLE_PayementSettlementObj(driver);

	ExcelData excelData = new ExcelData("C:\\Users\\ININDC00091\\git\\AzentioAutomationFramework\\DeveshFW_Excel\\ARAP_AzentioAutomationFramework_Excel\\Test-data\\KUBS_TESTDATA_V1.xlsx",
			"ApprovingBillsByEmployeeData", "Data Set ID");
	Map<String, String> testData = new HashMap<>();
	String dataSetID;

	// ****************@KUBS_AR_AP_UAT_004_007_TC_01*******************//

	@Then("^Enter the Receivable Name as Advance to employee$")
	public void enter_the_receivable_name_as_advance_to_employee() throws Throwable {
		// -------ADVANCE TO EMPOLYEE----------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountReceviableAdvances_ReceivableName_TextBox());
		arapObj.accountReceviableAdvances_ReceivableName_TextBox().click();
		arapObj.accountReceviableAdvances_ReceivableName_TextBox().sendKeys(testData.get("RecivableName"));
		arapObj.accountReceviableAdvances_ReceivableName_TextBox().sendKeys(Keys.ENTER);
	}

	@And("^Enter Business partner Value For Employee$")
	public void enter_business_partner_value_for_empolyee() throws Throwable {
		// -----------ENTER BUSINESS PARTNER--------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountReceviableAdvances_BusinessPatner_TextBox());
		arapObj.accountReceviableAdvances_BusinessPatner_TextBox().click();
		arapObj.accountReceviableAdvances_BusinessPatner_TextBox().sendKeys(testData.get("Partner"));
		arapObj.accountReceviableAdvances_BusinessPatner_TextBox().sendKeys(Keys.ENTER);
	}

	@And("^Enter Payment mode$")
	public void enter_payment_mode() throws Throwable {
		// ----------ENTER PAYMENT AMOUNT---------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountReceviableAdvances_paymentMode_TextBox());
		arapObj.accountReceviableAdvances_paymentMode_TextBox().click();
		arapObj.accountReceviableAdvances_paymentMode_TextBox().sendKeys(testData.get("ModeofPayment"));
//		Thread.sleep(4000);
		waitHelper.waitForElementwithFluentwait(driver, arapObj.accountReceviableAdvances_paymentMode_TextBox());
		arapObj.accountReceviableAdvances_paymentMode_TextBox().sendKeys(Keys.ENTER);
	}

	@Then("^Enter Amount value$")
	public void enter_amount_value() throws Throwable {
		// ---------ENTER AMOUNT VALUE--------//
		waitHelper.waitForElement(driver, 2000, arapObj.amount_TextBox());
		arapObj.amount_TextBox().sendKeys(testData.get("ModeofPayment"));
//		Thread.sleep(4000);
	}

	@And("^Choose Needed Currancy$")
	public void choose_needed_currancy() throws Throwable {
		// --------ENTER NEEDED CURRENCY-----------//
//		waitHelper.waitForElement(driver, 2000, arapObj.accountReceviableAdvances_currency_TextBox());
		waitHelper.waitForElementwithFluentwait(driver, arapObj.accountReceviableAdvances_currency_TextBox());
		arapObj.accountReceviableAdvances_currency_TextBox().sendKeys("INR");
		arapObj.accountReceviableAdvances_currency_TextBox().sendKeys(Keys.ENTER);
	}

	@Then("^Choose cost center$")
	public void choose_cost_center() throws Throwable {
		// --------ENTER COST CENTER-----------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountReceviableAdvances_costCenter_TextBox());
		arapObj.accountReceviableAdvances_costCenter_TextBox().click();
		arapObj.accountReceviableAdvances_costCenter_TextBox().sendKeys(testData.get("CostCenter"));
		arapObj.accountReceviableAdvances_costCenter_TextBox().sendKeys(Keys.ENTER);
	}

	@And("^Enter Description value$")
	public void enter_description_value() throws Throwable {
		// --------ENTER DESCRIPTION------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountReceviableAdvances_description_TextBox());
		arapObj.accountReceviableAdvances_description_TextBox().click();
		arapObj.accountReceviableAdvances_description_TextBox().sendKeys(testData.get("Description"));
	}
	
	@And("^Store the Referance Id and Open the adjusted Record$")
	public void store_the_referance_id_and_open_the_adjusted_record() throws Throwable {
		// -----------Action Icon-----------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_ReferanceId());
		String Referance_id = arapObj.ARAP_ReferanceId().getText();
		
		excelData.updateTestData(dataSetID, "ReferenceID", Referance_id);
		testData = excelData.getTestdata(dataSetID);
		
//		readerData.addReferanceData(Referance_id);
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_ActionButton());
		arapObj.ARAP_ActionButton().click();
	}
	
	@Then("^Save the Advance Record$")
	public void save_the_advance_record() throws Throwable {
		// ------SAVE THE RECORD----------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountReceviableAdvances_Save_Button());
		arapObj.accountReceviableAdvances_Save_Button().click();
	}
	
	@And("^Click First record of advance to employee Action icon$")
	public void click_first_record_of_advance_to_employee_action_icon() throws Throwable {
		// -----------REVIEWER ACTION-------------//
		javaScriptHelper.JavaScriptHelper(driver);
		String befr_xpath = "//span[contains(text(),'";
		String aftr_xpath = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//div//ion-buttons//ion-button";
		waitHelper.waitForElement(driver, 2000, driver.findElement(By.xpath(befr_xpath + testData.get("ReferenceID") + aftr_xpath)));
		driver.findElement(By.xpath(befr_xpath + testData.get("ReferenceID") + aftr_xpath)).click();

		// reviewerObj.reviewer_action_button().click();
	}

	@Then("^Enter Active Value In Advance Status$")
	public void enter_active_value_in_advance_status() throws Throwable {
		// ---------ACTIVE STATUS------------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountsReceivable_Advance_ADVstatus());
		arapObj.accountsReceivable_Advance_ADVstatus().click();
		arapObj.accountsReceivable_Advance_ADVstatus().sendKeys(testData.get("GRNStatus"));
	}

	@And("^find the Advance reference number and Net Adjustable value in the billing queue$")
	public void find_the_advance_reference_number_and_net_adjustable_value_in_the_billing_queue() throws Throwable {
		Thread.sleep(1000);
		javaScriptHelper.JavaScriptHelper(driver);
		// javascriptHelper.scrollDownByPixel();
		javaScriptHelper.scrollIntoView(arapObj.accountsPayable_paymentSettlementFooter());
		for (int i = 0; i <= 1; i++) {
			try {
				waitHelper.waitForElementVisible(driver.findElement(By.xpath("//div[contains(text(),'" + ADVNumber + "')]")), 1000, 100);
				driver.findElement(By.xpath("//div[contains(text(),'" + ADVNumber + "')]")).isDisplayed();
				break;

			} catch (NoSuchElementException e) {
				// waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementNextRecord(),
				// 1000, 100);
				arapObj.accountsPayablePayementSettlementNextRecord().click();

			}
			if (i == 1) {
				System.out.println("This is the end of the table  number is not availabe ");
				break;

			}
		}
	}

	@Then("^Click the Checkbox As Tick$")
	public void click_the_checkbox_as_tick() throws Throwable {
		// -------CHECKBOX CLICK----------------//
		String befr_xpath = "//div[contains(text(),'";
		String aftr_xpath = "')]//ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[3]//ion-checkbox";
		waitHelper.waitForElement(driver, 5000, driver.findElement(By.xpath(befr_xpath + ADVNumber + aftr_xpath)));
		driver.findElement(By.xpath(befr_xpath + ADVNumber + aftr_xpath)).click();
	}

	@And("^Get The Business Partner and Advance Number$")
	public void get_the_business_partner_and_advance_number() throws Throwable {
//		waitHelper.waitForElement(driver, 2000, arapObj.accountsReceivable_Advance_GetBp());
		waitHelper.waitForElementwithFluentwait(driver, arapObj.accountsReceivable_Advance_GetBp());
		BPNumber = arapObj.accountsReceivable_Advance_GetBp().getText();
		System.out.println(BPNumber);

		javaScriptHelper.JavaScriptHelper(driver);
		ADVNumber = (String) javaScriptHelper.executeScript("return document.getElementsByName('advanceNo')[1].value");
		System.out.println(ADVNumber);

		javaScriptHelper.JavaScriptHelper(driver);
		ADVAmount = (String) javaScriptHelper.executeScript("return document.getElementsByClassName('form__field ng-untouched ng-pristine ng-valid')[0].value");
		System.out.println(ADVAmount);
	}
	
	@And("^Give the stored Business partner Name$")
	public void give_the_stored_business_partner_name() throws Throwable {
		waitHelper.waitForElement(driver, 2000, arapObj.accountsPayablePayementSettlementBpName());
		arapObj.accountsPayablePayementSettlementBpName().sendKeys(BPNumber);
		arapObj.accountsPayablePayementSettlementBpName().sendKeys(Keys.ENTER);

	}
	
	@Then("^Choose the value date as System current date$")
	public void choose_the_value_date_as_system_current_date() throws Throwable {
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

	
	@Given("^User navigate to the kubs url and login as a reviewer user$")
	public void user_navigate_to_the_kubs_url_and_login_as_a_reviewer_user() throws IOException, ParseException {
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.logintoAzentioappReviewer("Reviewer", testData.get("ReviewerID"));
	}
	
	@Given("^User navigate to the kubs url and login as a checker user$")
    public void user_navigate_to_the_kubs_url_and_login_as_a_checker_user() throws InterruptedException {
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioAppAsChecker("Checker");
    }
	
	@And("^Verify the Net Adjusted Value is correctly displayed$")
	public void verify_the_net_adjusted_value_is_correctly_displayed() throws Throwable {
		// --------VALIDATE THE NET PAYABLE ADJUSTMENT--------------//
		javaScriptHelper.JavaScriptHelper(driver);
		String NetadjAmount = (String) javaScriptHelper
				.executeScript("return document.getElementsByName('paymentAmt')[0].value");
		System.out.println("The Net Adjust Amount is : " + NetadjAmount);
	}
	
	@And("^Give reviewer Remark and Submit$")
	public void give_reviewer_remark_and_submit() throws Throwable {
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
	
	@And("^Click the First Action Icon from checker$")
	public void click_the_first_action_icon_from_checker() throws Throwable {
		// ------------------CHECKER ACTION------------------//
		Thread.sleep(2000);
//			waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + readerData.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
//			waitHelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'" + readerData.readReferancedata()	+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(
				By.xpath("//span[contains(text(),'" + readerData.readReferancedata() + "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")).click();
	}
	
	@Then("^Enter payment option for verify$")
	public void enter_payment_option_for_verify() throws Throwable {
		// -----------ENTER PAYMENT OPTION----------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountsPayablePayementSettlementPaymentOption());
		arapObj.accountsPayablePayementSettlementPaymentOption().sendKeys(testData.get("PaymentOption"));
		arapObj.accountsPayablePayementSettlementPaymentOption().sendKeys(Keys.ENTER);
	}

	// ****************@KUBS_AR_AP_UAT_004_007_TC_02*************//

	@And("^Verify the TDS % & amount is correctly calculated & displayed$")
	public void verify_the_tds_amount_is_correctly_calculated_displayed() throws Throwable {
		// ----------VERIFY TDS VALUE------------//
		javaScriptHelper.JavaScriptHelper(driver);
		String TDS = (String) javaScriptHelper.executeScript("return document.getElementsByName('tdsAmt')[0].value");
		System.out.println("The TDS% & TDS amount is : " + TDS);
	}

	// ****************@KUBS_AR_AP_UAT_004_007_TC_03*************//
	
	@Then("^Fill branch details for report$")
	public void fill_branch_details_for_report() {

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
	
	@Then("^Enter Advance to employee and Active Value In Advance Status$")
	public void enter_advance_to_employee_and_active_value_in_advance_status() throws Throwable {
		// ---------ACTIVE STATUS------------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountsReceivable_Advance_ReceivableName());
		arapObj.accountsReceivable_Advance_ReceivableName().click();
		arapObj.accountsReceivable_Advance_ReceivableName().sendKeys(testData.get("ReceivableName"));
	}

//	@Then("^Verify Accounting entries post payment settlement approval fo Advance to Employee$")
//	public void verify_accounting_entries_post_payment_settlement_approval_fo_advance_to_employee() throws Throwable {
//		javaScriptHelper.JavaScriptHelper(driver);
//		Thread.sleep(1000);
//		for (int i = 0; i <= 299; i++) {
//			try {
//
//				driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'" + arapData.PanNo1 + "')])[1]")).isDisplayed();
//
//				driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'" + arapData.PanNo1 + "')])[1]"));
//				String TransactionType = driver
//						.findElement(By.xpath(
//								"(//datatable-body-cell[1]//span[contains(text(),' " + arapData.PanNo1 + " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[5]//span)[1]"))
//						.getText();
//				System.out.println("TransactionType is " + TransactionType);
//				String amount = driver
//						.findElement(By.xpath(
//								"(//datatable-body-cell[1]//span[contains(text(),' " + arapData.PanNo1 + " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[6]//span)[1]"))
//						.getText();
//				System.out.println("Amount is " + amount);
//				break;
//
//			} catch (NoSuchElementException e) {
//				javaScriptHelper.scrollIntoView(arapObj.accountsPayablePayementSettlementNextRecord());
//				arapObj.accountsPayablePayementSettlementNextRecord().click();
//			}
//		}
//		for (int i = 0; i <= 299; i++) {
//			try {
//
//				driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'" + arapData.PanNo1 + "')])[2]")).isDisplayed();
//
//				driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'" + arapData.PanNo1 + "')])[1]"));
//				String TransactionType = driver
//						.findElement(By.xpath(
//								"(//datatable-body-cell[1]//span[contains(text(),' " + arapData.PanNo1 + " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[5]//span)[2]"))
//						.getText();
//				System.out.println("TransactionType is " + TransactionType);
//				String amount = driver
//						.findElement(By.xpath(
//								"(//datatable-body-cell[1]//span[contains(text(),' " + arapData.PanNo1 + " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[6]//span)[2]"))
//						.getText();
//				System.out.println("Amount is " + amount);
//				break;
//
//			} catch (NoSuchElementException e) {
//				javaScriptHelper.scrollIntoView(arapObj.accountsPayablePayementSettlementNextRecord());
//				arapObj.accountsPayablePayementSettlementNextRecord().click();
//			}
//
//		}
//	}

	@And("^Verify the Net payable amount is correctly calculated & displayed$")
	public void verify_the_net_payable_amount_is_correctly_calculated_displayed() throws Throwable {
		// ------VERIFY THE NET PAYABLE AMOUNT-------//
		javaScriptHelper.JavaScriptHelper(driver);
		String Netpay = (String) javaScriptHelper.executeScript("return document.getElementsByName('nettAmt')[0].value");
		System.out.println("The Net Payable Amount is : " + Netpay);
	}

	// ****************@KUBS_AR_AP_UAT_004_007_TC_04*************//

	@And("^Enter Advance to employee Pan Number$")
	public void enter_advance_to_employee_pan_number() throws Throwable {
		// -------ENTER ADVANCE TO EMPOLYEE PAN NO----------//
		arapObj.accountsReceivable_Advance_ADVNostatus().click();
		arapObj.accountsReceivable_Advance_ADVNostatus().sendKeys(testData.get("PanNo"));
	}

	// ****************@KUBS_AR_AP_UAT_004_007_TC_05*************//

	@Then("^Click on Report button$")
	public void click_on_repoet_button() throws InterruptedException {
//	 Thread.sleep(2000);
//	  waithelper.waitForElement(driver, 2000,  arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_ReportButton());
		waitHelper.waitForElementwithFluentwait(driver, arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_ReportButton());
		arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_ReportButton().click();
	}

	@Then("^Click on Financial Reporting tab$")
	public void click_on_financial_reporting_tab() {
		waitHelper.waitForElement(driver, 2000, arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_FinancialReport());
		arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_FinancialReport().click();
	}

	@Then("^Click on Balance Sheet Report edit button$")
	public void click_on_balance_sheet_report_edit_button() {
//		waitHelper.waitForElement(driver, 2000, arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_BalanceSheetReport());
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoView(arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_BalanceSheetReport());
		waitHelper.waitForElementwithFluentwait(driver, arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_BalanceSheetReport());
		arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_BalanceSheetReport().click();
	}

	@Then("^Select date in calendar$")
	public void select_date_in_calendar() throws InterruptedException {
		waitHelper.waitForElement(driver, 2000, arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_CalendarButton());
		arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_CalendarButton().click();
		javaScriptHelper.JavaScriptHelper(driver);
		Thread.sleep(2000);
		for(int i=0;i<=30;i++) {
			try {
				// span[contains(text(),'Oct 2022')]
//			waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//span[contains(text(),'"+arAp_BalanceSheetReportTestDataType.Month+" "+arAp_BalanceSheetReportTestDataType.Year+"')]")));
				waitHelper.waitForElementwithFluentwait(driver,
						driver.findElement(By.xpath("//span[text()='" + testData.get("Month") + " " + testData.get("Year") + "']")));
				WebElement monthAndYear = driver.findElement(By.xpath("//span[text()='" + testData.get("Month") + " " + testData.get("Year") + "']"));
//			Thread.sleep(2000);
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_NextMonth().click();

			}
		}
		// td[@aria-label='November 1, 2022']/span
		WebElement FinalDay = driver.findElement(By.xpath(
				"//td[@aria-label='" + testData.get("FullMonth") + " " + testData.get("Date") + ", " + testData.get("Year") + "']/span"));
		clickAndActionHelper.doubleClick(FinalDay);
	}

	@Then("^Click on the View button$")
	public void click_on_the_view_button() {
//		waitHelper.waitForElement(driver, 2000, arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_ViewButton());
		waitHelper.waitForElementwithFluentwait(driver, arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_ViewButton());
		arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_ViewButton().click();
	}
	// ****************@KUBS_AR_AP_UAT_004_007_TC_06*************//

	@When("^Store the Advance Number$")
	public void store_the_advance_number() throws Throwable {
		// -----store the payment settlement approved Ref No--------//

		ADVNumber = arapObj.paymentSettlementRecentlyApprovedInvoiceNUmber().getText();
		System.out.println(ADVNumber);
	}

	@And("^Verify the Accounts Payable Report post payment settlement approval$")
	public void verify_the_accounts_payable_report_post_payment_settlement_approval() throws Throwable {
		browseHelper.SwitchToWindow(1);
		javaScriptHelper.JavaScriptHelper(driver);
//		while (true) {
//			Thread.sleep(2000);
//			try {
//				javaScriptHelper
//						.scrollIntoView(driver.findElement(By.xpath("//div[contains(text(),'" + ADVNumber + "')]")));
//				driver.findElement(By.xpath("//div[contains(text(),'" + ADVNumber + "')]")).isDisplayed();
//				break;
//			} catch (NoSuchElementException e) {
//				waitHelper.waitForElement(driver, 3000, arapReportObj.ARAP_Report_Nextbtn());
//				arapReportObj.ARAP_Report_Nextbtn().click();
//			}
//		}
		browseHelper.switchToParentWithChildClose();
	}

	@And("^Click main module Reports$")
	public void click_main_module_reports() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.Reports_Bud_Creation_ReportModule());
		requestAndAllocation.Reports_Bud_Creation_ReportModule().click();
	}
	
	@Then("^Give Current business Date for approving bills by employee$")
	public void give_current_business_date_for_approving_bills_by_employee() throws Throwable {
		// ----------CLICK ON DATE--------------//
		arapReportObj.ARAP_Report_Module_Date().click();
		javaScriptHelper.JavaScriptHelper(driver);
		while (true) {
			try {

				waitHelper.waitForElement(driver, 3000, driver.findElement(
						By.xpath("//span[contains(text(),'" + testData.get("Month") + " " + testData.get("Year") + "')]")));
				driver.findElement(
						By.xpath("//span[contains(text(),'" + testData.get("Month") + " " + testData.get("Year") + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				arapObj.ARAPNextMonth().click();

			}
		}
		waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='"
				+ testData.get("FullMonth") + " " + testData.get("Date") + ", " + testData.get("Year") + "']/span")));
		WebElement Click = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth") + " "
				+ testData.get("Date") + ", " + testData.get("Year") + "']/span"));

		clickAndActionHelper.doubleClick(Click);
	}


//	@And("^Give Accounts Payable Status$")
//	public void give_accounts_payable_status() throws Throwable {
//		// --------ACCOUNTS PAYABLE STATUS------//
//		arapReportObj.ARAP_Report_Status().sendKeys(Keys.DOWN);
//		arapReportObj.ARAP_Report_Status().sendKeys(Keys.ENTER);
//	}

	// *************@ KUBS_AR_AP_UAT_004_007_TC_07***************//

	@Then("^Click sub module Accounts Receivable Report$")
	public void click_sub_module_accounts_receivable_report() throws Throwable {
		// ----------ACCOUNTS RECEIVABLE EYE----------//
		arapReportObj.ARAP_Report_Acc_Rec_Module_Edit().click();
	}

	@And("^Verify the Accounts Receivable Report post payment settlement approval$")
	public void verify_the_accounts_receivable_report_post_payment_settlement_approval() throws Throwable {
		browseHelper.SwitchToWindow(1);
		javaScriptHelper.JavaScriptHelper(driver);
//		while (true) {
//			Thread.sleep(2000);
//			try {
//				javaScriptHelper
//						.scrollIntoView(driver.findElement(By.xpath("//div[contains(text(),'" + ADVNumber + "')]")));
//				driver.findElement(By.xpath("//div[contains(text(),'" + ADVNumber + "')]")).isDisplayed();
//				break;
//			} catch (NoSuchElementException e) {
//				waitHelper.waitForElement(driver, 3000, arapReportObj.ARAP_Report_Nextbtn());
//				arapReportObj.ARAP_Report_Nextbtn().click();
//			}
//		}
		browseHelper.switchToParentWithChildClose();
	}

	///////////////////////////////////////////////////////

	@Then("^select data set ID for advance to employee is adjusted against the selected bill$")
	public void select_data_set_id_for_advance_to_employee_is_adjusted_against_the_selected_bill() throws Throwable {
		dataSetID = "KUBS_AR_AP_UAT_004_007_TC_01_D1";
		testData = excelData.getTestdata(dataSetID);
	}

	@Then("^select data set ID for Verify TDS percentage and amount is correctly calculated$")
	public void select_data_set_id_for_verify_tds_percentage_and_amount_is_correctly_calculated() throws Throwable {
		dataSetID = "KUBS_AR_AP_UAT_004_007_TC_02_D1";
		testData = excelData.getTestdata(dataSetID);
	}

	@Then("^select data set ID for net payable amount is correctly calculated$")
	public void select_data_set_id_for_net_payable_amount_is_correctly_calculated() throws Throwable {
		dataSetID = "KUBS_AR_AP_UAT_004_007_TC_03_D1";
		testData = excelData.getTestdata(dataSetID);
	}

	@Then("^select data set ID for verify balance sheet post payment setlement approval$")
	public void select_data_set_id_for_verify_balance_sheet_post_payment_setlement_approval() throws Throwable {
		dataSetID = "KUBS_AR_AP_UAT_004_007_TC_05_D1";
		testData = excelData.getTestdata(dataSetID);
	}

	@Then("^select data set ID for accounts payable report post payment settlement approval$")
	public void select_data_set_id_for_accounts_payable_report_post_payment_settlement_approval() throws Throwable {
		dataSetID = "KUBS_AR_AP_UAT_004_007_TC_06_D1";
		testData = excelData.getTestdata(dataSetID);
	}

	@Then("^select data set ID for verify accounts receivalable report post payment settlement$")
	public void select_data_set_id_for_verify_accounts_receivalable_report_post_payment_settlement() throws Throwable {
		dataSetID = "KUBS_AR_AP_UAT_004_007_TC_07_D1";
		testData = excelData.getTestdata(dataSetID);
	}
}
