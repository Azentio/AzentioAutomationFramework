package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.DropDownHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.BUDGET_RequestAndAllocationObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_ReviewerObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.BUDGET_RequestAndAllocationTestDataType;
import testDataType.BUDGET_RequestandallocationBUDTYPEDATA;

public class KUBS_RequestandAllocation extends BaseClass {
	WebDriver driver = BaseClass.driver;
	ConfigFileReader configFileReader = new ConfigFileReader();
	KUBS_Login login;
	BUDGET_RequestAndAllocationObj requestAndAllocation;
	WaitHelper waitHelper = new WaitHelper(driver);
	String reviwerId;
	BUDGET_RequestAndAllocationTestDataType RequestAndAllocationTestData;
	JsonConfig jsonReader = new JsonConfig();
	DropDownHelper dropDownHelper = new DropDownHelper(driver);
	BUDGET_RequestandallocationBUDTYPEDATA requestandallocationbudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
	JavascriptHelper javahelper = new JavascriptHelper();
	JsonDataReaderWriter json = new JsonDataReaderWriter();
	KUBS_ReviewerObj reviewerObj = new KUBS_ReviewerObj(driver);
	String referance_id;
	BrowserHelper browserHelper;
	KUBS_CheckerObj kubschecker = new KUBS_CheckerObj(driver);

	// ********************* KUBS_RequestandAllocation_BP_BC_05_01 *********************//

	@Given("^Navigate the Azentio Maker Url and Click Finance option$")
	public void navigate_the_azentio_maker_url_and_click_finance_option() throws Throwable {

		// --------------------LOGIN THE MAKER USER-------------------//
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioApp("Maker");

	}

	@Then("^Click Two Direction Icon$")
	public void click_two_direction_icon() throws Throwable {

		// -------------------TO VIEW THE TRANFER AMOUNT BUDGET-----------------//
		requestAndAllocation = new BUDGET_RequestAndAllocationObj(driver);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver, 5000, requestAndAllocation.budget_requestAndAllocation_DirctionIcon());
		requestAndAllocation.budget_requestAndAllocation_DirctionIcon().click();

	}

	@And("^Click on Budget$")
	public void click_on_budget() throws Throwable {

		// -------------------------TO CLICK THE BUDGET
		// MODULE--------------------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetField());
		requestAndAllocation.budget_requestAndAllocation_BudgetField().click();
	}

	@Then("^Click on Budget Sub module Budget Request and Allocation Near Eye Icon$")
	public void click_on_Budget_Sub_module_budget_request_and_allocation_near_eye_icon() throws Throwable {

		// -----------------------TO CLICK THE EYE
		// ICON--------------------------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon());
		requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon().click();
	}

	@And("^Click on Add icon in Request and Allocation$")
	public void click_on_add_icon_in_request_and_allocation() throws Throwable {

		// --------------------TO CREATE A NEW BUDGET AMOUNT-------------------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_Addicon());
		requestAndAllocation.budget_requestAndAllocation_Addicon().click();
	}

	@Then("^Select Budget Code$")
	public void select_budget_code() throws Throwable {

		// ----------------------TO SELECT THE BUDGET CODE---------------------------//
		RequestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(RequestAndAllocationTestData.BudgetCode);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
	}

	@And("^Select Budget Year$")
	public void select_budget_year() throws Throwable {

		// ---------------------TO SELECT THE BUDGET YEAR----------------------//
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyear());
		dropDownHelper.SelectUsingVisibleText(requestAndAllocation.budget_requestAndAllocation_Budgetyear(),
				RequestAndAllocationTestData.BudgetYear);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
	}

	@Then("^Click on Branch$")
	public void click_on_branch() throws Throwable {

		// ------------------------TO SELECT THE BRANCH-------------------------//
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetbranch());
		requestAndAllocation.budget_requestAndAllocation_Budgetbranch().click();
	}

	@And("^Select one Branch$")
	public void select_one_branch() throws Throwable {

		// ---------------------TO SELECT ONE BRANCH CHECKBOX-----------------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_type2());
		requestAndAllocation.requestAndAllocation_branch_type2().click();
	}

	@Then("^Click on Branch ok button$")
	public void click_on_branch_ok_button() throws Throwable {
		
		//-------------------------TO CLICK BRANCH OK BUTTON-----------------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_branchOK());
		requestAndAllocation.budget_requestAndAllocation_branchOK().click();
	}

	@Then("^Select Which currency we need$")
	public void select_which_currency_we_need() throws Throwable {
		
		//-------------------------TO SELECT THE CURRENCY WE NEED---------------------------//
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Amountcurruncy());
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().click();
		// requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.ENTER);
	}

	@And("^Enter Amount for which Budget Type Show in Budget type field$")
	public void enter_amount_for_which_budget_type_show_in_budget_type_field() throws Throwable {
		
		//----------------------HERE WE ENTER BUDGET AMOUNT FOR EVERY BUDGET TYPE----------------------//		
		requestandallocationbudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgettype());
		String budgettype = requestAndAllocation.budget_requestAndAllocation_Budgettype().getText();
		requestandallocationbudtype = jsonReader.getBudtypeByName(budgettype);
		javahelper.JavaScriptHelper(driver);
		if (budgettype.equalsIgnoreCase("YEARLY")) {
			
			// ---------------------------THIS CODE FOR YEARLY BUDGET--------------------------//
			
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JavaScriptHelper(driver);
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyearly());
			requestAndAllocation.budget_requestAndAllocation_Budgetyearly()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetremark()
					.sendKeys(RequestAndAllocationTestData.Remark);
		} else if (budgettype.equalsIgnoreCase("MONTHLY")) {
			
			// ----------------------------THIS CODE FOR MONTHLY BUDGET-------------------------//
			
			javahelper.JavaScriptHelper(driver);
			javahelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth12()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark12()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth11());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth11()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark11()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth10());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth10()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark10()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth9());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth9()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark9()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth8());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth8()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark8()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth7());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth7()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth6());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth6()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark6()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth5());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth5()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark5()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth4());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth4()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark4()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth3());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth3()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark3()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth2());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth2()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark2()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth1());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth1()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark1()
					.sendKeys(RequestAndAllocationTestData.Remark);

		} else if (budgettype.equalsIgnoreCase("QUARTERLY")) {
			
			// ----------------------------THIS CODE FOR QUARTERLY BUDGET---------------------------//
			
			javahelper.JavaScriptHelper(driver);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark3()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark2()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly1());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly1()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark1()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly0());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly0()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark0()
					.sendKeys(RequestAndAllocationTestData.Remark);

		} else if (budgettype.equalsIgnoreCase("HALFYEARLY")) {
			
			// ---------------------------------THIS CODE FOR HALFYEARLY BUDGET-------------------------//
			
			javahelper.JavaScriptHelper(driver);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy1());
			requestAndAllocation.budget_requestAndAllocation_BudgetHy1()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHyremark1());
			requestAndAllocation.budget_requestAndAllocation_BudgetHyremark1()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy2());
			requestAndAllocation.budget_requestAndAllocation_BudgetHy2()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetHyremark2()
					.sendKeys(RequestAndAllocationTestData.Remark);

		}
	}

	@And("^click on save button$")
	public void click_on_save_button() throws Throwable {
		
		//-----------------------TO SAVE THE RECORD---------------------//
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_AllowSave());
		requestAndAllocation.budget_requestAndAllocation_AllowSave().click();

	}

	@Then("^Click on Maker Notification button$")
	public void click_on_maker_notification_button() throws Throwable {
		
		//---------------------------TO CLICK THE MAKER NOTIFICATION------------------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.makerNotificationIcon());
		requestAndAllocation.makerNotificationIcon().click();
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.maker_Referance_id());
		String Referance_id = requestAndAllocation.maker_Referance_id().getText();
		json.addReferanceData(Referance_id);
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.maker_Action_icon());
		requestAndAllocation.maker_Action_icon().click();

	}

	@And("^Click on Record submit$")
	public void click_on_record_submit() throws Throwable {
		
		//-------------------------TO SUBMIT THE RECORD-----------------------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetSubmit());
		requestAndAllocation.budget_requestAndAllocation_BudgetSubmit().click();
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_Alertremark());
		requestAndAllocation.requestAndAllocation_Alertremark().sendKeys(RequestAndAllocationTestData.Remark);
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

	// Reviewer - Flow
	@Given("^Navigate the Azentio Url login as Reviewer$")
	public void navigate_the_azentio_url_login_as_reviewer() throws Throwable {
		
		//----------------------------LOGIN AS REVIEWER-----------------------//
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.logintoAzentioappReviewer("Reviewer", json.readdata());
	}

	@Then("^Click on Notification icon$")
	public void click_on_notification_icon() throws Throwable {
		
		//------------------------CLICK ON REVIEWER NOTIFICATION-----------------------//
		reviewerObj = new KUBS_ReviewerObj(driver);
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewerNotidicationIcon());
		reviewerObj.reviewerNotidicationIcon().click();
	}

	@And("^Click on Reviewer Action button$")
	public void click_on_Reviewer_action_button() throws Throwable {
		
		//---------------------CLICK TO RECORD ACTION ICON-------------------------//
		javahelper.JavaScriptHelper(driver);
		// span[contains(text(),'336')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//div//ion-buttons//ion-button
		String befr_xpath = "//span[contains(text(),'";
		String aftr_xpath = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//div//ion-buttons//ion-button";
		waitHelper.waitForElement(driver, 2000,
				driver.findElement(By.xpath(befr_xpath + json.readReferancedata() + aftr_xpath)));
		driver.findElement(By.xpath(befr_xpath + json.readReferancedata() + aftr_xpath)).click();
		reviewerObj.reviewer_action_button().click();

	}

	@Then("^Click on Approve button in Reviewer$")
	public void click_on_approve_button_in_reviewer() throws Throwable {
		
		//--------------------APPROVE THE RECORD---------------------------//
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewerApproveButton());
		reviewerObj.reviewerApproveButton().click();
	}

	@And("^Submit the reviewer Record$")
	public void Submit_the_reviewer_Record() throws Throwable {
		
		//---------------------SUBMIT THE REVIEWER RECORD-----------------------//
		waitHelper.waitForElement(driver, 5000, reviewerObj.reviewerAlertRemarks());
		reviewerObj.reviewerAlertRemarks().sendKeys("ok");
		waitHelper.waitForElement(driver, 5000, reviewerObj.reviewerAlertSubmitButton());
		// reviewerObj.reviewerAlertSubmitButton().click();
		javahelper.JSEClick(reviewerObj.reviewerAlertSubmitButton());
		waitHelper.waitForElement(driver, 3000, reviewerObj.approvalStatus());
		Assert.assertTrue(reviewerObj.approvalStatus().isDisplayed());
	}

	// Checker - Flow
	@Given("^Navigate the Azentio Url login as checker$")
	public void navigate_the_azentio_url_login_as_checker() throws Throwable {
		
		//------------------LOGIN AS CHECKER---------------------------//
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioAppAsChecker("Checker");
	}

	@Then("^click on security management$")
	public void click_on_security_management() throws Throwable {
		
		//--------------------CLICK ON SECURITY MANAGEMENTS-----------------------------------//
		waitHelper.waitForElement(driver, 3000, kubschecker.checkerSecurityManagement());
		kubschecker.checkerSecurityManagement().click();
	}

	@And("^Click on sub module open pool near Edit icon$")
	public void click_on_sub_module_open_pool_near_edit_icon() throws Throwable {
		
		//----------------------CLICK ON OPEN POOL-----------------------//
		waitHelper.waitForElement(driver, 3000, kubschecker.checkerActionIcon());
		kubschecker.checkerActionIcon().click();
	}

	@Then("^Click the claim option$")
	public void click_the_claim_option() throws Throwable {
		
		//-------------------------CLICK CLAIM OPTION-------------------------//
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		waitHelper.waitForElement(driver, 10000,
				driver.findElement(By.xpath(before_xpath + json.readReferancedata() + after_xpath_claim)));
		driver.findElement(By.xpath(before_xpath + json.readReferancedata() + after_xpath_claim)).click();
		waitHelper.waitForElement(driver, 2000, kubschecker.checker_alert_close());
		kubschecker.checker_alert_close().click();
	}

	@And("^Click on checker notification icon$")
	public void click_on_checker_notification_icon() throws Throwable {
		
		//----------------CHECKER NOTIFICATION-----------------------//
		javahelper = new JavascriptHelper();
		waitHelper.waitForElement(driver, 3000, kubschecker.checkerNotificationIcon());
		javahelper.JavaScriptHelper(driver);
		javahelper.JSEClick(kubschecker.checkerNotificationIcon());
	}

	@Then("^click checker action icon$")
	public void click_checker_action_icon() throws Throwable {
		
		//------------------CHECKER ACTION------------------//
		waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"
				+ json.readReferancedata()
				+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(By.xpath("//span[contains(text(),'" + json.readReferancedata()
				+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"))
				.click();
	}

	@And("^Approve the Record$")
	public void Approve_the_Record() throws Throwable {
		
		//------------------APPROVE THE RECORD----------------------//
		waitHelper.waitForElement(driver, 2000, kubschecker.checkerApproveButton());
		kubschecker.checkerApproveButton().click();
	}

	@Then("^Submit the Record$")
	public void submit_the_Record() throws Throwable {
		
		//-----------------------SUBMIT THE RECORD------------------------//
		waitHelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
		kubschecker.checkerRemarks().sendKeys("ok");
		waitHelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();
		waitHelper.waitForElement(driver, 3000, kubschecker.Popup_status());
		Assert.assertTrue(kubschecker.Popup_status().isDisplayed());
	}

	/*
	 * 
	 * KUBS_Reviewer_Approve_Notification_BP_BC_05_02
	 * 
	 */
	@Given("^Navigate the Azentio Maker login$")
	public void Navigate_the_Azentio_Maker_login() throws Throwable {
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioApp("Maker");
		Thread.sleep(2000);
	}

	@Then("^Transfer Icon$")
	public void Transfer_Icon() throws Throwable {
		requestAndAllocation = new BUDGET_RequestAndAllocationObj(driver);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver, 5000, requestAndAllocation.budget_requestAndAllocation_DirctionIcon());
		requestAndAllocation.budget_requestAndAllocation_DirctionIcon().click();

	}

	@And("^Budget module in Transfer icon$")
	public void Budget_module_in_Transfer_icon() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetField());
		requestAndAllocation.budget_requestAndAllocation_BudgetField().click();
	}

	@Then("^Budget module Budget Request and Allocation Eye Icon$")
	public void Budget_module_Budget_Request_and_Allocation_Eye_Icon() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon());
		requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon().click();
	}

	@And("^Add icon button$")
	public void Add_icon_button() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_Addicon());
		requestAndAllocation.budget_requestAndAllocation_Addicon().click();
	}

	@Then("^New Budget Code$")
	public void New_Budget_Code() throws Throwable {
		RequestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(RequestAndAllocationTestData.BudgetCode);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
	}

	@And("^Current Budget Year$")
	public void Current_Budget_Year() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyear());
		dropDownHelper.SelectUsingVisibleText(requestAndAllocation.budget_requestAndAllocation_Budgetyear(),
				RequestAndAllocationTestData.BudgetYear);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
	}

	@Then("^Click  Branch$")
	public void click_branch() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetbranch());
		requestAndAllocation.budget_requestAndAllocation_Budgetbranch().click();
	}

	@And("^choose  Branch$")
	public void choose_Branch() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_type4());
		requestAndAllocation.requestAndAllocation_branch_type4().click();
	}

	@Then("^press Branch ok$")
	public void press_Branch_ok() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_branchOK());
		requestAndAllocation.budget_requestAndAllocation_branchOK().click();
	}

	@Then("^Choose one currency$")
	public void Choose_one_currency() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Amountcurruncy());
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().click();
		// requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.ENTER);
	}

	@And("^Enter Amount which Budget Type Show in budget type$")
	public void Enter_Amount_which_Budget_Type_Show_in_budget_type() throws Throwable {
		requestandallocationbudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgettype());
		String budgettype = requestAndAllocation.budget_requestAndAllocation_Budgettype().getText();
		requestandallocationbudtype = jsonReader.getBudtypeByName(budgettype);
		javahelper.JavaScriptHelper(driver);
		if (budgettype.equalsIgnoreCase("YEARLY")) {
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JavaScriptHelper(driver);
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyearly());
			requestAndAllocation.budget_requestAndAllocation_Budgetyearly()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetremark()
					.sendKeys(RequestAndAllocationTestData.Remark);
		} else if (budgettype.equalsIgnoreCase("MONTHLY")) {

			javahelper.JavaScriptHelper(driver);
			javahelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth12()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark12()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth11());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth11()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark11()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth10());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth10()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark10()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth9());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth9()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark9()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth8());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth8()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark8()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth7());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth7()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7()
					.sendKeys(RequestAndAllocationTestData.Remark);
			// javahelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7());

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth6());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth6()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark6()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth5());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth5()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark5()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth4());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth4()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark4()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth3());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth3()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark3()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth2());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth2()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark2()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth1());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth1()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark1()
					.sendKeys(RequestAndAllocationTestData.Remark);

		} else if (budgettype.equalsIgnoreCase("QUARTERLY")) {
			javahelper.JavaScriptHelper(driver);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark3()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark2()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly1());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly1()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark1()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly0());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly0()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark0()
					.sendKeys(RequestAndAllocationTestData.Remark);

		} else if (budgettype.equalsIgnoreCase("HALFYEARLY")) {
			javahelper.JavaScriptHelper(driver);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			// javahelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy1());
			requestAndAllocation.budget_requestAndAllocation_BudgetHy1()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHyremark1());
			requestAndAllocation.budget_requestAndAllocation_BudgetHyremark1()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy2());
			requestAndAllocation.budget_requestAndAllocation_BudgetHy2()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetHyremark2()
					.sendKeys(RequestAndAllocationTestData.Remark);

		}

	}

	@And("^save the record$")
	public void save_the_record() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_AllowSave());
		requestAndAllocation.budget_requestAndAllocation_AllowSave().click();
	}

	@Then("^Click Maker Notify Action button$")
	public void Click_maker_notify_Action_button() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.makerNotificationIcon());
		requestAndAllocation.makerNotificationIcon().click();
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.maker_Referance_id());
		String Referance_id = requestAndAllocation.maker_Referance_id().getText();
		json.addReferanceData(Referance_id);
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.maker_Action_icon());
		requestAndAllocation.maker_Action_icon().click();
	}

	@And("^Record submit$")
	public void Record_submit() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetSubmit());
		requestAndAllocation.budget_requestAndAllocation_BudgetSubmit().click();
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_Alertremark());
		requestAndAllocation.requestAndAllocation_Alertremark().sendKeys(RequestAndAllocationTestData.Remark);
		waitHelper.waitForElement(driver, 5000, requestAndAllocation.requestAndAllocation_Alertsubmit());
		requestAndAllocation.requestAndAllocation_Alertsubmit().click();
		waitHelper.waitForElement(driver, 10000, requestAndAllocation.requestAndAllocation_reviewer_id());
		reviwerId = requestAndAllocation.requestAndAllocation_reviewer_id().getText();
		String trimmdReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmdReviewerID);
		StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
		String filanReviewerID = bufferedString.toString();
		// json.addReferanceData(reviwerId =
		// requestAndAllocation.requestAndAllocation_reviewer_id().getText());
		json.addData(filanReviewerID);
		System.out.println(reviwerId);

	}

	// REVIEWER - APPROVER_Notification

	@Given("^Azentio Url login as Reviewer Approver$")
	public void Azentio_Url_login_as_Reviewer_Approver() throws Throwable {
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.logintoAzentioappReviewer("Reviewer", json.readdata());
	}

	@Then("^Capture to Notification icon$")
	public void Capture_to_Notification_icon() throws Throwable {
		reviewerObj = new KUBS_ReviewerObj(driver);
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewerNotidicationIcon());
		reviewerObj.reviewerNotidicationIcon().click();
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewer_referanceid());
		javahelper.JavaScriptHelper(driver);
		referance_id = reviewerObj.reviewer_referanceid().getText();
		System.out.println("Referance_id:" + referance_id);
		Assert.assertTrue(reviewerObj.reviewer_referanceid().isDisplayed());
	}

	@And("^Click the referance action icon$")
	public void click_the_referance_action_icon() throws Throwable {
		javahelper.JavaScriptHelper(driver);
		// span[contains(text(),'336')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//div//ion-buttons//ion-button
		String befr_xpath = "//span[contains(text(),'";
		String aftr_xpath = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//div//ion-buttons//ion-button";
		waitHelper.waitForElement(driver, 2000,
				driver.findElement(By.xpath(befr_xpath + json.readReferancedata() + aftr_xpath)));
		driver.findElement(By.xpath(befr_xpath + json.readReferancedata() + aftr_xpath)).click();

		reviewerObj.reviewer_action_button().click();
	}

	@Then("^Approve the record and get the Notification$")
	public void approve_the_record_and_get_the_notification() throws Throwable {
		json.addReferanceData(referance_id);
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewerApproveButton());
		reviewerObj.reviewerApproveButton().click();
		waitHelper.waitForElement(driver, 5000, reviewerObj.reviewerAlertRemarks());
		reviewerObj.reviewerAlertRemarks().sendKeys("ok");
		waitHelper.waitForElement(driver, 5000, reviewerObj.reviewerAlertSubmitButton());
		// reviewer.reviewerAlertSubmitButton().click();
		javahelper.JSEClick(reviewerObj.reviewerAlertSubmitButton());
		waitHelper.waitForElement(driver, 3000, reviewerObj.approvalStatus());
		String Notification = reviewerObj.approvalStatus().getText();
		System.out.println("Reviewer Notification: " + Notification);
		Assert.assertTrue(reviewerObj.approvalStatus().isDisplayed());
	}

	/*
	 * * * KUBS_Reviewer_Approve_BP_BC_05_03 *
	 */
	@Given("^Navigate the Azentio Maker Url in Maker$")
	public void navigate_the_azentio_maker_url_in_Maker() throws Throwable {
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioApp("Maker");
		Thread.sleep(2000);
	}

	@Then("^Click Transfer Icon in maker$")
	public void Click_Transfer_Icon_in_maker() throws Throwable {
		waitHelper = new WaitHelper(driver);
		javahelper.JavaScriptHelper(driver);
		waitHelper.waitForElement(driver, 5000, requestAndAllocation.budget_requestAndAllocation_DirctionIcon());
		javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_DirctionIcon());

	}

	@And("^Click on Budget module in Transfer icon$")
	public void Click_on_Budget_module_in_Transfer_icon() throws Throwable {
		javahelper.JavaScriptHelper(driver);
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetField());
		javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_BudgetField());
		// requestAndAllocation.budget_requestAndAllocation_BudgetField().click();
	}

	@Then("^Click to Budget module Budget Request and Allocation Eye Icon$")
	public void Click_to_Budget_module_Budget_Request_and_Allocation_Eye_Icon() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon());
		requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon().click();
	}

	@And("^Click to Add icon button$")
	public void Click_to_Add_icon_button() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_Addicon());
		requestAndAllocation.budget_requestAndAllocation_Addicon().click();
	}

	@Then("^Select New Budget Code in maker$")
	public void Select_New_Budget_Code_in_maker() throws Throwable {
		RequestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(RequestAndAllocationTestData.BudgetCode);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
	}

	@And("^choose Current Budget Year$")
	public void choose_Current_Budget_Year() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyear());
		dropDownHelper.SelectUsingVisibleText(requestAndAllocation.budget_requestAndAllocation_Budgetyear(),
				RequestAndAllocationTestData.BudgetYear);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
	}

	@Then("^Click to Branch$")
	public void click_to_branch() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetbranch());
		requestAndAllocation.budget_requestAndAllocation_Budgetbranch().click();
	}

	@And("^choose one Branch$")
	public void choose_one_Branch() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_type2());
		requestAndAllocation.requestAndAllocation_branch_type2().click();
	}

	@Then("^Click Branch ok$")
	public void Click_Branch_ok() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_branchOK());
		requestAndAllocation.budget_requestAndAllocation_branchOK().click();
	}

	@Then("^choose one currency$")
	public void choose_one_currency() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Amountcurruncy());
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().click();
		// requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.ENTER);
	}

	@And("^Enter Amount which Budget Type Show in type field$")
	public void Enter_Amount_which_Budget_Type_Show_in_type_field() throws Throwable {
		requestandallocationbudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgettype());
		String budgettype = requestAndAllocation.budget_requestAndAllocation_Budgettype().getText();
		requestandallocationbudtype = jsonReader.getBudtypeByName(budgettype);
		javahelper.JavaScriptHelper(driver);
		if (budgettype.equalsIgnoreCase("YEARLY")) {
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JavaScriptHelper(driver);
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyearly());
			requestAndAllocation.budget_requestAndAllocation_Budgetyearly()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetremark()
					.sendKeys(RequestAndAllocationTestData.Remark);
		} else if (budgettype.equalsIgnoreCase("MONTHLY")) {

			javahelper.JavaScriptHelper(driver);
			javahelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth12()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark12()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth11());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth11()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark11()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth10());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth10()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark10()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth9());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth9()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark9()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth8());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth8()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark8()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth7());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth7()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7()
					.sendKeys(RequestAndAllocationTestData.Remark);
			// javahelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7());

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth6());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth6()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark6()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth5());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth5()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark5()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth4());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth4()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark4()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth3());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth3()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark3()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth2());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth2()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark2()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth1());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth1()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark1()
					.sendKeys(RequestAndAllocationTestData.Remark);

		} else if (budgettype.equalsIgnoreCase("QUARTERLY")) {
			javahelper.JavaScriptHelper(driver);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark3()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark2()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly1());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly1()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark1()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly0());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly0()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark0()
					.sendKeys(RequestAndAllocationTestData.Remark);

		} else if (budgettype.equalsIgnoreCase("HALFYEARLY")) {
			javahelper.JavaScriptHelper(driver);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			// javahelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy1());
			requestAndAllocation.budget_requestAndAllocation_BudgetHy1()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHyremark1());
			requestAndAllocation.budget_requestAndAllocation_BudgetHyremark1()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy2());
			requestAndAllocation.budget_requestAndAllocation_BudgetHy2()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetHyremark2()
					.sendKeys(RequestAndAllocationTestData.Remark);

		}

	}

	@And("^save the record in Budget allocation$")
	public void save_the_record_in_Budget_allocation() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_AllowSave());
		requestAndAllocation.budget_requestAndAllocation_AllowSave().click();
	}

	@Then("^Click Maker Notify Action button in budget allocation$")
	public void Click_maker_notify_Action_button_in_budget_allocation() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.makerNotificationIcon());
		requestAndAllocation.makerNotificationIcon().click();
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.maker_Referance_id());
		String Referance_id = requestAndAllocation.maker_Referance_id().getText();
		json.addReferanceData(Referance_id);
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.maker_Action_icon());
		requestAndAllocation.maker_Action_icon().click();
	}

	@And("^Record submit in Budget allocation$")
	public void Record_submit_in_Budget_allocation() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetSubmit());
		requestAndAllocation.budget_requestAndAllocation_BudgetSubmit().click();
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_Alertremark());
		requestAndAllocation.requestAndAllocation_Alertremark().sendKeys(RequestAndAllocationTestData.Remark);
		waitHelper.waitForElement(driver, 5000, requestAndAllocation.requestAndAllocation_Alertsubmit());
		requestAndAllocation.requestAndAllocation_Alertsubmit().click();
		waitHelper.waitForElement(driver, 10000, requestAndAllocation.requestAndAllocation_reviewer_id());
		reviwerId = requestAndAllocation.requestAndAllocation_reviewer_id().getText();
		String trimmdReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmdReviewerID);
		StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
		String filanReviewerID = bufferedString.toString();
		// json.addReferanceData(reviwerId =
		// requestAndAllocation.requestAndAllocation_reviewer_id().getText());
		json.addData(filanReviewerID);
		System.out.println(reviwerId);

	}

	// REVIEWER - APPROVER

	@Given("^Azentio Url login as Reviewer for Approver$")
	public void Azentio_Url_login_as_Reviewer_for_Approver() throws Throwable {
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.logintoAzentioappReviewer("Reviewer", json.readdata());
	}

	@Then("^Click to Notification icon$")
	public void Click_to_Notification_icon() throws Throwable {
		reviewerObj = new KUBS_ReviewerObj(driver);
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewerNotidicationIcon());
		reviewerObj.reviewerNotidicationIcon().click();
	}

	@And("^Click to Reviewer Action button$")
	public void Click_to_Reviewer_Action_button() throws Throwable {
		javahelper.JavaScriptHelper(driver);
		// span[contains(text(),'336')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//div//ion-buttons//ion-button
		String befr_xpath = "//span[contains(text(),'";
		String aftr_xpath = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//div//ion-buttons//ion-button";
		waitHelper.waitForElement(driver, 2000,
				driver.findElement(By.xpath(befr_xpath + json.readReferancedata() + aftr_xpath)));
		driver.findElement(By.xpath(befr_xpath + json.readReferancedata() + aftr_xpath)).click();

		reviewerObj.reviewer_action_button().click();

	}

	@Then("^Click Approve button in Reviewer$")
	public void Click_Approve_button_in_Reviewer() throws Throwable {
		json.addReferanceData(referance_id);
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewerApproveButton());
		reviewerObj.reviewerApproveButton().click();
	}

	@And("^Submit the reviewer Approve Record$")
	public void Submit_the_reviewer_Approve_Record() throws Throwable {
		waitHelper.waitForElement(driver, 5000, reviewerObj.reviewerAlertRemarks());
		reviewerObj.reviewerAlertRemarks().sendKeys("ok");
		waitHelper.waitForElement(driver, 5000, reviewerObj.reviewerAlertSubmitButton());
		// reviewer.reviewerAlertSubmitButton().click();
		javahelper.JSEClick(reviewerObj.reviewerAlertSubmitButton());
		waitHelper.waitForElement(driver, 3000, reviewerObj.approvalStatus());
		Assert.assertTrue(reviewerObj.approvalStatus().isDisplayed());
	}

	/*
	 * * * KUBS_Reviewer_Rejecting_BP_BC_05_04 *
	 */
	@Given("^Navigate the Azentio Maker Url and Click Finance option in Maker$")
	public void Navigate_the_Azentio_Maker_Url_and_Click_Finance_option_in_Maker() throws Throwable {
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioApp("Maker");
		Thread.sleep(2000);
	}

	@Then("^Click Transfer Icon$")
	public void click_transfer_icon() throws Throwable {
		requestAndAllocation = new BUDGET_RequestAndAllocationObj(driver);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver, 5000, requestAndAllocation.budget_requestAndAllocation_DirctionIcon());
		requestAndAllocation.budget_requestAndAllocation_DirctionIcon().click();

	}

	@And("^Click on Budget module$")
	public void click_on_budget_module() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetField());
		requestAndAllocation.budget_requestAndAllocation_BudgetField().click();
	}

	@Then("^Click on Budget module Budget Request and Allocation Near Eye Icon$")
	public void click_on_budget_module_budget_request_and_allocation_near_eye_icon() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon());
		requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon().click();
	}

	@And("^Click on Add icon button$")
	public void click_on_add_icon_button() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_Addicon());
		requestAndAllocation.budget_requestAndAllocation_Addicon().click();
	}

	@Then("^Select New Budget Code$")
	public void select_new_budget_code() throws Throwable {
		RequestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(RequestAndAllocationTestData.BudgetCode);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
	}

	@And("^Select Current Budget Year$")
	public void select_current_budget_year() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyear());
		dropDownHelper.SelectUsingVisibleText(requestAndAllocation.budget_requestAndAllocation_Budgetyear(),
				RequestAndAllocationTestData.BudgetYear);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
	}

	@Then("^Click on Branch field$")
	public void click_on_branch_field() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetbranch());
		requestAndAllocation.budget_requestAndAllocation_Budgetbranch().click();
	}

	@And("^Select on one Branch$")
	public void select_on_one_branch() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_type1());
		requestAndAllocation.requestAndAllocation_branch_type1().click();
	}

	@Then("^Click Branch ok button$")
	public void click_branch_ok_button() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_branchOK());
		requestAndAllocation.budget_requestAndAllocation_branchOK().click();
	}

	@Then("^Select currency we need$")
	public void select_currency_we_need() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Amountcurruncy());
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().click();
		// requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.ENTER);
	}

	@And("^Enter Amount which Budget Type Show in Budget type field$")
	public void enter_amount_which_budget_type_show_in_budget_type_field() throws Throwable {
		requestandallocationbudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgettype());
		String budgettype = requestAndAllocation.budget_requestAndAllocation_Budgettype().getText();
		requestandallocationbudtype = jsonReader.getBudtypeByName(budgettype);
		javahelper.JavaScriptHelper(driver);
		if (budgettype.equalsIgnoreCase("YEARLY")) {
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JavaScriptHelper(driver);
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyearly());
			requestAndAllocation.budget_requestAndAllocation_Budgetyearly()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetremark()
					.sendKeys(RequestAndAllocationTestData.Remark);
		} else if (budgettype.equalsIgnoreCase("MONTHLY")) {

			javahelper.JavaScriptHelper(driver);
			javahelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth12()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark12()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth11());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth11()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark11()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth10());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth10()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark10()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth9());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth9()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark9()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth8());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth8()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark8()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth7());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth7()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7()
					.sendKeys(RequestAndAllocationTestData.Remark);
			// javahelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7());

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth6());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth6()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark6()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth5());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth5()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark5()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth4());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth4()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark4()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth3());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth3()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark3()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth2());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth2()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark2()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth1());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth1()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark1()
					.sendKeys(RequestAndAllocationTestData.Remark);

		} else if (budgettype.equalsIgnoreCase("QUARTERLY")) {
			javahelper.JavaScriptHelper(driver);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark3()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark2()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly1());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly1()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark1()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly0());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly0()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark0()
					.sendKeys(RequestAndAllocationTestData.Remark);

		} else if (budgettype.equalsIgnoreCase("HALFYEARLY")) {
			javahelper.JavaScriptHelper(driver);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			// javahelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy1());
			requestAndAllocation.budget_requestAndAllocation_BudgetHy1()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHyremark1());
			requestAndAllocation.budget_requestAndAllocation_BudgetHyremark1()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy2());
			requestAndAllocation.budget_requestAndAllocation_BudgetHy2()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetHyremark2()
					.sendKeys(RequestAndAllocationTestData.Remark);

		}

	}

	@And("^click save button in Budget allocation$")
	public void click_save_button_in_Budget_allocation() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_AllowSave());
		requestAndAllocation.budget_requestAndAllocation_AllowSave().click();
	}

	@Then("^Click on Maker Notify Action button in budget allocation$")
	public void click_on_maker_notify_action_button_in_budget_allocation() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.makerNotificationIcon());
		requestAndAllocation.makerNotificationIcon().click();
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.maker_Referance_id());
		String Referance_id = requestAndAllocation.maker_Referance_id().getText();
		json.addReferanceData(Referance_id);
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.maker_Action_icon());
		requestAndAllocation.maker_Action_icon().click();
	}

	@And("^Click on Record submit in Budget allocation$")
	public void Click_on_Record_submit_in_Budget_allocation() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetSubmit());
		requestAndAllocation.budget_requestAndAllocation_BudgetSubmit().click();
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_Alertremark());
		requestAndAllocation.requestAndAllocation_Alertremark().sendKeys(RequestAndAllocationTestData.Remark);
		waitHelper.waitForElement(driver, 5000, requestAndAllocation.requestAndAllocation_Alertsubmit());
		requestAndAllocation.requestAndAllocation_Alertsubmit().click();
		waitHelper.waitForElement(driver, 10000, requestAndAllocation.requestAndAllocation_reviewer_id());
		reviwerId = requestAndAllocation.requestAndAllocation_reviewer_id().getText();
		String trimmdReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmdReviewerID);
		StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
		String filanReviewerID = bufferedString.toString();
		// json.addReferanceData(reviwerId =
		// requestAndAllocation.requestAndAllocation_reviewer_id().getText());
		json.addData(filanReviewerID);
		System.out.println(reviwerId);

	}

	// REVIEWER - REJECTING
	@Given("^Navigate the Azentio Url login as Reviewer for Rejection$")
	public void Navigate_the_Azentio_Url_login_as_Reviewer_for_Rejection() throws Throwable {
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.logintoAzentioappReviewer("Reviewer", json.readdata());
	}

	@Then("^Click Notification icon$")
	public void click_notification_icon() throws Throwable {
		reviewerObj = new KUBS_ReviewerObj(driver);
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewerNotidicationIcon());
		reviewerObj.reviewerNotidicationIcon().click();
	}

	@And("^Click Reviewer Action button$")
	public void click_Reviewer_action_button() throws Throwable {
		javahelper.JavaScriptHelper(driver);
		// span[contains(text(),'336')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//div//ion-buttons//ion-button
		String befr_xpath = "//span[contains(text(),'";
		String aftr_xpath = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//div//ion-buttons//ion-button";
		waitHelper.waitForElement(driver, 2000,
				driver.findElement(By.xpath(befr_xpath + json.readReferancedata() + aftr_xpath)));
		driver.findElement(By.xpath(befr_xpath + json.readReferancedata() + aftr_xpath)).click();

		reviewerObj.reviewer_action_button().click();

	}

	@Then("^Click on Reject button in Reviewer$")
	public void click_on_Reject_button_in_Reviewer() throws Throwable {
		// reader.addReferanceData(referance_id);
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewerRejectButton());
		reviewerObj.reviewerRejectButton().click();
	}

	@And("^Submit the reviewer Rejecting Record$")
	public void Submit_the_reviewer_Rejecting_Record() throws Throwable {
		waitHelper.waitForElement(driver, 5000, reviewerObj.reviewerAlertRemarks());
		reviewerObj.reviewerAlertRemarks().sendKeys("ok");
		waitHelper.waitForElement(driver, 5000, reviewerObj.reviewerAlertSubmitButton());
		// reviewer.reviewerAlertSubmitButton().click();
		javahelper.JSEClick(reviewerObj.reviewerAlertSubmitButton());
		waitHelper.waitForElement(driver, 3000, reviewerObj.approvalStatus());
		Assert.assertTrue(reviewerObj.approvalStatus().isDisplayed());
	}

	/*
	 * 
	 * KUBS_Checker_Approve_Notification_BP_BC_05_05
	 *
	 */
	@Given("^Navigate to Azentio Url")
	public void Navigate_to_Azentio_Url() throws Throwable {
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioApp("Maker");
		Thread.sleep(2000);
	}

	@Then("^Transfer button Icon$")
	public void Transfer_button_Icon() throws Throwable {
		requestAndAllocation = new BUDGET_RequestAndAllocationObj(driver);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver, 5000, requestAndAllocation.budget_requestAndAllocation_DirctionIcon());
		requestAndAllocation.budget_requestAndAllocation_DirctionIcon().click();

	}

	@And("^Budget module Drpdwn$")
	public void Budget_module_Drpdwn() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetField());
		requestAndAllocation.budget_requestAndAllocation_BudgetField().click();
	}

	@Then("^Budget module Eye Icon$")
	public void Budget_module_Eye_Icon() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon());
		requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon().click();
	}

	@And("^Add icon$")
	public void Add_icon() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_Addicon());
		requestAndAllocation.budget_requestAndAllocation_Addicon().click();
	}

	@Then("^current Budget Code$")
	public void current_Budget_Code() throws Throwable {
		RequestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(RequestAndAllocationTestData.BudgetCode);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
	}

	@And("^current Budget Year$")
	public void current_Budget_Year() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyear());
		dropDownHelper.SelectUsingVisibleText(requestAndAllocation.budget_requestAndAllocation_Budgetyear(),
				RequestAndAllocationTestData.BudgetYear);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
	}

	@Then("^Branch field$")
	public void Branch_field() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetbranch());
		requestAndAllocation.budget_requestAndAllocation_Budgetbranch().click();
	}

	@And("^Choose one branch in field$")
	public void Choose_one_branch_in_field() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_type1());
		requestAndAllocation.requestAndAllocation_branch_type1().click();
	}

	@Then("^Branch ok button in pop up$")
	public void Branch_ok_button_in_pop_up() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_branchOK());
		requestAndAllocation.budget_requestAndAllocation_branchOK().click();
	}

	@Then("^Choose currency type$")
	public void Choose_currency_type() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Amountcurruncy());
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().click();
		// requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.ENTER);
	}

	@And("^Enter Amount for Budget Type$")
	public void Enter_Amount_for_Budget_Type() throws Throwable {
		requestandallocationbudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgettype());
		String budgettype = requestAndAllocation.budget_requestAndAllocation_Budgettype().getText();
		requestandallocationbudtype = jsonReader.getBudtypeByName(budgettype);
		javahelper.JavaScriptHelper(driver);
		if (budgettype.equalsIgnoreCase("YEARLY")) {
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JavaScriptHelper(driver);
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyearly());
			requestAndAllocation.budget_requestAndAllocation_Budgetyearly()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetremark()
					.sendKeys(RequestAndAllocationTestData.Remark);
		} else if (budgettype.equalsIgnoreCase("MONTHLY")) {

			javahelper.JavaScriptHelper(driver);
			javahelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth12()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark12()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth11());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth11()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark11()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth10());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth10()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark10()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth9());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth9()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark9()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth8());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth8()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark8()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth7());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth7()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7()
					.sendKeys(RequestAndAllocationTestData.Remark);
			// javahelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7());

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth6());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth6()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark6()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth5());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth5()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark5()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth4());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth4()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark4()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth3());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth3()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark3()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth2());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth2()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark2()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth1());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth1()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark1()
					.sendKeys(RequestAndAllocationTestData.Remark);

		} else if (budgettype.equalsIgnoreCase("QUARTERLY")) {
			javahelper.JavaScriptHelper(driver);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark3()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark2()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly1());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly1()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark1()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly0());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly0()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark0()
					.sendKeys(RequestAndAllocationTestData.Remark);

		} else if (budgettype.equalsIgnoreCase("HALFYEARLY")) {
			javahelper.JavaScriptHelper(driver);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			// javahelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy1());
			requestAndAllocation.budget_requestAndAllocation_BudgetHy1()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHyremark1());
			requestAndAllocation.budget_requestAndAllocation_BudgetHyremark1()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy2());
			requestAndAllocation.budget_requestAndAllocation_BudgetHy2()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetHyremark2()
					.sendKeys(RequestAndAllocationTestData.Remark);

		}

	}

	@And("^save Record$")
	public void save_Record() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_AllowSave());
		requestAndAllocation.budget_requestAndAllocation_AllowSave().click();
	}

	@Then("^Notification Action icon button$")
	public void notification_Action_icon_button() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.makerNotificationIcon());
		requestAndAllocation.makerNotificationIcon().click();
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.maker_Referance_id());
		String Referance_id = requestAndAllocation.maker_Referance_id().getText();
		json.addReferanceData(Referance_id);
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.maker_Action_icon());
		requestAndAllocation.maker_Action_icon().click();
	}

	@And("^Record submit icon$")
	public void Record_submit_icon() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetSubmit());
		requestAndAllocation.budget_requestAndAllocation_BudgetSubmit().click();
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_Alertremark());
		requestAndAllocation.requestAndAllocation_Alertremark().sendKeys(RequestAndAllocationTestData.Remark);
		waitHelper.waitForElement(driver, 5000, requestAndAllocation.requestAndAllocation_Alertsubmit());
		requestAndAllocation.requestAndAllocation_Alertsubmit().click();
		waitHelper.waitForElement(driver, 10000, requestAndAllocation.requestAndAllocation_reviewer_id());
		reviwerId = requestAndAllocation.requestAndAllocation_reviewer_id().getText();
		String trimmdReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmdReviewerID);
		StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
		String filanReviewerID = bufferedString.toString();
		// json.addReferanceData(reviwerId =
		// requestAndAllocation.requestAndAllocation_reviewer_id().getText());
		json.addData(filanReviewerID);
		System.out.println(reviwerId);

	}

	// Reviewer
	@Given("^login as Reviewer$")
	public void login_as_Reviewer() throws Throwable {
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.logintoAzentioappReviewer("Reviewer", json.readdata());
	}

	@Then("^Reviewer Notification icon$")
	public void Reviewer_Notification_icon() throws Throwable {
		reviewerObj = new KUBS_ReviewerObj(driver);
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewerNotidicationIcon());
		reviewerObj.reviewerNotidicationIcon().click();
	}

	@And("^Reviewer Action button icon$")
	public void Reviewer_Action_button_icon() throws Throwable {
		javahelper.JavaScriptHelper(driver);
		// span[contains(text(),'336')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//div//ion-buttons//ion-button
		String befr_xpath = "//span[contains(text(),'";
		String aftr_xpath = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//div//ion-buttons//ion-button";
		waitHelper.waitForElement(driver, 2000,
				driver.findElement(By.xpath(befr_xpath + json.readReferancedata() + aftr_xpath)));
		driver.findElement(By.xpath(befr_xpath + json.readReferancedata() + aftr_xpath)).click();

		reviewerObj.reviewer_action_button().click();
	}

	@Then("^Approve button in Reviewer stage$")
	public void Approve_button_in_Reviewer_stage() throws Throwable {
		// json.addReferanceData(referance_id);
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewerApproveButton());
		reviewerObj.reviewerApproveButton().click();
	}

	@And("^Submit Record$")
	public void Submit_Record() throws Throwable {
		waitHelper.waitForElement(driver, 5000, reviewerObj.reviewerAlertRemarks());
		reviewerObj.reviewerAlertRemarks().sendKeys("ok");
		waitHelper.waitForElement(driver, 5000, reviewerObj.reviewerAlertSubmitButton());
		// reviewer.reviewerAlertSubmitButton().click();
		javahelper.JSEClick(reviewerObj.reviewerAlertSubmitButton());
		waitHelper.waitForElement(driver, 3000, reviewerObj.approvalStatus());
		Assert.assertTrue(reviewerObj.approvalStatus().isDisplayed());
	}

	// CHECKER - REJECTING
	@Given("^login as checker$")
	public void Azentio_login_as_checker() throws Throwable {
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioAppAsChecker("Checker");
	}

	@Then("^security management$")
	public void security_management() throws Throwable {
		waitHelper.waitForElement(driver, 3000, kubschecker.checkerSecurityManagement());
		kubschecker.checkerSecurityManagement().click();
	}

	@And("^sub module open pool near Edit icon$")
	public void sub_module_open_pool_near_Edit_icon() throws Throwable {
		waitHelper.waitForElement(driver, 3000, kubschecker.checkerActionIcon());
		kubschecker.checkerActionIcon().click();
	}

	@Then("^the claim option button$")
	public void the_claim_option_button() throws Throwable {
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		waitHelper.waitForElement(driver, 10000,
				driver.findElement(By.xpath(before_xpath + json.readReferancedata() + after_xpath_claim)));
		driver.findElement(By.xpath(before_xpath + json.readReferancedata() + after_xpath_claim)).click();
		waitHelper.waitForElement(driver, 2000, kubschecker.checker_alert_close());
		kubschecker.checker_alert_close().click();
	}

	@And("^Onclick the checker notification icon in checker$")
	public void onclick_the_checker_notification_icon_in_checker() throws Throwable {
		javahelper = new JavascriptHelper();
		waitHelper.waitForElement(driver, 3000, kubschecker.checkerNotificationIcon());
		javahelper.JavaScriptHelper(driver);
		javahelper.JSEClick(kubschecker.checkerNotificationIcon());

	}

	@Then("^Capture the Notification is displayed$")
	public void capture_the_notification_is_displayed() throws Throwable {
		waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"
				+ json.readReferancedata()
				+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(By.xpath("//span[contains(text(),'" + json.readReferancedata()
				+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"))
				.click();
		System.out.println("The Referance ID: " + json.readReferancedata());
		waitHelper.waitForElement(driver, 2000, kubschecker.checkerApproveButton());
		kubschecker.checkerApproveButton().click();
		waitHelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
		kubschecker.checkerRemarks().sendKeys("ok");
		waitHelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();
		waitHelper.waitForElement(driver, 3000, kubschecker.Popup_status());
		String Notification = kubschecker.Popup_status().getText();
		System.out.println("System Should Display Notification: " + Notification);
	}

	/*
	 * 
	 * KUBS_Checker_Approve_BP_BC_05_06
	 * 
	 */

	@Given("^Navigate to Azentio Url and Click Finance option$")
	public void Navigate_to_Azentio_Url_and_Click_Finance_option() throws Throwable {
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioApp("Maker");
		Thread.sleep(2000);
	}

	@Then("^Click Transfer button Icon$")
	public void Click_Transfer_button_Icon() throws Throwable {
		requestAndAllocation = new BUDGET_RequestAndAllocationObj(driver);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver, 5000, requestAndAllocation.budget_requestAndAllocation_DirctionIcon());
		requestAndAllocation.budget_requestAndAllocation_DirctionIcon().click();

	}

	@And("^Click Budget module Drpdwn$")
	public void Click_Budget_module_Drpdwn() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetField());
		requestAndAllocation.budget_requestAndAllocation_BudgetField().click();
	}

	@Then("^Click on Budget module Eye Icon$")
	public void Click_on_Budget_module_Eye_Icon() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon());
		requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon().click();
	}

	@And("^Click on Add icon$")
	public void Click_on_Add_icon() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_Addicon());
		requestAndAllocation.budget_requestAndAllocation_Addicon().click();
	}

	@Then("^Choose current Budget Code$")
	public void Choose_current_Budget_Code() throws Throwable {
		RequestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(RequestAndAllocationTestData.BudgetCode);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
	}

	@And("^Choose current Budget Year$")
	public void Choose_current_Budget_Year() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyear());
		dropDownHelper.SelectUsingVisibleText(requestAndAllocation.budget_requestAndAllocation_Budgetyear(),
				RequestAndAllocationTestData.BudgetYear);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
	}

	@Then("^Choose on Branch field$")
	public void Choose_on_Branch_field() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetbranch());
		requestAndAllocation.budget_requestAndAllocation_Budgetbranch().click();
	}

	@And("^Choose one Branch in branch field$")
	public void Choose_one_Branch_in_branch_field() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_type1());
		requestAndAllocation.requestAndAllocation_branch_type1().click();
	}

	@Then("^Click Branch ok button in pop up$")
	public void Click_Branch_ok_button_in_pop_up() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_branchOK());
		requestAndAllocation.budget_requestAndAllocation_branchOK().click();
	}

	@Then("^Choose Need currency$")
	public void Choose_Need_currency() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Amountcurruncy());
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().click();
		// requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.ENTER);
	}

	@And("^Enter Amount for Budget Type Show in Budget type$")
	public void Enter_Amount_for_Budget_Type_Show_in_Budget_type() throws Throwable {
		requestandallocationbudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgettype());
		String budgettype = requestAndAllocation.budget_requestAndAllocation_Budgettype().getText();
		requestandallocationbudtype = jsonReader.getBudtypeByName(budgettype);
		javahelper.JavaScriptHelper(driver);
		if (budgettype.equalsIgnoreCase("YEARLY")) {
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JavaScriptHelper(driver);
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyearly());
			requestAndAllocation.budget_requestAndAllocation_Budgetyearly()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetremark()
					.sendKeys(RequestAndAllocationTestData.Remark);
		} else if (budgettype.equalsIgnoreCase("MONTHLY")) {

			javahelper.JavaScriptHelper(driver);
			javahelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth12()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark12()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth11());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth11()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark11()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth10());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth10()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark10()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth9());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth9()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark9()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth8());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth8()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark8()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth7());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth7()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7()
					.sendKeys(RequestAndAllocationTestData.Remark);
			// javahelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7());

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth6());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth6()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark6()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth5());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth5()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark5()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth4());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth4()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark4()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth3());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth3()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark3()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth2());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth2()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark2()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth1());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth1()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark1()
					.sendKeys(RequestAndAllocationTestData.Remark);

		} else if (budgettype.equalsIgnoreCase("QUARTERLY")) {
			javahelper.JavaScriptHelper(driver);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark3()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark2()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly1());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly1()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark1()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly0());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly0()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark0()
					.sendKeys(RequestAndAllocationTestData.Remark);

		} else if (budgettype.equalsIgnoreCase("HALFYEARLY")) {
			javahelper.JavaScriptHelper(driver);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			// javahelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy1());
			requestAndAllocation.budget_requestAndAllocation_BudgetHy1()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHyremark1());
			requestAndAllocation.budget_requestAndAllocation_BudgetHyremark1()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy2());
			requestAndAllocation.budget_requestAndAllocation_BudgetHy2()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetHyremark2()
					.sendKeys(RequestAndAllocationTestData.Remark);

		}

	}

	@And("^click on save$")
	public void click_on_save() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_AllowSave());
		requestAndAllocation.budget_requestAndAllocation_AllowSave().click();
	}

	@Then("^Click Notify Action icon button$")
	public void Click_Notify_Action_icon_button() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.makerNotificationIcon());
		requestAndAllocation.makerNotificationIcon().click();
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.maker_Referance_id());
		String Referance_id = requestAndAllocation.maker_Referance_id().getText();
		json.addReferanceData(Referance_id);
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.maker_Action_icon());
		requestAndAllocation.maker_Action_icon().click();
	}

	@And("^Click Record submit icon$")
	public void Click_Record_submit_icon() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetSubmit());
		requestAndAllocation.budget_requestAndAllocation_BudgetSubmit().click();
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_Alertremark());
		requestAndAllocation.requestAndAllocation_Alertremark().sendKeys(RequestAndAllocationTestData.Remark);
		waitHelper.waitForElement(driver, 5000, requestAndAllocation.requestAndAllocation_Alertsubmit());
		requestAndAllocation.requestAndAllocation_Alertsubmit().click();
		waitHelper.waitForElement(driver, 10000, requestAndAllocation.requestAndAllocation_reviewer_id());
		reviwerId = requestAndAllocation.requestAndAllocation_reviewer_id().getText();
		String trimmdReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmdReviewerID);
		StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
		String filanReviewerID = bufferedString.toString();
		// json.addReferanceData(reviwerId =
		// requestAndAllocation.requestAndAllocation_reviewer_id().getText());
		json.addData(filanReviewerID);
		System.out.println(reviwerId);

	}

	// Reviewer
	@Given("^Azentio login as Reviewer$")
	public void Azentio_login_as_Reviewer() throws Throwable {
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.logintoAzentioappReviewer("Reviewer", json.readdata());
	}

	@Then("^Click Reviewer Notification icon$")
	public void Click_Reviewer_Notification_icon() throws Throwable {
		reviewerObj = new KUBS_ReviewerObj(driver);
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewerNotidicationIcon());
		reviewerObj.reviewerNotidicationIcon().click();
	}

	@And("^Click Reviewer Action button icon$")
	public void Click_Reviewer_Action_button_icon() throws Throwable {
		javahelper.JavaScriptHelper(driver);
		// span[contains(text(),'336')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//div//ion-buttons//ion-button
		String befr_xpath = "//span[contains(text(),'";
		String aftr_xpath = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//div//ion-buttons//ion-button";
		waitHelper.waitForElement(driver, 2000,
				driver.findElement(By.xpath(befr_xpath + json.readReferancedata() + aftr_xpath)));
		driver.findElement(By.xpath(befr_xpath + json.readReferancedata() + aftr_xpath)).click();

		reviewerObj.reviewer_action_button().click();
	}

	@Then("^Click Approve button in Reviewer stage$")
	public void Click_Approve_button_in_Reviewer_stage() throws Throwable {
		// json.addReferanceData(referance_id);
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewerApproveButton());
		reviewerObj.reviewerApproveButton().click();
	}

	@And("^Submit reviewer Records$")
	public void Submit_reviewer_Records() throws Throwable {
		waitHelper.waitForElement(driver, 5000, reviewerObj.reviewerAlertRemarks());
		reviewerObj.reviewerAlertRemarks().sendKeys("ok");
		waitHelper.waitForElement(driver, 5000, reviewerObj.reviewerAlertSubmitButton());
		// reviewer.reviewerAlertSubmitButton().click();
		javahelper.JSEClick(reviewerObj.reviewerAlertSubmitButton());
		waitHelper.waitForElement(driver, 3000, reviewerObj.approvalStatus());
		Assert.assertTrue(reviewerObj.approvalStatus().isDisplayed());
	}

	// CHECKER - REJECTING
	@Given("^Azentio login as checker$")
	public void azentio_login_as_checker() throws Throwable {
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioAppAsChecker("Checker");
	}

	@Then("^click to security management$")
	public void click_to_security_management() throws Throwable {
		waitHelper.waitForElement(driver, 3000, kubschecker.checkerSecurityManagement());
		kubschecker.checkerSecurityManagement().click();
	}

	@And("^Click to sub module open pool near Edit icon$")
	public void Click_to_sub_module_open_pool_near_Edit_icon() throws Throwable {
		waitHelper.waitForElement(driver, 3000, kubschecker.checkerActionIcon());
		kubschecker.checkerActionIcon().click();
	}

	@Then("^Click to the claim option button$")
	public void Click_to_the_claim_option_button() throws Throwable {
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		waitHelper.waitForElement(driver, 10000,
				driver.findElement(By.xpath(before_xpath + json.readReferancedata() + after_xpath_claim)));
		driver.findElement(By.xpath(before_xpath + json.readReferancedata() + after_xpath_claim)).click();
		waitHelper.waitForElement(driver, 2000, kubschecker.checker_alert_close());
		kubschecker.checker_alert_close().click();
	}

	@And("^Click on the checker notification icon in checker$")
	public void Click_on_the_checker_notification_icon_in_checker() throws Throwable {
		javahelper = new JavascriptHelper();
		waitHelper.waitForElement(driver, 3000, kubschecker.checkerNotificationIcon());
		javahelper.JavaScriptHelper(driver);
		javahelper.JSEClick(kubschecker.checkerNotificationIcon());
	}

	@Then("^click to checker action icon button$")
	public void click_to_checker_action_icon_button() throws Throwable {
		waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"
				+ json.readReferancedata()
				+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(By.xpath("//span[contains(text(),'" + json.readReferancedata()
				+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"))
				.click();
	}

	@And("^Checker Approve the Record$")
	public void Checker_Approve_the_Record() throws Throwable {
		waitHelper.waitForElement(driver, 2000, kubschecker.checkerApproveButton());
		kubschecker.checkerApproveButton().click();
	}

	@Then("^Submit the Approve Record in checker$")
	public void Submit_the_Approve_Record_in_checker() throws Throwable {
		waitHelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
		kubschecker.checkerRemarks().sendKeys("ok");
		waitHelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();
		waitHelper.waitForElement(driver, 3000, kubschecker.Popup_status());
		Assert.assertTrue(kubschecker.Popup_status().isDisplayed());
	}

	/*
	 *
	 * KUBS_Checker_Rejecting_BP_BC_05_07
	 *
	 */
	@Given("^Navigate the Azentio Url and Click Finance option$")
	public void navigate_the_azentio_url_and_click_finance_option() throws Throwable {
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioApp("Maker");
		Thread.sleep(2000);
	}

	@Then("^Click Transfer button$")
	public void click_transfer_button() throws Throwable {
		requestAndAllocation = new BUDGET_RequestAndAllocationObj(driver);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver, 5000, requestAndAllocation.budget_requestAndAllocation_DirctionIcon());
		requestAndAllocation.budget_requestAndAllocation_DirctionIcon().click();
	}

	@And("^Click Budget module$")
	public void clickBudgetModule() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetField());
		requestAndAllocation.budget_requestAndAllocation_BudgetField().click();
	}

	@Then("^Click on Budget module Budget Request and Allocation Eye Icon$")
	public void clickOnBudgetModuleBudgetRequestAndAllocationEyeIcon() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon());
		requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon().click();
	}

	@And("^Click on Add icon Request and Allocation$")
	public void clickOnAddIconRequestAndAllocation() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_Addicon());
		requestAndAllocation.budget_requestAndAllocation_Addicon().click();
	}

	@Then("^Select current Budget Code$")
	public void selectCurrentBudgetCode() throws Throwable {
		RequestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(RequestAndAllocationTestData.BudgetCode);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
	}

	@And("^Select current Budget Year$")
	public void selectCurrentBudgetYear() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyear());
		dropDownHelper.SelectUsingVisibleText(requestAndAllocation.budget_requestAndAllocation_Budgetyear(),
				RequestAndAllocationTestData.BudgetYear);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
	}

	@Then("^Click on Branch fields$")
	public void clickOnBranchFields() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetbranch());
		requestAndAllocation.budget_requestAndAllocation_Budgetbranch().click();
	}

	@And("^Select one Branch in branch field$")
	public void selectOneBranchInBranchField() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_type1());
		requestAndAllocation.requestAndAllocation_branch_type1().click();
	}

	@Then("^Click on Branch ok button in pop up$")
	public void clickOnBranchOkButtonInPopUp() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_branchOK());
		requestAndAllocation.budget_requestAndAllocation_branchOK().click();
	}

	@Then("^Select Need currency$")
	public void selectNeedCurrency() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Amountcurruncy());
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().click();
		// requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.ENTER);
	}

	@And("^Enter Amount for which Budget Type Show in Budget type$")
	public void enterAmountForWhichBudgetTypeShowInBudgetType() throws Throwable {
		requestandallocationbudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgettype());
		String budgettype = requestAndAllocation.budget_requestAndAllocation_Budgettype().getText();
		requestandallocationbudtype = jsonReader.getBudtypeByName(budgettype);
		javahelper.JavaScriptHelper(driver);
		if (budgettype.equalsIgnoreCase("YEARLY")) {
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JavaScriptHelper(driver);
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyearly());
			requestAndAllocation.budget_requestAndAllocation_Budgetyearly()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetremark()
					.sendKeys(RequestAndAllocationTestData.Remark);
		} else if (budgettype.equalsIgnoreCase("MONTHLY")) {

			javahelper.JavaScriptHelper(driver);
			javahelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth12()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark12()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth11());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth11()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark11()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth10());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth10()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark10()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth9());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth9()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark9()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth8());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth8()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark8()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth7());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth7()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7()
					.sendKeys(RequestAndAllocationTestData.Remark);
			// javahelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7());

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth6());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth6()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark6()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth5());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth5()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark5()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth4());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth4()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark4()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth3());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth3()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark3()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth2());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth2()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark2()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth1());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth1()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark1()
					.sendKeys(RequestAndAllocationTestData.Remark);

		} else if (budgettype.equalsIgnoreCase("QUARTERLY")) {
			javahelper.JavaScriptHelper(driver);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark3()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark2()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly1());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly1()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark1()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly0());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly0()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark0()
					.sendKeys(RequestAndAllocationTestData.Remark);

		} else if (budgettype.equalsIgnoreCase("HALFYEARLY")) {
			javahelper.JavaScriptHelper(driver);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			// javahelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy1());
			requestAndAllocation.budget_requestAndAllocation_BudgetHy1()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHyremark1());
			requestAndAllocation.budget_requestAndAllocation_BudgetHyremark1()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy2());
			requestAndAllocation.budget_requestAndAllocation_BudgetHy2()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetHyremark2()
					.sendKeys(RequestAndAllocationTestData.Remark);

		}

	}

	@And("^click on save icon$")
	public void clickOnSaveIcon() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_AllowSave());
		requestAndAllocation.budget_requestAndAllocation_AllowSave().click();
	}

	@Then("^Click on notify Action icon button$")
	public void clickOnnotifyActionIconButton() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.makerNotificationIcon());
		requestAndAllocation.makerNotificationIcon().click();
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.maker_Referance_id());
		String Referance_id = requestAndAllocation.maker_Referance_id().getText();
		json.addReferanceData(Referance_id);
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.maker_Action_icon());
		requestAndAllocation.maker_Action_icon().click();
	}

	@And("^Click on Record submit icon$")
	public void clickOnRecordSubmitIcon() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetSubmit());
		requestAndAllocation.budget_requestAndAllocation_BudgetSubmit().click();
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_Alertremark());
		requestAndAllocation.requestAndAllocation_Alertremark().sendKeys(RequestAndAllocationTestData.Remark);
		waitHelper.waitForElement(driver, 5000, requestAndAllocation.requestAndAllocation_Alertsubmit());
		requestAndAllocation.requestAndAllocation_Alertsubmit().click();
		waitHelper.waitForElement(driver, 10000, requestAndAllocation.requestAndAllocation_reviewer_id());
		reviwerId = requestAndAllocation.requestAndAllocation_reviewer_id().getText();
		String trimmdReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmdReviewerID);
		StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
		String filanReviewerID = bufferedString.toString();
		// json.addReferanceData(reviwerId =
		// requestAndAllocation.requestAndAllocation_reviewer_id().getText());
		json.addData(filanReviewerID);
		System.out.println(reviwerId);
	}

	// Reviewer
	@Given("^Azentio Url login as Reviewer$")
	public void azentioUrlLoginAsReviewer() throws Throwable {
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.logintoAzentioappReviewer("Reviewer", json.readdata());
	}

	@Then("^Click reviewer Notification icon$")
	public void clickReviewerNotificationIcon() throws Throwable {
		reviewerObj = new KUBS_ReviewerObj(driver);
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewerNotidicationIcon());
		reviewerObj.reviewerNotidicationIcon().click();
	}

	@And("^Click on Reviewer Action button icon$")
	public void clickOnReviewerActionButtonIcon() throws Throwable {
		javahelper.JavaScriptHelper(driver);
		// span[contains(text(),'336')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//div//ion-buttons//ion-button
		String befr_xpath = "//span[contains(text(),'";
		String aftr_xpath = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//div//ion-buttons//ion-button";
		waitHelper.waitForElement(driver, 2000,
				driver.findElement(By.xpath(befr_xpath + json.readReferancedata() + aftr_xpath)));
		driver.findElement(By.xpath(befr_xpath + json.readReferancedata() + aftr_xpath)).click();

		reviewerObj.reviewer_action_button().click();
	}

	@Then("^Click on Approve button in Reviewer stage$")
	public void clickOnApproveButtonInReviewerStage() throws Throwable {
		// reader.addReferanceData(referance_id);
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewerApproveButton());
		reviewerObj.reviewerApproveButton().click();
	}

	@And("^Submit the reviewer Records$")
	public void submitTheReviewerRecords() throws Throwable {
		waitHelper.waitForElement(driver, 5000, reviewerObj.reviewerAlertRemarks());
		reviewerObj.reviewerAlertRemarks().sendKeys("ok");
		waitHelper.waitForElement(driver, 5000, reviewerObj.reviewerAlertSubmitButton());
		// reviewer.reviewerAlertSubmitButton().click();
		javahelper.JSEClick(reviewerObj.reviewerAlertSubmitButton());
		waitHelper.waitForElement(driver, 3000, reviewerObj.approvalStatus());
		Assert.assertTrue(reviewerObj.approvalStatus().isDisplayed());
	}

	// CHECKER - REJECTING
	@Given("^Azentio Url login as checker$")
	public void azentioUrlLoginAsChecker() throws Throwable {
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioAppAsChecker("Checker");
	}

	@Then("^click security management$")
	public void clickSecurityManagement() throws Throwable {
		waitHelper.waitForElement(driver, 3000, kubschecker.checkerSecurityManagement());
		kubschecker.checkerSecurityManagement().click();
	}

	@And("^Click sub module open pool near Edit icon$")
	public void clickSubModuleOpenPoolNearEditIcon() throws Throwable {
		waitHelper.waitForElement(driver, 3000, kubschecker.checkerActionIcon());
		kubschecker.checkerActionIcon().click();
	}

	@Then("^Click the claim option button$")
	public void clickTheClaimOptionButton() throws Throwable {
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		waitHelper.waitForElement(driver, 10000,
				driver.findElement(By.xpath(before_xpath + json.readReferancedata() + after_xpath_claim)));
		driver.findElement(By.xpath(before_xpath + json.readReferancedata() + after_xpath_claim)).click();
		waitHelper.waitForElement(driver, 2000, kubschecker.checker_alert_close());
		kubschecker.checker_alert_close().click();
	}

	@And("^Click on checker notification icon in checker$")
	public void clickOnCheckerNotificationIconInChecker() throws Throwable {
		javahelper = new JavascriptHelper();
		waitHelper.waitForElement(driver, 3000, kubschecker.checkerNotificationIcon());
		javahelper.JavaScriptHelper(driver);
		javahelper.JSEClick(kubschecker.checkerNotificationIcon());
	}

	@Then("^click checker action icon button$")
	public void clickCheckerActionIconButton() throws Throwable {
		waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"
				+ json.readReferancedata()
				+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(By.xpath("//span[contains(text(),'" + json.readReferancedata()
				+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"))
				.click();
	}

	@And("^Checker Reject the Record$")
	public void checkerRejectTheRecord() throws Throwable {
		waitHelper.waitForElement(driver, 2000, kubschecker.checkerRejectButton());
		kubschecker.checkerRejectButton().click();
	}

	@Then("^Submit the Reject Record in checker$")
	public void submitTheRejectRecordInChecker() throws Throwable {
		waitHelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
		kubschecker.checkerRemarks().sendKeys("ok");
		// waitHelper.waitForElement(driver, 10000, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();
		waitHelper.waitForElementVisible(kubschecker.Popup_status(), 2000, 2000);
		String Notification = kubschecker.Popup_status().getText();
		System.out.println("Notification is: " + Notification);
		Assert.assertTrue(kubschecker.Popup_status().isDisplayed());
	}

	/*
	 *
	 * KUBS_Authorizationstatus_BP_BC_05_08
	 *
	 */
	@Given("^Launch to Azentio maker Url$")
	public void launch_to_azentio_maker_url() throws Throwable {
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioApp("Maker");
		Thread.sleep(2000);
	}

	@Then("^Transfer icon click$")
	public void transfer_icon_click() throws Throwable {
		requestAndAllocation = new BUDGET_RequestAndAllocationObj(driver);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_DirctionIcon());
		requestAndAllocation.budget_requestAndAllocation_DirctionIcon().click();
	}

	@And("^Budget module Drpdwn Click$")
	public void budget_module_drpdwn_click() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetField());
		requestAndAllocation.budget_requestAndAllocation_BudgetField().click();
	}

	@Then("^Budget module Eye Icon Click$")
	public void budget_module_eye_icon_click() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon());
		requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon().click();
	}

	@And("^Add icon  Click$")
	public void add_icon_click() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_Addicon());
		requestAndAllocation.budget_requestAndAllocation_Addicon().click();
	}

	@Then("^Choose one current Budget Code$")
	public void choose_one_current_budget_code() throws Throwable {
		RequestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(RequestAndAllocationTestData.BudgetCode);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
	}

	@And("^Choose one current Budget Year$")
	public void choose_one_current_budget_year() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyear());
		dropDownHelper.SelectUsingVisibleText(requestAndAllocation.budget_requestAndAllocation_Budgetyear(),
				RequestAndAllocationTestData.BudgetYear);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
	}

	@Then("^Choose on Branch fields$")
	public void choose_on_branch_fields() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetbranch());
		requestAndAllocation.budget_requestAndAllocation_Budgetbranch().click();
	}

	@And("^Choose Branch branch field$")
	public void choose_branch_branch_field() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_type());
		requestAndAllocation.requestAndAllocation_branch_type().click();
	}

	@Then("^Click ok button in pop up$")
	public void click_ok_button_in_pop_up() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_branchOK());
		requestAndAllocation.budget_requestAndAllocation_branchOK().click();
	}

	@And("^Enter Amount for Budget Type Show in Budget type field$")
	public void enter_amount_for_budget_type_show_in_budget_type_field() throws Throwable {
		requestandallocationbudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgettype());
		String budgettype = requestAndAllocation.budget_requestAndAllocation_Budgettype().getText();
		requestandallocationbudtype = jsonReader.getBudtypeByName(budgettype);
		javahelper.JavaScriptHelper(driver);
		if (budgettype.equalsIgnoreCase("YEARLY")) {
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JavaScriptHelper(driver);
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyearly());
			requestAndAllocation.budget_requestAndAllocation_Budgetyearly()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetremark()
					.sendKeys(RequestAndAllocationTestData.Remark);
		} else if (budgettype.equalsIgnoreCase("MONTHLY")) {

			javahelper.JavaScriptHelper(driver);
			javahelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth12()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark12()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth11());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth11()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark11()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth10());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth10()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark10()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth9());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth9()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark9()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth8());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth8()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark8()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth7());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth7()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7()
					.sendKeys(RequestAndAllocationTestData.Remark);
			// javahelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7());

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth6());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth6()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark6()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth5());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth5()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark5()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth4());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth4()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark4()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth3());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth3()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark3()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth2());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth2()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark2()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth1());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth1()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark1()
					.sendKeys(RequestAndAllocationTestData.Remark);

		} else if (budgettype.equalsIgnoreCase("QUARTERLY")) {
			javahelper.JavaScriptHelper(driver);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark3()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark2()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly1());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly1()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark1()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly0());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly0()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark0()
					.sendKeys(RequestAndAllocationTestData.Remark);

		} else if (budgettype.equalsIgnoreCase("HALFYEARLY")) {
			javahelper.JavaScriptHelper(driver);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			// javahelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy1());
			requestAndAllocation.budget_requestAndAllocation_BudgetHy1()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHyremark1());
			requestAndAllocation.budget_requestAndAllocation_BudgetHyremark1()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy2());
			requestAndAllocation.budget_requestAndAllocation_BudgetHy2()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetHyremark2()
					.sendKeys(RequestAndAllocationTestData.Remark);

		}
	}

	@Then("^Choose Any Need currency$")
	public void choose_any_need_currency() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Amountcurruncy());
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().click();
		// requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.ENTER);
	}

	@And("^click on the save$")
	public void click_on_the_save() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_AllowSave());
		requestAndAllocation.budget_requestAndAllocation_AllowSave().click();
	}

	@Then("^Click the Notify Action icon button$")
	public void click_the_notify_action_icon_button() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.makerNotificationIcon());
		requestAndAllocation.makerNotificationIcon().click();
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.maker_Referance_id());
		String Referance_id = requestAndAllocation.maker_Referance_id().getText();
		json.addReferanceData(Referance_id);
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.maker_Action_icon());
		requestAndAllocation.maker_Action_icon().click();
	}

	@And("^Click the Record submit icon$")
	public void click_the_record_submit_icon() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetSubmit());
		requestAndAllocation.budget_requestAndAllocation_BudgetSubmit().click();
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_Alertremark());
		requestAndAllocation.requestAndAllocation_Alertremark().sendKeys(RequestAndAllocationTestData.Remark);
		waitHelper.waitForElement(driver, 5000, requestAndAllocation.requestAndAllocation_Alertsubmit());
		requestAndAllocation.requestAndAllocation_Alertsubmit().click();
		waitHelper.waitForElement(driver, 10000, requestAndAllocation.requestAndAllocation_reviewer_id());
		reviwerId = requestAndAllocation.requestAndAllocation_reviewer_id().getText();
		String trimmdReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmdReviewerID);
		StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
		String filanReviewerID = bufferedString.toString();
		// json.addReferanceData(reviwerId =
		// requestAndAllocation.requestAndAllocation_reviewer_id().getText());
		json.addData(filanReviewerID);
		System.out.println(reviwerId);
	}

	// REVIEWER
	@Given("^Azentio url login as Reviewer$")
	public void azentio_url_login_as_reviewer() throws Throwable {
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.logintoAzentioappReviewer("Reviewer", json.readdata());
	}

	@Then("^Click on Reviewer Notification icon$")
	public void click_on_reviewer_notification_icon() throws Throwable {
		reviewerObj = new KUBS_ReviewerObj(driver);
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewerNotidicationIcon());
		reviewerObj.reviewerNotidicationIcon().click();
	}

	@And("^Click on the Reviewer Action button icon$")
	public void click_on_the_reviewer_action_button_icon() throws Throwable {
		javahelper.JavaScriptHelper(driver);
		// span[contains(text(),'336')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//div//ion-buttons//ion-button
		String befr_xpath = "//span[contains(text(),'";
		String aftr_xpath = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//div//ion-buttons//ion-button";
		waitHelper.waitForElement(driver, 2000,
				driver.findElement(By.xpath(befr_xpath + json.readReferancedata() + aftr_xpath)));
		driver.findElement(By.xpath(befr_xpath + json.readReferancedata() + aftr_xpath)).click();

		reviewerObj.reviewer_action_button().click();
	}

	@Then("^Click to the Approve button in Reviewer stage$")
	public void click_to_the_approve_button_in_reviewer_stage() throws Throwable {
		// json.addReferanceData(referance_id);
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewerApproveButton());
		reviewerObj.reviewerApproveButton().click();
	}

	@And("^Submit to the reviewer Records$")
	public void submit_to_the_reviewer_records() throws Throwable {
		waitHelper.waitForElement(driver, 5000, reviewerObj.reviewerAlertRemarks());
		reviewerObj.reviewerAlertRemarks().sendKeys("ok");
		waitHelper.waitForElement(driver, 5000, reviewerObj.reviewerAlertSubmitButton());
		// reviewer.reviewerAlertSubmitButton().click();
		javahelper.JSEClick(reviewerObj.reviewerAlertSubmitButton());
		waitHelper.waitForElement(driver, 3000, reviewerObj.approvalStatus());
		Assert.assertTrue(reviewerObj.approvalStatus().isDisplayed());
	}

	// CHECKER
	@Given("^Azentio url login as checker$")
	public void azentio_url_login_as_checker() throws Throwable {
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioAppAsChecker("Checker");
	}

	@Then("^click to the security management$")
	public void click_to_the_security_management() throws Throwable {
		waitHelper.waitForElement(driver, 3000, kubschecker.checkerSecurityManagement());
		kubschecker.checkerSecurityManagement().click();
	}

	@And("^Click to the sub module open pool near Edit icon$")
	public void click_to_the_sub_module_open_pool_near_edit_icon() throws Throwable {
		waitHelper.waitForElement(driver, 3000, kubschecker.checkerActionIcon());
		kubschecker.checkerActionIcon().click();
	}

	@Then("^Click to claim option button$")
	public void click_to_claim_option_button() throws Throwable {
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		waitHelper.waitForElement(driver, 10000,
				driver.findElement(By.xpath(before_xpath + json.readReferancedata() + after_xpath_claim)));
		driver.findElement(By.xpath(before_xpath + json.readReferancedata() + after_xpath_claim)).click();
		waitHelper.waitForElement(driver, 2000, kubschecker.checker_alert_close());
		kubschecker.checker_alert_close().click();
	}

	@And("^Click the checker notification icon in checker$")
	public void click_the_checker_notification_icon_in_checker() throws Throwable {
		javahelper = new JavascriptHelper();
		waitHelper.waitForElement(driver, 3000, kubschecker.checkerNotificationIcon());
		javahelper.JavaScriptHelper(driver);
		javahelper.JSEClick(kubschecker.checkerNotificationIcon());
	}

	@Then("^click to the checker action icon button$")
	public void click_to_the_checker_action_icon_button() throws Throwable {
		waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"
				+ json.readReferancedata()
				+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(By.xpath("//span[contains(text(),'" + json.readReferancedata()
				+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"))
				.click();
	}

	@And("^Checker click Approve the Record$")
	public void checker_click_approve_the_record() throws Throwable {
		waitHelper.waitForElement(driver, 2000, kubschecker.checkerApproveButton());
		kubschecker.checkerApproveButton().click();
	}

	@Then("^Submit to the Approve Record in checker$")
	public void submit_to_the_approve_record_in_checker() throws Throwable {
		waitHelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
		kubschecker.checkerRemarks().sendKeys("ok");
		waitHelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();

	}

	@And("^Capture the Authorization status$")
	public void capture_the_authorization_status() throws Throwable {
		waitHelper.waitForElement(driver, 3000, kubschecker.Popup_status());
		String data = kubschecker.Popup_status().getText();
		System.out.println("Authorization Status: " + data);
		Assert.assertTrue(kubschecker.Popup_status().isDisplayed());

	}

	/*
	 *
	 * KUBS_Checker_Send_Notification_to_Maker_BP_BC_05_09
	 *
	 */

	@Given("^Launch to the Azentio Url$")
	public void Launch_to_the_Azentio_Url() throws Throwable {
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioApp("Maker");
		Thread.sleep(2000);
	}

	@Then("^OnClick Transfer button Icon$")
	public void OnClick_Transfer_button_Icon() throws Throwable {
		requestAndAllocation = new BUDGET_RequestAndAllocationObj(driver);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver, 5000, requestAndAllocation.budget_requestAndAllocation_DirctionIcon());
		requestAndAllocation.budget_requestAndAllocation_DirctionIcon().click();

	}

	@And("^OnClick Budget module Drpdwn$")
	public void onclick_Budget_module_Drpdwn() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetField());
		requestAndAllocation.budget_requestAndAllocation_BudgetField().click();
	}

	@Then("^OnClick on Budget module Eye Icon$")
	public void onclick_on_Budget_module_Eye_Icon() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon());
		requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon().click();
	}

	@And("^OnClick on Add icon$")
	public void OnClick_on_Add_icon() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_Addicon());
		requestAndAllocation.budget_requestAndAllocation_Addicon().click();
	}

	@Then("^Choose New Budget Code$")
	public void Choose_New_Budget_Code() throws Throwable {
		RequestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(RequestAndAllocationTestData.BudgetCode);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
	}

	@And("^Choose current finance Budget Year$")
	public void Choose_current_finance_Budget_Year() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyear());
		dropDownHelper.SelectUsingVisibleText(requestAndAllocation.budget_requestAndAllocation_Budgetyear(),
				RequestAndAllocationTestData.BudgetYear);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
	}

	@Then("^Onclick on Branch field$")
	public void Onclick_on_Branch_field() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetbranch());
		requestAndAllocation.budget_requestAndAllocation_Budgetbranch().click();
	}

	@And("^Onclick one Branch in branch field$")
	public void Onclick_one_Branch_in_branch_field() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_type3());
		requestAndAllocation.requestAndAllocation_branch_type3().click();
	}

	@Then("^OnClick Branch ok button in pop up$")
	public void Onclick_Branch_ok_button_in_pop_up() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_branchOK());
		requestAndAllocation.budget_requestAndAllocation_branchOK().click();
	}

	@Then("^Choose we Need currency$")
	public void Choose_we_Need_currency() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Amountcurruncy());
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().click();
		// requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.ENTER);
	}

	@And("^Enter Amount On Budget Show in Budget type$")
	public void Enter_Amount_on_Budget_Show_in_Budget_type() throws Throwable {
		requestandallocationbudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgettype());
		String budgettype = requestAndAllocation.budget_requestAndAllocation_Budgettype().getText();
		requestandallocationbudtype = jsonReader.getBudtypeByName(budgettype);
		javahelper.JavaScriptHelper(driver);
		if (budgettype.equalsIgnoreCase("YEARLY")) {
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JavaScriptHelper(driver);
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyearly());
			requestAndAllocation.budget_requestAndAllocation_Budgetyearly()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetremark()
					.sendKeys(RequestAndAllocationTestData.Remark);
		} else if (budgettype.equalsIgnoreCase("MONTHLY")) {

			javahelper.JavaScriptHelper(driver);
			javahelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth12());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth12()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark12()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth11());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth11()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark11()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth10());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth10()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark10()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth9());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth9()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark9()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth8());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth8()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark8()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth7());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth7()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7()
					.sendKeys(RequestAndAllocationTestData.Remark);
			// javahelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7());

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth6());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth6()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark6()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth5());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth5()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark5()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth4());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth4()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark4()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth3());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth3()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark3()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth2());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth2()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark2()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetmonth1());
			requestAndAllocation.budget_requestAndAllocation_Budgetmonth1()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark1()
					.sendKeys(RequestAndAllocationTestData.Remark);

		} else if (budgettype.equalsIgnoreCase("QUARTERLY")) {
			javahelper.JavaScriptHelper(driver);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly3()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark3()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly2()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark2()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly1());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly1()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark1()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly0());
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterly0()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetQuaterlyremark0()
					.sendKeys(RequestAndAllocationTestData.Remark);

		} else if (budgettype.equalsIgnoreCase("HALFYEARLY")) {
			javahelper.JavaScriptHelper(driver);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			// javahelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy1());
			requestAndAllocation.budget_requestAndAllocation_BudgetHy1()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHyremark1());
			requestAndAllocation.budget_requestAndAllocation_BudgetHyremark1()
					.sendKeys(RequestAndAllocationTestData.Remark);

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy2());
			requestAndAllocation.budget_requestAndAllocation_BudgetHy2()
					.sendKeys(requestandallocationbudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_BudgetHyremark2()
					.sendKeys(RequestAndAllocationTestData.Remark);

		}

	}

	@And("^Onclick save button$")
	public void Onclick_save_button() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_AllowSave());
		requestAndAllocation.budget_requestAndAllocation_AllowSave().click();
	}

	@Then("^OnClick Notification Action icon button$")
	public void OnClick_Notification_Action_icon_button() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.makerNotificationIcon());
		requestAndAllocation.makerNotificationIcon().click();
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.maker_Referance_id());
		String Referance_id = requestAndAllocation.maker_Referance_id().getText();
		json.addReferanceData(Referance_id);
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.maker_Action_icon());
		requestAndAllocation.maker_Action_icon().click();
	}

	@And("^OnClick Record submit icon$")
	public void OnClick_Record_submit_icon() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetSubmit());
		requestAndAllocation.budget_requestAndAllocation_BudgetSubmit().click();
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_Alertremark());
		requestAndAllocation.requestAndAllocation_Alertremark().sendKeys(RequestAndAllocationTestData.Remark);
		waitHelper.waitForElement(driver, 5000, requestAndAllocation.requestAndAllocation_Alertsubmit());
		requestAndAllocation.requestAndAllocation_Alertsubmit().click();
		waitHelper.waitForElement(driver, 10000, requestAndAllocation.requestAndAllocation_reviewer_id());
		reviwerId = requestAndAllocation.requestAndAllocation_reviewer_id().getText();
		String trimmdReviewerID = reviwerId.substring(85);
		StringBuffer sb = new StringBuffer(trimmdReviewerID);
		StringBuffer bufferedString = sb.deleteCharAt(trimmdReviewerID.length() - 1);
		String filanReviewerID = bufferedString.toString();
		// json.addReferanceData(reviwerId =
		// requestAndAllocation.requestAndAllocation_reviewer_id().getText());
		json.addData(filanReviewerID);
		System.out.println(reviwerId);

	}

	// Reviewer
	@Given("^url login as Reviewer$")
	public void url_login_as_Reviewer() throws Throwable {
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.logintoAzentioappReviewer("Reviewer", json.readdata());
	}

	@Then("^OnClick Reviewer Notification icon$")
	public void OnClick_Reviewer_Notification_icon() throws Throwable {
		reviewerObj = new KUBS_ReviewerObj(driver);
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewerNotidicationIcon());
		reviewerObj.reviewerNotidicationIcon().click();
	}

	@And("^OnClick Reviewer Action button icon$")
	public void OnClick_Reviewer_Action_button_icon() throws Throwable {
		javahelper.JavaScriptHelper(driver);
		// span[contains(text(),'336')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//div//ion-buttons//ion-button
		String befr_xpath = "//span[contains(text(),'";
		String aftr_xpath = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[1]//div//ion-buttons//ion-button";
		waitHelper.waitForElement(driver, 2000,
				driver.findElement(By.xpath(befr_xpath + json.readReferancedata() + aftr_xpath)));
		driver.findElement(By.xpath(befr_xpath + json.readReferancedata() + aftr_xpath)).click();

		reviewerObj.reviewer_action_button().click();
	}

	@Then("^OnClick Approve button in Reviewer stage$")
	public void OnClick_Approve_button_in_Reviewer_stage() throws Throwable {
		// json.addReferanceData(referance_id);
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewerApproveButton());
		reviewerObj.reviewerApproveButton().click();
	}

	@And("^Submit reviewer Record$")
	public void Submit_reviewer_Record() throws Throwable {
		waitHelper.waitForElement(driver, 5000, reviewerObj.reviewerAlertRemarks());
		reviewerObj.reviewerAlertRemarks().sendKeys("ok");
		waitHelper.waitForElement(driver, 5000, reviewerObj.reviewerAlertSubmitButton());
		// reviewer.reviewerAlertSubmitButton().click();
		javahelper.JSEClick(reviewerObj.reviewerAlertSubmitButton());
		waitHelper.waitForElement(driver, 3000, reviewerObj.approvalStatus());
		Assert.assertTrue(reviewerObj.approvalStatus().isDisplayed());
	}

	// CHECKER - REJECTING
	@Given("^Url login as checker$")
	public void url_login_as_checker() throws Throwable {
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioAppAsChecker("Checker");
	}

	@Then("^Onclick to security management$")
	public void Onclick_to_security_management() throws Throwable {
		waitHelper.waitForElement(driver, 3000, kubschecker.checkerSecurityManagement());
		kubschecker.checkerSecurityManagement().click();
	}

	@And("^OnClick to sub module open pool near Edit icon$")
	public void OnClick_to_sub_module_open_pool_near_Edit_icon() throws Throwable {
		waitHelper.waitForElement(driver, 3000, kubschecker.checkerActionIcon());
		kubschecker.checkerActionIcon().click();
	}

	@Then("^OnClick to the claim option button$")
	public void OnClick_to_the_claim_option_button() throws Throwable {
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		waitHelper.waitForElement(driver, 10000,
				driver.findElement(By.xpath(before_xpath + json.readReferancedata() + after_xpath_claim)));
		driver.findElement(By.xpath(before_xpath + json.readReferancedata() + after_xpath_claim)).click();
		waitHelper.waitForElement(driver, 2000, kubschecker.checker_alert_close());
		kubschecker.checker_alert_close().click();
	}

	@And("^OnClick on the checker notification icon in checker$")
	public void OnClick_on_the_checker_notification_icon_in_checker() throws Throwable {
		javahelper = new JavascriptHelper();
		waitHelper.waitForElement(driver, 3000, kubschecker.checkerNotificationIcon());
		javahelper.JavaScriptHelper(driver);
		javahelper.JSEClick(kubschecker.checkerNotificationIcon());
	}

	@Then("^Onclick to checker action icon button$")
	public void Onclick_to_checker_action_icon_button() throws Throwable {
		waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"
				+ json.readReferancedata()
				+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(By.xpath("//span[contains(text(),'" + json.readReferancedata()
				+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"))
				.click();
	}

	@And("^Once Checker Approve the Record$")
	public void once_Checker_Approve_the_Record() throws Throwable {
		waitHelper.waitForElement(driver, 2000, kubschecker.checkerApproveButton());
		kubschecker.checkerApproveButton().click();
	}

	@Then("^then Submit the Approve Record in checker$")
	public void then_Submit_the_Approve_Record_in_checker() throws Throwable {
		waitHelper.waitForElement(driver, 2000, kubschecker.checkerRemarks());
		kubschecker.checkerRemarks().sendKeys("ok");
		waitHelper.waitForElement(driver, 2000, kubschecker.checkersubmitButton());
		kubschecker.checkersubmitButton().click();
		waitHelper.waitForElement(driver, 3000, kubschecker.Popup_status());
		Assert.assertTrue(kubschecker.Popup_status().isDisplayed());
	}

	@And("^System login as Maker Url$")
	public void system_login_as_maker_url() throws Throwable {
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioApp("Maker");
	}

	@Then("^Onclick Maker Notification$")
	public void onclick_maker_notification() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.makerNotificationIcon());
		requestAndAllocation.makerNotificationIcon().click();
		//Assert.assertFalse(driver.findElement(By.xpath("//span[contains(text(),'" + json.readReferancedata()+ "')]")).isDisplayed());
	}
	/*
	 *
	 * @KUBS_SEARCH_CRITERIA_BP_BC_11_01
	 * 
	 */

	@Given("^Navigate the Azentio Url$")
	public void navigate_the_azentio_url() throws Throwable {
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioApp("Maker");
		Thread.sleep(2000);
	}

	@Then("^Click Transfer icon button$")
	public void click_transfer_icon_button() throws Throwable {
		requestAndAllocation = new BUDGET_RequestAndAllocationObj(driver);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_DirctionIcon());
		requestAndAllocation.budget_requestAndAllocation_DirctionIcon().click();
	}

	@And("^Click to Budget module$")
	public void click_to_budget_module() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetField());
		requestAndAllocation.budget_requestAndAllocation_BudgetField().click();
	}

	@Then("^Click to Budget module Budget Request and Allocation Edit Icon$")
	public void click_to_budget_module_budget_request_and_allocation_eye_icon() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetEditIcon());
		requestAndAllocation.budget_requestAndAllocation_BudgetEditIcon().click();
	}

	@And("^Click on search icon$")
	public void click_on_search_icon() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetSearchIcon());
		requestAndAllocation.budget_requestAndAllocation_BudgetSearchIcon().click();
	}

	@Then("^Enter the search code we Need$")
	public void enter_the_search_code_we_need() throws Throwable {
		RequestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_Budgetcodesearch());
		requestAndAllocation.budget_requestAndAllocation_Budgetcodesearch()
				.sendKeys(RequestAndAllocationTestData.SearchCode);
	}

	@And("^Click the action button$")
	public void Click_the_action_button() throws Throwable {
		// waitHelper.waitForElement(driver, 2000,
		// requestAndAllocation.budget_requestAndAllocation_Budgetaction());
		RequestAndAllocationTestData = new BUDGET_RequestAndAllocationTestDataType();
		RequestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		String befr_action = "//span[contains(text(),'";
		String aftr_action = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button";
		waitHelper.waitForElement(driver, 5000,
				driver.findElement(By.xpath(befr_action + RequestAndAllocationTestData.SearchCode + aftr_action)));
		driver.findElement(By.xpath(befr_action + RequestAndAllocationTestData.SearchCode + aftr_action)).click();

	}

	@Then("^Capture the code is displayed$")
	public void Capture_the_code_is_displayed() throws Throwable {
		javahelper.JavaScriptHelper(driver);
		String budgetCode = (String) javahelper
				.executeScript("return document.getElementsByClassName('ng-value-label')[0].innerText");
		System.out.println("Budget Code " + budgetCode);
	}

	/*
	 * 
	 * KUBS_SEARCH_CRITERIA_MODIFICATION_BP_BC_19_01
	 * 
	 */
	@Given("^Navigate the Azentio Url Maker$")
	public void Navigate_the_Azentio_Url_Maker() throws Throwable {
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioApp("Maker");
		Thread.sleep(2000);
	}

	@Then("^Click Transfer icon button Maker$")
	public void Click_Transfer_icon_button_Maker() throws Throwable {
		requestAndAllocation = new BUDGET_RequestAndAllocationObj(driver);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_DirctionIcon());
		requestAndAllocation.budget_requestAndAllocation_DirctionIcon().click();
	}

	@And("^Click to Budget module in Maker$")
	public void Click_to_Budget_module_in_Maker() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetField());
		requestAndAllocation.budget_requestAndAllocation_BudgetField().click();
	}

	@Then("^Click Budget module Budget Request and Allocation Edit Icon$")
	public void Click_Budget_module_Budget_Request_and_Allocation_Edit_Icon() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetEditIcon());
		requestAndAllocation.budget_requestAndAllocation_BudgetEditIcon().click();
	}

	@And("^Click search icon$")
	public void click_search_icon() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetSearchIcon());
		requestAndAllocation.budget_requestAndAllocation_BudgetSearchIcon().click();
	}

	@Then("^Enter the search code$")
	public void Enter_the_search_code() throws Throwable {
		RequestAndAllocationTestData= jsonReader.getAllowcationByName("Maker");
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_Budgetcodesearch());
		requestAndAllocation.budget_requestAndAllocation_Budgetcodesearch()
				.sendKeys(RequestAndAllocationTestData.SearchCode);
	}

	@And("^Click action button$")
	public void Click_action_button() throws Throwable {
		// waitHelper.waitForElement(driver, 2000,
		// requestAndAllocation.budget_requestAndAllocation_Budgetaction());
		RequestAndAllocationTestData = new BUDGET_RequestAndAllocationTestDataType();
		RequestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		String befr_action = "//span[contains(text(),'";
		String aftr_action = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button";
		waitHelper.waitForElement(driver, 2000,
				driver.findElement(By.xpath(befr_action + RequestAndAllocationTestData.SearchCode + aftr_action)));
		driver.findElement(By.xpath(befr_action + RequestAndAllocationTestData.SearchCode + aftr_action)).click();
		String befr_code = "//span[contains(text(),'";
		String aftr_code = "')]";
		waitHelper.waitForElement(driver, 2000,
				driver.findElement(By.xpath(befr_code + RequestAndAllocationTestData.SearchCode + aftr_code)));
		driver.findElement(By.xpath(befr_code + RequestAndAllocationTestData.SearchCode + aftr_code)).isDisplayed();
	}

	@Then("^Capture the code$")
	public void Capture_the_code() throws Throwable {
		javahelper.JavaScriptHelper(driver);
		String budgetCode = (String) javahelper
				.executeScript("return document.getElementsByClassName('ng-value-label')[0].innerText");
		System.out.println("Budget Code " + budgetCode);
	}

	@And("^Modify the Code$")
	public void Modify_the_Code() throws Throwable {

		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javahelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javahelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy2());
		requestAndAllocation.budget_requestAndAllocation_BudgetHy2()
				.sendKeys(RequestAndAllocationTestData.Searchamount);
	}

	@And("^After modify click save button$")
	public void after_modify_click_save_button() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_AllowSave());
		requestAndAllocation.budget_requestAndAllocation_AllowSave().click();

	}
}