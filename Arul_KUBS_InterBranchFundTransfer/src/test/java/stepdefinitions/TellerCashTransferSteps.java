package stepdefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotSame;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.ARAP_ARandAPObj;
import pageobjects.GL_Accounting_Setup_Obj;
import pageobjects.InterBranchFundTransferObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.Petty_Cash_Obj;
import pageobjects.TellerCashTransferObj;
import resources.BaseClass;
import resources.ExcelData;

public class TellerCashTransferSteps {
	WebDriver driver = BaseClass.driver;
	KUBS_Login kubsLogin;
	ConfigFileReader configFileReader = new ConfigFileReader();
	ClicksAndActionsHelper clickAndActionHelper = new ClicksAndActionsHelper(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	JavascriptHelper javaScriptHelper = new JavascriptHelper();
	DropDownHelper dropDownHelper = new DropDownHelper(driver);
	BrowserHelper browserHelper = new BrowserHelper(driver);
	InterBranchFundTransferObj ibftObj = new InterBranchFundTransferObj(driver);
	TellerCashTransferObj tctobj = new TellerCashTransferObj(driver);
	ARAP_ARandAPObj arapObj = new ARAP_ARandAPObj(driver);
	Petty_Cash_Obj pettyCashObj = new Petty_Cash_Obj(driver);
	GL_Accounting_Setup_Obj accSetupObj = new GL_Accounting_Setup_Obj(driver);
	String excelPath = System.getProperty("user.dir") + "\\Test-data\\KUBSTestData.xlsx";
	ExcelData excelData = new ExcelData(excelPath, "TellerCashTransfer", "Data Set ID");
	private Map<String, String> testdata;
	KUBS_CheckerObj checkerObj = new KUBS_CheckerObj(driver);
	String transactionrefno = "";
	
	@And("^Update test data for TCT_001$")
	public void update_test_data_for_tct001() throws Throwable {
		testdata = excelData.getTestdata("KUBS_TCT_001_D1");
	}
	@And("Navigate to Petty cash section")
	public void navigate_to_petty_cash_section() {    
		waitHelper.waitForElementToVisibleWithFluentWait(driver, tctobj.PettyCashModule(), 5, 500);
		tctobj.PettyCashModule().click();
	}
	@And("Navigate to Teller cash transfer view list")
	public void navigate_to_teller_cash_transfer_view_list() {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, tctobj.TellerCashTransferViewList(), 5, 500);
		tctobj.TellerCashTransferViewList().click();
	}
	@And("Click on Add button in teller cash transfer view list")
	public void click_on_add_button_in_teller_cash_transfer_view_list() {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, tctobj.TellerCashtransfer_AddIcon(), 5, 500);
		tctobj.TellerCashtransfer_AddIcon().click();
	}
	@And("Select the value in Target teller ID field")
	public void select_the_value_in_target_teller_id_field() {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, tctobj.TellerCashtransfer_TargetTellerID(), 5,
				500);
		tctobj.TellerCashtransfer_TargetTellerID().click();
		tctobj.TellerCashtransfer_TargetTellerID().sendKeys(testdata.get("TargetTellerId"));
		tctobj.TellerCashtransfer_TargetTellerID().sendKeys(Keys.DOWN);
		tctobj.TellerCashtransfer_TargetTellerID().sendKeys(Keys.ENTER);
	}
	@And("Select the value in Denom Code field")
	public void select_the_value_in_denom_code_field() {    
		waitHelper.waitForElementToVisibleWithFluentWait(driver, tctobj.TellerCashtransfer_DenomCode(), 5,
				500);
		tctobj.TellerCashtransfer_DenomCode().click();
		tctobj.TellerCashtransfer_DenomCode().sendKeys(testdata.get("DenomCode"));
		tctobj.TellerCashtransfer_DenomCode().sendKeys(Keys.DOWN);
		tctobj.TellerCashtransfer_DenomCode().sendKeys(Keys.ENTER);
	}
	@And("Select the value in Denom name field")
	public void select_the_value_in_denom_name_field() {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, tctobj.TellerCashtransfer_DenomName(), 5,
				500);
		tctobj.TellerCashtransfer_DenomName().click();
		tctobj.TellerCashtransfer_DenomName().sendKeys(testdata.get("DenomName"));
		tctobj.TellerCashtransfer_DenomName().sendKeys(Keys.DOWN);
		tctobj.TellerCashtransfer_DenomName().sendKeys(Keys.ENTER);
	}
	@And("Enter the value in Quantity field")
	public void enter_the_value_in_quantity_field() {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, tctobj.TellerCashtransfer_Quantity(), 5, 500);
		tctobj.TellerCashtransfer_Quantity().click();
		tctobj.TellerCashtransfer_Quantity().sendKeys(Keys.DELETE);
		tctobj.TellerCashtransfer_Quantity().sendKeys(testdata.get("Quantity"));
	}
	@And("Store the Referance Id and Open the Record for teller cash transfer")
	public void store_the_referance_id_and_open_the_record_for_teller_cash_transfer() {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, accSetupObj.TellerCashTransfer_ReferanceId(), 30,
				2);
		String Referance_id = accSetupObj.TellerCashTransfer_ReferanceId().getText();
		excelData.updateTestData(testdata.get("Data Set ID"), "Reference ID", Referance_id);
		System.out.println("Data Set ID " + testdata.get("Data Set ID"));
		System.out.println(Referance_id);
		waitHelper.waitForElementToVisibleWithFluentWait(driver, accSetupObj.TellerCashTransfer_ActionButton(), 30,
				2);
		accSetupObj.TellerCashTransfer_ActionButton().click();
	}
	@Then("Click submit button and Enter Remark submit it for teller cash transfer")
	public void click_submit_button_and_enter_remark_submit_it_for_teller_cash_transfer() {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_Submit(), 30, 2);
		arapObj.ARAP_Submit().click();
		waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_Remark(), 30, 2);
		arapObj.ARAP_Remark().sendKeys(testdata.get("MakerSubmitRemarks"));
		// waitHelper.waitForElementToVisibleWithFluentWait(driver,
		// arapObj.ARAP_RemarkSubmit(), 30, 2);

		for (int i = 0; i < 200; i++) {
			try {

				arapObj.ARAP_RemarkSubmit().click();
				break;
			} catch (Exception e) {
				if (i == 199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_ReviewerId(), 30, 2);
		String reviwerId = arapObj.ARAP_ReviewerId().getText();
		String trimmdReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmdReviewerID);
		StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
		String finalReviewerID = bufferedString.toString();
		excelData.updateTestData(testdata.get("Data Set ID"), "Reviewer ID", finalReviewerID.trim());
		System.out.println(finalReviewerID);
		System.out.println(finalReviewerID.trim());
	}
	@Given("Navigate as a Reviewer for teller cash transfer")
	public void navigate_as_a_reviewer_for_teller_cash_transfer() {
		kubsLogin = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.logintoAzentioappReviewer(testdata.get("Reviewer ID"));
	}
	@And("Click First record Action icon for teller cash transfer")
	public void click_first_record_action_icon_for_teller_cash_transfer() {
		String befr_xpath = "//span[contains(text(),'";
		String aftr_xpath = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//div//ion-buttons//ion-button";
		for (int i = 0; i < 200; i++) {
			try {
				driver.findElement(By.xpath(befr_xpath + testdata.get("Reference ID") + aftr_xpath)).click();
				break;
			} catch (Exception e) {
				if (i == 199) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}
	@And("Give Remark and Submit for teller cash transfer")
	public void give_remark_and_submit_for_teller_cash_transfer() {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, checkerObj.checkerRemarks(), 30, 2);
		checkerObj.checkerRemarks().click();
		checkerObj.checkerRemarks().sendKeys(testdata.get("MakerSubmitRemarks"));
		// waitHelper.waitForElement(driver, 2000, checkerObj.checkersubmitButton());
		for (int i = 0; i < 200; i++) {
			try {
				checkerObj.checkersubmitButton().click();
				break;
			} catch (Exception e) {
				if (i == 199) {
					Assert.fail(e.getMessage());
				}
			}
		}

		waitHelper.waitForElementToVisibleWithFluentWait(driver, checkerObj.Popup_status(), 30, 2);
		String Text = checkerObj.Popup_status().getText();
		System.out.println("Checker status: " + Text);
		Assert.assertTrue(checkerObj.Popup_status().isDisplayed());
	}
	@Given("Claim the Record in Checker for Teller cash transfer")
	public void claim_the_record_in_checker_for_teller_cash_transfer() {
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		for (int i = 0; i < 200; i++) {
			try {

				driver.findElement(By.xpath(before_xpath + testdata.get("Reference ID") + after_xpath_claim)).click();
				break;
			} catch (Exception e) {
				if (i == 199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		waitHelper.waitForElementToVisibleWithFluentWait(driver, checkerObj.checker_alert_close(), 30, 2);
		clickAndActionHelper.moveToElement(checkerObj.checker_alert_close());
		clickAndActionHelper.clickOnElement(checkerObj.checker_alert_close());
	}
	@And("Store the transaction reference number for teller cash transfer")
	public void store_the_transaction_reference_number_for_teller_cash_transfer() {
		
		for (int i = 0; i <= 500; i++) {
			try {
				javaScriptHelper.JavaScriptHelper(driver);
				transactionrefno = javaScriptHelper
						.executeScript("return document.getElementsByName('trnRefNo')[1].value").toString();
				excelData.updateTestData(testdata.get("Data Set ID"), "TransactionRefNo", transactionrefno);
				System.out.println("Data Set ID " + testdata.get("Data Set ID"));
				System.out.println(transactionrefno);
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}

		}
		//assertEquals(testdata.get("InstrumentNoCreated"), instrumentid);
		//document.getElementsByName('trnRefNo')[1].value
	}
	@And("Select the first record in Teller cash transfer view list")
	public void select_the_first_record_in_teller_cash_transfer_view_list() {
		waitHelper.waitForElementToVisibleWithFluentWait(driver,
				ibftObj.InterBranchFundTransferViewList_EyeIconofFirstRecord(), 5, 500);
		ibftObj.InterBranchFundTransferViewList_EyeIconofFirstRecord().click();
	}
	@And("Validate the approved record is reflected in teller cash transfer view list")
	public void validate_the_approved_record_is_reflected_in_teller_cash_transfer_view_list() {
		for (int i = 0; i <= 500; i++) {
			try {
				javaScriptHelper.JavaScriptHelper(driver);
				transactionrefno = javaScriptHelper
						.executeScript("return document.getElementsByName('trnRefNo')[1].value").toString();
				//excelData.updateTestData(testdata.get("Data Set ID"), "TransactionRefNo", transactionrefno);
				//System.out.println("Data Set ID " + testdata.get("Data Set ID"));
				//System.out.println(transactionrefno);
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}

		}
		assertEquals(testdata.get("TransactionRefNo"), transactionrefno);
	}
	@And("^Update test data for TCT_005$")
	public void update_test_data_for_tct005() throws Throwable {
		testdata = excelData.getTestdata("KUBS_TCT_005_D1");
	}
	@And("^Update test data for TCT_009$")
	public void update_test_data_for_tct009() throws Throwable {
		testdata = excelData.getTestdata("KUBS_TCT_009_D1");
	}
	@Given("Validate rejected teller cash transfer record is displayed")
	public void validate_rejected_teller_cash_transfer_record_is_displayed() {
		for (int i = 0; i <= 500; i++) {
			try {
				javaScriptHelper.JavaScriptHelper(driver);
				transactionrefno = javaScriptHelper
						.executeScript("return document.getElementsByName('trnRefNo')[1].value").toString();
				//excelData.updateTestData(testdata.get("Data Set ID"), "TransactionRefNo", transactionrefno);
				//System.out.println("Data Set ID " + testdata.get("Data Set ID"));
				//System.out.println(transactionrefno);
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}

		}
		assertNotSame(testdata.get("TransactionRefNo"), transactionrefno);
		//assertNotSame(testdata.get("TransactionRefNo"), transactionrefno);
	}
	@Given("Validate the returned record is reflected in teller cash transfer view list")
	public void validate_the_returned_record_is_reflected_in_teller_cash_transfer_view_list() {
		for (int i = 0; i <= 500; i++) {
			try {
				javaScriptHelper.JavaScriptHelper(driver);
				transactionrefno = javaScriptHelper
						.executeScript("return document.getElementsByName('trnRefNo')[1].value").toString();
				//excelData.updateTestData(testdata.get("Data Set ID"), "TransactionRefNo", transactionrefno);
				//System.out.println("Data Set ID " + testdata.get("Data Set ID"));
				//System.out.println(transactionrefno);
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}

		}
		assertEquals(testdata.get("TransactionRefNo"), transactionrefno);
	}
	@And("^Update test data for TCT_013$")
	public void update_test_data_for_tct013() throws Throwable {
		testdata = excelData.getTestdata("KUBS_TCT_013_D1");
	}
	@Given("Navigate to Teller cash transfer temp view")
	public void navigate_to_teller_cash_transfer_temp_view() {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, tctobj.TellerCashTransferTempView(), 5, 500);
		tctobj.TellerCashTransferTempView().click();
	}
	@Given("Search the Teller cash transfer record with valid credentials")
	public void search_the_teller_cash_transfer_record_with_valid_credentials() {
		waitHelper.waitForElement(driver, 2000, tctobj.TellerCashTransferSearchIcon());
		tctobj.TellerCashTransferSearchIcon().click();
		waitHelper.waitForElement(driver, 2000, tctobj.TellerCashTransfer_TransferAmountSearchField());
		tctobj.TellerCashTransfer_TransferAmountSearchField().click();
		tctobj.TellerCashTransfer_TransferAmountSearchField().sendKeys(testdata.get("SearchValidData"));
		Assert.assertTrue(driver.findElement(By.xpath("(//span[contains(text(),'" + testdata.get("SearchValidData") + "')])[1]")).isDisplayed());
	}
	@Given("Search the Teller cash transfer record with invalid credentials")
	public void search_the_teller_cash_transfer_record_with_invalid_credentials() {
		tctobj.TellerCashTransfer_TransferAmountSearchField().clear();
		tctobj.TellerCashTransfer_TransferAmountSearchField().sendKeys(testdata.get("SearchInvalidData"));
		waitHelper.waitForElement(driver, 2000, tctobj.TellerCashTransfer_NoDataText());
		Assert.assertTrue(tctobj.TellerCashTransfer_NoDataText().isDisplayed());
	}
	@And("74_Store the Referance Id and Open the Record for fund request in petty cash")
	public void _74_store_the_referance_id_and_open_the_record_for_fund_request_in_petty_cash() {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, accSetupObj.FundTransfer_ReferanceId(), 30,
				2);
		String Referance_id = accSetupObj.FundTransfer_ReferanceId().getText();
		excelData.updateTestData(testdata.get("Data Set ID"), "Reference ID", Referance_id);
		System.out.println("Data Set ID " + testdata.get("Data Set ID"));
		System.out.println(Referance_id);
		waitHelper.waitForElementToVisibleWithFluentWait(driver, accSetupObj.FundRequest_ActionButton(), 30,
				2);
		accSetupObj.FundRequest_ActionButton().click();
	}
	@And("^74_Enter Request Amount value$")
	public void _74_enter_request_amount_value() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver,  pettyCashObj.enterRequestAmout(), 60, 500);
		pettyCashObj.enterRequestAmout().click();
		pettyCashObj.enterRequestAmout().sendKeys(testdata.get("RequestAmount"));
	}

	@Then("^74_Enter Petty cash Remark$")
	public void _74_enter_petty_cash_remark() throws Throwable {
		pettyCashObj.enterRemark().click();
		pettyCashObj.enterRemark().sendKeys(testdata.get("Remarks"));
	}
	@Given("Navigate to Report segment")
	public void navigate_to_report_segment() {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, tctobj.ReportSegment(), 5, 500);
		tctobj.ReportSegment().click();
	}
	@Given("Navigate to Financial transaction report")
	public void navigate_to_financial_transaction_report() {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, tctobj.FinancialReporting(), 5, 500);
		tctobj.FinancialReporting().click();
		waitHelper.waitForElementToVisibleWithFluentWait(driver, tctobj.FinancialTransactionReport(), 5, 500);
		tctobj.FinancialTransactionReport().click();
	}
	@Given("Select the Branch value in Financial transaction report")
	public void select_the_branch_value_in_financial_transaction_report() {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, tctobj.FinancialTransactionReport_BranchDropdown(), 5,
				500);
		tctobj.FinancialTransactionReport_BranchDropdown().click();
		tctobj.FinancialTransactionReport_BranchDropdown().sendKeys(testdata.get("ReportBranch"));
		tctobj.FinancialTransactionReport_BranchDropdown().sendKeys(Keys.DOWN);
		tctobj.FinancialTransactionReport_BranchDropdown().sendKeys(Keys.ENTER);
	}
	@Given("Select the Report type value in Financial transaction report")
	public void select_the_report_type_value_in_financial_transaction_report() {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, tctobj.FinancialTransactionReport_ReportTypeDropdown(), 5,
				500);
		tctobj.FinancialTransactionReport_ReportTypeDropdown().click();
		tctobj.FinancialTransactionReport_ReportTypeDropdown().sendKeys(testdata.get("ReportType"));
		tctobj.FinancialTransactionReport_ReportTypeDropdown().sendKeys(Keys.DOWN);
		tctobj.FinancialTransactionReport_ReportTypeDropdown().sendKeys(Keys.ENTER);
	}
	@Given("Click on View button in Financial transaction report")
	public void click_on_view_button_in_financial_transaction_report() {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, tctobj.FinancialTransactionReport_ViewButton(), 5, 500);
		tctobj.FinancialTransactionReport_ViewButton().click();
		browserHelper.SwitchToWindow(1);
		
	}
	@Given("Validate the created teller cash transfer record is displayed in Financial transaction report")
	public void validate_the_created_teller_cash_transfer_record_is_displayed_in_financial_transaction_report() {
		for (int i=0; i<100; i++) {
			try{
				waitHelper.waitForElementToVisibleWithFluentWait(driver, tctobj.FinancialTransactionReport_TellerCashTransferText(), 5, 500);
				Assert.assertTrue(tctobj.FinancialTransactionReport_TellerCashTransferText().isDisplayed());
				break;
			}catch (Exception e){
				waitHelper.waitForElementToVisibleWithFluentWait(driver, tctobj.FinancialTransactionReport_NextButton(), 5, 500);
				tctobj.FinancialTransactionReport_NextButton().click();	
			}
		}
		
		
	}
	@And("^Update test data for TCT_015$")
	public void update_test_data_for_tct015() throws Throwable {
		testdata = excelData.getTestdata("KUBS_TCT_015_D1");
	}
	@Given("Search the particular Transaction ref no in view list")
	public void search_the_particular_transaction_ref_no_in_view_list() {
		waitHelper.waitForElement(driver, 2000, tctobj.TellerCashTransferSearchIcon());
		tctobj.TellerCashTransferSearchIcon().click();
		waitHelper.waitForElement(driver, 2000, tctobj.TellerCashTransfer_TransactionRefNoSearchField());
		tctobj.TellerCashTransfer_TransactionRefNoSearchField().click();
		tctobj.TellerCashTransfer_TransactionRefNoSearchField().sendKeys(testdata.get("TransactionRefNo"));
	}
	@Given("Validate No Records found popup is displayed")
	public void validate_no_records_found_popup_is_displayed() {
		waitHelper.waitForElement(driver, 2000, tctobj.TellerCashTransfer_NoDataText());
		Assert.assertTrue(tctobj.TellerCashTransfer_NoDataText().isDisplayed());
	}
}
