package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
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

public class BUDGET_BudgetRequestandAllocation extends BaseClass {
	WebDriver driver = BaseClass.driver;
	ConfigFileReader configFileReader = new ConfigFileReader();
	KUBS_Login login;
	BUDGET_RequestAndAllocationObj requestAndAllocation;
	WaitHelper waitHelper = new WaitHelper(driver);
	String reviwerId;
	BUDGET_RequestAndAllocationTestDataType requestAndAllocationTestData;
	JsonConfig jsonReader = new JsonConfig();
	DropDownHelper dropDownHelper = new DropDownHelper(driver);
	BUDGET_RequestandallocationBUDTYPEDATA requestAndAllocationBudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
	JavascriptHelper javaHelper = new JavascriptHelper();
	JsonDataReaderWriter json = new JsonDataReaderWriter();
	KUBS_ReviewerObj reviewerObj = new KUBS_ReviewerObj(driver);
	String referance_id;
	BrowserHelper browserHelper;
	KUBS_CheckerObj kubsChecker = new KUBS_CheckerObj(driver);

	// -----------------------AZENTIO COMMON LOGIN STEPS--------------------------//

	@Given("^Navigate the Azentio Maker Url$")
	public void navigate_the_azentio_maker_url() throws Throwable {

		// ---------LOGIN THE MAKER USER--------------//
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioApp("Maker");
		Thread.sleep(2000);
	}

	@Given("^Navigate the Azentio Url login as Reviewer$")
	public void navigate_the_azentio_url_login_as_reviewer() throws Throwable {

		// ----------LOGIN AS REVIEWER---------------//
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.logintoAzentioappReviewer("Reviewer", json.readdata());
	}

	@Given("^Navigate the Azentio Url login as checker$")
	public void navigate_the_azentio_url_login_as_checker() throws Throwable {

		// ----------LOGIN AS CHECKER----------------//
		login = new KUBS_Login(driver);
		driver.get(configFileReader.getApplicationUrl());
		login.loginToAzentioAppAsChecker("Checker");
	}

	// -------------------------MAKER COMMON STEPS--------------------------//

	@Then("^Click Transfer Icon$")
	public void click_transfer_icon() throws Throwable {

		// ---------TO VIEW THE TRANFER AMOUNT BUDGET----------//
		requestAndAllocation = new BUDGET_RequestAndAllocationObj(driver);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver, 5000, requestAndAllocation.budget_requestAndAllocation_DirctionIcon());
		requestAndAllocation.budget_requestAndAllocation_DirctionIcon().click();

	}

	@And("^Click on Budget Module$")
	public void click_on_budget_module() throws Throwable {

		// -----------TO CLICK THE BUDGET MODULE--------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetField());
		requestAndAllocation.budget_requestAndAllocation_BudgetField().click();
	}

	@Then("^Click on Budget Sub module Near Eye Icon$")
	public void click_on_Budget_Sub_module_near_eye_icon() throws Throwable {

		// ----------TO CLICK THE EYE ICON------------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon());
		requestAndAllocation.budget_requestAndAllocation_BudgetEyeIcon().click();
	}

	@And("^Click on Add icon in Request and Allocation$")
	public void click_on_add_icon_in_request_and_allocation() throws Throwable {

		// ----------TO CREATE A NEW BUDGET AMOUNT------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_Addicon());
		requestAndAllocation.budget_requestAndAllocation_Addicon().click();
	}

	@And("^Select Current Budget Year$")
	public void select_current_budget_year() throws Throwable {

		// ----------TO SELECT THE BUDGET YEAR---------------//
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyear());
		dropDownHelper.SelectUsingVisibleText(requestAndAllocation.budget_requestAndAllocation_Budgetyear(),
				requestAndAllocationTestData.BudgetYear);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.DOWN);
	}

//	@And("^click on save button$")
//	public void click_on_save_button() throws Throwable {
//
//		// ------------TO SAVE THE RECORD--------------------//
//		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_AllowSave());
//		requestAndAllocation.budget_requestAndAllocation_AllowSave().click();
//		Thread.sleep(2000);
//	}

	@Then("^Click on Branch$")
	public void click_on_branch() throws Throwable {

		// ------------------------TO SELECT THE BRANCH-------------------------//
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetbranch());
		requestAndAllocation.budget_requestAndAllocation_Budgetbranch().click();
	}

	@Then("^Click on Branch ok button$")
	public void click_on_branch_ok_button() throws Throwable {

		// -------------------------TO CLICK BRANCH OK BUTTON-----------------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_branchOK());
		requestAndAllocation.budget_requestAndAllocation_branchOK().click();
	}
	
	@Then("^Click on Maker Notification button$")
	public void click_on_maker_notification_button() throws Throwable {

		// ---------------------------TO CLICK THE MAKER NOTIFICATION------------------------//
		while(true){
			try {
		requestAndAllocation = new BUDGET_RequestAndAllocationObj(driver);
		javaHelper.JavaScriptHelper(driver);
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.makerNotificationIcon());
		javaHelper.JSEClick(requestAndAllocation.makerNotificationIcon());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.maker_Referance_id());
		String Referance_id = requestAndAllocation.maker_Referance_id().getText();
		json.addReferanceData(Referance_id);
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.maker_Action_icon());
		requestAndAllocation.maker_Action_icon().click();
		break;
		}
			catch(StaleElementReferenceException staleElement) {
				System.out.println(staleElement.getMessage());
			}
			}
		}

	@And("^Click on Record submit$")
	public void click_on_record_submit() throws Throwable {

		// -------------------------TO SUBMIT THE RECORD-----------------------------//
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
	
	//--------------------------------------REVIEWER COMMON STEPS----------------------------------//
	
	@Then("^Click on Notification icon$")
	public void click_on_notification_icon() throws Throwable {

		// ------------------------CLICK ON REVIEWER NOTIFICATION-----------------------//
		reviewerObj = new KUBS_ReviewerObj(driver);
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewerNotidicationIcon());
		reviewerObj.reviewerNotidicationIcon().click();
	}
	
	//-----------------------------------CHECKER COMMON STEPS------------------------------------//
	
	@Then("^click on security management$")
	public void click_on_security_management() throws Throwable {

		// --------------------CLICK ON SECURITY MANAGEMENTS-----------------------//
		waitHelper.waitForElement(driver, 3000, kubsChecker.checkerSecurityManagement());
		kubsChecker.checkerSecurityManagement().click();
	}

	@And("^Click on sub module open pool near Edit icon$")
	public void click_on_sub_module_open_pool_near_edit_icon() throws Throwable {

		// ----------------------CLICK ON OPEN POOL-----------------------//
		waitHelper.waitForElement(driver, 3000, kubsChecker.checkerActionIcon());
		kubsChecker.checkerActionIcon().click();
	}
	
	// ********************* KUBS_RequestandAllocation_BP_BC_05_01 ************************//

	@Then("^Select Budget Code in fields$")
	public void select_budget_code_in_fields() throws Throwable {

		// ----------TO SELECT THE BUDGET CODE----------------//
		requestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(requestAndAllocationTestData.BudgetCode);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
	}


	@And("^Select one Branch$")
	public void select_one_branch() throws Throwable {

		// ---------------------TO SELECT ONE BRANCH CHECKBOX-----------------------//
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_type());
		requestAndAllocation.requestAndAllocation_branch_type().click();
	}


	@Then("^Select Which currency we need$")
	public void select_which_currency_we_need() throws Throwable {

		// -------------------------TO SELECT THE CURRENCY WE NEED---------------------------//
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Amountcurruncy());
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().click();
		// requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.ENTER);
	}

	@And("^Enter Amount for which Budget Type Show in Budget type field$")
	public void enter_amount_for_which_budget_type_show_in_budget_type_field() throws Throwable {

		// ----------------------HERE WE ENTER BUDGET AMOUNT FOR EVERY BUDGET TYPE----------------------//
		requestAndAllocationBudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgettype());
		String budgettype = requestAndAllocation.budget_requestAndAllocation_Budgettype().getText();
		requestAndAllocationBudtype = jsonReader.getBudtypeByName(budgettype);
		javaHelper.JavaScriptHelper(driver);
		if (budgettype.equalsIgnoreCase("YEARLY")) {

			// ---------------------------THIS CODE FOR YEARLY BUDGET--------------------------//

			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JavaScriptHelper(driver);
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyearly());
			requestAndAllocation.budget_requestAndAllocation_Budgetyearly()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetremark()
					.sendKeys(requestAndAllocationTestData.Remark);
		} else if (budgettype.equalsIgnoreCase("MONTHLY")) {

			// ----------------------------THIS CODE FOR MONTHLY BUDGET-------------------------//

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

			// ----------------------------THIS CODE FOR QUARTERLY BUDGET---------------------------//

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

			// ---------------------------------THIS CODE FOR HALFYEARLY BUDGET-------------------------//

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

	// Reviewer - Flow

	@And("^Click on Reviewer Action button$")
	public void click_on_Reviewer_action_button() throws Throwable {

		// ---------------------CLICK TO RECORD ACTION ICON-------------------------//
		javaHelper.JavaScriptHelper(driver);
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

		// --------------------APPROVE THE RECORD---------------------------//
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewerApproveButton());
		reviewerObj.reviewerApproveButton().click();
	}

	@And("^Submit the reviewer Record$")
	public void Submit_the_reviewer_Record() throws Throwable {

		// ---------------------SUBMIT THE REVIEWER RECORD-----------------------//
		waitHelper.waitForElement(driver, 5000, reviewerObj.reviewerAlertRemarks());
		reviewerObj.reviewerAlertRemarks().sendKeys("ok");
		waitHelper.waitForElement(driver, 5000, reviewerObj.reviewerAlertSubmitButton());
		// reviewerObj.reviewerAlertSubmitButton().click();
		javaHelper.JSEClick(reviewerObj.reviewerAlertSubmitButton());
		waitHelper.waitForElement(driver, 3000, reviewerObj.approvalStatus());
		Assert.assertTrue(reviewerObj.approvalStatus().isDisplayed());
	}

	// Checker - Flow

	@Then("^Click the claim option$")
	public void click_the_claim_option() throws Throwable {

		// -------------------------CLICK CLAIM OPTION-------------------------//
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		waitHelper.waitForElement(driver, 10000,
				driver.findElement(By.xpath(before_xpath + json.readReferancedata() + after_xpath_claim)));
		driver.findElement(By.xpath(before_xpath + json.readReferancedata() + after_xpath_claim)).click();
		waitHelper.waitForElement(driver, 2000, kubsChecker.checker_alert_close());
		kubsChecker.checker_alert_close().click();
	}

	@And("^Click on checker notification icon$")
	public void click_on_checker_notification_icon() throws Throwable {

		// ----------------CHECKER NOTIFICATION-----------------------//
		javaHelper = new JavascriptHelper();
		waitHelper.waitForElement(driver, 3000, kubsChecker.checkerNotificationIcon());
		javaHelper.JavaScriptHelper(driver);
		javaHelper.JSEClick(kubsChecker.checkerNotificationIcon());
	}

	@Then("^click checker action icon$")
	public void click_checker_action_icon() throws Throwable {

		// ------------------CHECKER ACTION------------------//
		waitHelper.waitForElement(driver, 3000, driver.findElement(By.xpath("//span[contains(text(),'"
				+ json.readReferancedata()
				+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button")));
		driver.findElement(By.xpath("//span[contains(text(),'" + json.readReferancedata()
				+ "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button"))
				.click();
	}

	@And("^Approve the Record$")
	public void Approve_the_Record() throws Throwable {

		// ------------------APPROVE THE RECORD----------------------//
		waitHelper.waitForElement(driver, 2000, kubsChecker.checkerApproveButton());
		kubsChecker.checkerApproveButton().click();
	}

	@Then("^Submit the Record$")
	public void submit_the_Record() throws Throwable {

		// -----------------------SUBMIT THE RECORD------------------------//
		waitHelper.waitForElement(driver, 2000, kubsChecker.checkerRemarks());
		kubsChecker.checkerRemarks().sendKeys("ok");
		waitHelper.waitForElement(driver, 2000, kubsChecker.checkersubmitButton());
		kubsChecker.checkersubmitButton().click();
		waitHelper.waitForElement(driver, 3000, kubsChecker.Popup_status());
		Assert.assertTrue(kubsChecker.Popup_status().isDisplayed());
	}

	/*
	 * 
	 * KUBS_Reviewer_Approve_Notification_BP_BC_05_02
	 * 
	 */

	@Then("^New Budget Code$")
	public void New_Budget_Code() throws Throwable {
		requestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(requestAndAllocationTestData.BudgetCode);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
	}

	@And("^choose  Branch$")
	public void choose_Branch() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_type1());
		requestAndAllocation.requestAndAllocation_branch_type2().click();
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
		requestAndAllocationBudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgettype());
		String budgettype = requestAndAllocation.budget_requestAndAllocation_Budgettype().getText();
		requestAndAllocationBudtype = jsonReader.getBudtypeByName(budgettype);
		javaHelper.JavaScriptHelper(driver);
		if (budgettype.equalsIgnoreCase("YEARLY")) {
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JavaScriptHelper(driver);
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyearly());
			requestAndAllocation.budget_requestAndAllocation_Budgetyearly()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetremark()
					.sendKeys(requestAndAllocationTestData.Remark);
		} else if (budgettype.equalsIgnoreCase("MONTHLY")) {

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
			// javahelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7());

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
			javaHelper.JavaScriptHelper(driver);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			// javahelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
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


	// REVIEWER - APPROVER_Notification

	@Then("^Capture to Notification icon$")
	public void Capture_to_Notification_icon() throws Throwable {
		reviewerObj = new KUBS_ReviewerObj(driver);
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewerNotidicationIcon());
		reviewerObj.reviewerNotidicationIcon().click();
		waitHelper.waitForElement(driver, 2000, reviewerObj.reviewer_referanceid());
		javaHelper.JavaScriptHelper(driver);
		referance_id = reviewerObj.reviewer_referanceid().getText();
		System.out.println("Referance_id:" + referance_id);
		Assert.assertTrue(reviewerObj.reviewer_referanceid().isDisplayed());
	}

	@And("^Click the referance action icon$")
	public void click_the_referance_action_icon() throws Throwable {
		javaHelper.JavaScriptHelper(driver);
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
		javaHelper.JSEClick(reviewerObj.reviewerAlertSubmitButton());
		waitHelper.waitForElement(driver, 3000, reviewerObj.approvalStatus());
		String Notification = reviewerObj.approvalStatus().getText();
		System.out.println("Reviewer Notification: " + Notification);
		Assert.assertTrue(reviewerObj.approvalStatus().isDisplayed());
	}

	/*
	 * * * KUBS_Reviewer_Approve_BP_BC_05_03 *
	 */

	@Then("^Select New Budget Code in maker$")
	public void Select_New_Budget_Code_in_maker() throws Throwable {
		requestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(requestAndAllocationTestData.BudgetCode);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
	}


	@And("^choose one Branch$")
	public void choose_one_Branch() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_type2());
		requestAndAllocation.requestAndAllocation_branch_type2().click();
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
		requestAndAllocationBudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgettype());
		String budgettype = requestAndAllocation.budget_requestAndAllocation_Budgettype().getText();
		requestAndAllocationBudtype = jsonReader.getBudtypeByName(budgettype);
		javaHelper.JavaScriptHelper(driver);
		if (budgettype.equalsIgnoreCase("YEARLY")) {
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JavaScriptHelper(driver);
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyearly());
			requestAndAllocation.budget_requestAndAllocation_Budgetyearly()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetremark()
					.sendKeys(requestAndAllocationTestData.Remark);
		} else if (budgettype.equalsIgnoreCase("MONTHLY")) {

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
			// javahelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7());

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
			javaHelper.JavaScriptHelper(driver);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			// javahelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
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



	// REVIEWER - APPROVER

	@And("^Click to Reviewer Action button$")
	public void Click_to_Reviewer_Action_button() throws Throwable {
		javaHelper.JavaScriptHelper(driver);
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
		javaHelper.JSEClick(reviewerObj.reviewerAlertSubmitButton());
		waitHelper.waitForElement(driver, 3000, reviewerObj.approvalStatus());
		Assert.assertTrue(reviewerObj.approvalStatus().isDisplayed());
	}

	/*
	 * * * KUBS_Reviewer_Rejecting_BP_BC_05_04 *
	 */

	@Then("^Select New Budget Code$")
	public void select_new_budget_code() throws Throwable {
		requestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(requestAndAllocationTestData.BudgetCode);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
	}

	@And("^Select on one Branch$")
	public void select_on_one_branch() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_type3());
		requestAndAllocation.requestAndAllocation_branch_type3().click();
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
		requestAndAllocationBudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgettype());
		String budgettype = requestAndAllocation.budget_requestAndAllocation_Budgettype().getText();
		requestAndAllocationBudtype = jsonReader.getBudtypeByName(budgettype);
		javaHelper.JavaScriptHelper(driver);
		if (budgettype.equalsIgnoreCase("YEARLY")) {
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JavaScriptHelper(driver);
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyearly());
			requestAndAllocation.budget_requestAndAllocation_Budgetyearly()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetremark()
					.sendKeys(requestAndAllocationTestData.Remark);
		} else if (budgettype.equalsIgnoreCase("MONTHLY")) {

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
			// javahelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7());

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
			javaHelper.JavaScriptHelper(driver);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			// javahelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
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


	// REVIEWER - REJECTING

	@And("^Click Reviewer Action button$")
	public void click_Reviewer_action_button() throws Throwable {
		javaHelper.JavaScriptHelper(driver);
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
		javaHelper.JSEClick(reviewerObj.reviewerAlertSubmitButton());
		waitHelper.waitForElement(driver, 3000, reviewerObj.approvalStatus());
		Assert.assertTrue(reviewerObj.approvalStatus().isDisplayed());
	}

	/*
	 * 
	 * KUBS_Checker_Approve_Notification_BP_BC_05_05
	 *
	 */

	@Then("^current Budget Code$")
	public void current_Budget_Code() throws Throwable {
		requestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(requestAndAllocationTestData.BudgetCode);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
	}

	@And("^Choose one branch in field$")
	public void Choose_one_branch_in_field() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_type6());
		requestAndAllocation.requestAndAllocation_branch_type6().click();
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
		requestAndAllocationBudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgettype());
		String budgettype = requestAndAllocation.budget_requestAndAllocation_Budgettype().getText();
		requestAndAllocationBudtype = jsonReader.getBudtypeByName(budgettype);
		javaHelper.JavaScriptHelper(driver);
		if (budgettype.equalsIgnoreCase("YEARLY")) {
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JavaScriptHelper(driver);
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyearly());
			requestAndAllocation.budget_requestAndAllocation_Budgetyearly()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetremark()
					.sendKeys(requestAndAllocationTestData.Remark);
		} else if (budgettype.equalsIgnoreCase("MONTHLY")) {

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
			// javahelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7());

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
			javaHelper.JavaScriptHelper(driver);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			// javahelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
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


	// Reviewer

	@And("^Reviewer Action button icon$")
	public void Reviewer_Action_button_icon() throws Throwable {
		javaHelper.JavaScriptHelper(driver);
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
		javaHelper.JSEClick(reviewerObj.reviewerAlertSubmitButton());
		waitHelper.waitForElement(driver, 3000, reviewerObj.approvalStatus());
		Assert.assertTrue(reviewerObj.approvalStatus().isDisplayed());
	}

	// CHECKER - REJECTING

	@Then("^the claim option button$")
	public void the_claim_option_button() throws Throwable {
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		waitHelper.waitForElement(driver, 10000,
				driver.findElement(By.xpath(before_xpath + json.readReferancedata() + after_xpath_claim)));
		driver.findElement(By.xpath(before_xpath + json.readReferancedata() + after_xpath_claim)).click();
		waitHelper.waitForElement(driver, 2000, kubsChecker.checker_alert_close());
		kubsChecker.checker_alert_close().click();
	}

	@And("^Onclick the checker notification icon in checker$")
	public void onclick_the_checker_notification_icon_in_checker() throws Throwable {
		javaHelper = new JavascriptHelper();
		waitHelper.waitForElement(driver, 3000, kubsChecker.checkerNotificationIcon());
		javaHelper.JavaScriptHelper(driver);
		javaHelper.JSEClick(kubsChecker.checkerNotificationIcon());

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
		waitHelper.waitForElement(driver, 2000, kubsChecker.checkerApproveButton());
		kubsChecker.checkerApproveButton().click();
		waitHelper.waitForElement(driver, 2000, kubsChecker.checkerRemarks());
		kubsChecker.checkerRemarks().sendKeys("ok");
		waitHelper.waitForElement(driver, 2000, kubsChecker.checkersubmitButton());
		kubsChecker.checkersubmitButton().click();
		waitHelper.waitForElement(driver, 3000, kubsChecker.Popup_status());
		String Notification = kubsChecker.Popup_status().getText();
		System.out.println("System Should Display Notification: " + Notification);
	}

	/*
	 * 
	 * KUBS_Checker_Approve_BP_BC_05_06
	 * 
	 */

	@Then("^Choose current Budget Code$")
	public void Choose_current_Budget_Code() throws Throwable {
		requestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(requestAndAllocationTestData.BudgetCode);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
	}

	@And("^Choose one Branch in branch field$")
	public void Choose_one_Branch_in_branch_field() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_type6());
		requestAndAllocation.requestAndAllocation_branch_type6().click();
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
		requestAndAllocationBudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgettype());
		String budgettype = requestAndAllocation.budget_requestAndAllocation_Budgettype().getText();
		requestAndAllocationBudtype = jsonReader.getBudtypeByName(budgettype);
		javaHelper.JavaScriptHelper(driver);
		if (budgettype.equalsIgnoreCase("YEARLY")) {
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JavaScriptHelper(driver);
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyearly());
			requestAndAllocation.budget_requestAndAllocation_Budgetyearly()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetremark()
					.sendKeys(requestAndAllocationTestData.Remark);
		} else if (budgettype.equalsIgnoreCase("MONTHLY")) {

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
			// javahelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7());

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
			javaHelper.JavaScriptHelper(driver);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			// javahelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
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


	// Reviewer

	@And("^Click Reviewer Action button icon$")
	public void Click_Reviewer_Action_button_icon() throws Throwable {
		javaHelper.JavaScriptHelper(driver);
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
		javaHelper.JSEClick(reviewerObj.reviewerAlertSubmitButton());
		waitHelper.waitForElement(driver, 3000, reviewerObj.approvalStatus());
		Assert.assertTrue(reviewerObj.approvalStatus().isDisplayed());
	}

	// CHECKER - REJECTING

	@Then("^Click to the claim option button$")
	public void Click_to_the_claim_option_button() throws Throwable {
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		waitHelper.waitForElement(driver, 10000,
				driver.findElement(By.xpath(before_xpath + json.readReferancedata() + after_xpath_claim)));
		driver.findElement(By.xpath(before_xpath + json.readReferancedata() + after_xpath_claim)).click();
		waitHelper.waitForElement(driver, 2000, kubsChecker.checker_alert_close());
		kubsChecker.checker_alert_close().click();
	}

	@And("^Click on the checker notification icon in checker$")
	public void Click_on_the_checker_notification_icon_in_checker() throws Throwable {
		javaHelper = new JavascriptHelper();
		waitHelper.waitForElement(driver, 3000, kubsChecker.checkerNotificationIcon());
		javaHelper.JavaScriptHelper(driver);
		javaHelper.JSEClick(kubsChecker.checkerNotificationIcon());
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
		waitHelper.waitForElement(driver, 2000, kubsChecker.checkerApproveButton());
		kubsChecker.checkerApproveButton().click();
	}

	@Then("^Submit the Approve Record in checker$")
	public void Submit_the_Approve_Record_in_checker() throws Throwable {
		waitHelper.waitForElement(driver, 2000, kubsChecker.checkerRemarks());
		kubsChecker.checkerRemarks().sendKeys("ok");
		waitHelper.waitForElement(driver, 2000, kubsChecker.checkersubmitButton());
		kubsChecker.checkersubmitButton().click();
		waitHelper.waitForElement(driver, 3000, kubsChecker.Popup_status());
		Assert.assertTrue(kubsChecker.Popup_status().isDisplayed());
	}

	/*
	 *
	 * KUBS_Checker_Rejecting_BP_BC_05_07
	 *
	 */

	@Then("^Select current Budget Code$")
	public void selectCurrentBudgetCode() throws Throwable {
		requestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(requestAndAllocationTestData.BudgetCode);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
	}


	@And("^Select one Branch in branch field$")
	public void selectOneBranchInBranchField() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_type7());
		requestAndAllocation.requestAndAllocation_branch_type7().click();
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
		requestAndAllocationBudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgettype());
		String budgettype = requestAndAllocation.budget_requestAndAllocation_Budgettype().getText();
		requestAndAllocationBudtype = jsonReader.getBudtypeByName(budgettype);
		javaHelper.JavaScriptHelper(driver);
		if (budgettype.equalsIgnoreCase("YEARLY")) {
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JavaScriptHelper(driver);
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyearly());
			requestAndAllocation.budget_requestAndAllocation_Budgetyearly()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetremark()
					.sendKeys(requestAndAllocationTestData.Remark);
		} else if (budgettype.equalsIgnoreCase("MONTHLY")) {

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
			// javahelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7());

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
			javaHelper.JavaScriptHelper(driver);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			// javahelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
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


	// Reviewer

	@And("^Click on Reviewer Action button icon$")
	public void clickOnReviewerActionButtonIcon() throws Throwable {
		javaHelper.JavaScriptHelper(driver);
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
		javaHelper.JSEClick(reviewerObj.reviewerAlertSubmitButton());
		waitHelper.waitForElement(driver, 3000, reviewerObj.approvalStatus());
		Assert.assertTrue(reviewerObj.approvalStatus().isDisplayed());
	}

	// CHECKER - REJECTING

	@Then("^Click the claim option button$")
	public void clickTheClaimOptionButton() throws Throwable {
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		waitHelper.waitForElement(driver, 10000,
				driver.findElement(By.xpath(before_xpath + json.readReferancedata() + after_xpath_claim)));
		driver.findElement(By.xpath(before_xpath + json.readReferancedata() + after_xpath_claim)).click();
		waitHelper.waitForElement(driver, 2000, kubsChecker.checker_alert_close());
		kubsChecker.checker_alert_close().click();
	}

	@And("^Click on checker notification icon in checker$")
	public void clickOnCheckerNotificationIconInChecker() throws Throwable {
		javaHelper = new JavascriptHelper();
		waitHelper.waitForElement(driver, 3000, kubsChecker.checkerNotificationIcon());
		javaHelper.JavaScriptHelper(driver);
		javaHelper.JSEClick(kubsChecker.checkerNotificationIcon());
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
		waitHelper.waitForElement(driver, 2000, kubsChecker.checkerRejectButton());
		kubsChecker.checkerRejectButton().click();
	}

	@Then("^Submit the Reject Record in checker$")
	public void submitTheRejectRecordInChecker() throws Throwable {
		waitHelper.waitForElement(driver, 2000, kubsChecker.checkerRemarks());
		kubsChecker.checkerRemarks().sendKeys("ok");
		// waitHelper.waitForElement(driver, 10000, kubschecker.checkersubmitButton());
		kubsChecker.checkersubmitButton().click();
		waitHelper.waitForElementVisible(kubsChecker.Popup_status(), 2000, 2000);
		String Notification = kubsChecker.Popup_status().getText();
		System.out.println("Notification is: " + Notification);
		Assert.assertTrue(kubsChecker.Popup_status().isDisplayed());
	}

	/*
	 *
	 * KUBS_Authorizationstatus_BP_BC_05_08
	 *
	 */

	@Then("^Choose one current Budget Code$")
	public void choose_one_current_budget_code() throws Throwable {
		requestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(requestAndAllocationTestData.BudgetCode);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
	}

	@And("^Choose Branch branch field$")
	public void choose_branch_branch_field() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_type8());
		requestAndAllocation.requestAndAllocation_branch_type8().click();
	}

	@And("^Enter Amount for Budget Type Show in Budget type field$")
	public void enter_amount_for_budget_type_show_in_budget_type_field() throws Throwable {
		requestAndAllocationBudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgettype());
		String budgettype = requestAndAllocation.budget_requestAndAllocation_Budgettype().getText();
		requestAndAllocationBudtype = jsonReader.getBudtypeByName(budgettype);
		javaHelper.JavaScriptHelper(driver);
		if (budgettype.equalsIgnoreCase("YEARLY")) {
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JavaScriptHelper(driver);
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyearly());
			requestAndAllocation.budget_requestAndAllocation_Budgetyearly()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetremark()
					.sendKeys(requestAndAllocationTestData.Remark);
		} else if (budgettype.equalsIgnoreCase("MONTHLY")) {

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
			// javahelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7());

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
			javaHelper.JavaScriptHelper(driver);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			// javahelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
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

	@Then("^Choose Any Need currency$")
	public void choose_any_need_currency() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Amountcurruncy());
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().click();
		// requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.DOWN);
		requestAndAllocation.budget_requestAndAllocation_Amountcurruncy().sendKeys(Keys.ENTER);
	}


	// REVIEWER

	@And("^Click on the Reviewer Action button icon$")
	public void click_on_the_reviewer_action_button_icon() throws Throwable {
		javaHelper.JavaScriptHelper(driver);
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
		javaHelper.JSEClick(reviewerObj.reviewerAlertSubmitButton());
		waitHelper.waitForElement(driver, 3000, reviewerObj.approvalStatus());
		Assert.assertTrue(reviewerObj.approvalStatus().isDisplayed());
	}

	// CHECKER

	@Then("^Click to claim option button$")
	public void click_to_claim_option_button() throws Throwable {
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		waitHelper.waitForElement(driver, 10000,
				driver.findElement(By.xpath(before_xpath + json.readReferancedata() + after_xpath_claim)));
		driver.findElement(By.xpath(before_xpath + json.readReferancedata() + after_xpath_claim)).click();
		waitHelper.waitForElement(driver, 2000, kubsChecker.checker_alert_close());
		kubsChecker.checker_alert_close().click();
	}

	@And("^Click the checker notification icon in checker$")
	public void click_the_checker_notification_icon_in_checker() throws Throwable {
		javaHelper = new JavascriptHelper();
		waitHelper.waitForElement(driver, 3000, kubsChecker.checkerNotificationIcon());
		javaHelper.JavaScriptHelper(driver);
		javaHelper.JSEClick(kubsChecker.checkerNotificationIcon());
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
		waitHelper.waitForElement(driver, 2000, kubsChecker.checkerApproveButton());
		kubsChecker.checkerApproveButton().click();
	}

	@Then("^Submit to the Approve Record in checker$")
	public void submit_to_the_approve_record_in_checker() throws Throwable {
		waitHelper.waitForElement(driver, 2000, kubsChecker.checkerRemarks());
		kubsChecker.checkerRemarks().sendKeys("ok");
		waitHelper.waitForElement(driver, 2000, kubsChecker.checkersubmitButton());
		kubsChecker.checkersubmitButton().click();

	}

	@And("^Capture the Authorization status$")
	public void capture_the_authorization_status() throws Throwable {
		waitHelper.waitForElement(driver, 3000, kubsChecker.Popup_status());
		String data = kubsChecker.Popup_status().getText();
		System.out.println("Authorization Status: " + data);
		Assert.assertTrue(kubsChecker.Popup_status().isDisplayed());

	}

	/*
	 *
	 * KUBS_Checker_Send_Notification_to_Maker_BP_BC_05_09
	 *
	 */

	@Then("^Choose New Budget Code$")
	public void Choose_New_Budget_Code() throws Throwable {
		requestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetcode());
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(requestAndAllocationTestData.BudgetCode);
		requestAndAllocation.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);
	}

	@And("^Onclick one Branch in branch field$")
	public void Onclick_one_Branch_in_branch_field() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.requestAndAllocation_branch_type9());
		requestAndAllocation.requestAndAllocation_branch_type9().click();
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
		requestAndAllocationBudtype = new BUDGET_RequestandallocationBUDTYPEDATA();
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgettype());
		String budgettype = requestAndAllocation.budget_requestAndAllocation_Budgettype().getText();
		requestAndAllocationBudtype = jsonReader.getBudtypeByName(budgettype);
		javaHelper.JavaScriptHelper(driver);
		if (budgettype.equalsIgnoreCase("YEARLY")) {
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			javaHelper.JavaScriptHelper(driver);
			javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetyearly());
			requestAndAllocation.budget_requestAndAllocation_Budgetyearly()
					.sendKeys(requestAndAllocationBudtype.BudgetAmounT);
			requestAndAllocation.budget_requestAndAllocation_Budgetremark()
					.sendKeys(requestAndAllocationTestData.Remark);
		} else if (budgettype.equalsIgnoreCase("MONTHLY")) {

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
			// javahelper.scrollIntoViewAndClick(requestAndAllocation.budget_requestAndAllocation_Budgetmonthremark7());

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
			javaHelper.JavaScriptHelper(driver);
			waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
			// javahelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
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


	// Reviewer

	@And("^OnClick Reviewer Action button icon$")
	public void OnClick_Reviewer_Action_button_icon() throws Throwable {
		javaHelper.JavaScriptHelper(driver);
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
		javaHelper.JSEClick(reviewerObj.reviewerAlertSubmitButton());
		waitHelper.waitForElement(driver, 3000, reviewerObj.approvalStatus());
		Assert.assertTrue(reviewerObj.approvalStatus().isDisplayed());
	}

	// CHECKER - REJECTING

	@Then("^OnClick to the claim option button$")
	public void OnClick_to_the_claim_option_button() throws Throwable {
		String before_xpath = "//span[contains(text(),'";
		String after_xpath_claim = "')]/parent::div/parent::datatable-body-cell/preceding-sibling::datatable-body-cell[2]/div/ion-buttons/ion-button";
		waitHelper.waitForElement(driver, 10000,
				driver.findElement(By.xpath(before_xpath + json.readReferancedata() + after_xpath_claim)));
		driver.findElement(By.xpath(before_xpath + json.readReferancedata() + after_xpath_claim)).click();
		waitHelper.waitForElement(driver, 2000, kubsChecker.checker_alert_close());
		kubsChecker.checker_alert_close().click();
	}

	@And("^OnClick on the checker notification icon in checker$")
	public void OnClick_on_the_checker_notification_icon_in_checker() throws Throwable {
		javaHelper = new JavascriptHelper();
		waitHelper.waitForElement(driver, 3000, kubsChecker.checkerNotificationIcon());
		javaHelper.JavaScriptHelper(driver);
		javaHelper.JSEClick(kubsChecker.checkerNotificationIcon());
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
		waitHelper.waitForElement(driver, 2000, kubsChecker.checkerApproveButton());
		kubsChecker.checkerApproveButton().click();
	}

	@Then("^then Submit the Approve Record in checker$")
	public void then_Submit_the_Approve_Record_in_checker() throws Throwable {
		waitHelper.waitForElement(driver, 2000, kubsChecker.checkerRemarks());
		kubsChecker.checkerRemarks().sendKeys("ok");
		waitHelper.waitForElement(driver, 2000, kubsChecker.checkersubmitButton());
		kubsChecker.checkersubmitButton().click();
		waitHelper.waitForElement(driver, 3000, kubsChecker.Popup_status());
		Assert.assertTrue(kubsChecker.Popup_status().isDisplayed());
	}

	@Then("^Onclick Maker Notification$")
	public void onclick_maker_notification() throws Throwable {
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.makerNotificationIcon());
		requestAndAllocation.makerNotificationIcon().click();
		// Assert.assertFalse(driver.findElement(By.xpath("//span[contains(text(),'" +
		// json.readReferancedata()+ "')]")).isDisplayed());
		boolean Id = false;
		try {
			driver.findElement(By.xpath("//span[contains(text(),'" + json.readReferancedata()+ "')]")).click();
		}catch(NoSuchElementException e) {
			Id = true;
		}
		Assert.assertTrue(Id);
		
	}

	/*
	 *
	 * @KUBS_SEARCH_CRITERIA_BP_BC_11_01
	 * 
	 */

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
		requestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_Budgetcodesearch());
		requestAndAllocation.budget_requestAndAllocation_Budgetcodesearch()
				.sendKeys(requestAndAllocationTestData.SearchCode);
	}

	@And("^Click the action button$")
	public void Click_the_action_button() throws Throwable {
		// waitHelper.waitForElement(driver, 2000,
		// requestAndAllocation.budget_requestAndAllocation_Budgetaction());
		requestAndAllocationTestData = new BUDGET_RequestAndAllocationTestDataType();
		requestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		String befr_action = "//span[contains(text(),'";
		String aftr_action = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button";
		waitHelper.waitForElement(driver, 5000,
				driver.findElement(By.xpath(befr_action + requestAndAllocationTestData.SearchCode + aftr_action)));
		driver.findElement(By.xpath(befr_action + requestAndAllocationTestData.SearchCode + aftr_action)).click();

	}

	@Then("^Capture the code is displayed$")
	public void Capture_the_code_is_displayed() throws Throwable {
		javaHelper.JavaScriptHelper(driver);
		String budgetCode = (String) javaHelper
				.executeScript("return document.getElementsByClassName('ng-value-label')[0].innerText");
		System.out.println("Budget Code " + budgetCode);
	}

	/*
	 * 
	 * KUBS_SEARCH_CRITERIA_MODIFICATION_BP_BC_19_01
	 * 
	 */

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
		requestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		waitHelper.waitForElement(driver, 2000, requestAndAllocation.budget_requestAndAllocation_Budgetcodesearch());
		requestAndAllocation.budget_requestAndAllocation_Budgetcodesearch()
				.sendKeys(requestAndAllocationTestData.SearchCode);
	}

	@And("^Click action button$")
	public void Click_action_button() throws Throwable {
		// waitHelper.waitForElement(driver, 2000,
		// requestAndAllocation.budget_requestAndAllocation_Budgetaction());
		requestAndAllocationTestData = new BUDGET_RequestAndAllocationTestDataType();
		requestAndAllocationTestData = jsonReader.getAllowcationByName("Maker");
		String befr_action = "//span[contains(text(),'";
		String aftr_action = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell/div/ion-buttons/ion-button";
		waitHelper.waitForElement(driver, 2000,
				driver.findElement(By.xpath(befr_action + requestAndAllocationTestData.SearchCode + aftr_action)));
		driver.findElement(By.xpath(befr_action + requestAndAllocationTestData.SearchCode + aftr_action)).click();
		String befr_code = "//span[contains(text(),'";
		String aftr_code = "')]";
		waitHelper.waitForElement(driver, 2000,
				driver.findElement(By.xpath(befr_code + requestAndAllocationTestData.SearchCode + aftr_code)));
		driver.findElement(By.xpath(befr_code + requestAndAllocationTestData.SearchCode + aftr_code)).isDisplayed();
	}

	@Then("^Capture the code$")
	public void Capture_the_code() throws Throwable {
		javaHelper.JavaScriptHelper(driver);
		String budgetCode = (String) javaHelper
				.executeScript("return document.getElementsByClassName('ng-value-label')[0].innerText");
		System.out.println("Budget Code " + budgetCode);
	}

	@And("^Modify the Code$")
	public void Modify_the_Code() throws Throwable {

		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javaHelper.scrollToElemet(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		javaHelper.JSEClick(requestAndAllocation.budget_requestAndAllocation_Budgetamount());
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_BudgetHy2());
		requestAndAllocation.budget_requestAndAllocation_BudgetHy2()
				.sendKeys(requestAndAllocationTestData.Searchamount);
	}

	@And("^After modify click save button$")
	public void after_modify_click_save_button() throws Throwable {
		waitHelper.waitForElement(driver, 3000, requestAndAllocation.budget_requestAndAllocation_AllowSave());
		requestAndAllocation.budget_requestAndAllocation_AllowSave().click();

	}
}
