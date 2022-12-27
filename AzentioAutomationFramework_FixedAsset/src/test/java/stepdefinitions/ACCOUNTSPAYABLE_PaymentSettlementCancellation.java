package stepdefinitions;

import java.io.IOException;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ACCOUNTSPAYABLE_InvoiceBookingObj;
import pageobjects.ACCOUNTSPAYABLE_ManualPayoutObj;
import pageobjects.ACCOUNTSPAYABLE_PaymentSettlementCancellationObj;
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;
import testDataType.ACCOUNTSPAYABLE_PaymentSettlementCancellationTestDataType;
import testDataType.ACCOUNTSPAYABLE_VendorContractsTestDataType;

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
	JavascriptHelper javascripthelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter reader;
	BrowserHelper browserHelper;
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	ACCOUNTSPAYABLE_VendorContractsTestDataType aCCOUNTSPAYABLE_VendorContractsTestDataType;
	String excelPath = System.getProperty("user.dir")+"\\Test-data\\KUBSTestData.xlsx";
	ExcelData excelData = new ExcelData(excelPath,"ARAP_ManualPayout","Data Set ID");
	private Map<String, String> testData;
	
//--------  @KUBS_AR/AP_UAT_005_002_TC_01  ------------
    
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

    @And("^click on add button for payment settlement cancellation$")
    public void click_on_add_button_for_payment_settlement_cancellation() {
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_AddButton());
    	aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_AddButton().click();
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
}
