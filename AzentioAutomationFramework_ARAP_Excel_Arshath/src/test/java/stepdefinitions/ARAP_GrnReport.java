package stepdefinitions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataProvider.ConfigFileReader;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.VerificationHelper;
import helper.WaitHelper;
import io.cucumber.java.en.Then;
import pageobjects.ACCOUNTSPAYABLE_PayementSettlementObj;
import pageobjects.ARAP_ARandAPObj;
import pageobjects.ARAP_ReportsObj;
import pageobjects.AccountsReceivable_DebitNoteObj;
import pageobjects.ArApObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;

public class ARAP_GrnReport {
	WebDriver driver = BaseClass.driver;
	KUBS_Login kubsLogin;
	ConfigFileReader configFileReader = new ConfigFileReader();
	WaitHelper waithelper = new WaitHelper(driver);
	JavascriptHelper javaScriptHelper = new JavascriptHelper();
	ClicksAndActionsHelper clickAndActionHelper = new ClicksAndActionsHelper(driver);
	ArApObj arAPobj = new ArApObj(driver);
	BrowserHelper browseHelper = new BrowserHelper(driver);
	ExcelData excelData = new ExcelData("C:\\Users\\inindc00089\\eclipse-workspace\\AzentioAutomationFramework_ARAP\\Test-data\\KUBSTestData.xlsx","ArAP_GrnReport", "DataSet ID");
	Map<String, String> testData = new HashMap<>();
	
	
	
	
	@Then("^update data set Id for GRN Report$")
    public void update_data_set_id_for_grn_report() throws Throwable {
		testData = excelData.getTestdata("KUBS_AR_AP_UAT_001_001_TC_08_D1");   
    }
	
	
	
	
	 @Then("^Click on Report Tab$")
	    public void click_on_report_tabT() throws Throwable {
	    	waithelper.waitForElement(driver, 2000,arAPobj.report_Report_Button());
	    	arAPobj.report_Report_Button().click();  
	    }

	    @Then("^Click on GRN Edit button$")
	    public void click_on_grn_edit_button() throws Throwable {
	    	waithelper.waitForElement(driver, 2000,arAPobj.report_Report_GRNReport_EditButton());
	    	arAPobj.report_Report_GRNReport_EditButton().click();   
	    }

	    @Then("^Select Vendor or Employee name$")
	    public void select_vendor_or_employee_name() throws Throwable {
	    	waithelper.waitForElement(driver, 2000,arAPobj.report_Report_GRNReport_VendorEmployeeName());
	    	arAPobj.report_Report_GRNReport_VendorEmployeeName().click();
	    	arAPobj.report_Report_GRNReport_VendorEmployeeName().sendKeys(testData.get("VendorORemployeeeName"));
	    	arAPobj.report_Report_GRNReport_VendorEmployeeName().sendKeys(Keys.ENTER);
			
	    }

	    @Then("^Select Date$")
	    public void select_date() throws Throwable {
	    	waithelper.waitForElement(driver, 2000,arAPobj.calendar_button());
	    	arAPobj.calendar_button().click();
	    	javaScriptHelper.JavaScriptHelper(driver);
	    	ClicksAndActionsHelper clickAndActionHelper=new ClicksAndActionsHelper(driver);
	    	
	    	Thread.sleep(2000);
	    	while(true)
	        {
			try
			{
			
				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("Month")+" "+testData.get("Year")+"')]")));
				WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("Month")+" "+testData.get("Year")+"')]"));
				Thread.sleep(2000);
				break;
			}
			
			catch(NoSuchElementException nosuchElement)
			{
				arAPobj.ARAPNextMonth().click();
			}
			}
	    	Thread.sleep(2000);
			WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FullMonth")+" "+testData.get("Date")+", "+testData.get("Year")+"']/span"));
			clickAndActionHelper.doubleClick(FinalDay);
		
	    	 
	    }

	    @Then("^Select GRN Status$")
	    public void select_grn_status() throws Throwable {
	    	waithelper.waitForElement(driver, 2000,arAPobj.report_Report_GRNReport_GRNStatus());
	    	arAPobj.report_Report_GRNReport_GRNStatus().click();
	    	arAPobj.report_Report_GRNReport_GRNStatus().sendKeys(testData.get("GRNStatus"));
	    	arAPobj.report_Report_GRNReport_GRNStatus().sendKeys(Keys.ENTER);
	    	Thread.sleep(5000);
	    }
	    @Then("^Click on View buttonT$")
	    public void click_on_view_buttonT() throws Throwable {
	    	waithelper.waitForElement(driver, 2000,arAPobj.view_button());
	    	arAPobj.view_button().click();
	    }
	    @Then("^close the report$")
	    public void close_the_report() throws InterruptedException {
	    javaScriptHelper.JavaScriptHelper(driver);

	    browseHelper.SwitchToWindow(1);
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
	    browseHelper.switchToParentWithChildClose();
	    
	    }

}
