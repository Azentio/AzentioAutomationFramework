package stepdefinitions;

import java.io.IOException;
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
	
//--------  @KUBS_AR/AP_UAT_005_002_TC_01  ------------
    
    @When("^click on eye button of payment settlement cancellation$")
    public void click_on_eye_button_of_payment_settlement_cancellation() throws InterruptedException {
//    	javascripthelper.JavaScriptHelper(driver);
//    	javascripthelper.scrollIntoView(aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_EyeButton());
    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_EyeButton());
    	aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_EyeButton().click();
    }

    @And("^click on add button for payment settlement cancellation$")
    public void click_on_add_button_for_payment_settlement_cancellation() {
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_AddButton());
    	aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_AddButton().click();
    }

    @And("^Fill the required fields for payment settlement cancellation$")
    public void fill_the_required_fields_for_payment_settlement_cancellation() throws InterruptedException, IOException, ParseException  {
		javascripthelper.JavaScriptHelper(driver);
		waithelper.waitForElement(driver, 2000,aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_EntityBranch());
		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_EntityBranch().sendKeys(PaymentSettlementCancellationTestDataType.EntityBranch);
		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_EntityBranch().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 2000,aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_PaymentTxnNumber());
		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_PaymentTxnNumber().sendKeys(PaymentSettlementCancellationTestDataType.PaymentTxnNumber);
		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_PaymentTxnNumber().sendKeys(Keys.ENTER);
		
		
//		javascripthelper.scrollIntoViewAndClick(aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_Footer());
//		
//		waithelper.waitForElement(driver, 2000,aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_Remark());
//		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_Remark().sendKeys(PaymentSettlementCancellationTestDataType.Remarks);
		
		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_ValueDateCalendar().click();
		Thread.sleep(2000);
		javascripthelper.JavaScriptHelper(driver);
		while (true) {
			try {

				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + PaymentSettlementCancellationTestDataType.ValueMonth + " "
						+ PaymentSettlementCancellationTestDataType.ValueYear + "')]")));
				WebElement monthAndYear = driver.findElement(By.xpath(
						"//span[contains(text(),'" + PaymentSettlementCancellationTestDataType.ValueMonth + " " + PaymentSettlementCancellationTestDataType.ValueYear + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ClickOnNextMonth().click();
			}
		}
		WebElement ValueDate = driver.findElement(By.xpath("//td[@aria-label='" + PaymentSettlementCancellationTestDataType.ValueFullMonth + " "
				+ PaymentSettlementCancellationTestDataType.ValueDate + ", " + PaymentSettlementCancellationTestDataType.ValueYear + "']/span"));
		clicksAndActionHelper.doubleClick(ValueDate);
		
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_CancellationReasonCode());
		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_CancellationReasonCode().sendKeys(PaymentSettlementCancellationTestDataType.CancellationReasonCode);
		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_CancellationReasonCode().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_CancellationRemark());
		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_CancellationRemark().sendKeys(PaymentSettlementCancellationTestDataType.CAncellationRemark);
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
    	for (int i = 1; i <= 35; i++) {
			try {
		    	waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +jsonWriter.readReferancedata()+ "')]")));	
				WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" +  jsonWriter.readReferancedata() + "')]"));	
				waithelper.waitForElement(driver, i, referanceID);
				referanceID.click();
		    	System.out.println(referanceID);
//				Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElement(driver,4000,aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationNextButton());
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_NotificationNextButton().click();
			}
		}
    	String before_xpath="//span[contains(text(),'";
    	String after_xpath="')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button"; 
    	waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath +jsonWriter.readReferancedata()+after_xpath)));
    	driver.findElement(By.xpath(before_xpath +jsonWriter.readReferancedata() +after_xpath)).click();
    	
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
//		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_CancellationReasonCode());
//		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_CancellationReasonCode().sendKeys(PaymentSettlementCancellationTestDataType.CancellationReasonCode);
//		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_CancellationReasonCode().sendKeys(Keys.ENTER);
//		
//		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_CancellationRemark());
//		aCCOUNTSPAYABLE_PaymentSettlementCancellationObj.accountPayable_PaymentSettlementCancellation_CancellationRemark().sendKeys(PaymentSettlementCancellationTestDataType.CAncellationRemark);
    }
}
