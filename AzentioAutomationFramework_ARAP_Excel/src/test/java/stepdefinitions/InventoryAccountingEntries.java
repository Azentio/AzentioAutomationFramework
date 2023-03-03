package stepdefinitions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.RadioButtonHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.BUDGET_BudgetTransferObj;
import pageobjects.FixedAsset_AssetCreationObj;
import pageobjects.InventoryManagamentObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.Reports_AssetCreationCommonObj;
import resources.BaseClass;
import resources.ExcelData;

public class InventoryAccountingEntries {
	WebDriver driver = BaseClass.driver;
	ConfigFileReader config = new ConfigFileReader();
	KUBS_Login login = new KUBS_Login(driver);
	BrowserHelper browserHelper = new BrowserHelper(driver);
	JavascriptHelper javahelper = new JavascriptHelper();
	WaitHelper waithelper = new WaitHelper(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper();
	InventoryManagamentObj inventoryManagamentObj = new InventoryManagamentObj(driver);
	ConfigFileReader configFileReader = new ConfigFileReader();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	BUDGET_BudgetTransferObj budgetTransferObj = new BUDGET_BudgetTransferObj(driver);
	FixedAsset_AssetCreationObj fixedAsset_AssetCreationObj = new FixedAsset_AssetCreationObj(driver);
	Reports_AssetCreationCommonObj reports_AssetCreationCommonObj = new Reports_AssetCreationCommonObj(driver);

	String referance_id;
	KUBS_CheckerObj kubschecker=new KUBS_CheckerObj(driver);
	JavascriptHelper javascript;
	RadioButtonHelper radioButtonHelper = new RadioButtonHelper(driver);
	String reviwerId;
	String RefNo;

	ExcelData excelData = new ExcelData(
			"C:\\Users\\inindc00089\\eclipse-workspace\\AzentioAutomationFramework_ARAP\\Test-data\\KUBSTestData.xlsx",
			"InventoryReport", "DataSet ID");
	Map<String, String> testData = new HashMap<>();
	
	@And("^user update the data set ID for inventory accounting entries$")
	public void user_update_the_data_set_id_for_inventory_accounting_entries() throws Throwable {
		testData = excelData.getTestdata("KUBS_INV_MGMT_UAT_005_002_D1");
	}

	@And("^user update the data set ID for Inventory stock Gl Status$")
	public void user_update_the_data_set_id_for_inventory_stock_gl_status() throws Throwable {
		testData = excelData.getTestdata("KUBS_INV_MGMT_UAT_004_004_D1");
	}
	 
	@Then("^click on report segment button$")
	public void click_on_report_segment_button() throws Throwable {
		Thread.sleep(1500);
		
	javahelper.JavaScriptHelper(driver);
	javahelper.scrollIntoViewAndClick(inventoryManagamentObj.inventoryReportIcon());
		
//	waithelper.waitForElement(driver, 3000, inventoryManagamentObj.inventoryReportIcon());
//	inventoryManagamentObj.inventoryReportIcon().click();
		
	//waithelper.waitForElement(driver, 3000, inventoryManagamentObj.inventoryEnquiryMenu());
	//Assert.assertTrue(inventoryManagamentObj.inventoryEnquiryMenu().isDisplayed());
	
	}
	
	@And("^click on equiry menu$")
	public void click_on_equiry_menu() throws Throwable {
		waithelper.waitForElement(driver, 3000,inventoryManagamentObj.inventoryEnquiryMenu());

		inventoryManagamentObj.inventoryEnquiryMenu().click();
		waithelper.waitForElement(driver, 3000, inventoryManagamentObj.inventoryFinancialTransactionIcon());
		Assert.assertTrue(inventoryManagamentObj.inventoryFinancialTransactionIcon().isDisplayed());
		
	}
	
	@Then("^click on edit icon near fiancial transaction menu$")
	public void click_on_edit_icon_near_fiancial_transaction_menu() throws Throwable {
		inventoryManagamentObj.inventoryFinancialTransactionIcon().click();

	}
	

	@And("^choose the branch code$")
	public void choose_the_branch_code() throws Throwable {
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryBranchCode());
		inventoryManagamentObj.inventoryBranchCode().sendKeys(testData.get("BranchCode"));
		inventoryManagamentObj.inventoryBranchCode().sendKeys(Keys.ENTER);
	}

	@And("^choose the Gl code$")
	public void choose_the_gl_code() throws Throwable {
		
		inventoryManagamentObj.inventoryGlCode().sendKeys(testData.get("GLCode"));
		inventoryManagamentObj.inventoryGlCode().sendKeys(Keys.ENTER);
	}

	@And("^click transaction from date calender icon$")
	public void click_transaction_from_date_calender_icon() throws Throwable {
		inventoryManagamentObj.inventoryFromDate().click();

	}

	@Then("^choose from date$")
	public void choose_from_date() throws Throwable {
		
		javascripthelper.JavaScriptHelper(driver);
		Thread.sleep(500);
		while(true)
        {
		try
		{
		
			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("Month")+" "+testData.get("Year")+"')]")));
			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("Month")+" "+testData.get("Year")+"')]"));
		    break;
		}
		
		catch(NoSuchElementException nosuchElement)
		{
			inventoryManagamentObj.inventoryNextMonth().click();
		}
		}
		WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FullMonth")+" "+testData.get("Date")+", "+testData.get("Year")+"']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
	}

	@And("^click on transaction to date calender icon$")
	public void click_on_transaction_to_date_calender_icon() throws Throwable {

		waithelper.waitForElement(driver, 3000, inventoryManagamentObj.inventoryToDate());
		inventoryManagamentObj.inventoryToDate().click();
	
	}

	@Then("^choose to date$")
	public void choose_to_date() throws Throwable {
		Thread.sleep(500);
		while(true)
        {
		try
		{
		
			waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("Month1")+" "+testData.get("Year1")+"')]")));
			WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("Month1")+" "+testData.get("Year1")+"')]"));
		    break;
		}
		
		catch(NoSuchElementException nosuchElement)
		{
			inventoryManagamentObj.inventoryNextMonth().click();
		}
		}
		WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+testData.get("FullMonth1")+" "+testData.get("Date1")+", "+testData.get("Year1")+"']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
	}

	@And("^click on view button$")
	public void click_on_view_button() throws Throwable {
		waithelper.waitForElement(driver, 3000, inventoryManagamentObj.inventoryViewButton());
		inventoryManagamentObj.inventoryViewButton().click();
		Thread.sleep(3000);
	}
	
	 @Then("^validate voucher number for stock issue$")
	    public void validate_voucher_number_for_stock_issue() throws Throwable {
		 Thread.sleep(2000);

		    while(true) {
		    	try{

		waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("VoucherForStockIssue")+"')]")));


		WebElement VoucherNum =driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("VoucherForStockIssue")+"')]"));
		break;


		}


		catch(NoSuchElementException nosuchElement)

		{
			javascripthelper.JavaScriptHelper(driver);
	    	javascripthelper.scrollIntoView(inventoryManagamentObj.inventory_Next());
	    	

			inventoryManagamentObj.inventory_Next().click();

		}


		 }

		System.out.println("Record is present in the list");

		  

		 }
}
