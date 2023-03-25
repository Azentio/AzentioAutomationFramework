package stepdefinitions;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
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
import pageobjects.BUDGET_BudgetTransferObj;
import pageobjects.FixedAssetObj;
import pageobjects.FixedAsset_AssetCategoryObj;
import pageobjects.InventoryManagamentObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.ExcelData;
import utilities.ExtentTestManager;

public class FixedAssetCreation_KUBSStep extends BaseClass {

	WebDriver driver = BaseClass.driver;
	KUBS_Login kubsLogin;
	BrowserHelper browserHelper;
	WaitHelper waitHelper = new WaitHelper(driver);
	JavascriptHelper javascriptHelper = new JavascriptHelper();
	InventoryManagamentObj inventoryManagamentObj = new InventoryManagamentObj(driver);
	ConfigFileReader configFileReader = new ConfigFileReader();
	BUDGET_BudgetTransferObj budgetTransferObj = new BUDGET_BudgetTransferObj(driver);
	FixedAsset_AssetCategoryObj fixedAsset_AssetCategoryObj = new FixedAsset_AssetCategoryObj(driver);
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	FixedAssetObj fixedAssetObj = new FixedAssetObj(driver);
	KUBS_ReviewerObj revieweObj = new KUBS_ReviewerObj(driver);
	KUBS_CheckerObj checkerObj = new KUBS_CheckerObj(driver);
	String excelPath = System.getProperty("user.dir") + "\\Test-data\\KUBSTestData.xlsx";

	ExcelData excelData = new ExcelData(excelPath, "FixedAssetCreationTestData", "Data Set ID");
	Map<String, String> testData;

	@Given("^Maker Navigate to UAT URL login1$")
	public void maker_navigate_to_uat_url_login() throws InterruptedException {
		kubsLogin = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppByMaker();

	}

	@Then("^Click on the Direction1$")
	public void click_on_direction() throws Throwable {

		waitHelper.waitForElementwithFluentwait(driver, budgetTransferObj.budget_BudgetTransfer_DirectionIcon());
		budgetTransferObj.budget_BudgetTransfer_DirectionIcon().click();

	}

	@Then("^Click on Fixed Asset1$")
	public void click_on_fixed_asset() throws Throwable {

		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.fixedAsset_Button());
		fixedAssetObj.fixedAsset_Button().click();
	}

	@Then("^Click on the add button to add new record1$")
	public void click_on_the_add_button_to_add_new_record1() throws Throwable {
		for (int i = 0; i <= 200; i++) {
			try {
				clicksAndActionHelper.moveToElement(fixedAssetObj.fixedAsset_AssetCreation_AddButton());
				clicksAndActionHelper.clickOnElement(fixedAssetObj.fixedAsset_AssetCreation_AddButton());
				break;
			} catch (Exception e) {
				if (i == 200) {
					Assert.fail("Add button not clicked");
				}
			}
		}

	}

	@Then("^Fill Form$")
	public void fill_form() throws Throwable {

		testData = excelData.getTestdata("KUBS_FAT_UAT_002_001_01_D1");
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAssetObj.fixedAsset_AssetCreation_BranchCode_Textbox());
		fixedAssetObj.fixedAsset_AssetCreation_BranchCode_Textbox().click();

		System.out.println(testData.get("BranchCode"));
		fixedAssetObj.fixedAsset_AssetCreation_BranchCode_Textbox().sendKeys(testData.get("BranchCode"));
		fixedAssetObj.fixedAsset_AssetCreation_BranchCode_Textbox().sendKeys(Keys.ENTER);
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAssetObj.fixedAsset_AssetCreation_AssetCode_Textbox());
		fixedAssetObj.fixedAsset_AssetCreation_AssetCode_Textbox().click();

		fixedAssetObj.fixedAsset_AssetCreation_AssetCode_Textbox().sendKeys(testData.get("AssetCode"));
		fixedAssetObj.fixedAsset_AssetCreation_AssetCode_Textbox().sendKeys(Keys.ENTER);
		waitHelper.waitForElementwithFluentwait(driver,
				fixedAssetObj.fixedAsset_AssetCreation_BillReferenceNumber_Textbox());
		fixedAssetObj.fixedAsset_AssetCreation_BillReferenceNumber_Textbox().click();

		fixedAssetObj.fixedAsset_AssetCreation_BillReferenceNumber_Textbox().sendKeys(testData.get("BillReferenceNo"));
		fixedAssetObj.fixedAsset_AssetCreation_BillReferenceNumber_Textbox().sendKeys(Keys.ENTER);

	}

	@Then("^Save the filled form1$")
	public void save_the_filled_form() throws Throwable {
		waitHelper.waitForElementwithFluentwait(driver, fixedAssetObj.fixedAsset_AssetCreation_SaveButton());
		fixedAssetObj.fixedAsset_AssetCreation_SaveButton().click();
		for (int i = 0; i < 90; i++) {
			try {
				clicksAndActionHelper.moveToElement(fixedAssetObj.fixedAsset_AssetCategory_WorkflowInitiated());
				fixedAssetObj.fixedAsset_AssetCategory_WorkflowInitiated().click();
				break;
			} catch (Exception e) {

			}
		}
		for (int i = 0; i < 90; i++) {
			try {
				fixedAssetObj.fixedAsset_AssetCreation_SuccessMessageClose().click();
				break;
			} catch (Exception e) {
				if (i == 29) {
					// Assert.fail("Success message close button not clicked ");
				}
			}
		}
	}

	@Then("^Click on Fixed Asset Notification1$")
	public void click_on_fixed_asset_notification() {
		for (int i = 0; i < 30; i++) {
			try {
				clicksAndActionHelper
						.moveToElement(fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_WorkflowInitiated());
				fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_WorkflowInitiated().click();
				break;
			} catch (Exception e) {

			}
		}

		for (int i = 0; i < 30; i++) {
			try {

				clicksAndActionHelper.moveToElement(fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AlertClose());
				fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_AlertClose().click();
				break;
			} catch (Exception e) {

			}
		}

		for (int i = 0; i < 30; i++) {
			try {
				fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_Notification().click();
				break;
			} catch (Exception e) {

			}
		}

	}

	@Then("^Select the record which we saved1$")
	public void select_the_record_which_we_saved() throws Throwable {

		waitHelper.waitForElementwithFluentwait(driver, budgetTransferObj.budget_BudgetTransfer_FirstReferenceId());
		String id = budgetTransferObj.budget_BudgetTransfer_FirstReferenceId().getText();

		excelData.updateTestData("KUBS_FAT_UAT_002_001_01_D1", "Reference ID", id);
		testData = excelData.getTestdata("KUBS_FAT_UAT_002_001_01_D1");
		System.out.println("Reference ID:" + testData.get("Reference ID"));

		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
		for (int i = 0; i <= 50; i++) {
			try {

				waitHelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath)));
				driver.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath)).click();
				break;
			} catch (Exception e) {
				if (i == 50) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@Then("^Submit record1$")
	public void submit_record() throws Throwable {

		javascriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.accountPayable_SubmitButton());
		try {
			inventoryManagamentObj.accountPayable_SubmitButton().click();
		} catch (ElementClickInterceptedException e) {
			javascriptHelper.JSEClick(inventoryManagamentObj.accountPayable_SubmitButton());
		}

		waitHelper.waitForElementwithFluentwait(driver, budgetTransferObj.budget_BudgetTransfer_RemarkField());
		budgetTransferObj.budget_BudgetTransfer_RemarkField().click();

		budgetTransferObj.budget_BudgetTransfer_RemarkField().sendKeys("ok");
		budgetTransferObj.budget_BudgetTransfer_RemarkField().sendKeys(Keys.ENTER);

		waitHelper.waitForElementwithFluentwait(driver, budgetTransferObj.budget_BudgetTransfer_SubmitByMaker());
		budgetTransferObj.budget_BudgetTransfer_SubmitByMaker().click();
		WebElement recordstatus = budgetTransferObj.budget_BudgetTransfer_RecordStatus();

		waitHelper.waitForElementwithFluentwait(driver, budgetTransferObj.budget_BudgetTransfer_RecordStatus());
		clicksAndActionHelper.moveToElement(recordstatus);
		String message = budgetTransferObj.budget_BudgetTransfer_RecordStatus().getText();
		System.out.println(message);
		budgetTransferObj.budget_BudgetTransfer_RecordStatus().click();
		String t = "";
		String ar[] = message.split(" ");

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
		excelData.updateTestData("KUBS_FAT_UAT_002_001_01_D1", "Reviewer ID", reviewerId);

	}

	@Then("^Open the Reviewer account$")
	public void open_the_reviewer_account() throws Throwable {
		// reader = new JsonDataReaderWriter();
		kubsLogin = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.logintoAzentioappReviewer("Reviewer", testData.get("Reviewer ID"));
		waitHelper = new WaitHelper(driver);
		revieweObj = new KUBS_ReviewerObj(driver);
		waitHelper.waitForElementwithFluentwait(driver, revieweObj.reviewerNotidicationIcon());
		revieweObj.reviewerNotidicationIcon().click();
		browserHelper = new BrowserHelper(driver);
		javascriptHelper = new JavascriptHelper();

		waitHelper = new WaitHelper(driver);
		for (int i = 1; i <= 35; i++) {
			try {
				waitHelper.waitForElementwithFluentwait(driver, driver
						.findElement(By.xpath("//span[contains(text(),'" + testData.get("Reference ID") + "')]")));
				WebElement referanceID = driver
						.findElement(By.xpath("//span[contains(text(),'" + testData.get("Reference ID") + "')]"));
				referanceID.click();

				Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waitHelper.waitForElementwithFluentwait(driver, checkerObj.checker_notification_next_button());

				checkerObj.checker_notification_next_button().click();
			}
		}
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
		waitHelper.waitForElementwithFluentwait(driver,
				driver.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath)));
		driver.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath)).click();

	}

	@Then("^Open Reviewer account$")
	public void open_reviewer_account() throws Throwable {

		kubsLogin = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.logintoAzentioappReviewer("Reviewer", testData.get("Reviewer ID"));
		ExtentTestManager.getTest().info("User Navigated to required url & login as checker1");

	}

	@And("^Click on notification$")
	public void click_on_notification() throws Throwable {
		waitHelper = new WaitHelper(driver);
		revieweObj = new KUBS_ReviewerObj(driver);
		waitHelper.waitForElementwithFluentwait(driver, revieweObj.reviewerNotidicationIcon());
		clicksAndActionHelper.moveToElement(revieweObj.reviewerNotidicationIcon());
		revieweObj.reviewerNotidicationIcon().click();
		browserHelper = new BrowserHelper(driver);
		javascriptHelper = new JavascriptHelper();
		waitHelper = new WaitHelper(driver);
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
		System.out.println(testData.get("Reference ID"));
		waitHelper.waitForElementwithFluentwait(driver,
				driver.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath)));
		driver.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath)).click();

	}

	@Then("^Approve the record which we submitted from maker stage$")
	public void approve_the_record_which_we_submitted_from_maker_stage() throws Throwable {
		testData = excelData.getTestdata("KUBS_FAT_UAT_002_001_02_D1");
		waitHelper.waitForElementwithFluentwait(driver, revieweObj.reviewerApproveButton());
		revieweObj.reviewerApproveButton().click();
		waitHelper.waitForElementwithFluentwait(driver, revieweObj.reviewerAlertRemarks());
		revieweObj.reviewerAlertRemarks().sendKeys(testData.get("Remark"));
		waitHelper.waitForElementwithFluentwait(driver, revieweObj.reviewerAlertSubmitButton());
		revieweObj.reviewerAlertSubmitButton().click();
	}

	@Then("^Go to Checker account$")
	public void go_to_checker_account() throws Throwable {
		kubsLogin = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppAsChecker("Checker");
		ExtentTestManager.getTest().info("User Navigated to required url & login as reviewer1");

	}

	@And("^Clam the record$")
	public void clam_the_record() throws Throwable {
		waitHelper = new WaitHelper(driver);
		checkerObj = new KUBS_CheckerObj(driver);
		waitHelper.waitForElementwithFluentwait(driver, checkerObj.checkerSecurityManagement());
		checkerObj.checkerSecurityManagement().click();
		waitHelper.waitForElementwithFluentwait(driver, checkerObj.checkerActionIcon());
		checkerObj.checkerActionIcon().click();
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		waitHelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath_claim)));
		driver.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath_claim)).click();
		waitHelper.waitForElementwithFluentwait(driver, checkerObj.checkerAlertClose());
		checkerObj.checkerAlertClose().click();

	}

	@Then("^Click on notification and approve the record$")
	public void click_on_notification_and_approve_the_record() throws Throwable {
		testData = excelData.getTestdata("KUBS_FAT_UAT_002_001_03_D1");
		javascriptHelper = new JavascriptHelper();
		waitHelper.waitForElementwithFluentwait(driver, checkerObj.checkerNotificationIcon());
		checkerObj.checkerNotificationIcon().click();

		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
		waitHelper.waitForElementwithFluentwait(driver,
				driver.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath)));
		driver.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath)).click();

		waitHelper.waitForElementwithFluentwait(driver, checkerObj.checkerApproveButton());

		checkerObj.checkerApproveButton().click();
		waitHelper.waitForElementwithFluentwait(driver, revieweObj.reviewerAlertRemarks());

		revieweObj.reviewerAlertRemarks().sendKeys(testData.get("Remark"));
		waitHelper.waitForElementwithFluentwait(driver, revieweObj.reviewerAlertSubmitButton());

		revieweObj.reviewerAlertSubmitButton().click();

	}

	@Given("^Navigate to kubs URL and user should login as a maker1$")
	public void navigate_to_kubs_url_and_user_should_login_as_a_maker() throws Throwable {
		kubsLogin = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		kubsLogin.loginToAzentioAppByMaker();
	}

	@And("^User get the testdata for asset limit$")
	public void user_get_the_testdata_for_asset_limit() throws Throwable {

		testData = excelData.getTestdata("KUBS_FAT_UAT_002_001_01_D1");

	}

}
