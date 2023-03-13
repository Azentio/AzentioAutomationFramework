package stepdefinitions;

import java.util.HashMap;
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

public class FixedAssetCreation_KUBSStep extends BaseClass{
	
	WebDriver driver = BaseClass.driver;
	ConfigFileReader config = new ConfigFileReader();
    KUBS_Login kubsLogin;
	KUBS_ReviewerObj reviewer;
    //JsonConfig jsonconfig = new JsonConfig();
	BrowserHelper browserHelper;
	JavascriptHelper javahelper = new JavascriptHelper();
	//JsonConfig jsonReader = new JsonConfig();
	WaitHelper waithelper = new WaitHelper(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper();
	InventoryManagamentObj inventoryManagamentObj = new InventoryManagamentObj(driver);
	ConfigFileReader configFileReader = new ConfigFileReader();
	BUDGET_BudgetTransferObj budgetTransferObj = new BUDGET_BudgetTransferObj(driver);
	FixedAsset_AssetCategoryObj fixedAsset_AssetCategoryObj = new FixedAsset_AssetCategoryObj(driver);
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	
	JavascriptHelper javascript;
	FixedAssetObj fixedAssetObj = new FixedAssetObj(driver);
	
	String excelPath = System.getProperty("user.dir") + "\\Test-data\\KUBSTestData.xlsx";
	//Map<String, String> TestData = new HashMap<>();
	//ExcelData excelReader = new ExcelData(excelPath, "FixedAssetCreationTestData", "Test Case ID");
	
	ExcelData excelData = new ExcelData(excelPath,"FixedAssetCreationTestData","Data Set ID");
	Map<String, String> testData;
	
	 @Given("^Maker Navigate to UAT URL login1$")
	    public void maker_navigate_to_uat_url_login() throws InterruptedException {
			kubsLogin = new KUBS_Login(driver);
			driver.get(configFileReader.getApplicationUrl());
			kubsLogin.loginToAzentioAppByMaker();
			
	       
	    }
	 @Then("^Click on the Direction1$")
		public void click_on_direction() throws Throwable {
		 Thread.sleep(2000);
			waithelper.waitForElementwithFluentwait(driver, budgetTransferObj.budget_BudgetTransfer_DirectionIcon());
			budgetTransferObj.budget_BudgetTransfer_DirectionIcon().click();

		}
	 @Then("^Click on Fixed Asset1$")
		public void click_on_fixed_asset() throws Throwable {
			
		   
			waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.fixedAsset_Button(), 60, 5);
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
			//fixedAssetTestDataType = jsonReader.getFixedAssetByName("Maker");
		    testData = excelData.getTestdata("KUBS_FAT_UAT_002_001_01_D1");
			waithelper.waitForElementToVisibleWithFluentWait(driver,
					fixedAssetObj.fixedAsset_AssetCreation_BranchCode_Textbox(), 60, 5);
			fixedAssetObj.fixedAsset_AssetCreation_BranchCode_Textbox().click();
			Thread.sleep(500);
			System.out.println(testData.get("BranchCode"));
			fixedAssetObj.fixedAsset_AssetCreation_BranchCode_Textbox().sendKeys(testData.get("BranchCode"));
			fixedAssetObj.fixedAsset_AssetCreation_BranchCode_Textbox().sendKeys(Keys.ENTER);
			waithelper.waitForElementToVisibleWithFluentWait(driver,
					fixedAssetObj.fixedAsset_AssetCreation_AssetCode_Textbox(), 60, 5);
			fixedAssetObj.fixedAsset_AssetCreation_AssetCode_Textbox().click();
			Thread.sleep(500);
			fixedAssetObj.fixedAsset_AssetCreation_AssetCode_Textbox().sendKeys(testData.get("AssetCode"));
			fixedAssetObj.fixedAsset_AssetCreation_AssetCode_Textbox().sendKeys(Keys.ENTER);
			waithelper.waitForElementToVisibleWithFluentWait(driver,
					fixedAssetObj.fixedAsset_AssetCreation_BillReferenceNumber_Textbox(), 60, 5);
			fixedAssetObj.fixedAsset_AssetCreation_BillReferenceNumber_Textbox().click();
			Thread.sleep(500);
			fixedAssetObj.fixedAsset_AssetCreation_BillReferenceNumber_Textbox()
					.sendKeys(testData.get("BillReferenceNo"));
			fixedAssetObj.fixedAsset_AssetCreation_BillReferenceNumber_Textbox().sendKeys(Keys.ENTER);

		}
	 @Then("^Save the filled form1$")
		public void save_the_filled_form() throws Throwable {
			waithelper.waitForElementToVisibleWithFluentWait(driver, fixedAssetObj.fixedAsset_AssetCreation_SaveButton(),
					60, 5);
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
			// Notification
			// waitHelper.waitForElementToVisibleWithFluentWait(driver,fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_WorkflowInitiated(),30,2);
			for (int i = 0; i < 30; i++) {
				try {
					clicksAndActionHelper.moveToElement(fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_WorkflowInitiated());
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

			// waitHelper.waitForElementToVisibleWithFluentWait(driver,fixedAsset_AssetCategoryObj.fixedAsset_AssetCategory_Notification(),60,5);
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
			// Reference
			waithelper.waitForElement(driver, 6000, budgetTransferObj.budget_BudgetTransfer_FirstReferenceId());
			String id = budgetTransferObj.budget_BudgetTransfer_FirstReferenceId().getText();
			//jsonWriter.addReferanceData(id);
			excelData.updateTestData("KUBS_FAT_UAT_002_001_01_D1","Reference ID",id);
			testData = excelData.getTestdata("KUBS_FAT_UAT_002_001_01_D1");
			System.out.println("Reference ID:" + testData.get("Reference ID"));
//			String xpath ="//span[text()='"+testData.get("Reference ID")+"']/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
//			for (int i = 1; i <=200; i++) {
//				try {
//					clicksAndActionHelper.moveToElement(driver.findElement(By.xpath(xpath)));
//					clicksAndActionHelper.clickOnElement(driver.findElement(By.xpath(xpath)));
//					break;
//				} catch (Exception e) {
//					if (i ==200) {
//						Assert.fail(e.getMessage());
//					}
//				}
//
//			}
////			budgetTransferObj.budget_BudgetTransfer_FirstReferenceId().click();

			// Action-Pencil
			String before_xpath = "//span[contains(text(),'";
			String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
			for (int i = 0; i <= 50; i++) {
				try {

					waithelper.waitForElement(driver, 10000,
							driver.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath)));
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
			// Submit button
			// Thread.sleep(2000);
			javahelper.JavaScriptHelper(driver);
			waithelper.waitForElement(driver, 2000, inventoryManagamentObj.accountPayable_SubmitButton());
			try {
				inventoryManagamentObj.accountPayable_SubmitButton().click();
			} catch (ElementClickInterceptedException e) {
				javahelper.JSEClick(inventoryManagamentObj.accountPayable_SubmitButton());
			}
			// budgetTransferObj.budget_BudgetTransfer_Submit().click();

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
//					Thread.sleep(3000);	
			// waithelper.waitForElement(driver, 2000,
			// budgetTransferObj.budget_BudgetTransfer_RemarkField());

			// javahelper.JSEClick(budgetTransferObj.budget_BudgetTransfer_RemarkField());
			waithelper.waitForElementwithFluentwait(driver, budgetTransferObj.budget_BudgetTransfer_RemarkField());
			budgetTransferObj.budget_BudgetTransfer_RemarkField().click();
			// waithelper.waitForElement(driver, 2000,
			// budgetTransferObj.budget_BudgetTransfer_RemarkField());
			// Thread.sleep(2000);
			budgetTransferObj.budget_BudgetTransfer_RemarkField().sendKeys("ok");
			budgetTransferObj.budget_BudgetTransfer_RemarkField().sendKeys(Keys.ENTER);

			// Thread.sleep(2000);
			// Remark Submit
			waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_SubmitByMaker());
			budgetTransferObj.budget_BudgetTransfer_SubmitByMaker().click();
			// Thread.sleep(2000);
			WebElement recordstatus = budgetTransferObj.budget_BudgetTransfer_RecordStatus();
			Thread.sleep(2000);
			waithelper.waitForElementwithFluentwait(driver, budgetTransferObj.budget_BudgetTransfer_RecordStatus());
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
			excelData.updateTestData("KUBS_FAT_UAT_002_001_01_D1","Reviewer ID",reviewerId);
			
//			jsonWriter = new JsonDataReaderWriter();
//			jsonWriter.addData(reviewerId);

		}

		@Then("^Open the Reviewer account$")
		public void open_the_reviewer_account() throws Throwable {
			//reader = new JsonDataReaderWriter();
			kubsLogin = new KUBS_Login(driver);
			driver.get(config.getApplicationUrl());
			kubsLogin.logintoAzentioappReviewer("Reviewer", testData.get("Reviewer ID"));
			waithelper = new WaitHelper(driver);
			reviewer = new KUBS_ReviewerObj(driver);
			waithelper.waitForElement(driver, 2000, reviewer.reviewerNotidicationIcon());
			reviewer.reviewerNotidicationIcon().click();
			browserHelper = new BrowserHelper(driver);
			//budgetdata = jsonconfig.getBudgetdataByName("Maker");
			javascript = new JavascriptHelper();
			Thread.sleep(2000);
			waithelper = new WaitHelper(driver);
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
//					Thread.sleep(2000);
//					waithelper.waitForElement(driver, 10000,driver.findElement(By.xpath(before_xpath + TestData.get("Reference ID") + after_xpath)));
			waithelper.waitForElementwithFluentwait(driver,
					driver.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath)));
			driver.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath)).click();

		}
		@Then("^Open Reviewer account$")
		public void open_reviewer_account() throws Throwable {
			
			kubsLogin = new KUBS_Login(driver);
			//reader = new JsonDataReaderWriter();
			//login = new AzentioLogin(driver);
			driver.get(config.getApplicationUrl());
			kubsLogin.logintoAzentioappReviewer("Reviewer", testData.get("Reviewer ID"));
			ExtentTestManager.getTest().info("User Navigated to required url & login as checker1");

		}
		@And("^Click on notification$")
		public void click_on_notification() throws Throwable {
			waithelper = new WaitHelper(driver);
			reviewer = new KUBS_ReviewerObj(driver);
			waithelper.waitForElement(driver, 2000, reviewer.reviewerNotidicationIcon());
			clicksAndActionHelper.moveToElement(reviewer.reviewerNotidicationIcon());
			reviewer.reviewerNotidicationIcon().click();
			browserHelper = new BrowserHelper(driver);
			//budgetdata = jsonconfig.getBudgetdataByName("Maker");
			javascript = new JavascriptHelper();
			Thread.sleep(1000);
			waithelper = new WaitHelper(driver);
			/*
			 * for (int i = 1; i <= 35; i++) { try { // waithelper.waitForElement(driver,
			 * 3000,driver.findElement(By.xpath("//span[contains(text(),'" +
			 * TestData.get("Reference ID") + "')]")));
			 * waithelper.waitForElementwithFluentwait(driver,
			 * driver.findElement(By.xpath("//span[contains(text(),'" +
			 * TestData.get("Reference ID") + "')]"))); WebElement referanceID =
			 * driver.findElement(By.xpath("//span[contains(text(),'" +
			 * TestData.get("Reference ID") + "')]")); referanceID.click();
			 * 
			 * Assert.assertTrue(referanceID.isDisplayed()); break; } catch
			 * (NoSuchElementException e) { // waithelper.waitForElement(driver, 4000,
			 * kubschecker.checker_notification_next_button());
			 * waithelper.waitForElementwithFluentwait(driver,
			 * kubschecker.checker_notification_next_button());
			 * kubschecker.checker_notification_next_button().click(); } }
			 */
			String before_xpath = "//span[contains(text(),'";
			String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

			System.out.println(testData.get("Reference ID"));
//			waithelper.waitForElement(driver, 10000,driver.findElement(By.xpath(before_xpath + TestData.get("Reference ID") + after_xpath)));
			waithelper.waitForElementwithFluentwait(driver,
					driver.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath)));
			driver.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath)).click();

		}
		@Then("^Approve the record which we submitted from maker stage$")
		public void approve_the_record_which_we_submitted_from_maker_stage() throws Throwable {
			testData = excelData.getTestdata("KUBS_FAT_UAT_002_001_02_D1");
//			waithelper.waitForElement(driver, 2000, reviewer.reviewerApproveButton());
			waithelper.waitForElementwithFluentwait(driver, reviewer.reviewerApproveButton());
			reviewer.reviewerApproveButton().click();
//			waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertRemarks());
			waithelper.waitForElementwithFluentwait(driver, reviewer.reviewerAlertRemarks());
			reviewer.reviewerAlertRemarks().sendKeys(testData.get("Remark"));
//			waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertSubmitButton());
			waithelper.waitForElementwithFluentwait(driver, reviewer.reviewerAlertSubmitButton());
			reviewer.reviewerAlertSubmitButton().click();
			Thread.sleep(3000);
		}

		@Then("^Go to Checker account$")
		public void go_to_checker_account() throws Throwable {
			//login = new AzentioLogin(driver);
			kubsLogin = new KUBS_Login(driver);
			driver.get(config.getApplicationUrl());
			kubsLogin.loginToAzentioAppAsChecker("Checker");
			ExtentTestManager.getTest().info("User Navigated to required url & login as reviewer1");

		}
		@And("^Clam the record$")
		public void clam_the_record() throws Throwable {
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

		@Then("^Click on notification and approve the record$")
		public void click_on_notification_and_approve_the_record() throws Throwable {
			testData = excelData.getTestdata("KUBS_FAT_UAT_002_001_03_D1");
			javascript = new JavascriptHelper();
//			Thread.sleep(2000);
//			waithelper.waitForElement(driver, 3000, kubschecker.checkerNotificationIcon());
			waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerNotificationIcon());
			kubschecker.checkerNotificationIcon().click();
//			Thread.sleep(3000);
//			while (true) {
//				try {
//					waithelper.waitForElementwithFluentwait(driver,
//							driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("Reference ID") + "')]")));
//					break;
//				} catch (NoSuchElementException ne) {
//
//				}
//			}
//			Thread.sleep(1500);
//			for (int i = 1; i <= 35; i++) {
//				try {
//					waithelper.waitForElement(driver, 3000,
//							driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("Reference ID") + "')]")));
//					WebElement referanceID = driver
//							.findElement(By.xpath("//span[contains(text(),'" + testData.get("Reference ID") + "')]"));
//					referanceID.click();
//
//					Assert.assertTrue(referanceID.isDisplayed());
//					break;
//				} catch (NoSuchElementException e) {
//					waithelper.waitForElement(driver, 4000, kubschecker.checker_notification_next_button());
//					kubschecker.checker_notification_next_button().click();
//				}
//			}
			String before_xpath = "//span[contains(text(),'";
			String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

//			waithelper.waitForElement(driver, 10000,driver.findElement(By.xpath(before_xpath + TestData.get("Reference ID") + after_xpath)));
			waithelper.waitForElementwithFluentwait(driver,
					driver.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath)));
			driver.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath)).click();

			waithelper.waitForElement(driver, 4000, kubschecker.checkerApproveButton());

			kubschecker.checkerApproveButton().click();
//			waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertRemarks());
			waithelper.waitForElementwithFluentwait(driver, reviewer.reviewerAlertRemarks());
			Thread.sleep(2000);
			reviewer.reviewerAlertRemarks().sendKeys(testData.get("Remark"));
//			Thread.sleep(1000);
			waithelper.waitForElementwithFluentwait(driver, reviewer.reviewerAlertSubmitButton());
//			waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertSubmitButton());
			reviewer.reviewerAlertSubmitButton().click();
			Thread.sleep(3000);
		}
		@Given("^Navigate to kubs URL and user should login as a maker1$")
		public void navigate_to_kubs_url_and_user_should_login_as_a_maker() throws Throwable {
			//login = new AzentioLogin(driver);
			kubsLogin = new KUBS_Login(driver);
			driver.get(configFileReader.getApplicationUrl());
			kubsLogin.loginToAzentioAppByMaker();
		}

		@And("^User get the testdata for asset limit$")
	    public void user_get_the_testdata_for_asset_limit() throws Throwable {
			
			testData = excelData.getTestdata("KUBS_FAT_UAT_002_001_01_D1");
	        
    }
		








	


}
