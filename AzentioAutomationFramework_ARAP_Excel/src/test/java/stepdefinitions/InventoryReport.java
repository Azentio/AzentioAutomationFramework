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

public class InventoryReport {
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
			"C:\\Users\\ININDC00089\\git\\AzentioAutomationFramework\\ArAp\\AzentioAutomationFramework_ARAP_Excel\\Test-data\\KUBSTestData.xlsx",
			"InventoryReport", "DataSet ID");
	Map<String, String> testData = new HashMap<>();
	
	 @Then("^click on report icon$")
	    public void click_on_report_icon() throws InterruptedException {
	    	Thread.sleep(2000);
	    	javascripthelper.JavaScriptHelper(driver);
	    	javascripthelper.scrollIntoViewAndClick(fixedAsset_AssetCreationObj.fixedAssets_AssetCreation_ReportIcon());
	    }
	  @And("^user update the data set ID for instrument code report$")
	    public void user_update_the_data_set_id_for_instrument_code_report() throws Throwable {
		  testData = excelData.getTestdata("KUBS_INV_MGMT_UAT_007_007_D1");
	    }
	 
	 @And("^user should navigate to master reports menu$")

		public void user_should_navigate_to_master_reports_menu() {

//	    		waithelper.waitForElement(driver, 3000, reports_AssetCreationCommonObj.Report_AssetCreationCommon_ReportIcon()); 

//	    		reports_AssetCreationCommonObj.Report_AssetCreationCommon_ReportIcon().click(); 

			waithelper.waitForElement(driver, 3000, reports_AssetCreationCommonObj.Report_MasterReportsMenu());

			reports_AssetCreationCommonObj.Report_MasterReportsMenu().click();

		}

	
	@Then("^click on temp grid button of inventory code report$")
	public void click_on_temp_grid_button_of_inventory_code_report() {
		waithelper.waitForElement(driver, 3000, inventoryManagamentObj.Report_InventoryCode_TempView());
		inventoryManagamentObj.Report_InventoryCode_TempView().click();

	}

	@Then("^Fill the form for inventory code Report$")
	public void fill_the_form_for_inventory_code_report() throws Throwable {
		waithelper.waitForElement(driver, 3000, inventoryManagamentObj.Report_InventoryCode_Description());
		inventoryManagamentObj.Report_InventoryCode_Description().click();
		inventoryManagamentObj.Report_InventoryCode_Description().sendKeys(testData.get("Description"));
		inventoryManagamentObj.Report_InventoryCode_Description().sendKeys(Keys.ENTER);
		
		
		//Calendar
			Thread.sleep(2000);
			waithelper.waitForElement(driver, 2000,inventoryManagamentObj.report_InventoryCodeReport_CalendarButton());
			inventoryManagamentObj.report_InventoryCodeReport_CalendarButton().click();
			Thread.sleep(2000);
			 
			
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
	@Then("^click in the view button to check$")
    public void click_in_the_view_button_to_check()  {
		waithelper.waitForElement(driver, 3000, reports_AssetCreationCommonObj.Report_AssetCreationCommon_ViewButton());
		reports_AssetCreationCommonObj.Report_AssetCreationCommon_ViewButton().click();
    }
	

	@Then("^the report is displaying with all the details$")

	public void the_report_is_displaying_with_all_the_details() throws InterruptedException {
		Thread.sleep(1000);
		browserHelper.SwitchToWindow(1);
//		waithelper.waitForElement(driver, 10000, inventoryManagamentObj.Report_inventoryCodeReport());
//		boolean result = inventoryManagamentObj.Report_inventoryCodeReport().isDisplayed();
//		System.out.println(result);
		browserHelper.switchToParentWithChildClose();

	}
	
	//-----------KUBS_INV_MGMT_UAT_007_008-----
	 @And("^user update the data set ID for denomination details report$")
	    public void user_update_the_data_set_id_for_denomination_details_report() throws Throwable {
		  testData = excelData.getTestdata("KUBS_INV_MGMT_UAT_007_008_D1");
	    }
	
	@Then("^click on report button$")
	public void click_on_report_button() throws Throwable {
			//-----------CLICK ON REPORT ICON----------------//
			Thread.sleep(2000);
//			waithelper.waitForElement(driver, 3000, inventoryManagamentObj.inventoryReportIcon());
			waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryReportIcon());
			inventoryManagamentObj.inventoryReportIcon().click();
			waithelper.waitForElement(driver, 3000, inventoryManagamentObj.inventoryEnquiryMenu());
			Assert.assertTrue(inventoryManagamentObj.inventoryEnquiryMenu().isDisplayed());

		}
	@Then("^Click on Fund Requisition Report edit grid$")
	public void click_on_fund_requisition_report_edit_grid() throws Throwable {
		javascripthelper.JavaScriptHelper(driver);
		//waithelper.waitForElement(driver, 2000, inventoryManagamentObj.report_inventoryItemDetail_EditButton());
		
		javascripthelper.scrollIntoView(inventoryManagamentObj.report_FundRequsitionReport_EditButton());
		waithelper.waitForElement(driver, 3000, inventoryManagamentObj.report_FundRequsitionReport_EditButton());
		inventoryManagamentObj.report_FundRequsitionReport_EditButton().click();
	}

	@Then("^Fill the form for Fund Requisition Report$")
	public void fill_the_form_for_fund_requisition_report() throws Throwable {
		
		//Calendar
			Thread.sleep(2000);
			waithelper.waitForElement(driver, 2000,inventoryManagamentObj.report_FundRequsitionReport_CalendarButton());
			inventoryManagamentObj.report_FundRequsitionReport_CalendarButton().click();
			Thread.sleep(2000);
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

	@And("^Click on view button to view report of Fund Requisition Report$")
	public void click_on_view_button_to_view_report_of_fund_requisition_report() throws Throwable {
		waithelper.waitForElement(driver, 2000,inventoryManagamentObj.report_inventoryStockReceipt_ViewButton());
		inventoryManagamentObj.report_inventoryStockReceipt_ViewButton().click();
		
	}
	
	@Then("^verify the approved record is available in the report$")
	public void verify_the_approved_record_is_available_in_the_report() throws Throwable {
		
		Thread.sleep(1000);
		javascripthelper.JavaScriptHelper(driver);
		browserHelper.SwitchToWindow(1);
		Thread.sleep(3000);
		browserHelper.switchToParentWithChildClose();
		}
	
	//-------------KUBS_INV_MGMT_UAT_007_009-------------

	 @And("^user update the data set ID for inventory item details report$")
	    public void user_update_the_data_set_id_for_inventory_item_details_report() throws Throwable {
		 testData = excelData.getTestdata("KUBS_INV_MGMT_UAT_007_009_D1");
	    }

	@Then("^Click on inventory item details Report edit grid$")
	public void click_on_inventory_item_details_report_edit_grid() throws Throwable {
		javascripthelper.JavaScriptHelper(driver);
		 
		
		javascripthelper.scrollIntoView(inventoryManagamentObj.report_InventoryItemDetails_EditButton());
		waithelper.waitForElement(driver, 3000, inventoryManagamentObj.report_InventoryItemDetails_EditButton());
		inventoryManagamentObj.report_InventoryItemDetails_EditButton().click(); 
	}

	@Then("^Fill the form for inventory item details Report$")
	public void fill_the_form_for_inventory_item_details_report() throws Throwable {
		
		
		waithelper.waitForElement(driver, 2000,inventoryManagamentObj.report_InventoryItemDetails_ItemDescription_textbox());
		inventoryManagamentObj.report_InventoryItemDetails_ItemDescription_textbox().click();
		inventoryManagamentObj.report_InventoryItemDetails_ItemDescription_textbox().sendKeys(testData.get("Description"));
		inventoryManagamentObj.report_InventoryItemDetails_ItemDescription_textbox().sendKeys(Keys.ENTER);
		
		
		
		//Calendar
			Thread.sleep(2000);
			waithelper.waitForElement(driver, 2000,inventoryManagamentObj.report_PurchaseRequsition_calanderbutton());
			inventoryManagamentObj.report_PurchaseRequsition_calanderbutton().click();
			Thread.sleep(2000);
			 
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

	@And("^Click on view button to view report of inventory item details Report$")
	public void click_on_view_button_to_view_report_of_inventory_item_details_report() throws Throwable {
		waithelper.waitForElement(driver, 2000,inventoryManagamentObj.report_InventoryItemDetails_ViewButton());
		inventoryManagamentObj.report_InventoryItemDetails_ViewButton().click();    
	}
	//----------------------KUBS_INV_MGMT_UAT_007_010------------
	 @And("^user update the data set ID for inventory stock receipt report$")
	    public void user_update_the_data_set_id_for_inventory_stock_receipt_report() throws Throwable {
		 testData = excelData.getTestdata("KUBS_INV_MGMT_UAT_007_010_D1");
	    }

	@Then("^Click on inventory stock receipt Report edit grid$")
	public void click_on_inventory_stock_receipt_report_edit_grid() throws Throwable {
		javascripthelper.JavaScriptHelper(driver);
		//waithelper.waitForElement(driver, 2000, inventoryManagamentObj.report_inventoryItemDetail_EditButton());
		
		javascripthelper.scrollIntoView(inventoryManagamentObj.report_inventoryStockReceipt_EditButton());
		
		waithelper.waitForElement(driver, 2000,inventoryManagamentObj.report_inventoryStockReceipt_EditButton());
		inventoryManagamentObj.report_inventoryStockReceipt_EditButton().click();
	}

	@Then("^Fill the form for inventory stock receipt Report$")
	public void fill_the_form_for_inventory_stock_receipt_report() throws Throwable {
		
		waithelper.waitForElement(driver, 2000,inventoryManagamentObj.report_inventoryStockReceipt_POReferenceTextbox());
		inventoryManagamentObj.report_inventoryStockReceipt_POReferenceTextbox().click();
		inventoryManagamentObj.report_inventoryStockReceipt_POReferenceTextbox().sendKeys(testData.get("POReference"));
		inventoryManagamentObj.report_inventoryStockReceipt_POReferenceTextbox().sendKeys(Keys.ENTER);
		
		
		
		//Calendar
			Thread.sleep(2000);
			waithelper.waitForElement(driver, 2000,inventoryManagamentObj.report_PurchaseRequsition_calanderbutton());
			inventoryManagamentObj.report_PurchaseRequsition_calanderbutton().click();
			Thread.sleep(2000);

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

	@And("^Click on view button to view report of inventory stock receipt Report$")
	public void click_on_view_button_to_view_report_of_inventory_stock_receipt_report() throws Throwable {
		waithelper.waitForElement(driver, 2000,inventoryManagamentObj.report_inventoryStockReceipt_ViewButton());
		inventoryManagamentObj.report_inventoryStockReceipt_ViewButton().click();
		   
	}

}
