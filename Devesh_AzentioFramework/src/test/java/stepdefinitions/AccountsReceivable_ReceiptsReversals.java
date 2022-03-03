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
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
import pageobjects.AccountsReceivable_ReceiptsReversalsObj;
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.ACCOUNTSPAYABLE_InvoiceBookingTestDataType;
import testDataType.ACCOUNTSPAYABLE_VendorContractsTestDataType;
import testDataType.AccountsReceivable_ReceiptsReversalsTestDataType;

public class AccountsReceivable_ReceiptsReversals {
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	ConfigFileReader config = new ConfigFileReader();
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver);
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(driver);
	ACCOUNTSPAYABLE_InvoiceBookingObj aCCOUNTSPAYABLE_InvoiceBookingObj = new ACCOUNTSPAYABLE_InvoiceBookingObj(driver);
	AccountsReceivable_ReceiptsReversalsObj accountsReceivable_ReceiptsReversalsObj = new AccountsReceivable_ReceiptsReversalsObj(driver);
	AccountsReceivable_ReceiptsReversalsTestDataType ReceiptsReversalsTestDataType=jsonReader.getReceiptsReversalsdata("Maker");
	JavascriptHelper javascripthelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter reader;
	BrowserHelper browserHelper;
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	
	@And("^user should navigate to accounts receivable menu$")
	public void user_should_navigate_to_accounts_receivable_menu() {
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_DirectionButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_DirectionButton().click();
		waithelper.waitForElement(driver, 3000, accountsReceivable_ReceiptsReversalsObj.accountsReceivableMenu());
		accountsReceivable_ReceiptsReversalsObj.accountsReceivableMenu().click();
	}
	
	@When("^click on eye button of receipts$")
	public void click_on_eye_button_of_receipts() {
		waithelper.waitForElement(driver, 3000, accountsReceivable_ReceiptsReversalsObj.accountsReceivable_Receipts_EyeButton());
		accountsReceivable_ReceiptsReversalsObj.accountsReceivable_Receipts_EyeButton().click();

	}
	
	@Then("^get the txn number$")
	public void get_the_txn_number() throws IOException {
		waithelper.waitForElement(driver, 3000, accountsReceivable_ReceiptsReversalsObj.accountsReceivable_Receipts_Search());
		accountsReceivable_ReceiptsReversalsObj.accountsReceivable_Receipts_Search().click();
		
		waithelper.waitForElement(driver, 3000, accountsReceivable_ReceiptsReversalsObj.accountsReceivable_Receipts_ReceiptType());
		accountsReceivable_ReceiptsReversalsObj.accountsReceivable_Receipts_ReceiptType().sendKeys(ReceiptsReversalsTestDataType.ReceiptType);
		
		waithelper.waitForElement(driver, 3000, accountsReceivable_ReceiptsReversalsObj.accountsReceivable_Receipts_ReceiptNumber());
		accountsReceivable_ReceiptsReversalsObj.accountsReceivable_Receipts_ReceiptNumber().sendKeys(ReceiptsReversalsTestDataType.ReceiptNumber);
		
		waithelper.waitForElement(driver, 3000, accountsReceivable_ReceiptsReversalsObj.accountsReceivable_Receipts_TxnNumber());
		String txnNumber=accountsReceivable_ReceiptsReversalsObj.accountsReceivable_Receipts_TxnNumber().getText();
		System.out.println(txnNumber);
		jsonWriter=new JsonDataReaderWriter();
		jsonWriter.addData(txnNumber);
	}

	@When("^click on eye button of receipts reversals$")
	public void click_on_eye_button_of_receipts_reversals() throws InterruptedException {
		javascripthelper.JavaScriptHelper(driver);
		waithelper.waitForElement(driver, 3000, accountsReceivable_ReceiptsReversalsObj.accountsReceivable_ReceiptsReversals_EyeButton());
		javascripthelper.scrollIntoViewAndClick(accountsReceivable_ReceiptsReversalsObj.accountsReceivable_ReceiptsReversals_EyeButton());

	}

	@And("^click on add button for cancel receipt$")
	public void click_on_add_button_for_cancel_receipt() {
		waithelper.waitForElement(driver, 3000, accountsReceivable_ReceiptsReversalsObj.accountsReceivable_ReceiptsReversals_AddButton());
		accountsReceivable_ReceiptsReversalsObj.accountsReceivable_ReceiptsReversals_AddButton().click();
	}

	@And("^Fill the required fields to cancel the receipts through online mode$")
	public void fill_the_required_fields_to_cancel_the_receipts_through_online_mode() throws IOException, ParseException {
		reader = new JsonDataReaderWriter();
		accountsReceivable_ReceiptsReversalsObj.accountsReceivable_ReceiptsReversals_ReceiptReferenceNumber().click();
		waithelper.waitForElement(driver, 3000, accountsReceivable_ReceiptsReversalsObj.accountsReceivable_ReceiptsReversals_ReceiptReferenceNumber());
		accountsReceivable_ReceiptsReversalsObj.accountsReceivable_ReceiptsReversals_ReceiptReferenceNumber().sendKeys(reader.readdata());
		accountsReceivable_ReceiptsReversalsObj.accountsReceivable_ReceiptsReversals_ReceiptReferenceNumber().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, accountsReceivable_ReceiptsReversalsObj.accountsReceivable_ReceiptsReversals_CancellationRemarks());
		accountsReceivable_ReceiptsReversalsObj.accountsReceivable_ReceiptsReversals_CancellationRemarks().sendKeys(ReceiptsReversalsTestDataType.CancellationRemarks);
	
	}
	
	@Then("^save the record to cancel the receipts$")
	public void save_the_record_to_cancel_the_receipts() {
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SaveButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SaveButton().click();
	}
	
	@And("^select the record actions button$")
	public void select_the_record_actions_button() {
		waithelper.waitForElement(driver, 3000, accountsReceivable_ReceiptsReversalsObj.accountsReceivable_ReceiptsReversals_ActionButton());
		accountsReceivable_ReceiptsReversalsObj.accountsReceivable_ReceiptsReversals_ActionButton().click();
	}

	@Then("^click on initiate the record$")
	public void click_on_initiate_the_record() {
		waithelper.waitForElement(driver, 3000, accountsReceivable_ReceiptsReversalsObj.accountsReceivable_ReceiptsReversals_InitiateButton());
		accountsReceivable_ReceiptsReversalsObj.accountsReceivable_ReceiptsReversals_InitiateButton().click();
	}
	
	@And("^record status$")
	public void record_status() {
		waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
    	WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
    	clicksAndActionHelper.moveToElement(recordstatus);
    	
    	String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
    	System.out.println(message);
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
	}
	
	@And("^select the record pencil icon$")
	public void select_the_record_pencil_icon() throws IOException, ParseException {
		waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId());
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
	}

	@Then("^submit the record from maker to cancel the receipts$")
	public void submit_the_record_from_maker_to_cancel_the_receipts() throws InterruptedException, IOException {
		
    	
    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton());
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton().click(); 
    	
    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());
    	javascripthelper.JSEClick(aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField().sendKeys(ReceiptsReversalsTestDataType.RemarkByMaker);
		
    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit().click();
    	
    	Thread.sleep(1000);
    	waithelper.waitForElement(driver, 2000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
    	WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
    	clicksAndActionHelper.moveToElement(recordstatus);
    	
    	String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
    	System.out.println(message);
    	aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
//    	String t = "";
//		String ar[] = message.split(" ");
//		for (int i = ar.length - 1; i >= 0; i--) {
//			t = ar[ar.length - 1];
//		}
//		String reviewerId = "";
//		for (int i = 0; i < t.length() - 1; i++) {
//			if (t.charAt(i) == '.') {
//			} else {
//				reviewerId = reviewerId + t.charAt(i);
//			}
//		}
    	String t = "";
		String ar[] = message.split(" ");
		t=ar[ar.length-1];
		String reviewerId=t.replaceAll("[/.]", "");
		System.out.println(reviewerId);
		jsonWriter=new JsonDataReaderWriter();
		jsonWriter.addData(reviewerId);
	}

}
