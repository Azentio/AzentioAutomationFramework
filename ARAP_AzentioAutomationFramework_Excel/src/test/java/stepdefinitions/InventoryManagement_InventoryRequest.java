package stepdefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import dataProvider.ConfigFileReader;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.RadioButtonHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.InventoryManagement_InventoryStockReceiptObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_LoginObj;
import pageobjects.KUBS_ReviewerObj;
import pageobjects.Azentio_CheckerObj;
import pageobjects.Azentio_LoginObj;
import pageobjects.Azentio_ReviewerObj;
import pageobjects.BUDGET_BudgetTransferObj;
import pageobjects.InventoryManagamentObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;
import utilities.ExtentTestManager;

public class InventoryManagement_InventoryRequest extends BaseClass {
	WebDriver driver = BaseClass.driver;
	ConfigFileReader configFileReader = new ConfigFileReader();
	DropDownHelper dropDownHelper;
	WaitHelper waithelper = new WaitHelper(driver);
	// maker//
	KUBS_Login login;
	JavascriptHelper javaScriptHelper = new JavascriptHelper();
	InventoryManagement_InventoryStockReceiptObj inventoryManagement_InventoryStockReceiptObj = new InventoryManagement_InventoryStockReceiptObj(driver);
	InventoryManagamentObj inventoryManagamentObj = new InventoryManagamentObj(driver);
	BUDGET_BudgetTransferObj budgetTransferObj = new BUDGET_BudgetTransferObj(driver);
	KUBS_ReviewerObj reviewer = new KUBS_ReviewerObj(driver);
	KUBS_CheckerObj checkerObj = new KUBS_CheckerObj(driver);
//	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
//	JsonDataReaderWriter reader = new JsonDataReaderWriter();
	RadioButtonHelper radioButtonHelper = new RadioButtonHelper(driver);
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
//	Azentio_ReviewerObj reviewer;
	BrowserHelper browserHelper;
	String referance_id;
	String user = "Maker";
	Azentio_CheckerObj kubschecker = new Azentio_CheckerObj(driver);
	ConfigFileReader config = new ConfigFileReader();

	ExcelData excelData = new ExcelData("C:\\Users\\ININDC00091\\git\\AzentioAutomationFramework\\DeveshFW_Excel\\ARAP_AzentioAutomationFramework_Excel\\Test-data\\KUBS_InventoryMgmt_TestData.xlsx",
			"InventoryManagementTestData", "Data Set ID");
	Map<String, String> testData = new HashMap<>();
	String dataSetID;

	@Then("^Click on Inventory Management$")
	public void click_on_inventory_management() throws InterruptedException {
		javaScriptHelper.JavaScriptHelper(driver);
		Thread.sleep(2000);
		javaScriptHelper.scrollIntoViewAndClick(inventoryManagement_InventoryStockReceiptObj.inventoryManagement_InventoryStockReceipt_InventoryManagementField());

	}

	@And("^Click on the eye icon of Inventory Request$")
	public void click_on_the_eye_icon_of_inventory_request() throws Throwable {
//			waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryManagament_InventoryRequest_EyeButton());
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryManagament_InventoryRequest_EyeButton());
		inventoryManagamentObj.inventoryManagament_InventoryRequest_EyeButton().click();
//			inventoryManagamentObj.inventoryManagament_InventoryRequest_EyeButton().click();
	}

	@Then("^Click on Add button$")
	public void click_on_add_button() throws Throwable {
//			waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryManagament_InventoryRequest_AddButton());
//			inventoryManagamentObj.inventoryManagament_InventoryRequest_AddButton().click();
		Thread.sleep(2000);
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryManagament_InventoryRequest_AddButton());
		inventoryManagamentObj.inventoryManagament_InventoryRequest_AddButton().click();
	}

	@And("^Fill all the mandatory fields$")
	public void fill_all_the_mandatory_fields() throws Throwable {
//		inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");

//		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventoryManagament_InventoryRequest_BranchCode());
		waithelper.waitForElementToVisibleWithFluentWait(driver, inventoryManagamentObj.inventoryManagament_InventoryRequest_BranchCode(), 20, 2);
		inventoryManagamentObj.inventoryManagament_InventoryRequest_BranchCode().click();
		inventoryManagamentObj.inventoryManagament_InventoryRequest_BranchCode().sendKeys(testData.get("BranchCode"));
		inventoryManagamentObj.inventoryManagament_InventoryRequest_BranchCode().sendKeys(Keys.ENTER);
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventoryManagament_InventoryRequest_ItemCodeDescriptionButton());
		inventoryManagamentObj.inventoryManagament_InventoryRequest_ItemCodeDescriptionButton().click();
		Thread.sleep(1000);

//		radioButtonHelper.radioButton(testData.get("ItemCodeDescription"));
		String beforexpath = "//button[";
		String afterxpath = "]/div/div[2]";
		List<WebElement> radioitem = driver.findElements(By.xpath("//button/div/div[1]"));
		int size = radioitem.size();
		System.out.println(size);
		for (int i = 1; i <= size; i++) {
			if (driver.findElement(By.xpath(beforexpath + i + afterxpath)).getText().equals(testData.get("ItemCodeDescription"))) {
				String beforexpath1 = "//button[";
				String afterxpath1 = "]/div/div[1]";
				driver.findElement(By.xpath(beforexpath1 + i + afterxpath1)).click();
				break;
			}
		}

		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryManagament_InventoryRequest_AlertOkButton());
		inventoryManagamentObj.inventoryManagament_InventoryRequest_AlertOkButton().click();
			
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryManagament_InventoryRequest_RequestTypeButton());
		inventoryManagamentObj.inventoryManagament_InventoryRequest_RequestTypeButton().click();
//			Thread.sleep(1000);
//			waithelper.waitForElement(driver, 3000,inventoryManagamentObj.inventoryManagament_InventoryRequest_RequestTypeNormalRadioButton());
		while (true) {
			try {
				waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryManagament_InventoryRequest_RequestTypeNormalRadioButton());
				inventoryManagamentObj.inventoryManagament_InventoryRequest_RequestTypeNormalRadioButton().click();
				waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryManagament_InventoryRequest_AlertOkButton());
				inventoryManagamentObj.inventoryManagament_InventoryRequest_AlertOkButton().click();
				break;
			} catch (StaleElementReferenceException se) {

			}
		}
//			waithelper.waitForElement(driver, 2000,inventoryManagamentObj.inventoryManagament_InventoryRequest_RequestQty());
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryManagament_InventoryRequest_RequestQty());
		inventoryManagamentObj.inventoryManagament_InventoryRequest_RequestQty().click();
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventoryManagament_InventoryRequest_RequestQty());
		inventoryManagamentObj.inventoryManagament_InventoryRequest_RequestQty().sendKeys(testData.get("RequestQty"));

	}

	@Then("^Click on save button$")
	public void click_on_save_button() throws Throwable {

//		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventoryManagament_InventoryRequest_SaveButton());
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryManagament_InventoryRequest_SaveButton());
		inventoryManagamentObj.inventoryManagament_InventoryRequest_SaveButton().click();
		
//		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.inventoryManagament_InventoryRequest_PopupCloseButton());
		waithelper.waitForElementToVisibleWithFluentWait(driver, inventoryManagamentObj.inventoryManagament_InventoryRequest_PopupCloseButton2(), 20, 2);
		inventoryManagamentObj.inventoryManagament_InventoryRequest_PopupCloseButton2().click();
		
		waithelper.waitForElementToVisibleWithFluentWait(driver, inventoryManagamentObj.inventoryManagament_InventoryRequest_PopupCloseButton(), 20, 2);
		inventoryManagamentObj.inventoryManagament_InventoryRequest_PopupCloseButton().click();
		
		
		// javascripthelper.JavaScriptHelper(driver);
		// String str = javascripthelper.executeScript("return
		// document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText").toString();
		// System.out.println("Message:" + str);

	}

	@Then("^Click Notification button$")
	public void click_notification_button() throws Throwable {
//		Thread.sleep(2000);
		waithelper.waitForElementwithFluentwait(driver, budgetTransferObj.budget_BudgetTransfer_NotificationIcon());
		budgetTransferObj.budget_BudgetTransfer_NotificationIcon().click();

	}

	@And("^Select record which we saved$")
	public void select_record_which_we_saved() throws Throwable {
		// Reference
		waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_FirstReferenceId());
		String id = budgetTransferObj.budget_BudgetTransfer_FirstReferenceId().getText();
//		jsonWriter.addReferanceData(id);
		
		excelData.updateTestData(dataSetID, "ReferenceID", id);
		testData = excelData.getTestdata(dataSetID);
		
		System.out.println("Reference ID:" + id);
		Thread.sleep(1000);
		for (int i = 1; i <= 35; i++) {
			try {
//					waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]")));
				waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]")));
				WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]"));
				referanceID.click();
				System.out.println(referanceID);
				// Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElement(driver, 4000, budgetTransferObj.maker_notification_next_button());

				budgetTransferObj.maker_notification_next_button().click();
			}

			waithelper.waitForElement(driver, 4000, budgetTransferObj.maker_notification_next_button());

			budgetTransferObj.maker_notification_next_button().click();
		}
		budgetTransferObj.budget_BudgetTransfer_FirstReferenceId().click();

		// Action-Pencil
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

		waithelper.waitForElement(driver, 10000, driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)));
		driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)).click();

//		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryManagament_InventoryRequest_PopupCloseButton());
//		inventoryManagamentObj.inventoryManagament_InventoryRequest_PopupCloseButton().click();

	}

	@And("^Submit the record$")
	public void submit_the_record() throws Throwable {

		// Submit button
		// Thread.sleep(2000);
//		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.accountPayable_SubmitButton());
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.accountPayable_SubmitButton());
		inventoryManagamentObj.accountPayable_SubmitButton().click();
		// budgetTransferObj.budget_BudgetTransfer_Submit().click();
		javaScriptHelper.JavaScriptHelper(driver);
		// Remark
		// javahelper.JSEClick(inventoryManagamentObj.accountPayable_SubmitButton());
		/*
		 * inventoryManagamentObj.accountPayable_SubmitButton().isDisplayed(); boolean
		 * result = inventoryManagamentObj.accountPayable_SubmitButton().isEnabled();
		 * System.out.println(result); while(true) { try {
		 * //inventoryManagamentObj.accountPayable_SubmitButton().click(); WebElement
		 * submitButton = (WebElement) javahelper.
		 * executeScript("return document.getElementsByClassName('ion-color ion-color-primary md button button-clear in-toolbar ion-activatable ion-focusable hydrated')[1]"
		 * ); submitButton.click(); break; } catch(ElementNotInteractableException e) {
		 * System.out.println(e.getMessage()); } }
		 */
//			Thread.sleep(2000);
		WebElement element = WaitHelper.waitForElementwithFluentwait(driver, budgetTransferObj.budget_BudgetTransfer_RemarkField());
		element.click();
//			javahelper.JSEClick(budgetTransferObj.budget_BudgetTransfer_RemarkField());
		WebElement element1 = WaitHelper.waitForElementwithFluentwait(driver, budgetTransferObj.budget_BudgetTransfer_RemarkField());
		element1.sendKeys("ok");

//			budgetTransferObj.budget_BudgetTransfer_RemarkField().sendKeys("OK");

		// Remark Submit
		waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_SubmitByMaker());
		budgetTransferObj.budget_BudgetTransfer_SubmitByMaker().click();
//			Thread.sleep(2000);
		waithelper.waitForElementwithFluentwait(driver, budgetTransferObj.budget_BudgetTransfer_RecordStatus());
		WebElement recordstatus = budgetTransferObj.budget_BudgetTransfer_RecordStatus();

		clicksAndActionHelper.moveToElement(recordstatus);
		String message = budgetTransferObj.budget_BudgetTransfer_RecordStatus().getText();
		System.out.println(message);
		budgetTransferObj.budget_BudgetTransfer_RecordStatus().click();
		String emptystring = "";
		String ar[] = message.split(" ");
		emptystring = ar[ar.length - 1];
		String reviewerId = emptystring.replaceAll("[/.]", "");
//		String t = "";
//		String ar[] = message.split(" ");
//		Thread.sleep(2000);
//		for (int i = ar.length - 1; i >= 0; i--) {
//			t = ar[ar.length - 1];
//		}
//		String reviewerId = "";
//		for (int i = 0; i < t.length() - 1; i++) {
//			if (t.charAt(i) == '.') {
//			} else {
//				reviewerId = reviewerId + t.charAt(i);
//			}
//		}
		System.out.println(reviewerId);
		
		excelData.updateTestData(dataSetID, "ReviewerID", reviewerId);
		testData = excelData.getTestdata(dataSetID);
		
//		jsonWriter = new JsonDataReaderWriter();
//		jsonWriter.addData(reviewerId);

	}

	@Then("^Open Reviewer account$")
	public void open_reviewer_account() throws Throwable {
//		reader = new JsonDataReaderWriter();
		login = new KUBS_Login(driver);
		driver.get(config.getApplicationUrl());
		login.logintoAzentioappReviewer("Reviewer", testData.get("ReviewerID"));
		ExtentTestManager.getTest().info("User Navigated to required url & login as checker1");

	}

	@And("^Click on notification$")
	public void click_on_notification() throws Throwable {
		reviewer = new KUBS_ReviewerObj(driver);
		Thread.sleep(1000);
		waithelper.waitForElementwithFluentwait(driver, reviewer.reviewerNotidicationIcon());
		reviewer.reviewerNotidicationIcon().click();
		browserHelper = new BrowserHelper(driver);
		javaScriptHelper = new JavascriptHelper();
		waithelper = new WaitHelper(driver);
//		Thread.sleep(2000);
		for (int i = 1; i <= 50; i++) {
			try {
//					waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[text()='" + reader.readReferancedata() + "']")));
				waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[text()='" + testData.get("ReferenceID") + "']")));
				WebElement referanceID = driver.findElement(By.xpath("//span[text()='" + testData.get("ReferenceID") + "']"));
				referanceID.click();

				Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
//					waithelper.waitForElement(driver, 4000, kubschecker.checker_notification_next_button());
//				waithelper.waitForElementwithFluentwait(driver, kubschecker.checker_notification_next_button());
//				kubschecker.checker_notification_next_button().click();
			}
		}
		String before_xpath = "//span[text()='";
		String after_xpath = "']/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

//			waithelper.waitForElement(driver, 10000,driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)));
		waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)));
		driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)).click();

	}

	@Then("^Approve the record which we submitted from maker stage$")
	public void approve_the_record_which_we_submitted_from_maker_stage() throws Throwable {
//			waithelper.waitForElement(driver, 2000, reviewer.reviewerApproveButton());
		WaitHelper.waitForElementwithFluentwait(driver, reviewer.reviewerApproveButton());
		reviewer.reviewerApproveButton().click();
//			waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertRemarks());
		waithelper.waitForElementwithFluentwait(driver, reviewer.reviewerAlertRemarks());
		reviewer.reviewerAlertRemarks().sendKeys("ok");
//			waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertSubmitButton());
		waithelper.waitForElementwithFluentwait(driver, reviewer.reviewerAlertSubmitButton());
		reviewer.reviewerAlertSubmitButton().click();
		Thread.sleep(3000);
	}

	@Then("^Go to Checker account$")
	public void go_to_checker_account() throws Throwable {
		login = new KUBS_Login(driver);
		driver.get(config.getApplicationUrl());
		login.loginToAzentioAppAsChecker("Checker");
		ExtentTestManager.getTest().info("User Navigated to required url & login as reviewer1");

	}

	@And("^Clam the record$")
	public void clam_the_record() throws Throwable {
		waithelper = new WaitHelper(driver);
		checkerObj = new KUBS_CheckerObj(driver);
		waithelper.waitForElement(driver, 3000, kubschecker.checkerSecurityManagement());
		kubschecker.checkerSecurityManagement().click();
		waithelper.waitForElement(driver, 3000, kubschecker.checkerActionIcon());

		kubschecker.checkerActionIcon().click();
		Thread.sleep(2000);
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		waithelper.waitForElement(driver, 5000, driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath_claim)));
		driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath_claim)).click();
		waithelper.waitForElement(driver, 3000, kubschecker.checkerAlertClose());
		kubschecker.checkerAlertClose().click();

	}

	@Then("^Click on notification and approve the record$")
	public void click_on_notification_and_approve_the_record() throws Throwable {
		javaScriptHelper = new JavascriptHelper();
		Thread.sleep(1500);
//			waithelper.waitForElement(driver, 3000, kubschecker.checkerNotificationIcon());
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerNotificationIcon());
		kubschecker.checkerNotificationIcon().click();
//			Thread.sleep(3000);
		while (true) {
			try {
				waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]")));
				break;
			} catch (NoSuchElementException ne) {

			}
		}
		Thread.sleep(1500);
		for (int i = 1; i <= 35; i++) {
			try {
//					waithelper.waitForElement(driver, 3000,driver.findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]")));
				waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]")));
				WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("ReferenceID") + "')]"));
				referanceID.click();

				Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElement(driver, 4000, kubschecker.checker_notification_next_button());
				kubschecker.checker_notification_next_button().click();
			}
		}
		// span[contains(text(),'25')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

//			waithelper.waitForElement(driver, 10000,driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)));
		waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)));
		driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)).click();

//			waithelper.waitForElement(driver, 4000, kubschecker.checkerApproveButton());
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerApproveButton());
		kubschecker.checkerApproveButton().click();
//			waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertRemarks());
		waithelper.waitForElementwithFluentwait(driver, reviewer.reviewerAlertRemarks());
		reviewer.reviewerAlertRemarks().sendKeys("ok");
//			Thread.sleep(1000);
		waithelper.waitForElementwithFluentwait(driver, reviewer.reviewerAlertSubmitButton());
//			waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertSubmitButton());
		reviewer.reviewerAlertSubmitButton().click();
		Thread.sleep(3000);
	}

	@Then("^select data set ID for Inventory Request$")
	public void select_data_set_id_for_inventory_request() throws Throwable {
		dataSetID = "KUBS_INV_MGMT_UAT_001_001_D1";
		testData = excelData.getTestdata(dataSetID);
	}
	@Then("^update data set ID for Inventory Request for reviewer$")
	public void update_data_set_id_for_inventory_request_for_reviewer() throws Throwable {
		dataSetID = "KUBS_INV_MGMT_UAT_001_001_D1";
		testData = excelData.getTestdata(dataSetID);
	}
	@Then("^update data set ID for Inventory Request for checker$")
	public void update_data_set_id_for_inventory_request_for_checker() throws Throwable {
		dataSetID = "KUBS_INV_MGMT_UAT_001_001_D1";
		testData = excelData.getTestdata(dataSetID);
	}

}
