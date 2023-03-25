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
