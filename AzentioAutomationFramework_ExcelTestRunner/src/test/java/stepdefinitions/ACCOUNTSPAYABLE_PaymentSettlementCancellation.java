package stepdefinitions;

import java.io.IOException;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
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
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ACCOUNTSPAYABLE_InvoiceBookingObj;
import pageobjects.ACCOUNTSPAYABLE_ManualPayoutObj;
import pageobjects.ACCOUNTSPAYABLE_PayementSettlementObj;
import pageobjects.ACCOUNTSPAYABLE_PaymentSettlementCancellationObj;
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
import pageobjects.AccountsPayable_ManualPayoutEmployeeObj;
import pageobjects.ArAp_BalanceSheetReportObj;
import pageobjects.INVENTORY_EnquiryGlObject;
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;
import testDataType.ACCOUNTSPAYABLE_PaymentSettlementCancellationTestDataType;
import testDataType.ACCOUNTSPAYABLE_VendorContractsTestDataType;
import testDataType.ArAp_BalanceSheetReportTestDataType;

public class ACCOUNTSPAYABLE_PaymentSettlementCancellation {
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	ConfigFileReader config = new ConfigFileReader();
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver);
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(driver);
	ACCOUNTSPAYABLE_InvoiceBookingObj aCCOUNTSPAYABLE_InvoiceBookingObj = new ACCOUNTSPAYABLE_InvoiceBookingObj(driver);
	ACCOUNTSPAYABLE_ManualPayoutObj aCCOUNTSPAYABLE_ManualPayoutObj = new ACCOUNTSPAYABLE_ManualPayoutObj(driver);
	ACCOUNTSPAYABLE_PaymentSettlementCancellationObj aCCOUNTSPAYABLE_PaymentSettlementCancellationObj = new ACCOUNTSPAYABLE_PaymentSettlementCancellationObj(driver);
	ACCOUNTSPAYABLE_PaymentSettlementCancellationTestDataType PaymentSettlementCancellationTestDataType=jsonReader.getPaymentSettlementCancellationdata("Maker");
	ACCOUNTSPAYABLE_PayementSettlementObj paymentSettlementObj = new ACCOUNTSPAYABLE_PayementSettlementObj(driver);
	INVENTORY_EnquiryGlObject inventoryEnquiryGlObj=new INVENTORY_EnquiryGlObject(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter reader;
	KUBS_Login kubsLogin;
	BrowserHelper browserHelper;
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	ACCOUNTSPAYABLE_VendorContractsTestDataType aCCOUNTSPAYABLE_VendorContractsTestDataType;
	String excelPath = System.getProperty("user.dir")+"\\Test-data\\KUBSTestData.xlsx";
	ExcelData excelData = new ExcelData(excelPath,"ARAP_ManualPayout","Data Set ID");
	private Map<String, String> testData;
	// balance sheet
	AccountsPayable_ManualPayoutEmployeeObj accountsPayable_ManualPayoutEmployeeObj = new AccountsPayable_ManualPayoutEmployeeObj(driver);
	ConfigFileReader configFileReader = new ConfigFileReader();
	DropDownHelper dropDownHelper;
	ArAp_BalanceSheetReportObj arAp_BalanceSheetReportObj = new ArAp_BalanceSheetReportObj(driver);
	ArAp_BalanceSheetReportTestDataType arAp_BalanceSheetReportTestDataType = jsonReader.getBalanceSheetReportByName("maker");
	
//--------  @KUBS_AR/AP_UAT_005_002_TC_01  ------------
	@Then("^log in to the reviewer account for payment settlement$")
    public void log_in_to_the_reviewer_account_for_payment_settlement() throws Throwable {
		kubsLogin = new KUBS_Login(driver);
		driver.get(config.getApplicationUrl());
		kubsLogin.logintoAzentioappReviewer(testData.get("Reviewer ID"));
		Thread.sleep(1000); 
    }
    @When("^click on eye button of payment settlement cancellation$")
    public void click_on_eye_button_of_payment_settlement_cancellation() throws InterruptedException {
//    	javascripthelper.JavaScriptHelper(driver);
//    	javascripthelper.scrollIntoView(aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_EyeButton());
    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_EyeButton());
    	aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_EyeButton().click();
    }
    @And("^User update test data id for cancellation of payment settlement$")
    public void user_update_test_data_id_for_cancellation_of_payment_settlement() throws Throwable {
	 testData = excelData.getTestdata("KUBS_AR/AP_UAT_005_001_TC_01_01_D1");
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
	 testData = excelData.getTestdata("KUBS_AR/AP_UAT_005_001_TC_02_D1"); 
    }
 @And("^User update test data id to verify accounting entries post payment settlement approval$")
    public void user_update_test_data_id_to_verify_accounting_entries_post_payment_settlement_approval() throws Throwable {
	 testData = excelData.getTestdata("KUBS_AR/AP_UAT_005_001_TC_03_D1"); 
    }
 @And("^User Update test data id to Verify Balance sheet post payment settlement approval$")
 public void user_update_test_data_id_to_verify_balance_sheet_post_payment_settlement_approval() throws Throwable {
	 testData = excelData.getTestdata("KUBS_AR/AP_UAT_005_001_TC_04_D1");
 }
    @And("^click on add button for payment settlement cancellation$")
    public void click_on_add_button_for_payment_settlement_cancellation() {
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_AddButton());
    	aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_AddButton().click();
    }
    @And("^search for approved record in view area for post payment settlement$")
    public void search_for_approved_record_in_view_area_for_post_payment_settlement() throws Throwable {
    	paymentSettlementObj.paymentSettlementSearchTXNNumber().click();
		paymentSettlementObj.paymentSettlementSearchTXNNumber().sendKeys(testData.get("Search Approved Record"));
    }
    @And("^User Select the Entity branch for payment cancellation$")
    public void user_select_the_entity_branch_for_payment_cancellation() throws Throwable {
    	javascripthelper.JavaScriptHelper(driver);
		waithelper.waitForElement(driver, 2000,aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_EntityBranch());
		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_EntityBranch().sendKeys(testData.get("EntityBranch"));
		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_EntityBranch().sendKeys(Keys.ENTER);
    }

    @And("^User Select the Transaction Number for payment cancellation$")
    public void user_select_the_transaction_number_for_payment_cancellation() throws Throwable {
    	waithelper.waitForElement(driver, 2000,aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_PaymentTxnNumber());
		//aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_PaymentTxnNumber().sendKeys(testData.get("TransactionReferenceNumber"));
    	aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_PaymentTxnNumber().sendKeys(Keys.DOWN);
    	aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_PaymentTxnNumber().sendKeys(Keys.ENTER);
    }
    @And("^Store the selected Transaction number for payment cancellation$")
    public void store_the_selected_transaction_number_for_payment_cancellation() throws Throwable {
        
    }

    @And("^User Select the value date for payment cancellation$")
    public void user_select_the_value_date_for_payment_cancellation() throws Throwable {
    	aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_ValueDateCalendar().click();
		Thread.sleep(2000);
		javascripthelper.JavaScriptHelper(driver);
		while (true) {
			try {

				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("ValueMonth") + " "
						+ testData.get("ValueYear") + "')]")));
				WebElement monthAndYear = driver.findElement(By.xpath(
						"//span[contains(text(),'" + testData.get("ValueMonth") + " " + testData.get("ValueYear") + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth().click();
			}
		}
		WebElement ValueDate = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("ValueFullMonth") + " "
				+ testData.get("ValueDate") + ", " + testData.get("ValueYear") + "']/span"));
		clicksAndActionHelper.doubleClick(ValueDate);
		
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_CancellationReasonCode());
		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_CancellationReasonCode().sendKeys(PaymentSettlementCancellationTestDataType.CancellationReasonCode);
		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_CancellationReasonCode().sendKeys(Keys.ENTER);
		

    }
    @And("^User Enter Remarks for payment cancellation$")
    public void user_enter_remarks_for_payment_cancellation() throws Throwable {
    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_CancellationRemark());
		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_CancellationRemark().sendKeys(testData.get("Remarks"));
    }    
    @Then("^Save and submit the payment settlement cancellation record$")
    public void save_and_submit_the_payment_settlement_cancellation_record() throws IOException, ParseException, InterruptedException  {
    	waithelper.waitForElement(driver, 2000,aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_SaveButton());
		aCCOUNTSPAYABLE_ManualPayoutObj.accountPayable_ManualPayout_SaveButton().click();
		Thread.sleep(2000);
		javascripthelper.JavaScriptHelper(driver);
		String str = javascripthelper.executeScript(
				"return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText")
				.toString();
		System.out.println("Message:" + str);
		
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationButton().click();
		
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId());
		String id=aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId().getText();
		jsonWriter.addReferanceData(id);
		System.out.println("Reference ID:" +id);
//    	for (int i = 1; i <= 35; i++) {
//			try {
//		    	waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +jsonWriter.readReferancedata()+ "')]")));	
//				WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" +  jsonWriter.readReferancedata() + "')]"));	
//				waithelper.waitForElement(driver, i, referanceID);
//				referanceID.click();
//		    	System.out.println(referanceID);
//				Assert.assertTrue(referanceID.isDisplayed());
//				break;
//			} catch (NoSuchElementException e) {
//				waithelper.waitForElement(driver,4000,aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationNextButton());
//				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationNextButton().click();
//			}
//		}
    	String before_xpath="//span[contains(text(),'";
    	String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button"; 
    	waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath +testData.get("Reference ID")+after_xpath)));
    	driver.findElement(By.xpath(before_xpath +testData.get("Reference ID") +after_xpath)).click();
    	
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton());
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton().click(); 
    	
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker());
    	javascripthelper.JSEClick(aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker());
    	aCCOUNTSPAYABLE_InvoiceBookingObj.accountPayable_InvoiceBooking_RemarksByMaker().sendKeys(PaymentSettlementCancellationTestDataType.RemarkByMaker);
		
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit().click();
    	
    	Thread.sleep(1000);
    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
    	WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
    	clicksAndActionHelper.moveToElement(recordstatus);
    	
    	String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
    	System.out.println(message);
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
    	String emptystring = "";
		String ar[] = message.split(" ");
		emptystring=ar[ar.length-1];
		String reviewerId=emptystring.replaceAll("[/.]", "");
		System.out.println(reviewerId);
		System.out.println(reviewerId);
		jsonWriter=new JsonDataReaderWriter();
		excelData.updateTestData("KUBS_AR/AP_UAT_005_001_TC_01_02_D1", "Reviewer ID", reviewerId);
		jsonWriter.addData(reviewerId);
    }
    
    @And("^Fill the required fields for payment settlement cancellation of aprroved payout and verify$")
    public void fill_the_required_fields_for_payment_settlement_cancellation_of_aprroved_payout_and_verify() throws InterruptedException, IOException, ParseException  {
		javascripthelper.JavaScriptHelper(driver);
		waithelper.waitForElement(driver, 2000,aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_EntityBranch());
		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_EntityBranch().sendKeys(PaymentSettlementCancellationTestDataType.EntityBranch);
		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_EntityBranch().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 2000,aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_PaymentTxnNumber());
		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_PaymentTxnNumber().sendKeys(PaymentSettlementCancellationTestDataType.PayoutApprovedPaymentTxnNumber);
		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_PaymentTxnNumber().sendKeys(Keys.ENTER);
		
		String noitemfound=aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_ManualPayout_PaymentTxnNumberDropdown().getText();
		System.out.println(noitemfound+ " : The aprroved payout txn number is not available for cancellation of payment settlement.");
//		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_ValueDateCalendar().click();
//		Thread.sleep(2000);
//		javascripthelper.JavaScriptHelper(driver);
//		while (true) {
//			try {
//
//				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + PaymentSettlementCancellationTestDataType.ValueMonth + " "
//						+ PaymentSettlementCancellationTestDataType.ValueYear + "')]")));
//				WebElement monthAndYear = driver.findElement(By.xpath(
//						"//span[contains(text(),'" + PaymentSettlementCancellationTestDataType.ValueMonth + " " + PaymentSettlementCancellationTestDataType.ValueYear + "')]"));
//				break;
//			}
//
//			catch (NoSuchElementException nosuchElement) {
//				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth().click();
//			}
//		}
//		WebElement ValueDate = driver.findElement(By.xpath("//td[@aria-label='" + PaymentSettlementCancellationTestDataType.ValueFullMonth + " "
//				+ PaymentSettlementCancellationTestDataType.ValueDate + ", " + PaymentSettlementCancellationTestDataType.ValueYear + "']/span"));
//		clicksAndActionHelper.doubleClick(ValueDate);
//		
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_CancellationReasonCode());
		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_CancellationReasonCode().sendKeys(PaymentSettlementCancellationTestDataType.CancellationReasonCode);
		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_CancellationReasonCode().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_CancellationRemark());
		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_CancellationRemark().sendKeys(PaymentSettlementCancellationTestDataType.CAncellationRemark);
    }
    @Then("^Click on Report button$")
    public void click_on_repoet_button() throws InterruptedException  {
//	 Thread.sleep(2000);
//	  waithelper.waitForElement(driver, 2000,  arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_ReportButton());
	  waithelper.waitForElementwithFluentwait(driver, arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_ReportButton());
	  arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_ReportButton().click();
    }

    @Then("^Click on Financial Reporting tab$")
    public void click_on_financial_reporting_tab()  {
    	  waithelper.waitForElement(driver, 2000,arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_FinancialReport());
    	arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_FinancialReport().click();
    }
    @Then("^Click on Balance Sheet Report edit button$")
    public void click_on_balance_sheet_report_edit_button()  {
    	  waithelper.waitForElement(driver, 2000,arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_BalanceSheetReport());
	    	arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_BalanceSheetReport().click();
    }
    @And("^User Select branch code for Verify Balance sheet post payment settlement approval$")
    public void user_select_branch_code_for_verify_balance_sheet_post_payment_settlement_approval() throws Throwable {
    	waithelper.waitForElement(driver, 2000,arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_BranchTextbox());
    	arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_BranchTextbox().click();
    	arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_BranchTextbox().sendKeys(testData.get("Branch Code"));
    	arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_BranchTextbox().sendKeys(Keys.ENTER);
    }
    @And("^User Select report type for Verify Balance sheet post payment settlement approval$")
    public void user_select_report_type_for_verify_balance_sheet_post_payment_settlement_approval() throws Throwable {
    	//arAp_BalanceSheetReportTestDataType= jsonReader.getBalanceSheetReportByName("maker");
    	waithelper.waitForElement(driver, 2000,arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_ReportType());
    	arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_ReportType().click();
    	arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_ReportType().sendKeys(testData.get("Report Type"));
    	arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_ReportType().sendKeys(Keys.ENTER);
    	
    }
    @Then("^choose the from date to verify accounting entries post payment settlement approval$")
    public void choose_the_from_date_to_verify_accounting_entries_post_payment_settlement_approval() throws Throwable {
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
    @Then("^choose the to date for verify accounting entries post payment settlement approval$")
    public void choose_the_to_date_for_verify_accounting_entries_post_payment_settlement_approval() throws Throwable {
    	while(true)
        {
		try
		{
		
			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("ToMonth")+" "+testData.get("ToYear")+"')]")));
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
    @Then("^Select date in calendar$")
    public void select_date_in_calendar() throws InterruptedException  {
    	
    	arAp_BalanceSheetReportTestDataType= jsonReader.getBalanceSheetReportByName("maker");
    	
    	
		 waithelper.waitForElement(driver, 2000, arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_CalendarButton());
		 arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_CalendarButton().click();
		
		 
javascripthelper.JavaScriptHelper(driver);
while(true)
{
try
	{
		//span[contains(text(),'Oct 2022')]
//		Thread.sleep(1000);
//		waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//span[contains(text(),'"+arAp_BalanceSheetReportTestDataType.Month+" "+arAp_BalanceSheetReportTestDataType.Year+"')]")));
		waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("FromMonth")+" "+testData.get("FromYear")+"')]")));
		WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("FromMonth")+" "+testData.get("FromYear")+"')]"));
//		Thread.sleep(2000);
		break;
	}
				
catch(NoSuchElementException nosuchElement)
	{
		arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_NextMonth().click();
		
	}
}
			//td[@aria-label='November 1, 2022']/span
WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FromFullMonth")+" "+testData.get("FromDate")+", "+testData.get("FromYear")+"']/span"));
clicksAndActionHelper.doubleClick(FinalDay);
}
    
    @Then("^Click on the View button$")
    public void click_on_the_view_button()  {
    	waithelper.waitForElement(driver, 2000,arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_ViewButton());
    	arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_ViewButton().click();
  }
    @Then("^close the report$")
    public void close_the_report() throws InterruptedException {
    javascripthelper.JavaScriptHelper(driver);

    browserHelper.SwitchToWindow(1);
    Thread.sleep(1500);
	/*
	 * while(true) { try {
	 * javascripthelper.scrollIntoView(driver.findElement(By.xpath(
	 * "//div[contains(text(),'"+arAp_BalanceSheetReportTestDataType.BranchCode+
	 * "')]"))); driver.findElement(By.xpath("//div[contains(text(),'"+
	 * arAp_BalanceSheetReportTestDataType.BranchCode+"')]")).isDisplayed(); break;
	 * } catch(NoSuchElementException e) {
	 * arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_ReportNext().click(); }
	 * catch(StaleElementReferenceException e1) { } }
	 */
    browserHelper.switchToParentWithChildClose();
    
    }
    
    
    //-------KUBS_AR/AP_UAT_010_005_TC_07--------//
@Then("^Click on Reports tab$")
	public void click_on_reports_tab()   {
waithelper.waitForElement(driver, 2000,arAp_BalanceSheetReportObj.arAp_Reports());
arAp_BalanceSheetReportObj.arAp_Reports().click();
	    
}
    

@Then("^Click on Account Receivable Report edit button$")
public void click_on_account_receivable_report_edit_button()  {
waithelper.waitForElement(driver, 2000,arAp_BalanceSheetReportObj.arAp_AccountReceivableReport_AccountReceivableReport());
arAp_BalanceSheetReportObj.arAp_AccountReceivableReport_AccountReceivableReport().click();
    	     
}

@Then("^Fill Vendor employee details for report$")
public void fill_vendor_employee_details_for_report()  {
waithelper.waitForElement(driver, 2000,arAp_BalanceSheetReportObj.arAp_AccountReceivableReport_VendorEmployeeName());
arAp_BalanceSheetReportObj.arAp_AccountReceivableReport_VendorEmployeeName().click();
arAp_BalanceSheetReportObj.arAp_AccountReceivableReport_VendorEmployeeName().sendKeys(arAp_BalanceSheetReportTestDataType.VendorEmployeeName);
arAp_BalanceSheetReportObj.arAp_AccountReceivableReport_VendorEmployeeName().sendKeys(Keys.ENTER);
    	   
}
@Then("^select Receivable Status$")
public void select_receivable_status()  {
waithelper.waitForElement(driver, 2000,arAp_BalanceSheetReportObj.arAp_AccountReceivableReport_ReceivableStatus());
arAp_BalanceSheetReportObj.arAp_AccountReceivableReport_ReceivableStatus().click();
arAp_BalanceSheetReportObj.arAp_AccountReceivableReport_ReceivableStatus().sendKeys(arAp_BalanceSheetReportTestDataType.ReceivableStatus);
arAp_BalanceSheetReportObj.arAp_AccountReceivableReport_ReceivableStatus().sendKeys(Keys.ENTER);
		      
}
@And("^User Select Entity branch for Manual payout to verify cancelled payment transaction$")
public void user_select_entity_branch_for_manual_payout_to_verify_cancelled_payment_transaction() throws Throwable {
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

@And("^User Select BP Name for Manual payout to verify cancelled payment transaction$")
public void user_select_bp_name_for_manual_payout_to_verify_cancelled_payment_transaction() throws Throwable {
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

@And("^User Select the Beneficiary Name for Manual payout to verify cancelled payment transaction$")
public void user_select_the_beneficiary_name_for_manual_payout_to_verify_cancelled_payment_transaction() throws Throwable {
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

@And("^User Select the Currency for Manual payout to verify cancelled payment transaction$")
public void user_select_the_currency_for_manual_payout_to_verify_cancelled_payment_transaction() throws Throwable {
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

@And("^User Select the Payment Bank for Manual Payout to verify cancelled payment transaction$")
public void user_select_the_payment_bank_for_manual_payout_to_verify_cancelled_payment_transaction() throws Throwable {
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

@And("^User select the Bank Account number for Manual Payout to verify cancelled payment transaction$")
public void user_select_the_bank_account_number_for_manual_payout_to_verify_cancelled_payment_transaction() throws Throwable {
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

@And("^User select the Payment mode for Manual Payout to verify cancelled payment transaction$")
public void user_select_the_payment_mode_for_manual_payout_to_verify_cancelled_payment_transaction() throws Throwable {
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

@And("^User select the Reference Number for Manual Payout to verify cancelled payment transaction$")
public void user_select_the_reference_number_for_manual_payout_to_verify_cancelled_payment_transaction() throws Throwable {
	//ReferenceNumber
	waithelper.waitForElement(driver, 2000, accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_ReferenceNumber());
	accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_ReferenceNumber().sendKeys(testData.get("ReferenceNumber"));
}

@And("^User select the Cheque Number for Manual Payout to verify cancelled payment transaction$")
public void user_select_the_cheque_number_for_manual_payout_to_verify_cancelled_payment_transaction() throws Throwable {
	javascripthelper.JavaScriptHelper(driver);
	//ChequeNumber
			waithelper.waitForElement(driver, 2000, accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_ChequeNumber());
			accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_ChequeNumber().sendKeys(testData.get("ChequeNumber"));
			javascripthelper.scrollIntoViewAndClick(accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_Footer());
}

@And("^User Enter remark for Manual Payout to verify cancelled payment transaction$")
public void user_enter_remark_for_manual_payout_to_verify_cancelled_payment_transaction() throws Throwable {
	//Remarks
	waithelper.waitForElement(driver, 2000,accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_Remark());
	accountsPayable_ManualPayoutEmployeeObj.accountPayable_ManualPayout_Remark().sendKeys(testData.get("Remarks"));
}

    

}
