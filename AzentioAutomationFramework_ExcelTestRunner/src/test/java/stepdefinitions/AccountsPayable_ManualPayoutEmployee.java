package stepdefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
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
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ACCOUNTRECEIVABLE_CreditNoteObj;
import pageobjects.ACCOUNTSPAYABLEREPORT_PayoutReportObj;
import pageobjects.ACCOUNTSPAYABLE_ManualPayoutObj;
import pageobjects.ACCOUNTSPAYABLE_PayementSettlementObj;
import pageobjects.ACCOUNTSRECEIVABLE_AccountsReceivableReportObj;
import pageobjects.AccountReceivable_UpdateDepositedChequeObj;
import pageobjects.AccountsPayable_ManualPayoutEmployeeObj;
import pageobjects.Azentio_CheckerObj;
import pageobjects.Azentio_ReviewerObj;
import pageobjects.BUSINESS_PARTNER_SETUP_BusinessPartnerObj;
import pageobjects.ENQUIRY_FinancialTransactionObj;
import pageobjects.FinancialReporting_GLBalancesReportObj;
import pageobjects.INVENTORY_EnquiryGlObject;
import pageobjects.InventoryMaintenanceObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_MakerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;
import testDataType.ACCOUNTSPAYABLE_ContractReportTestData;
import testDataType.ACCOUTSAPAYBLE_AutoPayoutTestDataType;
import testDataType.AccountsPayable_ManualPayoutEmployeeTestDataType;
import testDataType.BUDGET_BudgetCreationTestDataType;
import testDataType.FinancialReporting_BalanceSheetReportTestDataType;
import testDataType.GeneralLedger2_JournalVoucherTestDataType;


public class AccountsPayable_ManualPayoutEmployee  extends BaseClass { 
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	ConfigFileReader configFileReader = new ConfigFileReader();
	ConfigFileReader config=new ConfigFileReader();
	DropDownHelper dropDownHelper;
	WaitHelper waithelper = new WaitHelper(driver) ;
	AccountsPayable_ManualPayoutEmployeeObj accountsPayable_ManualPayoutEmployeeObj = new AccountsPayable_ManualPayoutEmployeeObj(driver);
	AccountsPayable_ManualPayoutEmployeeTestDataType accountsPayable_ManualPayoutEmployeeTestDataType=jsonReader.getManualPayoutByName("Maker");
	InventoryMaintenanceObj inventoryMaintenanceObj = new InventoryMaintenanceObj(driver);
	INVENTORY_EnquiryGlObject inventoryEnquiryGlObj=new INVENTORY_EnquiryGlObject(driver);
	AccountReceivable_UpdateDepositedChequeObj accountReceivable_UpdateDepositedChequeObj = new AccountReceivable_UpdateDepositedChequeObj(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter reader;
	Azentio_ReviewerObj reviewer;
	KUBS_Login kubsLogin;
	BrowserHelper browserHelper;
	String referance_id;
	String user = "Maker";
	Azentio_CheckerObj kubschecker = new Azentio_CheckerObj(driver) ;
	BUDGET_BudgetCreationTestDataType budgetdata;
	ACCOUNTSPAYABLE_ManualPayoutObj manualPayoutObj=new ACCOUNTSPAYABLE_ManualPayoutObj(driver);
	WaitHelper waitHelper= new WaitHelper(driver);
	Map<String,String> payoutData= new HashMap<>();
	JavascriptHelper javascrtiptHelper= new JavascriptHelper();
	JsonConfig jsonConfig = new JsonConfig();
	ACCOUTSAPAYBLE_AutoPayoutTestDataType ManualPayoutData=jsonConfig.getAccountsPayableAutoPayoutTestDataByName("Maker");
	ACCOUNTSPAYABLE_PayementSettlementObj paymentSettlementObj= new ACCOUNTSPAYABLE_PayementSettlementObj(driver);
	String excelPath = System.getProperty("user.dir")+"\\Test-data\\KUBSTestData.xlsx";
	ExcelData excelData = new ExcelData(excelPath,"ARAP_ManualPayout","Data Set ID");
	private Map<String, String> testData;
	
	// Financial reporting
	KUBS_Login login = new KUBS_Login(driver);
	ENQUIRY_FinancialTransactionObj eNQUIRY_FinancialTransactionObj = new ENQUIRY_FinancialTransactionObj(driver);
	FinancialReporting_GLBalancesReportObj financialReporting_GLBalancesReportObj = new FinancialReporting_GLBalancesReportObj(driver);
	BUSINESS_PARTNER_SETUP_BusinessPartnerObj bUSINESS_PARTNER_SETUP_BusinessPartnerObj = new BUSINESS_PARTNER_SETUP_BusinessPartnerObj(driver);
	FinancialReporting_BalanceSheetReportTestDataType BalanceSheetReportTestDataType=jsonReader.getBalanceSheetReportdata("Maker");
	GeneralLedger2_JournalVoucherTestDataType JournalVoucherTestDataType=jsonReader.getJournalVoucherdata("Maker");
	
	// Account receivable report
	KUBS_MakerObj makerObj=new KUBS_MakerObj(driver);
	ACCOUNTRECEIVABLE_CreditNoteObj creditNoteObj=new ACCOUNTRECEIVABLE_CreditNoteObj(driver);
	ACCOUNTSRECEIVABLE_AccountsReceivableReportObj accountsReceivableReportObj=new ACCOUNTSRECEIVABLE_AccountsReceivableReportObj(driver);
	JavascriptHelper javascriptHelper= new JavascriptHelper();
	ACCOUNTSPAYABLE_ContractReportTestData reportTestData= jsonConfig.getAccountsPayableContractReportTestDataByName("Maker");
	// Account payable payout report
	ACCOUNTSPAYABLEREPORT_PayoutReportObj payoutReportObj = new ACCOUNTSPAYABLEREPORT_PayoutReportObj(driver);
	Map<String, String> mapData = new HashMap<>();
	INVENTORY_EnquiryGlObject glObj=new INVENTORY_EnquiryGlObject(driver);
	
	@And("^User update test data id for Manual payouts$")
    public void user_update_test_data_id_for_manual_payouts() throws Throwable {
		 testData = excelData.getTestdata("KUBS_AR/AP_UAT_006_003_TC_01_01_D1");
    }
	@And("^User update test data id for Approve the Manual Payout record in reviewer$")
    public void user_update_test_data_id_for_approve_the_manual_payout_record_in_reviewer() throws Throwable {
		testData = excelData.getTestdata("KUBS_AR/AP_UAT_006_003_TC_01_02_D1");
    }
	@And("^User Update the test data id for Approve the Manual Payout record in checker$")
    public void user_update_the_test_data_id_for_approve_the_manual_payout_record_in_checker() throws Throwable {
		testData = excelData.getTestdata("KUBS_AR/AP_UAT_006_003_TC_01_03_D1");
    }
	 
	 @And("^User update test data id for Verify accounting entries post payout approval$")
	    public void user_update_test_data_id_for_verify_accounting_entries_post_payout_approval() throws Throwable {
		 testData = excelData.getTestdata("KUBS_AR/AP_UAT_006_003_TC_03_D1");
	    }
	 @And("^User update test data id for Verify Balance sheet post payout approval$")
	    public void user_update_test_data_id_for_verify_balance_sheet_post_payout_approval() throws Throwable {
		 testData = excelData.getTestdata("KUBS_AR/AP_UAT_006_003_TC_01_03_D1");
	    }

	    @And("^User update test data id for Verify Accounts Receivable Report post payout approval$")
	    public void user_update_test_data_id_for_verify_accounts_receivable_report_post_payout_approval() throws Throwable {
	    	testData = excelData.getTestdata("KUBS_AR/AP_UAT_006_003_TC_01_04_D1");
	    }
	    @And("^User update test data id to Verify payout Report post payout approval$")
	    public void user_update_test_data_id_to_verify_payout_report_post_payout_approval() throws Throwable {
	    	testData = excelData.getTestdata("KUBS_AR/AP_UAT_006_003_TC_01_05_D1");
	    }
    @When("^click on eye button of manual payout$")
    public void click_on_eye_button_of_manual_payoutg() throws InterruptedException {
    	javascripthelper.JavaScriptHelper(driver);
    	javascripthelper.scrollIntoView(accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_EyeButton());
    	waithelper.waitForElement(driver, 3000, accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_EyeButton());
    	accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_EyeButton().click();
    }
    @Then("^log in to the reviewer account$")
	public void log_in_to_the_reviewer_account() throws IOException, ParseException, InterruptedException {
		reader = new JsonDataReaderWriter();
		kubsLogin = new KUBS_Login(driver);
		driver.get(config.getApplicationUrl());
		kubsLogin.logintoAzentioappReviewer(testData.get("Reviewer ID"));
		Thread.sleep(1000); 
		

	}
    
    @And("^then checker claim the record$")
	 public void then_checker_claim_the_record() throws InterruptedException, IOException, ParseException  {
	    	
	    	//open pool
	    	waithelper = new WaitHelper(driver);
			kubschecker = new Azentio_CheckerObj(driver);
			waithelper.waitForElementToVisibleWithFluentWait(driver, kubschecker.checkerSecurityManagement(), 30, 2);
	    	kubschecker.checkerSecurityManagement().click();
	    	
	    	//claim
	    	waithelper.waitForElement(driver,3000,kubschecker.checkerActionIcon());
	    	kubschecker.checkerActionIcon().click();
	    	Thread.sleep(2000);
	    	String before_xpath = "//span[contains(text(),'";
			String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		//	waithelper.waitForElement(driver, 5000, driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath_claim)));
			for (int i = 0; i <200; i++) {
				try {
					driver.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath_claim)).click();
					break;
				} catch (Exception e) {
					if (i==199) {
						Assert.fail(e.getMessage());
					}
				}
			}
			
			waithelper.waitForElement(driver,3000,kubschecker.checkerAlertClose());
			kubschecker.checkerAlertClose().click();
	 
	        
	    }
    @And("^Click on claim button in checker$")
    public void click_on_claim_button_in_checker() throws IOException, ParseException  {
    	String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		//String after_xpath = ;
		waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath_claim)));
		driver.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath_claim)).click();
    }

    

//    @And("^click on add button for manual payout$")
//    public void click_on_add_button_for_manual_payout() {
//    	waithelper.waitForElement(driver, 2000, accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_AddButton());
//    	accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_AddButton().click();
//    }
    @Then("^Click on the Finance$")
    public void click_on_the_finance() throws Throwable {
    	waithelper.waitForElement(driver, 2000,accountsPayable_ManualPayoutEmployeeObj.FinanceOption());
		accountsPayable_ManualPayoutEmployeeObj.FinanceOption().click();
    }
    @And("^User Select Entity branch for Manual payout$")
    public void user_select_entity_branch_for_manual_payout() throws Throwable {
    	//EntityBranch
    			waithelper.waitForElement(driver, 2000,accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_EntityBranch());
    			accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_EntityBranch().sendKeys(testData.get("Entity Branch"));
    			for (int i = 0; i <200; i++) {
    				try {
    					driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("Entity Branch")+"')]")).isDisplayed();
    					break;
    				} catch (Exception e) {
    					if (i==199) {
    						Assert.fail(e.getMessage());
    					}
    				}
    			}
    			accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_EntityBranch().sendKeys(Keys.ENTER);
    }

    @And("^User Select BP Name for Manual payout$")
    public void user_select_bp_name_for_manual_payout() throws Throwable {
    	//BP_Name
    			waithelper.waitForElement(driver, 2000,accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_BP_Name());
    			accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_BP_Name().sendKeys(testData.get("BP Name"));
    			for (int i = 0; i <200; i++) {
    				try {
    					driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("BP Name")+"')]")).isDisplayed();
    					break;
    				} catch (Exception e) {
    					if (i==199) {
    						Assert.fail(e.getMessage());
    					}
    				}
    			}
    			accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_BP_Name().sendKeys(Keys.ENTER);
    }

    @And("^User Select the Beneficiary Name for Manual payout$")
    public void user_select_the_beneficiary_name_for_manual_payout() throws Throwable {
    	//BeneficiaryName
    			accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_BeneficiaryName().click();
    			waithelper.waitForElement(driver, 2000, accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_BeneficiaryName());
    			accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_BeneficiaryName().sendKeys(testData.get("Beneficiary Name"));
    			for (int i = 0; i <200; i++) {
    				try {
    					driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("Beneficiary Name")+"')]")).isDisplayed();
    					break;
    				} catch (Exception e) {
    					if (i==199) {
    						Assert.fail(e.getMessage());
    					}
     				}
    			}
    			accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_BeneficiaryName().sendKeys(Keys.ENTER);
    }

    @And("^User Select the Currency for Manual payout$")
    public void user_select_the_currency_for_manual_payout() throws Throwable {
    	//Currency
    			waithelper.waitForElement(driver, 2000, accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_Currency());
    			accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_Currency().sendKeys(testData.get("Currency"));
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
    			accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_Currency().sendKeys(Keys.ENTER);
    }

    @And("^User Select the Payment Bank for Manual Payout$")
    public void user_select_the_payment_bank_for_manual_payout() throws Throwable {
    	//PaymentBank
    			waithelper.waitForElement(driver, 2000, accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_PaymentBank());
    			accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_PaymentBank().sendKeys(testData.get("Payment Bank"));
    			for (int i = 0; i <200; i++) {
    				try {
    					driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("Payment Bank")+"')]")).isDisplayed();
    					break;
    				} catch (Exception e) {
    					if (i==199) {
    						Assert.fail(e.getMessage());
    					}
    				}
    			}
    			accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_PaymentBank().sendKeys(Keys.ENTER);
    }

    @And("^User select the Bank Account number for Manual Payout$")
    public void user_select_the_bank_account_number_for_manual_payout() throws Throwable {
    	//BankAccountNumber
    			Double d = Double.valueOf(testData.get("Bank Account Number"));
    			accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_BankAccountNumber().click();
    			waithelper.waitForElement(driver, 2000, accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_BankAccountNumber());
    			accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_BankAccountNumber().sendKeys(String.format("%.0f", d));
    			for (int i = 0; i <200; i++) {
    				try {
    					driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+String.format("%.0f", d)+"')]")).isDisplayed();
    					break;
    				} catch (Exception e) {
    					if (i==199) {
    						Assert.fail(e.getMessage());
    					}
    				}
    			}
    			accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_BankAccountNumber().sendKeys(Keys.ENTER);
    }

    @And("^User select the Payment mode for Manual Payout$")
    public void user_select_the_payment_mode_for_manual_payout() throws Throwable {
    	//PaymentMode
    			waithelper.waitForElement(driver, 2000, accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_PaymentMode());
    			accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_PaymentMode().sendKeys(testData.get("Payment Mode"));
    			for (int i = 0; i <200; i++) {
    				try {
    					driver.findElement(By.xpath("//ng-dropdown-panel//span[contains(text(),'"+testData.get("Payment Mode")+"')]")).isDisplayed();
    					break;
    				} catch (Exception e) {
    					if (i==199) {
    						Assert.fail(e.getMessage());
    					}
    				}
    			}
    			accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_PaymentMode().sendKeys(Keys.ENTER);
    }

    @And("^User select the Reference Number for Manual Payout$")
    public void user_select_the_reference_number_for_manual_payout() throws Throwable {
    	//ReferenceNumber
    			waithelper.waitForElement(driver, 2000, accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_ReferenceNumber());
    			accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_ReferenceNumber().sendKeys(testData.get("ReferenceNumber"));
    }

    @And("^User select the Cheque Number for Manual Payout$")
    public void user_select_the_cheque_number_for_manual_payout() throws Throwable {
    	javascripthelper.JavaScriptHelper(driver);
    	//ChequeNumber
    			waithelper.waitForElement(driver, 2000, accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_ChequeNumber());
    			accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_ChequeNumber().sendKeys(testData.get("ChequeNumber"));
    			javascripthelper.scrollIntoViewAndClick(accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_Footer());
    }

    @And("^User Enter remark for Manual Payout$")
    public void user_enter_remark_for_manual_payout() throws Throwable {
    	//Remarks
    			waithelper.waitForElement(driver, 2000,accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_Remark());
    			accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_Remark().sendKeys(testData.get("Remarks"));
    }

    @And("^User Select the Payment transaction number$")
    public void user_select_the_payment_transaction_number() throws Throwable {
    	//SelectPaymentTxnNumber
    			for (int i = 0; i <200; i++) {
					try {
						accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_SelectPaymentTxnNumber().click();
						break;
					} catch (Exception e) {
						if (i==199) {
							Assert.fail(e.getMessage());					}
						}
						
				}
    			
    }

    
 /*
  *    @And("^Submit the Selected record of Manual payout$")
  
    public void submit_the_selected_record_of_manual_payout() throws Throwable {
    // Submit button
    waithelper.waitForElement(driver, 2000,accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_SubmitButton());
    accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_SubmitButton().click();
    		 
		
    //Remark
    javascripthelper.JavaScriptHelper(driver);
    waithelper.waitForElement(driver, 3000,accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_RemarkFieldMaker());
    javascripthelper.JSEClick(accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_RemarkFieldMaker());
    accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_RemarkFieldMaker().sendKeys("OK");
    	
	//Remark Submit
	
	waithelper.waitForElement(driver, 2000,accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_SubmitByMaker());
	accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_SubmitByMaker().click();
	Thread.sleep(2000);
	
	// REVIEWER
			Thread.sleep(2000);
			WebElement recordstatus = accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_RecordStatus();

			clicksAndActionHelper.moveToElement(recordstatus);
			String message = accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_RecordStatus().getText();
			System.out.println(message);
			accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_RecordStatus().click();
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
			jsonWriter = new JsonDataReaderWriter();
			jsonWriter.addData(reviewerId);
	
}*/
 
 


    
//    @Then("^Get the payout status$")
//    public void get_the_payout_status()  {
//    	
//    	waithelper.waitForElement(driver, 3000, accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_Search());
//    	accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_Search().click();
//    	waithelper.waitForElement(driver, 3000, accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_BusinessPartnerSearch());
//    	accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_BusinessPartnerSearch().sendKeys(accountsPayable_ManualPayoutEmployeeTestDataType.BP_Name);
//    	System.out.println("Payout Status is - " +accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_PayoutStatus().getText());
//       
//    }
   /* @Then("^click on the Notification select the record and reviewer Approve$")
    * 
   
    public void click_on_the_notification_select_the_record_and_reviewer_approve() throws Throwable {
    
  //notification
	waithelper = new WaitHelper(driver);
	reviewer = new Azentio_ReviewerObj(driver);
	waithelper.waitForElement(driver, 2000, reviewer.reviewerNotidicationIcon());
	reviewer.reviewerNotidicationIcon().click();
	
	
	//select the record
	browserHelper = new BrowserHelper(driver);
	budgetdata =  jsonReader.getBudgetdataByName("Maker");
	javascripthelper = new JavascriptHelper();
	Thread.sleep(1000);
	for (int i = 1; i <= 35; i++) {
		try {
			waithelper.waitForElement(driver, 3000, driver.findElement(
					By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]")));
			WebElement referanceID = driver.findElement(
					By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]"));
			referanceID.click();
			Assert.assertTrue(referanceID.isDisplayed());
			break;
		} catch (NoSuchElementException e) {
			waithelper.waitForElement(driver, 4000, kubschecker.checker_notification_next_button());

			kubschecker.checker_notification_next_button().click();
		}
	}
	String before_xpath = "//span[contains(text(),'";
	String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

	waithelper.waitForElement(driver, 5000,
			driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)));
	driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)).click();

	// Approve
	waithelper.waitForElement(driver, 4000, reviewer.reviewerApproveButton());
	reviewer.reviewerApproveButton().click();
	waithelper.waitForElement(driver, 2000,accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_ReviewerRemark() );
	accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_ReviewerRemark().sendKeys("ok");
	waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertSubmitButton());
	reviewer.reviewerAlertSubmitButton().click();
	Thread.sleep(3000);

    }
    @And("^select the record and Approve remark by checker$")
    public void select_the_record_and_approve_remark_by_checker() throws InterruptedException, IOException, ParseException, org.json.simple.parser.ParseException  {
    Thread.sleep(1000);
	for (int i = 1; i <= 35; i++) {
		try {
		waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +reader.readReferancedata()+ "')]")));
		WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" +  reader.readReferancedata() + "')]"));
		referanceID.click();
		Assert.assertTrue(referanceID.isDisplayed());
		break;
		} catch (NoSuchElementException e) {
			waithelper.waitForElement(driver,4000,kubschecker.checker_notification_next_button());
			kubschecker.checker_notification_next_button().click();
			}
    }
		String before_xpath="//span[contains(text(),'";
		String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
		 
		waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath(before_xpath +reader.readReferancedata()+after_xpath)));
		driver.findElement(By.xpath(before_xpath +reader.readReferancedata() +after_xpath)).click();
		
		
		//Approve
    	waithelper.waitForElement(driver,2000,kubschecker.checkerApproveButton());
    	kubschecker.checkerApproveButton().click();
    	Thread.sleep(2000);
    	waithelper.waitForElement(driver, 2000, accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_Remark());
    	accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_Remark().sendKeys("OK");
		Thread.sleep(2000);
		waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();
		Thread.sleep(6000);
	} */
    @And("^Select and Submit the Update Deposited Cheque record$")
	public void select_and_submit_the_update_deposited_cheque_record()
			throws InterruptedException, IOException, ParseException {

		// Reference
		waithelper.waitForElement(driver, 2000,
				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReferenceId());
		String id = inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReferenceId().getText();
		excelData.updateTestData("KUBS_AR/AP_UAT_006_003_TC_01_02_D1","Reference ID", id);
		//jsonWriter.addReferanceData(id);
		System.out.println("Reference ID:" + id);
//		for (int i = 1; i <= 35; i++) {
//			try {
//				waithelper.waitForElement(driver, 3000, driver
//						.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]")));
//				WebElement referanceID = driver
//						.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]"));
//				referanceID.click();
//				System.out.println(referanceID);
//				// Assert.assertTrue(referanceID.isDisplayed());
//				break;
//			} catch (NoSuchElementException e) {
//				waithelper.waitForElement(driver, 4000,
//						inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_NotificationNext_Button());
//
//				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_NotificationNext_Button().click();
//			}
//
//		}
	//	inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReferenceId().click();

		// pencil
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
		testData = excelData.getTestdata("KUBS_AR/AP_UAT_006_003_TC_01_02_D1");
		waithelper.waitForElement(driver, 2000,
				driver.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath)));
		driver.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath)).click();

		// Submit button
		waithelper.waitForElement(driver, 2000,
				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitButton());
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitButton().click();

		// Remark
		javascripthelper.JavaScriptHelper(driver);
		waithelper.waitForElement(driver, 3000,
				accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_RemarkField());
		javascripthelper.JSEClick(
				accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_RemarkField());
		accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_RemarkField().sendKeys("OK");
		// inventoryMaintenanceTestDataType.Remark

		// Remark Submit
		waithelper.waitForElement(driver, 2000,
				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitByMaker());
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
		//System.out.println(reviewerId);
		//jsonWriter = new JsonDataReaderWriter();
		excelData.updateTestData("KUBS_AR/AP_UAT_006_003_TC_01_02_D1","Reviewer ID",reviewerId);
		//jsonWriter.addData(reviewerId);

	}
    @Then("^click on the Notification select the Cheque record and Approve$")
	public void click_on_the_notification_select_the_cheque_record_and_approve()
			throws InterruptedException, IOException, ParseException {
		// notification
		waithelper = new WaitHelper(driver);
		reviewer = new Azentio_ReviewerObj(driver);
		waithelper.waitForElement(driver, 2000, reviewer.reviewerNotidicationIcon());
		reviewer.reviewerNotidicationIcon().click();

		// select the record
		browserHelper = new BrowserHelper(driver);
		// budgetdata = jsonReader.getBudgetdataByName("Maker");
		javascripthelper = new JavascriptHelper();
		Thread.sleep(1000);
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

		for (int i = 0; i <200; i++) {
			try {
				driver.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath)).click();
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
		}
		

		// Approve
		waithelper.waitForElement(driver, 4000, reviewer.reviewerApproveButton());
		reviewer.reviewerApproveButton().click();
		waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertRemarkSecond());
		reviewer.reviewerAlertRemarkSecond().sendKeys(testData.get("Remarks"));
		waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertSubmitButton());
		reviewer.reviewerAlertSubmitButton().click();
		Thread.sleep(3000);

	}
    @And("^select the Cheque record and Approve by checker$")
	public void select_the_cheque_record_and_approve_by_checker()
			throws InterruptedException, IOException, ParseException {
		Thread.sleep(1000);
		for (int i = 0; i <200; i++) {
			try {
				String before_xpath = "//span[contains(text(),'";
				String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

				waithelper.waitForElement(driver, 2000,
						driver.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath)));
				driver.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath)).click();
				break;
			} catch (StaleElementReferenceException e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}

		}
					
		// Approve
		waithelper.waitForElement(driver, 2000, kubschecker.checkerApproveButton());
		kubschecker.checkerApproveButton().click();
		Thread.sleep(2000);
		waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarkSecond());
		kubschecker.checkerRemarkSecond().sendKeys(testData.get("Reviewer ID"));
		Thread.sleep(2000);
		waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();
		Thread.sleep(2000);
	}
    @And("^click on view button near by manual payout module$")
    public void click_on_view_button_near_by_manual_payout_module() throws Throwable {
		//waitHelper.waitForElementVisible(manualPayoutObj.accountsPayable_ManualPayoutViewButton(), 2000, 200);
		javascrtiptHelper.JavaScriptHelper(driver);
		javascrtiptHelper.scrollIntoView(manualPayoutObj.accountsPayable_ManualPayoutViewButton());
		manualPayoutObj.accountsPayable_ManualPayoutViewButton().click();
		
    }
	@And("^search the active record in the manual pay out and get the transaction reference number$")
    public void search_the_active_record_in_the_manual_pay_out_and_get_the_transaction_reference_number() throws Throwable {
     //waitHelper.waitForElementVisible(manualPayoutObj.accountsPayablePayoutStatus(), 2000, 200);
		javascrtiptHelper.JavaScriptHelper(driver);
		javascrtiptHelper.scrollIntoView(manualPayoutObj.accountsPayablePayoutStatus());
     manualPayoutObj.accountsPayablePayoutStatus().click();
     manualPayoutObj.accountsPayablePayoutStatus().sendKeys(testData.get("Search Approved Record"));
     
     waitHelper.waitForElementVisible(manualPayoutObj.approvedManualPayoutReferenceNumber(), 2000, 200);
     String payoutApprovedReferenceNumber=manualPayoutObj.approvedManualPayoutReferenceNumber().getText();
     payoutData.put("approvedReferenceNumber", payoutApprovedReferenceNumber);
     
    }
	@Then("^verify the manual payout is appeared in the accounting entries$")
    public void verify_the_manual_payout_is_appeared_in_the_accounting_entries() throws Throwable {
		Thread.sleep(1000);
		javascrtiptHelper.JavaScriptHelper(driver);
		// boolean pageStatus = true;
		// javascriptHelper.scrollDownByPixel();
		for (int i = 0; i < 299; i++) {
			try {
				waitHelper
						.waitForElementVisible(
								driver.findElement(By.xpath("//datatable-body-cell[1]//span[contains(text(),'"
										+ payoutData.get("approvedReferenceNumber") + "')]")),
								2000, 100);
				driver.findElement(By.xpath("//datatable-body-cell[1]//span[contains(text(),'"
						+ payoutData.get("approvedReferenceNumber") + "')]")).isDisplayed();
				break;
			} catch (NoSuchElementException e) {
				// waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementNextRecord(),
				// 1000, 100);

				javascrtiptHelper.scrollIntoView(paymentSettlementObj.accountsPayablePayementSettlementNextRecord());

				paymentSettlementObj.accountsPayablePayementSettlementNextRecord().click();
			}

			if (i == 299) {
				Assert.fail("InvoiceNumber not availabe : " + payoutData.get("approvedReferenceNumber"));
			}
		}

	}

	@And("^search the multiple bill payout approved reference number$")
    public void search_the_multiple_bill_payout_approved_reference_number() throws Throwable {
		
		javascrtiptHelper.JavaScriptHelper(driver);
		javascrtiptHelper.scrollIntoView(manualPayoutObj.accountsPayableSearchApprovvedPayoutNumber());
       manualPayoutObj.accountsPayableSearchApprovvedPayoutNumber().click();
       manualPayoutObj.accountsPayableSearchApprovvedPayoutNumber().sendKeys(ManualPayoutData.ManualPayoutReferenceNumber);
       
	}
	@And("^choose branch code$")
	public void choose_branch_code() throws Throwable {
		for (int i = 0; i <200; i++) {
			try {
				inventoryEnquiryGlObj.inventoryBranchCode().sendKeys(testData.get("Branch Code"));
				inventoryEnquiryGlObj.inventoryBranchCode().sendKeys(Keys.ENTER);
				break;
			} catch (Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
				
			}
		}
		
	}
	@Then("^choose the from date$")
	public void choose_the_from_date() throws Throwable {
		
		javascripthelper.JavaScriptHelper(driver);
		while(true)
        {
		try
		{
		
			waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("FromMonth")+" "+testData.get("FromYear")+"')]")));
			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("FromMonth")+" "+testData.get("FromYear")+"')]"));
		    break;
		}
		
		catch(NoSuchElementException nosuchElement)
		{
			inventoryEnquiryGlObj.inventoryNextMonth().click();
		}
		}
		WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FromFullMonth")+" "+testData.get("FromDate")+", "+testData.get("FromYear")+"']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
	}
	@Then("^choose the to date$")
	public void choose_the_to_date() throws Throwable {
		while(true)
        {
		try
		{
		
			waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("ToMonth")+" "+testData.get("ToYear")+"')]")));
			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("ToMonth")+" "+testData.get("ToYear")+"')]"));
		    break;
		}
		
		catch(NoSuchElementException nosuchElement)
		{
			inventoryEnquiryGlObj.inventoryNextMonth().click();
		}
		}
		WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+testData.get("ToFullMonth")+" "+testData.get("ToDate")+", "+testData.get("ToYear")+"']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
	}
	
	@Then("^click on temp grid button of Balance sheet report$")
    public void click_on_temp_grid_button_of_balance_sheet_report()  {
		waithelper.waitForElement(driver, 3000, financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_TempGridButton());
		financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_TempGridButton().click();
    }
	@And("^User Select the branch name for Balance sheet post payout$")
    public void user_select_the_branch_name_for_balance_sheet_post_payout() throws Throwable {
		waithelper.waitForElement(driver, 3000, financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_Branch());
		financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_Branch().sendKeys(testData.get("AZENTMAIN-Azentio Main Branch"));
		financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_Branch().sendKeys(Keys.ENTER);
    }

    @And("^User Select the report type for Balance sheet post payout$")
    public void user_select_the_report_type_for_balance_sheet_post_payout() throws Throwable {
    	waithelper.waitForElement(driver, 3000, financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_ReportType());
		financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_ReportType().sendKeys(testData.get("Report Type"));
		financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_ReportType().sendKeys(Keys.ENTER);
    }

    @And("^User Select the balance sheet on date for Balance sheet post payout$")
    public void user_select_the_balance_sheet_on_date_for_balance_sheet_post_payout() throws Throwable {
    	waithelper.waitForElement(driver, 3000, financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_BalanceSheetAsOnDate());
		financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_BalanceSheetAsOnDate().click();
		javascripthelper.JavaScriptHelper(driver);
		while(true)
        {
		try
		{
		
			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("FromMonth")+" "+testData.get("FromYear")+"')]")));
			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("FromMonth")+" "+testData.get("FromYear")+"')]"));
		    break;
		}
		
		catch(NoSuchElementException nosuchElement)
		{
			inventoryEnquiryGlObj.inventoryNextMonth().click();
		}
		}
		WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FromFullMonth")+" "+testData.get("FromDate")+", "+testData.get("FromYear")+"']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
    }
	
	@And("^fill the required field of Balance sheet report$")
	public void fill_the_required_field_of_balance_sheet_report() {
		
		
		
		
		
		
		
		while(true)
		{
			try 
			{
				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+BalanceSheetReportTestDataType.BalanceSheetMonth+" "+BalanceSheetReportTestDataType.BalanceSheetYear+"')]")));
				WebElement birthmonthandyear=driver.findElement(By.xpath("//span[contains(text(),'"+BalanceSheetReportTestDataType.BalanceSheetMonth+" "+BalanceSheetReportTestDataType.BalanceSheetYear+"')]"));
//				driver.findElement(By.xpath("//div/div/button")).getText().contains(bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthMonth+" "+bUSINESS_PARTNER_SETUP_BusinessPartnerTestDataType.BirthYear);
				break;
			}catch(NoSuchElementException nosuchElement)
			{
				waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SelectDate());
				bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_SelectDate().click();
				String tablehead=bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_HeadYear().getText();
//				String tablehead="2016 ~ 2036";
				String headyear=tablehead.replaceAll(" ~", "");
//				System.out.println(headyear);
				String ar[] = headyear.split(" ");
				int y1=Integer.parseInt(ar[0]);
				int y2=Integer.parseInt(ar[1]);
				int year=Integer.parseInt(BalanceSheetReportTestDataType.BalanceSheetYear);
				if(year < y1 && year<y2)
				{
					while(true)
					{
						try {
							waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+BalanceSheetReportTestDataType.BalanceSheetYear+"')]")));
							WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+BalanceSheetReportTestDataType.BalanceSheetYear+"')]"));
						    break;
						}
						catch(NoSuchElementException nosuchElement1) {
							waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear());
							bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnPreviousYear().click();
						}
					}
					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+BalanceSheetReportTestDataType.BalanceSheetYear+"')]")));
					WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+BalanceSheetReportTestDataType.BalanceSheetYear+"')]"));
					Year.click();
					
					waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//td[@aria-label='"+BalanceSheetReportTestDataType.BalanceSheetFullMonth+" "+BalanceSheetReportTestDataType.BalanceSheetYear+"']")));
					driver.findElement(By.xpath("//td[@aria-label='"+BalanceSheetReportTestDataType.BalanceSheetFullMonth+" "+BalanceSheetReportTestDataType.BalanceSheetYear+"']")).click();
					
				}
				else if(year>y1 && year>y2)
				{
					while(true)
					{
						try {
							waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+BalanceSheetReportTestDataType.BalanceSheetYear+"')]")));
							WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+BalanceSheetReportTestDataType.BalanceSheetYear+"')]"));
						    break;
						}
						catch(NoSuchElementException nosuchElement2) {
							waithelper.waitForElement(driver, 3000, bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear());
							bUSINESS_PARTNER_SETUP_BusinessPartnerObj.businessPartner_ClickOnNextYear().click();
						}
					}
					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+BalanceSheetReportTestDataType.BalanceSheetYear+"')]")));
					WebElement Year=driver.findElement(By.xpath("//span[contains(text(),'"+BalanceSheetReportTestDataType.BalanceSheetYear+"')]"));
					clicksAndActionHelper.doubleClick(Year);
					
					waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//td[@aria-label='"+BalanceSheetReportTestDataType.BalanceSheetFullMonth+" "+BalanceSheetReportTestDataType.BalanceSheetYear+"']")));
					driver.findElement(By.xpath("//td[@aria-label='"+BalanceSheetReportTestDataType.BalanceSheetFullMonth+" "+BalanceSheetReportTestDataType.BalanceSheetYear+"']")).click();
					
				}
				else
				{
					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='"+BalanceSheetReportTestDataType.BalanceSheetYear+"']")));
					WebElement Year=driver.findElement(By.xpath("//td[@aria-label='"+BalanceSheetReportTestDataType.BalanceSheetYear+"']"));
					Year.click();
					
					waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//td[@aria-label='"+BalanceSheetReportTestDataType.BalanceSheetFullMonth+" "+BalanceSheetReportTestDataType.BalanceSheetYear+"']")));
					driver.findElement(By.xpath("//td[@aria-label='"+BalanceSheetReportTestDataType.BalanceSheetFullMonth+" "+BalanceSheetReportTestDataType.BalanceSheetYear+"']")).click();
					
				}
			}
		}
		waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='"+BalanceSheetReportTestDataType.BalanceSheetFullMonth +" "+BalanceSheetReportTestDataType.BalanceSheetDate+", "+BalanceSheetReportTestDataType.BalanceSheetYear+"']/span")));	
		WebElement BirthDate=driver.findElement(By.xpath("//td[@aria-label='"+BalanceSheetReportTestDataType.BalanceSheetFullMonth +" "+BalanceSheetReportTestDataType.BalanceSheetDate+", "+BalanceSheetReportTestDataType.BalanceSheetYear+"']/span"));
		clicksAndActionHelper.doubleClick(BirthDate);
		
	}

    @Then("^click on view button to view the balance sheet report$")
    public void click_on_view_button_to_view_the_balance_sheet_report()  {
    	waithelper.waitForElement(driver, 3000, financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_BalanceSheetReportView());
    	financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_BalanceSheetReportView().click();
    	
    }
    
    @Then("^Verify balance sheet should updated correctly$")
    public void Verify_balance_sheet_should_updated_correctly() throws InterruptedException  {
    	Thread.sleep(1000);
    	javascripthelper.JavaScriptHelper(driver);
    	browserHelper.SwitchToWindow(1);
    	waithelper.waitForElement(driver, 3000, financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_UpdatedData());
    	javascripthelper.scrollIntoView(financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_UpdatedData()); 
    	String receivableAmount = financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_UpdatedData().getText();
    	System.out.println("Trade Receivables Advances to Employee - "+ receivableAmount);
    	browserHelper.switchToParentWithChildClose();
    }
    
    @Then("^Verify balance sheet should updated correctly post approval through online mode$")
    public void Verify_balance_sheet_should_updated_correctly_post_approval_through_online_mode() throws InterruptedException  {
    	Thread.sleep(1000);
    	javascripthelper.JavaScriptHelper(driver);
    	browserHelper.SwitchToWindow(1);
    	waithelper.waitForElement(driver, 3000, financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_UpdatedDataReceipt());
    	javascripthelper.scrollIntoView(financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_UpdatedDataReceipt()); 
    	String receiptAmount = financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_UpdatedDataReceipt().getText();
    	System.out.println("Receivables Cash Equivalents - "+ receiptAmount);
    	browserHelper.switchToParentWithChildClose();
    }
    
    @Then("^Verify balance sheet should updated correctly post cheque is cleared$")
    public void Verify_balance_sheet_should_updated_correctly_post_cheque_is_cleared() throws InterruptedException  {
    	Thread.sleep(1000);
    	javascripthelper.JavaScriptHelper(driver);
    	browserHelper.SwitchToWindow(1);
    	waithelper.waitForElement(driver, 3000, financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_UpdatedDataReceipt());
    	javascripthelper.scrollIntoView(financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_UpdatedDataReceipt()); 
    	String chequeAmount = financialReporting_GLBalancesReportObj.FinancialReporting_BalanceSheetReport_UpdatedDataReceipt().getText();
    	System.out.println("Receivables Cash Equivalents - "+ chequeAmount);
    	browserHelper.switchToParentWithChildClose();
    }
    @And("^click ok segment segmant button$")
    public void click_ok_segment_segmant_button() throws Throwable {
    	waitHelper.waitForElementVisible(makerObj.kubsDirectionIcon(), 2000, 200);
    	makerObj.kubsDirectionIcon().click();
    }
    @And("^select the approved credit note reference number$")
    public void select_the_approved_credit_note_reference_number() throws Throwable {
    	waitHelper.waitForElementVisible(creditNoteObj.approvedCreditNoteRecord(), 2000, 200);
    	String approvedCreditNoteReferenceNumber=creditNoteObj.approvedCreditNoteRecord().getText();
    	testData.put("approvedCreditNoteReferenceNumber", approvedCreditNoteReferenceNumber);

    }

    @And("^get the credit note amount$")
    public void get_the_credit_note_amount() throws Throwable {
    	String approvedCreditNoteAmount=creditNoteObj.creditNoteApprovedCreditAmount().getText();
    	testData.put("approvedCreditNoteAmount", approvedCreditNoteAmount);
    }

    @And("^get the business partner name from approved credit note$")
    public void get_the_business_partner_name_from_approved_credit_note() throws Throwable {
    	String approvedCreditNoteBpName=creditNoteObj.creditNoteApprovedBusinessPartnerName().getText();
    	testData.put("approvedCreditNoteBpName", approvedCreditNoteBpName);
    }
    @And("^click on temp view near by accounts receivable report$")
    public void click_on_temp_view_near_by_accounts_receivable_report() throws Throwable {
    	waitHelper.waitForElementVisible(accountsReceivableReportObj.accountsReceivableReportTempView(), 2000, 200);
    	accountsReceivableReportObj.accountsReceivableReportTempView().click();
    	
    }

    @And("^click on business partner for settled credit note$")
    public void click_on_business_partner_for_settled_credit_note() throws Throwable {
    	waitHelper.waitForElementVisible(accountsReceivableReportObj.accountsReceivableReportBusinessPartnerName(), 2000, 200);
    	accountsReceivableReportObj.accountsReceivableReportBusinessPartnerName().click();
    	accountsReceivableReportObj.accountsReceivableReportBusinessPartnerName().sendKeys(testData.get("approvedCreditNoteBpName"));
    	accountsReceivableReportObj.accountsReceivableReportBusinessPartnerName().sendKeys(Keys.ENTER);
    }

    @And("^enter active credit note status in accounts Receivable module$")
    public void enter_active_credit_note_status_in_accounts_receivable_module() throws Throwable {
    	accountsReceivableReportObj.accountsReceivableReportPayableStatus().click();
    	accountsReceivableReportObj.accountsReceivableReportPayableStatus().sendKeys(reportTestData.ReceivableReportStatusAll);
    	accountsReceivableReportObj.accountsReceivableReportPayableStatus().sendKeys(Keys.ENTER);
    }
    @Then("^verify the approved credit note is available in the receivable report$")
    public void verify_the_approved_credit_note_is_available_in_the_receivable_report() throws Throwable {
    	browserHelper.SwitchToWindow(1);
		Thread.sleep(1000);
		javascriptHelper.JavaScriptHelper(driver);
//		while (true) {
//			try {
//				javascriptHelper.scrollIntoView(driver.findElement(
//						By.xpath("//div[contains(text(),'" + testData.get("approvedCreditNoteReferenceNumber") + "')]")));
//				driver.findElement(By.xpath("//div[contains(text(),'" + testData.get("approvedCreditNoteReferenceNumber") + "')]"));
//				break;
//			} catch (NoSuchElementException e) {
//				accountsReceivableReportObj.accountsReceivableReportNextRecord().click();
//			} catch (StaleElementReferenceException e1) {
//
//			}
//		}
		browserHelper.switchToParentWithChildClose();
    }

    
    /********* KUBS_AR_AP_UAT_006_003_TC_04 ***************/
    @And("^search the advance approved reference number in the reference number search column$")
    public void search_the_advance_approved_reference_number_in_the_reference_number_search_column() throws Throwable {
    	javascriptHelper.JavaScriptHelper(driver);
    	javascriptHelper.scrollIntoView(manualPayoutObj.accountsPayableSearchApprovvedPayoutNumber());
    	manualPayoutObj.accountsPayableSearchApprovvedPayoutNumber().click();
    	manualPayoutObj.accountsPayableSearchApprovvedPayoutNumber().sendKeys(testData.get("Advance Reference number"));
  
    }
    @And("^Choose date for Accounts Receivable report$")
    public void choose_date_for_accounts_receivable_report() throws Throwable {
    	while(true)
        {
		try
		{
		
			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("FromMonth")+" "+testData.get("FromYear")+"')]")));
			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("FromMonth")+" "+testData.get("FromYear")+"')]"));
		    break;
		}
		
		catch(NoSuchElementException nosuchElement)
		{
			inventoryEnquiryGlObj.inventoryNextMonth().click();
		}
		}
		WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FromFullMonth")+" "+testData.get("FromDate")+", "+testData.get("FromYear")+"']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
    }

    @And("^get the business partner nname$")
    public void get_the_business_partner_nname() throws Throwable {
    	String approvedBpName=manualPayoutObj.accountsPayableApprovedBpName().getText();
    	testData.put("approveBpName", approvedBpName);
    	System.out.println(testData.get("approveBpName"));
    	
    }

    @And("^click on the perticular suggestion record and get the advance reference number$")
    public void click_on_the_perticular_suggestion_record_and_get_the_advance_reference_number() throws Throwable {
    	
    	javascriptHelper.JavaScriptHelper(driver);
    	manualPayoutObj.accountsPayablePayoutRecord().click();
    	Thread.sleep(1000);
    	javascriptHelper.scrollIntoView(manualPayoutObj.accountsPayableGetAdvanceReferenceNumber());
    	String receivableReferenceNo=manualPayoutObj.accountsPayableGetAdvanceReferenceNumber().getText();
    	testData.put("receivableReferenceNo", receivableReferenceNo);
    	System.out.println("Receivable reference number : "+receivableReferenceNo);

    }
    @And("^enter the business partner name for advances to employee$")
    public void enter_the_business_partner_name_for_advances_to_employee() throws Throwable {
    	accountsReceivableReportObj.accountsReceivableReportBusinessPartnerName().click();
    	accountsReceivableReportObj.accountsReceivableReportBusinessPartnerName().sendKeys(testData.get("approveBpName"));
    	accountsReceivableReportObj.accountsReceivableReportBusinessPartnerName().sendKeys(Keys.ENTER);
    }   
    @And("^enter the advances to employee status active$")
    public void enter_the_advances_to_employee_status_active() throws Throwable {
    	accountsReceivableReportObj.accountsReceivableReportPayableStatus().click();
    	accountsReceivableReportObj.accountsReceivableReportPayableStatus().sendKeys(reportTestData.ReceivableReportStatusAll);
    	accountsReceivableReportObj.accountsReceivableReportPayableStatus().sendKeys(Keys.ENTER);
    }
    @Then("^verify the advance reference number is available in the accounts Receivable report$")
    public void verify_the_advance_reference_number_is_available_in_the_accounts_receivable_report() throws Throwable {
    	browserHelper.SwitchToWindow(1);
		Thread.sleep(1000);
		javascriptHelper.JavaScriptHelper(driver);
		while (true) {
			try {
				javascriptHelper.scrollIntoView(driver.findElement(
						By.xpath("//div[contains(text(),'" + testData.get("receivableReferenceNo") + "')]")));
				driver.findElement(By.xpath("//div[contains(text(),'" + testData.get("receivableReferenceNo") + "')]"));
				break;
			} catch (NoSuchElementException e) {
				accountsReceivableReportObj.accountsReceivableReportNextRecord().click();
			} catch (StaleElementReferenceException e1) {

			}
		}
		browserHelper.switchToParentWithChildClose();
    }



   	 




}
