package stepdefinitions;

import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageobjects.ACCOUNTSPAYABLE_InvoiceBookingObj;
import pageobjects.ACCOUNTSPAYABLE_PayementSettlementObj;
import pageobjects.ACCOUNTSRECEIVABLE_AdvancesObj;
import pageobjects.ARAP_ARandAPObj;
import pageobjects.ARAP_AdjustmentsObj;
import pageobjects.ARAP_GRNCreationPageObject;
import pageobjects.ARAP_PoCreationObj;
import pageobjects.BUDGET_BudgetCreationObj;
import pageobjects.FIXEDASSETS_AssetImpairementObj;
import pageobjects.INVENTORY_EnquiryGlObject;
import pageobjects.InventoryManagamentObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_MakerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;

public class CancellationOfAdvanceToEmployees extends BaseClass {
	WebDriver driver = BaseClass.driver;
	ARAP_GRNCreationPageObject grnObject = new ARAP_GRNCreationPageObject(driver);
	ARAP_PoCreationObj poCreationObj = new ARAP_PoCreationObj(driver);
	KUBS_MakerObj makerObj = new KUBS_MakerObj(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	KUBS_Login kubsLogin = new KUBS_Login(driver);
	KUBS_ReviewerObj kubsReviewerObj = new KUBS_ReviewerObj(driver);
	KUBS_CheckerObj kubsCheckerObj = new KUBS_CheckerObj(driver);
	String poNumber;
	String poBusinessPartner;
	String BPNumber;
	String DebitNo;
	String ADVNumber;
	String ADVAmount;
	ClicksAndActionsHelper clicksAndActionsHelper = new ClicksAndActionsHelper(driver);
	JavascriptHelper javaScriptHelper = new JavascriptHelper();
	JsonDataReaderWriter jsonReaderWriter = new JsonDataReaderWriter();
	ARAP_AdjustmentsObj arapAdjustment = new ARAP_AdjustmentsObj(driver);
	ARAP_ARandAPObj arapObj = new ARAP_ARandAPObj(driver);
	INVENTORY_EnquiryGlObject inventoryEnquiryGlObj = new INVENTORY_EnquiryGlObject(driver);
	InventoryManagamentObj inventoryManagamentObj = new InventoryManagamentObj(driver);
	ACCOUNTSPAYABLE_PayementSettlementObj paymentSettlementObj = new ACCOUNTSPAYABLE_PayementSettlementObj(driver);
	BUDGET_BudgetCreationObj budgetCreationObj = new BUDGET_BudgetCreationObj(driver);
	FIXEDASSETS_AssetImpairementObj assetImpairementObj = new FIXEDASSETS_AssetImpairementObj(driver);
	ACCOUNTSRECEIVABLE_AdvancesObj accuountsReceivableObj = new ACCOUNTSRECEIVABLE_AdvancesObj(driver);
	ACCOUNTSPAYABLE_InvoiceBookingObj invoiceBookingObj = new ACCOUNTSPAYABLE_InvoiceBookingObj(driver);
	Map<String, String> settlementTestData = new HashMap<>();
	Map<String, String> accountsReceivableTestData = new HashMap<>();
	ExcelData excelData = new ExcelData("C:\\Users\\inindc00091\\git\\AzentioAutomationFramework\\ARAP_Excel_priyanka0612\\AzentioAutomationFramework_ARAP_Excel\\Test-data\\KUBS_TESTDATA_V1.xlsx",
			"CancellationOfAdvanceEMPData", "Data Set ID");
	Map<String, String> testData = new HashMap<>();
	String dataSetID;

	@Then("^go to ar ap adjustment module$")
	public void go_to_ar_ap_adjustment_module() throws Throwable {
		Thread.sleep(2000);
		waitHelper.waitForElementToVisibleWithFluentWait(driver, makerObj.kubsToolIcon(), 5, 500);
		makerObj.kubsToolIcon().click();
		waitHelper.waitForElementVisible(makerObj.kubsDirectionIcon(), 2000, 100);
		makerObj.kubsDirectionIcon().click();
		makerObj.kubsAdjustmentsArAp().click();
		waitHelper.waitForElementVisible(arapAdjustment.adjustmentViewButton(), 1000, 100);
		arapAdjustment.adjustmentViewButton().click();
	}

	@Then("^click on search$")
	public void click_on_search() throws Throwable {
		invoiceBookingObj.accountPayable_InvoiceBooking_Search().click();
	}

	@And("^search the Ar cancelled advance in the adjustment screen$")
	public void search_the_ar_cancelled_advance_in_the_adjustment_screen() throws Throwable {
		javaScriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementVisible(arapAdjustment.adjustementSearchARAdvance(), 2000, 100);
		arapAdjustment.adjustementSearchARAdvance().click();
		arapAdjustment.adjustementSearchARAdvance().sendKeys(testData.get("AdjustementItemType"));
		waitHelper.waitForElementVisible(arapAdjustment.adjustementCancelledAdvanceFirstRecord(), 2000, 100);
		arapAdjustment.adjustementCancelledAdvanceFirstRecord().click();
		Thread.sleep(1000);

	}

	@And("^select one record$")
	public void select_one_record() throws Throwable {
		String adjstmentNumber = javaScriptHelper.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[16].value").toString();
		settlementTestData.put("adjustmentNumber", adjstmentNumber);
		System.out.println("Adjustment Reference number" + settlementTestData.get("adjustmentNumber"));
	}

	@Then("^click on report segment button$")
	public void click_on_report_segment_button() throws Throwable {
		Thread.sleep(1500);

		javaScriptHelper.JavaScriptHelper(driver);
		javaScriptHelper.scrollIntoViewAndClick(inventoryManagamentObj.inventoryReportIcon());

//	waithelper.waitForElement(driver, 3000, inventoryManagamentObj.inventoryReportIcon());
//	inventoryManagamentObj.inventoryReportIcon().click();

		// waithelper.waitForElement(driver, 3000,
		// inventoryManagamentObj.inventoryEnquiryMenu());
		// Assert.assertTrue(inventoryManagamentObj.inventoryEnquiryMenu().isDisplayed());

	}

	@And("^click on equiry menu$")
	public void click_on_equiry_menu() throws Throwable {
		waitHelper.waitForElement(driver, 3000, inventoryManagamentObj.inventoryEnquiryMenu());

		inventoryManagamentObj.inventoryEnquiryMenu().click();
		waitHelper.waitForElement(driver, 3000, inventoryManagamentObj.inventoryFinancialTransactionIcon());
		Assert.assertTrue(inventoryManagamentObj.inventoryFinancialTransactionIcon().isDisplayed());

	}

	@Then("^click on edit icon near by fiancial transaction menu$")
	public void click_on_edit_icon_near_by_fiancial_transaction_menu() throws Throwable {
		inventoryEnquiryGlObj.inventoryFinancialTransactionIcon().click();

	}

	@And("^choose branch code$")
	public void choose_branch_code() throws Throwable {
		inventoryEnquiryGlObj.inventoryBranchCode().sendKeys(testData.get("BranchCode"));
		inventoryEnquiryGlObj.inventoryBranchCode().sendKeys(Keys.ENTER);
	}

	@And("^click on transaction from date calender icon$")
	public void click_on_transaction_from_date_calender_icon() throws Throwable {
		inventoryEnquiryGlObj.inventoryFromDate().click();

	}

	@Then("^choose the from date$")
	public void choose_the_from_date() throws Throwable {

		javaScriptHelper.JavaScriptHelper(driver);
		while (true) {
			try {

				waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("Gl Month") + " " + testData.get("Gl Year") + "')]")));
				WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("Gl Month") + " " + testData.get("Gl Year") + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				inventoryEnquiryGlObj.inventoryNextMonth().click();
			}
		}
		WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("Gl FullMonth") + " " + testData.get("Gl Date") + ", " + testData.get("Gl Year") + "']/span"));
		clicksAndActionsHelper.doubleClick(FinalDay);
	}

	@And("^click on the transaction to date calender icon$")
	public void click_on_the_transaction_to_date_calender_icon() throws Throwable {

		waitHelper.waitForElement(driver, 3000, inventoryEnquiryGlObj.inventoryToDate());
		clicksAndActionsHelper.doubleClick(inventoryEnquiryGlObj.inventoryToDate());
		// .click();

	}

	@Then("^choose the to date$")
	public void choose_the_to_date() throws Throwable {
		while (true) {
			try {

				waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("Gl To Month") + " " + testData.get("Gl To Year") + "')]")));
				WebElement monthAndYear = driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("Gl To Month") + " " + testData.get("Gl To Year") + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				inventoryEnquiryGlObj.inventoryNextMonth().click();
			}
		}
		WebElement FinalDay = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("Gl To FullMonth") + " " + testData.get("Gl To Date") + ", " + testData.get("Gl To Year") + "']/span"));
		clicksAndActionsHelper.doubleClick(FinalDay);
	}

	@And("^click on view button$")
	public void click_on_view_button() throws Throwable {
		waitHelper.waitForElement(driver, 3000, inventoryManagamentObj.inventoryViewButton());
		inventoryManagamentObj.inventoryViewButton().click();
		Thread.sleep(3000);
	}

	@Then("^adjustment reference number not availabe in the GL  record$")
	public void adjustment_reference_number_not_availabe_in_the_gl_record() throws Throwable {
		javaScriptHelper.JavaScriptHelper(driver);

		for (int i = 0; i < 299; i++) {
			try {
				waitHelper.waitForElementVisible(driver.findElement(By.xpath("//span[contains(text(),'" + settlementTestData.get("adjustmentNumber") + "')]")), 2000, 100);
				boolean result = driver.findElement(By.xpath("//span[contains(text(),'" + settlementTestData.get("adjustmentNumber") + "')]")).isDisplayed();
				if (result == true) {
					Assert.fail("Data is available ,Hence Expected result is not matched");
				}
				break;

			} catch (NoSuchElementException e) {
				javaScriptHelper.scrollIntoView(inventoryEnquiryGlObj.nextRecord());
				inventoryEnquiryGlObj.nextRecord().click();
			}
		}
	}

	////////////////////////// TC_02////////////////////

	@And("^Goto accounts receivable advances module$")
	public void goto_accounts_receivable_advances_module() throws Throwable {
		waitHelper.waitForElementVisible(makerObj.kubsDirectionIcon(), 1000, 100);
		Thread.sleep(2000);
		makerObj.kubsDirectionIcon().click();
		Thread.sleep(2000);
		makerObj.kubsAccountsReceivable().click();
		waitHelper.waitForElementVisible(accuountsReceivableObj.accountsreceivableAdvancesViewIcon(), 1000, 100);
		accuountsReceivableObj.accountsreceivableAdvancesViewIcon().click();

	}

	@Then("^choose first record in the notification record in GRN stage$")
	public void choose_first_record_in_the_notification_record_in_grn_stage() throws Throwable {
		waitHelper.waitForElement(driver, 3000, grnObject.grnFirstReferenceId());
		String referenceID = grnObject.grnFirstReferenceId().getText();
		/*
		 * addReferanceData(referenceID) This method is a predefined method to store the
		 * reference ID into the Json file
		 */
		jsonReaderWriter.addReferanceData(referenceID);
		clicksAndActionsHelper.moveToElement(grnObject.grnFirstRecord());
		clicksAndActionsHelper.clickOnElement(grnObject.grnFirstRecord());
		// .click();
	}

	@And("^select one record from advances$")
	public void select_one_record_from_advances() throws Throwable {

		accuountsReceivableObj.accountsreceivableAdvancesADVStatusSearch().sendKeys(testData.get("ADVStatus"));
		// datatable-row-wrapper[1]//datatable-body-cell[8]//span

		String advNumber = accuountsReceivableObj.accountsreceivableAdvancesADVNumber().getText();
		accountsReceivableTestData.put("advNumber", advNumber);
		String BpName = accuountsReceivableObj.accountsreceivableAdvancesPoNumber().getText();
		accountsReceivableTestData.put("BpName", BpName);
		System.out.println(accountsReceivableTestData.get("advNumber"));
		System.out.println(accountsReceivableTestData.get("BpName"));
	}

	@And("^click on Add Icon$")
	public void click_on_Add_Icon() throws Throwable {
		for (int i = 0; i < 30; i++) {
			try {
				assetImpairementObj.fixedAssetAddButton().click();
				break;
			} catch (Exception e) {

			}
		}

	}

	@And("^Fill The form for advance adjustment$")
	public void fill_the_form_for_advance_adjustment() throws Throwable {
		waitHelper.waitForElementVisible(arapAdjustment.adjustmentBpName(), 1000, 100);
		arapAdjustment.adjustmentBpName().click();
		arapAdjustment.adjustmentBpName().sendKeys(accountsReceivableTestData.get("BpName"));
		arapAdjustment.adjustmentBpName().sendKeys(Keys.ENTER);
		arapAdjustment.adjustmentadjustmentType().click();
		arapAdjustment.adjustmentadjustmentType().sendKeys(Keys.ENTER);
		arapAdjustment.adjustmentItemType().click();
		arapAdjustment.adjustmentItemType().sendKeys("AR Advances");
		arapAdjustment.adjustmentItemType().sendKeys(Keys.ENTER);
		arapAdjustment.adjustmentAdjustmentReference().click();
		arapAdjustment.adjustmentAdjustmentReference().sendKeys(accountsReceivableTestData.get("advNumber"));
		arapAdjustment.adjustmentAdjustmentReference().sendKeys(Keys.ENTER);
		arapAdjustment.adjustmentSaveButton().click();

	}

	@And("^click notification button$")
	public void click_notification_button() throws Throwable {
		// After save our budget record we have to click on notification to submit our
		// record for approvals
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreationNotificationIcon(), 60, 100);
		budgetCreationObj.budgetCreationNotificationIcon().click();
//		Thread.sleep(1000);

	}

	@And("^click on Submit button$")
	public void click_on_submit_button() throws Throwable {
		// After select the record we have to submit the record for approval
		waitHelper.waitForElement(driver, 3000, budgetCreationObj.budgetCreation_SubmitButton());
		budgetCreationObj.budgetCreation_SubmitButton().click();

	}

	@Then("^enter remark in confirmation alert$")
	public void enter_remark_in_confirmation_alert() throws Throwable {
		javaScriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_AlertRemarks(), 60, 500);
		javaScriptHelper.JSEClick(budgetCreationObj.budgetCreation_AlertRemarks());
		/*
		 * After click on submit button one alert will open we have to enter the alert
		 * remark And click on the submit button
		 */
		budgetCreationObj.budgetCreation_AlertRemarks().sendKeys(testData.get("Remark"));

	}

	@Then("^click on submit button in alert$")
	public void click_on_submit_button_in_alert() throws Throwable {
		try {
			budgetCreationObj.budgetCreation_AlertsubmitButton().click();
		} catch (ElementClickInterceptedException clickException) {
//			Thread.sleep(1000);
			budgetCreationObj.budgetCreation_AlertRemarks().click();
			budgetCreationObj.budgetCreation_AlertRemarks().sendKeys(testData.get("Remark"));
			budgetCreationObj.budgetCreation_AlertsubmitButton().click();
		}
	}

	@And("^capture the reviewer ID in pop up which is open when we submit our record in maker stage$")
	public void capture_the_reviewer_id_in_pop_up_which_is_open_when_we_submit_our_record_in_maker_stage() throws Throwable {
		/*
		 * After maker submit the record reviewer iD will get auto generated in toast
		 * alert and we have to locate that alert and extract the ID from the alert(That
		 * reviewer ID is extracted with one dot By the help of that string buffer class
		 * 
		 */

		waitHelper.waitForElement(driver, 2000, budgetCreationObj.budgetCreation_ReviewerId());
		String reviwerId = budgetCreationObj.budgetCreation_ReviewerId().getText();
		System.out.println(reviwerId);
		String trimmerReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmerReviewerID);
		StringBuffer finalReviewerID = sb.deleteCharAt(trimmerReviewerID.length() - 1);
		String revID = finalReviewerID.toString();
		System.out.println("Reviewer ID is" + revID);
		jsonReaderWriter.addData(revID);
		budgetCreationObj.budgetCreationAlertClose().click();

	}

	@Then("^logout from maker$")
	public void logout_from_maker() throws Throwable {
		/*
		 * Then we have to logout from maker
		 */
		budgetCreationObj.budgetCreationUserName().click();
//		Thread.sleep(1000);		
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreationLogoutButton(), 90, 500);
		clicksAndActionsHelper.moveToElement(budgetCreationObj.budgetCreationLogoutButton());
		budgetCreationObj.budgetCreationLogoutButton().click();
	}

	@And("^login with reviewer credentials$")
	public void login_with_reviewer_credentials() throws Throwable {

		String userType = "Reviewer";
		/*
		 * Then we have to login with reviewer and continue the approval process
		 */
		Thread.sleep(3000);
		kubsLogin.logintoAzentioappReviewer(userType, jsonReaderWriter.readdata());

	}

	@Then("^click on notification button$")
	public void click_on_notification_button() throws Throwable {
		/*
		 * After successful login our first step is to click on the notification icon
		 */
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsReviewerObj.reviewerNotidicationIcon(), 60, 500);
		kubsReviewerObj.reviewerNotidicationIcon().click();

	}

	@And("^select our record in notification records using reference ID$")
	public void select_our_record_in_notification_records_using_reference_id() throws Throwable {
		/*
		 * After click on the notification icon lot of records will shown there, We have
		 * to select our record by the help of reference ID which is captured in maker
		 * stage
		 *
		 * before_xpath and after_xpath string variable are used to customize the xpath
		 * as per our reference ID
		 */
		// Thread.sleep(1000);
		javaScriptHelper.JavaScriptHelper(driver);
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
		for (int i = 0; i <= 300; i++) {
			try {
				waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath(before_xpath + jsonReaderWriter.readReferancedata() + after_xpath)));
				javaScriptHelper.JSEClick(driver.findElement(By.xpath(before_xpath + jsonReaderWriter.readReferancedata() + after_xpath)));
				// driver.findElement(By.xpath(before_xpath +
				// jsonReaderWriter.readReferancedata() + after_xpath)).click();
				break;
			} catch (Exception e) {
				if (i == 300) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@Then("^Approve the record from reviewer$")
	public void approve_the_budget_record_from_reviewer() throws Throwable {
		/*
		 * after verification we have to submit the record
		 * 
		 * approveButton() function contains the xpath for the approve button
		 */

		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsReviewerObj.reviewerApproveButton(), 60, 500);
		kubsReviewerObj.reviewerApproveButton().click();

	}

	@And("^enter the remark in alert$")
	public void enter_the_remark_in_alert() throws Throwable {

		waitHelper.waitForElement(driver, 3000, kubsReviewerObj.reviewerAlertRemarks());
		kubsReviewerObj.reviewerAlertRemarks().click();
		kubsReviewerObj.reviewerAlertRemarks().sendKeys(testData.get("Remark by Reviewer"));
	}

	@Then("^click on submit in alert$")
	public void click_on_submit_in_alert() throws Throwable {
		while (true) {

			try {
				waitHelper.waitForElement(driver, 3000, kubsReviewerObj.reviewerAlertSubmitButton());
				kubsReviewerObj.reviewerAlertSubmitButton().click();
				break;
			} catch (ElementClickInterceptedException e) {
				kubsReviewerObj.reviewerAlertRemarks().click();
				kubsReviewerObj.reviewerAlertRemarks().sendKeys(testData.get("Remark by Reviewer"));
			}
		}
	}

	@Then("^verify the approval status of the record$")
	public void verify_the_approval_status_of_the_record() throws Throwable {
		/*
		 * After clicked on the approve button we have to verify the record is approved
		 * or not By the help of toast alert.
		 * 
		 * reviewerApprovalStatus() this function have the xpath for that particular
		 * alert (That alert is present only 3 mins so we have to locate that and get
		 * the text for that alert)
		 * 
		 * We can use assert function for verification
		 */
		waitHelper.waitForElement(driver, 3000, kubsReviewerObj.reviewerApprovalStatus());
		String approval_status = kubsReviewerObj.reviewerApprovalStatus().getText();
		Assert.assertEquals(approval_status, "Record is available in CHECKER's Open Pool with status PENDING");

	}

	@And("^logout from reviewer$")
	public void logout_from_reviewer() throws Throwable {
		/*
		 * Then we have to logout from reviewer and start with checker approval
		 */
		while (true) {
			try {
				javaScriptHelper.JavaScriptHelper(driver);
				kubsReviewerObj.reviewerAlertClose().click();
				kubsReviewerObj.reviewerUserName().click();
				waitHelper.waitForElement(driver, 3000, kubsReviewerObj.reviewerLogoutButton());
				javaScriptHelper.JSEClick(kubsReviewerObj.reviewerLogoutButton());
				break;
			} catch (StaleElementReferenceException e) {

			}
		}
	}

	/* *** checker steps ***** */

	@Then("^login as a checker$")
	public void login_as_a_checker() throws Throwable {
		/*
		 * By the help of following step we can login as a checker
		 */
		Thread.sleep(3000);
		kubsLogin.loginToAzentioAppAsChecker("Checker");

	}

	@And("^click on security management menu in checker$")
	public void click_on_security_management_menu_in_checker() throws Throwable {
		while (true) {

			try {
				waitHelper.waitForElementVisible(kubsCheckerObj.checkerSecurityManagement(), 1000, 100);
				kubsCheckerObj.checkerSecurityManagement().click();
				break;
			} catch (StaleElementReferenceException staleElement) {
				System.out.println(staleElement.getMessage());
			}
		}
	}

	@Then("^click on action button under security management menu$")
	public void click_on_action_button_under_security_management_menu() throws Throwable {

		javaScriptHelper.JSEClick(kubsCheckerObj.checkerActionIcon());

	}

	@And("^select our record and clime using reference ID$")
	public void select_our_budget_record_and_clime_using_reference_id() throws Throwable {
		/*
		 * after click on the action button we have to clime the particular our record
		 * by the help of reference ID
		 * 
		 * try catch block is used for avoid stalelementReference Exception
		 */
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		javaScriptHelper.JSEClick(kubsCheckerObj.checkerActionIcon());
		for (int i = 0; i <= 100; i++) {
			try {
//			waitHelper.waitForElementToVisibleWithFluentWait(driver,
//				driver.findElement(By.xpath(before_xpath + jsonReaderWriter.readReferancedata() + after_xpath_claim)),
//				80, 500);
				WebElement climeButton = driver.findElement(By.xpath(before_xpath + jsonReaderWriter.readReferancedata() + after_xpath_claim));

				boolean bool = climeButton.isDisplayed();
				clicksAndActionsHelper.clickOnElement(climeButton);

				// after clicking on the clime button , clime successful message will came we

				Assert.assertTrue(bool);
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@Then("^click on Notification button$")
	public void cliick_on_notification_button() throws Throwable {
		javaScriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCheckerObj.checkerAlertClose(), 80, 500);
		for (int i = 0; i <= 15; i++) {
			try {
				kubsCheckerObj.checkerAlertClose().click();
				break;
			} catch (Exception e) {
				if (i == 15) {
					Assert.fail(e.getMessage());
				}
			}
		}
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCheckerObj.checkerNotificationIcon(), 60, 500);
		javaScriptHelper.JSEClick(kubsCheckerObj.checkerNotificationIcon());
		// clickAndActions.clickOnElement(kubsCheckerObj.checkerNotificationIcon());

	}

	@Then("^select our record in notification records by the help of reference ID$")
	public void select_our_record_in_notification_records_by_the_help_of_reference_id() throws Throwable {
		/*
		 * After clime our record the record will go to notification we have to capture
		 * the our record by the help of reference ID
		 */

		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button";
		for (int i = 0; i <= 100; i++) {
			try {
//				waitHelper.waitForElementToVisibleWithFluentWait(driver,
//						driver.findElement(By.xpath(before_xpath + jsonReaderWriter.readReferancedata() + after_xpath)),
//						100, 500);
				clicksAndActionsHelper.moveToElement(driver.findElement(By.xpath(before_xpath + jsonReaderWriter.readReferancedata() + after_xpath)));
				clicksAndActionsHelper.doubleClick(driver.findElement(By.xpath(before_xpath + jsonReaderWriter.readReferancedata() + after_xpath)));
				break;
			} catch (Exception e) {
				if (i == 100) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^click on approve button in checker stage$")
	public void click_on_approve_button_in_checker_stage() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCheckerObj.checkerApproveButton(), 60, 500);
		kubsCheckerObj.checkerApproveButton().click();

	}

	@Then("^give alert remark$")
	public void give_alert_remark() throws Throwable {
		javaScriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCheckerObj.checkerRemarks(), 60, 500);
		clicksAndActionsHelper.clickOnElement(kubsCheckerObj.checkerRemarks());
		kubsCheckerObj.checkerRemarks().sendKeys(testData.get("Remark by Checker"));
	}

	@Then("^click on submit button on alert$")
	public void click_on_submit_button_on_alert() throws Throwable {

		try {
			waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCheckerObj.checkersubmitButton(), 60, 500);
			kubsCheckerObj.checkersubmitButton().click();
		} catch (Exception e) {
			waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCheckerObj.checkerRemarks(), 60, 500);
			clicksAndActionsHelper.clickOnElement(kubsCheckerObj.checkerRemarks());
			kubsCheckerObj.checkerRemarks().sendKeys(testData.get("Remark by Checker"));
			waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCheckerObj.checkersubmitButton(), 60, 500);
			kubsCheckerObj.checkersubmitButton().click();
		}

	}

	@And("^verify the record got approved from checker$")
	public void verify_the_record_got_approved_from_checker() throws Throwable {
		/*
		 * After clicked on the approve button we have to verify the record is approved
		 * or not By the help of toast alert.
		 * 
		 * checkerApprovalStatus() this function have the xpath for that particular
		 * alert (That alert is present only 3 mins so we have to locate that and get
		 * the text for that alert)
		 * 
		 * We can use assert function for verification
		 * 
		 */
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCheckerObj.checkerApprovalStatus(), 60, 500);
		String approvalStatusForChecker = kubsCheckerObj.checkerApprovalStatus().getText();
		Assert.assertEquals(approvalStatusForChecker, "Record APPROVED successfully");
	}

	@Then("^logout from checker$")
	public void logout_from_checker() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCheckerObj.checkerAlertClose(), 60, 500);
		kubsCheckerObj.checkerAlertClose().click();
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCheckerObj.checkerUserName(), 60, 500);
		kubsCheckerObj.checkerUserName().click();
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCheckerObj.checkerLogoutButton(), 60, 500);
		clicksAndActionsHelper.moveToElement(kubsCheckerObj.checkerLogoutButton());
		kubsCheckerObj.checkerLogoutButton().click();
	}

	@And("^Go to payment settlement module$")
	public void go_to_payment_settlement_module() throws Throwable {
		waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementViewIcon(), 1000, 100);
		paymentSettlementObj.accountsPayablePayementSettlementViewIcon().click();
		Thread.sleep(1000);

	}

	@And("^fill the form for cancelled advances$")
	public void fill_the_form_for_cancelled_advances() throws Throwable {
		waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementPaymentOption(), 1000, 100);
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().click();
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().sendKeys(testData.get("PaymentOptionForCancelledAdvance"));
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().sendKeys(Keys.ENTER);
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().click();
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().sendKeys(accountsReceivableTestData.get("BpName"));
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().sendKeys(Keys.DOWN);
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}

	@And("^find the invoice reference number for cancelled advance is not availabe at the billing queue$")
	public void find_the_invoice_reference_number_for_cancelled_advance_is_not_availabe_at_the_billing_queue() throws Throwable {
		Thread.sleep(3000);
		javaScriptHelper.JavaScriptHelper(driver);
		// javaScriptHelper.scrollDownByPixel();
		for (int i = 0; i <= 30; i++) {
			try {
				waitHelper.waitForElementVisible(driver.findElement(By.xpath("//div[contains(text(),'" + accountsReceivableTestData.get("advNumber") + "')]")), 1000, 100);
				driver.findElement(By.xpath("//div[contains(text(),'" + accountsReceivableTestData.get("advNumber") + "')]")).isDisplayed();
				// Assert.assertFalse(result);

			} catch (NoSuchElementException e) {
				// waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementNextRecord(),
				// 1000, 100);
				// try

				try {
					javaScriptHelper.scrollIntoViewAndClick(paymentSettlementObj.accountsPayablePayementSettlementNextRecord());
					// paymentSettlementObj.accountsPayablePayementSettlementNextRecord().click();
				} catch (ElementNotInteractableException e5) {

				}
			}
			if (i == 3) {
				System.out.println("This is the end of the table Reference Number is not availabe ");
				break;

			}
		}

	}

	///////////////////////// TC_03////////////////////////

	@And("^select the advance to employee active record$")
	public void select_the_advance_to_employee_active_record() throws Throwable {
		// input[@placeholder='Search Receivable Name']
		waitHelper.waitForElementVisible(accuountsReceivableObj.accountsReceivablereceivableName(), 2000, 100);
		accuountsReceivableObj.accountsReceivablereceivableName().click();
		accuountsReceivableObj.accountsReceivablereceivableName().sendKeys(testData.get("RecevableName"));
		for (int row = 1; row < 7; row++) {
			// datatable-row-wrapper[1]/datatable-body-row[1]//datatable-body-cell[8]/div[1]/span[1]
			waitHelper.waitForElementVisible(driver.findElement(By.xpath("//datatable-row-wrapper[" + row + "]/datatable-body-row[1]//datatable-body-cell[8]/div[1]/span[1]")), 2000, 100);
			String receivableStatus = driver.findElement(By.xpath("//datatable-row-wrapper[" + row + "]/datatable-body-row[1]//datatable-body-cell[8]/div[1]/span[1]")).getText();
			System.out.println("Receivable STatus is " + receivableStatus);

			try {
				Assert.assertEquals(receivableStatus, "Active");
				Thread.sleep(2000);
				String advNumber = driver.findElement(By.xpath("//datatable-row-wrapper[" + row + "]/datatable-body-row[1]//datatable-body-cell[4]/div[1]/span[1]")).getText();
				String bpName = driver.findElement(By.xpath("//datatable-row-wrapper[" + row + "]/datatable-body-row[1]//datatable-body-cell[5]/div[1]/span[1]")).getText();
				accountsReceivableTestData.put("advNumber", advNumber);
				accountsReceivableTestData.put("BpName", bpName);
				System.out.println(accountsReceivableTestData.get("advNumber"));
				System.out.println(accountsReceivableTestData.get("BpName"));
				break;
			} catch (AssertionError e) {
				System.out.println("No match Try again");
			}

		}
	}

	@And("^go to aacounts payable module$")
	public void go_to_aacounts_payable_module() throws Throwable {
		waitHelper.waitForElementVisible(makerObj.kubsDirectionIcon(), 2000, 100);
		makerObj.kubsDirectionIcon().click();
		waitHelper.waitForElementVisible(makerObj.kubsAccountsPayable(), 2000, 100);
		makerObj.kubsAccountsPayable().click();
	}

	@And("^fill the form for settlement$")
	public void fill_the_form_for_settlement() throws Throwable {
		javaScriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayablePayementSettlementPaymentOption(), 1000, 100);
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().click();
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().sendKeys(testData.get("PaymentOptionForCancelledAdvance"));
		paymentSettlementObj.accountsPayablePayementSettlementPaymentOption().sendKeys(Keys.ENTER);
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().click();
		System.out.println(accountsReceivableTestData.get("advNumber"));
		System.out.println(accountsReceivableTestData.get("BpName"));
		Thread.sleep(1000);
		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().sendKeys(accountsReceivableTestData.get("BpName"));

		paymentSettlementObj.accountsPayablePayementSettlementBpNAme().sendKeys(Keys.ENTER);
		// div[contains(text(),'ADV_36_2422022')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[3]/ion-checkbox
		Thread.sleep(1000);
		for (int i = 1; i <= 15; i++) {
			if (i == 15) {
				Assert.fail("Record not available");
			}
			try {

				javaScriptHelper.scrollIntoViewAndClick(driver.findElement(By.xpath(
						"//div[contains(text(),'" + accountsReceivableTestData.get("advNumber") + "')]//ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell[3]//ion-checkbox")));
				break;
			} catch (NoSuchElementException e) {
				javaScriptHelper.scrollIntoView(paymentSettlementObj.accountsPayablePayementSettlementNextRecord());

				paymentSettlementObj.accountsPayablePayementSettlementNextRecord().click();
			}
		}
// javaScriptHelper.JSEClick(paymentSettlementObj.firstRecord());
// clicksAndActionsHelper.doubleClick(paymentSettlementObj.firstRecord());
		javaScriptHelper.scrollIntoView(paymentSettlementObj.accountsPayablePayementSettlementValueDate());
		paymentSettlementObj.accountsPayablePayementSettlementValueDate().click();
		Thread.sleep(1000);
		while (true) {
			try {

				waitHelper.waitForElement(driver, 5000, driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("MonthYear") + "')]")));
				driver.findElement(By.xpath("//span[contains(text(),'" + testData.get("MonthYear") + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				waitHelper.waitForElement(driver, 5000, paymentSettlementObj.accountsPayable_paymentSettlemen_NextMonth());
				paymentSettlementObj.accountsPayable_paymentSettlemen_NextMonth().click();
			}
		}

		waitHelper.waitForElement(driver, 5000, driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth") + " " + testData.get("Date") + ", " + testData.get("Year") + "']/span")));
		WebElement Click = driver.findElement(By.xpath("//td[@aria-label='" + testData.get("FullMonth") + " " + testData.get("Date") + ", " + testData.get("Year") + "']/span"));

		clicksAndActionsHelper.doubleClick(Click);
		paymentSettlementObj.accountsPayableDescription().click();
		paymentSettlementObj.accountsPayableDescription().sendKeys("Ok");
	}

	@And("^Save the form$")
	public void Save_the_form() throws Throwable {
		Thread.sleep(1000);
		// paymentSettlementObj.firstRecord().click();
		waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayableSaveButton(), 2000, 100);
		paymentSettlementObj.accountsPayableSaveButton().click();
		// clicksAndActionsHelper.doubleClick(paymentSettlementObj.accountsPayableSaveButton());
		// paymentSettlementObj.accountsPayableSaveButton().click();
		waitHelper.waitForElementVisible(paymentSettlementObj.accountsPayableAlertYes(), 2000, 100);
		paymentSettlementObj.accountsPayableAlertYes().click();
		Thread.sleep(1000);
	}

	@Then("^choose first record in the notification record$")
	public void choose_first_record_in_the_notification_record() throws Throwable {
		/*
		 * After click on notification we can see the record which we saved now and we
		 * have to select that along with the records reference ID We have to store the
		 * reference ID into the JSon file so that we can call the data in reviewer and
		 * checker stage
		 */
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreationFirstReferenceId(), 60, 500);
		String referenceID = budgetCreationObj.budgetCreationFirstReferenceId().getText();
		/*
		 * addReferanceData(referenceID) This method is a predefined method to store the
		 * reference ID into the Json file
		 */
		jsonReaderWriter.addReferanceData(referenceID);
		budgetCreationObj.budgetCreationFirstRecord().click();

	}

	@Then("^check the settlement completed advance can be cancelled$")
	public void check_the_settlement_completed_advance_can_be_cancelled() throws Throwable {
		waitHelper.waitForElementVisible(arapAdjustment.adjustmentBpName(), 1000, 100);
		arapAdjustment.adjustmentBpName().sendKeys(accountsReceivableTestData.get("BpName"));
		arapAdjustment.adjustmentBpName().sendKeys(Keys.ENTER);
		arapAdjustment.adjustmentadjustmentType().click();
		arapAdjustment.adjustmentadjustmentType().sendKeys(Keys.ENTER);
		arapAdjustment.adjustmentItemType().click();
		arapAdjustment.adjustmentItemType().sendKeys(testData.get("AdjustementItemType"));
		arapAdjustment.adjustmentItemType().sendKeys(Keys.ENTER);
		arapAdjustment.adjustmentAdjustmentReference().click();
		arapAdjustment.adjustmentAdjustmentReference().sendKeys(accountsReceivableTestData.get("advNumber"));
		waitHelper.waitForElementVisible(arapAdjustment.adjustmentAdjustmentReferenceNodata(), 2000, 100);
		boolean result = arapAdjustment.adjustmentAdjustmentReferenceNodata().isDisplayed();
		Assert.assertTrue(result);
		// driver.close();
	}

	///////////////////////// 003_009_TC_01////////////////////////

	@And("^goto arap adjustment main module$")
	public void goto_arap_adjustment_main_module() throws Throwable {
		waitHelper.waitForElementVisible(makerObj.kubsDirectionIcon(), 2000, 100);
		makerObj.kubsDirectionIcon().click();
	}

	@Then("^Click on Accounts Receive Advances Eye Icon$")
	public void click_on_accounts_receive_advances_eye_icon() throws Throwable {
		// ---------------ADVANCE EYE ICON----------------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountsReceivable_Advance_Eye());
		arapObj.accountsReceivable_Advance_Eye().click();
	}

	@Then("^Enter Cancelled Value In Advance Status$")
	public void enter_cancelled_value_in_advance_status() throws Throwable {
		// ----------GIVE DETAILS FOR SEARCH-----------//
		waitHelper.waitForElement(driver, 2000, arapObj.accountsReceivable_Advance_ReceivableName());
		arapObj.accountsReceivable_Advance_ReceivableName().click();
		arapObj.accountsReceivable_Advance_ReceivableName().sendKeys(testData.get("ReceivableName"));
		waitHelper.waitForElement(driver, 2000, arapObj.accountsReceivable_Advance_ADVstatus());
		arapObj.accountsReceivable_Advance_ADVstatus().click();
		arapObj.accountsReceivable_Advance_ADVstatus().sendKeys(testData.get("GRN Status"));
	}

	@And("^Get The Business Partner and Advance Number$")
	public void get_the_business_partner_and_advance_number() throws Throwable {
//		waitHelper.waitForElement(driver, 2000, arapObj.accountsReceivable_Advance_GetBp());
		waitHelper.waitForElementwithFluentwait(driver, arapObj.accountsReceivable_Advance_GetBp());
		BPNumber = arapObj.accountsReceivable_Advance_GetBp().getText();
		System.out.println(BPNumber);

		javaScriptHelper.JavaScriptHelper(driver);
		ADVNumber = (String) javaScriptHelper.executeScript("return document.getElementsByName('advanceNo')[1].value");
		System.out.println(ADVNumber);

		javaScriptHelper.JavaScriptHelper(driver);
		ADVAmount = (String) javaScriptHelper.executeScript("return document.getElementsByClassName('form__field ng-untouched ng-pristine ng-valid')[0].value");
		System.out.println(ADVAmount);
	}

//	@Then("^Verify No accounting entry is generated on cancelling advances against PO$")
//	public void verify_no_accounting_entry_is_generated_on_cancelling_advances_against_po() throws Throwable {
//		javaScriptHelper.JavaScriptHelper(driver);
//		Thread.sleep(1000);
//		for (int i = 0; i <= 299; i++) {
//			try {
//
//				driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'" + ADVNumber + "')])[1]")).isDisplayed();
//
//				driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'" + ADVNumber + "')])[1]"));
//				String TransactionType = driver
//						.findElement(By
//								.xpath("(//datatable-body-cell[1]//span[contains(text(),' " + ADVNumber + " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[5]//span)[1]"))
//						.getText();
//				System.out.println("TransactionType is " + TransactionType);
//				String amount = driver
//						.findElement(By
//								.xpath("(//datatable-body-cell[1]//span[contains(text(),' " + ADVNumber + " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[6]//span)[1]"))
//						.getText();
//				System.out.println("Amount is " + amount);
//				break;
//
//			} catch (NoSuchElementException e) {
//				javaScriptHelper.scrollIntoView(arapObj.accountsPayablePayementSettlementNextRecord());
//				arapObj.accountsPayablePayementSettlementNextRecord().click();
//			}
//		}
//		for (int i = 0; i <= 299; i++) {
//			try {
//
//				driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'" + ADVNumber + "')])[2]")).isDisplayed();
//
//				driver.findElement(By.xpath("(//datatable-body-cell[1]//span[contains(text(),'" + ADVNumber + "')])[1]"));
//				String TransactionType = driver
//						.findElement(By
//								.xpath("(//datatable-body-cell[1]//span[contains(text(),' " + ADVNumber + " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[5]//span)[2]"))
//						.getText();
//				System.out.println("TransactionType is " + TransactionType);
//				String amount = driver
//						.findElement(By
//								.xpath("(//datatable-body-cell[1]//span[contains(text(),' " + ADVNumber + " ')]/ancestor::datatable-body-cell[1]/following-sibling::datatable-body-cell[6]//span)[2]"))
//						.getText();
//				System.out.println("Amount is " + amount);
//				break;
//
//			} catch (NoSuchElementException e) {
//				javaScriptHelper.scrollIntoView(arapObj.accountsPayablePayementSettlementNextRecord());
//				arapObj.accountsPayablePayementSettlementNextRecord().click();
//			}
//
//		}
//	}
	
	@Then("^select data set ID for verify no accounting entries for cancelling advance to employee$")
    public void select_data_set_id_for_verify_no_accounting_entries_for_cancelling_advance_to_employee() throws Throwable {
		dataSetID = "KUBS_AR_AP_UAT_003_008_TC_01_D1";
		testData = excelData.getTestdata(dataSetID);
    }
	
	@Then("^select data set ID for verify cancelled adcance is not available for payment settlement$")
	public void select_data_set_id_for_verify_cancelled_adcance_is_not_available_for_payment_settlement() throws Throwable {
		dataSetID = "KUBS_AR_AP_UAT_003_008_TC_02_D1";
		testData = excelData.getTestdata(dataSetID);
	}
	
	@Then("^select data set ID for Verify cancelling Advance To employee is not allowed if the same has been adjusted$")
	public void select_data_set_id_for_verify_cancelling_advance_to_employee_is_not_allowed_if_the_same_has_been_adjusted() throws Throwable {
		dataSetID = "KUBS_AR_AP_UAT_003_008_TC_03_D1";
		testData = excelData.getTestdata(dataSetID);
	}

}