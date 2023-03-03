package stepdefinitions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Assert;
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
import helper.Selenium_Actions;
import helper.VerificationHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.ACCOUNTSPAYABLE_PayementSettlementObj;
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
import pageobjects.ARAP_ARandAPObj;
import pageobjects.ARAP_ReportsObj;
import pageobjects.Account_Receivable;
import pageobjects.AccountsReceivable_DebitNoteObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;


public class ARAP_AccountsPayableReport {
	WebDriver driver = BaseClass.driver;
	KUBS_Login kubsLogin;
	ConfigFileReader configFileReader = new ConfigFileReader();
	WaitHelper waitHelper = new WaitHelper(driver);
	JavascriptHelper javaScriptHelper = new JavascriptHelper();
	DropDownHelper dropDownHelper = new DropDownHelper(driver);
	Account_Receivable account_Receivable = new Account_Receivable(driver);
	Selenium_Actions seleniumactions = new Selenium_Actions(driver);
	VerificationHelper verificationHelper = new VerificationHelper();
	Map<String, String> testdata = new LinkedHashMap<>();
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
	
	ExcelData excelData = new ExcelData("C:\\Users\\ININDC00089\\git\\AzentioAutomationFramework\\ArAp\\AzentioAutomationFramework_ARAP_Excel\\Test-data\\KUBSTestData.xlsx","AccountPayableReport", "DataSet ID");
	Map<String, String> testData = new HashMap<>();
	
	
	@And("^Click On Search Icon$")
	public void click_on_search_icon() throws Throwable {
		waitHelper.waitForElement(driver, 3000, arapObj.ARAP_SearchIcon());
		arapObj.ARAP_SearchIcon().click();
	}
	@And("^Update the data set id for Accounts Payable Report post bill is approved$")
	public void update_the_data_set_id_for_accounts_payable_report_post_bill_is_approved() throws Throwable {
		testData = excelData.getTestdata("KUBS_AR_AP_UAT_001_001_TC_14_D1");    
	
	}
	
	@And("^Update the data set id for Accounts Payable Report APR4 post bill is approved$")
	public void update_the_data_set_id_for_accounts_payable_report_apr4_post_bill_is_approved() throws Throwable {
		testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_004_TC_08_D1");    
	
	}
	
	@And("^Update the data set id for Accounts Payable Report APR5 post bill is approved$")
	public void update_the_data_set_id_for_accounts_payable_report_apr5_post_bill_is_approved() throws Throwable {
		testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_005_TC_08_D1");    
	
	}
	
	@And("^Update the data set id for Accounts Payable Report APR6 post bill is approved$")
	public void update_the_data_set_id_for_accounts_payable_report_apr6_post_bill_is_approved() throws Throwable {
		testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_006_TC_06_D1");    
	
	}
	@And("^Update the data set id for Accounts Payable Report APR7 post bill is approved$")
	public void update_the_data_set_id_for_accounts_payable_report_apr7_post_bill_is_approved() throws Throwable {
		testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_007_TC_04_D1");    
	
	}
	@And("^Update the data set id for Accounts Payable Report APR8 post bill is approved$")
	public void update_the_data_set_id_for_accounts_payable_report_apr8_post_bill_is_approved() throws Throwable {
		testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_008_TC_03_D1");    
	
	}
	@And("^Update the data set id for Accounts Payable Report APR9 post bill is approved$")
	public void update_the_data_set_id_for_accounts_payable_report_apr9_post_bill_is_approved() throws Throwable {
		testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_009_TC_03_D1");    
	
	}
	@And("^Update the data set id for Accounts Payable Report APR10 post bill is approved$")
	public void update_the_data_set_id_for_accounts_payable_report_apr10_post_bill_is_approved() throws Throwable {
		testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_010_TC_03_D1");    
	
	}
	@And("^Update the data set id for Accounts Payable Report APR11 post bill is approved$")
	public void update_the_data_set_id_for_accounts_payable_report_apr11_post_bill_is_approved() throws Throwable {
		testData = excelData.getTestdata("KUBS_AR/AP_UAT_003_004_TC_03_D1");    
	
	}
	@And("^Update the data set id for Accounts Payable Report APR12 post bill is approved$")
	public void update_the_data_set_id_for_accounts_payable_report_apr12_post_bill_is_approved() throws Throwable {
		testData = excelData.getTestdata("KUBS_AR/AP_UAT_003_005_TC_03_D1");    
	
	}
	@And("^Update the data set id for Accounts Payable Report APR13 post bill is approved$")
	public void update_the_data_set_id_for_accounts_payable_report_apr13_post_bill_is_approved() throws Throwable {
		testData = excelData.getTestdata("KUBS_AR/AP_UAT_002_001_TC_04_D1");    
	
	}
	
	@Then("^Give Invoice Number in Invoice Bill$")
	public void give_invoice_number_in_invoice_bill() throws Throwable {
		// --------INVOICE FOR PURCHASE CONTRACT--------//
		arapObj.ARAP_InvoiceNumber().click();
		arapObj.ARAP_InvoiceNumber().sendKeys(testData.get("InvoiceNoBill"));
	}
	@Then("^Click on Table Row First Eye Icon in ARAP$")
	public void click_on_table_row_first_eye_icon_in_arap() throws Throwable {
		// --------CLICK THE TABLE FIRST EYE ICON-----------//
		waitHelper.waitForElement(driver, 2000, arapObj.ARAP_TableEye());
		arapObj.ARAP_TableEye().click();
		
	}


	@And("^Get Business Partner name in Invoice Bill$")
	public void get_business_partner_name_in_invoice_bill() throws Throwable {
		// -------GET DATA BP NAME -------//
//		waitHelper.waitForElement(driver, 5000, arapObj.ARAP_GetcancelBpName());
		waitHelper.waitForElementwithFluentwait(driver, arapObj.ARAP_GetcancelBpName());
		BPNumber = arapObj.ARAP_GetcancelBpName().getText();
		System.out.println(BPNumber);
	}
	@Then("^Third Segment report Icon$")
	public void third_segment_report_icon() throws Throwable {
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoView(arapObj.ARAP_SegmentButton_ReportIcon());
		waitHelper.waitForElement(driver, 3000, arapObj.ARAP_SegmentButton_ReportIcon());
		arapObj.ARAP_SegmentButton_ReportIcon().click();
		waitHelper.waitForElement(driver, 3000, arapObj.ARAP_Report());
		
		Assert.assertTrue(arapObj.ARAP_Report().isDisplayed());
		
	}

	@Then("^Click sub module Accounts Payable Report$")
	public void click_sub_module_accounts_payable_report() throws Throwable {
		// --------SUB-MODULE ACC PAYABLE REPORT--------//
		arapObj.ARAP_Report().click();
		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoView(arapReportObj.ARAP_Report_Acc_pay_Module_Edit());
		arapReportObj.ARAP_Report_Acc_pay_Module_Edit().click();
	}
	@And("^Give Getted Business Partner Name$")
	public void give_getted_business_partner_name() throws Throwable {
		// ---------GIVE GETTED DATA TO FIELD----------//
		// arapReportObj.ARAP_Report_Module_VendorName().click();
		arapReportObj.ARAP_Report_Module_VendorName().sendKeys(BPNumber);
		arapReportObj.ARAP_Report_Module_VendorName().sendKeys(Keys.ENTER);
	}
	@Then("^Give Current business Date in ArAp$")
	public void give_current_business_date_in_arap() throws Throwable {
		// ----------CLICK ON DATE--------------//
		arapReportObj.ARAP_Report_Module_Date().click();
		javaScriptHelper.JavaScriptHelper(driver);
		while (true) {
			try {

				waitHelper.waitForElement(driver, 3000, driver.findElement(
						By.xpath("//span[contains(text(),'" + testData.get("Month") + " " + testData.get("Year") + "')]")));
				driver.findElement(
						By.xpath("//span[contains(text(),'" + testData.get("Month") + " " + testData.get("Year") + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				arapObj.ARAPNextMonth().click();

			}
		}
		waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='"
				+ testData.get("FullMonth") + " " + testData.get("Date") + ", " + testData.get("Year") + "']/span")));
		WebElement Click = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth") + " "
				+ testData.get("Date") + ", " + testData.get("Year") + "']/span"));

		clickAndActionHelper.doubleClick(Click);
	}


	@And("^Give Accounts Payable Status$")
	public void give_accounts_payable_status() throws Throwable {
		// --------ACCOUNTS PAYABLE STATUS------//
		arapReportObj.ARAP_Report_Status().sendKeys(Keys.DOWN);
		arapReportObj.ARAP_Report_Status().sendKeys(Keys.ENTER);
	}

	@Then("^Click on View buttons$")
	public void click_on_view_buttons() throws Throwable {
		// ------CLICK ON VIEW BUTTON---------//
		arapReportObj.ARAP_Report_ViewButton().click();
		Thread.sleep(2000);
	}
	@And("^Verify the Accounts Payable Report is correctly displayed$")
	public void verify_the_accounts_payable_report_is_correctly_displayed() throws Throwable {
		// ----VERIFY THE GRN REPORT------//
		browseHelper.SwitchToWindow(1);
		javaScriptHelper.JavaScriptHelper(driver);
		while (true) {
			Thread.sleep(2000);
			try {
				javaScriptHelper.scrollIntoView(
						driver.findElement(By.xpath("//div[contains(text(),'" + testData.get("InvoiceNoBill") + "')]")));
				driver.findElement(By.xpath("//div[contains(text(),'" + testData.get("InvoiceNoBill") + "')]")).isDisplayed();
				break;
			} catch (NoSuchElementException e) {
				waitHelper.waitForElement(driver, 3000, arapReportObj.ARAP_Report_Nextbtn());
				arapReportObj.ARAP_Report_Nextbtn().click();
			}
		}
		browseHelper.switchToParentWithChildClose();
	}

	@Then("^Verify Balance sheet post GRN approval$")
    public void verify_balance_sheet_post_grn_approval() throws Throwable {
		browseHelper.SwitchToWindow(1);
		javaScriptHelper.JavaScriptHelper(driver);
    	Thread.sleep(2000);
    	javaScriptHelper.scrollDownByPixel();
    	Thread.sleep(1000);
    	browseHelper.switchToParentWithChildClose();
    }	
	
	
	
	//-----------------------//
	
	@And("^search sale of assert in debit list$")
    public void search_sale_of_assert_in_debit_list() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,account_Receivable.searchReceivableName());
        account_Receivable.searchReceivableName().click();
        account_Receivable.searchReceivableName().sendKeys(testData.get("ReceivableName"));
    }
    @And("^get the debit note number and buisnes partner name,debit note date$")
    public void get_the_debit_note_number_and_buisnes_partner_namedebit_note_date() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver, 4000, account_Receivable.debitNoteBuisnessPartner());
		String debitbuisnesspartnername = account_Receivable.debitNoteBuisnessPartner().getText();
		testdata.put("buisnessPartnerName", debitbuisnesspartnername);
		javaScriptHelper.JavaScriptHelper(driver);
		String debitNotenumber = (String) javaScriptHelper.executeScript("return document.getElementsByName('debitNoteNumber')[1].value");
		testdata.put("debitnotenumber", debitNotenumber);
		System.out.println(debitNotenumber);
		 String DebitnoteDate = (String) javaScriptHelper.executeScript("return document.getElementsByName('kubDateTime')[0].value");
	        testdata.put("DebitnoteDate", DebitnoteDate);
	        System.out.println(DebitnoteDate);
			String year = DebitnoteDate.substring(7,11);
			testdata.put("year", year);
			String month =DebitnoteDate.substring(3, 6);
			testdata.put("month", month);
			switch (month) {
			case "Dec":
				testdata.put("fullmonth","December");
				System.out.println(testdata.get("fullmonth"));
				break;
			case "Jan":
				testdata.put("fullmonth","January");
				System.out.println(testdata.get("fullmonth"));
				break;
			case "Feb":
				testdata.put("fullmonth","Febuary");
				System.out.println(testdata.get("fullmonth"));
				break;
			case "Mar":
				testdata.put("fullmonth","March");
				System.out.println(testdata.get("fullmonth"));
				break;
			case "Apr":
				testdata.put("fullmonth","April");
				System.out.println(testdata.get("fullmonth"));
				break;
			case "May":
				testdata.put("fullmonth","May");
				System.out.println(testdata.get("fullmonth"));
				break;
			case "Jun":
				testdata.put("fullmonth","June");
				System.out.println(testdata.get("fullmonth"));
				break;
			case "Jul":
				testdata.put("fullmonth","July");
				System.out.println(testdata.get("fullmonth"));
				break;
			case "Aug":
				testdata.put("fullmonth","August");
				System.out.println(testdata.get("fullmonth"));
				break;
			case "Sep":
				testdata.put("fullmonth","September");
				System.out.println(testdata.get("fullmonth"));
				break;
			case "Oct":
				testdata.put("fullmonth","October");
				System.out.println(testdata.get("fullmonth"));
				break;
			case "Nov":
				testdata.put("fullmonth","November");
				System.out.println(testdata.get("fullmonth"));
				break;
			}
			if (Integer.parseInt(DebitnoteDate.substring(0, 2))>9) {
				String day = DebitnoteDate.substring(0,2);
				System.out.println(day);
				testdata.put("day", day);
			}
			else{
				String day = DebitnoteDate.substring(1,2);
				testdata.put("day", day);
				System.out.println(day);
			}
		
    }
}

		
    

