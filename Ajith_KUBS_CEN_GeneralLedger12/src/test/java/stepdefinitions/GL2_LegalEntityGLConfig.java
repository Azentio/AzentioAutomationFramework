package stepdefinitions;

import java.io.IOException;
import java.util.Map;
import java.util.Random;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ACCOUNTSPAYABLE_InvoiceBookingObj;
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
import pageobjects.ARAP_ARandAPObj;
import pageobjects.AccountsReceivable_ReceiptsReversalsObj;
import pageobjects.AccountsReceivable_UpdateChequeStatusObj;
import pageobjects.ENQUIRY_FinancialTransactionObj;
import pageobjects.FinancialReporting_GLBalancesReportObj;
import pageobjects.GL2_JournalVoucherObj;
import pageobjects.GL2_JournalVoucherReversalObj;
import pageobjects.GL2_JournalVoucher_AccountEntryReportObj;
import pageobjects.GL2_LegalEntityGLConfigObj;
import pageobjects.GL_Accounting_Setup_Obj;
import pageobjects.GeneralLedger2_JournalVoucherObj;
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;
import testDataType.ACCOUNTSPAYABLE_InvoiceBookingTestDataType;
import testDataType.AccountsReceivable_UpdateChequeStatusTestDataType;
import testDataType.FinancialReporting_GLBalancesReportTestDataType;
import testDataType.GL2_JournalVoucherTestDataType;
import testDataType.GL2_JournalVoucher_AccountEntryReportTestDataType;
import testDataType.GL2_LegalEntityGLConfigTestDataType;
import testDataType.GeneralLedger2_JournalVoucherTestDataType;

public class GL2_LegalEntityGLConfig extends BaseClass {
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	DropDownHelper dropDownHelper;
	WaitHelper waithelper = new WaitHelper(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper();
	GL_Accounting_Setup_Obj accSetupObj = new GL_Accounting_Setup_Obj(driver);
	ARAP_ARandAPObj arapObj = new ARAP_ARandAPObj(driver);
	KUBS_CheckerObj checkerObj = new KUBS_CheckerObj(driver);
	KUBS_Login kubsLogin;
	ConfigFileReader configFileReader = new ConfigFileReader();
	ClicksAndActionsHelper clickAndActionHelper = new ClicksAndActionsHelper(driver);
	String excelPath = System.getProperty("user.dir")+"\\Test-data\\GLTestData.xlsx";
	ExcelData excelData = new ExcelData(excelPath,"GL2TestData","Data Set ID");
	private Map<String, String> testData;
	GL2_LegalEntityGLConfigObj gL2_LegalEntityGLConfigObj = new GL2_LegalEntityGLConfigObj(driver);
	GL2_LegalEntityGLConfigTestDataType gL2_LegalEntityGLConfigTestDataType = jsonReader
			.getLegalEntityGLConfigByName("Maker");
	// GL2 Journal Voucher
	GL2_JournalVoucherObj gL2_JournalVoucherObj = new GL2_JournalVoucherObj(driver);
	GL2_JournalVoucherTestDataType gL2_JournalVoucherTestDataType = jsonReader.getJournalVoucherByName("Maker");
	// Journal Voucher accounting entry
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	GL2_JournalVoucher_AccountEntryReportObj gL2_JournalVoucher_AccountEntryReportObj = new GL2_JournalVoucher_AccountEntryReportObj(
			driver);
	GL2_JournalVoucher_AccountEntryReportTestDataType gL2_JournalVoucher_AccountEntryReportTestDataType = jsonReader
			.getJournalVoucherReportByName("Maker");
	// reverse journal voucher
	GL2_JournalVoucherReversalObj gL2_JournalVoucherReversalObj = new GL2_JournalVoucherReversalObj(driver);
	// GL reports
	
	KUBS_Login login = new KUBS_Login(driver);
	ConfigFileReader config = new ConfigFileReader();
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(driver);
	ACCOUNTSPAYABLE_InvoiceBookingObj aCCOUNTSPAYABLE_InvoiceBookingObj = new ACCOUNTSPAYABLE_InvoiceBookingObj(driver);
	AccountsReceivable_UpdateChequeStatusObj accountsReceivable_UpdateChequeStatusObj = new AccountsReceivable_UpdateChequeStatusObj(driver);
	ENQUIRY_FinancialTransactionObj eNQUIRY_FinancialTransactionObj = new ENQUIRY_FinancialTransactionObj(driver);
	GeneralLedger2_JournalVoucherObj generalLedger2_JournalVoucherObj = new GeneralLedger2_JournalVoucherObj(driver);
	AccountsReceivable_ReceiptsReversalsObj accountsReceivable_ReceiptsReversalsObj = new AccountsReceivable_ReceiptsReversalsObj(driver);
	AccountsReceivable_UpdateChequeStatusTestDataType UpdateChequeStatusTestDataType=jsonReader.getUpdateChequeStatusdata("Maker");
	GeneralLedger2_JournalVoucherTestDataType JournalVoucherTestDataType=jsonReader.getJournalVoucherdata("Maker");
	ACCOUNTSPAYABLE_InvoiceBookingTestDataType InvoiceBookingTestDataType=jsonReader.getInvoiceBookingdata("Maker");
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	JsonDataReaderWriter reader;
	BrowserHelper browserHelper;
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	//Financials reports
	
	FinancialReporting_GLBalancesReportObj financialReporting_GLBalancesReportObj = new FinancialReporting_GLBalancesReportObj(
			driver);
	FinancialReporting_GLBalancesReportTestDataType GLBalancesReportTestDataType = jsonReader
			.getGLBalancesReportdata("Maker");

	
	@Given("^Navigate as a Reviewer for GL2$")
	    public void navigate_as_a_reviewer_for_gl2() throws Throwable {
		 kubsLogin = new KUBS_Login(driver);
			driver.get(configFileReader.getApplicationUrl());
			kubsLogin.logintoAzentioappReviewer(testData.get("Reviewer ID"));
			//Thread.sleep(1000);
	    }
	@Then("^Click on General ledger configuration$")
	public void click_on_general_ledger_configuration() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_LegalEntityGLConfigObj.gL2_Generalledgerconfiguration(), 5, 500);
		gL2_LegalEntityGLConfigObj.gL2_Generalledgerconfiguration().click();

	}

	@Then("^Click on Legal Entity GL Configuration Eye Icon$")
	public void click_on_legal_entity_gl_configuration_eye_icon() throws InterruptedException {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_EyeIcon(), 5, 500);
		gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_EyeIcon().click();

	}

	@Then("^Click on Legal Entity GL Configuration Add button$")
	public void click_on_legal_entity_gl_configuration_add_button() {
		for (int i = 0; i <30; i++) {
			try {
				gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_AddButton().click();
				break;
			} catch (Exception e) {
				if (i==29) {
					Assert.fail(e.getMessage());
				}
			}
		}
		

	}
	 @And("^Click First record Action icon for GL2$")
	    public void click_first_record_action_icon_for_gl2() throws Throwable {
		 String befr_xpath = "//span[contains(text(),'";
			String aftr_xpath = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//div//ion-buttons//ion-button";
			for (int i = 0; i <200; i++) {
				try {
					driver.findElement(By.xpath(befr_xpath +testData.get("Reference ID")+ aftr_xpath)).click();
					break;
				} catch (Exception e) {
					if (i==199) {
						Assert.fail(e.getMessage());
					}
				}
			}
	    }
	 @And("^Give Remark and Submit for GL2$")
	    public void give_remark_and_submit_for_gl2() throws Throwable {
		 waithelper.waitForElementToVisibleWithFluentWait(driver, checkerObj.checkerRemarks(),30, 2);
			checkerObj.checkerRemarks().sendKeys(testData.get("Remark"));
			//waitHelper.waitForElement(driver, 2000, checkerObj.checkersubmitButton());
			for (int i = 0; i <200; i++) {
				try {
					checkerObj.checkersubmitButton().click();
					break;
				} catch (Exception e) {
					if (i==199) {
						Assert.fail(e.getMessage());
					}
				}
			}
			
			waithelper.waitForElementToVisibleWithFluentWait(driver,checkerObj.Popup_status(),30, 2);
			String Text = checkerObj.Popup_status().getText();
			System.out.println("Checker status: " + Text);
			Assert.assertTrue(checkerObj.Popup_status().isDisplayed());
	    }
	 @And("^Claim the Record in Checker for GL2$")
	    public void claim_the_record_in_checker_for_gl2() throws Throwable {
		// -------------------------CLICK CLAIM OPTION-------------------------//
					String before_xpath = "//span[contains(text(),'";
					String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
					for (int i = 0; i <200; i++) {
						try {
							
							driver.findElement(By.xpath(before_xpath +testData.get("Reference ID")+ after_xpath_claim)).click();
							break;
						} catch (Exception e) {
							if (i==199) {
								Assert.fail(e.getMessage());
							}
						}
					}
					waithelper.waitForElementToVisibleWithFluentWait(driver,checkerObj.checker_alert_close(),30, 2);
					clickAndActionHelper.moveToElement(checkerObj.checker_alert_close());
					clickAndActionHelper.clickOnElement(checkerObj.checker_alert_close());
	    }
	@And("^User Update the test data set id to Create a Ledger at entity Level$")
    public void user_update_the_test_data_set_id_to_create_a_ledger_at_entity_level() throws Throwable {
         testData = excelData.getTestdata("KUBS_GL2_UAT_001_001_01_D1");
    }
	@And("^User Update the test data set id to do the entity level transaction$")
    public void user_update_the_test_data_set_id_to_do_the_entity_level_transaction() throws Throwable {
		testData = excelData.getTestdata("KUBS_GL2_UAT_001_003_01_D1");
    }
	 @And("^User Update the test data set id to create Journal Voucher$")
	    public void user_update_the_test_data_set_id_to_create_journal_voucher() throws Throwable {
		 testData = excelData.getTestdata("KUBS_GL2_UAT_003_001_01_D1");
	    }
	 @And("^User update the test data set id to generate a unique journal voucher number$")
	    public void user_update_the_test_data_set_id_to_generate_a_unique_journal_voucher_number() throws Throwable {
		 testData = excelData.getTestdata("KUBS_GL2_UAT_003_002_01_D1");
	    }

	    @And("^User update the test data set id for System should display the accounting entries for the vourcher generated$")
	    public void user_update_the_test_data_set_id_for_system_should_display_the_accounting_entries_for_the_vourcher_generated() throws Throwable {
	    	testData = excelData.getTestdata("KUBS_GL2_UAT_003_003_D1");
	    }

    @And("^User Update the test data set id to Map the GL in side entity level$")
    public void user_update_the_test_data_set_id_to_map_the_gl_in_side_entity_level() throws Throwable {
    	testData = excelData.getTestdata("KUBS_GL2_UAT_001_002_01_D1");
    }
	@And("^User Update the data set id to approve Ledger at entity level in Reviewer or Checker$")
    public void user_update_the_data_set_id_to_approve_ledger_at_entity_level_in_reviewer_or_checker() throws Throwable {
		testData = excelData.getTestdata("KUBS_GL2_UAT_001_001_02_D1");
    }
	 @And("^User Update the data set id to approve the entity level transaction in reviewer or checker$")
	    public void user_update_the_data_set_id_to_approve_the_entity_level_transaction_in_reviewer_or_checker() throws Throwable {
		 testData = excelData.getTestdata("KUBS_GL2_UAT_001_003_02_D1");
	    }
	 @And("^User Update test data set id to approve the Journal Voucher record in Reviewer or Checker$")
	    public void user_update_test_data_set_id_to_approve_the_journal_voucher_record_in_reviewer_or_checker() throws Throwable {
		 testData = excelData.getTestdata("KUBS_GL2_UAT_003_001_02_D1");
	    }
	 @And("^User Update test data set id to approve the GL2 Journal Voucher record in Reviewer or Checker$")
	    public void user_update_test_data_set_id_to_approve_the_gl2_journal_voucher_record_in_reviewer_or_checker() throws Throwable {
		 testData = excelData.getTestdata("KUBS_GL2_UAT_003_002_02_D1");
	    }
	 @And("^User Update test data set id to approve the GL2 Reverse Journal Voucher record in Reviewer or Checker$")
	    public void user_update_test_data_set_id_to_approve_the_gl2_reverse_journal_voucher_record_in_reviewer_or_checker() throws Throwable {
		 testData = excelData.getTestdata("KUBS_GL2_UAT_003_004_02_D1");
	    }
	 @And("^User update the test data set id to verify the Reversed Journal Voucher in Maker list view$")
	    public void user_update_the_test_data_set_id_to_verify_the_reversed_journal_voucher_in_maker_list_view() throws Throwable {
		 testData = excelData.getTestdata("KUBS_GL2_UAT_003_004_04_D1");
	    }
	 @And("^User Update the test data id for display the accounting entries for the vourcher generated$")
	    public void user_update_the_test_data_id_for_display_the_accounting_entries_for_the_vourcher_generated() throws Throwable {
		 testData = excelData.getTestdata("KUBS_GL2_UAT_003_005_D1");
	    }
	 @And("^User update the test data id for Check report for GL monthly balances$")
	    public void user_update_the_test_data_id_for_check_report_for_gl_monthly_balances() throws Throwable {
		 testData = excelData.getTestdata("KUBS_GL2_UAT_004_001_D1");
	    }

	 @And("^User Update the test data set id for Check the Transactions$")
	    public void user_update_the_test_data_set_id_for_check_the_transactions() throws Throwable {
		 testData = excelData.getTestdata("KUBS_GL2_UAT_006_001_D1");
	    }

	    @And("^User Update the test data set id for Check the Transactions as per GL$")
	    public void user_update_the_test_data_set_id_for_check_the_transactions_as_per_gl() throws Throwable {
	    	testData = excelData.getTestdata("KUBS_GL2_UAT_006_002_D1");
	    }
	 @And("^User Update the data set id to Approve the Mapped the GL in side the entity level in Reviewer or Checker$")
	    public void user_update_the_data_set_id_to_approve_the_mapped_the_gl_in_side_the_entity_level_in_reviewer_or_checker() throws Throwable {
		 testData = excelData.getTestdata("KUBS_GL2_UAT_001_002_02_D1");
	    }
	 


    @And("^Verify the given data in Created Ledger$")
    public void verify_the_given_data_in_created_ledger() throws Throwable {
    	Thread.sleep(1000);
    	String xpath ="//span[contains(text(),'"+testData.get("GLCheque")+"')]";
        for (int i = 0; i <200; i++) {
			try {
				Assert.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				if (i==199) {
					Assert.fail("Approved GL Entity record is not displayed in Maker List View");
				}
			}
		}
    }
	@And("^User select the cash GL$")
    public void user_select_the_cash_gl() throws Throwable {
		// CashGL
				waithelper.waitForElementToVisibleWithFluentWait(driver,
						gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_CashGL(), 5, 500);
				gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_CashGL().click();
				gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_CashGL()
						.sendKeys(testData.get("CashGL"));
				for (int i = 0; i <300; i++) {
					try {
						driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("CashGL")+"')]")).isDisplayed();
						break;
					} catch (Exception e) {
						if (i==299) {
							Assert.fail(e.getMessage());
						}
					}
				}
				gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_CashGL().sendKeys(Keys.ENTER);

    }

    @And("^User Select the Cheque GL$")
    public void user_select_the_cheque_gl() throws Throwable {
    	// GLCheck
    			waithelper.waitForElementToVisibleWithFluentWait(driver,
    					gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_GLCheck(), 5, 500);
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_GLCheck().click();
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_GLCheck()
    			.sendKeys(testData.get("GLCheque"));
    			for (int i = 0; i <200; i++) {
    				try {
    					driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("GLCheque")+"')]")).isDisplayed();
    					break;
    				} catch (Exception e) {
    					if (i==199) {
    						Assert.fail(e.getMessage());
    					}
    				}
    			}
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_GLCheck().sendKeys(Keys.ENTER);
    }

    @And("^User Select the Inter branch GL$")
    public void user_select_the_inter_branch_gl() throws Throwable {
    	// InterBranchGL
    			waithelper.waitForElementToVisibleWithFluentWait(driver,
    					gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_InterBranchGL(), 5, 500);
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_InterBranchGL().click();
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_InterBranchGL()
    					.sendKeys(testData.get("InterBranch GL"));
    			for (int i = 0; i <200; i++) {
    				try {
    					driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("InterBranch GL")+"')]")).isDisplayed();
    					break;
    				} catch (Exception e) {
    					if (i==199) {
    						Assert.fail(e.getMessage());
    					}
    				}
    			}
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_InterBranchGL().sendKeys(Keys.ENTER);
    }

    @And("^User Select the Position GL$")
    public void user_select_the_position_gl() throws Throwable {
    	// PositionGL
    			waithelper.waitForElementToVisibleWithFluentWait(driver,
    					gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_PositionGL(), 5, 500);
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_PositionGL().click();
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_PositionGL()
    					.sendKeys(testData.get("PositionGL"));
    			for (int i = 0; i <200; i++) {
    				try {
    					driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("PositionGL")+"')]")).isDisplayed();
    					break;
    				} catch (Exception e) {
    					if (i==199) {
    						Assert.fail(e.getMessage());
    					}
    				}
    			}
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_PositionGL().sendKeys(Keys.ENTER);
    }

    @And("^User Select the PL Exchange Gain GL$")
    public void user_select_the_pl_exchange_gain_gl() throws Throwable {
    	// PLExchangeGainGL
    			waithelper.waitForElementToVisibleWithFluentWait(driver,
    					gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_PLExchangeGainGL(), 5, 500);
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_PLExchangeGainGL().click();
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_PLExchangeGainGL()
    					.sendKeys(testData.get("PLExchangeGainGL"));
    			for (int i = 0; i <200; i++) {
    				try {
    					driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("PLExchangeGainGL")+"')]")).isDisplayed();
    					break;
    				} catch (Exception e) {
    					if (i==199) {
    						Assert.fail(e.getMessage());
    					}
    				}
    			}
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_PLExchangeGainGL().sendKeys(Keys.ENTER);
    }

    @And("^User Select the PL Exchange Loss GL$")
    public void user_select_the_pl_exchange_loss_gl() throws Throwable {
    	// PLExchangeLossGL
    			waithelper.waitForElementToVisibleWithFluentWait(driver,
    					gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_PLExchangeLossGL(), 5, 500);
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_PLExchangeLossGL().click();
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_PLExchangeLossGL()
    					.sendKeys(testData.get("PLExchangeLossGL"));
    			for (int i = 0; i <200; i++) {
    				try {
    					driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("PLExchangeLossGL")+"')]")).isDisplayed();
    					break;
    				} catch (Exception e) {
    					if (i==199) {
    						Assert.fail(e.getMessage());
    					}
    				}
    			}
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_PLExchangeLossGL().sendKeys(Keys.ENTER);
    }

    @And("^User Select the Revaluation Profit GL$")
    public void user_select_the_revaluation_profit_gl() throws Throwable {
    	// RevaluationProfitGL
    			waithelper.waitForElementToVisibleWithFluentWait(driver,
    					gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationProfitGL(), 5, 500);
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationProfitGL().click();
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationProfitGL()
    					.sendKeys(testData.get("RevaluationProfitGL"));
    			for (int i = 0; i <200; i++) {
    				try {
    					driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("RevaluationProfitGL")+"')]")).isDisplayed();
    					break;
    				} catch (Exception e) {
    					if (i==199) {
    						Assert.fail(e.getMessage());
    					}
    				}
    			}
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationProfitGL().sendKeys(Keys.ENTER);
    }

    @And("^User Select the Revaluation Loss GL$")
    public void user_select_the_revaluation_loss_gl() throws Throwable {
    	// RevaluationLossGL
    			waithelper.waitForElementToVisibleWithFluentWait(driver,
    					gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationLossGL(), 5, 500);
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationLossGL().click();
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationLossGL()
    					.sendKeys(testData.get("RevaluationLossGL"));
    			for (int i = 0; i <200; i++) {
    				try {
    					driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("RevaluationLossGL")+"')]")).isDisplayed();
    					break;
    				} catch (Exception e) {
    					if (i==199) {
    						Assert.fail(e.getMessage());
    					}
    				}
    			}
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationLossGL().sendKeys(Keys.ENTER);
    }

    @And("^User Select the Revaluation Notional Profit GL$")
    public void user_select_the_revaluation_notional_profit_gl() throws Throwable {
    	// RevaluationNotionalProfitGL
    			waithelper.waitForElementToVisibleWithFluentWait(driver,
    					gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationNotionalProfitGL(), 5, 500);
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationNotionalProfitGL().click();
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationNotionalProfitGL()
    					.sendKeys(testData.get("RevaluationNotionalProfitGL"));
    			for (int i = 0; i <200; i++) {
    				try {
    					driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("RevaluationNotionalProfitGL")+"')]")).isDisplayed();
    					break;
    				} catch (Exception e) {
    					if (i==199) {
    						Assert.fail(e.getMessage());
    					}
    				}
    			}
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationNotionalProfitGL().sendKeys(Keys.ENTER);
    }

    @And("^User Select the Revaluation Notional Loss GL$")
    public void user_select_the_revaluation_notional_loss_gl() throws Throwable {
    	// RevaluationNotionalLossGL
    			waithelper.waitForElementToVisibleWithFluentWait(driver,
    					gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationNotionalLossGL(), 5, 500);
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationNotionalLossGL().click();
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationNotionalLossGL()
    					.sendKeys(testData.get("RevaluationNotionalLossGL"));
    			for (int i = 0; i <200; i++) {
    				try {
    					driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("RevaluationNotionalLossGL")+"')]")).isDisplayed();
    					break;
    				} catch (Exception e) {
    					if (i==199) {
    						Assert.fail(e.getMessage());
    					}
    				}
    			}
    			gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_RevaluationNotionalLossGL().sendKeys(Keys.ENTER);

    }

	@Then("^save the Legal Entity GL Configuration record$")
	public void save_the_legal_entity_gl_configuration_record() {
		waithelper.waitForElement(driver, 2000, gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_Save());
		gL2_LegalEntityGLConfigObj.gL2_LegalEntityGLConfig_Save().click();
	}
	@And("^Store the Referance Id and Open the Record for GL2 records$")
    public void store_the_referance_id_and_open_the_record_for_gl2_records() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.GL2LegalEntity_ReferanceId(), 30, 2);
		String Referance_id = accSetupObj.GL2LegalEntity_ReferanceId().getText();
		excelData.updateTestData(testData.get("Data Set ID"),"Reference ID", Referance_id);
		System.out.println(Referance_id);
		waithelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.GL2LegalEntity_ActionButton(), 30, 2);
		accSetupObj.GL2LegalEntity_ActionButton().click();
    }
	 @And("^Store the Referance Id and Open the Record for Journal Voucher record$")
	    public void store_the_referance_id_and_open_the_record_for_journal_voucher_record() throws Throwable {
		 waithelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.GL2JournalVoucher_ReferanceId(), 30, 2);
			String Referance_id = accSetupObj.GL2JournalVoucher_ReferanceId().getText();
			excelData.updateTestData(testData.get("Data Set ID"),"Reference ID", Referance_id);
			System.out.println(Referance_id);
			waithelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.GL2JournalVoucher_ActionButton(), 30, 2);
			accSetupObj.GL2JournalVoucher_ActionButton().click(); 
	    }
	 @And("^Store the Referance Id and Open the Record for Reverse Journal Voucher record$")
	    public void store_the_referance_id_and_open_the_record_for_reverse_journal_voucher_record() throws Throwable {
		 waithelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.GL2ReverseJournalVoucher_ReferanceId(), 30, 2);
			String Referance_id = accSetupObj.GL2ReverseJournalVoucher_ReferanceId().getText();
			excelData.updateTestData(testData.get("Data Set ID"),"Reference ID", Referance_id);
			System.out.println(Referance_id);
			waithelper.waitForElementToVisibleWithFluentWait(driver,accSetupObj.GL2ReverseJournalVoucher_ActionButton(), 30, 2);
			accSetupObj.GL2ReverseJournalVoucher_ActionButton().click(); 
	    }
	@Then("^Click submit button and Enter Remark submit it for GL2 Records$")
    public void click_submit_button_and_enter_remark_submit_it_for_gl2_records() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_Submit(), 30, 2);
		arapObj.ARAP_Submit().click();
		waithelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_Remark(), 30, 2);
		arapObj.ARAP_Remark().sendKeys(testData.get("Remark"));
		//waitHelper.waitForElementToVisibleWithFluentWait(driver, arapObj.ARAP_RemarkSubmit(), 30, 2);
		
		for (int i = 0; i <200; i++) {
			try {
				
				arapObj.ARAP_RemarkSubmit().click();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		waithelper.waitForElementToVisibleWithFluentWait(driver,arapObj.ARAP_ReviewerId(),30, 2);
		String reviwerId = arapObj.ARAP_ReviewerId().getText();
		String trimmdReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmdReviewerID);
		StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
		String finalReviewerID = bufferedString.toString();
		excelData.updateTestData(testData.get("Data Set ID"),"Reviewer ID", finalReviewerID);
		System.out.println(reviwerId);
    }
	
	// GL2 Journal Voucher
	
	
	@Then("^Click on General Ledger Transaction Field$")
	public void click_on_general_ledger_transaction_field() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_JournalVoucherObj.gL2_JournalVoucher_GeneralLedgerTransaction(), 10, 500);
		gL2_JournalVoucherObj.gL2_JournalVoucher_GeneralLedgerTransaction().click();

	}

	@Then("^Click on Journal Voucher EyeIcon$")
	public void click_on_journal_voucher_eyeicon() throws InterruptedException {
		waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_EyeButton(),
				5, 500);
		gL2_JournalVoucherObj.gL2_JournalVoucher_EyeButton().click();

	}

	@Then("^Click on Journal Voucher AddButton$")
	public void click_on_journal_voucher_addbutton() {
		waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_AddButton(),
				5, 500);
		gL2_JournalVoucherObj.gL2_JournalVoucher_AddButton().click();
	}
	@And("^User Select the branch code$")
    public void user_select_the_branch_code() throws Throwable {
		// BranchCode
				waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_BranchCode(),
						5, 500);
				gL2_JournalVoucherObj.gL2_JournalVoucher_BranchCode().click();
				gL2_JournalVoucherObj.gL2_JournalVoucher_BranchCode().sendKeys(testData.get("BranchCode"));
				String xpath ="//span[contains(text(),'"+testData.get("BranchCode")+"')]";
		        for (int i = 0; i <200; i++) {
					try {
						driver.findElement(By.xpath(xpath)).isDisplayed();
						break;
					} catch (NoSuchElementException e) {
						if (i==199) {
							Assert.fail("Branch code is not displayed in Dropdown");
						}
					}
				}
				gL2_JournalVoucherObj.gL2_JournalVoucher_BranchCode().sendKeys(Keys.ENTER);
    }

    @And("^User Select the Currency$")
    public void user_select_the_currency() throws Throwable {
    	// Currency
    			waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_Currency(), 5,
    					500);
    			gL2_JournalVoucherObj.gL2_JournalVoucher_Currency().click();
    			gL2_JournalVoucherObj.gL2_JournalVoucher_Currency().sendKeys(testData.get("Currency"));
    			String xpath ="//span[contains(text(),'"+testData.get("Currency")+"')]";
		        for (int i = 0; i <200; i++) {
					try {
						driver.findElement(By.xpath(xpath)).isDisplayed();
						break;
					} catch (NoSuchElementException e) {
						if (i==199) {
							Assert.fail("Currency is not displayed in Dropdown");
						}
					}
				}
    			gL2_JournalVoucherObj.gL2_JournalVoucher_Currency().sendKeys(Keys.ENTER);
    }

    @And("^User Select the Journal Voucher$")
    public void user_select_the_journal_voucher() throws Throwable {
    	// JournalType
    			waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_JournalType(),
    					5, 500);
    			gL2_JournalVoucherObj.gL2_JournalVoucher_JournalType().click();
    			gL2_JournalVoucherObj.gL2_JournalVoucher_JournalType().sendKeys(testData.get("JournalType"));
    			String xpath ="//span[contains(text(),'"+testData.get("JournalType")+"')]";
		        for (int i = 0; i <200; i++) {
					try {
						driver.findElement(By.xpath(xpath)).isDisplayed();
						break;
					} catch (NoSuchElementException e) {
						if (i==199) {
							Assert.fail("Journal Type is not displayed in Dropdown");
						}
					}
				}
    			gL2_JournalVoucherObj.gL2_JournalVoucher_JournalType().sendKeys(Keys.ENTER);
    }

	 @And("^User Select the profit center$")
	    public void user_select_the_profit_center() throws Throwable {
	
			waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_ProfitCenter(),
					5, 500);
			gL2_JournalVoucherObj.gL2_JournalVoucher_ProfitCenter().click();
			gL2_JournalVoucherObj.gL2_JournalVoucher_ProfitCenter().sendKeys(testData.get("ProfitCenter"));
			for (int i = 0; i <300; i++) {
				try {
					driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("ProfitCenter")+"')]")).isDisplayed();
					break;
				} catch (Exception e) {
					if (i==299) {
						Assert.fail(e.getMessage());
					}
				}
			}
			gL2_JournalVoucherObj.gL2_JournalVoucher_ProfitCenter().sendKeys(Keys.ENTER);
			waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.costOrDeparmentRequiredClose(),
					5, 500);
			gL2_JournalVoucherObj.costOrDeparmentRequiredClose().click();
	    }
	 @And("^User Select cost center or Department$")
	    public void user_select_cost_center_or_department() throws Throwable {
	       try {
	    	   waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_CostCenter(),
						5, 500);
				gL2_JournalVoucherObj.gL2_JournalVoucher_CostCenter().click();
				gL2_JournalVoucherObj.gL2_JournalVoucher_CostCenter().sendKeys(testData.get("CostCenter"));
				for (int i = 0; i <300; i++) {
					try {
						driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("CostCenter")+"')]")).isDisplayed();
						break;
					} catch (Exception e) {
						if (i==299) {
							Assert.fail(e.getMessage());
						}
					}
				}
				gL2_JournalVoucherObj.gL2_JournalVoucher_CostCenter().sendKeys(Keys.ENTER);
		} catch (Exception e) {
			waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_Department(),
					5, 500);
			gL2_JournalVoucherObj.gL2_JournalVoucher_Department().click();
			gL2_JournalVoucherObj.gL2_JournalVoucher_Department().sendKeys(testData.get("Department"));
			for (int i = 0; i <300; i++) {
			 try {
				 driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("Department")+"')]")).isDisplayed();
					break;
			} catch (Exception e2) {
				if (i==299) {
					Assert.fail(e.getMessage());
				}
			}
		}
			gL2_JournalVoucherObj.gL2_JournalVoucher_Department().sendKeys(Keys.ENTER);
		}   
	    }
	    @And("^User enter the remark for Journal Voucher$")
	    public void user_enter_the_remark_for_journal_voucher() throws Throwable {
	    	// Remark
			waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_Remark(), 5,
					500);
			gL2_JournalVoucherObj.gL2_JournalVoucher_Remark().click();
			gL2_JournalVoucherObj.gL2_JournalVoucher_Remark().sendKeys(testData.get("Remark"));
			gL2_JournalVoucherObj.gL2_JournalVoucher_Remark().sendKeys(Keys.ENTER);
	    }

	@Then("^Add Debit credit record$")
	public void add_debit_credit_record() throws InterruptedException {
		// DrCr
		waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_DrCr(), 5,
				500);
		gL2_JournalVoucherObj.gL2_JournalVoucher_DrCr().click();

		// Select Debit
		waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_Debit(), 5,
				500);
		gL2_JournalVoucherObj.gL2_JournalVoucher_Debit().click();

		// Glcode
		waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_GlCode(), 5,
				500);
		gL2_JournalVoucherObj.gL2_JournalVoucher_GlCode().click();
		// Thread.sleep(2000);
		// GlCodeDebit
		//waithelper.waitForElement(driver, 2000, gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeDebit());
		for (int i = 0; i <50; i++) {
			try {
				gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeDebit().click();
				break;
			} catch (Exception e) {
				if (i==49) {
					Assert.fail(e.getMessage());
				}
			}
		}
		// DebitAmount
		waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_DebitAmount(),
				5, 500);
		gL2_JournalVoucherObj.gL2_JournalVoucher_DebitAmount().click();
		gL2_JournalVoucherObj.gL2_JournalVoucher_DebitAmount().sendKeys(testData.get("DebitAmount"));
		gL2_JournalVoucherObj.gL2_JournalVoucher_DebitAmount().sendKeys(Keys.ENTER);

		// ActionButton
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_JournalVoucherObj.gL2_JournalVoucher_ActionButton(), 5, 500);
		gL2_JournalVoucherObj.gL2_JournalVoucher_ActionButton().click();

		// ------Credit--//
		// DrCrSecond
		waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_DrCrSecond(),
				5, 500);
		gL2_JournalVoucherObj.gL2_JournalVoucher_DrCrSecond().click();

		// Select Credit
		waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_Credit(), 5,
				500);
		for (int i = 0; i <= 150; i++) {
			try {
				gL2_JournalVoucherObj.gL2_JournalVoucher_Credit().click();
				break;
			} catch (Exception e) {
				if (i == 150) {
					Assert.fail(e.getMessage());
				}
			}
		}
		// Glcode-Second
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeSecond(), 5, 500);
		gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeSecond().click();

		// GlCode-Credit
		// Thread.sleep(1000);
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeCredit(), 5, 500);
		for (int i = 0; i <200; i++) {
			try {
				gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeCredit().click();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}

		// CreditAmount
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_JournalVoucherObj.gL2_JournalVoucher_CreditAmount(), 5, 500);
		gL2_JournalVoucherObj.gL2_JournalVoucher_CreditAmount().click();
		gL2_JournalVoucherObj.gL2_JournalVoucher_CreditAmount().sendKeys(testData.get("CreditAmount"));
		gL2_JournalVoucherObj.gL2_JournalVoucher_CreditAmount().sendKeys(Keys.ENTER);

		/*
		 * //ActionButton waithelper.waitForElement(driver,
		 * 2000,gL2_JournalVoucherObj.gL2_JournalVoucher_ActionButtonSecond());
		 * gL2_JournalVoucherObj.gL2_JournalVoucher_ActionButtonSecond().click();
		 */
	}

	@Then("^save the Journal Voucher record$")
	public void save_the_journal_voucher_record() {

		waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_Save(), 5,
				500);
		gL2_JournalVoucherObj.gL2_JournalVoucher_Save().click();

	}

	@And("^User Store the Journal Voucher Reference Number$")
	public void user_store_the_journal_voucher_reference_number() throws Throwable {
		javascripthelper.JavaScriptHelper(driver);
		String JvRefNum = null;
		for (int i = 0; i <200; i++) {
			try {
				 JvRefNum = javascripthelper.executeScript("return document.getElementsByName('voucherNo')[1].value").toString();
				System.out.println(JvRefNum);
				break;
			} catch (Exception e) {
				
			}
		}
		
		excelData.updateTestData("KUBS_GL2_UAT_003_003_D1","TransactionRefNumber", JvRefNum);
		excelData.updateTestData("KUBS_GL2_UAT_003_004_04_D1","TransactionRefNumber", JvRefNum);
		excelData.updateTestData("KUBS_GL2_UAT_003_005_D1","TransactionRefNumber", JvRefNum);
	}

	@And("^Verify the created Journal Voucher Record In Maker$")
	public void verify_the_created_journal_voucher_record_in_maker() throws Throwable {
		for (int i = 0; i <300; i++) {
			try {
				driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("ProfitCenter")+"')]")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==299) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}
	@And("^User Verify JV is reversed$")
    public void user_verify_jv_is_reversed() throws Throwable {
		javascripthelper.JavaScriptHelper(driver);
		String JvRefNum = null;
		for (int i = 0; i <200; i++) {
			try {
				 JvRefNum = javascripthelper.executeScript("return document.getElementsByName('voucherNo')[1].value").toString();
				System.out.println(JvRefNum);
				break;
			} catch (Exception e) {
				
			}
		}
		Assert.assertEquals(JvRefNum, testData.get("TransactionRefNumber"));
    }

	// --------------------KUBS_GL2_UAT_003_002---------------//

    @And("^Add Debit record in JV$")
    public void add_debit_record_in_jv() throws Throwable {
    	// ----------------DebitRecord----------//
    			// DrCr
    			waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_DrCr(), 5,
    					500);
    			gL2_JournalVoucherObj.gL2_JournalVoucher_DrCr().click();

    			// Select Debit
    			waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_Debit(), 5,
    					500);
    			gL2_JournalVoucherObj.gL2_JournalVoucher_Debit().click();

    			// Glcode
    			waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_GlCode(), 5,
    					500);
    			gL2_JournalVoucherObj.gL2_JournalVoucher_GlCode().click();

    			// GlCodeDebit
    			//waithelper.waitForElement(driver, 2000, gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeDebit());
    			for (int i = 0; i <200; i++) {
    				try {
    					gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeDebit().click();
    					break;
    				} catch (Exception e) {
    					if (i==199) {
    						Assert.fail(e.getMessage());
    					}
    				}
    			}
    			
    			// DebitAmount
    			waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_DebitAmount(),
    					5, 500);
    			gL2_JournalVoucherObj.gL2_JournalVoucher_DebitAmount().click();
    			gL2_JournalVoucherObj.gL2_JournalVoucher_DebitAmount().sendKeys(testData.get("DebitAmount"));
    			gL2_JournalVoucherObj.gL2_JournalVoucher_DebitAmount().sendKeys(Keys.ENTER);

    }

    @And("^Add First Credit record in JV$")
    public void add_first_credit_record_in_jv() throws Throwable {
    	// ActionButton
    			waithelper.waitForElementToVisibleWithFluentWait(driver,
    					gL2_JournalVoucherObj.gL2_JournalVoucher_ActionButton(), 5, 500);
    			gL2_JournalVoucherObj.gL2_JournalVoucher_ActionButton().click();

    			// -----------------------------CreditRecordFirst--------------------------//
    			// DrCrSecond
    			waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucherObj.gL2_JournalVoucher_DrCrSecond(),
    					5, 500);
    			gL2_JournalVoucherObj.gL2_JournalVoucher_DrCrSecond().click();

    			// Select Credit
    			for (int i = 0; i <200; i++) {
    				try {
    					clickAndActionHelper.moveToElement(gL2_JournalVoucherObj.gL2_JournalVoucher_Credit());
    					clickAndActionHelper.clickOnElement(gL2_JournalVoucherObj.gL2_JournalVoucher_Credit());
    					
    					break;
    				} catch (Exception e) {
    					if (i==199) {
    						Assert.fail(e.getMessage());
    					}
    				}
    			}
    			

    			// Glcode-Second
    			for (int i = 0; i <200; i++) {
    				try {
    					gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeSecond().click();
    					break;
    				} catch (Exception e) {
    					if (i==199) {
    						Assert.fail(e.getMessage());
    					}
    				}
    			}
    			

    			// GlCode-Credit

    			for (int i = 0; i <200; i++) {
    				try {
    					gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeCredit().click();
    					break;
    				} catch (Exception e) {
    					if (i==199) {
    						Assert.fail(e.getMessage());
    					}
    				}
    			}
    			

    			// CreditAmount
    			waithelper.waitForElementToVisibleWithFluentWait(driver,
    					gL2_JournalVoucherObj.gL2_JournalVoucher_CreditAmount(), 5, 500);
    			gL2_JournalVoucherObj.gL2_JournalVoucher_CreditAmount().click();
    			gL2_JournalVoucherObj.gL2_JournalVoucher_CreditAmount()
    					.sendKeys(testData.get("CreditAmountfirst"));
    			gL2_JournalVoucherObj.gL2_JournalVoucher_CreditAmount().sendKeys(Keys.ENTER);

    }

    @And("^Add Second Credit record in JV$")
    public void add_second_credit_record_in_jv() throws Throwable {
    	// ActionButton
    			waithelper.waitForElementToVisibleWithFluentWait(driver,
    					gL2_JournalVoucherObj.gL2_JournalVoucher_CreditAmount(), 5, 500);
    			gL2_JournalVoucherObj.gL2_JournalVoucher_ActionButtonSecond().click();

    			// -----------------------------CreditRecordSecond--------------------------//
    			// DrCrSecond
    			for (int i = 0; i <200; i++) {
    				try {
    					clickAndActionHelper.moveToElement(gL2_JournalVoucherObj.gL2_JournalVoucher_DrCrThird());
    					clickAndActionHelper.clickOnElement(gL2_JournalVoucherObj.gL2_JournalVoucher_DrCrThird());
    					break;
    				} catch (Exception e) {
    					if (i==199) {
    						Assert.fail(e.getMessage());
    					}
    				}
    			}
    			

    			// Select Credit
    			for (int i = 0; i <200; i++) {
    				try {
    					clickAndActionHelper.moveToElement(gL2_JournalVoucherObj.gL2_JournalVoucher_Credit());
    					clickAndActionHelper.clickOnElement(gL2_JournalVoucherObj.gL2_JournalVoucher_Credit());
    					break;
    				} catch (Exception e) {
    					if (i==199) {
    						Assert.fail(e.getMessage());
    					}
    				}
    			}
    			

    			// Glcode-Third
    			for (int i = 0; i <200; i++) {
    				try {
    					gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeThird().click();
    					break;
    				} catch (Exception e) {
    					if (i==199) {
    						Assert.fail(e.getMessage());
    					}
    				}
    			}
    			

    			// GlCode-CreditSecond

    			for (int i = 0; i <200; i++) {
    				try {
    					gL2_JournalVoucherObj.gL2_JournalVoucher_GlCodeCreditSecond().click();
    					break;
    				} catch (Exception e) {
    					if (i==199) {
    						Assert.fail(e.getMessage());
    					}
    				}
    			}
    			
    			// CreditAmountSecond
    			waithelper.waitForElementToVisibleWithFluentWait(driver,
    					gL2_JournalVoucherObj.gL2_JournalVoucher_CreditAmountSecond(), 5, 500);
    			gL2_JournalVoucherObj.gL2_JournalVoucher_CreditAmountSecond().click();
    			gL2_JournalVoucherObj.gL2_JournalVoucher_CreditAmountSecond()
    					.sendKeys(testData.get("CreditAmountSecond"));
    			gL2_JournalVoucherObj.gL2_JournalVoucher_CreditAmountSecond().sendKeys(Keys.ENTER);

    }
	
		@Then("^select Transaction from date Journal vourcher$")
	public void select_transaction_from_date_journal_vourcher() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_FromDate(), 5, 500);
		gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_FromDate().click();

		javascripthelper.JavaScriptHelper(driver);
		while (true) {
			try {

				waithelper
						.waitForElementToVisibleWithFluentWait(driver,
								driver.findElement(By.xpath("//span[contains(text(),'"
										+ gL2_JournalVoucher_AccountEntryReportTestDataType.GLMonth + " "
										+ gL2_JournalVoucher_AccountEntryReportTestDataType.GLYear + "')]")),
								5, 500);
				WebElement monthAndYear = driver.findElement(
						By.xpath("//span[contains(text(),'" + gL2_JournalVoucher_AccountEntryReportTestDataType.GLMonth
								+ " " + gL2_JournalVoucher_AccountEntryReportTestDataType.GLYear + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_NextMonth().click();
			}
		}
		WebElement FinalDay = driver.findElement(
				By.xpath("//td[@aria-label='" + gL2_JournalVoucher_AccountEntryReportTestDataType.GLFullMonth + " "
						+ gL2_JournalVoucher_AccountEntryReportTestDataType.GLDay + ", "
						+ gL2_JournalVoucher_AccountEntryReportTestDataType.GLYear + "']/span"));
		clicksAndActionHelper.moveToElement(FinalDay);
		clicksAndActionHelper.doubleClick(FinalDay);

	}

	@Then("^select Transaction to date Journal vourcher$")
	public void select_transaction_to_date_journal_vourcher() throws InterruptedException {
//		Thread.sleep(2000);
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_ToDate(), 5, 500);
		gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_ToDate().click();

		while (true) {
			try {

				waithelper
						.waitForElementToVisibleWithFluentWait(driver,
								driver.findElement(By.xpath("//span[contains(text(),'"
										+ gL2_JournalVoucher_AccountEntryReportTestDataType.GLToMonth + " "
										+ gL2_JournalVoucher_AccountEntryReportTestDataType.GLYear + "')]")),
								5, 500);
				WebElement monthAndYear = driver.findElement(By
						.xpath("//span[contains(text(),'" + gL2_JournalVoucher_AccountEntryReportTestDataType.GLToMonth
								+ " " + gL2_JournalVoucher_AccountEntryReportTestDataType.GLYear + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_NextMonth(), 5, 500);
				gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_NextMonth().click();
			}
		}
		WebElement FinalDay2 = driver.findElement(
				By.xpath("//td[@aria-label='" + gL2_JournalVoucher_AccountEntryReportTestDataType.GLFullToMonth + " "
						+ gL2_JournalVoucher_AccountEntryReportTestDataType.GLToDate + ", "
						+ gL2_JournalVoucher_AccountEntryReportTestDataType.GLYear + "']/span"));
		clicksAndActionHelper.moveToElement(FinalDay2);
		clicksAndActionHelper.doubleClick(FinalDay2);
	}

	@And("^click on view button for record$")
	public void click_on_view_button_for_record() throws InterruptedException {
		for (int i = 0; i <=200; i++) {
			try {
				clickAndActionHelper.moveToElement(gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_ViewButton());
				clickAndActionHelper.clickOnElement(gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_ViewButton());
				break;

			} catch (Exception e) {
				if (i ==200) {
					Assert.fail(e.getMessage());
				}
			}
		}
//		Thread.sleep(2000);

	}
	 @And("^User select branch code in financial Transaction$")
	    public void user_select_branch_code_in_financial_transaction() throws Throwable {
		 waithelper.waitForElementToVisibleWithFluentWait(driver,gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_BranchCode(),30, 2);
			gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_BranchCode()
					.sendKeys(testData.get("BranchCode"));
			for (int i = 0; i <200; i++) {
				try {
					driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("BranchCode")+"')]")).isDisplayed();
					break;
				} catch (Exception e) {
					if (i==199) {
						Assert.fail(e.getMessage());
					}
				}
			}
			gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_BranchCode()
					.sendKeys(Keys.ENTER);
			
//			gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_GlCode()
//					.sendKeys(gL2_JournalVoucher_AccountEntryReportTestDataType.GLCode);
//			gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_GlCode().sendKeys(Keys.ENTER);

	    }

	@And("^Select the Transaction Ref no for journal Voucher$")
    public void select_the_transaction_ref_no_for_journal_voucher() throws Throwable {
		gL2_JournalVoucher_AccountEntryReportObj.transactionRefNo().click();
		gL2_JournalVoucher_AccountEntryReportObj.transactionRefNo().sendKeys(testData.get("TransactionRefNumber"));
		for (int i = 0; i <2000; i++) {
			try {
				driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("TransactionRefNumber")+"')]")).click();
				break;
			} catch (Exception e) {
				if (i==1999) {
					Assert.fail(e.getMessage());
				}
			}
		}
		//gL2_JournalVoucher_AccountEntryReportObj.transactionRefNo().sendKeys(Keys.DOWN);
		//gL2_JournalVoucher_AccountEntryReportObj.transactionRefNo().sendKeys(Keys.ENTER);
    }
	@And("^Select the Transaction Ref no for Reversal journal Voucher$")
    public void select_the_transaction_ref_no_for_reversal_journal_voucher() throws Throwable {
		gL2_JournalVoucher_AccountEntryReportObj.transactionRefNo().click();
		gL2_JournalVoucher_AccountEntryReportObj.transactionRefNo().sendKeys(testData.get("TransactionRefNumber"));
		for (int i = 0; i <50; i++) {
			try {
				driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("TransactionRefNumber")+"')]")).isDisplayed();
				gL2_JournalVoucher_AccountEntryReportObj.transactionRefNo().sendKeys(Keys.DOWN);
				gL2_JournalVoucher_AccountEntryReportObj.transactionRefNo().sendKeys(Keys.ENTER);
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		
    }

	@Then("^validate Journal vourcher number$")
	public void validate_journal_vourcher_number() throws InterruptedException {
		javascripthelper.JavaScriptHelper(driver);
//		javascripthelper
//				.scrollIntoView(gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_Total());
//		Thread.sleep(2000);
		for (int j = 0; j <200; j++) {
			try {
				driver.findElement(By.xpath("//span[contains(text(),'"
						+ testData.get("TransactionRefNumber") + "')]")).isDisplayed();	
				break;
			}

			catch (Exception e) {

				if (j==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		System.out.println("Record is present in the list");

		}
		


//-------------------------------@KUBS_GL2_UAT_003_005 Reversal----------------------------------------//

	@Then("^validate Journal vourcher Reversal number$")
	public void validate_journal_vourcher_Reversal_number() throws InterruptedException {

//		javascripthelper.JavaScriptHelper(driver);
//		Thread.sleep(500);
//		javascripthelper
//				.scrollIntoView(gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_Total());

//		Thread.sleep(2000);
		while (true) {
			try {
				WebElement VoucherNum = driver.findElement(By.xpath("//span[contains(text(),'"
						+ testData.get("TransactionRefNumber") + "')]"));
				Assert.assertTrue(VoucherNum.isDisplayed());
				break;
			}

			catch (NoSuchElementException nosuchElement) {

				gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_Next().click();
			}

		}
		System.out.println("Record is present in the list");
	}

	// -------------------------------@KUBS_GL2_UAT_008_002 all the details
	// JournalVoucher----------------------------------------//

	@Then("^validate all the details for Journal vourcher$")
	public void validate_all_the_details_for_journal_vourcher() throws InterruptedException {
		javascripthelper.JavaScriptHelper(driver);
		javascripthelper
				.scrollIntoView(gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_Total());
//		Thread.sleep(2000);
		while (true) {
			try {

				waithelper.waitForElementToVisibleWithFluentWait(driver,
						driver.findElement(By.xpath("//span[contains(text(),'"
								+ gL2_JournalVoucher_AccountEntryReportTestDataType.Voucher + "')]")),
						5, 500);
				WebElement VoucherNum = driver.findElement(By.xpath("//span[contains(text(),'"
						+ gL2_JournalVoucher_AccountEntryReportTestDataType.Voucher + "')]"));

				waithelper.waitForElementToVisibleWithFluentWait(driver,
						driver.findElement(By.xpath("//span[contains(text(),'"
								+ gL2_JournalVoucher_AccountEntryReportTestDataType.Voucher1 + "')]")),
						5, 500);
				WebElement VoucherNum1 = driver.findElement(By.xpath("//span[contains(text(),'"
						+ gL2_JournalVoucher_AccountEntryReportTestDataType.Voucher1 + "')]"));

				waithelper.waitForElementToVisibleWithFluentWait(driver,
						driver.findElement(By.xpath("//span[contains(text(),'"
								+ gL2_JournalVoucher_AccountEntryReportTestDataType.Voucher2 + "')]")),
						5, 500);
				WebElement VoucherNum2 = driver.findElement(By.xpath("//span[contains(text(),'"
						+ gL2_JournalVoucher_AccountEntryReportTestDataType.Voucher2 + "')]"));

				break;
			}

			catch (NoSuchElementException nosuchElement) {

				gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_Next().click();
			}

		}
		System.out.println("Record is present in the list");

	}

	// -------------------------------@KUBS_GL2_UAT_008_003 all the details for JV
	// reversal----------------------------------------//

	@Then("^validate all the details for JV reversal$")
	public void validate_all_the_details_for_jv_reversal() throws InterruptedException {
		javascripthelper.JavaScriptHelper(driver);
		javascripthelper
				.scrollIntoView(gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_Total());
//		Thread.sleep(2000);
		while (true) {
			try {

				waithelper
						.waitForElementToVisibleWithFluentWait(driver,
								driver.findElement(By.xpath("//span[contains(text(),'"
										+ gL2_JournalVoucher_AccountEntryReportTestDataType.VoucherReverse + "')]")),
								5, 500);
				WebElement VoucherNum = driver.findElement(By.xpath("//span[contains(text(),'"
						+ gL2_JournalVoucher_AccountEntryReportTestDataType.VoucherReverse + "')]"));

				waithelper
				.waitForElementToVisibleWithFluentWait(driver,
						driver.findElement(By.xpath("//span[contains(text(),'"
								+ gL2_JournalVoucher_AccountEntryReportTestDataType.VoucherReverse1 + "')]")),
						5, 500);
				WebElement VoucherNum1 = driver.findElement(By.xpath("//span[contains(text(),'"
						+ gL2_JournalVoucher_AccountEntryReportTestDataType.VoucherReverse1 + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {

				gL2_JournalVoucher_AccountEntryReportObj.gL2_JournalVoucher_AccountEntryReport_Next().click();
			}

		}
		System.out.println("Record is present in the list");

	}
// reverse journal voucher
	@Then("^Click on Journal Voucher Reversal EyeIcon$")
	public void click_on_journal_voucher_reversal_eyeicon() throws InterruptedException {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_JournalVoucherReversalObj.gL2_JournalVoucherReversal_EyeButton(), 5, 500);
		gL2_JournalVoucherReversalObj.gL2_JournalVoucherReversal_EyeButton().click();

	}

	@Then("^Click on Journal Voucher Reversal Pencil Icon$")
	public void click_on_journal_voucher_reversal_pencil_icon() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_JournalVoucherReversalObj.gL2_JournalVoucherReversal_PencilIcon(), 5, 500);
		gL2_JournalVoucherReversalObj.gL2_JournalVoucherReversal_PencilIcon().click();

	}
	@And("^User Search JV Reverse as Yes$")
    public void user_search_jv_reverse_as_yes() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_JournalVoucherReversalObj.gL2_JournalVoucherReversal_PencilIcon(),30,2);
		gL2_JournalVoucherReversalObj.gL2_JVReversedStatus().click();
		gL2_JournalVoucherReversalObj.gL2_JVReversedStatus().sendKeys("Yes");
		
    }
	
	// GL reports
	
	@And("^user should navigate to general ledger transaction menu$")
	public void user_should_navigate_to_general_ledger_transaction_menu()  {
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_DirectionButton().click();
		waithelper.waitForElement(driver, 3000, generalLedger2_JournalVoucherObj.GeneralLedger2_JournalVoucher_GeneralLedgerTransactionMenu());
		generalLedger2_JournalVoucherObj.GeneralLedger2_JournalVoucher_GeneralLedgerTransactionMenu().click();
	}
	
	@When("^click on eye button of journal voucher$")
	public void click_on_eye_button_of_journal_voucher()  {
		waithelper.waitForElement(driver, 3000, generalLedger2_JournalVoucherObj.GeneralLedger2_JournalVoucher_JournalVoucherEyeButton());
		generalLedger2_JournalVoucherObj.GeneralLedger2_JournalVoucher_JournalVoucherEyeButton().click();
	}

	@Then("^click on the record to get the voucher number$")
	public void click_on_the_record_to_get_the_voucher_number() throws IOException, InterruptedException  {
		javascripthelper.JavaScriptHelper(driver);
		javascripthelper.JavaScriptHelper(driver);
		String JvRefNum = null;
		for (int i = 0; i <200; i++) {
			try {
				 JvRefNum = javascripthelper.executeScript("return document.getElementsByName('voucherNo')[1].value").toString();
				System.out.println(JvRefNum);
				break;
			} catch (Exception e) {
				
			}
		}
		excelData.updateTestData(testData.get("Data Set ID"),"TransactionRefNumber", JvRefNum);
	}
	
	@Then("^click on the record to get the GL number$")
    public void click_on_the_record_to_get_the_gl_number() throws IOException, InterruptedException {
		javascripthelper.JavaScriptHelper(driver);
		String glCode=null;
		for (int i = 0; i < 2000; i++) {
			try {
				glCode = driver.findElement(By.xpath("//app-kub-lov[@ng-reflect-lov-label='GL Code']//ion-select[1]")).getAttribute("aria-label");
				break;
			} catch (Exception e) {
				if (i==1999) {
					Assert.fail(e.getMessage());
				}
			}
		}
		System.out.println(glCode);
		
		excelData.updateTestData(testData.get("Data Set ID"),"TransactionRefNumber", glCode);
    }
	
	@Then("^click on the record to get the transaction date$")
	public void click_on_the_record_to_get_the_transaction_date() throws IOException, InterruptedException {
		javascripthelper.JavaScriptHelper(driver);
		waithelper.waitForElement(driver, 3000, generalLedger2_JournalVoucherObj.GeneralLedger2_JournalVoucher_RecordVoucherNumberEyeButton());
		generalLedger2_JournalVoucherObj.GeneralLedger2_JournalVoucher_RecordVoucherNumberEyeButton().click();
//		String glcode=generalLedger2_JournalVoucherObj.GeneralLedger2_JournalVoucher_GLCode().getText();
		Thread.sleep(2000);
		String txnDate=javascripthelper.executeScript("return document.getElementsByClassName('form-control p-0')[0].value").toString();
		System.out.println(txnDate);
		jsonWriter=new JsonDataReaderWriter();
		jsonWriter.addData(txnDate);
	}
	@And("^User Select the Branch Code for  Check the Transactions$")
    public void user_select_the_branch_code_for_check_the_transactions() throws Throwable {
		waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_BranchCode());
		eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_BranchCode().sendKeys(JournalVoucherTestDataType.BranchCode);
		for (int i = 0; i <200; i++) {
			try {
				driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+JournalVoucherTestDataType.BranchCode+"')]")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}	
		eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_BranchCode().sendKeys(Keys.ENTER);
		
    }
	
	@And("^fill the reference number field of financial transaction$")
	public void fill_the_reference_number_field_of_financial_transaction() throws IOException, ParseException  {
		
		waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_TransactionRefNumber());
		eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_TransactionRefNumber().sendKeys(testData.get("TransactionRefNumber"));
		for (int i = 0; i <20000; i++) {
			try {
				driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("TransactionRefNumber")+"')]")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==19999) {
					Assert.fail(e.getMessage());
				}
			}
		}
		eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_TransactionRefNumber().sendKeys(Keys.ENTER);
		
	}
	
	@And("^fill the reference number field of financial transaction to check accounting entries post billing$")
	public void fill_the_reference_number_field_of_financial_transaction_to_check_accounting_entries_post_billing() throws IOException, ParseException  {
		waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_BranchCode());
		eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_BranchCode().sendKeys(InvoiceBookingTestDataType.EntityBranch);
		eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_BranchCode().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_TransactionRefNumber());
		eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_TransactionRefNumber().sendKeys(jsonWriter.readdata());
		eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_TransactionRefNumber().sendKeys(Keys.ENTER);
		
	}
	 @And("^User select the Branch Code for Check the transactions as per GL$")
	    public void user_select_the_branch_code_for_check_the_transactions_as_per_gl() throws Throwable {
		 waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_BranchCode());
		 eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_BranchCode().sendKeys(JournalVoucherTestDataType.BranchCode);
			for (int i = 0; i <200; i++) {
				try {
					driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+JournalVoucherTestDataType.BranchCode+"')]")).isDisplayed();
					break;
				} catch (Exception e) {
					if (i==199) {
						Assert.fail(e.getMessage());
					}
				}
			}	
			eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_BranchCode().sendKeys(Keys.ENTER);
	    }

	@And("^fill the GL number field of financial transaction$")
	public void fill_the_gl_number_field_of_financial_transaction() throws IOException, ParseException {
		waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_GlCode());
		eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_GlCode().sendKeys(testData.get("TransactionRefNumber").trim());
		for (int i = 0; i <2000; i++) {
			try {
				driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("TransactionRefNumber").trim()+"')]")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==1999) {
					Assert.fail(e.getMessage());
				}
			}
		}
		eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_GlCode().sendKeys(Keys.ENTER);
	}

	@And("^fill the date field of financial transaction$")
	public void fill_the_date_field_of_financial_transaction() throws IOException, ParseException {
		waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_BranchCode());
		eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_BranchCode().sendKeys(JournalVoucherTestDataType.BranchCode);
		eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_BranchCode().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_FromDate());
		eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_FromDate().click();
		
		while(true)
        {
		try
		{
		
			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+UpdateChequeStatusTestDataType.GLMonth+" "+UpdateChequeStatusTestDataType.GLYear+"')]")));
			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+UpdateChequeStatusTestDataType.GLMonth+" "+UpdateChequeStatusTestDataType.GLYear+"')]"));
		    break;
		}
		
		catch(NoSuchElementException nosuchElement)
		{
			waithelper.waitForElementToVisibleWithFluentWait(driver, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextMonth(), 5, 500);
			eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextMonth().click();
		}
		}
		WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+UpdateChequeStatusTestDataType.GLFullMonth+" "+UpdateChequeStatusTestDataType.GLDay+", "+UpdateChequeStatusTestDataType.GLYear+"']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
    	
    	waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ToDate());
    	eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ToDate().click();
    	
    	while(true)
        {
		try
		{
		
			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+UpdateChequeStatusTestDataType.GLToMonth+" "+UpdateChequeStatusTestDataType.GLYear+"')]")));
			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+UpdateChequeStatusTestDataType.GLToMonth+" "+UpdateChequeStatusTestDataType.GLYear+"')]"));
		    break;
		}
		
		catch(NoSuchElementException nosuchElement)
		{
			eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextMonth().click();
		}
		}
		WebElement FinalDay2=driver.findElement(By.xpath("//td[@aria-label='"+UpdateChequeStatusTestDataType.GLFullToMonth+" "+UpdateChequeStatusTestDataType.GLToDate+", "+UpdateChequeStatusTestDataType.GLYear+"']/span"));
		clicksAndActionHelper.doubleClick(FinalDay2);

	}
	
	@Then("^click on view button to view the report as per reference number$")
	public void click_on_view_button_to_view_the_report_as_per_reference_number()  {
		waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ViewButton());
		clickAndActionHelper.moveToElement(eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ViewButton());
		clickAndActionHelper.clickOnElement(eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ViewButton());
	}
	
	// Financials Reports
	@And("^user should navigate to financial reporting menu$")
	public void user_should_navigate_to_financial_reporting_menu() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				financialReporting_GLBalancesReportObj.FinancialReportingMenu(), 5, 500);
		financialReporting_GLBalancesReportObj.FinancialReportingMenu().click();
	}

	@Then("^click on temp grid button of GL Balances report$")
	public void click_on_temp_grid_button_of_gl_balances_report() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_TempGridButton(), 5, 500);
		financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_TempGridButton().click();
	}

	 @And("^User Select the branch code for GL Balances report$")
	    public void user_select_the_branch_code_for_gl_balances_report() throws Throwable {
		 waithelper.waitForElementToVisibleWithFluentWait(driver,
					financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_BranchCode(), 5, 500);
			financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_BranchCode()
					.sendKeys(GLBalancesReportTestDataType.BranchCode);
			for (int i = 0; i <200; i++) {
				try {
					driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+GLBalancesReportTestDataType.BranchCode+"')]")).isDisplayed();
					break;
				} catch (Exception e) {
					if (i==199) {
						Assert.fail(e.getMessage());
					}
				}
			}
			financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_BranchCode().sendKeys(Keys.ENTER);
	    }

    @And("^User Select the report type for GL Balances report$")
    public void user_select_the_report_type_for_gl_balances_report() throws Throwable {
    	waithelper.waitForElementToVisibleWithFluentWait(driver,financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_Report_Type(),30, 2);
        financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_Report_Type().click();
        financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_Report_Type().sendKeys("Own branch");
        for (int i = 0; i <200; i++) {
			try {
				driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'Own branch')]")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
        financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_Report_Type().sendKeys(Keys.ENTER);
    }

    @And("^User Select the GL code for GL Balances report$")
    public void user_select_the_gl_code_for_gl_balances_report() throws Throwable {
    	waithelper.waitForElementToVisibleWithFluentWait(driver,
				financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_GlCode(), 5, 500);
		financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_GlCode()
				.sendKeys(GLBalancesReportTestDataType.GLCode);
		for (int i = 0; i <200; i++) {
			try {
				driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+GLBalancesReportTestDataType.GLCode+"')]")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}	
    }
		financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_GlCode().sendKeys(Keys.ENTER);
    }

    @And("^User Choose the GL balances From Date for GL Balances report$")
    public void user_choose_the_gl_balances_from_date_for_gl_balances_report() throws Throwable {
    	waithelper.waitForElementToVisibleWithFluentWait(driver,
				financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_GLBalancesFromDate(), 5,
				500);
		financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_GLBalancesFromDate().click();

		while (true) {
			try {

				waithelper.waitForElementToVisibleWithFluentWait(driver,
						driver.findElement(By.xpath("//span[contains(text(),'" + GLBalancesReportTestDataType.GLMonth
								+ " " + GLBalancesReportTestDataType.GLYear + "')]")),
						5, 500);
				WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'"
						+ GLBalancesReportTestDataType.GLMonth + " " + GLBalancesReportTestDataType.GLYear + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextMonth().click();
			}
		}
		WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='"
				+ GLBalancesReportTestDataType.GLFullMonth + " " + GLBalancesReportTestDataType.GLDate + ", "
				+ GLBalancesReportTestDataType.GLYear + "']/span"));
		clicksAndActionHelper.moveToElement(FinalDay);
		clicksAndActionHelper.doubleClick(FinalDay);
/*
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_GLBalancesToDate(), 5, 500);
		financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_GLBalancesToDate().click();

		while (true) {
			try {

				waithelper.waitForElementToVisibleWithFluentWait(driver,
						driver.findElement(By.xpath("//span[contains(text(),'" + GLBalancesReportTestDataType.GLToMonth
								+ " " + GLBalancesReportTestDataType.GLToYear + "')]")),
						5, 500);
				WebElement monthAndYear = driver
						.findElement(By.xpath("//span[contains(text(),'" + GLBalancesReportTestDataType.GLToMonth + " "
								+ GLBalancesReportTestDataType.GLToYear + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextMonth().click();
			}
		}
		WebElement FinalDay2 = driver.findElement(By.xpath("//td[@aria-label='"
				+ GLBalancesReportTestDataType.GLFullToMonth + " " + GLBalancesReportTestDataType.GLToDate + ", "
				+ GLBalancesReportTestDataType.GLToYear + "']/span"));
		clicksAndActionHelper.moveToElement(FinalDay2);
		clicksAndActionHelper.doubleClick(FinalDay2);
		*/

    }

    @And("^User Select the Currency for GL Balances report$")
    public void user_select_the_currency_for_gl_balances_report() throws Throwable {
    	waithelper.waitForElementToVisibleWithFluentWait(driver,
				financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_Currency(), 5, 500);
		financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_Currency()
				.sendKeys(GLBalancesReportTestDataType.Currency);
		financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_Currency().sendKeys(Keys.ENTER);
		
    }

	@Then("^click on view button to view the report for any period$")
	public void click_on_view_button_to_view_the_report_for_any_period() throws InterruptedException {

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_ViewButton(), 5, 500);
		financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_ViewButton().click();
		Thread.sleep(3000);
		browserHelper.switchToParentWithChildClose();

	}

	// ------------------GL Monthly balances Report

	@Then("^click on temp grid button of GL monthly balances report$")
	public void click_on_temp_grid_button_of_gl_monthly_balances_report() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				financialReporting_GLBalancesReportObj.FinancialReporting_GLMonthlyBalancesReport_TempGridButton(), 5,
				500);
		financialReporting_GLBalancesReportObj.FinancialReporting_GLMonthlyBalancesReport_TempGridButton().click();
	}
	@And("^User select the branch code for GL Monthly Balances$")
    public void user_select_the_branch_code_for_gl_monthly_balances() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_BranchCode(), 5, 500);
		financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_BranchCode()
				.sendKeys(testData.get("Branch Code GL Monthly Balance"));
		for (int i = 0; i <200; i++) {
			try {
				driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("Branch Code GL Monthly Balance")+"')]")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_BranchCode().sendKeys(Keys.ENTER);
	}

    @And("^User Select the report type for GL Monthly Balances$")
    public void user_select_the_report_type_for_gl_monthly_balances() throws Throwable {
        waithelper.waitForElementToVisibleWithFluentWait(driver,financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_Report_Type(),30, 2);
        financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_Report_Type().click();
        financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_Report_Type().sendKeys(testData.get("Report Type GL Monthly Balance"));
        for (int i = 0; i <200; i++) {
			try {
				driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("Report Type GL Monthly Balance")+"')]")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
        financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_Report_Type().sendKeys(Keys.ENTER);
    }

    @And("^User Select the GL code for GL Monthly Balances$")
    public void user_select_the_gl_code_for_gl_monthly_balances() throws Throwable {
    	waithelper.waitForElementToVisibleWithFluentWait(driver,
				financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_GlCode(), 5,
				500);
		financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_GlCode()
				.sendKeys(testData.get("GL Code Monthly Balance"));
		for (int i = 0; i <200; i++) {
			try {
				driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("GL Code Monthly Balance")+"')]")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_GlCode().sendKeys(Keys.ENTER);
    }

    @And("^User Select the Currency for GL Monthly Balances$")
    public void user_select_the_currency_for_gl_monthly_balances() throws Throwable {
    	waithelper.waitForElementToVisibleWithFluentWait(driver,
				financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_CurrencyForMonthly(), 5,
				500);
		financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_CurrencyForMonthly()
				.sendKeys(testData.get("CurrenyForMonthlyBalancesReport"));
		for (int i = 0; i <200; i++) {
			try {
				driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("CurrenyForMonthlyBalancesReport")+"')]")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_CurrencyForMonthly()
		.sendKeys(Keys.ENTER);
    }
    @And("^User Choose GL Balances From Date$")
    public void user_choose_gl_balances_from_date() throws Throwable {
    	waithelper.waitForElementToVisibleWithFluentWait(driver,
				financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_GLBalancesFromDate(), 5,
				500);
		financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_GLBalancesFromDate().click();

		while (true) {
			try {

				waithelper.waitForElementToVisibleWithFluentWait(driver,
						driver.findElement(By.xpath("//span[contains(text(),'"
								+ testData.get("GLMonthForMonthlyBalancesReport") + " "
								+ testData.get("GLYearForMonthlyBalancesReport") + "')]")),
						5, 500);
				WebElement monthAndYear = driver.findElement(By
						.xpath("//span[contains(text(),'" + testData.get("GLMonthForMonthlyBalancesReport")
								+ " " + testData.get("GLYearForMonthlyBalancesReport") + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextMonth().click();
			}
		}
		WebElement FinalDay = driver.findElement(
				By.xpath("//td[@aria-label='" + testData.get("GLFullMonthForMonthlyBalancesReport") + " "
						+ GLBalancesReportTestDataType.GLDateForMonthlyBalancesReport + ", "
						+ GLBalancesReportTestDataType.GLYearForMonthlyBalancesReport + "']/span"));
		clicksAndActionHelper.moveToElement(FinalDay);
		clicksAndActionHelper.doubleClick(FinalDay);

		

    }


	@Then("^click on view button to view the report for monthly period$")
	public void click_on_view_button_to_view_the_report_for_monthly_period() throws InterruptedException {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_ViewButton(), 5, 500);
		financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_ViewButton().click();
		browserHelper.SwitchToWindow(1);
		Thread.sleep(3000);
		browserHelper.switchToParentWithChildClose();

	}








	}
