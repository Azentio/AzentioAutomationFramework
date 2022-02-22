package stepdefinitions;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import bsh.ParseException;
import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.BUDGET_BudgetCreationObj;
import pageobjects.BUDGET_SupplementaryBudgetObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_MakerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.BUDGET_SupplementarybudgetTestDataType;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.BUDGET_BudgetCreationObj;
import pageobjects.BUDGET_SupplementaryBudgetObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_MakerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.BUDGET_BudgetCreationTestDataType;
import testDataType.BUDGET_SupplementarybudgetTestDataType;
import utilities.ExtentTestManager;

public class Budget_BudgetSupplementary_BP_SB extends BaseClass {
	WebDriver driver = BaseClass.driver;
	AzentioLogin login;
	ConfigFileReader config = new ConfigFileReader();
	KUBS_ReviewerObj reviewer;
	KUBS_CheckerObj checker;
	WaitHelper waithelper;
	BrowserHelper browserHelper;
	String referance_id;
	JsonDataReaderWriter reader = new JsonDataReaderWriter();
	BUDGET_BudgetCreationTestDataType budgetdata;
	JsonConfig jsonconfig = new JsonConfig();

	public Properties prop;

	DropDownHelper dropDownHelper;
	BUDGET_SupplementaryBudgetObj bUDGET_SupplementaryBudgetObj = new BUDGET_SupplementaryBudgetObj(driver);
	BUDGET_BudgetCreationObj bUDGET_BudgetCreationObj = new BUDGET_BudgetCreationObj(driver);

	KUBS_MakerObj kubsMakerObj;

	BUDGET_SupplementarybudgetTestDataType bUDGET_SupplementaryBudgetTestDataType;

	JsonDataReaderWriter jsonWriter = new JsonDataReaderWriter();
	JavascriptHelper javascripthelper = new JavascriptHelper();
	ClicksAndActionsHelper clicksAndActionHelper = new ClicksAndActionsHelper(driver);
	JsonConfig jsonReader = new JsonConfig();

	// --------------------------------------COMMON------------------------//
	@Given("^Navigate to kubs url and login as maker user$")
	public void navigate_to_kubs_url_and_login_as_maker_user() throws InterruptedException {
		login = new AzentioLogin(driver);
		driver.get(config.getApplicationUrl());
		login.loginToAzentioApp("Maker");
	}

	@Then("^select budget menu$")
	public void select_budget_menu() throws Throwable {
		waithelper = new WaitHelper(driver);
		Thread.sleep(2000);
		waithelper.waitForElement(driver, 4000,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_DirectionIcon());
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_DirectionIcon().click();

		waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetField());
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetField().click();
	}

	@And("^click on the eye icon of supplementary budget sub menu$")
	public void click_on_the_eye_icon_of_supplementary_budget_sub_menu() {
		waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_EyeButton());
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_EyeButton().click();

	}

	@Then("^click on add button$")
	public void click_on_add_button() throws InterruptedException {
		Thread.sleep(2000);
		// waithelper.waitForElement(driver, 3000,
		// bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_AddButton());
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_AddButton().click();
	}

	@And("^fill the required field for yearly budget type$")
	public void fill_the_required_field_for_yearly_budget_type() {
		bUDGET_SupplementaryBudgetTestDataType = jsonReader.getSupplementaryBudgetByName("Maker");

		waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode());
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().click();
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode()
				.sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetCodeForyearly);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetCode().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

		waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear());
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().click();
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear()
				.sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetYearForyearly);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetYear().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

		waithelper.waitForElement(driver, 2000,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch());
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().click();
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch()
				.sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetBranchNameForyearly);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_BudgetBranch().sendKeys(Keys.ENTER);

		waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency());
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency().click();
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency()
				.sendKeys(bUDGET_SupplementaryBudgetTestDataType.CurrencyForyearly);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Currency().sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

		waithelper.waitForElement(driver, 2000,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryApportionAmount());
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SupplementaryApportionAmount()
				.sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetApportionAmt);

		waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Comments());
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_Comments()
				.sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetComments);
	}

	@Then("^save and submit by maker$")
	public void save_and_submit_by_maker() throws InterruptedException, IOException, ParseException, Throwable {
		waithelper.waitForElement(driver, 2000, bUDGET_BudgetCreationObj.budgetCreation_saveButton());
		bUDGET_BudgetCreationObj.budgetCreation_saveButton().click();
		Thread.sleep(2000);
		javascripthelper.JavaScriptHelper(driver);
		String str = javascripthelper.executeScript(
				"return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText")
				.toString();
		System.out.println("Message:" + str);

		waithelper.waitForElement(driver, 2000,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_MakerNotificationButton());
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_MakerNotificationButton().click();
		waithelper.waitForElement(driver, 2000,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_FirstReferenceId());

		String id = bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_FirstReferenceId().getText();
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
//				Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElement(driver, 4000, bUDGET_SupplementaryBudgetObj.maker_notification_next_button());

				bUDGET_SupplementaryBudgetObj.maker_notification_next_button().click();
			}
		}
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_FirstReferenceId().click();

		waithelper.waitForElement(driver, 2000,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_FirstPencilButton());
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_FirstPencilButton().click();

		waithelper.waitForElement(driver, 2000,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitButton());
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitButton().click();

		waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RemarkField());
		javascripthelper.JSEClick(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RemarkField());
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RemarkField()
				.sendKeys(bUDGET_SupplementaryBudgetTestDataType.RemarkByMaker);

		waithelper.waitForElement(driver, 2000,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitByMaker());
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitByMaker().click();
		Thread.sleep(2000);

	}

	@Then("^Navigate  to URL and login to Checker1$")
	public void navigate_to_url_and_login_to_checker1() throws Throwable {
		login = new AzentioLogin(driver);
		driver.get(config.getApplicationUrl());
		login.loginToAzentioAppAsChecker("Checker");
	}

	@When("^Click  on the Security management$")
	public void click_on_security_management() throws Throwable {
		waithelper = new WaitHelper(driver);
		kubschecker = new KUBS_CheckerObj(driver);
		waithelper.waitForElement(driver, 3000, kubschecker.checkerSecurityManagement());
		kubschecker.checkerSecurityManagement().click();
	}

	@Then("^Click  on open pool & click clam button$")
	public void click_on_open_pool_click_clam_button() throws Throwable {
		waithelper.waitForElement(driver, 3000, kubschecker.checkerActionIcon());

		kubschecker.checkerActionIcon().click();
		Thread.sleep(1000);
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		waithelper.waitForElement(driver, 5000,
				driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath_claim)));
		driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath_claim)).click();
		waithelper.waitForElement(driver, 3000, kubschecker.checkerAlertClose());
		kubschecker.checkerAlertClose().click();
	}

	@Then("^Click  on the Notification$")
	public void click_on_the_notification() throws Throwable {
		javascript = new JavascriptHelper();
		Thread.sleep(1000);
		waithelper.waitForElement(driver, 4000, kubschecker.checkerNotificationIcon());

		kubschecker.checkerNotificationIcon().click();
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

		 
	}
	// ----------Budget_BudgetSupplementary_BP_SB_03_02--------------//

	@And("^Find the budget code which is submitted from maker$")
	public void find_the_budget_code_which_is_submitted_from_maker() throws Throwable {
		browserHelper = new BrowserHelper(driver);

	}

	@Then("^Click on action Button$")
	public void click_on_action_button() throws Throwable, Throwable {

		 String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

		waithelper.waitForElement(driver, 10000,
				driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)));
		driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)).click();
	}

	@And("^Verify the record is generated by opening the record$")
	public void verify_the_record_is_generated_by_opening_the_record() {
		waithelper.waitForElement(driver, 4000, kubschecker.checkerRejectButton());

		Assert.assertTrue(kubschecker.checkerRejectButton().isDisplayed());
		waithelper.waitForElement(driver, 4000, kubschecker.checkerReturnButton());
		Assert.assertTrue(kubschecker.checkerReturnButton().isDisplayed());
		waithelper.waitForElement(driver, 4000, kubschecker.checkerApproveButton());

		Assert.assertTrue(kubschecker.checkerApproveButton().isDisplayed());

	}

	// -----------Budget_BudgetSupplementary_BP_SB_04_01-----------//
	KUBS_CheckerObj kubschecker;
	JavascriptHelper javascript;

	@Then("^Click  on action button of record user want to reject$")
	public void click_on_action_button_of_record_user_want_to_reject() throws Throwable {
		 String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

		waithelper.waitForElement(driver, 10000,
				driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)));
		driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)).click();
	}

	@Then("^Click  on reject button$")
	public void click_on_reject_button() throws Throwable {
		waithelper.waitForElement(driver, 2000, kubschecker.checkerRejectButton());
		kubschecker.checkerRejectButton().click();
		waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
		kubschecker.checkerRemarks().sendKeys("ok");
		waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();
		waithelper.waitForElement(driver, 3000, kubschecker.checker_right_corner_reject_toast());
		Assert.assertTrue(kubschecker.checker_right_corner_reject_toast().isDisplayed());

	}
	// -----------Budget_BudgetSupplementary_BP_SB_04_04-----------//

	@Then("^Click on action  button of record user want to reject the record.$")
	public void click_on_action_button_of_record_user_want_to_reject_the_record() throws Throwable {
	 String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

		waithelper.waitForElement(driver, 10000,
				driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)));
		driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)).click();
	}

	@Then("^Click on reject the button.$")
	public void click_on_reject_the_button() throws Throwable {
		waithelper.waitForElement(driver, 2000, kubschecker.checkerRejectButton());
		kubschecker.checkerApproveButton().click();
		waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
		kubschecker.checkerRemarks().sendKeys("ok");
		waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();
		waithelper.waitForElement(driver, 3000, kubschecker.checker_right_corner_reject_toast());
		Assert.assertTrue(kubschecker.checker_right_corner_reject_toast().isDisplayed());

	}

	// -----------Budget_BudgetSupplementary_BP_SB_06_01-----------//
	@Then("^Click  on action  button of record user want to approv or reject$")
	public void click_on_action_button_of_record_user_want_to_approvreject() throws Throwable {
		// waithelper.waitForElement(driver, 3000,
		// driver.findElement(By.xpath("//span[contains(text(),'" +
		// reader.readReferancedata() +
		// "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		// driver.findElement(By.xpath("//span[contains(text(),'" +
		// reader.readReferancedata() +
		// "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")).click();
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

		waithelper.waitForElement(driver, 10000,
				driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)));
		driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)).click();
		waithelper.waitForElement(driver, 4000, kubschecker.checkerRejectButton());

		Assert.assertTrue(kubschecker.checkerRejectButton().isDisplayed());
		waithelper.waitForElement(driver, 4000, kubschecker.checkerReturnButton());
		Assert.assertTrue(kubschecker.checkerReturnButton().isDisplayed());
		waithelper.waitForElement(driver, 4000, kubschecker.checkerApproveButton());
		Assert.assertTrue(kubschecker.checkerApproveButton().isDisplayed());

	}

	// -----------Budget_BudgetSupplementary_BP_SB_06_06-----------//
	@Then("^Click  on  action  button of record user want to Return$")
	public void click_on_action_button_of_record_user_want_to_return() throws Throwable {
		// waithelper.waitForElement(driver, 3000,
		// driver.findElement(By.xpath("//span[contains(text(),'" +
		// reader.readReferancedata() +
		// "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		// driver.findElement(By.xpath("//span[contains(text(),'" +
		// reader.readReferancedata() +
		// "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")).click();
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";

		waithelper.waitForElement(driver, 10000,
				driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)));
		driver.findElement(By.xpath(before_xpath + reader.readReferancedata() + after_xpath)).click();
		waithelper.waitForElement(driver, 4000, kubschecker.checkerReturnButton());
		kubschecker.checkerReturnButton().click();
		waithelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
		kubschecker.checkerRemarks().sendKeys("ok");
		waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();
	}

	@Then("^Capture  the popup that shows in right corner$")
	public void capture_the_popup_that_shows_in_right_corner() throws Throwable {
		waithelper.waitForElement(driver, 3000, kubschecker.checker_right_corner_green_toast());
		Assert.assertTrue(kubschecker.checker_right_corner_green_toast().isDisplayed());
	}

	// ------Auto auth new tushar-----------BP_SB_01_04--------------
	@Then("^Save and aprove the record$")
	public void save_and_aprove_the_record() throws Throwable {
		waithelper.waitForElement(driver, 2000, bUDGET_BudgetCreationObj.budgetCreation_saveButton());
		bUDGET_BudgetCreationObj.budgetCreation_saveButton().click();
		Thread.sleep(2000);
		javascripthelper.JavaScriptHelper(driver);
		String str = javascripthelper.executeScript(
				"return document.querySelector(\"ion-toast\").shadowRoot.querySelector(\"div[class='toast-message']\").innerText")
				.toString();
		System.out.println("Message:" + str);

		waithelper.waitForElement(driver, 2000,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_MakerNotificationButton());
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_MakerNotificationButton().click();
		waithelper.waitForElement(driver, 2000,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_FirstReferenceId());

		String id = bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_FirstReferenceId().getText();
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
//					Assert.assertTrue(referanceID.isDisplayed());
				break;
			} catch (NoSuchElementException e) {
				waithelper.waitForElement(driver, 4000, bUDGET_SupplementaryBudgetObj.maker_notification_next_button());

				bUDGET_SupplementaryBudgetObj.maker_notification_next_button().click();
			}
		}
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_FirstReferenceId().click();

		waithelper.waitForElement(driver, 2000,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_FirstPencilButton());
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_FirstPencilButton().click();
		Thread.sleep(2000);
		waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.maker_Approve_button());
		bUDGET_SupplementaryBudgetObj.maker_Approve_button().click();

		waithelper.waitForElement(driver, 2000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RemarkField());
		javascripthelper.JSEClick(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RemarkField());
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_RemarkField()
				.sendKeys(bUDGET_SupplementaryBudgetTestDataType.RemarkByMaker);
		Thread.sleep(2000);
		waithelper.waitForElement(driver, 2000,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitByMaker());
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SubmitByMaker().click();
		Thread.sleep(2000);
	}

	// --------------------Budget_BudgetSupplementary_BP_SB_01_02-------------
	@Then("^Search the created record$")
	public void search_the_created_record() throws Throwable {
		Thread.sleep(2000);
		waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_EyeButton());
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_EyeButton().click();
		// search icon
		waithelper.waitForElement(driver, 3000, bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchIcon());
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchIcon().click();
		Thread.sleep(2000);
		// Budget code
		bUDGET_SupplementaryBudgetTestDataType = jsonReader.getSupplementaryBudgetByName("Maker");
		waithelper.waitForElement(driver, 5000,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetCode());
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetCode().click();
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetCode()
				.sendKeys(bUDGET_SupplementaryBudgetTestDataType.BudgetCodeForyearly);
		bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchBudgetCode().sendKeys(Keys.ENTER);
		// select the record
		waithelper.waitForElement(driver, 3000,
				bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchSelectRecord());
		// bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchSelectRecord().isDisplayed();
		Assert.assertTrue(bUDGET_SupplementaryBudgetObj.budget_SupplementaryBudget_SearchSelectRecord().isDisplayed());
	}

}

/*
 * //-----------Budget_BudgetSupplementary_BP_SB_15_01-----------//
 * 
 * @Then("^Click   on  action  button of record user want to see the record$")
 * public void click_on_action_button_of_record_user_want_to_see_the_record()
 * throws Throwable { waithelper.waitForElement(driver, 3000,
 * driver.findElement(By.xpath("//span[contains(text(),'" +
 * reader.readReferancedata() +
 * "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"
 * ))); driver.findElement(By.xpath("//span[contains(text(),'" +
 * reader.readReferancedata() +
 * "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"
 * )).click();
 * 
 * } //-----------Budget_BudgetSupplementary_BP_SB_15_02-----------//
 * 
 * @Then("^Click on  action  button  of record user want to view$") public void
 * click_on_action_button_of_record_user_want_to_view() throws Throwable {
 * waithelper.waitForElement(driver, 3000,
 * driver.findElement(By.xpath("//span[contains(text(),'" +
 * reader.readReferancedata() +
 * "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"
 * ))); driver.findElement(By.xpath("//span[contains(text(),'" +
 * reader.readReferancedata() +
 * "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"
 * )).click();
 * 
 * } //-----------Budget_BudgetSupplementary_BP_SB_15_03-----------//
 * 
 * @Then("^Click on  action  button of record  user want to approve$") public
 * void click_on_action_button_of_record_user_want_to_approve() throws Throwable
 * { waithelper.waitForElement(driver, 3000,
 * driver.findElement(By.xpath("//span[contains(text(),'" +
 * reader.readReferancedata() +
 * "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"
 * ))); driver.findElement(By.xpath("//span[contains(text(),'" +
 * reader.readReferancedata() +
 * "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"
 * )).click();
 * 
 * }
 * 
 * @Then("^Click   on approve  button$") public void click_on_approve_button()
 * throws Throwable { waithelper.waitForElement(driver, 2000,
 * kubschecker.checkerApproveButton());
 * kubschecker.checkerApproveButton().click(); waithelper.waitForElement(driver,
 * 2000, kubschecker.checkerRemarks());
 * kubschecker.checkerRemarks().sendKeys("ok");
 * waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
 * kubschecker.checkersubmitButton().click();
 * 
 * }
 */
/*
 * //-----------Budget_BudgetSupplementary_BP_SB_16_01-----------//
 * 
 * @Then("^Click on  action  button of record user want  to approve  or reject$"
 * ) public void
 * click_on_action_button_of_record_user_want_to_approve_or_reject() throws
 * Throwable { waithelper.waitForElement(driver, 3000,
 * driver.findElement(By.xpath("//span[contains(text(),'" +
 * reader.readReferancedata() +
 * "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"
 * ))); driver.findElement(By.xpath("//span[contains(text(),'" +
 * reader.readReferancedata() +
 * "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"
 * )).click();
 * 
 * } //-----------Budget_BudgetSupplementary_BP_SB_16_02-----------//
 * 
 * @Then("^Click on  action  button of record user want to view the record$")
 * public void click_on_action_button_of_record_user_want_to_view_the_record()
 * throws Throwable { waithelper.waitForElement(driver, 3000,
 * driver.findElement(By.xpath("//span[contains(text(),'" +
 * reader.readReferancedata() +
 * "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"
 * ))); driver.findElement(By.xpath("//span[contains(text(),'" +
 * reader.readReferancedata() +
 * "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"
 * )).click();
 * 
 * }
 */
/*
 * //-----------Budget_BudgetSupplementary_BP_SB_16_03-----------//
 * 
 * @Then("^Click on  action  button of record user want view the record$")
 * public void click_on_action_button_of_record_user_want_view_the_record()
 * throws Throwable { waithelper.waitForElement(driver, 3000,
 * driver.findElement(By.xpath("//span[contains(text(),'" +
 * reader.readReferancedata() +
 * "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"
 * ))); driver.findElement(By.xpath("//span[contains(text(),'" +
 * reader.readReferancedata() +
 * "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"
 * )).click();
 * 
 * }
 * 
 * @Then("^User click on reject button$") public void
 * user_click_on_reject_button() throws Throwable {
 * waithelper.waitForElement(driver,3000,kubschecker.checkerRejectButton());
 * 
 * kubschecker.checkerRejectButton().click(); waithelper.waitForElement(driver,
 * 2000, kubschecker.checkerRemarks());
 * kubschecker.checkerRemarks().sendKeys("ok");
 * waithelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
 * kubschecker.checkersubmitButton().click();
 * 
 * }
 */

// -----------Budget_BudgetSupplementary_BP_SB_19_01-----------//
/*
 * @Then("^Click on the action  button of record user want to view the record$")
 * public void
 * click_on_the_action_button_of_record_user_want_to_view_the_record() throws
 * Throwable { waithelper.waitForElement(driver, 3000,
 * driver.findElement(By.xpath("//span[contains(text(),'" +
 * reader.readReferancedata() +
 * "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"
 * ))); driver.findElement(By.xpath("//span[contains(text(),'" +
 * reader.readReferancedata() +
 * "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"
 * )).click();
 * 
 * }
 */
// -----------Budget_BudgetSupplementary_BP_SB_19_02-----------//
/*
 * @Then("^Click on  action  button of the record user want to view the record$"
 * ) public void
 * click_on_action_button_of_the_record_user_want_to_view_the_record() throws
 * Throwable { waithelper.waitForElement(driver, 3000,
 * driver.findElement(By.xpath("//span[contains(text(),'" +
 * reader.readReferancedata() +
 * "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"
 * ))); driver.findElement(By.xpath("//span[contains(text(),'" +
 * reader.readReferancedata() +
 * "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"
 * )).click();
 * 
 * }
 */
