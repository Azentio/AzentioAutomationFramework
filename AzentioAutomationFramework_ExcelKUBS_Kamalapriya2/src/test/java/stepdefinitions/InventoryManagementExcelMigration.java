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
import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.RadioButtonHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.BUDGET_BudgetTransferObj;
import pageobjects.InventoryManagamentObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;
import testDataType.BUDGET_BudgetDefinitionTestDataType;
import testDataType.BUDGET_BudgetTransferTestDataType;
import testDataType.InventoryManagementTestDataType;
import utilities.ExtentTestManager;

public class InventoryManagementExcelMigration {
	WebDriver driver = BaseClass.driver;
	ConfigFileReader config = new ConfigFileReader();
	AzentioLogin login;
	KUBS_ReviewerObj reviewer;

	JsonConfig jsonconfig = new JsonConfig();
	BrowserHelper browserHelper = new BrowserHelper(driver);
	BUDGET_BudgetDefinitionTestDataType budgetdata;
	JavascriptHelper javahelper = new JavascriptHelper();
	JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper();
	BUDGET_BudgetTransferTestDataType budgetTransferTestDataType;
	JsonDataReaderWriter reader = new JsonDataReaderWriter();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	JsonDataReaderWriter readerData = new JsonDataReaderWriter();
	InventoryManagementTestDataType inventoryManagementTestDataType = new InventoryManagementTestDataType();
	InventoryManagamentObj inventoryManagamentObj = new InventoryManagamentObj(driver);
	ConfigFileReader configFileReader = new ConfigFileReader();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	BUDGET_BudgetTransferObj budgetTransferObj = new BUDGET_BudgetTransferObj(driver);
	String referance_id;
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	JavascriptHelper javascript;
	RadioButtonHelper radioButtonHelper = new RadioButtonHelper(driver);
	String reviwerId;
	String RefNo;
	ExcelData excelData = new ExcelData(System.getProperty("user.dir")+"\\Test-data\\KUBSTestData.xlsx","InventoryManagement","DataSet ID");
	Map<String, String> testData = new HashMap<>();
	
	@Then("^Fill all the required fields for requesting inventories$")
	public void fill_all_the_required_fields_for_requesting_inventories() throws Throwable {
		//inventoryManagementTestDataType = jsonReader.getInventoryManagementByName("Maker");
		waithelper.waitForElement(driver, 2000,
				inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_Access_Branch_Code());
		inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_Access_Branch_Code().click();
		waithelper.waitForElement(driver, 2000,
				inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_Access_Branch_Code());
		inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_Access_Branch_Code()
				.sendKeys(testData.get("AccessBranchCodeForRequest"));
		inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_Access_Branch_Code().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 2000,
				inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_InventoryBranchCode());
		inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_InventoryBranchCode().click();
		waithelper.waitForElement(driver, 2000,
				inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_InventoryBranchCode());
		inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_InventoryBranchCode()
				.sendKeys(testData.get("InventoryBranchCodeForRequest"));
		inventoryManagamentObj.inventoryMaintenance_InventoryAccessMaster_InventoryBranchCode().sendKeys(Keys.ENTER);

	}
	@And("^Select records which we saved$")
	public void select_records_which_we_saved() throws Throwable {
		// Reference
		waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_FirstReferenceId());
		String id = budgetTransferObj.budget_BudgetTransfer_FirstReferenceId().getText();
		excelData.updateTestData("KUBS_INV_MGMT_UAT_003_004_D1", "Reference ID", id);
		System.out.println("Reference ID:" + id);
		Thread.sleep(1000);
		for (int i = 1; i <= 35; i++) {
			try {
//				waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]")));
				waithelper.waitForElementwithFluentwait(driver, driver
						.findElement(By.xpath("//span[contains(text(),'" + testData.get("Reference ID") + "')]")));
				WebElement referanceID = driver
						.findElement(By.xpath("//span[contains(text(),'" + testData.get("Reference ID") + "')]"));
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

		waithelper.waitForElement(driver, 10000,
				driver.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath)));
		driver.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath)).click();

	}
	@And("^Submit the records$")
	public void submit_the_records() throws Throwable {

		// Submit button
		// Thread.sleep(2000);
		waithelper.waitForElement(driver, 2000, inventoryManagamentObj.accountPayable_SubmitButton());
		inventoryManagamentObj.accountPayable_SubmitButton().click();
		// budgetTransferObj.budget_BudgetTransfer_Submit().click();
		javahelper.JavaScriptHelper(driver);
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
//		Thread.sleep(2000);
		WebElement element = waithelper.waitForElementwithFluentwait(driver,
				budgetTransferObj.budget_BudgetTransfer_RemarkField());
		element.click();
//		javahelper.JSEClick(budgetTransferObj.budget_BudgetTransfer_RemarkField());
		WebElement element1 = waithelper.waitForElementwithFluentwait(driver,
				budgetTransferObj.budget_BudgetTransfer_RemarkField());
		element1.sendKeys("ok");

//		budgetTransferObj.budget_BudgetTransfer_RemarkField().sendKeys("OK");

		// Remark Submit
		waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_SubmitByMaker());
		budgetTransferObj.budget_BudgetTransfer_SubmitByMaker().click();
//		Thread.sleep(2000);
		waithelper.waitForElementwithFluentwait(driver, budgetTransferObj.budget_BudgetTransfer_RecordStatus());
		WebElement recordstatus = budgetTransferObj.budget_BudgetTransfer_RecordStatus();

		clicksAndActionHelper.moveToElement(recordstatus);
		String message = budgetTransferObj.budget_BudgetTransfer_RecordStatus().getText();
		System.out.println(message);
		budgetTransferObj.budget_BudgetTransfer_RecordStatus().click();
		String t = "";
		String ar[] = message.split(" ");
		Thread.sleep(2000);
		for (int i = ar.length - 1; i >= 0; i--) {
			t = ar[ar.length - 1];
		}
		String reviewerId = "";
		for (int i = 0; i < t.length() - 1; i++) {
			if (t.charAt(i) == '.') {
			} else {
				reviewerId = reviewerId + t.charAt(i);
			}
		}
		System.out.println(reviewerId);
		//jsonWriter = new JsonDataReaderWriter();
		//jsonWriter.addData(reviewerId);
		excelData.updateTestData("KUBS_INV_MGMT_UAT_003_004_D1", "Reviewer ID", reviewerId);

	}

	 @Then("^Get the data set for requesting invetories$")
	    public void get_the_data_set_for_requesting_invetories() throws Throwable {
	    	testData = excelData.getTestdata("KUBS_INV_MGMT_UAT_003_004_D1");

	 }
	 @Then("^Open Reviewer accounts$")
		public void open_reviewer_accounts() throws Throwable {
			String UserID = "Reviewer";

			reader = new JsonDataReaderWriter();
			login = new AzentioLogin(driver);
			driver.get(config.getApplicationUrl());
			login.logintoAzentioappReviewer(UserID, testData.get("Reviewer ID"));

			//login.logintoAzentioappReviewer("Reviewer", reader.readdata());
			ExtentTestManager.getTest().info("User Navigated to required url & login as checker1");

		}
	 @And("^Clam the records$")
		public void clam_the_records() throws Throwable {
			waithelper = new WaitHelper(driver);
			kubschecker = new KUBS_CheckerObj(driver);
			waithelper.waitForElement(driver, 3000, kubschecker.checkerSecurityManagement());
			kubschecker.checkerSecurityManagement().click();
			waithelper.waitForElement(driver, 3000, kubschecker.checkerActionIcon());

			kubschecker.checkerActionIcon().click();
			Thread.sleep(2000);
			String before_xpath = "//span[contains(text(),'";
			String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
			waithelper.waitForElement(driver, 5000,
					driver.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath_claim)));
			driver.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath_claim)).click();
			waithelper.waitForElement(driver, 3000, kubschecker.checkerAlertClose());
			kubschecker.checkerAlertClose().click();

		}
	 @Then("^Click on notification and approve the records$")
		public void click_on_notification_and_approve_the_records() throws Throwable {
			javascript = new JavascriptHelper();
//			Thread.sleep(2000);
//			waithelper.waitForElement(driver, 3000, kubschecker.checkerNotificationIcon());
			waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerNotificationIcon());
			kubschecker.checkerNotificationIcon().click();
//			Thread.sleep(3000);
			while (true) {
				try {
					waithelper.waitForElementwithFluentwait(driver,
							driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("Reference ID") + "')]")));
					break;
				} catch (NoSuchElementException ne) {

				}
			}
			Thread.sleep(1500);
			for (int i = 1; i <= 35; i++) {
				try {
					waithelper.waitForElement(driver, 3000,
							driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("Reference ID") + "')]")));
					WebElement referanceID = driver
							.findElement(By.xpath("//span[contains(text(),'" + testData.get("Reference ID") + "')]"));
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

//			waithelper.waitForElement(driver, 10000,driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)));
			waithelper.waitForElementwithFluentwait(driver,
					driver.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath)));
			driver.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath)).click();

			waithelper.waitForElement(driver, 4000, kubschecker.checkerApproveButton());

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
	 @And("^Get the data set id for branch access$")
	    public void get_the_data_set_id_for_branch_access() throws Throwable {
	    	testData = excelData.getTestdata("KUBS_INV_MGMT_UAT_003_004_D1");

	 }

}
