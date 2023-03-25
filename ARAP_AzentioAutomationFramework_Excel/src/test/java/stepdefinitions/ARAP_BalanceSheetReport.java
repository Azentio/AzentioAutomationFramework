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
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.ARAP_ARandAPObj;
import pageobjects.ARAP_GRNCreationPageObject;
import pageobjects.ARAP_ReportsObj;
import pageobjects.AccountsReceivable_DebitNoteObj;
import pageobjects.ArAp_BalanceSheetReportObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;

public class ARAP_BalanceSheetReport {
	WebDriver driver = BaseClass.driver;
	KUBS_Login kubsLogin;
	ConfigFileReader configFileReader = new ConfigFileReader();
	WaitHelper waitHelper = new WaitHelper(driver);
	JavascriptHelper javaScriptHelper = new JavascriptHelper(driver);
	DropDownHelper dropDownHelper = new DropDownHelper(driver);
	ARAP_GRNCreationPageObject grnObject=new ARAP_GRNCreationPageObject(driver);
	
	VerificationHelper verificationHelper = new VerificationHelper();
	String referance_id;
	String reviwerId;
	String GRNNO;
	String Branchcode;
	String InvoiceNo;
	String PoNumber;
	String BPNumber;
	String DebitNo;
	String ADVNumber;
	String ADVAmount;
	String TxnNo;
	String invoicenumber;
	Map<String, String> Getdata =new LinkedHashMap<>();
	JsonDataReaderWriter readerData = new JsonDataReaderWriter();
	KUBS_ReviewerObj reviewerObj = new KUBS_ReviewerObj(driver);
	KUBS_CheckerObj checkerObj = new KUBS_CheckerObj(driver);
	ClicksAndActionsHelper clickAndActionHelper = new ClicksAndActionsHelper(driver);
	ARAP_ARandAPObj arapObj = new ARAP_ARandAPObj(driver);
	
	ARAP_ReportsObj arapReportObj = new ARAP_ReportsObj(driver);
	JsonDataReaderWriter json = new JsonDataReaderWriter();
	BrowserHelper browseHelper = new BrowserHelper(driver);
	AccountsReceivable_DebitNoteObj accountsReceivable_DebitNoteObj = new AccountsReceivable_DebitNoteObj(driver);
	ArAp_BalanceSheetReportObj arAp_BalanceSheetReportObj = new ArAp_BalanceSheetReportObj(driver);

	ExcelData excelData = new ExcelData("C:\\Users\\inindc00089\\eclipse-workspace\\AzentioAutomationFramework_ARAP\\Test-data\\KUBSTestData.xlsx","BalanceSheetReport", "DataSet ID");
	Map<String, String> testData = new HashMap<>();
	
	@And("^Update the data set id for Balance sheet Report b1$")
    public void update_the_data_set_id_for_balance_sheet_report_b1() {
		testData = excelData.getTestdata("KUBS_AR_AP_UAT_001_001_TC_006_D1");     
    }
	
	
	@And("^Update the data set id for Balance sheet Report post bill is approved$")
    public void update_the_data_set_id_for_balance_sheet_report_post_bill_is_approved() {
		testData = excelData.getTestdata("KUBS_AR_AP_UAT_001_001_TC_13_D1");     
    }
	
	@And("^Update the data set id for Balance sheet Report b3$")
    public void update_the_data_set_id_for_balance_sheet_report_b3() {
		testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_002_TC_03_D1");     
    }
	@And("^Update the data set id for Balance sheet Report b4$")
    public void update_the_data_set_id_for_balance_sheet_report_b4() {
		testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_003_TC_03_D1");     
    }
	@And("^Update the data set id for Balance sheet Report b5$")
    public void update_the_data_set_id_for_balance_sheet_report_b5() {
		testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_004_TC_02_D1");     
    }
	@And("^Update the data set id for Balance sheet Report b6$")
    public void update_the_data_set_id_for_balance_sheet_report_b6() {
		testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_004_TC_07_D1");     
    }
	
	
	@And("^Update the data set id for Balance sheet Report b7$")
    public void update_the_data_set_id_for_balance_sheet_report_b7() {
		testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_005_TC_02_D1");     
    }
	
	@And("^Update the data set id for Balance sheet Report b8$")
    public void update_the_data_set_id_for_balance_sheet_report_b8() {
		testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_005_TC_07_D1");     
    }
	
	@And("^Update the data set id for Balance sheet Report b9$")
    public void update_the_data_set_id_for_balance_sheet_report_b9() {
		testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_006_TC_04_D1");     
    }
	
	@And("^Update the data set id for Balance sheet Report b10$")
    public void update_the_data_set_id_for_balance_sheet_report_b10() {
		testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_007_TC_03_D1");     
    }
	
	@And("^Update the data set id for Balance sheet Report b11$")
    public void update_the_data_set_id_for_balance_sheet_report_b11() {
		testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_008_TC_02_D1");     
    }
	@And("^Update the data set id for Balance sheet Report b12$")
    public void update_the_data_set_id_for_balance_sheet_report_b12() {
		testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_009_TC_02_D1");     
    }
	@And("^Update the data set id for Balance sheet Report b13$")
    public void update_the_data_set_id_for_balance_sheet_report_b13() {
		testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_010_TC_02_D1");     
    }
	@And("^Update the data set id for Balance sheet Report b14$")
    public void update_the_data_set_id_for_balance_sheet_report_b14() {
		testData = excelData.getTestdata("KUBS_AR/AP_UAT_002_001_TC_03_D1");     
    }
	@And("^Update the data set id for Balance sheet Report b15$")
    public void update_the_data_set_id_for_balance_sheet_report_b15() {
		testData = excelData.getTestdata("KUBS_AR/AP_UAT_002_002_TC_03_D1");     
    }
	
	@And("^search and get the active GRN code$")
    public void search_and_get_the_active_grn_code() throws Throwable {
    	waitHelper.waitForElementVisible(grnObject.grnSearchGRNStatus(), 2000, 200);
    	grnObject.grnSearchGRNStatus().click();
    	grnObject.grnSearchGRNStatus().sendKeys(testData.get("GRNStatus"));
    	String aprovedGRNNumber=grnObject.getApprovedGRNNumber().getText();
    	System.out.println("Approved GRN number"+aprovedGRNNumber);    	
    }
	
	@And("^search invoice type as expense$")
	public void search_invoice_type_as_expense() throws Throwable {
		arapObj.ARAP_InvoiceTypeSearch().click();
		arapObj.ARAP_InvoiceTypeSearch().sendKeys(testData.get("InvoiceType"));
	}
	@And("^get the buisness partner name and invoice number from the bill viewed$")
    public void get_the_buisness_partner_name_and_invoice_number_from_the_bill_viewed() throws Throwable {
        
		waitHelper.waitForElementwithFluentwait(driver, arapObj.getBuisnessPartnerFromInvoiceBill());
		BPNumber = arapObj.getBuisnessPartnerFromInvoiceBill().getText();
		System.out.println(BPNumber);
		
		
		
	    invoicenumber = (String) javaScriptHelper
				.executeScript("return document.getElementsByName('billNo')[0].value");
		System.out.println(invoicenumber);
		

	}
	
	 @And("^click the financial reporting$")
	    public void click_the_financial_reporting() throws Throwable {
		 waitHelper.waitForElement(driver, 2000,arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_FinancialReport());
	    	arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_FinancialReport().click();
	    }

	    @And("^click the balance sheet report$")
	    public void click_the_balance_sheet_report() throws Throwable {
//	    	waitHelper.waitForElement(driver, 2000,arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_BalanceSheetReport());
	    	
	    	javaScriptHelper.scrollIntoView(arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_BalanceSheetReport());
	    	waitHelper.waitForElementwithFluentwait(driver, arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_BalanceSheetReport());
	    	arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_BalanceSheetReport().click();
	    }
	    
	    
	    @Then("^Fill the details for Balance sheet report$")
	    public void fill_the_details_for_balance_sheet_report() throws Throwable {
	    	waitHelper.waitForElement(driver, 2000,arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_BranchTextbox());
	    	arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_BranchTextbox().click();
	    	arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_BranchTextbox().sendKeys(testData.get("BranchCode"));
	    	arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_BranchTextbox().sendKeys(Keys.ENTER);
	    	//arAp_BalanceSheetReportTestDataType= jsonReader.getBalanceSheetReportByName("maker");
	    	waitHelper.waitForElement(driver, 2000,arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_ReportType());
	    	arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_ReportType().click();
	    	arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_ReportType().sendKeys(testData.get("ReportType"));
	    	arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_ReportType().sendKeys(Keys.ENTER);
	    	
	    	waitHelper.waitForElement(driver, 2000, arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_CalendarButton());
			 arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_CalendarButton().click();
			
			 
			 
while(true)
	{
	try
		{
			//span[contains(text(),'Oct 2022')]
//			Thread.sleep(1000);
//			waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//span[contains(text(),'"+arAp_BalanceSheetReportTestDataType.Month+" "+arAp_BalanceSheetReportTestDataType.Year+"')]")));
		waitHelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("Month")+" "+testData.get("Year")+"')]")));
			WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("Month")+" "+testData.get("Year")+"')]"));
//			Thread.sleep(2000);
			break;
		}
					
	catch(NoSuchElementException nosuchElement)
		{
			arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_NextMonth().click();
			
		}
	}
				//td[@aria-label='November 1, 2022']/span
waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='"
		+ testData.get("FullMonth") + " " + testData.get("Date") + ", " + testData.get("Year") + "']/span")));
WebElement Click = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth") + " "
		+ testData.get("Date") + ", " + testData.get("Year") + "']/span"));

clickAndActionHelper.doubleClick(Click);

	    	 
	    }
	    
	    @Then("^Verify Balance sheet should be updated correctly basis the legs impacted in accounting entries$")
	    public void verify_balance_sheet_should_be_updated_correctly_basis_the_legs_impacted_in_accounting_entries() throws Throwable {
	    	

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
