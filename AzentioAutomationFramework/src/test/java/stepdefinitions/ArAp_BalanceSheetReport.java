package stepdefinitions;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.Then;
import pageobjects.ArAp_BalanceSheetReportObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.ArAp_BalanceSheetReportTestDataType;

public class ArAp_BalanceSheetReport extends BaseClass {
	

	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	ConfigFileReader configFileReader = new ConfigFileReader();
	ConfigFileReader config=new ConfigFileReader();
	DropDownHelper dropDownHelper;
	WaitHelper waithelper = new WaitHelper(driver) ;
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	JavascriptHelper javascripthelper = new JavascriptHelper();
	BrowserHelper  browserHelper =  new BrowserHelper(driver);
	ArAp_BalanceSheetReportObj arAp_BalanceSheetReportObj = new ArAp_BalanceSheetReportObj(driver);
	ArAp_BalanceSheetReportTestDataType arAp_BalanceSheetReportTestDataType = jsonReader.getBalanceSheetReportByName("maker");
	
	
	
	 @Then("^Click on Report button$")
	    public void click_on_repoet_button() throws InterruptedException  {
		 Thread.sleep(2000);
		  waithelper.waitForElement(driver, 2000,  arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_ReportButton());
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
	    @Then("^Fill branch details for report$")
	    public void fill_branch_details_for_report()  {
	    	//arAp_BalanceSheetReportTestDataType= jsonReader.getBalanceSheetReportByName("maker");
	    	waithelper.waitForElement(driver, 2000,arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_BranchTextbox());
	    	arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_BranchTextbox().click();
	    	arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_BranchTextbox().sendKeys(arAp_BalanceSheetReportTestDataType.BranchCode);
	    	arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_BranchTextbox().sendKeys(Keys.ENTER);
	    	//Thread.sleep(6000);
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
			Thread.sleep(2000);
			waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//span[contains(text(),'"+arAp_BalanceSheetReportTestDataType.Month+" "+arAp_BalanceSheetReportTestDataType.Year+"')]")));
			WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'"+arAp_BalanceSheetReportTestDataType.Month+" "+arAp_BalanceSheetReportTestDataType.Year+"')]"));
			Thread.sleep(2000);
			break;
		}
					
	catch(NoSuchElementException nosuchElement)
		{
			arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_NextMonth().click();
			
		}
	}
				//td[@aria-label='November 1, 2022']/span
	WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+arAp_BalanceSheetReportTestDataType.FullMonth+" "+arAp_BalanceSheetReportTestDataType.Day+", "+arAp_BalanceSheetReportTestDataType.Year+"']/span"));
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
	    
	    
}
