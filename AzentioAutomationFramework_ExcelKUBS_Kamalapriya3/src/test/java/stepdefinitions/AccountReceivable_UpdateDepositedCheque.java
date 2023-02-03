package stepdefinitions;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
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
import pageobjects.AccountReceivable_UpdateDepositedChequeObj;
import pageobjects.Azentio_CheckerObj;
import pageobjects.Azentio_ReviewerObj;
import pageobjects.InventoryMaintenanceObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.AccountReceivable_UpdateDepositedChequeTestDataType;
import testDataType.BUDGET_BudgetCreationTestDataType;
import testDataType.InventoryMaintenanceTestDataType;

public class AccountReceivable_UpdateDepositedCheque extends BaseClass {
	WebDriver driver = BaseClass.driver;
	JsonConfig jsonReader = new JsonConfig();
	ConfigFileReader configFileReader = new ConfigFileReader();
	ConfigFileReader config = new ConfigFileReader();
	DropDownHelper dropDownHelper;
	WaitHelper waithelper = new WaitHelper(driver);
	// maker//
	JavascriptHelper javascripthelper = new JavascriptHelper();

	AccountReceivable_UpdateDepositedChequeObj accountReceivable_UpdateDepositedChequeObj = new AccountReceivable_UpdateDepositedChequeObj(
			driver);

	AccountReceivable_UpdateDepositedChequeTestDataType accountReceivable_UpdateDepositedChequeTestDataType = jsonReader
			.getUpdateDepositedChequeByName("Maker");
	InventoryMaintenanceObj inventoryMaintenanceObj = new InventoryMaintenanceObj(driver);
	InventoryMaintenanceTestDataType inventoryMaintenanceTestDataType = new InventoryMaintenanceTestDataType();
	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	JsonDataReaderWriter reader = new JsonDataReaderWriter();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	Azentio_ReviewerObj reviewer;
	BrowserHelper browserHelper;
	String referance_id;
	String user = "Maker";
	Azentio_CheckerObj kubschecker = new Azentio_CheckerObj(driver);
	BUDGET_BudgetCreationTestDataType budgetdata;
	AzentioLogin login;

	@Then("^Click on Update cheque status Note icon$")
	public void click_on_update_cheque_status_note_icon() {
		javascripthelper.JavaScriptHelper(driver);
		javascripthelper.scrollIntoView(
				accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_NoteIcon());
		waithelper.waitForElement(driver, 2000,
				accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_NoteIcon());
		accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_NoteIcon().click();

	}

	@Then("^Select the Record$")
	public void select_the_record() {
		waithelper.waitForElement(driver, 2000,
				accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_FirstRecord());
		accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_FirstRecord().click();

	}

	// ChequeStatus Bounced
	@Then("^Select Cheque Status Bounced$")
	public void select_cheque_status_bounced() {

		waithelper.waitForElement(driver, 2000,
				accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_ChequeStatus());
		accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_ChequeStatus().click();
		accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_ChequeStatus()
				.sendKeys(accountReceivable_UpdateDepositedChequeTestDataType.ChequeStatusBounced);
		accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_ChequeStatus()
				.sendKeys(Keys.ENTER);

	}

	// BankCharges
	@Then("^Add Bank Charges$")
	public void add_bank_charges() {

		waithelper.waitForElement(driver, 2000,
				accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_BankCharges());
		accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_BankCharges().click();
		accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_BankCharges()
				.sendKeys(accountReceivable_UpdateDepositedChequeTestDataType.BankCharges);
		accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_BankCharges()
				.sendKeys(Keys.ENTER);

	}

	// BouncedReason
	@Then("^Select the bounced reason$")
	public void select_the_bounced_reason() {

		waithelper.waitForElement(driver, 2000,
				accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_BouncedReason());
		accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_BouncedReason().click();
		accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_BouncedReason()
				.sendKeys(accountReceivable_UpdateDepositedChequeTestDataType.BouncedReason);
		accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_BouncedReason()
				.sendKeys(Keys.ENTER);

	}

	@Then("^Click on Update Deposited Cheque Notification$")
	public void click_on_update_deposited_cheque_notification() {
		waithelper.waitForElement(driver, 3000,
				accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_Notification());
		accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_Notification().click();

	}

	@And("^Select and Submit the Update Deposited Cheque record$")
	public void select_and_submit_the_update_deposited_cheque_record()
			throws InterruptedException, IOException, ParseException {

		// Reference
		waithelper.waitForElement(driver, 2000,
				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReferenceId());
		String id = inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReferenceId().getText();
		jsonWriter.addReferanceData(id);
		System.out.println("Reference ID:" + id);
		for (int i = 1; i <= 35; i++) {
			try {
				waithelper.waitForElement(driver, 3000, driver
						.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]")));
				WebElement referanceID = driver
						.findElement(By.xpath("//span[contains(text(),'" + jsonWriter.readReferancedata() + "')]"));
				referanceID.click();
				System.out.println(referanceID);
				// Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElement(driver, 4000,
						inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_NotificationNext_Button());

				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_NotificationNext_Button().click();
			}

		}
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_ReferenceId().click();

		// pencil
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

		waithelper.waitForElement(driver, 2000,
				driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)));
		driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)).click();

		// Submit button
		waithelper.waitForElement(driver, 2000,
				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitButton());
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitButton().click();

		// Remark
		javascripthelper.JavaScriptHelper(driver);
		waithelper.waitForElement(driver, 3000,
				accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_RemarkField());
		javascripthelper.JSEClick(
				accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_RemarkField());
		accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_RemarkField().sendKeys("OK");
		// inventoryMaintenanceTestDataType.Remark

		// Remark Submit
		waithelper.waitForElement(driver, 2000,
				inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitByMaker());
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_SubmitByMaker().click();
		Thread.sleep(3000);

		// REVIEWER
		Thread.sleep(2000);
		WebElement recordstatus = inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RecordStatus();

		clicksAndActionHelper.moveToElement(recordstatus);
		String message = inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RecordStatus().getText();
		System.out.println(message);
		inventoryMaintenanceObj.inventoryMaintenance_InventoryItem_RecordStatus().click();
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
		jsonWriter = new JsonDataReaderWriter();
		jsonWriter.addData(reviewerId);

	}

	@Then("^click on the Notification select the Cheque record and Approve$")
	public void click_on_the_notification_select_the_cheque_record_and_approve()
			throws InterruptedException, IOException, ParseException {
		// notification
		waithelper = new WaitHelper(driver);
		reviewer = new Azentio_ReviewerObj(driver);
		waithelper.waitForElement(driver, 2000, reviewer.reviewerNotidicationIcon());
		reviewer.reviewerNotidicationIcon().click();

		// select the record
		browserHelper = new BrowserHelper(driver);
		// budgetdata = jsonReader.getBudgetdataByName("Maker");
		javascripthelper = new JavascriptHelper();
		Thread.sleep(1000);
		for (int i = 1; i <= 35; i++) {
			try {
				waithelper.waitForElement(driver, 3000,
						driver.findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]")));
				WebElement referanceID = driver
						.findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]"));
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
				driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)));
		driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)).click();

		// Approve
		waithelper.waitForElement(driver, 4000, reviewer.reviewerApproveButton());
		reviewer.reviewerApproveButton().click();
		waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertRemarkSecond());
		reviewer.reviewerAlertRemarkSecond().sendKeys("ok");
		waithelper.waitForElement(driver, 2000, reviewer.reviewerAlertSubmitButton());
		reviewer.reviewerAlertSubmitButton().click();
		Thread.sleep(3000);

	}

	@And("^select the Cheque record and Approve by checker$")
	public void select_the_cheque_record_and_approve_by_checker()
			throws InterruptedException, IOException, ParseException {
		Thread.sleep(1000);
		for (int i = 1; i <= 35; i++) {
			try {
				
				WebElement referanceID = driver
						.findElement(By.xpath("//span[contains(text(),'" + reader.readReferancedata() + "')]"));
				referanceID.click();
				
				break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElement(driver, 4000, kubschecker.checker_notification_next_button());
				kubschecker.checker_notification_next_button().click();
			}
			
			catch(Exception e)
			{
				if(i==35)
				{
					Assert.fail("Data not found");
				}
			}
		}
		while (true) {
			try {
				String before_xpath = "//span[contains(text(),'";
				String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

				waithelper.waitForElement(driver, 2000,
						driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)));
				driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)).click();
				break;
			} catch (StaleElementReferenceException e) {

			}
		}

		// Approve
		waithelper.waitForElement(driver, 2000, kubschecker.checkerApproveButton());
		kubschecker.checkerApproveButton().click();
		Thread.sleep(2000);
		waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarkSecond());
		kubschecker.checkerRemarkSecond().sendKeys("OK");
		Thread.sleep(2000);
		waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();
		Thread.sleep(2000);
	}

	// ChequeStatus Cleared
	@Then("^Select Cheque Status Cleared$")
	public void select_cheque_status_cleared() {

		waithelper.waitForElement(driver, 2000,
				accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_ChequeStatus());
		accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_ChequeStatus().click();
		accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_ChequeStatus()
				.sendKeys(accountReceivable_UpdateDepositedChequeTestDataType.ChequeStatusCleared);
		accountReceivable_UpdateDepositedChequeObj.accountReceivable_UpdateDepositedCheque_ChequeStatus()
				.sendKeys(Keys.ENTER);

	}

}
