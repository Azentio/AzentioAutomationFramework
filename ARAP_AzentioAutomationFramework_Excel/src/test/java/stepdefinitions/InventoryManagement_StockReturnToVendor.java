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
import pageobjects.KUBS_ReviewerObj;
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
	JavascriptHelper javascripthelper = new JavascriptHelper(driver);
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	BrowserHelper browserHelper;
	KUBS_ReviewerObj reviewer = new KUBS_ReviewerObj(driver);
	InventoryManagamentObj inventoryManagamentObj = new InventoryManagamentObj(driver);
	

	ExcelData excelData = new ExcelData("C:\\Users\\ININDC00091\\git\\AzentioAutomationFramework\\DeveshFW_Excel\\ARAP_AzentioAutomationFramework_Excel\\Test-data\\KUBS_InventoryMgmt_TestData.xlsx",
			"StockReturnToVendorTestData", "Data Set ID");
	Map<String, String> testData = new HashMap<>();
	String dataSetID;
	
	@And("^Click on stock return to vendor SubModule Eye icon$")
	public void click_on_stock_return_to_vendor_submodule_eye_icon() throws Throwable {
		// ---------TO VIEW THE stock return to vendor Eye icon----------//
		javascripthelper.scrollIntoView(inventoryManagamentObj.inventoryStockReturnBranchEye());
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryStockReturnBranchEye());
		inventoryManagamentObj.inventoryStockReturnBranchEye().click();
	}
	
	@Then("^Click on stock return to vendor Add icon$")
	public void click_on_stock_return_to_vendor_add_icon() throws Throwable {
		// ---------TO VIEW THE stock return to vendor Add icon----------//
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventoryStockReturnBranchAdd());
		inventoryManagamentObj.inventoryStockReturnBranchAdd().click();
	}
	
	@And("^Click on Request Referance No code$")
	public void click_on_request_referance_no_code() throws Throwable {
		// ---------TO Enter Request Referance No code----------//
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryRequestReferanceNumber());
		inventoryManagamentObj.inventoryRequestReferanceNumber().click();
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryRequestReferanceNumber());
		inventoryManagamentObj.inventoryRequestReferanceNumber().sendKeys(testData.get("RequestReferanceNo"));
//		Thread.sleep(500);
		inventoryManagamentObj.inventoryRequestReferanceNumber().sendKeys(Keys.ENTER);
	}

	@Then("^Click on Issue Referance No code$")
	public void click_on_issue_referance_no_code() throws Throwable {
		// ---------TO VIEW THE Issue Referance No code----------//
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryIssueReferanceNo());
		inventoryManagamentObj.inventoryIssueReferanceNo().click();
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryIssueReferanceNo());
		inventoryManagamentObj.inventoryIssueReferanceNo().sendKeys(Keys.DOWN);
//		Thread.sleep(500);
		inventoryManagamentObj.inventoryIssueReferanceNo().sendKeys(Keys.ENTER);
	}
	
	@And("^Click on item code$")
	public void click_on_item_code() throws Throwable {
		// ---------TO VIEW THE item code----------//
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryItemCode());
		inventoryManagamentObj.inventoryItemCode().click();
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryItemCode());
		inventoryManagamentObj.inventoryItemCode().sendKeys(Keys.DOWN);
//		Thread.sleep(500);
		inventoryManagamentObj.inventoryItemCode().sendKeys(Keys.ENTER);
		
	}

	@And("^Enter Return Quantity Stock value$")
	public void enter_return_quantity_stock_value() throws Throwable {
		// ---------TO VIEW THE Return Quantity----------//
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventoryReturnQuantity());
		inventoryManagamentObj.inventoryReturnQuantity().click();
		inventoryManagamentObj.inventoryReturnQuantity().sendKeys(testData.get("ReturnQuantity"));
	}


    
	@Then("^Click on Return Type and Choose Type$")
	public void click_on_return_type_and_choose_type() throws Throwable {
		// ---------TO VIEW THE Return Type----------//
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventory_ReturnType());
		inventoryManagamentObj.inventory_ReturnType().click();
		inventoryManagamentObj.inventory_ReturnType().sendKeys(testData.get("ReturnType"));
//		Thread.sleep(500);
		inventoryManagamentObj.inventory_ReturnType().sendKeys(Keys.ENTER);
	}

	@And("^Click on Return Reason and Choose Type$")
	public void click_on_return_reason_and_choose_type() throws Throwable {
		// ---------TO VIEW THE Return Reason----------//
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventory_ReturnReason());
		inventoryManagamentObj.inventory_ReturnReason().click();
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventory_ReturnReason());
		inventoryManagamentObj.inventory_ReturnReason().sendKeys(testData.get("ReturnReason"));
//		Thread.sleep(500);
		inventoryManagamentObj.inventory_ReturnReason().sendKeys(Keys.ENTER);
	}

	@Then("^Save the Inventory Stock Record$")
	public void save_the_inventory_stock_record() throws Throwable {
		// -----------SAVE THE RECORD----------------//
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventory_Save());
		inventoryManagamentObj.inventory_Save().click();
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryManagament_InventoryRequest_PopupCloseButton());
		inventoryManagamentObj.inventoryManagament_InventoryRequest_PopupCloseButton().click();
	}
	
	@And("^goto the maker Notification icon$")
	public void goto_the_maker_notification_icon() throws Throwable {
		// ------------Maker Notification icon---------//
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventory_MakerNotification());
		inventoryManagamentObj.inventory_MakerNotification().click();
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventory_ReferanceId());
		String Referance_id = inventoryManagamentObj.inventory_ReferanceId().getText();
		System.out.println(Referance_id);
		
		excelData.updateTestData(dataSetID, "ReferenceID", Referance_id);
		testData = excelData.getTestdata(dataSetID);
		
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventory_ActionButton());
		inventoryManagamentObj.inventory_ActionButton().click();

	}
	
	@Then("^Click Submit icon to Inventory Record$")
	public void click_submit_icon_to_inventory_record() throws Throwable {
		// -----------Submit Icon Inventory-----------//
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventory_Submit());
		inventoryManagamentObj.inventory_Submit().click();
	}

	@And("^Give Remark and submit Inventory field$")
	public void give_remark_and_submit_inventory_field() throws Throwable {
		// ----------ENTER THE REMARK AND SUBMIT THE RECORD-------------//
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventory_Remark());
		inventoryManagamentObj.inventory_Remark().click();
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventory_Remark());
		inventoryManagamentObj.inventory_Remark().sendKeys(testData.get("Remark"));
//		Thread.sleep(2000);
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventory_RemarkSubmit());
		inventoryManagamentObj.inventory_RemarkSubmit().click();
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventory_ReviewerId());
		String message = inventoryManagamentObj.inventory_ReviewerId().getText();
		String emptystring = "";
		String ar[] = message.split(" ");
		emptystring = ar[ar.length - 1];
		String reviewerId = emptystring.replaceAll("[/.]", "");
		
		excelData.updateTestData(dataSetID, "ReviewerID", reviewerId);
		testData = excelData.getTestdata(dataSetID);
		System.out.println(reviewerId);

	}
	
	@Then("^log in to the reviewer account to approve stock return to vendor record$")
	public void log_in_to_the_reviewer_account_to_approve_stock_return_to_vendor_record() throws IOException, ParseException {
		login = new KUBS_Login(driver);
		driver.get(config.getApplicationUrl());
		login.logintoAzentioappReviewer("Reviewer", testData.get("ReviewerID"));

	}
	
	@And("^Click on notification to approve the stock return to vendor record$")
	public void click_on_notification_to_approve_the_stock_return_to_vendor_() throws Throwable {
		waithelper.waitForElementwithFluentwait(driver, reviewer.reviewerNotidicationIcon());
		reviewer.reviewerNotidicationIcon().click();
//		Thread.sleep(2000);
		for (int i = 1; i <= 50; i++) {
			try {
				waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[text()='" + testData.get("ReferenceID") + "']")));
				WebElement referanceID = driver.findElement(By.xpath("//span[text()='" + testData.get("ReferenceID") + "']"));
				referanceID.click();
				Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				javascripthelper.scrollIntoView(kubschecker.checker_notification_next_button());
				waithelper.waitForElementwithFluentwait(driver, kubschecker.checker_notification_next_button());
				kubschecker.checker_notification_next_button().click();
			}
		}
		String before_xpath = "//span[text()='";
		String after_xpath = "']/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
		waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)));
		driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)).click();

	}
	
	@Then("^Click on notification and approve the stock return to vendors record$")
    public void click_on_notification_and_approve_the_stock_return_to_vendors_record() throws Throwable {
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerNotificationIcon());
		kubschecker.checkerNotificationIcon().click();
		while (true) {
			try {
				waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]")));
				break;
			} catch (NoSuchElementException ne) {

			}
		}
//		Thread.sleep(1500);
		for (int i = 1; i <= 35; i++) {
			try {
				waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]")));
				WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]"));
				referanceID.click();
				Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElementwithFluentwait(driver, kubschecker.checker_notification_next_button());
				kubschecker.checker_notification_next_button().click();
			}
		}
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
		waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)));
		driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)).click();

		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerApproveButton());
		kubschecker.checkerApproveButton().click();
		
		waithelper.waitForElementwithFluentwait(driver, reviewer.reviewerAlertRemarks());
		reviewer.reviewerAlertRemarks().sendKeys("ok");
		
		waithelper.waitForElementwithFluentwait(driver, reviewer.reviewerAlertSubmitButton());
		reviewer.reviewerAlertSubmitButton().click();
//		Thread.sleep(3000);
    }

    @And("^Claim the stock return to vendors record$")
    public void claim_the_stock_return_to_vendors_record() throws Throwable {
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerSecurityManagement());
		kubschecker.checkerSecurityManagement().click();
		
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerActionIcon());
		kubschecker.checkerActionIcon().click();
//		Thread.sleep(2000);
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath_claim)));
		driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath_claim)).click();
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerAlertClose());
		kubschecker.checkerAlertClose().click();
    }
    
//////////////////////////////////////////////////////////////////
	
	
	@Then("^select data set ID for checking stock return to vendor$")
    public void select_data_set_id_for_checking_stock_return_to_vendor() throws Throwable {
		dataSetID = "KUBS_INV_MGMT_UAT_006_001_TC_01_D1";
		testData = excelData.getTestdata(dataSetID);
    }
	
	@Then("^update data set ID for stock return to vendors for reviewer$")
    public void update_data_set_id_for_stock_return_to_vendors_for_reviewer() throws Throwable {
		dataSetID = "KUBS_INV_MGMT_UAT_006_001_TC_01_D1";
		testData = excelData.getTestdata(dataSetID);
    }

    @Then("^update data set ID for stock return to vendors for checker$")
    public void update_data_set_id_for_stock_return_to_vendors_for_checker() throws Throwable {
    	dataSetID = "KUBS_INV_MGMT_UAT_006_001_TC_01_D1";
		testData = excelData.getTestdata(dataSetID);
    }

}
