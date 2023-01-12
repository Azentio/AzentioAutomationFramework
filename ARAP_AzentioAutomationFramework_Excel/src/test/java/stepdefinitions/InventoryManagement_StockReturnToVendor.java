package stepdefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.parser.ParseException;
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
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
import pageobjects.AccountPayable_VendorPurchaseOrderObj;
import pageobjects.Azentio_ReviewerObj;
import pageobjects.INVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj;
import pageobjects.InventoryManagamentObj;
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;

public class InventoryManagement_StockReturnToVendor {
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	ConfigFileReader config = new ConfigFileReader();
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(driver);
	WaitHelper waithelper = new WaitHelper(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	BrowserHelper browserHelper;
//	INVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj iNVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj = new INVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj(driver);
//	AccountPayable_VendorPurchaseOrderObj accountPayable_VendorPurchaseOrderObj = new AccountPayable_VendorPurchaseOrderObj(driver);
	InventoryManagamentObj inventoryManagamentObj = new InventoryManagamentObj(driver);
	

	ExcelData excelData = new ExcelData("C:\\Users\\ININDC00091\\git\\AzentioAutomationFramework\\DeveshFW_Excel\\ARAP_AzentioAutomationFramework_Excel\\Test-data\\KUBS_InventoryMgmt_TestData.xlsx",
			"StockReturnToVendorTestData", "DataSet ID");
	Map<String, String> testData = new HashMap<>();
	String dataSetID;
	
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
	
	@Then("^Click on stock return report edit button$")
	public void click_on_stock_return_report_edit_button() throws Throwable {
		javascripthelper.JavaScriptHelper(driver);
		//waithelper.waitForElement(driver, 2000, inventoryManagamentObj.report_inventoryItemDetail_EditButton());
		
		javascripthelper.scrollIntoView(inventoryManagamentObj.report_StockReturn_EditButton());
		waithelper.waitForElement(driver, 3000, inventoryManagamentObj.report_StockReturn_EditButton());
		inventoryManagamentObj.report_StockReturn_EditButton().click();
	}

	@Then("^Fill the form for stock return report for return the inventories$")
	public void fill_the_form_for_stock_return_report_for_return_the_inventories() throws Throwable {
//		inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");

		waithelper.waitForElement(driver, 2000,inventoryManagamentObj.report_StockReturn_returntype_Textbox());
		inventoryManagamentObj.report_StockReturn_returntype_Textbox().click();
		inventoryManagamentObj.report_StockReturn_returntype_Textbox().sendKeys(testData.get("ReferenceID"));
		inventoryManagamentObj.report_StockReturn_returntype_Textbox().sendKeys(Keys.ENTER);
		
		//Calendar
			Thread.sleep(2000);
			waithelper.waitForElement(driver, 2000,inventoryManagamentObj.report_PurchaseRequsition_calanderbutton());
			inventoryManagamentObj.report_PurchaseRequsition_calanderbutton().click();
			Thread.sleep(2000);
			 
//			inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
			while(true)
		    {
			try
			{
			
				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("GL Month")+" "+testData.get("GL Year")+"')]")));
				WebElement monthAndYear=driver.findElement(By.xpath("//span[contains(text(),'"+testData.get("GL Month")+" "+testData.get("GL Year")+"')]"));
			    break;
			}
			
			catch(NoSuchElementException nosuchElement)
			{
				inventoryManagamentObj.inventoryNextMonth().click();
			}
			}
			WebElement FinalDay=driver.findElement(By.xpath("//td[@aria-label='"+testData.get("GL FullMonth")+" "+testData.get("GL Date")+", "+testData.get("GL Year")+"']/span"));
			clicksAndActionHelper.doubleClick(FinalDay);
	}

	@And("^Click on view button to view report of stock return$")
	public void click_on_view_button_to_view_report_of_stock_return() throws Throwable {
		waithelper.waitForElement(driver, 2000,inventoryManagamentObj.report_inventoryStockReceipt_ViewButton());
		inventoryManagamentObj.report_inventoryStockReceipt_ViewButton().click(); 
	}
	@Then("^verify the approved record is available in the stock return report$")
	public void verify_the_approved_record_is_available_in_the_stock_return_report() throws Throwable {
		System.out.println("Approved invoice number "+testData.get("Voucher"));
		javascripthelper.JavaScriptHelper(driver);

		browserHelper.SwitchToWindow(1);
		Thread.sleep(3000);
//		while(true)
//		{
//		try
//		{
//		javascripthelper.scrollIntoView(driver.findElement(By.xpath("//div[contains(text(),'+inventoryManagementTestDataType.Voucher+')]")));
//		driver.findElement(By.xpath("//div[contains(text(),'+inventoryManagementTestDataType.Voucher+')]")).isDisplayed();
//		break;
//		}
//		catch(NoSuchElementException e)
//		{
//			inventoryManagamentObj.Report_report_NextButton().click();
//		}
//		catch(StaleElementReferenceException e1)
//		{
//		}
//		}
		browserHelper.switchToParentWithChildClose();
		}
	
	
	@Then("^select data set ID for checking stock return to vendor$")
    public void select_data_set_id_for_checking_stock_return_to_vendor() throws Throwable {
		dataSetID = "KUBS_INV_MGMT_UAT_006_001";
		testData = excelData.getTestdata(dataSetID);
    }

}
