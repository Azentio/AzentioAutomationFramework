package stepdefinitions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
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
//	ARAP_ARandAPData arapData = jsonConfig.getARAPByName("ARAP");
	ARAP_ReportsObj arapReportObj = new ARAP_ReportsObj(driver);
	JsonDataReaderWriter json = new JsonDataReaderWriter();
	BrowserHelper browseHelper = new BrowserHelper(driver);
	AccountsReceivable_DebitNoteObj accountsReceivable_DebitNoteObj = new AccountsReceivable_DebitNoteObj(driver);
//	AccountsReceivable_DebitNoteTestDataType DebitNoteTestDataType= jsonConfig.getDebitNotedata("Maker");
	ACCOUNTSPAYABLE_PayementSettlementObj payementSettlementObj = new ACCOUNTSPAYABLE_PayementSettlementObj(driver);
	
	ExcelData excelData = new ExcelData("C:\\Users\\inindc00091\\git\\AzentioAutomationFramework\\ARAP_Excel_priyanka0612\\AzentioAutomationFramework_ARAP_Excel\\Test-data\\KUBS_TESTDATA_V1.xlsx",
			"ApprovingBillsByEmployeeData", "Data Set ID");
	Map<String, String> testData = new HashMap<>();
	String dataSetID;
	
	// ****************@KUBS_AR_AP_UAT_004_007_TC_01*******************//

	@Then("^Enter the Receivable Name as Advance to employee$")
	public void enter_the_receivable_name_as_advance_to_employee() throws Throwable {
		// -------ADVANCE TO EMPOLYEE----------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountReceviableAdvances_ReceivableName_TextBox());
		arapObj.accountReceviableAdvances_ReceivableName_TextBox().click();
		arapObj.accountReceviableAdvances_ReceivableName_TextBox().sendKeys(arapData.RecivableName1);
		arapObj.accountReceviableAdvances_ReceivableName_TextBox().sendKeys(Keys.ENTER);
	}

	@And("^Enter Business partner Value For Employee$")
	public void enter_business_partner_value_for_empolyee() throws Throwable {
		// -----------ENTER BUSINESS PARTNER--------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountReceviableAdvances_BusinessPatner_TextBox());
		arapObj.accountReceviableAdvances_BusinessPatner_TextBox().click();
		arapObj.accountReceviableAdvances_BusinessPatner_TextBox().sendKeys(arapData.Partner1);
		arapObj.accountReceviableAdvances_BusinessPatner_TextBox().sendKeys(Keys.ENTER);
	}

	@And("^Enter Payment mode$")
	public void enter_payment_mode() throws Throwable {
		// ----------ENTER PAYMENT AMOUNT---------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountReceviableAdvances_paymentMode_TextBox());
		arapObj.accountReceviableAdvances_paymentMode_TextBox().click();
		arapObj.accountReceviableAdvances_paymentMode_TextBox().sendKeys(arapData.ModeofPayment);
//		Thread.sleep(4000);
		waitHelper.waitForElementwithFluentwait(driver, arapObj.accountReceviableAdvances_paymentMode_TextBox());
		arapObj.accountReceviableAdvances_paymentMode_TextBox().sendKeys(Keys.ENTER);
	}

	@Then("^Enter Amount value$")
	public void enter_amount_value() throws Throwable {
		// ---------ENTER AMOUNT VALUE--------//
		waitHelper.waitForElement(driver, 2000, arapObj.amount_TextBox());
		arapObj.amount_TextBox().sendKeys(arapData.Amount);
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
		arapObj.accountReceviableAdvances_costCenter_TextBox().sendKeys(arapData.CostCenter);
		arapObj.accountReceviableAdvances_costCenter_TextBox().sendKeys(Keys.ENTER);
	}

	@And("^Enter Description value$")
	public void enter_description_value() throws Throwable {
		// --------ENTER DESCRIPTION------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountReceviableAdvances_description_TextBox());
		arapObj.accountReceviableAdvances_description_TextBox().click();
		arapObj.accountReceviableAdvances_description_TextBox().sendKeys(arapData.Description);
	}

	@Then("^Save the Advance Record$")
	public void save_the_advance_record() throws Throwable {
		// ------SAVE THE RECORD----------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountReceviableAdvances_Save_Button());
		arapObj.accountReceviableAdvances_Save_Button().click();
	}

	@Then("^Enter Active Value In Advance Status$")
	public void enter_active_value_in_advance_status() throws Throwable {
		// ---------ACTIVE STATUS------------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountsReceivable_Advance_ADVstatus());
		arapObj.accountsReceivable_Advance_ADVstatus().click();
		arapObj.accountsReceivable_Advance_ADVstatus().sendKeys(arapData.GRNStatus);
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

	@And("^Verify the Net Adjusted Value is correctly displayed$")
	public void verify_the_net_adjusted_value_is_correctly_displayed() throws Throwable {
		// --------VALIDATE THE NET PAYABLE ADJUSTMENT--------------//
		javaScriptHelper.JavaScriptHelper(driver);
		String NetadjAmount = (String) javaScriptHelper
				.executeScript("return document.getElementsByName('paymentAmt')[0].value");
		System.out.println("The Net Adjust Amount is : " + NetadjAmount);
	

	// ****************@KUBS_AR_AP_UAT_004_007_TC_02*************//

	@And("^Verify the TDS % & amount is correctly calculated & displayed$")
	public void verify_the_tds_amount_is_correctly_calculated_displayed() throws Throwable {
		// ----------VERIFY TDS VALUE------------//
		javaScriptHelper.JavaScriptHelper(driver);
		String TDS = (String) javaScriptHelper.executeScript("return document.getElementsByName('tdsAmt')[0].value");
		System.out.println("The TDS% & TDS amount is : " + TDS);
	}

	// ****************@KUBS_AR_AP_UAT_004_007_TC_03*************//

	@Then("^Enter Advance to employee and Active Value In Advance Status$")
	public void enter_advance_to_employee_and_active_value_in_advance_status() throws Throwable {
		// ---------ACTIVE STATUS------------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountsReceivable_Advance_ReceivableName());
		arapObj.accountsReceivable_Advance_ReceivableName().click();
		arapObj.accountsReceivable_Advance_ReceivableName().sendKeys(arapData.RecivableName1);
	}

	@Then("^Verify Accounting entries post payment settlement approval fo Advance to Employee$")
	public void verify_accounting_entries_post_payment_settlement_approval_fo_advance_to_employee() throws Throwable {
		javaScriptHelper.JavaScriptHelper(driver);
		Thread.sleep(1000);
		for (int i = 0; i <= 299; i++) {
			try {

				driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'" + arapData.PanNo1 + "')])[1]")).isDisplayed();

				driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'" + arapData.PanNo1 + "')])[1]"));
				String TransactionType = driver
						.findElement(By.xpath(
								"(//datatable-body-cell[1]//span[contains(text(),' " + arapData.PanNo1 + " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[5]//span)[1]"))
						.getText();
				System.out.println("TransactionType is " + TransactionType);
				String amount = driver
						.findElement(By.xpath(
								"(//datatable-body-cell[1]//span[contains(text(),' " + arapData.PanNo1 + " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[6]//span)[1]"))
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

				driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'" + arapData.PanNo1 + "')])[2]")).isDisplayed();

				driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'" + arapData.PanNo1 + "')])[1]"));
				String TransactionType = driver
						.findElement(By.xpath(
								"(//datatable-body-cell[1]//span[contains(text(),' " + arapData.PanNo1 + " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[5]//span)[2]"))
						.getText();
				System.out.println("TransactionType is " + TransactionType);
				String amount = driver
						.findElement(By.xpath(
								"(//datatable-body-cell[1]//span[contains(text(),' " + arapData.PanNo1 + " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[6]//span)[2]"))
						.getText();
				System.out.println("Amount is " + amount);
				break;

			} catch (NoSuchElementException e) {
				javaScriptHelper.scrollIntoView(arapObj.accountsPayablePayementSettlementNextRecord());
				arapObj.accountsPayablePayementSettlementNextRecord().click();
			}

		}
	}

	// ****************@KUBS_AR_AP_UAT_004_007_TC_04*************//

	@And("^Enter Advance to employee Pan Number$")
	public void enter_advance_to_employee_pan_number() throws Throwable {
		// -------ENTER ADVANCE TO EMPOLYEE PAN NO----------//
		arapObj.accountsReceivable_Advance_ADVNostatus().click();
		arapObj.accountsReceivable_Advance_ADVNostatus().sendKeys(arapData.PanNo1);
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
}
