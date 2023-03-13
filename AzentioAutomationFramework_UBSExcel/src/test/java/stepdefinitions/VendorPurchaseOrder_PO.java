package stepdefinitions;

import java.io.IOException;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
import pageobjects.AccountPayable_VendorPurchaseOrderObj;
import pageobjects.Azentio_CheckerObj;
import pageobjects.Azentio_ReviewerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;
import testDataType.AccountPayable_VendorPurchaseOrderTestDataType;
import testDataType.BUDGET_BudgetCreationTestDataType;

public class VendorPurchaseOrder_PO {

	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	ConfigFileReader configFileReader = new ConfigFileReader();
	ConfigFileReader config = new ConfigFileReader();
	DropDownHelper dropDownHelper;
	WaitHelper waithelper = new WaitHelper(driver);
	// maker//
	JavascriptHelper javascripthelper = new JavascriptHelper();

	AccountPayable_VendorPurchaseOrderObj accountPayable_VendorPurchaseOrderObj = new AccountPayable_VendorPurchaseOrderObj(
			driver);

	AccountPayable_VendorPurchaseOrderTestDataType accountPayable_VendorPurchaseOrderTestDataType = new AccountPayable_VendorPurchaseOrderTestDataType();

	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	JsonDataReaderWriter reader = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	Azentio_ReviewerObj reviewer;
	BrowserHelper browserHelper;
	String referance_id;
	String user = "Maker";
	Azentio_CheckerObj kubschecker = new Azentio_CheckerObj(driver);
	BUDGET_BudgetCreationTestDataType budgetdata;
	String excelPath = System.getProperty("user.dir") + "\\Test-data\\KUBSTestData.xlsx";
	ExcelData excelData = new ExcelData(excelPath, "POCreationTestData", "Data Set ID");
	Map<String, String> testData;

	ExcelData excelData1 = new ExcelData(excelPath, "ContractTestData", "Data Set ID");
	ExcelData excelDataGRNTestdata = new ExcelData(excelPath, "GRNTestData", "Data Set ID");
	ExcelData excelDataForAssetCreation = new ExcelData(excelPath, "FixedAsset_AssetCreation", "Data Set ID");
	Map<String, String> testData1;

	@And("^Get the test data for the po creation test case1$")
	public void get_the_test_data_for_the_po_creation_test_case1() throws Throwable {

		testData = excelData.getTestdata("KUBS_FAT_UAT_001_003_01_D1");

	}

	@And("^User fill the accountsPayable_VendorPurchaseOrder_BPName$")
	public void user_fill_the_accountspayablevendorpurchaseorderbpname() throws Throwable {

		// BP Name
		waithelper.waitForElementwithFluentwait(driver,
				accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_BPName());
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_BPName().click();
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_BPName()
				.sendKeys(testData.get("BpName"));
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_BPName().sendKeys(Keys.DOWN);
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_BPName().sendKeys(Keys.ENTER);

	}

	@And("^User fill the accountsPayable_VendorPurchaseOrder_ReferenceType$")
	public void user_fill_the_accountspayablevendorpurchaseorderreferencetype() throws Throwable {

		// Reference Type
		waithelper.waitForElementwithFluentwait(driver,
				accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ReferenceType());
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ReferenceType().click();
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ReferenceType()
				.sendKeys(testData.get("ReferenceType"));
		Thread.sleep(500);
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ReferenceType().sendKeys(Keys.DOWN);
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ReferenceType().sendKeys(Keys.ENTER);

	}

	@And("^User fill the accountsPayable_VendorPurchaseOrder_CheckBoxPoItem$")
	public void user_fill_the_accountspayablevendorpurchaseordercheckboxpoitem() throws Throwable {

		waithelper.waitForElementwithFluentwait(driver,
				accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_CheckBoxPoItem());

		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_CheckBoxPoItem().click();

	}

	@And("^User fill the accountsPayable_VendorPurchaseOrder_PoQuantity$")
	public void user_fill_the_accountspayablevendorpurchaseorderpoquantity() throws Throwable {

		// Po Quantity
		waithelper.waitForElementwithFluentwait(driver,
				accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PoQuantity());
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PoQuantity().click();
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PoQuantity()
				.sendKeys(testData.get("PoQuantity"));
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PoQuantity().sendKeys(Keys.DOWN);
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PoQuantity().sendKeys(Keys.ENTER);

	}

	@And("^User save the accountsPayable_VendorPurchaseOrder_PoItemSave1$")
	public void user_save_the_accountspayablevendorpurchaseorderpoitemsave1() throws Throwable {

		clicksAndActionHelper
				.clickOnElement(accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_PoItemSave());

	}

	@And("^User fill the accountsPayable_VendorPurchaseOrder_POSubType1$")
	public void user_fill_the_accountspayablevendorpurchaseorderposubtype1() throws Throwable {

		// Po Sub Type
		waithelper.waitForElementwithFluentwait(driver,
				accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_POSubType1());
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_POSubType1().click();
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_POSubType1()
				.sendKeys(testData.get("PoSubType"));
		Thread.sleep(500);
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_POSubType1().sendKeys(Keys.ENTER);

	}

	@And("^User fill the accountsPayable_VendorPurchaseOrder_CostCenter1$")
	public void user_fill_the_accountspayablevendorpurchaseordercostcenter1() throws Throwable {

		// cost Center
		waithelper.waitForElementwithFluentwait(driver,
				accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_CostCenter1());
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_CostCenter1().click();
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_CostCenter1()
				.sendKeys(testData.get("CostCenter"));
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_CostCenter1().sendKeys(Keys.ENTER);

	}

	@Then("^Click on Direction icon$")
	public void click_on_direction_icon() throws InterruptedException {
		waithelper = new WaitHelper(driver);
		Thread.sleep(2000);
//		 waithelper.waitForElement(driver, 4000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_DirectionIcon());
		waithelper.waitForElementwithFluentwait(driver,
				accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_DirectionIcon());
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_DirectionIcon().click();

	}

	@Then("^Click on Account Payable$")
	public void click_on_account_payable() {
		waithelper.waitForElement(driver, 4000,
				accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_AccountsPayableField());
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_AccountsPayableField().click();

	}

	@Then("^Click on purchase order Eye Icon$")
	public void click_on_purchase_order_eye_icon() {
		waithelper.waitForElement(driver, 2000,
				accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_EyeButton());
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_EyeButton().click();

	}

	@Then("^Click on purchase order Add button$")
	public void click_on_purchase_order_add_button() throws InterruptedException {
//			 waithelper.waitForElement(driver, 2000, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_AddButton());
		Thread.sleep(500);
		waithelper.waitForElementwithFluentwait(driver,
				accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_AddButton());
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_AddButton().click();

	}

	@Then("^Click on Account Payable Save button$")
	public void click_on_account_payable_save_button() {
		// waithelper.waitForElement(driver, 2000,
		// accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_Save());
		for (int i = 0; i < 40; i++) {
			try {
				accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_Save().click();
				break;
			} catch (Exception e) {

				if (i == 40) {
					e.getMessage();
				}

			}
		}

	}

	@Then("^Click on Account Payable Notification$")
	public void click_on_account_payable_notification() throws InterruptedException {
		// waithelper.waitForElement(driver, 2000,
		// accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_Notification());
		Thread.sleep(2000);
		for (int i = 0; i < 30; i++) {
			try {
				accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_Notification().click();
				break;
			} catch (Exception e) {

			}
		}

	}

	@Then("^Click on Item Details Record$")
	public void click_on_item_details_record() throws InterruptedException {

//				Thread.sleep(2000);
//				waithelper.waitForElement(driver, 2000,accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ItemDetailsRecord());
		for (int i = 0; i <= 500; i++) {
			try {
				accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ItemDetailsRecord().click();
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
		// validate msg

//		WebElement toast = accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_VaildationMsg();
//		waithelper.waitForElement(driver, 3000,
//				accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_VaildationMsg());
//		clicksAndActionHelper.clickOnElement(toast);
//		;
//		String message = accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_VaildationMsg()
//				.getText();
//		System.out.println(message);

	}

	@Then("^Edit the item details fields$")
	public void edit_the_item_details_fields() {

		// Shipped from Location
		waithelper.waitForElement(driver, 2000,
				accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ShippedFromLocation());
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ShippedFromLocation().click();
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ShippedFromLocation()
				.sendKeys(testData.get("ShippedFromLocation"));
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ShippedFromLocation()
				.sendKeys(Keys.ENTER);

		// waithelper.waitForElementwithFluentwait(driver,
		// accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RatePerUnitService());
		for (int i = 0; i < 30; i++) {
			try {
				accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RatePerUnitService()
						.sendKeys(testData.get("RatePerUnit"));
			} catch (Exception e) {

			}
		}

		// DeliveryLocation
		waithelper.waitForElement(driver, 2000,
				accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_DeliveryLocation());
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_DeliveryLocation().click();
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_DeliveryLocation()
				.sendKeys(testData.get("DeliveryLocation"));
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_DeliveryLocation()
				.sendKeys(Keys.ENTER);

	}

	@Then("^Select the record from Notification$")
	public void select_the_record_from_notification() throws Throwable {
		// Reference
		waithelper.waitForElement(driver, 2000,
				accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ReferenceId());
		String id = accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ReferenceId().getText();
		// jsonWriter.addReferanceData(id);
		excelData.updateTestData("KUBS_FAT_UAT_001_003_01_D1", "Reference ID", id);
		testData = excelData.getTestdata("KUBS_FAT_UAT_001_003_01_D1");
		// testData.get("KUBS_FAT_UAT_001_003_01_D1");
		System.out.println("Reference ID:" + id);
//			for (int i = 1; i <= 35; i++) {
//				try {
//					waithelper.waitForElement(driver, 3000, driver.findElement(
//							By.xpath("//span[contains(text(),'" +testData.get("Reference ID")+ "')]")));
//					WebElement referanceID = driver
//							.findElement(By.xpath("//span[contains(text(),'" +testData.get("Reference ID")+ "')]"));
//					referanceID.click();
//					System.out.println(referanceID);
//					// Assert.assertTrue(referanceID.isDisplayed());
//					break;
//				} catch (NoSuchElementException e) {
//					waithelper.waitForElement(driver, 4000,
//							accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_NotificationNext_Button());
//
//					accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_NotificationNext_Button().click();
//				}
//			}
//			accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_ReferenceId().click();

		// pencil
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
		// testData = excelData.getTestdata("KUBS_FAT_UAT_001_003_01_D1");

		waithelper.waitForElement(driver, 2000,
				driver.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath)));
		Thread.sleep(2000);
		driver.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath)).click();
	}

	@And("^Submit the Selected record$")
	public void submit_the_selected_record() throws InterruptedException, IOException {

		// Submit button
		waithelper.waitForElement(driver, 2000,
				accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_SubmitButton());
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_SubmitButton().click();

		// Remark
		javascripthelper.JavaScriptHelper(driver);
		waithelper.waitForElement(driver, 3000,
				accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RemarkField());
		javascripthelper
				.JSEClick(accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RemarkField());
		waithelper.waitForElementwithFluentwait(driver,
				accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RemarkField());
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RemarkField()
				.sendKeys(testData.get("Remark"));
		// inventoryMaintenanceTestDataType.Remark

		// Remark Submit

//        	waithelper.waitForElement(driver, 2000,accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_SubmitByMaker());
		for (int i = 0; i <= 500; i++) {
			try {
				accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_SubmitByMaker().click();
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
		// Thread.sleep(2000);

		// REVIEWER
//        			Thread.sleep(2000);
		waithelper.waitForElementwithFluentwait(driver,
				accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RecordStatus());
		WebElement recordstatus = accountPayable_VendorPurchaseOrderObj
				.accountsPayable_VendorPurchaseOrder_RecordStatus();

		clicksAndActionHelper.moveToElement(recordstatus);
		String message = accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RecordStatus()
				.getText();
		System.out.println(message);
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_RecordStatus().click();
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
		excelData.updateTestData("KUBS_FAT_UAT_001_003_01_D1", "Reviewer ID", reviewerId);
		// jsonWriter = new JsonDataReaderWriter();
		// jsonWriter.addData(reviewerId);

	}

	@And("^Get the test data for the po creation test case2$")
	public void get_the_test_data_for_the_po_creation_test_case2() throws Throwable {
		testData = excelData.getTestdata("KUBS_FAT_UAT_001_003_02_D1");
	}

	@And("^Get the test data for the po creation test case3$")
	public void get_the_test_data_for_the_po_creation_test_case3() throws Throwable {
		testData = excelData.getTestdata("KUBS_FAT_UAT_001_003_01_D1");
	}

	@Then("^click on the Notification select the record and Approve3$")
	public void click_on_the_notification_select_the_record_and_approve3()
			throws InterruptedException, IOException, ParseException {
		// notification
		waithelper = new WaitHelper(driver);
		reviewer = new Azentio_ReviewerObj(driver);
		// waithelper.waitForElement(driver, 2000, reviewer.reviewerNotidicationIcon());
		// waithelper.waitForElementToVisibleWithFluentWait(driver,reviewer.reviewerNotidicationIcon(),30,
		// 2);
		waithelper.waitForElementToVisibleWithFluentWait(driver, reviewer.reviewerNotidicationIcon(), 20, 1);

		reviewer.reviewerNotidicationIcon().click();

		// select the record
		browserHelper = new BrowserHelper(driver);
		// budgetdata = jsonReader.getBudgetdataByName("Maker");

//				for (int i = 0; i < 35; i++) {
//					try {
//						//waithelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]")));
//						WebElement referanceID = driver.findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]"));
//						referanceID.click();
//						Assert.assertTrue(referanceID.isDisplayed());
//
//						break;
//					} catch (NoSuchElementException e) {
//						//waithelper.waitForElement(driver, 4000, kubschecker.checker_notification_next_button());
//						kubschecker.checker_notification_next_button().click();
//						
//					}
//				}
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
		System.out.println("Reference ID " + testData.get("Reference ID"));
		for (int i = 0; i < 500; i++) {
			try {

				// waithelper.waitForElement(driver,
				// 5000,driver.findElement(By.xpath(before_xpath + reader.readReferancedata() +
				// after_xpath)));
				driver.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath)).click();
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}

			}
		}
		// Approve
//				waithelper.waitForElement(driver, 4000, reviewer.reviewerApproveButton());
		waithelper.waitForElementToVisibleWithFluentWait(driver, reviewer.reviewerApproveButton(), 30, 2);
		reviewer.reviewerApproveButton().click();

//				waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertRemarks());
		waithelper.waitForElementwithFluentwait(driver, reviewer.reviewerAlertRemarks());
		clicksAndActionHelper.moveToElement(reviewer.reviewerAlertRemarks());
		clicksAndActionHelper.moveToElement(reviewer.reviewerAlertRemarks());
		reviewer.reviewerAlertRemarks().sendKeys("Approved by reviewer");

//				waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertSubmitButton());
		for (int i = 0; i <= 500; i++) {
			try {
				waithelper.waitForElementwithFluentwait(driver, reviewer.reviewerAlertSubmitButton());
				reviewer.reviewerAlertSubmitButton().click();
				break;
			} catch (Exception e) {
				if (i == 500) {
					Assert.fail(e.getMessage());
				}
			}
		}
		Thread.sleep(3000);

	}

	@Then("^log in to the reviewer account3$")
	public void log_in_to_the_reviewer_account3() throws IOException, ParseException, InterruptedException {
		// reader = new JsonDataReaderWriter();
		KUBS_Login kubsLogin;
		// testData = excelData.getTestdata("KUBS_FAT_UAT_001_003_01_D1");
		kubsLogin = new KUBS_Login(driver);
		driver.get(config.getApplicationUrl());
		kubsLogin.logintoAzentioappReviewer("Reviewer", testData.get("Reviewer ID"));
		Thread.sleep(1000);

	}

	@Then("^click on the checker Notification$")
	public void click_on_the_checker_notification() throws InterruptedException {
//	    	Thread.sleep(1000);
//			waithelper.waitForElement(driver,3000,kubschecker.checkerNotificationIcon());
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerNotificationIcon());
		kubschecker.checkerNotificationIcon().click();
	}

	@And("^then checker claim the record3$")
	public void then_checker_claim_the_record3() throws InterruptedException, IOException, ParseException {

		// open pool
		waithelper = new WaitHelper(driver);
		kubschecker = new Azentio_CheckerObj(driver);
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubschecker.checkerSecurityManagement(), 20, 1);
		kubschecker.checkerSecurityManagement().click();
		System.out.println("Security management clicked");
		// claim
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubschecker.checkerActionIcon(), 20, 1);
		kubschecker.checkerActionIcon().click();
		System.out.println("Checker clicked on open pool temp view");
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		// waithelper.waitForElement(driver, 5000,
		// driver.findElement(By.xpath(before_xpath + reader.readReferancedata() +
		// after_xpath_claim)));
		for (int i = 0; i < 50; i++) {
			try {
				driver.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath_claim)).click();
				break;
			} catch (Exception e) {
				if (i == 50) {
					Assert.fail(e.getMessage());
				}

			}
		}
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubschecker.checkerAlertClose(), 20, 1);
		clicksAndActionHelper.moveToElement(kubschecker.checkerAlertClose());
		clicksAndActionHelper.clickOnElement(kubschecker.checkerAlertClose());
	}
	

	@And("^select the record and Approve by checker3$")
	public void select_the_record_and_approve_by_checker3() throws InterruptedException, IOException, ParseException {
		// Thread.sleep(2000);
		/*
		 * for (int i = 1; i <= 35; i++) { try { // waithelper.waitForElement(driver,
		 * 3000,driver.findElement(By.xpath("//span[contains(text(),'"
		 * +reader.readReferancedata()+ "')]")));
		 * waithelper.waitForElementwithFluentwait(driver,
		 * driver.findElement(By.xpath("//span[contains(text(),'"
		 * +reader.readReferancedata()+ "')]"))); WebElement referanceID =
		 * driver.findElement(By.xpath("//span[contains(text(),'" +
		 * reader.readReferancedata() + "')]")); referanceID.click();
		 * Assert.assertTrue(referanceID.isDisplayed()); break; } catch
		 * (NoSuchElementException e) {
		 * waithelper.waitForElement(driver,4000,kubschecker.
		 * checker_notification_next_button());
		 * kubschecker.checker_notification_next_button().click(); } }
		 */
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

//				waithelper.waitForElement(driver, 2000, driver.findElement(By.xpath(before_xpath +reader.readReferancedata()+after_xpath)));
		// waithelper.waitForElementwithFluentwait(driver,
		// driver.findElement(By.xpath(before_xpath +reader.readReferancedata()
		// +after_xpath)));
		for (int i = 0; i < 200; i++) {
			try {
				driver.findElement(By.xpath(before_xpath + testData.get("Reference ID") + after_xpath)).click();
				break;
			} catch (Exception e) {

			}
		}

		// Approve
//		    	waithelper.waitForElement(driver,2000,kubschecker.checkerApproveButton());
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerApproveButton());
		kubschecker.checkerApproveButton().click();
//		    	Thread.sleep(1000);
//		    	waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerRemarks());
		clicksAndActionHelper.moveToElement(kubschecker.checkerRemarks());
		clicksAndActionHelper.clickOnElement(kubschecker.checkerRemarks());
		kubschecker.checkerRemarks().sendKeys("Approved by checker");
//				Thread.sleep(2000);
//				waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();
		waithelper.waitForElementToVisibleWithFluentWait(driver, kubschecker.checker_right_corner_green_toast(), 20, 1);

		String toastAlert = kubschecker.checker_right_corner_green_toast().getText();
		System.out.println(toastAlert);
	}

	@And("^Get the test data for the po creation test case4$")
	public void get_the_test_data_for_the_po_creation_test_case4() throws Throwable {

		testData = excelData.getTestdata("KUBS_FAT_UAT_001_003_01_D1");

	}

	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(
			driver);

//	@Then("^search the business partner in po list view$")
//    public void search_the_business_partner_in_po_list_view() throws Throwable {
//        throw new PendingException();
//    }
	@And("^vendor contract PO details should display on PO creation  list view$")
	public void vendor_contract_po_details_should_display_on_po_creation_list_view() throws Throwable {

		System.out.println("Bp Name" + testData.get("BpName"));
		String bpName = testData.get("BpName");
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_verify(), 60, 5);
		Assert.assertEquals(bpName,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_verify().getText());
		System.out.println(aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_verify().getText());

	}

	@And("^store the Po number in GRN excel database$")
	public void store_the_po_number_in_grn_excel_database() throws Throwable {
		waithelper.waitForElementToVisibleWithFluentWait(driver,
				accountPayable_VendorPurchaseOrderObj.accountPayableVendorPurchaseOrderapprovedPo(), 20, 1);
		String poNumber = accountPayable_VendorPurchaseOrderObj.accountPayableVendorPurchaseOrderapprovedPo().getText();
		String bpName = accountPayable_VendorPurchaseOrderObj.accounstPayablePoCreationBpName().getText();
		System.out.println("Aopproved Bp Name " + bpName);
		System.out.println("Aopproved po Number " + poNumber);
		excelDataGRNTestdata.updateTestData("KUBS_FAT_UAT_001_004_01_D1", "GRNPoNumber", poNumber);
		excelDataGRNTestdata.updateTestData("KUBS_FAT_UAT_001_004_01_D1", "GRNbpName", bpName);
		excelDataForAssetCreation.updateTestData("KUBS_FAT_UAT_002_007_D8", "PONumber", poNumber);
	}

	@Then("^search vendor contract details by business partner name3$")
	public void search_vendor_contract_details_by_business_partner_name3() throws Throwable {

		ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(
				driver);
		waithelper.waitForElementwithFluentwait(driver,
				aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BusinessPartnerSearch());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BusinessPartnerSearch()
				.sendKeys(testData.get("BP_Name"));
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_BusinessPartnerSearch().sendKeys(Keys.ENTER);

	}

}
