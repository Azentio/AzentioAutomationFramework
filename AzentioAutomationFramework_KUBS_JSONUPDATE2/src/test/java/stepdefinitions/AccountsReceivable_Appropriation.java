package stepdefinitions;

import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
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
import pageobjects.ACCOUNTSRECEIVABLE_AppropriationObj;
import pageobjects.AccountsReceivable_ReceiptsReversalsObj;
import pageobjects.ENQUIRY_FinancialTransactionObj;
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.AccountsReceivable_AppropriationTestDataType;
import testDataType.AccountsReceivable_UpdateChequeStatusTestDataType;

public class AccountsReceivable_Appropriation {
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	ConfigFileReader config = new ConfigFileReader();
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver);
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(driver);
	ACCOUNTSPAYABLE_InvoiceBookingObj aCCOUNTSPAYABLE_InvoiceBookingObj = new ACCOUNTSPAYABLE_InvoiceBookingObj(driver);
	ACCOUNTSRECEIVABLE_AppropriationObj accountsReceivable_AppropriationObj = new ACCOUNTSRECEIVABLE_AppropriationObj(driver);
	ENQUIRY_FinancialTransactionObj eNQUIRY_FinancialTransactionObj = new ENQUIRY_FinancialTransactionObj(driver);
	AccountsReceivable_ReceiptsReversalsObj accountsReceivable_ReceiptsReversalsObj = new AccountsReceivable_ReceiptsReversalsObj(driver);
	AccountsReceivable_UpdateChequeStatusTestDataType UpdateChequeStatusTestDataType=jsonReader.getUpdateChequeStatusdata("Maker");
	AccountsReceivable_AppropriationTestDataType AppropriationTestDataType=jsonReader.getAppropriationdata("Maker");
	JavascriptHelper javascripthelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter reader;
	BrowserHelper browserHelper;
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
//	HashMap hashMap= new HashMap();
	
	@When("^click on eye button of appropriation$")
    public void click_on_eye_button_of_appropriation() throws InterruptedException  {
		javascripthelper.JavaScriptHelper(driver);
		Thread.sleep(2000);
		javascripthelper.scrollIntoView(accountsReceivable_AppropriationObj.accountsReceivable_Appropriation_EyeButton());
//		waithelper.waitForElement(driver, 3000, accountsReceivable_AppropriationObj.accountsReceivable_Appropriation_EyeButton());
		accountsReceivable_AppropriationObj.accountsReceivable_Appropriation_EyeButton().click();
    }
	
//	@When("^click on search button$")
//	public void click_on_search_button()  {
//		
//		waithelper.waitForElement(driver, 3000, accountsReceivable_AppropriationObj.accountsReceivable_Appropriation_Search());
//		accountsReceivable_AppropriationObj.accountsReceivable_Appropriation_Search().click();
//	}
	
	@Then("^get trx no for appropriating receipts against debit note$")
	public void get_trx_no_for_appropriating_receipts_against_debit_note() throws IOException {
		
		waithelper.waitForElement(driver, 3000, accountsReceivable_AppropriationObj.accountsReceivable_Appropriation_ReceiptRef());
		accountsReceivable_AppropriationObj.accountsReceivable_Appropriation_ReceiptRef().sendKeys(AppropriationTestDataType.ReceiptRefAgainstDebitNote);
		
		waithelper.waitForElement(driver, 3000, accountsReceivable_AppropriationObj.accountsReceivable_Appropriation_TrxNumber());
		String debitTrxNo=accountsReceivable_AppropriationObj.accountsReceivable_Appropriation_TrxNumber().getText();
		jsonWriter=new JsonDataReaderWriter();
		jsonWriter.addData(debitTrxNo);
		
	}
	
	@Then("^get trx no for appropriating receipts against advance po$")
	public void get_trx_no_for_appropriating_receipts_against_advance_po() throws IOException {
		
		waithelper.waitForElement(driver, 3000, accountsReceivable_AppropriationObj.accountsReceivable_Appropriation_ReceiptRef());
		accountsReceivable_AppropriationObj.accountsReceivable_Appropriation_ReceiptRef().sendKeys(AppropriationTestDataType.ReceiptRefAgainstAdvancePO);
		
		waithelper.waitForElement(driver, 3000, accountsReceivable_AppropriationObj.accountsReceivable_Appropriation_TrxNumber());
		String advancePOTrxNo=accountsReceivable_AppropriationObj.accountsReceivable_Appropriation_TrxNumber().getText();
		jsonWriter=new JsonDataReaderWriter();
		jsonWriter.addData(advancePOTrxNo);
	}
	
	@Then("^get trx no for appropriating receipts against advance employee$")
	public void get_trx_no_for_appropriating_receipts_against_advance_employee() throws IOException {
		
		waithelper.waitForElement(driver, 3000, accountsReceivable_AppropriationObj.accountsReceivable_Appropriation_ReceiptRef());
		accountsReceivable_AppropriationObj.accountsReceivable_Appropriation_ReceiptRef().sendKeys(AppropriationTestDataType.ReceiptRefAgainstAdvanceEMP);
		
		waithelper.waitForElement(driver, 3000, accountsReceivable_AppropriationObj.accountsReceivable_Appropriation_TrxNumber());
		String advanceEMPTrxNo=accountsReceivable_AppropriationObj.accountsReceivable_Appropriation_TrxNumber().getText();
		jsonWriter=new JsonDataReaderWriter();
		jsonWriter.addData(advanceEMPTrxNo);
	}

    @Then("^click on view button to view the reports$")
    public void click_on_view_button_to_view_the_reports() throws InterruptedException, IOException, ParseException  {
    	javascripthelper.JavaScriptHelper(driver);
    	waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ViewButton());
    	eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ViewButton().click();
    	
    }
    
    @And("^fill the required fields for appropriating receipt against debit note$")
    public void fill_the_required_fields_for_appropriating_receipt_against_debit_note() throws IOException, ParseException {
    	waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_BranchCode());
    	eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_BranchCode().sendKeys(UpdateChequeStatusTestDataType.BranchCode);
    	eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_BranchCode().sendKeys(Keys.ENTER);
    	
//    	waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_FromDate());
//    	eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_FromDate().click();
//    	
//    	
//    	
//    	waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ToDate());
//    	eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ToDate().click();
    	
    	waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_TransactionRefNumber());
    	eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_TransactionRefNumber().sendKeys(jsonWriter.readdata());
    	eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_TransactionRefNumber().sendKeys(Keys.ENTER);
    }

    @And("^Verify for appropriating receipt against debit note$")
    public void verify_for_appropriating_receipt_against_debit_note() throws IOException, ParseException, InterruptedException {
    	Thread.sleep(2000);
//    	javascripthelper.scrollIntoView(eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextPage());
    	String beforexpath="//span[contains(text(),' Credit ')]/../../../datatable-body-cell[1]/div/span[contains(text(),'";
    	String afterxpath="')]";
    	while(true)
    	{
    		
    		try {
    			driver.findElement(By.xpath(beforexpath+jsonWriter.readdata()+afterxpath));
    			break;
    		}
    		catch(NoSuchElementException nosuchElement){
//    			eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextPage().click();
    			System.out.println("Appropriating receipt against debit note record is not available in list");
    			System.exit(0);
    		}
    	}
    	System.out.println("Appropriating receipt against debit note record is available in list");
    }

    @And("^fill the required fields for appropriating receipt against Advance PO$")
    public void fill_the_required_fields_for_appropriating_receipt_against_advance_po() throws IOException, ParseException {
    	waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_BranchCode());
    	eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_BranchCode().sendKeys(UpdateChequeStatusTestDataType.BranchCode);
    	eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_BranchCode().sendKeys(Keys.ENTER);
    	
//    	waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_FromDate());
//    	eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_FromDate().click();
//    	
//    	
//    	
//    	waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ToDate());
//    	eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ToDate().click();
    	
    	waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_TransactionRefNumber());
    	eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_TransactionRefNumber().sendKeys(jsonWriter.readdata());
    	eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_TransactionRefNumber().sendKeys(Keys.ENTER);
    }

    @And("^Verify for appropriating receipt against Advance PO$")
    public void verify_for_appropriating_receipt_against_advance_po() throws IOException, ParseException{
    	String beforexpath="//span[contains(text(),' Credit ')]/../../../datatable-body-cell[1]/div/span[contains(text(),'";
    	String afterxpath="')]";
    	while(true)
    	{
    		
    		try {
    			driver.findElement(By.xpath(beforexpath+jsonWriter.readdata()+afterxpath));
    			break;
    		}
    		catch(NoSuchElementException nosuchElement){
//    			eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextPage().click();
    			System.out.println("Appropriating receipt against debit note record is not available in list");
    			System.exit(0);
    		}
    	}
    	System.out.println("Appropriating receipt against Advance PO record is available in list");
    }

    @And("^fill the required fields for appropriating receipt against Advance to Employee$")
    public void fill_the_required_fields_for_appropriating_receipt_against_advance_to_employee() throws IOException, ParseException  {
    	waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_BranchCode());
    	eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_BranchCode().sendKeys(UpdateChequeStatusTestDataType.BranchCode);
    	eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_BranchCode().sendKeys(Keys.ENTER);
    	
//    	waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_FromDate());
//    	eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_FromDate().click();
//    	
//    	
//    	
//    	waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ToDate());
//    	eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ToDate().click();
    	
    	waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_TransactionRefNumber());
    	eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_TransactionRefNumber().sendKeys(jsonWriter.readdata());
    	eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_TransactionRefNumber().sendKeys(Keys.ENTER);
    }

    @And("^Verify for appropriating receipt against Advance to Employee$")
    public void verify_for_appropriating_receipt_against_advance_to_employee() throws IOException, ParseException  {
    	String beforexpath="//span[contains(text(),' Credit ')]/../../../datatable-body-cell[1]/div/span[contains(text(),'";
    	String afterxpath="')]";
    	while(true)
    	{
    		
    		try {
    			driver.findElement(By.xpath(beforexpath+jsonWriter.readdata()+afterxpath));
    			break;
    		}
    		catch(NoSuchElementException nosuchElement){
//    			eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextPage().click();
    			System.out.println("Appropriating receipt against debit note record is not available in list");
    			System.exit(0);
    		}
    	}
    	System.out.println("Appropriating receipt against Employee record is available in list");
    }
}









