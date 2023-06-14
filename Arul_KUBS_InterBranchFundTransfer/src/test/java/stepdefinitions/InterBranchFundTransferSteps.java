package stepdefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotSame;

import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
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
import resources.BaseClass;
import resources.ExcelData;

public class InterBranchFundTransferSteps {
	WebDriver driver = BaseClass.driver;
	KUBS_Login kubsLogin;
	ConfigFileReader configFileReader = new ConfigFileReader();
	ClicksAndActionsHelper clickAndActionHelper = new ClicksAndActionsHelper(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	JavascriptHelper javaScriptHelper = new JavascriptHelper();
	DropDownHelper dropDownHelper = new DropDownHelper(driver);
	InterBranchFundTransferObj ibftObj = new InterBranchFundTransferObj(driver);
	ARAP_ARandAPObj arapObj = new ARAP_ARandAPObj(driver);
	GL_Accounting_Setup_Obj accSetupObj = new GL_Accounting_Setup_Obj(driver);
	String excelPath = System.getProperty("user.dir") + "\\Test-data\\KUBSTestData.xlsx";
	ExcelData excelData = new ExcelData(excelPath, "InterBranchFundTransfer", "Data Set ID");
	private Map<String, String> testdata;
	KUBS_CheckerObj checkerObj = new KUBS_CheckerObj(driver);

	@And("^Update test data for IBFT_001$")
	public void update_test_data_for_ibft001() throws Throwable {
		testdata = excelData.getTestdata("KUBS_IBFT_001_D1");
	}

	@And("^Click on Inter branch fund transfer eye icon$")
	public void click_on_inter_branch_fund_transfer_eye_icon() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, ibftObj.InterBranchFundTrnsferEyeIcon(), 5, 500);
		ibftObj.InterBranchFundTrnsferEyeIcon().click();
	}

	@And("^Click on Add button in Inter branch fund transfer$")
	public void click_on_add_button_in_inter_branch_fund_transfer() throws Throwable {
		for(int i=0;i<100;i++) {
			try {
				waitHelper.waitForElementToVisibleWithFluentWait(driver, ibftObj.InterBranchFundTrnsfer_AddIcon(), 5, 500);
				ibftObj.InterBranchFundTrnsfer_AddIcon().click();
				break;
			}catch(Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
					
				}
		}
	}

	@And("^Select the value in Mode of payment dropdown$")
	public void select_the_value_in_mode_of_payment_dropdown() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, ibftObj.InterBranchFundTrnsfer_ModeOfPayment(), 5,
				500);
		ibftObj.InterBranchFundTrnsfer_ModeOfPayment().click();
		ibftObj.InterBranchFundTrnsfer_ModeOfPayment().sendKeys(testdata.get("ModeOfPayment"));
		ibftObj.InterBranchFundTrnsfer_ModeOfPayment().sendKeys(Keys.DOWN);
		ibftObj.InterBranchFundTrnsfer_ModeOfPayment().sendKeys(Keys.ENTER);
	}

	@And("^Enter the value in Instrument no$")
	public void enter_the_value_in_instrument_no() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, ibftObj.InterBranchFundTrnsfer_InstrumentNo(), 5, 500);
		ibftObj.InterBranchFundTrnsfer_InstrumentNo().click();
		Random random = new Random();
		int RanNo1 = random.nextInt(7000 - 10) + 10;
		String createdInstrument = testdata.get("InstrumentNo") + RanNo1;
		excelData.updateTestData(testdata.get("Data Set ID"), "InstrumentNoCreated", createdInstrument);
		ibftObj.InterBranchFundTrnsfer_InstrumentNo().sendKeys(createdInstrument);

	}

	@And("^Select the value in DR as Debit$")
	public void select_the_value_in_dr_as_debit() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, ibftObj.InterBranchFundTrnsfer_DRAndCR1Field(), 5,
				500);
		ibftObj.InterBranchFundTrnsfer_DRAndCR1Field().click();
		ibftObj.InterBranchFundTrnsfer_DRAndCR1Field().sendKeys(testdata.get("DRCRAsDebit"));
		ibftObj.InterBranchFundTrnsfer_DRAndCR1Field().sendKeys(Keys.DOWN);
		ibftObj.InterBranchFundTrnsfer_DRAndCR1Field().sendKeys(Keys.ENTER);
	}

	@And("^Select GL Code1 in GL Code field$")
	public void select_gl_code1_in_gl_code_field() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, ibftObj.InterBranchFundTrnsfer_GLCode1Field(), 5, 500);
		ibftObj.InterBranchFundTrnsfer_GLCode1Field().click();
		Thread.sleep(2000);
		System.out.println("GL Code " + testdata.get("GLCode1"));
		ibftObj.InterBranchFundTrnsfer_GLCode1Field().sendKeys(testdata.get("GLCode1").substring(12));
		ibftObj.InterBranchFundTrnsfer_GLCode1Field().sendKeys(Keys.DOWN);
		ibftObj.InterBranchFundTrnsfer_GLCode1Field().sendKeys(Keys.ENTER);
	}

	@And("^Enter the amount1 in Amount field$")
	public void enter_the_amount1_in_amount_field() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, ibftObj.InterBranchFundTrnsfer_AmountField(), 5, 500);
		ibftObj.InterBranchFundTrnsfer_AmountField().click();
		ibftObj.InterBranchFundTrnsfer_AmountField().sendKeys(testdata.get("Amount1"));
	}

	@And("^Enter the remarks1 on Remarks field$")
	public void enter_the_remarks1_on_remarks_field() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, ibftObj.InterBranchFundTrnsfer_RemarksField(), 5, 500);
		ibftObj.InterBranchFundTrnsfer_RemarksField().click();
		ibftObj.InterBranchFundTrnsfer_RemarksField().sendKeys(testdata.get("Remarks1"));
	}

	@And("^Click on Add button in Action section$")
	public void click_on_add_button_in_action_section() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, ibftObj.InterBranchFundTrnsfer_AddNewRowIcon(), 5,
				500);
		ibftObj.InterBranchFundTrnsfer_AddNewRowIcon().click();
	}

	@And("^Select the value in DR as Credit$")
	public void select_the_value_in_dr_as_credit() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, ibftObj.InterBranchFundTrnsfer_DRAndCR2Field(), 5,
				500);
		ibftObj.InterBranchFundTrnsfer_DRAndCR2Field().click();
		ibftObj.InterBranchFundTrnsfer_DRAndCR2Field().sendKeys(testdata.get("DRCRAsCredit"));
		ibftObj.InterBranchFundTrnsfer_DRAndCR2Field().sendKeys(Keys.DOWN);
		ibftObj.InterBranchFundTrnsfer_DRAndCR2Field().sendKeys(Keys.ENTER);
	}

	@And("^Select Branch code in Branh code field$")
	public void select_branch_code_in_branh_code_field() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, ibftObj.InterBranchFundTrnsfer_BranchCode2Field(), 5,
				500);
		ibftObj.InterBranchFundTrnsfer_BranchCode2Field().click();
		ibftObj.InterBranchFundTrnsfer_BranchCode2Field().sendKeys(testdata.get("BranchCode2"));
		ibftObj.InterBranchFundTrnsfer_BranchCode2Field().sendKeys(Keys.DOWN);
		ibftObj.InterBranchFundTrnsfer_BranchCode2Field().sendKeys(Keys.ENTER);
	}

	@And("^Select GL Code2 in GL Code field$")
	public void select_gl_code2_in_gl_code_field() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, ibftObj.InterBranchFundTrnsfer_GLCode2Field(), 5, 500);
		ibftObj.InterBranchFundTrnsfer_GLCode2Field().click();
		System.out.println("GL Code 2 " + testdata.get("GLCode2"));
		ibftObj.InterBranchFundTrnsfer_GLCode2Field().sendKeys(testdata.get("GLCode2").substring(12));
		ibftObj.InterBranchFundTrnsfer_GLCode2Field().sendKeys(Keys.DOWN);
		ibftObj.InterBranchFundTrnsfer_GLCode2Field().sendKeys(Keys.ENTER);
	}

	@And("^Enter the amount2 in Amount field$")
	public void enter_the_amount2_in_amount_field() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, ibftObj.InterBranchFundTrnsfer_Amount2Field(), 5, 500);
		ibftObj.InterBranchFundTrnsfer_Amount2Field().click();
		ibftObj.InterBranchFundTrnsfer_Amount2Field().sendKeys(testdata.get("Amount2"));
	}

	@And("^Click on Save icon$")
	public void click_on_save_icon() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, ibftObj.InterBranchFundTrnsfer_SaveIcon(), 5, 500);
		ibftObj.InterBranchFundTrnsfer_SaveIcon().click();
	}

	@And("^Navigate to General ledger transaction section$")
	public void navigate_to_general_ledger_transaction_section() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, ibftObj.GeneralLedgerTransaction(), 5, 500);
		ibftObj.GeneralLedgerTransaction().click();
	}

	@And("^Enter the remarks2 on Remarks field$")
	public void enter_the_remarks2_on_remarks_field() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, ibftObj.InterBranchFundTrnsfer_Remarks2Field(), 5,
				500);
		ibftObj.InterBranchFundTrnsfer_Remarks2Field().click();
		ibftObj.InterBranchFundTrnsfer_Remarks2Field().sendKeys(testdata.get("Remarks2"));
	}

	@And("^Store the Referance Id and Open the Record for GL2 records$")
	public void store_the_referance_id_and_open_the_record_for_gl2_records() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, accSetupObj.interBranchFundTransferReferanceId(), 30,
				2);
		String Referance_id = accSetupObj.interBranchFundTransferReferanceId().getText();
		excelData.updateTestData(testdata.get("Data Set ID"), "Reference ID", Referance_id);
		System.out.println("Data Set ID " + testdata.get("Data Set ID"));
		System.out.println(Referance_id);
		waitHelper.waitForElementToVisibleWithFluentWait(driver, accSetupObj.interBranchFundTransferActionButton(), 30,
				2);
		accSetupObj.interBranchFundTransferActionButton().click();
	}

	@Then("^Click submit button and Enter Remark submit it for GL2 Records$")
	public void click_submit_button_and_enter_remark_submit_it_for_gl2_records() throws Throwable {
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
		excelData.updateTestData(testdata.get("Data Set ID"), "Reviewer ID", finalReviewerID);
		System.out.println(reviwerId);
	}

	@And("^Update test data for IBFT_002$")
	public void update_test_data_for_ibft002() throws Throwable {
		testdata = excelData.getTestdata("KUBS_IBFT_001_D1");
	}

	@And("^Update test data for IBFT_003$")
	public void update_test_data_for_ibft003() throws Throwable {
		testdata = excelData.getTestdata("KUBS_IBFT_001_D1");
	}

	@And("^Update test data for IBFT_004$")
	public void update_test_data_for_ibft004() throws Throwable {
		testdata = excelData.getTestdata("KUBS_IBFT_001_D1");
	}

	// **********************************************Reviewer and checker
	// *******************************************************************//
	@Given("^Navigate as a Reviewer for Inter branch fund transfer$")
	public void navigate_as_a_reviewer_for_inter_branch_fund_transfer() throws Throwable {
		kubsLogin = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.logintoAzentioappReviewer(testdata.get("Reviewer ID"));
	}

	@And("^Give Remark and Submit for Inter branch fund transfer$")
	public void give_remark_and_submit_for_inter_branch_fund_transfer() throws Throwable {
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

	@And("^Claim the Record in Checker for Inter branch fund transfer$")
	public void claim_the_record_in_checker_for_inter_branch_fund_transfer() throws Throwable {
		// -------------------------CLICK CLAIM OPTION-------------------------//
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

	@And("^Click First record Action icon for Inter branch fund transfer$")
	public void click_first_record_action_icon_for_inter_branch_fund_transfer() throws Throwable {
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

	@Given("Select the first record in Inter branch fund transfer view list")
	public void select_the_first_record_in_inter_branch_fund_transfer_view_list() {
		waitHelper.waitForElementToVisibleWithFluentWait(driver,
				ibftObj.InterBranchFundTransferViewList_EyeIconofFirstRecord(), 5, 500);
		ibftObj.InterBranchFundTransferViewList_EyeIconofFirstRecord().click();
	}

	@Given("Verify the given data in Inter branch fund transfer")
	public void verify_the_given_data_in_inter_branch_fund_transfer() {
		String instrumentid = "";
		for (int i = 0; i <= 500; i++) {
			try {
				javaScriptHelper.JavaScriptHelper(driver);
				instrumentid = javaScriptHelper
						.executeScript("return document.getElementsByName('instrumentNo')[1].value").toString();
				System.out.println(instrumentid);
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}

		}
		assertEquals(testdata.get("InstrumentNoCreated"), instrumentid);
	}

	@And("^Update test data for IBFT_005$")
	public void update_test_data_for_ibft005() throws Throwable {
		testdata = excelData.getTestdata("KUBS_IBFT_005_D1");
	}

	@And("^Update test data for IBFT_006$")
	public void update_test_data_for_ibft006() throws Throwable {
		testdata = excelData.getTestdata("KUBS_IBFT_005_D1");
	}

	@And("^Update test data for IBFT_007$")
	public void update_test_data_for_ibft007() throws Throwable {
		testdata = excelData.getTestdata("KUBS_IBFT_005_D1");
	}

	@And("^Update test data for IBFT_008$")
	public void update_test_data_for_ibft008() throws Throwable {
		testdata = excelData.getTestdata("KUBS_IBFT_005_D1");
	}

	@And("^Update test data for IBFT_009$")
	public void update_test_data_for_ibft009() throws Throwable {
		testdata = excelData.getTestdata("KUBS_IBFT_009_D1");
	}

	@And("^Update test data for IBFT_010$")
	public void update_test_data_for_ibft010() throws Throwable {
		testdata = excelData.getTestdata("KUBS_IBFT_009_D1");
	}

	@And("^Update test data for IBFT_011$")
	public void update_test_data_for_ibft011() throws Throwable {
		testdata = excelData.getTestdata("KUBS_IBFT_009_D1");
	}

	@And("^Update test data for IBFT_012$")
	public void update_test_data_for_ibft012() throws Throwable {
		testdata = excelData.getTestdata("KUBS_IBFT_009_D1");
	}

	@Given("Navigate to Inter branch fund transfer temp view")
	public void navigate_to_inter_branch_fund_transfer_temp_view() {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, ibftObj.InterBranchFundTrnsferTempView(), 5, 500);
		ibftObj.InterBranchFundTrnsferTempView().click();
	}

	@Given("Return the record in checker stage")
	public void return_the_record_in_checker_stage() {
		waitHelper.waitForElement(driver, 2000, ibftObj.ReturnButtonInChecker());
		ibftObj.ReturnButtonInChecker().click();
	}

	@Given("Reject the record in checker stage")
	public void reject_the_record_in_checker_stage() {
		waitHelper.waitForElement(driver, 2000, ibftObj.RejectButtonInChecker());
		ibftObj.RejectButtonInChecker().click();
	}

	@Given("Verify the returned inter branch fund transfer record is displayed")
	public void verify_the_returned_inter_branch_fund_transfer_record_is_displayed() {
		String instrumentid = "";
		for (int i = 0; i <= 500; i++) {
			try {
				javaScriptHelper.JavaScriptHelper(driver);
				instrumentid = javaScriptHelper
						.executeScript("return document.getElementsByName('instrumentNo')[1].value").toString();
				System.out.println(instrumentid);
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}

		}
		assertEquals(testdata.get("InstrumentNoCreated"), instrumentid);
	}

	@Given("Verify the rejected inter branch fund transfer record is displayed")
	public void verify_the_rejected_inter_branch_fund_transfer_record_is_displayed() {
		String instrumentid = "";
		for (int i = 0; i <= 500; i++) {
			try {
				javaScriptHelper.JavaScriptHelper(driver);
				instrumentid = javaScriptHelper
						.executeScript("return document.getElementsByName('instrumentNo')[1].value").toString();
				System.out.println(instrumentid);
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}

		}
		assertNotSame(testdata.get("InstrumentNoCreated"), instrumentid);
		// assertNotEquals(testdata.get("InstrumentNoCreated"), instrumentid);
	}

	@And("^Update test data for IBFT_013$")
	public void update_test_data_for_ibft013() throws Throwable {
		testdata = excelData.getTestdata("KUBS_IBFT_013_D1");
	}

	@And("Verify the back button functionality")
	public void verify_the_back_button_functionality() {
		waitHelper.waitForElement(driver, 2000, ibftObj.BackButton());
		for(int i=0;i<=100;i++) {
			try {
				ibftObj.BackButton().click();
				break;
			}catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
				
				
			}
		}
		
	}

	@And("Search the Inter branch fund transfer record with valid credentials")
	public void search_the_inter_branch_fund_transfer_record_with_valid_credentials() {
		waitHelper.waitForElement(driver, 2000, ibftObj.InterBranchFundTransferSearchIcon());
		ibftObj.InterBranchFundTransferSearchIcon().click();
		waitHelper.waitForElement(driver, 2000, ibftObj.InterBranchFundTransfer_DrAmountSearchField());
		ibftObj.InterBranchFundTransfer_DrAmountSearchField().click();
		ibftObj.InterBranchFundTransfer_DrAmountSearchField().sendKeys(testdata.get("SearchValidData"));
		Assert.assertTrue(driver.findElement(By.xpath("(//span[contains(text(),'" + testdata.get("SearchValidData") + "')])[1]")).isDisplayed());

	}

	@And("Search the Inter branch fund transfer record with Invalid credentials")
	public void search_the_inter_branch_fund_transfer_record_with_invalid_credentials() {
//		waitHelper.waitForElement(driver, 2000, ibftObj.InterBranchFundTransferSearchIcon());
//		ibftObj.InterBranchFundTransferSearchIcon().click();
//		waitHelper.waitForElement(driver, 2000, ibftObj.InterBranchFundTransfer_DrAmountSearchField());
//		ibftObj.InterBranchFundTransfer_DrAmountSearchField().click();
		ibftObj.InterBranchFundTransfer_DrAmountSearchField().clear();
		ibftObj.InterBranchFundTransfer_DrAmountSearchField().sendKeys(testdata.get("SearchInvalidData"));
		waitHelper.waitForElement(driver, 2000, ibftObj.InterBranchFundTransfer_NoDataText());
		Assert.assertTrue(ibftObj.InterBranchFundTransfer_NoDataText().isDisplayed());

	}

	@And("Validate the view summary functionality of Inter branch fund transfer")
	public void validate_the_view_summary_functionality_of_inter_branch_fund_transfer() {
		waitHelper.waitForElement(driver, 2000, ibftObj.ViewSummaryLink());
		ibftObj.ViewSummaryLink().click();
		waitHelper.waitForElement(driver, 2000, ibftObj.TransactionSummaryTextinViewSummary());
		Assert.assertTrue(ibftObj.TransactionSummaryTextinViewSummary().isDisplayed());

	}

}