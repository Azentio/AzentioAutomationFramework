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
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.ACCOUNTSPAYABLE_InvoiceBookingTestDataType;
import testDataType.ACCOUNTSPAYABLE_VendorContractsTestDataType;
import testDataType.AccountsReceivable_ReceiptsReversalsTestDataType;
import testDataType.AccountsReceivable_UpdateChequeStatusTestDataType;

public class AccountsReceivable_UpdateChequeStatus {
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	ConfigFileReader config = new ConfigFileReader();
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver);
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(driver);
	ACCOUNTSPAYABLE_InvoiceBookingObj aCCOUNTSPAYABLE_InvoiceBookingObj = new ACCOUNTSPAYABLE_InvoiceBookingObj(driver);
	AccountsReceivable_UpdateChequeStatusObj accountsReceivable_UpdateChequeStatusObj = new AccountsReceivable_UpdateChequeStatusObj(driver);
	ENQUIRY_FinancialTransactionObj eNQUIRY_FinancialTransactionObj = new ENQUIRY_FinancialTransactionObj(driver);
	AccountsReceivable_ReceiptsReversalsObj accountsReceivable_ReceiptsReversalsObj = new AccountsReceivable_ReceiptsReversalsObj(driver);
	AccountsReceivable_UpdateChequeStatusTestDataType UpdateChequeStatusTestDataType=jsonReader.getUpdateChequeStatusdata("Maker");
	JavascriptHelper javascripthelper = new JavascriptHelper();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter reader;
	BrowserHelper browserHelper;
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	
	@When("^click on eye button of update cheque status$")
    public void click_on_eye_button_of_update_cheque_status()  {
		javascripthelper.JavaScriptHelper(driver);
		javascripthelper.scrollIntoView(accountsReceivable_UpdateChequeStatusObj.accountsReceivable_UpdateChequeStatus_EyeButton());
		waithelper.waitForElement(driver, 3000, accountsReceivable_UpdateChequeStatusObj.accountsReceivable_UpdateChequeStatus_EyeButton());
		accountsReceivable_UpdateChequeStatusObj.accountsReceivable_UpdateChequeStatus_EyeButton().click();
    }
	
	@Then("^get slip number by using cheque number$")
	public void get_slip_number_by_using_cheque_number() throws IOException {
		waithelper.waitForElement(driver, 3000, accountsReceivable_UpdateChequeStatusObj.accountsReceivable_UpdateChequeStatus_Search());
		accountsReceivable_UpdateChequeStatusObj.accountsReceivable_UpdateChequeStatus_Search().click();
		
		waithelper.waitForElement(driver, 3000, accountsReceivable_UpdateChequeStatusObj.accountsReceivable_UpdateChequeStatus_ChequeNumber());
		accountsReceivable_UpdateChequeStatusObj.accountsReceivable_UpdateChequeStatus_ChequeNumber().sendKeys(UpdateChequeStatusTestDataType.ChequeNumber);
		
		waithelper.waitForElement(driver, 3000, accountsReceivable_UpdateChequeStatusObj.accountsReceivable_UpdateChequeStatus_SlipNumber());
		String slipnumber=accountsReceivable_UpdateChequeStatusObj.accountsReceivable_UpdateChequeStatus_SlipNumber().getText();
		jsonWriter=new JsonDataReaderWriter();
		jsonWriter.addData(slipnumber);
	}

    @Then("^click on report icon1$")
    public void click_on_report_icon1() {
    	javascripthelper.JavaScriptHelper(driver);
    	javascripthelper.scrollIntoViewAndClick(eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ReportIcon());
    }

    @Then("^click on enquiry menu$")
    public void click_on_enquiry_menu() {
        
    	waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_EnquiryMenu());
    	eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_EnquiryMenu().click();
    }

    @Then("^click on temp grid button of financial transaction$")
    public void click_on_temp_grid_button_of_financial_transaction()  {
    	waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_FinancialTransactionField());
    	eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_FinancialTransactionField().click();
    }
    
    @And("^fill the required fields of financial transaction$")
    public void fill_the_required_fields_of_financial_transaction(){
    	waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_BranchCode());
    	eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_BranchCode().sendKeys(UpdateChequeStatusTestDataType.BranchCode);
    	eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_BranchCode().sendKeys(Keys.ENTER);
    	
//    	waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_GlCode());
//    	eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_GlCode().sendKeys(UpdateChequeStatusTestDataType.GLCode);
//    	eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_GlCode().sendKeys(Keys.ENTER);
    	
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

    @Then("^click on view button to view the reports and verify$")
    public void click_on_view_button_to_view_the_reports_and_verify() throws InterruptedException, IOException, ParseException  {
    	javascripthelper.JavaScriptHelper(driver);
    	waithelper.waitForElement(driver, 3000, eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ViewButton());
    	eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_ViewButton().click();
    	Thread.sleep(2000);
    	javascripthelper.scrollIntoView(eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextPage());
    	String beforexpath="//span[contains(text(),' Debit ')]/../../../datatable-body-cell[1]/div/span[contains(text(),'";
    	String afterxpath="')]";
    	
    	//span[contains(text(),' Debit ')]/../../../datatable-body-cell[1]/div/span[contains(text(),'  ')]
//    	while(!driver.findElement(By.xpath(beforexpath+UpdateChequeStatusTestDataType.SlipNumber+afterxpath)).getText().equals(jsonWriter.readdata()))
    	while(true)
    	{
    		try {
    			driver.findElement(By.xpath(beforexpath+jsonWriter.readdata()+afterxpath));
    			System.out.println("Cleared cheque record is available in list");
    			break;
    		}
    		catch(NoSuchElementException nosuchElement){
    			try {
    				eNQUIRY_FinancialTransactionObj.ENQUIRY_FinancialTransaction_NextPage().click();
    			}
    			catch(NoSuchElementException nosuchElement1) {
    				System.out.println("Cleared cheque record is not available in list");
    				break;
    			}
    		}
    	}
    	
    }

}









