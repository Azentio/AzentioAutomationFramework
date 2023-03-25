package stepdefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.json.simple.parser.ParseException;
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
import io.cucumber.java.en.When;
import pageobjects.ACCOUNTSPAYABLE_VendorContractsObj;
import pageobjects.AccountPayable_VendorPurchaseOrderObj;
import pageobjects.AccountsPayable_GrnObj;
import pageobjects.Azentio_ReviewerObj;
import pageobjects.BUDGET_BudgetTransferObj;
import pageobjects.INVENTORY_MANAGEMENT_PurchaseRequitionConfirmationObj;
import pageobjects.InventoryManagamentObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.ExcelData;
import resources.JsonDataReaderWriter;
import utilities.ExtentTestManager;

public class InventoryManagement_GRN {
	WebDriver driver = BaseClass.driver;
	KUBS_Login login = new KUBS_Login(driver);
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);
	Azentio_ReviewerObj reviewer = new Azentio_ReviewerObj(driver);;
	ConfigFileReader config = new ConfigFileReader();
	ACCOUNTSPAYABLE_VendorContractsObj aCCOUNTSPAYABLE_VendorContractsObj = new ACCOUNTSPAYABLE_VendorContractsObj(driver);
	WaitHelper waithelper = new WaitHelper(driver);
	JavascriptHelper javascripthelper = new JavascriptHelper(driver);
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	BrowserHelper browserHelper;
	AccountsPayable_GrnObj accountsPayable_GRNObj = new AccountsPayable_GrnObj(driver);
	AccountPayable_VendorPurchaseOrderObj accountPayable_VendorPurchaseOrderObj = new AccountPayable_VendorPurchaseOrderObj(driver);
	InventoryManagamentObj inventoryManagamentObj = new InventoryManagamentObj(driver);
	BUDGET_BudgetTransferObj budgetTransferObj = new BUDGET_BudgetTransferObj(driver);
	ExcelData excelData = new ExcelData("C:\\Users\\ININDC00091\\git\\AzentioAutomationFramework\\DeveshFW_Excel\\ARAP_AzentioAutomationFramework_Excel\\Test-data\\KUBS_InventoryMgmt_TestData.xlsx",
			"GRNTestData", "Data Set ID");
	Map<String, String> testData = new HashMap<>();
	String dataSetID;

	@Then("^Click on Direction icon$")
	public void click_on_direction_icon() throws InterruptedException {
//		Thread.sleep(2000);
		waithelper.waitForElementwithFluentwait(driver, accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_DirectionIcon());
		accountPayable_VendorPurchaseOrderObj.accountsPayable_VendorPurchaseOrder_DirectionIcon().click();

	}

	@Then("^click on first eye button to get the po number$")
	public void click_on_first_eye_button_to_get_the_po_number() throws InterruptedException, IOException {
		waithelper.waitForElementwithFluentwait(driver, accountPayable_VendorPurchaseOrderObj.accountPayable_VendorPurchaseOrder_FirstEyeButton());
		accountPayable_VendorPurchaseOrderObj.accountPayable_VendorPurchaseOrder_FirstEyeButton().click();
//		Thread.sleep(2000);
		String ponumber = javascripthelper.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[2].value").toString();
		System.out.println("PO Number: " + ponumber);
		excelData.updateTestData(dataSetID, "PoNumber", ponumber);
		testData = excelData.getTestdata(dataSetID);

	}
	
	@Then("^Fill the form for GRN record$")
    public void fill_the_form_for_grn_record() throws Throwable {
    waithelper.waitForElementwithFluentwait(driver, accountsPayable_GRNObj.accountPayable_GrnBpName());
    accountsPayable_GRNObj.accountPayable_GrnBpName().click(); 
	accountsPayable_GRNObj.accountPayable_GrnBpName().sendKeys(testData.get("BPName"));
	accountsPayable_GRNObj.accountPayable_GrnBpName().sendKeys(Keys.ENTER);
	
	waithelper.waitForElementwithFluentwait(driver, accountsPayable_GRNObj.accountsPayable_Grn_BpBranch());
    accountsPayable_GRNObj.accountsPayable_Grn_BpBranch().click();
	accountsPayable_GRNObj.accountsPayable_Grn_BpBranch().sendKeys(testData.get("BPBranch"));
	accountsPayable_GRNObj.accountsPayable_Grn_BpBranch().sendKeys(Keys.ENTER);
	Random random = new Random();
	int randomNum=random.nextInt(5000-2500)+2500;
	waithelper.waitForElementwithFluentwait(driver, accountsPayable_GRNObj.accountPayable_GrnInvoiceNumber());
	accountsPayable_GRNObj.accountPayable_GrnInvoiceNumber().click(); 
	accountsPayable_GRNObj.accountPayable_GrnInvoiceNumber().sendKeys(testData.get("InvoiceNumber")+randomNum);
	accountsPayable_GRNObj.accountPayable_GrnInvoiceNumber().sendKeys(Keys.ENTER);
		
	waithelper.waitForElementwithFluentwait(driver, accountsPayable_GRNObj.accountPayable_GrnDeliveryLocation());
    accountsPayable_GRNObj.accountPayable_GrnDeliveryLocation().click();
	accountsPayable_GRNObj.accountPayable_GrnDeliveryLocation().sendKeys(testData.get("DeliveryLocation"));
	accountsPayable_GRNObj.accountPayable_GrnDeliveryLocation().sendKeys(Keys.ENTER);
	
	waithelper.waitForElementwithFluentwait(driver, accountsPayable_GRNObj.accountPayable_Grn_SaveButton());
    accountsPayable_GRNObj.accountPayable_Grn_SaveButton().click();
	
	for (int i = 1; i <= 20; i++) {
		try {
			waithelper.waitForElementwithFluentwait(driver, accountsPayable_GRNObj.MessageContent());
			String msg1 = accountsPayable_GRNObj.MessageContent().getText();
			System.out.println(msg1);
			waithelper.waitForElementwithFluentwait(driver, accountsPayable_GRNObj.ConfirmationMessageCloseButton());
			accountsPayable_GRNObj.ConfirmationMessageCloseButton().click();
			break;
		} catch (Exception e) {
		}
	}
//	Thread.sleep(2000);
	for (int i = 1; i <= 20; i++) {
		try {
			waithelper.waitForElementwithFluentwait(driver, accountsPayable_GRNObj.MessageContent());
			String msg2 = accountsPayable_GRNObj.MessageContent().getText();
			System.out.println(msg2);
			waithelper.waitForElementwithFluentwait(driver, accountsPayable_GRNObj.ConfirmationMessageCloseButton());
			accountsPayable_GRNObj.ConfirmationMessageCloseButton().click();
			break;
		} catch (Exception e) {
		}
	}
}


	@Then("^Click on save button to save the record$")
	public void click_on_save_button_to_save_the_record() throws Throwable {
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryManagament_InventoryRequest_SaveButton());
		inventoryManagamentObj.inventoryManagament_InventoryRequest_SaveButton().click();
		
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.inventoryManagament_InventoryRequest_PopupCloseButton());
		inventoryManagamentObj.inventoryManagament_InventoryRequest_PopupCloseButton().click();

	}

	@Then("^Click on notification & open record which we created for GRN$")
	public void click_on_notification_open_record_which_we_created_for_grn() throws Throwable {
		waithelper.waitForElementwithFluentwait(driver, budgetTransferObj.budget_BudgetTransfer_NotificationIcon());
		budgetTransferObj.budget_BudgetTransfer_NotificationIcon().click();

		waithelper.waitForElementwithFluentwait(driver, budgetTransferObj.budget_BudgetTransfer_FirstReferenceId());
		String id = budgetTransferObj.budget_BudgetTransfer_FirstReferenceId().getText();
		
		excelData.updateTestData(dataSetID, "ReferenceID", id);
		testData = excelData.getTestdata(dataSetID);
		System.out.println("Reference ID:" + id);
		
		for (int i = 1; i <= 35; i++) {
			try {
				waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[text()='" + testData.get("ReferenceID") + "']")));
				WebElement referanceID = driver.findElement(By.xpath("//span[text()='" + testData.get("ReferenceID") + "']"));
				referanceID.click();
				System.out.println(referanceID);
				// Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElementwithFluentwait(driver, budgetTransferObj.maker_notification_next_button());
				budgetTransferObj.maker_notification_next_button().click();
			}
		}
		budgetTransferObj.budget_BudgetTransfer_FirstReferenceId().click();

		String before_xpath = "//span[text()='";
		String after_xpath = "']/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
		waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)));
		driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)).click();
		/*
		 * By xpath = By.xpath(before_xpath + reader.readReferancedata() + after_xpath);
		 * Actions action = new Actions(driver);
		 * 
		 * action.moveToElement((WebElement) xpath).click().perform();
		 */
	}
	
	@Then("^Select PO Number for grn$")
    public void select_po_number_for_grn() throws Throwable {
    waithelper.waitForElementwithFluentwait(driver, accountsPayable_GRNObj.accountPayable_GrnPONumber());
    accountsPayable_GRNObj.accountPayable_GrnPONumber().click();
    
    waithelper.waitForElementwithFluentwait(driver, accountsPayable_GRNObj.accountPayable_GrnPONumber());
    accountsPayable_GRNObj.accountPayable_GrnPONumber().sendKeys(testData.get("PoNumber"));
		
    waithelper.waitForElementwithFluentwait(driver, accountsPayable_GRNObj.accountPayable_GrnPONumber());
    accountsPayable_GRNObj.accountPayable_GrnPONumber().sendKeys(Keys.ENTER);

	}
	
	@Then("^Add quantity received quantity approved$")
    public void add_quantity_received_quantity_approved() throws Throwable {
    waithelper.waitForElementwithFluentwait(driver, accountsPayable_GRNObj.accountPayable_GrnQtyReceived());
    accountsPayable_GRNObj.accountPayable_GrnQtyReceived().click();
	accountsPayable_GRNObj.accountPayable_GrnQtyReceived().sendKeys(testData.get("QtyReceived"));
	accountsPayable_GRNObj.accountPayable_GrnQtyReceived().sendKeys(Keys.ENTER);

	waithelper.waitForElementwithFluentwait(driver, accountsPayable_GRNObj.accountPayable_GrnQtyApproved());
    accountsPayable_GRNObj.accountPayable_GrnQtyApproved().click();
	accountsPayable_GRNObj.accountPayable_GrnQtyApproved().sendKeys(testData.get("QtyApproved"));
	accountsPayable_GRNObj.accountPayable_GrnQtyApproved().sendKeys(Keys.ENTER);
		
    }

	@Then("^Click on GRN item save button$")
	public void click_on_grn_item_save_button() throws Throwable {
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.accountPayable_GrnSaveButton());
		WebElement save = inventoryManagamentObj.accountPayable_GrnSaveButton();
		clicksAndActionHelper.moveToElement(save);
		inventoryManagamentObj.accountPayable_GrnSaveButton().click();
		waithelper.waitForElementwithFluentwait(driver, accountsPayable_GRNObj.ConfirmationMessageCloseButton());
		accountsPayable_GRNObj.ConfirmationMessageCloseButton().click();
	}

	@Then("^Click on the Notification$")
	public void click_on_the_notification() throws Throwable {
//		Thread.sleep(1000);
		waithelper.waitForElementwithFluentwait(driver, budgetTransferObj.budget_BudgetTransfer_NotificationIcon());
		budgetTransferObj.budget_BudgetTransfer_NotificationIcon().click();

	}

	@Then("^Select the record which we saved$")
	public void select_the_record_which_we_saved() throws Throwable {
		// Reference
		waithelper.waitForElementwithFluentwait(driver, budgetTransferObj.budget_BudgetTransfer_FirstReferenceId());
		String id = budgetTransferObj.budget_BudgetTransfer_FirstReferenceId().getText();
		
		excelData.updateTestData(dataSetID, "ReferenceID", id);
		testData = excelData.getTestdata(dataSetID);
		System.out.println("Reference ID:" + id);
		
		for (int i = 1; i <= 35; i++) {
			try {
				waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[text()='" + testData.get("ReferenceID") + "']")));
				WebElement referanceID = driver.findElement(By.xpath("//span[text()='" + testData.get("ReferenceID") + "']"));
				referanceID.click();
				System.out.println(referanceID);
				// Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElementwithFluentwait(driver, budgetTransferObj.maker_notification_next_button());
				budgetTransferObj.maker_notification_next_button().click();
			}

		}
		waithelper.waitForElementwithFluentwait(driver, budgetTransferObj.budget_BudgetTransfer_FirstReferenceId());
		budgetTransferObj.budget_BudgetTransfer_FirstReferenceId().click();

		// Action-Pencil
		String before_xpath = "//span[text()='";
		String after_xpath = "']/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
		waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)));
		driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)).click();

	}

	@Then("^Submit record$")
	public void submit_record() throws Throwable {
		// Submit button
		waithelper.waitForElementwithFluentwait(driver, inventoryManagamentObj.accountPayable_SubmitButton());
		try {
			inventoryManagamentObj.accountPayable_SubmitButton().click();
		} catch (ElementClickInterceptedException e) {
			javascripthelper.JSEClick(inventoryManagamentObj.accountPayable_SubmitButton());
		}

		// Remark
		waithelper.waitForElementwithFluentwait(driver, budgetTransferObj.budget_BudgetTransfer_RemarkField());
		budgetTransferObj.budget_BudgetTransfer_RemarkField().click();
		budgetTransferObj.budget_BudgetTransfer_RemarkField().sendKeys("ok");
		budgetTransferObj.budget_BudgetTransfer_RemarkField().sendKeys(Keys.ENTER);

		// Remark Submit
		waithelper.waitForElement(driver, 2000, budgetTransferObj.budget_BudgetTransfer_SubmitByMaker());
		budgetTransferObj.budget_BudgetTransfer_SubmitByMaker().click();

		waithelper.waitForElementwithFluentwait(driver, budgetTransferObj.budget_BudgetTransfer_RecordStatus());
		WebElement recordstatus = budgetTransferObj.budget_BudgetTransfer_RecordStatus();
		
		waithelper.waitForElementwithFluentwait(driver, budgetTransferObj.budget_BudgetTransfer_RecordStatus());
		clicksAndActionHelper.moveToElement(recordstatus);
		String message = budgetTransferObj.budget_BudgetTransfer_RecordStatus().getText();
		System.out.println(message);
		budgetTransferObj.budget_BudgetTransfer_RecordStatus().click();
		String emptystring = "";
		String ar[] = message.split(" ");
		emptystring = ar[ar.length - 1];
		String reviewerId = emptystring.replaceAll("[/.]", "");
		System.out.println(reviewerId);
		
		excelData.updateTestData(dataSetID, "ReviewerID", reviewerId);
		testData = excelData.getTestdata(dataSetID);

	}

	@Then("^Approve the record which we submitted from maker$")
	public void approve_the_record_which_we_submitted_from_maker() throws Throwable {
//		Thread.sleep(2000);
		for (int i = 1; i <= 50; i++) {
			try {
				waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[text()='" + testData.get("ReferenceID") + "']")));
				WebElement referanceID = driver.findElement(By.xpath("//span[text()='" + testData.get("ReferenceID") + "']"));
				referanceID.click();
				Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElementwithFluentwait(driver, kubschecker.checker_notification_next_button());
				kubschecker.checker_notification_next_button().click();
			}
		}
		String before_xpath = "//span[text()='";
		String after_xpath = "']/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
		waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)));
		driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath)).click();

		waithelper.waitForElementwithFluentwait(driver, reviewer.reviewerApproveButton());
		reviewer.reviewerApproveButton().click();
		
		waithelper.waitForElementwithFluentwait(driver, reviewer.reviewerAlertRemarks());
		javascripthelper.JSEClick(reviewer.reviewerAlertRemarks());
		
		waithelper.waitForElementwithFluentwait(driver, reviewer.reviewerAlertRemarks());
		reviewer.reviewerAlertRemarks().sendKeys("ok");
		
		waithelper.waitForElementwithFluentwait(driver, reviewer.reviewerAlertSubmitButton());
		reviewer.reviewerAlertSubmitButton().click();
//		Thread.sleep(2000);

	}

	@Then("^Claim grn record$")
	public void claim_grn_record() throws Throwable {
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerSecurityManagement());
		kubschecker.checkerSecurityManagement().click();
		
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerActionIcon());
		kubschecker.checkerActionIcon().click();
//		Thread.sleep(1000);
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath_claim)));
		driver.findElement(By.xpath(before_xpath + testData.get("ReferenceID") + after_xpath_claim)).click();
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerAlertClose());
		kubschecker.checkerAlertClose().click();
	}

	@Then("^Click on the notification and approve the record$")
	public void click_on_the_notification_and_approve_the_record() throws Throwable {
		waithelper.waitForElementwithFluentwait(driver, kubschecker.checkerNotificationIcon());
		kubschecker.checkerNotificationIcon().click();
//		Thread.sleep(2000);
		for (int i = 1; i <= 50; i++) {
			try {
				waithelper.waitForElementwithFluentwait(driver, driver.findElement(By.xpath("//span[text()='" + testData.get("ReferenceID") + "']")));
				WebElement referanceID = driver.findElement(By.xpath("//span[text()='" + testData.get("ReferenceID") + "']"));
				referanceID.click();
				Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElementwithFluentwait(driver, kubschecker.checker_notification_next_button());
				kubschecker.checker_notification_next_button().click();
			}
		}
		String before_xpath = "//span[text()='";
		String after_xpath = "']/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
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
	
	@Then("^click on first eye button to get a GRN number$")
	public void click_on_first_eye_button_to_get_a_grn_number() throws InterruptedException {
		waithelper.waitForElementwithFluentwait(driver, aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractCodeEyeButton());
		aCCOUNTSPAYABLE_VendorContractsObj.accountPayable_VendorContracts_ContractCodeEyeButton().click();
//		Thread.sleep(2000);
		String grnNo = javascripthelper.executeScript("return document.getElementsByClassName('native-input sc-ion-input-md')[2].value").toString();
		System.out.println("GRN Number: " + grnNo);

	}

	@Then("^Open the Reviewer account$")
	public void open_the_reviewer_account() throws Throwable {
		login = new KUBS_Login(driver);
		driver.get(config.getApplicationUrl());
		login.logintoAzentioappReviewer("Reviewer", testData.get("ReviewerID"));

	}

	@Then("^Go to Checker login$")
	public void go_to_checker_login() throws Throwable {
		login = new KUBS_Login(driver);
		driver.get(config.getApplicationUrl());
		login.loginToAzentioAppAsChecker("Checker");
		ExtentTestManager.getTest().info("User Navigated to required url & login as reviewer1");

	}

	@Then("^select data set ID for GRN$")
	public void select_data_set_id_for_grn() throws Throwable {
		dataSetID = "KUBS_INV_MGMT_UAT_001_005_D1";
		testData = excelData.getTestdata(dataSetID);
	}
	
	@Then("^update data set ID for GRN for reviewer$")
	public void update_data_set_id_for_grn_for_reviewer() throws Throwable {
		dataSetID = "KUBS_INV_MGMT_UAT_001_005_D1";
		testData = excelData.getTestdata(dataSetID);
	}
	
	@Then("^update data set ID for GRN for checker$")
	public void update_data_set_id_for_grn_for_checker() throws Throwable {
		dataSetID = "KUBS_INV_MGMT_UAT_001_005_D1";
		testData = excelData.getTestdata(dataSetID);
	}

}
