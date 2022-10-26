package stepdefinitions;

import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import dataProvider.ConfigFileReader;
import dataProvider.JsonConfig;
import helper.BrowserHelper;
import helper.ClicksAndActionsHelper;
import helper.JavascriptHelper;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.BUDGET_BudgetCreationObj;
import pageobjects.BUDGET_RequestAndAllocationObj;
import pageobjects.KUBS_CheckerObj;
import pageobjects.KUBS_MakerObj;
import pageobjects.KUBS_ReviewerObj;
import pageobjects.MASTERREPORT_BudgetCodeReportObj;
import resources.BaseClass;
import resources.JsonDataReaderWriter;
import testDataType.BUDGET_BudgetDefinitionUATTestDataType;

public class BUDGET_UAT_BudgetDefinition extends BaseClass {
	WebDriver driver = BaseClass.driver;
	KUBS_Login kubsLogin = new KUBS_Login(driver);
	String user = "Maker";
	ConfigFileReader configFileReader = new ConfigFileReader();
	JavascriptHelper javascriptHelper = new JavascriptHelper();
	JsonConfig jsonConfig = new JsonConfig();
	KUBS_MakerObj kubsMakerObj = new KUBS_MakerObj(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	BUDGET_BudgetDefinitionUATTestDataType budgetDefinitionUATTestData = jsonConfig
			.getUATBudgetDefinitionTestData(user);
	BUDGET_BudgetCreationObj budgetCreationObj = new BUDGET_BudgetCreationObj(driver);
	JsonDataReaderWriter jsonReaderWriter = new JsonDataReaderWriter();
	KUBS_ReviewerObj kubsReviewerObj = new KUBS_ReviewerObj(driver);
	KUBS_CheckerObj kubsCheckerObj = new KUBS_CheckerObj(driver);
	ClicksAndActionsHelper clickAndActions = new ClicksAndActionsHelper(driver);
	BrowserHelper browserHelper = new BrowserHelper(driver);
	Map<String, String> testData = new HashMap<>();
	BUDGET_RequestAndAllocationObj requestAndAllocationObj = new BUDGET_RequestAndAllocationObj(driver);

	@Given("^navigate to given url and login with maker credentials$")
	public void navigate_to_given_url() throws Throwable {
		/*
		 * This function used to open the chrome browser and lauch the URL we want to
		 * test
		 */
		driver.get(configFileReader.getApplicationUrl());
		// loginToAzentioApp is already written function, Which is written inside the
		// same step definition package className: KUBS_Login
		kubsLogin.loginToAzentioApp(user);
		javascriptHelper.JavaScriptHelper(driver);

	}

	@Then("^click on budget configuration menu$")
	public void click_on_budget_configuration_menu() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsMakerObj.kubsBudgetConfiguration(), 60, 500);
		/*
		 * This step is to click the budget configuration main menu after login to the
		 * azentio application successfully
		 */
		kubsMakerObj.kubsBudgetConfiguration().click();

	}

	@Then("^click on eye icon which is near by budget definition submenu$")
	public void click_on_eye_icon_which_is_near_by_budget_definition_submenu() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_EyeIcon(), 60, 500);
		budgetCreationObj.budgetCreation_EyeIcon().click();

	}

	@And("^click on add button to create budget code$")
	public void click_on_add_button_to_create_budget_code() throws Throwable {
		/*
		 * In this below step is used to click on the action button , Javascript locator
		 * is used instead of xpath Javascript Locator :
		 * document.getElementById('addBtn')
		 */
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_AddButton(), 60, 500);
		// budgetCreationObj.budgetCreation_AddButton().click();
		for (int i = 0; i <= 10; i++) {
			try {
				clickAndActions.moveToElement(budgetCreationObj.budgetCreation_AddButton());
				clickAndActions.doubleClick(budgetCreationObj.budgetCreation_AddButton());
				waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_BudgetCode(),
						5, 500);
				Assert.assertTrue(budgetCreationObj.budgetCreation_BudgetCode().isDisplayed());
				break;
			} catch (Exception e) {
				if (i == 10) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	/*
	 * Coming below 14 steps helps us to enter our test data like budget code and
	 * budget name in to the appropriate fields we have separate budget name for
	 * every budget type
	 */
	@Then("^enter Budget Code for yearly budget$")
	public void enter_budget_code_for_yearly_budget() throws Throwable {

		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_BudgetCode(), 60,
				500);
		budgetCreationObj.budgetCreation_BudgetCode().sendKeys(budgetDefinitionUATTestData.uatYearlyBudgetCode);

	}

	@Then("^enter the budget code  to make current/future financial budget$")
	public void enter_the_budget_code_to_make_current_financial_budget() throws Throwable {
		// String budgetPrefix="BUD";
		Random random = new Random();
		int randomNumber = random.nextInt(999999 - 100000) + 100000;
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_BudgetCode(), 60,
				500);
		budgetCreationObj.budgetCreation_BudgetCode()
				.sendKeys(budgetDefinitionUATTestData.BudgetCodePrefix + randomNumber);

	}

	@Then("^fill the budget code field$")
	public void fill_the_budget_code_field() throws Throwable {
		Random random = new Random();
		int randomNumber = random.nextInt(999999 - 100000) + 100000;
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_BudgetCode(), 60,
				500);
		budgetCreationObj.budgetCreation_BudgetCode()
				.sendKeys(budgetDefinitionUATTestData.BudgetCodePrefix + randomNumber);
	}

	@Then("^enter Budget Code for current financial yearly budget$")
	public void enter_budget_code_for_current_financial_yearly_budget() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_BudgetCode(), 60,
				500);
		budgetCreationObj.budgetCreation_BudgetCode()
				.sendKeys(budgetDefinitionUATTestData.uatCurrentFinancialBudgetCode);
	}

	@Then("^enter Budget Code for monthly budget$")
	public void enter_budget_code_for_monthly_budget() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_BudgetCode(), 60,
				500);
		budgetCreationObj.budgetCreation_BudgetCode().sendKeys(budgetDefinitionUATTestData.uatMonthlyBudgetCode);

	}

	@Then("^enter Budget Code for half yearly budget$")
	public void enter_budget_code_for_half_yearly_budget() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_BudgetCode(), 60,
				500);
		budgetCreationObj.budgetCreation_BudgetCode().sendKeys(budgetDefinitionUATTestData.uatHalfYearlyBudgetCode);

	}

	@Then("^enter Budget Code quarterly budget$")
	public void enter_budget_code_for_quarterly_budget() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_BudgetCode(), 60,
				500);
		budgetCreationObj.budgetCreation_BudgetCode().sendKeys(budgetDefinitionUATTestData.uatQuarterlyBudgetCode);

	}

	@And("^choose yearly option in budget type$")
	public void choose_yearly_option_in_budget_type() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_BudgetType(), 60,
				500);
		budgetCreationObj.budgetCreation_BudgetType().click();
		budgetCreationObj.budgetCreation_BudgetType().sendKeys(Keys.DOWN);
		budgetCreationObj.budgetCreation_BudgetType().sendKeys(Keys.DOWN);
		budgetCreationObj.budgetCreation_BudgetType().sendKeys(Keys.DOWN);
		budgetCreationObj.budgetCreation_BudgetType().sendKeys(Keys.ENTER);

	}

	@And("^choose monthly option in budget type$")
	public void choose_monthly_option_in_budget_type() throws Throwable {
		budgetCreationObj.budgetCreation_BudgetType().click();
		budgetCreationObj.budgetCreation_BudgetType().sendKeys(Keys.DOWN);
		budgetCreationObj.budgetCreation_BudgetType().sendKeys(Keys.ENTER);

	}

	@And("^choose Quarterly option in budget type$")
	public void choose_quarterly_option_in_budget_type() throws Throwable {
		budgetCreationObj.budgetCreation_BudgetType().click();
		budgetCreationObj.budgetCreation_BudgetType().sendKeys(Keys.DOWN);
		budgetCreationObj.budgetCreation_BudgetType().sendKeys(Keys.DOWN);
		budgetCreationObj.budgetCreation_BudgetType().sendKeys(Keys.ENTER);
	}

	@And("^choose half yearly option in budget type$")
	public void choose_half_yearly_option_in_budget_type() throws Throwable {
		budgetCreationObj.budgetCreation_BudgetType().click();
		budgetCreationObj.budgetCreation_BudgetType().sendKeys(Keys.ENTER);
	}

	@And("^give warning percentage$")
	public void give_warning_percentage() throws Throwable {
		budgetCreationObj.budgetCreation_WarningPercentage().sendKeys(budgetDefinitionUATTestData.warningPecentage);
	}

	@And("^enter budget name for yearly budget$")
	public void enter_budget_name_for_yearly_budget() throws Throwable {
		budgetCreationObj.budgetCreation_BudgetName().sendKeys(budgetDefinitionUATTestData.uatYearlyBudgetType);
	}

	@And("^enter budget name for monthly budget$")
	public void enter_budget_name_for_monthly_budget() throws Throwable {
		budgetCreationObj.budgetCreation_BudgetName().sendKeys(budgetDefinitionUATTestData.uatMonthlyBudgetType);
	}

	@And("^enter budget name for Quarterly budget$")
	public void enter_budget_name_for_quarterly_budget() throws Throwable {
		budgetCreationObj.budgetCreation_BudgetName().sendKeys(budgetDefinitionUATTestData.uatQuarterlyBudgetType);
	}

	@And("^enter budget name for half yearly$")
	public void enter_budget_name_for_half_yearly() throws Throwable {
		budgetCreationObj.budgetCreation_BudgetName().sendKeys(budgetDefinitionUATTestData.uatHalfYearlyBudgetType);
	}

	@Then("^enter remark$")
	public void enter_remark() throws Throwable {
		budgetCreationObj.budgetCreation_Remarks().sendKeys(budgetDefinitionUATTestData.remark);

	}

	/*
	 * After enter all the test data in appropriate text box the we have to click on
	 * the save button This below method help us to click on the save button
	 */
	@Then("^click on Save button$")
	public void click_on_save_button() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_saveButton(), 60,
				500);
		budgetCreationObj.budgetCreation_saveButton().click();
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_ReviewerId(), 10, 1);
		System.out.println(budgetCreationObj.budgetCreation_ReviewerId().getText());
	Assert.assertEquals(budgetCreationObj.budgetCreation_ReviewerId().getText(), "Saved successfully, Workflow initiated kindly submit record from inbox");
	waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreationAlertClose(), 10, 1);
	budgetCreationObj.budgetCreationAlertClose().click();
	}

	@And("^enter the budget code for current financial year$")
	public void enter_the_budget_code_for_current_financial_year() throws Throwable {
		requestAndAllocationObj.budget_requestAndAllocation_Budgetcode().click();
		requestAndAllocationObj.budget_requestAndAllocation_Budgetcode()
				.sendKeys(budgetDefinitionUATTestData.uatCurrentFinancialBudgetCode);
		requestAndAllocationObj.budget_requestAndAllocation_Budgetcode().sendKeys(Keys.ENTER);

	}

	@And("^choose the budget year as current financial year$")
	public void choose_the_budget_year_as_current_financial_year() throws Throwable {
		requestAndAllocationObj.budget_requestAndAllocation_Budgetyear().click();
		requestAndAllocationObj.budget_requestAndAllocation_Budgetyear().sendKeys(Keys.ENTER);
	}

	@And("^choose branch as azentio main$")
	public void choose_branch_as_azentio_main() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		requestAndAllocationObj.budget_requestAndAllocation_Budgetbranch().click();
		// javascriptHelper.scrollIntoViewAndClick(requestAndAllocationObj.budgetBudgetReqAndAllocationAzentMainBranch());
		// requestAndAllocationObj.budgetBudgetReqAndAllocationAzentMainBranch().click();
		requestAndAllocationObj.budget_requestAndAllocation_branchOK().click();
	}

	@And("^enter the budget amount in the appropriate text box along with remark$")
	public void enter_the_budget_amount_in_the_appropriate_text_box_along_with_remark() throws Throwable {
		requestAndAllocationObj.budget_requestAndAllocation_Budgetamount().click();
		requestAndAllocationObj.budget_requestAndAllocation_Budgetamount().sendKeys("1000000");
	}

	@And("^click notification button$")
	public void click_notification_button() throws Throwable {
		// After save our budget record we have to click on notification to submit our
		// record for approvals
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreationNotificationIcon(), 60,
				100);
		budgetCreationObj.budgetCreationNotificationIcon().click();
//		Thread.sleep(1000);

	}

	@Then("^choose first record in the notification record$")
	public void choose_first_record_in_the_notification_record() throws Throwable {
		/*
		 * After click on notification we can see the record which we saved now and we
		 * have to select that along with the records reference ID We have to store the
		 * reference ID into the JSon file so that we can call the data in reviewer and
		 * checker stage
		 */
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreationFirstReferenceId(), 60,
				500);
		String referenceID = budgetCreationObj.budgetCreationFirstReferenceId().getText();
		/*
		 * addReferanceData(referenceID) This method is a predefined method to store the
		 * reference ID into the Json file
		 */
		jsonReaderWriter.addReferanceData(referenceID);
		budgetCreationObj.budgetCreationFirstRecord().click();

	}

	@Then("^click on the search button$")
	public void click_on_the_search_button() throws Throwable {
		waitHelper.waitForElementVisible(budgetCreationObj.notificationSearchIcon(), 3000, 300);
//		javascriptHelper.JavaScriptHelper(driver);
//		javascriptHelper.JSEClick( budgetCreationObj.notificationSearchIcon());
		for(int i=0;i<=15;i++)
		{
		try
		{
		budgetCreationObj.notificationSearchIcon().click();
		break;
		}
		catch(Exception e)
		{
			if(i==15)
			{
				Assert.fail(e.getMessage());
			}
		}
		}
	}

	@And("^serach the budget defenition sub module name$")
	public void serach_the_budget_defenition_sub_module_name() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.eventCode(), 30, 500);
		budgetCreationObj.eventCode().click();
		budgetCreationObj.eventCode().sendKeys(budgetDefinitionUATTestData.budgetDefenitionEventCode);
	}

	@And("^serach the budget request and allocation sub module name$")
	public void serach_the_budget_request_and_allocation_sub_module_name() throws Throwable {
		waitHelper.waitForElementVisible(budgetCreationObj.eventCode(), 3000, 300);
		budgetCreationObj.eventCode().click();
		budgetCreationObj.eventCode().sendKeys(budgetDefinitionUATTestData.budgetRequestAndAllocationEventCode);
	}

	@And("^serach the budget supplimentory sub module name$")
	public void serach_the_budget_supplimentory_sub_module_name() throws Throwable {
		waitHelper.waitForElementVisible(budgetCreationObj.eventCode(), 3000, 300);
		budgetCreationObj.eventCode().click();
		budgetCreationObj.eventCode().sendKeys(budgetDefinitionUATTestData.budgetSupplimentoryEventCode);
	}

	@And("^click on Submit button$")
	public void click_on_submit_button() throws Throwable {
		// After select the record we have to submit the record for approval
		waitHelper.waitForElement(driver, 3000, budgetCreationObj.budgetCreation_SubmitButton());
		budgetCreationObj.budgetCreation_SubmitButton().click();

	}

	@Then("^enter remark in confirmation alert$")
	public void enter_remark_in_confirmation_alert() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreation_AlertRemarks(), 60,
				500);
		javascriptHelper.JSEClick(budgetCreationObj.budgetCreation_AlertRemarks());
		/*
		 * After click on submit button one alert will open we have to enter the alert
		 * remark And click on the submit button
		 */
		budgetCreationObj.budgetCreation_AlertRemarks().sendKeys(budgetDefinitionUATTestData.remark);

	}

	@Then("^click on submit button in alert$")
	public void click_on_submit_button_in_alert() throws Throwable {
		try {
			budgetCreationObj.budgetCreation_AlertsubmitButton().click();
		} catch (ElementClickInterceptedException clickException) {
//			Thread.sleep(1000);
			budgetCreationObj.budgetCreation_AlertRemarks().click();
			budgetCreationObj.budgetCreation_AlertRemarks().sendKeys(budgetDefinitionUATTestData.remark);
			budgetCreationObj.budgetCreation_AlertsubmitButton().click();
		}
	}

	@And("^capture the reviewer ID in pop up which is open when we submit our record in maker stage$")
	public void capture_the_reviewer_id_in_pop_up_which_is_open_when_we_submit_our_record_in_maker_stage()
			throws Throwable {
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
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreationLogoutButton(), 90,
				500);
		clickAndActions.moveToElement(budgetCreationObj.budgetCreationLogoutButton());
		budgetCreationObj.budgetCreationLogoutButton().click();
	}

	/*
	 * ******************************** Reviewer steps
	 * ************************************
	 */
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
		javascriptHelper.JavaScriptHelper(driver);
		String before_xpath = "//span[contains(text(),'";
		String after_xpath = "')]/ancestor::datatable-body-cell/preceding-sibling::datatable-body-cell//ion-button";
		for (int i = 0; i <= 300; i++) {
			try {
				waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsReviewerObj.reviewerNotidicationIcon(), 60, 500);
				kubsReviewerObj.reviewerNotidicationIcon().click();
				waitHelper.waitForElement(driver, 3000, driver
						.findElement(By.xpath(before_xpath + jsonReaderWriter.readReferancedata() + after_xpath)));
				javascriptHelper.JSEClick(driver
						.findElement(By.xpath(before_xpath + jsonReaderWriter.readReferancedata() + after_xpath)));
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

	@Then("^verify budget data are matched whic is submited by maker$")
	public void verify_budget_data_are_matched_whic_is_submited_by_maker() throws Throwable {

		/*
		 * After select the record we have to verify the details which is matched with
		 * maker submitted data we can use java script locator for locating the budget
		 * code and etc
		 */
//		Thread.sleep(2000);

		while (true) {
			try {
				javascriptHelper.JavaScriptHelper(driver);
				waitHelper.setImplicitWait(5000);

				String budgetCode = (String) javascriptHelper.executeScript(
						"return document.getElementsByClassName('native-input sc-ion-input-md')[1].value");
				String budgetType = kubsReviewerObj.budgetType().getText();
				String warningPercentage = (String) javascriptHelper.executeScript(
						"return document.getElementsByClassName('native-input sc-ion-input-md')[2].value");
				String budgetname = (String) javascriptHelper.executeScript(
						"return document.getElementsByClassName('native-input sc-ion-input-md')[3].value");
				String budgetRemark = (String) javascriptHelper.executeScript(
						"return document.getElementsByClassName('native-input sc-ion-input-md')[4].value");

				if (budgetType.equalsIgnoreCase("YEARLY")) {
					Assert.assertEquals(budgetname, budgetDefinitionUATTestData.uatYearlyBudgetType);
					Assert.assertEquals(budgetCode, budgetDefinitionUATTestData.uatYearlyBudgetCode);
				} else if (budgetType.equalsIgnoreCase("HALFYEARLY")) {
					Assert.assertEquals(budgetname, budgetDefinitionUATTestData.uatHalfYearlyBudgetType);
					Assert.assertEquals(budgetCode, budgetDefinitionUATTestData.uatHalfYearlyBudgetCode);
				} else if (budgetType.equalsIgnoreCase("MONTHLY")) {
					Assert.assertEquals(budgetname, budgetDefinitionUATTestData.uatMonthlyBudgetType);
					Assert.assertEquals(budgetCode, budgetDefinitionUATTestData.uatMonthlyBudgetCode);

				} else if (budgetType.equalsIgnoreCase("QUARTERLY")) {
					Assert.assertEquals(budgetname, budgetDefinitionUATTestData.uatQuarterlyBudgetType);
					Assert.assertEquals(budgetCode, budgetDefinitionUATTestData.uatQuarterlyBudgetCode);
				}

				Assert.assertEquals(warningPercentage, budgetDefinitionUATTestData.warningPecentage);
				Assert.assertEquals(budgetRemark, budgetDefinitionUATTestData.remark);
				break;
			} catch (StaleElementReferenceException staleElement) {
				System.out.println(staleElement.getMessage());
			} catch (JavascriptException e) {

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
		kubsReviewerObj.reviewerAlertRemarks().sendKeys(budgetDefinitionUATTestData.approvalCommentsFromReviewer);
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
				kubsReviewerObj.reviewerAlertRemarks()
						.sendKeys(budgetDefinitionUATTestData.approvalCommentsFromReviewer);
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
				javascriptHelper.JavaScriptHelper(driver);
				kubsReviewerObj.reviewerAlertClose().click();
				kubsReviewerObj.reviewerUserName().click();
				waitHelper.waitForElement(driver, 3000, kubsReviewerObj.reviewerLogoutButton());
				javascriptHelper.JSEClick(kubsReviewerObj.reviewerLogoutButton());
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

		javascriptHelper.JSEClick(kubsCheckerObj.checkerActionIcon());

	}

	@Then("^verify the yearly budget approve record is available in the approved list view$")
	public void verify_the_yearly_budget_approve_record_is_available_in_the_approved_list_view() throws Throwable {
		waitHelper.waitForElementVisible(driver
				.findElement(By.xpath("//datatable-row-wrapper[1]//datatable-body-cell[2]//span[contains(text(),' "
						+ budgetDefinitionUATTestData.uatYearlyBudgetCode + " ')]")),
				2000, 200);
		Assert.assertTrue(driver
				.findElement(By.xpath("//datatable-row-wrapper[1]//datatable-body-cell[2]//span[contains(text(),' "
						+ budgetDefinitionUATTestData.uatYearlyBudgetCode + " ')]"))
				.isDisplayed());
	}

	@Then("^verify the monthly approved budget code is appeared in the list view$")
	public void verify_the_monthly_approved_budget_code_is_appeared_in_the_list_view() throws Throwable {
		waitHelper.waitForElementVisible(driver
				.findElement(By.xpath("//datatable-row-wrapper[1]//datatable-body-cell[2]//span[contains(text(),' "
						+ budgetDefinitionUATTestData.uatMonthlyBudgetCode + " ')]")),
				2000, 200);
		Assert.assertTrue(driver
				.findElement(By.xpath("//datatable-row-wrapper[1]//datatable-body-cell[2]//span[contains(text(),' "
						+ budgetDefinitionUATTestData.uatMonthlyBudgetCode + " ')]"))
				.isDisplayed());
	}

	@Then("^verify the quaterly budget approve record is available in the approved list view$")
	public void verify_the_quaterly_budget_approve_record_is_available_in_the_approved_list_view() throws Throwable {
		waitHelper.waitForElementVisible(driver
				.findElement(By.xpath("//datatable-row-wrapper[1]//datatable-body-cell[2]//span[contains(text(),' "
						+ budgetDefinitionUATTestData.uatQuarterlyBudgetCode + " ')]")),
				2000, 200);
		Assert.assertTrue(driver
				.findElement(By.xpath("//datatable-row-wrapper[1]//datatable-body-cell[2]//span[contains(text(),' "
						+ budgetDefinitionUATTestData.uatQuarterlyBudgetCode + " ')]"))
				.isDisplayed());
	}

	@Then("^verify the half yearly budget approve record is available in the approved list view$")
	public void verify_the_half_yearly_budget_approve_record_is_available_in_the_approved_list_view() throws Throwable {
		waitHelper.waitForElementVisible(driver
				.findElement(By.xpath("//datatable-row-wrapper[1]//datatable-body-cell[2]//span[contains(text(),' "
						+ budgetDefinitionUATTestData.uatHalfYearlyBudgetCode + " ')]")),
				2000, 200);
		Assert.assertTrue(driver
				.findElement(By.xpath("//datatable-row-wrapper[1]//datatable-body-cell[2]//span[contains(text(),' "
						+ budgetDefinitionUATTestData.uatHalfYearlyBudgetCode + " ')]"))
				.isDisplayed());
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
		javascriptHelper.JSEClick(kubsCheckerObj.checkerActionIcon());
		for (int i = 0; i <= 200; i++) {
			try {
//			waitHelper.waitForElementToVisibleWithFluentWait(driver,
//				driver.findElement(By.xpath(before_xpath + jsonReaderWriter.readReferancedata() + after_xpath_claim)),
//				80, 500);
				WebElement climeButton = driver
						.findElement(By.xpath(before_xpath + jsonReaderWriter.readReferancedata() + after_xpath_claim));

				boolean bool = climeButton.isDisplayed();
				clickAndActions.clickOnElement(climeButton);

				// after clicking on the clime button , clime successful message will came we

				Assert.assertTrue(bool);
				break;
			} catch (Exception e) {
				if (i == 200) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@Then("^click on Notification button$")
	public void cliick_on_notification_button() throws Throwable {
		javascriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCheckerObj.checkerAlertClose(), 80, 500);
for(int i=0;i<=15;i++)
{
		try
{
		kubsCheckerObj.checkerAlertClose().click();
break;
}
catch(Exception e)
{
if(i==15)
{
	Assert.fail(e.getMessage());
}
}
}
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCheckerObj.checkerNotificationIcon(), 60, 500);
		javascriptHelper.JSEClick(kubsCheckerObj.checkerNotificationIcon());
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
		for (int i = 0; i <= 200; i++) {
			try {
//				waitHelper.waitForElementToVisibleWithFluentWait(driver,
//						driver.findElement(By.xpath(before_xpath + jsonReaderWriter.readReferancedata() + after_xpath)),
//						100, 500);
				clickAndActions.moveToElement(driver
						.findElement(By.xpath(before_xpath + jsonReaderWriter.readReferancedata() + after_xpath)));
				clickAndActions.doubleClick(driver
						.findElement(By.xpath(before_xpath + jsonReaderWriter.readReferancedata() + after_xpath)));
				break;
			} catch (Exception e) {
				if (i == 200) {
					Assert.fail(e.getMessage());
				}
			}
		}
	}

	@And("^validate the record which is submited by maker$")
	public void validate_the_budget_record_which_is_submited_by_maker() throws Throwable {
		/*
		 * After select our record we have to verify the budget data by the help of
		 * assert statement
		 */
		for (int i = 0; i <= 30; i++) {
			try {
				waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCheckerObj.budgetType(), 60, 500);
				String budgetType = kubsCheckerObj.budgetType().getText();
				String budgetCode = (String) javascriptHelper.executeScript(
						"return document.getElementsByClassName('native-input sc-ion-input-md')[1].value");
				String warningPercentage = (String) javascriptHelper.executeScript(
						"return document.getElementsByClassName('native-input sc-ion-input-md')[2].value");
				String budgetname = (String) javascriptHelper.executeScript(
						"return document.getElementsByClassName('native-input sc-ion-input-md')[3].value");
				String budgetRemark = (String) javascriptHelper.executeScript(
						"return document.getElementsByClassName('native-input sc-ion-input-md')[4].value");

				if (budgetType.equalsIgnoreCase("YEARLY")) {
					Assert.assertEquals(budgetname, budgetDefinitionUATTestData.uatYearlyBudgetType);
					Assert.assertEquals(budgetCode, budgetDefinitionUATTestData.uatYearlyBudgetCode);
				} else if (budgetType.equalsIgnoreCase("HALFYEARLY")) {
					Assert.assertEquals(budgetname, budgetDefinitionUATTestData.uatHalfYearlyBudgetType);
					Assert.assertEquals(budgetCode, budgetDefinitionUATTestData.uatHalfYearlyBudgetCode);

				} else if (budgetType.equalsIgnoreCase("MONTHLY")) {
					Assert.assertEquals(budgetname, budgetDefinitionUATTestData.uatMonthlyBudgetType);
					Assert.assertEquals(budgetCode, budgetDefinitionUATTestData.uatMonthlyBudgetCode);

				} else if (budgetType.equalsIgnoreCase("QUARTERLY")) {
					Assert.assertEquals(budgetname, budgetDefinitionUATTestData.uatQuarterlyBudgetType);
					Assert.assertEquals(budgetCode, budgetDefinitionUATTestData.uatQuarterlyBudgetCode);
				}

				Assert.assertEquals(warningPercentage, budgetDefinitionUATTestData.warningPecentage);

				Assert.assertEquals(budgetRemark, budgetDefinitionUATTestData.remark);
				break;
			} catch (Exception e) {
				if (i == 30) {
					System.out.println(e.getMessage());

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
		javascriptHelper.JavaScriptHelper(driver);
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCheckerObj.checkerRemarks(), 60, 500);
		clickAndActions.clickOnElement(kubsCheckerObj.checkerRemarks());
		kubsCheckerObj.checkerRemarks().sendKeys(budgetDefinitionUATTestData.approvalCommentsFromChecker);
	}

	@Then("^click on submit button on alert$")
	public void click_on_submit_button_on_alert() throws Throwable {

		try {
			waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCheckerObj.checkersubmitButton(), 60, 500);
			kubsCheckerObj.checkersubmitButton().click();
		} catch (Exception e) {
			waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCheckerObj.checkerRemarks(), 60, 500);
			clickAndActions.clickOnElement(kubsCheckerObj.checkerRemarks());
			kubsCheckerObj.checkerRemarks().sendKeys(budgetDefinitionUATTestData.approvalCommentsFromChecker);
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
		Assert.assertEquals(approvalStatusForChecker, "Record approved successfully");
	}

	@Then("^logout from checker$")
	public void logout_from_checker() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCheckerObj.checkerAlertClose(), 60, 500);
		kubsCheckerObj.checkerAlertClose().click();
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCheckerObj.checkerUserName(), 60, 500);
		kubsCheckerObj.checkerUserName().click();
		waitHelper.waitForElementToVisibleWithFluentWait(driver, kubsCheckerObj.checkerLogoutButton(), 60, 500);
		clickAndActions.moveToElement(kubsCheckerObj.checkerLogoutButton());
		kubsCheckerObj.checkerLogoutButton().click();
	}

	@Then("^get the budget code budget type and transaction date$")
	public void get_the_budget_code_budget_type_and_transaction_date() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCreationObj.budgetCreationApprovedBudgetCode(),
				60, 500);
		testData.put("budgetCode", budgetCreationObj.budgetCreationApprovedBudgetCode().getText());
		testData.put("budgetType", budgetCreationObj.approvedBudgetType().getText());
		testData.put("TransactionDate", budgetCreationObj.approvedBudgetDate().getText());
		System.out.println("Apprpved Budget code :" + testData.get("budgetCode"));
		System.out.println("Approved Budget Type :" + testData.get("budgetType"));
		System.out.println("Approved budget Transaction Date :" + testData.get("TransactionDate"));
	}

	MASTERREPORT_BudgetCodeReportObj budgetCodeReport = new MASTERREPORT_BudgetCodeReportObj(driver);

	@Then("^click on master report main module$")
	public void click_on_master_report_main_module() throws Throwable {

		budgetCodeReport.masterReportMainMenu().click();
	}

	@Then("^enter budget type in budget code report$")
	public void enter_budget_type_in_budget_code_report() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCodeReport.masterBudgetBudgetType(), 60, 500);
		budgetCodeReport.masterBudgetBudgetType().click();
		budgetCodeReport.masterBudgetBudgetType().sendKeys(testData.get("budgetType"));
		budgetCodeReport.masterBudgetBudgetType().sendKeys(Keys.DOWN);
		budgetCodeReport.masterBudgetBudgetType().sendKeys(Keys.ENTER);
	}

	@And("^click on temp view near by budget code report sub module$")
	public void click_on_temp_view_near_by_budget_code_report_sub_module() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCodeReport.masterBudgetReport(), 60, 500);
		budgetCodeReport.masterBudgetReport().click();
	}

	@And("^give transaction date$")
	public void give_transaction_date() throws Throwable {
		Month months = null;
		String[] splittedDate = testData.get("TransactionDate").split("-");
		String day = splittedDate[0];
		String month = splittedDate[1];
		String year = splittedDate[2];
		switch (month) {
		case "Jan":
			months = months.JANUARY;
			break;
		case "Feb":
			months = months.FEBRUARY;
			break;
		case "Mar":
			months = months.MARCH;
			break;
		case "Apr":
			months = months.APRIL;
			break;
		case "May":
			months = months.MAY;
			break;
		case "Jun":
			months = months.JUNE;
			break;
		case "Jul":
			months = months.JULY;
			break;
		case "Aug":
			months = months.AUGUST;
			break;
		case "Sep":
			months = months.SEPTEMBER;
			break;
		case "Oct":
			months = months.OCTOBER;
			break;
		case "Nov":
			months = months.NOVEMBER;
			break;
		case "Dec":
			months = months.DECEMBER;
			break;

		}
		String stringMonth = months.toString();
		String finalMonth = stringMonth.substring(1).toLowerCase();
		String trmDay = null;
		System.out.println("Final Month is : " + finalMonth);
		stringMonth.substring(0, 1);
		System.out.println("Final Full month:" + stringMonth.substring(0, 1) + finalMonth);
		Thread.sleep(1000);
		int dayNo = Integer.parseInt(day);
		if (dayNo < 10) {
			System.out.println("Inside day if statement");
			trmDay = day.substring(1);

		} else {
			trmDay = day.substring(0);
		}
		System.out.println("Trim Day is " + trmDay);
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCodeReport.masterBudgetInputCalendar(), 90, 500);
		budgetCodeReport.masterBudgetInputCalendar().click();
		System.out.println(month + " " + year);
		driver.findElement(By.xpath("//owl-date-time-calendar/div/div/button")).click();
		driver.findElement(By.xpath("//td//span[contains(text(),'" + year + "')]")).click();
		driver.findElement(By.xpath("//td//span[contains(text(),'" + month + "')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//td[@aria-label='" + stringMonth.substring(0, 1) + finalMonth + " " + trmDay
				+ ", " + year + "']/span")).click();

	}

	@Then("^click on view button in budget code report$")
	public void click_on_view_button_in_budget_code_report() throws Throwable {
		waitHelper.waitForElementToVisibleWithFluentWait(driver, budgetCodeReport.masterBudgetBudgetCodeViewButton(),
				60, 500);
		budgetCodeReport.masterBudgetBudgetCodeViewButton().click();
	}

	@Then("^verify approved budget code is appeared under in master report$")
	public void verify_approved_budget_code_is_appeared_under_in_master_report() throws Throwable {

		browserHelper.SwitchToWindow(1);
		// waitHelper.setPageLoadTimeout(60, TimeUnit.SECONDS);
		boolean budgetCodeStatus = false;
		for (int i = 0; i <= 150; i++) {
			try {
				waitHelper.waitForElementToVisibleWithFluentWait(driver,
						driver.findElement(By.xpath("//td/div[contains(text(),'" + testData.get("budgetCode") + "')]")),
						150, 500);
				budgetCodeStatus = driver
						.findElement(By.xpath("//td/div[contains(text(),'" + testData.get("budgetCode") + "')]"))
						.isDisplayed();
			} catch (Exception e) {
				if (i == 150) {

					Assert.fail(e.getMessage());
				}
			}
		}
		if (budgetCodeStatus == true) {
			System.out.println(testData.get("budgetCode") + " is visible in budget code report");

			browserHelper.switchToParentWithChildClose();
		} else {

			Assert.fail(testData.get("budgetCode") + "Budget Code not visisble in report");
			browserHelper.switchToParentWithChildClose();
		}

	}
}
