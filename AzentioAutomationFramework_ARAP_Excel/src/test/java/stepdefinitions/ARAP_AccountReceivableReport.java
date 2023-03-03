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
import helper.JavascriptHelper;
import helper.Selenium_Actions;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.ARAP_ARandAPObj;
import pageobjects.Account_Receivable;
import pageobjects.Accounts_Payable;
import pageobjects.ArAp_BalanceSheetReportObj;
import pageobjects.ArAp_Cancellation_of_vendorObj;
import pageobjects.Ar_Ap_AdjustmentObj;
import pageobjects.Ar_Po_creationObj;
import pageobjects.Enquiry_Obj;
import pageobjects.InvoiceBookingObj;
import pageobjects.Payment_SettlementObj;
import resources.BaseClass;
import resources.ExcelData;

public class ARAP_AccountReceivableReport extends BaseClass {
	WebDriver driver = BaseClass.driver;
	Selenium_Actions seleniumactions = new Selenium_Actions(driver);
	KUBS_Login login;
	ConfigFileReader configreader = new ConfigFileReader();
	ArAp_Cancellation_of_vendorObj cancellationofcontract = new ArAp_Cancellation_of_vendorObj(driver);
	WaitHelper waithelper = new WaitHelper(driver) ;
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);

	Map<String, String> testdata = new LinkedHashMap<>();
	private String NetPayableAmountinBillList;
	private float CalculatedTdsValue;
	private String debitbuisnesspartnername;
	private String debitinvoicenumber;
	Ar_Po_creationObj arpoCreationObj = new Ar_Po_creationObj(driver);
	InvoiceBookingObj invoiceBookingObj = new InvoiceBookingObj(driver);
	Payment_SettlementObj paymentSettlementObj = new Payment_SettlementObj(driver);
	Account_Receivable account_Receivable = new Account_Receivable(driver);
	Accounts_Payable accounts_PayableObj = new Accounts_Payable(driver);
	Ar_Ap_AdjustmentObj arapAdjustment = new Ar_Ap_AdjustmentObj(driver);
	Enquiry_Obj enquiryObj = new Enquiry_Obj(driver);
	ARAP_ARandAPObj arapObj = new ARAP_ARandAPObj(driver);
	JavascriptHelper javascriphelper = new JavascriptHelper();
	JavascriptHelper javascripthelper = new JavascriptHelper();
	BrowserHelper  browserHelper =  new BrowserHelper(driver);

	
	ArAp_BalanceSheetReportObj arAp_BalanceSheetReportObj = new ArAp_BalanceSheetReportObj(driver);
	
	ExcelData excelData = new ExcelData("C:\\Users\\ININDC00089\\git\\AzentioAutomationFramework\\ArAp\\AzentioAutomationFramework_ARAP_Excel\\Test-data\\KUBSTestData.xlsx","ARAP_AccountReceivableReport", "DataSet ID");
	Map<String, String> testData = new HashMap<>();
	
	@And("^user update the data set ID for Account Receivable Report$")
    public void user_update_the_data_set_id_for_account_receivable_report() throws Throwable {
		testData = excelData.getTestdata("KUBS_AR/AP_UAT_004_004_TC_07_D1"); 
    }
	
	@And("^click the Account Receivable Report$")
    public void click_the_account_receivable_report() throws Throwable {
        seleniumactions.getWaitHelper().waitForElement(driver,2000,enquiryObj.accountsReceivableReportEditIcon());
        enquiryObj.accountsReceivableReportEditIcon().click();
    }
    
	@And("^select the vendor name$")
    public void select_the_vendor_name() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,enquiryObj.selectVendorName());
        seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.selectVendorName());
        enquiryObj.selectVendorName().sendKeys(testData.get("VendorName"));
        enquiryObj.selectVendorName().sendKeys(Keys.ENTER);
    }

	@And("^select the Receivable status based on we get from Debit note$")
    public void select_the_receivable_status_based_on_we_get_from_debit_note() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,enquiryObj.selectContractStatus());
        seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.selectContractStatus());
        enquiryObj.selectContractStatus().sendKeys(Keys.ENTER);
    }
	
	@And("^select the date$")
    public void select_the_date() throws Throwable {
    	
  waithelper.waitForElement(driver, 2000, arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_CalendarButton());
arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_CalendarButton().click();
	
			 
javascripthelper.JavaScriptHelper(driver);
while(true)
	{
	try
		{
		//span[contains(text(),'Oct 2022')]
//		Thread.sleep(1000);
//		waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath("//span[contains(text(),'"+arAp_BalanceSheetReportTestDataType.Month+" "+arAp_BalanceSheetReportTestDataType.Year+"')]")));
		waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("Month")+" "+testData.get("Year")+"')]")));
		WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("Month")+" "+testData.get("Year")+"')]"));
//		Thread.sleep(2000);
		break;
		}
					
	catch(NoSuchElementException nosuchElement)
		{
			arAp_BalanceSheetReportObj.arAp_BalanceSheetReport_NextMonth().click();
			
		}
	}
				//td[@aria-label='November 1, 2022']/span
waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='"
		+ testData.get("FullMonth") + " " + testData.get("Date") + ", " + testData.get("Year") + "']/span")));
WebElement Click = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth") + " "
		+ testData.get("Date") + ", " + testData.get("Year") + "']/span"));

clicksAndActionHelper.doubleClick(Click);   }

    @And("^select the payable status$")
    public void select_the_payable_status() throws Throwable {
    	seleniumactions.getWaitHelper().waitForElement(driver,2000,enquiryObj.selectContractStatus());
        seleniumactions.getClickAndActionsHelper().clickOnElement(enquiryObj.selectContractStatus());
        enquiryObj.selectContractStatus().sendKeys(testdata.get("invoicestatus"));
        enquiryObj.selectContractStatus().sendKeys(Keys.ENTER);
    }
   
    @Then("^verify the debit note is available in Receivable Report$")
    public void verify_the_debit_note_is_available_in_receivable_report() throws Throwable {
	
    	seleniumactions.getBrowserHelper().SwitchToWindow(1);
		/*
		 * javascriphelper.JavaScriptHelper(driver); while (true) { try {
		 * javascriphelper.scrollIntoView(driver.findElement(By.xpath(
		 * "//div[contains(text(),'"+testdata.get("debitnotenumber")+"')]")));
		 * driver.findElement(By.xpath("//div[contains(text(),'"+testdata.get(
		 * "debitnotenumber")+"')]")).isDisplayed();
		 * 
		 * break; } catch (NoSuchElementException e) {
		 * seleniumactions.getWaitHelper().waitForElement(driver,2000,enquiryObj.
		 * nextPageInContractReport()); enquiryObj.nextPageInContractReport().click(); }
		 * 
		 * }
		 */
    	seleniumactions.getBrowserHelper().switchToParentWithChildClose();
    }
}
