package stepdefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
import pageobjects.InventoryMaintenanceObj;
import pageobjects.KUBS_CheckerObj;
import resources.BaseClass;
import resources.ExcelData;
//InventoryItemCode
public class InventoryMaintenance extends BaseClass {
	WebDriver driver = BaseClass.driver;
	ConfigFileReader configFileReader = new ConfigFileReader();
	ConfigFileReader config = new ConfigFileReader();
	DropDownHelper dropDownHelper;
	WaitHelper waithelper = new WaitHelper(driver);
	// maker//
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(driver);

	JavascriptHelper javascripthelper = new JavascriptHelper();
	KUBS_Login login = new KUBS_Login(driver);
	InventoryMaintenanceObj inventoryMaintenanceObj = new InventoryMaintenanceObj(driver);
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	BrowserHelper browserHelper;
	String referance_id;
	String user = "Maker";
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	ExcelData excelData = new ExcelData(
			"C:\\Users\\ININDC00089\\git\\AzentioAutomationFramework\\ArAp\\AzentioAutomationFramework_ARAP_Excel\\Test-data\\KUBSTestData.xlsx",
			"InventoryItemCode", "DataSet ID");
	Map<String, String> testData = new HashMap<>();

	// getVendorPurchaseOrderyByName

	/*
	 * @Then("^Click on Direction icon$") public void click_on_direction_icon()
	 * throws InterruptedException { waithelper = new WaitHelper(driver) ;
	 * Thread.sleep(2000); waithelper.waitForElement(driver, 4000,
	 * accountPayable_VendorPurchaseOrderObj.
	 * accountsPayable_VendorPurchaseOrder_DirectionIcon());
	 * accountPayable_VendorPurchaseOrderObj.
	 * accountsPayable_VendorPurchaseOrder_DirectionIcon().click();
	 * 
	 * }
	 */
//	@Then("^Click on Direction Left$")
//	public void click_on_direction_left() {
//		waithelper = new WaitHelper(driver);
//		waithelper.waitForElement(driver, 3000,
//				inventoryMaintenanceObj.inventoryMaintenance_InventoryMaintenanceDirectionLeft());
//		inventoryMaintenanceObj.inventoryMaintenance_InventoryMaintenanceDirectionLeft().click();
//
//	}

	@And("^user update the data set ID for Inventory item code$")
	public void user_update_the_data_set_id_for_inventory_item_code() throws Throwable {
		testData = excelData.getTestdata("KUBS_INV_MGMT_UAT_002_003_01_D1");
	}

	@Then("^Click on Inventory Maintenance$")
	public void click_on_inventory_maintenance() throws InterruptedException {

		waithelper.waitForElement(driver, 3000,
				inventoryMaintenanceObj.inventoryMaintenance_InventoryMaintenanceField());
		inventoryMaintenanceObj.inventoryMaintenance_InventoryMaintenanceField().click();

	}

	@Then("^Click on Inventory Item Master Eye Icon$")
	public void click_on_inventory_item_master_eye_icon() {
		for(int i=1; i<=10; i++) {
			try {
		
		clicksAndActionHelper.moveToElement(inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_EyeButton());
		
		waithelper.waitForElement(driver, 3000, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_EyeButton());
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_EyeButton().click();
		break;
	}
	catch(Exception e) {}
	}}

	@Then("^Click on Inventory Maintenance Add button$")
	public void click_on_inventory_maintenance_add_button() throws InterruptedException {
//		    Thread.sleep(2000);
//		    waithelper.waitForElement(driver, 3000, inventoryMaintenanceObj.inventoryMaintenance_AddButton());
		waithelper.waitForElementwithFluentwait(driver, inventoryMaintenanceObj.inventoryMaintenance_AddButton());
		inventoryMaintenanceObj.inventoryMaintenance_AddButton().click();

	}

	@Then("^Fill Inventory Item Mandatory fields$")
	public void fill_inventory_item_mandatory_fields() throws InterruptedException {

		inventoryMaintenanceObj = new InventoryMaintenanceObj(driver);

		// Branch Code
		waithelper.waitForElement(driver, 3000,
				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_BranchCode());
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_BranchCode().click();
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_BranchCode().sendKeys(testData.get("BranchCode"));
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_BranchCode().sendKeys(Keys.ENTER);

		// Item Code
		waithelper.waitForElement(driver, 3000, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ItemCode());
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ItemCode().click();
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ItemCode().sendKeys(testData.get("ItemCode"));
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ItemCode().sendKeys(Keys.ENTER);

		// Item Description
		waithelper.waitForElement(driver, 3000,
				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ItemDescription());
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ItemDescription().click();
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ItemDescription()
				.sendKeys(testData.get("ItemDescription"));
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ItemDescription().sendKeys(Keys.ENTER);

		// Item Short Description
		
		
		
		waithelper.waitForElement(driver, 3000,
				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ItemShortDescription());
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ItemShortDescription().click();
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ItemShortDescription()
				.sendKeys(testData.get("ItemShortDescription"));
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ItemShortDescription().sendKeys(Keys.ENTER);
		

		// Instrument Code
		waithelper.waitForElement(driver, 3000,
				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_InstrumentCode());
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_InstrumentCode().click();
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_InstrumentCode()
				.sendKeys(testData.get("InstrumentCode"));
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_InstrumentCode().sendKeys(Keys.ENTER);

		// Currency Code
		waithelper.waitForElement(driver, 3000,
				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_CurrencyCode());
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_CurrencyCode().click();
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_CurrencyCode()
				.sendKeys(testData.get("CurrencyCode"));
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_CurrencyCode().sendKeys(Keys.ENTER);

		// Reorder Level
		waithelper.waitForElement(driver, 3000,
				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReorderLevel());
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReorderLevel().click();
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReorderLevel()
				.sendKeys(testData.get("ReorderLevel"));
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReorderLevel().sendKeys(Keys.ENTER);

		// Excess Level
		waithelper.waitForElement(driver, 3000,
				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ExcessLevel());
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ExcessLevel().click();
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ExcessLevel().sendKeys(testData.get("ExcessLevel"));
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ExcessLevel().sendKeys(Keys.ENTER);

		// Reorder Qty
		waithelper.waitForElement(driver, 3000,
				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReorderQty());
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReorderQty().click();
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReorderQty().sendKeys(testData.get("ReorderQty"));
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReorderQty().sendKeys(Keys.ENTER);

		/*
		 * //CurrentBalanceQuantity waithelper.waitForElement(driver, 3000,
		 * inventoryMaintenanceObj.
		 * inventoryMaintenance_InventoryItem_CurrentBalanceQuantity());
		 * inventoryMaintenanceObj.
		 * inventoryMaintenance_InventoryItem_CurrentBalanceQuantity().click();
		 * inventoryMaintenanceObj.
		 * inventoryMaintenance_InventoryItem_CurrentBalanceQuantity().sendKeys(
		 * inventoryMaintenanceTestDataType.CurrentBalanceQuantity);
		 * inventoryMaintenanceObj.
		 * inventoryMaintenance_InventoryItem_CurrentBalanceQuantity().sendKeys(Keys.
		 * ENTER);
		 * 
		 * //Qc Required waithelper.waitForElement(driver, 3000,
		 * inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_QcRequired());
		 * inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_QcRequired().click
		 * ();
		 * 
		 * //Fill Indicator waithelper.waitForElement(driver, 3000,
		 * inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_FillIndicator());
		 * inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_FillIndicator().
		 * click();
		 */
	}

	@Then("^Click on Inventory Item Save button$")
	public void click_on_inventory_item_save_button() throws InterruptedException {

		// save
		waithelper.waitForElement(driver, 2000, inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_Save());
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_Save().click();
//		   	Thread.sleep(2000);
		waithelper.waitForElementwithFluentwait(driver,
				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RecordStatus());
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RecordStatus().click();
//		    javascripthelper.JavaScriptHelper(driver);
//		    String str = javascripthelper.executeScript("return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText").toString();
//		    System.out.println("Message:" +str);
	}

	@Then("^Click on Inventory Item Notification$")
	public void click_on_inventory_item_notification() {
		// Notification
		waithelper.waitForElement(driver, 2000,
				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_MakerNotification());
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_MakerNotification().click();

	}

	@And("^user update the data set ID for Inventory item code Reviewer$")
	public void user_update_the_data_set_id_for_inventory_item_code_reviewer() throws Throwable {
		testData = excelData.getTestdata("KUBS_INV_MGMT_UAT_002_003_02_D1");
	}

    @And("^User login as a reviewer user for Inventory item code$")
    public void user_login_as_a_reviewer_user_for_inventory_item_code() throws Throwable {
    	login = new KUBS_Login(driver);
		driver.get(config.getApplicationUrl());
		login.logintoAzentioappReviewer("Reviewer", testData.get("ReviewerID"));
    }

	@And("^Select and Submit the record$")
	public void select_and_submit_the_record() throws InterruptedException, IOException, ParseException {
		
		waithelper.waitForElement(driver, 2000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId());
		String Reference_Id = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_FirstReferenceId()
				.getText();

		excelData.updateTestData("KUBS_INV_MGMT_UAT_002_003_02_D1", "ReferenceID", Reference_Id);

		System.out.println("ReferenceID:" + Reference_Id);

		for (int i = 1; i <= 199; i++) {
			try {
				waithelper.waitForElement(driver, 2000,
						aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ActionButton());
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ActionButton().click();

				break;
			} catch (Exception e) {
				if (i == 199) {
					Assert.fail(e.getMessage());
				}
			}
		}

		waithelper.waitForElement(driver, 4000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_SubmitButton().click();
//		    	Thread.sleep(1000);
//		    	waithelper.waitForElement(driver, 4000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());
		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());
	//	javascripthelper.JSEClick(aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField());
		for (int i = 1; i <=199; i++) {
			try {
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField().click();
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RemarkField()
				.sendKeys(testData.get("MakerAlertRemark"));
		break;
			}
			catch(Exception e) {
				if (i==199) {
					Assert.fail(e.getMessage());
				}
			}
			}
		waithelper.waitForElement(driver, 4000,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit().click();

//		    	Thread.sleep(1000);
//		    	waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
		WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
		clicksAndActionHelper.moveToElement(recordstatus);

		String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
		System.out.println(message);
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();
		String emptystring = "";
		String ar[] = message.split(" ");
		emptystring = ar[ar.length - 1];
		String reviewerId = emptystring.replaceAll("[/.]", "");
		System.out.println(reviewerId);
		excelData.updateTestData("KUBS_INV_MGMT_UAT_002_003_02_D1", "ReviewerID", reviewerId);

	}

	@Then("^click on the Notification select the record and Approve$")
	public void click_on_the_notification_select_the_record_and_approve()
			throws InterruptedException, IOException, ParseException {
		browserHelper = new BrowserHelper(driver);
		String after_xpath_for_action = "]/datatable-body-row/div/datatable-body-cell[1]/div/ion-buttons/ion-button";
		Thread.sleep(1000);
		for (int i = 1; i < 35; i++) {

			try {
				waithelper.waitForElement(driver, 3000,
						driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]")));
				WebElement referanceID = driver
						.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]"));
				referanceID.click();
				Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElement(driver, 4000, kubschecker.checker_notification_next_button());

				kubschecker.checker_notification_next_button().click();
			}
		}
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

		waithelper.waitForElement(driver, 5000,
				driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)));
		driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)).click();

		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Approve_Button());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Approve_Button().click();
//							waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer());
		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer().click();

		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ApproveRemarkByReviewer()
				.sendKeys(testData.get("ReviewerAlertRemark"));
//							waithelper.waitForElement(driver, 3000, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_Submit().click();
//							Thread.sleep(2000);
		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
		WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
		clicksAndActionHelper.moveToElement(recordstatus);
		String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
		System.out.println(message);
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();

	}
	@And("^Click on claim button for Inventory item code$")
    public void click_on_claim_button_for_inventory_item_code() throws Throwable {
		//testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_001_TC_001_01_D1");
    	String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		//String after_xpath = ;
		//waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath_claim)));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(before_xpath+testData.get("ReferenceID")+after_xpath_claim)).click();
    
    }


	@And("^select the Inventory item code record and Approve by checker$")
    public void select_the_inventory_item_code_record_and_approve_by_checker() throws InterruptedException, IOException, ParseException {
		Thread.sleep(2000);
		// testData = excelData.getTestdata("KUBS_AR/AP_UAT_001_001_TC_001_01_D1");
		for (int i = 1; i <= 35; i++) {
			try {
//								waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" +reader.readReferancedata()+ "')]")));
				waithelper.waitForElementwithFluentwait(driver,
						driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]")));
				WebElement referanceID = driver
						.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]"));
				referanceID.click();
				Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElement(driver, 4000, kubschecker.checker_notification_next_button());
				kubschecker.checker_notification_next_button().click();
			}
		}
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

//								waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath(before_xpath +reader.readReferancedata()+after_xpath)));
		waithelper.waitForElementwithFluentwait(driver,
				driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)));
		driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)).click();

//							waithelper.waitForElement(driver, 2000, kubschecker.checkerApproveButton());
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerApproveButton());
		kubschecker.checkerApproveButton().click();
//							waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerRemarks());
		kubschecker.checkerRemarks().sendKeys(testData.get("CheckerAlertRemark"));
//							waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();
//							Thread.sleep(2000);
		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus());
		WebElement recordstatus = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus();
		clicksAndActionHelper.moveToElement(recordstatus);
		String message = aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().getText();
		System.out.println(message);
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_RecordStatus().click();

	}

}
