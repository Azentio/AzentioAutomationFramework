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
import pageobjects.AccountsReceivable_UpdateChequeStatusObj;
import pageobjects.ENQUIRY_FinancialTransactionObj;
import pageobjects.GeneralLedger2_JournalVoucherObj;
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.AccountsReceivable_UpdateChequeStatusTestDataType;
import testDataType.GeneralLedger2_JournalVoucherTestDataType;

public class GeneralLedger2_JournalVoucher_Reports {
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	ConfigFileReader config = new ConfigFileReader();
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver);
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(driver);
	ACCOUNTSPAYABLE_InvoiceBookingObj aCCOUNTSPAYABLE_InvoiceBookingObj = new ACCOUNTSPAYABLE_InvoiceBookingObj(driver);
	AccountsReceivable_UpdateChequeStatusObj accountsReceivable_UpdateChequeStatusObj = new AccountsReceivable_UpdateChequeStatusObj(driver);
	ENQUIRY_FinancialTransactionObj eNQUIRY_FinancialTransactionObj = new ENQUIRY_FinancialTransactionObj(driver);
	GeneralLedger2_JournalVoucherObj generalLedger2_JournalVoucherObj = new GeneralLedger2_JournalVoucherObj(driver);
	AccountsReceivable_ReceiptsReversalsObj accountsReceivable_ReceiptsReversalsObj = new AccountsReceivable_ReceiptsReversalsObj(driver);
	AccountsReceivable_UpdateChequeStatusTestDataType UpdateChequeStatusTestDataType=jsonReader.getUpdateChequeStatusdata("Maker");
	GeneralLedger2_JournalVoucherTestDataType JournalVoucherTestDataType=jsonReader.getJournalVoucherdata("Maker");
	JavascriptHelper javascripthelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter reader;
	BrowserHelper browserHelper;
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	
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
		waithelper.waitForElement(driver, 3000, generalLedger2_JournalVoucherObj.GeneralLedger2_JournalVoucher_RecordVoucherNumberEyeButton());
		generalLedger2_JournalVoucherObj.GeneralLedger2_JournalVoucher_RecordVoucherNumberEyeButton().click();
		Thread.sleep(1000);
		String voucherNumber=javascripthelper.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[3].value").toString();
		jsonWriter=new JsonDataReaderWriter();
		jsonWriter.addData(voucherNumber);
	}
	
	@Then("^click on the record to get the GL number$")
    public void click_on_the_record_to_get_the_gl_number() throws IOException, InterruptedException {
		javascripthelper.JavaScriptHelper(driver);
		waithelper.waitForElement(driver, 3000, generalLedger2_JournalVoucherObj.GeneralLedger2_JournalVoucher_RecordVoucherNumberEyeButton());
		generalLedger2_JournalVoucherObj.GeneralLedger2_JournalVoucher_RecordVoucherNumberEyeButton().click();
//		String glcode=generalLedger2_JournalVoucherObj.GeneralLedger2_JournalVoucher_GLCode().getText();
		Thread.sleep(2000);
		String glcode=javascripthelper.executeScript("return document.getElementsByClassName('aux-input')[4].value").toString();
		System.out.println(glcode);
		jsonWriter=new JsonDataReaderWriter();
		jsonWriter.addData(glcode);
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
	
	@And("^fill the reference number field of financial transaction$")
	public void fill_the_reference_number_field_of_financial_transaction() throws IOException, ParseException  {
		waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_BranchCode());
		eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_BranchCode().sendKeys(JournalVoucherTestDataType.BranchCode);
		eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_BranchCode().sendKeys(Keys.ENTER);
		
		waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_TransactionRefNumber());
		eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_TransactionRefNumber().sendKeys(jsonWriter.readdata());
		eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_TransactionRefNumber().sendKeys(Keys.ENTER);
		
	}

	@And("^fill the GL number field of financial transaction$")
	public void fill_the_gl_number_field_of_financial_transaction() throws IOException, ParseException {
		waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_BranchCode());
		eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_BranchCode().sendKeys(JournalVoucherTestDataType.BranchCode);
		eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_BranchCode().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_GlCode());
		eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_GlCode().sendKeys(jsonWriter.readdata());
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
		eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ViewButton().click();
	}

}
