package stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.ACCOUNTSPAYABLE_InvoiceBookingObj;
import pageobjects.ARAP_GRNCreationPageObject;
import pageobjects.REPORT_FinancialReportingObj;
import resources.BaseClass;
import testDataType.ACCOUNTSPAYABLE_ContractReportTestData;

public class FINANCIALREPORT_BalanceSheet extends BaseClass{
	WebDriver driver = BaseClass.driver;
	ACCOUNTSPAYABLE_InvoiceBookingObj invoiceBookingObj=new ACCOUNTSPAYABLE_InvoiceBookingObj(driver);
	REPORT_FinancialReportingObj financialReportObj=new REPORT_FinancialReportingObj(driver);
	Map<String,String> testData=new HashMap<>();
	BrowserHelper browserHelper=new BrowserHelper(driver);
	JavascriptHelper javascriptHelper=new JavascriptHelper();
	ARAP_GRNCreationPageObject grnObj =new ARAP_GRNCreationPageObject(driver);
	JsonConfig jsonConfig = new JsonConfig();
	ClicksAndActionsHelper clickAndActionHelper= new ClicksAndActionsHelper(driver);
	ACCOUNTSPAYABLE_ContractReportTestData reportTestData= jsonConfig.getAccountsPayableContractReportTestDataByName("Maker");
	
	@And("^get the transcationDate$")
    public void get_the_transcationdate() throws Throwable {
		
		String transactionDate=invoiceBookingObj.invoiceBillBooking_TransactionDate.getText();
		testData.put("transactionDate", transactionDate);
		System.out.println(testData.get("transactionDate"));
       
    }
	@And("^click on financial reporting main menu$")
    public void click_on_financial_reporting_main_menu() throws Throwable {
		financialReportObj.financialTransactionMainMenu().click();
    }

    @And("^click on temp view near by balance sheet sub menu$")
    public void click_on_temp_view_near_by_balance_sheet_sub_menu() throws Throwable {
    	
    	financialReportObj.financialReportingBalanceSheet().click();
    }
    @And("^select branch in balance sheet$")
    public void select_branch_in_balance_sheet() throws Throwable {
    	financialReportObj.financialReportingBalanceSheetBranchName().click();
    	financialReportObj.financialReportingBalanceSheetBranchName().sendKeys(reportTestData.balancesheetBranchName);
    	financialReportObj.financialReportingBalanceSheetBranchName().sendKeys(Keys.ENTER);
    }
    @And("^enter the transaction date$")
    public void enter_the_transaction_date() throws Throwable {
    	financialReportObj.financialReportingBalanceSheetInputCalendar().click();
    	//Thread.sleep(2000);
    	financialReportObj.financialReprtingYearMonth().click();
    	String fullDate=testData.get("transactionDate");
    	String[] transDate=fullDate.split("-");
    	String splitDay = transDate[0];
    	testData.put("splitDay", splitDay);
    	if (Integer.parseInt(splitDay)<9) {
    		String day = splitDay.substring(1, 2);
    		testData.put("day", day);
    
		}
    	else
    	{
    		String day = splitDay.substring(0, 2);		
    		testData.put("day", day);
    	}
    	
    	System.out.println(transDate[1]);
    	System.out.println(transDate[2]);
    	//Thread.sleep(2000);
    	while(true)
    	{
    		
    	try
    	{
    	driver.findElement(By.xpath("//tr//td//span[contains(text(),'"+transDate[2]+"')]")).click();
    	break;
    	}
    	catch(ElementClickInterceptedException e)
    	{
    		
    	}
    	}
    	//driver.findElement(By.xpath("//tr//td//span[contains(text(),'"+transDate[1]+"')]")).click();
    	clickAndActionHelper.doubleClick(driver.findElement(By.xpath("//tr//td//span[contains(text(),'"+transDate[1]+"')]")));
    	//driver.findElement(By.xpath("//tr//td//span[contains(text(),'"+testData.get("day")+"')]")).click();
    	clickAndActionHelper.doubleClick(driver.findElement(By.xpath("//tr//td//span[contains(text(),'"+testData.get("day")+"')]")));
    }
    @Then("^Verify Balance sheet post Bill is cancelled$")
    public void verify_balance_sheet_post_bill_is_cancelled() throws Throwable {
    	browserHelper.SwitchToWindow(1);
    	javascriptHelper.JavaScriptHelper(driver);
    	Thread.sleep(2000);
    	javascriptHelper.scrollDownByPixel();
    	Thread.sleep(1000);
    	browserHelper.switchToParentWithChildClose();
    }
    
    
    /************   KUBS_AR/AP_UAT_001_004_TC_02          ***********/
    @And("^get the transaction date in grn$")
    public void get_the_transaction_date_in_grn() throws Throwable {
    	String transactionDate=grnObj.grnTransactionDate().getText();
    	testData.put("transactionDate", transactionDate);
		System.out.println(testData.get("transactionDate"));
    }
    @Then("^Verify Balance sheet post GRN approval$")
    public void verify_balance_sheet_post_grn_approval() throws Throwable {
    	browserHelper.SwitchToWindow(1);
    	javascriptHelper.JavaScriptHelper(driver);
    	Thread.sleep(2000);
    	javascriptHelper.scrollDownByPixel();
    	Thread.sleep(1000);
    	browserHelper.switchToParentWithChildClose();
    }
    
}
