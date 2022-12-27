package stepdefinitions;

import java.io.IOException;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import pageobjects.AccountReceivable_UpdateDepositedChequeObj;
import pageobjects.AccountsPayable_ManualPayoutEmployeeObj;
import pageobjects.Azentio_CheckerObj;
import pageobjects.Azentio_ReviewerObj;
import pageobjects.InventoryMaintenanceObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;
import testDataType.AccountsPayable_ManualPayoutEmployeeTestDataType;
import testDataType.BUDGET_BudgetCreationTestDataType;


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
	AccountReceivable_UpdateDepositedChequeObj accountReceivable_UpdateDepositedChequeObj = new AccountReceivable_UpdateDepositedChequeObj(
			driver);
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
	String excelPath = System.getProperty("user.dir")+"\\Test-data\\KUBSTestData.xlsx";
	ExcelData excelData = new ExcelData(excelPath,"ARAP_ManualPayout","Data Set ID");
	private Map<String, String> testData;
	
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
	 
	 @And("^User update test data id for Approve cancelled payment settlement transaction in reviewver$")
	    public void user_update_test_data_id_for_approve_cancelled_payment_settlement_transaction_in_reviewver() throws Throwable {
		 testData = excelData.getTestdata("KUBS_AR/AP_UAT_005_001_TC_01_02_D1");  
	    }
	 @And("^User update test data id to verify the cancelled payment settlement transaction in Maker$")
	    public void user_update_test_data_id_to_verify_the_cancelled_payment_settlement_transaction_in_maker() throws Throwable {
		 testData = excelData.getTestdata("KUBS_AR/AP_UAT_005_001_TC_01_04_D1");
	    }
	 @And("^User update test data id to verify cancelled payment txn is not available for payout on payout screen$")
	    public void user_update_test_data_id_to_verify_cancelled_payment_txn_is_not_available_for_payout_on_payout_screen() throws Throwable {
		 testData = excelData.getTestdata("KUBS_AR/AP_UAT_005_001_TC_02_01_D1"); 
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
   	 




}
