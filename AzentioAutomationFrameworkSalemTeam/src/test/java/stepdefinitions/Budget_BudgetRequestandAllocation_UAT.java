package stepdefinitions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
import pageobjects.BUDGET_RequestAndAllocationObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.BUDGET_RequestAndAllocationTestDataType;
import testDataType.BUDGET_RequestandallocationBUDTYPEDATA;

public class Budget_BudgetRequestandAllocation_UAT extends BaseClass {
	WebDriver driver = BaseClass.driver;
	ConfigFileReader configFileReader = new ConfigFileReader();
	KUBS_Login login;
	BUDGET_RequestAndAllocationObj requestAndAllocation = new BUDGET_RequestAndAllocationObj(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	String reviwerId;
	//BUDGET_RequestAndAllocationTestDataType requestAndAllocationTestData = new BUDGET_RequestAndAllocationTestDataType();
	JsonConfig jsonReader = new JsonConfig();
	BUDGET_RequestAndAllocationTestDataType requestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
	DropDownHelper dropDownHelper = new DropDownHelper(driver);
	BUDGET_RequestandallocationBUDTYPEDATA requestAndAllocationBudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
	JavascriptHelper javaHelper = new JavascriptHelper();
	JsonDataReaderWriter json = new JsonDataReaderWriter();
	KUBS_ReviewerObj reviewerObj = new KUBS_ReviewerObj(driver);
	String referance_id;
	String Type;
	BrowserHelper browserHelper = new BrowserHelper(driver);
	KUBS_CheckerObj kubsChecker = new KUBS_CheckerObj(driver);
	ClicksAndActionsHelper clickAndActionHelper = new ClicksAndActionsHelper(driver);

	// ---------------------------LOGIN---------------------------------//

	@Given("^Navigate to the Azentio Url$")
	public void navigate_to_the_azentio_url() throws Throwable {
		// ---------LOGIN THE MAKER USER--------------//
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioApp("Maker");
		Thread.sleep(1000);
	}

	@Given("^Azentio Url login as Reviewer$")
	public void azentio_url_login_as_reviewer() throws Throwable {

		// ---------LOGIN THE REVIEWER USER--------------//
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.logintoAzentioappReviewer("Reviewer", json.readdata());
	}

	@Given("^Azentio Url login as checker page$")
	public void azentio_url_login_as_checker_page() throws Throwable {

		// ---------LOGIN THE CHECKER USER--------------//
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioAppAsChecker("Checker");
	}

	// ---------------------------MAKER COMMON
	// STEPS---------------------------------//

	@Then("^click the Two Direction Icon$")
	public void click_the_two_direction_icon() throws Throwable {

		// ---------TO VIEW THE TRANFER AMOUNT BUDGET----------//
		requestAndAllocation = new BUDGET_RequestAndAllocationObj(driver);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver, 5000, requestAndAllocation.budget_requestAndAllocation_DirctionIcon());
		requestAndAllocation.budget_requestAndAllocation_DirctionIcon().click();
	}

	@And("^click to the Budget$")
	public void click_to_the_budget() throws Throwable {

		// -----------TO CLICK THE BUDGET MODULE--------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetField());
		requestAndAllocation.budget_requestAndAllocation_BudgetField().click();
		Thread.sleep(1000);
	}

	@Then("^click on the Budget Sub module Budget Request and Allocation Near Eye Icon$")
	public void click_on_the_budget_sub_module_budget_request_and_allocation_near_eye_icon() throws Throwable {

		// ----------TO CLICK THE EYE ICON------------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon());
		requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon().click();
		
	}

	@And("^click on the Add icon in Request and Allocation$")
	public void click_on_the_add_icon_in_request_and_allocation() throws Throwable {

		// ----------TO CREATE A NEW BUDGET AMOUNT------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_Addicon());
		requestAndAllocation.budget_requestAndAllocation_Addicon().click();
	}

	@Then("^click on the Branch$")
	public void click_on_the_branch() throws Throwable {

		// ----------TO SELECT THE BRANCH-----------------//
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetbranch());
		requestAndAllocation.budget_requestAndAllocation_Budgetbranch().click();
	}

	@And("^select the Budget Year$")
	public void select_the_budget_year() throws Throwable {

		// ----------TO SELECT THE BUDGET YEAR-------------//
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyear());
		dropDownHelper.SelectUsingVisibleText(requestAndAllocation.budget_requestAndAllocation_Budgetyear(),
				requestAndAllocationTestData.BudgetYear);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.ENTER);
		// requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
	}

	@Then("^click on the Branch ok button$")
	public void click_on_the_branch_ok_button() throws Throwable {

		// -----------TO CLICK BRANCH OK BUTTON------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_branchOK());
		requestAndAllocation.budget_requestAndAllocation_branchOK().click();

	}

	@Then("^select one currency we need$")
	public void select_one_currency_we_need() throws Throwable {

		// -----------TO SELECT THE CURRENCY WE NEED-----------//
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Amountcurruncy());
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().click();
		// requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.ENTER);
	}

	@Then("^click on the Maker icon button$")
	public void click_on_the_maker_icon_button() throws Throwable {

		// -----------TO CLICK THE MAKER NOTIFICATION-------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.makerNotificationIcon());
		requestAndAllocation.makerNotificationIcon().click();
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.maker_Referance_id());
		String Referance_id = requestAndAllocation.maker_Referance_id().getText();
		json.addReferanceData(Referance_id);
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.maker_Action_icon());
		requestAndAllocation.maker_Action_icon().click();
	}

	@And("^click on the save button$")
	public void click_on_the_save_button() throws Throwable {

		// ------------TO SAVE THE RECORD--------------------//
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_AllowSave());
		requestAndAllocation.budget_requestAndAllocation_AllowSave().click();
		Thread.sleep(2000);
		javaHelper.JavaScriptHelper(driver);
		String output = (String) javaHelper.executeScript(
				"return document.querySelector('ion-toast').shadowRoot.querySelector('div[class=toast-message]').innerText");
		System.out.println(output);
	}

	@And("^click on the Record submit$")
	public void click_on_the_record_submit() throws Throwable {

		// ------------TO SUBMIT THE RECORD------------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetSubmit());
		requestAndAllocation.budget_requestAndAllocation_BudgetSubmit().click();
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_Alertremark());
		requestAndAllocation.requestAndAllocation_Alertremark().sendKeys(requestAndAllocationTestData.Remark);
		waitHelper.waitForElement(driver, 5000, requestAndAllocation.requestAndAllocation_Alertsubmit());
		requestAndAllocation.requestAndAllocation_Alertsubmit().click();
		waitHelper.waitForElement(driver, 10000, requestAndAllocation.requestAndAllocation_reviewer_id());
		reviwerId = requestAndAllocation.requestAndAllocation_reviewer_id().getText();
		String trimmdReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmdReviewerID);
		StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
		String filanReviewerID = bufferedString.toString();
		// requestAndAllocation.requestAndAllocation_reviewer_id().getText());
		json.addData(filanReviewerID);
		System.out.println(reviwerId);
	}

	// ----------------------REVIEWER COMMON STEPS------------------------------//

	@Then("^Click on Reviewer Notification icon$")
	public void click_on_reviewer_notification_icon() throws Throwable {

		// -------------REVIEWER NOTIFICATION---------------//
		reviewerObj = new KUBS_ReviewerObj(driver);
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewerNotidicationIcon());
		reviewerObj.reviewerNotidicationIcon().click();
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewer_referanceid());
		javaHelper.JavaScriptHelper(driver);
		referance_id = reviewerObj.reviewer_referanceid().getText();
		System.out.println("Referance_id:" + referance_id);
		Assert.assertTrue(reviewerObj.reviewer_referanceid().isDisplayed());
	}

	@And("^Click on to Reviewer Action button$")
	public void click_on_to_reviewer_action_button() throws Throwable {

		// -----------REVIEWER ACTION-------------//
		javaHelper.JavaScriptHelper(driver);
		// span[contains(text(),'336')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//div//ion-buttons//ion-button
		String befr_xpath = "//span[contains(text(),'";
		String aftr_xpath = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//div//ion-buttons//ion-button";
		waitHelper.waitForElement(driver, 2000,
				driver.findElement(By.xpath(befr_xpath + json.readReferancedata() + aftr_xpath)));
		driver.findElement(By.xpath(befr_xpath + json.readReferancedata() + aftr_xpath)).click();
		reviewerObj.reviewer_action_button().click();
	}

	@Then("^Click on to Approve button in Reviewer$")
	public void click_on_to_approve_button_in_reviewer() throws Throwable {

		// -----------------REVIEWER APPROVE---------------------//
		json.addReferanceData(referance_id);
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewerApproveButton());
		reviewerObj.reviewerApproveButton().click();
	}

	// -----------------------------------CHECKER COMMON
	// STEPS------------------------------------//

	@Then("^click on the security management$")
	public void click_on_the_security_management() throws Throwable {

		// --------------------CLICK ON SECURITY MANAGEMENTS-----------------------//
		waitHelper.waitForElement(driver, 3000, kubsChecker.checkerSecurityManagement());
		kubsChecker.checkerSecurityManagement().click();
	}

	@And("^Click on the sub module open pool near Edit icon$")
	public void click_on_the_sub_module_open_pool_near_edit_icon() throws Throwable {

		// ----------------------CLICK ON OPEN POOL-----------------------//
		waitHelper.waitForElement(driver, 3000, kubsChecker.checkerActionIcon());
		kubsChecker.checkerActionIcon().click();
	}

	@Then("^Click the claim option icon$")
	public void click_the_claim_option_icon() throws Throwable {

		// -------------------------CLICK CLAIM OPTION-------------------------//
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		waitHelper.waitForElement(driver, 10000,
				driver.findElement(By.xpath(before_xpath + json.readReferancedata() + after_xpath_claim)));
		driver.findElement(By.xpath(before_xpath + json.readReferancedata() + after_xpath_claim)).click();
		waitHelper.waitForElement(driver, 2000, kubsChecker.checker_alert_close());
		kubsChecker.checker_alert_close().click();
	}

	@And("^Click on the checker notification icon$")
	public void click_on_the_checker_notification_icon() throws Throwable {

		// ----------------CHECKER NOTIFICATION-----------------------//
		javaHelper = new JavascriptHelper();
		waitHelper.waitForElement(driver, 3000, kubsChecker.checkerNotificationIcon());
		javaHelper.JavaScriptHelper(driver);
		javaHelper.JSEClick(kubsChecker.checkerNotificationIcon());
	}

	@Then("^click the checker action icon$")
	public void click_the_checker_action_icon() throws Throwable {

		// ------------------CHECKER ACTION------------------//
		waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"
				+ json.readReferancedata()
				+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(By.xpath("//span[contains(text(),'" + json.readReferancedata()
				+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"))
				.click();
	}
	// ------------------------@KUBS_UAT_Monthly_KUBS_BP_UAT_002_001----------------------//

	@Then("^select the Budget Code$")
	public void select_the_budget_code() throws Throwable {

		// ----------TO SELECT THE BUDGET CODE----------------//
		requestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(requestAndAllocationTestData.Monthly);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
	}

	@And("^select to one Branch$")
	public void select_to_one_branch() throws Throwable {

		// ---------------------TO SELECT ONE BRANCH CHECKBOX-----------------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_type());
		requestAndAllocation.requestAndAllocation_branch_type().click();
	}

	@And("^Enter the Amount for Monthly Budget type$")
	public void enter_the_amount_for_monthly_budget_type() throws Throwable {

		// ----------------------HERE WE ENTER BUDGET AMOUNT FOR EVERY BUDGET
		// TYPE----------------------//
		requestAndAllocationBudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgettype());
		String budgettype = requestAndAllocation.budget_requestAndAllocation_Budgettype().getText();
		requestAndAllocationBudtype = jsonReader.getBudtypeByName(budgettype);
		javaHelper.JavaScriptHelper(driver);

		// ----------------------------THIS CODE FOR MONTHLY
		// BUDGET-------------------------//

		javaHelper.JavaScriptHelper(driver);
		javaHelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
		requestAndAllocation.budget_requestAndAllocation_Budgetmonth12()
				.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
		requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark12()
				.sendKeys(requestAndAllocationTestData.Remark);

		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth11());
		requestAndAllocation.budget_requestAndAllocation_Budgetmonth11()
				.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
		requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark11()
				.sendKeys(requestAndAllocationTestData.Remark);

		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth10());
		requestAndAllocation.budget_requestAndAllocation_Budgetmonth10()
				.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
		requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark10()
				.sendKeys(requestAndAllocationTestData.Remark);

		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth9());
		requestAndAllocation.budget_requestAndAllocation_Budgetmonth9()
				.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
		requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark9()
				.sendKeys(requestAndAllocationTestData.Remark);

		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth8());
		requestAndAllocation.budget_requestAndAllocation_Budgetmonth8()
				.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
		requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark8()
				.sendKeys(requestAndAllocationTestData.Remark);

		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth7());
		requestAndAllocation.budget_requestAndAllocation_Budgetmonth7()
				.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
		requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7()
				.sendKeys(requestAndAllocationTestData.Remark);

	}

	// ----------------------------@KUBS_UAT_Quarterly_KUBS_BP_UAT_002_002----------------------//

	@Then("^select to Budget Code$")
	public void select_to_budget_code() throws Throwable {

		// ----------TO SELECT THE BUDGET CODE----------------//
		requestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(requestAndAllocationTestData.Quarterly);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
	}

	@And("^select the one Branch$")
	public void select_the_one_branch() throws Throwable {

		// ---------------------TO SELECT ONE BRANCH CHECKBOX-----------------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_type1());
		requestAndAllocation.requestAndAllocation_branch_type1().click();
	}

	@And("^Enter the Amount for Quarterly Budget type$")
	public void enter_the_amount_for_quarterly_budget_type() throws Throwable {

		// ----------------------HERE WE ENTER BUDGET AMOUNT FOR EVERY BUDGET
		// TYPE----------------------//
		requestAndAllocationBudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgettype());
		String budgettype = requestAndAllocation.budget_requestAndAllocation_Budgettype().getText();
		requestAndAllocationBudtype = jsonReader.getBudtypeByName(budgettype);
		javaHelper.JavaScriptHelper(driver);

		// ----------------------------THIS CODE FOR QUARTERLY
		// BUDGET---------------------------//

		javaHelper.JavaScriptHelper(driver);
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3());
		requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3()
				.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
		requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark3()
				.sendKeys(requestAndAllocationTestData.Remark);

		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2());
		requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2()
				.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
		requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark2()
				.sendKeys(requestAndAllocationTestData.Remark);

	}

	// ------------------------@KUBS_UAT_Halfyearly_KUBS_BP_UAT_002_003------------------------//

	@Then("^Choose to Budget Code$")
	public void choose_to_budget_code() throws Throwable {

		// ----------TO SELECT THE BUDGET CODE----------------//
		requestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(requestAndAllocationTestData.Halfyearly);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
	}

	@And("^select the Branch$")
	public void select_the_branch() throws Throwable {

		// ---------------------TO SELECT ONE BRANCH CHECKBOX-----------------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_type1());
		requestAndAllocation.requestAndAllocation_branch_type1().click();
	}

	@And("^Enter the Amount for Halfyearly Budget type$")
	public void enter_the_amount_for_halfyearly_budget_type() throws Throwable {

		// ----------------------HERE WE ENTER BUDGET AMOUNT FOR EVERY BUDGET
		// TYPE----------------------//
		requestAndAllocationBudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgettype());
		String budgettype = requestAndAllocation.budget_requestAndAllocation_Budgettype().getText();
		requestAndAllocationBudtype = jsonReader.getBudtypeByName(budgettype);
		javaHelper.JavaScriptHelper(driver);

		// ---------------------------------THIS CODE FOR HALFYEARLY
		// BUDGET-------------------------//

		javaHelper.JavaScriptHelper(driver);
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javaHelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy2());
		requestAndAllocation.budget_requestAndAllocation_BudgetHy2().sendKeys(requestAndAllocationBudtype.BudgetAmounT);
		requestAndAllocation.budget_requestAndAllocation_BudgetHyremark2()
				.sendKeys(requestAndAllocationTestData.Remark);
	}

	// ---------------------------@KUBS_UAT_yearly_KUBS_BP_UAT_002_004--------------------//

	@Then("^Choose to the Budget Code$")
	public void choose_to_the_budget_code() throws Throwable {

		// ----------TO SELECT THE BUDGET CODE----------------//
		requestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(requestAndAllocationTestData.Yearly);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
	}

	@And("^Choose to the one Branch$")
	public void choose_to_the_one_branch() throws Throwable {

		// ---------------------TO SELECT ONE BRANCH CHECKBOX-----------------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_type1());
		requestAndAllocation.requestAndAllocation_branch_type1().click();
	}

	@And("^Enter the Amount for yearly Budget type$")
	public void enter_the_amount_for_yearly_budget_type() throws Throwable {

		// -------------------HERE WE ENTER BUDGET AMOUNT FOR EVERY BUDGET
		// TYPE----------------------//
		requestAndAllocationBudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgettype());
		String budgettype = requestAndAllocation.budget_requestAndAllocation_Budgettype().getText();
		requestAndAllocationBudtype = jsonReader.getBudtypeByName(budgettype);
		javaHelper.JavaScriptHelper(driver);

		// ---------------------------THIS CODE FOR YEARLY
		// BUDGET--------------------------//

		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javaHelper.JavaScriptHelper(driver);
		javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyearly());
		requestAndAllocation.budget_requestAndAllocation_Budgetyearly()
				.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
		requestAndAllocation.budget_requestAndAllocation_Budgetremark().sendKeys(requestAndAllocationTestData.Remark);
	}

	// --------------------------@KUBS_UAT_BudgetApprove_KUBS_BP_UAT_002_005------------------------//

	@Then("^To Select the Budget Code$")
	public void to_select_the_budget_code() throws Throwable {

		// ----------TO SELECT THE BUDGET CODE----------------//
		requestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode()
				.sendKeys(requestAndAllocationTestData.BudgetApprove);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
	}

	@And("^Choose the one Branch$")
	public void choose_the_one_branch() throws Throwable {

		// ---------------------TO SELECT ONE BRANCH CHECKBOX-----------------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_type3());
		requestAndAllocation.requestAndAllocation_branch_type3().click();
	}

	@And("^Give Amount for Budget Type Show in Budget type field$")
	public void give_amount_for_budget_type_show_in_budget_type_field() throws Throwable {

		// ----------------------HERE WE ENTER BUDGET AMOUNT FOR EVERY BUDGET
		// TYPE----------------------//
		requestAndAllocationBudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgettype());
		String budgettype = requestAndAllocation.budget_requestAndAllocation_Budgettype().getText();
		requestAndAllocationBudtype = jsonReader.getBudtypeByName(budgettype);
		javaHelper.JavaScriptHelper(driver);
		if (budgettype.equalsIgnoreCase("YEARLY")) {

			// ---------------------------THIS CODE FOR YEARLY
			// BUDGET--------------------------//

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JavaScriptHelper(driver);
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyearly());
			requestAndAllocation.budget_requestAndAllocation_Budgetyearly()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetremark()
					.sendKeys(requestAndAllocationTestData.Remark);
		} else if (budgettype.equalsIgnoreCase("MONTHLY")) {

			// ----------------------------THIS CODE FOR MONTHLY
			// BUDGET-------------------------//

			javaHelper.JavaScriptHelper(driver);
			javaHelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth12()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark12()
					.sendKeys(requestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth11());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth11()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark11()
					.sendKeys(requestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth10());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth10()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark10()
					.sendKeys(requestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth9());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth9()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark9()
					.sendKeys(requestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth8());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth8()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark8()
					.sendKeys(requestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth7());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth7()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7()
					.sendKeys(requestAndAllocationTestData.Remark);

		} else if (budgettype.equalsIgnoreCase("QUARTERLY")) {

			// ----------------------------THIS CODE FOR QUARTERLY
			// BUDGET---------------------------//

			javaHelper.JavaScriptHelper(driver);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark3()
					.sendKeys(requestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark2()
					.sendKeys(requestAndAllocationTestData.Remark);

		} else if (budgettype.equalsIgnoreCase("HALFYEARLY")) {

			// ---------------------------------THIS CODE FOR HALFYEARLY
			// BUDGET-------------------------//

			javaHelper.JavaScriptHelper(driver);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy1());
			requestAndAllocation.budget_requestAndAllocation_BudgetHy1()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHyremark1());
			requestAndAllocation.budget_requestAndAllocation_BudgetHyremark1()
					.sendKeys(requestAndAllocationTestData.Remark);

		}

	}

	// REVIEWER APPROVE

	@And("^Submit the record in reviewer$")
	public void submit_the_record_in_reviewer() throws Throwable {

		// ---------------------SUBMIT THE REVIEWER RECORD-----------------------//
		waitHelper.waitForElement(driver, 5000, reviewerObj.reviewerAlertRemarks());
		reviewerObj.reviewerAlertRemarks().sendKeys("ok");
		waitHelper.waitForElement(driver, 5000, reviewerObj.reviewerAlertSubmitButton());
		// reviewer.reviewerAlertSubmitButton().click();
		javaHelper.JSEClick(reviewerObj.reviewerAlertSubmitButton());
		waitHelper.waitForElement(driver, 3000, reviewerObj.approvalStatus());
		String Notification = reviewerObj.approvalStatus().getText();
		System.out.println("Reviewer Notification: " + Notification);
		Assert.assertTrue(reviewerObj.approvalStatus().isDisplayed());
	}

	// CHECKER APPROVE

	@And("^Approve the Record in checker$")
	public void approve_the_record_in_checker() throws Throwable {

		// ------------------APPROVE THE RECORD----------------------//
		waitHelper.waitForElement(driver, 2000, kubsChecker.checkerApproveButton());
		kubsChecker.checkerApproveButton().click();
	}

	@Then("^Submit the Record in checker$")
	public void submit_the_record_in_checker() throws Throwable {

		// -----------------------SUBMIT THE RECORD------------------------//
		waitHelper.waitForElement(driver, 2000, kubsChecker.checkerRemarks());
		kubsChecker.checkerRemarks().sendKeys("ok");
		waitHelper.waitForElement(driver, 2000, kubsChecker.checkersubmitButton());
		kubsChecker.checkersubmitButton().click();
		waitHelper.waitForElement(driver, 3000, kubsChecker.Popup_status());
		Assert.assertTrue(kubsChecker.Popup_status().isDisplayed());
	}

	// -------------------@KUBS_UAT_BudgetReject_KUBS_BP_UAT_002_006----------------//

	@Then("^Current Budget Code$")
	public void Current_Budget_Code() throws Throwable {

		// ----------TO SELECT THE BUDGET CODE----------------//
		requestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		// requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(requestAndAllocationTestData.BudgetCodeUat);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
	}

	@And("^Select Branch checkbox$")
	public void select_branch_checkbox() throws Throwable {

		// ---------------------TO SELECT ONE BRANCH CHECKBOX-----------------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_type1());
		requestAndAllocation.requestAndAllocation_branch_type1().click();
	}

	@And("^Budget Amount for Budget Type Show in Budget type field$")
	public void budget_amount_for_budget_type_show_in_budget_type_field() throws Throwable {

		// ----------------------HERE WE ENTER BUDGET AMOUNT FOR EVERY BUDGET
		// TYPE----------------------//
		requestAndAllocationBudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgettype());
		String budgettype = requestAndAllocation.budget_requestAndAllocation_Budgettype().getText();
		requestAndAllocationBudtype = jsonReader.getBudtypeByName(budgettype);
		javaHelper.JavaScriptHelper(driver);
		if (budgettype.equalsIgnoreCase("YEARLY")) {

			// ---------------------------THIS CODE FOR YEARLY
			// BUDGET--------------------------//

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JavaScriptHelper(driver);
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyearly());
			requestAndAllocation.budget_requestAndAllocation_Budgetyearly()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetremark()
					.sendKeys(requestAndAllocationTestData.Remark);
		} else if (budgettype.equalsIgnoreCase("MONTHLY")) {

			// ----------------------------THIS CODE FOR MONTHLY
			// BUDGET-------------------------//

			javaHelper.JavaScriptHelper(driver);
			javaHelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth12()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark12()
					.sendKeys(requestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth11());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth11()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark11()
					.sendKeys(requestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth10());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth10()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark10()
					.sendKeys(requestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth9());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth9()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark9()
					.sendKeys(requestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth8());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth8()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark8()
					.sendKeys(requestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth7());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth7()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7()
					.sendKeys(requestAndAllocationTestData.Remark);

		} else if (budgettype.equalsIgnoreCase("QUARTERLY")) {

			// ----------------------------THIS CODE FOR QUARTERLY
			// BUDGET---------------------------//

			javaHelper.JavaScriptHelper(driver);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark3()
					.sendKeys(requestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark2()
					.sendKeys(requestAndAllocationTestData.Remark);

		} else if (budgettype.equalsIgnoreCase("HALFYEARLY")) {

			// ---------------------------------THIS CODE FOR HALFYEARLY
			// BUDGET-------------------------//

			javaHelper.JavaScriptHelper(driver);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy2());
			requestAndAllocation.budget_requestAndAllocation_BudgetHy2()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHyremark2());
			requestAndAllocation.budget_requestAndAllocation_BudgetHyremark2()
					.sendKeys(requestAndAllocationTestData.Remark);

		}
	}

	// REVIEWER STEP ALREADY WRITE IN COMMON STEPS -->-->-->-->-->-->--> Line No 782

	// CHECKER -REJECTING

	@And("^Reject the Record in checker$")
	public void Reject_the_Record_in_checker() throws Throwable {

		// ------------------CLICK THE REJECT BUTTON--------------------------//
		waitHelper.waitForElement(driver, 2000, kubsChecker.checkerRejectButton());
		kubsChecker.checkerRejectButton().click();
	}

	@Then("^Submit the Rejecting Record in checker$")
	public void Submit_the_Rejecting_Record_in_checker() throws Throwable {

		// -----------------SUBMIT THE REJECT RECORD-----------------------//
		waitHelper.waitForElement(driver, 2000, kubsChecker.checkerRemarks());
		kubsChecker.checkerRemarks().sendKeys("Reject");
		// waithelper.waitForElement(driver, 10000, kubschecker.checkersubmitButton());
		kubsChecker.checkersubmitButton().click();
		waitHelper.waitForElementVisible(kubsChecker.Popup_status(), 2000, 2000);
		Assert.assertTrue(kubsChecker.Popup_status().isDisplayed());
	}

	// ----------------------@KUBS_UAT_KUBS_BP_UAT_002_007----------------------//

	// **********Previous steps already written ***********//

	@Then("^Again Login the Maker$")
	public void again_login_the_maker() throws Throwable {
		// ---------LOGIN THE MAKER USER--------------//
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioApp("Maker");
		Thread.sleep(1000);
	}

	@And("^click on the Record Reject$")
	public void click_on_the_record_reject() throws Throwable {

		// ------------TO Reject THE RECORD------------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_Cancel());
		requestAndAllocation.budget_requestAndAllocation_Cancel().click();
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_Alertremark());
		requestAndAllocation.requestAndAllocation_Alertremark().sendKeys(requestAndAllocationTestData.Remark);
		waitHelper.waitForElement(driver, 5000, requestAndAllocation.requestAndAllocation_Alertsubmit());
		requestAndAllocation.requestAndAllocation_Alertsubmit().click();
		waitHelper.waitForElement(driver, 10000, requestAndAllocation.requestAndAllocation_reviewer_id());
		reviwerId = requestAndAllocation.requestAndAllocation_reviewer_id().getText();
		System.out.println("The Result is:" + reviwerId);
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.requestAndAllocation_notificationClose());
		requestAndAllocation.requestAndAllocation_notificationClose().click();

	}

	@And("^Save the Record and capture the output$")
	public void save_the_record_and_capture_the_output() throws Throwable {
		// ------------TO SAVE THE RECORD--------------------//
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_AllowSave());
		requestAndAllocation.budget_requestAndAllocation_AllowSave().click();
		Thread.sleep(2000);
		javaHelper.JavaScriptHelper(driver);
		String output = (String) javaHelper.executeScript(
				"return document.querySelector('ion-toast').shadowRoot.querySelector('div[class=toast-message]').innerText");
		System.out.println(output);
		System.out.println("System should allow the rejected budget code Again Re-use");
	}

	// ---------------------@KUBS_UAT_KUBS_BP_UAT_003_001----------------------//

	@And("^Change the Amount Before Approval$")
	public void change_the_amount_before_approval() throws Throwable {
		// ------------HERE WE ENTER BEFORE BUDGET AMOUNT FOR EVERY BUDGET TYPE------------------//
		javaHelper.JavaScriptHelper(driver);
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy2());
		requestAndAllocation.budget_requestAndAllocation_BudgetHy2().clear();
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy2());
		requestAndAllocation.budget_requestAndAllocation_BudgetHy2().click();
		Thread.sleep(1000);
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy2());
		requestAndAllocation.budget_requestAndAllocation_BudgetHy2().sendKeys("500000");
	}

    
	// ---------------------@KUBS_UAT_KUBS_BP_UAT_003_002----------------------//

    @Then("^Enter the Budget type$")
    public void enter_the_budget_type() throws Throwable {
    	
    	waitHelper.waitForElement(driver, 3000, requestAndAllocation.requestAndAllocation_BudgetHytype());
    	requestAndAllocation.requestAndAllocation_BudgetHytype().click();
    	requestAndAllocation.requestAndAllocation_BudgetHytype().sendKeys("Half");
    }
    
    @Then("^Click on Table Row First Eye Icon$")
    public void click_on_table_row_first_eye_icon() throws Throwable {
    	waitHelper.waitForElement(driver, 3000, requestAndAllocation.requestAndAllocation_Budget_TableEye());
    	requestAndAllocation.requestAndAllocation_Budget_TableEye().click();
    }
    
    @And("^Click On Search Icon$")
    public void click_on_search_icon() throws Throwable {
    	waitHelper.waitForElement(driver, 3000, requestAndAllocation.requestAndAllocation_Budget_Search());
    	requestAndAllocation.requestAndAllocation_Budget_Search().click();
    }
    
    @And("^Change the Amount After Approval$")
    public void change_the_amount_after_approval() throws Throwable {
		javaHelper.JavaScriptHelper(driver);
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javaHelper.scrollIntoView(requestAndAllocation.budget_requestAndAllocation_BudgetHy2());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy2());
		requestAndAllocation.budget_requestAndAllocation_BudgetHy2().clear();
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy2());
		requestAndAllocation.budget_requestAndAllocation_BudgetHy2().click();
		Thread.sleep(1000);
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy2());
		requestAndAllocation.budget_requestAndAllocation_BudgetHy2().sendKeys("500000");
    }
    
    @When("^validate the modification$")
    public void validate_the_modification() throws Throwable {
        //-------VALIDATE THE MODIFICATION-------//    	
    	try {
    		
    		requestAndAllocation.budget_requestAndAllocation_AllowSave().click();    		    		
    	}
    	catch(NoSuchElementException e) {
    		System.out.println("System should not Allow to Modify the Amount");
    	}
    }
    
	// ---------------------@KUBS_UAT_KUBS_BP_UAT_003_003----------------------//

	@Then("^Monthly Budget Code$")
	public void monthly_budget_code() throws Throwable {

		// ----------------ENTER THE MONTHLY BUDGET CODE---------------------//
		requestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(requestAndAllocationTestData.Monthly);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);

	}

	@Then("^Capture April Month$")
	public void capture_april_month() throws Throwable {

		// -----------------CAPTURE MONTH AND ENTER AMOUNT-----------------------//
		javaHelper.JavaScriptHelper(driver);
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.april_Month());
		Assert.assertTrue(requestAndAllocation.april_Month().isDisplayed());
		requestAndAllocation.budget_requestAndAllocation_Budgetmonth1()
				.sendKeys(requestAndAllocationTestData.BudgetAmount);
		System.out.println("CURRENT MONTH IS ON APRIL");
	}

	@And("^Capture May Month$")
	public void capture_may_month() throws Throwable {

		// -----------------CAPTURE MONTH AND ENTER AMOUNT-----------------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.may_Month());
		Assert.assertTrue(requestAndAllocation.may_Month().isDisplayed());
		requestAndAllocation.budget_requestAndAllocation_Budgetmonth2()
				.sendKeys(requestAndAllocationTestData.BudgetAmount);
	}

	@Then("^Capture June Month$")
	public void capture_june_month() throws Throwable {

		// -----------------CAPTURE MONTH AND ENTER AMOUNT-----------------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.june_Month());
		Assert.assertTrue(requestAndAllocation.june_Month().isDisplayed());
		requestAndAllocation.budget_requestAndAllocation_Budgetmonth3()
				.sendKeys(requestAndAllocationTestData.BudgetAmount);
	}

	@And("^Capture July Month$")
	public void capture_july_month() throws Throwable {

		// -----------------CAPTURE MONTH AND ENTER AMOUNT-----------------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.july_Month());
		Assert.assertTrue(requestAndAllocation.july_Month().isDisplayed());
		requestAndAllocation.budget_requestAndAllocation_Budgetmonth4()
				.sendKeys(requestAndAllocationTestData.BudgetAmount);
	}

	@Then("^Capture Augest Month$")
	public void capture_augest_month() throws Throwable {

		// -----------------CAPTURE MONTH AND ENTER AMOUNT-----------------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.august_Month());
		Assert.assertTrue(requestAndAllocation.august_Month().isDisplayed());
		requestAndAllocation.budget_requestAndAllocation_Budgetmonth5()
				.sendKeys(requestAndAllocationTestData.BudgetAmount);
	}

	@And("^Capture Sepetember Month$")
	public void capture_sepetember_month() throws Throwable {

		// -----------------CAPTURE MONTH AND ENTER AMOUNT-----------------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.september_Month());
		Assert.assertTrue(requestAndAllocation.september_Month().isDisplayed());
		requestAndAllocation.budget_requestAndAllocation_Budgetmonth6()
				.sendKeys(requestAndAllocationTestData.BudgetAmount);
	}

	@Then("^Capture October Month$")
	public void capture_october_month() throws Throwable {

		// -----------------CAPTURE MONTH AND ENTER AMOUNT-----------------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.october_Month());
		Assert.assertTrue(requestAndAllocation.october_Month().isDisplayed());
		requestAndAllocation.budget_requestAndAllocation_Budgetmonth7()
				.sendKeys(requestAndAllocationTestData.BudgetAmount);
	}

	@And("^Capture November Month$")
	public void capture_november_month() throws Throwable {

		// -----------------CAPTURE MONTH AND ENTER AMOUNT-----------------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.november_Month());
		Assert.assertTrue(requestAndAllocation.november_Month().isDisplayed());
		requestAndAllocation.budget_requestAndAllocation_Budgetmonth8()
				.sendKeys(requestAndAllocationTestData.BudgetAmount);
	}

	@Then("^Capture December Month$")
	public void capture_december_month() throws Throwable {

		// -----------------CAPTURE MONTH AND ENTER AMOUNT-----------------------//
		javaHelper.scrollIntoView(requestAndAllocation.december_Month());
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.december_Month());
		Assert.assertTrue(requestAndAllocation.december_Month().isDisplayed());
		requestAndAllocation.budget_requestAndAllocation_Budgetmonth9()
				.sendKeys(requestAndAllocationTestData.BudgetAmount);
	}

	@And("^Capture January Month$")
	public void capture_january_month() throws Throwable {

		// -----------------CAPTURE MONTH AND ENTER AMOUNT-----------------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.january_Month());
		Assert.assertTrue(requestAndAllocation.january_Month().isDisplayed());
		requestAndAllocation.budget_requestAndAllocation_Budgetmonth10()
				.sendKeys(requestAndAllocationTestData.BudgetAmount);
	}

	@Then("^Capture Feburary Month$")
	public void capture_feburary_month() throws Throwable {

		// -----------------CAPTURE MONTH AND ENTER AMOUNT-----------------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.february_Month());
		Assert.assertTrue(requestAndAllocation.february_Month().isDisplayed());
		requestAndAllocation.budget_requestAndAllocation_Budgetmonth11()
				.sendKeys(requestAndAllocationTestData.BudgetAmount);
	}

	@And("^Capture March Month$")
	public void capture_march_month() throws Throwable {

		// -----------------CAPTURE MONTH AND ENTER AMOUNT-----------------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.march_Month());
		Assert.assertTrue(requestAndAllocation.march_Month().isDisplayed());
		requestAndAllocation.budget_requestAndAllocation_Budgetmonth12()
				.sendKeys(requestAndAllocationTestData.BudgetAmount);

	}

	// ----------------------@KUBS_UAT_KUBS_BP_UAT_003_004----------------------//

	@Then("^Quarterly Budget Code$")
	public void quarterly_budget_code() throws Throwable {

		// -----------------ENTER BUDGET CODE---------------------//
		requestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(requestAndAllocationTestData.Quarterly);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);

	}

	@And("^Enter the Budget Year$")
	public void enter_the_budget_year() throws Throwable {

		// ----------------BUDGET YEAR-----------------//
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyear());
		dropDownHelper.SelectUsingVisibleText(requestAndAllocation.budget_requestAndAllocation_Budgetyear(),
				requestAndAllocationTestData.BudgetYear);
	}

	@Then("^Give budget amount for quarterly$")
	public void give_budget_amount_for_quarterly() throws Throwable {

		// ---------------------ENTER QUARTERLY AMOUNT FOR 3rd and 4th
		// QUARTER----------------//
		requestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2());
		requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2()
				.sendKeys(requestAndAllocationTestData.BudgetAmount);
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3());
		requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3()
				.sendKeys(requestAndAllocationTestData.BudgetAmount);

	}

	// ----------------------@KUBS_UAT_KUBS_BP_UAT_003_005----------------------//

	@Then("^Halfyearly Budget Code$")
	public void halfyearly_budget_code() throws Throwable {

		// -----------------ENTER BUDGET CODE---------------------//
		requestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(requestAndAllocationTestData.Halfyearly);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
	}

	@And("^Enter the Budget Year for halfyearly$")
	public void enter_the_budget_year_for_halfyearly() throws Throwable {

		// ----------------BUDGET YEAR-----------------//
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyear());
		dropDownHelper.SelectUsingVisibleText(requestAndAllocation.budget_requestAndAllocation_Budgetyear(),
				requestAndAllocationTestData.BudgetYear1);
	}

	@Then("^Give budget amount for HalfYearly$")
	public void give_budget_amount_for_halfyearly() throws Throwable {

		// ---------------------ENTER QUARTERLY AMOUNT FOR 3rd and 4th
		// QUARTER----------------//
		requestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy2());
		requestAndAllocation.budget_requestAndAllocation_BudgetHy2()
				.sendKeys(requestAndAllocationTestData.BudgetAmount);
	}

	// ---------------------@KUBS_UAT_KUBS_BP_UAT_004_001----------------------//

	@Then("^select the Wrong Budget Code$")
	public void select_the_wrong_budget_code() throws Throwable {

		// ----------TO SELECT THE BUDGET CODE----------------//
		requestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode()
				.sendKeys(requestAndAllocationTestData.Budgetcancel);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
	}

	@And("^select FIRST Branch$")
	public void select_first_branch() throws Throwable {

		// ---------------------TO SELECT ONE BRANCH CHECKBOX-----------------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_type1());
		requestAndAllocation.requestAndAllocation_branch_type1().click();
	}

	@And("^select the past Budget Year$")
	public void select_the_past_budget_year() throws Throwable {

		// ----------TO SELECT THE PAST BUDGET YEAR---------------//
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyear());
		dropDownHelper.SelectUsingVisibleText(requestAndAllocation.budget_requestAndAllocation_Budgetyear(),
				requestAndAllocationTestData.BudgetYear1);
		// requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
	}

	@And("^Enter the Amount for Required Budget type$")
	public void enter_the_amount_for_required_budget_type() throws Throwable {

		// ----------------------HERE WE ENTER BUDGET AMOUNT FOR EVERY BUDGET
		// TYPE----------------------//
		requestAndAllocationBudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgettype());
		String budgettype = requestAndAllocation.budget_requestAndAllocation_Budgettype().getText();
		requestAndAllocationBudtype = jsonReader.getBudtypeByName(budgettype);
		javaHelper.JavaScriptHelper(driver);
		if (budgettype.equalsIgnoreCase("YEARLY")) {

			// ---------------------------THIS CODE FOR YEARLY
			// BUDGET--------------------------//

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JavaScriptHelper(driver);
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyearly());
			requestAndAllocation.budget_requestAndAllocation_Budgetyearly()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetremark()
					.sendKeys(requestAndAllocationTestData.Remark);
		} else if (budgettype.equalsIgnoreCase("MONTHLY")) {

			// ----------------------------THIS CODE FOR MONTHLY
			// BUDGET-------------------------//

			javaHelper.JavaScriptHelper(driver);
			javaHelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth12()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark12()
					.sendKeys(requestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth11());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth11()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark11()
					.sendKeys(requestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth10());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth10()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark10()
					.sendKeys(requestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth9());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth9()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark9()
					.sendKeys(requestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth8());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth8()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark8()
					.sendKeys(requestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth7());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth7()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7()
					.sendKeys(requestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth6());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth6()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark6()
					.sendKeys(requestAndAllocationTestData.Remark);

		} else if (budgettype.equalsIgnoreCase("QUARTERLY")) {

			// ----------------------------THIS CODE FOR QUARTERLY
			// BUDGET---------------------------//

			javaHelper.JavaScriptHelper(driver);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark3()
					.sendKeys(requestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark2()
					.sendKeys(requestAndAllocationTestData.Remark);

		} else if (budgettype.equalsIgnoreCase("HALFYEARLY")) {

			// ---------------------------------THIS CODE FOR HALFYEARLY
			// BUDGET-------------------------//

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy2());
			requestAndAllocation.budget_requestAndAllocation_BudgetHy2()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetHyremark2()
					.sendKeys(requestAndAllocationTestData.Remark);

		}
	}

	@And("^Click the Cancel button$")
	public void click_the_cancel_button() throws Throwable {

		// --------------------CLICK ON CANCEL----------------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_Cancel());
		requestAndAllocation.budget_requestAndAllocation_Cancel().click();
	}

	@Then("^Submit the Cancel Record$")
	public void submit_the_cancel_record() throws Throwable {

		// -----------------------SUBMIT THE RECORD------------------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_Alertremark());
		requestAndAllocation.requestAndAllocation_Alertremark().sendKeys(requestAndAllocationTestData.Remark);
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_Alertsubmit());
		requestAndAllocation.requestAndAllocation_Alertsubmit().click();
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.Popup_status());
		String status = requestAndAllocation.Popup_status().getText();
		System.out.println(status);
	}

	
	// -----------------------------@KUBS_UAT_KUBS_BP_UAT_004_002-----------------------------//


    @And("^Get Budget type$")
    public void get_budget_type() throws Throwable {
        //-------GET BUDGET TYPE-------//
    	waitHelper.waitForElement(driver, 3000, requestAndAllocation.requestAndAllocation_GetBudgettype());
    	Type = requestAndAllocation.requestAndAllocation_GetBudgettype().getText();
    	System.out.println(Type);
    }
    
    @And("^Click on sub module Budget creation Reports$")
    public void click_on_sub_module_budget_creation_reports() throws Throwable {
    	//-------BUDGET CREATION REPORTS------//
    	javaHelper.JavaScriptHelper(driver);
    	javaHelper.scrollIntoView(requestAndAllocation.Reports_Bud_Creation());
    	requestAndAllocation.Reports_Bud_Creation().click();
    }
    
    @Then("^Give the Getted budget type$")
    public void give_the_getted_budget_type() throws Throwable {
        //--------GIVE BUDGET TYPE---------//
    	waitHelper.waitForElement(driver, 3000, requestAndAllocation.Reports_Bud_Creation_BudType());
    	requestAndAllocation.Reports_Bud_Creation_BudType().click();
    	requestAndAllocation.Reports_Bud_Creation_BudType().sendKeys(Type);
    	requestAndAllocation.Reports_Bud_Creation_BudType().sendKeys(Keys.ENTER);
    }

    @Then("^Third Segment report Icon$")
    public void third_segment_report_icon() throws Throwable {
    	javaHelper.JavaScriptHelper(driver);
    	javaHelper.scrollIntoView(requestAndAllocation.Reports_Bud_Creation_ReportIcon());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.Reports_Bud_Creation_ReportIcon());
    	requestAndAllocation.Reports_Bud_Creation_ReportIcon().click();
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.Reports_Bud_Creation_EnquiryMenu());
		Assert.assertTrue(requestAndAllocation.Reports_Bud_Creation_EnquiryMenu().isDisplayed());
    }

    @And("^Click main module Reports$")
    public void click_main_module_reports() throws Throwable {
    	waitHelper.waitForElement(driver, 3000, requestAndAllocation.Reports_Bud_Creation_ReportModule());
    	requestAndAllocation.Reports_Bud_Creation_ReportModule().click();
    } 
    
    @Then("^Give Current business Date$")
    public void give_current_business_date() throws Throwable {
    	// ----------CLICK ON DATE--------------//
    	requestAndAllocation.ARAP_Report_Module_Date().click();
		javaHelper.JavaScriptHelper(driver);
		while (true) {
			try {

				waitHelper.waitForElement(driver, 3000, driver.findElement(
						By.xpath("//span[contains(text(),'" + requestAndAllocationTestData.Month + " " + requestAndAllocationTestData.Year + "')]")));
				driver.findElement(
						By.xpath("//span[contains(text(),'" + requestAndAllocationTestData.Month + " " + requestAndAllocationTestData.Year + "')]"));
				break;
			}

			catch (NoSuchElementException nosuchElement) {
				requestAndAllocation.ARAPNextMonth().click();

			}
		}
		waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//td[@aria-label='"
				+ requestAndAllocationTestData.FullMonth + " " + requestAndAllocationTestData.Date + ", " + requestAndAllocationTestData.Year + "']/span")));
		WebElement Click = driver.findElement(By.xpath("//td[@aria-label='" + requestAndAllocationTestData.FullMonth + " "
				+ requestAndAllocationTestData.Date + ", " + requestAndAllocationTestData.Year + "']/span"));

		clickAndActionHelper.doubleClick(Click);
    }

    @Then("^Click on View button$")
    public void click_on_view_button() throws Throwable {
    	waitHelper.waitForElement(driver, 3000, requestAndAllocation.Reports_Bud_Creation_ViewButton());
    	requestAndAllocation.Reports_Bud_Creation_ViewButton().click();
    }
    
    @And("^Verify the Budget creation Report$")
    public void verify_the_budget_creation_report() throws Throwable {
		browserHelper.SwitchToWindow(1);
		javaHelper.JavaScriptHelper(driver);
		/*Set<String> windowHandles = driver.getWindowHandles();
		for (String string : windowHandles) {
			String title = driver.switchTo().window(string).getTitle();
			System.out.println(title);
		}*/
		while (true) {
			Thread.sleep(2000);
			try {
				javaHelper
						.scrollIntoView(driver.findElement(By.xpath("//div[contains(text(),'" + Type + "')]")));
				driver.findElement(By.xpath("//div[contains(text(),'" + Type + "')]")).isDisplayed();
				break;
			} catch (NoSuchElementException e) {
				waitHelper.waitForElement(driver, 3000, requestAndAllocation.Reports_Bud_Creation_Nextbtn());
				requestAndAllocation.Reports_Bud_Creation_Nextbtn().click();
			}
		}
		
		browserHelper.switchToParentWithChildClose();
    }
	
	// -----------------------------@KUBS_UAT_KUBS_BP_UAT_005_001-----------------------------//

	@Then("^Select the Branch Request Budget Code$")
	public void select_the_branch_request_budget_code() throws Throwable {

		// ----------TO SELECT THE BUDGET CODE----------------//
		requestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode()
				.sendKeys(requestAndAllocationTestData.BudgetAllocate);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
	}

	@And("^Select the Requested Branch$")
	public void select_the_requested_branch() throws Throwable {

		// ---------------ENTER REQUESTED BRANCH-----------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_type4());
		requestAndAllocation.requestAndAllocation_branch_type4().click();
	}

	@And("^Give Branch requested to allocate the budget amount$")
	public void give_branch_requested_to_allocate_the_budget_amount() throws Throwable {

		// ----------------------HERE WE ENTER BUDGET AMOUNT FOR EVERY BUDGET
		// TYPE----------------------//
		requestAndAllocationBudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgettype());
		String budgettype = requestAndAllocation.budget_requestAndAllocation_Budgettype().getText();
		requestAndAllocationBudtype = jsonReader.getBudtypeByName(budgettype);
		javaHelper.JavaScriptHelper(driver);
		if (budgettype.equalsIgnoreCase("YEARLY")) {

			// ---------------------------THIS CODE FOR YEARLY
			// BUDGET--------------------------//

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JavaScriptHelper(driver);
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyearly());
			requestAndAllocation.budget_requestAndAllocation_Budgetyearly()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetremark()
					.sendKeys(requestAndAllocationTestData.Remark);
		} else if (budgettype.equalsIgnoreCase("MONTHLY")) {

			// ----------------------------THIS CODE FOR MONTHLY
			// BUDGET-------------------------//

			javaHelper.JavaScriptHelper(driver);
			javaHelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth12()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark12()
					.sendKeys(requestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth11());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth11()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark11()
					.sendKeys(requestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth10());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth10()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark10()
					.sendKeys(requestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth9());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth9()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark9()
					.sendKeys(requestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth8());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth8()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark8()
					.sendKeys(requestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth7());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth7()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7()
					.sendKeys(requestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth6());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth6()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark6()
					.sendKeys(requestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth5());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth5()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark5()
					.sendKeys(requestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth4());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth4()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark4()
					.sendKeys(requestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth3());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth3()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark3()
					.sendKeys(requestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth2());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth2()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark2()
					.sendKeys(requestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth1());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth1()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark1()
					.sendKeys(requestAndAllocationTestData.Remark);

		} else if (budgettype.equalsIgnoreCase("QUARTERLY")) {

			// ----------------------------THIS CODE FOR QUARTERLY
			// BUDGET---------------------------//

			javaHelper.JavaScriptHelper(driver);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark3()
					.sendKeys(requestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark2()
					.sendKeys(requestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly1());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly1()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark1()
					.sendKeys(requestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly0());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly0()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark0()
					.sendKeys(requestAndAllocationTestData.Remark);

		} else if (budgettype.equalsIgnoreCase("HALFYEARLY")) {

			// ---------------------------------THIS CODE FOR HALFYEARLY
			// BUDGET-------------------------//

			javaHelper.JavaScriptHelper(driver);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy1());
			requestAndAllocation.budget_requestAndAllocation_BudgetHy1()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHyremark1());
			requestAndAllocation.budget_requestAndAllocation_BudgetHyremark1()
					.sendKeys(requestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy2());
			requestAndAllocation.budget_requestAndAllocation_BudgetHy2()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetHyremark2()
					.sendKeys(requestAndAllocationTestData.Remark);

		}
	}

}
