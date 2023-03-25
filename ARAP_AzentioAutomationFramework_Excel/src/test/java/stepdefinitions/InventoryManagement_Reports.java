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
import pageobjects.ArApObj;
import pageobjects.Azentio_ReviewerObj;
import pageobjects.BUDGET_RequestAndAllocationObj;
import pageobjects.INVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj;
import pageobjects.InventoryManagamentObj;
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;

public class InventoryManagement_Reports {
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	ConfigFileReader config = new ConfigFileReader();
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(driver);
	WaitHelper waithelper = new WaitHelper(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper(driver);
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	BrowserHelper browserHelper=new BrowserHelper(driver);
	ArApObj arAPobj = new ArApObj(driver);
	BUDGET_RequestAndAllocationObj requestAndAllocation = new BUDGET_RequestAndAllocationObj(driver);
	InventoryManagamentObj inventoryManagamentObj = new InventoryManagamentObj(driver);

	ExcelData excelData = new ExcelData("C:\\Users\\ININDC00091\\git\\AzentioAutomationFramework\\DeveshFW_Excel\\ARAP_AzentioAutomationFramework_Excel\\Test-data\\KUBS_InventoryMgmt_TestData.xlsx",
			"ReportsTestData", "Data Set ID");
	Map<String, String> testData = new HashMap<>();
	String dataSetID;

	// ------------------KUBS_INV_MGMT_UAT_007_001-----
	@Then("^Click on Inventory access detail report edit grid$")
	public void click_on_inventory_access_detail_report_edit_grid() throws Throwable {
		javascripthelper.scrollIntoView(inventoryManagamentObj.report_inventoryAccessDetails_EditButton());
		inventoryManagamentObj.report_inventoryAccessDetails_EditButton().click();
	}

	@Then("^Fill the form for  Inventory access detail report$")
	public void fill_the_form_for_inventory_access_detail_report() throws Throwable {
//		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.report_inventoryItemDetail_ItemDescription());
//		inventoryManagamentObj.report_inventoryItemDetail_ItemDescription().click();
//		inventoryManagamentObj.report_inventoryItemDetail_ItemDescription().sendKeys(testData.get("ItemDescriptionForInvtItemDetails"));
//		inventoryManagamentObj.report_inventoryItemDetail_ItemDescription().sendKeys(Keys.ENTER);
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.report_inventoryAccessDetail_BranchName());
		inventoryManagamentObj.report_inventoryAccessDetail_BranchName().sendKeys(testData.get("BranchName"));
		inventoryManagamentObj.report_inventoryAccessDetail_BranchName().sendKeys(Keys.ENTER);
		// Calendar
//		Thread.sleep(2000);
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.report_inventoryAccessDetail_calender());
		inventoryManagamentObj.report_inventoryAccessDetail_calender().click();
		while (true) {
			try {

				waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("GL Month") + " " + testData.get("GL Year") + "')]")));
				WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("GL Month") + " " + testData.get("GL Year") + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				inventoryManagamentObj.inventoryNextMonth().click();
			}
		}
		waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//td[@aria-label='" + testData.get("GL FullMonth") + " " + testData.get("GL Date") + ", " + testData.get("GL Year") + "']/span")));
		WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("GL FullMonth") + " " + testData.get("GL Date") + ", " + testData.get("GL Year") + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
	}

	@And("^click on view button to view report$")
	public void click_on_view_button_to_view_report() throws Throwable {
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.report_viewButton());
		inventoryManagamentObj.report_viewButton().click();
	}
	
	@Then("^Click on Master reports Tab$")
	public void click_on_master_reports_Tab() throws Throwable {
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.report_MasterReportsTab());
		inventoryManagamentObj.report_MasterReportsTab().click();
	}

	// ------------------KUBS_INV_MGMT_UAT_007_002-------------------//

	@Then("^Click on Inventory Request report edit grid$")
	public void click_on_inventory_request_report_edit_grid() throws Throwable {
		javascripthelper.scrollIntoView(inventoryManagamentObj.report_inventoryRequest_Editbutton());
		inventoryManagamentObj.report_inventoryRequest_Editbutton().click();
	}

	@Then("^Fill the form for Inventory Request report$")
	public void fill_the_form_for_inventory_request_report() throws Throwable {
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.report_inventoryRequest_RequestReferenceNo());
		inventoryManagamentObj.report_inventoryRequest_RequestReferenceNo().click();
		inventoryManagamentObj.report_inventoryRequest_RequestReferenceNo().sendKeys(testData.get("RequestReferenceNumber"));
		inventoryManagamentObj.report_inventoryRequest_RequestReferenceNo().sendKeys(Keys.ENTER);
		// Calendar
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.report_inventoryRequest_calanderbutton());
		inventoryManagamentObj.report_inventoryRequest_calanderbutton().click();
		while (true) {
			try {
				waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("GL Month") + " " + testData.get("GL Year") + "')]")));
				WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("GL Month") + " " + testData.get("GL Year") + "')]"));
				break;
			}
			catch (NoSuchElementException nosuchElement) {
				inventoryManagamentObj.inventoryNextMonth().click();
			}
		}
		waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//td[@aria-label='" + testData.get("GL FullMonth") + " " + testData.get("GL Date") + ", " + testData.get("GL Year") + "']/span")));
		WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("GL FullMonth") + " " + testData.get("GL Date") + ", " + testData.get("GL Year") + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
	}

	@And("^click on view button to view report of inventory request$")
	public void click_on_view_button_to_view_report_of_inventory_request() throws Throwable {
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.report_inventoryRequest_viewbutton());
		inventoryManagamentObj.report_inventoryRequest_viewbutton().click();

	}

	// ---------------- KUBS_INV_MGMT_UAT_007_003-----------------//

	@Then("^Click on Purchase requisition report edit grid$")
	public void click_on_purchase_requisition_report_edit_grid() throws Throwable {
		javascripthelper.scrollIntoView(inventoryManagamentObj.report_PurchaseRequsition_editbutton());
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.report_PurchaseRequsition_editbutton());
		inventoryManagamentObj.report_PurchaseRequsition_editbutton().click();
	}

	@Then("^Fill the form for Purchase requisition report$")
	public void fill_the_form_for_purchase_requisition_report() throws Throwable {

		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.report_PurchaseRequsition_IndentReferenceNo());
		inventoryManagamentObj.report_PurchaseRequsition_IndentReferenceNo().click();
		inventoryManagamentObj.report_PurchaseRequsition_IndentReferenceNo().sendKeys(testData.get("IndentReferenceNo"));
		inventoryManagamentObj.report_PurchaseRequsition_IndentReferenceNo().sendKeys(Keys.ENTER);
		// Calendar
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.report_PurchaseRequsition_calanderbutton());
		inventoryManagamentObj.report_PurchaseRequsition_calanderbutton().click();
//		Thread.sleep(1000);
		for(int i=0;i<=50;i++) {
			try {
				waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[text()='" + testData.get("GL Month") + " " + testData.get("GL Year") + " ']")));
				WebElement monthAndYear = driver.findElement(By.xpath("//span[text()='" + testData.get("GL Month") + " " + testData.get("GL Year") + " ']"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				inventoryManagamentObj.inventoryNextMonth().click();
			}
		}
		
		waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(
				"//td[@aria-label='" + testData.get("GL FullMonth") + " " + testData.get("GL Date") + ", " + testData.get("GL Year") + "']/span")));
		WebElement FinalDay = driver.findElement(By.xpath(
				"//td[@aria-label='" + testData.get("GL FullMonth") + " " + testData.get("GL Date") + ", " + testData.get("GL Year") + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
	}

	@And("^Click on view button to view report of Purchase requisition report$")
	public void click_on_view_button_to_view_report_of_purchase_requisition_report() throws Throwable {
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.report_PurchaseRequsition_viewbutton());
		inventoryManagamentObj.report_PurchaseRequsition_viewbutton().click();
	}

//----------  KUBS_INV_MGMT_UAT_007_004-----------------//

	@Then("^Click on stock issuance report edit grid$")
	public void click_on_stock_issuance_report_edit_grid() throws Throwable {
		javascripthelper.scrollIntoView(inventoryManagamentObj.report_StockIssuance_editbutton());
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.report_StockIssuance_editbutton());
		inventoryManagamentObj.report_StockIssuance_editbutton().click();
	}
	
	 @Then("^Click on the Report Tab$")
	    public void click_on_the_report_tabT() throws Throwable {
	    	waithelper.waitForElementwithFluentwait(driver, arAPobj.report_Report_Button());
	    	arAPobj.report_Report_Button().click();  
	    }

	@Then("^Fill the form for stock issuance report$")
	public void fill_the_form_for_stock_issuance_report() throws Throwable {
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.report_StockIssuance_IssuanceReffrenceNo());
		inventoryManagamentObj.report_StockIssuance_IssuanceReffrenceNo().click();
		inventoryManagamentObj.report_StockIssuance_IssuanceReffrenceNo().sendKeys(testData.get("IssueReferenceNo"));
		inventoryManagamentObj.report_StockIssuance_IssuanceReffrenceNo().sendKeys(Keys.ENTER);
		// Calendar
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.report_PurchaseRequsition_calanderbutton());
		inventoryManagamentObj.report_PurchaseRequsition_calanderbutton().click();
		while (true) {
			try {

				waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("GL Month") + " " + testData.get("GL Year") + "')]")));
				WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("GL Month") + " " + testData.get("GL Year") + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				inventoryManagamentObj.inventoryNextMonth().click();
			}
		}
		waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(
				"//td[@aria-label='" + testData.get("GL FullMonth") + " " + testData.get("GL Date") + ", " + testData.get("GL Year") + "']/span")));
		WebElement FinalDay = driver.findElement(By.xpath(
				"//td[@aria-label='" + testData.get("GL FullMonth") + " " + testData.get("GL Date") + ", " + testData.get("GL Year") + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
	}

	@And("^Click on view button to view report of stock issuance report$")
	public void click_on_view_button_to_view_report_of_stock_issuance_report() throws Throwable {
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.report_StockIssuance_ViewButton());
		inventoryManagamentObj.report_StockIssuance_ViewButton().click();
	}
	
//----------KUBS_INV_MGMT_UAT_007_005------------------//
	
	 @Then("^Click on Stock Confirmation edit button$")
	    public void click_on_stock_confirmation_edit_button() throws Throwable {
	    	javascripthelper.scrollIntoView(inventoryManagamentObj.Report_report_StockConfirmationReport());
	    	waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.Report_report_StockConfirmationReport());
			inventoryManagamentObj.Report_report_StockConfirmationReport().click();    
			 
	    }

	    @Then("^Fill the details of stock confirmation$")
	    public void fill_the_details_of_stock_confirmation() throws Throwable {
	    	waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.Report_report_StockConfirmationReport_acceptStatus());
			inventoryManagamentObj.Report_report_StockConfirmationReport_acceptStatus().click();  
			inventoryManagamentObj.Report_report_StockConfirmationReport_acceptStatus().sendKeys(testData.get("AcceptStatus"));
			inventoryManagamentObj.Report_report_StockConfirmationReport_acceptStatus().sendKeys(Keys.ENTER);
			
			waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.report_PurchaseRequsition_calanderbutton());
			inventoryManagamentObj.report_PurchaseRequsition_calanderbutton().click();
//			Thread.sleep(2000);
			for (int i = 0; i <= 50; i++) {
				try {
					waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[text()='" + testData.get("GL Month") + " " + testData.get("GL Year") + " ']")));
					WebElement monthAndYear = driver.findElement(By.xpath("//span[text()='" + testData.get("GL Month") + " " + testData.get("GL Year") + " ']"));
					break;
				}
				catch (NoSuchElementException nosuchElement) {
					waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryNextMonth());
					inventoryManagamentObj.inventoryNextMonth().click();
				}
			}
			waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//td[@aria-label='" + testData.get("GL FullMonth") + " " + testData.get("GL Date") + ", " + testData.get("GL Year") + "']/span")));
			WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("GL FullMonth") + " " + testData.get("GL Date") + ", " + testData.get("GL Year") + "']/span"));
			clicksAndActionHelper.doubleClick(FinalDay);
		}
	    
		@Then("^Click on View button$")
		public void click_on_view_button() throws Throwable {
			waithelper.waitForElementwithFluentwait(driver, requestAndAllocation.Reports_Bud_Creation_ViewButton());
			requestAndAllocation.Reports_Bud_Creation_ViewButton().click();
		}
	
	
//----------KUBS_INV_MGMT_UAT_007_006------------------//
	@Then("^Click on stock return report edit grid$")
	public void click_on_stock_return_report_edit_grid() throws Throwable {
		javascripthelper.scrollIntoView(inventoryManagamentObj.report_StockReturn_EditButton());
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.report_StockReturn_EditButton());
		inventoryManagamentObj.report_StockReturn_EditButton().click();
	}

	@Then("^Fill the form for stock return report$")
	public void fill_the_form_for_stock_return_report() throws Throwable {
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.report_StockReturn_returntype_Textbox());
		inventoryManagamentObj.report_StockReturn_returntype_Textbox().click();
		inventoryManagamentObj.report_StockReturn_returntype_Textbox().sendKeys(testData.get("ReturnType"));
		inventoryManagamentObj.report_StockReturn_returntype_Textbox().sendKeys(Keys.ENTER);

		// Calendar
//		Thread.sleep(2000);
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.report_PurchaseRequsition_calanderbutton());
		inventoryManagamentObj.report_PurchaseRequsition_calanderbutton().click();
//		Thread.sleep(2000);

		while (true) {
			try {
				waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("GL Month") + " " + testData.get("GL Year") + "')]")));
				WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("GL Month") + " " + testData.get("GL Year") + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				inventoryManagamentObj.inventoryNextMonth().click();
			}
		}
		waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(
				"//td[@aria-label='" + testData.get("GL FullMonth") + " " + testData.get("GL Date") + ", " + testData.get("GL Year") + "']/span")));
		WebElement FinalDay = driver.findElement(By.xpath(
				"//td[@aria-label='" + testData.get("GL FullMonth") + " " + testData.get("GL Date") + ", " + testData.get("GL Year") + "']/span"));
		clicksAndActionHelper.doubleClick(FinalDay);
	}

	@And("^Click on view button to view report of stock return report$")
	public void click_on_view_button_to_view_report_of_stock_return_report() throws Throwable {
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.report_inventoryStockReceipt_ViewButton());
		inventoryManagamentObj.report_inventoryStockReceipt_ViewButton().click();
	}
	

	@Then("^verify the approved record is available in the report$")
	public void verify_the_approved_record_is_available_in_the_report() throws Throwable {
		try {
			browserHelper.SwitchToWindow(1);
			waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.report_AutoGeneratedDocument());
			boolean result = inventoryManagamentObj.report_AutoGeneratedDocument().isDisplayed();
			System.out.println("Report is generated : "+ result);

		} catch (Exception e) {
			Assert.fail("Report is not generated");
		}
		browserHelper.switchToParentWithChildClose();
		
	}
	
	@Then("^click on report button$")
	public void click_on_report_button() throws Throwable {
		// -----------CLICK ON REPORT ICON----------------//
//		Thread.sleep(500);
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryReportIcon());
		inventoryManagamentObj.inventoryReportIcon().click();
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryEnquiryMenu());
		Assert.assertTrue(inventoryManagamentObj.inventoryEnquiryMenu().isDisplayed());

	}

//--------------------------------------------------------------------------//
	@Then("^select data set ID for inventory access details report$")
	public void select_data_set_id_for_inventory_access_details_report() throws Throwable {
		dataSetID = "KUBS_INV_MGMT_UAT_007_001_D1";
		testData = excelData.getTestdata(dataSetID);
	}

	@Then("^select data set ID for inventory request report$")
	public void select_data_set_id_for_inventory_request_report() throws Throwable {
		dataSetID = "KUBS_INV_MGMT_UAT_007_002_D1";
		testData = excelData.getTestdata(dataSetID);
	}

	@Then("^select data set ID for Purchase requisition report$")
	public void select_data_set_id_for_purchase_requisition_report() throws Throwable {
		dataSetID = "KUBS_INV_MGMT_UAT_007_003_D1";
		testData = excelData.getTestdata(dataSetID);
	}

	@Then("^select data set ID for stock issuance report$")
	public void select_data_set_id_for_stock_issuance_report() throws Throwable {
		dataSetID = "KUBS_INV_MGMT_UAT_007_004_D1";
		testData = excelData.getTestdata(dataSetID);
	}

	@Then("^select data set ID for stock confirmation report$")
	public void select_data_set_id_for_stock_confirmation_report() throws Throwable {
		dataSetID = "KUBS_INV_MGMT_UAT_007_005_D1";
		testData = excelData.getTestdata(dataSetID);
	}
	
	@Then("^select data set ID for stock return report$")
	public void select_data_set_id_for_stock_return_report() throws Throwable {
		dataSetID = "KUBS_INV_MGMT_UAT_007_006_D1";
		testData = excelData.getTestdata(dataSetID);
	}

}
