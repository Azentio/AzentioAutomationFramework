package stepdefinitions;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedHashMap;
import java.util.List;
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
import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.Selenium_Actions;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ACCOUNTSPAYABLE_InvoiceBookingObj;
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
import pageobjects.ARAP_ARandAPObj;
import pageobjects.AccountingSetup_ChartOfAccountsDefinitionObj;
import pageobjects.AccountsReceivable_ReceiptsReversalsObj;
import pageobjects.AccountsReceivable_UpdateChequeStatusObj;
import pageobjects.Accounts_Payable;
import pageobjects.ArAp_Cancellation_of_vendorObj;
import pageobjects.ENQUIRY_FinancialTransactionObj;
import pageobjects.Enquiry_Obj;
import pageobjects.FinancialReporting_GLBalancesReportObj;
import pageobjects.FinancialReporting_TrialBalanceReportObj;
import pageobjects.GL2_FinancialTransactionReportObj;
import pageobjects.GL2_JournalVoucherObj;
import pageobjects.GL2_JournalVoucherReversalObj;
import pageobjects.GL2_JournalVoucher_AccountEntryReportObj;
import pageobjects.GL2_LegalEntityGLConfigObj;
import pageobjects.GL_Accounting_Setup_Obj;
import pageobjects.GeneralLedger2_JournalVoucherObj;
import pageobjects.Gl_Reports_Obj1;
import pageobjects.JobScheduler_JobExecutionObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_MakerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;
import testDataType.ACCOUNTSPAYABLE_InvoiceBookingTestDataType;
import testDataType.AccountsReceivable_UpdateChequeStatusTestDataType;
import testDataType.FinancialReporting_GLBalancesReportTestDataType;
import testDataType.FinancialReporting_TrialBalanceReportTestDataType;
import testDataType.GL2_FinancialTransactionReportTestDataType;
import testDataType.GL2_JournalVoucherTestDataType;
import testDataType.GL2_JournalVoucher_AccountEntryReportTestDataType;
import testDataType.GL2_LegalEntityGLConfigTestDataType;
import testDataType.GL_ModuleTestData;
import testDataType.GeneralLedger2_JournalVoucherTestDataType;
import testDataType.JobScheduler_JobExecutionTestDataType;

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
	BrowserHelper browserHelper = new BrowserHelper(driver);
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	//Financials reports
	
	FinancialReporting_GLBalancesReportObj financialReporting_GLBalancesReportObj = new FinancialReporting_GLBalancesReportObj(
			driver);
	FinancialReporting_GLBalancesReportTestDataType GLBalancesReportTestDataType = jsonReader
			.getGLBalancesReportdata("Maker");
	// batch execution
	JobScheduler_JobExecutionObj jobScheduler_JobExecutionObj = new JobScheduler_JobExecutionObj(driver);
	JobScheduler_JobExecutionTestDataType JobExecutionTestDataType = jsonReader.getJobExecutiondata("Maker");
	// GL Reports
	Gl_Reports_Obj1 glReportsObj = new Gl_Reports_Obj1(driver);
	Selenium_Actions seleniumactions = new Selenium_Actions(driver);
	ConfigFileReader configreader = new ConfigFileReader();
	JsonConfig jsonconfig = new JsonConfig();
	ArAp_Cancellation_of_vendorObj cancellationofcontract = new ArAp_Cancellation_of_vendorObj(driver);
	Accounts_Payable accounts_PayableObj = new Accounts_Payable(driver);
	GL_ModuleTestData glModuleData = jsonconfig.getGlmoduleTestDataByName("Maker");
	JavascriptHelper javascriphelper = new JavascriptHelper();
	Enquiry_Obj enquiryObj = new Enquiry_Obj(driver);
	Map<String, String> testdata = new LinkedHashMap<>();
	// financial reports
	KUBS_MakerObj kubsMakerObj = new KUBS_MakerObj(driver);
	JsonConfig jsonConfig = new JsonConfig();
	GL2_FinancialTransactionReportObj gL2_FinancialTransactionReportObj = new GL2_FinancialTransactionReportObj(driver);
	GL2_FinancialTransactionReportTestDataType gL2_FinancialTransactionReportTestDataType = jsonReader
			.getFinancialTransactionReportByName("Maker");
	// trial balance report
	
	FinancialReporting_TrialBalanceReportObj financialReporting_TrialBalanceReportObj = new FinancialReporting_TrialBalanceReportObj(
			driver);
	AccountingSetup_ChartOfAccountsDefinitionObj accountingSetup_ChartOfAccountsDefinitionObj = new AccountingSetup_ChartOfAccountsDefinitionObj(
			driver);
	FinancialReporting_TrialBalanceReportTestDataType TrialBalanceReportTestDataType = jsonReader
			.getTrialBalanceReportdata("Maker");
	
	
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
	@When("^click the Direction icon$")
	public void click_the_direction_icon() throws Throwable {
		Thread.sleep(900);
		waithelper.waitForElementToVisibleWithFluentWait(driver, cancellationofcontract.getOptionicon(), 20,
				500);
		clicksAndActionHelper.clickOnElement(cancellationofcontract.getOptionicon());
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
			for (int i = 0; i <20000; i++) {
				try {
					driver.findElement(By.xpath(befr_xpath +testData.get("Reference ID")+ aftr_xpath)).click();
					break;
				} catch (Exception e) {
					if (i==19999) {
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
	 @And("^User update the test data id for Check GL balance for any period$")
	    public void user_update_the_test_data_id_for_check_gl_balance_for_any_period() throws Throwable {
		 testData = excelData.getTestdata("KUBS_GL2_UAT_005_001_D1");
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
        for (int i = 0; i <20000; i++) {
			try {
				Assert.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				if (i==19999) {
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
    @And("^User select the JV Transaction number to display all the details for JV$")
    public void user_select_the_jv_transaction_number_to_display_all_te_details_for_jv() throws Throwable {
    	gL2_JournalVoucher_AccountEntryReportObj.transactionRefNo().click();
		gL2_JournalVoucher_AccountEntryReportObj.transactionRefNo().sendKeys(testdata.get("JvRefNum"));
		for (int i = 0; i <200000; i++) {
			try {
				driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testdata.get("JvRefNum")+"')]")).click();
				break;
			} catch (Exception e) {
				if (i==199999) {
					Assert.fail(e.getMessage());
				}
			}
		}
		//gL2_JournalVoucher_AccountEntryReportObj.transactionRefNo().sendKeys(Keys.DOWN);
		//gL2_JournalVoucher_AccountEntryReportObj.transactionRefNo().sendKeys(Keys.ENTER);
    }

    @And("^User select the JV Transaction number to display all the details for JV reversal$")
    public void user_select_the_jv_transaction_number_to_display_all_the_details_for_jv_reversal() throws Throwable {
    	gL2_JournalVoucher_AccountEntryReportObj.transactionRefNo().click();
		gL2_JournalVoucher_AccountEntryReportObj.transactionRefNo().sendKeys(testdata.get("JvRefNum"));
		for (int i = 0; i <200000; i++) {
			try {
				driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testdata.get("JvRefNum")+"')]")).click();
				break;
			} catch (Exception e) {
				if (i==199999) {
					Assert.fail(e.getMessage());
				}
			}
		}
    }
    @And("^User select the Branch Code for verify details of JV$")
    public void user_select_the_branch_code_for_verify_details_of_jv() throws Throwable {
    	waithelper.waitForElement(driver, 3000,
				financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_BranchCode());
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_BranchCode()
				.sendKeys(testData.get("BranchCode"));
		for (int i = 0; i <200; i++) {
			try {
				driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("BranchCode")+"')]")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}	
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_BranchCode()
				.sendKeys(Keys.ENTER);

    }
    @And("^User select the Branch Code for verify details of JV Reversal$")
    public void user_select_the_branch_code_for_verify_details_of_jv_reversal() throws Throwable {
    	waithelper.waitForElement(driver, 3000,
				financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_BranchCode());
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_BranchCode()
				.sendKeys(testData.get("BranchCode"));
		for (int i = 0; i <200; i++) {
			try {
				driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("BranchCode")+"')]")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}	
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_BranchCode()
				.sendKeys(Keys.ENTER);
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
		for (int i = 0; i <20000; i++) {
			try {
				driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("TransactionRefNumber")+"')]")).click();
				break;
			} catch (Exception e) {
				if (i==19999) {
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
		for (int i = 0; i <200; i++) {
			try {
				// gl code 1
				driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("glCode11")+"')]")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		for (int i = 0; i <200; i++) {
			try {
				// gl code 2
				driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("glCode21")+"')]")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		for (int i = 0; i <200; i++) {
			try {
				// gl code 3
				driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("glCode31")+"')]")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		
		
		for (int i = 0; i <200; i++) {
			try {
				// gl description
				driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("glCode12")+"')]")).isDisplayed();
				driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("glCode22")+"')]")).isDisplayed();
				driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("glCode32")+"')]")).isDisplayed();
			    break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		for (int i = 0; i <200; i++) {
			try {
				// credit debit 
				driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("crDr1")+"')]")).isDisplayed();
				driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("crDr2")+"')]")).isDisplayed();
				driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("crDr3")+"')]")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		for (int i = 0; i <200; i++) {
			try {
				// verify credit and debit Amount 
				driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("Amount1")+"')]")).isDisplayed();
				driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("Amount2")+"')]")).isDisplayed();
				driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("Amount3")+"')]")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		
			}

	// -------------------------------@KUBS_GL2_UAT_008_003 all the details for JV
	// reversal----------------------------------------//

	@Then("^validate all the details for JV reversal$")
	public void validate_all_the_details_for_jv_reversal() throws InterruptedException {
		for (int i = 0; i <200; i++) {
			try {
				// gl code 1
				driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("glCode11")+"')]")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		for (int i = 0; i <200; i++) {
			try {
				// gl code 2
				driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("glCode21")+"')]")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		for (int i = 0; i <200; i++) {
			try {
				// gl code 3
				driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("glCode31")+"')]")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		
		
		for (int i = 0; i <200; i++) {
			try {
				// gl description
				driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("glCode12")+"')]")).isDisplayed();
				driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("glCode22")+"')]")).isDisplayed();
				driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("glCode32")+"')]")).isDisplayed();
			    break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		for (int i = 0; i <200; i++) {
			try {
				// credit debit 
				driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("crDr1")+"')]")).isDisplayed();
				driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("crDr2")+"')]")).isDisplayed();
				driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("crDr3")+"')]")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		for (int i = 0; i <200; i++) {
			try {
				// verify credit and debit Amount 
				driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("Amount1")+"')]")).isDisplayed();
				driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("Amount2")+"')]")).isDisplayed();
				driver.findElement(By.xpath("//span[contains(text(),'"+testdata.get("Amount3")+"')]")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		

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
				glCode = driver.findElement(By.xpath("(//app-kub-lov[@ng-reflect-lov-label='GL Code']//ion-select[1])[1]")).getAttribute("aria-label");
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
	@And("^Get all details of Journal Voucher$")
    public void get_all_details_of_journal_voucher() throws Throwable {
		javascripthelper.JavaScriptHelper(driver);
		String JvRefNum = null;
		for (int i = 0; i <200; i++) {
			try {
				JvRefNum = javascripthelper.executeScript("return document.getElementsByName('voucherNo')[1].value").toString();
				System.out.println(JvRefNum);
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		testdata.put("JvRefNum", JvRefNum);
		String glCode1=null;
		for (int i = 0; i < 2000; i++) {
			try {
				glCode1 = driver.findElement(By.xpath("(//app-kub-lov[@ng-reflect-lov-label='GL Code']//ion-select[1])[1]")).getAttribute("aria-label");
				break;
			} catch (Exception e) {
				if (i==1999) {
					Assert.fail(e.getMessage());
				}
			}
		}
		System.out.println(glCode1);
		String[] split = glCode1.split("-");
		String glCode11 = split[0].trim();
		System.out.println(glCode11);
		String glCode = split[1]+"-"+split[2];
		String glCode12 = glCode.trim();
		System.out.println(glCode12);
		//FD with Central Bank of India (Non-Current)
		testdata.put("glCode11", glCode11);
		testdata.put("glCode12", glCode12);
		String glCode2=null;
		for (int i = 0; i < 2000; i++) {
			try {
				glCode2 = driver.findElement(By.xpath("(//app-kub-lov[@ng-reflect-lov-label='GL Code']//ion-select[1])[2]")).getAttribute("aria-label");
				break;
			} catch (Exception e) {
				if (i==1999) {
					Assert.fail(e.getMessage());
				}
			}
		}
		String[] split1 = glCode2.split("-");
		String glCode21 = split1[0].trim();
		System.out.println(glCode21);
		String glCode22 = split1[1].trim();
		System.out.println(glCode22);
		//FD with Central Bank of India (Non-Current)
		testdata.put("glCode21", glCode21);
		testdata.put("glCode22", glCode22);
		String glCode3=null;
		for (int i = 0; i < 2000; i++) {
			try {
				glCode3 = driver.findElement(By.xpath("(//app-kub-lov[@ng-reflect-lov-label='GL Code']//ion-select[1])[3]")).getAttribute("aria-label");
				break;
			} catch (Exception e) {
				if (i==1999) {
					Assert.fail(e.getMessage());
				}
			}
		}
		String[] split2 = glCode3.split("-");
		String glCode31 = split2[0].trim();
		System.out.println(glCode31);
		String glCode32 = split2[1].trim();
		System.out.println(glCode32);
		//FD with Central Bank of India (Non-Current)
		testdata.put("glCode31", glCode31);
		testdata.put("glCode32", glCode32);

				String crDr1=null;
				for (int i = 0; i < 2000; i++) {
					try {
						crDr1 = driver.findElement(By.xpath("(//app-kub-lov[@ng-reflect-lov-label='Cr/Dr']//ion-select[1])[1]")).getAttribute("aria-label");
						break;
					} catch (Exception e) {
						if (i==1999) {
							Assert.fail(e.getMessage());
						}
					}
				}
				testdata.put("crDr1", crDr1.trim());
				System.out.println(testdata.get("crDr1"));
				String crDr2=null;
				for (int i = 0; i < 2000; i++) {
					try {
						crDr2 = driver.findElement(By.xpath("(//app-kub-lov[@ng-reflect-lov-label='Cr/Dr']//ion-select[1])[2]")).getAttribute("aria-label");
						break;
					} catch (Exception e) {
						if (i==1999) {
							Assert.fail(e.getMessage());
						}
					}
				}
				testdata.put("crDr2", crDr2.trim());
				System.out.println(testdata.get("crDr2"));
				String crDr3=null;
				for (int i = 0; i < 2000; i++) {
					try {
						crDr3 = driver.findElement(By.xpath("(//app-kub-lov[@ng-reflect-lov-label='Cr/Dr']//ion-select[1])[3]")).getAttribute("aria-label");
						break;
					} catch (Exception e) {
						if (i==1999) {
							Assert.fail(e.getMessage());
						}
					}
				}
				testdata.put("crDr3", crDr3.trim());
				System.out.println(testdata.get("crDr3"));
				javascriphelper.JavaScriptHelper(driver);
				String Amount1 = null;
				for (int i = 0; i < 2000; i++) {
					try {
						Amount1 = javascriphelper.executeScript("return document.getElementsByTagName('input')[20].value").toString();
						break;
					} catch (Exception e) {
						if (i==1999) {
							Assert.fail(e.getMessage());
						}
					}
				}
				testdata.put("Amount1", Amount1);
				System.out.println(testdata.get("Amount1"));
				String Amount2 = null;
				for (int i = 0; i < 2000; i++) {
					try {
						Amount2 = javascriphelper.executeScript("return document.getElementsByTagName('input')[23].value").toString();
						break;
					} catch (Exception e) {
						if (i==1999) {
							Assert.fail(e.getMessage());
						}
					}
				}
				testdata.put("Amount2", Amount2);
				System.out.println(testdata.get("Amount2")); 
				String Amount3 = null;
				for (int i = 0; i < 2000; i++) {
					try {
						Amount3 = javascriphelper.executeScript("return document.getElementsByTagName('input')[23].value").toString();
						break;
					} catch (Exception e) {
						if (i==1999) {
							Assert.fail(e.getMessage());
						}
					}
				}
				testdata.put("Amount3", Amount3);
				System.out.println(testdata.get("Amount3"));
		
    }
	@And("^Get all details of Journal Voucher Reversal$")
    public void get_all_details_of_journal_voucher_reversal() throws Throwable {
		javascripthelper.JavaScriptHelper(driver);
		String JvRefNum = null;
		for (int i = 0; i <200; i++) {
			try {
				JvRefNum = javascripthelper.executeScript("return document.getElementsByTagName('ion-input')[5].value").toString();
				System.out.println(JvRefNum);
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		testdata.put("JvRefNum", JvRefNum);
		String glCode1=null;
		for (int i = 0; i < 2000; i++) {
			try {
				glCode1 = driver.findElement(By.xpath("(//app-kub-lov[@ng-reflect-lov-label='GL Code']//ion-select[1])[1]")).getAttribute("aria-label");
				break;
			} catch (Exception e) {
				if (i==1999) {
					Assert.fail(e.getMessage());
				}
			}
		}
		System.out.println(glCode1);
		String[] split = glCode1.split("-");
		String glCode11 = split[0].trim();
		System.out.println(glCode11);
		String glCode = split[1]+"-"+split[2];
		String glCode12 = glCode.trim();
		System.out.println(glCode12);
		//FD with Central Bank of India (Non-Current)
		testdata.put("glCode11", glCode11);
		testdata.put("glCode12", glCode12);
		String glCode2=null;
		for (int i = 0; i < 2000; i++) {
			try {
				glCode2 = driver.findElement(By.xpath("(//app-kub-lov[@ng-reflect-lov-label='GL Code']//ion-select[1])[2]")).getAttribute("aria-label");
				break;
			} catch (Exception e) {
				if (i==1999) {
					Assert.fail(e.getMessage());
				}
			}
		}
		String[] split1 = glCode2.split("-");
		String glCode21 = split1[0].trim();
		System.out.println(glCode21);
		String glCode22 = split1[1].trim();
		System.out.println(glCode22);
		//FD with Central Bank of India (Non-Current)
		testdata.put("glCode21", glCode21);
		testdata.put("glCode22", glCode22);
		String glCode3=null;
		for (int i = 0; i < 2000; i++) {
			try {
				glCode3 = driver.findElement(By.xpath("(//app-kub-lov[@ng-reflect-lov-label='GL Code']//ion-select[1])[3]")).getAttribute("aria-label");
				break;
			} catch (Exception e) {
				if (i==1999) {
					Assert.fail(e.getMessage());
				}
			}
		}
		String[] split2 = glCode3.split("-");
		String glCode31 = split2[0].trim();
		System.out.println(glCode31);
		String glCode32 = split2[1].trim();
		System.out.println(glCode32);
		//FD with Central Bank of India (Non-Current)
		testdata.put("glCode31", glCode31);
		testdata.put("glCode32", glCode32);

				String crDr1=null;
				for (int i = 0; i < 2000; i++) {
					try {
						crDr1 = driver.findElement(By.xpath("(//app-kub-lov[@ng-reflect-lov-label='Cr/Dr']//ion-select[1])[1]")).getAttribute("aria-label");
						break;
					} catch (Exception e) {
						if (i==1999) {
							Assert.fail(e.getMessage());
						}
					}
				}
				testdata.put("crDr1", crDr1.trim());
				System.out.println(testdata.get("crDr1"));
				String crDr2=null;
				for (int i = 0; i < 2000; i++) {
					try {
						crDr2 = driver.findElement(By.xpath("(//app-kub-lov[@ng-reflect-lov-label='Cr/Dr']//ion-select[1])[2]")).getAttribute("aria-label");
						break;
					} catch (Exception e) {
						if (i==1999) {
							Assert.fail(e.getMessage());
						}
					}
				}
				testdata.put("crDr2", crDr2.trim());
				System.out.println(testdata.get("crDr2"));
				String crDr3=null;
				for (int i = 0; i < 2000; i++) {
					try {
						crDr3 = driver.findElement(By.xpath("(//app-kub-lov[@ng-reflect-lov-label='Cr/Dr']//ion-select[1])[3]")).getAttribute("aria-label");
						break;
					} catch (Exception e) {
						if (i==1999) {
							Assert.fail(e.getMessage());
						}
					}
				}
				testdata.put("crDr3", crDr3.trim());
				System.out.println(testdata.get("crDr3"));
				javascriphelper.JavaScriptHelper(driver);
				String Amount1 = null;
				for (int i = 0; i < 2000; i++) {
					try {
						Amount1 = javascriphelper.executeScript("return document.getElementsByTagName('input')[20].value").toString();
						break;
					} catch (Exception e) {
						if (i==1999) {
							Assert.fail(e.getMessage());
						}
					}
				}
				testdata.put("Amount1", Amount1);
				System.out.println(testdata.get("Amount1"));
				String Amount2 = null;
				for (int i = 0; i < 2000; i++) {
					try {
						Amount2 = javascriphelper.executeScript("return document.getElementsByTagName('input')[23].value").toString();
						break;
					} catch (Exception e) {
						if (i==1999) {
							Assert.fail(e.getMessage());
						}
					}
				}
				testdata.put("Amount2", Amount2);
				System.out.println(testdata.get("Amount2")); 
				String Amount3 = null;
				for (int i = 0; i < 2000; i++) {
					try {
						Amount3 = javascriphelper.executeScript("return document.getElementsByTagName('input')[23].value").toString();
						break;
					} catch (Exception e) {
						if (i==1999) {
							Assert.fail(e.getMessage());
						}
					}
				}
				testdata.put("Amount3", Amount3);
				System.out.println(testdata.get("Amount3"));

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
				financialReporting_GLBalancesReportObj.FinancialReportingMenu(), 30, 500);
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
					.sendKeys(testData.get("Branch Code GL Balances Report"));
			for (int i = 0; i <200; i++) {
				try {
					driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("Branch Code GL Balances Report")+"')]")).isDisplayed();
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
        financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_Report_Type().sendKeys(testData.get("Report Type GL Balances Report"));
        for (int i = 0; i <200; i++) {
			try {
				driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("Report Type GL Balances Report")+"')]")).isDisplayed();
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
				.sendKeys(testData.get("GL Code GL Balances Report"));
		for (int i = 0; i <200; i++) {
			try {
				driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("GL Code GL Balances Report")+"')]")).isDisplayed();
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
						driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("GLToMonth GL Balances Report")
								+ " " + testData.get("GLToYear GL Balances Report") + "')]")),
						5, 500);
				WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'"
						+ testData.get("GLToMonth GL Balances Report") + " " + testData.get("GLToYear GL Balances Report") + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextMonth().click();
			}
		}
		WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='"
				+ testData.get("GLToFullMonth GL Balances Report") + " " + testData.get("GLToDate GL Balances Report") + ", "
				+ testData.get("GLToYear GL Balances Report") + "']/span"));
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
    	financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_Currency().click();
    	financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_Currency()
				.sendKeys(testData.get("CurrenyForGL Balances Report"));
    	for (int i = 0; i <200; i++) {
			try {
				driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("CurrenyForGL Balances Report")+"')]")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}	
    }
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
		//browserHelper.SwitchToWindow(1);
		Thread.sleep(3000);
		browserHelper.switchToParentWithChildClose();

	}
	
	// JOB Execution
	
	@Then("^Select configuration$")
	public void selet_configuration() {
		waithelper.waitForElementToVisibleWithFluentWait(driver, jobScheduler_JobExecutionObj.configuration_option(), 10,
				500);
		clicksAndActionHelper.moveToElement(jobScheduler_JobExecutionObj.configuration_option());
			
		jobScheduler_JobExecutionObj.configuration_option().click();
	}
	@And("^User Update the test data set id for Configure batch Job$")
    public void user_update_the_test_data_set_id_for_configure_batch_job() throws Throwable {
        testData = excelData.getTestdata("KUBS_GL2_UAT_007_001_D1");
    }
	@And("^User Update test data set id for Income Statement report$")
    public void user_update_test_data_set_id_for_income_statement_report() throws Throwable {
		testData = excelData.getTestdata("KUBS_GL2_UAT_008_013_D1");
    }
	@And("^User Update test data set id for Cashflow statement report$")
    public void user_update_test_data_set_id_for_cashflow_statement_report() throws Throwable {
		testData = excelData.getTestdata("KUBS_GL2_UAT_008_012_D1");
    }

	@And("^User Update test data set id for balancesheet report$")
	public void user_update_test_data_set_id_for_balancesheet_report() throws Throwable {
		testData = excelData.getTestdata("KUBS_GL2_UAT_008_011_D1");
	}

	@And("^User Update test data set id for trial balance based on the given from date to till date$")
	public void user_update_test_data_set_id_for_trial_balance_based_on_the_given_from_date_to_till_date()
			throws Throwable {
		testData = excelData.getTestdata("KUBS_GL2_UAT_008_010_D1");
	}
	@And("^User Update test data set id for trial balance based on the leaf GL$")
    public void user_update_test_data_set_id_for_trial_balance_based_on_the_leaf_gl() throws Throwable {
		testData = excelData.getTestdata("KUBS_GL2_UAT_008_009_D1");
    }
	@And("^User Update test data set id for trial balance$")
    public void user_update_test_data_set_id_for_trial_balance() throws Throwable {
		testData = excelData.getTestdata("KUBS_GL2_UAT_008_007_D1");
    }
	@And("^User update the test data set id to display all the details for JV$")
    public void user_update_the_test_data_set_id_to_display_all_the_details_for_jv() throws Throwable {
		testData = excelData.getTestdata("KUBS_GL2_UAT_008_002_D1");
    }

    @And("^User update the test data set id to display all the details for JV reversal$")
    public void user_update_the_test_data_set_id_to_display_all_the_details_for_jv_reversal() throws Throwable {
    	testData = excelData.getTestdata("KUBS_GL2_UAT_008_003_D1");
    }
    @And("^User update the test data set id for GL monthly balances$")
    public void user_update_the_test_data_set_id_for_gl_monthly_balances() throws Throwable {
    	testData = excelData.getTestdata("KUBS_GL2_UAT_008_005_D1");
    }
    @And("^User Update test data set id to Check Report for financial transaction$")
    public void user_update_test_data_set_id_to_check_report_for_financial_transaction() throws Throwable {
    	testData = excelData.getTestdata("KUBS_GL2_UAT_008_006_D1");
    }

	@And("^User Update test data set id for trial balance summary$")
    public void user_update_test_data_set_id_for_trial_balance_summary() throws Throwable {
		testData = excelData.getTestdata("KUBS_GL2_UAT_008_008_D1");
    }

	@And("^User get the system for job execution$")
	public void user_get_the_system_for_job_execution() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,jobScheduler_JobExecutionObj.systemDate(), 30, 2);
		String systemdate = jobScheduler_JobExecutionObj.systemDate().getText();
//		System.out.println(systemdate);
		String[] split = systemdate.split("-");
		int date = Integer.parseInt(split[0]);
//		System.out.println(date);
		String month = split[1];
//		System.out.println(month);
		int year = Integer.parseInt(split[2]);
//		System.out.println(year);
		int monthNum;
		switch (month) {
		case "Jan":
			monthNum = 1;
			break;
		case "Feb":
			monthNum = 2;
			break;
		case "Mar":
			monthNum = 3;
			break;
		case "Apr":
			monthNum = 4;
			break;
		case "May":
			monthNum = 5;
			break;
		case "Jun":
			monthNum = 6;
			break;
		case "Jul":
			monthNum = 7;
			break;
		case "Aug":
			monthNum = 8;
			break;
		case "Sep":
			monthNum = 9;
			break;
		case "Oct":
			monthNum = 10;
			break;
		case "Nov":
			monthNum = 11;
			break;
		case "Dec":
			monthNum = 12;
			break;
		default:
			monthNum = 0;
			break;
		}
//        System.out.println(monthNum);

		LocalDate Date = LocalDate.of(year, monthNum, date);
		String JobExecutionDate = Date.plusDays(1).toString();
//		System.out.println(JobExecutionDate);
		String[] split2 = JobExecutionDate.split("-");
		String yearExecution =split2[0];
		testdata.put("yearExecution", yearExecution);
		int jobExecutionMonth = Integer.parseInt(split2[1]);
		String jobDate=split2[2];
		testdata.put("jobDate", jobDate);
		String monthString;
        switch (jobExecutionMonth) {
            case 1:  monthString = "Jan";       break;
            case 2:  monthString = "Feb";      break;
            case 3:  monthString = "Mar";         break;
            case 4:  monthString = "Apr";         break;
            case 5:  monthString = "May";           break;
            case 6:  monthString = "Jun";          break;
            case 7:  monthString = "Jul";          break;
            case 8:  monthString = "Aug";        break;
            case 9:  monthString = "Sep";     break;
            case 10: monthString = "Oct";       break;
            case 11: monthString = "Nov";      break;
            case 12: monthString = "Dec";      break;
            default: monthString = "Invalid month"; break;
        }
        testdata.put("Tomonth", monthString);
        int jobExecutionFullMonth = Integer.parseInt(split2[1]);
        String fullMonthString;
        switch (jobExecutionFullMonth) {
            case 1:  fullMonthString = "January";       break;
            case 2:  fullMonthString = "February";      break;
            case 3:  fullMonthString = "March";         break;
            case 4:  fullMonthString = "April";         break;
            case 5:  fullMonthString = "May";           break;
            case 6:  fullMonthString = "June";          break;
            case 7:  fullMonthString = "July";          break;
            case 8:  fullMonthString = "August";        break;
            case 9:  fullMonthString = "September";     break;
            case 10: fullMonthString = "October";       break;
            case 11: fullMonthString = "November";      break;
            case 12: fullMonthString = "December";      break;
            default: fullMonthString = "Invalid month"; break;
        }
        testdata.put("FullMonth", fullMonthString);
		
	}
	@And("^user should navigate to job scheduler menu$")
	public void user_should_navigate_to_job_scheduler_menu() {
		waithelper.waitForElementToVisibleWithFluentWait(driver, jobScheduler_JobExecutionObj.JobSchedulerMenu(), 5,
				500);
		jobScheduler_JobExecutionObj.JobSchedulerMenu().click();
	}

	@When("^click on temp grid button of job execution$")
	public void click_on_temp_grid_button_of_job_execution() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				jobScheduler_JobExecutionObj.JobScheduler_JobExecution_TempGrid(), 5, 500);
		jobScheduler_JobExecutionObj.JobScheduler_JobExecution_TempGrid().click();
	}

	@And("^select the date to start job$")
	public void select_the_date_to_start_job() {

		waithelper.waitForElementToVisibleWithFluentWait(driver,
				jobScheduler_JobExecutionObj.JobScheduler_JobExecution_ToDate(), 5, 500);
		jobScheduler_JobExecutionObj.JobScheduler_JobExecution_ToDate().click();
		while (true) {
			try {

				waithelper.waitForElementToVisibleWithFluentWait(
						driver, driver.findElement(By.xpath("//span[contains(text(),'"
								+ testdata.get("Tomonth") + " " + testdata.get("yearExecution") + "')]")),
						5, 500);
//				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"
//						+ JobExecutionTestDataType.ToMonth + " " + JobExecutionTestDataType.ToYear + "')]")));
				WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'"
						+ testdata.get("Tomonth") + " " + testdata.get("yearExecution") + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				jobScheduler_JobExecutionObj.JobScheduler_JobExecution_NextMonth().click();
			}
		}
		WebElement FinalDay2 = driver.findElement(By.xpath("//td[@aria-label='" + testdata.get("FullMonth")
				+ " " + testdata.get("jobDate") + ", " + testdata.get("yearExecution") + "']/span"));
		clicksAndActionHelper.moveToElement(FinalDay2);
		clicksAndActionHelper.doubleClick(FinalDay2);
	}

	@Then("^Click on start job$")
	public void click_on_start_job() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				jobScheduler_JobExecutionObj.JobScheduler_JobExecution_StartJobButton(), 5, 500);
		jobScheduler_JobExecutionObj.JobScheduler_JobExecution_StartJobButton().click();
	}

// --------   Job definition

	@When("^click on temp grid button of job definition$")
	public void click_on_temp_grid_button_of_job_definition() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_TempGrid(), 5, 500);
		jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_TempGrid().click();
	}

	@Then("^click on add button to config job$")
	public void click_on_add_button_to_config_job() {
		for (int i = 0; i <200; i++) {
			try {
				jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_AddButton().click();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}	
		
	}
	@And("^User Enter Job Code$")
    public void user_enter_job_code() throws Throwable {
		Random random = new Random();
		int RanNo1 = random.nextInt(700-10)+10;
	    int RanNo2 = random.nextInt(90-1)+10;
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_JobCode(), 50, 500);
		jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_JobCode().sendKeys(testData.get("JobCode")+RanNo1+RanNo2);
    }

    @And("^User Enter Jobe Name$")
    public void user_enter_jobe_name() throws Throwable {
		Random random = new Random();
		int RanNo3 = random.nextInt(900 - 10) + 10;
		int RanNo4 = random.nextInt(60 - 1) + 10;
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_JobName(), 5, 500);
		jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_JobName()
				.sendKeys(testData.get("JobName") + RanNo3 + RanNo4);
    }

    @And("^User Enter the Application Name$")
    public void user_enter_the_application_name() throws Throwable {
    	Random random = new Random();
    	int RanNo5 = random.nextInt(500-10)+10;
	    int RanNo6 = random.nextInt(20-1)+10;
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_ApplicationName(), 5, 500);
		jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_ApplicationName()
				.sendKeys(testData.get("ApplicationName")+RanNo5+RanNo6);
    }

    @And("^User Enter Module Code$")
    public void user_enter_module_code() throws Throwable {
    	Random random = new Random();
    	int RanNo7 = random.nextInt(300-10)+10;
	    int RanNo8 = random.nextInt(50-1)+10;
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_ModuleCode(), 5, 500);
		jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_ModuleCode()
				.sendKeys(testData.get("ModuleCode")+RanNo7+RanNo8);
    }

    @And("^User Select the Process Name$")
    public void user_select_the_process_name() throws Throwable {
    	waithelper.waitForElementToVisibleWithFluentWait(driver,
				jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_ProcessName(), 5, 500);
		jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_ProcessName()
				.sendKeys(testData.get("ProcessName"));
		for (int i = 0; i <200; i++) {
			try {
				driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("ProcessName")+"')]")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}	
		jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_ProcessName().sendKeys(Keys.ENTER);
    }

    @And("^User Select the Job Type$")
    public void user_select_the_job_type() throws Throwable {
    	waithelper.waitForElementToVisibleWithFluentWait(driver,
				jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_JobType(), 5, 500);
		jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_JobType().sendKeys(testData.get("JobType"));
		for (int i = 0; i <200; i++) {
			try {
				driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("JobType")+"')]")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}	
		jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_JobType().sendKeys(Keys.ENTER);
    }

    @And("^User Enter the number of Threads for batch job$")
    public void user_enter_the_number_of_threads_for_batch_job() throws Throwable {
    	waithelper.waitForElementToVisibleWithFluentWait(driver,
				jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_NumberOfThreads(), 5, 500);
		jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_NumberOfThreads()
				.sendKeys(testData.get("NumberOfThreads"));
    }

    @And("^User Enter the Sequence Number$")
    public void user_enter_the_sequence_number() throws Throwable {
    	waithelper.waitForElementToVisibleWithFluentWait(driver,
				jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_SequenceNumber(), 5, 500);
		jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_SequenceNumber()
				.sendKeys(testData.get("SequenceNumber"));
    }

    @And("^User Enter the remarks for Batch Job$")
    public void user_enter_the_remarks_for_batch_job() throws Throwable {
    	waithelper.waitForElementToVisibleWithFluentWait(driver,
				jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_Remarks(), 5, 500);
		jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_Remarks().sendKeys(testData.get("Remark"));

    }

	@Then("^click on save button1$")
	public void click_on_save_button1() throws InterruptedException {
//		Thread.sleep(1000);
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_SaveButton(), 5, 500);
		jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_SaveButton().click();

//		Thread.sleep(1000);
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_RecordStatus(), 5, 500);
		WebElement recordstatus = jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_RecordStatus();

		clicksAndActionHelper.moveToElement(recordstatus);
		String message = jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_RecordStatus().getText();
		System.out.println(message);
		jobScheduler_JobExecutionObj.JobScheduler_JobDefinition_RecordStatus().click();
	}
	// GL Balances Reports
	@Given("^Login as a Azentio Maker$")
	public void login_as_a_azentio_maker() throws Throwable {
		login = new KUBS_Login(driver);
		driver.get(configreader.getApplicationUrl());
		login.loginToAzentioAppByMaker();

	}

	

	@Then("^verify that available balance should equal to closing net balance in Gl balance Report$")
	public void verify_that_available_balance_should_equal_to_closing_net_balance_in_gl_balance_report()
			throws Throwable {
		//// *[@id="__bookmark_1"]/tbody/tr[3]/td[15]/div
		seleniumactions.getBrowserHelper().SwitchToWindow(1);

		for (int j = 1; j < 20; j++) {
			String Glbalance = "";
			for (int i = 3; i < 45; i++) {
				try {
					String xpath = "//*[@id=\"__bookmark_1\"]/tbody/tr[" + i + "]/td[15]/div";
					javascriphelper.JavaScriptHelper(driver);
					javascriphelper.scrollIntoView(driver.findElement(By.xpath(xpath)));
					String amount = driver.findElement(By.xpath(xpath)).getText();
					// System.out.println(amount);
					String string = amount.split("[.]")[0].toString();
					// System.out.println(string);
					String replace = string.replace(",", "");
					// System.out.println(replace);
					Glbalance = replace.trim().replace(" ", "");
					// System.out.println(Glbalance);
					// - 5022000
					// -5022000

					// System.out.println("Verified Avaliable in the Report
					// :"+driver.findElement(By.xpath(xpath)).getText());
				} catch (Exception e) {
					glReportsObj.nextPageInGlbalanceReport().click();
				}
				if (Glbalance.equalsIgnoreCase(testdata.get("Glbalance"))) {
					System.out.println("Verified Gl balance in the report :" + Glbalance);
					break;
				}
			}
			if (Glbalance.equalsIgnoreCase(testdata.get("Glbalance"))) {
				break;
			}
		}
		seleniumactions.getBrowserHelper().switchToParentWithChildClose();
	}

	@And("^click the Account Payable Main Module$")
	public void click_the_account_payable_main_module() throws Throwable {
		seleniumactions.getWaitHelper().waitForElementToVisibleWithFluentWait(driver,
				cancellationofcontract.getAccountspayable(), 20, 500);
		seleniumactions.getClickAndActionsHelper().clickOnElement(cancellationofcontract.getAccountspayable());
	}

	@And("^click the Manual Payout Eye icon$")
	public void click_the_manual_payout_eye_icon() throws Throwable {
		javascriphelper.JavaScriptHelper(driver);
		javascriphelper.scrollIntoView(glReportsObj.manualPayoutEyeIcon());
		glReportsObj.manualPayoutEyeIcon().click();
	}

	@And("^click the Add icon in Manual Payout$")
	public void click_the_add_icon_in_manual_payout() throws Throwable {
		for (int i = 0; i <200; i++) {
			try {
				glReportsObj.manualPayoutAddIcon().click();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		
	}

	@And("^Select the entity branch$")
	public void select_the_entity_branch() throws Throwable {
		glReportsObj.manualPayoutSelectEntityBranch().click();
		glReportsObj.manualPayoutSelectEntityBranch().sendKeys(glModuleData.branchCode);
		glReportsObj.manualPayoutSelectEntityBranch().sendKeys(Keys.ENTER);
	}

	@And("^Select the Buisness Partner Name$")
	public void select_the_buisness_partner_name() throws Throwable {
		glReportsObj.manualPayoutSelectBp().click();
		glReportsObj.manualPayoutSelectBp().sendKeys(Keys.ENTER);

	}

	@And("^Select the beneficiary name$")
	public void select_the_beneficiary_name() throws Throwable {
		glReportsObj.manualPayoutSelectBeneficiaryName().click();
	}

	@And("^Select the currency type$")
	public void select_the_currency_type() throws Throwable {
		glReportsObj.manualPayoutSelectBeneficiaryName().click();
		glReportsObj.manualPayoutSelectBeneficiaryName().sendKeys(Keys.ENTER);
	}

	@And("^click the calender and select the valid date$")
	public void click_the_calender_and_select_the_valid_date() throws Throwable {
		enquiryObj.calenderInContractReport().click();
		seleniumactions.getWaitHelper().waitForElementToVisibleWithFluentWait(driver,
				driver.findElement(
						By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]")),
				20, 500);
		driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]"))
				.click();
		seleniumactions.getWaitHelper().waitForElementToVisibleWithFluentWait(driver,
				driver.findElement(By.xpath("//span[text()='" + glModuleData.GlYear + "']")), 20, 500);
		driver.findElement(By.xpath("//span[text()='" + glModuleData.GlYear + "']")).click();
		driver.findElement(By.xpath("//span[text()='" + glModuleData.GlMonth + "']")).click();
		seleniumactions.getWaitHelper()
				.waitForElementToVisibleWithFluentWait(driver, driver.findElement(By.xpath("//td[@aria-label='"
						+ glModuleData.GlFullMonth + " " + glModuleData.GlDay + ", " + glModuleData.GlYear + "']")), 20,
						500);
		driver.findElement(By.xpath("//td[@aria-label='" + glModuleData.GlFullMonth + " " + glModuleData.GlDay + ", "
				+ glModuleData.GlYear + "']")).click();
	}

	@And("^Select bank in manual payout$")
	public void select_bank_in_manual_payout() throws Throwable {
		glReportsObj.manualPayoutSelectBank().click();
		glReportsObj.manualPayoutSelectBank().sendKeys(glModuleData.PaymentBank);
		glReportsObj.manualPayoutSelectBank().sendKeys(Keys.ENTER);
	}

	@And("^Select the bank Account Number$")
	public void select_the_bank_account_number() throws Throwable {
		glReportsObj.manualPayoutSelectBankAccountNumber().click();
		glReportsObj.manualPayoutSelectBankAccountNumber().sendKeys(Keys.ENTER);
	}

	@And("^get the Available balance and store$")
	public void get_the_available_balance_and_store() throws Throwable {
		javascriphelper.JavaScriptHelper(driver);
		String Availablebalance = (String) javascriphelper
				.executeScript("return document.getElementById('availableBalance').value");
		System.out.println(Availablebalance);
		String[] Balance = Availablebalance.split("[.]");
		String Glbalance = Balance[0].toString();
		System.out.println(Glbalance);
		String GlBalance = Glbalance.replace(",", "");
		System.out.println(GlBalance);
		testdata.put("Glbalance", GlBalance);
		// String AvailabeBalance= Balance.substring(0,1)+","+Balance.substring(1,
		// 2)+Balance.substring(3, 5)+Balance.substring(5);
		// testdata.put("AvailableBalance", AvailabeBalance);
		// System.out.println(AvailabeBalance);
	}

	@And("^click the notes option$")
	public void click_the_notes_option() throws Throwable {
		javascriphelper.JavaScriptHelper(driver);
		javascriphelper.scrollIntoView(enquiryObj.inventoryReportIcon());
		enquiryObj.inventoryReportIcon().click();

	}

	@And("^click the financial Report$")
	public void click_the_financial_report() throws Throwable {
		seleniumactions.getWaitHelper().waitForElementToVisibleWithFluentWait(driver, enquiryObj.financialReporting(), 20, 500);
		enquiryObj.financialReporting().click();
	}

	@And("^click the Gl balance report edit icon$")
	public void click_the_gl_balance_report_edit_icon() throws Throwable {
		glReportsObj.FinancialTransactionIcon().click();
		;
	}

	@And("^select the branch$")
	public void select_the_branch() throws Throwable {
		glReportsObj.glBalanceReportSelectBranch().click();
		glReportsObj.glBalanceReportSelectBranch().sendKeys(glModuleData.branchCode);
		glReportsObj.glBalanceReportSelectBranch().sendKeys(Keys.ENTER);
	}

	@And("^select the Gl code$")
	public void select_the_gl_code() throws Throwable {
		glReportsObj.glBalanceReportSelectGlcode().click();
		glReportsObj.glBalanceReportSelectGlcode().sendKeys(glModuleData.gLCode);
		glReportsObj.glBalanceReportSelectGlcode().sendKeys(Keys.ENTER);

	}

	@And("^Select the Gl from date$")
	public void select_the_gl_from_date() throws Throwable {
		enquiryObj.calenderInContractReport().click();
		seleniumactions.getWaitHelper().waitForElementToVisibleWithFluentWait(driver,
				driver.findElement(
						By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]")),
				20, 500);
		driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]"))
				.click();

		seleniumactions.getWaitHelper().waitForElementToVisibleWithFluentWait(driver,
				driver.findElement(By.xpath("//span[text()='" + glModuleData.GlYear + "']")), 20, 500);
		driver.findElement(By.xpath("//span[text()='" + glModuleData.GlYear + "']")).click();
		driver.findElement(By.xpath("//span[text()='" + glModuleData.GlMonth + "']")).click();
		seleniumactions.getWaitHelper()
				.waitForElementToVisibleWithFluentWait(driver, driver.findElement(By.xpath("//td[@aria-label='"
						+ glModuleData.GlFullMonth + " " + glModuleData.GlDay + ", " + glModuleData.GlYear + "']")), 20,
						500);
		driver.findElement(By.xpath("//td[@aria-label='" + glModuleData.GlFullMonth + " " + glModuleData.GlDay + ", "
				+ glModuleData.GlYear + "']")).click();
	}

	@And("^Select the Gl To date$")
	public void select_the_gl_to_date() throws Throwable {
		enquiryObj.calenderInContractReport().click();
		seleniumactions.getWaitHelper().waitForElementToVisibleWithFluentWait(driver,
				driver.findElement(
						By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]")),
				20, 500);
		driver.findElement(By.xpath("(//span[@class='owl-dt-control-content owl-dt-control-button-content'])[2]"))
				.click();

		seleniumactions.getWaitHelper().waitForElementToVisibleWithFluentWait(driver,
				driver.findElement(By.xpath("//span[text()='" + glModuleData.GlYear + "']")), 20, 500);
		driver.findElement(By.xpath("//span[text()='" + glModuleData.GlYear + "']")).click();
		driver.findElement(By.xpath("//span[text()='" + glModuleData.GlToMonth + "']")).click();
		seleniumactions.getWaitHelper().waitForElementToVisibleWithFluentWait(driver,
				driver.findElement(By.xpath("(//span[text()='" + glModuleData.GlToDate + "'])[1]")), 20, 500);
		driver.findElement(By.xpath("(//span[text()='" + glModuleData.GlToDate + "'])[1]")).click();
	}

	@And("^select the currency type in gl balance report$")
	public void select_the_currency_type_in_gl_balance_report() throws Throwable {
		glReportsObj.glBalanceReportCurrency().click();
		glReportsObj.glBalanceReportCurrency().sendKeys(glModuleData.CurrencyType);
	}

	@And("^click the View button$")
	public void click_the_view_button() throws Throwable {
		glReportsObj.glViewButton().click();
	}

	// ************************************KUBS_GL_UAT_007_001**************************************************************************
	// Check the accounting mapping done for the accounting Scheme
	@When("^user click the Accounting setup$")
	public void user_click_the_accounting_setup() throws Throwable {
		seleniumactions.getWaitHelper().waitForElementToVisibleWithFluentWait(driver, glReportsObj.accountingSetup(), 20, 500);
		glReportsObj.accountingSetup().click();
	}

	@Then("^verify the mapping of accounintg entries to be triggered$")
	public void verify_the_mapping_of_accounintg_entries_to_be_triggered() throws Throwable {
		String xpath = "//ul/li/span[contains(text(),'ASSET MONTHLY DEPRECIATION')]";
		javascriphelper.JavaScriptHelper(driver);
		javascriphelper.scrollIntoView(driver.findElement(By.xpath(xpath)));
		driver.findElement(By.xpath(xpath)).isDisplayed();
	}

	@And("^click the accounting scheme definition eye icon$")
	public void click_the_accounting_scheme_definition_eye_icon() throws Throwable {
		glReportsObj.accountingSchemeDefinitionEyeIcon().click();
	}

	@And("^click the search icon$")
	public void click_the_search_icon() throws Throwable {
		glReportsObj.searchIcon().click();
	}

	@And("^search the active status in list view$")
	public void search_the_active_status_in_list_view() throws Throwable {
		glReportsObj.searchStatusInAccountingScheme().click();
		glReportsObj.searchStatusInAccountingScheme().sendKeys(glModuleData.statusactive);
		glReportsObj.searchStatusInAccountingScheme().sendKeys(Keys.ENTER);
	}

	@And("^get the accounting scheme name in first list view$")
	public void get_the_accounting_scheme_name_in_first_list_view() throws Throwable {
		String Xpath = "//datatable-row-wrapper[1]/datatable-body-row[1]/div[2]/datatable-body-cell[2]/div[1]/span[1]";
		String AccountingSchemeName = driver.findElement(By.xpath(Xpath)).getText();
		testdata.put("AccountingSchemeName", AccountingSchemeName);
	}

	@And("^click the Accounting Scheme Event Mapping Eye icon$")
	public void click_the_accounting_scheme_event_mapping_eye_icon() throws Throwable {
		glReportsObj.accountingSchemeEventMappingEyeIcon().click();
	}

//    @And("^click add icon in Gl$")
//    public void click_add_icon_in_gl() throws Throwable {
//        glReportsObj.addIcon().click();
//    }

	@And("^select the event$")
	public void select_the_event() throws Throwable {
		glReportsObj.selectEvent().click();
		glReportsObj.selectEvent().sendKeys(glModuleData.EventName);
		glReportsObj.selectEvent().sendKeys(Keys.ENTER);
	}

	@And("^click the Scheme$")
	public void click_the_scheme() throws Throwable {
		javascriphelper.JavaScriptHelper(driver);
		String xpath1 = "//ul/li/span[contains(text(),'" + glModuleData.SchemeName1 + "')]";
		javascriphelper.scrollIntoView(driver.findElement(By.xpath(xpath1)));
		driver.findElement(By.xpath(xpath1)).click();

	}

	@And("^click Add button$")
	public void click_add_button() throws Throwable {
		glReportsObj.addSchemesButton().click();
	}

	@And("^click next Scheme$")
	public void click_next_scheme() throws Throwable {
		String xpath2 = "//ul/li/span[contains(text(),'" + glModuleData.SchemeName2 + "')]";
		javascriphelper.scrollIntoView(driver.findElement(By.xpath(xpath2)));
		driver.findElement(By.xpath(xpath2)).click();
	}

	@And("^click save button in event mapping$")
	public void click_save_button_in_event_mapping() throws Throwable {
		glReportsObj.saveButtonInEventMapping().click();
	}

//    @And("^Click on notification icon$")
//    public void click_on_notification_icon() throws Throwable {
//    	Thread.sleep(1000);
//        glReportsObj.makerNotificationIcon().click();
//    }

	@And("^select the first records$")
	public void select_the_first_records() throws Throwable {
		seleniumactions.getWaitHelper().waitForElementToVisibleWithFluentWait(driver, glReportsObj.firstReferenceId(), 20, 500);
		String firtsReferenceID = glReportsObj.firstReferenceId().getText();
		// Geting reference ID
		jsonWriter.addReferanceData(firtsReferenceID);
		glReportsObj.FirstRecordEditIcon().click();

	}

	@And("^click on submits$")
	public void click_on_submits() throws Throwable {
		seleniumactions.getWaitHelper().waitForElementToVisibleWithFluentWait(driver, glReportsObj.submitRemark(), 20, 500);
		glReportsObj.submitRemark().click();
		seleniumactions.getWaitHelper().waitForElementToVisibleWithFluentWait(driver, glReportsObj.budgetCreation_ReviewerId(),20, 500);
		String reviwerId = glReportsObj.budgetCreation_ReviewerId().getText();
		String trimmerReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmerReviewerID);
		StringBuffer finalReviewerID = sb.deleteCharAt(trimmerReviewerID.length() - 1);
		String revID = finalReviewerID.toString();
		// System.out.println("String buffer reviewer ID is"+finalReviewerID);
		// System.out.println("Reviewer ID is"+revID);
		jsonWriter.addData(revID);
	}

	@And("^click on submit buttons$")
	public void click_on_submit_buttons() throws Throwable {
		seleniumactions.getWaitHelper().waitForElementToVisibleWithFluentWait(driver, glReportsObj.submit(), 20, 500);
		glReportsObj.submit().click();
	}

//    @And("^enter remark in alert tab$")
//    public void enter_remark_in_alert_tab() throws Throwable {
//    	Thread.sleep(2000);
//        glReportsObj.enterRemarkInMaker().click();
//        glReportsObj.enterRemarkInMaker().sendKeys("ok");
//        
//    }

	@Then("^verify System should allow to map to the transaction event more than one Accounting Scheme$")
	public void verify_system_should_allow_to_map_to_the_transaction_event_more_than_one_accounting_scheme()
			throws Throwable {
		seleniumactions.getWaitHelper().waitForElementToVisibleWithFluentWait(driver,
				driver.findElement(By.xpath("//span[contains(text(),'" + glModuleData.SchemeName1 + "')]")), 20, 500);
		driver.findElement(By.xpath("//span[contains(text(),'" + glModuleData.SchemeName1 + "')]")).isDisplayed();
		seleniumactions.getWaitHelper().waitForElementToVisibleWithFluentWait(driver,
				driver.findElement(By.xpath("//span[contains(text(),'" + glModuleData.SchemeName2 + "')]")), 20, 500);
		driver.findElement(By.xpath("//span[contains(text(),'" + glModuleData.SchemeName2 + "')]")).isDisplayed();
	}

	@And("^search Event name based on which we created$")
	public void search_event_name_based_on_which_we_created() throws Throwable {
		seleniumactions.getWaitHelper().waitForElementToVisibleWithFluentWait(driver, glReportsObj.searchEventName(), 20, 500);
		glReportsObj.searchEventName().click();
		glReportsObj.searchEventName().sendKeys(glModuleData.EventName);
	}

	@And("^clck the first edit icon in list view$")
	public void clck_the_first_edit_icon_in_list_view() throws Throwable {
		glReportsObj.clickFirstEditIconInListView().click();
	}

	@And("^select the Status for EventMapping$")
	public void select_the_status_for_eventmapping() throws Throwable {
		glReportsObj.selectStatusInEventMapping().click();
		glReportsObj.selectStatusInEventMapping().sendKeys(Keys.DOWN);
		glReportsObj.selectStatusInEventMapping().sendKeys(Keys.ENTER);
	}

	@And("^select accounting book name$")
	public void select_accounting_book_name() throws Throwable {
		glReportsObj.selectAccountingBook().click();
		glReportsObj.selectAccountingBook().sendKeys(glModuleData.AccountingBookname);
		glReportsObj.selectAccountingBook().sendKeys(Keys.ENTER);
	}

	@And("^enter the Accounting Scheme Code$")
	public void enter_the_accounting_scheme_code() throws Throwable {
		Random ran = new Random();
		int rand = ran.nextInt(500 - 10) + 10;
		glReportsObj.enterAccountingSchemeCode().click();
		glReportsObj.enterAccountingSchemeCode().sendKeys(glModuleData.AccountingSchemeCode + rand);
		glReportsObj.enterAccountingSchemeCode().sendKeys(Keys.ENTER);
	}

	@And("^enter the Accounting Scheme name$")
	public void enter_the_accounting_scheme_name() throws Throwable {
		Random ran = new Random();
		int rand = ran.nextInt(500 - 10) + 10;
		glReportsObj.enterAccountingSchemeName().click();
		glReportsObj.enterAccountingSchemeName().sendKeys(glModuleData.AccountingSchemeName + rand);
		glReportsObj.enterAccountingSchemeName().sendKeys(Keys.ENTER);

	}

	@And("^select expand indicator$")
	public void select_expand_indicator() throws Throwable {
		glReportsObj.selectExpandIndicator().click();
		glReportsObj.selectExpandIndicator().sendKeys(glModuleData.ExpandIndicator);
		glReportsObj.selectExpandIndicator().sendKeys(Keys.ENTER);
	}

	@And("^select Transaction Type$")
	public void select_transaction_type() throws Throwable {
		glReportsObj.selectTransactionType().click();
		glReportsObj.selectTransactionType().sendKeys(glModuleData.TransactionType);
		glReportsObj.selectTransactionType().sendKeys(Keys.ENTER);

	}

	@And("^click save buttons$")
	public void click_save_buttons() throws Throwable {
		glReportsObj.saveButton().click();

	}

	@And("^click add icon in accounting scheme details$")
	public void click_add_icon_in_accounting_scheme_details() throws Throwable {
		seleniumactions.getWaitHelper().waitForElementToVisibleWithFluentWait(driver, glReportsObj.addAccountingSchemesDetail(),
				20, 500);
		glReportsObj.addAccountingSchemesDetail().click();
	}

	@And("^select GL resource$")
	public void select_gl_resource() throws Throwable {
		glReportsObj.selectGlSource().click();
		glReportsObj.selectGlSource().sendKeys(glModuleData.selectGlSource);
		glReportsObj.selectGlSource().sendKeys(Keys.ENTER);
	}

	@And("^select CrDr flag$")
	public void select_crdr_flag() throws Throwable {
		glReportsObj.selectCrDrFlag().click();
		glReportsObj.selectCrDrFlag().sendKeys(glModuleData.DrFlag);
		glReportsObj.selectCrDrFlag().sendKeys(Keys.ENTER);
	}

	@And("^select parameter String$")
	public void select_parameter_string() throws Throwable {
		glReportsObj.selectParameterType().click();
		glReportsObj.selectParameterType().sendKeys(glModuleData.ParameterType);
		glReportsObj.selectParameterType().sendKeys(Keys.ENTER);

	}

	@And("^select expand indicator in accounting Scheme details$")
	public void select_expand_indicator_in_accounting_scheme_details() throws Throwable {
		glReportsObj.selectExpandIndicatorInSchemeDetail().click();
		glReportsObj.selectExpandIndicatorInSchemeDetail().sendKeys(glModuleData.ExpandIndicator);
		glReportsObj.selectExpandIndicatorInSchemeDetail().sendKeys(Keys.ENTER);
	}

	@And("^select parameter$")
	public void select_parameter() throws Throwable {
		glReportsObj.selectParameterInAccountingSchemeDetails().click();
		glReportsObj.selectParameterInAccountingSchemeDetails()
				.sendKeys(glModuleData.ParameterInAccountingSchemeDetails);
		glReportsObj.selectParameterInAccountingSchemeDetails().sendKeys(Keys.ENTER);
	}

	@And("^click add icon in table$")
	public void click_add_icon_in_table() throws Throwable {
		glReportsObj.addIconinAccountingSchemeDetails().click();
	}

	@And("^click save button in accounting scheme$")
	public void click_save_button_in_accounting_scheme() throws Throwable {
		glReportsObj.saveButtonInAccountingSchemeDetails().click();

	}

	@And("^click edit icon in accounting schemes$")
	public void click_edit_icon_in_accounting_schemes() throws Throwable {
		javascriphelper.JavaScriptHelper(driver);
		javascriphelper.scrollIntoView(glReportsObj.editIconInAccountingSchemeDetails());
		seleniumactions.getWaitHelper().waitForElementToVisibleWithFluentWait(driver,
				glReportsObj.editIconInAccountingSchemeDetails(), 20, 500);
		glReportsObj.editIconInAccountingSchemeDetails().click();
	}

	@And("^select the status in accounting Scheme details$")
	public void select_the_status_in_accounting_scheme_details() throws Throwable {
		glReportsObj.selectStatusInAccountingSchemes().click();
		glReportsObj.selectStatusInAccountingSchemes().sendKeys(Keys.DOWN);
		glReportsObj.selectStatusInAccountingSchemes().sendKeys(Keys.ENTER);
	}

	@And("^select Cr flag$")
	public void select_cr_flag() throws Throwable {
		glReportsObj.selectCrDrFlag().click();
		glReportsObj.selectCrDrFlag().sendKeys(glModuleData.CrFlag);
		glReportsObj.selectCrDrFlag().sendKeys(Keys.ENTER);
	}

	@Then("^verify System should triggered the applied rule for the accounting scheme$")
	public void verify_system_should_triggered_the_applied_rule_for_the_accounting_scheme() throws Throwable {
		String xpath = "//ul/li/span[contains(text(),'" + glModuleData.AccountingSchemeName + "')]";
		javascriphelper.JavaScriptHelper(driver);
		javascriphelper.scrollIntoView(driver.findElement(By.xpath(xpath)));
		driver.findElement(By.xpath(xpath)).isDisplayed();
	}

// Financial reports
	@And("^click on tool icon$")
	public void click_on_tool_icon() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubsMakerObj.kubsToolIcon(), 5, 500);
		kubsMakerObj.kubsToolIcon().click();
	}

	@Then("^click on Financial reporting button$")
	public void click_on_financial_reporting_button() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_FinancialTransactionReportObj.gL2_FinancialTransactionReport_FinancialReport(), 5, 500);
		gL2_FinancialTransactionReportObj.gL2_FinancialTransactionReport_FinancialReport().click();

	}

	@Then("^click on Financial Transaction Report$")
	public void click_on_financial_transaction_report() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_FinancialTransactionReportObj.gL2_FinancialTransactionReport(), 5, 500);
		gL2_FinancialTransactionReportObj.gL2_FinancialTransactionReport().click();

	}
	

    @And("^User Select the branch code for Financial transaction$")
    public void user_select_the_branch_code_for_financial_transaction() throws Throwable {
    	// BranchCode
    			waithelper.waitForElementToVisibleWithFluentWait(driver,
    					gL2_FinancialTransactionReportObj.gL2_FinancialTransactionReport_Branch(), 5, 500);
    			gL2_FinancialTransactionReportObj.gL2_FinancialTransactionReport_Branch().click();
    			gL2_FinancialTransactionReportObj.gL2_FinancialTransactionReport_Branch()
    					.sendKeys(testData.get("BranchCode"));
    			for (int i = 0; i <200; i++) {
    				try {
    					driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("BranchCode")+"')]")).isDisplayed();
    					break;
    				} catch (Exception e) {
    					if (i==199) {
    						Assert.fail(e.getMessage());
    					}
    				}
    			}	
    			gL2_FinancialTransactionReportObj.gL2_FinancialTransactionReport_Branch().sendKeys(Keys.ENTER);
    }

    @And("^User Select the GL Code for Financial transaction$")
    public void user_select_the_gl_code_for_financial_transaction() throws Throwable {
    	// GlCode
    			waithelper.waitForElementToVisibleWithFluentWait(driver,
    					gL2_FinancialTransactionReportObj.gL2_FinancialTransactionReport_GlCode(), 5, 500);
    			gL2_FinancialTransactionReportObj.gL2_FinancialTransactionReport_GlCode().click();
    			gL2_FinancialTransactionReportObj.gL2_FinancialTransactionReport_GlCode()
    					.sendKeys(testData.get("GL Code"));
    			for (int i = 0; i <200; i++) {
    				try {
    					driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("GL Code")+"')]")).click();
    					break;
    				} catch (Exception e) {
    					if (i==199) {
    						Assert.fail(e.getMessage());
    					}
    				}
    			}	
    		//	gL2_FinancialTransactionReportObj.gL2_FinancialTransactionReport_GlCode().sendKeys(Keys.ENTER);
    }

	@Then("^Select Transaction from date Financial Transaction Report$")
	public void select_transaction_from_date_financial_transaction_report() {

		// select Transaction from date
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_FinancialTransactionReportObj.gL2_FinancialTransactionReport_CalendarFromDate(), 5, 500);
		gL2_FinancialTransactionReportObj.gL2_FinancialTransactionReport_CalendarFromDate().click();

		javascripthelper.JavaScriptHelper(driver);
		while (true) {
			try {

				waithelper
						.waitForElementToVisibleWithFluentWait(driver,
								driver.findElement(By.xpath("//span[contains(text(),'"
										+ testdata.get("ToMonth") + " "
										+ testdata.get("Year") + "')]")),
								5, 500);

				WebElement monthAndYear = driver.findElement(
						By.xpath("//span[contains(text(),'" + testdata.get("ToMonth") + " "
								+ testdata.get("Year") + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				waithelper.waitForElementToVisibleWithFluentWait(driver, gL2_FinancialTransactionReportObj.gL2_FinancialTransactionReport_NextMonth(), 5, 500);
				gL2_FinancialTransactionReportObj.gL2_FinancialTransactionReport_NextMonth().click();
			}
		}
		WebElement FinalDay = driver
				.findElement(By.xpath("//td[@aria-label='" + testdata.get("FullMonth")
						+ " " + testdata.get("Date") + ", "
						+ testdata.get("Year") + "']/span"));
		clicksAndActionHelper.moveToElement(FinalDay);
		clicksAndActionHelper.doubleClick(FinalDay);
		
		
	}

	@Then("^select Transaction to date Financial Transaction Report$")
	public void select_transaction_to_date_financial_transaction_report() {
		// select Transaction to date
		waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ToDate());
		eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ToDate().click();

		while (true) {
			try {

				waithelper.waitForElement(driver, 3000,
						driver.findElement(By.xpath("//span[contains(text(),'"
								+ testdata.get("ToMonth") + " "
								+ testdata.get("Year") + "')]")));
				WebElement monthAndYear = driver.findElement(By.xpath(
						"//span[contains(text(),'" + testdata.get("ToMonth")
								+ " " + testdata.get("Year") + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				waithelper.waitForElementToVisibleWithFluentWait(driver, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextMonth(), 5, 500);
				eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextMonth().click();
			}
		}
		WebElement FinalDay2 = driver.findElement(
				By.xpath("//td[@aria-label='" + testdata.get("FullMonth")
						+ " " + testdata.get("Date") + ", "
						+ testdata.get("Year") + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay2);

	}

	@And("^click view button of report$")
	public void click_view_button_of_report() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_FinancialTransactionReportObj.gL2_FinancialTransactionReport_View(), 5, 500);
		gL2_FinancialTransactionReportObj.gL2_FinancialTransactionReport_View().click();

	}

	@Then("^verify the approved invoicebill number is available in report$")
	public void verify_the_approved_invoicebill_number_is_available_in_report() throws Throwable {
		System.out.println("Voucher " + gL2_FinancialTransactionReportTestDataType.Voucher);
		javascripthelper.JavaScriptHelper(driver);
		browserHelper.SwitchToWindow(1);
		Thread.sleep(3000);
		browserHelper.switchToParentWithChildClose();
	}

	// ----------KUBS_GL2_UAT_008_005 GL monthly balances----------------//

	@Then("^click on GL monthly balances$")
	public void click_on_gl_monthly_balances() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_FinancialTransactionReportObj.gL2_GlMonthlyBalanceReport(), 5, 500);
		gL2_FinancialTransactionReportObj.gL2_GlMonthlyBalanceReport().click();

	}
	@And("^User Select the Branch Code for Check GL Monthly balances$")
    public void user_select_the_branch_code_for_check_gl_monthly_balances() throws Throwable {

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

    @And("^User Select the Report type for Check GL Monthly balances$")
    public void user_select_the_report_type_for_check_gl_monthly_balances() throws Throwable {
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

    @And("^User Select the GL Code for Check GL Monthly balances$")
    public void user_select_the_gl_code_for_check_gl_monthly_balances() throws Throwable {
    	// GlCode
    	waithelper.waitForElementToVisibleWithFluentWait(driver,
				financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_GlCode(), 5, 500);
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

    @And("^User Select the Currency for Check GL Monthly balances$")
    public void user_select_the_currency_for_check_gl_monthly_balances() throws Throwable {
    	// Currency
    	waithelper.waitForElementToVisibleWithFluentWait(driver,
				financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_Currency(), 5, 500);
    	financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_Currency().click();
    	financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_Currency()
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
		financialReporting_GLBalancesReportObj.FinancialReporting_GLBalancesReport_Currency().sendKeys(Keys.ENTER);
    }

	@Then("^verify the Record available in report$")
	public void verify_the_record_available_in_report() throws InterruptedException {
		javascripthelper.JavaScriptHelper(driver);
		browserHelper.SwitchToWindow(1);
		Thread.sleep(3000);
		browserHelper.switchToParentWithChildClose();

	}

	// -----------------KUBS_GL2_UAT_008_011 Balancesheet
	// report-------------------//

	@Then("^click on balancesheet report$")
	public void click_on_balancesheet_report() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_FinancialTransactionReportObj.gL2_BalanceSheetReport(), 5, 500);
		gL2_FinancialTransactionReportObj.gL2_BalanceSheetReport().click();

	}
	 @And("^User Select the branch code for balancesheet report$")
	    public void user_select_the_branch_code_for_balancesheet_report() throws Throwable {
		// BranchCode
			waithelper.waitForElementToVisibleWithFluentWait(driver,
					gL2_FinancialTransactionReportObj.gL2_BalanceSheetReport_BranchTextbox(), 5, 500);
			gL2_FinancialTransactionReportObj.gL2_BalanceSheetReport_BranchTextbox().click();
			gL2_FinancialTransactionReportObj.gL2_BalanceSheetReport_BranchTextbox()
					.sendKeys(testData.get("BranchCode"));
			for (int i = 0; i <200; i++) {
				try {
					driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("BranchCode")+"')]")).isDisplayed();
					break;
				} catch (Exception e) {
					if (i==199) {
						Assert.fail(e.getMessage());
					}
				}
			}	
			gL2_FinancialTransactionReportObj.gL2_BalanceSheetReport_BranchTextbox().sendKeys(Keys.DOWN);
	    }
	 @And("^User Select the Report Type for balancesheet report$")
	    public void user_select_the_report_type_for_balancesheet_report() throws Throwable {
		 gL2_FinancialTransactionReportObj.gL2_BalanceSheetReport_BranchTextbox().sendKeys(Keys.ENTER);
			gL2_FinancialTransactionReportObj.gl2BalanceSheetReportType().click();
			gL2_FinancialTransactionReportObj.gl2BalanceSheetReportType().sendKeys(Keys.DOWN);
			gL2_FinancialTransactionReportObj.gl2BalanceSheetReportType().sendKeys(Keys.ENTER);
	    }

	@Then("^verify the Record available in the report$")
	public void verify_the_record_available_in_the_report() throws Throwable {
		javascripthelper.JavaScriptHelper(driver);
		browserHelper.SwitchToWindow(1);
		Thread.sleep(2000);
//		for (int i = 0; i <= 3000; i++) {
//			try {
//				javascripthelper.scrollIntoView(gL2_FinancialTransactionReportObj.gL2_BalanceSheetReport_TdsReport());
//				waithelper.waitForElementToVisibleWithFluentWait(driver,
//						gL2_FinancialTransactionReportObj.gL2_BalanceSheetReport_TdsReport(), 5, 500);
//				gL2_FinancialTransactionReportObj.gL2_BalanceSheetReport_TdsReport().isDisplayed();
//				break;
//			} catch (NoSuchElementException e) {
//				if (i == 3000) {
//					Assert.fail();
//				}
//			}
//		}
//		Thread.sleep(3000);
		browserHelper.switchToParentWithChildClose();
	}

	// --------------------Cashflow statement report-----------------------//

	@Then("^click on Cashflow statement report$")
	public void click_on_cashflow_statement_report() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_FinancialTransactionReportObj.gL2_CashFlowStatementReport(), 5, 500);
		gL2_FinancialTransactionReportObj.gL2_CashFlowStatementReport().click();

	}
	@And("^User Select the branch code for Cashflow statement report$")
    public void user_select_the_branch_code_for_cashflow_statement_report() throws Throwable {
		// BranchCode
				waithelper.waitForElementToVisibleWithFluentWait(driver,
						gL2_FinancialTransactionReportObj.gL2_CashFlowStatementReport_Branch(), 5, 500);
				gL2_FinancialTransactionReportObj.gL2_CashFlowStatementReport_Branch().click();
				gL2_FinancialTransactionReportObj.gL2_CashFlowStatementReport_Branch()
						.sendKeys(testData.get("BranchCode"));
				for (int i = 0; i <200; i++) {
					try {
						driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("BranchCode")+"')]")).isDisplayed();
						break;
					} catch (Exception e) {
						if (i==199) {
							Assert.fail(e.getMessage());
						}
					}
				}	
				gL2_FinancialTransactionReportObj.gL2_CashFlowStatementReport_Branch().sendKeys(Keys.ENTER);
    }

	// -----------------Income statement report--------------------------//

	@Then("^click on Income statement report$")
	public void click_on_income_statement_report() {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				gL2_FinancialTransactionReportObj.gL2_IncomeStatementReport(), 5, 500);
		gL2_FinancialTransactionReportObj.gL2_IncomeStatementReport().click();

	}
	@And("^get the system date for Income statement report$")
    public void get_the_system_date_for_income_statement_report() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,jobScheduler_JobExecutionObj.systemDate(), 30, 2);
	    String systemdate = jobScheduler_JobExecutionObj.systemDate().getText();
	//  System.out.println(systemdate);
	String[] split = systemdate.split("-");
	String date = split[0];
	testdata.put("Date", date);
	//  System.out.println(date);
	String month = split[1];
	testdata.put("ToMonth", month);
	//  System.out.println(month);
	String year = split[2];
	testdata.put("Year", year);
	//  System.out.println(year);
	String fullMonth;
	switch (month) {
	case "Jan":
	fullMonth = "January";
	break;
	case "Feb":
	fullMonth = "February";
	break;
	case "Mar":
	fullMonth = "March";
	break;
	case "Apr":
	fullMonth = "April";
	break;
	case "May":
	fullMonth = "May";
	break;
	case "Jun":
	fullMonth ="June";
	break;
	case "Jul":
	fullMonth = "July";
	break;
	case "Aug":
	fullMonth ="August";
	break;
	case "Sep":
	fullMonth = "September";
	break;
	case "Oct":
	fullMonth = "October";
	break;
	case "Nov":
	fullMonth = "November";
	break;
	case "Dec":
	fullMonth = "December";
	break;
	default:
	 fullMonth = "InvalidMonth";
	break;
	}
	testdata.put("FullMonth", fullMonth);
    }
	@And("^User select the branch code for Income Statement report$")
    public void user_select_the_branch_code_for_income_statement_report() throws Throwable {
		// BranchCode
				waithelper.waitForElementToVisibleWithFluentWait(driver,
						gL2_FinancialTransactionReportObj.gL2_IncomeStatementReport_Branch(), 5, 500);
				gL2_FinancialTransactionReportObj.gL2_IncomeStatementReport_Branch().click();
				gL2_FinancialTransactionReportObj.gL2_IncomeStatementReport_Branch()
						.sendKeys(testData.get("BranchCode"));
				for (int i = 0; i <200; i++) {
					try {
						driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("BranchCode")+"')]")).isDisplayed();
						break;
					} catch (Exception e) {
						if (i==199) {
							Assert.fail(e.getMessage());
						}
					}
				}	
				gL2_FinancialTransactionReportObj.gL2_IncomeStatementReport_Branch().sendKeys(Keys.ENTER);
    }
	
	// trail balance
	@Then("^click on temp grid button of Trial Balance report$")
	public void click_on_temp_grid_button_of_Trial_balance_report() {
		waithelper.waitForElement(driver, 3000,
				financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_TempGridButton());
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_TempGridButton().click();
	}
	@And("^User Select the branch for trial balance$")
    public void user_select_the_branch_for_trial_balance() throws Throwable {
		waithelper.waitForElement(driver, 3000,
				financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_BranchCode());
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_BranchCode()
				.sendKeys(testData.get("BranchCode"));
		for (int i = 0; i <200; i++) {
			try {
				driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("BranchCode")+"')]")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}	
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_BranchCode()
				.sendKeys(Keys.ENTER);

    }

    @And("^User Select the Report Type for trial balance$")
    public void user_select_the_report_type_for_trial_balance() throws Throwable {
    	financialReporting_TrialBalanceReportObj.financialReportingTrailBalanceReportType().click();
    	financialReporting_TrialBalanceReportObj.financialReportingTrailBalanceReportType().sendKeys(testData.get("ReportType"));
    	for (int i = 0; i <200; i++) {
			try {
				driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("ReportType")+"')]")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}	
		
		financialReporting_TrialBalanceReportObj.financialReportingTrailBalanceReportType().sendKeys(Keys.ENTER);
    }

    @And("^User choose trial balance from date for trial balance$")
    public void user_choose_trial_balance_from_date_for_trial_balance() throws Throwable {
    	waithelper.waitForElement(driver, 3000,
				financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_TrialBalanceFromDate());
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_TrialBalanceFromDate().click();

		while (true) {
			try {

				waithelper.waitForElement(driver, 3000,
						driver.findElement(By.xpath("//span[contains(text(),'"
								+ testdata.get("ToMonth") + " "
								+ testdata.get("Year") + "')]")));
				WebElement monthAndYear = driver.findElement(By.xpath(
						"//span[contains(text(),'" + testdata.get("ToMonth")
								+ " " + testdata.get("Year") + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextMonth().click();
			}
		}
		WebElement FinalDay = driver.findElement(
				By.xpath("//td[@aria-label='" + testdata.get("FullMonth")
						+ " " + testdata.get("Date") + ", "
						+ testdata.get("Year")+ "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);

    }

    @And("^User Choose trial balance To date for trial balance$")
    public void user_choose_trial_balance_to_date_for_trial_balance() throws Throwable {
    	waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ToDate());
		eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ToDate().click();

		while (true) {
			try {

				waithelper.waitForElement(driver, 3000,
						driver.findElement(By.xpath("//span[contains(text(),'"
								+ testdata.get("ToMonth") + " "
								+ testdata.get("Year") + "')]")));
				WebElement monthAndYear = driver.findElement(By.xpath(
						"//span[contains(text(),'" + testdata.get("ToMonth")
								+ " " + testdata.get("Year") + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				waithelper.waitForElementToVisibleWithFluentWait(driver, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextMonth(), 5, 500);
				eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextMonth().click();
			}
		}
		WebElement FinalDay2 = driver.findElement(
				By.xpath("//td[@aria-label='" + testdata.get("FullMonth")
						+ " " + testdata.get("Date") + ", "
						+ testdata.get("Year") + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay2);


    }

    @And("^User select the Currency type for trial balance$")
    public void user_select_the_currency_type_for_trial_balance() throws Throwable {
    	financialReporting_TrialBalanceReportObj.financialReportingTrialBalanceCurrencyType().click();
		financialReporting_TrialBalanceReportObj.financialReportingTrialBalanceCurrencyType().sendKeys(Keys.DOWN);
		financialReporting_TrialBalanceReportObj.financialReportingTrialBalanceCurrencyType().sendKeys(Keys.DOWN);
		financialReporting_TrialBalanceReportObj.financialReportingTrialBalanceCurrencyType().sendKeys(Keys.DOWN);
		financialReporting_TrialBalanceReportObj.financialReportingTrialBalanceCurrencyType().sendKeys(Keys.ENTER);
    }

	@And("^fill the required field of Trial Balance report$")
	public void fill_the_required_field_of_Trial_balance_report() {
		
		
		

		waithelper.waitForElement(driver, 3000,
				financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_TrialBalanceFromDate());
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_TrialBalanceFromDate().click();

		while (true) {
			try {

				waithelper.waitForElement(driver, 3000,
						driver.findElement(
								By.xpath("//span[contains(text(),'" + TrialBalanceReportTestDataType.TrialMonth + " "
										+ TrialBalanceReportTestDataType.TrialYear + "')]")));
				WebElement monthAndYear = driver
						.findElement(By.xpath("//span[contains(text(),'" + TrialBalanceReportTestDataType.TrialMonth
								+ " " + TrialBalanceReportTestDataType.TrialYear + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextMonth().click();
			}
		}
		WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='"
				+ TrialBalanceReportTestDataType.TrialFullMonth + " " + TrialBalanceReportTestDataType.TrialDate + ", "
				+ TrialBalanceReportTestDataType.TrialYear + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);

		waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ToDate());
		eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ToDate().click();

		while (true) {
			try {

				waithelper.waitForElement(driver, 3000,
						driver.findElement(
								By.xpath("//span[contains(text(),'" + TrialBalanceReportTestDataType.TrialToMonth + " "
										+ TrialBalanceReportTestDataType.TrialToYear + "')]")));
				WebElement monthAndYear = driver
						.findElement(By.xpath("//span[contains(text(),'" + TrialBalanceReportTestDataType.TrialToMonth
								+ " " + TrialBalanceReportTestDataType.TrialToYear + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextMonth().click();
			}
		}
		WebElement FinalDay2 = driver.findElement(By.xpath("//td[@aria-label='"
				+ TrialBalanceReportTestDataType.TrialFullToMonth + " " + TrialBalanceReportTestDataType.TrialToDate
				+ ", " + TrialBalanceReportTestDataType.TrialToYear + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay2);

//		waithelper.waitForElement(driver, 3000, financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_Currency());
//		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_Currency().sendKeys(TrialBalanceReportTestDataType.Currency);
//		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_Currency().sendKeys(Keys.ENTER);
	}

	@And("^click on view button in trial balance report$")
	public void click_on_view_button_in_trial_balance_report() throws Throwable {
		waithelper.waitForElement(driver, 3000,
				financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_ViewButton());
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_ViewButton().click();
	}

	@Then("^click on view button to view the report of Trial balance$")
	public void click_on_view_button_to_view_the_report_of_trial_balance() throws InterruptedException {
		waithelper.waitForElement(driver, 3000,
				financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_ViewButton());
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_ViewButton().click();
		for(int i=0;i<=3000000;i++)
		try
		{
		 browserHelper.SwitchToWindow(1);
		break;
		}
		catch(IndexOutOfBoundsException e)
		{
		if(i==3000000)
		{
			
			e.printStackTrace();
			Assert.fail("Report not openened");
		}
		}
		 for (int i = 0; i <= 200; i++) {
			try {
				driver.findElement(By.xpath("//div[text()='TRIAL BALANCE']")).isDisplayed();
				break;
			} catch (NoSuchElementException e) {
				if (i == 200) {
					e.printStackTrace();
				}

			}
		}
		browserHelper.switchToParentWithChildClose();
	}

	// ------------------Trial balance Report Summary

	@Then("^click on temp grid button of Trial Balance report summarized$")
	public void click_on_temp_grid_button_of_Trial_Balance_report_summarized() {
		waithelper.waitForElement(driver, 3000,
				financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReportSummary_TempGridButton());
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReportSummary_TempGridButton().click();
	}
	@And("^User Select the branch for trial balance summary$")
    public void user_select_the_branch_for_trial_balance_summary() throws Throwable {
		waithelper.waitForElement(driver, 3000,
				financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_BranchCode());
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_BranchCode()
				.sendKeys(testData.get("BranchCode"));
		for (int i = 0; i <200; i++) {
			try {
				driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("BranchCode")+"')]")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}	
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_BranchCode()
				.sendKeys(Keys.ENTER);
    }

    @And("^User Select the Report Type for trial balance summary$")
    public void user_select_the_report_type_for_trial_balance_summary() throws Throwable {
    	financialReporting_TrialBalanceReportObj.financialReportingTrailBalanceReportType().click();
    	financialReporting_TrialBalanceReportObj.financialReportingTrailBalanceReportType().sendKeys(testData.get("ReportType"));
    	for (int i = 0; i <200; i++) {
			try {
				driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("ReportType")+"')]")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}	
		
		financialReporting_TrialBalanceReportObj.financialReportingTrailBalanceReportType().sendKeys(Keys.ENTER);

    }

    @And("^User select the Currency type for trial balance summary$")
    public void user_select_the_currency_type_for_trial_balance_summary() throws Throwable {
    	waithelper.waitForElement(driver, 3000,
				financialReporting_TrialBalanceReportObj.financialReportingTrialBalanceCurrencyType());
		financialReporting_TrialBalanceReportObj.financialReportingTrialBalanceCurrencyType()
				.sendKeys(testData.get("Currency"));
		for (int i = 0; i <200; i++) {
			try {
				driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("Currency")+"')]")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}	
		financialReporting_TrialBalanceReportObj.financialReportingTrialBalanceCurrencyType().sendKeys(Keys.ENTER);
    }

    @And("^User choose trial balance from date for trial balance summary$")
    public void user_choose_trial_balance_from_date_for_trial_balance_summary() throws Throwable {
    	waithelper.waitForElement(driver, 3000,
				financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_TrialBalanceFromDate());
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_TrialBalanceFromDate().click();

		while (true) {
			try {

				waithelper.waitForElement(driver, 3000,
						driver.findElement(By.xpath("//span[contains(text(),'"
								+ testdata.get("ToMonth") + " "
								+ testdata.get("Year") + "')]")));
				WebElement monthAndYear = driver.findElement(By.xpath(
						"//span[contains(text(),'" + testdata.get("ToMonth")
								+ " " + testdata.get("Year") + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextMonth().click();
			}
		}
		WebElement FinalDay = driver.findElement(
				By.xpath("//td[@aria-label='" + testdata.get("FullMonth")
						+ " " + testdata.get("Date") + ", "
						+ testdata.get("Year")+ "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);

    }

    @And("^User Choose trial balance To date for trial balance summary$")
    public void user_choose_trial_balance_to_date_for_trial_balance_summary() throws Throwable {
    	waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ToDate());
		eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ToDate().click();

		while (true) {
			try {

				waithelper.waitForElement(driver, 3000,
						driver.findElement(By.xpath("//span[contains(text(),'"
								+ testdata.get("ToMonth") + " "
								+ testdata.get("Year") + "')]")));
				WebElement monthAndYear = driver.findElement(By.xpath(
						"//span[contains(text(),'" + testdata.get("ToMonth")
								+ " " + testdata.get("Year") + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				waithelper.waitForElementToVisibleWithFluentWait(driver, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextMonth(), 5, 500);
				eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextMonth().click();
			}
		}
		WebElement FinalDay2 = driver.findElement(
				By.xpath("//td[@aria-label='" + testdata.get("FullMonth")
						+ " " + testdata.get("Date") + ", "
						+ testdata.get("Year") + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay2);

    }

	

	@Then("^click on view button to view the report of Trial balance summary$")
	public void click_on_view_button_to_view_the_report_of_trial_balance_summary() throws InterruptedException {
		waithelper.waitForElement(driver, 3000,
				financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_ViewButton());
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_ViewButton().click();
		Thread.sleep(5000);
		browserHelper.SwitchToWindow(1);
		Thread.sleep(1000);
		browserHelper.switchToParentWithChildClose();

	}

	// ----008_009 & 008_010

	@And("^user should navigate to accounting setup menu$")
	public void user_should_navigate_to_accounting_setup_menu() {
		waithelper.waitForElement(driver, 3000, accountingSetup_ChartOfAccountsDefinitionObj.AccountingSetupMenu());
		accountingSetup_ChartOfAccountsDefinitionObj.AccountingSetupMenu().click();
	}

	@Then("^click on eye button of chart of accounts definition submenu$")
	public void click_on_eye_button_of_chart_of_accounts_definition_submenu() {
		waithelper.waitForElement(driver, 3000,
				accountingSetup_ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_EyeButton());
		accountingSetup_ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_EyeButton().click();
	}

	@Then("^search coa code using coa name$")
	public void search_coa_code_using_coa_name() {
		waithelper.waitForElement(driver, 3000, accountingSetup_ChartOfAccountsDefinitionObj
				.accountingSetup_ChartOfAccountsDefinition_COA_NameSearch());
		accountingSetup_ChartOfAccountsDefinitionObj.accountingSetup_ChartOfAccountsDefinition_COA_NameSearch()
				.sendKeys(TrialBalanceReportTestDataType.COA_Name);
	}

	@And("^get the coa code$")
	public void get_the_coa_code() throws IOException {
		String coacode = accountingSetup_ChartOfAccountsDefinitionObj
				.accountingSetup_ChartOfAccountsDefinition_COA_Code().getText();
		jsonWriter = new JsonDataReaderWriter();
		jsonWriter.addData(coacode);
	}

    @And("^User Select the branch code for Check the trial balance based on the leaf GL$")
    public void user_select_the_branch_code_for_check_the_trial_balance_based_on_the_leaf_gl() throws Throwable {
    	waithelper.waitForElement(driver, 3000,
				financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_BranchCode());
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_BranchCode()
				.sendKeys(testData.get("BranchCode"));
		for (int i = 0; i <200; i++) {
			try {
				driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("BranchCode")+"')]")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}	
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_BranchCode()
				.sendKeys(Keys.ENTER);
    }

    @And("^User Select report type for Check the trial balance based on the leaf GL$")
    public void user_select_report_type_for_check_the_trial_balance_based_on_the_leaf_gl() throws Throwable {
    	waithelper.waitForElement(driver, 3000,
				financialReporting_TrialBalanceReportObj.financialReportingTrailBalanceReportType());
		financialReporting_TrialBalanceReportObj.financialReportingTrailBalanceReportType()
				.sendKeys(testData.get("ReportType"));
		for (int i = 0; i <200; i++) {
			try {
				driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("ReportType")+"')]")).click();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}	
//		financialReporting_TrialBalanceReportObj.financialReportingTrailBalanceReportType()
//				.sendKeys(Keys.ENTER);
    }

    @And("^User Select Trial balance from date for Check the trial balance based on the leaf GL$")
    public void user_select_trial_balance_from_date_for_check_the_trial_balance_based_on_the_leaf_gl() throws Throwable {
    	waithelper.waitForElement(driver, 3000,
				financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_TrialBalanceFromDate());
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_TrialBalanceFromDate().click();

		while (true) {
			try {

				waithelper.waitForElement(driver, 3000,
						driver.findElement(
								By.xpath("//span[contains(text(),'" + testdata.get("ToMonth") + " "
										+ testdata.get("Year") + "')]")));
				WebElement monthAndYear = driver
						.findElement(By.xpath("//span[contains(text(),'" + testdata.get("ToMonth")
								+ " " + testdata.get("Year") + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				waithelper.waitForElementToVisibleWithFluentWait(driver, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextMonth(), 5, 500);
				eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextMonth().click();
			}
		}
		WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='"
				+ testdata.get("FullMonth") + " " +testdata.get("Date")+ ", "
				+ testdata.get("Year") + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);

    }

    @And("^User Select Trial balance to date for Check the trial balance based on the leaf GL$")
    public void user_select_trial_balance_to_date_for_check_the_trial_balance_based_on_the_leaf_gl() throws Throwable {
    	waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ToDate());
		eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ToDate().click();

		while (true) {
			try {

				waithelper.waitForElement(driver, 3000,
						driver.findElement(
								By.xpath("//span[contains(text(),'" + testdata.get("ToMonth") + " "
										+ testdata.get("Year") + "')]")));
				WebElement monthAndYear = driver
						.findElement(By.xpath("//span[contains(text(),'" + testdata.get("ToMonth")
								+ " " + testdata.get("Year") + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextMonth().click();
			}
		}
		WebElement FinalDay2 = driver.findElement(By.xpath("//td[@aria-label='"
				+ testdata.get("FullMonth") + " " + testdata.get("Date")
				+ ", " + testdata.get("Year") + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay2);

    }

    @And("^User Select the Currency for Check the trial balance based on the leaf GL$")
    public void user_select_the_currency_for_check_the_trial_balance_based_on_the_leaf_gl() throws Throwable {
    	eNQUIRY_FinancialTransactionObj.trialBalanceCurrencyType().click();
		eNQUIRY_FinancialTransactionObj.trialBalanceCurrencyType().sendKeys(testData.get("Currency"));
		for (int i = 0; i <200; i++) {
			try {
				driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("Currency")+"')]")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}	
		eNQUIRY_FinancialTransactionObj.trialBalanceCurrencyType().sendKeys(Keys.ENTER);
    }

		@And("^User Select the branch for trial balance report$")
    public void user_select_the_branch_for_trial_balance_report() throws Throwable {
		waithelper.waitForElement(driver, 3000,
				financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_BranchCode());
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_BranchCode()
				.sendKeys(testData.get("BranchCode"));
		for (int i = 0; i <200; i++) {
			try {
				driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("BranchCode")+"')]")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}	
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_BranchCode()
				.sendKeys(Keys.ENTER);

    }

    @And("^User Select the Report Type for trial balance report$")
    public void user_select_the_report_type_for_trial_balance_report() throws Throwable {
    	waithelper.waitForElement(driver, 3000,
				financialReporting_TrialBalanceReportObj.financialReportingTrailBalanceReportType());
		financialReporting_TrialBalanceReportObj.financialReportingTrailBalanceReportType()
				.sendKeys(testData.get("ReportType"));
		for (int i = 0; i <200; i++) {
			try {
				driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("ReportType")+"')]")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}	
		financialReporting_TrialBalanceReportObj.financialReportingTrailBalanceReportType()
				.sendKeys(Keys.ENTER);
    }

    @And("^User Choose the trial balance From date$")
    public void user_choose_the_trial_balance_from_date() throws Throwable {
    	waithelper.waitForElement(driver, 3000,
				financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_TrialBalanceFromDate());
		financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_TrialBalanceFromDate().click();

		while (true) {
			try {

				waithelper.waitForElement(driver, 3000,
						driver.findElement(
								By.xpath("//span[contains(text(),'" + testdata.get("ToMonth") + " "
										+ testdata.get("Year") + "')]")));
				WebElement monthAndYear = driver
						.findElement(By.xpath("//span[contains(text(),'" + testdata.get("ToMonth")
								+ " " + testdata.get("Year") + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				waithelper.waitForElementToVisibleWithFluentWait(driver, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextMonth(), 5, 500);
				eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextMonth().click();
			}
		}
		WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='"
				+ testdata.get("FullMonth") + " " +testdata.get("Date")+ ", "
				+ testdata.get("Year") + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);

    }

    @And("^User Choose the trial balance To date$")
    public void user_choose_the_trial_balance_to_date() throws Throwable {
    	waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ToDate());
		eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ToDate().click();

		while (true) {
			try {

				waithelper.waitForElement(driver, 3000,
						driver.findElement(
								By.xpath("//span[contains(text(),'" + testdata.get("ToMonth") + " "
										+ testdata.get("Year") + "')]")));
				WebElement monthAndYear = driver
						.findElement(By.xpath("//span[contains(text(),'" + testdata.get("ToMonth")
								+ " " + testdata.get("Year") + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextMonth().click();
			}
		}
		WebElement FinalDay2 = driver.findElement(By.xpath("//td[@aria-label='"
				+ testdata.get("FullMonth") + " " + testdata.get("Date")
				+ ", " + testdata.get("Year") + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay2);

    }

    @And("^User Select the Currency for trial balance report$")
    public void user_select_the_currency_for_trial_balance_report() throws Throwable {
    	eNQUIRY_FinancialTransactionObj.trialBalanceCurrencyType().click();
		eNQUIRY_FinancialTransactionObj.trialBalanceCurrencyType().sendKeys(testData.get("Currency"));
		for (int i = 0; i <200; i++) {
			try {
				driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("Currency")+"')]")).isDisplayed();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}	
		eNQUIRY_FinancialTransactionObj.trialBalanceCurrencyType().sendKeys(Keys.ENTER);
    }

	@And("^check the trial balance based on the leaf gl is available$")
	public void check_the_trial_balance_based_on_the_leaf_gl_is_available()
			throws IOException, ParseException, InterruptedException {
		// Thread.sleep(6000);
//    	waithelper.waitForElement(driver, 10000, financialReporting_TrialBalanceReportObj.FinancialReporting_TrialBalanceReport_Report());
		javascripthelper.JavaScriptHelper(driver);
		for (int i = 0; i <= 300000; i++) {
			try {
				browserHelper.SwitchToWindow(1);
				break;
			} catch (IndexOutOfBoundsException e) {
				if (i == 300000) {
					e.printStackTrace();
				}
			}
		}
		String beforexpath = "//td//div[contains(text(),'";
		String afterxpath = "')]";
		// Thread.sleep(6000);
//    	waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(beforexpath +jsonWriter.readdata()+ afterxpath)));
//    	javascripthelper.scrollIntoView(driver.findElement(By.xpath(beforexpath +jsonWriter.readdata()+ afterxpath)));

		System.out.println("Leaf GL is in JSON " + jsonWriter.readdata());
//    	System.out.println("Leaf GL is"+leafGL);
		for(int j=1;j<=3;j++)
		{
		for(int i=3;i<=30;i++) {
			try {
				//table[@id='__bookmark_2']//tr[8]//td[1]/div
				String leafGl = driver.findElement(By.xpath("//table[@id='__bookmark_2']//tr["+i+"]//td[1]/div")).getText();
				System.out.println("leaf GL is"+leafGl);
				
			if((jsonWriter.readdata().trim()).equals(leafGl.trim()));
			{
				break;
			}
			} catch (NoSuchElementException e) {

				if(i==30)
				{
				driver.findElement(By.xpath("//input[@title='Next page']")).click();
				}
				} catch (StaleElementReferenceException e) {

			}
		}
		
		}
		
		browserHelper.switchToParentWithChildClose();
	}



	
}









	
